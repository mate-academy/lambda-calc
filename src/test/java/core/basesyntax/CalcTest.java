package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {

    private static final double DELTA = 0.0001;
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void addPositive() {
        Assert.assertEquals(2, calculator.calculate(1, 1, '+'), DELTA);
    }

    @Test
    public void addNegative() {
        Assert.assertEquals(-10, calculator.calculate(-5, -5, '+'), DELTA);
    }

    @Test
    public void subPositive() {
        Assert.assertEquals(5, calculator.calculate(10, 5, '-'), DELTA);
    }

    @Test
    public void subNegative() {
        Assert.assertEquals(-5, calculator.calculate(-10, -5, '-'), DELTA);
    }

    @Test
    public void mulPositive() {
        Assert.assertEquals(25, calculator.calculate(5, 5, '*'), DELTA);
    }

    @Test
    public void mulByZero() {
        Assert.assertEquals(0, calculator.calculate(5, 0, '*'), DELTA);
    }

    @Test
    public void mulByNegative() {
        Assert.assertEquals(25, calculator.calculate(-5, -5, '*'), DELTA);
    }

    @Test
    public void mulByOneNegative() {
        Assert.assertEquals(-25, calculator.calculate(-5, 5, '*'), DELTA);
    }

    @Test
    public void divPositive() {
        Assert.assertEquals(5, calculator.calculate(25, 5, '/'), DELTA);
    }

    @Test
    public void divByOneNegative() {
        Assert.assertEquals(-5, calculator.calculate(25, -5, '/'), DELTA);
    }

    @Test
    public void divNegative() {
        Assert.assertEquals(5, calculator.calculate(-25, -5, '/'), DELTA);
    }

    @Test
    public void powerPositive() {
        Assert.assertEquals(125, calculator.calculate(5, 3, '^'), DELTA);
    }

    @Test
    public void powerWithNegativeNum() {
        Assert.assertEquals(0.04, calculator.calculate(5, -2, '^'), DELTA);
    }

    @Test
    public void powerByZero() {
        Assert.assertEquals(1, calculator.calculate(9999, 0, '^'), DELTA);
    }

    @Test
    public void divByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(5, 0, '/'), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperationMark() {
        calculator.calculate(5, 5, '@');
    }

    @Test(expected = NullPointerException.class)
    public void wrongNullOperator() {
        Double a = null;
        calculator.calculate(a, a, '^');
    }
}
