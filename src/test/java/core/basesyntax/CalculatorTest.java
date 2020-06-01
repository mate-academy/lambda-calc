package core.basesyntax;

import core.basesyntax.exeption.DataProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addPositiveNumbers() {
        Assert.assertEquals(Double.valueOf(6), Calculator.calculate(2.56, 3.44, '+'));
    }

    @Test
    public void addPositiveAndNegativeNumbers() {
        Assert.assertEquals(Double.valueOf(-0.88), Calculator.calculate(2.56, -3.44, '+'), 2);
    }

    @Test
    public void addNegativeNumbers() {
        Assert.assertEquals(Double.valueOf(-6), Calculator.calculate(-2.56, -3.44, '+'));
    }

    @Test
    public void subtractPositiveNumbers() {
        Assert.assertEquals(Double.valueOf(-0.88), Calculator.calculate(2.56, 3.44, '-'),2);
    }

    @Test
    public void subtractPositiveAndNegativeNumbers() {
        Assert.assertEquals(Double.valueOf(6), Calculator.calculate(2.56, -3.44, '-'));
    }

    @Test
    public void subtractNegativeNumbers() {
        Assert.assertEquals(Double.valueOf(0.88), Calculator.calculate(-2.56, -3.44, '-'),2);
    }

    @Test
    public void multiplyPositiveNumbers() {
        Assert.assertEquals(Double.valueOf(9), Calculator.calculate(3.0, 3.0, '*'));
    }
    @Test
    public void multiplyPositiveAndNegativeNumbers() {
        Assert.assertEquals(Double.valueOf(-9), Calculator.calculate(3.0, -3.0, '*'));
    }

    @Test
    public void multiplyByZero() {
        Assert.assertEquals(Double.valueOf(0), Calculator.calculate(6.0, 0.0, '*'));
    }

    @Test
    public void powerPositiveNumbers() {
        Assert.assertEquals(Double.valueOf(36), Calculator.calculate(6.0, 2.0, '^'));
    }

    @Test
    public void powerPositiveAndNegativeNumbers() {
        Assert.assertEquals(Double.valueOf(0.111), Calculator.calculate(9.0, -1.0, '^'),3);
    }

    @Test
    public void powerNegativeAndPositiveNumbers() {
        Assert.assertEquals(Double.valueOf(36), Calculator.calculate(-6.0, 2.0, '^'));
    }

    @Test
    public void powerNegativeNumbers() {
        Assert.assertEquals(Double.valueOf(-0.1666), Calculator.calculate(-6.0, -1.0, '^'),2);
    }

    @Test
    public void dividePositiveNumbers() {
        Assert.assertEquals(Double.valueOf(1), Calculator.calculate(6.0, 6.0, '/'));
    }

    @Test(expected = AssertionError.class)
    public void divideByZero() {
        Calculator.calculate(6.0, 0.0, '/');
        Assert.fail("Sorry, we don't can device by zero!");

    }

    @Test(expected = DataProcessingException.class)
    public void setNotValidSign() {
        Calculator.calculate(6.0, 3.0, 'x');
    }

}