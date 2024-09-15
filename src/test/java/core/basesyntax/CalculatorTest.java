package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final String BAD_OPERATION = "Wrong operation.";
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
    void additionWithPositiveTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void additionWithPositiveAndNegativeTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void additionWithNegativeTest() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void additionWithZeroTest() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, ADDITION);
        expected = ZERO + NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void additionWithMinAndMaxTest() {
        actual = calculator.calculate(MAX_NUMBER, MAX_NUMBER, ADDITION);
        expected = MAX_NUMBER + MAX_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, ADDITION);
        expected = MAX_NUMBER + MIN_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void subtractionWithPositiveTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = ZERO;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void subtractionWithPositiveAndNegativeTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = POSITIVE_NUMBER - NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void subtractionWithNegativeTest() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = ZERO;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void subtractionWithZeroTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, SUBTRACTION);
        expected = POSITIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void subtractionWithMinAndMaxTest() {
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, SUBTRACTION);
        expected = MIN_NUMBER - MAX_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void multiplicationWithPositiveTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void multiplicationWithPositiveAndNegativeTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = POSITIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void multiplicationWithNegativeTest() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void multiplicationWithZeroTest() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        expected = ZERO;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void multiplicationWithMinAndMaxTest() {
        actual = calculator.calculate(MAX_NUMBER, MAX_NUMBER, MULTIPLICATION);
        expected = MAX_NUMBER * MAX_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, MULTIPLICATION);
        expected = MIN_NUMBER * MAX_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void divisionWithPositiveTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = 1;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void divisionWithPositiveAndNegativeTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = POSITIVE_NUMBER / NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void divisionWithNegativeTest() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = 1;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void divisionWithZeroTest() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    void divisionWithMinAndMaxTest() {
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, DIVISION);
        expected = MIN_NUMBER / MAX_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void remainderDivisionWithPositiveTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, REMAINDER_DIVISION);
        expected = ZERO;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void remainderDivisionWithPositiveAndNegativeTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, REMAINDER_DIVISION);
        expected = POSITIVE_NUMBER % NEGATIVE_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void remainderDivisionWithNegativeTest() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, REMAINDER_DIVISION);
        expected = 0;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void remainderDivisionWithZeroTest() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, REMAINDER_DIVISION));
    }

    @Test
    void remainderDivisionWithMinAndMaxTest() {
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, REMAINDER_DIVISION);
        expected = MIN_NUMBER % MAX_NUMBER;
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void powWithPositiveTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POW);
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void powWithPositiveAndNegativeTest() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POW);
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void powWithNegativeTest() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POW);
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void powWithZeroTest() {
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, POW);
        expected = Math.pow(ZERO, NEGATIVE_NUMBER);
        assertEquals(actual, expected, BAD_OPERATION);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POW);
        expected = Math.pow(POSITIVE_NUMBER, ZERO);
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void powWithMinAndMaxTest() {
        actual = calculator.calculate(MIN_NUMBER, MAX_NUMBER, POW);
        expected = Math.pow(MIN_NUMBER, MAX_NUMBER);
        assertEquals(actual, expected, BAD_OPERATION);
        actual = calculator.calculate(MAX_NUMBER, MAX_NUMBER, POW);
        expected = Math.pow(MAX_NUMBER, MAX_NUMBER);
        assertEquals(actual, expected, BAD_OPERATION);
    }

    @Test
    void illegalOperation() {
        assertThrows(InvalidOperatorException.class, () -> calculator.calculate(1, 2, '@'));
    }
}
