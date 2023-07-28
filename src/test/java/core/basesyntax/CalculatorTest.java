package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.00001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionOfTwoPositiveNumbers_OK() {
        assertEquals(13.0, calculator.calculate(5.0, 8.0, '+'), DELTA);
        assertEquals(105.293, calculator.calculate(5.293, 100.0, '+'), DELTA);
        assertEquals(9.023, calculator.calculate(1.0, 8.023, '+'), DELTA);
        assertEquals(8.024, calculator.calculate(0.001, 8.023, '+'), DELTA);
    }

    @Test
    void calculate_additionOfTwoNegativeDoubleNumbers_OK() {
        assertEquals(-123.0, calculator.calculate(-10.0, -113.0, '+'), DELTA);
        assertEquals(-215.0, calculator.calculate(-102.0, -113.0, '+'), DELTA);
        assertEquals(-299.190, calculator.calculate(-200.1, -99.090, '+'), DELTA);
        assertEquals(-13.0, calculator.calculate(-10.0, -3.0, '+'), DELTA);
    }

    @Test
    void calculate_additionOfNegativeAndPositiveNumbers_OK() {
        assertEquals(103.0, calculator.calculate(-10.0, 113.0, '+'), DELTA);
        assertEquals(-99.9999, calculator.calculate(14.0, -113.9999, '+'), DELTA);
        assertEquals(-887.09, calculator.calculate(-1000.09, 113.0, '+'), DELTA);
        assertEquals(87.99, calculator.calculate(200.99, -113.0, '+'), DELTA);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_OK() {
        assertEquals(10, calculator.calculate(10, 0, '+'), DELTA);
        assertEquals(-10.02, calculator.calculate(-10.02, 0, '+'), DELTA);
        assertEquals(100.20, calculator.calculate(0, 100.20, '+'), DELTA);
        assertEquals(-123.321, calculator.calculate(0, -123.321, '+'), DELTA);
        assertEquals(0, calculator.calculate(0, 0, '+'), DELTA);
    }

    @Test
    void calculate_additionOfMinAndMaxValues_OK() {
        assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'), DELTA);
        assertEquals(1.0E-323,
                calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+'), DELTA);
    }

    @Test
    void calculate_subtractionOfTwoNegativeDoubleNumbers_OK() {
        assertEquals(103.0, calculator.calculate(-10.0, -113.0, '-'), DELTA);
        assertEquals(11.0, calculator.calculate(-102.0, -113.0, '-'), DELTA);
        assertEquals(-101.1, calculator.calculate(-200.1, -99.0, '-'), DELTA);
        assertEquals(-7.0, calculator.calculate(-10.0, -3.0, '-'), DELTA);
    }

    @Test
    void calculate_subtractionOfNegativeAndPositiveNumbers_OK() {
        assertEquals(-123.0, calculator.calculate(-10.0, 113.0, '-'), DELTA);
        assertEquals(127.9999, calculator.calculate(14.0, -113.9999, '-'), DELTA);
        assertEquals(-1113.09, calculator.calculate(-1000.09, 113.0, '-'), DELTA);
        assertEquals(313.99, calculator.calculate(200.99, -113.0, '-'), DELTA);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_OK() {
        assertEquals(10, calculator.calculate(10, 0, '-'), DELTA);
        assertEquals(-10.02, calculator.calculate(-10.02, 0, '-'), DELTA);
        assertEquals(-100.20, calculator.calculate(0, 100.20, '-'), DELTA);
        assertEquals(123.321, calculator.calculate(0, -123.321, '-'), DELTA);
        assertEquals(0, calculator.calculate(0, 0, '-'), DELTA);
    }

    @Test
    void calculate_subtractionOfMinAndMaxValues_OK() {
        assertEquals(0, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'), DELTA);
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'), DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoPositiveNumbers_OK() {
        assertEquals(40.0, calculator.calculate(5.0, 8.0, '*'), DELTA);
        assertEquals(529.3, calculator.calculate(5.293, 100.0, '*'), DELTA);
        assertEquals(8.023, calculator.calculate(1.0, 8.023, '*'), DELTA);
        assertEquals(0.008022, calculator.calculate(8.023, 0.001, '*'), DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoNegativeDoubleNumbers_OK() {
        assertEquals(1130.0, calculator.calculate(-10.0, -113.0, '*'), DELTA);
        assertEquals(11526.0, calculator.calculate(-102.0, -113.0, '*'), DELTA);
        assertEquals(19819.8, calculator.calculate(-200.2, -99.0, '*'), DELTA);
        assertEquals(30.0, calculator.calculate(-10.0, -3.0, '*'), DELTA);
    }

    @Test
    void calculate_multiplicationOfNegativeAndPositiveNumbers_OK() {
        assertEquals(-1130.0, calculator.calculate(-10.0, 113.0, '*'), DELTA);
        assertEquals(-1595.9986, calculator.calculate(14.0, -113.9999, '*'), DELTA);
        assertEquals(-113010.17, calculator.calculate(-1000.09, 113.0, '*'), DELTA);
        assertEquals(-22711.87, calculator.calculate(200.99, -113.0, '*'), DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_OK() {
        assertEquals(0, calculator.calculate(10, 0, '*'), DELTA);
        assertEquals(0, calculator.calculate(-10.02, 0, '*'), DELTA);
        assertEquals(0, calculator.calculate(0, 100.20, '*'), DELTA);
        assertEquals(0, calculator.calculate(0, -123.321, '*'), DELTA);
        assertEquals(0, calculator.calculate(0, 0, '*'), DELTA);
    }

    @Test
    void calculate_multiplicationOfMinAndMaxValues_OK() {
        assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'), DELTA);
        assertEquals(0,
                calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*'), DELTA);
    }

    @Test
    void calculate_divisionOfTwoPositiveNumbers_OK() {
        assertEquals(0.625, calculator.calculate(5.0, 8.0, '/'), DELTA);
        assertEquals(0.05293, calculator.calculate(5.293, 100.0, '/'), DELTA);
        assertEquals(0.125, calculator.calculate(1.0, 8.0, '/'), DELTA);
        assertEquals(8023, calculator.calculate(8.023, 0.001, '/'), DELTA);
    }

    @Test
    void calculate_divisionOfTwoNegativeDoubleNumbers_OK() {
        assertEquals(10.3, calculator.calculate(-103.0, -10.0, '/'), DELTA);
        assertEquals(1.0, calculator.calculate(-102.0, -102.0, '/'), DELTA);
        assertEquals(2.0, calculator.calculate(-200.0, -100.0, '/'), DELTA);
        assertEquals(2.5, calculator.calculate(-10.0, -4.0, '/'), DELTA);
    }

    @Test
    void calculate_divisionOfNegativeAndPositiveNumbers_OK() {
        assertEquals(-10.3, calculator.calculate(-103.0, 10.0, '/'), DELTA);
        assertEquals(-1.0, calculator.calculate(102.0, -102.0, '/'), DELTA);
        assertEquals(-2.0, calculator.calculate(200.0, -100.0, '/'), DELTA);
        assertEquals(-2.5, calculator.calculate(-10.0, 4.0, '/'), DELTA);
    }

    @Test
    void calculate_divisionWithZeroInSecondPosition_NotOK() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(23.0, 0, '/'));
    }

    @Test
    void calculate_divisionWithZeroInFirstPosition_OK() {
        assertEquals(0, calculator.calculate(0.0, 12.0, '/'), DELTA);
    }

    @Test
    void calculate_divisionOfMinAndMaxValues_OK() {
        assertEquals(1, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'), DELTA);
        assertEquals(1, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/'), DELTA);
    }

    @Test
    void calculate_raisingPositiveNumberToPositivePower_OK() {
        assertEquals(1, calculator.calculate(1, 89.0, '^'), DELTA);
        assertEquals(32, calculator.calculate(2, 5.0, '^'), DELTA);
        assertEquals(512, calculator.calculate(4, 4.5,'^'), DELTA);
        assertEquals(2, calculator.calculate(8, 1.0 / 3, '^'), DELTA);
        assertEquals(3.0, calculator.calculate(81, 1.0 / 4, '^'), DELTA);
    }

    @Test
    void calculate_raisingPositiveNumberToNegativeNumber_OK() {
        assertEquals(1, calculator.calculate(1, -89.0, '^'), DELTA);
        assertEquals(0.125, calculator.calculate(2, -3, '^'));
        assertEquals(0.5, calculator.calculate(4, -1.0 / 2, '^'));
    }

    @Test
    void calculate_raisingNegativeNumberToPositiveNumber_OK() {
        assertEquals(-2187.0, calculator.calculate(-3, 7, '^'), DELTA);
        assertEquals(6561.0, calculator.calculate(-3, 8, '^'), DELTA);
    }

    @Test
    void calculate_raisingNumbersToPowerZero_OK() {
        assertEquals(1, calculator.calculate(3482093, 0, '^'), DELTA);
        assertEquals(1, calculator.calculate(-3341, 0, '^'), DELTA);
    }

    @Test
    void calculate_illegalOperation_NotOK() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(23910390, 3920920, '&'));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(23910390, 3920920, '.'));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(23910390, 3920920, '0'));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(23910390, 3920920, '_'));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(23910390, 3920920, 'a'));
    }
}
