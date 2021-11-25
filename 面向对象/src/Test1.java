
class Dog {
    public String name;
    public int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(name + "在吃饭！");
    }
    public void run() {
        System.out.println(name + "正在跑！");
    }
}

class Bird {
    public String name;
    public int age;
    public Bird(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(name + "正在吃饭！");
    }

    public void fly() {
        System.out.println(name + "正在飞！");
    }
}
public class Test1 {
    public static void main(String[] args) {
        Dog dog = new Dog("小狗", 18);
        dog.run();
        dog.eat();
        Bird bird = new Bird("小鸟", 19);
        bird.fly();
        bird.eat();
    }
}
