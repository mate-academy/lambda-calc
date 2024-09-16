package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {
    private static SimpleCalculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new SimpleCalculator();
    }

    @Test
    void additionWithPositives_OK() {
        double a = 10;
        double b = 20;
        double actual = calculator.calculate(a, b, '+');
        double expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithNegatives_OK() {
        double a = -10;
        double b = -20;
        double actual = calculator.calculate(a, b, '+');
        double expected = -30;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithNegativeAndPositive_OK() {
        double a = 10;
        double b = -20;
        double actual = calculator.calculate(a, b, '+');
        double expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZero_OK() {
        double a = 10;
        double b = 0;
        double actualFirstCase = calculator.calculate(a, b, '+');
        double expected = 10;
        assertEquals(expected, actualFirstCase);
        double actualSecondCase = calculator.calculate(b, a, '+');
        assertEquals(expected, actualSecondCase);
    }

    @Test
    void additionWithMinAndMaxValues_OK() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        double actual = calculator.calculate(a, b, '+');
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void substractionWithPositives_OK() {
        double a = 10;
        double b = 20;
        double actual = calculator.calculate(a, b, '-');
        double expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void substractionWithNegatives_OK() {
        double a = -10;
        double b = -20;
        double actual = calculator.calculate(a, b, '-');
        double expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void substractionWithNegativeAndPositive_OK() {
        double a = 10;
        double b = -20;
        double actual = calculator.calculate(a, b, '-');
        double expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    void substractionWithZero_OK() {
        double a = 10;
        double b = 0;
        double actualFirstCase = calculator.calculate(a, b, '-');
        double expectedFirstCase = 10;
        assertEquals(expectedFirstCase, actualFirstCase);
        double expectedSecondCase = -10;
        double actualSecondCase = calculator.calculate(b, a, '-');
        assertEquals(expectedSecondCase, actualSecondCase);
    }

    @Test
    void substractionWithMinAndMaxValues_OK() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        double actual = calculator.calculate(a, b, '-');
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithPositives_OK() {
        double a = 10;
        double b = 20;
        double actual = calculator.calculate(a, b, '*');
        double expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithNegatives_OK() {
        double a = -10;
        double b = -20;
        double actual = calculator.calculate(a, b, '*');
        double expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithNegativeAndPositive_OK() {
        double a = 10;
        double b = -20;
        double actual = calculator.calculate(a, b, '*');
        double expected = -200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZero_OK() {
        double a = 10;
        double b = 0;
        double actualFirstCase = calculator.calculate(a, b, '*');
        double expected = 0;
        assertEquals(expected, actualFirstCase);
        double actualSecondCase = calculator.calculate(b, a, '*');
        assertEquals(expected, actualSecondCase);
    }

    @Test
    void multiplicationWithMinAndMaxValues_OK() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        double actual = calculator.calculate(a, b, '*');
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithPositives_OK() {
        double a = 15;
        double b = 5;
        double actual = calculator.calculate(a, b, '/');
        double expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithNegatives_OK() {
        double a = -15;
        double b = -3;
        double actual = calculator.calculate(a, b, '/');
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithNegativeAndPositive_OK() {
        double a = 10;
        double b = -2;
        double actual = calculator.calculate(a, b, '/');
        double expected = -5;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZero_OK() {
        double a = 0;
        double b = 10;
        double actual = calculator.calculate(a, b, '/');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionByZero_NotOK() {
        double a = 10;
        double b = 0;
        assertThrows(ArithmeticException.class, () -> calculator.calculate(a, b, '/'));
    }

    @Test
    void divisionWithMinAndMaxValues_NotOK() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        assertThrows(ArithmeticException.class, () -> calculator.calculate(a, b, '/'));
    }

    @Test
    void raisingPositiveToPowerPositive_OK() {
        double a = 5;
        double b = 4;
        double actual = calculator.calculate(a, b, '^');
        double expected = 625;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToPowerNegative_OK() {
        double a = 2;
        double b = -3;
        double actual = calculator.calculate(a, b, '^');
        double expected = 0.125;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPowerPositive_OK() {
        double a = -5;
        double b = 3;
        double actual = calculator.calculate(a, b, '^');
        double expected = -125;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPowerNegative_OK() {
        double a = -5;
        double b = -3;
        double actual = calculator.calculate(a, b, '^');
        double expected = -0.008;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToPowerOfZero_OK() {
        double a = 5;
        double b = 0;
        double actual = calculator.calculate(a, b, '^');
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPowerOfZero_OK() {
        double a = -5;
        double b = 0;
        double actual = calculator.calculate(a, b, '^');
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_OK() {
        double a = 0;
        double b = 5;
        double actual = calculator.calculate(a, b, '^');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOK() {
        double a = 20;
        double b = 20;
        char invalidOperand = 'h';
        assertThrows(RuntimeException.class, () -> calculator.calculate(a, b, invalidOperand));
    }
}


