package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double ZERO = 0;
    private static final double FIRST_POS_OPERAND = 5;
    private static final double SECOND_POS_OPERAND = 10;
    private static final double FIRST_NEG_OPERAND = -5;
    private static final double SECOND_NEG_OPERAND = -10;
    private static final double SQUARE = 2;
    private static final double NEG_SQUARE = -2;
    private static final double DELTA = 0.0001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';
    private static final char ILLEGA_OPERATION = 'a';
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addWithTwoPos_Ok() {
        double expected = 15;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, ADDITION);
        assertEquals(expected, actual, "Test failed! Addition of two positive operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_addWithTwoNeg_Ok() {
        double expected = -15;
        double actual = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, ADDITION);
        assertEquals(expected, actual,"Test failed! Addition of two negative operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_addWithOnePosOneNeg_Ok() {
        double expected = -5;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, ADDITION);
        assertEquals(expected, actual, "Test failed! Addition of a positive operand and a negative"
                + "operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_addWithZero_Ok() {
        double expected = 5;
        double actual = calculator.calculate(FIRST_POS_OPERAND, ZERO, ADDITION);
        assertEquals(expected, actual, "Test failed! Addition of a positive operand and a zero"
                + " operand should be " + expected + " but was " + actual);
        actual = calculator.calculate(ZERO, FIRST_POS_OPERAND, ADDITION);
        assertEquals(expected, actual, "Test failed! Addition of a zero operand and a positive"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_addWithMaxAndMin_Ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA, "Test failed! Addition of min value and max value"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subWithTwoPos_Ok() {
        double expected = -5;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, "Test failed! Subtraction of two positive operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subWithTwoNeg_Ok() {
        double expected = 5;
        double actual = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, "Test failed! Subtraction of two negative operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subWithOnePosOneNeg_Ok() {
        double expected = 15;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, "Test failed! Subtraction of a positive operand and a "
                + "negative operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subWithZero_Ok() {
        double expected = 5;
        double actual = calculator.calculate(FIRST_POS_OPERAND, ZERO, SUBTRACTION);
        assertEquals(expected, actual, "Test failed! Subtraction of a zero operand and a positive"
                + " operand should be " + expected + " but was " + actual);
        actual = calculator.calculate(ZERO, FIRST_NEG_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, "Test failed! Subtraction of a zero operand and a negative"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_subWithMaxAndMin_Ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Test failed! Subtraction of min value and max value"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multWithTwoPos_Ok() {
        double expected = 50;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, MULTIPLICATION);
        assertEquals(expected, actual, "Test failed! Multiplication of two positive operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multWithTwoNeg_Ok() {
        double expected = 50;
        double actual = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, MULTIPLICATION);
        assertEquals(expected, actual, "Test failed! Multiplication of two negative operands"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multWithOnePosOneNeg_Ok() {
        double expected = -50;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, MULTIPLICATION);
        assertEquals(expected, actual, "Test failed! Multiplication of a positive operand and"
                + " a negative operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multWithZero_Ok() {
        double expected = 0;
        double actual = calculator.calculate(FIRST_POS_OPERAND, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, "Test failed! Multiplication of a positive operand and"
                + " a zero operand should be " + expected + " but was " + actual);
        expected = -0.0;
        actual = calculator.calculate(ZERO, SECOND_NEG_OPERAND, MULTIPLICATION);
        assertEquals(expected, actual, "Test failed! Multiplication of a zero operand and"
                + " a negative operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_multWithMaxAndMin_Ok() {
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Test failed! Multiplication of min value and "
                + "max value should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_divWithTwoPos_Ok() {
        double expected = 0.5;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, DIVISION);
        assertEquals(expected, actual, "Test failed! Division of two positive operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_divWithTwoNeg_Ok() {
        double expected = 0.5;
        double actual = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, DIVISION);
        assertEquals(expected, actual, "Test failed! Division of two negative operands should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_divWithOnePosOneNeg_Ok() {
        double expected = -0.5;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, DIVISION);
        assertEquals(expected, actual, "Test failed! Division of a positive operand and a negative"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_divWithZero_Ok() {
        double expected = -0.0;
        double actual = calculator.calculate(ZERO, SECOND_NEG_OPERAND, DIVISION);
        assertEquals(expected, actual, "Test failed! Division of a zero operand and a negative"
                + " operand should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_divWithZero_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIRST_POS_OPERAND, ZERO, DIVISION),
                "Test failed! Division by zero must throw the Arithmetic exception.");
    }

    @Test
    void calculate_divMinAndMax_Ok() {
        double expected = Double.MAX_VALUE / Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA, "Test failed! Division of min value and max value"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_powWithPos_Ok() {
        double expected = 25;
        double actual = calculator.calculate(FIRST_POS_OPERAND, SQUARE, RAISING_TO_POWER);
        assertEquals(expected, actual, "Test failed! Raising to positive power should be "
                + expected + " but was " + actual);
        actual = calculator.calculate(FIRST_NEG_OPERAND, SQUARE, RAISING_TO_POWER);
        assertEquals(expected, actual, "Test failed! Raising to positive power should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_powWithNeg_Ok() {
        double expected = 0.04;
        double actual = calculator.calculate(FIRST_POS_OPERAND, NEG_SQUARE, RAISING_TO_POWER);
        assertEquals(expected, actual, "Test failed! Raising to negative power should be "
                + expected + " but was " + actual);
        actual = calculator.calculate(FIRST_NEG_OPERAND, NEG_SQUARE, RAISING_TO_POWER);
        assertEquals(expected, actual, "Test failed! Raising to negative power should be "
                + expected + " but was " + actual);
    }

    @Test
    void calculate_powWithZero_Ok() {
        double expected = 1;
        double actual = calculator.calculate(FIRST_POS_OPERAND, ZERO, RAISING_TO_POWER);
        assertEquals(expected, actual, "Test failed! Raising to zero power"
                + " should be " + expected + " but was " + actual);
        actual = calculator.calculate(FIRST_NEG_OPERAND, ZERO, RAISING_TO_POWER);
        assertEquals(expected, actual, "Test failed! Raising to zero power"
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_powZeroPow_Ok() {
        double expected = 0;
        double actual = calculator.calculate(ZERO, SQUARE, RAISING_TO_POWER);
        assertEquals(expected, actual, "Test failed! Raising zero to positive power "
                + " should be " + expected + " but was " + actual);
    }

    @Test
    void calculate_powZeroPow_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(ZERO, NEG_SQUARE, RAISING_TO_POWER),
                "Test failed! Rasing zero to negetive power must throw the Arithmetic exception.");
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(ZERO, ZERO, RAISING_TO_POWER),
                "Test failed! Raising zero to zero power must throw the Arithmetic exception.");
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(FIRST_POS_OPERAND,
                        SECOND_POS_OPERAND,
                        ILLEGA_OPERATION),
                "Test failed! Illegal operation must throw the Arithmetic exception.");
    }
}
