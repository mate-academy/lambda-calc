package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LambdaCalculatorTest {
    private static LambdaCalculator lambdaCalculator;

    @BeforeAll
    static void beforeAll() {
        lambdaCalculator = new LambdaCalculator();
    }

    @Test
    void check_operator_NotOk() {
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(10,5, ' '));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(12,10, '%'));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(120,500, '5'));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(76,-87, '?'));
    }

    @Test
    void check_for_plus_Ok() {
        assertEquals(6, lambdaCalculator.calculate(3, 3, '+'));
        assertEquals(100, lambdaCalculator.calculate(98, 2, '+'));
        assertEquals(-13, lambdaCalculator.calculate(-20, 7, '+'));
        assertEquals(0, lambdaCalculator.calculate(-100, 100, '+'));
    }

    @Test
    void check_for_plus_NotOk() {
        assertNotEquals(7, lambdaCalculator.calculate(3, 3, '+'));
        assertNotEquals(23, lambdaCalculator.calculate(98, 2, '+'));
        assertNotEquals(-19, lambdaCalculator.calculate(-20, 7, '+'));
        assertNotEquals(7, lambdaCalculator.calculate(-100, 100, '+'));
    }

    @Test
    void check_for_minus_Ok() {
        assertEquals(2, lambdaCalculator.calculate(5, 3, '-'));
        assertEquals(-56, lambdaCalculator.calculate(-40, 16, '-'));
        assertEquals(0, lambdaCalculator.calculate(-20, -20, '-'));
        assertEquals(1, lambdaCalculator.calculate(10000, 9999, '-'));
    }

    @Test
    void check_for_minus_NotOk() {
        assertNotEquals(0, lambdaCalculator.calculate(5, 3, '-'));
        assertNotEquals(-90, lambdaCalculator.calculate(-40, 16, '-'));
        assertNotEquals(89, lambdaCalculator.calculate(-20, -20, '-'));
        assertNotEquals(9, lambdaCalculator.calculate(10000, 9999, '-'));
    }

    @Test
    void check_for_multiply_Ok() {
        assertEquals(4, lambdaCalculator.calculate(2, 2, '*'));
        assertEquals(81, lambdaCalculator.calculate(9, 9, '*'));
        assertEquals(-135, lambdaCalculator.calculate(-15, 9, '*'));
        assertEquals(75924, lambdaCalculator.calculate(999, 76, '*'));
    }

    @Test
    void check_for_multiply_NotOk() {
        assertNotEquals(45, lambdaCalculator.calculate(2, 2, '*'));
        assertNotEquals(8, lambdaCalculator.calculate(9, 9, '*'));
        assertNotEquals(-5, lambdaCalculator.calculate(-15, 9, '*'));
        assertNotEquals(724, lambdaCalculator.calculate(999, 76, '*'));
    }

    @Test
    void check_for_divide_Ok() {
        assertEquals(2, lambdaCalculator.calculate(10, 5, '/'));
        assertEquals(46.333333333333336, lambdaCalculator.calculate(973, 21, '/'));
        assertEquals(-3, lambdaCalculator.calculate(-21, 7, '/'));
        assertEquals(1, lambdaCalculator.calculate(899, 899, '/'));
    }

    @Test
    void check_for_divide_NotOk() {
        assertNotEquals(17, lambdaCalculator.calculate(10, 5, '/'));
        assertNotEquals(46.33333333336, lambdaCalculator.calculate(973, 21, '/'));
        assertNotEquals(90, lambdaCalculator.calculate(-21, 7, '/'));
        assertNotEquals(0, lambdaCalculator.calculate(899, 899, '/'));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(76,0, '/'));
    }

    @Test
    void check_for_pow_Ok() {
        assertEquals(4, lambdaCalculator.calculate(2, 2, '^'));
        assertEquals(15625, lambdaCalculator.calculate(-5, 6, '^'));
    }

    @Test
    void check_for_pow_NotOk() {
        assertNotEquals(8, lambdaCalculator.calculate(2, 2, '^'));
        assertNotEquals(-15625, lambdaCalculator.calculate(-5, 6, '^'));
    }
}
