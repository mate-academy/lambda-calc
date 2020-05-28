package core.basesyntax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static final double DELTA = 1e-15;

    @Test
    public void evaluate_CheckStandardExpressions_True() {
        assertEquals(-0.0, Calculator.evaluate("(-0.0) + (-0.0)"), DELTA);

        assertEquals(4, Calculator.evaluate("2 + 2"), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, Calculator.evaluate("2 / 0"), DELTA);
        assertEquals(5051, Calculator.evaluate("5050 + 1"), DELTA);
        assertEquals(5051, Calculator.evaluate("5052 - 1"), DELTA);
        assertEquals(1488, Calculator.evaluate("30 + 20 - 1 * 2 - -1440"), DELTA);
        assertEquals(-177.0, Calculator.evaluate("(2 + 2) - 2 + 7 * 5 - (318 - 2 * (55 - 3))"), DELTA);
        assertEquals(-5585.091684, Calculator.evaluate("((918-232) - 5) * 0.219836 - (2323 * 3 - (1235.2 - 1))"), DELTA);
        assertEquals(-5586.091684, Calculator.evaluate("((918-232) - 5) * 0.219836 - (2323 * 3 - (1235.2 - 1))" + '-' + '1'), DELTA);
    }

    @Test(expected = RuntimeException.class)
    public void evaluate_InvalidExpression_RuntimeExceptionThrown() {
        Calculator.evaluate("one plus one");
    }

    @Test(expected = RuntimeException.class)
    public void evaluate_InvalidParenthesis_RuntimeExceptionThrown() {
        Calculator.evaluate("(2 + 2) - 7 - ((1)");
    }

    @Test(expected = NullPointerException.class)
    public void evaluate_EmptyString_RuntimeExceptionThrown() {
        Calculator.evaluate("");
    }
}
