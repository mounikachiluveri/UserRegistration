package com.bridgelabs.repositery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserRepo {
    public final static String DB_URL = "jdbc:mysql://localhost:3306/world";
    public final static String DB_USERNAME = "root";
    public final static String DB_PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}