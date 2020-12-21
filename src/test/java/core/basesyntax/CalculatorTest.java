package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final int FIRST_ELEMENT = 20;
    private static final int SECOND_ELEMENT = 2;
    private static final int THIRD_ELEMENT = -30;
    private static final int FOURTH_ELEMENT = -1;
    private static final int FIFTH_ELEMENT = 0;
    private static final int MAX_ELEMENT = Integer.MAX_VALUE;
    private static final int MIN_ELEMENT = Integer.MIN_VALUE;

    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void commonAddition() {
        double actual = calculator.calculator(FIRST_ELEMENT, SECOND_ELEMENT, '+');
        double expected = 22;
        assertEquals(expected, actual);
        actual = calculator.calculator(THIRD_ELEMENT, FOURTH_ELEMENT, '+');
        expected = -31;
        assertEquals(expected, actual);
        actual = calculator.calculator(FIRST_ELEMENT, FOURTH_ELEMENT, '+');
        expected = 19;
        assertEquals(expected, actual);
        actual = calculator.calculator(MAX_ELEMENT, FIFTH_ELEMENT, '+');
        expected = Integer.MAX_VALUE;
        assertEquals(expected,actual);
    }

    @Test
    void commonSubtraction() {
        double actual = calculator.calculator(FIRST_ELEMENT, SECOND_ELEMENT, '-');
        double expected = 18;
        assertEquals(expected, actual);
        actual = calculator.calculator(THIRD_ELEMENT, FOURTH_ELEMENT, '-');
        expected = -29;
        assertEquals(expected, actual);
        actual = calculator.calculator(FIRST_ELEMENT, FOURTH_ELEMENT, '-');
        expected = 21;
        assertEquals(expected, actual);
        actual = calculator.calculator(MIN_ELEMENT, MIN_ELEMENT, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void commonMultiplication() {
        double actual = calculator.calculator(FIRST_ELEMENT, SECOND_ELEMENT, '*');
        double expected = 40;
        assertEquals(expected, actual);
        actual = calculator.calculator(THIRD_ELEMENT, FOURTH_ELEMENT, '*');
        expected = 30;
        assertEquals(expected, actual);
        actual = calculator.calculator(FIRST_ELEMENT, FOURTH_ELEMENT, '*');
        expected = -20;
        assertEquals(expected, actual);
        actual = calculator.calculator(SECOND_ELEMENT, FIFTH_ELEMENT, '*');
        expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void commonDivision() {
        double actual = calculator.calculator(FIRST_ELEMENT, SECOND_ELEMENT, '/');
        double expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculator(THIRD_ELEMENT, FOURTH_ELEMENT, '/');
        expected = 30;
        assertEquals(expected, actual);
        actual = calculator.calculator(FIRST_ELEMENT, FOURTH_ELEMENT, '/');
        expected = -20;
        assertEquals(expected, actual);
        actual = calculator.calculator(FIFTH_ELEMENT, SECOND_ELEMENT, '/');
        expected = 0;
        assertEquals(expected,actual);
        actual = calculator.calculator(MIN_ELEMENT + 1, MAX_ELEMENT, '/');
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void commonRaising() {
        double actual = calculator.calculator(FIRST_ELEMENT, SECOND_ELEMENT, '^');
        double expected = 400;
        assertEquals(expected, actual);
        actual = calculator.calculator(THIRD_ELEMENT, FOURTH_ELEMENT, '^');
        expected = 1 / Math.pow(THIRD_ELEMENT, Math.abs(FOURTH_ELEMENT));
        assertEquals(expected, actual);
        actual = calculator.calculator(FIRST_ELEMENT, FOURTH_ELEMENT, '^');
        expected = 1 / Math.pow(FIRST_ELEMENT, Math.abs(FOURTH_ELEMENT));
        assertEquals(expected, actual);
        actual = calculator.calculator(FIFTH_ELEMENT, SECOND_ELEMENT, '^');
        expected = 0;
        assertEquals(expected,actual);
        actual = calculator.calculator(SECOND_ELEMENT, FIFTH_ELEMENT, '^');
        expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    void divisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculator(SECOND_ELEMENT, FIFTH_ELEMENT, '/'));
    }

    @Test
    void checkingOperator() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(FIRST_ELEMENT, SECOND_ELEMENT, '%'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(SECOND_ELEMENT, FOURTH_ELEMENT, 'a'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(THIRD_ELEMENT, FIFTH_ELEMENT, '5'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(FIRST_ELEMENT, SECOND_ELEMENT, '\u0000'));
    }

    @Test
    void checkingOutOfBoundResult() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(MAX_ELEMENT, SECOND_ELEMENT, '+'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(MIN_ELEMENT, FIRST_ELEMENT, '-'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(MAX_ELEMENT, SECOND_ELEMENT, '*'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculator(SECOND_ELEMENT, MAX_ELEMENT, '^'));
    }
}
