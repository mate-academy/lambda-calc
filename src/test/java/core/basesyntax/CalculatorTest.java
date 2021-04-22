package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char DIVISION_OPERATOR = '/';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char RAISE_TO_POWER_OPERATOR = '^';
    private static final char ILLEGAL_OPERATOR = '$';
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private static double actual;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(7.33, 13.66, ADDITION_OPERATOR);
        expected = 20.99;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-7.33, -13.66, ADDITION_OPERATOR);
        expected = -20.99;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveAndNegativeNumbers_isOk() {
        actual = calculator.calculate(7.33, -13.66, ADDITION_OPERATOR);
        expected = -6.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithNull_isOk() {
        actual = calculator.calculate(0.0, 123.45, ADDITION_OPERATOR);
        expected = 123.45;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMinValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, 7.33, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 7.33, ADDITION_OPERATOR);
        expected = 7.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(7.33, 13.66, SUBTRACTION_OPERATOR);
        expected = -6.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-7.33, -13.66, SUBTRACTION_OPERATOR);
        expected = 6.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeNumbers_isOk() {
        actual = calculator.calculate(7.33, -13.66, SUBTRACTION_OPERATOR);
        expected = 20.99;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithNull_isOk() {
        actual = calculator.calculate(7.33, 0.0, SUBTRACTION_OPERATOR);
        expected = 7.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMaxAndMinValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, 7.33, SUBTRACTION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 7.33, SUBTRACTION_OPERATOR);
        expected = -7.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(7.33, 13.66, DIVISION_OPERATOR);
        expected = 0.5366;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-7.33, -13.66, DIVISION_OPERATOR);
        expected = 0.5366;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeNumbers_isOk() {
        actual = calculator.calculate(7.33, -13.66, DIVISION_OPERATOR);
        expected = -0.5366;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionOfNull_isOk() {
        actual = calculator.calculate(0.0, 7.33, DIVISION_OPERATOR);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionByNull_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(7.33, 0.0, DIVISION_OPERATOR));
    }

    @Test
    void calculate_divisionMaxAndMinValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, 7.33, DIVISION_OPERATOR);
        expected = 2.45251450867983E307;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 7.33, DIVISION_OPERATOR);
        expected = 3.5E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(7.33, 13.66, MULTIPLICATION_OPERATOR);
        expected = 100.1278;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(-7.33, -13.66, MULTIPLICATION_OPERATOR);
        expected = 100.1278;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeNumbers_isOk() {
        actual = calculator.calculate(7.33, -13.66, MULTIPLICATION_OPERATOR);
        expected = -100.1278;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithNull_Ok_isOk() {
        actual = calculator.calculate(0.0, 123.45, MULTIPLICATION_OPERATOR);
        expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxAndMinValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, 7.33, MULTIPLICATION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 7.33, MULTIPLICATION_OPERATOR);
        expected = 3.5E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingValueToPositivePower_isOk() {
        actual = calculator.calculate(1.5, 3.5, RAISE_TO_POWER_OPERATOR);
        expected = 4.1335;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingValueToNegativePower_isOk() {
        actual = calculator.calculate(1.5, -3.5, RAISE_TO_POWER_OPERATOR);
        expected = 0.2419;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToFractionalPower_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(-1.5, -3.5, RAISE_TO_POWER_OPERATOR));
    }

    @Test
    void calculate_raisingValueToZeroPower_isOk() {
        actual = calculator.calculate(1.5, 0.0, RAISE_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-1.5, 0.0, RAISE_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_isOk() {
        actual = calculator.calculate(0.0, 7.33, RAISE_TO_POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0.0, -7.33, RAISE_TO_POWER_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegalOperations_notOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(7.33, 13.66, ILLEGAL_OPERATOR));
    }
}
