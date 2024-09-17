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
        double expected = 11;
        assertEquals(expected, calculator.calculate(5, 6, '+'));

        expected = -10;
        assertEquals(expected, calculator.calculate(-2, -8, '+'));

        expected = -17;
        assertEquals(expected, calculator.calculate(-24, 7, '+'));

        expected = 5;
        assertEquals(expected, calculator.calculate(5, 0, '+'));

        expected = 5;
        assertEquals(expected, calculator.calculate(0, 5, '+'));
    }

    @Test
    void addition_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        });
    }

    @Test
    void subtraction_Ok() {
        double expected = -1;
        assertEquals(expected, calculator.calculate(5, 6, '-'));

        expected = 6;
        assertEquals(expected, calculator.calculate(-2, -8, '-'));

        expected = -31;
        assertEquals(expected, calculator.calculate(-24, 7, '-'));

        expected = 5;
        assertEquals(expected, calculator.calculate(5, 0, '-'));

        expected = -5;
        assertEquals(expected, calculator.calculate(0, 5, '-'));

        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));

        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'));
    }

    @Test
    void multiplication_Ok() {
        double expected = 30;
        assertEquals(expected, calculator.calculate(5, 6, '*'));

        expected = 16;
        assertEquals(expected, calculator.calculate(-2, -8, '*'));

        expected = -168;
        assertEquals(expected, calculator.calculate(-24, 7, '*'));

        expected = 0;
        assertEquals(expected, calculator.calculate(5, 0, '*'));

        expected = 0;
        assertEquals(expected, calculator.calculate(0, 5, '*'));
    }

    @Test
    void multiplication_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        });
    }

    @Test
    void division_Ok() {
        double expected = 2;
        assertEquals(expected, calculator.calculate(8, 4, '/'));

        expected = 4;
        assertEquals(expected, calculator.calculate(-8.0, -2.0, '/'));

        expected = -3;
        assertEquals(expected, calculator.calculate(-24.0, 8.0, '/'));

        expected = 0;
        assertEquals(expected, calculator.calculate(0, 5, '/'));

        expected = 1;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));

        expected = 1;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/'));
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
        double expected = 3125;
        assertEquals(expected, calculator.calculate(5, 5, '^'));

        expected = -3125;
        assertEquals(expected, calculator.calculate(-5, 5, '^'));

        expected = 0.5;
        assertEquals(expected, calculator.calculate(2, -1, '^'));

        expected = -0.5;
        assertEquals(expected, calculator.calculate(-2, -1, '^'));

        expected = 1;
        assertEquals(expected, calculator.calculate(5, 0, '^'));

        expected = 1;
        assertEquals(expected, calculator.calculate(-5, 0, '^'));

        expected = 0;
        assertEquals(expected, calculator.calculate(0, 5, '^'));
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
