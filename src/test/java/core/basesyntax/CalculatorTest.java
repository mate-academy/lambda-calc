package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    static final char ADDITIONAL_OPERATION = '+';
    static final char SUBTRACTION_OPERATION = '-';
    static final char DIVISION_OPERATION = '/';
    static final char MULTIPLICATION_OPERATION = '*';
    static final char RAISING_OPERATION = '^';
    static final char ILLEGAL_OPERATION_1 = '%';
    static final char ILLEGAL_OPERATION_2 = '_';
    static final char ILLEGAL_OPERATION_3 = '?';
    static final double DELTA = 0.0000001;
    private final Calculator calculator = new Calculator();

    @Test
    void calculate_AddTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(15.6852, 25.2358, ADDITIONAL_OPERATION);
        double expected = 40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-15.6852, -25.2358, ADDITIONAL_OPERATION);
        double expected = -40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddNegativeAndPositiveNumbers_Ok() {
        double actual = calculator.calculate(-15.6852, 25.2358, ADDITIONAL_OPERATION);
        double expected = 9.5506;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(15.6852, -25.2358, ADDITIONAL_OPERATION);
        expected = -9.5506;
        assertEquals(expected, actual, DELTA,"Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddZeroAndDifferentNumbers_Ok() {
        double actual = calculator.calculate(0, -25.2358, ADDITIONAL_OPERATION);
        double expected = -25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(15.6852, 0, ADDITIONAL_OPERATION);
        expected = 15.6852;
        assertEquals(expected, actual, DELTA,"Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddMinValueOfDouble_OK() {
        double actual = calculator.calculate(-Double.MAX_VALUE, 25.2358, ADDITIONAL_OPERATION);
        double expected = -Double.MAX_VALUE + 25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_AddMaxValueOfDouble_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, 25.2358, ADDITIONAL_OPERATION);
        });
    }

    @Test
    void calculate_SubTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(15.6852, 25.2358, SUBTRACTION_OPERATION);
        double expected = -9.5506;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-15.6852, -25.2358, SUBTRACTION_OPERATION);
        double expected = 9.5506;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubNegativeAndPositiveNumbers_Ok() {
        double actual = calculator.calculate(15.6852, -25.2358, SUBTRACTION_OPERATION);
        double expected = 40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, 25.2358, SUBTRACTION_OPERATION);
        expected = -40.921;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_SubZeroAndDifferentNumbers_Ok() {
        double actual = calculator.calculate(0, -25.2358, SUBTRACTION_OPERATION);
        double expected = 25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(0, 25.2358, SUBTRACTION_OPERATION);
        expected = -25.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

    }

    @Test
    void calculate_SubMinValueOfDouble_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-Double.MAX_VALUE, 25.2358, SUBTRACTION_OPERATION);
        });

    }

    @Test
    void calculate_SubMaxValueOfDouble_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 9515225.2358, SUBTRACTION_OPERATION);
        double expected = Double.MAX_VALUE - 9515225.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(15.6852, 25.2358, DIVISION_OPERATION);
        double expected = 0.621545582;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-15.6852, -25.2358, DIVISION_OPERATION);
        double expected = 0.621545582;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionNegativeAndPositiveNumbers_Ok() {
        double actual = calculator.calculate(-15.6852, 25.2358, DIVISION_OPERATION);
        double expected = -0.621545582;
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
        double actual = calculator.calculate(Double.MAX_VALUE, 9515225.2358, DIVISION_OPERATION);
        double expected = Double.MAX_VALUE / 9515225.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_DivisionMaxValueOfDouble_OK() {
        double actual = calculator.calculate(-Double.MAX_VALUE, 9515225.2358, DIVISION_OPERATION);
        double expected = -Double.MAX_VALUE / 9515225.2358;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(15.6852, 25.2358, MULTIPLICATION_OPERATION);
        double expected = 395.82857016;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-15.6852, -25.2358, MULTIPLICATION_OPERATION);
        double expected = 395.82857016;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationNegativeAndPositiveNumbers_Ok() {
        double actual = calculator.calculate(-15.6852, 25.2358, MULTIPLICATION_OPERATION);
        double expected = -395.82857016;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationZeroAndDifferentNumbers_NotOk() {
        double actual = calculator.calculate(0, 25.2358, MULTIPLICATION_OPERATION);
        double expected = 0;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_MultiplicationMaxAndMinValueOfDouble_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, 25.2358, MULTIPLICATION_OPERATION);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-Double.MAX_VALUE, 25.2358, MULTIPLICATION_OPERATION);
        });
    }

    @Test
    void calculate_MultiplicationMaxAndMinValueOfDouble_OK() {
        double actual = calculator.calculate(0, Double.MAX_VALUE, MULTIPLICATION_OPERATION);
        double expected = 0;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-Double.MAX_VALUE, 0, MULTIPLICATION_OPERATION);
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToPositivePower_OK() {
        double actual = calculator.calculate(15.6852, 3, RAISING_OPERATION);
        double expected = 3858.959_157_542;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, 3, RAISING_OPERATION);
        expected = -3858.959_157_542;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToNegativePower_OK() {
        double actual = calculator.calculate(15.6852, -3, RAISING_OPERATION);
        double expected = 2.591_372E-4;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, -3, RAISING_OPERATION);
        expected = -2.591_372E-4;
        assertEquals(expected, actual, DELTA, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToZeroPower_OK() {
        double actual = calculator.calculate(15.6852, 0, RAISING_OPERATION);
        double expected = 1;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);

        actual = calculator.calculate(-15.6852, 0, RAISING_OPERATION);
        expected = -1;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_raisingZeroToPower_OK() {
        double actual = calculator.calculate(0, 25, RAISING_OPERATION);
        double expected = 0;
        assertEquals(expected, actual, "Result was wrong! Expected: " + expected
                + " but was: " + actual);
    }

    @Test
    void calculate_illegalOperation_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(25865, 25.2358, ILLEGAL_OPERATION_1);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(25865, 25.2358, ILLEGAL_OPERATION_2);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(25865, 25.2358, ILLEGAL_OPERATION_3);
        });
    }
}
