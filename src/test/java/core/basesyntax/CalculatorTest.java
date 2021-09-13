package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_ok() {
        double expected = 82;
        double actual = calculator.calculate(80, 2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_ok() {
        double expected = -82;
        double actual = calculator.calculate(-80, -2, '+');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionWithOneNegativeOperand_ok() {
        double expected = -78;
        double actual = calculator.calculate(-80, 2, '+');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionWithFirstOperandIsZero_ok() {
        double expected = 2;
        double actual = calculator.calculate(0, 2, '+');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionWithSecondOperandIsZero_ok() {
        double expected = 80;
        double actual = calculator.calculate(80, 0, '+');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionWithMaxAndMinValue_ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithMaxAndMaxValue_ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithMinAndMinValue_ok() {
        double expected = Double.MIN_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_ok() {
        double expected = 78;
        double actual = calculator.calculate(80, 2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_ok() {
        double expected = -78;
        double actual = calculator.calculate(-80, -2, '-');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionWithOneNegativeOperand_ok() {
        double expected = -82;
        double actual = calculator.calculate(-80, 2, '-');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionWithFirstOperandIsZero_ok() {
        double expected = -2;
        double actual = calculator.calculate(0, 2, '-');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionWithSecondOperandIsZero_ok() {
        double expected = 80;
        double actual = calculator.calculate(80, 0, '-');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionWithMaxAndMinOperands_ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithMaxAndMaxOperands_ok() {
        double expected = 0;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMinAndMinOperands_ok() {
        double expected = 0;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_ok() {
        double expected = 160;
        double actual = calculator.calculate(80, 2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_ok() {
        double expected = 160;
        double actual = calculator.calculate(-80, -2, '*');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationWithNegativeAndPositiveOperands_ok() {
        double expected = -160;
        double actual = calculator.calculate(-80, 2, '*');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationWithFirstOperandIsZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '*');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationWithSecondOperandIsZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(80, 0, '*');
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationWithMinAndMaxOperands_ok() {
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithMaxAndMaxOperands_ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithMinAndMinOperands_ok() {
        double expected = 0;
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_ok() {
        double expected = 6400;
        double actual = calculator.calculate(80, 2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_ok() {
        double expected = 0.25;
        double actual = calculator.calculate(2, -2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_ok() {
        double expected = 6400;
        double actual = calculator.calculate(-80, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_ok() {
        double expected = 0.25;
        double actual = calculator.calculate(-2, -2, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(-80, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(80, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower() {
        double expected = 0;
        double actual = calculator.calculate(0, 10, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_ok() {
        double expected = 40;
        double actual = calculator.calculate(80, 2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_ok() {
        double expected = 40;
        double actual = calculator.calculate(-80, -2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithNegativeAndPositiveOperands_ok() {
        double expected = -40;
        double actual = calculator.calculate(-80, 2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondOperandIsZero_ok() {
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(80, 0, '/'));
    }

    @Test
    void calculate_divisionWithFirstOperandIsZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_withIllegalOperator_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator
                .calculate(2, 0, '%'));
    }
}

