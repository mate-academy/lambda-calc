package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.000001;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void calculateAddTwoPositive() {
        expected = 10;
        actual = calculator.calculate(4, 6, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAddTwoNegative() {
        expected = -10;
        actual = calculator.calculate(-4, -6, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAddPositiveNegative() {
        expected = -2;
        actual = calculator.calculate(4, -6, '+');
        assertEquals(expected, actual);
        expected = 2;
        actual = calculator.calculate(-4, 6, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAddZeroInDifPos() {
        expected = 5;
        actual = calculator.calculate(5, 0, '+');
        assertEquals(expected, actual);
        actual = calculator.calculate(0, 5, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAddMaxDoubleValue() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateAddMinDoubleValue() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateSubtractTwoPositive() {
        expected = 2;
        actual = calculator.calculate(6, 4, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractTwoNegative() {
        expected = 2;
        actual = calculator.calculate(-4, -6, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractPositiveNegative() {
        expected = 10;
        actual = calculator.calculate(4, -6, '-');
        assertEquals(expected, actual);
        expected = -10;
        actual = calculator.calculate(-4, 6, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractZeroInDifPos() {
        expected = 5;
        actual = calculator.calculate(5, 0, '-');
        assertEquals(expected, actual);
        expected = -5;
        actual = calculator.calculate(0, 5, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractMaxDoubleValue() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateSubtractMinDoubleValue() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateMultiplicationTwoPositive() {
        expected = 24;
        actual = calculator.calculate(4, 6, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationTwoNegative() {
        expected = 24;
        actual = calculator.calculate(-4, -6, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationPositiveNegative() {
        expected = -24;
        actual = calculator.calculate(4, -6, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(-4, 6, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationZeroInDifPos() {
        expected = 0;
        actual = calculator.calculate(5, 0, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(0, 5, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationMaxDoubleValue() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateMultiplicationMinDoubleValue() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateDivisionTwoPositive() {
        expected = 1.5;
        actual = calculator.calculate(6, 4, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionTwoNegative() {
        expected = 1.5;
        actual = calculator.calculate(-6, -4, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionPositiveNegative() {
        expected = -1.5;
        actual = calculator.calculate(6, -4, '/');
        assertEquals(expected, actual);
        actual = calculator.calculate(-6, 4, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionZeroInFirstPos() {
        expected = 0;
        actual = calculator.calculate(0, 5, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionZeroInSecondPos() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(5, 0, '/'));
    }

    @Test
    public void calculateDivisionMaxDoubleValue() {
        expected = 1;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateDivisionMinDoubleValue() {
        expected = 1;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateRaisingPositiveToPositive() {
        expected = 27;
        actual = calculator.calculate(3, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingPositiveToNegative() {
        expected = 0.0016;
        actual = calculator.calculate(5, -4, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateRaisingNegativeToPositive() {
        expected = 16;
        actual = calculator.calculate(-2, 4, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingNegativeToNegative() {
        expected = 0.0625;
        actual = calculator.calculate(-2, -4, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateRaisingValueToZero() {
        expected = 1;
        actual = calculator.calculate(4, 0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateRaisingZeroValue() {
        expected = 0;
        actual = calculator.calculate(0, 6, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void wrongOperationCharacter() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(4, 8, '&'));
    }
}
