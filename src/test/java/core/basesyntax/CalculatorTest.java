package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';
    private static final char ILLEGAL_OPERATOR = '#';
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositive_ok() {
        double expected = 9;
        double actual = calculator.calculate(5, 4, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegative_ok() {
        double expected = -7;
        double actual = calculator.calculate(-5, -2, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveNegative_ok() {
        double expected = -10;
        double actual = calculator.calculate(10, -20, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionFirstZero_ok() {
        double expected = 5;
        double actual = calculator.calculate(0, 5, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionSecondZero_ok() {
        double expected = 4;
        double actual = calculator.calculate(4, 0, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinMaxDouble_ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositive_ok() {
        double expected = 1;
        double actual = calculator.calculate(5, 4, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoNegative_ok() {
        double expected = -3;
        double actual = calculator.calculate(-5, -2, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveNegative_ok() {
        double expected = 30;
        double actual = calculator.calculate(10, -20, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionFirstZero_ok() {
        double expected = -5;
        double actual = calculator.calculate(0, 5, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionSecondZero_ok() {
        double expected = 4;
        double actual = calculator.calculate(4, 0, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinMaxDouble_ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE,
                                             Double.MIN_VALUE,
                                             SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositive_ok() {
        double expected = 2;
        double actual = calculator.calculate(1, 2, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegative_ok() {
        double expected = 10;
        double actual = calculator.calculate(-5, -2, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveNegative_ok() {
        double expected = -40;
        double actual = calculator.calculate(2, -20, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationFirstZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 5, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationSecondZero_ok() {
        double expected = 0;
        double actual = calculator.calculate(4, 0, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMinMaxDouble_ok() {
        double sum = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertTrue(sum == Double.MAX_VALUE * Double.MIN_VALUE);
    }

    @Test
    void calculate_divisionTwoPositive_ok() {
        double expected = 2;
        double actual = calculator.calculate(2, 1, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoNegative_ok() {
        double expected = 3;
        double actual = calculator.calculate(-6, -2, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveNegative_ok() {
        double expected = -4;
        double actual = calculator.calculate(20, -5, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionFirstZero_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(5, 0, DIVISION));
    }

    @Test
    void calculate_raisingPositiveToPositive_ok() {
        double expected = 4;
        double actual = calculator.calculate(2, 2, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToPositive_ok() {
        double expected = 4;
        double actual = calculator.calculate(-2, 2, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToNegative_ok() {
        double expected = 0.25;
        double actual = calculator.calculate(2, -2, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToNegative_ok() {
        double expected = 0.04;
        double actual = calculator.calculate(-5, -2, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZero_ok() {
        double expected = 1;
        double actual = calculator.calculate(2, 0, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToZero_ok() {
        double expected = 1.0;
        double actual = calculator.calculate(-5, 0, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPositive_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegaloperator_Notok() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(2, 2, ILLEGAL_OPERATOR)
        );
    }
}
