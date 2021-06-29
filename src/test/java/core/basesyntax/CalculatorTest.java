package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final String BAD_ADDITION_MESSAGE = "Wrong addition.";
    private static final String BAD_SUBTRACTION_MESSAGE = "Wrong subtraction.";
    private static final String BAD_MULTIPLY_MESSAGE = "Wrong multiply.";
    private static final String BAD_DIVISION_MESSAGE = "Wrong division.";
    private static final String BAD_POW_MESSAGE = "Wrong pow.";
    private static final double POSITIVE_NUMBER = 2.5;
    private static final double NEGATIVE_NUMBER = -12.01;
    private static final double ZERO = 0;
    private static final double MAX_NUMBER = Double.MAX_VALUE;
    private static final double MIN_NUMBER = Double.MIN_VALUE;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POW = '^';
    private static final char REMAINDER_DIVISION = '%';
    private static Calculator calculator;
    private char operation;
    private double actual;
    private double expected;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionTest() {
        operation = ADDITION;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, operation);
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        assertEquals(actual, expected, BAD_ADDITION_MESSAGE);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_ADDITION_MESSAGE);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_ADDITION_MESSAGE);
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, operation);
        expected = ZERO + NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_ADDITION_MESSAGE);
        actual = calculator.calculate(MAX_NUMBER, MAX_NUMBER, operation);
        expected = MAX_NUMBER + MAX_NUMBER;
        assertEquals(actual, expected, BAD_ADDITION_MESSAGE);
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, operation);
        expected = MAX_NUMBER + MIN_NUMBER;
        assertEquals(actual, expected, BAD_ADDITION_MESSAGE);
    }

    @Test
    void subtractionTest() {
        operation = SUBTRACTION;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, operation);
        expected = ZERO;
        assertEquals(actual, expected, BAD_SUBTRACTION_MESSAGE);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, operation);
        assertEquals(actual, expected, BAD_SUBTRACTION_MESSAGE);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = POSITIVE_NUMBER - NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_SUBTRACTION_MESSAGE);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, operation);
        expected = POSITIVE_NUMBER;
        assertEquals(actual, expected, BAD_SUBTRACTION_MESSAGE);
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, operation);
        expected = MIN_NUMBER - MAX_NUMBER;
        assertEquals(actual, expected, BAD_SUBTRACTION_MESSAGE);
    }

    @Test
    void multiplicationTest() {
        operation = MULTIPLICATION;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, operation);
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(actual, expected, BAD_MULTIPLY_MESSAGE);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_MULTIPLY_MESSAGE);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = POSITIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_MULTIPLY_MESSAGE);
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, operation);
        expected = ZERO;
        assertEquals(actual, expected, BAD_MULTIPLY_MESSAGE);
        actual = calculator.calculate(MAX_NUMBER, MAX_NUMBER, operation);
        expected = MAX_NUMBER * MAX_NUMBER;
        assertEquals(actual, expected, BAD_MULTIPLY_MESSAGE);
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, operation);
        expected = MIN_NUMBER * MAX_NUMBER;
        assertEquals(actual, expected, BAD_MULTIPLY_MESSAGE);
    }

    @Test
    void divisionTest() {
        operation = DIVISION;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, operation);
        expected = 1;
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, operation);
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = POSITIVE_NUMBER / NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, operation));
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, operation);
        expected = MIN_NUMBER / MAX_NUMBER;
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
    }

    @Test
    void remainderDivisionTest() {
        operation = REMAINDER_DIVISION;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, operation);
        expected = ZERO;
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, operation);
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = POSITIVE_NUMBER % NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, operation));
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, operation);
        expected = MIN_NUMBER % MAX_NUMBER;
        assertEquals(actual, expected, BAD_DIVISION_MESSAGE);
    }

    @Test
    void powTest() {
        operation = POW;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, operation);
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(actual, expected, BAD_POW_MESSAGE);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, operation);
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(actual, expected, BAD_POW_MESSAGE);
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, operation);
        expected = Math.pow(ZERO, NEGATIVE_NUMBER);
        assertEquals(actual, expected, BAD_POW_MESSAGE);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, operation);
        expected = Math.pow(POSITIVE_NUMBER, ZERO);
        assertEquals(actual, expected, BAD_POW_MESSAGE);
    }

    @Test
    void illegalOperation() {
        assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1, 2, '@'));
    }
}
