package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private String password = "admin123";

    public void findUser(String username) throws SQLException {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.executeQuery();
        } 
    }

    public void deleteUser(String username) throws SQLException {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.execute();
        }
    }

}