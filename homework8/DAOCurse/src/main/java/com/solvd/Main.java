package com.solvd;

import com.solvd.dao.jdbc.LibraryDAO;
import com.solvd.dao.jdbc.SchoolDAO;
import com.solvd.dao.jdbc.StudentDAO;
import com.solvd.model.Library;
import com.solvd.model.School;
import com.solvd.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
//        StudentDAO dao = new StudentDAO();
////        Student student = dao.getEntityById(1);
////        System.out.println(student);
//
//        List<Student> allStudents = dao.getEntities();
//        allStudents.forEach(System.out::println);
//
//        Student newStudent = new Student("Michalnew", "Nowak", 27, "new@email.com", 1, 2);
//        dao.insert(newStudent);
//
//        Student newStudent2 = new Student("Jakub", "Szczypek", 26, "new@email.com", 1, 2);
//        dao.update(1, newStudent2);

//        dao.delete(4);

//        dao.insert(newStudent);

//        SchoolDAO dao = new SchoolDAO();
////        School school = dao.getEntityById(1);
////        System.out.println(school);
//
//        List<School> allSchools = dao.getEntities();
//        allSchools.forEach(System.out::println);

//        School school = new School("New School", "New Location");
//        dao.insert(school);
//
//        School school1 = new School("New School Updated", "New Location Updated");
//        dao.update(3, school1);

//        dao.delete(3);

        LibraryDAO dao = new LibraryDAO();
//        Library library = dao.getEntityById(1);
//        System.out.println(library);

        List<Library> allLibraries = dao.getEntities();
        allLibraries.forEach(System.out::println);

//        Library library = new Library("Central Library New", "New Location");
//        dao.insert(library);
//
//        Library library = new Library("Central Library", "Main Street");
//        dao.update(1, library);
////
//        dao.delete(3);


    }
}
