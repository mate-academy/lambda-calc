package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void operationOfPositiveOperands_OK() {
        actual = calculator.calculate(10, 20, '+');
        expected = 30;
        assertEquals(expected, actual);
        actual = calculator.calculate(20, 10, '-');
        expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 20, '*');
        expected = 200;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 20, '/');
        expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void operationOfNegativeOperands_OK() {
        actual = calculator.calculate(-10, -20, '+');
        expected = -30;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, -20, '-');
        expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, -20, '*');
        expected = 200;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, -20, '/');
        expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void operationOfPositiveAndNegative_OK() {
        actual = calculator.calculate(-10, 10, '+');
        expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 10, '-');
        expected = -20;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 10, '*');
        expected = -100;
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 10, '/');
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void operationWithZero_OK() {
        actual = calculator.calculate(0, 10, '+');
        expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, '+');
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 10, '-');
        expected = -10;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, '-');
        expected = 10;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 10, '*');
        expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, '*');
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 10, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void dividingByZero_NotOK() {
        assertThrows(NullDivisorException.class, () ->
                calculator.calculate(10, 0, '/'));
    }

    @Test
    void operationForMinAndMaxDoubleValues_NotOK() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '-'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '*'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(3, Double.MAX_EXPONENT + 1, '^'));
    }

    @Test
    void operationForMinAndMaxDoubleValues_OK() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '+');
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, 0, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);
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
    void illegalOperation_NotOK() {
        assertThrows(InvalidOperatorException.class, () ->
                calculator.calculate(0, 0, '$'));
    }
}
