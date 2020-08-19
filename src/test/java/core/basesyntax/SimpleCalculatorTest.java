package core.basesyntax;

import static java.lang.Float.NaN;

import org.junit.Assert;
import org.junit.Test;

public class SimpleCalculatorTest {
    private static final double DELTA = 1e-6;
    private static final char[] BAD_OPERATORS = {'0', '1', '~', ',',
            ' ', '\b', '\r', '\r', '\t', '\f', '\b', '\n', '\\', '◘',
            '☺', '%', '$', '#', '@', '!', '&', '(', ')', '“'};
    private SimpleCalculator calculator = new SimpleCalculator();

    @Test
    public void addOk() {
        Assert.assertEquals(2, calculator.calculate(1, '+', 1), DELTA);
        Assert.assertEquals(54, calculator.calculate(-5, '+', 59), DELTA);
        Assert.assertEquals(0, calculator.calculate(15, '+', -15), DELTA);
        Assert.assertEquals(-40, calculator.calculate(-25, '+', -15), DELTA);
        Assert.assertEquals(-1, calculator.calculate(-2147483648, '+', 2147483647), DELTA);
        Assert.assertEquals(44.4, calculator.calculate(44.4, '+', 0), DELTA);
        Assert.assertEquals(4.5, calculator.calculate(0, '+', 4.5), DELTA);
        Assert.assertEquals(0.9999999999, calculator.calculate(0.3333333333, '+', 0.6666666666), DELTA);
    }

    @Test
    public void substractOK() {
        Assert.assertEquals(0, calculator.calculate(1, '-', 1), DELTA);
        Assert.assertEquals(7, calculator.calculate(2147483647, '-', 2147483640), DELTA);
        Assert.assertEquals(-1, calculator.calculate(0, '-', 1), DELTA);
        Assert.assertEquals(1, calculator.calculate(1, '-', 0), DELTA);
        Assert.assertEquals(6, calculator.calculate(1, '-', -5), DELTA);
        Assert.assertEquals(-47, calculator.calculate(-51, '-', -4), DELTA);
        Assert.assertEquals(-6, calculator.calculate(-5, '-', 1), DELTA);
        Assert.assertEquals(0.6666666667, calculator.calculate(1, '-', 0.3333333333), DELTA);
    }

    @Test
    public void multiplyOk() {

        Assert.assertEquals(25, calculator.calculate(5, '*', 5), DELTA);
        Assert.assertEquals(25, calculator.calculate(5, '•', 5), DELTA);
        Assert.assertEquals(-25, calculator.calculate(5, '*', -5), DELTA);
        Assert.assertEquals(-25, calculator.calculate(-5, '*', 5), DELTA);
        Assert.assertEquals(25, calculator.calculate(-5, '*', -5), DELTA);
        Assert.assertEquals(0, calculator.calculate(5, '*', 0), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, '*', 0), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, '*', 0), DELTA);
    }

    @Test
    public void divisionOK() {
        Assert.assertEquals(1, calculator.calculate(5, '/', 5), DELTA);
        Assert.assertEquals(1, calculator.calculate(5, ':', 5), DELTA);
        Assert.assertEquals(-1, calculator.calculate(5, '/', -5), DELTA);
        Assert.assertEquals(5, calculator.calculate(25, '/', 5), DELTA);
        Assert.assertEquals(-1, calculator.calculate(-5, '/', 5), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        calculator.calculate(5, '/', 0);
    }

    @Test
    public void powOK() {
        Assert.assertEquals(25, calculator.calculate(5, '^', 2), DELTA);
        Assert.assertEquals(5, calculator.calculate(25, '^', 0.5), DELTA);
        Assert.assertEquals(8, calculator.calculate(4, '^', 1.5), DELTA);
        Assert.assertEquals(25, calculator.calculate(-5, '^', 2), DELTA);
        Assert.assertEquals(-125, calculator.calculate(-5, '^', 3), DELTA);
        Assert.assertEquals(NaN, calculator.calculate(-5, '^', 0.5), DELTA);
        Assert.assertEquals(2.23606798, calculator.calculate(5, '^', 0.5), DELTA);
        Assert.assertEquals(0.25, calculator.calculate(0.5, '^', 2), DELTA);
        Assert.assertEquals(1, calculator.calculate(1545, '^', 0), DELTA);
        Assert.assertEquals(512, calculator.calculate(0.125, '^', -3), DELTA);
        Assert.assertEquals(0.0625, calculator.calculate(2, '^', -4), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void badOperatorError() {
        int exceptionsCounter = 0;
        for (char operator : BAD_OPERATORS) {
            try {
                calculator.calculate(1, operator, 1);
            }
            catch (IllegalAccessError e) {
                exceptionsCounter++;
            }
        Assert.assertEquals(BAD_OPERATORS.length, exceptionsCounter);
        }
    }
}
