package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double FIRST_POS_OPERAND = 0.125;
    private static final double SECOND_POS_OPERAND = 7.1;
    private static final double FIRST_NEG_OPERAND = -2.0;
    private static final double SECOND_NEG_OPERAND = -12.52;
    private static final String ERROR_MESSAGE = "Expected and actual results not equal";
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static Calculator calculator;
    private double actualResult;

    @BeforeAll
    static void setUp_Calculator() {
        calculator = new Calculator();
    }

    @Test
    public void addition_TwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, ADD);
        assertEquals(FIRST_POS_OPERAND + SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void addition_TwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, ADD);
        assertEquals(FIRST_NEG_OPERAND + SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void addition_PositiveAndNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, ADD);
        assertEquals(FIRST_POS_OPERAND + SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void addition_Zero_isOk() {
        actualResult = calculator.calculate(0, SECOND_NEG_OPERAND, ADD);
        assertEquals(SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, 0, ADD);
        assertEquals(FIRST_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, 0, ADD);
        assertEquals(FIRST_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEG_OPERAND, ADD);
        assertEquals(SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, 0, ADD);
        assertEquals(0, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void addition_MaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.POSITIVE_INFINITY, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POS_OPERAND, ADD);
        assertEquals(Double.MAX_VALUE + SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEG_OPERAND, ADD);
        assertEquals(Double.MAX_VALUE + SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MAX_VALUE, ADD);
        assertEquals(FIRST_POS_OPERAND + Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MAX_VALUE, ADD);
        assertEquals(FIRST_NEG_OPERAND + Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void addition_MinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(Double.MIN_VALUE + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POS_OPERAND, ADD);
        assertEquals(Double.MIN_VALUE + SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEG_OPERAND, ADD);
        assertEquals(Double.MIN_VALUE + SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MIN_VALUE, ADD);
        assertEquals(FIRST_POS_OPERAND + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MIN_VALUE, ADD);
        assertEquals(FIRST_NEG_OPERAND + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void addition_MinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.MIN_VALUE + Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(Double.MAX_VALUE + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtraction_TwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, SUBTRACT);
        assertEquals(FIRST_POS_OPERAND - SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtraction_TwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(FIRST_NEG_OPERAND - SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtraction_PositiveAndNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(FIRST_POS_OPERAND - SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtraction_Zero_isOk() {
        actualResult = calculator.calculate(0, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(-SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, 0, SUBTRACT);
        assertEquals(FIRST_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, 0, SUBTRACT);
        assertEquals(FIRST_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(-SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, 0, SUBTRACT);
        assertEquals(0, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtraction_MaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POS_OPERAND, SUBTRACT);
        assertEquals(Double.MAX_VALUE - SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(Double.MAX_VALUE - SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MAX_VALUE, SUBTRACT);
        assertEquals(FIRST_POS_OPERAND - Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MAX_VALUE, SUBTRACT);
        assertEquals(FIRST_NEG_OPERAND - Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtraction_MinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACT);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POS_OPERAND, SUBTRACT);
        assertEquals(Double.MIN_VALUE - SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(Double.MIN_VALUE - SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MIN_VALUE, SUBTRACT);
        assertEquals(FIRST_POS_OPERAND - Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MIN_VALUE, SUBTRACT);
        assertEquals(FIRST_NEG_OPERAND - Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void subtraction_MinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.MIN_VALUE - Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACT);
        assertEquals(Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplication_TwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, MULTIPLY);
        assertEquals(FIRST_POS_OPERAND * SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplication_TwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, MULTIPLY);
        assertEquals(FIRST_NEG_OPERAND * SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplication_PositiveAndNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, MULTIPLY);
        assertEquals(FIRST_POS_OPERAND * SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplication_Zero_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, 0, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_POS_OPERAND, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, 0, MULTIPLY);
        assertEquals(FIRST_NEG_OPERAND * 0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEG_OPERAND, MULTIPLY);
        assertEquals(0 * SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, 0, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplication_MaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.POSITIVE_INFINITY, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POS_OPERAND, MULTIPLY);
        assertEquals(Double.MAX_VALUE * SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEG_OPERAND, MULTIPLY);
        assertEquals(Double.MAX_VALUE * SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MAX_VALUE, MULTIPLY);
        assertEquals(FIRST_POS_OPERAND * Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MAX_VALUE, MULTIPLY);
        assertEquals(FIRST_NEG_OPERAND * Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplication_MinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLY);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POS_OPERAND, MULTIPLY);
        assertEquals(Double.MIN_VALUE * SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEG_OPERAND, MULTIPLY);
        assertEquals(Double.MIN_VALUE * SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MIN_VALUE, MULTIPLY);
        assertEquals(FIRST_POS_OPERAND * Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MIN_VALUE, MULTIPLY);
        assertEquals(FIRST_NEG_OPERAND * Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void multiplication_MinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.MIN_VALUE * Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLY);
        assertEquals(Double.MAX_VALUE * Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void division_TwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, DIVIDE);
        assertEquals(FIRST_POS_OPERAND / SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void division_TwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, DIVIDE);
        assertEquals(FIRST_NEG_OPERAND / SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void division_PositiveAndNegativeOperands_sOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, DIVIDE);
        assertEquals(FIRST_POS_OPERAND / SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void division_Zero_isOk() {
        actualResult = calculator.calculate(0, SECOND_POS_OPERAND, DIVIDE);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(0, SECOND_NEG_OPERAND, DIVIDE);
        assertEquals(0 / SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIRST_POS_OPERAND, 0, DIVIDE));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIRST_NEG_OPERAND, 0, DIVIDE));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(0, 0, DIVIDE));
    }

    @Test
    public void division_MaxValue_isOk() {
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(1, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_POS_OPERAND, DIVIDE);
        assertEquals(Double.MAX_VALUE / SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, SECOND_NEG_OPERAND, DIVIDE);
        assertEquals(Double.MAX_VALUE / SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MAX_VALUE, DIVIDE);
        assertEquals(FIRST_POS_OPERAND / Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MAX_VALUE, DIVIDE);
        assertEquals(FIRST_NEG_OPERAND / Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void division_MinValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVIDE);
        assertEquals(1, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_POS_OPERAND, DIVIDE);
        assertEquals(Double.MIN_VALUE / SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MIN_VALUE, SECOND_NEG_OPERAND, DIVIDE);
        assertEquals(Double.MIN_VALUE / SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_POS_OPERAND, Double.MIN_VALUE, DIVIDE);
        assertEquals(FIRST_POS_OPERAND / Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, Double.MIN_VALUE, DIVIDE);
        assertEquals(FIRST_NEG_OPERAND / Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void division_MinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVIDE);
        assertEquals(Double.POSITIVE_INFINITY, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_PositiveOperandToPositivePow_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, SECOND_POS_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_NegativeOperandsToPositivePow_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_POS_OPERAND, POW);
        assertEquals(Math.pow(FIRST_NEG_OPERAND, SECOND_POS_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_PositiveOperandsToNegativePow_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, SECOND_NEG_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_NegativeOperandsToNegativePow_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, POW);
        assertEquals(Math.pow(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_PositiveOperandsToZeroPow_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, 0, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, 0), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_NegativeOperandsToZeroPow_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, 0, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, 0), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_ZeroToPositivePow_isk() {
        actualResult = calculator.calculate(0, SECOND_POS_OPERAND, POW);
        assertEquals(Math.pow(0, SECOND_POS_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void raising_ZeroToNegativePow_isOk() {
        actualResult = calculator.calculate(0, SECOND_NEG_OPERAND, POW);
        assertEquals(Math.pow(0, SECOND_NEG_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    void calculate_illegalOperation_isNotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, '%');
            calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, '$');
            calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, '&');
            calculator.calculate(0, SECOND_POS_OPERAND, '_');
        });
    }
}
