package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.000001;
    private static Calculator calculator;
    private double expected;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void calculateAddTwoPositive() {
        expected = 10;
        assertEquals(expected,calculator.calculate(4, 6, '+'));
    }

    @Test
    public void calculateAddTwoNegative() {
        expected = -10;
        assertEquals(expected,calculator.calculate(-4, -6, '+'));
    }

    @Test
    public void calculateAddPositiveNegative() {
        expected = -2;
        assertEquals(expected, calculator.calculate(4, -6, '+'));
        expected = 2;
        assertEquals(expected, calculator.calculate(-4, 6, '+'));
    }

    @Test
    public void calculateAddZeroInDifPos() {
        expected = 5;
        assertEquals(expected, calculator.calculate(5, 0, '+'));
        assertEquals(expected, calculator.calculate(0, 5, '+'));
    }

    @Test
    public void calculateAddMaxDoubleValue() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE,Double.MAX_VALUE, '+'),DELTA);
    }

    @Test
    public void calculateAddMinDoubleValue() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+'),
                DELTA);
    }

    @Test
    public void calculateSubtractTwoPositive() {
        expected = 2;
        assertEquals(expected,calculator.calculate(6, 4, '-'));
    }

    @Test
    public void calculateSubtractTwoNegative() {
        expected = 2;
        assertEquals(expected,calculator.calculate(-4, -6, '-'));
    }

    @Test
    public void calculateSubtractPositiveNegative() {
        expected = 10;
        assertEquals(expected, calculator.calculate(4, -6, '-'));
        expected = -10;
        assertEquals(expected, calculator.calculate(-4, 6, '-'));
    }

    @Test
    public void calculateSubtractZeroInDifPos() {
        expected = 5;
        assertEquals(expected, calculator.calculate(5, 0, '-'));
        expected = -5;
        assertEquals(expected, calculator.calculate(0, 5, '-'));
    }

    @Test
    public void calculateSubtractMaxDoubleValue() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE,Double.MAX_VALUE, '-'),DELTA);
    }

    @Test
    public void calculateSubtractMinDoubleValue() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'),
                DELTA);
    }

    @Test
    public void calculateMultiplicationTwoPositive() {
        expected = 24;
        assertEquals(expected,calculator.calculate(4, 6, '*'));
    }

    @Test
    public void calculateMultiplicationTwoNegative() {
        expected = 24;
        assertEquals(expected,calculator.calculate(-4, -6, '*'));
    }

    @Test
    public void calculateMultiplicationPositiveNegative() {
        expected = -24;
        assertEquals(expected, calculator.calculate(4, -6, '*'));
        assertEquals(expected, calculator.calculate(-4, 6, '*'));
    }

    @Test
    public void calculateMultiplicationZeroInDifPos() {
        expected = 0;
        assertEquals(expected, calculator.calculate(5, 0, '*'));
        assertEquals(expected, calculator.calculate(0, 5, '*'));
    }

    @Test
    public void calculateMultiplicationMaxDoubleValue() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE,Double.MAX_VALUE, '*'),DELTA);
    }

    @Test
    public void calculateMultiplicationMinDoubleValue() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*'),
                DELTA);
    }

    @Test
    public void calculateDivisionTwoPositive() {
        expected = 1.5;
        assertEquals(expected,calculator.calculate(6, 4, '/'));
    }

    @Test
    public void calculateDivisionTwoNegative() {
        expected = 1.5;
        assertEquals(expected,calculator.calculate(-6, -4, '/'));
    }

    @Test
    public void calculateDivisionPositiveNegative() {
        expected = -1.5;
        assertEquals(expected, calculator.calculate(6, -4, '/'));
        assertEquals(expected, calculator.calculate(-6, 4, '/'));
    }

    @Test
    public void calculateDivisionZeroInFirstPos() {
        expected = 0;
        assertEquals(expected, calculator.calculate(0, 5, '/'));
    }

    @Test
    public void calculateDivisionZeroInSecondPos() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(5, 0, '/'));
    }

    @Test
    public void calculateDivisionMaxDoubleValue() {
        expected = 1;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE,Double.MAX_VALUE, '/'),DELTA);
    }

    @Test
    public void calculateDivisionMinDoubleValue() {
        expected = 1;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/'),
                DELTA);
    }

    @Test
    public void calculateRaisingPositiveToPositive() {
        expected = 27;
        assertEquals(expected, calculator.calculate(3, 3, '^'));
    }

    @Test
    public void calculateRaisingPositiveToNegative() {
        expected = 0.0016;
        assertEquals(expected, calculator.calculate(5, -4, '^'), DELTA);
    }

    @Test
    public void calculateRaisingNegativeToPositive() {
        expected = 16;
        assertEquals(expected, calculator.calculate(-2, 4, '^'));
    }

    @Test
    public void calculateRaisingNegativeToNegative() {
        expected = 0.0625;
        assertEquals(expected,calculator.calculate(-2, -4, '^'), DELTA);
    }

    @Test
    public void calculateRaisingValueToZero() {
        expected = 1;
        assertEquals(expected, calculator.calculate(4, 0, '^'), DELTA);
    }

    @Test
    public void calculateRaisingZeroValue() {
        expected = 0;
        assertEquals(expected, calculator.calculate(0, 6, '^'));
    }

    @Test
    public void wrongOperationCharacter() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(4, 8, '&'));
    }

}
