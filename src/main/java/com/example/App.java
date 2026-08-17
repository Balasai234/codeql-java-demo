package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws Exception {

        String username = args.length > 0 ? args[0] : "admin";

        Connection connection =
                DriverManager.getConnection(
                        "jdbc:h2:mem:testdb",
                        "sa",
                        "");

        Statement statement = connection.createStatement();

        // Intentionally vulnerable code for CodeQL demonstration
        String query =
                "SELECT * FROM users WHERE username = '" + username + "'";

        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            System.out.println(result.getString("username"));
        }

        result.close();
        statement.close();
        connection.close();
    }
}
