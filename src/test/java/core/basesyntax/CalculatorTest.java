package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double POSITIVE_VALUE = 21;
    private static final double NEGATIVE_VALUE = -21;
    private static final double ZERO_VALUE = 0;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void addition_Ok() {
        double actualFirst = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, '+');
        assertEquals(42, actualFirst);
        double actualSecond = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, '+');
        assertEquals(-42, actualSecond);
        double actualThird = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, '+');
        assertEquals(0, actualThird);
        double actualForth = calculator.calculate(MAX_VALUE, MAX_VALUE, '+');
        assertEquals(Double.POSITIVE_INFINITY, actualForth);
        double actualFifth = calculator.calculate(POSITIVE_VALUE, ZERO_VALUE, '+');
        assertEquals(21, actualFifth);
        double actualSixth = calculator.calculate(MAX_VALUE, MIN_VALUE, '+');
        assertEquals(1.7976931348623157E308, actualSixth);
    }

    @Test
    public void subtraction_Ok() {
        double actualFirst = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, '-');
        assertEquals(0, actualFirst);
        double actualSecond = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, '-');
        assertEquals(0, actualSecond);
        double actualThird = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, '-');
        assertEquals(42, actualThird);
        double actualForth = calculator.calculate(MAX_VALUE, MAX_VALUE, '-');
        assertEquals(0, actualForth);
        double actualFifth = calculator.calculate(POSITIVE_VALUE, ZERO_VALUE, '-');
        assertEquals(21, actualFifth);
        double actualSixth = calculator.calculate(MAX_VALUE, MIN_VALUE, '-');
        assertEquals(1.7976931348623157E308, actualSixth);
    }

    @Test
    public void division_Ok() {
        double actualFirst = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, '/');
        assertEquals(1, actualFirst);
        double actualSecond = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, '/');
        assertEquals(1, actualSecond);
        double actualThird = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, '/');
        assertEquals(-1, actualThird);
        double actualForth = calculator.calculate(MAX_VALUE, MAX_VALUE, '/');
        assertEquals(1, actualForth);
        double actualFifth = calculator.calculate(MAX_VALUE, MIN_VALUE, '/');
        assertEquals(Double.POSITIVE_INFINITY, actualFifth);
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(POSITIVE_VALUE, ZERO_VALUE, '/'), "Can't division on zero!");
    }

    @Test
    public void multiplication_Ok() {
        double actualFirst = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, '*');
        assertEquals(441, actualFirst);
        double actualSecond = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, '*');
        assertEquals(441, actualSecond);
        double actualThird = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, '*');
        assertEquals(-441, actualThird);
        double actualForth = calculator.calculate(MAX_VALUE, MAX_VALUE, '*');
        assertEquals(Double.POSITIVE_INFINITY, actualForth);
        double actualFifth = calculator.calculate(POSITIVE_VALUE, ZERO_VALUE, '*');
        assertEquals(0, actualFifth);
        double actualSixth = calculator.calculate(MAX_VALUE, MIN_VALUE, '*');
        assertEquals(8.881784197001251E-16, actualSixth);
    }

    @Test
    public void raisingToAPower_Ok() {
        double actualFirst = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, '^');
        assertEquals(5.842587018385982E27, actualFirst);
        double actualSecond = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, '^');
        assertEquals(-1.7115705711410192E-28, actualSecond);
        double actualThird = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, '^');
        assertEquals(1.7115705711410192E-28, actualThird);
        double actualForth = calculator.calculate(MAX_VALUE, MAX_VALUE, '^');
        assertEquals(Double.POSITIVE_INFINITY, actualForth);
        double actualFifth = calculator.calculate(POSITIVE_VALUE, ZERO_VALUE, '^');
        assertEquals(1, actualFifth);
        double actualSixth = calculator.calculate(MAX_VALUE, MIN_VALUE, '^');
        assertEquals(1, actualSixth);
        double actualSeventh = calculator.calculate(ZERO_VALUE, POSITIVE_VALUE, '^');
        assertEquals(0, actualSeventh);

    }

    @Test
    public void illegalArgument() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 2, 'd'));
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 2, '%'));
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 2, '9'));
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 2, '('));
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 2, '&'));
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 2, '#'));
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(1, 2, '>'));
    }
}
