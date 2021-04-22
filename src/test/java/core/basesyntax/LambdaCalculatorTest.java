package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final char ILLEGAL_OPERATION = '$';
    private static final double DELTA = 0.0001;
    private static LambdaCalculator lambdaCalculatorTest;

    @BeforeAll
    static void beforeAll() {
        lambdaCalculatorTest = new LambdaCalculator();
    }

    @Test
    void additionTwoPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, 3.5, ADD);
        assertEquals(5.8, actual);
    }

    @Test
    void additionTwoNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, -3.5, ADD);
        assertEquals(-5.8, actual);
    }

    @Test
    void additionFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, -3.5, ADD);
        assertEquals(-1.2, actual, DELTA);
    }

    @Test
    void additionFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, 3.5, ADD);
        assertEquals(1.2, actual, DELTA);
    }

    @Test
    void additionWithZeroValues() {
        double actualZeroFirst = lambdaCalculatorTest.calculate(0.0, 3.5, ADD);
        double actualZeroSecond = lambdaCalculatorTest.calculate(2.3, 0.0, ADD);
        double actualBothZeros = lambdaCalculatorTest.calculate(0.0, 0.0, ADD);
        assertEquals(3.5, actualZeroFirst);
        assertEquals(2.3, actualZeroSecond);
        assertEquals(0.0, actualBothZeros);
    }

    @Test
    void additionForMinAndMaxDoubleValues() {
        double actualTwoMaxValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actualTwoMaxValues);
        double actualTwoMinValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADD);
        assertEquals(Double.NEGATIVE_INFINITY, actualTwoMinValues);
        double actualMaxAndMinValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADD);
        assertEquals(0.0, actualMaxAndMinValues);
        double actualMinAndMaxValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(0.0, actualMinAndMaxValues);
    }

    @Test
    void subtractionTwoPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, 3.5, SUBTRACT);
        assertEquals(-1.2, actual, DELTA);
    }

    @Test
    void subtractionTwoNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, -3.5, SUBTRACT);
        assertEquals(1.2, actual, DELTA);
    }

    @Test
    void subtractionFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, -3.5, SUBTRACT);
        assertEquals(5.8, actual);
    }

    @Test
    void subtractionFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, 3.5, SUBTRACT);
        assertEquals(-5.8, actual);
    }

    @Test
    void subtractionWithZeroValues() {
        double actualZeroFirst = lambdaCalculatorTest.calculate(0.0, 3.5, SUBTRACT);
        double actualZeroSecond = lambdaCalculatorTest.calculate(2.3, 0.0, SUBTRACT);
        double actualBothZeros = lambdaCalculatorTest.calculate(0.0, 0.0, SUBTRACT);
        assertEquals(-3.5, actualZeroFirst);
        assertEquals(2.3, actualZeroSecond);
        assertEquals(0.0, actualBothZeros);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues() {
        double actualTwoMaxValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(0.0, actualTwoMaxValues);
        double actualTwoMinValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACT);
        assertEquals(0.0, actualTwoMinValues);
        double actualMaxAndMinValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.POSITIVE_INFINITY, actualMaxAndMinValues);
        double actualMinAndMaxValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.NEGATIVE_INFINITY, actualMinAndMaxValues);
    }

    @Test
    void multiplicationTwoPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, 3.5, MULTIPLY);
        assertEquals(8.05, actual, DELTA);
    }

    @Test
    void multiplicationTwoNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, -3.5, MULTIPLY);
        assertEquals(8.05, actual, DELTA);
    }

    @Test
    void multiplicationFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, -3.5, MULTIPLY);
        assertEquals(-8.05, actual, DELTA);
    }

    @Test
    void multiplicationFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, 3.5, MULTIPLY);
        assertEquals(-8.05, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroValues() {
        double actualZeroFirst = lambdaCalculatorTest.calculate(0.0, 3.5, MULTIPLY);
        double actualZeroSecond = lambdaCalculatorTest.calculate(2.3, 0.0, MULTIPLY);
        double actualBothZeros = lambdaCalculatorTest.calculate(0.0, 0.0, MULTIPLY);
        assertEquals(0.0, actualZeroFirst);
        assertEquals(0.0, actualZeroSecond);
        assertEquals(0.0, actualBothZeros);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues() {
        double actualTwoMaxValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualTwoMaxValues);
        double actualTwoMinValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualTwoMinValues);
        double actualMaxAndMinValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.NEGATIVE_INFINITY, actualMaxAndMinValues);
        double actualMinAndMaxValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.NEGATIVE_INFINITY, actualMinAndMaxValues);
    }

    @Test
    void divisionTwoPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, 3.5, DIVIDE);
        assertEquals(0.65714, actual, DELTA);
    }

    @Test
    void divisionTwoNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, -3.5, DIVIDE);
        assertEquals(0.65714, actual, DELTA);
    }

    @Test
    void divisionFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalculatorTest.calculate(2.3, -3.5, DIVIDE);
        assertEquals(-0.65714, actual, DELTA);
    }

    @Test
    void divisionFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalculatorTest.calculate(-2.3, 3.5, DIVIDE);
        assertEquals(-0.65714, actual, DELTA);
    }

    @Test
    void divisionFirstValueZero() {
        double actual = lambdaCalculatorTest.calculate(0.0, 3.5, DIVIDE);
        assertEquals(0.0, actual);
    }

    @Test
    void divisionSecondValueZero() {
        assertThrows(ArithmeticException.class,
                () -> lambdaCalculatorTest.calculate(2.3, 0, DIVIDE));
    }

    @Test
    void divisionForMinAndMaxDoubleValues() {
        double actualTwoMaxValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(1.0, actualTwoMaxValues);
        double actualTwoMinValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(1.0, actualTwoMinValues);
        double actualMaxAndMinValues =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(-1.0, actualMaxAndMinValues);
        double actualMinAndMaxValues =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(-1.0, actualMinAndMaxValues);
    }

    @Test
    void raisingPositiveOrNegativeValuesToThePositivePower() {
        double actualPositiveToPositivePower = lambdaCalculatorTest.calculate(2.3, 3.5, POW);
        double actualNegativeToPositivePower = lambdaCalculatorTest.calculate(-2.3, 3.5, POW);
        assertEquals(18.45216, actualPositiveToPositivePower, DELTA);
        assertEquals(Double.NaN, actualNegativeToPositivePower, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValuesToTheNegativePower() {
        double actualPositiveToNegativePower = lambdaCalculatorTest.calculate(2.3, -3.5, POW);
        double actualNegativeToNegativePower = lambdaCalculatorTest.calculate(-2.3, -3.5, POW);
        assertEquals(0.05419, actualPositiveToNegativePower, DELTA);
        assertEquals(Double.NaN, actualNegativeToNegativePower, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValuesToZeroPower() {
        double actualPositiveToZeroPower = lambdaCalculatorTest.calculate(2.3, 0.0, POW);
        double actualNegativeToZeroPower = lambdaCalculatorTest.calculate(-2.3, 0.0, POW);
        assertEquals(1.0, actualPositiveToZeroPower);
        assertEquals(1.0, actualNegativeToZeroPower);
    }

    @Test
    void raisingZeroToPositiveOrNegativePower() {
        double actualZeroToPositivePower = lambdaCalculatorTest.calculate(0.0, 3.5, POW);
        double actualZeroToNegativePower = lambdaCalculatorTest.calculate(0.0, -3.5, POW);
        assertEquals(0.0, actualZeroToPositivePower, DELTA);
        assertEquals(Double.POSITIVE_INFINITY, actualZeroToNegativePower, DELTA);
    }

    @Test
    void checkForIllegalOperation() {
        assertThrows(RuntimeException.class,
                () -> lambdaCalculatorTest.calculate(0.0, -3.5, ILLEGAL_OPERATION));
    }
}
