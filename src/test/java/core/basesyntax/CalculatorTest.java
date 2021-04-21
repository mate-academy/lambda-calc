package core.basesyntax;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final String MESSAGE_ADDITION = "Addition isn't correct, "
            + "expected: %1f but was: %1f";
    private static final String MESSAGE_SUBTRACTION = "Subtraction isn't correct, "
            + "expected: %1f but was: %1f";
    private static final String MESSAGE_MULTIPLICATION = "Multiplication isn't correct, "
            + "expected: %1f but was: %1f";
    private static final String MESSAGE_DIVISION = "Division isn't correct, "
            + "expected: %1f but was: %1f";
    private static final String MESSAGE_POWER = "Rising to power isn't correct, "
            + "expected: %1f but was: %1f";
    private static final double ZERO = 0.0;
    private static final double DELTA = 0.0001;
    private static final char ILLEGAL_OPERATOR_SYMBOL = '#';
    private static final char ILLEGAL_OPERATOR_LETTER = 'a';
    private static final char ILLEGAL_OPERATOR_DIGIT = '1';
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addition_TwoPositiveArguments() {
        expected = 5.9;
        actual = calculator.calculate(2.6, 3.3, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));
    }

    @Test
    void addition_TwoNegativeArguments() {
        expected = -4.6;
        actual = calculator.calculate(-3.2, -1.4, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));
    }

    @Test
    void addition_MixedArguments() {
        expected = 4.8;
        actual = calculator.calculate(7.3, -2.5, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));

        expected = -2.1;
        actual = calculator.calculate(-3.5, 1.4, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));
    }

    @Test
    void addition_MaxValue() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));
    }

    @Test
    void addition_MinValue() {
        expected = 1.0E-323;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));
    }

    @Test
    void addition_WithZero() {
        expected = 4.3;
        actual = calculator.calculate(4.3, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));

        expected = -7.8;
        actual = calculator.calculate(-7.8, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));

        expected = 1.2;
        actual = calculator.calculate(ZERO, 1.2, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));

        expected = -3.4;
        actual = calculator.calculate(ZERO, -3.4, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));

        expected = ZERO + ZERO;
        actual = calculator.calculate(ZERO, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_ADDITION, expected, actual));
    }

    @Test
    void subtraction_TwoPositiveArguments() {
        expected = 2.2;
        actual = calculator.calculate(5.4, 3.2, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));
    }

    @Test
    void subtraction_TwoNegativeArguments() {
        expected = -2.0;
        actual = calculator.calculate(-7.3, -5.3, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));
    }

    @Test
    void subtraction_MixedArguments() {
        expected = 14.3;
        actual = calculator.calculate(8.2, -6.1, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));

        expected = -14.0;
        actual = calculator.calculate(-11.6, 2.4, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));
    }

    @Test
    void subtraction_MaxValue() {
        expected = 0.0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));
    }

    @Test
    void subtraction_MinValue() {
        expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));
    }

    @Test
    void subtraction_WithZero() {
        expected = 1.3;
        actual = calculator.calculate(1.3, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));

        expected = -7.0;
        actual = calculator.calculate(-7.0, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));

        expected = -3.3;
        actual = calculator.calculate(ZERO, 3.3, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));

        expected = 6.2;
        actual = calculator.calculate(ZERO, -6.2, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));

        expected = 0.0;
        actual = calculator.calculate(ZERO, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_SUBTRACTION, expected, actual));
    }

    @Test
    void multiplication_TwoPositiveArguments() {
        expected = 4.76;
        actual = calculator.calculate(1.7, 2.8, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));
    }

    @Test
    void multiplication_TwoNegativeArguments() {
        expected = 38.16;
        actual = calculator.calculate(-5.3, -7.2, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));
    }

    @Test
    void multiplication_MixedArguments() {
        expected = -11.89;
        actual = calculator.calculate(2.9, -4.1, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));

        expected = -230.01;
        actual = calculator.calculate(-12.3, 18.7, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));
    }

    @Test
    void multiplication_MaxValues() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));
    }

    @Test
    void multiplication_MinValues() {
        expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));
    }

    @Test
    void multiplication_WithZero() {
        expected = 0.0;
        actual = calculator.calculate(7.6, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));

        expected = 0.0;
        actual = calculator.calculate(-1.7, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));

        expected = 0.0;
        actual = calculator.calculate(ZERO, 4.1, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));

        expected = 0.0;
        actual = calculator.calculate(ZERO, -9.2, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));

        expected = 0.0;
        actual = calculator.calculate(ZERO, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_MULTIPLICATION, expected, actual));
    }

    @Test
    void division_TwoPositiveArguments() {
        expected = 0.3636;
        actual = calculator.calculate(2.4, 6.6, DIVISION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_DIVISION, expected, actual));
    }

    @Test
    void division_TwoNegativeArguments() {
        expected = 2.0588;
        actual = calculator.calculate(-3.5, -1.7, DIVISION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_DIVISION, expected, actual));
    }

    @Test
    void division_MixedArguments() {
        expected = -2.0819;
        actual = calculator.calculate(25.4, -12.2, DIVISION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_DIVISION, expected, actual));

        expected = -2.873;
        actual = calculator.calculate(-18.1, 6.3, DIVISION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_DIVISION, expected, actual));
    }

    @Test
    void division_MaxValue() {
        expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_DIVISION, expected, actual));
    }

    @Test
    void division_MinValue() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA,
                String.format(MESSAGE_DIVISION, expected, actual));
    }

    @Test
    void division_WithZero_ThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(3.1, ZERO, DIVISION));
        assertThrows(ArithmeticException.class, () -> calculator
                .calculate(-2.4, ZERO, DIVISION));
    }

    @Test
    void power_PositiveArgumentTwoPositivePower() {
        expected = 19475.4273;
        actual = calculator.calculate(4.1, 7.0, POWER);
        assertEquals(expected, actual, DELTA, String.format(MESSAGE_POWER, expected, actual));
    }

    @Test
    void power_NegativeArgumentTwoPositivePower() {
        expected = NaN;
        actual = calculator.calculate(-1.3, 2.1, POWER);
        assertEquals(expected, actual, DELTA, String.format(MESSAGE_POWER, expected, actual));
    }

    @Test
    void power_MixedArguments() {
        expected = 501.7599;
        actual = calculator.calculate(-22.4, 2.0, POWER);
        assertEquals(expected, actual, DELTA, String.format(MESSAGE_POWER, expected, actual));

        expected = 8.394812048711156E-6;
        actual = calculator.calculate(17.3, -4.1, POWER);
        assertEquals(expected, actual, DELTA, String.format(MESSAGE_POWER, expected, actual));
    }

    @Test
    void power_WithZero() {
        expected = 1.0;
        actual = calculator.calculate(-3.3, ZERO, POWER);
        assertEquals(expected, actual, DELTA, String.format(MESSAGE_POWER, expected, actual));

        expected = 1.0;
        actual = calculator.calculate(6.2, ZERO, POWER);
        assertEquals(expected, actual, DELTA, String.format(MESSAGE_POWER, expected, actual));

        expected = 0.0;
        actual = calculator.calculate(ZERO, 6.4, POWER);
        assertEquals(expected, actual, DELTA, String.format(MESSAGE_POWER, expected, actual));
    }

    @Test
    void calculate_IllegalOperation_ThrowsException() {
        assertThrows(IllegalOperatorationException.class, () -> {
            calculator.calculate(4.3, 3.2, ILLEGAL_OPERATOR_SYMBOL);
            calculator.calculate(-6.3, 8.4, ILLEGAL_OPERATOR_LETTER);
            calculator.calculate(-6.7, -9.1, ILLEGAL_OPERATOR_DIGIT);
        });
    }
}
