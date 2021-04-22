package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final int ZERO_OPERAND = 0;
    private static final char SUM_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char EXPONENT_OPERATOR = '^';
    private static final char ILLEGAL_OPERATOR = 'h';
    private static final double FIRST_OPERAND = 123.4567;
    private static final double SECOND_OPERAND = 8910.12345;
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addition_twoPositives_Ok() {
        expected = 9033.58015;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_twoNegatives_Ok() {
        expected = -9033.58015;
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_PositiveAndNegative_Ok() {
        double expected = 8786.666749999999;
        double actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_zeroValue_Ok() {
        expected = 123.4567;
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = 8910.12345;
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_maxValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_twoPositives_Ok() {
        expected = -8786.666749999999;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_twoNegatives_Ok() {
        expected = 8786.666749999999;
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_PositiveAndNegative_Ok() {
        expected = 9033.58015;
        actual = calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_zeroValue_Ok() {
        expected = 123.4567;
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = -8910.12345;
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_maxValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_twoPositives_Ok() {
        expected = 1100014.4377296148;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_twoNegatives_Ok() {
        expected = 1100014.4377296148;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_PositiveAndNegative_Ok() {
        expected = -1100014.4377296148;
        actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_zeroValue_Ok() {
        expected = 0.0;
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_maxValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_twoPositives_Ok() {
        expected = 0.013855778844455855;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_twoNegatives_Ok() {
        expected = 0.013855778844455855;
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_PositiveAndNegative_Ok() {
        expected = -0.013855778844455855;
        actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_zeroValue_Ok() {
        expected = 0.0;
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_zeroValue_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, DIVISION_OPERATOR));
    }

    @Test
    void division_maxValues_Ok() {
        expected = 2.0175849918917968E304;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ToPositivePower_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ToNegativePower_Ok() {
        expected = 0.0;
        actual = calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ToZeroPower_Ok() {
        expected = 1.0;
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = 1.0;
        actual = calculator.calculate(-FIRST_OPERAND, ZERO_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ZeroToPower_Ok() {
        expected = 0.0;
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = 0.0;
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, ILLEGAL_OPERATOR));
    }
}
