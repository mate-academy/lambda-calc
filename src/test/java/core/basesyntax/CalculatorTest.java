package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITIONAL_OPERATION = '+';
    private static final char SUBTRACTION_OPERATION = '-';
    private static final char DIVISION_OPERATION = '/';
    private static final char MULTIPLICATION_OPERATION = '*';
    private static final char RAISING_OPERATION = '^';
    private static final char ILLEGAL_OPERATION = '%';
    private static final double DELTA = 0.0000001;
    private Calculator calculator;
    private double expected;
    private double actual;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_AddTwoPositiveNumbers_Ok() {
        actual = calculator.calculate(15.6852, 25.2358, ADDITIONAL_OPERATION);
        expected = 40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddTwoNegativeNumbers_Ok() {
        actual = calculator.calculate(-15.6852, -25.2358, ADDITIONAL_OPERATION);
        expected = -40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddNegativeAndPositiveNumbers_Ok() {
        actual = calculator.calculate(-15.6852, 25.2358, ADDITIONAL_OPERATION);
        expected = 9.5506;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(15.6852, -25.2358, ADDITIONAL_OPERATION);
        expected = -9.5506;
        assertEquals(expected, actual, DELTA,"Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddZeroAndDifferentNumbers_Ok() {
        actual = calculator.calculate(0, -25.2358, ADDITIONAL_OPERATION);
        expected = -25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(15.6852, 0, ADDITIONAL_OPERATION);
        expected = 15.6852;
        assertEquals(expected, actual, DELTA,"Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddMinValueOfDouble_OK() {
        actual = calculator.calculate(-Double.MAX_VALUE, 25.2358, ADDITIONAL_OPERATION);
        expected = -Double.MAX_VALUE + 25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddMaxValueOfDouble_NotOK() {
        actual = calculator.calculate(Double.MAX_VALUE, 25.2358, ADDITIONAL_OPERATION);
        expected = Double.MAX_VALUE + 25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubTwoPositiveNumbers_Ok() {
        actual = calculator.calculate(15.6852, 25.2358, SUBTRACTION_OPERATION);
        expected = -9.5506;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubTwoNegativeNumbers_Ok() {
        actual = calculator.calculate(-15.6852, -25.2358, SUBTRACTION_OPERATION);
        expected = 9.5506;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubNegativeAndPositiveNumbers_Ok() {
        actual = calculator.calculate(15.6852, -25.2358, SUBTRACTION_OPERATION);
        expected = 40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, 25.2358, SUBTRACTION_OPERATION);
        expected = -40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubZeroAndDifferentNumbers_Ok() {
        actual = calculator.calculate(0, -25.2358, SUBTRACTION_OPERATION);
        expected = 25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(0, 25.2358, SUBTRACTION_OPERATION);
        expected = -25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

    }

    @Test
    void calculate_SubMinValueOfDouble_NotOK() {
        actual = calculator.calculate(-Double.MAX_VALUE, 25.2358, SUBTRACTION_OPERATION);
        expected = -Double.MAX_VALUE + 25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubMaxValueOfDouble_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, 9515225.2358, SUBTRACTION_OPERATION);
        expected = Double.MAX_VALUE - 9515225.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionTwoPositiveNumbers_Ok() {
        actual = calculator.calculate(15.6852, 25.2358, DIVISION_OPERATION);
        expected = 0.621545582;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionTwoNegativeNumbers_Ok() {
        actual = calculator.calculate(-15.6852, -25.2358, DIVISION_OPERATION);
        expected = 0.621545582;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionNegativeAndPositiveNumbers_Ok() {
        actual = calculator.calculate(-15.6852, 25.2358, DIVISION_OPERATION);
        expected = -0.621545582;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionZeroAndDifferentNumbers_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(15.6852, 0, DIVISION_OPERATION);
        });
    }

    @Test
    void calculate_DivisionMinValueOfDouble_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, 9515225.2358, DIVISION_OPERATION);
        expected = Double.MAX_VALUE / 9515225.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionMaxValueOfDouble_OK() {
        actual = calculator.calculate(-Double.MAX_VALUE, 9515225.2358, DIVISION_OPERATION);
        expected = -Double.MAX_VALUE / 9515225.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationTwoPositiveNumbers_Ok() {
        actual = calculator.calculate(15.6852, 25.2358, MULTIPLICATION_OPERATION);
        expected = 395.82857016;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationTwoNegativeNumbers_Ok() {
        actual = calculator.calculate(-15.6852, -25.2358, MULTIPLICATION_OPERATION);
        expected = 395.82857016;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationNegativeAndPositiveNumbers_Ok() {
        actual = calculator.calculate(-15.6852, 25.2358, MULTIPLICATION_OPERATION);
        expected = -395.82857016;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationZeroAndDifferentNumbers_NotOk() {
        actual = calculator.calculate(0, 25.2358, MULTIPLICATION_OPERATION);
        expected = 0;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationMaxAndMinValueOfDouble_OK() {
        actual = calculator.calculate(15.6852, Double.MAX_VALUE, MULTIPLICATION_OPERATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        expected = Double.NEGATIVE_INFINITY;
        actual = calculator.calculate(-Double.MAX_VALUE, 25.2358, MULTIPLICATION_OPERATION);
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToPositivePower_OK() {
        actual = calculator.calculate(15.6852, 3, RAISING_OPERATION);
        expected = 3858.959_157_542;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, 3, RAISING_OPERATION);
        expected = -3858.959_157_542;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToNegativePower_OK() {
        actual = calculator.calculate(15.6852, -3, RAISING_OPERATION);
        expected = 2.591_372E-4;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, -3, RAISING_OPERATION);
        expected = -2.591_372E-4;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToZeroPower_OK() {
        actual = calculator.calculate(15.6852, 0, RAISING_OPERATION);
        expected = 1;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, 0, RAISING_OPERATION);
        expected = -1;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingZeroToPower_OK() {
        actual = calculator.calculate(0, 25, RAISING_OPERATION);
        expected = 0;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_illegalOperation_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(25865, 25.2358, ILLEGAL_OPERATION);
        });
    }
}
