package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA_VALUE = 0.00001;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addPositiveValues_Ok() {
        double actual = calculator.calculate(100, 200, '+');
        double expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addNegativeValues_Ok() {
        double actual = calculator.calculate(-100, -200, '+');
        double expected = -300;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addPositiveAndNegative_Ok() {
        double actual = calculator.calculate(-100, 200, '+');
        double expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addZero_Ok() {
        double actual = calculator.calculate(0, -200, '+');
        double expected = -200;
        assertEquals(expected, actual);
        actual = calculator.calculate(100, 0, '+');
        expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addMaxValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addMaxAndMinValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        double expected = 1.0E-323;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subPositiveValues_Ok() {
        double actual = calculator.calculate(100, 200, '-');
        double expected = -100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subNegativeValues_Ok() {
        double actual = calculator.calculate(-100, -200, '-');
        double expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subPositiveAndNegative_Ok() {
        double actual = calculator.calculate(-100, 200, '-');
        double expected = -300;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subZero_Ok() {
        double actual = calculator.calculate(0, -200, '-');
        double expected = 200;
        assertEquals(expected, actual);
        actual = calculator.calculate(100, 0, '-');
        expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subMaxValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        double expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '-');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subMaxAndMinValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        double expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '-');
        expected = 1.0E-323;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_mulPositiveValues_Ok() {
        double actual = calculator.calculate(100, 200, '*');
        double expected = 20000;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_mulNegativeValues_Ok() {
        double actual = calculator.calculate(-100, -200, '*');
        double expected = 20000;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_mulPositiveAndNegative_Ok() {
        double actual = calculator.calculate(-100, 200, '*');
        double expected = -20000;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_mulZero_Ok() {
        double actual = calculator.calculate(0, -200, '*');
        double expected = 0.0;
        assertEquals(expected, actual);
        actual = calculator.calculate(100, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_mulMaxValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_mulMaxAndMinValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        double expected = 8.881784197001251E-16;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_mulMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        double expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divPositiveValues_Ok() {
        double actual = calculator.calculate(125, 200, '/');
        double expected = 0.625;
        assertEquals(expected, actual, DELTA_VALUE);
    }

    @Test
    void calculate_divNegativeValues_Ok() {
        double actual = calculator.calculate(-401, -200, '/');
        double expected = 2.005;
        assertEquals(expected, actual, DELTA_VALUE);
    }

    @Test
    void calculate_divPositiveAndNegative_Ok() {
        double actual = calculator.calculate(-179, 200, '/');
        double expected = -0.895;
        assertEquals(expected, actual, DELTA_VALUE);
    }

    @Test
    void calculate_divZero_Ok() {
        double actual = calculator.calculate(0, -200, '/');
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divByZero_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(100, 0, '/'));
    }

    @Test
    void calculate_divMaxValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        double expected = 1;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '/');
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divMaxAndMinValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual, Double.MIN_VALUE);
    }

    @Test
    void calculate_divMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        double expected = 1;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '/');
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingToPositivePower_Ok() {
        double actual = calculator.calculate(5, 4, '^');
        double expected = 625;
        assertEquals(expected, actual);
        actual = calculator.calculate(-5, 5, '^');
        expected = -3125;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingToNegativePower_Ok() {
        double actual = calculator.calculate(5, -4, '^');
        double expected = 0.0016;
        assertEquals(expected, actual, DELTA_VALUE);
        actual = calculator.calculate(-5, -5, '^');
        expected = -0.00032;
        assertEquals(expected, actual, DELTA_VALUE);
    }

    @Test
    void calculate_raisingToZeroPower_Ok() {
        double actual = calculator.calculate(5, 0, '^');
        double expected = 1;
        assertEquals(expected, actual);
        actual = calculator.calculate(-5, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        double actual = calculator.calculate(0, 5, '^');
        double expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(0, -5, '^');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
        actual = calculator.calculate(0, 0, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingMaxValuesToPower_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '^');
        expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, '^');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingMinValuesToPower_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '^');
        double expected = 1;
        assertEquals(expected, actual);
        expected = Double.NaN;
        actual = calculator.calculate(-Double.MIN_VALUE, Double.MIN_VALUE, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '^');
        expected = 1;
        assertEquals(expected, actual);
        actual = calculator.calculate(-Double.MIN_VALUE, -Double.MIN_VALUE, '^');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingMinAndMaxValuesToPower_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '^');
        double expected = 1;
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MIN_VALUE, '^');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MIN_VALUE, -Double.MAX_VALUE, '^');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 1, '!'));
    }

}
