package com;
class Animal {
    public String name;
    public int age;
    public Animal(String name, int age) {
        this.age = age;
        this.name = name;
    }
    public void eat() {
        System.out.println(name + "在吃饭！");
    }
}
class Dog extends Animal {
    public String name;
    public int age;
    public Dog(String name, int age) {
        super("动物", 1);
        this.name = name;
        this.age = age;
    }
    public void run() {
        System.out.println(name + "正在跑！");
    }
    public void fatherClass() {
        System.out.println(super.name + super.age);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Dog dog = new Dog("小狗", 18);
        dog.fatherClass();
    }
}
