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
    void calculate_additionTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, ADDITION);
        double expected = 15;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_additionTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, ADDITION);
        double expected = -15;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-10,5, ADDITION);
        double expected = -5;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_additionWithZero_OK() {
        double actual = calculator.calculate(0, 10, ADDITION);
        double expected = 10;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        double expected = 0;
        assertEquals(expected,actual,DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, SUBTRACTION);
        double expected = 5;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, SUBTRACTION);
        double expected = -5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-5, 10, SUBTRACTION);
        double expected = -15;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroOperands_OK() {
        double actual = calculator.calculate(10, 0, SUBTRACTION);
        double expected = 10;
        assertEquals(expected, actual);
        expected = -10;
        actual = calculator.calculate(0, 10, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithMinValues_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, DIVISION);
        double expected = 2;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, DIVISION);
        double expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-10, 2, DIVISION);
        double expected = -5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithFirstZeroOperands_OK() {
        double actual = calculator.calculate(0, 10, DIVISION);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionOnZero_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, DIVISION);
        });
    }

    @Test
    void calculate_divisionWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMinValues_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, MULTIPLICATION);
        double expected = 50;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_multiplicationTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, MULTIPLICATION);
        double expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeAndPositiveOperands_OK() {
        double actual = calculator.calculate(-10,5, MULTIPLICATION);
        double expected = -50;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_multiplicationWithZero_OK() {
        double actual = calculator.calculate(0, 10, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(10, 0, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMaxValues_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected,actual,DELTA);
    }

    @Test
    void calculate_raisingPositiveToPositivePower_OK() {
        double expected = 32;
        double actual = calculator.calculate(2, 5, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveToNegativePower_OK() {
        double expected = 0.125;
        double actual = calculator.calculate(2, -3, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeToNegativePower_OK() {
        double expected = -0.125;
        double actual = calculator.calculate(-2, -3, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeToPositivePower_OK() {
        double expected = -27;
        double actual = calculator.calculate(-3, 3, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_OK() {
        double expected = 1;
        double actual = calculator.calculate(5, 0, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_OK() {
        double expected = 1;
        double actual = calculator.calculate(-5, 0, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_OK() {
        double expected = 0;
        double actual = calculator.calculate(0, 5, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_zeroToNegativePower_OK() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(0, -3, RISING);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_unknownOperation_OK() {
        assertThrows(UnknownOperationException.class, () -> {
            calculator.calculate(10, 10, '.');
        });
    }
}
