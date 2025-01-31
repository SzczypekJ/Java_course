package com.solvd.jaxb;

//import jakarta.xml.bind.annotation.XmlAttribute;
//import jakarta.xml.bind.annotation.XmlElement;
//import jakarta.xml.bind.annotation.XmlType;
//import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
//
//import java.util.Date;

import java.util.Date;

//@XmlType(propOrder = { "id", "name", "age", "car", "animal", "date" })
@XmlType
public class Student {

    private String name;
    private int age;
    private int id;
    private Car car;
    private Animal animal;
    private Date date;

    public Student() {
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    @XmlElement
    public void setCar(Car car) {
        this.car = car;
    }

    public Animal getAnimal() {
        return animal;
    }

    @XmlElement
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement
    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", car=" + car +
                ", animal=" + animal +
                ", date=" + date +
                '}';
    }

    public Student(String name, int age, int id, Car car, Animal animal, Date date) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.car = car;
        this.animal = animal;
        this.date = date;
    }
}
