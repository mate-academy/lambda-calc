package core.basesyntax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    private static final double DELTA = 1e-15;
    private static final double A = 10;
    private static final double B = 5;
    private static final double D = 20;
    private static final double E = 30;
    private static final double F = 2;
    private static final double G = 4;

    @Test
    public void sumWithPositiveNumbers() {
        assertEquals(15, calculator.calculate(A, B, '+'), DELTA);
        assertEquals(22, calculator.calculate(D, F, '+'), DELTA);
        assertEquals(35, calculator.calculate(E, B, '+'), DELTA);
        assertEquals(24, calculator.calculate(D, G, '+'), DELTA);
    }

    @Test
    public void divideWithPositiveNumbers() {
        assertEquals(2, calculator.calculate(A, B, '/'), DELTA);
        assertEquals(10, calculator.calculate(D, F, '/'), DELTA);
        assertEquals(6, calculator.calculate(E, B, '/'), DELTA);
        assertEquals(5, calculator.calculate(D, G, '/'), DELTA);
    }

    @Test
    public void multiplyWithPositiveNumbers() {
        assertEquals(50, calculator.calculate(A, B, '*'), DELTA);
        assertEquals(40, calculator.calculate(D, F, '*'), DELTA);
        assertEquals(150, calculator.calculate(E, B, '*'), DELTA);
        assertEquals(80, calculator.calculate(D, G, '*'), DELTA);
    }

    @Test
    public void subtractWithPositiveNumbers() {
        assertEquals(5, calculator.calculate(A, B, '-'), DELTA);
        assertEquals(18, calculator.calculate(D, F, '-'), DELTA);
        assertEquals(25, calculator.calculate(E, B, '-'), DELTA);
        assertEquals(16, calculator.calculate(D, G, '-'), DELTA);
    }

    @Test
    public void powerWithPositiveNumbers() {
        assertEquals(100000, calculator.calculate(A, B, '^'), DELTA);
        assertEquals(400, calculator.calculate(D, F, '^'), DELTA);
        assertEquals(24300000, calculator.calculate(E, B, '^'), DELTA);
        assertEquals(160000, calculator.calculate(D, G, '^'), DELTA);
    }

    @Test
    public void powerWithNegative() {
        assertEquals(1.0E-5, calculator.calculate(A, -B, '^'), DELTA);
        assertEquals(0.0025, calculator.calculate(D, -F, '^'), DELTA);
        assertEquals(4.11522633744856E-8, calculator.calculate(E, -B, '^'), DELTA);
        assertEquals(6.25E-6, calculator.calculate(D, -G, '^'), DELTA);
    }

    @Test
    public void divideByZero() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(A, 0d, '/'), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(B, 0d, '/'), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(D, 0d, '/'), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(G, 0d, '/'), DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void incorrectChar() {
        calculator.calculate(A, B, '(');
    }

    @Test(expected = NullPointerException.class)
    public void incorrectArgm() {
        calculator.calculate(Double.parseDouble(null), B, '/');
    }
}