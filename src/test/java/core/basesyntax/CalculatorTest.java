package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.000001;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveIntegers_ok() {
        expected = 30;
        actual = calculator.calculate(10, 20, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionTwoNegativeIntegers_ok() {
        expected = -30;
        actual = calculator.calculate(-10, -20, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeIntegers_ok() {
        expected = -10;
        actual = calculator.calculate(10, -20, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroParameter_ok() {
        expected = 20;
        actual = calculator.calculate(0, 20, '+');
        assertEquals(expected, actual);
        actual = calculator.calculate(20, 0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxDoubleValues_ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinDoubleValues_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveIntegers_ok() {
        expected = 10;
        actual = calculator.calculate(20, 10, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoNegativeIntegers_ok() {
        expected = 10;
        actual = calculator.calculate(-10, -20, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeIntegers_ok() {
        expected = 30;
        actual = calculator.calculate(10, -20, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroParameter_ok() {
        expected = -20;
        actual = calculator.calculate(0, 20, '-');
        assertEquals(expected, actual);
        expected = 20;
        actual = calculator.calculate(20, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxDoubleValues_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinDoubleValues_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveIntegers_ok() {
        expected = 200;
        actual = calculator.calculate(10, 20, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegativeIntegers_ok() {
        expected = 200;
        actual = calculator.calculate(-10, -20, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeIntegers_ok() {
        expected = -200;
        actual = calculator.calculate(10, -20, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroParameter_ok() {
        expected = 0;
        actual = calculator.calculate(0, 20, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(20, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxDoubleValues_ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMinDoubleValues_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveIntegers_ok() {
        expected = 0.5;
        actual = calculator.calculate(10, 20, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionTwoNegativeIntegers_ok() {
        expected = 0.5;
        actual = calculator.calculate(-10, -20, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeIntegers_ok() {
        expected = -0.5;
        actual = calculator.calculate(10, -20, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroFirstParameter_ok() {
        expected = 0;
        actual = calculator.calculate(0, 20, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroSecondParameter_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, '/');
        });
    }

    @Test
    void calculate_divisionMaxDoubleValues_ok() {
        expected = 1;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionMinDoubleValues_ok() {
        expected = 1;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveIntegerToPositivePower_ok() {
        expected = 8;
        actual = calculator.calculate(2, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeIntegerToPositivePower_ok() {
        expected = -8;
        actual = calculator.calculate(-2, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveIntegerToNegativePower_ok() {
        expected = 1.0 / 8 / 8;
        actual = calculator.calculate(8, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeIntegerToNegativePower_ok() {
        expected = 1.0 / 8 / 8;
        actual = calculator.calculate(-8, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveIntegerToZeroPower_ok() {
        expected = 1;
        actual = calculator.calculate(8, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeIntegerToZeroPower_ok() {
        expected = 1;
        actual = calculator.calculate(-8, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        expected = 0;
        actual = calculator.calculate(0, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperator_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, '%');
        });
    }
}
