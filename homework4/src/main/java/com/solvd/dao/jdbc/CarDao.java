package com.solvd.dao.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.dao.ICarDao;
import com.solvd.dao.IStudentDao;
import com.solvd.model.Car;
import com.solvd.model.Student;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CarDao implements ICarDao {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Car getEntityById(int index) {
        Car car = new Car();

        Connection connection = null;

        try {
            connection = connectionPool.getConnection();

            String query = "SELECT * FROM cars WHERE carId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                car.setStudentId(resultSet.getInt("studentId"));
            }

        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return car;
    }

    @Override
    public List<Car> getEntities() {

        Connection connection = null;
        List<Car> cars = new ArrayList<>();

        try {
            connection = connectionPool.getConnection();

            String query = "SELECT * FROM cars";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                car.setStudentId(resultSet.getInt("studentId"));
                cars.add(car);
            }

        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return cars;
    }

    @Override
    public void insert(Car car) {

        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            String query = "INSERT INTO cars(model, year, studentId) VALUES(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getYear());
            preparedStatement.setInt(3, car.getStudentId());
            preparedStatement.execute();
            System.out.println("You successfully added new car to database");

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
            String query = "DELETE FROM cars WHERE carId = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            preparedStatement.execute();
            System.out.println("You successfully deleted the car from database");


        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int index, Car car) {

        Connection connection = null;

        try {
            connection = connectionPool.getConnection();

            String query = "UPDATE cars SET model = ?, year = ?, studentId = ? WHERE carId = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getYear());
            preparedStatement.setInt(3, car.getStudentId());
            preparedStatement.setInt(4, index);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Successfully updated car with ID " + index);
            } else {
                System.out.println("No car found with ID " + index);
            }

        } catch (SQLException e) {
            System.out.println("ERROR");

        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

}
