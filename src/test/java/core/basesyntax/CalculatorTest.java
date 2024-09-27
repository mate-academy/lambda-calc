package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.01;
    private static Calculator calculator;

    @BeforeClass
    public static void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        Assert.assertEquals(7, calculator.calculate('+', 2, 5), DELTA);
        Assert.assertEquals(3, calculator.calculate('+', -2, 5), DELTA);
        Assert.assertEquals(2, calculator.calculate('+', 2, 0), DELTA);
        Assert.assertEquals(0, calculator.calculate('+', 0, 0), DELTA);
    }

    @Test
    public void subtractTest() {
        Assert.assertEquals(-3, calculator.calculate('-', 2, 5), DELTA);
        Assert.assertEquals(-7, calculator.calculate('-', -2, 5), DELTA);
        Assert.assertEquals(3, calculator.calculate('-', -2, -5), DELTA);
        Assert.assertEquals(-3, calculator.calculate('-', 0, 3), DELTA);
    }

    @Test
    public void multiplyTest() {
        Assert.assertEquals(10, calculator.calculate('*', 2, 5), DELTA);
        Assert.assertEquals(10, calculator.calculate('*', -2, -5), DELTA);
        Assert.assertEquals(0, calculator.calculate('*', 2, 0), DELTA);
        Assert.assertEquals(-10, calculator.calculate('*', -2, 5), DELTA);
    }

    @Test
    public void toPowerTest() {
        Assert.assertEquals(32, calculator.calculate('^', 2, 5), DELTA);
        Assert.assertEquals(1, calculator.calculate('^', 2, 0), DELTA);
        Assert.assertEquals(0, calculator.calculate('^', 5, -10), DELTA);
    }

    @Test
    public void divideTest() {
        Assert.assertEquals(0, calculator.calculate('/', 2, 5), DELTA);
        Assert.assertEquals(-2, calculator.calculate('/', 4, -2), DELTA);
        Assert.assertEquals(2, calculator.calculate('/', -2, -1), DELTA);
        Assert.assertEquals(0, calculator.calculate('/', 0, 5), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.calculate('/', 5, 0);
    }

    @Test(expected = NoSuchAOperationException.class)
    public void invalidArgument() {
        calculator.calculate(')', 8, 9);
    }
}
