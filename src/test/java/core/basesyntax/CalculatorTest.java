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
    private static final double INFINITY = 1.0 / 0.0;
    private static final double ZERO = 0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';
    private static final double DELTA = 1e-16;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        assertEquals(calculator.calculate(POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, ADDITION),
                15.0, DELTA);
    }

    @Test
    void additionWithNegativeOperands_Ok() {
        assertEquals(calculator.calculate(
                NEGATIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, ADDITION),-15.0, DELTA);
    }

    @Test
    void additionDifferentOperands_Ok() {
        assertEquals(calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, ADDITION),-5.0, DELTA);
        assertEquals(calculator.calculate(
                NEGATIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, ADDITION),5.0, DELTA);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        assertEquals(calculator.calculate(ZERO, POSITIVE_SECOND_NUMBER, ADDITION),10.0, DELTA);
        assertEquals(calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO, ADDITION),5.0, DELTA);
    }

    @Test
    void additionWithDifferentValue_Ok() {
        assertEquals(0, calculator.calculate(MAX_VALUE, -MAX_VALUE, ADDITION), DELTA);
    }

    @Test
    void additionWithTwoMinValue_Ok() {
        assertEquals(-INFINITY, calculator.calculate(-MAX_VALUE, -MAX_VALUE, ADDITION), DELTA);
    }

    @Test
    void additionWithTwoMaxValue_NotOk() {
        assertEquals(INFINITY, calculator.calculate(MAX_VALUE, MAX_VALUE, ADDITION), DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() {
        assertEquals(-5.0, calculator.calculate(
                POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, SUBTRACTION), DELTA);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() {
        assertEquals(5.0, calculator.calculate(
                NEGATIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, SUBTRACTION), DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        assertEquals(15.0, calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, SUBTRACTION));
    }

    @Test
    void subtractionWithMaxValue_Ok() {
        assertEquals(0, calculator.calculate(
                -MAX_VALUE, -MAX_VALUE, SUBTRACTION));
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() {
        assertEquals(50.0, calculator.calculate(
                POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, MULTIPLICATION), DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        assertEquals(-50.0, calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, MULTIPLICATION), DELTA);
    }

    @Test
    void multiplicationWithPositiveAndZeroOperands_Ok() {
        assertEquals(0, calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO, MULTIPLICATION));
    }

    @Test
    void multiplicationWithMaxAndMinValueOperands_Ok() {
        assertEquals(INFINITY, calculator.calculate(MAX_VALUE, MAX_VALUE, MULTIPLICATION));
        assertEquals(-INFINITY, calculator.calculate(-MAX_VALUE, MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() {
        assertEquals(0.5, calculator.calculate(
                POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, DIVISION));
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        assertEquals(-0.5, calculator.calculate(
                POSITIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, DIVISION));
    }

    @Test
    void divisionWithPositiveAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO, DIVISION));
    }

    @Test
    void divisionWithMaxAndMinValueOperands_Ok() {
        assertEquals(1, calculator.calculate(MAX_VALUE, MAX_VALUE, DIVISION));
        assertEquals(1, calculator.calculate(-MAX_VALUE, -MAX_VALUE, DIVISION));
    }

    @Test
    void raisingPositiveToThePositivePower_Ok() {
        assertEquals(25.0, calculator.calculate(POSITIVE_FIRST_NUMBER, 2,RAISING));
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        assertEquals(25.0, calculator.calculate(NEGATIVE_FIRST_NUMBER, 2,RAISING));
    }

    @Test
    void raisingPositiveToTheNegativePower_Ok() {
        assertEquals(0.04, calculator.calculate(POSITIVE_FIRST_NUMBER, -2,RAISING));
    }

    @Test
    void raisingNegativeToTheNegativePower_Ok() {
        assertEquals(0.04, calculator.calculate(NEGATIVE_FIRST_NUMBER, -2,RAISING));
    }

    @Test
    void raisingToTheZeroPower_Ok() {
        assertEquals(1, calculator.calculate(POSITIVE_FIRST_NUMBER, ZERO,RAISING));
        assertEquals(1, calculator.calculate(NEGATIVE_FIRST_NUMBER, ZERO,RAISING));
        assertEquals(1, calculator.calculate(POSITIVE_SECOND_NUMBER, ZERO,RAISING));
        assertEquals(1, calculator.calculate(NEGATIVE_SECOND_NUMBER, ZERO,RAISING));
        assertEquals(1, calculator.calculate(-MAX_VALUE, ZERO,RAISING));
        assertEquals(1, calculator.calculate(MAX_VALUE, ZERO,RAISING));
    }

    @Test
    void raisingMaxAndMinValueToThePower_NotOk() {
        assertEquals(INFINITY, calculator.calculate(MAX_VALUE,2, RAISING));
        assertEquals(INFINITY, calculator.calculate(-MAX_VALUE,2, RAISING));
    }

    @Test
    void differentOperation_NotOk() {
        assertThrows(IllegalAccessException.class, () ->
                calculator.calculate(POSITIVE_FIRST_NUMBER, POSITIVE_SECOND_NUMBER, '!'));
    }
}
