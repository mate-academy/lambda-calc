package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char POWER_OPERATOR = '^';
    private static final double DELTA = 0.0001;
    private static Calculator calculatorTest;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculatorTest = new Calculator();
    }

    @Test
    public void calculate_sumWithTwoPositiveNumber_Ok() {
        actual = calculatorTest.calculate(1, 3, ADDITION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_sumWithTwoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-10, -10, ADDITION_OPERATOR);
        expected = -20;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_sumWithTwoNumbersNegativeAndPositive_Ok() {
        actual = calculatorTest.calculate(-10, 12, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_sumWithFirstNumberZero_Ok() {
        actual = calculatorTest.calculate(0, 2, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_sumWithSecondNumberZero_Ok() {
        actual = calculatorTest.calculate(2, 0, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_sumWithMaxDoubleValues_Ok() {
        actual = calculatorTest.calculate(Double.MAX_VALUE, 2, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void calculate_sumWithMinDoubleValue_Ok() {
        actual = calculatorTest.calculate(Double.MIN_VALUE, 2, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void calculate_subtractionWithTwoPositiveNumber_Ok() {
        actual = calculatorTest.calculate(5, 4, SUBTRACTION_OPERATOR);
        expected = 1;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void calculate_subtractionWithTwoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-2, -2, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithPositiveAndNegative_Ok() {
        actual = calculatorTest.calculate(5, -5, SUBTRACTION_OPERATOR);
        expected = 10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithFirstNumberZero_Ok() {
        actual = calculatorTest.calculate(0, -1, SUBTRACTION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithSecondZero_Ok() {
        actual = calculatorTest.calculate(2, 0, SUBTRACTION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithDoubleMaxValue_Ok() {
        actual = calculatorTest.calculate(2, Double.MAX_VALUE, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithDoubleMinValue_Ok() {
        actual = calculatorTest.calculate(2, Double.MIN_VALUE, SUBTRACTION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithTwoPositiveNumbers_Ok() {
        actual = calculatorTest.calculate(2, 2, MULTIPLICATION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithTwoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-2, -2, MULTIPLICATION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithPositiveAndNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-2, 2, MULTIPLICATION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithFirstNumberZero_Ok() {
        actual = calculatorTest.calculate(0, 2, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithSecondNumberZero_Ok() {
        actual = calculatorTest.calculate(2, 0, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithDoubleMaxValue_Ok() {
        actual = calculatorTest.calculate(2, Double.MAX_VALUE, MULTIPLICATION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithDoubleMinValue_Ok() {
        actual = calculatorTest.calculate(2, Double.MIN_VALUE, MULTIPLICATION_OPERATOR);
        expected = 1.0E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithTwoPositiveNumbers_Ok() {
        actual = calculatorTest.calculate(2, 2, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithTwoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-2, -2, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithPositiveAndNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(2, -2, DIVISION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithNumberFirstZero_Ok() {
        actual = calculatorTest.calculate(0, 2, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithNumberSecondZero_Ok() {
        actual = calculatorTest.calculate(2.0, 0, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithMaxDoubleValue_Ok() {
        actual = calculatorTest.calculate(2, Double.MAX_VALUE, DIVISION_OPERATOR);
        expected = 1.1125369292536007E-308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithMinDoubleValue_Ok() {
        actual = calculatorTest.calculate(2, Double.MIN_VALUE, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisingWithPositiveNumberAndPositivePower_Ok() {
        actual = calculatorTest.calculate(2, 2, POWER_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisingWithNegativeNumberAndPositivePower_Ok() {
        actual = calculatorTest.calculate(-2, 2, POWER_OPERATOR);
        expected = 4;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void calculate_raisingWithPositiveNumberAndNegativePower_Ok() {
        actual = calculatorTest.calculate(2, -2, POWER_OPERATOR);
        expected = 0.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisingWithNegativeNumberAndNegativePower_Ok() {
        actual = calculatorTest.calculate(-2, -2, POWER_OPERATOR);
        expected = 0.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisingWithPositiveNumberAndZeroPower_Ok() {
        actual = calculatorTest.calculate(2, 0, POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisingWithNegativeAndZeroPower_Ok() {
        actual = calculatorTest.calculate(-2, 0, POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisingZeroToPower_Ok() {
        actual = calculatorTest.calculate(0, 2, POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculatorTest.calculate(2, 3, '@');
        });
    }
}
