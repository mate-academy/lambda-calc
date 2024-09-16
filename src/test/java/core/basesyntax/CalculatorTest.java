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
    private static final char ILLEGAL_OPERATION = '!';
    private static final double POSITIVE_DIGIT = 7.2;
    private static final double NEGATIVE_DIGIT = -3.5;
    private static final double DELTA = 000.1;
    private static final double ZERO_DIGIT = 0;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, POSITIVE_DIGIT, PLUS);
        expected = 14.4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, NEGATIVE_DIGIT, PLUS);
        expected = -7;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, POSITIVE_DIGIT, PLUS);
        expected = 3.7;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, ZERO_DIGIT, PLUS);
        expected = 7.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO_DIGIT, NEGATIVE_DIGIT, PLUS);
        expected = -3.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_DIGIT, PLUS);
        expected = Double.MAX_VALUE + 7.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_DIGIT, PLUS);
        expected = Double.MIN_VALUE + 7.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, POSITIVE_DIGIT, MINUS);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, NEGATIVE_DIGIT, MINUS);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, POSITIVE_DIGIT, MINUS);
        expected = -10.7;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, ZERO_DIGIT, MINUS);
        expected = 7.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO_DIGIT, NEGATIVE_DIGIT, MINUS);
        expected = 3.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_DIGIT, MINUS);
        expected = Double.MAX_VALUE - 7.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_DIGIT, MINUS);
        expected = Double.MIN_VALUE - 7.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, POSITIVE_DIGIT, MULTIPLICATION);
        expected = 51.84;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, NEGATIVE_DIGIT, MULTIPLICATION);
        expected = 12.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, POSITIVE_DIGIT, MULTIPLICATION);
        expected = -25.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, ZERO_DIGIT, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO_DIGIT, NEGATIVE_DIGIT, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_DIGIT, MULTIPLICATION);
        expected = Double.MAX_VALUE * 7.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_DIGIT, MULTIPLICATION);
        expected = Double.MIN_VALUE * 7.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, POSITIVE_DIGIT, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, NEGATIVE_DIGIT, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, POSITIVE_DIGIT, DIVISION);
        expected = -0.48611111111;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAtFirstPosition_Ok() {
        actual = calculator.calculate(ZERO_DIGIT, NEGATIVE_DIGIT, DIVISION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAtSecondPosition_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_DIGIT, ZERO_DIGIT, DIVISION);
        });
    }

    @Test
    void divisionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_DIGIT, DIVISION);
        expected = Double.MAX_VALUE / 7.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_DIGIT, DIVISION);
        expected = Double.MIN_VALUE / 7.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, POSITIVE_DIGIT, POWER);
        expected = Math.pow(7.2, 7.2);
        assertEquals(expected, actual);

        actual = calculator.calculate(NEGATIVE_DIGIT, POSITIVE_DIGIT, POWER);
        expected = Math.pow(-3.5, 7.2);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveOrNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(POSITIVE_DIGIT, NEGATIVE_DIGIT, POWER);
        expected = Math.pow(7.2, -3.5);
        assertEquals(expected, actual);

        actual = calculator.calculate(NEGATIVE_DIGIT, NEGATIVE_DIGIT, POWER);
        expected = Math.pow(-3.5, -3.5);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveOrNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(NEGATIVE_DIGIT, ZERO_DIGIT, POWER);
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(POSITIVE_DIGIT, ZERO_DIGIT, POWER);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        actual = calculator.calculate(ZERO_DIGIT, POSITIVE_DIGIT, POWER);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_DIGIT, NEGATIVE_DIGIT, ILLEGAL_OPERATION);
        });
    }
}
