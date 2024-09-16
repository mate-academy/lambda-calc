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
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0;
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';
    private static final char POW = '^';
    private static final char ILLEGAL_OPERAND = '%';
    private static final String ERROR_MESSAGE = "Expected result not equals actual result.";
    private static Calculator calculator;
    private static double actual;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTest_OK() {
        expected = 21.0;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, ADD);
        assertEquals(expected, actual, DELTA);
        expected = -21.0;
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ADD);
        assertEquals(expected, actual, DELTA);
        expected = -11.0;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionZeroTest_OK() {
        expected = 5.0;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, ADD);
        assertEquals(expected, actual, DELTA);
        expected = -16.0;
        actual = calculator.calculate(ZERO, SECOND_NEGATIVE_NUMBER, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinMaxTest_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actual, ERROR_MESSAGE);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(1.0E-323, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_subtractionTest_OK() {
        expected = -11.0;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, SUB);
        assertEquals(expected, actual, DELTA);
        expected = 11.0;
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, SUB);
        assertEquals(expected, actual, DELTA);
        expected = 21.0;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, SUB);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionZeroTest_OK() {
        expected = 5.0;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, SUB);
        assertEquals(expected, actual, DELTA);
        expected = 16.0;
        actual = calculator.calculate(ZERO, SECOND_NEGATIVE_NUMBER, SUB);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinMaxTest_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUB);
        assertEquals(ZERO, actual, ERROR_MESSAGE);
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUB);
        assertEquals(expected, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_multiplyTest_OK() {
        expected = 80;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, MUL);
        assertEquals(expected, actual, DELTA);
        expected = 80;
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, MUL);
        assertEquals(expected, actual, DELTA);
        expected = -80.0;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, MUL);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyZeroTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, MUL);
        assertEquals(ZERO, actual, DELTA);
        actual = calculator.calculate(ZERO, SECOND_NEGATIVE_NUMBER, MUL);
        assertEquals(ZERO, actual, DELTA);
    }

    @Test
    void calculate_multiplyMinMaxTest_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MUL);
        assertEquals(Double.POSITIVE_INFINITY, actual, ERROR_MESSAGE);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MUL);
        assertEquals(ZERO, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_divisionTest_OK() {
        expected = 0.3125;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, DIV);
        assertEquals(expected, actual, DELTA);
        expected = 0.3125;
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, DIV);
        assertEquals(expected, actual, DELTA);
        expected = -0.3125;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroTest_OK() {
        actual = calculator.calculate(ZERO, FIRST_POSITIVE_NUMBER, DIV);
        assertEquals(ZERO, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroTest_notOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, DIV);
        });
    }

    @Test
    void calculate_divisionMinMaxTest_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIV);
        assertEquals(1, actual, ERROR_MESSAGE);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIV);
        assertEquals(1, actual, ERROR_MESSAGE);
    }

    @Test
    void calculate_risingTest_OK() {
        expected = 1.52587890625E11;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
        expected = 6.5536E-12;
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
        expected = 1.52587890625E11;
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_POSITIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
        expected = 6.5536E-12;
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_risingZroTest_OK() {
        actual = calculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, POW);
        assertEquals(1, actual, DELTA);
        actual = calculator.calculate(FIRST_NEGATIVE_NUMBER, ZERO, POW);
        assertEquals(1, actual, DELTA);
        actual = calculator.calculate(ZERO, FIRST_POSITIVE_NUMBER,POW);
        assertEquals(ZERO, actual, DELTA);
    }

    @Test
    void calculate_risingBothNegativeTest_notOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-5.0, -1.5, POW);
        });
    }

    @Test
    void calculate_illegalOperandTest_OK() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(ZERO, SECOND_POSITIVE_NUMBER, ILLEGAL_OPERAND);
            calculator.calculate(FIRST_NEGATIVE_NUMBER, ZERO, ILLEGAL_OPERAND);
        });
    }
}
