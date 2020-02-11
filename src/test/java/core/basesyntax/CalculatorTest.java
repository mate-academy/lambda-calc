package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private static final double DELTA = 0.01;

    Calculator calculator = new Calculator();

    @Test
    public void calculatePositiveValues() {
        Assert.assertEquals(3, calculator.calculate(1, 2, '+'), DELTA);
        Assert.assertEquals(4, calculator.calculate(6, 2, '-'), DELTA);
        Assert.assertEquals(0.5, calculator.calculate(1, 2, '/'), DELTA);
        Assert.assertEquals(10, calculator.calculate(5, 2, '*'), DELTA);
        Assert.assertEquals(100, calculator.calculate(10, 2, '^'), DELTA);
    }

    @Test
    public void calculateNegativeValues() {
        Assert.assertEquals(-3, calculator.calculate(-1, -2, '+'), DELTA);
        Assert.assertEquals(-4, calculator.calculate(-6, -2, '-'), DELTA);
        Assert.assertEquals(0.5, calculator.calculate(-1, -2, '/'), DELTA);
        Assert.assertEquals(-0.5, calculator.calculate(-1, 2, '/'), DELTA);
        Assert.assertEquals(10, calculator.calculate(-5, -2, '*'), DELTA);
        Assert.assertEquals(-10, calculator.calculate(-5, 2, '*'), DELTA);
        Assert.assertEquals(9, calculator.calculate(-3, 2, '^'), DELTA);
        Assert.assertEquals(0.01, calculator.calculate(-10, -2, '^'), DELTA);
        Assert.assertEquals(100, calculator.calculate(-10, 2, '^'), DELTA);
    }

    @Test
    public void calculateFirstZeroValue() {
        Assert.assertEquals(-2, calculator.calculate(0, -2, '+'), DELTA);
        Assert.assertEquals(2, calculator.calculate(0, -2, '-'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, -2, '/'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, 2, '*'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, 2, '^'), DELTA);
    }

    @Test
    public void calculateSecondZeroValue() {
        Assert.assertEquals(4, calculator.calculate(4, 0, '+'), DELTA);
        Assert.assertEquals(5, calculator.calculate(5, 0, '-'), DELTA);
        Assert.assertEquals(Math.abs(Double.POSITIVE_INFINITY), calculator
                .calculate(6, 0, '/'), DELTA);
        Assert.assertEquals(Math.abs(Double.POSITIVE_INFINITY), calculator
                .calculate(6, -0, '/'), DELTA);
        Assert.assertEquals(0, calculator.calculate(7, 0, '*'), DELTA);
        Assert.assertEquals(1, calculator.calculate(8, 0, '^'), DELTA);
    }

    @Test
    public void wrongOperator() {
        try {
            calculator.calculate(1, 1, 'H');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }
}
