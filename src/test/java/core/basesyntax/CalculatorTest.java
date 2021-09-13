package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void editionWithTwoPositiveOperands_ok() {
        expected = 82;
        actual = calculator.calculate(80, 2, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void editionWithTwoNegativeOperands_ok() {
        expected = -82;
        actual = calculator.calculate(-80, -2, '+');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void editionWithNegativeAndPositiveOperands_ok() {
        expected = -78;
        actual = calculator.calculate(-80, 2, '+');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void editionWithFirstOperandIsZero_ok() {
        expected = 2;
        actual = calculator.calculate(0, 2, '+');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void editionWithSecondOperandIsZero_ok() {
        expected = 80;
        actual = calculator.calculate(80, 0, '+');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void editionWithMinAndMaxOperands_ok() {
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void editionWithMaxAndMaxOperands_ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void editionWithMinAndMinOperands_ok() {
        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands_ok() {
        expected = 78;
        actual = calculator.calculate(80, 2, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoNegativeOperands_ok() {
        expected = -78;
        actual = calculator.calculate(-80, -2, '-');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void subtractionWithNegativeAndPositiveOperands_ok() {
        expected = -82;
        actual = calculator.calculate(-80, 2, '-');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void subtractionWithFirstOperandIsZero_ok() {
        expected = -2;
        actual = calculator.calculate(0, 2, '-');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void subtractionWithSecondOperandIsZero_ok() {
        expected = 80;
        actual = calculator.calculate(80, 0, '-');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void subtractionWithMaxAndMinOperands_ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithMaxAndMaxOperands_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithMinAndMinOperands_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoPositiveOperands_ok() {
        expected = 160;
        actual = calculator.calculate(80, 2, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_ok() {
        expected = 160;
        actual = calculator.calculate(-80, -2, '*');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void multiplicationWithNegativeAndPositiveOperands_ok() {
        expected = -160;
        actual = calculator.calculate(-80, 2, '*');
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void multiplicationWithFirstOperandIsZero_ok() {
        expected = 0;
        actual = calculator.calculate(0, 2, '*');
        assertEquals(actual, expected);
    }

    @Test
    void multiplicationWithSecondOperandIsZero_ok() {
        expected = 0;
        actual = calculator.calculate(80, 0, '*');
        assertEquals(actual, expected);
    }

    @Test
    void multiplicationWithMinAndMaxOperands_ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithMaxAndMaxOperands_ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithMinAndMinOperands_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToThePositivePower_ok() {
        expected = 6400;
        actual = calculator.calculate(80, 2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_ok() {
        expected = 0.25;
        actual = calculator.calculate(2, -2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToThePositivePower_ok() {
        expected = 6400;
        actual = calculator.calculate(-80, 2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_ok() {
        expected = 0.25;
        actual = calculator.calculate(-2, -2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToZeroPower_ok() {
        expected = 1;
        actual = calculator.calculate(-80, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToZeroPower_ok() {
        expected = 1;
        actual = calculator.calculate(80, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower() {
        expected = 0;
        actual = calculator.calculate(0, 10, '^');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoPositiveOperands_ok() {
        expected = 40;
        actual = calculator.calculate(80, 2, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoNegativeOperands_ok() {
        expected = 40;
        actual = calculator.calculate(-80, -2, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithNegativeAndPositiveOperands_ok() {
        expected = -40;
        actual = calculator.calculate(-80, 2, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithSecondOperandIsZero_ok() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(80, 0, '/'));
    }

    @Test
    void divisionWithFirstOperandIsZero_ok() {
        expected = 0;
        actual = calculator.calculate(0, 2, '/');
        assertEquals(expected, actual, DELTA);
    }
}

