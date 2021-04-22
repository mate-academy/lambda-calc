package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double NUMBER_DIVIDED_BY_NUMBER = 1.0;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static final double NEGATIVE_NUMBER = -347.981;
    private static final double POSITIVE_NUMBER = 543.234;
    private static final double DELTA = 0.0001;
    private static final char ILLEGAL_OPERATOR = '#';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char MINUS = '-';
    private static final char POWER = '^';
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
    void calculate_additionTwoPositiveNumbers_isOk() {
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeNumbers_isOk() {
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveAndNegativeNumbers_isOk() {
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionNumberWithZero_isOk() {
        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinMaxValues_Ok() {
        expected = MAX_VALUE + POSITIVE_NUMBER;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = MIN_VALUE + POSITIVE_NUMBER;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveNumbers_isOk() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoNegativeNumbers_isOk() {
        expected = ZERO;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeNumbers_isOk() {
        expected = POSITIVE_NUMBER - NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionNumberWithZero_isOk() {
        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = -POSITIVE_NUMBER;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinMaxValues_Ok() {
        expected = MAX_VALUE - POSITIVE_NUMBER;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = MIN_VALUE - POSITIVE_NUMBER;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveNumbers_isOk() {
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegativeNumbers_isOk() {
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeNumbers_isOk() {
        expected = POSITIVE_NUMBER * NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationNumberWithZero_isOk() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMinMaxValues_Ok() {
        expected = MAX_VALUE * POSITIVE_NUMBER;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = MIN_VALUE * POSITIVE_NUMBER;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveNumbers_isOk() {
        expected = NUMBER_DIVIDED_BY_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoNegativeNumbers_isOk() {
        expected = NUMBER_DIVIDED_BY_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeNumbers_isOk() {
        expected = POSITIVE_NUMBER / NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionNumberByZero_isOk() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionNumberByZero_isNotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_divisionMinMaxValues_isOk() {
        expected = MAX_VALUE / POSITIVE_NUMBER;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);

        expected = MIN_VALUE / POSITIVE_NUMBER;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumberToPositivePower_isOk() {
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(NEGATIVE_NUMBER, POSITIVE_NUMBER);
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumberToNegativePower_isOk() {
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumberToZeroPower_isOk() {
        expected = Math.pow(POSITIVE_NUMBER, ZERO);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(NEGATIVE_NUMBER, ZERO);
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_isOk() {
        expected = Math.pow(ZERO, POSITIVE_NUMBER);
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(ZERO, NEGATIVE_NUMBER);
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void illegalOperation_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATOR);
            calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATOR);
            calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATOR);
            calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATOR);
        });
    }
}
