package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exceptions.OperatorException;
import core.basesyntax.exceptions.ValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 1e-13;
    private static final Double MIN_DOUBLE_VALUE = Double.MIN_VALUE;
    private static final Double MAX_DOUBLE_VALUE = Double.MAX_VALUE;
    private static final Double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    private static final char ILLEGAL_EXPRESSION = '?';
    private static Calculator calculator;
    private double firstValue;
    private double secondValue;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = 1.0E-323;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = MAX_DOUBLE_VALUE;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_OK() {
        firstValue = -100.1;
        secondValue = 200.2;
        expected = 100.1;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_OK() {
        firstValue = -100.10;
        secondValue = -200.20;
        expected = -300.3;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_OK() {
        firstValue = 0.1;
        secondValue = 0.2;
        expected = 0.3;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_OK() {
        firstValue = 0.0;
        secondValue = 5.0;
        expected = 5.0;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
        firstValue = -5.0;
        secondValue = 0.0;
        expected = -5.0;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMinAndMaxDoubleValues_OK() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = 1.0;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = 0.0;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = 1;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_OK() {
        firstValue = -25.5;
        secondValue = 5.1;
        expected = -5.0;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_OK() {
        firstValue = -15.15;
        secondValue = -5.05;
        expected = 3;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_OK() {
        firstValue = 75.5;
        secondValue = 15.1;
        expected = 5.0;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionZero_OK() {
        firstValue = 0.0;
        secondValue = 125.0;
        expected = 0.0;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_NotOK() {
        firstValue = 125.0;
        secondValue = 0.0;
        assertThrows(ValueException.class, () ->
                calculator.calculate(firstValue, secondValue, '/'));
    }

    @Test
    void calculate_illegalOperation_NotOK() {
        assertThrows(OperatorException.class, () ->
                calculator.calculate(firstValue, secondValue, ILLEGAL_EXPRESSION));
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = 0.00;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = 8.881784197001251E-16;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_OK() {
        firstValue = -5.05;
        secondValue = 5.05;
        expected = -25.5025;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_OK() {
        firstValue = -25.5;
        secondValue = -15.5;
        expected = 395.25;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_OK() {
        firstValue = 0.1;
        secondValue = 0.1;
        expected = 0.01;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_OK() {
        firstValue = 0.0;
        secondValue = 5.0;
        expected = 0.0;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
        firstValue = -5.0;
        secondValue = 0.0;
        expected = 0.0;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativePositiveValueToTheNegativePower_OK() {
        firstValue = -5.0;
        secondValue = -4.0;
        expected = 0.0016;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
        firstValue = 5.0;
        secondValue = -4.0;
        expected = 0.0016;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativePositiveValueToThePositivePower_OK() {
        firstValue = -5.0;
        secondValue = 5.0;
        expected = -3125.0;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
        firstValue = 5.0;
        secondValue = 2.0;
        expected = 25.0;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativePositiveValueToTheZeroPower_OK() {
        firstValue = -5.0;
        secondValue = 0.0;
        expected = 1.0;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
        firstValue = -5.0;
        secondValue = 0.0;
        expected = 1.0;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToNegativePower_NotOK() {
        firstValue = 0.0;
        secondValue = -5.0;
        assertThrows(ValueException.class,
                () -> calculator.calculate(firstValue, secondValue, '^'));
    }

    @Test
    void calculate_raisingZeroToPositivePower_OK() {
        firstValue = 0.0;
        secondValue = 5.0;
        expected = 0.0;
        actual = calculator.calculate(firstValue, secondValue, '^');
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = 0.0;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = 0.0;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = -MAX_DOUBLE_VALUE;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = MAX_DOUBLE_VALUE;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_OK() {
        firstValue = -0.3;
        secondValue = 0.2;
        expected = -0.5;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
        firstValue = 5.0;
        secondValue = -5.0;
        expected = 10.0;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_OK() {
        firstValue = -25.0;
        secondValue = -5.0;
        expected = -20.0;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_OK() {
        firstValue = 0.3;
        secondValue = 0.2;
        expected = 0.1;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_OK() {
        firstValue = -5.0;
        secondValue = 0.0;
        expected = -5.0;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
        firstValue = 0.0;
        secondValue = 5.0;
        expected = -5.0;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void doubleComparing0andZero() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = 0.0;
        assertEquals(firstValue, secondValue, DELTA);
    }
}
