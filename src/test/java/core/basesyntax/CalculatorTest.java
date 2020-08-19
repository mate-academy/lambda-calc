package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
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
    private static Calculator test;

    @BeforeClass
    public static void setUp() {
        test = new Calculator();
    }

    @Test
    public void testSumPositive() {
        Assert.assertEquals(15, test.calculator(10, 5, PLUS), DELTA);
        Assert.assertEquals(5105, test.calculator(105, 5000, PLUS), DELTA);
        Assert.assertEquals(2, test.calculator(1, 1, PLUS), DELTA);
        Assert.assertEquals(0, test.calculator(0, 0, PLUS), DELTA);
    }

    @Test
    public void testSumNegative() {
        Assert.assertEquals(-11, test.calculator(-10, -1, PLUS), DELTA);
        Assert.assertEquals(98, test.calculator(-2, 100, PLUS), DELTA);
        Assert.assertEquals(-3, test.calculator(-3, 0, PLUS), DELTA);
    }

    @Test
    public void testSubtractionPositive() {
        Assert.assertEquals(16, test.calculator(20, 4, MINUS), DELTA);
        Assert.assertEquals(999, test.calculator(1000, 1, MINUS), DELTA);
        Assert.assertEquals(0, test.calculator(0, 0, MINUS), DELTA);
    }

    @Test
    public void testSubtractionNegative() {
        Assert.assertEquals(-5, test.calculator(-10, -5, MINUS), DELTA);
        Assert.assertEquals(36, test.calculator(30, -6, MINUS), DELTA);
        Assert.assertEquals(-7, test.calculator(-7, 0, MINUS), DELTA);
    }

    @Test
    public void testMultiplyOnlyPositive() {
        Assert.assertEquals(200, test.calculator(40, 5, MULTIPLICATION), DELTA);
        Assert.assertEquals(15000, test.calculator(3, 5000, MULTIPLICATION), DELTA);
        Assert.assertEquals(1, test.calculator(1, 1, MULTIPLICATION), DELTA);
    }

    @Test
    public void testMultiplyNegative() {
        Assert.assertEquals(80, test.calculator(-10, -8, MULTIPLICATION), DELTA);
        Assert.assertEquals(-50, test.calculator(-10, 5, MULTIPLICATION), DELTA);
        Assert.assertEquals(1, test.calculator(-1, -1, MULTIPLICATION), DELTA);
    }

    @Test
    public void testMultiplyByZero() {
        Assert.assertEquals(0, test.calculator(0, -9, MULTIPLICATION), DELTA);
        Assert.assertEquals(0, test.calculator(0, 0, MULTIPLICATION), DELTA);
        Assert.assertEquals(0, test.calculator(1, 0, MULTIPLICATION), DELTA);
    }

    @Test
    public void testDivisionOnlyPositive() {
        Assert.assertEquals(10, test.calculator(50, 5, DIVISION), DELTA);
        Assert.assertEquals(1000, test.calculator(5000, 5, DIVISION), DELTA);
        Assert.assertEquals(1, test.calculator(1, 1, DIVISION), DELTA);
    }

    @Test
    public void testDivisionNegative() {
        Assert.assertEquals(1, test.calculator(-10, -10, DIVISION), DELTA);
        Assert.assertEquals(-4, test.calculator(-20, 5, DIVISION), DELTA);
        Assert.assertEquals(0, test.calculator(0, -11, DIVISION), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator test = new Calculator();
        test.calculator(2, 0, DIVISION);
        test.calculator(-2, 0, DIVISION);
    }

    @Test
    public void testPowOnlyPositive() {
        Assert.assertEquals(100000, test.calculator(10, 5, POWER), DELTA);
        Assert.assertEquals(8, test.calculator(2, 3, POWER), DELTA);
        Assert.assertEquals(1, test.calculator(1, 5, POWER), DELTA);
    }

    @Test
    public void testPowWithNegatives() {
        Assert.assertEquals(100, test.calculator(-10, 2, POWER), DELTA);
        Assert.assertEquals(-1000, test.calculator(-10, 3, POWER), DELTA);
        Assert.assertEquals(-1, test.calculator(-1, 17, POWER), DELTA);
        Assert.assertEquals(1, test.calculator(-1, 20, POWER), DELTA);
        Assert.assertEquals(0.01, test.calculator(10, -3, POWER), DELTA);
        Assert.assertEquals(1, test.calculator(1, -12, POWER), DELTA);
    }

    @Test
    public void testPowZero() {
        Assert.assertEquals(1, test.calculator(60, 0, POWER), DELTA);
        Assert.assertEquals(1, test.calculator(-13, 0, POWER), DELTA);
        Assert.assertEquals(0, test.calculator(0, 10, POWER), DELTA);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownOperator() {
        test.calculator(1, 4, '#');
        test.calculator(2, 5, '=');
        test.calculator(3, 6, '$');
    }
}
