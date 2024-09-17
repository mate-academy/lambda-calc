package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final char ILLEGAL_ARGUMENT = 'g';
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;
    private static final double POSITIVE_VALUE = 438.004;
    private static final double NEGATIVE_VALUE = -247.036;
    private static Calculator calculator;

    @BeforeAll
    static void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    void calculate_sumOfTwoPositiveValue_Ok() {
        double expected = POSITIVE_VALUE + POSITIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumOfTwoNegativeValue_Ok() {
        double expected = NEGATIVE_VALUE + NEGATIVE_VALUE;
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected,actual, DELTA);
    }

    @Test
    void calculate_sumOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE + NEGATIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumOfPositiveValueAndZero_Ok() {
        double expected = POSITIVE_VALUE + ZERO;
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumOfNegativeValueAndZero_Ok() {
        double expected = ZERO + NEGATIVE_VALUE;
        double actual = calculator.calculate(ZERO, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumOfTwoMaxAndMinDoubleValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual =
                calculator.calculate(Double.MAX_VALUE, Double. MAX_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
        expected = 1.0E-323;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumOfPositiveAndNegativeNumber_Ok() {
        double expected = POSITIVE_VALUE + NEGATIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfTwoPositiveValue_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfTwoNegativeValue_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE - NEGATIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfPositiveWithZero_Ok() {
        double expected = POSITIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);
        expected = -POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionOfMinAndMax_Ok() {
        double expected = ZERO;
        double actual =
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfTwoPositiveValue_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfTwoNegativeValue_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE / NEGATIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfPositiveValueAndZero_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfValueWithZero_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_VALUE, ZERO, DIVISION));
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
    void calculate_multiplicationOfTwoPositiveValue_Ok() {
        double expected = POSITIVE_VALUE * POSITIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoNegativeValue_Ok() {
        double expected = NEGATIVE_VALUE * NEGATIVE_VALUE;
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE * NEGATIVE_VALUE;
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfValueWithZero_Ok() {
        double expected = ZERO;
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfMinAndMax_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual =
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual =
                calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfTwoPositiveValue_Ok() {
        double expected = Math.pow(POSITIVE_VALUE, POSITIVE_VALUE);
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfTwoNegativeValue_Ok() {
        double expected = Math.pow(NEGATIVE_VALUE, NEGATIVE_VALUE);
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfPositiveAndNegativeValue_Ok() {
        double expected = Math.pow(POSITIVE_VALUE, NEGATIVE_VALUE);
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfValueWithZero_Ok() {
        double expected = 1.0;
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfMinAndMax_Ok() {
        double expected = Math.pow(Double.MAX_VALUE, Double.MAX_VALUE);
        double actual =
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
        expected = Math.pow(Double.MIN_VALUE, Double.MIN_VALUE);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalArgument_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_ARGUMENT));
    }
}
