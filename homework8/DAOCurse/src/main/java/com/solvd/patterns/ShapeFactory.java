package com.solvd.patterns;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Animal getAnimal(String animalType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else {
            return null;
        }
    }
}
