package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void subtractWithPositiveValues() {
        Assert.assertEquals(2L, calculator.calculate(4L, 2L, '-'));
    }

    @Test
    public void subtractWithZero() {
        Assert.assertEquals(2L, calculator.calculate(2L, 0L, '-'));
    }

    @Test
    public void sumWithPositiveValues() {
        Assert.assertEquals(8L, calculator.calculate(2L, 6L, '+'));
        Assert.assertEquals(200L, calculator.calculate(200L, 0L, '+'));
        Assert.assertEquals(0L, calculator.calculate(0L, 0L, '+'));
    }

    @Test
    public void multiplyWithPositiveValues() {
        Assert.assertEquals(4L, calculator.calculate(2L, 2L, '*'));
        Assert.assertEquals(300L, calculator.calculate(150L, 2L, '*'));
        Assert.assertEquals(12L, calculator.calculate(4L, 3L, '*'));
    }

    @Test
    public void multiplyWithNegativeValues() {
        Assert.assertEquals(22L, calculator.calculate(-2L, -11L, '*'));
        Assert.assertEquals(-22L, calculator.calculate(-2L, 11L, '*'));
        Assert.assertEquals(-6L, calculator.calculate(2L, -3L, '*'));
    }

    @Test
    public void divideWithPositiveValues() {
        Assert.assertEquals(2L, calculator.calculate(22L, 11L, '/'));
        Assert.assertEquals(1L, calculator.calculate(22L, 22L, '/'));
        Assert.assertEquals(3L, calculator.calculate(33L, 11L, '/'));
    }

    @Test
    public void divideWithNegativeValues() {
        Assert.assertEquals(-2L, calculator.calculate(-22L, 11L, '/'));
        Assert.assertEquals(1L, calculator.calculate(-22L, -22L, '/'));
        Assert.assertEquals(-33L, calculator.calculate(33L, -1L, '/'));
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.calculate(2L, 0L, '/');
        Assert.fail("ArithmeticException should be thrown when divide by zero");
    }

    @Test
    public void powerWithPositiveValues() {
        Assert.assertEquals(4L, calculator.calculate(2L, 2L, '^'));
        Assert.assertEquals(27L, calculator.calculate(3L, 3L, '^'));
    }

    @Test
    public void powerToZero() {
        Assert.assertEquals(1L, calculator.calculate(34567L, 0L, '^'));
    }

    @Test
    public void powerZeroToPositiveValue() {
        Assert.assertEquals(0L, calculator.calculate(0L, 56L, '^'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonexistentOperation(){
        calculator.calculate(90L, 78L, '@');
        Assert.fail("IllegalArgumentException should be thrown if operation not exist");
    }
}
