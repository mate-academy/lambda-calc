package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char DIV = '/';
    private static final char MUL = '*';
    private static final char POW = '^';
    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;
    private static final String ERROR_MSG = "Operation %c was reject. Check test.";
    private static Calculator testCalculator;

    @BeforeAll
    public static void beforeAll() {
        testCalculator = new Calculator();
    }

    @Test
    public void addCalculateOk() {
        assertEquals(7, testCalculator.calculate(2, 5, ADD),
                String.format(ERROR_MSG, ADD));
        assertEquals(3, testCalculator.calculate(-2, 5, ADD),
                String.format(ERROR_MSG, ADD));
        assertEquals(-3, testCalculator.calculate(2, -5, ADD),
                String.format(ERROR_MSG, ADD));
        assertEquals(-7, testCalculator.calculate(-2, -5, ADD),
                String.format(ERROR_MSG, ADD));
        assertEquals(1000, testCalculator.calculate(999, 1, ADD),
                String.format(ERROR_MSG, ADD));
        assertEquals(5, testCalculator.calculate(0, 5, ADD),
                String.format(ERROR_MSG, ADD));
        assertEquals(5, testCalculator.calculate(5, 0, ADD),
                String.format(ERROR_MSG, ADD));
        assertEquals(0, testCalculator.calculate(0, 0, ADD),
                String.format(ERROR_MSG, ADD));
    }

    @Test
    public void subCalculateOk() {
        assertEquals(-3, testCalculator.calculate(2, 5, SUB),
                String.format(ERROR_MSG, SUB));
        assertEquals(-7, testCalculator.calculate(-2, 5, SUB),
                String.format(ERROR_MSG, SUB));
        assertEquals(7, testCalculator.calculate(2, -5, SUB),
                String.format(ERROR_MSG, SUB));
        assertEquals(3, testCalculator.calculate(-2, -5, SUB),
                String.format(ERROR_MSG, SUB));
        assertEquals(-5, testCalculator.calculate(0, 5, SUB),
                String.format(ERROR_MSG, SUB));
        assertEquals(5, testCalculator.calculate(5, 0, SUB),
                String.format(ERROR_MSG, SUB));
        assertEquals(0, testCalculator.calculate(0, 0, SUB),
                String.format(ERROR_MSG, SUB));
    }

    @Test
    public void divCalculateOk() {
        assertEquals(5, testCalculator.calculate(10, 2, DIV),
                String.format(ERROR_MSG, DIV));
        assertEquals(-5, testCalculator.calculate(10, -2, DIV),
                String.format(ERROR_MSG, DIV));
        assertEquals(-5, testCalculator.calculate(-10, 2, DIV),
                String.format(ERROR_MSG, DIV));
        assertEquals(5, testCalculator.calculate(-10, -2, DIV),
                String.format(ERROR_MSG, DIV));
        assertEquals(0, testCalculator.calculate(0, 5, DIV),
                String.format(ERROR_MSG, DIV));
    }

    @Test
    public void mulCalculateOk() {
        assertEquals(10, testCalculator.calculate(2, 5, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(10, testCalculator.calculate(5, 2, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(-10, testCalculator.calculate(-2, 5, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(-10, testCalculator.calculate(2, -5, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(-10, testCalculator.calculate(-5, 2, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(-10, testCalculator.calculate(5, -2, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(10, testCalculator.calculate(-2, -5, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(1000, testCalculator.calculate(1000, 1, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(1000, testCalculator.calculate(1, 1000, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(0, testCalculator.calculate(0, 5, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(0, testCalculator.calculate(5, 0, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(0, testCalculator.calculate(0, -5, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(0, testCalculator.calculate(-5, 0, MUL),
                String.format(ERROR_MSG, MUL));
        assertEquals(0, testCalculator.calculate(0, 0, MUL),
                String.format(ERROR_MSG, MUL));
    }

    @Test
    public void powCalculateOk() {
        assertEquals(32, testCalculator.calculate(2, 5, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(25, testCalculator.calculate(5, 2, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(-32, testCalculator.calculate(-2, 5, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(0.03125,
                testCalculator.calculate(2, -5, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(25, testCalculator.calculate(-5, 2, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(0.04,
                testCalculator.calculate(5, -2, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(-0.03125,
                testCalculator.calculate(-2, -5, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(1000,
                testCalculator.calculate(1000, 1, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(1,
                testCalculator.calculate(1, 1000, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(0,
                testCalculator.calculate(0, 5, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(1,
                testCalculator.calculate(5, 0, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(Double.POSITIVE_INFINITY,
                testCalculator.calculate(0, -5, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(1,
                testCalculator.calculate(-5, 0, POW),
                String.format(ERROR_MSG, POW));
        assertEquals(1,
                testCalculator.calculate(0, 0, POW),
                String.format(ERROR_MSG, POW));
    }

    @Test
    public void InvalidOperationSymbol() {
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, ' '));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, '$'));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, 's'));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, '5'));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, 'M'));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, 'A'));
    }

    @Test
    public void maxAndMinValue() {
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(MAX, 1, ADD));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(MIN, 1, SUB));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(MAX, 2, MUL));
        assertEquals(0, testCalculator.calculate(MAX, MAX, SUB));
        assertEquals(0, testCalculator.calculate(MIN, MIN, SUB));
    }

    @Test
    public void divToZero() {
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(5, 0, DIV));
    }
}
