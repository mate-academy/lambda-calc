package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char BAD_OPERAND = '#';
    private static final double NEGATIVE_VALUE = -1997.444;
    private static final double POSITIVE_VALUE = 2020.224;
    private static final double DELTA = 0.0001;

    private static final char MULTIPLIER = '*';
    private static final char DIVISOR = '/';
    private static final char POWER = '^';
    private static final char MINUS = '-';
    private static final char PLUS = '+';
    private static final double ZERO = 0;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionTwoPositiveNumbers_Ok() {
        expected = 4040.448;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionTwoNegativeNumbers_Ok() {
        expected = -3994.888;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionPositiveAndNegativeNumbers_Ok() {
        expected = 22.779999999999973;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionNumberWithZero_Ok() {
        expected = POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionMinMaxValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = 2020.224;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionTwoPositiveNumbers_Ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionTwoNegativeNumbers_Ok() {
        expected = ZERO;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionPositiveAndNegativeNumbers_Ok() {
        expected = 4017.6679999999997;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionNumberWithZero_Ok() {
        expected = POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = -POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionMinMaxValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = -2020.224;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationTwoPositiveNumbers_Ok() {
        expected = 4081305.0101759997;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationTwoNegativeNumbers_Ok() {
        expected = 3989782.533136;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationPositiveAndNegativeNumbers_Ok() {
        expected = -4035284.307456;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationNumberWithZero_Ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLIER);
        assertEquals(expected, actual, DELTA);

        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationMinMaxValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, MULTIPLIER);
        assertEquals(expected, actual, DELTA);

        expected = 2.683E-321;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionTwoPositiveNumbers_Ok() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionTwoNegativeNumbers_Ok() {
        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionPositiveAndNegativeNumbers_Ok() {
        expected = -1.0114045750469098;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionNumberByZero_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionNumberByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, ZERO, DIVISOR);
        });
    }

    @Test
    void divisionMinMaxValues_Ok() {
        expected = 8.898484202060345E304;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, DIVISOR);
        assertEquals(expected, actual, DELTA);

        expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, DIVISOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNumberToPositivePower_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNumberToNegativePower_Ok() {
        expected = 0.0;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNumberToZeroPower_Ok() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, POWER);
        assertEquals(expected, actual, DELTA);

        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroToPower_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, BAD_OPERAND);
            calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, BAD_OPERAND);
            calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, BAD_OPERAND);
            calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, BAD_OPERAND);
        });
    }
}