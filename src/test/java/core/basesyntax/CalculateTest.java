package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char POWER_OPERATOR = '^';
    private static final double DELTA = 0.0001;
    private static Calculator calculatorTest;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculatorTest = new Calculator();
    }

    @Test
    public void sumWithTwoPositiveNumber() {
        actual = calculatorTest.calculator(1, 3, ADDITION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void sumWithTwoNegativesNumbers() {
        actual = calculatorTest.calculator(-10, -10, ADDITION_OPERATOR);
        expected = -20;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void sumWithTwoNumbersNegativesAndPositive() {
        actual = calculatorTest.calculator(-10, 12, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void sumWithFirstNumberZero() {
        actual = calculatorTest.calculator(0, 2, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void sumWithSecondNumberZero() {
        actual = calculatorTest.calculator(2, 0, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void sumWithMaxDoubleValues() {
        actual = calculatorTest.calculator(Double.MAX_VALUE, 2, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void sumWithMinDoubleValue() {
        actual = calculatorTest.calculator(Double.MIN_VALUE, 2, ADDITION_OPERATOR);
        expected = 2;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void subtractionWithTwoPositiveNumber() {
        actual = calculatorTest.calculator(5, 4, SUBTRACTION_OPERATOR);
        expected = 1;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void subtractionWithTwoNegativesNumbers() {
        actual = calculatorTest.calculator(-2, -2, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithPositiveAndNegative() {
        actual = calculatorTest.calculator(5, -5, SUBTRACTION_OPERATOR);
        expected = 10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithFirstNumberZero() {
        actual = calculatorTest.calculator(0, -1, SUBTRACTION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithSecondZero() {
        actual = calculatorTest.calculator(2, 0, SUBTRACTION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithDoubleMaxValue() {
        actual = calculatorTest.calculator(2, Double.MAX_VALUE, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithDoubleMinValue() {
        actual = calculatorTest.calculator(2, Double.MIN_VALUE, SUBTRACTION_OPERATOR);
        expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithTwoPositiveNumbers() {
        actual = calculatorTest.calculator(2, 2, MULTIPLICATION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithTwoNegativeNumbers() {
        actual = calculatorTest.calculator(-2, -2, MULTIPLICATION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithPositiveAndNegativeNumbers() {
        actual = calculatorTest.calculator(-2, 2, MULTIPLICATION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithFirstNumberZero() {
        actual = calculatorTest.calculator(0, 2, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithSecondNumberZero() {
        actual = calculatorTest.calculator(2, 0, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithDoubleMaxValue() {
        actual = calculatorTest.calculator(2, Double.MAX_VALUE, MULTIPLICATION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithDoubleMinValue() {
        actual = calculatorTest.calculator(2, Double.MIN_VALUE, MULTIPLICATION_OPERATOR);
        expected = 1.0E-323;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithTwoPositiveNumbers() {
        actual = calculatorTest.calculator(2, 2, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithTwoNegativeNumbers() {
        actual = calculatorTest.calculator(-2, -2, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithPositiveAndNegativeNumbers() {
        actual = calculatorTest.calculator(2, -2, DIVISION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithNumberFirstZero() {
        actual = calculatorTest.calculator(0, 2, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithNumberSecondZero() {
        actual = calculatorTest.calculator(2.0, 0, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithMaxDoubleValue() {
        actual = calculatorTest.calculator(2, Double.MAX_VALUE, DIVISION_OPERATOR);
        expected = 1.1125369292536007E-308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithMinDoubleValue() {
        actual = calculatorTest.calculator(2, Double.MIN_VALUE, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingWithPositiveNumberAndPositivePower() {
        actual = calculatorTest.calculator(2, 2, POWER_OPERATOR);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingWithNegativeNumberAndPositivePower() {
        actual = calculatorTest.calculator(-2, 2, POWER_OPERATOR);
        expected = -4;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    public void raisingWithPositiveNumberAndNegativePower() {
        actual = calculatorTest.calculator(2, -2, POWER_OPERATOR);
        expected = 0.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingWithNegativeNumberAndNegativePower() {
        actual = calculatorTest.calculator(-2, -2, POWER_OPERATOR);
        expected = -0.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingWithPositiveNumberAndZeroPower() {
        actual = calculatorTest.calculator(2, 0, POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingWithNegativeAndZeroPower() {
        actual = calculatorTest.calculator(-2, 0, POWER_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingZeroToPower() {
        actual = calculatorTest.calculator(0, 2, POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void illegalOperation() {
        assertThrows(RuntimeException.class, () -> {
            calculatorTest.calculator(2, 3, '@');
        });
    }
}
