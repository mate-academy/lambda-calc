package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.00001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char EXPONENTIATION = '^';
    private static final double POSITIVE_NUMBER = 2.5;
    private static final double NEGATIVE_NUMBER = -1.5;
    private static Calculator calculator;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        assertEquals(5.0, actual);
    }

    @Test
    void calculate_additionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        assertEquals(-3.0, actual);
    }

    @Test
    void calculate_additionNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_additionWithZero_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, 0.0, ADDITION);
        assertEquals(POSITIVE_NUMBER, actual);
        actual = calculator.calculate(0.0, NEGATIVE_NUMBER, ADDITION);
        assertEquals(NEGATIVE_NUMBER, actual);
    }

    @Test
    void calculate_additionMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, ADDITION);
        assertEquals(POSITIVE_NUMBER, actual);
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        assertEquals(Double.MAX_VALUE, actual);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_subtractionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_subtractionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_subtractionNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(-4.0, actual);
        actual = calculator.calculate(.000049, -0.00005, SUBTRACTION);
        assertEquals(0.00009, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZero_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, 0.0, SUBTRACTION);
        assertEquals(POSITIVE_NUMBER, actual);
    }

    @Test
    void calculate_subtractionMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(-POSITIVE_NUMBER, actual);
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(Double.MAX_VALUE, actual);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void calculate_multiplicationTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        assertTrue(actual > 0);
        assertEquals(6.25, actual);
    }

    @Test
    void calculate_multiplicationTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertTrue(actual > 0);
        assertEquals(2.25, actual);
    }

    @Test
    void calculate_multiplicationNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        assertTrue(actual < 0);
        assertEquals(-3.75, actual);
    }

    @Test
    void calculate_multiplicationWithZero_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, 0.0, MULTIPLICATION);
        assertEquals(0.0, actual);
        actual = calculator.calculate(0.0, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(-0.0, actual);
    }

    @Test
    void calculate_multiplicationMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(8.881784197001251E-16, actual);
    }

    @Test
    void calculate_multiplicationMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(Double.NEGATIVE_INFINITY, actual);
    }

    @Test
    void calculate_multiplicationMinDoubleValue_isNotOk() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        assertNotEquals(Double.MIN_VALUE, actual);
        actual = calculator.calculate(Double.MIN_VALUE, NEGATIVE_NUMBER, MULTIPLICATION);
        assertNotEquals(-Double.MIN_VALUE, actual);
    }

    @Test
    void calculate_divisionTwoPositiveNumbers_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        assertTrue(actual > 0);
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_divisionTwoNegativeNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertTrue(actual > 0);
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_divisionNegativeAndPositiveNumbers_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        assertTrue(actual < 0);
        assertEquals(-0.6, actual);
    }

    @Test
    void calculate_divisionWithZero_isOk() {
        actual = calculator.calculate(0, POSITIVE_NUMBER, DIVISION);
        assertEquals(0.0, actual);
        actual = calculator.calculate(0, NEGATIVE_NUMBER, DIVISION);
        assertEquals(-0.0, actual);
    }

    @Test
    void calculate_exceptionForDivisionByZero_isThrown() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(10.0, 0.0, DIVISION));
    }

    @Test
    void calculate_divisionMinAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_divisionByMaxDoubleValue_isNotOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, Double.MAX_VALUE, DIVISION);
        assertNotEquals(Double.MIN_VALUE, actual);
        assertNotEquals(0.0, actual);
    }

    @Test
    void calculate_divisionByMinDoubleValue_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, Double.MIN_VALUE, DIVISION);
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(NEGATIVE_NUMBER, Double.MIN_VALUE, DIVISION);
        assertEquals(Double.NEGATIVE_INFINITY, actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeNumberToPositivePower_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, 3.0, EXPONENTIATION);
        assertEquals(15.625, actual);
        actual = calculator.calculate(NEGATIVE_NUMBER, 3.0, EXPONENTIATION);
        assertEquals(-3.375, actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeNumberToNegativePower_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, -2.0, EXPONENTIATION);
        assertEquals(0.16, actual);
        actual = calculator.calculate(NEGATIVE_NUMBER, -2.0, EXPONENTIATION);
        assertEquals(0.44444, actual, DELTA);
    }

    @Test
    void calculate_exceptionForRaisingNegativeNumberToFractionalPower_isThrown() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, EXPONENTIATION));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, EXPONENTIATION));
    }

    @Test
    void calculate_raisingPositiveAndNegativeNumberToZero_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, 0.0, EXPONENTIATION);
        assertTrue(actual == 1);
        actual = calculator.calculate(NEGATIVE_NUMBER, 0.0, EXPONENTIATION);
        assertTrue(actual == 1);
    }

    @Test
    void calculate_raisingZeroToPositivePower_isOk() {
        actual = calculator.calculate(0.0, POSITIVE_NUMBER, EXPONENTIATION);
        assertTrue(actual == 0.0);
    }

    @Test
    void calculate_exceptionForRaisingZeroToNegativePower_isThrown() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(0.0, NEGATIVE_NUMBER, EXPONENTIATION));
    }

    @Test
    void calculate_exceptionForIllegalOperation_isThrown() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, 'b'));
    }
}
