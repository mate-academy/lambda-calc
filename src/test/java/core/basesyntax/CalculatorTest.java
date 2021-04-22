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
    private static final char RAISING_TO_A_POWER = '^';
    private static final char ILLEGAL_OPERATION_SYMBOL = '?';
    private static final double POSITIVE_VALUE = 123.123;
    private static final double NEGATIVE_VALUE = -456.456;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;

    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        double expected = 246.246;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        double expected = -912.912;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ADDITION);
        double expected = -333.333;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZero_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        double expected = 123.123;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionForMaxAndMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        double actual2 = calculator.calculate(-Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        double expected2 = -Double.MAX_VALUE;
        assertEquals(expected2, actual2, DELTA);

        double actual3 = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        double expected3 = Double.POSITIVE_INFINITY;
        assertEquals(expected3, actual3, DELTA);

        double actual4 = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        double expected4 = Double.NEGATIVE_INFINITY;
        assertEquals(expected4, actual4, DELTA);

        double actual5 = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        double expected5 = 0;
        assertEquals(expected5, actual5, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        double expected = 579.579;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZero_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, SUBTRACTION);
        double expected = -123.123;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMaxAndMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        double actual2 = calculator.calculate(-Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        double expected2 = -Double.MAX_VALUE;
        assertEquals(expected2, actual2, DELTA);

        double actual3 = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        double expected3 = Double.POSITIVE_INFINITY;
        assertEquals(expected3, actual3, DELTA);

        double actual4 = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        double expected4 = 0;
        assertEquals(expected4, actual4, DELTA);

        double actual5 = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        double expected5 = Double.NEGATIVE_INFINITY;
        assertEquals(expected5, actual5, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        double expected = 15_159.2731;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        double expected = 208_352.0799;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        double expected = -56_200.2321;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZero_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationForMaxAndMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        double actual2 = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        double expected2 = Double.POSITIVE_INFINITY;
        assertEquals(expected2, actual2, DELTA);

        double actual3 = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        double expected3 = Double.NEGATIVE_INFINITY;
        assertEquals(expected3, actual3, DELTA);

        double actual4 = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        double expected4 = 0;
        assertEquals(expected4, actual4, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        double expected = -0.2697;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroOnFirstPlace_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOnZero_notOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_VALUE, ZERO, DIVISION));
    }

    @Test
    void calculate_divisionForMaxAndMinDoubleValues_NOk() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);

        double actual2 = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION);
        double expected2 = 1;
        assertEquals(expected2, actual2, DELTA);

        double actual3 = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION);
        double expected3 = -1;
        assertEquals(expected2, actual2, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToPositivePower_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        double expected = 2.3379324409797183E257;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToPositivePower_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToNegativePower_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToNegativePower_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(NEGATIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, RAISING_TO_A_POWER);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(UnsupportedOperationException.class, () ->
                calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ILLEGAL_OPERATION_SYMBOL));
    }
}
