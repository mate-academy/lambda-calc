package core.basesyntax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestKalculator {
    private static final double DELTA = 1e-15;
    private static final double A = 10;
    private static final double B = 5;
    private static final double D = 20;
    private static final double E = 30;
    private static final double F = 2;
    private static final double G = 4;

    @Test
    public void sum() {
        assertEquals(15, Kalculator.evaluate(A, B, '+'), DELTA);
        assertEquals(22, Kalculator.evaluate(D, F, '+'), DELTA);
        assertEquals(35, Kalculator.evaluate(E, B, '+'), DELTA);
        assertEquals(24, Kalculator.evaluate(D, G, '+'), DELTA);
    }

    @Test
    public void divide() {
        assertEquals(2, Kalculator.evaluate(A, B, '/'), DELTA);
        assertEquals(10, Kalculator.evaluate(D, F, '/'), DELTA);
        assertEquals(6, Kalculator.evaluate(E, B, '/'), DELTA);
        assertEquals(5, Kalculator.evaluate(D, G, '/'), DELTA);
    }

    @Test
    public void multiply() {
        assertEquals(50, Kalculator.evaluate(A, B, '*'), DELTA);
        assertEquals(40, Kalculator.evaluate(D, F, '*'), DELTA);
        assertEquals(150, Kalculator.evaluate(E, B, '*'), DELTA);
        assertEquals(80, Kalculator.evaluate(D, G, '*'), DELTA);
    }

    @Test
    public void subtract() {
        assertEquals(5, Kalculator.evaluate(A, B, '-'), DELTA);
        assertEquals(18, Kalculator.evaluate(D, F, '-'), DELTA);
        assertEquals(25, Kalculator.evaluate(E, B, '-'), DELTA);
        assertEquals(16, Kalculator.evaluate(D, G, '-'), DELTA);
    }

    @Test
    public void power() {
        assertEquals(100000, Kalculator.evaluate(A, B, '^'), DELTA);
        assertEquals(400, Kalculator.evaluate(D, F, '^'), DELTA);
        assertEquals(24300000, Kalculator.evaluate(E, B, '^'), DELTA);
        assertEquals(160000, Kalculator.evaluate(D, G, '^'), DELTA);
    }

    @Test
    public void powerWithNegative() {
        assertEquals(1.0E-5, Kalculator.evaluate(A, -B, '^'), DELTA);
        assertEquals(0.0025, Kalculator.evaluate(D, -F, '^'), DELTA);
        assertEquals(4.11522633744856E-8, Kalculator.evaluate(E, -B, '^'), DELTA);
        assertEquals(6.25E-6, Kalculator.evaluate(D, -G, '^'), DELTA);
    }

    @Test
    public void divideByZero() {
        assertEquals(Double.POSITIVE_INFINITY, Kalculator.evaluate(A, 0, '/'), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, Kalculator.evaluate(B, 0, '/'), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, Kalculator.evaluate(D, 0, '/'), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, Kalculator.evaluate(G, 0, '/'), DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void incorrectChar() {
        Kalculator.evaluate(A, B, '(');
        Kalculator.evaluate(A, B, '?');
        Kalculator.evaluate(A, B, '$');
        Kalculator.evaluate(A, B, '|');
    }

    @Test(expected = NullPointerException.class)
    public void incorrectArgm() {
        Kalculator.evaluate(Double.parseDouble(null), B, '(');
        Kalculator.evaluate(Double.parseDouble(null), B, '?');
        Kalculator.evaluate(A, Double.parseDouble(null), '$');
        Kalculator.evaluate(A, Double.parseDouble(null), '|');
    }
}
