package com.solvd.dao.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.dao.ISchoolDAO;
import com.solvd.model.School;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO implements ISchoolDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public School getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "select * from mydb.schools where id = ?";
        School school = new School();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                school.setName(resultSet.getString("name"));
                school.setLocation(resultSet.getString("location"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return school;
    }

    @Override
    public List<School> getEntities() {
        List<School> listOdSchools = new ArrayList<>();

        Connection connection = connectionPool.getConnection();
        String sql = "select * from mydb.schools";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                School school = new School();
                school.setName(resultSet.getString("name"));
                school.setLocation(resultSet.getString("location"));
                listOdSchools.add(school);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return listOdSchools;
    }

    @Override
    public void insert(School school) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.schools (name, location) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, school.getName());
            preparedStatement.setString(2, school.getLocation());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, School school) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.schools SET name = ?, location = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, school.getName());
            preparedStatement.setString(2, school.getLocation());
            preparedStatement.setInt(3, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void delete(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "DELETE FROM mydb.schools WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
