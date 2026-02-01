package com.example;

import java.util.logging.Logger;

public class Calculator {

    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    public int calculate(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        switch (op) {
            case "add":
            case "add-again":
                return a + b;

            case "sub":
            case "sub-again":
                return a - b;

            case "mul":
                return a * b;

            case "div":
                if (b == 0) {
                    logger.warning("Division by zero attempted. Returning 0.");
                    return 0;
                }
                return a / b;

            case "mod":
                return a % b;

            case "pow":
                return (int) Math.pow(a, b);

            default:
                logger.log(java.util.logging.Level.INFO, "Unknown operation: {0}", op);
                return 0;
        }
    }


}