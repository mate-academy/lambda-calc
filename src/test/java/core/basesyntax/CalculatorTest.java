package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final double MIN_VALUE = Double.MIN_VALUE;
    private static final double DELTA = 1e-15;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_illegalOperation_notOk() {
        double a = 5;
        double b = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(a, b, '&');
        });
    }

    @Test
    void additionTwoPositive_Ok() {
        double a = 10;
        double b = 13;
        assertEquals(23, calculator.calculate(a, b, '+'));
    }

    @Test
    void additionTwoNegative_Ok() {
        double a = -4;
        double b = -100;
        assertEquals(-104, calculator.calculate(a, b, '+'));
    }

    @Test
    void additionPositiveAndNegative_Ok() {
        double a = 100;
        double b = -56;
        assertEquals(44, calculator.calculate(a, b, '+'));
    }

    @Test
    void additionMinValues_Ok() {
        double a = MIN_VALUE;
        double b = MIN_VALUE;
        assertEquals(0, calculator.calculate(a, b, '+'), DELTA);
    }

    @Test
    void additionMaxValues_Ok() {
        double a = MAX_VALUE;
        double b = MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(a, b, '+'), DELTA);
    }

    @Test
    void additionMinAndMaxValues_Ok() {
        double a = MIN_VALUE;
        double b = MAX_VALUE;
        assertEquals(MAX_VALUE, calculator.calculate(a, b, '+'), DELTA);
    }

    @Test
    void additionWithZero_Ok() {
        double a = 45;
        double b = 0;
        assertEquals(a, calculator.calculate(a, b, '+'));
    }

    @Test
    void subtractionTwoPositive_Ok() {
        double a = 30;
        double b = 13;
        assertEquals(17, calculator.calculate(a, b, '-'));
    }

    @Test
    void subtractionTwoNegative_Ok() {
        double a = -4;
        double b = -100;
        assertEquals(96, calculator.calculate(a, b, '-'));
    }

    @Test
    void subtractionPositiveAndNegative_Ok() {
        double a = 100;
        double b = -56;
        assertEquals(156, calculator.calculate(a, b, '-'));
    }

    @Test
    void subtractionMinAndMaxDoubleValue_Ok() {
        double a = MIN_VALUE;
        double b = MAX_VALUE;
        assertEquals(-MAX_VALUE, calculator.calculate(a, b, '-'), DELTA);
    }

    @Test
    void subtractionMinValues_Ok() {
        double a = MIN_VALUE;
        double b = MIN_VALUE;
        assertEquals(0, calculator.calculate(a, b, '-'), DELTA);
    }

    @Test
    void subtractionMaxValues_Ok() {
        double a = MAX_VALUE;
        double b = MAX_VALUE;
        assertEquals(0, calculator.calculate(a, b, '-'), DELTA);
    }

    @Test
    void subtractionWithZero_Ok() {
        double a = 45;
        double b = 0;
        assertEquals(a, calculator.calculate(a, b, '-'));
    }

    @Test
    void multiplicationTwoPositive_Ok() {
        double a = 10.01;
        double b = 13.02;
        assertEquals(130.3302, calculator.calculate(a, b, '*'));
    }

    @Test
    void multiplicationTwoNegative_Ok() {
        double a = -4;
        double b = -100.02;
        assertEquals(400.08, calculator.calculate(a, b, '*'));
    }

    @Test
    void multiplicationPositiveAndNegative_Ok() {
        double a = 100.2;
        double b = -56;
        assertEquals(-5611.2, calculator.calculate(a, b, '*'));
    }

    @Test
    void multiplicationWithZero_Ok() {
        double a = 45;
        double b = 0;
        assertEquals(0, calculator.calculate(a, b, '*'));
    }

    @Test
    void multiplicationMinAndMaxDoubleValues_Ok() {
        double a = MIN_VALUE;
        double b = MAX_VALUE;
        assertEquals(0, calculator.calculate(a, b, '*'), DELTA);
    }

    @Test
    void multiplicationMinDoubleValues_Ok() {
        double a = MIN_VALUE;
        double b = MIN_VALUE;
        assertEquals(0, calculator.calculate(a, b, '*'), DELTA);
    }

    @Test
    void multiplicationMaxDoubleValues_Ok() {
        double a = MAX_VALUE;
        double b = MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(a, b, '*'), DELTA);
    }

    @Test
    void divisionTwoPositive_Ok() {
        double a = 130;
        double b = 13;
        assertEquals(10, calculator.calculate(a, b, '/'));
    }

    @Test
    void divisionTwoNegative_Ok() {
        double a = -4;
        double b = -2;
        assertEquals(2, calculator.calculate(a, b, '/'));
    }

    @Test
    void divisionPositiveAndNegative_Ok() {
        double a = 100;
        double b = -20;
        assertEquals(-5, calculator.calculate(a, b, '/'));
    }

    @Test
    void divisionWithZero_Ok() {
        double a = 0;
        double b = 2;
        assertEquals(a, calculator.calculate(a, b, '/'));
    }

    @Test
    void divisionMinByMaxDoubleValues_Ok() {
        double a = MIN_VALUE;
        double b = MAX_VALUE;
        assertEquals(0, calculator.calculate(a, b, '/'), DELTA);
    }

    @Test
    void divisionMaxByMinDoubleValues_Ok() {
        double a = MAX_VALUE;
        double b = MIN_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(a, b, '/'), DELTA);
    }

    @Test
    void divisionByZero_NotOk() {
        double a = 5;
        double b = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(a, b, '/');
        });
    }

    @Test
    void raisingPositiveToPositivePower_Ok() {
        double a = 4;
        double b = 2;
        assertEquals(16, calculator.calculate(4, 2, '^'));
    }

    @Test
    void raisingNegativeToPositivePower_Ok() {
        double a = -2;
        double b = 3;
        assertEquals(-8, calculator.calculate(-2, 3, '^'));
    }

    @Test
    void raisingPositiveToNegativePower_Ok() {
        double a = 4;
        double b = -2;
        assertEquals(0.0625, calculator.calculate(4, -2, '^'));
    }

    @Test
    void raisingNegativeToNegativePower_Ok() {
        double a = -2;
        double b = -2;
        assertEquals(-0.125, calculator.calculate(-2, -3, '^'));
    }

    @Test
    void raisingPositiveToZeroPower_Ok() {
        double a = -2;
        double b = 0;
        assertEquals(1, calculator.calculate(5, 0, '^'));
    }

    @Test
    void raisingNegativeToZeroPower_Ok() {
        double a = -2;
        double b = 0;
        assertEquals(1, calculator.calculate(-2, 0, '^'));
    }

    @Test
    void raisingZeroToPositivePower_Ok() {
        double a = 0;
        double b = 67;
        assertEquals(0, calculator.calculate(0, 67, '^'));
    }

    @Test
    void raisingZeroToNegativePower_NotOk() {
        double a = 0;
        double b = -2;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(a, b, '^');
        });
    }
}
