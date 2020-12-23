package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    static final double FIRST_CASE_A = 21;
    static final double SECOND_CASE_A = -21;
    static final double THIRD_CASE_B = 0;
    static final double FORTH_CASE_A = Double.MAX_VALUE;
    static final double FIFTH_CASE_A = Double.MIN_VALUE;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void addition_Ok() {
        final double expectedFirst = 42;
        final double expectedSecond = -42;
        final double expectedThird = 0;
        final double expectedForth = Double.POSITIVE_INFINITY;
        final double expectedFifth = 21;
        final double expectedSixth = 1.7976931348623157E308;
        final double actualFirst = calculator.calculate(FIRST_CASE_A, FIRST_CASE_A, '+');
        final double actualSecond = calculator.calculate(SECOND_CASE_A, SECOND_CASE_A, '+');
        final double actualThird = calculator.calculate(FIRST_CASE_A, SECOND_CASE_A, '+');
        final double actualForth = calculator.calculate(FORTH_CASE_A, FORTH_CASE_A, '+');
        final double actualFifth = calculator.calculate(FIRST_CASE_A, THIRD_CASE_B, '+');
        final double actualSixth = calculator.calculate(FORTH_CASE_A, FIFTH_CASE_A, '+');
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedSecond, actualSecond);
        assertEquals(expectedThird, actualThird);
        assertEquals(expectedForth, actualForth);
        assertEquals(expectedFifth, actualFifth);
        assertEquals(expectedSixth, actualSixth);
    }

    @Test
    public void subtraction_Ok() {
        final double expectedFirst = 0;
        final double expectedSecond = 0;
        final double expectedThird = 42;
        final double expectedForth = 0;
        final double expectedFifth = 21;
        final double expectedSixth = 1.7976931348623157E308;
        final double actualFirst = calculator.calculate(FIRST_CASE_A, FIRST_CASE_A, '-');
        final double actualSecond = calculator.calculate(SECOND_CASE_A, SECOND_CASE_A, '-');
        final double actualThird = calculator.calculate(FIRST_CASE_A, SECOND_CASE_A, '-');
        final double actualForth = calculator.calculate(FORTH_CASE_A, FORTH_CASE_A, '-');
        final double actualFifth = calculator.calculate(FIRST_CASE_A, THIRD_CASE_B, '-');
        final double actualSixth = calculator.calculate(FORTH_CASE_A, FIFTH_CASE_A, '-');
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedSecond, actualSecond);
        assertEquals(expectedThird, actualThird);
        assertEquals(expectedForth, actualForth);
        assertEquals(expectedFifth, actualFifth);
        assertEquals(expectedSixth, actualSixth);
    }

    @Test
    public void division_Ok() {
        final double expectedFirst = 1;
        final double expectedSecond = 1;
        final double expectedThird = -1;
        final double expectedForth = 1;
        final double expectedFifth = Double.POSITIVE_INFINITY;
        final double actualFirst = calculator.calculate(FIRST_CASE_A, FIRST_CASE_A, '/');
        final double actualSecond = calculator.calculate(SECOND_CASE_A, SECOND_CASE_A, '/');
        final double actualThird = calculator.calculate(FIRST_CASE_A, SECOND_CASE_A, '/');
        final double actualForth = calculator.calculate(FORTH_CASE_A, FORTH_CASE_A, '/');
        final double actualFifth = calculator.calculate(FORTH_CASE_A, FIFTH_CASE_A, '/');
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedSecond, actualSecond);
        assertEquals(expectedThird, actualThird);
        assertEquals(expectedForth, actualForth);
        assertEquals(expectedFifth, actualFifth);
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(FIRST_CASE_A, THIRD_CASE_B, '/'), "Can't division on zero!");
    }

    @Test
    public void multiplication_Ok() {
        final double expectedFirst = 441;
        final double expectedSecond = 441;
        final double expectedThird = -441;
        final double expectedForth = Double.POSITIVE_INFINITY;
        final double expectedFifth = 0;
        final double expectedSixth = 8.881784197001251E-16;
        final double actualFirst = calculator.calculate(FIRST_CASE_A, FIRST_CASE_A, '*');
        final double actualSecond = calculator.calculate(SECOND_CASE_A, SECOND_CASE_A, '*');
        final double actualThird = calculator.calculate(FIRST_CASE_A, SECOND_CASE_A, '*');
        final double actualForth = calculator.calculate(FORTH_CASE_A, FORTH_CASE_A, '*');
        final double actualFifth = calculator.calculate(FIRST_CASE_A, THIRD_CASE_B, '*');
        final double actualSixth = calculator.calculate(FORTH_CASE_A, FIFTH_CASE_A, '*');
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedSecond, actualSecond);
        assertEquals(expectedThird, actualThird);
        assertEquals(expectedForth, actualForth);
        assertEquals(expectedFifth, actualFifth);
        assertEquals(expectedSixth, actualSixth);
    }

    @Test
    public void raisingToAPower_Ok() {
        final double expectedFirst = 5.842587018385982E27;
        final double expectedSecond = -1.7115705711410192E-28;
        final double expectedThird = 1.7115705711410192E-28;
        final double expectedForth = Double.POSITIVE_INFINITY;
        final double expectedFifth = 1;
        final double expectedSixth = 1;
        final double actualFirst = calculator.calculate(FIRST_CASE_A, FIRST_CASE_A, '^');
        final double actualSecond = calculator.calculate(SECOND_CASE_A, SECOND_CASE_A, '^');
        final double actualThird = calculator.calculate(FIRST_CASE_A, SECOND_CASE_A, '^');
        final double actualForth = calculator.calculate(FORTH_CASE_A, FORTH_CASE_A, '^');
        final double actualFifth = calculator.calculate(FIRST_CASE_A, THIRD_CASE_B, '^');
        final double actualSixth = calculator.calculate(FORTH_CASE_A, FIFTH_CASE_A, '^');
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedSecond, actualSecond);
        assertEquals(expectedThird, actualThird);
        assertEquals(expectedForth, actualForth);
        assertEquals(expectedFifth, actualFifth);
        assertEquals(expectedSixth, actualSixth);
    }
}
