package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLIER = '*';
    private static final char DIVIDER = '/';
    private static final char POW = '^';
    private static final char ILLEGAL_OPERAND = '@';
    private static final double POSITIVE_VALUE = 2.25;
    private static final double NEGATIVE_VALUE = -3.13;
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0.0;
    private static Calculator calculator;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addition2PositiveOperands_ok() {
        expected = 4.5;
        assertEquals(expected, calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, PLUS), DELTA);
    }

    @Test
    void calculate_additionWith2NegativeOperands_ok() {
        expected = -6.26;
        assertEquals(expected, calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, PLUS), DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_ok() {
        expected = -0.88;
        assertEquals(expected, calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, PLUS), DELTA);
    }

    @Test
    void calculate_additionWithZero_ok() {
        expected = POSITIVE_VALUE;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_VALUE, PLUS));
        expected = NEGATIVE_VALUE;
        assertEquals(expected, calculator.calculate(NEGATIVE_VALUE, ZERO, PLUS));
    }

    @Test
    void calculate_additionWithDoubleMinAndMaxValues_ok() {
        expected = 1.0E-323;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, PLUS));
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, PLUS));
    }

    @Test
    void calculate_subtractionWith2PositiveOperands_ok() {
        expected = ZERO;
        assertEquals(expected, calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MINUS), DELTA);
    }

    @Test
    void calculate_subtractionWith2NegativeOperands_ok() {
        expected = ZERO;
        assertEquals(expected, calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MINUS), DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_ok() {
        expected = 5.38;
        assertEquals(expected, calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MINUS), DELTA);
    }

    @Test
    void calculate_subtractionZero_ok() {
        expected = POSITIVE_VALUE;
        assertEquals(expected, calculator.calculate(POSITIVE_VALUE, ZERO, MINUS));
        expected = NEGATIVE_VALUE * -1;
        assertEquals(expected, calculator.calculate(ZERO, NEGATIVE_VALUE, MINUS));
    }

    @Test
    void calculate_subtractionMaxAndMinValues_ok() {
        expected = ZERO;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS));
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS));
    }

    @Test
    void calculate_multiplicationWith2PositiveValues_ok() {
        expected = 5.0625;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationWith2NegativeValues_ok() {
        expected = 9.7969;
        assertEquals(expected,
                calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_ok() {
        expected = -7.0425;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationWithZero_ok() {
        expected = ZERO;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLIER), DELTA);
        assertEquals(expected,
                calculator.calculate(ZERO, NEGATIVE_VALUE, MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationMinAndMaxValues_ok() {
        expected = ZERO;
        assertEquals(expected,
                calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLIER));
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLIER));
    }

    @Test
    void calculate_division2PositiveValues_ok() {
        expected = 1.0;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVIDER), DELTA);
    }

    @Test
    void calculate_division2NegativeValues_ok() {
        expected = 1.0;
        assertEquals(expected,
                calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVIDER), DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_ok() {
        expected = -0.7188;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVIDER), DELTA);
    }

    @Test
    void calculate_divisionZeroByOperand_Ok() {
        expected = ZERO;
        assertEquals(expected,
                calculator.calculate(ZERO, NEGATIVE_VALUE, DIVIDER), DELTA);
    }

    @Test
    void calculate_divisionByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, ZERO, DIVIDER);
        });
    }

    @Test
    void calculate_divisionMinAndMaxValues_ok() {
        expected = 1.0;
        assertEquals(expected,
                calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVIDER));
        assertEquals(expected,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDER));
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToPositivePower_ok() {
        expected = 6.2002;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, POW), DELTA);
        expected = Double.NaN;
        assertEquals(expected,
                calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, POW), DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToNegativePower_ok() {
        expected = 0.0790;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, POW), DELTA);
        expected = Double.NaN;
        assertEquals(expected,
                calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, POW), DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValuesToZeroPower_ok() {
        expected = 1.0;
        assertEquals(expected,
                calculator.calculate(POSITIVE_VALUE, ZERO, POW));
        assertEquals(expected,
                calculator.calculate(NEGATIVE_VALUE, ZERO, POW));
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        expected = ZERO;
        assertEquals(expected,
                calculator.calculate(ZERO, POSITIVE_VALUE, POW));
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected,
                calculator.calculate(ZERO, NEGATIVE_VALUE, POW));
    }

    @Test
    void calculate_illegalOperand_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ILLEGAL_OPERAND);
            calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_OPERAND);
            calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_OPERAND);
            calculator.calculate(ZERO, NEGATIVE_VALUE, ILLEGAL_OPERAND);
            calculator.calculate(POSITIVE_VALUE, ZERO, ILLEGAL_OPERAND);
        });
    }
}
