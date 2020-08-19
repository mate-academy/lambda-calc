package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private static final double DELTA = 0.000_000_001;
    private static Calculator calculator;
    private static double result;

    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionIsOk() {
        result = calculator.calculate(-22, -10, '+');
        Assert.assertEquals(-32, result, DELTA);
        result = calculator.calculate(13, 7, '+');
        Assert.assertEquals(20, result, DELTA);
        result = calculator.calculate(0, 0, '+');
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void subtractionIsOk() {
        result = calculator.calculate(100, 10, '-');
        Assert.assertEquals(90, result, DELTA);
        result = calculator.calculate(-10, -7, '-');
        Assert.assertEquals(-3, result, DELTA);
        result = calculator.calculate(-10, 5, '-');
        Assert.assertEquals(-15, result, DELTA);
    }

    @Test
    public void divisionIsOk() {
        result = calculator.calculate(100, 10, '/');
        Assert.assertEquals(10, result, DELTA);
        result = calculator.calculate(-10, 2, '/');
        Assert.assertEquals(-5, result, DELTA);
        result = calculator.calculate(-44, -2, '/');
        Assert.assertEquals(22, result, DELTA);
    }

    @Test
    public void multiplicationIsOk() {
        result = calculator.calculate(10, 10, '*');
        Assert.assertEquals(100, result, DELTA);
        result = calculator.calculate(25, 0, '*');
        Assert.assertEquals(0, result, DELTA);
        result = calculator.calculate(-15, 10, '*');
        Assert.assertEquals(-150, result, DELTA);
    }

    @Test
    public void powerRaisingIsOk() {
        result = calculator.calculate(10, 2, '^');
        Assert.assertEquals(100, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        result = calculator.calculate(15, 0, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalActionTest() {
        result = calculator.calculate(15, 15, '&');
    }
}