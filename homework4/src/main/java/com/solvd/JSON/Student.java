package com.solvd.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder({ "name", "age", "date", "car", "animal", "computer", "phone" })
public class Student {

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;

    @JsonProperty("car")
    private Car car;

    @JsonProperty("animal")
    private Animal animal;

    @JsonProperty("computer")
    private Computer computer;

    @JsonProperty("phone")
    private Phone phone;

    public Student(String name, int age, Date date, Car car, Animal animal, Computer computer, Phone phone) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.car = car;
        this.animal = animal;
        this.computer = computer;
        this.phone = phone;
    }

    public Student() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", car=" + car +
                ", animal=" + animal +
                ", computer=" + computer +
                ", phone=" + phone +
                '}';
    }
}
