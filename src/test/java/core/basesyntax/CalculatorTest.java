package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String DIV = "/";
    private static final String MUL = "*";
    private static final String POW = "^";
    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;
    private Calculator testCalculator;

    @BeforeEach
    void getCalculator() {
        testCalculator = new Calculator();
    }

    @Test
    void addCalculateOk() {
        assertEquals(7, testCalculator.calculate(2, 5, ADD));
        assertEquals(3, testCalculator.calculate(-2, 5, ADD));
        assertEquals(-7, testCalculator.calculate(-2, -5, ADD));
        assertEquals(1000, testCalculator.calculate(999, 1, ADD));
        assertEquals(5, testCalculator.calculate(0, 5, ADD));
        assertEquals(5, testCalculator.calculate(5, 0, ADD));
        assertEquals(0, testCalculator.calculate(0, 0, ADD));
    }

    @Test
    void subCalculateOk() {
        assertEquals(-3, testCalculator.calculate(2, 5, SUB));
        assertEquals(-7, testCalculator.calculate(-2, 5, SUB));
        assertEquals(3, testCalculator.calculate(-2, -5, SUB));
        assertEquals(999, testCalculator.calculate(1000, 1, SUB));
        assertEquals(-5, testCalculator.calculate(0, 5, SUB));
        assertEquals(5, testCalculator.calculate(5, 0, SUB));
        assertEquals(0, testCalculator.calculate(0, 0, SUB));
    }

    @Test
    void divCalculateOk() {
        assertEquals(5, testCalculator.calculate(10, 2, DIV));
        assertEquals(-5, testCalculator.calculate(10, -2, DIV));
        assertEquals(-5, testCalculator.calculate(-10, 2, DIV));
        assertEquals(5, testCalculator.calculate(-10, -2, DIV));
        assertEquals(1000, testCalculator.calculate(1000, 1, DIV));
        assertEquals(0, testCalculator.calculate(0, 5, DIV));
    }

    @Test
    void mulCalculateOk() {
        assertEquals(10, testCalculator.calculate(2, 5, MUL));
        assertEquals(10, testCalculator.calculate(5, 2, MUL));
        assertEquals(-10, testCalculator.calculate(-2, 5, MUL));
        assertEquals(-10, testCalculator.calculate(2, -5, MUL));
        assertEquals(-10, testCalculator.calculate(-5, 2, MUL));
        assertEquals(-10, testCalculator.calculate(5, -2, MUL));
        assertEquals(10, testCalculator.calculate(-2, -5, MUL));
        assertEquals(1000, testCalculator.calculate(1000, 1, MUL));
        assertEquals(1000, testCalculator.calculate(1, 1000, MUL));
        assertEquals(0, testCalculator.calculate(0, 5, MUL));
        assertEquals(0, testCalculator.calculate(5, 0, MUL));
        assertEquals(0, testCalculator.calculate(0, -5, MUL));
        assertEquals(0, testCalculator.calculate(-5, 0, MUL));
        assertEquals(0, testCalculator.calculate(0, 0, MUL));
    }

    @Test
    void powCalculateOk() {
        assertEquals(32, testCalculator.calculate(2, 5, POW));
        assertEquals(25, testCalculator.calculate(5, 2, POW));
        assertEquals(-32, testCalculator.calculate(-2, 5, POW));
        assertEquals(0.03125, testCalculator.calculate(2, -5, POW));
        assertEquals(25, testCalculator.calculate(-5, 2, POW));
        assertEquals(0.04, testCalculator.calculate(5, -2, POW));
        assertEquals(-0.03125, testCalculator.calculate(-2, -5, POW));
        assertEquals(1000, testCalculator.calculate(1000, 1, POW));
        assertEquals(1, testCalculator.calculate(1, 1000, POW));
        assertEquals(0, testCalculator.calculate(0, 5, POW));
        assertEquals(1, testCalculator.calculate(5, 0, POW));
        assertEquals(Double.POSITIVE_INFINITY, testCalculator.calculate(0, -5, POW));
        assertEquals(1, testCalculator.calculate(-5, 0, POW));
        assertEquals(1, testCalculator.calculate(0, 0, POW));
    }

    @Test
    void InvalidOperationSymbol() {
        assertThrows(NullPointerException.class,
                () -> testCalculator.calculate(-5, 0, null));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, "$"));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, "s"));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, "5"));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, "MUL"));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, "ADD"));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, "*/"));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(-5, 0, "+-"));
        assertEquals(-5,
                testCalculator.calculate(-5, 0, "+   "));
    }

    @Test
    void maxAndMinValue() {
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(MAX, 1, ADD));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(MIN, 1, SUB));
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(MAX, 2, MUL));
        assertEquals(0,testCalculator.calculate(MAX,MAX, SUB));
        assertEquals(0,testCalculator.calculate(MIN,MIN, SUB));
    }

    @Test
    void divToZero() {
        assertThrows(ArithmeticException.class,
                () -> testCalculator.calculate(5, 0, DIV));
    }
}
