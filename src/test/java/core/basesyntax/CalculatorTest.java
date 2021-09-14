package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addictionTwoPositive() {
        double first = 7;
        double second = 14;
        double expected = 21;
        double actual = calculator.calculate(first, second, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionTwoNegative() {
        double first = -38;
        double second = -17;
        double expected = -55;
        double actual = calculator.calculate(first, second, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionPositiveAndNegative() {
        double first = 40;
        double second = -20;
        double expected = 20;
        double actual = calculator.calculate(first, second, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionZero() {
        double first = 0;
        double second = 93;
        double expected = 93;
        double actual = calculator.calculate(first, second, '+');
        assertEquals(expected, actual);
        first = 36;
        second = 0;
        expected = 36;
        actual = calculator.calculate(first, second, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionMaxValue() {
        double first = Double.MAX_VALUE;
        double second = -7;
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(first, second, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionMinValue() {
        double first = Double.MIN_VALUE;
        double second = 0;
        double expected = Double.MIN_VALUE;
        double actual = calculator.calculate(first, second, '+');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoPositive() {
        double first = 15;
        double second = 10;
        double expected = 5;
        double actual = calculator.calculate(first, second, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoNegative() {
        double first = -3;
        double second = -4;
        double expected = 1;
        double actual = calculator.calculate(first, second, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositiveAndNegative() {
        double first = 34;
        double second = -14;
        double expected = 48;
        double actual = calculator.calculate(first, second, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionZero() {
        double first = 0;
        double second = -17;
        double expected = 17;
        double actual = calculator.calculate(first, second, '-');
        assertEquals(expected, actual);
        first = -11;
        second = 0;
        expected = -11;
        actual = calculator.calculate(first, second, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMaxValue() {
        double first = Double.MAX_VALUE;
        double second = -4;
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(first, second, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMinValue() {
        double first = Double.MIN_VALUE;
        double second = 3;
        double expected = -3;
        double actual = calculator.calculate(first, second, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoPositive() {
        double first = 6;
        double second = 4;
        double expected = 24;
        double actual = calculator.calculate(first, second, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoNegative() {
        double first = -7;
        double second = -14;
        double expected = 98;
        double actual = calculator.calculate(first, second, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationPositiveAndNegative() {
        double first = 7;
        double second = -21;
        double expected = -147;
        double actual = calculator.calculate(first, second, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationZero() {
        double first = 0;
        double second = 346;
        double expected = 0;
        double actual = calculator.calculate(first, second, '*');
        assertEquals(expected, actual);
        first = 52;
        second = 0;
        expected = 0;
        actual = calculator.calculate(first, second, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMaxValue() {
        double first = Double.MAX_VALUE;
        double second = 32;
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(first, second, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMinValue() {
        double first = Double.MIN_VALUE;
        double second = 3;
        double expected = 1.5E-323;
        double actual = calculator.calculate(first, second, '*');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoPositive() {
        double first = 6;
        double second = 2;
        double expected = 3;
        double actual = calculator.calculate(first, second, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoNegative() {
        double first = -10;
        double second = -5;
        double expected = 2;
        double actual = calculator.calculate(first, second, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveAndNegative() {
        double first = 20;
        double second = -5;
        double expected = -4;
        double actual = calculator.calculate(first, second, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionZero() {
        double first = 0;
        double second = 300;
        double expected = 0;
        double actual = calculator.calculate(first, second, '/');
        assertEquals(expected, actual);
        double firstL = 35437;
        double secondL = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstL, secondL, '/');
        });
    }

    @Test
    void divisionMaxValue() {
        double first = Double.MAX_VALUE;
        double second = 7;
        double expected = 2.5681330498033083E307;
        double actual = calculator.calculate(first, second, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionMinValue() {
        double first = Double.MIN_VALUE;
        double second = 3;
        double expected = 0;
        double actual = calculator.calculate(first, second, '/');
        assertEquals(expected, actual);
    }

    @Test
    void raiseToPower() {
        double first = 7;
        double second = 3;
        double expected = 343;
        double actual = calculator.calculate(first, second, '^');
        assertEquals(expected, actual);
        first = -7;
        second = 3;
        expected = -343;
        actual = calculator.calculate(first, second, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raiseToNegativePower() {
        double first = 7;
        double second = -1;
        double expected = 0.14285714285714285;
        double actual = calculator.calculate(first, second, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raiseToZeroPower() {
        double first = 4363;
        double second = 0;
        double expected = 1;
        double actual = calculator.calculate(first, second, '^');
        assertEquals(expected, actual);
    }

    @Test
    void checkOperation() {
        double first = 7;
        double second = 4;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(first, second, '!');
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(first, second, '3');
        });
    }
}
