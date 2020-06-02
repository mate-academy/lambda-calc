package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-6;

    @Test
    public void addNumbers() {
        Assert.assertEquals(5.0, Calculator.calculate(2.0, 3.0, '+'), DELTA);
        Assert.assertEquals(1.0, Calculator.calculate(-2.0, 3.0, '+'), DELTA);
        Assert.assertEquals(-1.0, Calculator.calculate(2.0, -3.0, '+'), DELTA);
        Assert.assertEquals(-5.0, Calculator.calculate(-2.0, -3.0, '+'), DELTA);
    }

    @Test
    public void multiplyNumbers() {
        Assert.assertEquals(6.0, Calculator.calculate(2.0, 3.0, '*'), DELTA);
        Assert.assertEquals(-6.0, Calculator.calculate(-2.0, 3.0, '*'), DELTA);
        Assert.assertEquals(-6.0, Calculator.calculate(2.0, -3.0, '*'), DELTA);
        Assert.assertEquals(6.0, Calculator.calculate(-2.0, -3.0, '*'), DELTA);
    }

    @Test
    public void divideNumbers() {
        Assert.assertEquals(0.6666666666666666, Calculator.calculate(2.0, 3.0, '/'), DELTA);
        Assert.assertEquals(-0.6666666666666666, Calculator.calculate(-2.0, 3.0, '/'), DELTA);
        Assert.assertEquals(-0.6666666666666666, Calculator.calculate(2.0, -3.0, '/'), DELTA);
        Assert.assertEquals(0.6666666666666666, Calculator.calculate(-2.0, -3.0, '/'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void dividedByZero() {
        Calculator.calculate(2.0, 0, '/');
    }

    @Test
    public void subtractNumbers() {
        Assert.assertEquals(-1.0, Calculator.calculate(2.0, 3.0, '-'), DELTA);
        Assert.assertEquals(-5.0, Calculator.calculate(-2.0, 3.0, '-'), DELTA);
        Assert.assertEquals(5.0, Calculator.calculate(2.0, -3.0, '-'), DELTA);
        Assert.assertEquals(1.0, Calculator.calculate(-2.0, -3.0, '-'), DELTA);
    }

    @Test
    public void exponentialNumber() {
        Assert.assertEquals(25.0, Calculator.calculate(5.0,2.0, '^'), DELTA);
        Assert.assertEquals(2, Calculator.calculate(4.0,0.5, '^'), DELTA);
        Assert.assertEquals(-0.015625, Calculator.calculate(-4.0,-3.0, '^'), DELTA);
        Assert.assertEquals(0.015625, Calculator.calculate(4.0,-3.0, '^'), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectOperation() {
        Calculator.calculate(2,3,  's');
    }

    @Test(expected = IllegalArgumentException.class)
    public void unavailableOperation() {
        Calculator.calculate(2,3,  '%');
    }
}
