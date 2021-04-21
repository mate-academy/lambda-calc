package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITIONAL = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POWER = '^';
    private static final double POSITIVE_NUMBER = 5.0;
    private static final double NEGATIVE_NUMBER = -5.0;
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionalTwoPositiveNumbers_Ok() {
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);
    }

    @Test
    void additionalTwoNegativeNumbers_Ok() {
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);
    }

    @Test
    void additionalWhenOneArgumentZero_Ok() {
        expected = POSITIVE_NUMBER + 0;
        actual = calculator.calculate(POSITIVE_NUMBER, 0, ADDITIONAL);
        assertEquals(expected, actual);

        expected = 0 + POSITIVE_NUMBER;
        actual = calculator.calculate(0, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);

        expected = 0 + NEGATIVE_NUMBER;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);

        expected = NEGATIVE_NUMBER + 0;
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, ADDITIONAL);
        assertEquals(expected, actual);

    }

    @Test
    void additionalMaxValuesAndMinValueWithOther_0k() {
        expected = Double.MAX_VALUE + POSITIVE_NUMBER;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE + POSITIVE_NUMBER;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionTwoPositiveNumbers_Ok() {
        expected = POSITIVE_NUMBER - POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoNegativeNumbers_Ok() {
        expected = NEGATIVE_NUMBER - NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWhenOneArgumentZero_Ok() {
        expected = POSITIVE_NUMBER - 0;
        actual = calculator.calculate(POSITIVE_NUMBER, 0, SUBTRACTION);
        assertEquals(expected, actual);

        expected = 0 - POSITIVE_NUMBER;
        actual = calculator.calculate(0, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);

        expected = 0 - NEGATIVE_NUMBER;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);

        expected = NEGATIVE_NUMBER - 0;
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, SUBTRACTION);
        assertEquals(expected, actual);

    }

    @Test
    void subtractionWithMaxValuesAndMinValueandOther_0k() {
        expected = Double.MAX_VALUE - POSITIVE_NUMBER;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE - POSITIVE_NUMBER;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyTwoPositiveNumbers_Ok() {
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoNegativeNumbers_Ok() {
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyPositiveAndNegativeNumbers_Ok() {
        expected = POSITIVE_NUMBER * NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);

        expected = NEGATIVE_NUMBER * POSITIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyWithZero_Ok() {
        expected = POSITIVE_NUMBER * 0;
        actual = calculator.calculate(POSITIVE_NUMBER, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = NEGATIVE_NUMBER * 0;
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0 * POSITIVE_NUMBER;
        actual = calculator.calculate(0, POSITIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0 * NEGATIVE_NUMBER;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0;
        actual = calculator.calculate(0, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = Double.MAX_VALUE * 0;
        actual = calculator.calculate(Double.MAX_VALUE, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = Double.MIN_VALUE * 0;
        actual = calculator.calculate(Double.MIN_VALUE, 0, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoPositiveNumbers_Ok() {
        expected = POSITIVE_NUMBER / POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoNegativeNumbers_Ok() {
        expected = NEGATIVE_NUMBER / NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void dividePositiveAndNegativeNumbers_Ok() {
        expected = POSITIVE_NUMBER / NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);

        expected = NEGATIVE_NUMBER / POSITIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void zeroDivideToNumber_Ok() {
        expected = 0 / POSITIVE_NUMBER;
        actual = calculator.calculate(0, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);

        expected = 0 / NEGATIVE_NUMBER;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);

        expected = 0 / Double.MAX_VALUE;
        actual = calculator.calculate(0, Double.MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);

        expected = 0 / Double.MIN_VALUE;
        actual = calculator.calculate(0, Double.MIN_VALUE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void maxAndMinValuesDivideToNumber_Ok() {
        expected = Double.MAX_VALUE / POSITIVE_NUMBER;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE / POSITIVE_NUMBER;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideToZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, 0, DIVIDE); });
    }

    @Test
    void raisingToPowerPositiveNumbers_Ok() {
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

    }

    @Test
    void raisingToPowerNegativeNumbers_Ok() {
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingToPowerPositiveAndNegativeNumbers_Ok() {
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(NEGATIVE_NUMBER, POSITIVE_NUMBER);
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingToPowerWhenOneValueIsZero_Ok() {
        expected = Math.pow(0, NEGATIVE_NUMBER);
        actual = calculator.calculate(0, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(0, POSITIVE_NUMBER);
        actual = calculator.calculate(0, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(NEGATIVE_NUMBER, 0);
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(POSITIVE_NUMBER, 0);
        actual = calculator.calculate(POSITIVE_NUMBER, 0, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(0,0);
        actual = calculator.calculate(0, 0, POWER);
        assertEquals(expected, actual);
    }

    @Test
    void enteredWrongOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, '!');
            calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, '!');
            calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, '!');
        });
    }
}
