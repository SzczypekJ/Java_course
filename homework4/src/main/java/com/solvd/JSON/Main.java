package com.solvd.JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        mapper.setDateFormat(df);

        // Write to json file
        List<Student> students = List.of(
                new Student("John", 30, new Date(), new Car("Opel", 2020), new Animal("cat", "mrauu"), new Computer("Lenovo", 2010), new Phone("Apple", 2024)),
                new Student("Wiktoria", 20, new Date(), new Car("Audi", 2015), new Animal("Crocodile", "Puszek"), new Computer("Macbook", 2019), new Phone("Xaiomi", 2021)));

        mapper.writeValue(new File("students1.json"), students);

        // Reading from json file
        List<Student> studentsFromJson = mapper.readValue(new File("students.json"), new TypeReference<List<Student>>(){});
        System.out.println(studentsFromJson);
    }
}
