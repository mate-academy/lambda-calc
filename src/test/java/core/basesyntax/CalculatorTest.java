package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double POSITIVE_NUMBER = 567.222;
    private static final double NEGATIVE_NUMBER = -345.223;
    private static final double DELTA = 0.0001;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char ILLEGAL_OPERATION = '!';
    private static final char POW = '^';
    private static final int ZERO = 0;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveNumber_Ok() {
        expected = 1134.444;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void calculate_additionTwoNegativeNumber_Ok() {
        expected = -690.446;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void calculate_additionPositiveAndNegativeNumber_Ok() {
        expected = 221.99899999999997;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, PLUS), DELTA);
        expected = 221.99899999999997;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void calculate_additionNumberWithZero_Ok() {
        expected = 567.222;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, ZERO, PLUS), DELTA);
        expected = 567.222;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_NUMBER, PLUS), DELTA);
    }

    @Test
    void calculate_additionMinAndMaxDoubleValues_Ok() {
        expected = 1.79769313486231570e+308d;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                PLUS), DELTA);
        expected = 567.222;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                PLUS), DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveNumber_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionTwoNegativeNumber_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeNumber_Ok() {
        expected = 912.4449999999999;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER,
                MINUS), DELTA);
        expected = -912.4449999999999;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionNumberWithZero_Ok() {
        expected = 567.222;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, ZERO,
                MINUS), DELTA);
        expected = -567.222;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void calculate_subtractionMinAndMaxDoubleValues_Ok() {
        expected = 1.79769313486231570E308;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                MINUS), DELTA);
        expected = -567.222;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                MINUS), DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveNumber_Ok() {
        expected = 321740.797284;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegativeNumber_Ok() {
        expected = 119178.91972900002;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeNumber_Ok() {
        expected = -195818.080506;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER,
                MULTIPLICATION), DELTA);
        expected = -195818.080506;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_multiplicationNumberWithZero_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, ZERO,
                MULTIPLICATION), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_multiplicationMinAndMaxDoubleValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                MULTIPLICATION), DELTA);
        expected = 6.1E-322;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                MULTIPLICATION),DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveNumber_Ok() {
        expected = 1.0;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void calculate_divisionTwoNegativeNumber_Ok() {
        expected = 1.0;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeNumber_Ok() {
        expected = -1.6430597034380674;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER,
                DIVISION), DELTA);
        expected = -0.6086206106251169;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void calculate_divisionNumberWithZero_Ok() {
        expected = 0.0;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_NUMBER,
                DIVISION), DELTA);
    }

    @Test
    void calculate_divisionNumberWithZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_divisionMinAndMaxDoubleValues_Ok() {
        expected = 3.1692937418899755E305;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER,
                DIVISION), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER,
                DIVISION),DELTA);
    }

    @Test
    void calculate_raisePositiveNegativeToPositive_Ok() {
        expected = Double.NaN;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER,
                POW), DELTA);
        expected = Double.NaN;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER,
                POW), DELTA);
    }

    @Test
    void calculate_raisePositiveNegativeNumberToZero_Ok() {
        expected = 1;
        assertEquals(expected, calculator.calculate(POSITIVE_NUMBER, ZERO,
                POW), DELTA);
        expected = 1;
        assertEquals(expected, calculator.calculate(NEGATIVE_NUMBER, ZERO,
                POW), DELTA);
    }

    @Test
    void calculate_raiseZero_Ok() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(ZERO, NEGATIVE_NUMBER,
                POW), DELTA);
        expected = 0.0;
        assertEquals(expected, calculator.calculate(ZERO, POSITIVE_NUMBER,
                POW),DELTA);
    }

    @Test
    void calculate_illegalOperation_NotOK() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATION);
        });
    }
}
