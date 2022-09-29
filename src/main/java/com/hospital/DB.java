package com.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public Connection banco() throws SQLException {
        final String url = "jdbc:mysql://50.17.72.170/Hospital";
        final String user = "root";
        final String pass = "o&89LdE03NWQ";

        Connection dbConect = DriverManager.getConnection(url, user, pass);
        return dbConect;
    }
}