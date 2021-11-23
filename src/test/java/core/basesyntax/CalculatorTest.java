package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private static final char ADD = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final char ILLEGAL_OPERATION = '%';
    private static final double POSITIVE_DIFF_OF_MIN_AND_MAX_VALUES = 1.7976931348623157E308;
    private static final double NEGATIVE_DIFF_OF_MIN_AND_MAX_VALUES = -1.7976931348623157E308;
    private static final double SUM_OF_TWO_MIN_VALUES = 1.0E-323;
    private static final double MULTIPLY_MIN_BY_MAX = 8.881784197001251E-16;
    private static final double DELTA = 0.000000000000001;

    @Test
    void calculate_addingTwoPositive_ok() {
        double expected = 15.5;
        double actual = calculator.calculate(5.1, 10.4, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingTwoNegative_ok() {
        double expected = -15.5;
        double actual = calculator.calculate(-5.1, -10.4, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingPositiveToNegative_ok() {
        double expected = -5.3;
        double actual = calculator.calculate(-10.4, 5.1, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingZero_ok() {
        double expected = 10.4;
        double actual = calculator.calculate(0, 10.4, ADD);
        assertEquals(expected, actual, DELTA);

        expected = -10.4;
        actual = calculator.calculate(0, -10.4, ADD);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingMinAndMaxValues_ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(POSITIVE_DIFF_OF_MIN_AND_MAX_VALUES, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(SUM_OF_TWO_MIN_VALUES, actual);
    }

    @Test
    void calculate_subtractingTwoPositive_ok() {
        double expected = -5.3;
        double actual = calculator.calculate(5.1, 10.4, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractingTwoNegative_ok() {
        double expected = 5.3;
        double actual = calculator.calculate(-5.1, -10.4, MINUS);
        assertEquals(expected, actual, DELTA);

    }

    @Test
    void calculate_negativeMinusPositive_ok() {
        double expected = -15.5;
        double actual = calculator.calculate(-10.4, 5.1, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_positiveMinusNegative_ok() {
        double expected = 15.5;
        double actual = calculator.calculate(10.4, -5.1, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractingZero_ok() {
        double expected = 5.1;
        double actual = calculator.calculate(5.1, 0.0, MINUS);
        assertEquals(expected, actual);

        expected = -5.1;
        actual = calculator.calculate(0.0, 5.1, MINUS);
        assertEquals(expected, actual);

        actual = calculator.calculate(-5.1, 0.0, MINUS);
        assertEquals(expected, actual);

        expected = 5.1;
        actual = calculator.calculate(0.0, -5.1, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractingMinAndMaxValues_ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MINUS);
        assertEquals(POSITIVE_DIFF_OF_MIN_AND_MAX_VALUES, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(NEGATIVE_DIFF_OF_MIN_AND_MAX_VALUES, actual);
    }

    @Test
    void calculate_multiplyTwoPositive_ok() {
        double expected = 53.04;
        double actual = calculator.calculate(10.4, 5.1, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyTwoNegative_ok() {
        double expected = 53.04;
        double actual = calculator.calculate(-10.4, -5.1, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyPositiveAndNegative_ok() {
        double expected = -53.04;
        double actual = calculator.calculate(-10.4, 5.1, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyByZero_ok() {
        double expected = -0.0;
        double actual = calculator.calculate(-10.4, 0.0, MULTIPLY);
        assertEquals(expected, actual);

        expected = 0.0;
        actual = calculator.calculate(0.0, 5.1, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyMinAndMaxValues_ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(MULTIPLY_MIN_BY_MAX, actual);

        double expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLY);
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_divideTwoPositive_ok() {
        double expected = 2.03921568627451;
        double actual = calculator.calculate(10.4, 5.1, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideTwoNegative_ok() {
        double expected = 2.03921568627451;
        double actual = calculator.calculate(-10.4, -5.1, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_dividePositiveByNegative_ok() {
        double expected = -2.03921568627451;
        double actual = calculator.calculate(10.4, -5.1, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideNegativeByPositive_ok() {
        double expected = -2.03921568627451;
        double actual = calculator.calculate(-10.4, 5.1, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideByNumberItself_ok() {
        double expected = 1.0;
        double actual = calculator.calculate(5.1, 5.1, DIVIDE);
        assertEquals(expected, actual);

        actual = calculator.calculate(-5.1, -5.1, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideByZero_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(5.1, 0, DIVIDE));
    }

    @Test
    void calculate_divideZero_ok() {
        double actual = calculator.calculate(0, 5.1, DIVIDE);
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_divideMinAndMaxValues_ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVIDE);
        assertEquals(Double.POSITIVE_INFINITY, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(0.0, actual);
    }

    @Test
    void calculate_raisePositiveToPositive_ok() {
        double expected = 153769.43917747992;
        double actual = calculator.calculate(10.4, 5.1, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseNegativeToNegative_ok() {
        double expected = -0.09615384615384615;
        double actual = calculator.calculate(-10.4, -1, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisePositiveToNegative_ok() {
        double expected = 0.19607843137254904;
        double actual = calculator.calculate(5.1, -1, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseNegativeToPositive_ok() {
        double expected = -0.19607843137254904;
        double actual = calculator.calculate(-5.1, -1, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raiseToZero_ok() {
        double actual = calculator.calculate(5.1, 0, POW);
        assertEquals(1.0, actual);

        actual = calculator.calculate(-5.1, 0, POW);
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_raiseMinAndMaxValues_ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, POW);
        assertEquals(0.0, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, POW);
        assertEquals(1.0, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, POW);
        assertEquals(Double.POSITIVE_INFINITY, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, POW);
        assertEquals(1.0, actual);
    }

    @Test
    void calculate_WithIllegalOperator_notOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(5.1, 5.1, ILLEGAL_OPERATION));
    }
}

