package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double NUMBER1 = 25.003;
    private static final double NUMBER2 = 2;

    @Test
    void additionTwoNumbers() {
        assertEquals(NUMBER1 + NUMBER2, Calculator.calculate(NUMBER1, NUMBER2, '+'));
        assertEquals(-NUMBER1 + (-NUMBER2), Calculator.calculate(-NUMBER1, -NUMBER2, '+'));
        assertEquals(NUMBER1 + (-NUMBER2), Calculator.calculate(NUMBER1, -NUMBER2, '+'));
        assertEquals(0 + NUMBER2, Calculator.calculate(0, NUMBER2, '+'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
    }

    @Test
    void subtractionTwoNumbers() {
        assertEquals(NUMBER1 - NUMBER2, Calculator.calculate(NUMBER1, NUMBER2, '-'));
        assertEquals(-NUMBER1 - (-NUMBER2), Calculator.calculate(-NUMBER1, -NUMBER2, '-'));
        assertEquals(-NUMBER1 - NUMBER2, Calculator.calculate(-NUMBER1, NUMBER2, '-'));
        assertEquals(0 - NUMBER2, Calculator.calculate(0, NUMBER2, '-'));
        assertEquals(0.0, Calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '-'));
    }

    @Test
    void divisionTwoNumbers() {
        assertEquals(NUMBER1 / NUMBER2, Calculator.calculate(NUMBER1, NUMBER2, '/'));
        assertEquals(NUMBER2 / (-NUMBER1), Calculator.calculate(-NUMBER2, NUMBER1, '/'));
        assertEquals(0 / NUMBER1, Calculator.calculate(0, NUMBER1, '/'));
        assertEquals(1, Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(NUMBER2, 0, '/'));
    }

    @Test
    void multiplicationTwoNumbers() {
        assertEquals(NUMBER1 * NUMBER2, Calculator.calculate(NUMBER1, NUMBER2, '*'));
        assertEquals(NUMBER1 * (-NUMBER2), Calculator.calculate(NUMBER1, -NUMBER2, '*'));
        assertEquals(0 * NUMBER2, Calculator.calculate(0, NUMBER2, '*'));
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'));
    }

    @Test
    void raisingValueToPower() {
        assertEquals(Math.pow(NUMBER1, NUMBER2), Calculator.calculate(NUMBER1, NUMBER2, '^'));
        assertEquals(Math.pow(NUMBER1, -NUMBER2),
                Calculator.calculate(NUMBER1, -NUMBER2, '^'));
        assertEquals(1, Calculator.calculate(NUMBER1, 0, '^'));
        assertEquals(0, Calculator.calculate(0, NUMBER1, '^'));
        assertThrows(ArithmeticException.class, () -> Calculator.calculate(0, -2, '^'));
        assertThrows(ArithmeticException.class, () -> Calculator.calculate(-NUMBER1, 0.3, '^'));
    }

    @Test
    void operationIsOK() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate(NUMBER1, NUMBER2, '%'));
    }
}
