package core.basesyntax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static final double DELTA = 1e-15;

    @Test
    public void evaluate_Sum_True() {
        assertEquals(4, Calculator.evaluate(2, 2, '+'), DELTA);
        assertEquals(40, Calculator.evaluate(20, 20, '+'), DELTA);
        assertEquals(400, Calculator.evaluate(200, 200, '+'), DELTA);
        assertEquals(4000, Calculator.evaluate(2000, 2000, '+'), DELTA);
        assertEquals(40_000_000_000_000d, Calculator.evaluate(20_000_000_000_000d, 20_000_000_000_000d, '+'), DELTA);
    }

    @Test
    public void evaluate_Subtraction_True() {
        assertEquals(4, Calculator.evaluate(8, 4, '-'), DELTA);
        assertEquals(40, Calculator.evaluate(80, 40, '-'), DELTA);
        assertEquals(400, Calculator.evaluate(800, 400, '-'), DELTA);
        assertEquals(4000, Calculator.evaluate(8000, 4000, '-'), DELTA);
        assertEquals(40_000_000_000_000d, Calculator.evaluate(80_000_000_000_000d, 40_000_000_000_000d, '-'), DELTA);
    }

    @Test
    public void evaluate_Multiplication_True() {
        assertEquals(4, Calculator.evaluate(2, 2, '*'), DELTA);
        assertEquals(400, Calculator.evaluate(20, 20, '*'), DELTA);
        assertEquals(40000, Calculator.evaluate(200, 200, '*'), DELTA);
        assertEquals(4000000, Calculator.evaluate(2000, 2000, '*'), DELTA);
        assertEquals(400_000_000_000_000_000_000_000_000d, Calculator.evaluate(20_000_000_000_000d, 20_000_000_000_000d, '*'), DELTA);
    }

    @Test
    public void evaluate_Division_True() {
        assertEquals(4, Calculator.evaluate(16, 4, '/'), DELTA);
        assertEquals(40, Calculator.evaluate(160, 4, '/'), DELTA);
        assertEquals(400, Calculator.evaluate(1600, 4, '/'), DELTA);
        assertEquals(4000, Calculator.evaluate(16000, 4, '/'), DELTA);
        assertEquals(400_000_000_000_000_000_000_000_000d, Calculator.evaluate(1600_000_000_000_000_000_000_000_000d, 4, '/'), DELTA);
    }

    @Test
    public void evaluate_Exponentiation_True() {
        assertEquals(4, Calculator.evaluate(2, 2, '^'), DELTA);
        assertEquals(8, Calculator.evaluate(2, 3, '^'), DELTA);
        assertEquals(16, Calculator.evaluate(2, 4, '^'), DELTA);
        assertEquals(32, Calculator.evaluate(2, 5, '^'), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, Calculator.evaluate(2, 1024, '^'), DELTA);
    }

    @Test
    public void evaluate_DivideByZero_Infinity() {
        assertEquals(Double.POSITIVE_INFINITY, Calculator.evaluate(2, 0, '/'), DELTA);
    }

    @Test(expected = RuntimeException.class)
    public void evaluate_IncorrectCharacter_ThrowsRuntimeException() {
        Calculator.evaluate(2, 2, '(');
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_null_ThrowsRuntimeException() {
        Calculator.evaluate(Double.parseDouble(null), 2, '/');
    }
}
