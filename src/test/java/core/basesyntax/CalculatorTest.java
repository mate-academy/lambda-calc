package core.basesyntax;

import core.basesyntax.exceptions.UndefinedOperationException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private double a = 2.00;
    private double b = 3.00;
    private double c = -2.00;
    private double d = -3.00;
    private static final double DELTA = 0.001;

    @Test
    public void additionIsValid() {
        double actualResult = calculator.calculate(a, b, '+');
        Assert.assertEquals(5.00, actualResult, DELTA);
    }

    @Test
    public void additionWithNegativeValues() {
        double actualResult = calculator.calculate(c, d, '+');
        Assert.assertEquals(-5.00, actualResult, DELTA);
    }

    @Test
    public void subsractionIsValid() {
        double actualResult = calculator.calculate(a, b, '-');
        Assert.assertEquals(-1.00, actualResult, DELTA);
    }

    @Test
    public void substractionWithNegativeValues() {
        double actualResult = calculator.calculate(c, d, '-');
        Assert.assertEquals(1.00, actualResult, DELTA);
    }

    @Test
    public void multiplicationIsValid() {
        double actualResult = calculator.calculate(a, b, '*');
        Assert.assertEquals(6.00, actualResult, DELTA);
    }

    @Test
    public void multiplicationWithNegativeValues() {
        double actualResult = calculator.calculate(c, d, '*');
        Assert.assertEquals(6.00, actualResult, DELTA);
    }

    @Test
    public void divisionIsValid() {
        double actualResult = calculator.calculate(a, b, '/');
        Assert.assertEquals(0.666, actualResult, DELTA);
    }

    @Test
    public void divisionWithNegativeValues() {
        double actualResult = calculator.calculate(c, d, '/');
        Assert.assertEquals(0.666, actualResult, DELTA);
    }

    @Test
    public void divisionByZero() {
        double actualResult = calculator.calculate(a, 0, '/');
        Assert.assertEquals(Double.POSITIVE_INFINITY, actualResult, DELTA);
    }

    @Test
    public void powerIsValid() {
        double actualResult = calculator.calculate(a, b, 'p');
        Assert.assertEquals(8.00, actualResult, DELTA);
    }

    @Test
    public void powerWithNegativeValues() {
        double actualResult = calculator.calculate(c, d, 'p');
        Assert.assertEquals(-0.125, actualResult, DELTA);
    }

    @Test
    public void powerWithNegativeExponent() {
        double actualResult = calculator.calculate(a, d, 'p');
        Assert.assertEquals(0.125, actualResult, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void usageNull() {
        Double theNull = null;
        double actualResult = calculator.calculate(theNull, b, '+');
    }

    @Test(expected = UndefinedOperationException.class)
    public void undefinedOperation() {
        double actualResult = calculator.calculate(a, b, 's');
    }
}
