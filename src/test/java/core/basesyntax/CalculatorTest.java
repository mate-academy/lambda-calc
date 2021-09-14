package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.00001;
    private static CalculatorService calculatorService;
    private double actual;
    private double expected;

    @BeforeAll
    private static void beforeAll() {
        calculatorService = new Calculator();
    }

    @Test
    void calculate_addTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(10, 5, '+');
        expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-5, -10, '+');
        expected = -15;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addPositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-30, 50, '+');
        expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZero_Ok() {
        actual = calculatorService.calculate(0, 5, '+');
        expected = 5;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(0, 0, '+');
        expected = 0;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(50, 0, '+');
        expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addTwoZeroNumbers_Ok() {
        actual = calculatorService.calculate(0, 0, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = 1.0E-323;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(200, 5, '-');
        expected = 195;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-50, -10, '-');
        expected = -40;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractPositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-30, 50, '-');
        expected = -80;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZero_Ok() {
        actual = calculatorService.calculate(0, 5, '-');
        expected = -5;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(50, 0, '-');
        expected = 50;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(0, 0, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractTwoZeroNumbers_Ok() {
        actual = calculatorService.calculate(0, 0, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(100, 100, '*');
        expected = 10000;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-8, -20, '*');
        expected = 160;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyPositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-40, 40, '*');
        expected = -1600;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZero_Ok() {
        actual = calculatorService.calculate(0, 5, '*');
        expected = 0;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(50, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(0, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoZeroNumbers_Ok() {
        actual = calculatorService.calculate(0, 0, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(100, 10, '/');
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-8, -2, '/');
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_dividePositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-160, 4, '/');
        expected = -40;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideWithZero_Ok() {
        actual = calculatorService.calculate(0, 5, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideWithZero_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, '/'));
    }

    @Test
    void calculate_divideWithTwoZeroValues_Ok() {
        actual = calculatorService.calculate(0, 0, '/');
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisePositiveNumberToPositivePower_Ok() {
        actual = calculatorService.calculate(2, 5, '^');
        expected = 32;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseNegativeNumberToPositivePower_Ok() {
        actual = calculatorService.calculate(-5, 2, '^');
        expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseNegativeNumberToNegativePower_Ok() {
        actual = calculatorService.calculate(-4, -2, '^');
        expected = 0.0625;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingToPowerWithZero_Ok() {
        actual = calculatorService.calculate(0, 5, '^');
        expected = 0;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(50, 0, '^');
        expected = 1;
        assertEquals(expected, actual);
        actual = calculatorService.calculate(0, 0, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeToZeroPower_Ok() {
        actual = calculatorService.calculate(-80, 0, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToNegativePower_Ok() {
        actual = calculatorService.calculate(0, -5, '^');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseMaxNumberToMaxPower_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '^');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseMinNumberToMinPower_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperationType_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, '$'));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, '4'));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, 'h'));
    }
}
