package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final int ZERO_ELEMENT = 0;
    private static final int MAX_ELEMENT = Integer.MAX_VALUE;
    private static final int MIN_ELEMENT = Integer.MIN_VALUE;

    private static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void addition_ok() {
        assertEquals(22, calculator.calculator(20, 2, '+'));
        assertEquals(-31, calculator.calculator(-30, -1, '+'));
        assertEquals(19, calculator.calculator(20, -1, '+'));
        assertEquals(-5, calculator.calculator(-10, 5, '+'));
        assertEquals(Integer.MAX_VALUE, calculator.calculator(MAX_ELEMENT, ZERO_ELEMENT, '+'));
        assertEquals(Integer.MIN_VALUE, calculator.calculator(ZERO_ELEMENT, MIN_ELEMENT, '+'));
        assertEquals(-2147483643, calculator.calculator(MIN_ELEMENT, 5, '+'));
        assertEquals(-2147483645, calculator.calculator(3, MIN_ELEMENT, '+'));
        assertEquals(2147483642, calculator.calculator(MAX_ELEMENT, -5, '+'));
        assertEquals(2147483644, calculator.calculator(-3, MAX_ELEMENT, '+'));
    }

    @Test
    public void subtraction_ok() {
        assertEquals(18, calculator.calculator(20, 2, '-'));
        assertEquals(-29, calculator.calculator(-30, -1, '-'));
        assertEquals(21, calculator.calculator(20, -1, '-'));
        assertEquals(-15, calculator.calculator(-10, 5, '-'));
        assertEquals(-10, calculator.calculator(-10, ZERO_ELEMENT, '-'));
        assertEquals(-10, calculator.calculator(ZERO_ELEMENT, 10, '-'));
        assertEquals(0, calculator.calculator(MIN_ELEMENT, MIN_ELEMENT, '-'));
        assertEquals(2147483642, calculator.calculator(MAX_ELEMENT, 5, '-'));
        assertEquals(-2147483644, calculator.calculator(3, MAX_ELEMENT, '-'));
        assertEquals(-2147483643, calculator.calculator(MIN_ELEMENT, -5, '-'));
        assertEquals(2147483645, calculator.calculator(-3, MIN_ELEMENT, '-'));
    }

    @Test
    public void multiplication_ok() {
        assertEquals(40, calculator.calculator(20, 2, '*'));
        assertEquals(50, calculator.calculator(-10, -5, '*'));
        assertEquals(-100, calculator.calculator(20, -5, '*'));
        assertEquals(-50, calculator.calculator(-10, 5, '*'));
        assertEquals(0, calculator.calculator(-10, ZERO_ELEMENT, '*'));
        assertEquals(0, calculator.calculator(ZERO_ELEMENT, 5, '*'));
        assertEquals(MAX_ELEMENT, calculator.calculator(MAX_ELEMENT, 1, '*'));
        assertEquals(MIN_ELEMENT, calculator.calculator(1, MIN_ELEMENT,'*'));
        assertEquals(MIN_ELEMENT + 1, calculator.calculator(MAX_ELEMENT, -1, '*'));
    }

    @Test
    public void division_ok() {
        assertEquals(10, calculator.calculator(20, 2, '/'));
        assertEquals(2, calculator.calculator(-10, -5, '/'));
        assertEquals(-4, calculator.calculator(20, -5, '/'));
        assertEquals(-2, calculator.calculator(-10, 5, '/'));
        assertEquals(0, calculator.calculator(ZERO_ELEMENT, 5, '/'));
        assertEquals(-0.0, calculator.calculator(ZERO_ELEMENT, -100, '/'));
        assertEquals(-1, calculator.calculator(MIN_ELEMENT + 1, MAX_ELEMENT, '/'));
        assertEquals(-1073741824, calculator.calculator(MIN_ELEMENT, 2, '/'));
        assertEquals(7.158278823333334E8, calculator.calculator(MAX_ELEMENT, 3, '/'));
        assertEquals(1073741824, calculator.calculator(MIN_ELEMENT, -2, '/'));
        assertEquals(-7.158278823333334E8, calculator.calculator(MAX_ELEMENT, -3, '/'));
    }

    @Test
    public void raising_ok() {
        assertEquals(400, calculator.calculator(20, 2, '^'));
        double expected = 1 / Math.pow(-10, Math.abs(-5));
        assertEquals(expected, calculator.calculator(-10, -5, '^'));
        expected = 1 / Math.pow(20, Math.abs(-5));
        assertEquals(expected, calculator.calculator(20, -5, '^'));
        assertEquals(400, calculator.calculator(-20, 2, '^'));
        assertEquals(0, calculator.calculator(ZERO_ELEMENT, 5, '^'));
        assertEquals(1, calculator.calculator(50, ZERO_ELEMENT, '^'));
        assertEquals(1, calculator.calculator(-50, ZERO_ELEMENT, '^'));
        assertEquals(MIN_ELEMENT, calculator.calculator(MIN_ELEMENT, 1, '^'));
        assertEquals(MAX_ELEMENT, calculator.calculator(MAX_ELEMENT, 1, '^'));
    }

    @Test
    public void divisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(20, ZERO_ELEMENT, '/'));
    }

    @Test
    public void checkingOperator() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(20, 4, '%'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(5, -10, 'a'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(30, ZERO_ELEMENT, '5'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(-5, -11, '\u0000'));
    }

    @Test
    public void checkingOutOfBoundResult() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(MAX_ELEMENT, 2, '+'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(-7, MIN_ELEMENT, '+'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(MIN_ELEMENT, 1, '-'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(-4, MAX_ELEMENT, '-'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(MAX_ELEMENT, 4, '*'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(8, MIN_ELEMENT, '*'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(-2, MAX_ELEMENT, '^'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(MIN_ELEMENT, 5, '^'));
    }
}
