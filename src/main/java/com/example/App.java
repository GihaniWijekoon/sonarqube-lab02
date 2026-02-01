package com.example;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            
            int result = calc.calculate(10, 5, "add-again");
            logger.log(Level.INFO, "Calculation Result: {0}", result);
            
            UserService service = new UserService();
            
            logger.info("Searching for user 'admin'...");
            service.findUser("admin");
            
            logger.warning("Deleting user 'admin'...");
            service.deleteUser("admin");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database error occurred", e);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Invalid input: {0}", e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred", e);
        }
    }
}