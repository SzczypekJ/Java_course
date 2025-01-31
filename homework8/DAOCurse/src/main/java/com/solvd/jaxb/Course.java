package com.solvd.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "code", "numberOfPeople"})
public class Course {

    private String name;
    private String code;
    private int numberOfPeople;

    public Course(String name, String code, int numberOfPeople) {
        this.name = name;
        this.code = code;
        this.numberOfPeople = numberOfPeople;
    }

    public Course() {}

    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name = "Numberofpeople")
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }
}
