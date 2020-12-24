package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculator();
    }

    @Test
    public void addition_both_positive_ok() {
        assertEquals(0, calculator.calculate(0, 0, '+'));
        assertEquals(4, calculator.calculate(2, 2, '+'));
        assertEquals(143234, calculator.calculate(72143, 71091, '+'));
        assertEquals(4.294967294E9,
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '+'));
    }

    @Test
    public void addition_both_negative_ok() {
        assertEquals(-17, calculator.calculate(-9, -8, '+'));
        assertEquals(-143234, calculator.calculate(-72143, -71091, '+'));
    }

    @Test
    public void addition_positive_negative_ok() {
        assertEquals(-10, calculator.calculate(10, -20, '+'));
        assertEquals(43, calculator.calculate(-21, 64, '+'));
        assertEquals(0, calculator.calculate(Integer.MAX_VALUE, -Integer.MAX_VALUE, '+'));
    }

    @Test
    public void subtraction_positive_ok() {
        assertEquals(0, calculator.calculate(0, 0, '-'));
        assertEquals(1, calculator.calculate(3, 2, '-'));
        assertEquals(72143, calculator.calculate(143234, 71091, '-'));
        assertEquals(0, calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '-'));
    }

    @Test
    public void subtraction_negative_result_ok() {
        assertEquals(-134, calculator.calculate(-80, 54, '-'));
        assertEquals(-17, calculator.calculate(-67, -50, '-'));
        assertEquals(-1052, calculator.calculate(-72143, -71091, '-'));
    }

    @Test
    public void subtraction_positive_result_ok() {
        assertEquals(24, calculator.calculate(10, -14, '-'));
        assertEquals(10, calculator.calculate(-20, -30, '-'));
        assertEquals(43, calculator.calculate(-21, -64, '-'));
        assertEquals(4.294967294E9,
                calculator.calculate(Integer.MAX_VALUE, -Integer.MAX_VALUE, '-'));
    }

    @Test
    public void multiplication_ok() {
        assertEquals(21, calculator.calculate(7, 3, '*'));
        assertEquals(-48, calculator.calculate(-4, 12, '*'));
        assertEquals(-256, calculator.calculate(32, -8, '*'));
        assertEquals(492, calculator.calculate(-123, -4, '*'));
        assertEquals(0, calculator.calculate(0, 0, '*'));
        assertEquals(4.6116860141324206E18, calculator.calculate(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '*'));
        assertEquals(0, calculator.calculate(Integer.MAX_VALUE, 0, '*'));
    }

    @Test
    public void division_ok() {
        assertEquals(0.2, calculator.calculate(1, 5, '/'));
        assertEquals(-3, calculator.calculate(-93, 31, '/'));
        assertEquals(50, calculator.calculate(-4000, -80, '/'));
        assertEquals(0, calculator.calculate(0, Integer.MAX_VALUE, '/'));
        assertEquals(1, calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '/'));
    }

    @Test
    public void division_by_zero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(10000, 0, '/'));
    }

    @Test
    public void pow_ok() {
        assertEquals(81, calculator.calculate(3, 4, '^'));
        assertEquals(0.0625, calculator.calculate(2, -4, '^'));
        assertEquals(-0.00411522633744856, calculator.calculate(-3, -5, '^'));
        assertEquals(64, calculator.calculate(-8, 2, '^'));
        assertEquals(-343, calculator.calculate(-7, 3, '^'));
        assertEquals(1, calculator.calculate(Integer.MAX_VALUE, 0, '^'));
        assertEquals(0, calculator.calculate(0, 2342324, '^'));
        assertEquals(1, calculator.calculate(0, 0, '^'));

        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(98432823, 234892349, '^'));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(-10302103, 12301020, '^'));
        assertEquals(Double.NEGATIVE_INFINITY, calculator.calculate(-10302103, 12301021, '^'));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(-0, -92454395, '^'));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(0, -3948598, '^'));
    }

    @Test
    public void unsupported_operation() {
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
