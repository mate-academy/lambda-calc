package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final String FAILED_ADDITION_MSG = "Addition test failed, "
            + "expected: %.2f, actual: %.2f";
    private static final String FAILED_SUBTRACTION_MSG = "Subtraction test failed, "
            + "expected: %.2f, actual: %.2f";
    private static final String FAILED_MULTIPLICATION_MSG = "Multiplication test failed, "
            + "expected: %1f, actual: %1f";
    private static final String FAILED_DIVISION_MSG = "Division test failed, "
            + "expected: %1f, actual: %1f";
    private static final String FAILED_POWER_RISING_MSG = "Rising to power test failed, "
            + "expected: %1f, actual: %1f";
    private static final double ZERO = 0.0;
    private static final double DELTA = 0.0001;
    private static final char ILLEGAL_OPERATOR = '@';
    private Calculator calculator;
    private double actual;
    private double expected;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addition_bothPositive_isOk() {
        expected = 7.56;
        actual = calculator.calculate(3.5, 4.06, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));
    }

    @Test
    void addition_bothNegative_isOk() {
        expected = -9.5;
        actual = calculator.calculate(-4, -5.5, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));
    }

    @Test
    void addition_positiveAndNegative_isOk() {
        expected = -1.5;
        actual = calculator.calculate(4, -5.5, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));
    }

    @Test
    void addition_zeroOperations_isOk() {
        expected = 5.5;
        actual = calculator.calculate(5.5, ZERO, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));

        expected = -4;
        actual = calculator.calculate(ZERO, -4, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));

        expected = ZERO;
        actual = calculator.calculate(ZERO, ZERO, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));
    }

    @Test
    void addition_maximumValue_isOk() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_SUBTRACTION_MSG, expected, actual));
    }

    @Test
    void addition_minimumValue_isOk() {
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_SUBTRACTION_MSG, expected, actual));
    }

    @Test
    void subtraction_bothPositive_isOk() {
        expected = -1.5;
        actual = calculator.calculate(4, 5.5, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_SUBTRACTION_MSG, expected, actual));
    }

    @Test
    void subtraction_bothNegative_isOk() {
        expected = 1.5;
        actual = calculator.calculate(-4, -5.5, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_SUBTRACTION_MSG, expected, actual));
    }

    @Test
    void subtraction_positiveAndNegative_isOk() {
        expected = 9.5;
        actual = calculator.calculate(4, -5.5, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));
    }

    @Test
    void subtraction_zeroOperations_isOk() {
        expected = 5.5;
        actual = calculator.calculate(5.5, ZERO, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));

        expected = 4;
        actual = calculator.calculate(ZERO, -4, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));

        expected = ZERO;
        actual = calculator.calculate(ZERO, ZERO, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_ADDITION_MSG, expected, actual));
    }

    @Test
    void subtraction_maximumValue_isOk() {
        expected = ZERO;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_SUBTRACTION_MSG, expected, actual));
    }

    @Test
    void subtraction_minimumValue_isOk() {
        expected = ZERO;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_SUBTRACTION_MSG, expected, actual));
    }

    @Test
    void multiplication_bothPositive_isOk() {
        expected = 14.21;
        actual = calculator.calculate(3.5, 4.06, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));
    }

    @Test
    void multiplication_bothNegative_isOk() {
        expected = 22.0;
        actual = calculator.calculate(-4, -5.5, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));
    }

    @Test
    void multiplication_positiveAndNegative_isOk() {
        expected = -22.0;
        actual = calculator.calculate(4, -5.5, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));
    }

    @Test
    void multiplication_zeroOperations_isOk() {
        expected = ZERO;
        actual = calculator.calculate(5.5, ZERO, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));

        expected = ZERO;
        actual = calculator.calculate(ZERO, -4, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));

        expected = ZERO;
        actual = calculator.calculate(ZERO, ZERO, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));
    }

    @Test
    void multiplication_maximumValue_isOk() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));
    }

    @Test
    void multiplication_minimumValue_isOk() {
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_MULTIPLICATION_MSG, expected, actual));
    }

    @Test
    void division_bothPositive_isOk() {
        expected = 0.86206;
        actual = calculator.calculate(3.5, 4.06, '/');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_DIVISION_MSG, expected, actual));
    }

    @Test
    void division_bothNegative_isOk() {
        expected = 0.727272;
        actual = calculator.calculate(-4, -5.5, '/');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_DIVISION_MSG, expected, actual));
    }

    @Test
    void division_positiveAndNegative_isOk() {
        expected = -0.72727;
        actual = calculator.calculate(4, -5.5, '/');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_DIVISION_MSG, expected, actual));
    }

    @Test
    void division_zeroOperations_isOk() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, -4, '/');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_DIVISION_MSG, expected, actual));
    }

    @Test
    void divisionByZero_throwsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(1, ZERO, '/');
            calculator.calculate(ZERO, ZERO, '/');
        });
    }

    @Test
    void division_maximumValue_isOk() {
        expected = 1;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_DIVISION_MSG, expected, actual));
    }

    @Test
    void division_minimumValue_isOk() {
        expected = 1;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_DIVISION_MSG, expected, actual));
    }

    @Test
    void risingToEvenPositive_isOk() {
        expected = 410.0625;
        actual = calculator.calculate(4.5, 4, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));

        expected = 410.0625;
        actual = calculator.calculate(-4.5, 4, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));
    }

    @Test
    void risingToOddEvenPositive_isOk() {
        expected = 1845.28125;
        actual = calculator.calculate(4.5, 5, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));

        expected = -1845.28125;
        actual = calculator.calculate(-4.5, 5, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));
    }

    @Test
    void risingToEvenNegative_isOk() {
        expected = 0.002438;
        actual = calculator.calculate(4.5, -4, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));

        expected = 0.002438;
        actual = calculator.calculate(-4.5, -4, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));
    }

    @Test
    void risingToOddNegative_isOk() {
        expected = 0.010973;
        actual = calculator.calculate(4.5, -3, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));

        expected = -0.010973;
        actual = calculator.calculate(-4.5, -3, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));
    }

    @Test
    void risingToZeroPower_isOk() {
        expected = 1;
        actual = calculator.calculate(4.5, ZERO, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));

        expected = 1;
        actual = calculator.calculate(-4.5, ZERO, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));

        expected = 1;
        actual = calculator.calculate(ZERO, ZERO, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));
    }

    @Test
    void risingZeroToPower_isOk() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, 4.5, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));

        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(ZERO, -4.5, '^');
        assertEquals(expected, actual, DELTA,
                String.format(FAILED_POWER_RISING_MSG, expected, actual));
    }

    @Test
    void illegalOperation_throwsException() {
        assertThrows(IllegalOperationException.class, () -> {
            calculator.calculate(1,2, ILLEGAL_OPERATOR);
        });
    }
}
