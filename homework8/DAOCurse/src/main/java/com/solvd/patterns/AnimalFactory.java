package com.solvd.patterns;

public class AnimalFactory extends AbstractFactory {

    @Override
    public Animal getAnimal(String animalType) {
        if (animalType.equalsIgnoreCase("cat")) {
            return new Cat();
        } else if (animalType.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (animalType.equalsIgnoreCase("fish")) {
            return new Fish();
        } else {
            return null;
        }
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
