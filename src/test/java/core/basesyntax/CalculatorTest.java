package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double FIRST_NUMBER = 25.003;
    private static final double SECOND_NUMBER = 2;
    private static final double NEGATIVE_FIRST_NUMBER = -25;
    private static final double NEGATIVE_SECOND_NUMBER = -3;
    private static double expected;

    @Test
    void additionTwoNumbers() {
        expected = FIRST_NUMBER + SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, '+'));
        expected = NEGATIVE_FIRST_NUMBER + NEGATIVE_SECOND_NUMBER;
        assertEquals(expected,
                Calculator.calculate(NEGATIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, '+'));
        expected = FIRST_NUMBER + NEGATIVE_SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, '+'));
        expected = 0 + SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(0, SECOND_NUMBER, '+'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
    }

    @Test
    void subtractionTwoNumbers() {
        expected = FIRST_NUMBER - SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, '-'));
        expected = NEGATIVE_FIRST_NUMBER - NEGATIVE_SECOND_NUMBER;
        assertEquals(expected,
                Calculator.calculate(NEGATIVE_FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, '-'));
        expected = NEGATIVE_FIRST_NUMBER - SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(NEGATIVE_FIRST_NUMBER, SECOND_NUMBER, '-'));
        expected = 0 - SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(0, SECOND_NUMBER, '-'));
        expected = 0.0;
        assertEquals(expected, Calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '-'));
    }

    @Test
    void divisionTwoNumbers() {
        expected = FIRST_NUMBER / SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, '/'));
        expected = SECOND_NUMBER / NEGATIVE_FIRST_NUMBER;
        assertEquals(expected, Calculator.calculate(SECOND_NUMBER, NEGATIVE_FIRST_NUMBER, '/'));
        expected = 0;
        assertEquals(expected, Calculator.calculate(0, FIRST_NUMBER, '/'));
        expected = 1;
        assertEquals(expected, Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(SECOND_NUMBER, 0, '/'));
    }

    @Test
    void multiplicationTwoNumbers() {
        expected = FIRST_NUMBER * SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, '*'));
        expected = FIRST_NUMBER * NEGATIVE_SECOND_NUMBER;
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, '*'));
        expected = 0;
        assertEquals(expected, Calculator.calculate(0, SECOND_NUMBER, '*'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'));
    }

    @Test
    void raisingValueToPower() {
        expected = Math.pow(FIRST_NUMBER, SECOND_NUMBER);
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, '^'));
        expected = Math.pow(FIRST_NUMBER, NEGATIVE_SECOND_NUMBER);
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, NEGATIVE_SECOND_NUMBER, '^'));
        expected = 1;
        assertEquals(expected, Calculator.calculate(FIRST_NUMBER, 0, '^'));
        expected = 0;
        assertEquals(expected, Calculator.calculate(0, FIRST_NUMBER, '^'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(0, -2, '^'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(-FIRST_NUMBER, 0.3, '^'));
    }

    @Test
    void operationIsOK() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, '%'));
    }
}
