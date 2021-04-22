package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RISING_TO_POWER = '^';
    private static final char ILLEGAL_SIGN = '@';
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static final double NEGATIVE_VALUE = - 200.114;
    private static final double POSITIVE_VALUE = 300.112;
    private static final double ZERO = 0.0;
    private static final double POSITIVE_POWER = 3.0;
    private static final double Negative_POWER = -3.0;
    private Calculator calculator;
    private double actual;
    private double expected;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    //ADDITION
    @Test
    void positiveNumbersAddition_Ok() {
        expected = POSITIVE_VALUE + POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumbersAddition_Ok() {
        expected = NEGATIVE_VALUE + NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeAndPositiveNumbersAddition_Ok() {
        expected = NEGATIVE_VALUE + POSITIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroAtFirstElementAddition_Ok() {
        expected = POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroAtSecondElementAddition_Ok() {
        expected = POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void maxValueAddition_Ok() {
        expected = MAX_VALUE + POSITIVE_VALUE;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void twoMaxValuesAddition_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(MAX_VALUE, MAX_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void minValueAddition_Ok() {
        expected = POSITIVE_VALUE + MIN_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, MIN_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void positiveNumbersSubtraction_Ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumbersSubtraction_Ok() {
        expected = NEGATIVE_VALUE - NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumberAtFirstSubtraction_OK() {
        expected = NEGATIVE_VALUE - POSITIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumberAtSecondElementSubtraction_OK() {
        expected = POSITIVE_VALUE - NEGATIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroAtFirstElementSubtraction_Ok() {
        expected = ZERO - NEGATIVE_VALUE;
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroAtSecondElementSubtraction_Ok() {
        expected = NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void maxValueSubtraction_Ok() {
        expected = MAX_VALUE - NEGATIVE_VALUE;
        actual = calculator.calculate(MAX_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void minValueSubtraction_Ok() {
        expected = MIN_VALUE - NEGATIVE_VALUE;
        actual = calculator.calculate(MIN_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void positiveNumbersMultiplication_Ok() {
        expected = POSITIVE_VALUE * POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumbersMultiplication_Ok() {
        expected = NEGATIVE_VALUE * NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void positiveAndNegativeElementMultiplication_Ok() {
        expected = POSITIVE_VALUE * NEGATIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroFirstElementMultiplication_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroSecondElementMultiplication_Ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void maxValueMultiplication() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void minValueMultiplication() {
        expected = MIN_VALUE * POSITIVE_VALUE;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void positiveNumbersDivision_Ok() {
        expected = POSITIVE_VALUE / POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumbersDivision_Ok() {
        expected = NEGATIVE_VALUE / NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void positiveAndNegativeElementDivision_Ok() {
        expected = POSITIVE_VALUE / NEGATIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroFirstElementDivision_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroSecondElementDivision_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_VALUE, 0, DIVISION));
    }

    @Test
    void maxValueDivision_Ok() {
        expected = MAX_VALUE / POSITIVE_VALUE;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void minValueDivision_Ok() {
        expected = MIN_VALUE / POSITIVE_VALUE;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void risingPositiveNumberToPositivePower_Ok() {
        expected = Math.pow(POSITIVE_VALUE, POSITIVE_POWER);
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_POWER, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void risingNegativeNumberToPositivePower_Ok() {
        expected = Math.pow(NEGATIVE_VALUE, POSITIVE_POWER);
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_POWER, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void risingPositiveNumberToNegativePower_Ok() {
        expected = Math.pow(POSITIVE_VALUE, Negative_POWER);
        actual = calculator.calculate(POSITIVE_VALUE, Negative_POWER, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void risingNegativeNumberToNegativePower_Ok() {
        expected = Math.pow(NEGATIVE_VALUE, Negative_POWER);
        actual = calculator.calculate(NEGATIVE_VALUE, Negative_POWER, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void risingPositiveNumberToZeroPower_Ok() {
        expected = Math.pow(POSITIVE_VALUE, ZERO);
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void risingNegativeNumberToZeroPower_Ok() {
        expected = Math.pow(NEGATIVE_VALUE, ZERO);
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void risingZeroToPositivePower_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_POWER, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ILLEGAL_SIGN));
    }
}




