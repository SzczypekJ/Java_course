package com.solvd.mavenproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    // Inicjalizacja loggera
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Application just started");

        try {
            int result = divide(10, 2);
            logger.debug("Result of dividing: {}", result);
        } catch (ArithmeticException e) {
            logger.error("Error during dividing", e);
        }
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("You can't divide by zero");
        }
        return a / b;
    }
}
