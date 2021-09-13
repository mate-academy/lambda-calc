package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

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
    void calculate_additionWithMinAndMaxInDifferentPlaces_Ok() {
        expected = max;
        actual = calculator.calculate(max, min, '+');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(min, min, '+');
        assertEquals(expected, actual, DELTA);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(max, max, '+');
        assertEquals(expected, actual);
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

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_Ok() {
        expected = 0.45789;
        actual = calculator.calculate(0.45789, 0, '-');
        assertEquals(expected, actual);
        expected = -25.7861488;
        actual = calculator.calculate(0, 25.7861488, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMinAndMaxInDifferentPlaces_Ok() {
        expected = 0;
        actual = calculator.calculate(max, max, '-');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(min, min, '-');
        assertEquals(expected, actual);
        expected = max;
        actual = calculator.calculate(max, min, '-');
        assertEquals(expected, actual);
        expected = Double.NEGATIVE_INFINITY;
        actual = calculator.calculate(-max, max, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoPosistive_Ok() {
        expected = 10;
        actual = calculator.calculate(100.00001, 10, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegatives_Ok() {
        expected = 1.3539;
        actual = calculator.calculate(-45,-33.2355, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegative_Ok() {
        expected = -4.4444;
        actual = calculator.calculate(200, -45, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroInFirstValue_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 43, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroInSecondValue_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(789, 0, '/');
        });
    }

    @Test
    void calculate_divisionWithMinAndMaxInDifferentPlaces_Ok() {
        expected = 1;
        actual = calculator.calculate(max, max, '/');
        assertEquals(expected, actual);
        expected = 1;
        actual = calculator.calculate(min, min, '/');
        assertEquals(expected, actual);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(max, min, '/');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(min, max, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositive_Ok() {
        expected = 100500;
        actual = calculator.calculate(10.05, 10000, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoNegative_Ok() {
        expected = 100500;
        actual = calculator.calculate(-1005, -100, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegative_Ok() {
        expected = -45600;
        actual = calculator.calculate(-456, 100, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 100, '*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(45698, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMinAndMaxInDifferentPlaces_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(max, max, '*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(min, min, '*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(max, min, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToPositive_Ok() {
        expected = 10;
        actual = calculator.calculate(10, 1, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveToNegative_Ok() {
        expected = 0;
        actual = calculator.calculate(10, -45.48, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToPositive_Ok() {
        expected = 100;
        actual = calculator.calculate(-10, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeToNegative_Ok() {
        expected = 0;
        actual = calculator.calculate(-10, -7, '^');
        assertEquals(expected, actual, DELTA);
        expected = 0.0039;
        actual = calculator.calculate(-2, -8, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZero_Ok() {
        expected = 1;
        actual = calculator.calculate(57, 0, '^');
        assertEquals(expected, actual);

    }

    @Test
    void calculate_raisingNefativeToZero_Ok() {
        expected = 1;
        actual = calculator.calculate(-78, 0, '^');
        assertEquals(expected, actual);

    }

    @Test
    void calculate_raisingzeroToPower_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 7, '^');
        assertEquals(expected, actual);

    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, 0, '&');
        });
    }
}
