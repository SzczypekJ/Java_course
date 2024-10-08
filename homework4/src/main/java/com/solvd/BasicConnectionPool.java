package com.solvd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BasicConnectionPool {

    private static String url;
    private static String user;
    private static String password;
    private static List<Connection> connectionPool = new ArrayList<>();
    private static List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 5;

    public static BasicConnectionPool create() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

        user = resourceBundle.getString("user");
        password = resourceBundle.getString("password");
        url = resourceBundle.getString("url");
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(createConnection(url, user, password));
        }
        return new BasicConnectionPool();
    }

    private BasicConnectionPool() {
    }

    public Connection getConnection() {
        if (connectionPool.isEmpty()) {

            synchronized (connectionPool) {
                try {
                    connectionPool.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        synchronized (connectionPool) {
            connectionPool.notifyAll();
        }
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    // standard getters

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        BasicConnectionPool.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        BasicConnectionPool.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        BasicConnectionPool.password = password;
    }

    public static List<Connection> getConnectionPool() {
        return connectionPool;
    }

    public static void setConnectionPool(List<Connection> connectionPool) {
        BasicConnectionPool.connectionPool = connectionPool;
    }

    public static List<Connection> getUsedConnections() {
        return usedConnections;
    }

    public static void setUsedConnections(List<Connection> usedConnections) {
        BasicConnectionPool.usedConnections = usedConnections;
    }

    public static int getInitialPoolSize() {
        return INITIAL_POOL_SIZE;
    }

    public static void setInitialPoolSize(int initialPoolSize) {
        INITIAL_POOL_SIZE = initialPoolSize;
    }
}