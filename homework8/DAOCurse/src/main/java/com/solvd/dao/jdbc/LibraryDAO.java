package com.solvd.dao.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.dao.ILibraryDAO;
import com.solvd.model.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO implements ILibraryDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Library getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.libraries WHERE id = ?";
        Library library = new Library();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                library.setName(rs.getString("name"));
                library.setLocation(rs.getString("location"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return library;
    }

    @Override
    public List<Library> getEntities() {
        List<Library> libraries = new ArrayList<>();

        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.libraries";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Library library = new Library();
                library.setName(rs.getString("name"));
                library.setLocation(rs.getString("location"));
                libraries.add(library);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return libraries;
    }

    @Override
    public void insert(Library library) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.libraries (name, location) VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, library.getName());
            ps.setString(2, library.getLocation());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Library library) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.libraries SET name = ?, location = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, library.getName());
            ps.setString(2, library.getLocation());
            ps.setInt(3, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "DELETE FROM mydb.libraries WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
