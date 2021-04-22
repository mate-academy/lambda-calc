package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double POSITIVE_FIRST_NUMBER = 5.0;
    private static final double POSITIVE_SECOND_NUMBER = 10.0;
    private static final double NEGATIVE_FIRST_NUMBER = -5.0;
    private static final double NEGATIVE_SECOND_NUMBER = -10.0;
    private static final double MAX_VALUE = 1.7976931348623157E308;
    private static final double INFINITY = Double.POSITIVE_INFINITY;
    private static final double ZERO = 0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';
    private static final double DELTA = 1e-16;
    private static final char WRONG_OPERATION = '!';

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        double expected = 15.0;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithNegativeOperands_Ok() {
        double expected = -15.0;
        double actual = calculator.calculate(
                NEGATIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, ADDITION);;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionDifferentOperands_Ok() {
        double expected = -5.0;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, ADDITION);
        assertEquals(expected, actual, DELTA);
        expected = 5.0;
        actual = calculator.calculate(
                NEGATIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        double expected = 10.0;
        double actual = calculator.calculate(ZERO, POSITIVE_SECOND_NUMBER, ADDITION);
        assertEquals(expected, actual, DELTA);
        expected = 5.0;
        actual = calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA);

    }

    @Test
    void additionWithDifferentValue_Ok() {
        double expected = 10.0;
        double actual = calculator.calculate(ZERO, POSITIVE_SECOND_NUMBER, ADDITION);
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calculator.calculate(MAX_VALUE, -MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoMinValue_Ok() {
        double expected = -INFINITY;
        double actual = calculator.calculate(-MAX_VALUE, -MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoMaxValue_NotOk() {
        double expected = INFINITY;
        double actual = calculator.calculate(MAX_VALUE, MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() {
        double expected = -5.0;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() {
        double expected = 5.0;
        double actual = calculator.calculate(
                NEGATIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        double expected = 15.0;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithMaxValue_Ok() {
        double expected = 0;
        double actual = calculator.calculate(
                -MAX_VALUE, -MAX_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() {
        double expected = 50.0;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        double expected = -50.0;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndZeroOperands_Ok() {
        double expected = 0;
        double actual = calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithMaxAndMinValueOperands_Ok() {
        double expected = INFINITY;
        double actual = calculator.calculate(MAX_VALUE, MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        expected = -INFINITY;
        actual = calculator.calculate(-MAX_VALUE, MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() {
        double expected = 0.5;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        double expected = -0.5;
        double actual = calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO, DIVISION));
    }

    @Test
    void divisionWithMaxAndMinValueOperands_Ok() {
        double expected = 1;
        double actual = calculator.calculate(MAX_VALUE, MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
        expected = 1;
        actual = calculator.calculate(-MAX_VALUE, -MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveToThePositivePower_Ok() {
        double expected = 25.0;
        double actual = calculator.calculate(POSITIVE_FIRST_NUMBER, 2,RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        double expected = 25.0;
        double actual = calculator.calculate(NEGATIVE_FIRST_NUMBER, 2,RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveToTheNegativePower_Ok() {
        double expected = 0.04;
        double actual = calculator.calculate(POSITIVE_FIRST_NUMBER, -2,RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeToTheNegativePower_Ok() {
        double expected = 0.04;
        double actual = calculator.calculate(NEGATIVE_FIRST_NUMBER, -2,RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingToTheZeroPower_Ok() {
        double expected = 1;
        double actual = calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO,RAISING);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_FIRST_NUMBER, ZERO,RAISING);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(POSITIVE_SECOND_NUMBER, ZERO,RAISING);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_SECOND_NUMBER, ZERO,RAISING);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-MAX_VALUE, ZERO,RAISING);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(MAX_VALUE, ZERO,RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingMaxAndMinValueToThePower_NotOk() {
        double expected = INFINITY;
        double actual = calculator.calculate(MAX_VALUE,2, RAISING);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-MAX_VALUE,2, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void differentOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(
                        POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, WRONG_OPERATION));
    }
}
