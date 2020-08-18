package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    public static final double DELTA = 0.1;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    @Test
    public void testMultiply() {
        Calculator test = new Calculator();
        Assert.assertEquals(50, test.calculator(10, 5, MULTIPLICATION), DELTA);
        Assert.assertEquals(50, test.calculator(-10, -5, MULTIPLICATION), DELTA);
        Assert.assertEquals(-50, test.calculator(-10, 5, MULTIPLICATION), DELTA);
        Assert.assertEquals(0, test.calculator(0, -5, MULTIPLICATION), DELTA);
        Assert.assertEquals(0, test.calculator(0, 0, MULTIPLICATION), DELTA);
    }

    @Test
    public void testSum() {
        Calculator test = new Calculator();
        Assert.assertEquals(15, test.calculator(10, 5, PLUS), DELTA);
        Assert.assertEquals(-15, test.calculator(-10, -5, PLUS), DELTA);
        Assert.assertEquals(-5, test.calculator(-5, 0, PLUS), DELTA);
        Assert.assertEquals(0, test.calculator(0, 0, PLUS), DELTA);
    }

    @Test
    public void testSubtraction() {
        Calculator test = new Calculator();
        Assert.assertEquals(5, test.calculator(10, 5, MINUS), DELTA);
        Assert.assertEquals(-5, test.calculator(-10, -5, MINUS), DELTA);
        Assert.assertEquals(-5, test.calculator(-5, 0, MINUS), DELTA);
        Assert.assertEquals(0, test.calculator(0, 0, MINUS), DELTA);
    }

    @Test
    public void testDivision() {
        Calculator test = new Calculator();
        Assert.assertEquals(2, test.calculator(10, 5, DIVISION), DELTA);
        Assert.assertEquals(2, test.calculator(-10, -5, DIVISION), DELTA);
        Assert.assertEquals(-2, test.calculator(-10, 5, DIVISION), DELTA);
    }

    @Test
    public void testPow() {
        Calculator test = new Calculator();
        Assert.assertEquals(100000, test.calculator(10, 5, POWER), DELTA);
        Assert.assertEquals(100, test.calculator(-10, 2, POWER), DELTA);
        Assert.assertEquals(0.01, test.calculator(10, -3, POWER), DELTA);
        Assert.assertEquals(1, test.calculator(10, 0, POWER), DELTA);
        Assert.assertEquals(0, test.calculator(0, 10, POWER), DELTA);
    }


    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator test = new Calculator();
        test.calculator(2, 0, DIVISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownOperator() {
        Calculator test = new Calculator();
        test.calculator(5, 10, '#');
    }
}
