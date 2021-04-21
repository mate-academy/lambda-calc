package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalcTest {
    private static LambdaCalc lambdaCalc;
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final double DELTA = 0.0001;

    @BeforeAll
    static void setUp() {
        lambdaCalc = new LambdaCalc();
    }

    @Test
    void additionTwoPositiveValues() {
        double actual = lambdaCalc.calculate(2.3, 3.5, ADD);
        assertEquals(5.8, actual);
    }

    @Test
    void additionTwoNegativeValues() {
        double actual = lambdaCalc.calculate(-2.3, -3.5, ADD);
        assertEquals(-5.8, actual);
    }

    @Test
    void additionFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalc.calculate(2.3, -3.5, ADD);
        assertEquals(-1.2, actual, DELTA);
    }

    @Test
    void additionFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalc.calculate(-2.3, 3.5, ADD);
        assertEquals(1.2, actual, DELTA);
    }

    @Test
    void additionWithZeroValues() {
        double actualFirst = lambdaCalc.calculate(0.0, 3.5, ADD);
        double actualSecond = lambdaCalc.calculate(2.3, 0.0, ADD);
        double actualThird = lambdaCalc.calculate(0.0, 0.0, ADD);
        assertEquals(3.5, actualFirst);
        assertEquals(2.3, actualSecond);
        assertEquals(0.0, actualThird);
    }

    @Test
    void additionForMinAndMaxDoubleValues() {
        double actualFirst = lambdaCalc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actualFirst);
        double actualSecond = lambdaCalc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADD);
        assertEquals(Double.NEGATIVE_INFINITY, actualSecond);
        double actualThird = lambdaCalc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADD);
        assertEquals(0.0, actualThird);
        double actualFourth = lambdaCalc.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(0.0, actualFourth);
    }

    @Test
    void subtractionTwoPositiveValues() {
        double actual = lambdaCalc.calculate(2.3, 3.5, SUBTRACT);
        assertEquals(-1.2, actual, DELTA);
    }

    @Test
    void subtractionTwoNegativeValues() {
        double actual = lambdaCalc.calculate(-2.3, -3.5, SUBTRACT);
        assertEquals(1.2, actual, DELTA);
    }

    @Test
    void subtractionFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalc.calculate(2.3, -3.5, SUBTRACT);
        assertEquals(5.8, actual);
    }

    @Test
    void subtractionFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalc.calculate(-2.3, 3.5, SUBTRACT);
        assertEquals(-5.8, actual);
    }

    @Test
    void subtractionWithZeroValues() {
        double actualFirst = lambdaCalc.calculate(0.0, 3.5, SUBTRACT);
        double actualSecond = lambdaCalc.calculate(2.3, 0.0, SUBTRACT);
        double actualThird = lambdaCalc.calculate(0.0, 0.0, SUBTRACT);
        assertEquals(-3.5, actualFirst);
        assertEquals(2.3, actualSecond);
        assertEquals(0.0, actualThird);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues() {
        double actualFirst = lambdaCalc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(0.0, actualFirst);
        double actualSecond = lambdaCalc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACT);
        assertEquals(0.0, actualSecond);
        double actualThird = lambdaCalc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.POSITIVE_INFINITY, actualThird);
        double actualFourth = lambdaCalc.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.NEGATIVE_INFINITY, actualFourth);
    }

    @Test
    void multiplicationTwoPositiveValues() {
        double actual = lambdaCalc.calculate(2.3, 3.5, MULTIPLY);
        assertEquals(8.05, actual, DELTA);
    }

    @Test
    void multiplicationTwoNegativeValues() {
        double actual = lambdaCalc.calculate(-2.3, -3.5, MULTIPLY);
        assertEquals(8.05, actual, DELTA);
    }

    @Test
    void multiplicationFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalc.calculate(2.3, -3.5, MULTIPLY);
        assertEquals(-8.05, actual, DELTA);
    }

    @Test
    void multiplicationFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalc.calculate(-2.3, 3.5, MULTIPLY);
        assertEquals(-8.05, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroValues() {
        double actualFirst = lambdaCalc.calculate(0.0, 3.5, MULTIPLY);
        double actualSecond = lambdaCalc.calculate(2.3, 0.0, MULTIPLY);
        double actualThird = lambdaCalc.calculate(0.0, 0.0, MULTIPLY);
        assertEquals(0.0, actualFirst);
        assertEquals(0.0, actualSecond);
        assertEquals(0.0, actualThird);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues() {
        double actualFirst = lambdaCalc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualFirst);
        double actualSecond = lambdaCalc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualSecond);
        double actualThird = lambdaCalc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.NEGATIVE_INFINITY, actualThird);
        double actualFourth = lambdaCalc.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.NEGATIVE_INFINITY, actualFourth);
    }

    @Test
    void divisionTwoPositiveValues() {
        double actual = lambdaCalc.calculate(2.3, 3.5, DIVIDE);
        assertEquals(0.65714, actual, DELTA);
    }

    @Test
    void divisionTwoNegativeValues() {
        double actual = lambdaCalc.calculate(-2.3, -3.5, DIVIDE);
        assertEquals(0.65714, actual, DELTA);
    }

    @Test
    void divisionFirstPositiveAndSecondNegativeValues() {
        double actual = lambdaCalc.calculate(2.3, -3.5, DIVIDE);
        assertEquals(-0.65714, actual, DELTA);
    }

    @Test
    void divisionFirstNegativeAndSecondPositiveValues() {
        double actual = lambdaCalc.calculate(-2.3, 3.5, DIVIDE);
        assertEquals(-0.65714, actual, DELTA);
    }

    @Test
    void divisionFirstValueZero() {
        double actual = lambdaCalc.calculate(0.0, 3.5, DIVIDE);
        assertEquals(0.0, actual);
    }

    @Test
    void divisionSecondValueZero() {
        assertThrows(ArithmeticException.class,
                () -> lambdaCalc.calculate(2.3, 0, DIVIDE));
    }

    @Test
    void divisionForMinAndMaxDoubleValues() {
        double actualFirst = lambdaCalc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(1.0, actualFirst);
        double actualSecond = lambdaCalc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(1.0, actualSecond);
        double actualThird = lambdaCalc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(-1.0, actualThird);
        double actualFourth = lambdaCalc.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(-1.0, actualFourth);
    }

    @Test
    void raisingPositiveOrNegativeValuesToThePositivePower() {
        double actualFirst = lambdaCalc.calculate(2.3, 3.5, POW);
        double actualSecond = lambdaCalc.calculate(-2.3, 3.5, POW);
        assertEquals(18.45216, actualFirst, DELTA);
        assertEquals(Double.NaN, actualSecond, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValuesToTheNegativePower() {
        double actualFirst = lambdaCalc.calculate(2.3, -3.5, POW);
        double actualSecond = lambdaCalc.calculate(-2.3, -3.5, POW);
        assertEquals(0.05419, actualFirst, DELTA);
        assertEquals(Double.NaN, actualSecond, DELTA);
    }

    @Test
    void raisingPositiveOrNegativeValuesToZeroPower() {
        double actualFirst = lambdaCalc.calculate(2.3, 0.0, POW);
        double actualSecond = lambdaCalc.calculate(-2.3, 0.0, POW);
        assertEquals(1.0, actualFirst);
        assertEquals(1.0, actualSecond);
    }

    @Test
    void raisingZeroToPositiveOrNegativePower() {
        double actualFirst = lambdaCalc.calculate(0.0, 3.5, POW);
        double actualSecond = lambdaCalc.calculate(0.0, -3.5, POW);
        assertEquals(0.0, actualFirst, DELTA);
        assertEquals(Double.POSITIVE_INFINITY, actualSecond, DELTA);
    }

    @Test
    void checkForIllegalOperation() {
        assertThrows(RuntimeException.class, () -> lambdaCalc.calculate(0.0, -3.5, '$'));
    }
}
