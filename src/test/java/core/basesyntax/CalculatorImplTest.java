package core.basesyntax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorImplTest {
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
    calculator = new CalculatorImpl();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        expected = 0.152438 + 124.093161;
        actual = calculator.calculate(0.152438, 124.093161, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, 0.01, '+'));
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        expected = - 53.343 - 0.3456;
        actual = calculator.calculate(-53.343, -0.3456, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(-0.0001, -Double.MAX_VALUE, '+'));
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        expected = 104.4567 - 567.042345;
        actual = calculator.calculate(104.4567, -567.042345, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754 + 0;
        actual = calculator.calculate(0.09754, 0, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroAndNegativeOperands_Ok() {
        expected = 0 - 213.9621;
        actual = calculator.calculate(0, - 213.9621, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMinDoubleOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+'));
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        expected = 0.152438 - 124.093161;
        actual = calculator.calculate(0.152438, 124.093161, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        expected = 0.3456 - 53.343;
        actual = calculator.calculate(- 53.343, - 0.3456, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 104.4567 + 567.042345;
        actual = calculator.calculate(104.4567, - 567.042345, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithMaxPositiveAndNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, -0.0001, '-'));
    }

    @Test
    void calculate_subtractionWithPositiveAndMaxNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(0.0001, -Double.MAX_VALUE, '-'));
    }

    @Test
    void calculate_subtractionWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754 - 0;
        actual = calculator.calculate(0.09754, 0, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroAndNegativeOperands_Ok() {
        expected = 0 + 213.9621;
        actual = calculator.calculate(0, - 213.9621, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMaxAndMinDoubleOperands_Ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        expected = 0.152438 * 124.093161;
        actual = calculator.calculate(0.152438, 124.093161, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, 2.13, '*'));
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        expected = - 53.343 * (- 0.3456);
        actual = calculator.calculate(-53.343, -0.3456, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(-52.24, -Double.MAX_VALUE, '*'));
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        expected = 104.4567 * (- 567.042345);
        actual = calculator.calculate(104.4567, -567.042345, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndZeroOperands_Ok() {
        expected = 0.09754 * 0;
        actual = calculator.calculate(0.09754, 0, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroAndNegativeOperands_Ok() {
        expected = 0 * (- 213.9621);
        actual = calculator.calculate(0, - 213.9621, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxAndMinDoubleOperands_Ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }


}