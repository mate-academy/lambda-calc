package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MyCalculatorTest {
    private static final double DELTA = 1e-8;
    private static final double firstPositiveOperand = 10;
    private static final double secondPositiveOperand = 20;
    private static final double firstNegativeOperand = -6;
    private static final double secondNegativeOperand = -3;
    private static final double minDouble = Double.MIN_VALUE;
    private static final double maxDouble = Double.MAX_VALUE;
    private static final double zero = 0;
    private static final Calculator myCalculator = new MyCalculator();

    @Test
    void calculate_additionTwoPositiveOperands_Ok() {
        double expected = 30;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, secondPositiveOperand, '+'));
    }

    @Test
    void calculate_additionTwoNegativeOperands_Ok() {
        double expected = -9;
        assertEquals(expected,
                myCalculator.calculate(firstNegativeOperand, secondNegativeOperand, '+'));
    }

    @Test
    void calculate_additionPositiveNegativeOperands_Ok() {
        double expected = 4;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, firstNegativeOperand, '+'));
    }

    @Test
    void calculate_additionZeroFirstOperand_Ok() {
        assertEquals(firstPositiveOperand,
                myCalculator.calculate(zero, firstPositiveOperand, '+'));
    }

    @Test
    void calculate_additionZeroSecondOperand_Ok() {
        assertEquals(firstPositiveOperand,
                myCalculator.calculate(firstPositiveOperand, zero, '+'));
    }

    @Test
    void calculate_additionMaxMinDoubleValues_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCalculator.calculate(maxDouble, minDouble, '+');
        });
    }

    @Test
    void calculate_subtractionTwoPositiveOperands_Ok() {
        double expected = -10;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, secondPositiveOperand, '-'));
    }

    @Test
    void calculate_subtractionTwoNegativeOperands_Ok() {
        double expected = -3;
        assertEquals(expected,
                myCalculator.calculate(firstNegativeOperand, secondNegativeOperand, '-'));
    }

    @Test
    void calculate_subtractionPositiveNegativeOperands_Ok() {
        double expected = 16;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, firstNegativeOperand, '-'));
    }

    @Test
    void calculate_subtractionZeroFirstOperand_Ok() {
        double expected = -firstPositiveOperand;
        assertEquals(expected,
                myCalculator.calculate(zero, firstPositiveOperand, '-'));
    }

    @Test
    void calculate_subtractionZeroSecondOperand_Ok() {
        assertEquals(firstPositiveOperand,
                myCalculator.calculate(firstPositiveOperand, zero, '-'));
    }

    @Test
    void calculate_subtractionMaxMinDoubleValues_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCalculator.calculate(maxDouble, minDouble, '-');
        });
    }

    @Test
    void calculate_divisionTwoPositiveOperands_Ok() {
        double expected = 0.5;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, secondPositiveOperand, '/'), DELTA);
    }

    @Test
    void calculate_divisionTwoNegativeOperands_Ok() {
        double expected = 2;
        assertEquals(expected,
                myCalculator.calculate(firstNegativeOperand, secondNegativeOperand, '/'), DELTA);
    }

    @Test
    void calculate_divisionPositiveNegativeOperands_Ok() {
        double expected = 10 / -6.0;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, firstNegativeOperand, '/'), DELTA);
    }

    @Test
    void calculate_divisionZeroFirstOperand_Ok() {
        double expected = 0;
        assertEquals(expected,
                myCalculator.calculate(zero, firstPositiveOperand, '/'));
    }

    @Test
    void calculate_divisionZeroSecondOperand_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCalculator.calculate(firstPositiveOperand, zero, '/');
        });
    }

    @Test
    void calculate_divisionMaxMinDoubleValues_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCalculator.calculate(maxDouble, minDouble, '/');
        });
    }

    @Test
    void calculate_multiplicationTwoPositiveOperands_Ok() {
        double expected = 200;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, secondPositiveOperand, '*'));
    }

    @Test
    void calculate_multiplicationTwoNegativeOperands_Ok() {
        double expected = 18;
        assertEquals(expected,
                myCalculator.calculate(firstNegativeOperand, secondNegativeOperand, '*'));
    }

    @Test
    void calculate_multiplicationPositiveNegativeOperands_Ok() {
        double expected = -60;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, firstNegativeOperand, '*'));
    }

    @Test
    void calculate_multiplicationZeroFirstOperand_Ok() {
        assertEquals(zero,
                myCalculator.calculate(zero, firstPositiveOperand, '*'));
    }

    @Test
    void calculate_multiplicationZeroSecondOperand_Ok() {
        assertEquals(zero,
                myCalculator.calculate(firstPositiveOperand, zero, '*'));
    }

    @Test
    void calculate_multiplicationMaxMinDoubleValues_Ok() {
        double expected = maxDouble * minDouble;
        assertEquals(expected,
                myCalculator.calculate(maxDouble, minDouble, '*'));
    }

    @Test
    void calculate_positiveToPositivePower_OK() {
        double expected = 1e20;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, secondPositiveOperand, '^'));
    }

    @Test
    void calculate_negativeToPositivePower_OK() {
        double expected = 59049;
        assertEquals(expected,
                myCalculator.calculate(secondNegativeOperand, firstPositiveOperand, '^'));
    }

    @Test
    void calculate_positiveToNegativePower_OK() {
        double expected = 1e-3;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, secondNegativeOperand, '^'));
    }

    @Test
    void calculate_negativeToNegativePower_OK() {
        double expected = -1 / 27.0;
        assertEquals(expected,
                myCalculator.calculate(secondNegativeOperand, secondNegativeOperand, '^'));
    }

    @Test
    void calculate_positiveToZeroPower_OK() {
        double expected = 1;
        assertEquals(expected,
                myCalculator.calculate(firstPositiveOperand, zero, '^'));
    }

    @Test
    void calculate_negativeToZero_OK() {
        double expected = 1;
        assertEquals(expected,
                myCalculator.calculate(firstNegativeOperand, zero, '^'));
    }

    @Test
    void calculate_ZeroToPower_OK() {
        double expected = 0;
        assertEquals(expected,
                myCalculator.calculate(zero, firstPositiveOperand, '^'));
    }

    @Test
    void calculate_ZeroToNegativePower_OK() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCalculator.calculate(zero, firstNegativeOperand, '^');
        });
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCalculator.calculate(firstPositiveOperand, secondPositiveOperand, '#');
        });
    }
}
