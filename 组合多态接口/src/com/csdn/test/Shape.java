package com.csdn.test;

abstract public class Shape {
    abstract public void draw();
}

class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("△");
    }
}
class Rhombus extends Shape{
    @Override
    public void draw() {
        System.out.println("◇");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Star extends Shape{
    @Override
    public void draw() {
        System.out.println("☆");
    }
}
class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("□");
    }
}