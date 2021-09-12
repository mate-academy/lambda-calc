package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorImplTest {
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;
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

    @BeforeAll
    static void beforeAll() {
        positives = new CalculatorImpl(0.152438, 124.093161);
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
        expected = 0.152438 + 124.093161;
        actual = positives.calculate('+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                maxPositiveAndPositive.calculate('+'));
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        expected = - 53.343 - 0.3456;
        actual = negatives.calculate('+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                negativeAndMaxNegative.calculate('+'));
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        expected = 104.4567 - 56.042345;
        actual = positiveAndNegative.calculate('+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754 + 0;
        actual = positiveAndZero.calculate('+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroAndNegativeOperands_Ok() {
        expected = 0 - 213.9621;
        actual = zeroAndNegative.calculate('+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMinDoubleOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                positivesMaxAndMin.calculate('+'));
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        expected = 0.152438 - 124.093161;
        actual = positives.calculate('-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        expected = 0.3456 - 53.343;
        actual = negatives.calculate( '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 104.4567 + 56.042345;
        actual = positiveAndNegative.calculate('-');
        assertEquals(expected, actual, DELTA);
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
        expected = 0.09754 - 0;
        actual = positiveAndZero.calculate('-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroAndNegativeOperands_Ok() {
        expected = 0 + 213.9621;
        actual = zeroAndNegative.calculate('-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMaxAndMinDoubleOperands_Ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = positivesMaxAndMin.calculate('-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        expected = 0.152438 * 124.093161;
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
        expected = - 53.343 * (- 0.3456);
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
        expected = 104.4567 * (- 56.042345);
        actual = positiveAndNegative.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754 * 0;
        actual = positiveAndZero.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroAndNegativeOperands_Ok() {
        expected = 0 * (- 213.9621);
        actual = zeroAndNegative.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxAndMinDoubleOperands_Ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = positivesMaxAndMin.calculate('*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_Ok() {
        expected = 0.152438 / 124.093161;
        actual = positives.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        expected = - 53.343 / (- 0.3456);
        actual = negatives.calculate( '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        expected = 104.4567 / (- 56.042345);
        actual = positiveAndNegative.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMaxPositiveAndNegativeOperands_Ok() {
        expected = Double.MAX_VALUE / (- 7.0123);
        actual = maxPositiveAndNegative.calculate('/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndMaxNegativeOperands_Ok() {
        expected = 21.0001 / (- Double.MAX_VALUE);
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
        expected = 0 / (- 213.9621);
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
        expected = Math.pow(0.152438, 124.093161);
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
        expected = Math.pow(- 567.042345, 104.4567);
        actual = negativeAndPositive.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToNegativePower_Ok() {
        expected = Math.pow(- 53.343, - 0.3456);
        actual = negatives.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToNegativePower_Ok() {
        expected = Math.pow(104.4567, - 56.042345);
        actual = positiveAndNegative.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToZeroPower_Ok() {
        expected = Math.pow(- 53.343, 0);
        actual = negativeAndZero.calculate('^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZeroPower_Ok() {
        expected = Math.pow(0.09754, 0);
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
