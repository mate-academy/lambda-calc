package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private double expected;
    private double actual;

    @Test
    public void testSum() {
        double a = 36;
        double b = 28;
        expected = 64;
        actual = Calculator.calculate(a, '+', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSumNegative() {
        double a = -9;
        double b = -7;
        expected = -16;
        actual = Calculator.calculate(a, '+', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testDifference() {
        double a = 9;
        double b = 7;
        expected = 2;
        actual = Calculator.calculate(a, '-', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testDifferenceWhenOneIsNegative() {
        double a = 9;
        double b = -7;
        expected = 16;
        actual = Calculator.calculate(a, '-', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testMultiply() {
        double a = 8;
        double b = 6;
        expected = 48;
        actual = Calculator.calculate(a, '*', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testMultiplyWithZero() {
        double a = 8;
        double b = 0;
        expected = 0;
        actual = Calculator.calculate(a, '*', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testMultiplyWhenOneIsNegative() {
        double a = -4;
        double b = 5;
        expected = -20;
        actual = Calculator.calculate(a, '*', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testDivide() {
        double a = 64;
        double b = 4;
        expected = 16;
        actual = Calculator.calculate(a, '/', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testDivideResultIrrational() {
        double a = 22;
        double b = 7;
        expected = 3.142;
        actual = Calculator.calculate(a, '/', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testDivideByZero() {
        double a = 22;
        double b = 0;
        Calculator.calculate(a, '/', b);
    }

    @Test
    public void testPow() {
        double a = 2;
        double b = 5;
        expected = 32;
        actual = Calculator.calculate(a, '^', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testPowWhenOneIsNegative() {
        double a = 5;
        double b = -3;
        expected = 0.008;
        actual = Calculator.calculate(a, '^', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testPowInZero() {
        double a = 78;
        double b = 0;
        expected = 1;
        actual = Calculator.calculate(a, '^', b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testCalculateWithNonValidOperation() {
        double a = 1;
        double b = 1;
        Calculator.calculate(a, '=', b);
    }
}
