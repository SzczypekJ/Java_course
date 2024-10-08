package com.solvd.model;

public class Car {
    private String model;
    private int year;
    private int studentId;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Car() {
    }

    public Car(String model, int year, int studentId) {
        this.model = model;
        this.year = year;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", studentId=" + studentId +
                '}';
    }
}
