package com.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            int result = calc.calculate(10, 5, "add-again");
            logger.log(Level.INFO, "Result: {0}", result);
            
            UserService service = new UserService();
            service.findUser("admin");
            service.deleteUser("admin");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Application Error", e);
        }
    }
}