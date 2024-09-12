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
    void calculateAdditionTwoPositiveNumbers_Ok() {
        expected = 10.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);
    }

    @Test
    void calculateAdditionTwoNegativeNumbers_Ok() {
        expected = -10.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);
    }

    @Test
    void calculateAdditionWhenOneArgumentZero_Ok() {
        expected = 5.0;
        actual = calculator.calculate(POSITIVE_NUMBER, 0, ADDITIONAL);
        assertEquals(expected, actual);

        expected = 5.0;
        actual = calculator.calculate(0, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);

        expected = -5.0;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual);

        expected = -5.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, ADDITIONAL);
        assertEquals(expected, actual);

    }

    @Test
    void calculateAdditionMaxValuesAndMinValueWithOther_0k() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual, DELTA);

        expected = 5.0;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, ADDITIONAL);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionTwoPositiveNumbers_Ok() {
        expected = 0.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionTwoNegativeNumbers_Ok() {
        expected = 0.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWhenOneArgumentZero_Ok() {
        expected = 5.0;
        actual = calculator.calculate(POSITIVE_NUMBER, 0, SUBTRACTION);
        assertEquals(expected, actual);

        expected = -5.0;
        actual = calculator.calculate(0, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);

        expected = 5.0;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);

        expected = -5.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, SUBTRACTION);
        assertEquals(expected, actual);

    }

    @Test
    void calculateSubtractionWithMaxValuesAndMinValueandOther_0k() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual, DELTA);

        expected = -5.0;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyTwoPositiveNumbers_Ok() {
        expected = 25.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplyTwoNegativeNumbers_Ok() {
        expected = 25.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplyPositiveAndNegativeNumbers_Ok() {
        expected = -25.0;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);

        expected = -25.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplyWithZero_Ok() {
        expected = 0.0;
        actual = calculator.calculate(POSITIVE_NUMBER, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = -0.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0.0;
        actual = calculator.calculate(0, POSITIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);

        expected = -0.0;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0;
        actual = calculator.calculate(0, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0.0;
        actual = calculator.calculate(Double.MAX_VALUE, 0, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, 0, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivideTwoPositiveNumbers_Ok() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivideTwoNegativeNumbers_Ok() {
        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDividePositiveAndNegativeNumbers_Ok() {
        expected = -1.0;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);

        expected = -1.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateZeroDivideToNumber_Ok() {
        expected = 0.0;
        actual = calculator.calculate(0, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);

        expected = -0.0;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual);

        expected = 0.0;
        actual = calculator.calculate(0, Double.MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);

        expected = 0.0;
        actual = calculator.calculate(0, Double.MIN_VALUE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMaxAndMinValuesDivideToNumber_Ok() {
        expected = 3.5953862697246315E307;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual, DELTA);

        expected = 0.0001;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideToZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, 0, DIVIDE); });
    }

    @Test
    void calculateRaisingToPowerPositiveNumbers_Ok() {
        expected = 3125.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

    }

    @Test
    void calculateRaisingToPowerNegativeNumbers_Ok() {
        expected = -3.2E-4;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateRaisingToPowerPositiveAndNegativeNumbers_Ok() {
        expected = 3.2E-4;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = -3125.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateRaisingToPowerWhenOneValueIsZero_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(0, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = 0.0;
        actual = calculator.calculate(0, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = -1.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, 0, POWER);
        assertEquals(expected, actual, DELTA);

        expected = 1.0;
        actual = calculator.calculate(POSITIVE_NUMBER, 0, POWER);
        assertEquals(expected, actual, DELTA);

        expected = 1.0;
        actual = calculator.calculate(0, 0, POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculateWhenEnteredWrongOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, '!');
            calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, '!');
            calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, '!');
        });
    }
}
