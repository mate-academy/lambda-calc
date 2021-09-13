package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addition_Ok() {
        expected = 15.0;
        assertEquals(expected, calculator.calculate(7.6, 7.4, '+'));
        assertEquals(-expected, calculator.calculate(-10, -5, '+'));
        assertEquals(expected, calculator.calculate(25.5, -10.5, '+'));
        assertEquals(-expected, calculator.calculate(-20, 5, '+'));
        assertEquals(expected, calculator.calculate(15, 0, '+'));
        assertEquals(expected, calculator.calculate(0, 15, '+'));
        assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
        assertEquals(Double.MIN_VALUE * 2,
                calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+'));
    }

    @Test
    void calculate_subtraction_Ok() {
        expected = 20;
        assertEquals(expected, calculator.calculate(25.5, 5.5, '-'));
        assertEquals(-expected, calculator.calculate(-25, -5, '-'));
        assertEquals(expected, calculator.calculate(15, -5, '-'));
        assertEquals(-expected, calculator.calculate(-5, 15, '-'));
        assertEquals(expected, calculator.calculate(20, 0, '-'));
        assertEquals(-expected, calculator.calculate(0, 20, '-'));
        assertEquals(0, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));
    }

    @Test
    void multiplication_Ok() {
        double expected = 5;
        assertEquals(expected, calculator.calculate(2.5, 2, '*'));
        assertEquals(expected, calculator.calculate(-2.5, -2, '*'));
        assertEquals(-expected, calculator.calculate(-2.5, 2, '*'));
        assertEquals(-expected, calculator.calculate(2.5, -2, '*'));
        assertEquals(0, calculator.calculate(2.5, 0, '*'));
        assertEquals(0, calculator.calculate(0, 2.5, '*'));
        assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*'));
    }

    @Test
    void division_Ok() {
        double expected = 15.5;
        assertEquals(expected, calculator.calculate(35.65, 2.3, '/'));
        assertEquals(expected, calculator.calculate(-35.65, -2.3, '/'));
        assertEquals(-expected, calculator.calculate(35.65, -2.3, '/'));
        assertEquals(-expected, calculator.calculate(-35.65, 2.3, '/'));
        assertEquals(0, calculator.calculate(0, 2.3, '/'));
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(25, 0, '/');
        });
        assertEquals(1,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));
        assertEquals(1, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/'));
    }

    @Test
    void raising_to_power_Ok() {
        assertEquals(27, calculator.calculate(3,3,'^'));
        assertEquals(4, calculator.calculate(-2, 2, '^'));
        assertEquals(0.25, calculator.calculate(2, -2, '^'));
        assertEquals(0.25, calculator.calculate(-2, -2, '^'));
        assertEquals(1, calculator.calculate(5, 0, '^'));
        assertEquals(1, calculator.calculate(-5, 0, '^'));
        assertEquals(0, calculator.calculate(0, 5, '^'));
    }

    @Test
    void calculate_illegal_operation_notOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '$'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '!'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '@'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '#'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '%'));
    }
}
