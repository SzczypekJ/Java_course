package com.solvd.jackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Student {

    @JsonProperty("ID")
    private Long ID;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("Age")
    private Integer Age;

    @JsonProperty("Courses")
    private Courses Courses;

    @JsonProperty("Car")
    private Car car;

    public Student(Long ID, String name, Integer age, com.solvd.jackson.Courses courses, Car car) {
        this.ID = ID;
        Name = name;
        Age = age;
        Courses = courses;
        this.car = car;
    }

    public Student() {}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public com.solvd.jackson.Courses getCourses() {
        return Courses;
    }

    public void setCourses(com.solvd.jackson.Courses courses) {
        Courses = courses;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Courses=" + Courses +
                ", car=" + car +
                '}';
    }
}
