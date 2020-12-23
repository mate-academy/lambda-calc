package core.basesyntax;

import core.basesyntax.exception.DivisionByZeroException;
import core.basesyntax.exception.IllegalOperatorException;
import core.basesyntax.exception.InvalidValuesException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    private static final int DEFAULT_A = 5;
    private static final int DEFAULT_B = 17;
    private static final double ADD_A_B = 22;
    private static final double SUBTRACT_A_B = -12;
    private static final double MULTIPLY_A_B = 5 * 17;
    private static final double DIVIDE_A_B = (double) 5 / 17;
    private static final double DIVIDE_B_A = (double) 17 / 5;
    private static final double RAISE_A_TO_B = Math.pow(5, 17);
    private static final double RAISE_B_TO_A = Math.pow(17, 5);
    private static final int ZERO = 0;

    @Test
    void add_Ok() {
        double expected = ADD_A_B;
        double actual = calculator.calculate(DEFAULT_A, DEFAULT_B, '+');
        assertEquals(expected, actual);
    }

    @Test
    void add_NotOk() {
        assertThrows(InvalidValuesException.class, () -> {
            calculator.calculate(Integer.MAX_VALUE, 1, '+');
        });
    }

    @Test
    void subtract_Ok() {
        double expected = SUBTRACT_A_B;
        double actual = calculator.calculate(DEFAULT_A, DEFAULT_B, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtract_NotOk() {
        assertThrows(InvalidValuesException.class, () -> {
            calculator.calculate(Integer.MAX_VALUE, -1, '-');
        });
    }

    @Test
    void divide_Ok() {
        double expected = DIVIDE_A_B;
        double actual = calculator.calculate(DEFAULT_A, DEFAULT_B, '/');
        assertEquals(expected, actual);
        expected = DIVIDE_B_A;
        actual = calculator.calculate(DEFAULT_B, DEFAULT_A, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divide_ByZero() {
        assertThrows(DivisionByZeroException.class, () -> {
            calculator.calculate(DEFAULT_A, ZERO, '/');
        });
    }

    @Test
    void multiply_Ok() {
        double expected = MULTIPLY_A_B;
        double actual = calculator.calculate(DEFAULT_A, DEFAULT_B, '*');
        assertEquals(expected, actual);
    }

    @Test
    void raiseToPower_Ok() {
        double expected = RAISE_A_TO_B;
        double actual = calculator.calculate(DEFAULT_A, DEFAULT_B, '^');
        assertEquals(expected, actual);
        expected = RAISE_B_TO_A;
        actual = calculator.calculate(DEFAULT_B, DEFAULT_A, '^');
        assertEquals(expected, actual);
    }

    @Test
    void notValidOperator() {
        assertThrows(IllegalOperatorException.class, () -> {
            calculator.calculate(DEFAULT_A, DEFAULT_B, '%');
        });
    }
}