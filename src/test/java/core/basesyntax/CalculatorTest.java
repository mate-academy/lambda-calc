package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double FIRST_POSITIVE_NUMBER = 5.0;
    private static final double SECOND_POSITIVE_NUMBER = 16.0;
    private static final double FIRST_NEGATIVE_NUMBER = -5.0;
    private static final double SECOND_NEGATIVE_NUMBER = -16.0;
    private static final double MAX_DOUBLE_VALUE = Double.MAX_VALUE;
    private static final double MIN_DOUBLE_VALUE = Double.MIN_VALUE;
    private static final double DELTA = 0.0001;
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';
    private static final char POW = '^';
    private static final char ILLEGAL_OPERAND = '%';
    private static final String ERROR_MESSAGE = "Expected result not equals actual result.";
    private static Calculator calculator;
    private static double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, ADD);
        assertEquals(FIRST_POSITIVE_NUMBER + SECOND_POSITIVE_NUMBER, actual, DELTA);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ADD);
        assertEquals(FIRST_NEGATIVE_NUMBER + SECOND_NEGATIVE_NUMBER, actual, DELTA);
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ADD);
        assertEquals(FIRST_POSITIVE_NUMBER + SECOND_NEGATIVE_NUMBER, actual, DELTA);
    }

    @Test
    void calculate_additionZeroTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, 0, ADD);
        assertEquals(FIRST_POSITIVE_NUMBER + 0, actual, DELTA);
        actual = calculator.calculate(0, SECOND_NEGATIVE_NUMBER, ADD);
        assertEquals(0 + SECOND_NEGATIVE_NUMBER, actual, DELTA);
    }

    @Test
    void calculate_additionMinMaxTest_OK() {
        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actual, ERROR_MESSAGE);
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, ADD);
        assertEquals(1.0E-323, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_subtractionTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, SUB);
        assertEquals(FIRST_POSITIVE_NUMBER - SECOND_POSITIVE_NUMBER, actual);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, SUB);
        assertEquals(FIRST_NEGATIVE_NUMBER - SECOND_NEGATIVE_NUMBER, actual);
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, SUB);
        assertEquals(FIRST_POSITIVE_NUMBER - SECOND_NEGATIVE_NUMBER, actual, DELTA);
    }

    @Test
    void calculate_subtractionZeroTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, 0, SUB);
        assertEquals(FIRST_POSITIVE_NUMBER + 0, actual, DELTA);
        actual = calculator.calculate(0, SECOND_NEGATIVE_NUMBER, SUB);
        assertEquals(0 - SECOND_NEGATIVE_NUMBER, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinMaxTest_OK() {
        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, SUB);
        assertEquals(0, actual, ERROR_MESSAGE);
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, SUB);
        assertEquals(0, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_multiplyTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, MUL);
        assertEquals(FIRST_POSITIVE_NUMBER * SECOND_POSITIVE_NUMBER, actual);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, MUL);
        assertEquals(FIRST_NEGATIVE_NUMBER * SECOND_NEGATIVE_NUMBER, actual);
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, MUL);
        assertEquals(FIRST_POSITIVE_NUMBER * SECOND_NEGATIVE_NUMBER, actual, DELTA);
    }

    @Test
    void calculate_multiplyZeroTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, 0, MUL);
        assertEquals(FIRST_POSITIVE_NUMBER * 0, actual, DELTA);
        actual = calculator.calculate(0, SECOND_NEGATIVE_NUMBER, MUL);
        assertEquals(0 * SECOND_NEGATIVE_NUMBER, actual, DELTA);
    }

    @Test
    void calculate_multiplyMinMaxTest_OK() {
        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, MUL);
        assertEquals(Double.POSITIVE_INFINITY, actual, ERROR_MESSAGE);
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, MUL);
        assertEquals(0, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_divisionTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, DIV);
        assertEquals(FIRST_POSITIVE_NUMBER / SECOND_POSITIVE_NUMBER, actual, DELTA);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, DIV);
        assertEquals(FIRST_NEGATIVE_NUMBER / SECOND_NEGATIVE_NUMBER, actual, DELTA);
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, DIV);
        assertEquals(FIRST_POSITIVE_NUMBER / SECOND_NEGATIVE_NUMBER, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroTest_OK() {
        actual = calculator.calculate(0, FIRST_POSITIVE_NUMBER, DIV);
        assertEquals(0, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroTest_notOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(FIRST_POSITIVE_NUMBER, 0, DIV);
        });
    }

    @Test
    void calculate_divisionMinMaxTest_OK() {
        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, DIV);
        assertEquals(1, actual, ERROR_MESSAGE);
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, DIV);
        assertEquals(1, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_risingTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, POW);
        assertEquals(Math.pow(FIRST_POSITIVE_NUMBER,SECOND_POSITIVE_NUMBER), actual, DELTA);
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, POW);
        assertEquals(Math.pow(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER), actual, DELTA);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_POSITIVE_NUMBER, POW);
        assertEquals(Math.pow(FIRST_NEGATIVE_NUMBER,SECOND_POSITIVE_NUMBER), actual, DELTA);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, POW);
        assertEquals(Math.pow(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER), actual, DELTA);
    }

    @Test
    void calculate_risingZroTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, 0, POW);
        assertEquals(1, actual, DELTA);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, 0, POW);
        assertEquals(1, actual, DELTA);
        actual = calculator.calculate(0, FIRST_POSITIVE_NUMBER,POW);
        assertEquals(0, actual, DELTA);
    }

    @Test
    void calculate_illegalOperandTest_OK() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(0, SECOND_POSITIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(FIRST_NEGATIVE_NUMBER, 0, ILLEGAL_OPERAND);
        });
    }
}
