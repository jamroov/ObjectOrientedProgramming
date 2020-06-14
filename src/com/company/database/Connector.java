package com.company.database;

import java.sql.*;
import java.util.Properties;

public class Connector {
    static final String DB_URL = "jdbc:postgresql://localhost:5433/ObjectOriented";
    static final String USER = "postgres";
    static final String PASS = "mati12346";
    static private Connection CONNECTION;

    public static void connect() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASS);
        CONNECTION = DriverManager.getConnection(DB_URL, props);
        System.out.println("Connected");
    }

    public static Statement getStatement() throws SQLException {
        return CONNECTION.createStatement();
    }

    public static void executeSQL(String sql) throws SQLException {
        CONNECTION.createStatement().execute(sql);
    }
}
