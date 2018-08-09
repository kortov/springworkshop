package com.kortov.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimeZone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        System.out.println("Connecting to database " + jdbcURL);
        try {
            Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection refused!");
            e.printStackTrace();
        }

    }
}
