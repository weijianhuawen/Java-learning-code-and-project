class Animal {
    public String name;
    public int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(this.name + "正在吃饭！");
    }
}
class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }
    public void fly() {
        System.out.println(this.name + "正在飞翔！");
    }

    @Override
    public void eat() {
        System.out.println(this.age + this.name + "正在慢慢地吃饭！");
    }
}
class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }
    public void cute() {
        System.out.println(name + "忙着装可爱！");
    }

    @Override
    public void eat() {
        System.out.println(this.age + this.name + "正在安静地吃饭！");
    }
}
public class OverFunc {
    public static void main(String[] args) {
        Animal animal1 = new Bird("小鸟", 2);
        animal1.eat();
        Animal animal2 = new Cat("小猫", 1);
        animal2.eat();
    }
}

