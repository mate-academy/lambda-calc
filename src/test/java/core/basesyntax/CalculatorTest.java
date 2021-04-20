package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double POSITIVE_DOUBLE = 123.456;
    private static final double NEGATIVE_DOUBLE = -654.321;
    private static final int ZERO = 0;
    private static final double DELTA = 0.0001;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char DIVIDER = '/';
    private static final char MULTIPLIER = '*';
    private static final char POW = '^';
    private static final char ILLEGAL_SIGN = '$';
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionTwoPositiveNumbers_isOK() {
        expected = POSITIVE_DOUBLE + POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE, PLUS), DELTA);
    }

    @Test
    void additionTwoNegativeNumbers_isOK() {
        expected = NEGATIVE_DOUBLE + NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE, PLUS), DELTA);
    }

    @Test
    void additionNegativePositive_isOK() {
        expected = NEGATIVE_DOUBLE + POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE, PLUS), DELTA);
        expected = POSITIVE_DOUBLE + NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE, PLUS), DELTA);
    }

    @Test
    void additionZero_isOK() {
        expected = ZERO + POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE, PLUS), DELTA);
        expected = POSITIVE_DOUBLE + ZERO;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO, PLUS), DELTA);
    }

    @Test
    void additionMaxAndMinValues() {
        expected = Double.MAX_VALUE + POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                PLUS), DELTA);
        expected = Double.MIN_VALUE + POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                PLUS), DELTA);
    }

    @Test
    void subtractionTwoPositiveNumbers_isOK() {
        double expected = POSITIVE_DOUBLE - POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void subtractionTwoNegativeNumbers_isOK() {
        double expected = NEGATIVE_DOUBLE - NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void subtractionNegativePositive_isOK() {
        expected = NEGATIVE_DOUBLE - POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                MINUS), DELTA);
        expected = POSITIVE_DOUBLE - NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void subtractionZero_isOK() {
        expected = ZERO - POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                MINUS), DELTA);
        expected = POSITIVE_DOUBLE - ZERO;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO,
                MINUS), DELTA);
    }

    @Test
    void subtractionMaxAndMinValues() {
        expected = Double.MAX_VALUE - POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                MINUS), DELTA);
        expected = Double.MIN_VALUE - POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void multiplicationTwoPositiveNumbers_isOK() {
        double expected = POSITIVE_DOUBLE * POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void multiplicationTwoNegativeNumbers_isOK() {
        double expected = NEGATIVE_DOUBLE * NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void multiplicationNegativePositive_isOK() {
        expected = NEGATIVE_DOUBLE * POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
        expected = POSITIVE_DOUBLE * NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void multiplicationZero_isOK() {
        expected = ZERO * POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
        expected = POSITIVE_DOUBLE * ZERO;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO,
                MULTIPLIER), DELTA);
    }

    @Test
    void multiplicationMaxAndMinValues() {
        expected = Double.MAX_VALUE * POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
        expected = Double.MIN_VALUE * POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void divisionTwoPositiveNumbers_isOK() {
        double expected = POSITIVE_DOUBLE / POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void divisionTwoNegativeNumbers_isOK() {
        double expected = NEGATIVE_DOUBLE / NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void divisionNegativePositive_isOK() {
        expected = NEGATIVE_DOUBLE / POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
        expected = POSITIVE_DOUBLE / NEGATIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void divisionZeroAsFirstValue_isOK() {
        double expected = ZERO / POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void divisionZeroAsSecondValue_isNotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_DOUBLE, ZERO, DIVIDER);
        });
    }

    @Test
    void divisionMaxAndMinValues() {
        expected = Double.MAX_VALUE / POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
        expected = Double.MIN_VALUE / POSITIVE_DOUBLE;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void raisingPositiveNegativeToPositive_isOK() {
        expected = Math.pow(POSITIVE_DOUBLE, POSITIVE_DOUBLE);
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                POW), DELTA);
        expected = Math.pow(NEGATIVE_DOUBLE, POSITIVE_DOUBLE);
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                POW), DELTA);
    }

    @Test
    void raisingPositiveNegativeToNegative_isOK() {
        expected = Math.pow(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE);
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                POW), DELTA);
        expected = Math.pow(POSITIVE_DOUBLE, NEGATIVE_DOUBLE);
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                POW), DELTA);
    }

    @Test
    void raisingPositiveNegativeToZero_isOK() {
        expected = Math.pow(NEGATIVE_DOUBLE, ZERO);
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, ZERO,
                POW), DELTA);
        expected = Math.pow(POSITIVE_DOUBLE, ZERO);
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO,
                POW), DELTA);
    }

    @Test
    void raisingZero_isOK() {
        expected = Math.pow(ZERO, NEGATIVE_DOUBLE);
        assertEquals(expected, calculator.calculate(ZERO, NEGATIVE_DOUBLE,
                POW), DELTA);
        expected = Math.pow(ZERO, POSITIVE_DOUBLE);
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                POW), DELTA);
    }

    @Test
    void illegalOperation_isNotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE, ILLEGAL_SIGN);
            calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE, ILLEGAL_SIGN);
            calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE, ILLEGAL_SIGN);
            calculator.calculate(ZERO, POSITIVE_DOUBLE, ILLEGAL_SIGN);
        });
    }
}
