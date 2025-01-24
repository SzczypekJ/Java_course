package com.solvd.dao.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.dao.IStudentDAO;
import com.solvd.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Student getEntityById(int id)  {
        Student student = new Student();
        String sql = "SELECT * FROM mydb.students WHERE id = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));
                student.setLibrariesId(resultSet.getInt("libraries_id"));
                student.setSchoolId(resultSet.getInt("schools_id"));
            }

        }catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return student;
    }

    @Override
    public List<Student> getEntities() {
        List<Student> listOfStudents = new ArrayList<>();
        String sql = "SELECT * FROM mydb.students";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));
                student.setLibrariesId(resultSet.getInt("libraries_id"));
                student.setSchoolId(resultSet.getInt("schools_id"));
                listOfStudents.add(student);
            }

        }catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return listOfStudents;
    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO `mydb`.`students`(first_name, last_name, age, email, libraries_id, schools_id) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getLibrariesId());
            preparedStatement.setInt(6, student.getSchoolId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Student student) {
        String sql = "UPDATE `mydb`.`students` SET `first_name` = ?, `last_name` = ?, `age` = ?, `email` = ?, `libraries_id` = ?, `schools_id` = ? WHERE `id` = ?";

        Connection connection = connectionPool.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getLibrariesId());
            preparedStatement.setInt(6, student.getSchoolId());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM `mydb`.`students` WHERE `id` = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
