package com.solvd.patterns;

public abstract class AbstractFactory {
    public abstract Animal getAnimal(String animalType);
    public abstract Shape getShape(String shapeType);
}
