package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final double POSITIVE_X = 3;
    private static final double POSITIVE_Y = 4;
    private static final double NEGATIVE_X = -3;
    private static final double NEGATIVE_Y = -4;
    private static final double DELTA = 0.001;

    @Test
    public void addPositiveValues() {
        double expected = 7;
        double actual = Calculator.calculate(POSITIVE_X, POSITIVE_Y, '+');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void addNegativeValues() {
        double expected = -7;
        double actual = Calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '+');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractPositiveValues() {
        double expected = -1;
        double actual = Calculator.calculate(POSITIVE_X, POSITIVE_Y, '-');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractNegativeValues() {
        double expected = 1;
        double actual = Calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '-');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplyPositiveValues() {
        double expected = 12;
        double actual = Calculator.calculate(POSITIVE_X, POSITIVE_Y, '*');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplyNegativeValues() {
        double expected = 12;
        double actual = Calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '*');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void dividePositiveValues() {
        double expected = 0.75;
        double actual = Calculator.calculate(POSITIVE_X, POSITIVE_Y, '/');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divideNegativeValues() {
        double expected = 0.75;
        double actual = Calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '/');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void powerPositiveValues() {
        double expected = 81;
        double actual = Calculator.calculate(POSITIVE_X, POSITIVE_Y, '^');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void powerNegativeValues() {
        double expected = 0.012;
        double actual = Calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '^');
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void addNullValue() {
        Double nullValue = null;
        Calculator.calculate(POSITIVE_X, nullValue, '+');
    }

    @Test
    public void divideByZero() {
        double actual = Calculator.calculate(POSITIVE_X, 0, '/');
        Assert.assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void useWrongOperation() {
        Calculator.calculate(POSITIVE_X, POSITIVE_Y, '#');
    }
}
