package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final char ADD = '+';
    private static final char MINUS = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final char WRONG_OPERAND = '?';
    private static final double POSITIVE_NUMBER = 457.199;
    private static final double NEGATIVE_NUMBER = -905.073;
    private static final double ZERO = 0;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addition_withTwoPositiveOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADD);
        expected = 914.398;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_withTwoNegativeOperands_OK() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADD);
        expected = -1810.146;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, -NEGATIVE_NUMBER, ADD);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_withPositiveAndNegativeNumbers_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADD);
        expected = -447.874;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, ADD);
        expected = -447.874;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_withZeroAndPositiveOperands_OK() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, ADD);
        expected = POSITIVE_NUMBER;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, ADD);
        expected = NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_withMaxVal_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADD);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, Double.MAX_VALUE, ADD);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_withMinValue_OK() {
        actual = calculator.calculate(NEGATIVE_NUMBER, Double.MIN_VALUE, ADD);
        expected = -905.073;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_NUMBER, Double.MIN_VALUE, ADD);
        expected = 457.199;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_withTwoMinValueOperands_OK() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADD);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_withTwoMaxValueOperands_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtracion_withPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        expected = 1362.272;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtracion_withTwoNegativeOperands_OK() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtracion_withZero_OK() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, MINUS);
        expected = 905.073;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, MINUS);
        expected = -905.073;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtracion_withNegativeAndPositiveOperands_OK() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MINUS);
        expected = -1362.272;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtracion_withTwoPositiveOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MINUS);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtracion_withMimValueAndMaxValueOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, Double.MAX_VALUE, MINUS);
        expected = -1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_NUMBER, Double.MIN_VALUE, MINUS);
        expected = 457.199;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_withTwoPositiveOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = 209030.9256;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_withTwoNegativeOperands_OK() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = 819157.1353;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_withPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = -413798.4705;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_withZero_OK() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_withMimValueAndMaxValueOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, Double.MIN_VALUE, MULTIPLICATION);
        expected = -4.47E-321;
        assertEquals(expected, actual, DELTA);

    }

    @Test
    void division_withTwoPositiveOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_withTwoNegativeOperands_OK() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_withPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = -0.5051;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_withZero_OK() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, DIVISION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION);
        });
    }

    @Test
    void raising_toPositivePowerOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raising_toNegativePowerOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raising_toZeroPowerOperands_OK() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raising_zeroToPowerOperands_OK() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POWER);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkWrongOperand_isNotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, WRONG_OPERAND);
            calculator.calculate(ZERO, NEGATIVE_NUMBER, WRONG_OPERAND);
        });
    }
}
