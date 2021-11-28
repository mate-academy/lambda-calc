package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double DELTA = 0.0001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVISION = '/';
    private static final char RAISING_TO_POWER = '^';
    private static Calculator calculator;

    @BeforeAll
    static void createCalculatorInstance() {
        calculator = new CalculatorImpl();
    }

    @Test
    void addition_positive_numbers_Ok() {
        double actual = calculator.calculate(5, 7, ADDITION);
        double expected = 12;
        assertEquals(expected, actual,
                "wrong result with positive numbers, expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void addition_Negative_numbers_Ok() {
        double expected = -13;
        double actual = calculator.calculate(-8, -5, ADDITION);
        assertEquals(expected, actual,
                "wrong result with negative numbers, expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void addition_oneNegative_number_Ok() {
        double expected = -1.7;
        double actual = calculator.calculate(-8, 6.3, ADDITION);
        assertEquals(expected, actual, DELTA,
                "wrong result with negative numbers, expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void addition_zeroNum_Ok() {
        double expected = 41;
        double actual = calculator.calculate(41, 0, ADDITION);
        assertEquals(expected, actual,
                "Wrong result with zero. Expected: "
                        + expected + ", but was: " + actual);
        expected = 53;
        actual = calculator.calculate(0, 53, ADDITION);
        assertEquals(expected, actual,
                "Wrong result with zero. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void addition_positive_maxValues_Ok() {
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, 741, ADDITION);
        assertEquals(expected, actual,
                "Wrong result with MaxValue. Expected: "
                        + expected + " , but was: " + actual);
    }

    @Test
    void addiction_maxAndMinValues_Ok() {
        double expected = 56;
        double actual = calculator.calculate(Double.MIN_VALUE, 56, ADDITION);
        assertEquals(expected, actual,
                "Wrong result with MinValue. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void defaultChar_action_NotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(13, 28, '\u0000'));
    }

    @Test
    void subtraction_twoPositiveNums_Ok() {
        double expected = 14.9;
        double actual = calculator.calculate(43, 28.1, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                "Wrong result with positive numbers. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_twoNegativeNums_Ok() {
        double expected = -11;
        double actual = calculator.calculate(-32, -21, SUBTRACTION);
        assertEquals(expected, actual,
                "Wrong result with negative numbers. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_oneNegativeNum_Ok() {
        double expected = -76;
        double actual = calculator.calculate(-53, 23, SUBTRACTION);
        assertEquals(expected, actual,
                "Wrong result with one negative number. Expected: " + expected
                        + ", but was: " + actual);
    }

    @Test
    void subtraction_zeroNum_Ok() {
        double expected = -38;
        double actual = calculator.calculate(0, 38, SUBTRACTION);
        assertEquals(expected, actual,
                "Wrong result with 1st zero. Expected: "
                        + expected + ", but was: " + actual);
        expected = 45;
        actual = calculator.calculate(45, 0, SUBTRACTION);
        assertEquals(expected, actual,
                "Wrong result with 2nd zero. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_minValue_Ok() {
        double expected = -98;
        double actual = calculator.calculate(Double.MIN_VALUE, 98, SUBTRACTION);
        assertEquals(expected, actual,
                "Wrong result with MinValue. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_oneMaxValue_Ok() {
        double expected = 1.7976931348623157E308;
        double actual = calculator.calculate(Double.MAX_VALUE, 21345, SUBTRACTION);
        assertEquals(expected, actual,
                "Wrong result with MaxValue. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void multiply_positiveNums_Ok() {
        double expected = 32;
        double actual = calculator.calculate(4, 8, MULTIPLY);
        assertEquals(expected, actual,
                "Wrong result with positive numbers. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_negativeNums_Ok() {
        double expected = 26.8;
        double actual = calculator.calculate(-4, -6.7, MULTIPLY);
        assertEquals(expected, actual, DELTA,
                "Wrong result with negative numbers. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void multiply_oneNegativeNum_Ok() {
        double expected = -60;
        double actual = calculator.calculate(-6, 10, MULTIPLY);
        assertEquals(expected, actual,
                "Wrong result with one negative number. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_byZero_Ok() {
        double expected = 0;
        double actual = calculator.calculate(24, 0, MULTIPLY);
        assertEquals(expected, actual,
                "Wrong result with zero. Expected: " + expected + ", but was: " + actual);
        actual = calculator.calculate(0, 56, MULTIPLY);
        assertEquals(expected, actual, "Wrong result with zero. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_maxValue_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, 35, MULTIPLY);
        assertEquals(expected, actual, "Wrong result with MaxValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_minValues_Ok() {
        double expected = 1.14E-322;
        double actual = calculator.calculate(Double.MIN_VALUE, 23, MULTIPLY);
        assertEquals(expected, actual, "Wrong result with MinValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_positiveNums_Ok() {
        double expected = 0.3333333333333333;
        double actual = calculator.calculate(3, 9,DIVISION);
        assertEquals(expected, actual, DELTA, "Wrong result with positive numbers. Expected: "
                + expected + ", but was: " + actual);

    }

    @Test
    void division_byZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(4, 0, '/'));
    }

    @Test
    void division_negativeNums_Ok() {
        double expected = 1.25;
        double actual = calculator.calculate(-5, -4, DIVISION);
        assertEquals(expected, actual, DELTA, "Wrong result with negative numbers. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_oneNegitiveNum_Ok() {
        double expected = -4;
        double actual = calculator.calculate(32, -8, DIVISION);
        assertEquals(expected, actual, "Wrong result with one negative number. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_MaxNums_Ok() {
        double expected = 2.9482228625220422E-307;
        double actual = calculator.calculate(53, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA, "Wrong result with MaxValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_minValue_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(48, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, "Wrong result with MinValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void raisingToPower_PositivePower_Ok() {
        double expected = -243;
        double actual = calculator.calculate(-3, 5, RAISING_TO_POWER);
        assertEquals(expected, actual, "Wrong result with positive number to positive power."
                + " Expected: " + expected + ", but was: " + actual);
        actual = calculator.calculate(3, 5, RAISING_TO_POWER);
        assertEquals(-expected, actual, "Wrong result with negative number to positive power. "
                + "Expected: " + expected + ", but was: " + actual);
    }

    @Test
    void infinityValues_NotOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '/'));
    }

    @Test
    void negativeInfinityValues_NotOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '/'));
    }

    @Test
    void raisingToPower_negativePower_Ok() {
        double expected = 1.28E-5;
        double actual = calculator.calculate(5, -7, RAISING_TO_POWER);
        assertEquals(expected, actual, "Wrong result with positive number to negative power. "
                + "Expected: " + expected + ", but was: " + actual);
        expected = -1.28E-5;
        actual = calculator.calculate(-5, -7, RAISING_TO_POWER);
        assertEquals(expected, actual, "Wrong result with negative number to negative power. "
                + "Expected: " + expected + ", but was: " + actual);
    }

    @Test
    void raisingToPower_zeroToPower_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 12,RAISING_TO_POWER);
        assertEquals(expected, actual, "Wrong result with zero to power. "
                + "Expected:" + expected + ", but was: " + actual);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(0, -12, RAISING_TO_POWER);
        assertEquals(expected, actual, "Wrong result with zero to a negative power. "
                + "Expected: " + expected + ", but was:" + actual);
    }

    @Test
    void raisingToPower_zeroPower_Ok() {
        double expected = 1;
        double actual = calculator.calculate(80, 0, RAISING_TO_POWER);
        assertEquals(expected, actual, "Wrong result with raising to a zero. "
                + "Expected:" + expected + ", but was:" + actual);
    }
}
