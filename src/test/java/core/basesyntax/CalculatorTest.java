package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private static final double INFINITY = 1.0 / 0.0;
    private Calculator calculator;

    @Before
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void sum() {
        double res = calculator.calculate(10, 5, '+');
        double res1 = calculator.calculate(10.01, -5.01, '+');
        double res2 = calculator.calculate(10000, 5000, '+');

        Assert.assertEquals(15, res, 0.0);
        Assert.assertEquals(5, res1, 0.0);
        Assert.assertEquals(15000, res2, 0.0);
    }

    @Test
    public void minus() {
        double res = calculator.calculate(10, 5, '-');
        double res1 = calculator.calculate(10.01, -5, '-');
        double res2 = calculator.calculate(10000, 5000, '-');

        Assert.assertEquals(5, res, 0.0);
        Assert.assertEquals(15.01, res1, 0.0);
        Assert.assertEquals(5000, res2, 0.0);
    }

    @Test
    public void division() {
        double res = calculator.calculate(10, 5, '/');
        double res1 = calculator.calculate(10.10, -5, '/');
        double res2 = calculator.calculate(10000, 50, '/');

        Assert.assertEquals(2, res, 0.0);
        Assert.assertEquals(-2.02, res1, 0.0);
        Assert.assertEquals(200, res2, 0.0);
    }

    @Test
    public void multiplication() {
        double res = calculator.calculate(10, 5, '*');
        double res1 = calculator.calculate(10.10, 5.10, '*');
        double res2 = calculator.calculate(10000, -5, '*');

        Assert.assertEquals(50, res, 0.0);
        Assert.assertEquals(51.51, res1, 0.0);
        Assert.assertEquals(-50000, res2, 0.0);
    }

    @Test
    public void exponentiation() {
        double res = calculator.calculate(2, 3, '^');
        double res1 = calculator.calculate(10, -1, '^');
        double res2 = calculator.calculate(15, 0, '^');

        Assert.assertEquals(8, res, 0.0);
        Assert.assertEquals(0.1, res1, 0.0);
        Assert.assertEquals(1, res2, 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void sumNull() {
        double res = calculator.calculate(10, Double.valueOf(null), '+');
    }

    @Test(expected = NullPointerException.class)
    public void minusNull() {
        double res = calculator.calculate(10, Double.valueOf(null), '-');
    }

    @Test(expected = NullPointerException.class)
    public void divisionNull() {
        double res = calculator.calculate(10, Double.valueOf(null), '/');
    }

    @Test(expected = NullPointerException.class)
    public void multiplicationNull() {
        double res = calculator.calculate(10, Double.valueOf(null), '*');
    }

    @Test(expected = NullPointerException.class)
    public void exponentialNull() {
        double res = calculator.calculate(10, Double.valueOf(null), '^');
    }

    @Test
    public void divisionZero() {
        double res = calculator.calculate(10, 0.0, '/');
        Assert.assertEquals(INFINITY, res, 0.0);
    }

    @Test
    public void multiplicationInfinity() {
        double res = calculator.calculate(10, INFINITY, '*');
        Assert.assertEquals(INFINITY, res, 0.0);
    }

    @Test
    public void devitionInfinity() {
        double res = calculator.calculate(1, INFINITY, '/');
        Assert.assertEquals(0.0, res, 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void wrongOperation() {
        double res = calculator.calculate(10, 5, '!');
        double res1 = calculator.calculate(10, 5, '1');
        double res2 = calculator.calculate(10, 5, 'q');
    }

    @Test(expected = NumberFormatException.class)
    public void wrongValues() {
        double res = calculator.calculate(Double.valueOf("10"), 5, '*');
        double res1 = calculator.calculate(Double.valueOf("ten"), 5, '/');
        double res2 = calculator.calculate(Double.valueOf("10,00"), 5, '+');
    }
}
