package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private Calculate calculator = new Calculator();
    private double expected;
    private double actual;

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        expected = 100.0;
        actual = calculator.calculate(90.0, 10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        expected = - 150.0;
        actual = calculator.calculate(-100.0, -50.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        expected = - 150.0;
        actual = calculator.calculate(-200.0, 50.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirstOperandIsZero_Ok() {
        expected = 50.0;
        actual = calculator.calculate(0.0, 50.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithSecondOperandIsZero_Ok() {
        expected = 60.0;
        actual = calculator.calculate(60.0, 0.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMinAndMaxDoubleValues_Ok() {
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithMinAndMaxDoubleValues_Ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithMinAndMaxDoubleValues_Ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMinAndMaxDoubleValues_Ok() {
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(2.0, 0.0, '/');
        });
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_Ok() {
        expected = 64.0;
        actual = calculator.calculate(8.0, 2.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_Ok() {
        expected = 64.0;
        actual = calculator.calculate(-8.0, 2.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_Ok() {
        expected = 0.015625;
        actual = calculator.calculate(8.0, -2.0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_Ok() {
        expected = 0.015625;
        actual = calculator.calculate(-8.0, -2.0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() {
        expected = 1.0;
        actual = calculator.calculate(8.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() {
        expected = 1.0;
        actual = calculator.calculate(-8.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        expected = 0.0;
        actual = calculator.calculate(0.0, 10.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToNegativePower() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(0, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(2.0, 3.0, '#');
        });
    }
}
