package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calc;
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char DIV = '/';
    private static final char MUL = '*';
    private static final char POW = '^';
    private double valueFirst;
    private double valueSecond;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calc = new Calculator();
    }

    @Test
    void addPositiveOperands() {
        valueFirst = 5.0;
        valueSecond = 12.0;
        actual = calc.calculate(valueFirst, valueSecond, ADD);
        expected = valueFirst + valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void addNegativeOperands() {
        valueFirst = -5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, ADD);
        expected = valueFirst + valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void addPositiveAndNegativeOperands() {
        valueFirst = 5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, ADD);
        expected = valueFirst + valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void addZeroInDifferentPlaces() {
        valueFirst = 5.0;
        valueSecond = 0;
        actual = calc.calculate(valueFirst, valueSecond, ADD);
        expected = 5.0;
        assertEquals(expected, actual);
        actual = calc.calculate(valueSecond, valueFirst, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void addMaxAndMinDoubleValues() {
        valueFirst = Double.MIN_VALUE;
        valueSecond = Double.MAX_VALUE;
        actual = calc.calculate(valueFirst, valueSecond, ADD);
        expected = valueFirst + valueSecond;
        assertEquals(actual, expected);
    }

    @Test
    void subPositiveOperands() {
        valueFirst = 5.0;
        valueSecond = 12.0;
        actual = calc.calculate(valueFirst, valueSecond, SUB);
        expected = valueFirst - valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void subNegativeOperands() {
        valueFirst = -5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, SUB);
        expected = valueFirst - valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void subPositiveAndNegativeOperands() {
        valueFirst = 5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, SUB);
        expected = valueFirst - valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void subZeroInDifferentPlaces() {
        valueFirst = 5.0;
        actual = calc.calculate(valueFirst, 0, SUB);
        assertEquals(actual, 5.0);
        actual = calc.calculate(0, valueFirst, SUB);
        expected = -5.0;
        assertEquals(expected, actual);
    }

    @Test
    void subMaxAndMinDoubleValues() {
        valueFirst = Double.MIN_VALUE;
        valueSecond = Double.MAX_VALUE;
        actual = calc.calculate(valueFirst, valueSecond, SUB);
        expected = valueFirst - valueSecond;
        assertEquals(actual, expected);
    }

    @Test
    void mulPositiveOperands() {
        valueFirst = 5.0;
        valueSecond = 12.0;
        actual = calc.calculate(valueFirst, valueSecond, MUL);
        expected = valueFirst * valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void mulNegativeOperands() {
        valueFirst = -5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, MUL);
        expected = valueFirst * valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void mulPositiveAndNegativeOperands() {
        valueFirst = 5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, MUL);
        expected = valueFirst * valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void mulZeroInDifferentPlaces() {
        valueFirst = 5.0;
        valueSecond = 0;
        actual = calc.calculate(valueFirst, valueSecond, MUL);
        expected = 0;
        assertEquals(expected, actual);
        actual = calc.calculate(valueSecond, valueFirst, MUL);
        assertEquals(expected, actual);
    }

    @Test
    void mulMaxAndMinDoubleValues() {
        valueFirst = Double.MIN_VALUE;
        valueSecond = Double.MAX_VALUE;
        actual = calc.calculate(valueFirst, valueSecond, MUL);
        expected = valueFirst * valueSecond;
        assertEquals(actual, expected);
    }

    @Test
    void divPositiveOperands() {
        valueFirst = 5.0;
        valueSecond = 12.0;
        actual = calc.calculate(valueFirst, valueSecond, DIV);
        expected = valueFirst / valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void divNegativeOperands() {
        valueFirst = -5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, DIV);
        expected = valueFirst / valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void divPositiveAndNegativeOperands() {
        valueFirst = 5.0;
        valueSecond = -12.0;
        actual = calc.calculate(valueFirst, valueSecond, DIV);
        expected = valueFirst / valueSecond;
        assertEquals(expected, actual);
    }

    @Test
    void divZeroInDifferentPlaces() {
        valueFirst = 5.0;
        valueSecond = 0;
        assertThrows(ArithmeticException.class, () -> calc.calculate(valueFirst, valueSecond, DIV));
        expected = 0;
        actual = calc.calculate(valueSecond, valueFirst, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void divMaxAndMinDoubleValues() {
        valueFirst = Double.MIN_VALUE;
        valueSecond = Double.MAX_VALUE;
        actual = calc.calculate(valueSecond, valueFirst, DIV);
        expected = valueSecond / valueFirst;
        assertEquals(actual, expected);
    }

    @Test
    void raisingPositiveToPowerPositive() {
        valueFirst = 2;
        valueSecond = 8;
        double actual = calc.calculate(valueFirst, valueSecond, POW);
        double expected = 256;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToPowerNegative() {
        valueFirst = 5;
        valueSecond = -2;
        actual = calc.calculate(valueFirst, valueSecond, POW);
        expected = 0.04;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPowerPositive() {
        valueFirst = -5;
        valueSecond = 2;
        actual = calc.calculate(valueFirst, valueSecond, POW);
        expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPowerNegative() {
        valueFirst = -2;
        valueSecond = -5;
        double actual = calc.calculate(valueFirst, valueSecond, POW);
        double expected = -0.03125;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToPowerOfZero() {
        valueFirst = 5;
        valueSecond = 0;
        double actual = calc.calculate(valueFirst, valueSecond, POW);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPowerOfZero_OK() {
        valueFirst = -5;
        valueSecond = 0;
        double actual = calc.calculate(valueFirst, valueSecond, POW);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOK() {
        valueFirst = -5;
        valueSecond = 0;
        char invalidChar = '@';
        assertThrows(RuntimeException.class, () ->
                calc.calculate(valueFirst, valueSecond, invalidChar));
    }
}
