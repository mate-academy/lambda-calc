package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
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
    private double actual = 0.0;

    @Test
    void addingTwoPositive_Ok() {
        double expectedForBothPositive = 15.5;
        actual = calculator.calculate(FIVE_POSITIVE, TEN_POSITIVE, ADD);
        assertEquals(expectedForBothPositive, actual, DELTA);
    }

    @Test
    void addingTwoNegative_Ok() {
        double expectedForBothNegative = -15.5;
        actual = calculator.calculate(FIVE_NEGATIVE, TEN_NEGATIVE, ADD);
        assertEquals(expectedForBothNegative, actual, DELTA);
    }

    @Test
    void addingPositiveToNegative_Ok() {
        double expectedForNegativeAndPositive = -5.3;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, ADD);
        assertEquals(expectedForNegativeAndPositive, actual, DELTA);
    }

    @Test
    void addingZero_Ok() {
        double expectedForPositiveAndZero = 10.4;
        actual = calculator.calculate(0, FIVE_POSITIVE, ADD);
        assertEquals(expectedForPositiveAndZero, actual, DELTA);

        double expectedForNegativeAndZero = -10.4;
        actual = calculator.calculate(0, TEN_NEGATIVE, ADD);
        assertEquals(expectedForNegativeAndZero, actual, DELTA);
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
        double expectedForBothPositive = -5.3;
        double actual = calculator.calculate(FIVE_POSITIVE, TEN_POSITIVE, MINUS);
        assertEquals(expectedForBothPositive, actual, DELTA);
    }

    @Test
    void subtractingTwoNegative_Ok() {
        double expectedForBothNegative = -15.5;
        actual = calculator.calculate(FIVE_NEGATIVE, TEN_NEGATIVE, MINUS);
        assertEquals(expectedForBothNegative, actual, DELTA);

    }

    @Test
    void negativeMinusPositive_Ok() {
        double expectedForNegativeMinusPositive = 5.3;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, MINUS);
        assertEquals(expectedForNegativeMinusPositive, actual, DELTA);
    }

    @Test
    void PositiveMinusNegative_Ok() {
        double expectedForPositiveMinusNegative = 15.5;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_NEGATIVE, MINUS);
        assertEquals(expectedForPositiveMinusNegative, actual, DELTA);
    }

    @Test
    void subtractingZero_Ok() {
        double expectedForPositiveMinusZero = 5.1;
        actual = calculator.calculate(FIVE_POSITIVE, 0.0, MINUS);
        assertEquals(expectedForPositiveMinusZero, actual);

        double expectedForZeroMinusPositive = -5.1;
        actual = calculator.calculate(0.0, FIVE_POSITIVE, MINUS);
        assertEquals(expectedForZeroMinusPositive, actual);

        actual = calculator.calculate(FIVE_NEGATIVE, 0.0, MINUS);
        assertEquals(expectedForZeroMinusPositive, actual);

        double expectedForZeroMinusNegative = 5.1;
        actual = calculator.calculate(0.0, FIVE_NEGATIVE, MINUS);
        assertEquals(expectedForZeroMinusNegative, actual);
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
        double expectedForBothPositive = 53.04;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_POSITIVE, MULTIPLY);
        assertEquals(expectedForBothPositive, actual, DELTA);
    }

    @Test
    void multiplyTwoNegative_Ok() {
        double expectedForBothPositive = 53.04;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_NEGATIVE, MULTIPLY);
        assertEquals(expectedForBothPositive, actual, DELTA);
    }

    @Test
    void multiplyPositiveAndNegative_Ok() {
        double expectedForPositiveAndNegative = -53.04;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, MULTIPLY);
        assertEquals(expectedForPositiveAndNegative, actual, DELTA);
    }

    @Test
    void multiplyByZero_Ok() {
        double expectedForMultiplyByZero = 0;
        actual = calculator.calculate(TEN_NEGATIVE, 0, MULTIPLY);
        assertEquals(expectedForMultiplyByZero, actual);

        actual = calculator.calculate(0, FIVE_POSITIVE, MULTIPLY);
        assertEquals(expectedForMultiplyByZero, actual);
    }

    @Test
    void multiplyMinAndMaxValues_Ok() {
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MAX_DOUBLE_VALUE, MULTIPLY);
        assertEquals(MULTIPLY_MIN_BY_MAX, actual);

        double expectedForMinMultiplyMin = 0.0;
        actual = calculator.calculate(MIN_DOUBLE_VALUE, MIN_DOUBLE_VALUE, MULTIPLY);
        assertEquals(expectedForMinMultiplyMin, actual);

        actual = calculator.calculate(MAX_DOUBLE_VALUE, MAX_DOUBLE_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void divideTwoPositive_Ok() {
        double expectedForBothPositive = 2.03921568627451;
        double actual = calculator.calculate(TEN_POSITIVE, FIVE_POSITIVE, DIVIDE);
        assertEquals(expectedForBothPositive, actual);
    }

    @Test
    void divideTwoNegative() {
        double expectedForBothNegative = -2.03921568627451;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_NEGATIVE, DIVIDE);
        assertEquals(expectedForBothNegative, actual);
    }

    @Test
    void dividePositiveByNegative_Ok() {
        double expectedForPositiveDividedByNegative = -2.03921568627451;
        actual = calculator.calculate(TEN_POSITIVE, FIVE_NEGATIVE, DIVIDE);
        assertEquals(expectedForPositiveDividedByNegative, actual);
    }

    @Test
    void divideNegativeByPositive_Ok() {
        double expectedForNegativeDividedByPositive = 2.03921568627451;
        actual = calculator.calculate(TEN_NEGATIVE, FIVE_POSITIVE, DIVIDE);
        assertEquals(expectedForNegativeDividedByPositive, actual);
    }

    @Test
    void divideByNumberItself() {
        double expectedForSamePositives = 1.0;
        actual = calculator.calculate(FIVE_POSITIVE, FIVE_POSITIVE, DIVIDE);
        assertEquals(expectedForSamePositives, actual);

        double expectedForSameNegatives = 1.0;
        actual = calculator.calculate(FIVE_NEGATIVE, FIVE_NEGATIVE, DIVIDE);
        assertEquals(expectedForSameNegatives, actual);
    }

    @Test
    void divideByZero_Ok() {
        actual = calculator.calculate(FIVE_POSITIVE, 0, DIVIDE);
        assertEquals(Double.POSITIVE_INFINITY, actual);

        actual = calculator.calculate(FIVE_NEGATIVE, 0, DIVIDE);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void divideZero_Ok() {

    }

    @Test
    void divideDoubleMinByDoubleMax() {

    }
}
