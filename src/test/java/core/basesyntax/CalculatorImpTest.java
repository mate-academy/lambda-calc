package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImpTest {
    private static final double POSITIVE_NUMBER1 = 2.65;
    private static final double POSITIVE_NUMBER2 = 17.35;
    private static final double NEGATIVE_NUMBER1 = -2.65;
    private static final double NEGATIVE_NUMBER2 = -17.35;
    private static final double DELTA = 0.000001;
    private static final double ZERO = 0;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final char ILLEGAL_OPERATION = '#';
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImp();
    }

    @Test
    void calculate_AddTwoPositiveNumbers_Ok() {
        double expected = 20;
        double actual = calculator.calculate(POSITIVE_NUMBER1, POSITIVE_NUMBER2, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AddTwoNegativeNumbers_Ok() {
        double expected = -20;
        double actual = calculator.calculate(NEGATIVE_NUMBER1, NEGATIVE_NUMBER2, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AddTwoDifferentNumbers_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER1, POSITIVE_NUMBER1, PLUS);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_AddZeroToNumberFirst_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER1, PLUS);
        assertEquals(POSITIVE_NUMBER1, actual);
    }

    @Test
    void calculate_AddZeroToNumberSecond_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER1, ZERO, PLUS);
        assertEquals(POSITIVE_NUMBER1, actual);
    }

    @Test
    void calculate_AddTwoMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, PLUS);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_AddTwoMinDoubleValues_Ok() {
        double expected = 1.0E-323;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AddMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, PLUS);
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_SubtractTwoPositiveNumbers_Ok() {
        double expected = -14.7;
        double actual = calculator.calculate(POSITIVE_NUMBER1, POSITIVE_NUMBER2, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_SubtractTwoNegativeNumbers_Ok() {
        double expected = 14.7;
        double actual = calculator.calculate(NEGATIVE_NUMBER1, NEGATIVE_NUMBER2, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_SubtractTwoDifferentNumbers_Ok() {
        double expected = -5.3;
        double actual = calculator.calculate(NEGATIVE_NUMBER1, POSITIVE_NUMBER1, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractZeroToNumberFirst_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER1, MINUS);
        assertEquals(NEGATIVE_NUMBER1, actual);
    }

    @Test
    void calculate_SubtractZeroToNumberSecond_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER1, ZERO, MINUS);
        assertEquals(POSITIVE_NUMBER1, actual);
    }

    @Test
    void calculate_SubtractTwoMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_SubtractTwoMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_SubtractMinAndMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE * -1;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractMaxAndMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MINUS);
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_MultiplyTwoPositiveNumbers_Ok() {
        double expected = 45.9775;
        double actual = calculator.calculate(POSITIVE_NUMBER1, POSITIVE_NUMBER2, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplyTwoNegativeNumbers_Ok() {
        double expected = 45.9775;
        double actual = calculator.calculate(NEGATIVE_NUMBER1, NEGATIVE_NUMBER2, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplyTwoDifferentNumbers_Ok() {
        double expected = -45.9775;
        double actual = calculator.calculate(NEGATIVE_NUMBER1, POSITIVE_NUMBER2, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplyZeroToNumberFirst_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER1, MULTIPLICATION);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_MultiplyZeroToNumberSecond_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER1, ZERO, MULTIPLICATION);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_MultiplyTwoMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_MultiplyTwoMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_MultiplyMinAndMaxDoubleValues_Ok() {
        double expected = 8.881784197001251E-16;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplyMaxAndMinDoubleValues_Ok() {
        double expected = 8.881784197001251E-16;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivideTwoPositiveNumbers_Ok() {
        double expected = 0.152737;
        double actual = calculator.calculate(POSITIVE_NUMBER1, POSITIVE_NUMBER2, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_DivideTwoNegativeNumbers_Ok() {
        double expected = 0.152737;
        double actual = calculator.calculate(NEGATIVE_NUMBER1, NEGATIVE_NUMBER2, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_DivideTwoDifferentNumbers_Ok() {
        double expected = -6.547169;
        double actual = calculator.calculate(NEGATIVE_NUMBER2, POSITIVE_NUMBER1, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_DivideZeroToNumberFirst_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER1, DIVISION);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_DivideZeroToNumberSecond_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER1, ZERO, DIVISION));
    }

    @Test
    void calculate_DivideTwoMaxDoubleValues_Ok() {
        double expected = 1;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivideTwoMinDoubleValues_Ok() {
        double expected = 1;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivideMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_DivideMaxAndMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_RaisePositiveNumberToPositivePower_Ok() {
        double expected = 1923.727793;
        double actual = calculator.calculate(POSITIVE_NUMBER2, POSITIVE_NUMBER1, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_RaiseNegativeNumberToPositivePower_Ok() {
        double expected = -1923.727793;
        double actual = calculator.calculate(NEGATIVE_NUMBER2, POSITIVE_NUMBER1, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_RaisePositiveNumberToNegativePower_Ok() {
        double expected = 0.000519;
        double actual = calculator.calculate(POSITIVE_NUMBER2, NEGATIVE_NUMBER1, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_RaiseNegativeNumberToNegativePower_Ok() {
        double expected = -0.000519;
        double actual = calculator.calculate(NEGATIVE_NUMBER2, NEGATIVE_NUMBER1, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_RaisePositiveNumberToZeroPower_Ok() {
        double expected = 1;
        double actual = calculator.calculate(POSITIVE_NUMBER2, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_RaiseNegativeNumberToZeroPower_Ok() {
        double expected = -1;
        double actual = calculator.calculate(NEGATIVE_NUMBER2, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_RaiseZeroToPower_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER2, POWER);
        assertEquals(ZERO, actual);
    }

    @Test
    void calculate_IllegalOperation_NotOK() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(POSITIVE_NUMBER1, POSITIVE_NUMBER2, ILLEGAL_OPERATION));
    }
}
