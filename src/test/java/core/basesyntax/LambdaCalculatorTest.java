package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;

class LambdaCalculatorTest {
    private static final double FIRST_POSITIVE = 34.2;
    private static final double SECOND_POSITIVE = 23.4;
    private static final double FIRST_NEGATIVE = -34.2;
    private static final double SECOND_NEGATIVE = -23.4;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;
    private static LambdaCalculator lambdaCalculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        lambdaCalculator = new LambdaCalculator();
    }

    void addingTwoPositive_Ok() {
        expected = FIRST_POSITIVE + SECOND_POSITIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '+');
        assertEquals(expected, actual);
    }

    void addingTwoNegative_Ok() {
        expected = FIRST_NEGATIVE + SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '+');
        assertEquals(expected, actual);
    }

    void addingPositiveAndNegative_Ok() {
        expected = FIRST_POSITIVE + SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '+');
        assertEquals(expected, actual);
    }

    void addingZero_Ok() {
        expected = ZERO + SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(ZERO, SECOND_NEGATIVE, '+');
        assertEquals(expected, actual);

        expected = FIRST_POSITIVE + ZERO;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, '+');
        assertEquals(expected, actual);
    }

    void addingMinAndPositiveValues_Ok() {
        double expected = Double.MIN_VALUE + FIRST_POSITIVE;
        double actual = lambdaCalculator.calculate(Double.MIN_VALUE, FIRST_POSITIVE, '+');
        assertEquals(expected, actual, DELTA);
    }

    void addingMaxAndNegativeValues_Ok() {
        double expected = Double.MAX_VALUE + FIRST_NEGATIVE;
        double actual = lambdaCalculator.calculate(Double.MAX_VALUE, FIRST_NEGATIVE, '+');
        assertEquals(expected, actual, DELTA);
    }

    void substractingTwoPositive_Ok() {
        expected = FIRST_POSITIVE - SECOND_POSITIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '-');
        assertEquals(expected, actual);
    }

    void substractingTwoNegative_Ok() {
        expected = FIRST_NEGATIVE - SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '-');
        assertEquals(expected, actual);
    }

    void substractingPositiveAndNegative_Ok() {
        expected = FIRST_POSITIVE - SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '-');
        assertEquals(expected, actual);
    }

    void substractingZero_Ok() {
        expected = ZERO - SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(ZERO, SECOND_NEGATIVE, '-');
        assertEquals(expected, actual);

        expected = FIRST_POSITIVE - ZERO;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, '-');
        assertEquals(expected, actual);
    }

    void substractingMinAndPositiveDoubleValues_Ok() {
        double expected = Double.MIN_VALUE - SECOND_POSITIVE;
        double actual = lambdaCalculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE, '-');
        assertEquals(expected, actual, DELTA);
    }

    void substractingMaxAndNegativeDoubleValues_Ok() {
        double expected = Double.MAX_VALUE - SECOND_NEGATIVE;
        double actual = lambdaCalculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE, '-');
        assertEquals(expected, actual, DELTA);
    }

    void multiplyingPositives_Ok() {
        expected = FIRST_POSITIVE * SECOND_POSITIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '*');
        assertEquals(expected, actual);
    }

    void multiplyingNegatives_Ok() {
        expected = FIRST_NEGATIVE * SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '*');
        assertEquals(expected, actual);
    }

    void multiplyingPositiveAndNegative_Ok() {
        expected = FIRST_POSITIVE * SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '*');
        assertEquals(expected, actual);
    }

    void multiplyingZero_Ok() {
        expected = FIRST_POSITIVE * ZERO;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, '*');
        assertEquals(expected, actual);

        expected = ZERO * SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(ZERO, SECOND_NEGATIVE, '*');
        assertEquals(expected, actual);
    }

    void multiplyingMaxAndMinValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA);

        expected = ZERO;
        actual = lambdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    void dividingPositives_Ok() {
        expected = FIRST_POSITIVE / SECOND_POSITIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '/');
        assertEquals(expected, actual);
    }

    void dividingNegatives_Ok() {
        expected = FIRST_NEGATIVE / SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '/');
        assertEquals(expected, actual);
    }

    void dividingPositiveAndNegative_Ok() {
        expected = FIRST_POSITIVE / SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '/');
        assertEquals(expected, actual);
    }

    void dividingZero_Ok() {
        expected = ZERO / SECOND_POSITIVE;
        actual = lambdaCalculator.calculate(ZERO, SECOND_POSITIVE, '/');
        assertEquals(expected, actual);
    }

    void dividingByZero_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, '/'));
    }

    void dividingMaxAndMinValues() {
        expected = Double.MAX_VALUE / SECOND_NEGATIVE;
        actual = lambdaCalculator.calculate(Double.MAX_VALUE, SECOND_NEGATIVE, '/');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE / SECOND_POSITIVE;
        actual = lambdaCalculator.calculate(Double.MIN_VALUE, SECOND_POSITIVE, '/');
        assertEquals(expected, actual, DELTA);
    }

    void raisingToPositive_Ok() {
        expected = Math.pow(FIRST_POSITIVE, SECOND_POSITIVE);
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '^');
        assertEquals(expected, actual);

        expected = Math.pow(FIRST_NEGATIVE, SECOND_POSITIVE);
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '^');
        assertEquals(expected, actual);
    }

    void raisingToNegative_Ok() {
        expected = Math.pow(FIRST_POSITIVE, SECOND_NEGATIVE);
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '^');
        assertEquals(expected, actual);

        expected = Math.pow(FIRST_NEGATIVE, SECOND_NEGATIVE);
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '^');
        assertEquals(expected, actual);
    }

    void raisingToZero_Ok() {
        expected = Math.pow(FIRST_POSITIVE, ZERO);
        actual = lambdaCalculator.calculate(FIRST_POSITIVE, ZERO, '^');
        assertEquals(expected, actual);

        expected = Math.pow(FIRST_NEGATIVE, ZERO);
        actual = lambdaCalculator.calculate(FIRST_NEGATIVE, ZERO, '^');
        assertEquals(expected, actual);
    }

    void raisingZeroToPower() {
        expected = Math.pow(ZERO, FIRST_POSITIVE);
        actual = lambdaCalculator.calculate(ZERO, FIRST_POSITIVE, '^');
        assertEquals(expected, actual);

        expected = Math.pow(ZERO, FIRST_NEGATIVE);
        actual = lambdaCalculator.calculate(ZERO, FIRST_NEGATIVE, '^');
        assertEquals(expected, actual);
    }

    void checkTheOperator_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> lambdaCalculator.calculate(FIRST_NEGATIVE, FIRST_POSITIVE, '1'));
    }
}
