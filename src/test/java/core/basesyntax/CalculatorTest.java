package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double POSITIVE_NUMBER = 253.0093;
    private static final double NEGATIVE_NUMBER = -137.057;
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final char ILLEGAL_ARGUMENT = 'g';
    private static Calculator calculator;

    @BeforeAll
    static void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    void calculate_summationOfTwoPositiveNumber_Ok() {
        double expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_summationOfTwoNegativeNumber_Ok() {
        double expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        double actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_summationOfPositiveAndNegativeNumber_Ok() {
        double expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_summationOfNumberWithZero_Ok() {
        double expected = POSITIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_summationOfMinAndMax_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
        expected = 1.0E-323;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfTwoPositiveNumber_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfTwoNegativeNumber_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveAndNegativeNumber_Ok() {
        double expected = POSITIVE_NUMBER - NEGATIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfNumberWithZero_Ok() {
        double expected = POSITIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);
        expected = -POSITIVE_NUMBER;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinAndMax_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfTwoPositiveNumber_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfTwoNegativeNumber_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfPositiveAndNegativeNumber_Ok() {
        double expected = POSITIVE_NUMBER / NEGATIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfPositiveNumberAndZero_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfNumberWithZero_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    void calculate_divisionOfMinAndMax_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoPositiveNumber_Ok() {
        double expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoNegativeNumber_Ok() {
        double expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        double actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfPositiveAndNegativeNumber_Ok() {
        double expected = POSITIVE_NUMBER * NEGATIVE_NUMBER;
        double actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfNumberWithZero_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinAndMax_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfTwoPositiveNumber_Ok() {
        double expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        double actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfTwoNegativeNumber_Ok() {
        double expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        double actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfPositiveAndNegativeNumber_Ok() {
        double expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        double actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfNumberWithZero_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfMinAndMax_Ok() {
        double expected = Math.pow(Double.MAX_VALUE, Double.MAX_VALUE);
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
        expected = Math.pow(Double.MIN_VALUE, Double.MIN_VALUE);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalArgument_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_ARGUMENT));
    }
}
