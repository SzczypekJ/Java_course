package com.solvd.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "students")
//@XmlType(propOrder = { "list" })
public class Students {
    private List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public Students() {
    }

    @XmlElement(name = "student")
    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Students{" +
                "list=" + list +
                '}';
    }
}
