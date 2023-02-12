package com.messages.app.crud.dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_messages", "root", "2845796sena");
        } catch (SQLException e) {
            System.out.println("Exception " + e);
        }

        return connection;
    }
}
