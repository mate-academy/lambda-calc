package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char RAISING = '^';
    private static Calculation calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositive_Ok() {
        expected = 25.7;
        actual = calculator.calculate(15.7, 10, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegative_Ok() {
        expected = -35.5;
        actual = calculator.calculate(-15.5, -20, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirstPositiveAndSecondNegative_Ok() {
        expected = -15.4675;
        actual = calculator.calculate(20, -35.4675, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithSecondPositiveAndFirstNegative_Ok() {
        expected = 15.4675;
        actual = calculator.calculate(-20, 35.4675, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_Ok() {
        expected = -35.4675;
        actual = calculator.calculate(0, -35.4675, PLUS);
        assertEquals(expected, actual);
        expected = 715.7549;
        actual = calculator.calculate(715.7549, 0, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMinAndMaxInDifferentPlaces_Ok() {
        expected = MAX_VALUE;
        actual = calculator.calculate(MAX_VALUE, MIN_VALUE, PLUS);
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(MIN_VALUE, MIN_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(MAX_VALUE, MAX_VALUE, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoPositive_Ok() {
        expected = 100;
        actual = calculator.calculate(134.5, 34.5, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegatives_Ok() {
        expected = 10.9984317;
        actual = calculator.calculate(-0.45789, -11.4563218, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithFirstPositiveAndSecondNegative_Ok() {
        expected = 10.45789;
        actual = calculator.calculate(0.45789, -10, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondPositiveAndFirstNegative_Ok() {
        expected = -10.45789;
        actual = calculator.calculate(-0.45789, 10, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_Ok() {
        expected = 0.45789;
        actual = calculator.calculate(0.45789, 0, MINUS);
        assertEquals(expected, actual);
        expected = -25.7861488;
        actual = calculator.calculate(0, 25.7861488, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMinAndMaxInDifferentPlaces_Ok() {
        expected = 0;
        actual = calculator.calculate(MAX_VALUE, MAX_VALUE, MINUS);
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(MIN_VALUE, MIN_VALUE, MINUS);
        assertEquals(expected, actual);
        expected = MAX_VALUE;
        actual = calculator.calculate(MAX_VALUE, MIN_VALUE, MINUS);
        assertEquals(expected, actual);
        expected = Double.NEGATIVE_INFINITY;
        actual = calculator.calculate(-MAX_VALUE, MAX_VALUE, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoPosistive_Ok() {
        expected = 10;
        actual = calculator.calculate(100.00001, 10, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegatives_Ok() {
        expected = 1.3539;
        actual = calculator.calculate(-45,-33.2355, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithFirstPositiveAndSecondNegative_Ok() {
        expected = -4.4444;
        actual = calculator.calculate(200, -45, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWitSecondPositiveAndFirstNegative_Ok() {
        expected = -4.4444;
        actual = calculator.calculate(-200, 45, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroInFirstValue_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 43, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroInSecondValue_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(789, 0, DIVIDE);
        });
    }

    @Test
    void calculate_divisionWithMinAndMaxInDifferentPlaces_Ok() {
        expected = 1;
        actual = calculator.calculate(MAX_VALUE, MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);
        expected = 1;
        actual = calculator.calculate(MIN_VALUE, MIN_VALUE, DIVIDE);
        assertEquals(expected, actual);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(MAX_VALUE, MIN_VALUE, DIVIDE);
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(MIN_VALUE, MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositive_Ok() {
        expected = 100500;
        actual = calculator.calculate(10.05, 10000, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoNegative_Ok() {
        expected = 100500;
        actual = calculator.calculate(-1005, -100, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstPositiveAndSecondNegative_Ok() {
        expected = -45600;
        actual = calculator.calculate(456, -100, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondPositiveAndFirstNegative_Ok() {
        expected = -45600;
        actual = calculator.calculate(-456, 100, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 100, MULTIPLY);
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(45698, 0, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMinAndMaxInDifferentPlaces_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(MAX_VALUE, MAX_VALUE, MULTIPLY);
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(MIN_VALUE, MIN_VALUE, MULTIPLY);
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(MAX_VALUE, MIN_VALUE, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToPositive_Ok() {
        expected = 10;
        actual = calculator.calculate(10, 1, RAISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveToNegative_Ok() {
        expected = 0;
        actual = calculator.calculate(10, -45.48, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToPositive_Ok() {
        expected = 100;
        actual = calculator.calculate(-10, 2, RAISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeToNegative_Ok() {
        expected = 0;
        actual = calculator.calculate(-10, -7, RAISING);
        assertEquals(expected, actual, DELTA);
        expected = 0.0039;
        actual = calculator.calculate(-2, -8, RAISING);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZero_Ok() {
        expected = 1;
        actual = calculator.calculate(57, 0, RAISING);
        assertEquals(expected, actual);

    }

    @Test
    void calculate_raisingNegativeToZero_Ok() {
        expected = 1;
        actual = calculator.calculate(-78, 0, RAISING);
        assertEquals(expected, actual);

    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 7, RAISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(0, 0, '&');
        });
    }
}
