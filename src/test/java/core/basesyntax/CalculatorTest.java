package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.DoubleLimitException;
import core.basesyntax.exception.InvalidOperatorException;
import core.basesyntax.exception.NullDivisorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;
    private double expected;
    private double actual;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionOfPositiveOperands_OK() {
        actual = calculator.calculate(10, 20, '+');
        expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    void additionOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '+');
        expected = -30;
        assertEquals(expected, actual);
    }

    @Test
    void additionOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZero_OK() {
        actual = calculator.calculate(0, 10, '+');
        expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, '+');
        assertEquals(expected, actual);
        actual = calculator.calculate(-0.0, -0.0, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void additionForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
    }

    @Test
    void additionForMinAndMaxDoubleValues_OK() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '+');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionOfPositiveOperands_OK() {
        actual = calculator.calculate(20, 10, '-');
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '-');
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '-');
        expected = -20;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZero_OK() {
        actual = calculator.calculate(0, 10, '-');
        expected = -10;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 0, '-');
        assertEquals(expected, actual);
        actual = calculator.calculate(-0.0, 0, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '-'));
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_OK() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationOfPositiveOperands_OK() {
        actual = calculator.calculate(20, 10, '*');
        expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '*');
        expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '*');
        expected = -100;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZero_OK() {
        expected = 0;
        actual = calculator.calculate(0, 10, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '*'));
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_OK() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void divisionOfPositiveOperands_OK() {
        actual = calculator.calculate(20, 10, '/');
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void divisionOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '/');
        expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void divisionOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '/');
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZero_OK() {
        expected = 0;
        actual = calculator.calculate(0, 10, '/');
        assertEquals(expected, actual);
        actual = calculator.calculate(-0.0, 10, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionForMinAndMaxDoubleValues_NotOK() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/'));
    }

    @Test
    void divisionForMinAndMaxDoubleValues_OK() {
        expected = 1;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual);
    }

    @Test
    void dividingByZero_NotOK() {
        assertThrows(NullDivisorException.class, () ->
                calculator.calculate(10, 0, '/'));
    }

    @Test
    void raisingPositiveAndNegativeToPositive_OK() {
        actual = calculator.calculate(10, 4, '^');
        expected = 10000;
        assertEquals(expected, actual);
        actual = calculator.calculate(-5, 2, '^');
        expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveAndNegativeToNegative_OK() {
        actual = calculator.calculate(0.5, -2, '^');
        expected = 4;
        assertEquals(expected, actual);
        actual = calculator.calculate(-0.5, -3, '^');
        expected = -8;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveAndNegativeToZero_OK() {
        expected = 1;
        actual = calculator.calculate(10, 0, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToNotNegativePower_OK() {
        expected = 0;
        actual = calculator.calculate(0, 10, '^');
        assertEquals(expected, actual);
        expected = 1;
        actual = calculator.calculate(0, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToNegativePower_NotOK() {
        assertThrows(NullDivisorException.class, () ->
                calculator.calculate(0, -10, '^'));
    }

    @Test
    void raisingDoubleLimit_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 0, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingDoubleLimit_NotOk() {
        assertThrows(DoubleLimitException.class, () ->
                calculator.calculate(Double.MAX_VALUE, 2, '^'));
    }

    @Test
    void illegalOperation_NotOK() {
        assertThrows(InvalidOperatorException.class, () ->
                calculator.calculate(0, 0, '$'));
    }
}
