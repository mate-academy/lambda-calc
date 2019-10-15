package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final String MESSAGE_NPE = "NPE was expected!";
    private static final String MESSAGE_ARITHMETIC_EXCTPITON = "Expected ArithmeticException";

    @Test
    public void correctSum() {
        Assert.assertEquals(3, Calculator.calculate( -2, '+', 5));
    }

    @Test
    public void correctSubtraction() {
        Assert.assertEquals(-1, Calculator.calculate( 5, '-', 6));
    }

    @Test
    public void correctMultiply() {
        Assert.assertEquals(-6, Calculator.calculate( -3, '*', 2));
    }

    @Test
    public void correctDivide() {
        Assert.assertEquals(-3, Calculator.calculate( 9, '/', -3));
    }

    @Test
    public void correctPow() {
        Assert.assertEquals(8, Calculator.calculate( 2, '^', 3));
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
        Assert.assertEquals(1, Calculator.calculate( 2, '^', 0));
    }

    @Test
    public void numberInDegree1() {
        Assert.assertEquals(7, Calculator.calculate( 7, '^', 1));
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
        Assert.assertEquals(0, Calculator.calculate( 3, '*', 0));
    }

    @Test
    public void multiplyZeroByNumber() {
        Assert.assertEquals(0, Calculator.calculate( 0, '*', -6));
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
