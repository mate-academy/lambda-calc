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
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void commonAddition() {
        assertEquals(22, calculator.calculator(20, 2, '+'));
        assertEquals(-31, calculator.calculator(-30, -1, '+'));
        assertEquals(19, calculator.calculator(20, -1, '+'));
        assertEquals(-5, calculator.calculator(-10, 5, '+'));
        assertEquals(Integer.MAX_VALUE,calculator.calculator(MAX_ELEMENT, ZERO_ELEMENT, '+'));
        assertEquals(Integer.MIN_VALUE,calculator.calculator(MIN_ELEMENT, ZERO_ELEMENT, '+'));
    }

    @Test
    void commonSubtraction() {
        assertEquals(18, calculator.calculator(20, 2, '-'));
        assertEquals(-29, calculator.calculator(-30, -1, '-'));
        assertEquals(21, calculator.calculator(20, -1, '-'));
        assertEquals(-15, calculator.calculator(-10, 5, '-'));
        assertEquals(-10, calculator.calculator(-10, ZERO_ELEMENT, '-'));
        assertEquals(0, calculator.calculator(MIN_ELEMENT, MIN_ELEMENT, '-'));
    }

    @Test
    void commonMultiplication() {
        assertEquals(40, calculator.calculator(20, 2, '*'));
        assertEquals(50, calculator.calculator(-10, -5, '*'));
        assertEquals(-100, calculator.calculator(20, -5, '*'));
        assertEquals(-50, calculator.calculator(-10, 5, '*'));
        assertEquals(0, calculator.calculator(-10, ZERO_ELEMENT, '*'));
        assertEquals(0, calculator.calculator(ZERO_ELEMENT, 5, '*'));
    }

    @Test
    void commonDivision() {
        assertEquals(10, calculator.calculator(20, 2, '/'));
        assertEquals(2, calculator.calculator(-10, -5, '/'));
        assertEquals(-4, calculator.calculator(20, -5, '/'));
        assertEquals(-2, calculator.calculator(-10, 5, '/'));
        assertEquals(0, calculator.calculator(ZERO_ELEMENT, 5, '/'));
        assertEquals(-1, calculator.calculator(MIN_ELEMENT + 1, MAX_ELEMENT, '/'));
    }

    @Test
    void commonRaising() {
        assertEquals(400, calculator.calculator(20, 2, '^'));
        double expected = 1 / Math.pow(-10, Math.abs(-5));
        assertEquals(expected, calculator.calculator(-10, -5, '^'));
        expected = 1 / Math.pow(20, Math.abs(-5));
        assertEquals(expected, calculator.calculator(20, -5, '^'));
        assertEquals(0,calculator.calculator(ZERO_ELEMENT, 5, '^'));
        assertEquals(1,calculator.calculator(50, ZERO_ELEMENT, '^'));
    }

    @Test
    void divisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(20, ZERO_ELEMENT, '/'));
    }

    @Test
    void checkingOperator() {
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
    void checkingOutOfBoundResult() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(MAX_ELEMENT, 2, '+'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(MIN_ELEMENT, 1, '-'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(MAX_ELEMENT, 4, '*'));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(2, MAX_ELEMENT, '^'));
    }
}
