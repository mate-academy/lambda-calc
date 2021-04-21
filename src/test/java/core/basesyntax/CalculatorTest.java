package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    public static final int ZERO_OPERAND = 0;
    public static final char SUM_OPERATOR = '+';
    public static final char SUBTRACTION_OPERATOR = '-';
    public static final char MULTIPLICATION_OPERATOR = '*';
    public static final char DIVISION_OPERATOR = '/';
    public static final char EXPONENT_OPERATOR = '^';
    public static final char ILLEGAL_OPERATOR = 'h';
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
        expected = FIRST_OPERAND + SECOND_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_twoNegatives_Ok() {
        expected = -FIRST_OPERAND + -SECOND_OPERAND;
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_PositiveAndNegative_Ok() {
        double expected = -FIRST_OPERAND + SECOND_OPERAND;
        double actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_zeroValue_Ok() {
        expected = FIRST_OPERAND + ZERO_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = ZERO_OPERAND + SECOND_OPERAND;
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addition_maxValues_Ok() {
        expected = Double.MAX_VALUE + SECOND_OPERAND;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_twoPositives_Ok() {
        expected = FIRST_OPERAND - SECOND_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_twoNegatives_Ok() {
        expected = -FIRST_OPERAND - -SECOND_OPERAND;
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_PositiveAndNegative_Ok() {
        expected = FIRST_OPERAND - -SECOND_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_zeroValue_Ok() {
        expected = FIRST_OPERAND - ZERO_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = ZERO_OPERAND - SECOND_OPERAND;
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_maxValues_Ok() {
        expected = Double.MAX_VALUE - SECOND_OPERAND;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_twoPositives_Ok() {
        expected = FIRST_OPERAND * SECOND_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_twoNegatives_Ok() {
        expected = -FIRST_OPERAND * -SECOND_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_PositiveAndNegative_Ok() {
        expected = -FIRST_OPERAND * SECOND_OPERAND;
        actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_zeroValue_Ok() {
        expected = FIRST_OPERAND * ZERO_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplication_maxValues_Ok() {
        expected = Double.MAX_VALUE * SECOND_OPERAND;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_twoPositives_Ok() {
        expected = FIRST_OPERAND / SECOND_OPERAND;
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_twoNegatives_Ok() {
        expected = -FIRST_OPERAND / -SECOND_OPERAND;
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_PositiveAndNegative_Ok() {
        expected = -FIRST_OPERAND / SECOND_OPERAND;
        actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_zeroValue_Ok() {
        expected = ZERO_OPERAND / SECOND_OPERAND;
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
        expected = Double.MAX_VALUE / SECOND_OPERAND;
        actual = calculator.calculate(Double.MAX_VALUE, SECOND_OPERAND, DIVISION_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ToPositivePower_Ok() {
        expected = Math.pow(FIRST_OPERAND, SECOND_OPERAND);
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-FIRST_OPERAND, SECOND_OPERAND);
        actual = calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ToNegativePower_Ok() {
        expected = Math.pow(FIRST_OPERAND, -SECOND_OPERAND);
        actual = calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-FIRST_OPERAND, -SECOND_OPERAND);
        actual = calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ToZeroPower_Ok() {
        expected = Math.pow(FIRST_OPERAND, ZERO_OPERAND);
        actual = calculator.calculate(FIRST_OPERAND, ZERO_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-FIRST_OPERAND, ZERO_OPERAND);
        actual = calculator.calculate(-FIRST_OPERAND, ZERO_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raise_ZeroToPower_Ok() {
        expected = Math.pow(ZERO_OPERAND, SECOND_OPERAND);
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(ZERO_OPERAND, SECOND_OPERAND);
        actual = calculator.calculate(ZERO_OPERAND, SECOND_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, ILLEGAL_OPERATOR));
    }
}
