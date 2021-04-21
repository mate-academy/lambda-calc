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
    void calculate_additionTwoPositiveNumbers_isOK() {
        expected = 246.912;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE, PLUS), DELTA);
    }

    @Test
    void calculate_additionTwoNegativeNumbers_isOK() {
        expected = -1308.642;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE, PLUS), DELTA);
    }

    @Test
    void calculate_additionNegativePositive_isOK() {
        expected = -530.865;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE, PLUS), DELTA);
        expected = -530.865;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE, PLUS), DELTA);
    }

    @Test
    void calculate_additionZero_isOK() {
        expected = 123.456;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE, PLUS), DELTA);
        expected = 123.456;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO, PLUS), DELTA);
    }

    @Test
    void calculate_additionMaxAndMinValues() {
        expected = 1.7976931348623157E308;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                PLUS), DELTA);
        expected = 123.456;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                PLUS), DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveNumbers_isOK() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionTwoNegativeNumbers_isOK() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionNegativePositive_isOK() {
        expected = -777.777;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                MINUS), DELTA);
        expected = 777.777;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionZero_isOK() {
        expected = -123.456;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                MINUS), DELTA);
        expected = 123.456;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionMaxAndMinValues() {
        expected = 1.7976931348623157E308;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                MINUS), DELTA);
        expected = -123.456;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                MINUS), DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveNumbers_isOK() {
        expected = 15241.383936;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegativeNumbers_isOK() {
        expected = 428135.97104100004;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationNegativePositive_isOK() {
        expected = -80779.853376;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
        expected = -80779.853376;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationZero_isOK() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO,
                MULTIPLIER), DELTA);
    }

    @Test
    void calculate_multiplicationMaxAndMinValues() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
        expected = 6.1E-322;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                MULTIPLIER), DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveNumbers_isOK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void calculate_divisionTwoNegativeNumbers_isOK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void calculate_divisionNegativePositive_isOK() {
        expected = -5.30003402021773;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
        expected = -0.18867803417588613;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void calculate_divisionZeroAsFirstValue_isOK() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void calculate_divisionZeroAsSecondValue_isNotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_DOUBLE, ZERO, DIVIDER);
        });
    }

    @Test
    void calculate_divisionMaxAndMinValues() {
        expected = 1.4561407585393303E306;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_DOUBLE,
                DIVIDER), DELTA);
    }

    @Test
    void calculate_raisingPositiveNegativeToPositive_isOK() {
        expected = 1.6208034937136549E258;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE,
                POW), DELTA);
        expected = Double.NaN;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE,
                POW), DELTA);
    }

    @Test
    void calculate_raisingPositiveNegativeToNegative_isOK() {
        expected = Double.NaN;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, NEGATIVE_DOUBLE,
                POW), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE,
                POW), DELTA);
    }

    @Test
    void calculate_raisingPositiveNegativeToZero_isOK() {
        expected = 1.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_DOUBLE, ZERO,
                POW), DELTA);
        expected = Math.pow(POSITIVE_DOUBLE, ZERO);
        assertEquals(expected, calculator.calculate(POSITIVE_DOUBLE, ZERO,
                POW), DELTA);
    }

    @Test
    void calculate_raisingZero_isOK() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(ZERO, NEGATIVE_DOUBLE,
                POW), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_DOUBLE,
                POW), DELTA);
    }

    @Test
    void calculate_illegalOperation_isNotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_DOUBLE, POSITIVE_DOUBLE, ILLEGAL_SIGN);
            calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_DOUBLE, ILLEGAL_SIGN);
            calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_DOUBLE, ILLEGAL_SIGN);
            calculator.calculate(ZERO, POSITIVE_DOUBLE, ILLEGAL_SIGN);
        });
    }
}
