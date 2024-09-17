package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;
    private static final double POSITIVE_NUMBER_1 = 23.4;
    private static final double POSITIVE_NUMBER_2 = 700.5;
    private static final double POSITIVE_NUMBER_3 = 321.45;
    private static final double POSITIVE_NUMBER_4 = 8;
    private static final double POSITIVE_NUMBER_5 = 25;
    private static final double POSITIVE_NUMBER_6 = 2.5;
    private static final double POSITIVE_NUMBER_7 = 4.5;
    private static final double NEGATIVE_NUMBER_1 = -23.4;
    private static final double NEGATIVE_NUMBER_2 = -700.5;
    private static final double NEGATIVE_NUMBER_3 = -8;
    private static final double NEGATIVE_NUMBER_4 = -25;
    private static final double NEGATIVE_NUMBER_5 = -2.5;
    private static final double ZERO_NUMBER = 0;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '+');
        expected = 723.9;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_isOk() {
        expected = -723.9;
        actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_isOk() {
        expected = 677.1;
        actual = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_isOk() {
        expected = POSITIVE_NUMBER_2;
        actual = calculator.calculate(ZERO_NUMBER, POSITIVE_NUMBER_2, '+');
        assertEquals(expected, actual);
        expected = POSITIVE_NUMBER_3;
        actual = calculator.calculate(POSITIVE_NUMBER_3, ZERO_NUMBER, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues_isOk() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '-');
        expected = -677.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_isOk() {
        expected = 677.1;
        actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_isOk() {
        expected = -723.9;
        actual = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_isOk() {
        expected = NEGATIVE_NUMBER_2;
        actual = calculator.calculate(ZERO_NUMBER, POSITIVE_NUMBER_2, '-');
        assertEquals(expected, actual);
        expected = POSITIVE_NUMBER_3;
        actual = calculator.calculate(POSITIVE_NUMBER_3, ZERO_NUMBER, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '*');
        expected = 16391.7;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_isOk() {
        expected = 16391.7;
        actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_isOk() {
        expected = -16391.7;
        actual = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_isOk() {
        expected = ZERO_NUMBER;
        actual = calculator.calculate(ZERO_NUMBER, POSITIVE_NUMBER_2, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER_3, ZERO_NUMBER, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues_isOk() {
        expected = ZERO_NUMBER;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_isOk() {
        expected = 0.32;
        actual = calculator.calculate(POSITIVE_NUMBER_4, POSITIVE_NUMBER_5, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_isOk() {
        expected = 0.32;
        actual = calculator.calculate(NEGATIVE_NUMBER_3, NEGATIVE_NUMBER_4, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_isOk() {
        expected = -0.32;
        actual = calculator.calculate(POSITIVE_NUMBER_4, NEGATIVE_NUMBER_4, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroInDifferentPlaces() {
        expected = ZERO_NUMBER;
        actual = calculator.calculate(ZERO_NUMBER, POSITIVE_NUMBER_5, '/');
        assertEquals(expected, actual);
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(POSITIVE_NUMBER_4, ZERO_NUMBER, '/'));
    }

    @Test
    void calculate_raisingForMinAndMaxDoubleValues() {
        expected = 1;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '^');
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveOrNegativeValueToThePositivePower() {
        expected = 61.763235;
        actual = calculator.calculate(POSITIVE_NUMBER_6, POSITIVE_NUMBER_7, '^');
        assertEquals(expected, actual, DELTA);
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(NEGATIVE_NUMBER_5, POSITIVE_NUMBER_7, '^'));

    }

    @Test
    void calculate_raisingPositiveOrNegativeValueToTheNegativePower() {
        expected = 0.02327;
        actual = calculator.calculate(POSITIVE_NUMBER_7, NEGATIVE_NUMBER_5, '^');
        assertEquals(expected, actual, DELTA);
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(NEGATIVE_NUMBER_5, NEGATIVE_NUMBER_5, '^'));
    }

    @Test
    void calculate_raisingPositiveOrNegativeValueToTheZeroPower() {
        expected = 1;
        actual = calculator.calculate(POSITIVE_NUMBER_7, ZERO_NUMBER, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(NEGATIVE_NUMBER_5, ZERO_NUMBER, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower() {
        expected = ZERO_NUMBER;
        actual = calculator.calculate(ZERO_NUMBER, POSITIVE_NUMBER_7, '^');
        assertEquals(expected, actual);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(ZERO_NUMBER, NEGATIVE_NUMBER_5, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperations_ExceptionOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(ZERO_NUMBER, ZERO_NUMBER, '='));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(ZERO_NUMBER, ZERO_NUMBER, '!'));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(ZERO_NUMBER, ZERO_NUMBER, '$'));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(ZERO_NUMBER, ZERO_NUMBER, '%'));
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(ZERO_NUMBER, ZERO_NUMBER, '('));
    }
}
