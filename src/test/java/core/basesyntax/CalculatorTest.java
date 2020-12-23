package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void addition_positive_ok() {
        assertEquals(4, calculator.calculate(2, 2, '+'));
        assertEquals(143234, calculator.calculate(72143, 71091, '+'));
    }

    @Test
    void addition_negative_result_ok() {
        assertEquals(-17, calculator.calculate(-9, -8, '+'));
        assertEquals(-143234, calculator.calculate(-72143, -71091, '+'));
    }

    @Test
    void addition_negative_ok() {
        assertEquals(-10, calculator.calculate(10, -20, '+'));
        assertEquals(43, calculator.calculate(-21, 64, '+'));
    }

    @Test
    void subtraction_positive_ok() {
        assertEquals(1, calculator.calculate(3, 2, '-'));
        assertEquals(72143, calculator.calculate(143234, 71091, '-'));
    }

    @Test
    void subtraction_negative_result_ok() {
        assertEquals(-17, calculator.calculate(-67, -50, '-'));
        assertEquals(-1052, calculator.calculate(-72143, -71091, '-'));
    }

    @Test
    void subtraction_negative_ok() {
        assertEquals(10, calculator.calculate(-20, -30, '-'));
        assertEquals(43, calculator.calculate(-21, -64, '-'));
    }

    @Test
    void multiplication_ok() {
        assertEquals(21, calculator.calculate(7, 3, '*'));
        assertEquals(-48, calculator.calculate(-4, 12, '*'));
        assertEquals(-256, calculator.calculate(32, -8, '*'));
        assertEquals(4.6116860141324206E18, calculator.calculate(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '*'));
        assertEquals(0, calculator.calculate(Integer.MAX_VALUE, 0, '*'));
    }

    @Test
    void division_ok() {
        assertEquals(0.2, calculator.calculate(1, 5, '/'));
        assertEquals(-3, calculator.calculate(-93, 31, '/'));
        assertEquals(50, calculator.calculate(-4000, -80, '/'));
        assertEquals(0, calculator.calculate(0, Integer.MAX_VALUE, '/'));
        assertEquals(1, calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '/'));
    }

    @Test
    void division_by_zero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(10000, 0, '/'));
    }

    @Test
    void pow_ok() {
        assertEquals(81, calculator.calculate(3, 4, '^'));
        assertEquals(0.0625, calculator.calculate(2, -4, '^'));
        assertEquals(-0.00411522633744856, calculator.calculate(-3, -5, '^'));
        assertEquals(64, calculator.calculate(-8, 2, '^'));
        assertEquals(-343, calculator.calculate(-7, 3, '^'));
        assertEquals(1, calculator.calculate(Integer.MAX_VALUE, 0, '^'));
    }

    @Test
    void unsupported_operation() {
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, '1'));
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, '.'));
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, 'a'));
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, ']'));
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, '('));
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, '>'));
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, ' '));
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(1, 1, '\n'));
    }
}
