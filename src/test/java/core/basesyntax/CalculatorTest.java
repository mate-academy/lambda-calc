package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final double max = Double.MAX_VALUE;
    private static final double min = Double.MIN_VALUE;
    private double expected;
    private double actual;
    private final Calculation calculator = new Calculator();


    @Test
    void calculate_additionWithTwoPositive_Ok() {
        expected = 25.7;
        actual = calculator.calculate(15.7, 10, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegative_Ok() {
        expected = -35.5;
        actual = calculator.calculate(-15.5, -20, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegative_Ok() {
        expected = -15.4675;
        actual = calculator.calculate(20, -35.4675, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_Ok() {
        expected = -35.4675;
        actual = calculator.calculate(0, -35.4675, '+');
        assertEquals(expected, actual);
        expected = 715.7549;
        actual = calculator.calculate(715.7549, 0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMinAndMax_Ok() {
        expected = max;
        actual = calculator.calculate(max, min, '+');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(min, min, '+');
        assertEquals(expected, actual,DELTA);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(max, max, '+');
        assertEquals(expected, actual,DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositive_Ok() {
        expected = 100;
        actual = calculator.calculate(134.5, 34.5, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegatives_Ok() {
        expected = 10.9984317;
        actual = calculator.calculate(-0.45789, -11.4563218, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegative_Ok() {
        expected = -10.45789;
        actual = calculator.calculate(-0.45789, 10, '-');
        assertEquals(expected, actual);
    }
}