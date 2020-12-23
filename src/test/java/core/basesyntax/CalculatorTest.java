package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Double MAX = Double.MAX_VALUE;
    private static final Double MIN = Double.MIN_VALUE;
    private static Calculable calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void check_for_addition_OK() {
        assertEquals(4, calculator.calculate(2, 2, '+'));
        assertEquals(3, calculator.calculate(3, 0, '+'));
        assertEquals(3, calculator.calculate(0, 3, '+'));
        assertEquals(3, calculator.calculate(-3, 6, '+'));
        assertEquals(3, calculator.calculate(6, -3, '+'));
        assertEquals(-6, calculator.calculate(-3, -3, '+'));
        assertEquals(1.7976931348623157E308, calculator.calculate(MAX, 100, '+'));
        assertEquals(MIN + 100, calculator.calculate(MIN, 100, '+'));
    }

    @Test
    void check_for_addition_not_OK() {
        assertNotEquals(1, calculator.calculate(2, 2, '+'));
        assertNotEquals(100, calculator.calculate(3, 0, '+'));
        assertNotEquals(200, calculator.calculate(0, 3, '+'));
        assertNotEquals(-12, calculator.calculate(-3, 6, '+'));
        assertNotEquals(0, calculator.calculate(6, -3, '+'));
        assertNotEquals(1, calculator.calculate(-3, -3, '+'));
        assertNotEquals(2, calculator.calculate(MAX, 100, '+'));
        assertNotEquals(0.666, calculator.calculate(MIN, 100, '+'));
    }

    @Test
    void check_for_subtraction_OK() {
        assertEquals(0, calculator.calculate(2, 2, '-'));
        assertEquals(3, calculator.calculate(3, 0, '-'));
        assertEquals(-3, calculator.calculate(0, 3, '-'));
        assertEquals(-9, calculator.calculate(-3, 6, '-'));
        assertEquals(9, calculator.calculate(6, -3, '-'));
        assertEquals(0, calculator.calculate(-3, -3, '-'));
        assertEquals(MAX - 100, calculator.calculate(MAX, 100, '-'));
        assertEquals(MIN - 100, calculator.calculate(MIN, 100, '-'));
    }

    @Test
    void check_for_subtraction_not_OK() {
        assertNotEquals(555, calculator.calculate(2, 2, '-'));
        assertNotEquals(-120, calculator.calculate(3, 0, '-'));
        assertNotEquals(3, calculator.calculate(0, 3, '-'));
        assertNotEquals(2, calculator.calculate(-3, 6, '-'));
        assertNotEquals(1, calculator.calculate(6, -3, '-'));
        assertNotEquals(1111, calculator.calculate(-3, -3, '-'));
        assertNotEquals(1000, calculator.calculate(MAX, 100, '-'));
        assertNotEquals(-123, calculator.calculate(MIN, 100, '-'));
    }

    @Test
    void check_for_division_OK() {
        assertEquals(1, calculator.calculate(2, 2, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(3, 0, '/'));
        assertEquals(0, calculator.calculate(0, 3, '/'));
        assertEquals(-0.5, calculator.calculate(-3, 6, '/'));
        assertEquals(-2, calculator.calculate(6, -3, '/'));
        assertEquals(1, calculator.calculate(-3, -3, '/'));
        assertEquals(MAX / MIN, calculator.calculate(MAX, MIN, '/'));
    }

    @Test
    void check_for_division_not_OK() {
        assertNotEquals(14, calculator.calculate(2, 2, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(3, 0, '/'));
        assertNotEquals(888, calculator.calculate(0, 3, '/'));
        assertNotEquals(-333, calculator.calculate(-3, 6, '/'));
        assertNotEquals(1000, calculator.calculate(6, -3, '/'));
        assertNotEquals(1.333, calculator.calculate(-3, -3, '/'));
        assertNotEquals(22, calculator.calculate(MAX, MIN, '/'));
    }

    @Test
    void check_for_multiplication_OK() {
        assertEquals(4, calculator.calculate(2, 2, '*'));
        assertEquals(0, calculator.calculate(3, 0, '*'));
        assertEquals(0, calculator.calculate(0, 3, '*'));
        assertEquals(-18, calculator.calculate(-3, 6, '*'));
        assertEquals(-18, calculator.calculate(6, -3, '*'));
        assertEquals(9, calculator.calculate(-3, -3, '*'));
        assertEquals(MAX * MIN, calculator.calculate(MAX, MIN, '*'));
    }

    @Test
    void check_for_multiplication_not_OK() {
        assertNotEquals(123, calculator.calculate(2, 2, '*'));
        assertNotEquals(0.213, calculator.calculate(3, 0, '*'));
        assertNotEquals(100, calculator.calculate(0, 3, '*'));
        assertNotEquals(-183, calculator.calculate(-3, 6, '*'));
        assertNotEquals(2222, calculator.calculate(6, -3, '*'));
        assertNotEquals(111, calculator.calculate(-3, -3, '*'));
        assertNotEquals(0 * MIN, calculator.calculate(MAX, MIN, '*'));
    }

    @Test
    void check_for_raising_to_power_OK() {
        assertEquals(4, calculator.calculate(2, 2, '^'));
        assertEquals(1, calculator.calculate(3, 0, '^'));
        assertEquals(0, calculator.calculate(0, 3, '^'));
        assertEquals(729, calculator.calculate(-3, 6, '^'));
        assertEquals(0.16666666666666666, calculator.calculate(6, -1, '^'));
        assertEquals(-0.037037037037037035, calculator.calculate(-3, -3, '^'));
        assertEquals(1.7976931348623157E308, calculator.calculate(MAX, MIN, '^'));
    }

    @Test
    void check_for_raising_to_power_not_OK() {
        assertNotEquals(122, calculator.calculate(2, 2, '^'));
        assertNotEquals(10000, calculator.calculate(3, 0, '^'));
        assertNotEquals(-112, calculator.calculate(0, 3, '^'));
        assertNotEquals(1, calculator.calculate(-3, 6, '^'));
        assertNotEquals(-123123, calculator.calculate(6, -1, '^'));
        assertNotEquals(1, calculator.calculate(-3, -3, '^'));
        assertNotEquals(2233, calculator.calculate(MAX, MIN, '^'));
    }

    @Test
    void check_for_operator_not_OK() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, '2'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, '.'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, ';'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, '!'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, '$'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, '%'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, '&'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, ' '));
    }
}
