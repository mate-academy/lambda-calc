package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calc;
    private double value1;
    private double value2;
    private double actual;
    private double expected;
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char DIV = '/';
    private static final char MUL = '*';
    private static final char EXP = '^';
    //private static final double MIN_DOUBLE = Double.MIN_VALUE;
    //private static final double MAX_DOUBLE = Double.MAX_VALUE;

    @BeforeAll
    static void beforeAll() {
        calc = new Calculator();
    }

    @Test
    void addPositiveOperands() {
        value1 = 5.0;
        value2 = 12.0;
        actual = calc.calculate(value1, value2, ADD);
        expected = value1 + value2;
        assertEquals(expected, actual);
    }

    @Test
    void addNegativeOperands() {
        value1 = -5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, ADD);
        expected = value1 + value2;
        assertEquals(expected, actual);
    }

    @Test
    void addPositiveAndNegativeOperands() {
        value1 = 5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, ADD);
        expected = value1 + value2;
        assertEquals(expected, actual);
    }

    @Test
    void addZeroInDifferentPlaces() {
        value1 = 5.0;
        value2 = 0;
        actual = calc.calculate(value1, value2, ADD);
        expected = 5.0;
        assertEquals(expected, actual);
        actual = calc.calculate(value2, value1, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void addMaxAndMinDoubleValues() {///
        value1 = Double.MIN_VALUE;
        value2 = Double.MAX_VALUE;
        actual = calc.calculate(value1, value2, ADD);
        expected = value1 + value2;
        assertEquals(actual, expected);
    }

    @Test
    void subPositiveOperands() {
        value1 = 5.0;
        value2 = 12.0;
        actual = calc.calculate(value1, value2, SUB);
        expected = value1 - value2;
        assertEquals(expected, actual);
    }

    @Test
    void subNegativeOperands() {
        value1 = -5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, SUB);
        expected = value1 - value2;
        assertEquals(expected, actual);
    }

    @Test
    void subPositiveAndNegativeOperands() {
        value1 = 5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, SUB);
        expected = value1 - value2;
        assertEquals(expected, actual);
    }

    @Test
    void subZeroInDifferentPlaces() {
        value1 = 5.0;
        actual = calc.calculate(value1, 0, SUB);
        assertEquals(actual, 5.0);
        actual = calc.calculate(0, value1, SUB);
        expected = -5.0;
        assertEquals(expected, actual);
    }

    @Test
    void subMaxAndMinDoubleValues() {
        value1 = Double.MIN_VALUE;
        value2 = Double.MAX_VALUE;
        actual = calc.calculate(value1, value2, SUB);
        expected = value1 - value2;
        assertEquals(actual, expected);
    }

    @Test
    void mulPositiveOperands() {
        value1 = 5.0;
        value2 = 12.0;
        actual = calc.calculate(value1, value2, MUL);
        expected = value1 * value2;
        assertEquals(expected, actual);
    }

    @Test
    void mulNegativeOperands() {
        value1 = -5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, MUL);
        expected = value1 * value2;
        assertEquals(expected, actual);
    }

    @Test
    void mulPositiveAndNegativeOperands() {
        value1 = 5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, MUL);
        expected = value1 * value2;
        assertEquals(expected, actual);
    }

    @Test
    void mulZeroInDifferentPlaces() {
        value1 = 5.0;
        value2 = 0;
        actual = calc.calculate(value1, value2, MUL);
        expected = 0;
        assertEquals(expected, actual);
        actual = calc.calculate(value2, value1, MUL);
        assertEquals(expected, actual);
    }

    @Test
    void mulMaxAndMinDoubleValues() {
        value1 = Double.MIN_VALUE;
        value2 = Double.MAX_VALUE;
        actual = calc.calculate(value1, value2, MUL);
        expected = value1 * value2;
        assertEquals(actual, expected);
    }

    @Test
    void divPositiveOperands() {
        value1 = 5.0;
        value2 = 12.0;
        actual = calc.calculate(value1, value2, DIV);
        expected = value1 / value2;
        assertEquals(expected, actual);
    }

    @Test
    void divNegativeOperands() {
        value1 = -5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, DIV);
        expected = value1 / value2;
        assertEquals(expected, actual);
    }

    @Test
    void divPositiveAndNegativeOperands() {
        value1 = 5.0;
        value2 = -12.0;
        actual = calc.calculate(value1, value2, DIV);
        expected = value1 / value2;
        assertEquals(expected, actual);
    }

    @Test
    void divZeroInDifferentPlaces() {
        value1 = 5.0;
        value2 = 0;
        assertThrows(ArithmeticException.class, () -> calc.calculate(value1, value2, '/'));
        expected = 0;
        actual = calc.calculate(value2, value1, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void divMaxAndMinDoubleValues() {
        value1 = Double.MIN_VALUE;
        value2 = Double.MAX_VALUE;
        actual = calc.calculate(value2, value1, DIV);
        expected = value2 / value1;
        assertEquals(actual, expected);
    }

    @Test
    void name() {
    }
}