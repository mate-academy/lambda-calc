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
    private static Calculator calculator;
    private static double firstOperand;
    private static double secondOperand;
    private static double delta;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
        firstOperand = 123.4567;
        secondOperand = 8910.12345;
        delta = 0.0001;
    }

    @Test
    void addition_twoPositives_Ok() {
        expected = firstOperand + secondOperand;
        actual = calculator.calculate(firstOperand, secondOperand, SUM_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void addition_twoNegatives_Ok() {
        expected = -firstOperand + -secondOperand;
        actual = calculator.calculate(-firstOperand, -secondOperand, SUM_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void addition_PositiveAndNegative_Ok() {
        double expected = -firstOperand + secondOperand;
        double actual = calculator.calculate(-firstOperand, secondOperand, SUM_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void addition_zeroValue_Ok() {
        expected = firstOperand + ZERO_OPERAND;
        actual = calculator.calculate(firstOperand, ZERO_OPERAND, SUM_OPERATOR);
        assertEquals(expected, actual, delta);

        expected = ZERO_OPERAND + secondOperand;
        actual = calculator.calculate(ZERO_OPERAND, secondOperand, SUM_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void addition_maxValues_Ok() {
        expected = Double.MAX_VALUE + secondOperand;
        actual = calculator.calculate(Double.MAX_VALUE, secondOperand, SUM_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void subtraction_twoPositives_Ok() {
        expected = firstOperand - secondOperand;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void subtraction_twoNegatives_Ok() {
        expected = -firstOperand - -secondOperand;
        actual = calculator.calculate(-firstOperand, -secondOperand, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void subtraction_PositiveAndNegative_Ok() {
        expected = firstOperand - -secondOperand;
        actual = calculator.calculate(firstOperand, -secondOperand, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void subtraction_zeroValue_Ok() {
        expected = firstOperand - ZERO_OPERAND;
        actual = calculator.calculate(firstOperand, ZERO_OPERAND, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, delta);

        expected = ZERO_OPERAND - secondOperand;
        actual = calculator.calculate(ZERO_OPERAND, secondOperand, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void subtraction_maxValues_Ok() {
        expected = Double.MAX_VALUE - secondOperand;
        actual = calculator.calculate(Double.MAX_VALUE, secondOperand, SUBTRACTION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void multiplication_twoPositives_Ok() {
        expected = firstOperand * secondOperand;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void multiplication_twoNegatives_Ok() {
        expected = -firstOperand * -secondOperand;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void multiplication_PositiveAndNegative_Ok() {
        expected = -firstOperand * secondOperand;
        actual = calculator.calculate(-firstOperand, secondOperand, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void multiplication_zeroValue_Ok() {
        expected = firstOperand * ZERO_OPERAND;
        actual = calculator.calculate(firstOperand, ZERO_OPERAND, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void multiplication_maxValues_Ok() {
        expected = Double.MAX_VALUE * secondOperand;
        actual = calculator.calculate(Double.MAX_VALUE, secondOperand, MULTIPLICATION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void division_twoPositives_Ok() {
        expected = firstOperand / secondOperand;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void division_twoNegatives_Ok() {
        expected = -firstOperand / -secondOperand;
        actual = calculator.calculate(-firstOperand, -secondOperand, DIVISION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void division_PositiveAndNegative_Ok() {
        expected = -firstOperand / secondOperand;
        actual = calculator.calculate(-firstOperand, secondOperand, DIVISION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void division_zeroValue_Ok() {
        expected = ZERO_OPERAND / secondOperand;
        actual = calculator.calculate(ZERO_OPERAND, secondOperand, DIVISION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void division_zeroValue_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(firstOperand, ZERO_OPERAND, DIVISION_OPERATOR));
    }

    @Test
    void division_maxValues_Ok() {
        expected = Double.MAX_VALUE / secondOperand;
        actual = calculator.calculate(Double.MAX_VALUE, secondOperand, DIVISION_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void raise_ToPositivePower_Ok() {
        expected = Math.pow(firstOperand, secondOperand);
        actual = calculator.calculate(firstOperand, secondOperand, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);

        expected = Math.pow(-firstOperand, secondOperand);
        actual = calculator.calculate(-firstOperand, secondOperand, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void raise_ToNegativePower_Ok() {
        expected = Math.pow(firstOperand, -secondOperand);
        actual = calculator.calculate(firstOperand, -secondOperand, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);

        expected = Math.pow(-firstOperand, -secondOperand);
        actual = calculator.calculate(-firstOperand, -secondOperand, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void raise_ToZeroPower_Ok() {
        expected = Math.pow(firstOperand, ZERO_OPERAND);
        actual = calculator.calculate(firstOperand, ZERO_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);

        expected = Math.pow(-firstOperand, ZERO_OPERAND);
        actual = calculator.calculate(-firstOperand, ZERO_OPERAND, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void raise_ZeroToPower_Ok() {
        expected = Math.pow(ZERO_OPERAND, secondOperand);
        actual = calculator.calculate(ZERO_OPERAND, secondOperand, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);

        expected = Math.pow(ZERO_OPERAND, secondOperand);
        actual = calculator.calculate(ZERO_OPERAND, secondOperand, EXPONENT_OPERATOR);
        assertEquals(expected, actual, delta);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(firstOperand, secondOperand, ILLEGAL_OPERATOR));
    }
}
