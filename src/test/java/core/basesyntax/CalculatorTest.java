package core.basesyntax;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.00001;

    private Calculator calculator = null;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals("The sum of calculate",
                12, calculator.calculate(7, 5, '+'), DELTA);
        assertEquals("The sum of calculate",
                -2, calculator.calculate(-7, 5, '+'), DELTA);
        assertEquals("The sum of calculate",
                2, calculator.calculate(7, -5, '+'), DELTA);
        assertEquals("The sum of calculate",
                -12, calculator.calculate(-7, -5, '+'), DELTA);
        assertEquals("The sum of calculate",
                7, calculator.calculate(7, 0, '+'), DELTA);
        assertEquals("The sum of calculate",
                5, calculator.calculate(0, 5, '+'), DELTA);
        assertEquals("The sum of calculate",
                0, calculator.calculate(0, 0, '+'), DELTA);
    }

    @Test
    public void testSubtraction() {
        assertEquals("The subtrction of calculate",
                9, calculator.calculate(21, 12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                33, calculator.calculate(21, -12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                -33, calculator.calculate(-21, 12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                -9, calculator.calculate(-21, -12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                21, calculator.calculate(21, 0, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                -12, calculator.calculate(0, 12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                0, calculator.calculate(0, 0, '-'), DELTA);
    }

    @Test
    public void testMultiplier() {
        assertEquals("The multipiler of calculate",
                18, calculator.calculate(2, 9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                -18, calculator.calculate(-2, 9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                -18, calculator.calculate(2, -9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                18, calculator.calculate(-2, -9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                0, calculator.calculate(0, 9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                0, calculator.calculate(2, 0, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                0, calculator.calculate(0, 0, '*'), DELTA);
    }

    @Test
    public void testDivision() {
        assertEquals("The division of calculate",
                5, calculator.calculate(35, 7, '/'), DELTA);
        assertEquals("The division of calculate",
                -5, calculator.calculate(-35, 7, '/'), DELTA);
        assertEquals("The division of calculate",
                -5, calculator.calculate(35, -7, '/'), DELTA);
        assertEquals("The division of calculate",
                5, calculator.calculate(-35, -7, '/'), DELTA);
        assertEquals("The division of calculate",
                0, calculator.calculate(0, 7, '/'), DELTA);
    }

    @Test
    public void testPow() {
        assertEquals("The pow of calculate",
                144, calculator.calculate(12, 2, '^'), DELTA);
        assertEquals("The pow of calculate",
                12, calculator.calculate(12, 1, '^'), DELTA);
        assertEquals("The pow of calculate1",
                0.00694444, calculator.calculate(12, -2, '^'), DELTA);
        assertEquals("The pow of calculate2",
                144, calculator.calculate(-12, 2, '^'), DELTA);
        assertEquals("The pow of calculate3",
                0.00694444, calculator.calculate(-12, -2, '^'), DELTA);
        assertEquals("The pow of calculate",
                1, calculator.calculate(12, 0, '^'), DELTA);
        assertEquals("The pow of calculate",
                0, calculator.calculate(0, 2, '^'), DELTA);
        assertEquals("The pow of calculate",
                1, calculator.calculate(0, 0, '^'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        calculator.calculate(5, 0, '/');
    }

    @Test(expected = InvalidParameterException.class)
    public void wrongInputParameter() {
        calculator.calculate(1, 5, 'p');
    }
}
