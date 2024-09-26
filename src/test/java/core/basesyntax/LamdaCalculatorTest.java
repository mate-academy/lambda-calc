package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LamdaCalculatorTest {
    private static final double DELTA = 0.0001;
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING = '^';
    private static LamdaCalculator lamdaCalculator;

    @BeforeAll
    static void beforeAll() {
        lamdaCalculator = new LamdaCalculator();
    }

    @Test
    void calculate_sumOfTwoPositive_Ok() {
        double expected = 550.1;
        double actual = lamdaCalculator.calculate(50, 500.1, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumOfTwoNegative_Ok() {
        double expected = -60.6;
        double actual = lamdaCalculator.calculate(-20.2, -40.4, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_sumOfDifferent_Ok() {
        double expected = 40.6;
        double actual = lamdaCalculator.calculate(60.8, -20.2, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroFirst_Ok() {
        double expected = 88.8;
        double actual = lamdaCalculator.calculate(0, 88.8, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroSecond_Ok() {
        double expected = 60.8;
        double actual = lamdaCalculator.calculate(60.8, 0, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinValues_Ok() {
        double expected = 1.0E-323;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subOfTwoPositive_Ok() {
        double expected = -450.1;
        double actual = lamdaCalculator.calculate(50, 500.1, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subOfTwoNegative_Ok() {
        double expected = 20.2;
        double actual = lamdaCalculator.calculate(-20.2, -40.4, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subOfDifferent_Ok() {
        double expected = 81;
        double actual = lamdaCalculator.calculate(60.8, -20.2, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractionWithZeroFirst_Ok() {
        double expected = -88.8;
        double actual = lamdaCalculator.calculate(0, 88.8, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractionWithZeroSecond_Ok() {
        double expected = 60.8;
        double actual = lamdaCalculator.calculate(60.8, 0, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractionMaxValues_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractionMinValues_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfTwoPositive_Ok() {
        double expected = 10;
        double actual = lamdaCalculator.calculate(502, 50.2, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfTwoNegative_Ok() {
        double expected = 0.5;
        double actual = lamdaCalculator.calculate(-20.2, -40.4, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfDifferent_Ok() {
        double expected = -3;
        double actual = lamdaCalculator.calculate(-60, 20, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroFirst_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(0, 88.8, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroSecond_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                lamdaCalculator.calculate(50.5, 0, DIVISION));
    }

    @Test
    void calculate_divisionMaxValues_Ok() {
        double expected = 1;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionMinValues_Ok() {
        double expected = 1;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoPositive_Ok() {
        double expected = 100;
        double actual = lamdaCalculator.calculate(10, 10, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoNegative_Ok() {
        double expected = 100;
        double actual = lamdaCalculator.calculate(-10, -10, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationOfTwoDifferent_Ok() {
        double expected = -100;
        double actual = lamdaCalculator.calculate(10, -10, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroFirst_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(0, 88.8, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroSecond_NotOk() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(88.8, 0, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMinValues_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingOfTwoPositive_Ok() {
        double expected = 1.0E10;
        double actual = lamdaCalculator.calculate(10, 10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingOfTwoNegative_Ok() {
        double expected = 1.0E-10;
        double actual = lamdaCalculator.calculate(-10, -10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingOfsecondNegative_Ok() {
        double expected = 1.0E-10;
        double actual = lamdaCalculator.calculate(10, -10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingOfFirstNegative_Ok() {
        double expected = 1.0E10;
        double actual = lamdaCalculator.calculate(-10, 10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingWithZeroFirst_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(0, 88.8, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingWithZeroSecond_NotOk() {
        double expected = 1;
        double actual = lamdaCalculator.calculate(88.8, 0, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingMaxValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingMinValues_Ok() {
        double expected = 1;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalArgument_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> lamdaCalculator.calculate(10, 50, '$'));
    }
}
