package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void calculate_additionTwoPositiveIntegers_ok() {
        double expected = 30;
        double actual = calculator.calculate(10, 20, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionTwoNegativeIntegers_ok() {
        double expected = -30;
        double actual = calculator.calculate(-10, -20, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeIntegers_ok() {
        double expected = -10;
        double actual = calculator.calculate(10, -20, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroParameter_ok() {
        double expected = 20;
        double actual = calculator.calculate(0, 20, '+');
        assertEquals(expected, actual);
        actual = calculator.calculate(20, 0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxDoubleValues_ok() {
        double expected = Double.MAX_VALUE + Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMinDoubleValues_ok() {
        double expected = Double.MIN_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoPositiveIntegers_ok() {
        double expected = 10;
        double actual = calculator.calculate(20, 10, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoNegativeIntegers_ok() {
        double expected = 10;
        double actual = calculator.calculate(-10, -20, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeIntegers_ok() {
        double expected = 30;
        double actual = calculator.calculate(10, -20, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroParameter_ok() {
        double expected = -20;
        double actual = calculator.calculate(0, 20, '-');
        assertEquals(expected, actual);
        expected = 20;
        actual = calculator.calculate(20, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxDoubleValues_ok() {
        double expected = Double.MAX_VALUE - Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinDoubleValues_ok() {
        double expected = Double.MIN_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationTwoPositiveIntegers_ok() {
        double expected = 200;
        double actual = calculator.calculate(10, 20, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationTwoNegativeIntegers_ok() {
        double expected = 200;
        double actual = calculator.calculate(-10, -20, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeIntegers_ok() {
        double expected = -200;
        double actual = calculator.calculate(10, -20, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroParameter_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 20, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(20, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxDoubleValues_ok() {
        double expected = Double.MAX_VALUE * Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMinDoubleValues_ok() {
        double expected = Double.MIN_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionTwoPositiveIntegers_ok() {
        double expected = 0.5;
        double actual = calculator.calculate(10, 20, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionTwoNegativeIntegers_ok() {
        double expected = 0.5;
        double actual = calculator.calculate(-10, -20, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeIntegers_ok() {
        double expected = -0.5;
        double actual = calculator.calculate(10, -20, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroFirstParameter_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 20, '/');
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
        double expected = Double.MAX_VALUE / Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinDoubleValues_ok() {
        double expected = Double.MIN_VALUE / Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveIntegerToPositivePower_ok() {
        double expected = 8;
        double actual = calculator.calculate(2, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeIntegerToPositivePower_ok() {
        double expected = -8;
        double actual = calculator.calculate(-2, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveIntegerToNegativePower_ok() {
        double expected = 1.0 / 8 / 8;
        double actual = calculator.calculate(8, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeIntegerToNegativePower_ok() {
        double expected = 1.0 / 8 / 8;
        double actual = calculator.calculate(-8, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveIntegerToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(8, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeIntegerToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(-8, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperator_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, '%');
        });
    }
}
