package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {
    private static MyCalculator calculator;

    @BeforeAll
    static void init() {
        calculator = new MyCalculator();
    }

    @Test
    void additionTwoPositive_Ok() {
        double a = 2.67;
        double b = 3.445;
        double expected = a + b;
        char add = '+';
        assertEquals(calculator.calculate(a, b, add), expected);
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

    @Test
    void subtractionTwoPositive_Ok() {
        double a = 2.67;
        double b = 3.445;
        double expected = a - b;
        assertEquals(calculator.calculate(a, b, '-'), expected);
    }

    @Test
    void subtractionNegativePositive_Ok() {
        double a = -2.67;
        double b = -3.445;
        double expected = a - b;
        assertEquals(calculator.calculate(a, b, '-'), expected);
    }

    @Test
    void subtractionNegativeAndPositive_Ok() {
        double a = 2.67;
        double b = -3.445;
        double expected = a - b;
        assertEquals(calculator.calculate(a, b, '-'), expected);
    }

    @Test
    void subtractionZeroAndPositive_Ok() {
        double a = 0;
        double b = 3.445;
        double expected = a - b;
        assertEquals(calculator.calculate(a, b, '-'), expected);
    }

    @Test
    void subtractionNegativeAndZero_Ok() {
        double a = -2.67;
        double b = 0;
        double expected = a - b;
        assertEquals(calculator.calculate(a, b, '-'), expected);
    }

    @Test
    void subtractionDouble_MaxAndDouble_Max_Ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        double expected = a - b;
        assertEquals(calculator.calculate(a, b, '-'), expected);
    }

    @Test
    void subtractionDouble_MinAndDouble_Min_Ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        double expected = a - b;
        assertEquals(calculator.calculate(a, b, '-'), expected);
    }

    @Test
    void multiplicationTwoPositive_Ok() {
        double a = 2.67;
        double b = 3.445;
        double expected = a * b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void multiplicationNegativePositive_Ok() {
        double a = -2.67;
        double b = -3.445;
        double expected = a * b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void multiplicationNegativeAndPositive_Ok() {
        double a = 2.67;
        double b = -3.445;
        double expected = a * b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void multiplicationZeroAndPositive_Ok() {
        double a = 0;
        double b = 3.445;
        double expected = a * b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void multiplicationNegativeAndZero_Ok() {
        double a = -2.67;
        double b = 0;
        double expected = a * b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void multiplicationDouble_MaxAndDouble_Max_Ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        double expected = a * b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void multiplicationDouble_MinAndDouble_Min_Ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        double expected = a * b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void divideTwoPositive_Ok() {
        double a = 2.67;
        double b = 3.445;
        double expected = a / b;
        assertEquals(calculator.calculate(a, b, '/'), expected);
    }

    @Test
    void divideNegativePositive_Ok() {
        double a = -2.67;
        double b = -3.445;
        double expected = a / b;
        assertEquals(calculator.calculate(a, b, '/'), expected);
    }

    @Test
    void divideNegativeAndPositive_Ok() {
        double a = 2.67;
        double b = -3.445;
        double expected = a / b;
        assertEquals(calculator.calculate(a, b, '/'), expected);
    }

    @Test
    void divideZeroAndPositive_Ok() {
        double a = 0;
        double b = 3.445;
        double expected = a / b;
        assertEquals(calculator.calculate(a, b, '*'), expected);
    }

    @Test
    void divideByZero_NotOk() {
        double a = -2.67;
        double b = 0;
        assertThrows(ArithmeticException.class, () -> calculator.calculate(a, b, '/'));
    }

    @Test
    void divideDouble_MaxAndDoubleMax_Ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        double expected = a / b;
        assertEquals(calculator.calculate(a, b, '/'), expected);
    }

    @Test
    void divideDouble_MinAndDoubleMin_Ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        double expected = a / b;
        assertEquals(calculator.calculate(a, b, '/'), expected);
    }

    @Test
    void powTwoPositive_Ok() {
        double a = 2.67;
        double b = 3.445;
        double expected = Math.pow(a, b);
        assertEquals(calculator.calculate(a, b, '^'), expected);
    }

    @Test
    void powNegativePositive_Ok() {
        double a = -2.67;
        double b = -3.445;
        double expected = Math.pow(a, b);
        assertEquals(calculator.calculate(a, b, '^'), expected);
    }

    @Test
    void powNegativeAndPositive_Ok() {
        double a = 2.67;
        double b = -3.445;
        double expected = Math.pow(a, b);
        assertEquals(calculator.calculate(a, b, '^'), expected);
    }

    @Test
    void powZeroAndPositive_Ok() {
        double a = 0;
        double b = 3.445;
        double expected = Math.pow(a, b);
        assertEquals(calculator.calculate(a, b, '^'), expected);
    }

    @Test
    void powNegativeAndZero_Ok() {
        double a = -2.67;
        double b = 0;
        double expected = Math.pow(a, b);
        assertEquals(calculator.calculate(a, b, '^'), expected);
    }

    @Test
    void powDouble_MaxAndDouble_Max_Ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        double expected = Math.pow(a, b);
        assertEquals(calculator.calculate(a, b, '^'), expected);
    }

    @Test
    void powDouble_MinAndDouble_Min_Ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        double expected = Math.pow(a, b);
        assertEquals(calculator.calculate(a, b, '^'), expected);
    }

    @Test
    void wrongOperator_NotOk() {
        double a = 23f;
        double b = 56;
        char wrongOperator = '$';
        assertThrows(RuntimeException.class, () -> calculator.calculate(a, b, wrongOperator));
    }

    @Test
    void nullParameters_NotOk() {
        Double a = null;
        Float b = null;
        char wrongOperator = '$';
        assertThrows(NullPointerException.class, () -> calculator.calculate(a, b, wrongOperator));
    }
}
