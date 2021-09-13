package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositiveOperands_ok() {
        double expected = 20.5;
        double actual = calculator.calculate(10, '+', 10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionNegativeOperands_ok() {
        double expected = -20.5;
        double actual = calculator.calculate(-10, '+', -10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperand_ok() {
        double expected = 10.5;
        double actual = calculator.calculate(15.5, '+', -5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithFirstOperandIsZero_ok() {
        double expected = 10.5;
        double actual = calculator.calculate(0, '+', 10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithSecondOperandIsZero_ok() {
        double expected = 10.5;
        double actual = calculator.calculate(10.5, '+', 0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMinOperand_ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, '+', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMaxOperand_ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, '+', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinAndMinOperand_ok() {
        double expected = Double.MIN_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MIN_VALUE, '+', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands_ok() {
        double expected = 10.5;
        double actual = calculator.calculate(15.5, '-', 5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionNegativeOperands_ok() {
        double expected = 0.5;
        double actual = calculator.calculate(-10, '-', -10.5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperand_ok() {
        double expected = -20.5;
        double actual = calculator.calculate(-15.5, '-', 5);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithFirstOperandIsZero_ok() {
        double expected = -10;
        double actual = calculator.calculate(0, '-', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondOperandIsZero_ok() {
        double expected = -10;
        double actual = calculator.calculate(-10, '-', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxAndMinOperand_ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, '-', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMaxAndMaxOperand_ok() {
        double expected = 0;
        double actual = calculator.calculate(Double.MAX_VALUE, '-', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinAndMinOperand_ok() {
        double expected = 0;
        double actual = calculator.calculate(Double.MIN_VALUE, '-', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveOperands_ok() {
        double expected = 10;
        double actual = calculator.calculate(5, '*', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_ok() {
        double expected = 10;
        double actual = calculator.calculate(-5, '*', -2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperand_ok() {
        double expected = -10;
        double actual = calculator.calculate(-5, '*', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstOperandIsZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, '*', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondOperandIsZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(10, '*', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxAndMinOperand_ok() {
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, '*', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxAndMaxOperand_ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, '*', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMinAndMinOperand_ok() {
        double expected = 0;
        double actual = calculator.calculate(Double.MIN_VALUE, '*', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveOperands_ok() {
        double expected = 5;
        double actual = calculator.calculate(10, '/', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeOperands_ok() {
        double expected = 5;
        double actual = calculator.calculate(-10, '/', -2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperand_ok() {
        double expected = -5;
        double actual = calculator.calculate(-10, '/', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithFirstOperandIsZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, '/', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondOperandIsZero_ok() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(80, '/', 0));
    }

    @Test
    void calculate_divisionMaxAndMinOperand_ok() {
        double expected = Double.MAX_VALUE / Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, '/', Double.MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_ok() {
        double expected = 25;
        double actual = calculator.calculate(5, '^', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculator_raisingPositiveValueToTheNegativePower_ok() {
        double expected = 0.25;
        double actual = calculator.calculate(2, '^', -2);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_ok() {
        double expected = 4;
        double actual = calculator.calculate(-2, '^', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculator_raisingNegativeValueToTheNegativePower_ok() {
        double expected = 0.25;
        double actual = calculator.calculate(-2, '^', -2);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower() {
        double expected = 0;
        double actual = calculator.calculate(0, '^', 10);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(-10, '^', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(10, '^', 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingMaxAndMaxPower_ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, '^', Double.MAX_VALUE);
        assertEquals(expected, actual, DELTA);
    }
}
