package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculationTests {
    private static final Double DELTA = 0.0000001;
    private Calculator calculator;

    @Before
    public void stetUp() {
        calculator = new Calculator();
    }

    @Test
    public void isSumIntOk() {
        Assert.assertEquals(30d,
                calculator.calculate(10d, 20d, '+'), DELTA);
    }

    @Test
    public void isSumFloatOk() {
        Assert.assertEquals(30.33,
                calculator.calculate(10.11, 20.22, '+'), DELTA);
    }

    @Test
    public void isSumZeroesOk() {
        Assert.assertEquals(0d,
                calculator.calculate(0d, 0d, '+'), DELTA);
    }

    @Test
    public void isSumNegativesOk() {
        Assert.assertEquals(-31d,
                calculator.calculate(-13d,-18d, '+'), DELTA);
    }

    @Test
    public void isDiffIntOk() {
        Assert.assertEquals(20d,
                calculator.calculate(30d, 10d, '-'), DELTA);
    }

    @Test
    public void isDiffFloatOk() {
        Assert.assertEquals(10.12,
                calculator.calculate(30.23, 20.11, '-'), DELTA);
    }

    @Test
    public void isDiffZeroesOk() {
        Assert.assertEquals(0d,
                calculator.calculate(0d,0d, '-'), DELTA);
    }

    @Test
    public void isDiffNegativesOk() {
        Assert.assertEquals(1d,
                calculator.calculate(-5d, -6d, '-'), DELTA);
    }

    @Test
    public void isMultiplyIntOk() {
        Assert.assertEquals(6d,
                calculator.calculate(2d, 3d, '*'), DELTA);
    }

    @Test
    public void isMultiplyFloatOk() {
        Assert.assertEquals(8.4,
                calculator.calculate(3.5,2.4, '*'), DELTA);
    }

    @Test
    public void isMultiplyZeroOk() {
        Assert.assertEquals(0d,
                calculator.calculate(10d, 0d, '*'), DELTA);
    }

    @Test
    public void isMultiplyZeroesOk() {
        Assert.assertEquals(0d,
                calculator.calculate(0d,0d, '*'), DELTA);
    }

    @Test
    public void isMultiplyNegativeOk() {
        Assert.assertEquals(-30d,
                calculator.calculate(-3d,10d, '*'), DELTA);
    }

    @Test
    public void isMultiplyNegativesOk() {
        Assert.assertEquals(30d,
                calculator.calculate(-3d, -10d, '*'), DELTA);
    }

    @Test
    public void isDivisionIntOk() {
        Assert.assertEquals(5d,
                calculator.calculate(10d, 2d, '/'), DELTA);
    }

    @Test
    public void isDivisionFloatOk() {
        Assert.assertEquals(4d,
                calculator.calculate(8.8,2.2, '/'), DELTA);
    }

    @Test
    public void isDivisionZeroDividendOk() {
        Assert.assertEquals(0d,
                calculator.calculate(0d, 5d, '/'), DELTA);
    }

    @Test
    public void isDivisionZeroDivisorOk() {
        Assert.assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(10d, 0d, '/'), DELTA);

    }

    @Test
    public void isDivisionNegativeOk() {
        Assert.assertEquals(-4d,
                calculator.calculate(-8d, 2d, '/'), DELTA);
    }

    @Test
    public void isDivisionNegativesOk() {
        Assert.assertEquals(4d,
                calculator.calculate(-8d,-2d, '/'), DELTA);
    }

    @Test
    public void isPowerIntOk() {
        Assert.assertEquals(8d,
                calculator.calculate(2d, 3d, '^'), DELTA);
    }

    @Test
    public void isPowerBaseFloatOk() {
        Assert.assertEquals(10.648,
                calculator.calculate(2.2 ,3d, '^'), DELTA);
    }

    @Test
    public void isPowerBaseZeroOk() {
        Assert.assertEquals(0d,
                calculator.calculate(0d,3d, '^'), DELTA);
    }

    @Test
    public void isPowerBaseNegativeOk() {
        Assert.assertEquals(-8d,
                calculator.calculate(-2d,3d, '^'), DELTA);
    }

    @Test
    public void isPowerExponentZeroOk() {
        Assert.assertEquals(1d,
                calculator.calculate(0d,0d, '^'), DELTA);
    }

    @Test
    public void isPowerExponentNegativeOk() {
        Assert.assertEquals(0.04,
                calculator.calculate(5d,-2d, '^'), DELTA);
    }
}
