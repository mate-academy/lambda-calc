package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveOperands_Ok() {
        expected = 15d + 20d;
        actual = calculator.calculate(15, 20, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeOperands_Ok() {
        expected = -15d + -20d;
        actual = calculator.calculate(-15, -20, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        expected = -15d + 20d;
        actual = calculator.calculate(-15, 20, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZero_Ok() {
        expected = 0 + 20d;
        actual = calculator.calculate(0, 20, '+');
        assertEquals(expected, actual, DELTA);

        expected = 15d + 0;
        actual = calculator.calculate(15, 0, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionForMinMaxValues_Ok() {
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE + Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinMaxValues_Ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE - Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinMaxValues_Ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMinMaxValues_Ok() {
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE / Double.MAX_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE / Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE / Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_Ok() {
        expected = 15d / 0;
        actual = calculator.calculate(15, 0, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingValueToPositiveNumber_Ok() {
        expected = Math.pow(15d, 20d);
        actual = calculator.calculate(15, 20, '^');
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-15d, 20d);
        actual = calculator.calculate(-15, 20, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingValueToNegativeNumber_Ok() {
        expected = Math.pow(15d, -20d);
        actual = calculator.calculate(15, -20, '^');
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-15d, -20d);
        actual = calculator.calculate(-15, -20, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingValueToZero_Ok() {
        expected = Math.pow(15d, 0);
        actual = calculator.calculate(15, 0, '^');
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-15d, 0);
        actual = calculator.calculate(-15, 0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        expected = Math.pow(0, 20d);
        actual = calculator.calculate(0, 20d, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(NoSuchOperationException.class, () -> calculator.calculate(15, 20, '$'));
    }
}
