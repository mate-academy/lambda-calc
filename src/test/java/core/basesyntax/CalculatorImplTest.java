package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double DELTA = 0.001;
    private static final double ZERO = 0;
    private static final double ONE = 1;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVIDE = '/';
    private static final char MULTIPLY = '*';
    private static final char POWER = '^';
    private static final char ILLEGAL_OPERATOR = '?';
    private static Calculator calculator;
    private static double firstElement;
    private static double secondElement;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
        firstElement = 2.02432;
        secondElement = 1.04321;
    }

    @Test
    void additionalWithTwoPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, ADDITION);
        double expected = 3.067;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithTwoNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, ADDITION);
        double expected = -3.067;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithOneNegativeElement_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, ADDITION);
        double expected = 0.981;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithFirstElementZero_Ok() {
        double actual = calculator.calculate(firstElement, ZERO, ADDITION);
        double expected = 2.024;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithSecondElementZero_Ok() {
        double actual = calculator.calculate(ZERO, secondElement, ADDITION);
        double expected = 1.043;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithMaxDoubleValueAndZero_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, ZERO, ADDITION);
        double expected = Double.MAX_VALUE;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalWithMaxDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, secondElement, ADDITION);
        double expected = Double.MAX_VALUE;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalMaxDoubleToMaxDouble_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        double expected = Double.POSITIVE_INFINITY;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, firstElement, ADDITION);
        double expected = 2.024;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoElementsPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, DIVIDE);
        double expected = 1.940;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoElementsNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, DIVIDE);
        double expected = 1.940;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithOneElementNegative_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, DIVIDE);
        double expected = -1.940;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionOnZero_NotOk() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstElement, ZERO, DIVIDE);
        });
    }

    @Test
    void divisionWithZeroOnSecondElement_Ok() {
        double actual = calculator.calculate(ZERO, secondElement, DIVIDE);
        Assertions.assertEquals(ZERO, actual);
    }

    @Test
    void divisionWithMaxDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, firstElement, DIVIDE);
        double expected = Double.MAX_VALUE / 2.02432;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divisionWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, secondElement, DIVIDE);
        double expected = Double.MIN_VALUE / 1.04321;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoElementPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, SUBTRACTION);
        double expected = 0.981;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoElementNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, SUBTRACTION);
        double expected = -0.981;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithOneElementNegative_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, SUBTRACTION);
        double expected = 3.067;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithSecondElementZero_Ok() {
        double actual = calculator.calculate(firstElement, ZERO, SUBTRACTION);
        double expected = 2.024;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithFirstElementZero_Ok() {
        double actual = calculator.calculate(ZERO, secondElement, SUBTRACTION);
        double expected = -1.043;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithMaxDoubleValueAndPositiveOne_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, firstElement, SUBTRACTION);
        double expected = Double.MAX_VALUE - 2.02432;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractionWithMaxDoubleValueAndNegativeOne_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, -firstElement, SUBTRACTION);
        double expected = Double.MAX_VALUE + 2.02432;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractionWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, firstElement, SUBTRACTION);
        double expected = -2.024;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoElementsPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, MULTIPLY);
        double expected = 2.111;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoElementsNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, MULTIPLY);
        double expected = 2.111;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithOneElementNegative_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, MULTIPLY);
        double expected = -2.111;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithFirstElementZero_Ok() {
        double actual = calculator.calculate(firstElement, ZERO, MULTIPLY);
        double expected = ZERO;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithSecondElementZero_Ok() {
        double actual = calculator.calculate(ZERO, secondElement, MULTIPLY);
        double expected = ZERO;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithMaxDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, firstElement, MULTIPLY);
        double expected = Double.MAX_VALUE * 2.02432;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, firstElement, MULTIPLY);
        double expected = Double.MIN_VALUE * 2.02432;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raisePositiveValueToPositivePower_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, POWER);
        double expected = Math.pow(2.02432, 1.04321);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raisePositiveValueToNegativePower_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, POWER);
        double expected = Math.pow(2.02432, -1.04321);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseNegativeValueToPositivePower_Ok() {
        double actual = calculator.calculate(-firstElement, secondElement, POWER);
        double expected = Math.pow(-2.02432, 1.04321);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseNegativeValueToNegativePower_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, POWER);
        double expected = Math.pow(-2.02432, -1.04321);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseNegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(-2.02432, ZERO, POWER);
        double expected = ONE;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raisePositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(firstElement, ZERO, POWER);
        double expected = ONE;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseZeroToPower_Ok() {
        double actual = calculator.calculate(ZERO, firstElement, POWER);
        double expected = ZERO;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMaxDoubleToNegativeOne_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, -firstElement, POWER);
        double expected = Math.pow(Double.MAX_VALUE, -2.02432);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMaxDoubleToPositiveOne_NotOk() {
        double actual = calculator.calculate(Double.MAX_VALUE, firstElement, POWER);
        double expected = Math.pow(Double.MAX_VALUE, 2.02432);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMinDoubleToPositiveOne_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, firstElement, POWER);
        double expected = ZERO;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMinDoubleToNegativeOne_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, -firstElement, POWER);
        double expected = Math.pow(Double.MIN_VALUE, -2.02432);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOk() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstElement, secondElement, ILLEGAL_OPERATOR);
        });
    }
}
