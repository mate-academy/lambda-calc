package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class TestUnit {

    public void sumIsValid() {
        double expected = 222.1;
        Calculator calculator =
                new Calculator('+', 196, 26.1);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void subtractionIsValid() {
        double expected = -61.71;
        Calculator calculator =
                new Calculator('-', 38.41, 100.12);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void multiplicationIsValid() {
        double expected = -12;
        Calculator calculator =
                new Calculator('*', -2.4, 5);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void divisionIsValid() {
        double expected = -3;
        Calculator calculator =
                new Calculator('/', 12, -4);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void powIsValid() {
        double expected = 100;
        Calculator calculator =
                new Calculator('^', 10, 2);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        Calculator calculator =
                new Calculator('/', 10, 0);
        calculator.result();
    }

    @Test
    public void powByZeroIsValid() {
        double expected = 1;
        Calculator calculator = new Calculator('^', 12, 0);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void multiplicationByZeroIsValid() {
        double expected = 0;
        Calculator calculator = new Calculator('*', 1, 0);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test
    public void powByNegativeNumberIsValid() {
        double expected = 0.015625;
        Calculator calculator = new Calculator('^', 8, -2);
        Assert.assertEquals(expected, calculator.result(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidOperations() {
        Calculator calculator = new Calculator('#', 8.0, 7.2);
        Assert.assertEquals(2, calculator.result(), 0);
    }
}
