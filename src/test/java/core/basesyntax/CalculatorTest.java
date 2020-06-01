package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addSimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(3), Calculator.calculate(1, 2, '+'));
    }

    @Test
    public void addNegativeNumbers() throws CalculateException {
        Assert.assertEquals(Integer.valueOf(-12), Calculator.calculate(-2, -10, '+'));
    }

    @Test
    public void subtractSimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(2), Calculator.calculate(4, 2, '-'));
    }

    @Test
    public void subtractNegativeNumbers() {
        Assert.assertEquals(Integer.valueOf(-2), Calculator.calculate(-4, -2, '-'));
    }

    @Test
    public void multiplySimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(4), Calculator.calculate(2, 2, '*'));
    }

    @Test
    public void multiplyByZero() {
        Assert.assertEquals(Integer.valueOf(0), Calculator.calculate(0, 2, '*'));
    }

    @Test
    public void divideSimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(1), Calculator.calculate(2, 2, '/'));
    }

    @Test(expected = CalculateException.class)
    public void divideByZero() {
        Assert.assertEquals(Integer.valueOf(1), Calculator.calculate(2, 0, '/'));
    }

    @Test(expected = CalculateException.class)
    public void setNotValidSign() {
        Calculator.calculate(2, 2, 's');
    }
}
