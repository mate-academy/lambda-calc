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
        double firstNumber = 5;
        double secondNumber = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstNumber, secondNumber, '&');
        });
    }

    @Test
    void additionTwoPositive_Ok() {
        double firstNumber = 10;
        double secondNumber = 13;
        assertEquals(23, calculator.calculate(firstNumber, secondNumber, '+'));
    }

    @Test
    void additionTwoNegative_Ok() {
        double firstNumber = -4;
        double secondNumber = -100;
        assertEquals(-104, calculator.calculate(firstNumber, secondNumber, '+'));
    }

    @Test
    void additionPositiveAndNegative_Ok() {
        double firstNumber = 100;
        double secondNumber = -56;
        assertEquals(44, calculator.calculate(firstNumber, secondNumber, '+'));
    }

    @Test
    void additionNegativeAndPositive_Ok() {
        double firstNumber = -100;
        double secondNumber = 56;
        assertEquals(-44, calculator.calculate(firstNumber, secondNumber, '+'));
    }

    @Test
    void additionMinValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MIN_VALUE;
        assertEquals(0, calculator.calculate(firstNumber, secondNumber, '+'), DELTA);
    }

    @Test
    void additionMaxValues_Ok() {
        double firstNumber = Double.MAX_VALUE;
        double secondNumber = Double.MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(firstNumber,
                secondNumber, '+'), DELTA);
    }

    @Test
    void additionMinAndMaxValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        assertEquals(Double.MAX_VALUE, calculator.calculate(firstNumber,
                secondNumber, '+'), DELTA);
    }

    @Test
    void additionWithZero_Ok() {
        double firstNumber = 45;
        double secondNumber = 0;
        assertEquals(firstNumber, calculator.calculate(firstNumber, secondNumber, '+'));
    }

    @Test
    void subtractionTwoPositive_Ok() {
        double firstNumber = 30;
        double secondNumber = 13;
        assertEquals(17, calculator.calculate(firstNumber, secondNumber, '-'));
    }

    @Test
    void subtractionTwoNegative_Ok() {
        double firstNumber = -4;
        double secondNumber = -100;
        assertEquals(96, calculator.calculate(firstNumber, secondNumber, '-'));
    }

    @Test
    void subtractionPositiveAndNegative_Ok() {
        double firstNumber = 100;
        double secondNumber = -56;
        assertEquals(156, calculator.calculate(firstNumber, secondNumber, '-'));
    }

    @Test
    void subtractionNegativeAndPositive_Ok() {
        double firstNumber = -100;
        double secondNumber = 56;
        assertEquals(-156, calculator.calculate(firstNumber, secondNumber, '-'));
    }

    @Test
    void subtractionMinAndMaxDoubleValue_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        assertEquals(-Double.MAX_VALUE, calculator.calculate(firstNumber,
                secondNumber, '-'), DELTA);
    }

    @Test
    void subtractionMinValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MIN_VALUE;
        assertEquals(0, calculator.calculate(firstNumber,
                secondNumber, '-'), DELTA);
    }

    @Test
    void subtractionMaxValues_Ok() {
        double firstNumber = Double.MAX_VALUE;
        double secondNumber = Double.MAX_VALUE;
        assertEquals(0, calculator.calculate(firstNumber, secondNumber, '-'), DELTA);
    }

    @Test
    void subtractionWithZero_Ok() {
        double firstNumber = 45;
        double secondNumber = 0;
        assertEquals(firstNumber, calculator.calculate(firstNumber, secondNumber, '-'));
    }

    @Test
    void multiplicationTwoPositive_Ok() {
        double firstNumber = 10.01;
        double secondNumber = 13.02;
        assertEquals(130.3302, calculator.calculate(firstNumber, secondNumber, '*'));
    }

    @Test
    void multiplicationTwoNegative_Ok() {
        double firstNumber = -4;
        double secondNumber = -100.02;
        assertEquals(400.08, calculator.calculate(firstNumber, secondNumber, '*'));
    }

    @Test
    void multiplicationPositiveAndNegative_Ok() {
        double firstNumber = 100.2;
        double secondNumber = -56;
        assertEquals(-5611.2, calculator.calculate(firstNumber, secondNumber, '*'));
    }

    @Test
    void multiplicationNegativeAndPositive_Ok() {
        double firstNumber = -100.2;
        double secondNumber = 56;
        assertEquals(-5611.2, calculator.calculate(firstNumber, secondNumber, '*'));
    }

    @Test
    void multiplicationWithZero_Ok() {
        double firstNumber = 45;
        double secondNumber = 0;
        assertEquals(0, calculator.calculate(firstNumber, secondNumber, '*'));
    }

    @Test
    void multiplicationMinAndMaxDoubleValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        assertEquals(0, calculator.calculate(firstNumber, secondNumber, '*'), DELTA);
    }

    @Test
    void multiplicationMinDoubleValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MIN_VALUE;
        assertEquals(0, calculator.calculate(firstNumber, secondNumber, '*'), DELTA);
    }

    @Test
    void multiplicationMaxDoubleValues_Ok() {
        double firstNumber = Double.MAX_VALUE;
        double secondNumber = Double.MAX_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(firstNumber,
                secondNumber, '*'), DELTA);
    }

    @Test
    void divisionTwoPositive_Ok() {
        double firstNumber = 130;
        double secondNumber = 13;
        assertEquals(10, calculator.calculate(firstNumber, secondNumber, '/'));
    }

    @Test
    void divisionTwoNegative_Ok() {
        double firstNumber = -4;
        double secondNumber = -2;
        assertEquals(2, calculator.calculate(firstNumber, secondNumber, '/'));
    }

    @Test
    void divisionPositiveAndNegative_Ok() {
        double firstNumber = 100;
        double secondNumber = -20;
        assertEquals(-5, calculator.calculate(firstNumber, secondNumber, '/'));
    }

    @Test
    void divisionNegativeAndPositive_Ok() {
        double firstNumber = -100;
        double secondNumber = 20;
        assertEquals(-5, calculator.calculate(firstNumber, secondNumber, '/'));
    }

    @Test
    void divisionWithZero_Ok() {
        double firstNumber = 0;
        double secondNumber = 2;
        assertEquals(firstNumber, calculator.calculate(firstNumber, secondNumber, '/'));
    }

    @Test
    void divisionMinByMaxDoubleValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        assertEquals(0, calculator.calculate(firstNumber,
                secondNumber, '/'), DELTA);
    }

    @Test
    void divisionMaxByMinDoubleValues_Ok() {
        double firstNumber = Double.MAX_VALUE;
        double secondNumber = Double.MIN_VALUE;
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(firstNumber,
                secondNumber, '/'), DELTA);
    }

    @Test
    void divisionByZero_NotOk() {
        double firstNumber = 5;
        double secondNumber = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstNumber, secondNumber, '/');
        });
    }

    @Test
    void raisingPositiveToPositivePower_Ok() {
        double firstNumber = 4;
        double power = 2;
        assertEquals(16, calculator.calculate(firstNumber, power, '^'));
    }

    @Test
    void raisingNegativeToPositivePower_Ok() {
        double firstNumber = -2;
        double power = 3;
        assertEquals(-8, calculator.calculate(firstNumber, power, '^'));
    }

    @Test
    void raisingPositiveToNegativePower_Ok() {
        double firstNumber = 4;
        double power = -2;
        assertEquals(0.0625, calculator.calculate(firstNumber, power, '^'));
    }

    @Test
    void raisingNegativeToNegativePower_Ok() {
        double firstNumber = -2;
        double power = -2;
        assertEquals(0.25, calculator.calculate(firstNumber, power, '^'));
    }

    @Test
    void raisingPositiveToZeroPower_Ok() {
        double firstNumber = -2;
        double power = 0;
        assertEquals(1, calculator.calculate(firstNumber, power, '^'));
    }

    @Test
    void raisingNegativeToZeroPower_Ok() {
        double firstNumber = -2;
        double power = 0;
        assertEquals(1, calculator.calculate(firstNumber, power, '^'));
    }

    @Test
    void raisingZeroToPositivePower_Ok() {
        double firstNumber = 0;
        double power = 67;
        assertEquals(0, calculator.calculate(firstNumber, power, '^'));
    }

    @Test
    void raisingZeroToNegativePower_NotOk() {
        double firstNumber = 0;
        double power = -2;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstNumber, power, '^');
        });
    }
}
