package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplementationTest {
    private static final double DELTA = 0.00001;
    private static final String DIVISION_OPERATION_MESSAGE = "Oops, operation of"
            + " division doesn't work correctly";
    private static final String MULTIPLICATION_OPERATION_MESSAGE = "Oops, operation of"
            + " multiplication doesn't work correctly";
    private static final String SUBTRACTION_OPERATION_MESSAGE = "Oops, operation of"
            + " subtraction doesn't work correctly";
    private static final String ADDITION_OPERATION_MESSAGE = "Oops, operation of"
            + " addition doesn't work correctly";
    private static CalculatorImplementation calculator;
    private static double actual;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImplementation();
    }

    @Test
    void addition_TwoPositiveOperands_Ok() {
        actual = calculator.calculate(200.3, 0.7, '+');
        expected = 201.0;
        assertEquals(actual, expected, DELTA, ADDITION_OPERATION_MESSAGE);
    }

    @Test
    void addition_TwoNegativeOperands_Ok() {
        actual = calculator.calculate(-20.65, -10.35, '+');
        expected = -31.0;
        assertEquals(actual, expected, DELTA, ADDITION_OPERATION_MESSAGE);
    }

    @Test
    void addition_positiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(150.0, -90.5, '+');
        expected = 59.5;
        assertEquals(actual, expected, DELTA, ADDITION_OPERATION_MESSAGE);
    }

    @Test
    void addition_NegativeAndPositiveOperands_Ok() {
        actual = calculator.calculate(-30.45, 30.05, '+');
        expected = -0.4;
        assertEquals(actual, expected, DELTA, ADDITION_OPERATION_MESSAGE);
    }

    @Test
    void addition_WithZero_Ok() {
        actual = calculator.calculate(0.0, 222.22, '+');
        expected = 222.22;
        assertEquals(actual, expected);
        actual = calculator.calculate(234.34, 0.0, '+');
        expected = 234.34;
        assertEquals(actual, expected, DELTA, ADDITION_OPERATION_MESSAGE);
    }

    @Test
    void addition_MinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        assertEquals(actual, expected, DELTA, ADDITION_OPERATION_MESSAGE);
    }

    @Test
    void subtraction_TwoPositiveOperands_Ok() {
        actual = calculator.calculate(125.75, 98.05, '-');
        expected = 27.7;
        assertEquals(actual, expected, DELTA, SUBTRACTION_OPERATION_MESSAGE);
    }

    @Test
    void subtraction_TwoNegativeOperands_Ok() {
        actual = calculator.calculate(-78.634, -18.995, '-');
        expected = -59.639;
        assertEquals(actual, expected, DELTA, SUBTRACTION_OPERATION_MESSAGE);
    }

    @Test
    void subtraction_PositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(123.456, -123.456, '-');
        expected = 246.912;
        assertEquals(actual, expected, DELTA, SUBTRACTION_OPERATION_MESSAGE);
    }

    @Test
    void subtraction_NegativeAndPositiveOperands_Ok() {
        actual = calculator.calculate(-232.98, 785.38, '-');
        expected = -1018.36;
        assertEquals(actual, expected, DELTA, SUBTRACTION_OPERATION_MESSAGE);
    }

    @Test
    void subtraction_WithZero_Ok() {
        actual = calculator.calculate(0.0, 444.44, '-');
        expected = -444.44;
        assertEquals(actual, expected, DELTA, SUBTRACTION_OPERATION_MESSAGE);
        actual = calculator.calculate(555.58, 0.0, '-');
        expected = 555.58;
        assertEquals(actual, expected, DELTA, SUBTRACTION_OPERATION_MESSAGE);
    }

    @Test
    void subtraction_MinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        assertEquals(actual, expected, DELTA, SUBTRACTION_OPERATION_MESSAGE);
    }

    @Test
    void multiplication_TwoPositiveOperands_Ok() {
        actual = calculator.calculate(2.34, 2.210, '*');
        expected = 5.1714;
        assertEquals(actual, expected, DELTA, MULTIPLICATION_OPERATION_MESSAGE);
    }

    @Test
    void multiplication_TwoNegativeOperands_Ok() {
        actual = calculator.calculate(-5.65, -7.77, '*');
        expected = 43.9005;
        assertEquals(actual, expected, DELTA, MULTIPLICATION_OPERATION_MESSAGE);
    }

    @Test
    void multiplication_PositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(15.0, -3.5, '*');
        expected = -52.5;
        assertEquals(actual, expected, DELTA, MULTIPLICATION_OPERATION_MESSAGE);
    }

    @Test
    void multiplication_NegativeAndPositiveOperands_Ok() {
        actual = calculator.calculate(-10.45, 10.05, '*');
        expected = -105.0225;
        assertEquals(actual, expected, DELTA, MULTIPLICATION_OPERATION_MESSAGE);
    }

    @Test
    void multiplication_WithZero_Ok() {
        actual = calculator.calculate(0.0, 12.22, '*');
        expected = 0;
        assertEquals(actual, expected, DELTA, MULTIPLICATION_OPERATION_MESSAGE);
        actual = calculator.calculate(15.15, 0.0, '*');
        expected = 0;
        assertEquals(actual, expected, DELTA, MULTIPLICATION_OPERATION_MESSAGE);
    }

    @Test
    void multiplication_MinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        assertEquals(actual, expected, DELTA, MULTIPLICATION_OPERATION_MESSAGE);
    }

    @Test
    void division_TwoPositiveOperands_Ok() {
        actual = calculator.calculate(60.30, 3.15, '/');
        expected = 19.1428571;
        assertEquals(actual, expected, DELTA, DIVISION_OPERATION_MESSAGE);
    }

    @Test
    void division_TwoNegativeOperands_Ok() {
        actual = calculator.calculate(-1.234, -0.456, '/');
        expected = 2.70614035;
        assertEquals(actual, expected, DELTA, DIVISION_OPERATION_MESSAGE);
    }

    @Test
    void division_PositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(15.0, -3.5, '/');
        expected = -4.28571429;
        assertEquals(actual, expected, DELTA, DIVISION_OPERATION_MESSAGE);
    }

    @Test
    void division_NegativeAndPositiveOperands_Ok() {
        actual = calculator.calculate(-10, 2, '/');
        expected = -5;
        assertEquals(actual, expected, DELTA, DIVISION_OPERATION_MESSAGE);
    }

    @Test
    void division_WithZero_Ok() {
        actual = calculator.calculate(0.0, 35.35, '/');
        expected = 0;
        assertEquals(actual, expected, DELTA, DIVISION_OPERATION_MESSAGE);
    }

    @Test
    void division_WhenSecondOperandZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(100.55, 0, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, '/'));
    }

    @Test
    void division_MinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        assertEquals(actual, expected, DELTA, DIVISION_OPERATION_MESSAGE);
    }

    @Test
    void raising_ToAPowerTwoPositiveOperands_Ok() {
        actual = calculator.calculate(2, 5, '^');
        expected = 32;
        assertEquals(actual, expected);
    }

    @Test
    void raising_ToAPowerTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-2, -5, '^');
        expected = -0.03125;
        assertEquals(actual, expected);
    }

    @Test
    void raising_ToAPowerPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(2, -5, '^');
        expected = 0.03125;
        assertEquals(actual, expected);
    }

    @Test
    void raising_ToAPowerNegativeAndPositiveOperands_Ok() {
        actual = calculator.calculate(-10, 2, '^');
        expected = 100;
        assertEquals(actual, expected);
    }

    @Test
    void raising_ToAPowerWithZero_Ok() {
        actual = calculator.calculate(0, 2, '^');
        expected = 0;
        assertEquals(actual, expected);
        actual = calculator.calculate(2, 0, '^');
        expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(20, 4, '#'));
    }
}
