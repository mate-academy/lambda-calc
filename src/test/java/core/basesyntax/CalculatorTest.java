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
    public void sumWholeValidTest() {
        double result = calculator.calculate(10d, 20d, '+');
        Assert.assertEquals(30d, result, DELTA);
        result = calculator.calculate(20d, 10d, '+');
        Assert.assertEquals(30d, result, DELTA);
        result = calculator.calculate(10d, 0d, '+');
        Assert.assertEquals(10d, result, DELTA);
        result = calculator.calculate(0d, 20d, '+');
        Assert.assertEquals(20d, result, DELTA);
    }

    @Test
    public void sumDecimalValidTest() {
        double result = calculator.calculate(10.54, 20.36, '+');
        Assert.assertEquals(30.9, result, DELTA);
        result = calculator.calculate(16.37, 7.54, '+');
        Assert.assertEquals(23.91, result, DELTA);
    }

    @Test
    public void sumInValidTest() {
        double result = calculator.calculate(10d, 20d, '+');
        Assert.assertNotEquals(-10d, result, DELTA);
        result = calculator.calculate(10.999, 1.111, '+');
        Assert.assertNotEquals(12d, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void sumNullTest() {
        Double a = null;
        double result = calculator.calculate(10d, a, '+');
    }

    @Test
    public void subWholeValidTest() {
        double result = calculator.calculate(50d, 20d, '-');
        Assert.assertEquals(30d, result, DELTA);
        result = calculator.calculate(10d, 20d, '-');
        Assert.assertEquals(-10d, result, DELTA);
        result = calculator.calculate(10d, 0d, '-');
        Assert.assertEquals(10d, result, DELTA);
        result = calculator.calculate(0d, 25d, '-');
        Assert.assertEquals(-25d, result, DELTA);
    }

    @Test
    public void subDecimalValidTest() {
        double result = calculator.calculate(32.756, 17.342, '-');
        Assert.assertEquals(15.414, result, DELTA);
        result = calculator.calculate(13.582, 24.732, '-');
        Assert.assertEquals(-11.15, result, DELTA);
    }

    @Test
    public void subInValidTest() {
        double result = calculator.calculate(12d, 20d, '-');
        Assert.assertNotEquals(-12d, result, DELTA);
        result = calculator.calculate(30.111, 5d, '-');
        Assert.assertNotEquals(35.111d, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void subNullTest() {
        Double a = null;
        Double result = calculator.calculate(10d, a, '-');
    }

    @Test
    public void multWholeValidTest() {
        double result = calculator.calculate(10d, 20d, '*');
        Assert.assertEquals(200d, result, DELTA);
        result = calculator.calculate(33d, 1d, '*');
        Assert.assertEquals(33d, result, DELTA);
        result = calculator.calculate(10d, 0d, '*');
        Assert.assertEquals(0d, result, DELTA);
        result = calculator.calculate(0d, 5d, '*');
        Assert.assertEquals(0d, result, DELTA);
    }

    @Test
    public void multDecimalValidTest() {
        double result = calculator.calculate(12.5, 12.5, '*');
        Assert.assertEquals(156.25, result, DELTA);
        result = calculator.calculate(11.55, 7.32, '*');
        Assert.assertEquals(84.546, result, DELTA);
        result = calculator.calculate(10.5, 20.3, '*');
        Assert.assertEquals(213.15, result, DELTA);
    }

    @Test
    public void multInValidTest() {
        double result = calculator.calculate(10d, 20d, '*');
        Assert.assertNotEquals(30d, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void multNullTest() {
        Double a = null;
        double result = calculator.calculate(10d, a, '*');
    }

    @Test
    public void divWholeValidTest() {
        double result = calculator.calculate(40d, 20d, '/');
        Assert.assertEquals(2d, result, DELTA);
        result = calculator.calculate(36d, 72d, '/');
        Assert.assertEquals(0.5, result, DELTA);
        result = calculator.calculate(0d, 10d, '/');
        Assert.assertEquals(0d, result, DELTA);
    }

    @Test
    public void divDecimalValidTest() {
        double result = calculator.calculate(32.6, 5.3, '/');
        Assert.assertEquals(6.151, result, DELTA);
        result = calculator.calculate(5.74, 15.32, '/');
        Assert.assertEquals(0.375, result, DELTA);
        result = calculator.calculate(10.2, 20.4, '/');
        Assert.assertEquals(0.5, result, DELTA);
    }

    @Test
    public void divInValidTest() {
        double result = calculator.calculate(10d, 20d, '/');
        Assert.assertNotEquals(200d, result, DELTA);
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
        result = calculator.calculate(16, -2, '^');
        Assert.assertEquals(0.004, result, DELTA);
    }

    @Test
    public void powInValidTest() {
        double result = calculator.calculate(10d, 2d, '^');
        Assert.assertNotEquals(10d, result, DELTA);
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
