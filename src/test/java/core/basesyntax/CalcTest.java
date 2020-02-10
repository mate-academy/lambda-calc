package core.basesyntax;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {

    private static final double DELTA = 0.0001;
    private Calc calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calc();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addPositive() {
        Assert.assertEquals(2, calc.calculate(1, 1, '+'), DELTA);
    }

    @Test
    public void addNegative() {
        Assert.assertEquals(-10, calc.calculate(-5, -5, '+'), DELTA);
    }

    @Test
    public void subPositive() {
        Assert.assertEquals(5, calc.calculate(10, 5, '-'), DELTA);
    }

    @Test
    public void subNegative() {
        Assert.assertEquals(-5, calc.calculate(-10, -5, '-'), DELTA);
    }

    @Test
    public void mulPositive() {
        Assert.assertEquals(25, calc.calculate(5, 5, '*'), DELTA);
    }

    @Test
    public void mulByZero() {
        Assert.assertEquals(0, calc.calculate(5, 0, '*'), DELTA);
    }

    @Test
    public void divPositive() {
        Assert.assertEquals(5, calc.calculate(25, 5, '/'), DELTA);
    }

    @Test
    public void powerPositive() {
        Assert.assertEquals(125, calc.calculate(5, 3, '^'), DELTA);
    }

    @Test
    public void powerWithNegativeNum() {
        Assert.assertEquals(0.04, calc.calculate(5, -2, '^'), DELTA);
    }

    @Test
    public void powBy0() {
        Assert.assertEquals(1, calc.calculate(9999, 0, '^'), DELTA);
    }

    @Test
    public void divByZero() {
        calc.calculate(5, 0, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperationMark() {
        calc.calculate(5, 5, '@');
    }

    @Test(expected = NullPointerException.class)
    public void wrongNullOperator() {
        Double a = null;
        calc.calculate(a, a, '^');
    }
}
