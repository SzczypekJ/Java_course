package com.solvd.jackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Read JSON
//        try {
//            Root root = objectMapper.readValue(new File("src/main/resources/mappers/university.json"), Root.class);
//            for (Student student : root.getUniversity().getStudents()) {
//                System.out.println(student);
//                //                System.out.println("Purchase Date: " + student.getCar().getPurchaseDate());
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        // Write JSON
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            Car car1 = new Car("Honda", "Civic", 2019, sdf.parse("15-03-2020"));
            Car car2 = new Car("BMW", "X5", 2021, sdf.parse("20-08-2021"));

            Course course1 = new Course("Data Structures", "DS101", 40);
            Course course2 = new Course("Algorithms", "ALG102", 35);
            List<Course> courseList1 = Arrays.asList(course1, course2);
            Courses courses1 = new Courses(courseList1);

            Course course3 = new Course("Operating Systems", "OS201", 60);
            Course course4 = new Course("Computer Networks", "CN202", 55);
            List<Course> courseList2 = Arrays.asList(course3, course4);
            Courses courses2 = new Courses(courseList2);

            Student student1 = new Student(101L, "Alice", 21, courses1, car1);
            Student student2 = new Student(102L, "Bob", 25, courses2, car2);
            List<Student> studentList = Arrays.asList(student1, student2);

            University university = new University(studentList);
            Root root = new Root(university);


            objectMapper.writeValue(new File("src/main/resources/mappers/university2.json"), root);

        } catch (ParseException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
