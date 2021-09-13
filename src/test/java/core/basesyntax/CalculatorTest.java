package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculateSumOf2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '+');
        expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumOf2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '+');
        expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumOfPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '+');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '+');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '+');
        expected = 12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '+');
        expected = -12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = 1.0E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSumForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
                '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '+');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumForDoubleNegativeInfinityAndPositiveInfinityA_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, '+');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '+');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '-');
        expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '-');
        expected = -7;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '-');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '-');
        expected = -12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '-');
        expected = 12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        expected = -1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForMaxAndMinValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '-');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '-');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionForDoubleNegativeInfinityAndPositiveInfinityA_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, '-');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '-');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '*');
        expected = 100.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '*');
        expected = 25.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '*');
        expected = -25;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '*');
        expected = 5.9E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '*');
        expected = -5.9E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplicationForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '/');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '/');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '/');
        expected = -1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(7, 0, '/'));
    }

    @Test
    void calculateDivisionForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '/');
        expected = 1.4980776123852632E307;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '/');
        expected = -1.4980776123852632E307;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '/');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '/');
        expected = -0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForMaxAndMinValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivisionForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingPositiveValueToThePositivePower_Ok() {
        actual = calculator.calculate(2, 2, '^');
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingPositiveValueToTheNegativePower_Ok() {
        actual = calculator.calculate(2, -2, '^');
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(-2, 2, '^');
        expected = 4.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(-2, -2, '^');
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingPositiveValueToZeroPower_Ok() {
        actual = calculator.calculate(2, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(-2, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingZeroToPower_Ok() {
        actual = calculator.calculate(0, 2, '^');
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingZeroToZeroPower_Ok() {
        actual = calculator.calculate(0, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateWithIllegalOperator_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(2, 0, '%'));
    }
}
