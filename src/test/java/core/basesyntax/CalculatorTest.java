package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private Calculate calculator = new Calculator();

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        double expected = 100.0;
        double actual = calculator.calculate(90.0, 10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoNegativeOperands_Ok() {
        double expected = - 150.0;
        double actual = calculator.calculate(-100.0, -50.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        double expected = - 150.0;
        double actual = calculator.calculate(-200.0, 50.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithFirstOperandIsZero_Ok() {
        double expected = 50.0;
        double actual = calculator.calculate(0.0, 50.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithSecondOperandIsZero_Ok() {
        double expected = 60.0;
        double actual = calculator.calculate(60.0, 0.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithMinAndMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithMinAndMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithMinAndMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithMinAndMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE / Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionByZero_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(2.0, 0.0, '/');
        });
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        double expected = 64.0;
        double actual = calculator.calculate(8.0, 2.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        double expected = 64.0;
        double actual = calculator.calculate(-8.0, 2.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() {
        double expected = 0.015625;
        double actual = calculator.calculate(8.0, -2.0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() {
        double expected = 0.015625;
        double actual = calculator.calculate(-8.0, -2.0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(8.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(-8.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        double expected = 0.0;
        double actual = calculator.calculate(0.0, 10.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(2.0, 3.0, '#');
        });
    }
}
