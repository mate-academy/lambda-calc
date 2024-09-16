package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POW = '^';
    private static final char ILLEGAL_ARGUMENT = '&';

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addingWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(125.6, 45.1, PLUS);
        double expected = 170.7;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-2, -3, PLUS);
        double expected = -5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addingWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(12.65, -2, PLUS);
        double expected = 10.65;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_Ok() {
        double actualWithPositive = calculator.calculate(0, 45, PLUS);
        double actualWithNegative = calculator.calculate(0, -45, PLUS);
        double expectedForPositiveNumber = 45;
        double expectedForNegativeNumber = -45;
        assertEquals(expectedForPositiveNumber, actualWithPositive);
        assertEquals(expectedForNegativeNumber, actualWithNegative);
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues_Ok() {
        double actualForMin = calculator.calculate(Double.MIN_VALUE, 1, PLUS);
        double actualForMax = calculator.calculate(Double.MAX_VALUE, 1, PLUS);
        double expectedForMin = 1;
        double expectedForMax = Double.MAX_VALUE;
        assertEquals(actualForMin, expectedForMin, DELTA);
        assertEquals(actualForMax, expectedForMax, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(1254.12, 54.12, MINUS);
        double expected = 1200;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-45, -12.5, MINUS);
        double expected = -32.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(450.54, -49.46, MINUS);
        double expected = 500;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_Ok() {
        double actualWithPositive = calculator.calculate(0, 45, MINUS);
        double actualWithNegative = calculator.calculate(0, -45, MINUS);
        double expectedForPositiveNumber = -45;
        double expectedForNegativeNumber = 45;
        assertEquals(expectedForPositiveNumber, actualWithPositive);
        assertEquals(expectedForNegativeNumber, actualWithNegative);
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues_Ok() {
        double actualForMin = calculator.calculate(Double.MIN_VALUE, 1, MINUS);
        double actualForMax = calculator.calculate(Double.MAX_VALUE - 1, Double.MAX_VALUE, MINUS);
        double expectedForMin = -1.0;
        double expectedForMax = 0.0;
        assertEquals(actualForMin, expectedForMin, DELTA);
        assertEquals(actualForMax, expectedForMax, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(12.5, 2.0, MULTIPLICATION);
        double expected = 25.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-5.2, -2.0, MULTIPLICATION);
        double expected = 10.4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(-5.5, 5.5, MULTIPLICATION);
        double expected = -30.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_Ok() {
        double actualWithPositive = calculator.calculate(0, 45.0, MULTIPLICATION);
        double actualWithNegative = calculator.calculate(0, -45.0, MULTIPLICATION);
        double expectedForPositiveNumber = 0.0;
        double expectedForNegativeNumber = -0.0;
        assertEquals(expectedForPositiveNumber, actualWithPositive);
        assertEquals(expectedForNegativeNumber, actualWithNegative);
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues_Ok() {
        double actualForMin = calculator.calculate(Double.MIN_VALUE, 1, MULTIPLICATION);
        double actualForMax = calculator.calculate(Double.MAX_VALUE, 1, MULTIPLICATION);
        double expectedForMin = 4.9E-324;
        double expectedForMax = 1.7976931348623157E308;
        assertEquals(actualForMin, expectedForMin, DELTA);
        assertEquals(actualForMax, expectedForMax, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(12.0, 2.0, DIVISION);
        double expected = 6.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-45.0, -22.5, DIVISION);
        double expected = 2.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(-5.5, 5.5, DIVISION);
        double expected = -1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroOnOtherNumber_Ok() {
        double actualWithPositive = calculator.calculate(0.0, 45.0, DIVISION);
        double actualWithNegative = calculator.calculate(0.0, -45.0, DIVISION);
        double expectedForPositiveNumber = 0.0;
        double expectedForNegativeNumber = -0.0;
        assertEquals(expectedForPositiveNumber, actualWithPositive);
        assertEquals(expectedForNegativeNumber, actualWithNegative);
    }

    @Test
    void calculate_divisionForMinAndMaxDoubleValues_Ok() {
        double actualForMin = calculator.calculate(Double.MIN_VALUE, 5.9, DIVISION);
        double actualForMax = calculator.calculate(Double.MAX_VALUE, 139.0, DIVISION);
        double expectedForMin = 0.0;
        double expectedForMax = 1.2933044135700114E306;
        assertEquals(actualForMin, expectedForMin, DELTA);
        assertEquals(actualForMax, expectedForMax, DELTA);
    }

    @Test
    void calculate_divisionZeroAndPositiveOrNegativeNumber_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(45.7546, 0, DIVISION));
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToThePositivePower_Ok() {
        double actualWithPositive = calculator.calculate(12.0, 2.0, POW);
        double actualWithNegative = calculator.calculate(-4.2, 4, POW);
        double expectedWithPositive = 144.0;
        double expectedWithNegative = 311.16960000000006;
        assertEquals(expectedWithPositive, actualWithPositive, DELTA);
        assertEquals(expectedWithNegative, actualWithNegative, DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToTheNegativePower_Ok() {
        double actualWithPositive = calculator.calculate(12.0, -2.0, POW);
        double actualWithNegative = calculator.calculate(-4.2, -4, POW);
        double expectedWithPositive = 0.006944444444444444;
        double expectedWithNegative = 0.0032136815421557885;
        assertEquals(expectedWithPositive, actualWithPositive, DELTA);
        assertEquals(expectedWithNegative, actualWithNegative, DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToZeroPower_Ok() {
        double actualWithPositive = calculator.calculate(12.0, 0.0, POW);
        double actualWithNegative = calculator.calculate(-4.2, 0.0, POW);
        double expectedWithPositive = 1.0;
        double expectedWithNegative = 1.0;
        assertEquals(expectedWithPositive, actualWithPositive, DELTA);
        assertEquals(expectedWithNegative, actualWithNegative, DELTA);
    }

    @Test
    void calculate_raisingZeroToPositiveAndZeroPower_Ok() {
        double actualWithZero = calculator.calculate(0.0, 0.0, POW);
        double actualWithPositive = calculator.calculate(0.0, 2, POW);
        double expectedWithZero = 1.0;
        double expectedWithPositive = 0.0;
        assertEquals(actualWithZero, expectedWithZero, DELTA);
        assertEquals(expectedWithPositive, actualWithPositive, DELTA);
    }

    @Test
    void calculate_raisingZeroToNegativePower_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(0.0, -5.4568, POW));
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(0.0,0.0, ILLEGAL_ARGUMENT));
    }
}
