package com.solvd.day2;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    String name;
    String location;
    String phone;
    List<String> courses;
}
