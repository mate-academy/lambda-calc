package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVIDING = '/';
    private static final char RAISING_TO_POWER = '^';
    private static final char ILLEGAL_OPERATOR = 's';
    private static final double POSITIVE_NUMBER = 25.379;
    private static final double NEGATIVE_NUMBER = -89.6479;
    private static final double ZERO = 0.0;
    private static final double DOUBLE_MAX_VALUE = Double.MAX_VALUE;
    private static final double DOUBLE_MIN_VALUE = Double.MIN_VALUE;
    private final Calculator calculator = new Calculator();
    private double actual;
    private double expected;

    @Test
    void calculate_AdditionWithPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = POSITIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVIDING);
        expected = POSITIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, RAISING_TO_POWER);
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithTwoNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVIDING);
        expected = NEGATIVE_NUMBER / NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithTwoNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, RAISING_TO_POWER);
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = POSITIVE_NUMBER - NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = POSITIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVIDING);
        expected = POSITIVE_NUMBER / NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, RAISING_TO_POWER);
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = NEGATIVE_NUMBER + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVIDING);
        expected = NEGATIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, RAISING_TO_POWER);
        expected = Math.pow(NEGATIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionByZeroPositiveNumber_Bad() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_NUMBER, ZERO, DIVIDING));
    }

    @Test
    void calculate_DivisionByZeroNegativeNumber_Bad() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(NEGATIVE_NUMBER, ZERO, DIVIDING));
    }

    @Test
    void calculate_ZeroDivide_Good() {
        actual = calculator.calculate(0, 50, DIVIDING);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingZeroToPositivePower_Good() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, RAISING_TO_POWER);
        expected = Math.pow(ZERO, POSITIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingZeroToNegativePower_Good() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, RAISING_TO_POWER);
        expected = Math.pow(ZERO, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_InvalidInputOperationWithDifferentNumbersPosition_Bad() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATOR));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATOR));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATOR));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATOR));
    }

    @Test
    void calculate_AdditionWithZeroAsFirstAndPositiveNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, ADDITION);
        expected = ZERO + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroAsFirstAndNegativeNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, ADDITION);
        expected = ZERO + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroAsSecondAndPositiveNumberAsFirst_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, ADDITION);
        expected = POSITIVE_NUMBER + ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroAsSecondAndNegativeNumberAsFirst_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, ADDITION);
        expected = NEGATIVE_NUMBER + ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithTwoDoubleMaxValues_Good() {
        actual = calculator.calculate(DOUBLE_MAX_VALUE, DOUBLE_MAX_VALUE, ADDITION);
        expected = DOUBLE_MAX_VALUE + DOUBLE_MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithTwoDoubleMinValues_Good() {
        actual = calculator.calculate(DOUBLE_MIN_VALUE, DOUBLE_MIN_VALUE, ADDITION);
        expected = DOUBLE_MIN_VALUE + DOUBLE_MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstMaxAndSecondMinValues_Good() {
        actual = calculator.calculate(DOUBLE_MAX_VALUE, DOUBLE_MIN_VALUE, ADDITION);
        expected = DOUBLE_MAX_VALUE + DOUBLE_MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstMinAndSecondMaxValues_Good() {
        actual = calculator.calculate(DOUBLE_MIN_VALUE, DOUBLE_MAX_VALUE, ADDITION);
        expected = DOUBLE_MIN_VALUE + DOUBLE_MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMaxValueAndPositiveNumber_Good() {
        actual = calculator.calculate(DOUBLE_MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = DOUBLE_MAX_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMaxValueAndNegativeNumber_Good() {
        actual = calculator.calculate(DOUBLE_MAX_VALUE, NEGATIVE_NUMBER, ADDITION);
        expected = DOUBLE_MAX_VALUE + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMinValueAndPositiveNumber_Good() {
        actual = calculator.calculate(DOUBLE_MIN_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = DOUBLE_MIN_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMinValueAndNegativeNumber_Good() {
        actual = calculator.calculate(DOUBLE_MIN_VALUE, NEGATIVE_NUMBER, ADDITION);
        expected = DOUBLE_MIN_VALUE + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

}
