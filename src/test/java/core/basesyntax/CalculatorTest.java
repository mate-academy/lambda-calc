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
    void calculate_sumOf2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '+');
        expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumOf2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '+');
        expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumOfPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '+');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '+');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SumForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '+');
        expected = 12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '+');
        expected = -12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = 1.0E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
                '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '+');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumForDoubleNegativeInfinityAndPositiveInfinityA_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, '+');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '+');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_sumWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '-');
        expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '-');
        expected = -7;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '-');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '-');
        expected = -12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '-');
        expected = 12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        expected = -1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMaxAndMinValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '-');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '-');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForDoubleNegativeInfinityAndPositiveInfinityA_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, '-');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '-');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '*');
        expected = 100.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '*');
        expected = 25.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '*');
        expected = -25;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '*');
        expected = 5.9E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '*');
        expected = -5.9E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '/');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '/');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '/');
        expected = -1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(7, 0, '/'));
    }

    @Test
    void calculate_divisionForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '/');
        expected = 1.4980776123852632E307;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '/');
        expected = -1.4980776123852632E307;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '/');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '/');
        expected = -0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMaxAndMinValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_Ok() {
        actual = calculator.calculate(2, 2, '^');
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_Ok() {
        actual = calculator.calculate(2, -2, '^');
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(-2, 2, '^');
        expected = 4.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(-2, -2, '^');
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() {
        actual = calculator.calculate(2, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(-2, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        actual = calculator.calculate(0, 2, '^');
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToZeroPower_Ok() {
        actual = calculator.calculate(0, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToNegativePower_Ok() {
        actual = calculator.calculate(0, -2, '^');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_WithIllegalOperator_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator
                .calculate(2, 0, '%'));
    }
}
