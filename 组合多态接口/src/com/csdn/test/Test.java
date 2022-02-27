package com.csdn.test;

public class Test {
    public static void main(String[] args) {
        Flower flower = new Flower();
        Square square = new Square();
        Star star = new Star();
        Rhombus rhombus = new Rhombus();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        Shape[] shapes = {flower, square, star, rhombus, circle, triangle};
        for (Shape shape :shapes) {
            shape.draw();
        }
    }
}
