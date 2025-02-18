package com.solvd.patterns;

public class FacotryGenerator {

    public static AbstractFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (factoryType.equalsIgnoreCase("animal")) {
            return new AnimalFactory();
        } else {
            return null;
        }
    }
}
