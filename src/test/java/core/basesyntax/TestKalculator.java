package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class TestKalculator {
    private static final int A = 10;
    private static final int B = 5;
    private static final int D = 20;
    private static final int E = 30;
    private static final int F = 2;
    private static final int G = 4;

    @Test
    public void sum() {
        Assert.assertEquals(15, Kalculator.evaluate(A, B, '+'));
        Assert.assertEquals(22, Kalculator.evaluate(D, F, '+'));
        Assert.assertEquals(35, Kalculator.evaluate(E, B, '+'));
        Assert.assertEquals(24, Kalculator.evaluate(D, G, '+'));
    }

    @Test
    public void divide() {
        Assert.assertEquals(2, Kalculator.evaluate(A, B, '/'));
        Assert.assertEquals(10, Kalculator.evaluate(D, F, '/'));
        Assert.assertEquals(6, Kalculator.evaluate(E, B, '/'));
        Assert.assertEquals(5, Kalculator.evaluate(D, G, '/'));
    }

    @Test
    public void multiply() {
        Assert.assertEquals(50, Kalculator.evaluate(A, B, '*'));
        Assert.assertEquals(40, Kalculator.evaluate(D, F, '*'));
        Assert.assertEquals(150, Kalculator.evaluate(E, B, '*'));
        Assert.assertEquals(80, Kalculator.evaluate(D, G, '*'));
    }

    @Test
    public void subtract() {
        Assert.assertEquals(5, Kalculator.evaluate(A, B, '-'));
        Assert.assertEquals(18, Kalculator.evaluate(D, F, '-'));
        Assert.assertEquals(25, Kalculator.evaluate(E, B, '-'));
        Assert.assertEquals(16, Kalculator.evaluate(D, G, '-'));
    }

    @Test
    public void power() {
        Assert.assertEquals(100000, Kalculator.evaluate(A, B, '^'));
        Assert.assertEquals(400, Kalculator.evaluate(D, F, '^'));
        Assert.assertEquals(24300000, Kalculator.evaluate(E, B, '^'));
        Assert.assertEquals(160000, Kalculator.evaluate(D, G, '^'));
    }

    @Test(expected = ArithmeticException.class)
    public void overflow() {
        Kalculator.evaluate(A * 100000, B * 100000, '*');
        Kalculator.evaluate(D * 100000, F * 100000, '*');
        Kalculator.evaluate(E * 100000, B * 100000, '*');
        Kalculator.evaluate(D * 100000, G * 100000, '*');
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        Kalculator.evaluate(A, 0, '/');
        Kalculator.evaluate(B, 0, '/');
        Kalculator.evaluate(D, 0, '/');
        Kalculator.evaluate(G, 0, '/');
    }

    @Test(expected = NullPointerException.class)
    public void incorrectChar() {
        Kalculator.evaluate(A, B, '(');
        Kalculator.evaluate(A, B, '?');
        Kalculator.evaluate(A, B, '$');
        Kalculator.evaluate(A, B, '|');
    }
}
