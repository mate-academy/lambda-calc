package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testing {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        Double expected = 20.0;
        Double actual = calculator.calculation(10, 10, '+');
        Assert.assertEquals(expected, actual);
    }

    public void testSumNegPos() {
        Double expected = 26.0;
        Double actual = calculator.calculation(38, -12, '+');
        Assert.assertEquals(expected, actual);
    }

    public void testSumTwoNeg() {
        Double expected = -26.0;
        Double actual = calculator.calculation(-14, -12, '+');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDif() {
        Double expected = 49.0;
        Double actual = calculator.calculation(54, 5, '-');
        Assert.assertEquals(expected, actual);
    }

    public void testDifPosNeg() {
        Double expected = 79.0;
        Double actual = calculator.calculation(63, -16, '-');
        Assert.assertEquals(expected, actual);
    }

    public void testDifNegPos() {
        Double expected = -51.0;
        Double actual = calculator.calculation(-63, -12, '-');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiv() {
        Double expected = 12.0;
        Double actual = calculator.calculation(36, 3, '/');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDivByZeroPos() {
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = calculator.calculation(36, 0, '/');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDivByZeroNeg() {
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = calculator.calculation(-36, 0, '/');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMult() {
        Double expected = 72.0;
        Double actual = calculator.calculation(36, 2, '*');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultByZero() {
        Double expected = 0.0;
        Double actual = calculator.calculation(36, 0, '*');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultTwoNeg() {
        Double expected = 100.0;
        Double actual = calculator.calculation(-10, -10, '*');
        Assert.assertEquals(expected, actual);
    }

    public void testMultNegPos() {
        Double expected = -93.0;
        Double actual = calculator.calculation(-31, 3, '*');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPow() {
        Double expected = 64.0;
        Double actual = calculator.calculation(8, 2, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegNumberEqualPow() {
        Double expected = 49.0;
        Double actual = calculator.calculation(-7, 2, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegNumberOddPow() {
        Double expected = -125.0;
        Double actual = calculator.calculation(-5, 3, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testZeroPow() {
        Double expected = 1.0;
        Double actual = calculator.calculation(8, 0, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOnePow() {
        Double expected = 93.0;
        Double actual = calculator.calculation(93, 1, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSQRTPow() {
        Double expected = 4.0;
        Double actual = calculator.calculation(16, 0.5, '^');
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = ArithmeticException.class)
    public void wrongOperator() {
        Double expected = 16.0;
        Double actual = calculator.calculation(16, 1, '!');
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void nullDigit() {
        Double expected = 1.0;
        Double actual = calculator.calculation(Double.valueOf(null), 1, '!');
        Assert.assertEquals(expected, actual);
    }

}