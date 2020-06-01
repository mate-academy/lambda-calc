package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0;
    private static Calculator calculator;

    @BeforeClass
    public static void createObject() {
        calculator = new Calculator();
    }

    @Test
    public void isPlusOk() {
        double result = calculator.calculate(1, '+', 2);
        Assert.assertEquals(3, result, DELTA);
    }

    @Test
    public void isPlusNegativeValues() {
        double result = calculator.calculate(-1, '+', -2);
        Assert.assertEquals(-3, result, DELTA);
    }

    @Test
    public void isPlusNotValid() {
        double result = calculator.calculate(1, '+', 2);
        Assert.assertNotEquals(4, result);
    }

    @Test
    public void isMinusOk() {
        double result = calculator.calculate(7, '-', 5);
        Assert.assertEquals(2, result, DELTA);
    }

    @Test
    public void isMinusNegativeValues() {
        double result = calculator.calculate(-2, '-', -6);
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void isMinusNotValid() {
        double result = calculator.calculate(2, '-', 6);
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void isDivisionOk() {
        double result = calculator.calculate(6, '/', 2);
        Assert.assertEquals(3, result, DELTA);
    }

    @Test
    public void isDivisionNotValid() {
        double result = calculator.calculate(-6, '/', 2);
        Assert.assertNotEquals(-3, result);
    }

    @Test
    public void isDivisionNegativeValues() {
        double result = calculator.calculate(-6, '/', -2);
        Assert.assertEquals(3, result, DELTA);
    }

    @Test
    public void isDivisionZeroPositiveValue() {
        double result = calculator.calculate(6, '/', 0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
    }

    @Test
    public void isDivisionZeroNegativeValue() {
        double result = calculator.calculate(-6, '/', 0);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, result, DELTA);
    }

    @Test
    public void isMultiplyOk() {
        double result = calculator.calculate(3, '*', 4);
        Assert.assertEquals(12, result, DELTA);
    }

    @Test
    public void isMultiplyNotValid() {
        double result = calculator.calculate(3, '*', 3);
        Assert.assertNotEquals(10, result);
    }

    @Test
    public void isMultiplyNegativeValues() {
        double result = calculator.calculate(-3, '*', -4);
        Assert.assertEquals(12, result, DELTA);
    }


    @Test
    public void isExponentiationOk() {
        double result = calculator.calculate(3, '^', 3);
        Assert.assertEquals(27, result, DELTA);
    }

    @Test
    public void isExponentiationNotValid() {
        double result = calculator.calculate(3, '^', 10);
        Assert.assertNotEquals(10, result);
    }

    @Test
    public void isExponentiationOnZero() {
        double result = calculator.calculate(-3, '^', 0);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void isOperatorNotValid() {
        double result = calculator.calculate(100, 'a', 500);
        Assert.fail("Illegal operator");
    }
}
