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
    private static final double POSITIVE_NUMBER = 29.819;
    private static final double NEGATIVE_NUMBER = -89.513;
    private static final double ZERO = 0.0;
    private final Calculator calculator = new Calculator();
    private double actual;
    private double expected;

    @Test
    void calculate_AdditionWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = 59.638;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithTwoNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = -179.026;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = -59.694;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = -59.694;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroAsFirstAndPositiveNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroAsFirstAndNegativeNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, ADDITION);
        expected = NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroAsSecondAndPositiveNumberAsFirst_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, ADDITION);
        expected = POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroAsSecondAndNegativeNumberAsFirst_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, ADDITION);
        expected = NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithTwoDoubleMaxValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithTwoDoubleMinValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        expected = 1.0E-323;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstMaxAndSecondMinValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithFirstMinAndSecondMaxValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADDITION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMaxValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMaxValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_NUMBER, ADDITION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMinValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = 29.819;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithDoubleMinValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, NEGATIVE_NUMBER, ADDITION);
        expected = -89.513;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = 119.33200000000001;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = -119.33200000000001;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithZeroAsFirstAndPositiveNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, SUBTRACTION);
        expected = -29.819;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithZeroAsFirstAndNegativeNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, SUBTRACTION);
        expected = 89.513;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithZeroAsSecondAndPositiveNumberAsFirst_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, SUBTRACTION);
        expected = POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithZeroAsSecondAndNegativeNumberAsFirst_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, SUBTRACTION);
        expected = NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoDoubleMaxValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoDoubleMinValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithFirstMaxAndSecondMinValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithFirstMinAndSecondMaxValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = -1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithDoubleMaxValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithDoubleMaxValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_NUMBER, SUBTRACTION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithDoubleMinValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = -29.819;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithDoubleMinValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, NEGATIVE_NUMBER, SUBTRACTION);
        expected = 89.513;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = 889.1727609999999;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = 8012.577169000001;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = -2669.1881470000003;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = -2669.1881470000003;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithZeroAsFirstAndPositiveNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithZeroAsFirstAndNegativeNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = -ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithZeroAsSecondAndPositiveNumberAsFirst_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithZeroAsSecondAndNegativeNumberAsFirst_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, MULTIPLICATION);
        expected = -ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoDoubleMaxValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoDoubleMinValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithFirstMaxAndSecondMinValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithFirstMinAndSecondMaxValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithDoubleMaxValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithDoubleMaxValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithDoubleMinValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = 1.5E-322;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithDoubleMinValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = -4.45E-322;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVIDING);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithTwoNegativeNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVIDING);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVIDING);
        expected = -0.33312479751544466;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithFirstNegativeAndSecondPositiveNumbers_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVIDING);
        expected = -3.0018779972500758;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithZeroAsFirstAndPositiveNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVIDING);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithZeroAsFirstAndNegativeNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, DIVIDING);
        expected = -ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithZeroAsSecondAndPositiveNumberAsFirst_Bad() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_NUMBER, ZERO, DIVIDING));
    }

    @Test
    void calculate_DividingWithZeroAsSecondAndNegativeNumberAsFirst_Bad() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(NEGATIVE_NUMBER, ZERO, DIVIDING));
    }

    @Test
    void calculate_DividingWithTwoDoubleMaxValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDING);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithTwoDoubleMinValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVIDING);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithFirstMaxAndSecondMinValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVIDING);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithFirstMinAndSecondMaxValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVIDING);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithDoubleMaxValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, DIVIDING);
        expected = 6.028683506698132E306;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithDoubleMaxValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_NUMBER, DIVIDING);
        expected = -2.008303972453516E306;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithDoubleMinValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, DIVIDING);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DividingWithDoubleMinValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, NEGATIVE_NUMBER, DIVIDING);
        expected = -ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithTwoPositiveNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, RAISING_TO_POWER);
        expected = 9.287717637349725E43;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithTwoNegativeNotIntegerNumbers_Bad() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, RAISING_TO_POWER));
    }

    @Test
    void calculate_RaisingToPowerWithFirstPositiveAndSecondNegativeNumbers_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, RAISING_TO_POWER);
        expected = 1.0320515178709868E-132;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithFirstNegativeAndSecondPositiveNotIntegerNumber_Bad() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, RAISING_TO_POWER));
    }

    @Test
    void calculate_RaisingToPowerWithZeroAsFirstAndPositiveNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, RAISING_TO_POWER);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithZeroAsFirstAndNegativeNumberAsSecond_Good() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, RAISING_TO_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithZeroAsSecondAndPositiveNumberAsFirst_Good() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, RAISING_TO_POWER);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithZeroAsSecondAndNegativeNumberAsFirst_Good() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, RAISING_TO_POWER);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithTwoDoubleMaxValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, RAISING_TO_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithTwoDoubleMinValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, RAISING_TO_POWER);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithFirstMaxAndSecondMinValues_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, RAISING_TO_POWER);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithFirstMinAndSecondMaxValues_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, RAISING_TO_POWER);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithDoubleMaxValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, RAISING_TO_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithDoubleMaxValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_NUMBER, RAISING_TO_POWER);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithDoubleMinValueAndPositiveNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, RAISING_TO_POWER);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingToPowerWithDoubleMinValueAndNegativeNumber_Good() {
        actual = calculator.calculate(Double.MIN_VALUE, NEGATIVE_NUMBER, RAISING_TO_POWER);
        expected = Double.POSITIVE_INFINITY;
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
}
