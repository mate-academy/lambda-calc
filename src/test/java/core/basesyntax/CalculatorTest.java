package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.000001;
    private static Calculator calc;
    private double expected;
    private double actual;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void positiveAddition() {
        expected = 8;
        actual = calc.calculator(1, 7, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeAddition() {
        expected = -8;
        actual = calc.calculator(-1, -7, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeAddition() {
        expected = 6;
        actual = calc.calculator(-1, 7, '+');
        assertEquals(expected, actual);
        expected = -6;
        actual = calc.calculator(1, -7, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void differentPlacesZeroAddition() {
        expected = 1;
        actual = calc.calculator(1, 0, '+');
        assertEquals(expected, actual);
        actual = calc.calculator(0, 1, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void maxMinValuesAddition() {
        expected = Double.POSITIVE_INFINITY;
        actual = calc.calculator(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calc.calculator(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveSubtraction() {
        expected = -6;
        actual = calc.calculator(1, 7, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeSubtraction() {
        expected = 6;
        actual = calc.calculator(-1, -7, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeSubtraction() {
        expected = 8;
        actual = calc.calculator(1, -7, '-');
        assertEquals(expected, actual);
        expected = -8;
        actual = calc.calculator(-1, 7, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void differentPlacesZeroSubtraction() {
        expected = 1;
        actual = calc.calculator(1, 0, '-');
        assertEquals(expected, actual);
        expected = -1;
        actual = calc.calculator(0, 1, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void maxMinValuesSubtraction() {
        expected = 0;
        actual = calc.calculator(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calc.calculator(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveMultiplication() {
        expected = 7;
        actual = calc.calculator(1, 7, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeMultiplication() {
        expected = 7;
        actual = calc.calculator(-1, -7, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeMultiplication() {
        expected = -7;
        actual = calc.calculator(-1, 7, '*');
        assertEquals(expected, actual);
        expected = -7;
        actual = calc.calculator(1, -7, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void differentPlacesZeroMultiplication() {
        expected = 0;
        actual = calc.calculator(1, 0, '*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calc.calculator(0, 7, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void maxMinValuesMultiplication() {
        expected = Double.POSITIVE_INFINITY;
        actual = calc.calculator(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calc.calculator(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveDivision() {
        expected = 2;
        actual = calc.calculator(4,2, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeDivision() {
        expected = 2;
        actual = calc.calculator(-4,-2, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeDivision() {
        expected = -2;
        actual = calc.calculator(-4, 2, '/');
        assertEquals(expected, actual);
        expected = -2;
        actual = calc.calculator(4, -2, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void firstPlacesZeroDivision() {
        expected = 0;
        actual = calc.calculator(0, 2, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void secondPlacesZeroDivision() {
        assertThrows(ArithmeticException.class,
                () -> calc.calculator(2, 0, '/'));
    }

    @Test
    public void maxMinValueDivision() {
        expected = 1;
        actual = calc.calculator(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual);
        expected = 1;
        actual = calc.calculator(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToPositiveOrNegative() {
        expected = 64;
        actual = calc.calculator(4, 3, '^');
        assertEquals(expected, actual);
        expected = 0.0625;
        actual = calc.calculator(4, -2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingNegativeToPositiveOrNegative() {
        expected = 16;
        actual = calc.calculator(-4, 2, '^');
        assertEquals(expected, actual);
        expected = 0.0625;
        actual = calc.calculator(-4, -2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingValueToZero() {
        expected = 1;
        actual = calc.calculator(2, 0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingZeroToPower() {
        expected = 0;
        actual = calc.calculator(0, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void illegalOperation() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculator(1, 2, '&'));
    }
}
