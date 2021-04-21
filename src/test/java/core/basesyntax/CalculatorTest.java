package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.DoubleLimitException;
import core.basesyntax.exception.InvalidOperatorException;
import core.basesyntax.exception.NullDivisorException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionOfPositiveOperands_OK() {
        actual = calculator.calculate(10, 20, '+');
        expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '+');
        expected = -30;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZero_OK() {
        actual = calculator.calculate(0, 10, '+');
        expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
    }

    @Test
    void calculate_subtractionOfPositiveOperands_OK() {
        actual = calculator.calculate(20, 10, '-');
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '-');
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '-');
        expected = -20;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZero_OK() {
        actual = calculator.calculate(0, 10, '-');
        expected = -10;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '-'));
    }

    @Test
    void calculate_multiplicationOfPositiveOperands_OK() {
        actual = calculator.calculate(20, 10, '*');
        expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '*');
        expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '*');
        expected = -100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZero_OK() {
        expected = 0;
        actual = calculator.calculate(0, 10, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '*'));
    }

    @Test
    void calculate_divisionOfPositiveOperands_OK() {
        actual = calculator.calculate(20, 10, '/');
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '/');
        expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '/');
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZero_OK() {
        expected = 0;
        actual = calculator.calculate(0, 10, '/');
        assertEquals(expected, actual);
        actual = calculator.calculate(0, 10, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/'));
    }

    @Test
    void calculate_dividingByZero_NotOK() {
        assertThrows(NullDivisorException.class, () ->
                calculator.calculate(10, 0, '/'));
    }

    @Test
    void calculate_raisingPositiveAndNegativeToPositive_OK() {
        actual = calculator.calculate(10, 4, '^');
        expected = 10000;
        assertEquals(expected, actual);
        actual = calculator.calculate(-5, 2, '^');
        expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeToNegative_OK() {
        actual = calculator.calculate(0.5, -2, '^');
        expected = 4;
        assertEquals(expected, actual);
        actual = calculator.calculate(-0.5, -3, '^');
        expected = -8;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeToZero_OK() {
        expected = 1;
        actual = calculator.calculate(10, 0, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToNotNegativePower_OK() {
        expected = 0;
        actual = calculator.calculate(0, 10, '^');
        assertEquals(expected, actual);
        expected = 1;
        actual = calculator.calculate(0, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToNegativePower_NotOK() {
        assertThrows(NullDivisorException.class, () ->
                calculator.calculate(0, -10, '^'));
    }

    @Test
    void calculate_illegalOperation_NotOK() {
        assertThrows(InvalidOperatorException.class, () ->
                calculator.calculate(0, 0, '$'));
    }
}
