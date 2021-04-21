package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final char ILLEGAL_OPERATION = '!';
    private static final double FIRST_POSITIVE_DIGIT = 575485720.53454;
    private static final double SECOND_POSITIVE_DIGIT = 64389674.35409;
    private static final double FIRST_NEGATIVE_DIGIT = -9854321.532345;
    private static final double SECOND_NEGATIVE_DIGIT = -534873.123122;
    private static final double DELTA = 000.1;
    private static final double ZERO_DIGIT = 0;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, SECOND_POSITIVE_DIGIT, PLUS);
        expected = FIRST_POSITIVE_DIGIT + SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_NEGATIVE_DIGIT, PLUS);
        expected = FIRST_NEGATIVE_DIGIT + SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_POSITIVE_DIGIT, PLUS);
        expected = FIRST_NEGATIVE_DIGIT + SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, ZERO_DIGIT, PLUS);
        expected = FIRST_POSITIVE_DIGIT + ZERO_DIGIT;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO_DIGIT, SECOND_NEGATIVE_DIGIT, PLUS);
        expected = ZERO_DIGIT + SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_DIGIT, PLUS);
        expected = Double.MAX_VALUE + SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, FIRST_POSITIVE_DIGIT, PLUS);
        expected = Double.MIN_VALUE + FIRST_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, SECOND_POSITIVE_DIGIT, MINUS);
        expected = FIRST_POSITIVE_DIGIT - SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_NEGATIVE_DIGIT, MINUS);
        expected = FIRST_NEGATIVE_DIGIT - SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_POSITIVE_DIGIT, MINUS);
        expected = FIRST_NEGATIVE_DIGIT - SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, ZERO_DIGIT, MINUS);
        expected = FIRST_POSITIVE_DIGIT - ZERO_DIGIT;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO_DIGIT, SECOND_NEGATIVE_DIGIT, MINUS);
        expected = ZERO_DIGIT - SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_DIGIT, MINUS);
        expected = Double.MAX_VALUE - SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, FIRST_POSITIVE_DIGIT, MINUS);
        expected = Double.MIN_VALUE - FIRST_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, SECOND_POSITIVE_DIGIT, MULTIPLICATION);
        expected = FIRST_POSITIVE_DIGIT * SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_NEGATIVE_DIGIT, MULTIPLICATION);
        expected = FIRST_NEGATIVE_DIGIT * SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_POSITIVE_DIGIT, MULTIPLICATION);
        expected = FIRST_NEGATIVE_DIGIT * SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, ZERO_DIGIT, MULTIPLICATION);
        expected = FIRST_POSITIVE_DIGIT * ZERO_DIGIT;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO_DIGIT, SECOND_NEGATIVE_DIGIT, MULTIPLICATION);
        expected = ZERO_DIGIT * SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_DIGIT, MULTIPLICATION);
        expected = Double.MAX_VALUE * SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, FIRST_POSITIVE_DIGIT, MULTIPLICATION);
        expected = Double.MIN_VALUE * FIRST_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, SECOND_POSITIVE_DIGIT, DIVISION);
        expected = FIRST_POSITIVE_DIGIT / SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_NEGATIVE_DIGIT, DIVISION);
        expected = FIRST_NEGATIVE_DIGIT / SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_POSITIVE_DIGIT, DIVISION);
        expected = FIRST_NEGATIVE_DIGIT / SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAtFirstPosition_Ok() {
        actual = calculator.calculate(ZERO_DIGIT, SECOND_NEGATIVE_DIGIT, DIVISION);
        expected = ZERO_DIGIT / SECOND_NEGATIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAtSecondPosition_NotOk() {
        try {
            calculator.calculate(FIRST_POSITIVE_DIGIT, ZERO_DIGIT, DIVISION);
        } catch (ArithmeticException e) {
            return;
        }
        fail("ArithmeticException should be throw if second digit is zero");
    }

    @Test
    void divisionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_POSITIVE_DIGIT, DIVISION);
        expected = Double.MAX_VALUE / SECOND_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, FIRST_POSITIVE_DIGIT, DIVISION);
        expected = Double.MIN_VALUE / FIRST_POSITIVE_DIGIT;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, SECOND_POSITIVE_DIGIT, POWER);
        expected = Math.pow(FIRST_POSITIVE_DIGIT, SECOND_POSITIVE_DIGIT);
        assertEquals(expected, actual);

        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, FIRST_POSITIVE_DIGIT, POWER);
        expected = Math.pow(FIRST_NEGATIVE_DIGIT, FIRST_POSITIVE_DIGIT);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveOrNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, FIRST_NEGATIVE_DIGIT, POWER);
        expected = Math.pow(FIRST_POSITIVE_DIGIT, FIRST_NEGATIVE_DIGIT);
        assertEquals(expected, actual);

        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, SECOND_NEGATIVE_DIGIT, POWER);
        expected = Math.pow(FIRST_NEGATIVE_DIGIT, SECOND_NEGATIVE_DIGIT);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveOrNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_DIGIT, ZERO_DIGIT, POWER);
        expected = Math.pow(FIRST_NEGATIVE_DIGIT, ZERO_DIGIT);
        assertEquals(expected, actual);

        actual = calculator.calculate(FIRST_POSITIVE_DIGIT, ZERO_DIGIT, POWER);
        expected = Math.pow(FIRST_POSITIVE_DIGIT, ZERO_DIGIT);
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        actual = calculator.calculate(ZERO_DIGIT, FIRST_NEGATIVE_DIGIT, POWER);
        expected = Math.pow(ZERO_DIGIT, FIRST_NEGATIVE_DIGIT);
        assertEquals(expected, actual);

        actual = calculator.calculate(ZERO_DIGIT, FIRST_NEGATIVE_DIGIT, POWER);
        expected = Math.pow(ZERO_DIGIT, FIRST_NEGATIVE_DIGIT);
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_notOk() {
        try {
            calculator.calculate(FIRST_POSITIVE_DIGIT, SECOND_NEGATIVE_DIGIT, ILLEGAL_OPERATION);
        } catch (RuntimeException e) {
            return;
        }
        fail("Runtime exception should be throw if operation is illegal");
    }
}
