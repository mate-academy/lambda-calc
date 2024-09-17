package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private static Calculator calculator;
    private final double firstPositiveOperand = 23.15;
    private final double secondPositiveOperand = 97.32;
    private final double firstNegativeOperand = -12.24;
    private final double secondNegativeOperand = -31.10;
    private final int zeroOperand = 0;

    private final char addition = '+';
    private final char subtraction = '-';
    private final char division = '/';
    private final char multiplication = '*';
    private final char raisingToPower = '^';
    private final char illegalOperation = 'k';

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionPositiveOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondPositiveOperand, addition);
        double expected = firstPositiveOperand + secondPositiveOperand;
        assertEquals(expected, actual, "Test failed! Addition of two positive operands should be "
                + expected + " but it is " + actual);
    }

    @Test
    void additionNegativeOperands() {
        double actual = calculator.calculate(firstNegativeOperand, secondNegativeOperand, addition);
        double expected = firstNegativeOperand + secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Addition of two negative operands should be "
                + expected + " but it is " + actual);
    }

    @Test
    void additionPositiveAndNegativeOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondNegativeOperand, addition);
        double expected = firstPositiveOperand + secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Addition of a positive operand and a negative"
                + " operand should be " + expected + " but it is " + actual);
    }

    @Test
    void additionOperationWithOneZeroOperand() {
        double actual = calculator.calculate(zeroOperand, secondNegativeOperand, addition);
        double expected = zeroOperand + secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Addition of a zero operand and a negative"
                + " operand should be " + expected + " but it is " + actual);

        actual = calculator.calculate(firstPositiveOperand, zeroOperand, addition);
        expected = firstPositiveOperand + zeroOperand;
        assertEquals(expected, actual, "Test failed! Addition of a positive operand and a zero"
                + " operand should be " + expected + " but it is " + actual);
    }

    @Test
    void additionOperationWithMinOrMaxOperand() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, addition);
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Addition of min value and max value"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void subtractionPositiveOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondPositiveOperand,
                subtraction);
        double expected = firstPositiveOperand - secondPositiveOperand;
        assertEquals(expected, actual, "Test failed! Subtraction of two positive operands"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void subtractionNegativeOperands() {
        double actual = calculator.calculate(firstNegativeOperand, secondNegativeOperand,
                subtraction);
        double expected = firstNegativeOperand - secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Subtraction of two negative operands"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void subtractionPositiveAndNegativeOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondNegativeOperand,
                subtraction);
        double expected = firstPositiveOperand - secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Subtraction of a positive operand and a "
                + "negative operand should be " + expected + " but it is " + actual);
    }

    @Test
    void subtractionOperationWithOneZeroOperand() {
        double actual = calculator.calculate(zeroOperand, secondNegativeOperand, subtraction);
        double expected = zeroOperand - secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Subtraction of a zero operand and a negative"
                + " operand should be " + expected + " but it is " + actual);

        actual = calculator.calculate(firstPositiveOperand, zeroOperand, subtraction);
        expected = firstPositiveOperand - zeroOperand;
        assertEquals(expected, actual, "Test failed! Subtraction of a positive operand and a zero"
                + " operand should be " + expected + " but it is " + actual);
    }

    @Test
    void subtractionOperationWithMinOrMaxOperand() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, subtraction);
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Subtraction of min value and max value"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void divisionPositiveOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondPositiveOperand, division);
        double expected = firstPositiveOperand / secondPositiveOperand;
        assertEquals(expected, actual, "Test failed! Division of two positive operands should be "
                + expected + " but it is " + actual);
    }

    @Test
    void divisionNegativeOperands() {
        double actual = calculator.calculate(firstNegativeOperand, secondNegativeOperand, division);
        double expected = firstNegativeOperand / secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Division of two negative operands should be "
                + expected + " but it is " + actual);
    }

    @Test
    void divisionPositiveAndNegativeOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondNegativeOperand, division);
        double expected = firstPositiveOperand / secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Division of a positive operand and a negative"
                + " operand should be " + expected + " but it is " + actual);
    }

    @Test
    void divisionOperationWithOneZeroOperand() {
        double actual = calculator.calculate(zeroOperand, secondNegativeOperand, division);
        double expected = zeroOperand / secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Division of a zero operand and a negative"
                + " operand should be " + expected + " but it is " + actual);

        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(firstPositiveOperand, zeroOperand, division),
                "Test failed! Division by zero must throw the Arithmetic exception.");
    }

    @Test
    void divisionOperationWithMinOrMaxOperand() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, division);
        double expected = Double.MIN_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Division of min value and max value"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void multiplicationPositiveOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondPositiveOperand,
                multiplication);
        double expected = firstPositiveOperand * secondPositiveOperand;
        assertEquals(expected, actual, "Test failed! Multiplication of two positive operands"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void multiplicationNegativeOperands() {
        double actual = calculator.calculate(firstNegativeOperand, secondNegativeOperand,
                multiplication);
        double expected = firstNegativeOperand * secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Multiplication of two negative operands"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void multiplicationPositiveAndNegativeOperands() {
        double actual = calculator.calculate(firstPositiveOperand, secondNegativeOperand,
                multiplication);
        double expected = firstPositiveOperand * secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Multiplication of a positive operand and"
                + " a negative operand should be " + expected + " but it is " + actual);
    }

    @Test
    void multiplicationOperationWithOneZeroOperand() {
        double actual = calculator.calculate(zeroOperand, secondNegativeOperand, multiplication);
        double expected = zeroOperand * secondNegativeOperand;
        assertEquals(expected, actual, "Test failed! Multiplication of a zero operand and"
                + " a negative operand should be " + expected + " but it is " + actual);

        actual = calculator.calculate(firstPositiveOperand, zeroOperand, multiplication);
        expected = firstPositiveOperand * zeroOperand;
        assertEquals(expected, actual, "Test failed! Multiplication of a positive operand and"
                + " a zero operand should be " + expected + " but it is " + actual);
    }

    @Test
    void multiplicationOperationWithMinOrMaxOperand() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, multiplication);
        double expected = Double.MIN_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, "Test failed! Multiplication of min value and max value"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void raisingToPositivePower() {
        double actual = calculator.calculate(firstPositiveOperand, secondPositiveOperand,
                raisingToPower);
        double expected = Math.pow(firstPositiveOperand, secondPositiveOperand);
        assertEquals(expected, actual, "Test failed! Raising to positive power should be "
                + expected + " but it is " + actual);
    }

    @Test
    void raisingToNegativePower() {
        double actual = calculator.calculate(firstNegativeOperand, secondNegativeOperand,
                raisingToPower);
        double expected = Math.pow(firstNegativeOperand, secondNegativeOperand);
        assertEquals(expected, actual, "Test failed! Raising to negative power should be "
                + expected + " but it is " + actual);
    }

    @Test
    void raisingToZeroPower() {
        double actual = calculator.calculate(firstPositiveOperand, zeroOperand, raisingToPower);
        double expected = Math.pow(firstPositiveOperand, zeroOperand);
        assertEquals(expected, actual, "Test failed! Raising to zero power"
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void raisingZeroToPower() {
        double actual = calculator.calculate(zeroOperand, secondNegativeOperand, raisingToPower);
        double expected = Math.pow(zeroOperand, secondNegativeOperand);
        assertEquals(expected, actual, "Test failed! Raising zero to negative power "
                + " should be " + expected + " but it is " + actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(firstPositiveOperand, secondPositiveOperand,
                        illegalOperation));
    }
}
