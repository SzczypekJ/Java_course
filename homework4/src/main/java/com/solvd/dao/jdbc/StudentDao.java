package com.solvd.dao.jdbc;

import com.solvd.dao.IStudentDao;
import com.solvd.model.Student;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import com.solvd.BasicConnectionPool;

public class StudentDao implements IStudentDao {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Student getEntityById(int index) {
        Student student = new Student();
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();

            String query = "SELECT * FROM students where studentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
            }

        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return student;
    }

    @Override
    public List<Student> getEntities() {
        ;
        Connection connection = null;
        List<Student> students = new ArrayList<>();

        try {
            connection = connectionPool.getConnection();

            String query = "SELECT * FROM students";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return students;
    }

    @Override
    public void insert(Student student) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();

            String query = "INSERT INTO students (firstName, lastName, email, phone) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.execute();
            System.out.println("You successfully added new student to database");

        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int index) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            String query = "DELETE FROM students WHERE studentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            preparedStatement.execute();
            System.out.println("You successfully deleted student from database");

        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int index, Student student) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();

            String query = "UPDATE students SET firstName = ?, lastName = ?, email = ?, phone = ? WHERE studentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setInt(5, index);
            preparedStatement.execute();
            System.out.println("You successfully updated student from database");

        } catch (SQLException e) {
            System.out.println("ERROR");

            connectionPool.releaseConnection(connection);
        }
    }
}