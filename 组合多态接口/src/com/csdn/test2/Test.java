package com.csdn.test2;

public class Test {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        Flower flower = new Flower();
        Square square = new Square();
        Star star = new Star();
        Rhombus rhombus = new Rhombus();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        drawMap(flower);
        drawMap(square);
        drawMap(star);
        drawMap(rhombus);
        drawMap(circle);
        drawMap(triangle);
    }
}
