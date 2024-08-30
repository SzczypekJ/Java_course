package com.solvd.mavenproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testDivideWithValidInput() {
        int result = App.divide(10, 2);
        assertEquals(5, result, "Dividing 10 by 2 should return 5");
    }

    @Test
    public void testDivideWithZeroDenominator() {
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
            App.divide(10, 0);
        }, "Dividing by zero should throw an ArithmeticException");

        assertEquals("You can't divide by zero", thrown.getMessage());
    }

    @Test
    public void testDivideWithNegativeNumbers() {
        int result = App.divide(-10, 2);
        assertEquals(-5, result, "Dividing -10 by 2 should return -5");

        result = App.divide(10, -2);
        assertEquals(-5, result, "Dividing 10 by -2 should return -5");
    }

    @Test
    public void testDivideWithNegativeNumbersBoth() {
        int result = App.divide(-10, -2);
        assertEquals(5, result, "Dividing -10 by -2 should return 5");
    }
}
