package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final int POSITIVE_FIRST = 123;
    private static final int POSITIVE_SECOND = 7;
    private static final int NEGATIVE_FIRST = -1234;
    private static final int NEGATIVE_SECOND = -34;
    private static final String ADD = "+";
    private static final String SUBTR = "-";
    private static final String MULTI = "*";
    private static final String DIV = "/";
    private static final String POW = "^";
    private static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void null_operation_NotOk() {
        assertThrows(NullPointerException.class, () -> {
            calculator.calculate(2, 2, null);
        });
    }

    @Test
    void division_by_zero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(24, 0, DIV);
        });
    }

    @Test
    void incorrect_math_operation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(2, 5, "square");
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(2, 5, "|");
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(2, 5, "%");
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(2, 5, "");
        });
    }

    @Test
    void division_Ok() {
        double actual = calculator.calculate(10, 3, DIV);
        double expected = 3.3333333333333335;
        assertEquals(expected, actual);
        assertEquals((double) NEGATIVE_FIRST / NEGATIVE_SECOND,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, DIV));
        assertEquals((double) POSITIVE_FIRST / POSITIVE_SECOND,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, DIV));
        assertEquals((double) POSITIVE_FIRST / NEGATIVE_FIRST,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, DIV));
        assertEquals((double) NEGATIVE_SECOND / POSITIVE_SECOND,
                calculator.calculate(NEGATIVE_SECOND, POSITIVE_SECOND, DIV));
        assertEquals((double) 0 / POSITIVE_SECOND,
                calculator.calculate(0, POSITIVE_SECOND, DIV));
    }

    @Test
    void addition_Ok() {
        double actual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, ADD);
        double expected = 4.294967294E9;
        assertEquals(expected, actual);
        assertEquals((double) NEGATIVE_FIRST + NEGATIVE_SECOND,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, ADD));
        assertEquals((double) POSITIVE_FIRST + POSITIVE_SECOND,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, ADD));
        assertEquals((double) POSITIVE_FIRST + NEGATIVE_FIRST,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, ADD));
        assertEquals((double) NEGATIVE_SECOND + POSITIVE_SECOND,
                calculator.calculate(NEGATIVE_SECOND, POSITIVE_SECOND, ADD));
        assertEquals((double) 0 + POSITIVE_SECOND,
                calculator.calculate(0, POSITIVE_SECOND, ADD));
        assertEquals((double) NEGATIVE_SECOND + 0,
                calculator.calculate(NEGATIVE_SECOND, 0, ADD));
    }

    @Test
    void subtraction_Ok() {
        double actual = calculator.calculate(0, Integer.MIN_VALUE, SUBTR);
        double expected = 2.147483648E9;
        assertEquals(expected, actual);
        assertEquals((double) NEGATIVE_FIRST - NEGATIVE_SECOND,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, SUBTR));
        assertEquals((double) POSITIVE_FIRST - POSITIVE_SECOND,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, SUBTR));
        assertEquals((double) POSITIVE_FIRST - NEGATIVE_FIRST,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, SUBTR));
        assertEquals((double) NEGATIVE_SECOND - POSITIVE_SECOND,
                calculator.calculate(NEGATIVE_SECOND, POSITIVE_SECOND, SUBTR));
        assertEquals((double) 0 - POSITIVE_SECOND,
                calculator.calculate(0, POSITIVE_SECOND, SUBTR));
        assertEquals((double) NEGATIVE_SECOND - 0,
                calculator.calculate(NEGATIVE_SECOND, 0, SUBTR));
    }

    @Test
    void multiplication_Ok() {
        double actual = calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, MULTI);
        double expected = -4.6116860162799043E18;
        assertEquals(expected, actual);
        assertEquals((double) NEGATIVE_FIRST * NEGATIVE_SECOND,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, MULTI));
        assertEquals((double) POSITIVE_FIRST * POSITIVE_SECOND,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, MULTI));
        assertEquals((double) POSITIVE_FIRST * NEGATIVE_FIRST,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, MULTI));
        assertEquals((double) NEGATIVE_SECOND * POSITIVE_SECOND,
                calculator.calculate(NEGATIVE_SECOND, POSITIVE_SECOND, MULTI));
        assertEquals((double) 0 * POSITIVE_SECOND,
                calculator.calculate(0, POSITIVE_SECOND, MULTI));
        assertEquals((double) NEGATIVE_SECOND * 0,
                calculator.calculate(NEGATIVE_SECOND, 0, MULTI));
        assertEquals((double) 0 * 0, calculator.calculate(0, 0, MULTI));
    }

    @Test
    void pow_Ok() {
        double actual = calculator.calculate(2, -1, POW);
        double expected = 0.5;
        assertEquals(expected, actual);
        assertEquals(Math.pow(NEGATIVE_FIRST, NEGATIVE_SECOND),
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, POW));
        assertEquals(Math.pow(POSITIVE_FIRST, POSITIVE_SECOND),
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, POW));
        assertEquals(Math.pow(POSITIVE_FIRST, NEGATIVE_FIRST),
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, POW));
        assertEquals(Math.pow(NEGATIVE_SECOND, POSITIVE_SECOND),
                calculator.calculate(NEGATIVE_SECOND, POSITIVE_SECOND, POW));
        assertEquals(Math.pow(0, POSITIVE_SECOND), calculator.calculate(0, POSITIVE_SECOND, POW));
        assertEquals(Math.pow(NEGATIVE_SECOND, 0), calculator.calculate(NEGATIVE_SECOND, 0, POW));
        assertEquals(Math.pow(0, 0), calculator.calculate(0, 0, POW));
    }
}
