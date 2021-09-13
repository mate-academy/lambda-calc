package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private double expected;
    private double actual;
    private double number1;
    private double number2;

    @Test
    void addictionTwoPositive() {
        number1 = 7;
        number2 = 14;
        expected = 21;
        actual = calculator.calculate(number1, number2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionTwoNegative() {
        number1 = -7;
        number2 = -14;
        expected = -21;
        actual = calculator.calculate(number1, number2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionPositiveAndNegative() {
        number1 = 7;
        number2 = -14;
        expected = -7;
        actual = calculator.calculate(number1, number2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionZero_1() {
        number1 = 0;
        number2 = -14;
        expected = -14;
        actual = calculator.calculate(number1, number2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionZero_2() {
        number1 = -14;
        number2 = 0;
        expected = -14;
        actual = calculator.calculate(number1, number2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionMaxValue() {
        number1 = Double.MAX_VALUE;
        number2 = -7;
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(number1, number2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void addictionMinValue() {
        number1 = Double.MIN_VALUE;
        number2 = 0;
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(number1, number2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoPositive() {
        number1 = 7;
        number2 = 14;
        expected = -7;
        actual = calculator.calculate(number1, number2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoNegative() {
        number1 = -7;
        number2 = -14;
        expected = 7;
        actual = calculator.calculate(number1, number2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositiveAndNegative() {
        number1 = 7;
        number2 = -14;
        expected = 21;
        actual = calculator.calculate(number1, number2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionZero_1() {
        number1 = 0;
        number2 = -14;
        expected = 14;
        actual = calculator.calculate(number1, number2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionZero_2() {
        number1 = -14;
        number2 = 0;
        expected = -14;
        actual = calculator.calculate(number1, number2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMaxValue() {
        number1 = Double.MAX_VALUE;
        number2 = -7;
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(number1, number2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMinValue() {
        number1 = Double.MIN_VALUE;
        number2 = 3;
        expected = -3;
        actual = calculator.calculate(number1, number2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoPositive() {
        number1 = 7;
        number2 = 14;
        expected = 98;
        actual = calculator.calculate(number1, number2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoNegative() {
        number1 = -7;
        number2 = -14;
        expected = 98;
        actual = calculator.calculate(number1, number2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationPositiveAndNegative() {
        number1 = 7;
        number2 = -14;
        expected = -98;
        actual = calculator.calculate(number1, number2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationZero_1() {
        number1 = 0;
        number2 = 14;
        expected = 0;
        actual = calculator.calculate(number1, number2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationZero_2() {
        number1 = 14;
        number2 = 0;
        expected = 0;
        actual = calculator.calculate(number1, number2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMaxValue() {
        number1 = Double.MAX_VALUE;
        number2 = 7;
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(number1, number2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMinValue() {
        number1 = Double.MIN_VALUE;
        number2 = 3;
        expected = 1.5E-323;
        actual = calculator.calculate(number1, number2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoPositive() {
        number1 = 7;
        number2 = 14;
        expected = 0.5;
        actual = calculator.calculate(number1, number2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoNegative() {
        number1 = -7;
        number2 = -14;
        expected = 0.5;
        actual = calculator.calculate(number1, number2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveAndNegative() {
        number1 = 7;
        number2 = -14;
        expected = -0.5;
        actual = calculator.calculate(number1, number2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionZero_1() {
        number1 = 0;
        number2 = 14;
        expected = 0;
        actual = calculator.calculate(number1, number2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionZero_2() {
        number1 = 14;
        number2 = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(number1, number2, '/');
        });
    }

    @Test
    void divisionMaxValue() {
        number1 = Double.MAX_VALUE;
        number2 = 7;
        expected = 2.5681330498033083E307;
        actual = calculator.calculate(number1, number2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionMinValue() {
        number1 = Double.MIN_VALUE;
        number2 = 3;
        expected = 0;
        actual = calculator.calculate(number1, number2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void raiseToPower() {
        number1 = 7;
        number2 = 3;
        expected = 343;
        actual = calculator.calculate(number1, number2, '^');
        assertEquals(expected, actual);
        number1 = -7;
        number2 = 3;
        expected = -343;
        actual = calculator.calculate(number1, number2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raiseToNegativePower() {
        number1 = 7;
        number2 = -2;
        expected = 0.02040816326530612;
        actual = calculator.calculate(number1, number2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raiseToZeroPower() {
        number1 = 7;
        number2 = 0;
        expected = 1;
        actual = calculator.calculate(number1, number2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void checkOperation() {
        number1 = 7;
        number2 = 4;
        assertThrows(IllegalStateException.class, () -> {
            calculator.calculate(number1, number2, '!');
        });
        assertThrows(IllegalStateException.class, () -> {
            calculator.calculate(number1, number2, '3');
        });
    }
}
