package com.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:mysql://50.17.72.170";
        final String user = "root";
        final String pass = "o&89LdE03NWQ";

        Connection dbConect = DriverManager.getConnection(url, user, pass);
        dbConect.close();
    }
}
