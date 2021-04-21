package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static LambdaCalculator lambdaCalculatorTest;
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final double DELTA = 0.0001;

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
        double actualFirst = lambdaCalculatorTest.calculate(0.0, 3.5, ADD);
        double actualSecond = lambdaCalculatorTest.calculate(2.3, 0.0, ADD);
        double actualThird = lambdaCalculatorTest.calculate(0.0, 0.0, ADD);
        assertEquals(3.5, actualFirst);
        assertEquals(2.3, actualSecond);
        assertEquals(0.0, actualThird);
    }

    @Test
    void additionForMinAndMaxDoubleValues() {
        double actualFirst =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actualFirst);
        double actualSecond =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADD);
        assertEquals(Double.NEGATIVE_INFINITY, actualSecond);
        double actualThird =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADD);
        assertEquals(0.0, actualThird);
        double actualFourth =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(0.0, actualFourth);
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
        double actualFirst = lambdaCalculatorTest.calculate(0.0, 3.5, SUBTRACT);
        double actualSecond = lambdaCalculatorTest.calculate(2.3, 0.0, SUBTRACT);
        double actualThird = lambdaCalculatorTest.calculate(0.0, 0.0, SUBTRACT);
        assertEquals(-3.5, actualFirst);
        assertEquals(2.3, actualSecond);
        assertEquals(0.0, actualThird);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues() {
        double actualFirst =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(0.0, actualFirst);
        double actualSecond =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACT);
        assertEquals(0.0, actualSecond);
        double actualThird =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.POSITIVE_INFINITY, actualThird);
        double actualFourth =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.NEGATIVE_INFINITY, actualFourth);
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
        double actualFirst = lambdaCalculatorTest.calculate(0.0, 3.5, MULTIPLY);
        double actualSecond = lambdaCalculatorTest.calculate(2.3, 0.0, MULTIPLY);
        double actualThird = lambdaCalculatorTest.calculate(0.0, 0.0, MULTIPLY);
        assertEquals(0.0, actualFirst);
        assertEquals(0.0, actualSecond);
        assertEquals(0.0, actualThird);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues() {
        double actualFirst =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualFirst);
        double actualSecond =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualSecond);
        double actualThird =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.NEGATIVE_INFINITY, actualThird);
        double actualFourth =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.NEGATIVE_INFINITY, actualFourth);
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
        double actualFirst =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(1.0, actualFirst);
        double actualSecond =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(1.0, actualSecond);
        double actualThird =
                lambdaCalculatorTest.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(-1.0, actualThird);
        double actualFourth =
                lambdaCalculatorTest.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(-1.0, actualFourth);
    }

    @Test
    void raisingPositiveOrNegativeValuesToThePositivePower() {
        double actualFirst = lambdaCalculatorTest.calculate(2.3, 3.5, POW);
        double actualSecond = lambdaCalculatorTest.calculate(-2.3, 3.5, POW);
        assertEquals(18.45216, actualFirst, DELTA);
        assertEquals(Double.NaN, actualSecond, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValuesToTheNegativePower() {
        double actualFirst = lambdaCalculatorTest.calculate(2.3, -3.5, POW);
        double actualSecond = lambdaCalculatorTest.calculate(-2.3, -3.5, POW);
        assertEquals(0.05419, actualFirst, DELTA);
        assertEquals(Double.NaN, actualSecond, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValuesToZeroPower() {
        double actualFirst = lambdaCalculatorTest.calculate(2.3, 0.0, POW);
        double actualSecond = lambdaCalculatorTest.calculate(-2.3, 0.0, POW);
        assertEquals(1.0, actualFirst);
        assertEquals(1.0, actualSecond);
    }

    @Test
    void raisingZeroToPositiveOrNegativePower() {
        double actualFirst = lambdaCalculatorTest.calculate(0.0, 3.5, POW);
        double actualSecond = lambdaCalculatorTest.calculate(0.0, -3.5, POW);
        assertEquals(0.0, actualFirst, DELTA);
        assertEquals(Double.POSITIVE_INFINITY, actualSecond, DELTA);
    }

    @Test
    void checkForIllegalOperation() {
        assertThrows(RuntimeException.class,
                () -> lambdaCalculatorTest.calculate(0.0, -3.5, '$'));
    }
}
