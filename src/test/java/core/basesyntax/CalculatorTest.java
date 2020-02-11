package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private double a = 2.00;
    private double b = 4.00;
    private double c = -6.00;
    private double d = -7.00;
    private static final double DELTA = 0.001;

    @Test
    public void additionIsValid() {
        double res = calculator.calculate(a, b, '+');
        Assert.assertEquals(6.00, res, DELTA);
    }

    @Test
    public void additionWithNegative() {
        double res = calculator.calculate(c, d, '+');
        Assert.assertEquals(-13.00, res, DELTA);
    }

    @Test
    public void subtractionIsValid() {
        double res = calculator.calculate(a, b, '-');
        Assert.assertEquals(-2.00, res, DELTA);
    }

    @Test
    public void subtractionWithNegative() {
        double res = calculator.calculate(c, d, '-');
        Assert.assertEquals(1.00, res, DELTA);
    }

    @Test
    public void multiplicationIsValid() {
        double res = calculator.calculate(a, b, '*');
        Assert.assertEquals(8.00, res, DELTA);
    }

    @Test
    public void multiplicationWithNegative() {
        double res = calculator.calculate(c, d, '*');
        Assert.assertEquals(42.00, res, DELTA);
    }

    @Test
    public void divisionIsValid() {
        double res = calculator.calculate(a,b,'/');
        Assert.assertEquals(0.5, res, DELTA);
    }

    @Test
    public void divisionByZero () {
        double res = calculator.calculate(a, 0, '/');
        Assert.assertEquals(Double.POSITIVE_INFINITY, res, DELTA);
    }

    @Test
    public void powerIsValid() {
        double res = calculator.calculate(a,b,'^');
        Assert.assertEquals(16.00, res, DELTA);
    }

    @Test
    public void powerWithNegativeExponent() {
        double res = calculator.calculate(a,-3,'^');
        Assert.assertEquals(0.125, res, DELTA);
    }

    @Test
    public void powerWithZero() {
        double res = calculator.calculate(a,0,'^');
        Assert.assertEquals(1, res, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void usageNull() {
        Double theNull = null;
        double res = calculator.calculate(theNull, b,'+');
    }
}
