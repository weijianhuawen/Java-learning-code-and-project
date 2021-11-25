package com.csdn.test;

class Animal {
    public String name;
    public int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(name + "在吃饭！");
    }
}
class Dog extends Animal{
    public Dog(String name, int age) {
        super("动物", 1);
        this.name = name;
        this.age = age;
    }
    public void run() {
        System.out.println(name + "正在跑！");
    }
    public void fatherClass() {
        System.out.print(super.name + super.age);
    }
}

class Bird extends Animal{
    public Bird(String name, int age) {
        super("动物", 1);
        this.name = name;
        this.age = age;
    }
    public void fly() {
        System.out.println(name + "正在飞！");
    }
    public void fatherClass() {
        System.out.print(super.name + super.age);
    }
}
public class Test1 {
    public static void main(String[] args) {
        Dog dog = new Dog("小狗", 18);
        Bird bird = new Bird("小鸟", 19);
        dog.fatherClass();
        bird.fatherClass();
    }
}