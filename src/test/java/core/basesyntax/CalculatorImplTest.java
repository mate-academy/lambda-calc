package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double delta = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void createCalculatorInstance() {
        calculator = new CalculatorImpl();
    }

    @Test
    void addition_positive_numbersOk() {
        double first = 5;
        double second = 7;
        char action = '+';
        double actual = calculator.calculate(first, second, action);
        double expected = 12;
        assertEquals(expected, actual,
                "wrong result with positive numbers, expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void addition_Negative_numbersOk() {
        double first = -8;
        double second = -5;
        char action = '+';
        double expected = -13;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "wrong result with negative numbers, expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void addition_oneNegative_numberOk() {
        double first = -8;
        double second = 6.3;
        char action = '+';
        double expected = -1.7;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta,
                "wrong result with negative numbers, expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void addition_zeroNumOk() {
        double first = 41;
        double second = 0;
        char action = '+';
        double expected = 41;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with zero. Expected: "
                        + expected + ", but was: " + actual);
        assertEquals(expected, actual,
                "Wrong result with zero. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void addition_positive_maxValuesOk() {
        double first = Double.MAX_VALUE;
        double second = 741;
        char action = '+';
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with MaxValue. Expected: "
                        + expected + " , but was: " + actual);
    }

    @Test
    void addiction_maxAndMinValuesOk() {
        double first = Double.MIN_VALUE;
        double second = 56;
        char action = '+';
        double expected = 56;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with MinValue. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void defaultChar_actionNotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(13, 28, '\u0000'));
    }

    @Test
    void subtraction_twoPositiveNumsOk() {
        double first = 43;
        double second = 28.1;
        char action = '-';
        double expected = 14.9;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta,
                "Wrong result with positive numbers. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_twoNegativeNumsOk() {
        double first = -32;
        double second = -21;
        char action = '-';
        double expected = -11;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with negative numbers. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_oneNegativeNumOk() {
        double first = -53;
        double second = 23;
        char action = '-';
        double expected = -76;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with one negative number. Expected: " + expected
                        + ", but was: " + actual);
    }

    @Test
    void subtraction_zeroNumOk() {
        double first = 0;
        double second = 38;
        char action = '-';
        double expected = -38;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with 1st zero. Expected: "
                        + expected + ", but was: " + actual);
        expected = 38;
        actual = calculator.calculate(second, first, action);
        assertEquals(expected, actual,
                "Wrong result with 2nd zero. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_minValueOk() {
        double first = Double.MIN_VALUE;
        double second = 98;
        char action = '-';
        double expected = -98;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with MinValue. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void subtraction_oneMaxValueOk() {
        double first = Double.MAX_VALUE;
        double second = 21345;
        char action = '-';
        double expected = 1.7976931348623157E308;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with MaxValue. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void multiply_positiveNumsOk() {
        double first = 4;
        double second = 8;
        char action = '*';
        double expected = 32;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with positive numbers. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_negativeNumsOk() {
        double first = -4;
        double second = -6.7;
        char action = '*';
        double expected = 26.8;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta,
                "Wrong result with negative numbers. Expected: "
                        + expected + ", but was: " + actual);
    }

    @Test
    void multiply_oneNegativeNumOk() {
        double first = -6;
        double second = 10;
        char action = '*';
        double expected = -60;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with one negative number. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_byZeroOk() {
        double first = 24;
        double second = 0;
        char action = '*';
        double expected = 0;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual,
                "Wrong result with zero. Expected: " + expected + ", but was: " + actual);
        actual = calculator.calculate(second, first, action);
        assertEquals(expected, actual, "Wrong result with zero. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_maxValueOk() {
        double first = Double.MAX_VALUE;
        double second = 35;
        char action = '*';
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, "Wrong result with MaxValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void multiply_minValuesOk() {
        double first = Double.MIN_VALUE;
        double second = 23;
        char action = '*';
        double expected = 1.14E-322;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, "Wrong result with MinValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_positiveNumsOk() {
        double first = 3;
        double second = 9;
        char action = '/';
        double expected = 0.3333333333333333;
        double actual = calculator.calculate(first, second,action);
        assertEquals(expected, actual, delta, "Wrong result with positive numbers. Expected: "
                + expected + ", but was: " + actual);

    }

    @Test
    void division_byZeroNotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(4, 0, '/'));
    }

    @Test
    void division_negativeNumsOk() {
        double first = -5;
        double second = -4;
        char action = '/';
        double expected = 1.25;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta, "Wrong result with negative numbers. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_oneNegitiveNumOk() {
        double first = 32;
        double second = -8;
        char action = '/';
        double expected = -4;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, "Wrong result with one negative number. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_MaxNumsOk() {
        double first = 53;
        double second = Double.MAX_VALUE;
        char action = '/';
        double expected = 2.9482228625220422E-307;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta, "Wrong result with MaxValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void division_minValueOk() {
        double first = 48;
        double second = Double.MIN_VALUE;
        char action = '/';
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, "Wrong result with MinValue. Expected: "
                + expected + ", but was: " + actual);
    }

    @Test
    void raisingToPower_PositivePowerOk() {
        double first = -3;
        double second = 5;
        char action = '^';
        double expected = -243;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, "Wrong result with positive number to positive power."
                + " Expected: " + expected + ", but was: " + actual);
        actual = calculator.calculate(-first, second, action);
        assertEquals(-expected, actual, "Wrong result with negative number to positive power. "
                + "Expected: " + expected + ", but was: " + actual);
    }

    @Test
    void infinityValuesNotOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '/'));
    }

    @Test
    void negativeInfinityValuesNotOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '/'));
    }

    @Test
    void raisingToPower_negativePowerOk() {
        double first = 5;
        double second = -7;
        char action = '^';
        double expected = 1.28E-5;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, "Wrong result with positive number to negative power. "
                + "Expected: " + expected + ", but was: " + actual);
        expected = -1.28E-5;
        actual = calculator.calculate(-first, second, action);
        assertEquals(expected, actual, "Wrong result with negative number to negative power. "
                + "Expected: " + expected + ", but was: " + actual);
    }

    @Test
    void raisingToPower_zeroToPowerOk() {
        double first = 0;
        double second = 12;
        char action = '^';
        double expected = 0;
        double actual = calculator.calculate(first, second,action);
        assertEquals(expected, actual, "Wrong result with zero to power. "
                + "Expected:" + expected + ", but was: " + actual);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(first, -second, action);
        assertEquals(expected, actual, "Wrong result with zero to a negative power. "
                + "Expected: " + expected + ", but was:" + actual);
    }

    @Test
    void raisingToPower_zeroPowerOk() {
        double first = 80;
        double second = 0;
        char action = '^';
        double expected = 1;
        double actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, "Wrong result with raising to a zero. "
                + "Expected:" + expected + ", but was:" + actual);
    }
}
