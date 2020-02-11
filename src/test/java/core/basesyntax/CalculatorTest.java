package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Double.NaN;

public class CalculatorTest {
    private static final double DELTA = 0.0001;

    @Test
    public void sumValidTest() {
        double result = Calculator.calculate(3, 2, '+');
        Assert.assertEquals(5, result, DELTA);
        result = Calculator.calculate(-5.0, 4, '+');
        Assert.assertEquals(-1, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void sumNullTest() {
        Double a = null;
        double result = Calculator.calculate(2000d, a, '+');
    }

    @Test
    public void diffValidTest() {
        double result = Calculator.calculate(3, 2, '-');
        Assert.assertEquals(1, result, DELTA);
        result = Calculator.calculate(-5.0, 4, '-');
        Assert.assertEquals(-9, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void diffNullTest() {
        Double a = null;
        double result = Calculator.calculate(2000d, a, '-');
    }

    @Test
    public void multiValidTest() {
        double result = Calculator.calculate(3, 2, '*');
        Assert.assertEquals(6, result, DELTA);
        result = Calculator.calculate(-5.0, 4, '*');
        Assert.assertEquals(-20, result, DELTA);
    }

    @Test
    public void multiInValidTest() {
        double result = Calculator.calculate(0, -5, '*');
        Assert.assertNotEquals(-5, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void multiNullTest() {
        Double a = null;
        double result = Calculator.calculate(2000d, a, '*');
    }

    @Test
    public void divisionValidTest() {
        double result = Calculator.calculate(3, 2, '/');
        Assert.assertEquals(1.5, result, DELTA);
        result = Calculator.calculate(-5.0, 4, '/');
        Assert.assertEquals(-1.25, result, DELTA);
    }

    @Test
    public void divisionInValidTest() {
        double result = Calculator.calculate(0, -5, '/');
        Assert.assertNotEquals(-5, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void divisionNullTest() {
        Double a = null;
        double result = Calculator.calculate(2000d, a, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionByZeroTest() {
        double result = Calculator.calculate(2000d, 0, '/');
    }

    @Test
    public void powValidTest() {
        double result = Calculator.calculate(3, 2, '^');
        Assert.assertEquals(9, result, DELTA);
        result = Calculator.calculate(-2, 3, '^');
        Assert.assertEquals(-8, result, DELTA);
        result = Calculator.calculate(5, 0, '^');
        Assert.assertEquals(1, result, DELTA);
        result = Calculator.calculate(0, 0, '^');
        Assert.assertEquals(1, result, DELTA);
        result = Calculator.calculate(4.0, 0.5, '^');
        Assert.assertEquals(2.0, result, DELTA);
    }

    @Test
    public void powInValidTest() {
        double result = Calculator.calculate(4, 0.5, '^');
        Assert.assertNotEquals(8, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void powNullTest() {
        Double a = null;
        double result = Calculator.calculate(2000d, a, '^');
    }

    @Test
    public void powGetNaNTest() {
        double result = Calculator.calculate(-4, 0.5, '^');
        Assert.assertEquals(NaN, result, DELTA);
    }

}
