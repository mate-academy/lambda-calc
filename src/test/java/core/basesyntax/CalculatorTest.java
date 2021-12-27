package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private static Calculator calculator;
    private static final double FIRST_POSITIVE_OPERAND = 11.13;
    private static final double SECOND_POSITIVE_OPERAND = 12.14;
    private static final double FIRST_NEGATIVE_OPERAND = -21.23;
    private static final double SECOND_NEGATIVE_OPERAND = -22.24;
    private static final double ZERO_OPERAND = 0.0;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';
    private static final char ILLEGAL_OPERATION = '$';

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, ADDITION);
        double expected = FIRST_POSITIVE_OPERAND + SECOND_POSITIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Addition of two positive operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_additionNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, ADDITION);
        double expected = FIRST_NEGATIVE_OPERAND + SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Addition of two negative operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, ADDITION);
        double expected = FIRST_POSITIVE_OPERAND + SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Addition of a positive operand and a negative"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_additionOperationWithOneZeroOperand_Ok() {
        double actual = calculator.calculate(ZERO_OPERAND,
                SECOND_NEGATIVE_OPERAND, ADDITION);
        double expected = ZERO_OPERAND + SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Addition of a zero operand and a negative"
                + " operand should be " + expected + " but was " + actual);

        actual = calculator.calculate(FIRST_POSITIVE_OPERAND,
                ZERO_OPERAND, ADDITION);
        expected = FIRST_POSITIVE_OPERAND + ZERO_OPERAND;
        assertEquals(expected, actual, "Test failed! Addition of a positive operand and a zero"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_additionOperationWithMinOrMaxOperand_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADDITION);
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Addition of min value and max value"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subtractionPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND,
                SUBTRACTION);
        double expected = FIRST_POSITIVE_OPERAND - SECOND_POSITIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Subtraction of two positive operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subtractionNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND,
                SUBTRACTION);
        double expected = FIRST_NEGATIVE_OPERAND - SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Subtraction of two negative operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND,
                SUBTRACTION);
        double expected = FIRST_POSITIVE_OPERAND - SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Subtraction of a positive operand and a "
                + "negative operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subtractionOperationWithOneZeroOperand_Ok() {
        double actual = calculator.calculate(ZERO_OPERAND, SECOND_NEGATIVE_OPERAND, SUBTRACTION);
        double expected = ZERO_OPERAND - SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Subtraction of a zero operand and a negative"
                + " operand should be " + expected + " but was " + actual);

        actual = calculator.calculate(FIRST_POSITIVE_OPERAND, ZERO_OPERAND, SUBTRACTION);
        expected = FIRST_POSITIVE_OPERAND - ZERO_OPERAND;
        assertEquals(expected, actual, "Test failed! Subtraction of a positive operand and a zero"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subtractionOperationWithMinOrMaxOperand_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Subtraction of min value and max value"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_divisionPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, DIVISION);
        double expected = FIRST_POSITIVE_OPERAND / SECOND_POSITIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Division of two positive operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_ivisionNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, DIVISION);
        double expected = FIRST_NEGATIVE_OPERAND / SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Division of two negative operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, DIVISION);
        double expected = FIRST_POSITIVE_OPERAND / SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Division of a positive operand and a negative"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_divisionOperationWithOneZeroOperand_Ok() {
        double actual = calculator.calculate(ZERO_OPERAND, SECOND_NEGATIVE_OPERAND, DIVISION);
        double expected = ZERO_OPERAND / SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Division of a zero operand and a negative"
                + " operand should be " + expected + " but was " + actual);

        assertThrows(ArithmeticException.class, () ->
                        calculator.calculate(FIRST_POSITIVE_OPERAND, ZERO_OPERAND, DIVISION),
                "Test failed! Division by zero must throw the Arithmetic exception.");
    }

    @Test
    void calculate_divisionOperationWithMinOrMaxOperand_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = Double.MIN_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Division of min value and max value"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multiplicationPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND,
                MULTIPLICATION);
        double expected = FIRST_POSITIVE_OPERAND * SECOND_POSITIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Multiplication of two positive operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND,
                MULTIPLICATION);
        double expected = FIRST_NEGATIVE_OPERAND * SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Multiplication of two negative operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND,
                MULTIPLICATION);
        double expected = FIRST_POSITIVE_OPERAND * SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Multiplication of a positive operand and"
                + " a negative operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multiplicationOperationWithOneZeroOperand_Ok() {
        double actual = calculator.calculate(ZERO_OPERAND, SECOND_NEGATIVE_OPERAND, MULTIPLICATION);
        double expected = ZERO_OPERAND * SECOND_NEGATIVE_OPERAND;
        assertEquals(expected, actual, "Test failed! Multiplication of a zero operand and"
                + " a negative operand should be " + expected + " but was " + actual);

        actual = calculator.calculate(FIRST_POSITIVE_OPERAND, ZERO_OPERAND, MULTIPLICATION);
        expected = FIRST_POSITIVE_OPERAND * ZERO_OPERAND;
        assertEquals(expected, actual, "Test failed! Multiplication of a positive operand and"
                + " a zero operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multiplicationOperationWithMinOrMaxOperand_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        double expected = Double.MIN_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Multiplication of min value and max value"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_raisingToPositivePower_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND,
                RAISING_TO_POWER);
        double expected = Math.pow(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND);
        assertEquals(expected, actual, "Test failed! Raising to positive power should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_raisingToNegativePower_Ok() {
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND,
                RAISING_TO_POWER);
        double expected = Math.pow(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND);
        assertEquals(expected, actual, "Test failed! Raising to negative power should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_raisingToZeroPower_Ok() {
        double actual = calculator.calculate(FIRST_POSITIVE_OPERAND,
                ZERO_OPERAND, RAISING_TO_POWER);
        double expected = Math.pow(FIRST_POSITIVE_OPERAND, ZERO_OPERAND);
        assertEquals(expected, actual, "Test failed! Raising to zero power"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        double actual = calculator.calculate(ZERO_OPERAND,
                SECOND_NEGATIVE_OPERAND, RAISING_TO_POWER);
        double expected = Math.pow(ZERO_OPERAND, SECOND_NEGATIVE_OPERAND);
        assertEquals(expected, actual, "Test failed! Raising zero to negative power "
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(FIRST_POSITIVE_OPERAND,
                        SECOND_POSITIVE_OPERAND, ILLEGAL_OPERATION),
                "Test failed! Only math operations can be used for math operations.");
    }
}
