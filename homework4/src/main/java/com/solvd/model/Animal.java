package com.solvd.model;

public class Animal {
    private String animalType;
    private String name;
    private int age;
    private int studentId;

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Animal(String animalType, String name, int age, int studentId) {
        this.animalType = animalType;
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "animalType='" + animalType + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", studentId=" + studentId +
                '}';
    }
}
