package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void sumIsValid() {
        double expected = 51.12;
        Calculator calculator = new Calculator('+', 15, 36.12);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void subtractionIsValid() {
        double expected = -77.77;
        Calculator calculator = new Calculator('-', 58.45, 136.22);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void multiplicationIsValid() {
        double expected = -2251.388;
        Calculator calculator = new Calculator('*', -24.4, 92.27);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void divisionIsValid() {
        double expected = -31.1;
        Calculator calculator = new Calculator('/', 124.4, -4);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void powIsValid() {
        double expected = 1771561;
        Calculator calculator = new Calculator('^', 11, 6);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        Calculator calculator = new Calculator('/', 124.4, 0);
        calculator.result();
    }

    @Test
    public void powByZeroIsValid() {
        double expected = 1;
        Calculator calculator = new Calculator('^', 56.4, 0);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void multiplicationByZeroIsValid() {
        double expected = 0;
        Calculator calculator = new Calculator('*', 11, 0);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void powByNegativeNumberIsValid() {
        double expected = 0.015625;
        Calculator calculator = new Calculator('^', 8, -2);
        Assert.assertEquals(expected, calculator.result(), 0);
    }
}
