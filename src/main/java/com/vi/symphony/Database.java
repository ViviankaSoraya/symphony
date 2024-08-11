package com.vi.symphony;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    static String url = "jdbc:postgresql://localhost:5432/symphony";
    static String username = "vivi";
    static String password = "vivianka";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
