package com.solvd.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException, ParseException {

////         Reading the xml using JAXB
//        JAXBContext context = JAXBContext.newInstance(University.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//
//        File file = new File("src/main/resources/mappers/jaxbuniversity.xml");
//        University university = (University) unmarshaller.unmarshal(file);

//         Manually ready the context
//        for (Student student : university.getStudents()) {
//            System.out.println("Student: " + student.getName() + ", Age: " + student.getAge());
//            System.out.println("  Car: " + student.getCar().getProducent() + " " + student.getCar().getModel());
//            System.out.println("  Purchase Date: " + student.getCar().getFormattedPurchaseDate());
//
//            for (Course course : student.getCourses()) {
//                System.out.println("  Course: " + course.getName() + " (" + course.getCode() + "), Students: " + course.getNumberOfPeople());
//            }
//            System.out.println();
//
//        }
//        // Read the context using toString() method
//        for (Student student : university.getStudents()) {
//            System.out.println(student);
//            System.out.println();
//        }
//    }

        // Writing the file using the JAXB
        JAXBContext context = JAXBContext.newInstance(University.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File("src/main/resources/mappers/jaxbuniversity.xml");
        University university = (University) unmarshaller.unmarshal(file);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Student newStudent = new Student();
        newStudent.setId(3);
        newStudent.setName("Anna");
        newStudent.setAge(22);

        Date purchaseDate = dateFormat.parse("15-08-2021");
        Car newCar = new Car("Ford", "Focus", "2020", purchaseDate);
        newStudent.setCar(newCar);

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Machine Learning", "ML01", 40));
        courses.add(new Course("AI Fundamentals", "AI01", 35));
        newStudent.setCourses(courses);


        university.getStudents().add(newStudent);

        saveToXml(university, "src/main/resources/mappers/updated_jaxbuniversity.xml");
    }

    public static void saveToXml(University university, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(University.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        File file = new File(filePath);
        marshaller.marshal(university, file);
        System.out.println("Date is saved in: " + filePath);
    }
}
