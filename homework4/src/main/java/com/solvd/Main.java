package com.solvd;

import com.solvd.dao.ICarDao;
import com.solvd.dao.IStudentDao;
import com.solvd.dao.jdbc.CarDao;
import com.solvd.dao.jdbc.StudentDao;
import com.solvd.model.Car;
import com.solvd.model.Student;

public class Main {
    public static void main(String[] args) {
        IStudentDao studentDao = new StudentDao();
        // Getting the student by id
//        System.out.println(studentDao.getEntityById(1));

//        Getting all students in the table:
//        System.out.println(studentDao.getEntities());

//        Inserting student in the table:
//        Student student = new Student();
//        student.setFirstName("Jakub2");
//        student.setLastName("Szczypek2");
//        student.setEmail("jakub.szczypek2@example.com");
//        student.setPhone("600000001");
//        studentDao.insert(student);

//        Deleting student from teh table:
//        studentDao.delete(5);

//        Updating existing student:
//        Student student = new Student();
//        student.setFirstName("JohnUpdated");
//        student.setLastName("SmithUpdated");
//        student.setEmail("john.smithupdated@gmail.com");
//        student.setPhone("newPhone");
//        studentDao.update(1, student);

        ICarDao cardDao = new CarDao();

//        Getting car by ID:
//        System.out.println(cardDao.getEntityById(1));

        // Getting all cars in the table:
//        System.out.println(cardDao.getEntities());

        // Inserting new car to the table:
//        Car car = new Car();
//        car.setStudentId(2);
//        car.setYear(2024);
//        car.setModel("BMW1");
//        cardDao.insert(car);

//        Deleting the car from database:
//        cardDao.delete(4);

//        Updating the car in database:
//        Car car = new Car();
//        car.setModel("NewModel");
//        car.setYear(2023);
//        car.setStudentId(1);
//        cardDao.update(3, car);

    }
}
