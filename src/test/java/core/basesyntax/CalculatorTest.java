package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final String MESSAGE_NPE = "NPE was expected!";
    private static final String MESSAGE_ARITHMETIC_EXCTPITON = "Expected ArithmeticException";

    private static int expected;
    private static int actutal;

    @Test
    public void correctSum() {
        expected = 3;
        actutal = Calculator.calculate( -2, '+', 5);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void correctSubtraction() {
        expected = -1;
        actutal = Calculator.calculate( 5, '-', 6);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void correctMultiply() {
        expected = -6;
        actutal = Calculator.calculate( -3, '*', 2);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void correctDivide() {
        expected = -3;
        actutal = Calculator.calculate( 9, '/', -3);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void correctPow() {
        expected = 8;
        actutal = Calculator.calculate( 2, '^', 3);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void operatorNull() {
        try {
            Assert.assertNotEquals("72", Calculator.calculate( 7, null, 2));
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail(MESSAGE_NPE);
    }

    @Test
    public void divideByZero() {
        try {
            Assert.assertNotEquals(0, Calculator.calculate( 7, null, 2));
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail(MESSAGE_NPE);
    }
    @Test
    public void numberInDegreeZero() {
        expected = 1;
        actutal = Calculator.calculate( 2, '^', 0);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void numberInDegree1() {
        expected = 7;
        actutal = Calculator.calculate( 7, '^', 1);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void numberInDegreeMinus() {
        try {
            Assert.assertNotEquals(0, Calculator.calculate( 8,'^', -2));
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail(MESSAGE_ARITHMETIC_EXCTPITON);
    }

    @Test
    public void multiplyByZero() {
        expected = 0;
        actutal = Calculator.calculate( 3, '*', 0);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void multiplyZeroByNumber() {
        expected = 0;
        actutal = Calculator.calculate( 0, '*', -6);
        Assert.assertEquals(expected, actutal);
    }

    @Test
    public void maxSum() {
        try {
            Assert.assertNotEquals(Integer.MIN_VALUE,
                    Calculator.calculate( Integer.MAX_VALUE, '+', Integer.MAX_VALUE));
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail(MESSAGE_ARITHMETIC_EXCTPITON);
    }

    @Test
    public void minSubrtaction() {
        try {
            Assert.assertNotEquals(Integer.MAX_VALUE,
                    Calculator.calculate( Integer.MIN_VALUE, '+', Integer.MIN_VALUE));
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail(MESSAGE_ARITHMETIC_EXCTPITON);
    }

    @Test
    public void maxMultiply() {
        try {
            Assert.assertNotEquals(Integer.MIN_VALUE,
                    Calculator.calculate( Integer.MAX_VALUE, '*', Integer.MAX_VALUE));
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail(MESSAGE_ARITHMETIC_EXCTPITON);
    }

    @Test
    public void maxPow() {
        try {
            Assert.assertNotEquals(Integer.MIN_VALUE, Calculator.calculate( Integer.MAX_VALUE,'^', Integer.MAX_VALUE));
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail(MESSAGE_ARITHMETIC_EXCTPITON);
    }
}
