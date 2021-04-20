package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final char ILLEGAL_OPERATIONS = '?';
    private static final double POSITIVE_NUMBER = 20.5;
    private static final double NEGATIVE_NUMBER = -12.7;
    private static final double ZERO = 0;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    private static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void calculate_additionTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
   public void calculate_additionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, ADDITION);
        expected = ZERO + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, ADDITION);
        expected = NEGATIVE_NUMBER + ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = -Double.MAX_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = Double.MAX_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = Double.MAX_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        expected = -Double.MAX_VALUE + -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = -Double.MAX_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = POSITIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, SUBTRACTION);
        expected = ZERO - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, SUBTRACTION);
        expected = POSITIVE_NUMBER - ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = -Double.MAX_VALUE - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = Double.MAX_VALUE - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = Double.MAX_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION);
        expected = -Double.MAX_VALUE - -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = -Double.MAX_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = POSITIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = NEGATIVE_NUMBER / NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = NEGATIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        expected = ZERO / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithZeroInSecondOperand_ArithmeticException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    public void calculate_divisionWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, DIVISION);
        expected = -Double.MAX_VALUE / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, DIVISION);
        expected = Double.MAX_VALUE / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        expected = Double.MAX_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION);
        expected = -Double.MAX_VALUE / -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        expected = -Double.MAX_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        expected = ZERO * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        expected = POSITIVE_NUMBER * ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = -Double.MAX_VALUE * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = Double.MAX_VALUE * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION);
        expected = -Double.MAX_VALUE * -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = -Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingToPositivePower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingToNegativePower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingToZeroPower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, ZERO);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        expected = Math.pow(POSITIVE_NUMBER, ZERO);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingZeroToPower_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POWER);
        expected = Math.pow(ZERO, POSITIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(ZERO, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_illegalOperation_RuntimeException() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATIONS));
    }
}
