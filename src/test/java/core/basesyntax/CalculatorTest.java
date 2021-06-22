package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double POSITIVE_NUMBER = 253.0093;
    private static final double NEGATIVE_NUMBER = -137.057;
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POW = '^';
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void creatCalculator() {
        calculator = new Calculator();
    }

    @Test
    void summationOfTwoPositiveNumber() {
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void summationOfTwoNegativeNumber() {
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void summationOfPositiveAndNegativeNumber() {
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void summationOfNumberWithZero() {
        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void summationOfMinAndMax() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionOfTwoPositiveNumber() {
        expected = 0.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionOfTwoNegativeNumber() {
        expected = 0.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionOfPositiveAndNegativeNumber() {
        expected = POSITIVE_NUMBER - NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionOfNumberWithZero() {
        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = -POSITIVE_NUMBER;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionOfMinAndMax() {
        expected = 0.0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionOfTwoPositiveNumber() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionOfTwoNegativeNumber() {
        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionOfPositiveAndNegativeNumber() {
        expected = POSITIVE_NUMBER / NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionOfNumberWithZero() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    void divisionOfMinAndMax() {
        expected = 1.0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationOfTwoPositiveNumber() {
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationOfTwoNegativeNumber() {
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationOfPositiveAndNegativeNumber() {
        expected = POSITIVE_NUMBER * NEGATIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationOfNumberWithZero() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationOfMinAndMax() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void powOfTwoPositiveNumber() {
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void powOfTwoNegativeNumber() {
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void powOfPositiveAndNegativeNumber() {
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void powOfNumberWithZero() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POW);
        assertEquals(expected, actual, DELTA);

        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void powOfMinAndMax() {
        expected = Math.pow(Double.MAX_VALUE, Double.MAX_VALUE);
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, POW);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(Double.MIN_VALUE, Double.MIN_VALUE);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, POW);
        assertEquals(expected, actual, DELTA);
    }
}
