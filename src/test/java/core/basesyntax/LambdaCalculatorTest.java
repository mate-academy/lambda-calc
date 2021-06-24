package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static final double FIRST_POSITIVE = 34.2;
    private static final double SECOND_POSITIVE = 23.4;
    private static final double FIRST_NEGATIVE = -34.2;
    private static final double SECOND_NEGATIVE = -23.4;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static LambdaCalculator lambdaCalculator;

    @BeforeAll
    static void beforeAll() {
        lambdaCalculator = new LambdaCalculator();
    }

    @Test
    void calculate_addingTwoPositive_Ok() {
        double expected = FIRST_POSITIVE + SECOND_POSITIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingTwoNegative_Ok() {
        double expected = FIRST_NEGATIVE + SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingPositiveAndNegative_Ok() {
        double expected = FIRST_POSITIVE + SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingZero_Ok() {
        double expected = ZERO + SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(ZERO, SECOND_NEGATIVE, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = FIRST_POSITIVE + ZERO;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingMinAndPositiveValues_Ok() {
        double expected = Double.MIN_VALUE + FIRST_POSITIVE;
        double actual = lambdaCalculator.calculate(Double.MIN_VALUE, FIRST_POSITIVE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingMaxAndNegativeValues_Ok() {
        double expected = Double.MAX_VALUE + FIRST_NEGATIVE;
        double actual = lambdaCalculator.calculate(Double.MAX_VALUE, FIRST_NEGATIVE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractingTwoPositive_Ok() {
        double expected = FIRST_POSITIVE - SECOND_POSITIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractingTwoNegative_Ok() {
        double expected = FIRST_NEGATIVE - SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractingPositiveAndNegative_Ok() {
        double expected = FIRST_POSITIVE - SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractingZero_Ok() {
        double expected = ZERO - SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(ZERO, SECOND_NEGATIVE, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = FIRST_POSITIVE - ZERO;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractingMinAndPositiveDoubleValues_Ok() {
        double expected = Double.MIN_VALUE - SECOND_POSITIVE;
        double actual = lambdaCalculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractingMaxAndNegativeDoubleValues_Ok() {
        double expected = Double.MAX_VALUE - SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingPositives_Ok() {
        double expected = FIRST_POSITIVE * SECOND_POSITIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingNegatives_Ok() {
        double expected = FIRST_NEGATIVE * SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingPositiveAndNegative_Ok() {
        double expected = FIRST_POSITIVE * SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingZero_Ok() {
        double expected = FIRST_POSITIVE * ZERO;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = ZERO * SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(ZERO, SECOND_NEGATIVE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingMaxAndMinValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = lambdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = ZERO;
        actual = lambdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingPositives_Ok() {
        double expected = FIRST_POSITIVE / SECOND_POSITIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingNegatives_Ok() {
        double expected = FIRST_NEGATIVE / SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingPositiveAndNegative_Ok() {
        double expected = FIRST_POSITIVE / SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingZero_Ok() {
        double expected = ZERO / SECOND_POSITIVE;
        double actual = lambdaCalculator.calculate(ZERO, SECOND_POSITIVE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingByZero_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, DIVISION));
    }

    @Test
    void calculate_dividingMaxAndMinValues() {
        double expected = Double.MAX_VALUE / SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE, DIVISION);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE / SECOND_POSITIVE;
        actual = lambdaCalculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingToPositive_Ok() {
        double expected = Math.pow(FIRST_POSITIVE, SECOND_POSITIVE);
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(FIRST_NEGATIVE, SECOND_POSITIVE);
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingToNegative_Ok() {
        double expected = Math.pow(FIRST_POSITIVE, SECOND_NEGATIVE);
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(FIRST_NEGATIVE, SECOND_NEGATIVE);
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingToZero_Ok() {
        double expected = Math.pow(FIRST_POSITIVE, ZERO);
        double actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(FIRST_NEGATIVE, ZERO);
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower() {
        double expected = Math.pow(ZERO, FIRST_POSITIVE);
        double actual = lambdaCalculator.calculate(ZERO, FIRST_POSITIVE, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(ZERO, FIRST_NEGATIVE);
        actual = lambdaCalculator.calculate(ZERO, FIRST_NEGATIVE, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_checkTheOperator_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> lambdaCalculator.calculate(FIRST_NEGATIVE, FIRST_POSITIVE, '&'));
    }
}
