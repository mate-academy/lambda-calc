package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void addNumbers() {
        Assert.assertEquals(Double.valueOf(5.0), Calculator.calculate(2.0, 3.0, '+'));
        Assert.assertEquals(Double.valueOf(1.0), Calculator.calculate(-2.0, 3.0, '+'));
        Assert.assertEquals(Double.valueOf(-1.0), Calculator.calculate(2.0, -3.0, '+'));
        Assert.assertEquals(Double.valueOf(-5.0), Calculator.calculate(-2.0, -3.0, '+'));
    }

    @Test
    public void multiplyNumbers() {
        Assert.assertEquals(Double.valueOf(6.0), Calculator.calculate(2.0, 3.0, '*'));
        Assert.assertEquals(Double.valueOf(-6.0), Calculator.calculate(-2.0, 3.0, '*'));
        Assert.assertEquals(Double.valueOf(-6.0), Calculator.calculate(2.0, -3.0, '*'));
        Assert.assertEquals(Double.valueOf(6.0), Calculator.calculate(-2.0, -3.0, '*'));
    }

    @Test
    public void divideNumbers() {
        Assert.assertEquals(Double.valueOf(0.6666666666666666), Calculator.calculate(2.0, 3.0, '/'));
        Assert.assertEquals(Double.valueOf(-0.6666666666666666), Calculator.calculate(-2.0, 3.0, '/'));
        Assert.assertEquals(Double.valueOf(-0.6666666666666666), Calculator.calculate(2.0, -3.0, '/'));
        Assert.assertEquals(Double.valueOf(0.6666666666666666), Calculator.calculate(-2.0, -3.0, '/'));
    }

    @Test(expected = ArithmeticException.class)
    public void dividedByZero() {
        Calculator.calculate(2.0, 0, '/');
    }

    @Test
    public void subtractNumbers() {
        Assert.assertEquals(Double.valueOf(-1.0), Calculator.calculate(2.0, 3.0, '-'));
        Assert.assertEquals(Double.valueOf(-5.0), Calculator.calculate(-2.0, 3.0, '-'));
        Assert.assertEquals(Double.valueOf(5.0), Calculator.calculate(2.0, -3.0, '-'));
        Assert.assertEquals(Double.valueOf(1.0), Calculator.calculate(-2.0, -3.0, '-'));
    }

    @Test(expected = NullPointerException.class)
    public void incorrectOperation() {
        Calculator.calculate(2,3,  's');
    }

    @Test(expected = NullPointerException.class)
    public void unavailableOperation() {
        Calculator.calculate(2,3,  '%');
    }
}
