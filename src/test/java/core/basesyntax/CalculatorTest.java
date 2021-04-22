package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RISING_TO_POWER = '^';
    private static final char ILLEGAL_SIGN = '@';
    private static final double NEGATIVE_VALUE = - 200.114;
    private static final double POSITIVE_VALUE = 300.112;
    private static final double ZERO = 0.0;
    private static final double ONE = 1.0;
    private static final double POSITIVE_POWER = 3.0;
    private static final double Negative_POWER = -3.0;
    private static Calculator calculator;
    private static double delta;
    private double actual;
    private double expected;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
        delta = 0.0001;
    }

    @Test
    void positiveNumbersAddition_Ok() {
        expected = 600.224;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumbersAddition_Ok() {
        expected = -400.228;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeAndPositiveNumbersAddition_Ok() {
        expected = 99.998;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void zeroAtFirstElementAddition_Ok() {
        expected = 300.112;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void zeroAtSecondElementAddition_Ok() {
        expected = 300.112;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void maxValueAddition_Ok() {
        expected = Double.MAX_VALUE + 300.112;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void twoMaxValuesAddition_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void minValueAddition_Ok() {
        expected = 300.112 + Double.MIN_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, ADDITION);
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
        expected = ZERO;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumberAtFirstSubtraction_OK() {
        expected = -500.226;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void negativeNumberAtSecondElementSubtraction_OK() {
        expected = 500.226;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void zeroAtFirstElementSubtraction_Ok() {
        expected = 200.114;
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
        expected = Double.MAX_VALUE - (-200.114);
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void minValueSubtraction_Ok() {
        expected = Double.MIN_VALUE - (-200.114);
        actual = calculator.calculate(Double.MIN_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void positiveNumbersMultiplication_Ok() {
        expected = 90067.2125;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void negativeNumbersMultiplication_Ok() {
        expected = 40045.6129;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void positiveAndNegativeElementMultiplication_Ok() {
        expected = - 60056.6127;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, delta);
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
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void minValueMultiplication() {
        expected = Double.MIN_VALUE * 300.112;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void positiveNumbersDivision_Ok() {
        expected = ONE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void negativeNumbersDivision_Ok() {
        expected = ONE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void positiveAndNegativeElementDivision_Ok() {
        expected = -1.4997;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, delta);
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
        expected = Double.MAX_VALUE / 300.112;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void minValueDivision_Ok() {
        expected = Double.MIN_VALUE / 300.112;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, delta);
    }

    @Test
    void risingPositiveNumberToPositivePower_Ok() {
        expected = 2.7030251291004933E7;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_POWER, RISING_TO_POWER);
        assertEquals(expected, actual, delta);
    }

    @Test
    void risingNegativeNumberToPositivePower_Ok() {
        expected = -8013687.799;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_POWER, RISING_TO_POWER);
        assertEquals(expected, actual, delta);
    }

    @Test
    void risingPositiveNumberToNegativePower_Ok() {
        expected = 3.699558650913385E-8;
        actual = calculator.calculate(POSITIVE_VALUE, Negative_POWER, RISING_TO_POWER);
        assertEquals(expected, actual, delta);
    }

    @Test
    void risingNegativeNumberToNegativePower_Ok() {
        expected = -1.2478649344370651E-7;
        actual = calculator.calculate(NEGATIVE_VALUE, Negative_POWER, RISING_TO_POWER);
        assertEquals(expected, actual, delta);
    }

    @Test
    void risingPositiveNumberToZeroPower_Ok() {
        expected = ONE;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, RISING_TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void risingNegativeNumberToZeroPower_Ok() {
        expected = ONE;
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
