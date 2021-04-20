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
    public void calculateAdditionTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
   public void calculateAdditionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, ADDITION);
        expected = ZERO + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, ADDITION);
        expected = NEGATIVE_NUMBER + ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = -Double.MAX_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = Double.MAX_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = Double.MAX_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        expected = -Double.MAX_VALUE + -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = -Double.MAX_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = POSITIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateSubtractionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateSubtractionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, SUBTRACTION);
        expected = ZERO - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, SUBTRACTION);
        expected = POSITIVE_NUMBER - ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = -Double.MAX_VALUE - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = Double.MAX_VALUE - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = Double.MAX_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION);
        expected = -Double.MAX_VALUE - -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = -Double.MAX_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = POSITIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = NEGATIVE_NUMBER / NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateDivisionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = NEGATIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateDivisionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        expected = ZERO / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithZeroInSecondOperand_ArithmeticException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    public void calculateDivisionWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, DIVISION);
        expected = -Double.MAX_VALUE / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, DIVISION);
        expected = Double.MAX_VALUE / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        expected = Double.MAX_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION);
        expected = -Double.MAX_VALUE / -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        expected = -Double.MAX_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        expected = ZERO * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        expected = POSITIVE_NUMBER * ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithMinDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = -Double.MAX_VALUE * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithMaxDoubleValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = Double.MAX_VALUE * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithTwoMaxDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithTwoMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION);
        expected = -Double.MAX_VALUE * -Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithMinDoubleValueAndMaxDoubleValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = -Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingToPositivePower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingToNegativePower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingToZeroPower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, ZERO);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        expected = Math.pow(POSITIVE_NUMBER, ZERO);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingZeroToPower_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POWER);
        expected = Math.pow(ZERO, POSITIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(ZERO, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateIllegalOperation_RuntimeException() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATIONS));
    }
}
