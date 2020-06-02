package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testing {
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        Double expected = 20.0;
        Double actual = calculator.calculate(10, 10, '+');
        Assert.assertEquals(expected, actual);
    }

    public void testSumNegPos() {
        Double expected = 26.0;
        Double actual = calculator.calculate(38, -12, '+');
        Assert.assertEquals(expected, actual);
    }

    public void testSumTwoNeg() {
        Double expected = -26.0;
        Double actual = calculator.calculate(-14, -12, '+');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDif() {
        Double expected = 49.0;
        Double actual = calculator.calculate(54, 5, '-');
        Assert.assertEquals(expected, actual);
    }

    public void testDifPosNeg() {
        Double expected = 79.0;
        Double actual = calculator.calculate(63, -16, '-');
        Assert.assertEquals(expected, actual);
    }

    public void testDifNegPos() {
        Double expected = -51.0;
        Double actual = calculator.calculate(-63, -12, '-');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiv() {
        Double expected = 12.0;
        Double actual = calculator.calculate(36, 3, '/');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDivByZeroPos() {
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = calculator.calculate(36, 0, '/');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDivByZeroNeg() {
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = calculator.calculate(-36, 0, '/');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMult() {
        Double expected = 72.0;
        Double actual = calculator.calculate(36, 2, '*');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultByZero() {
        Double expected = 0.0;
        Double actual = calculator.calculate(36, 0, '*');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultTwoNeg() {
        Double expected = 100.0;
        Double actual = calculator.calculate(-10, -10, '*');
        Assert.assertEquals(expected, actual);
    }

    public void testMultNegPos() {
        Double expected = -93.0;
        Double actual = calculator.calculate(-31, 3, '*');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPow() {
        Double expected = 64.0;
        Double actual = calculator.calculate(8, 2, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegNumberEqualPow() {
        Double expected = 49.0;
        Double actual = calculator.calculate(-7, 2, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegNumberOddPow() {
        Double expected = -125.0;
        Double actual = calculator.calculate(-5, 3, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testZeroPow() {
        Double expected = 1.0;
        Double actual = calculator.calculate(8, 0, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOnePow() {
        Double expected = 93.0;
        Double actual = calculator.calculate(93, 1, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSQRTPow() {
        Double expected = 4.0;
        Double actual = calculator.calculate(16, 0.5, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = ArithmeticException.class)
    public void wrongOperator() {
        Double expected = 16.0;
        Double actual = calculator.calculate(16, 1, '!');
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void nullDigit() {
        Double expected = 1.0;
        Double actual = calculator.calculate(Double.valueOf(null), 1, '!');
        Assert.assertEquals(expected, actual);
    }
}