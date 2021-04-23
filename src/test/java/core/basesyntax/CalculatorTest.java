package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private static final char ADD = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final char ILLEGAL_OPERATION = '%';
    private static final double MIN_DOUBLE_VALUE = Double.MIN_VALUE;
    private static final double MAX_DOUBLE_VALUE = Double.MAX_VALUE;
    private static final double POSITIVE_DIFF_OF_MIN_AND_MAX_VALUES = 1.7976931348623157E308;
    private static final double NEGATIVE_DIFF_OF_MIN_AND_MAX_VALUES = -1.7976931348623157E308;
    private static final double SUM_OF_TWO_MIN_VALUES = 1.0E-323;
    private static final double MULTIPLY_MIN_BY_MAX = 8.881784197001251E-16;
    private static final double FIVE_POSITIVE = 5.1;
    private static final double TEN_POSITIVE = 10.4;
    private static final double FIVE_NEGATIVE = -5.1;
    private static final double TEN_NEGATIVE = -10.4;
    private static final double DELTA = 0.000000000000001;
    private double actual;
    private double expected;

    @Test
    void addingTwoPositive_Ok() {
        expected = 15.5;
        actual = calculator.calculate(FIVE_POSITIVE, TEN_POSITIVE, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addingTwoNegative_Ok() {
        expected = -15.5;
        actual = calculator.calculate(FIVE_NEGATIVE, TEN_NEGATIVE, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addingPositiveToNegative_Ok() {
        expected = -5.3;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addingZero_Ok() {
        expected = 10.4;
        actual = calculator.calculate(0, TEN_POSITIVE, ADD);
        assertEquals(expected, actual, DELTA);

        expected = -10.4;
        actual = calculator.calculate(0, TEN_NEGATIVE, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addingMinAndMaxValues_Ok() {
        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actual);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, MAX_DOUBLE_VALUE, ADD);
        assertEquals(POSITIVE_DIFF_OF_MIN_AND_MAX_VALUES, actual);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, ADD);
        assertEquals(SUM_OF_TWO_MIN_VALUES, actual);
    }

    @Test
    void subtractingTwoPositive_Ok() {
        expected = -5.3;
        double actual = calculator.calculate(FIVE_POSITIVE, TEN_POSITIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractingTwoNegative_Ok() {
        expected = 5.3;
        actual = calculator.calculate(FIVE_NEGATIVE, TEN_NEGATIVE, MINUS);
        assertEquals(expected, actual, DELTA);

    }

    @Test
    void negativeMinusPositive_Ok() {
        expected = -15.5;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positiveMinusNegative_Ok() {
        expected = 15.5;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_NEGATIVE, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractingZero_Ok() {
        expected = 5.1;
        actual = calculator.calculate(FIVE_POSITIVE, 0.0, MINUS);
        assertEquals(expected, actual);

        expected = -5.1;
        actual = calculator.calculate(0.0, FIVE_POSITIVE, MINUS);
        assertEquals(expected, actual);

        actual = calculator.calculate(FIVE_NEGATIVE, 0.0, MINUS);
        assertEquals(expected, actual);

        expected = 5.1;
        actual = calculator.calculate(0.0, FIVE_NEGATIVE, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractingMinAndMaxValues_Ok() {
        actual = calculator.calculate(MAX_DOUBLE_VALUE, MIN_DOUBLE_VALUE, MINUS);
        assertEquals(POSITIVE_DIFF_OF_MIN_AND_MAX_VALUES, actual);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, MAX_DOUBLE_VALUE, MINUS);
        assertEquals(NEGATIVE_DIFF_OF_MIN_AND_MAX_VALUES, actual);
    }

    @Test
    void multiplyTwoPositive_Ok() {
        expected = 53.04;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_POSITIVE, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyTwoNegative_Ok() {
        expected = 53.04;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_NEGATIVE, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyPositiveAndNegative_Ok() {
        expected = -53.04;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyByZero_Ok() {
        expected = -0.0;
        actual = calculator.calculate(TEN_NEGATIVE, 0.0, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0.0;
        actual = calculator.calculate(0.0, FIVE_POSITIVE, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyMinAndMaxValues_Ok() {
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MAX_DOUBLE_VALUE, MULTIPLY);
        assertEquals(MULTIPLY_MIN_BY_MAX, actual);

        expected = 0.0;
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, MULTIPLY);
        assertEquals(expected, actual);

        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void divideTwoPositive_Ok() {
        expected = 2.03921568627451;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_POSITIVE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoNegative() {
        expected = 2.03921568627451;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_NEGATIVE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void dividePositiveByNegative_Ok() {
        expected = -2.03921568627451;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_NEGATIVE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divideNegativeByPositive_Ok() {
        expected = -2.03921568627451;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divideByNumberItself() {
        expected = 1.0;
        actual = calculator.calculate(FIVE_POSITIVE, FIVE_POSITIVE, DIVIDE);
        assertEquals(expected, actual);

        expected = 1.0;
        actual = calculator.calculate(FIVE_NEGATIVE, FIVE_NEGATIVE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divideByZero_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIVE_POSITIVE, 0, DIVIDE));
    }

    @Test
    void calculate_divideZero_Ok() {
        actual = calculator.calculate(0, FIVE_POSITIVE, DIVIDE);
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_divideMinAndMaxValues() {
        actual = calculator.calculate(MAX_DOUBLE_VALUE, MIN_DOUBLE_VALUE, DIVIDE);
        assertEquals(Double.POSITIVE_INFINITY, actual);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, MAX_DOUBLE_VALUE, DIVIDE);
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_raisePositiveToPositive_Ok() {
        expected = 153769.43917747992;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_POSITIVE, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseNegativeToNegative_Ok() {
        expected = -0.09615384615384615;
        actual = calculator.calculate(TEN_NEGATIVE, -1, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisePositiveToNegative_Ok() {
        expected = 0.19607843137254904;
        actual = calculator.calculate(FIVE_POSITIVE, -1, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseNegativeToPositive_Ok() {
        expected = -0.19607843137254904;
        actual = calculator.calculate(FIVE_NEGATIVE, -1, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseToZero_Ok() {
        actual = calculator.calculate(FIVE_POSITIVE, 0, POW);
        assertEquals(1.0, actual);

        actual = calculator.calculate(FIVE_NEGATIVE, 0, POW);
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_raiseMinAndMaxValues_Ok() {
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MAX_DOUBLE_VALUE, POW);
        assertEquals(0.0, actual);

        actual = calculator.calculate(MAX_DOUBLE_VALUE, MIN_DOUBLE_VALUE, POW);
        assertEquals(1.0, actual);

        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, POW);
        assertEquals(Double.POSITIVE_INFINITY, actual);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, POW);
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_WithIllegalOperator_NotOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(FIVE_POSITIVE, FIVE_POSITIVE, ILLEGAL_OPERATION));
    }
}
