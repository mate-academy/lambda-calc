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
    void calculate_operator_NotOk() {
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(10,5, ' '));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(12,10, '%'));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(120,500, '5'));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(76,-87, '?'));
    }

    @Test
    void calculate_addition_Ok() {
        assertEquals(6, lambdaCalculator.calculate(3, 3, '+'));
        assertEquals(100, lambdaCalculator.calculate(98, 2, '+'));
        assertEquals(-13, lambdaCalculator.calculate(-20, 7, '+'));
        assertEquals(0, lambdaCalculator.calculate(-100, 100, '+'));
        assertEquals(2.147484097E9,
                lambdaCalculator.calculate(Integer.MAX_VALUE, 450, '+'));
        assertEquals(-2.147483198E9,
                lambdaCalculator.calculate(Integer.MIN_VALUE, 450, '+'));
    }

    @Test
    void calculate_addition_NotOk() {
        assertNotEquals(7, lambdaCalculator.calculate(3, 3, '+'));
        assertNotEquals(23, lambdaCalculator.calculate(98, 2, '+'));
        assertNotEquals(-19, lambdaCalculator.calculate(-20, 7, '+'));
        assertNotEquals(7, lambdaCalculator.calculate(-100, 100, '+'));
        assertNotEquals(2.147484097,
                lambdaCalculator.calculate(Integer.MAX_VALUE, 450, '+'));
        assertNotEquals(-2.147483198,
                lambdaCalculator.calculate(Integer.MIN_VALUE, 450, '+'));
    }

    @Test
    void calculate_subtraction_Ok() {
        assertEquals(2, lambdaCalculator.calculate(5, 3, '-'));
        assertEquals(-56, lambdaCalculator.calculate(-40, 16, '-'));
        assertEquals(0, lambdaCalculator.calculate(-20, -20, '-'));
        assertEquals(1, lambdaCalculator.calculate(10000, 9999, '-'));
        assertEquals(2.147482994E9,
                lambdaCalculator.calculate(Integer.MAX_VALUE, 653, '-'));
        assertEquals(4.294967295E9,
                lambdaCalculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '-'));
    }

    @Test
    void calculate_subtraction_NotOk() {
        assertNotEquals(0, lambdaCalculator.calculate(5, 3, '-'));
        assertNotEquals(-90, lambdaCalculator.calculate(-40, 16, '-'));
        assertNotEquals(89, lambdaCalculator.calculate(-20, -20, '-'));
        assertNotEquals(9, lambdaCalculator.calculate(10000, 9999, '-'));
        assertNotEquals(2.147482, lambdaCalculator.calculate(Integer.MAX_VALUE, 231, '-'));
        assertNotEquals(4.29496729539,
                lambdaCalculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '-'));
    }

    @Test
    void calculate_multiplication_Ok() {
        assertEquals(4, lambdaCalculator.calculate(2, 2, '*'));
        assertEquals(81, lambdaCalculator.calculate(9, 9, '*'));
        assertEquals(-135, lambdaCalculator.calculate(-15, 9, '*'));
        assertEquals(75924, lambdaCalculator.calculate(999, 76, '*'));
        assertEquals(-4.6116860162799043E18,
                lambdaCalculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '*'));
    }

    @Test
    void calculate_multiplication_NotOk() {
        assertNotEquals(45, lambdaCalculator.calculate(2, 2, '*'));
        assertNotEquals(8, lambdaCalculator.calculate(9, 9, '*'));
        assertNotEquals(-5, lambdaCalculator.calculate(-15, 9, '*'));
        assertNotEquals(724, lambdaCalculator.calculate(999, 76, '*'));
        assertNotEquals(4.6116860162799043E18,
                lambdaCalculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '*'));
    }

    @Test
    void calculate_division_Ok() {
        assertEquals(2, lambdaCalculator.calculate(10, 5, '/'));
        assertEquals(46.333333333333336, lambdaCalculator.calculate(973, 21, '/'));
        assertEquals(-3, lambdaCalculator.calculate(-21, 7, '/'));
        assertEquals(1, lambdaCalculator.calculate(899, 899, '/'));
        assertEquals(-0.9999999995343387,
                lambdaCalculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '/'));
    }

    @Test
    void calculate_division_NotOk() {
        assertNotEquals(17, lambdaCalculator.calculate(10, 5, '/'));
        assertNotEquals(46.33333333336, lambdaCalculator.calculate(973, 21, '/'));
        assertNotEquals(90, lambdaCalculator.calculate(-21, 7, '/'));
        assertNotEquals(0, lambdaCalculator.calculate(899, 899, '/'));
        assertThrows(ArithmeticException.class, () -> lambdaCalculator.calculate(76,0, '/'));
        assertNotEquals(-0.999999999534,
                lambdaCalculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '/'));
    }

    @Test
    void calculate_raising_to_a_power_Ok() {
        assertEquals(4, lambdaCalculator.calculate(2, 2, '^'));
        assertEquals(15625, lambdaCalculator.calculate(-5, 6, '^'));
        assertEquals(0.000064, lambdaCalculator.calculate(5, -6, '^'));
        assertEquals(-0.125, lambdaCalculator.calculate(-2, -3, '^'));
        assertEquals(1, lambdaCalculator.calculate(2, 0, '^'));
        assertEquals(1, lambdaCalculator.calculate(-2, 0, '^'));
        assertEquals(0, lambdaCalculator.calculate(0, 5, '^'));
        assertEquals(1, lambdaCalculator.calculate(Integer.MAX_VALUE, 0, '^'));
        assertEquals(4.6116860184273879E18, lambdaCalculator.calculate(Integer.MIN_VALUE, 2, '^'));
    }

    @Test
    void calculate_raising_to_a_power_NotOk() {
        assertNotEquals(8, lambdaCalculator.calculate(2, 2, '^'));
        assertNotEquals(-15625, lambdaCalculator.calculate(-5, 6, '^'));
        assertNotEquals(0.0064, lambdaCalculator.calculate(9, -8, '^'));
        assertNotEquals(-0.134, lambdaCalculator.calculate(-3, -7, '^'));
        assertNotEquals(0, lambdaCalculator.calculate(5, 0, '^'));
        assertNotEquals(-1, lambdaCalculator.calculate(-2, 0, '^'));
        assertNotEquals(1, lambdaCalculator.calculate(0, 7, '^'));
        assertNotEquals(0, lambdaCalculator.calculate(Integer.MAX_VALUE, 0, '^'));
        assertNotEquals(4.6116860184273, lambdaCalculator.calculate(Integer.MIN_VALUE, 2, '^'));
    }
}
