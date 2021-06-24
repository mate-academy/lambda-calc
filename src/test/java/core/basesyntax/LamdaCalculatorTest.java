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
    private static final char MULTIPLIKATION = '*';
    private static final char RAISING = '^';
    private static LamdaCalculator lamdaCalculator;

    @BeforeAll
    static void beforeAll() {
        lamdaCalculator = new LamdaCalculator();
    }

    @Test
    void calculating_sumOfTwoPositive_Ok() {
        double expected = 550.1;
        double actual = lamdaCalculator.calculate(50, 500.1, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_sumOfTwoNegative_Ok() {
        double expected = -60.6;
        double actual = lamdaCalculator.calculate(-20.2, -40.4, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_sumOfDifferent_Ok() {
        double expected = 40.6;
        double actual = lamdaCalculator.calculate(60.8, -20.2, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_additionWithZeroFirst_Ok() {
        double expected = 88.8;
        double actual = lamdaCalculator.calculate(0, 88.8, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_additionWithZeroSecond_Ok() {
        double expected = 60.8;
        double actual = lamdaCalculator.calculate(60.8, 0, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_additionMaxValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_additionMinValues_Ok() {
        double expected = 1.0E-323;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_subOfTwoPositive_Ok() {
        double expected = -450.1;
        double actual = lamdaCalculator.calculate(50, 500.1, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_subOfTwoNegative_Ok() {
        double expected = 20.2;
        double actual = lamdaCalculator.calculate(-20.2, -40.4, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_subOfDifferent_Ok() {
        double expected = 81;
        double actual = lamdaCalculator.calculate(60.8, -20.2, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_substractionWithZeroFirst_Ok() {
        double expected = -88.8;
        double actual = lamdaCalculator.calculate(0, 88.8, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_substractionWithZeroSecond_Ok() {
        double expected = 60.8;
        double actual = lamdaCalculator.calculate(60.8, 0, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_substractionMaxValues_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_substractionMinValues_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_divisionOfTwoPositive_Ok() {
        double expected = 10;
        double actual = lamdaCalculator.calculate(502, 50.2, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_divisionOfTwoNegative_Ok() {
        double expected = 0.5;
        double actual = lamdaCalculator.calculate(-20.2, -40.4, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_divisionOfDifferent_Ok() {
        double expected = -3;
        double actual = lamdaCalculator.calculate(-60, 20, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_divisionWithZeroFirst_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(0, 88.8, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_divisionWithZeroSecond_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                lamdaCalculator.calculate(50.5, 0, DIVISION));
    }

    @Test
    void calculating_divisionMaxValues_Ok() {
        double expected = 1;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_divisionMinValues_Ok() {
        double expected = 1;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_multiplicationOfTwoPositive_Ok() {
        double expected = 100;
        double actual = lamdaCalculator.calculate(10, 10, MULTIPLIKATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_multiplicationOfTwoNegative_Ok() {
        double expected = 100;
        double actual = lamdaCalculator.calculate(-10, -10, MULTIPLIKATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_multiplicationOfTwoDifferent_Ok() {
        double expected = -100;
        double actual = lamdaCalculator.calculate(10, -10, MULTIPLIKATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_multiplicationWithZeroFirst_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(0, 88.8, MULTIPLIKATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_multiplicationWithZeroSecond_NotOk() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(88.8, 0, MULTIPLIKATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_multiplicationMaxValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                MULTIPLIKATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_multiplicationMinValues_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                MULTIPLIKATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingOfTwoPositive_Ok() {
        double expected = 1.0E10;
        double actual = lamdaCalculator.calculate(10, 10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingOfTwoNegative_Ok() {
        double expected = 1.0E-10;
        double actual = lamdaCalculator.calculate(-10, -10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingOfsecondNegative_Ok() {
        double expected = 1.0E-10;
        double actual = lamdaCalculator.calculate(10, -10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingOfFirstNegative_Ok() {
        double expected = 1.0E10;
        double actual = lamdaCalculator.calculate(-10, 10, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingWithZeroFirst_Ok() {
        double expected = 0;
        double actual = lamdaCalculator.calculate(0, 88.8, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingWithZeroSecond_NotOk() {
        double expected = 1;
        double actual = lamdaCalculator.calculate(88.8, 0, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingMaxValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = lamdaCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculating_raisingMinValues_Ok() {
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
