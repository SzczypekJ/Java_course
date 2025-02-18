package com.solvd.patterns;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String city;
    private String address;
}
