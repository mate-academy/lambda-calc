package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.DivisionByZeroException;
import core.basesyntax.exception.IllegalOperatorException;
import core.basesyntax.exception.InvalidValuesException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final int POSITIVE_A = 5;
    private static final int POSITIVE_B = 17;
    private static final double ADD_A_B = 22;
    private static final double SUBTRACT_A_B = -12;
    private static final double MULTIPLY_A_B = 5 * 17;
    private static final double DIVIDE_A_B = (double) 5 / 17;
    private static final double DIVIDE_B_A = (double) 17 / 5;
    private static final double RAISE_A_TO_B = Math.pow(5, 17);
    private static final double RAISE_B_TO_A = Math.pow(17, 5);
    private static final int ZERO = 0;
    private static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void addition_Ok() {
        double expected = ADD_A_B;
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '+');
        assertEquals(expected, actual);
        expected = -10;
        actual = calculator.calculate(-2.8, -7.2, '+');
        assertEquals(expected, actual);
        expected = -7;
        actual = calculator.calculate(-10, 3, '+');
        assertEquals(expected, actual);
        expected = 10;
        actual = calculator.calculate(0, 10, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void addition_NotOk() {
        assertThrows(InvalidValuesException.class, () -> {
            calculator.calculate(Integer.MAX_VALUE, 1, '+');
        });
    }

    @Test
    public void subtraction_Ok() {
        double expected = SUBTRACT_A_B;
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '-');
        assertEquals(expected, actual);
        expected = 4.4;
        actual = calculator.calculate(-2.8, -7.2, '-');
        assertEquals(expected, actual);
        expected = -13;
        actual = calculator.calculate(-10, 3, '-');
        assertEquals(expected, actual);
        expected = -10;
        actual = calculator.calculate(0, 10, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtraction_NotOk() {
        assertThrows(InvalidValuesException.class, () -> {
            calculator.calculate(Integer.MAX_VALUE, -1, '-');
        });
    }

    @Test
    public void division_Ok() {
        double expected = DIVIDE_A_B;
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '/');
        assertEquals(expected, actual);
        expected = (double) -7 / 9;
        actual = calculator.calculate(-7, 9, '/');
        assertEquals(expected, actual);
        expected = (double) -10 / -6;
        actual = calculator.calculate(-10, -6, '/');
        assertEquals(expected, actual);
        expected = (double) Integer.MAX_VALUE / Integer.MIN_VALUE;
        actual = calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '/');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(0, 5, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void division_ByZero() {
        assertThrows(DivisionByZeroException.class, () -> {
            calculator.calculate(POSITIVE_A, ZERO, '/');
        });
    }

    @Test
    public void multiplication_Ok() {
        double expected = MULTIPLY_A_B;
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '*');
        assertEquals(expected, actual);
        expected = -8;
        actual = calculator.calculate(-2, 4, '*');
        assertEquals(expected, actual);
        expected = 8;
        actual = calculator.calculate(-2, -4, '*');
        assertEquals(expected, actual);
        expected = (double) Integer.MAX_VALUE / 2;
        actual = calculator.calculate(Integer.MAX_VALUE, 0.5, '*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(-100, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingToPower_Ok() {
        double expected = RAISE_A_TO_B;
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '^');
        assertEquals(expected, actual);
        expected = RAISE_B_TO_A;
        actual = calculator.calculate(POSITIVE_B, POSITIVE_A, '^');
        assertEquals(expected, actual);
        expected = 0.5;
        actual = calculator.calculate(2, -1, '^');
        assertEquals(expected, actual);
        expected = 1;
        actual = calculator.calculate(1, 0, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(-1, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void notValidOperator() {
        assertThrows(IllegalOperatorException.class, () -> {
            calculator.calculate(POSITIVE_A, POSITIVE_B, '%');
        });
    }
}
