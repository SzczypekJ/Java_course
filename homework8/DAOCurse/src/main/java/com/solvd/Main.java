package com.solvd;

import com.solvd.dao.IStudentDAO;
import com.solvd.dao.jdbc.LibraryDAO;
import com.solvd.dao.jdbc.SchoolDAO;
import com.solvd.dao.jdbc.StudentDAO;
import com.solvd.model.Library;
import com.solvd.model.School;
import com.solvd.model.Student;
import com.solvd.service.LibraryService;
import com.solvd.service.Service;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    // FOR JDBC !!!!!!
//    public static void main( String[] args )
//    {
////        StudentDAO dao = new StudentDAO();
//////        Student student = dao.getEntityById(1);
//////        System.out.println(student);
////
////        List<Student> allStudents = dao.getEntities();
////        allStudents.forEach(System.out::println);
////
////        Student newStudent = new Student("Michalnew", "Nowak", 27, "new@email.com", 1, 2);
////        dao.insert(newStudent);
////
////        Student newStudent2 = new Student("Jakub", "Szczypek", 26, "new@email.com", 1, 2);
////        dao.update(1, newStudent2);
//
////        dao.delete(4);
//
////        dao.insert(newStudent);
//
////        SchoolDAO dao = new SchoolDAO();
//////        School school = dao.getEntityById(1);
//////        System.out.println(school);
////
////        List<School> allSchools = dao.getEntities();
////        allSchools.forEach(System.out::println);
//
////        School school = new School("New School", "New Location");
////        dao.insert(school);
////
////        School school1 = new School("New School Updated", "New Location Updated");
////        dao.update(3, school1);
//
////        dao.delete(3);
//
//        LibraryDAO dao = new LibraryDAO();
////        Library library = dao.getEntityById(1);
////        System.out.println(library);
//
//        List<Library> allLibraries = dao.getEntities();
//        allLibraries.forEach(System.out::println);
//
////        Library library = new Library("Central Library New", "New Location");
////        dao.insert(library);
////
////        Library library = new Library("Central Library", "Main Street");
////        dao.update(1, library);
//////
////        dao.delete(3);
//    }

    // FOR myBatis !!!!!!
    public static void main(String[] args) {
        IStudentDAO studentDAO = Service.getStudentSelect();

        // Retrieve a student by id
        Student student = studentDAO.getEntityById(1);
        System.out.println("Retrieved student: " + student);

        // Retrieve all students
        List<Student> students = studentDAO.getEntities();
        System.out.println("List of students:");
        students.forEach(System.out::println);

        // Insert a new student record
        Student newStudent = new Student();
        newStudent.setFirstName("Jan");
        newStudent.setLastName("Kowalski");
        newStudent.setAge(22);
        newStudent.setEmail("jan.kowalski@example.com");
        newStudent.setLibrariesId(1);
        newStudent.setSchoolId(1);
        studentDAO.insert(newStudent);
        System.out.println("Added a new student.");

        List<Student> students1 = studentDAO.getEntities();
        System.out.println("List of students:");
        students1.forEach(System.out::println);

        // Update an existing student.
        int updateStudentId = 2;
        newStudent.setEmail("jan.updated@example.com");
        studentDAO.update(updateStudentId, newStudent);
        System.out.println("Updated student with id: " + updateStudentId);


        List<Student> students2 = studentDAO.getEntities();
        System.out.println("List of students:");
        students2.forEach(System.out::println);

        // Delete a student record by id (for example, id = 3)
        int deleteStudentId = 3;
        studentDAO.delete(deleteStudentId);
        System.out.println("Deleted student with id: " + deleteStudentId);

        List<Student> students3 = studentDAO.getEntities();
        System.out.println("List of students:");
        students3.forEach(System.out::println);

        LibraryService libraryService = new LibraryService();

        // Retrieve a library by id
        Library library = libraryService.getLibraryById(1);
        System.out.println("Retrieved library: " + library);

        // Retrieve all libraries
        List<Library> libraries = libraryService.getAllLibraries();
        System.out.println("List of libraries:");
        libraries.forEach(System.out::println);

        // Insert a new library record
        Library newLibrary = new Library();
        newLibrary.setName("New Library");
        newLibrary.setLocation("Main City");
        libraryService.addLibrary(newLibrary);
        System.out.println("Added a new library.");

        // Retrieve all libraries
        List<Library> libraries1 = libraryService.getAllLibraries();
        System.out.println("List of libraries:");
        libraries1.forEach(System.out::println);

        // Update an existing library.
        int updateLibraryId = 2;
        newLibrary.setName("Main Library");
        libraryService.updateLibrary(updateLibraryId, newLibrary);
        System.out.println("Updated library with id: " + updateLibraryId);

        // Retrieve all libraries
        List<Library> libraries2 = libraryService.getAllLibraries();
        System.out.println("List of libraries:");
        libraries2.forEach(System.out::println);

        // Delete a library record by id (for example, id = 3)
        int deleteLibraryId = 3;
        libraryService.deleteLibrary(deleteLibraryId);
        System.out.println("Deleted library with id: " + deleteLibraryId);

        // Retrieve all libraries
        List<Library> libraries3 = libraryService.getAllLibraries();
        System.out.println("List of libraries:");
        libraries3.forEach(System.out::println);
    }
}
