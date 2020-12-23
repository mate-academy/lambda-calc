package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0;
    private static final double NUMBER1 = 25;
    private static final double NUMBER2 = 2;

    @Test
    void additionTwoNumbers() {
        assertEquals(27, Calculator.calculate(NUMBER1, NUMBER2, '+'), DELTA);
        assertEquals(-27, Calculator.calculate(-NUMBER1, -NUMBER2, '+'), DELTA);
        assertEquals(23, Calculator.calculate(NUMBER1, -NUMBER2, '+'), DELTA);
        assertEquals(2, Calculator.calculate(0, NUMBER2, '+'), DELTA);
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
    }

    @Test
    void subtractionTwoNumbers() {
        assertEquals(23, Calculator.calculate(NUMBER1, NUMBER2, '-'),DELTA);
        assertEquals(-23, Calculator.calculate(-NUMBER1, -NUMBER2, '-'),DELTA);
        assertEquals(-27, Calculator.calculate(-NUMBER1, NUMBER2, '-'),DELTA);
        assertEquals(-2, Calculator.calculate(0, NUMBER2, '-'),DELTA);
        assertEquals(0.0, Calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'),DELTA);
    }

    @Test
    void divisionTwoNumbers() {
        assertEquals(12.5, Calculator.calculate(NUMBER1, NUMBER2, '/'), DELTA);
        assertEquals(-0.08, Calculator.calculate(-NUMBER2, NUMBER1, '/'), DELTA);
        assertEquals(0, Calculator.calculate(0, NUMBER1, '/'), DELTA);
        assertEquals(1, Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'), DELTA);
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(NUMBER2, 0, '/'));
    }

    @Test
    void multiplicationTwoNumbers() {
        assertEquals(50, Calculator.calculate(NUMBER1, NUMBER2, '*'),DELTA);
        assertEquals(-50, Calculator.calculate(NUMBER1, -NUMBER2, '*'),DELTA);
        assertEquals(0, Calculator.calculate(0, NUMBER2, '*'),DELTA);
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'));
    }

    @Test
    void raisingValueToPower() {
        double division = Calculator.calculate(NUMBER1, -NUMBER2, '/');
        assertEquals(156.25, Calculator.calculate(division, NUMBER2, '^'), DELTA);
        assertEquals(Math.pow(division, -NUMBER2),
                Calculator.calculate(division, -NUMBER2, '^'), DELTA);
        assertEquals(1, Calculator.calculate(division, 0, '^'), DELTA);
        assertEquals(0, Calculator.calculate(0, NUMBER1, '^'), DELTA);
    }

    @Test
    void operationIsOK() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate(NUMBER1, NUMBER2, '5'));
    }
}
