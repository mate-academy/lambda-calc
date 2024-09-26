package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POWER = '^';
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    void calculate_additionTwoPositiveValues_Ok() {
        double actual = calculator.calculate(2.22, 3.33, PLUS);
        double expected = 5.55;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeValues_Ok() {
        double actual = calculator.calculate(-2.1, -6.23, PLUS);
        double expected = -8.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOneNegativeOnePositiveValues_Ok() {
        double actual = calculator.calculate(-7.7, 4.6, PLUS);
        double expected = -3.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOnePositiveOneNegativeValues_Ok() {
        double actual = calculator.calculate(4.245, -7.455, PLUS);
        double expected = -3.21;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionToDoubleMaxValue_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, 1, PLUS);
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionToZero_Ok() {
        double actual = calculator.calculate(0, 4.98, PLUS);
        double expected = 4.98;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionZeroToValue_Ok() {
        double actual = calculator.calculate(5.25, 0, PLUS);
        double expected = 5.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionNegativeToZero_Ok() {
        double actual = calculator.calculate(0, -7.77, PLUS);
        double expected = -7.77;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionToMaxDouble_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, PLUS);
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeDoubleMax_Ok() {
        double actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, PLUS);
        double expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOnePositiveDoubleMinAndNegativeDoubleMax_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, -Double.MAX_VALUE, PLUS);
        double expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionOnePositiveDoubleMaxAndNegativeDoubleMax_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, PLUS);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionDoubleMaxAndNegativeDoubleMin_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, -Double.MIN_VALUE, MINUS);
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionToDoubleMinValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS);
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionTwoPositiveValues_Ok() {
        double actual = calculator.calculate(9.87, 7.23, MINUS);
        double expected = 2.64;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionTwoNegativeValues_Ok() {
        double actual = calculator.calculate(-6.958586, -9.462523, MINUS);
        double expected = 2.503937;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionOnePositiveAndNegativeValues_Ok() {
        double actual = calculator.calculate(-13.0236, 7.2325, MINUS);
        double expected = -20.2561;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionZeroAndPositiveValue_Ok() {
        double actual = calculator.calculate(0, 9.01, MINUS);
        double expected = -9.01;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionNegativeWithPositive_OK() {
        double actual = calculator.calculate(-7.56656, 4.56567, MINUS);
        double expected = -12.13223;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subAdditionTwoZero_Ok() {
        double actual = calculator.calculate(0, 0, MINUS);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingTwoPositiveValues_Ok() {
        double actual = calculator.calculate(7.7, 4.4, MULTIPLY);
        double expected = 33.88;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingTwoNegativeValues_Ok() {
        double actual = calculator.calculate(-2.5, -6, MULTIPLY);
        double expected = 15;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingOnePositiveAndNegative_Ok() {
        double actual = calculator.calculate(4.34252352, -10.43634634636, MULTIPLY);
        double expected = -45.3200794719;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingZeroAndNegativeValue_Ok() {
        double actual = calculator.calculate(-10, 0, MULTIPLY);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingPositiveValueAndZero_Ok() {
        double actual = calculator.calculate(23, 0, MULTIPLY);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyingDoubleMinValueByNegativeDoubleMaxValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, -Double.MAX_VALUE, MULTIPLY);
        double expected = -8.881784197001251E-16;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingTwoPositiveValues_OK() {
        double actual = calculator.calculate(12.12, 2.22, DIVIDE);
        double expected = 5.4594594594595;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingTwoNegativeValues_Ok() {
        double actual = calculator.calculate(-10, -5.45, DIVIDE);
        double expected = 1.8348623853211;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingOneNegativeAndOnePositiveValues_Ok() {
        double actual = calculator.calculate(-32.0001, 4, DIVIDE);
        double expected = -8.000025;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingTwoElementsWithFloatingPoint_Ok() {
        double actual = calculator.calculate(2.34856, 4.24, DIVIDE);
        double expected = 0.55390566037736;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(3, 0, DIVIDE));
    }

    @Test
    void calculate_dividingZeroByValue_Ok() {
        double actual = calculator.calculate(0, -2.334, DIVIDE);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingDoubleMaxValueByDoubleMax_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);

    }

    @Test
    void calculate_dividingDoubleMinValueByDoubleMin_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVIDE);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividingDoubleMaxByNegativeDoubleMin_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, -Double.MIN_VALUE, DIVIDE);
        double expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingToPositivePower_Ok() {
        double actual = calculator.calculate(2.22, 4, POWER);
        double expected = 24.28912656;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToNegativePower_Ok() {
        double actual = calculator.calculate(-3.98, -2, POWER);
        double expected = 0.063129718946491;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingToZeroPower_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, 0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToZeroPower_Ok() {
        double actual = calculator.calculate(0, 0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_WithBadTypeOfOperand_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(0, 23.524, '%'));
    }
}
