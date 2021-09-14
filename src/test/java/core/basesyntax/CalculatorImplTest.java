package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        expected = 124.2455;
        actual = calculator.calculate(0.1524, 124.0931, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, 104.01, '+'));
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        expected = - 53.6886;
        actual = calculator.calculate(- 53.343, - 0.3456, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(- 53.0001, - Double.MAX_VALUE, '+'));
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        expected = 48.414355;
        actual = calculator.calculate(104.4567, - 56.042345, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754;
        actual = calculator.calculate(0.09754, 0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroAndNegativeOperands_Ok() {
        expected = - 213.9621;
        actual = calculator.calculate(0, - 213.9621, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxAndMinDoubleOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+'));
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        expected = - 123.9407;
        actual = calculator.calculate(0.1524, 124.0931,'-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        expected = - 52.9974;
        actual = calculator.calculate(- 53.343, - 0.3456, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 160.499045;
        actual = calculator.calculate(104.4567, - 56.042345, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMaxPositiveAndNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, - 7.0123, '-'));
    }

    @Test
    void calculate_subtractionWithPositiveAndMaxNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(21.0001, - Double.MAX_VALUE, '-'));
    }

    @Test
    void calculate_subtractionWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754;
        actual = calculator.calculate(0.09754, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroAndNegativeOperands_Ok() {
        expected = 213.9621;
        actual = calculator.calculate(0, - 213.9621, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxAndMinDoubleOperands_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        expected = 18.9118;
        actual = calculator.calculate(0.1524, 124.0931,'*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, 104.01, '*'));
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        expected = 18.4353;
        actual = calculator.calculate(- 53.343, - 0.3456, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(- 53.0001, - Double.MAX_VALUE, '*'));
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        expected = - 5853.9984;
        actual = calculator.calculate(104.4567, - 56.042345, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndZeroOperands_Ok() {
        expected = 0.0;
        actual = calculator.calculate(0.09754, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroAndNegativeOperands_Ok() {
        expected = - 0.0;
        actual = calculator.calculate(0, - 213.9621, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxAndMinDoubleOperands_Ok() {
        expected = 8.8818E-16;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_Ok() {
        expected = 0.0012;
        actual = calculator.calculate(0.1524, 124.0931, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        expected = 154.349;
        actual = calculator.calculate(- 53.343, - 0.3456, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        expected = - 1.8639;
        actual = calculator.calculate(104.4567, - 56.042345, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMaxPositiveAndNegativeOperands_Ok() {
        expected = - 2.5636283884921006E307;
        actual = calculator.calculate(Double.MAX_VALUE, - 7.0123, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndMaxNegativeOperands_Ok() {
        expected = - 1.1682E-307;
        actual = calculator.calculate(21.0001, - Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(0.09754, 0, '/'));
    }

    @Test
    void calculate_divisionWithZeroAndNegativeOperands_Ok() {
        expected = - 0.0;
        actual = calculator.calculate(0, - 213.9621, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionMaxAndMinDoubleOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/'));
    }

    @Test
    void calculate_raisingPositiveToPositivePower_Ok() {
        expected = 4.112E-102;
        actual = calculator.calculate(0.1524, 124.0931, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingMaxPositiveToPositivePower_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, 104.01, '^'));
    }

    @Test
    void calculate_raisingNegativeToPositivePower_Ok() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(- 567.042345, 104.4567, '^'));
    }

    @Test
    void calculate_raisingNegativeToNegativePower_Ok() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(- 53.343, - 0.3456, '^'));
    }

    @Test
    void calculate_raisingPositiveToNegativePower_Ok() {
        expected = 7.1462E-114;
        actual = calculator.calculate(104.4567, - 56.042345, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToZeroPower_Ok() {
        expected = 1.0;
        actual = calculator.calculate(- 53.343, 0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZeroPower_Ok() {
        expected = 1.0;
        actual = calculator.calculate(0.09754, 0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroAndNegativePower_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(0, - 213.9621, '^'));
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(104.4567, - 56.042345, '%'));
    }
}
