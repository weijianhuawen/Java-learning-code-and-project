package com.csdn.test2;

public class Animal {
    public String name;
    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name + "正在吃饭");
    }
}
interface IRun{
    void running();
}
interface ISwim{
    void swimming();
}
interface IFly{
    void flying();
}
interface ISkip{
    void skipping();
}
class Frog extends Animal implements ISkip, ISwim{
    public Frog(String name) {
        super(name);
    }
    @Override
    public void swimming() {
        System.out.println(name + "擅长蛙泳！");
    }
    @Override
    public void skipping() {
        System.out.println(name + "要跳起来！");
    }
}
class Bird extends Animal implements IFly{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void flying() {
        System.out.println(name + "正在自由飞翔！");
    }
}

class Cat extends Animal implements IRun,ISkip{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void running() {
        System.out.println(name + "的狂奔！");
    }

    @Override
    public void skipping() {
        System.out.println(name + "也会跳！");
    }
}
class Duck extends Animal implements ISwim, IRun{
    public Duck(String name) {
        super(name);
    }

    @Override
    public void running() {
        System.out.println(name + "也会努力奔跑的！");
    }

    @Override
    public void swimming() {
        System.out.println(name + "也会游泳！");
    }
}