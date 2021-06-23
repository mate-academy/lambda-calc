package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class LambdaCalculatorTest {
    private static final double FIRST_POSITIVE = 34.2;
    private static final double SECOND_POSITIVE = 23.4;
    private static final double FIRST_NEGATIVE = -34.2;
    private static final double SECOND_NEGATIVE = -23.4;
    private static final double ZERO = 0;
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

    void addingPositiveAndNegaive_Ok() {
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

//    void addingMinAndMaxDoubleValues_Ok() {
//        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
//        double actual = lambdaCalculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
//    }

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

    void substractingPositiveAndNegaive_Ok() {
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

//    void substractingMinAndMaxDoubleValues_Ok() {
//        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
//        double actual = lambdaCalculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
//    }

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

//    void multiplyingMaxAndMinValues_Ok() {
//        expected = FIRST_POSITIVE * SECOND_NEGATIVE;
//        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '*');
//        assertEquals(expected, actual);
//    }

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

//    void dividingMaxAndMinValues() {
//        expected = FIRST_POSITIVE / SECOND_POSITIVE;
//        actual = lambdaCalculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '/');
//        assertEquals(expected, actual);
//    }

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

    void checkTheOperator() {
        assertThrows(IllegalArgumentException.class,
                () -> lambdaCalculator.calculate(FIRST_NEGATIVE, FIRST_POSITIVE, '1'));
    }









}