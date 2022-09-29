package com.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:mysql://0.0.0.0";
        final String user = "root";
        final String pass = "********";

        Connection dbConect = DriverManager.getConnection(url, user, pass);
        dbConect.close();
    }
}