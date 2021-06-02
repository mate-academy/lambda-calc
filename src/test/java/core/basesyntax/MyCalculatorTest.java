package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {
    Calculator calculator = new MyCalculator();

    @Test
    void additionTwoPositive_Ok() {
        double a = 2.67;
        double b = 3.445;
        double expected = a + b;
        assertEquals(calculator.calculate(a, b, '+'), expected);
    }

    @Test
    void additionNegativePositive_Ok() {
        double a = -2.67;
        double b = -3.445;
        double expected = a + b;
        assertEquals(calculator.calculate(a, b, '+'), expected);
    }

    @Test
    void additionNegativeAndPositive_Ok() {
        double a = 2.67;
        double b = -3.445;
        double expected = a + b;
        assertEquals(calculator.calculate(a, b, '+'), expected);
    }

    @Test
    void additionZeroAndPositive_Ok() {
        double a = 0;
        double b = 3.445;
        double expected = a + b;
        assertEquals(calculator.calculate(a, b, '+'), expected);
    }

    @Test
    void additionNegativeAndZero_Ok() {
        double a = -2.67;
        double b = 0;
        double expected = a + b;
        assertEquals(calculator.calculate(a, b, '+'), expected);
    }

    @Test
    void additionDouble_MaxAndDouble_Max_Ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        double expected = a + b;
        assertEquals(calculator.calculate(a, b, '+'), expected);
    }
    @Test
    void additionDouble_MinAndDouble_Min_Ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        double expected = a + b;
        assertEquals(calculator.calculate(a, b, '+'), expected);
    }
}