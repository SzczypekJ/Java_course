package com.solvd.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static jakarta.xml.bind.JAXB.marshal;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date   = simpleDateFormat.parse("22-1-2024");

        Date date1 = new Date();
        String abc = simpleDateFormat.format(date1);


        Students students = unmarshal();
        System.out.println(students);
        marshal();
    }

    public static Students unmarshal() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Students.class);
        return (Students) context.createUnmarshaller()
                .unmarshal(new FileReader("students.xml"));
    }

    public static void marshal() throws JAXBException, IOException {
        Student ivan = new Student("Ivan", 30, 3, new Car("Renault", 2015), new Animal("Cat", "Miauuu"), new Date());
        Student anna = new Student("Anna", 20, 4, new Car("Mazda", 2024), new Animal("Dog", "Woff"), new Date());
        Students students = new Students();
        List<Student> list = new ArrayList<>();
        list.add(ivan);
        list.add(anna);
        students.setList(list);

        JAXBContext context = JAXBContext.newInstance(Students.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(students, new File("students1.xml"));
    }
}
