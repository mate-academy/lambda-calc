package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double DELTA = 0.0001;
    private static Calculator positives;
    private static Calculator negatives;
    private static Calculator maxPositiveAndPositive;
    private static Calculator negativeAndMaxNegative;
    private static Calculator positiveAndNegative;
    private static Calculator positiveAndZero;
    private static Calculator zeroAndNegative;
    private static Calculator positivesMaxAndMin;
    private static Calculator maxPositiveAndNegative;
    private static Calculator positiveAndMaxNegative;
    private static Calculator negativeAndPositive;
    private static Calculator negativeAndZero;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        positives = new CalculatorImpl(0.1524, 124.0931);
        negatives = new CalculatorImpl(- 53.343, - 0.3456);
        maxPositiveAndPositive = new CalculatorImpl(Double.MAX_VALUE, 104.01);
        negativeAndMaxNegative = new CalculatorImpl(- 53.0001, - Double.MAX_VALUE);
        positiveAndNegative = new CalculatorImpl(104.4567, - 56.042345);
        negativeAndPositive = new CalculatorImpl(- 567.042345, 104.4567);
        positiveAndZero = new CalculatorImpl(0.09754, 0);
        negativeAndZero = new CalculatorImpl(- 53.343, 0);
        zeroAndNegative = new CalculatorImpl(0, - 213.9621);
        positivesMaxAndMin = new CalculatorImpl(Double.MAX_VALUE, Double.MIN_VALUE);
        maxPositiveAndNegative = new CalculatorImpl(Double.MAX_VALUE, - 7.0123);
        positiveAndMaxNegative = new CalculatorImpl(21.0001, - Double.MAX_VALUE);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        expected = 124.2455;
        actual = positives.calculate('+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                maxPositiveAndPositive.calculate('+'));
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        expected = - 53.6886;
        actual = negatives.calculate('+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                negativeAndMaxNegative.calculate('+'));
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        expected = 48.414355;
        actual = positiveAndNegative.calculate('+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754;
        actual = positiveAndZero.calculate('+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroAndNegativeOperands_Ok() {
        expected = - 213.9621;
        actual = zeroAndNegative.calculate('+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxAndMinDoubleOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                positivesMaxAndMin.calculate('+'));
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        expected = - 123.9407;
        actual = positives.calculate('-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        expected = - 52.9974;
        actual = negatives.calculate('-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 160.499045;
        actual = positiveAndNegative.calculate('-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMaxPositiveAndNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                maxPositiveAndNegative.calculate('-'));
    }

    @Test
    void calculate_subtractionWithPositiveAndMaxNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                positiveAndMaxNegative.calculate('-'));
    }

    @Test
    void calculate_subtractionWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754;
        actual = positiveAndZero.calculate('-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroAndNegativeOperands_Ok() {
        expected = 213.9621;
        actual = zeroAndNegative.calculate('-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxAndMinDoubleOperands_Ok() {
        expected = 1.7976931348623157E308;
        actual = positivesMaxAndMin.calculate('-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        expected = 18.9118;
        actual = positives.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                maxPositiveAndPositive.calculate('*'));
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        expected = 18.4353;
        actual = negatives.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                negativeAndMaxNegative.calculate('*'));
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        expected = - 5853.9984;
        actual = positiveAndNegative.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndZeroOperands_Ok() {
        expected = 0.0;
        actual = positiveAndZero.calculate('*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroAndNegativeOperands_Ok() {
        expected = - 0.0;
        actual = zeroAndNegative.calculate('*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxAndMinDoubleOperands_Ok() {
        expected = 8.8818E-16;
        actual = positivesMaxAndMin.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_Ok() {
        expected = 0.0012;
        actual = positives.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        expected = 154.349;
        actual = negatives.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        expected = - 1.8639;
        actual = positiveAndNegative.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMaxPositiveAndNegativeOperands_Ok() {
        expected = - 2.5636283884921006E307;
        actual = maxPositiveAndNegative.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndMaxNegativeOperands_Ok() {
        expected = - 1.1682E-307;
        actual = positiveAndMaxNegative.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                positiveAndZero.calculate('/'));
    }

    @Test
    void calculate_divisionWithZeroAndNegativeOperands_Ok() {
        expected = - 0.0;
        actual = zeroAndNegative.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionMaxAndMinDoubleOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                positivesMaxAndMin.calculate('/'));
    }

    @Test
    void calculate_raisingPositiveToPositivePower_Ok() {
        expected = 4.112E-102;
        actual = positives.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingMaxPositiveToPositivePower_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                maxPositiveAndPositive.calculate('^'));
    }

    @Test
    void calculate_raisingNegativeToPositivePower_Ok() {
        assertThrows(ArithmeticException.class, () ->
                negativeAndPositive.calculate('^'));
    }

    @Test
    void calculate_raisingNegativeToNegativePower_Ok() {
        assertThrows(ArithmeticException.class, () ->
                negatives.calculate('^'));
    }

    @Test
    void calculate_raisingPositiveToNegativePower_Ok() {
        expected = 7.1462E-114;
        actual = positiveAndNegative.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToZeroPower_Ok() {
        expected = 1.0;
        actual = negativeAndZero.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZeroPower_Ok() {
        expected = 1.0;
        actual = positiveAndZero.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroAndNegativePower_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                zeroAndNegative.calculate('^'));
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () ->
                positiveAndNegative.calculate('%'));
    }
}
