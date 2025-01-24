package com.solvd.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int librariesId;
    private int schoolId;


}
