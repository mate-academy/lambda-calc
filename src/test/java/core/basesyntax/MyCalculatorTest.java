package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char DIVISION = '/';
    public static final char MULTIPLICATION = '*';
    public static final char RISING = '^';
    private static final double DELTA = 0.00001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new MyCalculator();
    }

    @Test
    void additionTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, ADDITION);
        double expected = 15;
        assertEquals(expected,actual);
    }

    @Test
    void additionTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, ADDITION);
        double expected = -15;
        assertEquals(expected, actual);
    }

    @Test
    void additionNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-10,5, ADDITION);
        double expected = -5;
        assertEquals(expected,actual);
    }

    @Test
    void additionWithZero_OK() {
        double actual = calculator.calculate(0, 10, ADDITION);
        double expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void additionWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        double expected = 0;
        assertEquals(expected,actual,DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, SUBTRACTION);
        double expected = 5;
        assertEquals(expected,actual);
    }

    @Test
    void subtractionWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, SUBTRACTION);
        double expected = -5;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-5, 10, SUBTRACTION);
        double expected = -15;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroOperands_OK() {
        double actual = calculator.calculate(10, 0, SUBTRACTION);
        double expected = 10;
        assertEquals(expected, actual);
        expected = -10;
        actual = calculator.calculate(0, 10, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithMinValues_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, DIVISION);
        double expected = 2;
        assertEquals(expected,actual);
    }

    @Test
    void divisionWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, DIVISION);
        double expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-10, 2, DIVISION);
        double expected = -5;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithFirstZeroOperands_OK() {
        double actual = calculator.calculate(0, 10, DIVISION);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionOnZero_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, DIVISION);
        });
    }

    @Test
    void divisionWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithMinValues_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, MULTIPLICATION);
        double expected = 50;
        assertEquals(expected,actual);
    }

    @Test
    void multiplicationTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, MULTIPLICATION);
        double expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-10,5, MULTIPLICATION);
        double expected = -50;
        assertEquals(expected,actual);
    }

    @Test
    void multiplicationWithZero_OK() {
        double actual = calculator.calculate(0, 10, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected,actual,DELTA);
    }

    @Test
    void raisingPositiveToPositivePower_OK() {
        double expected = 32;
        double actual = calculator.calculate(2, 5, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToNegativePower_OK() {
        double expected = 0.125;
        double actual = calculator.calculate(2, -3, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToNegativePower_OK() {
        double expected = -0.125;
        double actual = calculator.calculate(-2, -3, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPositivePower_OK() {
        double expected = -27;
        double actual = calculator.calculate(-3, 3, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToZeroPower_OK() {
        double expected = 1;
        double actual = calculator.calculate(5, 0, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_OK() {
        double expected = 1;
        double actual = calculator.calculate(-5, 0, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_OK() {
        double expected = 0;
        double actual = calculator.calculate(0, 5, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void unknownOperation_OK() {
        assertThrows(UnknownOperationException.class, () -> {
            calculator.calculate(10, 10, '.');
        });
    }
}
