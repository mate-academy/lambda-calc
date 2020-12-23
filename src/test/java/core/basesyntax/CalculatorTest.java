package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final int POS_FST = 123;
    private static final int POS_SCD = 7;
    private static final int NEG_SCD = -34;
    private static final int NEG_FST = -1234;
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
        assertEquals((double) NEG_FST / NEG_SCD, calculator.calculate(NEG_FST, NEG_SCD, DIV));
        assertEquals((double) POS_FST / POS_SCD, calculator.calculate(POS_FST, POS_SCD, DIV));
        assertEquals((double) POS_FST / NEG_FST, calculator.calculate(POS_FST, NEG_FST, DIV));
        assertEquals((double) NEG_SCD / POS_SCD, calculator.calculate(NEG_SCD, POS_SCD, DIV));
        assertEquals((double) 0 / POS_SCD, calculator.calculate(0, POS_SCD, DIV));

    }

    @Test
    void addition_Ok() {
        double actual = calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, ADD);
        double expected = 4.294967294E9;
        assertEquals(expected, actual);
        assertEquals((double) NEG_FST + NEG_SCD, calculator.calculate(NEG_FST, NEG_SCD, ADD));
        assertEquals((double) POS_FST + POS_SCD, calculator.calculate(POS_FST, POS_SCD, ADD));
        assertEquals((double) POS_FST + NEG_FST, calculator.calculate(POS_FST, NEG_FST, ADD));
        assertEquals((double) NEG_SCD + POS_SCD, calculator.calculate(NEG_SCD, POS_SCD, ADD));
        assertEquals((double) 0 + POS_SCD, calculator.calculate(0, POS_SCD, ADD));
        assertEquals((double) NEG_SCD + 0, calculator.calculate(NEG_SCD, 0, ADD));
    }

    @Test
    void subtraction_Ok() {
        double actual = calculator.calculate(0, Integer.MIN_VALUE, SUBTR);
        double expected = 2.147483648E9;
        assertEquals(expected, actual);
        assertEquals((double) NEG_FST - NEG_SCD, calculator.calculate(NEG_FST, NEG_SCD, SUBTR));
        assertEquals((double) POS_FST - POS_SCD, calculator.calculate(POS_FST, POS_SCD, SUBTR));
        assertEquals((double) POS_FST - NEG_FST, calculator.calculate(POS_FST, NEG_FST, SUBTR));
        assertEquals((double) NEG_SCD - POS_SCD, calculator.calculate(NEG_SCD, POS_SCD, SUBTR));
        assertEquals((double) 0 - POS_SCD, calculator.calculate(0, POS_SCD, SUBTR));
        assertEquals((double) NEG_SCD - 0, calculator.calculate(NEG_SCD, 0, SUBTR));
    }

    @Test
    void multiplication_Ok() {
        double actual = calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, MULTI);
        double expected = -4.6116860162799043E18;
        assertEquals(expected, actual);
        assertEquals((double) NEG_FST * NEG_SCD, calculator.calculate(NEG_FST, NEG_SCD, MULTI));
        assertEquals((double) POS_FST * POS_SCD, calculator.calculate(POS_FST, POS_SCD, MULTI));
        assertEquals((double) POS_FST * NEG_FST, calculator.calculate(POS_FST, NEG_FST, MULTI));
        assertEquals((double) NEG_SCD * POS_SCD, calculator.calculate(NEG_SCD, POS_SCD, MULTI));
        assertEquals((double) 0 * POS_SCD, calculator.calculate(0, POS_SCD, MULTI));
        assertEquals((double) NEG_SCD * 0, calculator.calculate(NEG_SCD, 0, MULTI));
        assertEquals((double) 0 * 0, calculator.calculate(0, 0, MULTI));
    }

    @Test
    void pow_Ok() {
        double actual = calculator.calculate(2, -1, POW);
        double expected = 0.5;
        assertEquals(expected, actual);
        assertEquals(Math.pow(NEG_FST, NEG_SCD), calculator.calculate(NEG_FST, NEG_SCD, POW));
        assertEquals(Math.pow(POS_FST, POS_SCD), calculator.calculate(POS_FST, POS_SCD, POW));
        assertEquals(Math.pow(POS_FST, NEG_FST), calculator.calculate(POS_FST, NEG_FST, POW));
        assertEquals(Math.pow(NEG_SCD, POS_SCD), calculator.calculate(NEG_SCD, POS_SCD, POW));
        assertEquals(Math.pow(0, POS_SCD), calculator.calculate(0, POS_SCD, POW));
        assertEquals(Math.pow(NEG_SCD, 0), calculator.calculate(NEG_SCD, 0, POW));
        assertEquals(Math.pow(0, 0), calculator.calculate(0, 0, POW));
    }
}
