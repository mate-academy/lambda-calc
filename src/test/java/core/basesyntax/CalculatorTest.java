package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 1e-15;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_illegalOperation_notOk() {
        double firstOperand = 5;
        double secondOperand = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstOperand, secondOperand, '&');
        });
    }

    @Test
    void additionTwoPositive_Ok() {
        double firstOperand = 10;
        double secondOperand = 13;
        assertEquals(23, calculator.calculate(firstOperand, secondOperand, '+'));
    }

    @Test
    void additionTwoNegative_Ok() {
        double firstOperand = -4;
        double secondOperand = -100;
        assertEquals(-104, calculator.calculate(firstOperand, secondOperand, '+'));
    }

    @Test
    void additionPositiveAndNegative_Ok() {
        double firstOperand = 100;
        double secondOperand = -56;
        assertEquals(44, calculator.calculate(firstOperand, secondOperand, '+'));
    }

    @Test
    void additionNegativeAndPositive_Ok() {
        double firstOperand = -100;
        double secondOperand = 56;
        assertEquals(-44, calculator.calculate(firstOperand, secondOperand, '+'));
    }

    @Test
    void additionMinValues_Ok() {
        double firstOperand = Double.MIN_VALUE;
        double secondOperand = Double.MIN_VALUE;
        assertEquals(0, calculator.calculate(firstOperand, secondOperand, '+'), DELTA);
    }

    @Test
    void additionMaxValues_Ok() {
        double firstOperand = Double.MAX_VALUE;
        double secondOperand = Double.MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(firstOperand,
                secondOperand, '+'), DELTA);
    }

    @Test
    void additionMinAndMaxValues_Ok() {
        double firstOperand = Double.MIN_VALUE;
        double secondOperand = Double.MAX_VALUE;
        assertEquals(Double.MAX_VALUE, calculator.calculate(firstOperand,
                secondOperand, '+'), DELTA);
    }

    @Test
    void additionWithZero_Ok() {
        double firstOperand = 45;
        double secondOperand = 0;
        assertEquals(firstOperand, calculator.calculate(firstOperand, secondOperand, '+'));
    }

    @Test
    void subtractionTwoPositive_Ok() {
        double firstOperand = 30;
        double secondOperand = 13;
        assertEquals(17, calculator.calculate(firstOperand, secondOperand, '-'));
    }

    @Test
    void subtractionTwoNegative_Ok() {
        double firstOperand = -4;
        double secondOperand = -100;
        assertEquals(96, calculator.calculate(firstOperand, secondOperand, '-'));
    }

    @Test
    void subtractionPositiveAndNegative_Ok() {
        double firstOperand = 100;
        double secondOperand = -56;
        assertEquals(156, calculator.calculate(firstOperand, secondOperand, '-'));
    }

    @Test
    void subtractionNegativeAndPositive_Ok() {
        double firstOperand = -100;
        double secondOperand = 56;
        assertEquals(-156, calculator.calculate(firstOperand, secondOperand, '-'));
    }

    @Test
    void subtractionMinAndMaxDoubleValue_Ok() {
        double firstOperand = Double.MIN_VALUE;
        double secondOperand = Double.MAX_VALUE;
        assertEquals(-Double.MAX_VALUE, calculator.calculate(firstOperand,
                secondOperand, '-'), DELTA);
    }

    @Test
    void subtractionMinValues_Ok() {
        double firstOperand = Double.MIN_VALUE;
        double secondOperand = Double.MIN_VALUE;
        assertEquals(0, calculator.calculate(firstOperand,
                secondOperand, '-'), DELTA);
    }

    @Test
    void subtractionMaxValues_Ok() {
        double firstOperand = Double.MAX_VALUE;
        double secondOperand = Double.MAX_VALUE;
        assertEquals(0, calculator.calculate(firstOperand, secondOperand, '-'), DELTA);
    }

    @Test
    void subtractionWithZero_Ok() {
        double firstOperand = 45;
        double secondOperand = 0;
        assertEquals(firstOperand, calculator.calculate(firstOperand, secondOperand, '-'));
    }

    @Test
    void multiplicationTwoPositive_Ok() {
        double firstOperand = 10.01;
        double secondOperand = 13.02;
        assertEquals(130.3302, calculator.calculate(firstOperand, secondOperand, '*'));
    }

    @Test
    void multiplicationTwoNegative_Ok() {
        double firstOperand = -4;
        double secondOperand = -100.02;
        assertEquals(400.08, calculator.calculate(firstOperand, secondOperand, '*'));
    }

    @Test
    void multiplicationPositiveAndNegative_Ok() {
        double firstOperand = 100.2;
        double secondOperand = -56;
        assertEquals(-5611.2, calculator.calculate(firstOperand, secondOperand, '*'));
    }

    @Test
    void multiplicationNegativeAndPositive_Ok() {
        double firstOperand = -100.2;
        double secondOperand = 56;
        assertEquals(-5611.2, calculator.calculate(firstOperand, secondOperand, '*'));
    }

    @Test
    void multiplicationWithZero_Ok() {
        double firstOperand = 45;
        double secondOperand = 0;
        assertEquals(0, calculator.calculate(firstOperand, secondOperand, '*'));
    }

    @Test
    void multiplicationMinAndMaxDoubleValues_Ok() {
        double firstOperand = Double.MIN_VALUE;
        double secondOperand = Double.MAX_VALUE;
        assertEquals(0, calculator.calculate(firstOperand, secondOperand, '*'), DELTA);
    }

    @Test
    void multiplicationMinDoubleValues_Ok() {
        double firstOperand = Double.MIN_VALUE;
        double secondOperand = Double.MIN_VALUE;
        assertEquals(0, calculator.calculate(firstOperand, secondOperand, '*'), DELTA);
    }

    @Test
    void multiplicationMaxDoubleValues_Ok() {
        double firstOperand = Double.MAX_VALUE;
        double secondOperand = Double.MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(firstOperand,
                secondOperand, '*'), DELTA);
    }

    @Test
    void divisionTwoPositive_Ok() {
        double firstOperand = 130;
        double secondOperand = 13;
        assertEquals(10, calculator.calculate(firstOperand, secondOperand, '/'));
    }

    @Test
    void divisionTwoNegative_Ok() {
        double firstOperand = -4;
        double secondOperand = -2;
        assertEquals(2, calculator.calculate(firstOperand, secondOperand, '/'));
    }

    @Test
    void divisionPositiveAndNegative_Ok() {
        double firstOperand = 100;
        double secondOperand = -20;
        assertEquals(-5, calculator.calculate(firstOperand, secondOperand, '/'));
    }

    @Test
    void divisionNegativeAndPositive_Ok() {
        double firstOperand = -100;
        double secondOperand = 20;
        assertEquals(-5, calculator.calculate(firstOperand, secondOperand, '/'));
    }

    @Test
    void divisionWithZero_Ok() {
        double firstOperand = 0;
        double secondOperand = 2;
        assertEquals(firstOperand, calculator.calculate(firstOperand, secondOperand, '/'));
    }

    @Test
    void divisionMinByMaxDoubleValues_Ok() {
        double firstOperand = Double.MIN_VALUE;
        double secondOperand = Double.MAX_VALUE;
        assertEquals(0, calculator.calculate(firstOperand,
                secondOperand, '/'), DELTA);
    }

    @Test
    void divisionMaxByMinDoubleValues_Ok() {
        double firstOperand = Double.MAX_VALUE;
        double secondOperand = Double.MIN_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(firstOperand,
                secondOperand, '/'), DELTA);
    }

    @Test
    void divisionByZero_NotOk() {
        double firstOperand = 5;
        double secondOperand = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstOperand, secondOperand, '/');
        });
    }

    @Test
    void raisingPositiveToPositivePower_Ok() {
        double firstOperand = 4;
        double power = 2;
        assertEquals(16, calculator.calculate(firstOperand, power, '^'));
    }

    @Test
    void raisingNegativeToPositivePower_Ok() {
        double firstOperand = -2;
        double power = 3;
        assertEquals(-8, calculator.calculate(firstOperand, power, '^'));
    }

    @Test
    void raisingPositiveToNegativePower_Ok() {
        double firstOperand = 4;
        double power = -2;
        assertEquals(0.0625, calculator.calculate(firstOperand, power, '^'));
    }

    @Test
    void raisingNegativeToNegativePower_Ok() {
        double firstOperand = -2;
        double power = -2;
        assertEquals(0.25, calculator.calculate(firstOperand, power, '^'));
    }

    @Test
    void raisingPositiveToZeroPower_Ok() {
        double firstOperand = -2;
        double power = 0;
        assertEquals(1, calculator.calculate(firstOperand, power, '^'));
    }

    @Test
    void raisingNegativeToZeroPower_Ok() {
        double firstOperand = -2;
        double power = 0;
        assertEquals(1, calculator.calculate(firstOperand, power, '^'));
    }

    @Test
    void raisingZeroToPositivePower_Ok() {
        double firstOperand = 0;
        double power = 67;
        assertEquals(0, calculator.calculate(firstOperand, power, '^'));
    }

    @Test
    void raisingZeroToNegativePower_NotOk() {
        double firstOperand = 0;
        double power = -2;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstOperand, power, '^');
        });
    }
}
