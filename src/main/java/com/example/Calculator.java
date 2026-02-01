package com.example;

import java.util.logging.Logger;

public class Calculator {

    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    public int calculate(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        // FIX: Merged cases using comma-separated labels
        return switch (op) {
            case "add", "add-again" -> a + b;
            case "sub", "sub-again" -> a - b;
            case "mul" -> a * b;
            case "div" -> {
                if (b == 0) {
                    logger.warning("Division by zero attempted. Returning 0.");
                    yield 0;
                }
                yield a / b;
            }
            case "mod" -> a % b;
            case "pow" -> (int) Math.pow(a, b);
            default -> {
                logger.log(java.util.logging.Level.INFO, "Unknown operation: {0}", op);
                yield 0;
            }
        };
    }
}