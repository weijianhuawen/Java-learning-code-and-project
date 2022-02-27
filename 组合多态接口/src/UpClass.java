class Animal1 {
    public String name;
    public int age;
    public Animal1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(this.name + "正在吃饭！");
    }
}
class Bird1 extends Animal1{

    public Bird1(String name, int age) {
        super(name, age);
    }
    public void fly() {
        System.out.println(this.name + "正在飞翔！");
    }
}

public class UpClass {
    public static void func1(Animal1 an) {
        an.eat();
    }
    public static Animal1 func2() {
        return new Bird1("小鸟", 2);
    }
    public static void main(String[] args) {
        Animal1 animal1 = new Bird1("小鸟", 2);
        animal1.eat();
        func1(new Bird1("小鸟", 2));
        Animal1 animal2 = func2();
        animal2.eat();
    }
}


