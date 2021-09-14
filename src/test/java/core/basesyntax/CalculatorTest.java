package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double A_POSITIVE = 1.23;
    private static final double B_POSITIVE = 12.345;
    private static final double A_NEGATIVE = -123.456;
    private static final double B_NEGATIVE = -5.0;
    private static final byte ZERO = 0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char EXPONENTIATION = '^';
    private SimpleCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositiveOperands_Ok() {
        double actual = calculator.calculate(A_POSITIVE, B_POSITIVE, ADDITION);
        double expected = A_POSITIVE + B_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionNegativeOperands_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, ADDITION);
        double expected = A_NEGATIVE + B_NEGATIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirstNegativeOperand_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, A_POSITIVE, ADDITION);
        double expected = A_NEGATIVE + A_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMinOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        double expected = Double.MIN_VALUE + Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxValuesOperands_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        double expected = Double.MAX_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxAndMinOperands_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveOperands_Ok() {
        double actual = calculator.calculate(A_POSITIVE, B_POSITIVE, SUBTRACTION);
        double expected = A_POSITIVE - B_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeOperands_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, SUBTRACTION);
        double expected = A_NEGATIVE - B_NEGATIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstNegativeOperand_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, A_POSITIVE, SUBTRACTION);
        double expected = A_NEGATIVE - A_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondNegativeOperand_Ok() {
        double actual = calculator.calculate(A_POSITIVE, A_NEGATIVE, SUBTRACTION);
        double expected = A_POSITIVE - A_NEGATIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        double expected = Double.MIN_VALUE - Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxOperands_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double expected = Double.MAX_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinAndMaxOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveOperands_Ok() {
        double actual = calculator.calculate(A_POSITIVE, B_POSITIVE, MULTIPLICATION);
        double expected = A_POSITIVE * B_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, MULTIPLICATION);
        double expected = A_NEGATIVE * B_NEGATIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstNegativeOperand_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, A_POSITIVE, MULTIPLICATION);
        double expected = A_NEGATIVE * A_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMinOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        double expected = Double.MIN_VALUE * Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxValuesOperands_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        double expected = Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxAndMinOperands_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveOperands_Ok() {
        double actual = calculator.calculate(A_POSITIVE, B_POSITIVE, DIVISION);
        double expected = A_POSITIVE / B_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeOperands_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, DIVISION);
        double expected = A_NEGATIVE / B_NEGATIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithFirstNegativeOperand_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, A_POSITIVE, DIVISION);
        double expected = A_NEGATIVE / A_POSITIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondNegativeOperand_Ok() {
        double actual = calculator.calculate(A_POSITIVE, A_NEGATIVE, DIVISION);
        double expected = A_POSITIVE / A_NEGATIVE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        double expected = Double.MIN_VALUE / Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMaxOperands_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = Double.MAX_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinAndMaxOperands_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = Double.MIN_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionByZero_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(A_POSITIVE, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_exponentiationPositiveToPositiveValue_Ok() {
        double actual = calculator.calculate(A_POSITIVE, B_POSITIVE, EXPONENTIATION);
        double expected = Math.pow(A_POSITIVE, B_POSITIVE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationNegativeToPositiveValue_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, B_POSITIVE, EXPONENTIATION);
        double expected = Math.pow(A_NEGATIVE, B_POSITIVE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationPositiveToNegativeValue_Ok() {
        double actual = calculator.calculate(A_POSITIVE, B_NEGATIVE, EXPONENTIATION);
        double expected = Math.pow(A_POSITIVE, B_NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationNegativeToNegativeValue_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, EXPONENTIATION);
        double expected = Math.pow(A_NEGATIVE, B_NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationPositiveValueToZero_Ok() {
        double actual = calculator.calculate(A_POSITIVE, ZERO, EXPONENTIATION);
        double expected = Math.pow(A_POSITIVE, ZERO);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationNegativeValueToZero_Ok() {
        double actual = calculator.calculate(A_NEGATIVE, ZERO, EXPONENTIATION);
        double expected = Math.pow(A_NEGATIVE, ZERO);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationZeroToPositiveValue_Ok() {
        double actual = calculator.calculate(ZERO, A_POSITIVE, EXPONENTIATION);
        double expected = Math.pow(ZERO, A_POSITIVE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationZeroToNegativeValue_Ok() {
        double actual = calculator.calculate(ZERO, A_NEGATIVE, EXPONENTIATION);
        double expected = Math.pow(ZERO, A_NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalOperationException.class, () -> {
            calculator.calculate(A_POSITIVE, B_NEGATIVE, '%');
        });
    }
}
