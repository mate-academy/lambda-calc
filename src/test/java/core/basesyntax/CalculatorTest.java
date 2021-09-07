package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static double DELTA = 0.0001;
    private static Calculator calculator;
    private static double actual;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveOperands_Ok() {
        actual = calculator.calculate(10.1, 20.2, ADDITION);
        expected = 30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-10.1, -20.2, ADDITION);
        expected = -30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(10.1, -20.2, ADDITION);
        expected = -10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveAndZeroOperands_Ok() {
        actual = calculator.calculate(10.1, 0.0, ADDITION);
        expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionZeroAndNegativeOperands_Ok() {
        actual = calculator.calculate(0.0, -20.0, ADDITION);
        expected = -20.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionTwoMaxDoubleOperands_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION));
    }

    @Test
    void calculate_additionTwoMinDoubleOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveOperands_Ok() {
        actual = calculator.calculate(10.1, 20.2, SUBTRACTION);
        expected = -10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-10.1, -20.2, SUBTRACTION);
        expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(10.1, -20.2, SUBTRACTION);
        expected = 30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveAndZeroOperands_Ok() {
        actual = calculator.calculate(10.1, 0.0, SUBTRACTION);
        expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionZeroAndNegativeOperands_Ok() {
        actual = calculator.calculate(0.0, -20.0, SUBTRACTION);
        expected = 20.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoMaxDoubleOperands_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void calculate_subtractionTwoMinDoubleOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveOperands_Ok() {
        actual = calculator.calculate(10.1, 20.2, MULTIPLICATION);
        expected = 204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-10.1, -20.2, MULTIPLICATION);
        expected = 204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(10.1, -20.2, MULTIPLICATION);
        expected = -204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveAndZeroOperands_Ok() {
        actual = calculator.calculate(10.1, 0.0, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationZeroAndNegativeOperands_Ok() {
        actual = calculator.calculate(0.0, -20.0, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoMaxDoubleOperands_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void calculate_multiplicationTwoMinDoubleOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(10.1, 20.2, DIVISION);
        double expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.1, -20.2, DIVISION);
        double expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(10.1, -20.2, DIVISION);
        double expected = -0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndZeroOperands_NotOk() {
        assertThrows(DivisionByZero.class,
                () -> calculator.calculate(10.1, 0.0, DIVISION));
    }

    @Test
    void calculate_divisionPositiveAndMinDoubleOperands_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(10.1, Double.MIN_VALUE, DIVISION));
    }

    @Test
    void calculate_divisionZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0.0, -20.0, DIVISION);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoMaxDoubleOperands_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionTwoMinDoubleOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveOperandToPositivePower_Ok() {
        double actual = calculator.calculate(2.0, 10.0, POWER);
        double expected = 1024.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeOperandToPositivePower_Ok() {
        double actual = calculator.calculate(-2.0, 3.0, POWER);
        double expected = -8.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveOperandToNegativePower_Ok() {
        double actual = calculator.calculate(2.0, -2.0, POWER);
        double expected = 0.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeOperandToNegativePower_Ok() {
        double actual = calculator.calculate(-2.0, -3.0, POWER);
        double expected = -0.125;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveOperandToZeroPower_Ok() {
        double actual = calculator.calculate(15.0, 0.0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeOperandToZeroPower_Ok() {
        double actual = calculator.calculate(-5.0, 0.0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZerOperandToPositivePower_Ok() {
        double actual = calculator.calculate(0.0, 4.0, POWER);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_rootOfNegativeOperand_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(-9, 0.5, POWER));
    }

    @Test
    void calculate_raisingMaxDoubleOperandToMaxDoublePower_NotOk() {
        assertThrows(IllegalValues.class,
                () -> calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, POWER));
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        assertThrows(IllegalOperation.class,
                () -> calculator.calculate(10, 20, '$'));
    }
}
