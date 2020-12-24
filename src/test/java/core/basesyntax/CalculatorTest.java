package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addition_Ok() {
        assertEquals(5 + 6, calculator.calculate(5, 6, '+'));
        assertEquals((-2) + (-8), calculator.calculate(-2, -8, '+'));
        assertEquals((-24) + 7, calculator.calculate(-24, 7, '+'));
        assertEquals(5, calculator.calculate(5, 0, '+'));
        assertEquals(5, calculator.calculate(0, 5, '+'));
    }

    @Test
    void addition_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        });
    }

    @Test
    void subtraction_Ok() {
        assertEquals(5 - 6, calculator.calculate(5, 6, '-'));
        assertEquals((-2) - (-8), calculator.calculate(-2, -8, '-'));
        assertEquals((-24) - 7, calculator.calculate(-24, 7, '-'));
        assertEquals(5, calculator.calculate(5, 0, '-'));
        assertEquals(-5, calculator.calculate(0, 5, '-'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));
        assertEquals(0, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'));
    }

    @Test
    void multiplication_Ok() {
        assertEquals(5 * 6, calculator.calculate(5, 6, '*'));
        assertEquals((-2) * (-8), calculator.calculate(-2, -8, '*'));
        assertEquals((-24) * 7, calculator.calculate(-24, 7, '*'));
        assertEquals(0, calculator.calculate(5, 0, '*'));
        assertEquals(0, calculator.calculate(0, 5, '*'));
    }

    @Test
    void multiplication_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        });
    }

    @Test
    void division_Ok() {
        assertEquals(5.0 / 6.0, calculator.calculate(5, 6, '/'));
        assertEquals((-2.0) / (-8.0), calculator.calculate(-2.0, -8.0, '/'));
        assertEquals((-24.0) / 7.0, calculator.calculate(-24.0, 7.0, '/'));
        assertEquals(0, calculator.calculate(0, 5, '/'));
        assertEquals(1, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));
        assertEquals(1, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/'));
    }

    @Test
    void division_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, 0, '/');
            calculator.calculate(1, 0, '/');
        });
    }

    @Test
    void power_Ok() {
        assertEquals(Math.pow(5, 5), calculator.calculate(5, 5, '^'));
        assertEquals(Math.pow(-5, 5), calculator.calculate(-5, 5, '^'));
        assertEquals(Math.pow(5, -5), calculator.calculate(5, -5, '^'));
        assertEquals(Math.pow(-5, -5), calculator.calculate(-5, -5, '^'));
        assertEquals(Math.pow(5, 0), calculator.calculate(5, 0, '^'));
        assertEquals(Math.pow(-5, 0), calculator.calculate(-5, 0, '^'));
        assertEquals(Math.pow(0, 5), calculator.calculate(0, 5, '^'));
    }

    @Test
    void operation_NotOk() {
        int first = 0;
        int second = 0;
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(first, second, ' ');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(first, second, 'i');
        });
    }

    @Test
    void pow_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(55555, 55555, '^');
        });
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, -5, '^');
        });
    }
}
