package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Float.NaN;

/**
 * Feel free to remove this class and create your own.
 */
public class SimpleCalculatorTest {
    private static final double DELTA = 1e-6;
    private char[] badOperators = {'0', '1', '~', ',', ' ', '\b', '\r', '\r', '\t', '\f', '\b', '\n', '\\', '◘', '☺', '%', '$', '#', '@', '!', '&', '(', ')', '“'};

    @Test
    public void addOk() throws IOException {
        Assert.assertEquals(2, SimpleCalculator.calculate(1, '+', 1), DELTA);
        Assert.assertEquals(54, SimpleCalculator.calculate(-5, '+', 59), DELTA);
        Assert.assertEquals(0, SimpleCalculator.calculate(15, '+', -15), DELTA);
        Assert.assertEquals(-40, SimpleCalculator.calculate(-25, '+', -15), DELTA);
        Assert.assertEquals(-1, SimpleCalculator.calculate(-2147483648, '+', 2147483647), DELTA);
        Assert.assertEquals(44.4, SimpleCalculator.calculate(44.4, '+', 0), DELTA);
        Assert.assertEquals(4.5, SimpleCalculator.calculate(0, '+', 4.5), DELTA);
        Assert.assertEquals(0.9999999999, SimpleCalculator.calculate(0.3333333333, '+', 0.6666666666), DELTA);
    }

    @Test
    public void substractOK() throws IOException {
        Assert.assertEquals(0, SimpleCalculator.calculate(1, '-', 1), DELTA);
        Assert.assertEquals(7, SimpleCalculator.calculate(2147483647, '-', 2147483640), DELTA);
        Assert.assertEquals(-1, SimpleCalculator.calculate(0, '-', 1), DELTA);
        Assert.assertEquals(1, SimpleCalculator.calculate(1, '-', 0), DELTA);
        Assert.assertEquals(6, SimpleCalculator.calculate(1, '-', -5), DELTA);
        Assert.assertEquals(-47, SimpleCalculator.calculate(-51, '-', -4), DELTA);
        Assert.assertEquals(-6, SimpleCalculator.calculate(-5, '-', 1), DELTA);
        Assert.assertEquals(0.6666666667, SimpleCalculator.calculate(1, '-', 0.3333333333), DELTA);
    }

    @Test
    public void multiplyOk() throws IOException {
        Assert.assertEquals(25, SimpleCalculator.calculate(5, '*', 5), DELTA);
        Assert.assertEquals(25, SimpleCalculator.calculate(5, '•', 5), DELTA);
        Assert.assertEquals(-25, SimpleCalculator.calculate(5, '*', -5), DELTA);
        Assert.assertEquals(-25, SimpleCalculator.calculate(-5, '*', 5), DELTA);
        Assert.assertEquals(25, SimpleCalculator.calculate(-5, '*', -5), DELTA);
        Assert.assertEquals(0, SimpleCalculator.calculate(5, '*', 0), DELTA);
        Assert.assertEquals(0, SimpleCalculator.calculate(0, '*', 0), DELTA);
        Assert.assertEquals(0, SimpleCalculator.calculate(0, '*', 0), DELTA);
    }

    @Test
    public void divisionOK() throws IOException {
        Assert.assertEquals(1, SimpleCalculator.calculate(5, '/', 5), DELTA);
        Assert.assertEquals(1, SimpleCalculator.calculate(5, ':', 5), DELTA);
        Assert.assertEquals(-1, SimpleCalculator.calculate(5, '/', -5), DELTA);
        Assert.assertEquals(5, SimpleCalculator.calculate(25, '/', 5), DELTA);
        Assert.assertEquals(-1, SimpleCalculator.calculate(-5, '/', 5), DELTA);
    }

    @Test
    public void divisionByZeroTest() {
        try {
            SimpleCalculator.calculate(5, '/', 0);
        } catch (ArithmeticException e) {
            return;
        } catch (IOException e) {
            Assert.fail("ArithmeticException should be thrown");
        }
        Assert.fail("ArithmeticException should be thrown");
    }

    @Test
    public void powOK() throws IOException {
        Assert.assertEquals(25, SimpleCalculator.calculate(5, '^', 2), DELTA);
        Assert.assertEquals(5, SimpleCalculator.calculate(25, '^', 0.5), DELTA);
        Assert.assertEquals(8, SimpleCalculator.calculate(4, '^', 1.5), DELTA);
        Assert.assertEquals(25, SimpleCalculator.calculate(-5, '^', 2), DELTA);
        Assert.assertEquals(-125, SimpleCalculator.calculate(-5, '^', 3), DELTA);
        Assert.assertEquals(NaN, SimpleCalculator.calculate(-5, '^', 0.5), DELTA);
        Assert.assertEquals(2.23606798, SimpleCalculator.calculate(5, '^', 0.5), DELTA);
        Assert.assertEquals(0.25, SimpleCalculator.calculate(0.5, '^', 2), DELTA);
    }

    @Test
    public void badOperatorError() {
        for (char operator : badOperators) {
            try {
                SimpleCalculator.calculate(1, operator, 1);
            } catch (IOException e) {
                Assert.fail(" \"" + operator + "\" is unknown operator");
            }
        }
        Assert.fail();
    }
}