package core.basesyntax;

import core.basesyntax.exceptions.UndefinedOperationException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private double a = 2.00;
    private double b = 3.00;
    private static double result = 0.00;
    private static final double DELTA = 0.001;
    private static final double INFINITY = 1.00 / 0;

    @Test
    public void additionIsValid() {
        result = calculator.calculate(a, b, '+');
        Assert.assertEquals(5.00, result, DELTA);
    }

    @Test
    public void subsractionIsValid() {
        result = calculator.calculate(a, b, '-');
        Assert.assertEquals(-1.00, result, DELTA);
    }

    @Test
    public void multiplicationIsValid() {
        result = calculator.calculate(a, b, '*');
        Assert.assertEquals(6.00, result, DELTA);
    }

    @Test
    public void divisionIsValid() {
        result = calculator.calculate(a, b, '/');
        Assert.assertEquals(0.666, result, DELTA);
    }

    @Test
    public void divisionByZero() {
        result = calculator.calculate(a, 0, '/');
        Assert.assertEquals(INFINITY, result, DELTA);
    }

    @Test
    public void powerIsValid() {
        result = calculator.calculate(a, b, 'p');
        Assert.assertEquals(8.00, result, DELTA);
    }

    @Test
    public void powerWithNegativeExponent() {
        result = calculator.calculate(a, -3, 'p');
        Assert.assertEquals(0.125, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void usageNull() {
        Double theNull = null;
        result = calculator.calculate(theNull, b, '+');
    }

    @Test(expected = UndefinedOperationException.class)
    public void undefinedOperation() {
        result = calculator.calculate(a, b, 's');
    }
}