package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.000001;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '+');
        expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    void additionWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '+');
        expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '+');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '+');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void additionForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '+');
        expected = 12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '+');
        expected = -12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = 1.0E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
                '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void additionForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '+');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void additionForDoubleNegativeInfinityAndPositiveInfinityA_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, '+');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void additionForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '+');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '-');
        expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '-');
        expected = -7;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '-');
        expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '-');
        expected = -12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '-');
        expected = 12.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        expected = -1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMaxAndMinValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '-');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '-');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForDoubleNegativeInfinityAndPositiveInfinityA_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, '-');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '-');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '*');
        expected = 100.0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '*');
        expected = 25.0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '*');
        expected = -25;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithSecondZeroValue_Ok() {
        actual = calculator.calculate(7, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithBothZeroValues_Ok() {
        actual = calculator.calculate(0, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '*');
        expected = 5.9E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '*');
        expected = -5.9E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWith2PositiveOperands_Ok() {
        actual = calculator.calculate(10, 10, '/');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWith2NegativeOperands_Ok() {
        actual = calculator.calculate(-5, -5, '/');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-5, 5, '/');
        expected = -1.0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithFirstZeroValue_Ok() {
        actual = calculator.calculate(0, 7, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(7, 0, '/'));
    }

    @Test
    void divisionForMaxDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, 12, '/');
        expected = 1.4980776123852632E307;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForMaxDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, -12, '/');
        expected = -1.4980776123852632E307;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForBothDoubleMaxValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForMinDoubleValueAndPositiveValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, 12, '/');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForMinDoubleValueAndNegativeValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, -12, '/');
        expected = -0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForBothDoubleMinValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForMinAndMaxValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForMaxAndMinValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionForBothDoublePositiveInfinities_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void divisionForDoublePositiveInfinityAndNegativeInfinity_Ok() {
        actual = calculator.calculate(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void divisionForBothDoubleNegativeInfinities_Ok() {
        actual = calculator.calculate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        actual = calculator.calculate(2, 2, '^');
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() {
        actual = calculator.calculate(2, -2, '^');
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(-2, 2, '^');
        expected = 4.0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(-2, -2, '^');
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        actual = calculator.calculate(2, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(-2, 0, '^');
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        actual = calculator.calculate(0, 2, '^');
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToZeroPower_Ok() {
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
