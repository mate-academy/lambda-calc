package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class TestKalculator {
    private static final int A = 10;
    private static final int B = 5;

    @Test
    public void sum() {
        Assert.assertEquals(15, Kalculator.evaluate(A, B, '+'));
    }

    @Test
    public void divide() {
        Assert.assertEquals(15, Kalculator.evaluate(A, B, '/'));
    }

    @Test
    public void multiply() {
        Assert.assertEquals(15, Kalculator.evaluate(A, B, '*'));
    }

    @Test
    public void subtract() {
        Assert.assertEquals(15, Kalculator.evaluate(A, B, '-'));
    }

    @Test
    public void overflow() {
        try {
            Kalculator.evaluate(A * 100000, B * 100000, '*');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Where overflow");
    }
}