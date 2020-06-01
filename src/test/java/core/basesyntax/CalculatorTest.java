package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addition() {
        Assert.assertEquals(3, Calculator.calculate(1, 2, '+'));
        Assert.assertEquals(-3, Calculator.calculate(-1, -2, '+'));
        Assert.assertEquals(1, Calculator.calculate(-1, 2, '+'));
    }

    @Test
    public void subtraction() {
        Assert.assertEquals(1, Calculator.calculate(3, 2, '-'));
        Assert.assertEquals(-1, Calculator.calculate(-3, -2, '-'));
        Assert.assertEquals(-5, Calculator.calculate(-3, 2, '-'));
    }

    @Test
    public void multiplication() {
        Assert.assertEquals(6, Calculator.calculate(3, 2, '*'));
        Assert.assertEquals(6, Calculator.calculate(-3, -2, '*'));
        Assert.assertEquals(-6, Calculator.calculate(-3, 2, '*'));
    }

    @Test
    public void division() {
        Assert.assertEquals(2, Calculator.calculate(6, 3, '/'));
        Assert.assertEquals(2, Calculator.calculate(-6, -3, '/'));
        Assert.assertEquals(-2, Calculator.calculate(-6, 3, '/'));
    }

    @Test
    public void exponentiation() {
        Assert.assertEquals(4, Calculator.calculate(2, 2, '^'));
        Assert.assertEquals(4, Calculator.calculate(-2, 2, '^'));
        Assert.assertEquals(0, Calculator.calculate(2, -2, '^'));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() throws ArithmeticException {
        Calculator.calculate(3, 0, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void unavailableOperation() throws IllegalArgumentException {
        Calculator.calculate(3, 2, '%');
    }
}
