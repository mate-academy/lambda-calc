package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.001;
    private static Calculator calculator;

    @BeforeClass
    public static void before() {
        calculator = new Calculator();
    }

    @Test
    public void sumValidTest() {
        double result = calculator.calculate(10d, 20d, '+');
        Assert.assertEquals(30d, result, DELTA);
        result = calculator.calculate(10d, 0d, '+');
        Assert.assertEquals(10d, result, DELTA);
        result = calculator.calculate(10.501, 20.302, '+');
        Assert.assertEquals(30.803, result, DELTA);
    }

    @Test
    public void sumInValidTest() {
        double result = calculator.calculate(10d, 20d, '+');
        Assert.assertNotEquals(35d, result);
    }

    @Test(expected = NullPointerException.class)
    public void sumNullTest() {
        Double a = null;
        double result = calculator.calculate(10d, a, '+');
    }

    @Test
    public void subValidTest() {
        double result = calculator.calculate(50D, 20D, '-');
        Assert.assertEquals(30d, result, DELTA);
        result = calculator.calculate(10D, 0D, '-');
        Assert.assertEquals(10d, result, DELTA);
        result = calculator.calculate(50.505, 20.302, '-');
        Assert.assertEquals(30.203, result, DELTA);
    }

    @Test
    public void subInValidTest() {
        double result = calculator.calculate(10d, 20d, '-');
        Assert.assertNotEquals(35d, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void subNullTest() {
        Double a = null;
        Double result = calculator.calculate(10d, a, '-');
    }

    @Test
    public void multValidTest() {
        double result = calculator.calculate(10d, 20d, '*');
        Assert.assertEquals(200d, result, DELTA);
        result = calculator.calculate(10d, 0d, '*');
        Assert.assertEquals(0d, result, DELTA);
        result = calculator.calculate(10.5, 20.3, '*');
        Assert.assertEquals(213.15, result, DELTA);
    }

    @Test
    public void multInValidTest() {
        double result = calculator.calculate(10d, 20d, '*');
        Assert.assertNotEquals(35d, result);
    }

    @Test(expected = NullPointerException.class)
    public void multNullTest() {
        Double a = null;
        double result = calculator.calculate(10d, a, '*');
    }

    @Test
    public void divValidTest() {
        double result = calculator.calculate(40d, 20d, '/');
        Assert.assertEquals(2d, result, DELTA);
        result = calculator.calculate(0d, 10d, '/');
        Assert.assertEquals(0d, result, DELTA);
        result = calculator.calculate(10.2, 20.4, '/');
        Assert.assertEquals(0.5, result, DELTA);
    }

    @Test
    public void divInValidTest() {
        double result = calculator.calculate(10d, 20d, '/');
        Assert.assertNotEquals(35d, result);
    }

    @Test(expected = NullPointerException.class)
    public void divNullTest() {
        Double a = null;
        double result = calculator.calculate(10d, a, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void divZeroTest() {
        double result = calculator.calculate(10d, 0, '/');
    }

    @Test
    public void powValidTest() {
        double result = calculator.calculate(2d, 10d, '^');
        Assert.assertEquals(1024d, result, DELTA);
        result = calculator.calculate(4d, 2d, '^');
        Assert.assertEquals(16d, result, DELTA);
        result = calculator.calculate(16, 0.5, '^');
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void powInValidTest() {
        double result = calculator.calculate(10d, 2d, '^');
        Assert.assertNotEquals(10d, result);
    }

    @Test(expected = NullPointerException.class)
    public void powNullTest() {
        Double a = null;
        double result = calculator.calculate(10d, a, '^');
    }

    @Test(expected = NullPointerException.class)
    public void wrongArgument() {
        double result = calculator.calculate(10d, 20d, 'a');
    }
}
