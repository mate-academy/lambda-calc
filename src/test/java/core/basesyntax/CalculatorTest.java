package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double POSITIVE_ARGUMENT = 1354.0345;
    private static final double NEGATIVE_ARGUMENT = -343.7453;
    private static final double ONE = 1.0;
    private static final double ZERO = 0.0;
    private static final double DELTA = 0.0001;
    private static final char ILLEGAL_OPERATOR_SYMBOL = '#';
    private static final char ILLEGAL_OPERATOR_LETTER = 'a';
    private static final char ILLEGAL_OPERATOR_DIGIT = '1';
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addition_TwoPositiveArguments_Ok() {
        expected = POSITIVE_ARGUMENT + POSITIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void addition_TwoNegativeArguments_Ok() {
        expected = NEGATIVE_ARGUMENT + NEGATIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, NEGATIVE_ARGUMENT, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void addition_MixedArguments_Ok() {
        expected = POSITIVE_ARGUMENT + NEGATIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, NEGATIVE_ARGUMENT, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = NEGATIVE_ARGUMENT + POSITIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, POSITIVE_ARGUMENT, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void addition_MaxValue_Ok() {
        expected = Double.MAX_VALUE + ONE;
        actual = calculator.calculate(Double.MAX_VALUE, ONE, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void addition_MinValue_Ok() {
        expected = Double.MIN_VALUE + ONE;
        actual = calculator.calculate(Double.MIN_VALUE, ONE, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void addition_WithZero_Ok() {
        expected = POSITIVE_ARGUMENT + ZERO;
        actual = calculator.calculate(POSITIVE_ARGUMENT, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = NEGATIVE_ARGUMENT + ZERO;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO + POSITIVE_ARGUMENT;
        actual = calculator.calculate(ZERO, POSITIVE_ARGUMENT, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO + NEGATIVE_ARGUMENT;
        actual = calculator.calculate(ZERO, NEGATIVE_ARGUMENT, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO + ZERO;
        actual = calculator.calculate(ZERO, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA, "Addition isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void subtraction_TwoPositiveArguments_Ok() {
        expected = POSITIVE_ARGUMENT - POSITIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void subtraction_TwoNegativeArguments_Ok() {
        expected = NEGATIVE_ARGUMENT - NEGATIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, NEGATIVE_ARGUMENT, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void subtraction_MixedArguments_Ok() {
        expected = POSITIVE_ARGUMENT - NEGATIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, NEGATIVE_ARGUMENT, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = NEGATIVE_ARGUMENT - POSITIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, POSITIVE_ARGUMENT, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void subtraction_MaxValue_Ok() {
        expected = ONE - Double.MAX_VALUE;
        actual = calculator.calculate(ONE, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void subtraction_MinValue_Ok() {
        expected = Double.MIN_VALUE - ONE;
        actual = calculator.calculate(Double.MIN_VALUE, ONE, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void subtraction_WithZero_Ok() {
        expected = POSITIVE_ARGUMENT - ZERO;
        actual = calculator.calculate(POSITIVE_ARGUMENT, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = NEGATIVE_ARGUMENT - ZERO;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO - POSITIVE_ARGUMENT;
        actual = calculator.calculate(ZERO, POSITIVE_ARGUMENT, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO - NEGATIVE_ARGUMENT;
        actual = calculator.calculate(ZERO, NEGATIVE_ARGUMENT, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO - ZERO;
        actual = calculator.calculate(ZERO, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Subtraction isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void multiplication_TwoPositiveArguments_Ok() {
        expected = POSITIVE_ARGUMENT * POSITIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void multiplication_TwoNegativeArguments_Ok() {
        expected = NEGATIVE_ARGUMENT * NEGATIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, NEGATIVE_ARGUMENT, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void multiplication_MixedArguments_Ok() {
        expected = POSITIVE_ARGUMENT * NEGATIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, NEGATIVE_ARGUMENT, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = NEGATIVE_ARGUMENT * POSITIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, POSITIVE_ARGUMENT, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void multiplication_MaxValues_Ok() {
        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void multiplication_MinValues_Ok() {
        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void multiplication_WithZero_Ok() {
        expected = POSITIVE_ARGUMENT * ZERO;
        actual = calculator.calculate(POSITIVE_ARGUMENT, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = NEGATIVE_ARGUMENT * ZERO;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO * POSITIVE_ARGUMENT;
        actual = calculator.calculate(ZERO, POSITIVE_ARGUMENT, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO * NEGATIVE_ARGUMENT;
        actual = calculator.calculate(ZERO, NEGATIVE_ARGUMENT, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = ZERO * ZERO;
        actual = calculator.calculate(ZERO, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Multiplication isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void division_TwoPositiveArguments_Ok() {
        expected = POSITIVE_ARGUMENT / POSITIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, DIVISION);
        assertEquals(expected, actual, DELTA, "Division isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void division_TwoNegativeArguments_Ok() {
        expected = NEGATIVE_ARGUMENT / NEGATIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, NEGATIVE_ARGUMENT, DIVISION);
        assertEquals(expected, actual, DELTA, "Division isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void division_MixedArguments_Ok() {
        expected = POSITIVE_ARGUMENT / NEGATIVE_ARGUMENT;
        actual = calculator.calculate(POSITIVE_ARGUMENT, NEGATIVE_ARGUMENT, DIVISION);
        assertEquals(expected, actual, DELTA, "Division isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = NEGATIVE_ARGUMENT / POSITIVE_ARGUMENT;
        actual = calculator.calculate(NEGATIVE_ARGUMENT, POSITIVE_ARGUMENT, DIVISION);
        assertEquals(expected, actual, DELTA, "Division isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void division_MaxValue_Ok() {
        expected = Double.MIN_VALUE / Double.MAX_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA, "Division isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void division_MinValue_Ok() {
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA, "Division isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void division_WithZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(POSITIVE_ARGUMENT, ZERO, DIVISION));
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(NEGATIVE_ARGUMENT, ZERO, DIVISION));
    }

    @Test
    void power_PositiveArgumentTwoPositivePower_Ok() {
        expected = Math.pow(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT);
        actual = calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, POWER);
        assertEquals(expected, actual, "Rising to power isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void power_NegativeArgumentTwoPositivePower_Ok() {
        expected = Math.pow(NEGATIVE_ARGUMENT, POSITIVE_ARGUMENT);
        actual = calculator.calculate(NEGATIVE_ARGUMENT, POSITIVE_ARGUMENT, POWER);
        assertEquals(expected, actual, "Rising to power isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void power_MixedArguments_Ok() {
        expected = Math.pow(NEGATIVE_ARGUMENT, NEGATIVE_ARGUMENT);
        actual = calculator.calculate(NEGATIVE_ARGUMENT, NEGATIVE_ARGUMENT, POWER);
        assertEquals(expected, actual, "Rising to power isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = Math.pow(POSITIVE_ARGUMENT, NEGATIVE_ARGUMENT);
        actual = calculator.calculate(POSITIVE_ARGUMENT, NEGATIVE_ARGUMENT, POWER);
        assertEquals(expected, actual, "Rising to power isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void power_WithZero_Ok() {
        expected = Math.pow(NEGATIVE_ARGUMENT, ZERO);
        actual = calculator.calculate(NEGATIVE_ARGUMENT, ZERO, POWER);
        assertEquals(expected, actual, "Rising to power isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = Math.pow(POSITIVE_ARGUMENT, ZERO);
        actual = calculator.calculate(POSITIVE_ARGUMENT, ZERO, POWER);
        assertEquals(expected, actual, "Rising to power isn't correct, expected: "
                + expected + " but was: " + actual);

        expected = Math.pow(ZERO, POSITIVE_ARGUMENT);
        actual = calculator.calculate(ZERO, POSITIVE_ARGUMENT, POWER);
        assertEquals(expected, actual, "Rising to power isn't correct, expected: "
                + expected + " but was: " + actual);
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        assertThrows(IllegalOperatorationException.class, () -> {
            calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, ILLEGAL_OPERATOR_SYMBOL);
            calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, ILLEGAL_OPERATOR_LETTER);
            calculator.calculate(POSITIVE_ARGUMENT, POSITIVE_ARGUMENT, ILLEGAL_OPERATOR_DIGIT);
        });
    }
}
