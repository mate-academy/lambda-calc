package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JUnitCalculatorTest {
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
    private static JUnitCalculator jUnitCalculator;

    @BeforeAll
    static void createCalculator() {
        jUnitCalculator = new JUnitCalculator();
    }

    @Test
    void calculateSumOfTwoPositiveValue_Ok() {
        double expected = POSITIVE_VALUE + POSITIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumOfTwoNegativeValue_Ok() {
        double expected = NEGATIVE_VALUE + NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected,actual, DELTA);
    }

    @Test
    void calculateSumOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE + NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumOfPositiveValueAndZero_Ok() {
        double expected = POSITIVE_VALUE + ZERO;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
        actual = jUnitCalculator.calculate(ZERO, POSITIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumOfNegativeValueAndZero_Ok() {
        double expected = ZERO + NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(ZERO, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
        actual = jUnitCalculator.calculate(NEGATIVE_VALUE, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumOfTwoMaxAndMinDoubleValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual =
                jUnitCalculator.calculate(Double.MAX_VALUE, Double. MAX_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
        expected = 1.0E-323;
        actual = jUnitCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumOfPositiveAndNegativeNumber_Ok() {
        double expected = POSITIVE_VALUE + NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionOfTwoPositiveValue_Ok() {
        double expected = ZERO;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionOfTwoNegativeValue_Ok() {
        double expected = ZERO;
        double actual = jUnitCalculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE - NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionOfPositiveWithZero_Ok() {
        double expected = POSITIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);
        expected = -POSITIVE_VALUE;
        actual = jUnitCalculator.calculate(ZERO, POSITIVE_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionOfMinAndMax_Ok() {
        double expected = ZERO;
        double actual =
                jUnitCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
        actual = jUnitCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionOfTwoPositiveValue_Ok() {
        double expected = 1.0;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionOfTwoNegativeValue_Ok() {
        double expected = 1.0;
        double actual = jUnitCalculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE / NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionOfPositiveValueAndZero_Ok() {
        double expected = ZERO;
        double actual = jUnitCalculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfValueWithZero_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> jUnitCalculator.calculate(POSITIVE_VALUE, ZERO, DIVISION));
    }

    @Test
    void calculateDivisionOfMinAndMax_Ok() {
        double expected = 1.0;
        double actual = jUnitCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
        actual = jUnitCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationOfTwoPositiveValue_Ok() {
        double expected = POSITIVE_VALUE * POSITIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationOfTwoNegativeValue_Ok() {
        double expected = NEGATIVE_VALUE * NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationOfPositiveAndNegativeValue_Ok() {
        double expected = POSITIVE_VALUE * NEGATIVE_VALUE;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationOfValueWithZero_Ok() {
        double expected = ZERO;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        actual = jUnitCalculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationOfMinAndMax_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual =
                jUnitCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual =
                jUnitCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowerOfTwoPositiveValue_Ok() {
        double expected = Math.pow(POSITIVE_VALUE, POSITIVE_VALUE);
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowerOfTwoNegativeValue_Ok() {
        double expected = Math.pow(NEGATIVE_VALUE, NEGATIVE_VALUE);
        double actual = jUnitCalculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowerOfPositiveAndNegativeValue_Ok() {
        double expected = Math.pow(POSITIVE_VALUE, NEGATIVE_VALUE);
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowerOfValueWithZero_Ok() {
        double expected = 1.0;
        double actual = jUnitCalculator.calculate(POSITIVE_VALUE, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = jUnitCalculator.calculate(ZERO, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowerOfMinAndMax_Ok() {
        double expected = Math.pow(Double.MAX_VALUE, Double.MAX_VALUE);
        double actual =
                jUnitCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
        expected = Math.pow(Double.MIN_VALUE, Double.MIN_VALUE);
        actual = jUnitCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalArgument_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> jUnitCalculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_ARGUMENT));
    }
}
