package com.csdn.test;

import java.util.concurrent.Callable;

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
class Bird extends Animal {

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
class Cat extends Animal {
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
public class Instancesof {
    public static void main3(String[] args) {
        Animal animal = new Cat("小猫", 1);
        if (animal instanceof Bird) {
            Bird bird = (Bird) animal;
            bird.eat();
        }
        if (animal instanceof Cat) {
          Cat cat = (Cat)animal;
          cat.eat();
        }
    }
    public static void main(String[] args) {
        Animal animal = new Cat("小猫", 1);
        Bird bird = (Bird) animal;
        bird.eat();
    }
    public static void main1(String[] args) {
        Animal animal = new Cat("小猫", 1);
        Cat cat = (Cat)animal;
        cat.eat();
    }
}
