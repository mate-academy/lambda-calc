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
    public void calculateAdditionTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = NEGATIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = POSITIVE_NUMBER + NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
   public void calculateAdditionWithZeroInFirstOperand_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, ADDITION);
        expected = ZERO + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithZeroInSecondOperand_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, ADDITION);
        expected = NEGATIVE_NUMBER + ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithMinDoubleValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = Double.MIN_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAdditionWithMaxDoubleValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, ADDITION);
        expected = Double.MAX_VALUE + POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = POSITIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateSubtractionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = NEGATIVE_NUMBER - POSITIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateSubtractionWithZeroInFirstOperand_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, SUBTRACTION);
        expected = ZERO - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithZeroInSecondOperand_Ok() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, SUBTRACTION);
        expected = POSITIVE_NUMBER - ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithMinDoubleValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = Double.MIN_VALUE - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSubtractionWithMaxDoubleValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, SUBTRACTION);
        expected = Double.MAX_VALUE - POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = POSITIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = NEGATIVE_NUMBER / NEGATIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateDivisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = NEGATIVE_NUMBER / POSITIVE_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateDivisionWithZeroInFirstOperand_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        expected = ZERO / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithZeroInSecondOperand_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    public void calculateDivisionWithMinDoubleValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, DIVISION);
        expected = Double.MIN_VALUE / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateDivisionWithMaxDoubleValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, DIVISION);
        expected = Double.MAX_VALUE / POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = POSITIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * NEGATIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = NEGATIVE_NUMBER * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithZeroInFirstOperand_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        expected = ZERO * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithZeroInSecondOperand_Ok() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        expected = POSITIVE_NUMBER * ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithMinDoubleValue_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = Double.MIN_VALUE * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateMultiplicationWithMaxDoubleValue_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        expected = Double.MAX_VALUE * POSITIVE_NUMBER;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingToPositivePower_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        expected = Math.pow(POSITIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingToNegativePower_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingToZeroPower_Ok() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, POWER);
        expected = Math.pow(NEGATIVE_NUMBER, ZERO);
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        expected = Math.pow(POSITIVE_NUMBER, ZERO);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateRaisingZeroToPower_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POWER);
        expected = Math.pow(ZERO, POSITIVE_NUMBER);
        assertEquals(expected, actual);
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, POWER);
        expected = Math.pow(ZERO, NEGATIVE_NUMBER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateIllegalOperation_NotOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATIONS));
    }
}
