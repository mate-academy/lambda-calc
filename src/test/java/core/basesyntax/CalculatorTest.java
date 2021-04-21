package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double POSITIVE_NUMBER = 567.222;
    private static final double NEGATIVE_NUMBER = - 345.223;
    private static final double DELTA = 0.0001;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char ILLEGAL_OPERATION = '!';
    private static final char POW = '^';
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionTwoPositiveNumber_Ok() {
        expected = 765.231;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void additionTwoNegativeNumber_Ok() {
        expected = -453.213;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void additionPositiveAndNegativeNumber_Ok() {
        expected = -245.212;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, PLUS), DELTA);
        expected = -245.213;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void additionNumberWithZero_Ok() {
        expected = 564.213;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, 0, PLUS), DELTA);
        expected = 564.213;
        assertEquals(expected, calculator.calculate(0, POSITIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void additionMinAndMaxDoubleValues_Ok() {
        expected = 1.79769313486231570e+308d;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                PLUS), DELTA);
        expected = 455.123;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                PLUS),DELTA);
    }

    @Test
    void subtractionTwoPositiveNumber_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void subtractionTwoNegativeNumber_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void subtractionPositiveAndNegativeNumber_Ok() {
        expected = -255.212;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER,
                MINUS), DELTA);
        expected = -255.213;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void subtractionNumberWithZero_Ok() {
        expected = -564.213;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, 0,
                MINUS), DELTA);
        expected = 564.213;
        assertEquals(expected, calculator.calculate(0, POSITIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void subtractionMinAndMaxDoubleValues_Ok() {
        expected = 1.79769313486231570e+308d;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                MINUS), DELTA);
        expected = 455.123;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                MINUS),DELTA);
    }

    @Test
    void multiplicationTwoPositiveNumber_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void multiplicationTwoNegativeNumber_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void multiplicationPositiveAndNegativeNumber_Ok() {
        expected = -255.212;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER,
                MULTIPLICATION), DELTA);
        expected = -255.213;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void multiplicationNumberWithZero_Ok() {
        expected = -564.213;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, 0,
                MULTIPLICATION), DELTA);
        expected = 564.213;
        assertEquals(expected, calculator.calculate(0, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void multiplicationMinAndMaxDoubleValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
        expected = 6.1E-322;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                MULTIPLICATION),DELTA);
    }

    @Test
    void divisionTwoPositiveNumber_Ok() {
        expected = 1.0;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void divisionTwoNegativeNumber_Ok() {
        expected = 1.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void divisionPositiveAndNegativeNumber_Ok() {
        expected = -255.212213123123;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER,
                DIVISION), DELTA);
        expected = -255.12213123123;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void divisionNumberWithZero_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(0, POSITIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void divisionNumberWithZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, 0, DIVISION);
        });
    }

    @Test
    void divisionMinAndMaxDoubleValues_Ok() {
        expected = 1.79769313486231570e+308d;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                DIVISION), DELTA);
        expected = 455.123;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                DIVISION),DELTA);
    }

    @Test
    void raisePositiveNegativeToPositive_Ok() {
        expected = Double.NaN;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                POW), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                POW), DELTA);
    }

    @Test
    void raisePositiveNegativeNumberToZero_Ok() {
        expected = Math.pow(POSITIVE_NUMBER, 0);
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, 0,
                POW), DELTA);
        expected = 1.2;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, 0,
                POW), DELTA);
    }

    @Test
    void raiseZero_Ok() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(0, NEGATIVE_NUMBER,
                POW), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(0, POSITIVE_NUMBER,
                POW),DELTA);
    }

    @Test
    void illegalOperation_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            assertEquals(POSITIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATION);
            assertEquals(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATION);
            assertEquals(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATION);
            assertEquals(NEGATIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATION);
            assertEquals(NEGATIVE_NUMBER, 0, ILLEGAL_OPERATION);
            assertEquals(0, NEGATIVE_NUMBER, ILLEGAL_OPERATION);
            assertEquals(0, POSITIVE_NUMBER, ILLEGAL_OPERATION);
            assertEquals(POSITIVE_NUMBER, 0, ILLEGAL_OPERATION);
        });
    }
}
