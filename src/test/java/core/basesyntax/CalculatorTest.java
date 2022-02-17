package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositiveOperands_ok() {
        expected = 20.5;
        actual = calculator.calculate(10, '+', 10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionNegativeOperands_ok() {
        expected = -20.5;
        actual = calculator.calculate(-10, '+', -10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperand_ok() {
        expected = 10.5;
        actual = calculator.calculate(15.5, '+', -5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithFirstOperandIsZero_ok() {
        expected = 10.5;
        actual = calculator.calculate(0, '+', 10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithSecondOperandIsZero_ok() {
        expected = 10.5;
        actual = calculator.calculate(10.5, '+', 0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMinOperand_ok() {
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, '+', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMaxOperand_ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, '+', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinAndMinOperand_ok() {
        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, '+', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands_ok() {
        expected = 10.5;
        actual = calculator.calculate(15.5, '-', 5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionNegativeOperands_ok() {
        expected = 0.5;
        actual = calculator.calculate(-10, '-', -10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperand_ok() {
        expected = -20.5;
        actual = calculator.calculate(-15.5, '-', 5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithFirstOperandIsZero_ok() {
        expected = -10;
        actual = calculator.calculate(0, '-', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondOperandIsZero_ok() {
        expected = -10;
        actual = calculator.calculate(-10, '-', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxAndMinOperand_ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, '-', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMaxAndMaxOperand_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, '-', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinAndMinOperand_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, '-', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveOperands_ok() {
        expected = 10;
        actual = calculator.calculate(5, '*', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_ok() {
        expected = 10;
        actual = calculator.calculate(-5, '*', -2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperand_ok() {
        expected = -10;
        actual = calculator.calculate(-5, '*', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstOperandIsZero_ok() {
        expected = 0;
        actual = calculator.calculate(0, '*', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondOperandIsZero_ok() {
        expected = 0;
        actual = calculator.calculate(10, '*', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxAndMinOperand_ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, '*', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxAndMaxOperand_ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, '*', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMinAndMinOperand_ok() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, '*', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveOperands_ok() {
        expected = 5;
        actual = calculator.calculate(10, '/', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeOperands_ok() {
        expected = 5;
        actual = calculator.calculate(-10, '/', -2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperand_ok() {
        expected = -5;
        actual = calculator.calculate(-10, '/', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithFirstOperandIsZero_ok() {
        expected = 0;
        actual = calculator.calculate(0, '/', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWhenSecondOperandIsZero_ok() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(80, '/', 0));
    }

    @Test
    void calculate_divisionMaxAndMinOperands() {
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, '/', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_ok() {
        expected = 25;
        actual = calculator.calculate(5, '^', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculator_raisingPositiveValueToTheNegativePower_ok() {
        expected = 0.25;
        actual = calculator.calculate(2, '^', -2);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_ok() {
        expected = 4;
        actual = calculator.calculate(-2, '^', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculator_raisingNegativeValueToTheNegativePower_ok() {
        expected = 0.25;
        actual = calculator.calculate(-2, '^', -2);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower() {
        expected = 0;
        actual = calculator.calculate(0, '^', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingFirstIsZeroToNegativePower() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(0, '^', -2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_ok() {
        expected = 1;
        actual = calculator.calculate(-10, '^', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_ok() {
        expected = 1;
        actual = calculator.calculate(10, '^', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingMaxAndMaxPower_ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, '^', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_WithIllegalOperator_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator
                .calculate(2, '%', 2));
    }
}
