package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.00001;
    private static Calculator calculator;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(1000.05, 100.05, 'a');
        assertEquals(1100.1, actual);
    }

    @Test
    void calculate_additionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-1000.05, -100.05, 'a');
        assertEquals(-1100.1, actual);
    }

    @Test
    void calculate_additionNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(0.000049, -0.00005, 'a');
        assertEquals(0.0, actual, DELTA);
        actual = calculator.calculate(-0.000049, 0.00005, 'a');
        assertEquals(0.0, actual, DELTA);
    }

    @Test
    void calculate_additionWithZero_isOk() {
        actual = calculator.calculate(20.5555555, 0.0, 'a');
        assertEquals(20.5555555, actual);
        actual = calculator.calculate(0.0, -20.5555555, 'a');
        assertEquals(-20.5555555, actual);
    }

    @Test
    void calculate_additionMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MIN_VALUE, 1.0, 'a');
        assertEquals(1.0, actual);
        actual = calculator.calculate(Double.MAX_VALUE, 1.0, 'a');
        assertEquals(Double.MAX_VALUE, actual);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, 'a');
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_subtractionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(1000.05, 100.05, 's');
        assertEquals(900.0, actual);
    }

    @Test
    void calculate_subtractionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-1000.05, -100.05, 's');
        assertEquals(-900.0, actual);
    }

    @Test
    void calculate_subtractionNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(-0.000049, 0.00005, 's');
        assertEquals(-0.00009, actual, DELTA);
        actual = calculator.calculate(.000049, -0.00005, 's');
        assertEquals(0.00009, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZero_isOk() {
        actual = calculator.calculate(20.5555555, 0.0, 's');
        assertEquals(20.5555555, actual);
        actual = calculator.calculate(0.0, -20.5555555, 's');
        assertEquals(20.5555555, actual);
    }

    @Test
    void calculate_subtractionMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MIN_VALUE, 1.0, 's');
        assertEquals(-1.0, actual);
        actual = calculator.calculate(Double.MAX_VALUE, 1.0, 's');
        assertEquals(Double.MAX_VALUE, actual);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, 's');
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_multiplicationTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(10.0, 100.0, 'm');
        assertEquals(1000.0, actual);
    }

    @Test
    void calculate_multiplicationTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-10.0, -100.0, 'm');
        assertEquals(1000.0, actual);
    }

    @Test
    void calculate_multiplicationNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(-0.1, 0.1, 'm');
        assertEquals(-0.01, actual, DELTA);
        actual = calculator.calculate(0.1, -0.1, 'm');
        assertEquals(-0.01, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZero_isOk() {
        actual = calculator.calculate(20.5555555, 0.0, 'm');
        assertEquals(0.0, actual);
        actual = calculator.calculate(0.0, -20.5555555, 'm');
        assertEquals(-0.0, actual);
    }

    @Test
    void calculate_multiplicationMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, 'm');
        assertEquals(8.881784197001251E-16, actual);
    }

    @Test
    void calculate_multiplicationMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, 2.0, 'm');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(Double.MAX_VALUE, 1.0, 'm');
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_multiplicationMinDoubleValue_isOk() {
        actual = calculator.calculate(Double.MIN_VALUE, 1.0, 'm');
        assertEquals(Double.MIN_VALUE, actual);
        actual = calculator.calculate(Double.MIN_VALUE, 0.9, 'm');
        assertEquals(Double.MIN_VALUE, actual);
    }

    @Test
    void calculate_divisionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(100.0, 10.0, 'd');
        assertEquals(10.0, actual);
    }

    @Test
    void calculate_divisionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-10.0, -100.0, 'd');
        assertEquals(0.1, actual);
    }

    @Test
    void calculate_divisionNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(-0.0001, 10.0, 'd');
        assertEquals(-0.00001, actual, DELTA);
        actual = calculator.calculate(0.0001, -10.0, 'd');
        assertEquals(-0.00001, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZero_isOk() {
        actual = calculator.calculate(2.0, 0.0, 'd');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(0, -20.5555555, 'd');
        assertEquals(-0.0, actual);

    }

    @Test
    void calculate_divisionMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, 'd');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, 'd');
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_divisionByMaxDoubleValue_isNotOk() {
        actual = calculator.calculate(1.0, Double.MAX_VALUE, 'd');
        assertNotEquals(Double.MIN_VALUE, actual);
        assertNotEquals(0.0, actual);
    }

    @Test
    void calculate_divisionByMinDoubleValue_isOk() {
        actual = calculator.calculate(1.0, Double.MIN_VALUE, 'd');
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_divisionMinAndMaxDoubleValueByZero_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, 0.0, 'd');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(Double.MIN_VALUE, 0.0, 'd');
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeNumberToPositivePower_isOk() {
        actual = calculator.calculate(2.0, 3.0, 'p');
        assertEquals(8.0, actual);
        actual = calculator.calculate(-2.0, 3.0, 'p');
        assertEquals(-8.0, actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeNumberToNegativePower_isOk() {
        actual = calculator.calculate(2.0, -3.0, 'p');
        assertEquals(0.125, actual);
        actual = calculator.calculate(-2.0, -3.0, 'p');
        assertEquals(-0.125, actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeNumberToZero_isOk() {
        actual = calculator.calculate(2.0, 0.0, 'p');
        assertTrue(actual == 1);
        actual = calculator.calculate(-2.0, 0.0, 'p');
        assertTrue(actual == 1);
    }

    @Test
    void calculate_raisingZeroToPower_isOk() {
        double exponent = 20.5;
        actual = calculator.calculate(0.0, exponent, 'p');
        assertTrue(actual == 0.0);
        actual = calculator.calculate(0.0, -exponent, 'p');
        assertTrue(actual == Double.POSITIVE_INFINITY);
    }

    @Test
    void calculate_exceptionForIllegalOperation_isThrown() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(10.0, 0.0, 'b'));
    }

}
