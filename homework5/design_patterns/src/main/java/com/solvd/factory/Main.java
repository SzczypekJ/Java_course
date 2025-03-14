package com.solvd.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("Circle");
        shape1.drawShape();

        Shape shape2 = shapeFactory.getShape("Rectangle");
        shape2.drawShape();

        Shape shape3 = shapeFactory.getShape("Square");
        shape3.drawShape();
    }
}
