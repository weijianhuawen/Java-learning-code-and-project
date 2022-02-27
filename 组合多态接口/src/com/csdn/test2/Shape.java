package com.csdn.test2;

public interface Shape {
    public void draw();
    default public void print() {
        System.out.println("我非要实现接口中的方法！");//default后面的public可以不加
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}
class Rhombus implements Shape {
    @Override
    public void draw() {
        System.out.println("◇");
    }
}
class Flower implements Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Star implements Shape {
    @Override
    public void draw() {
        System.out.println("☆");
    }
}
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("□");
    }
}
