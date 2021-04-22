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
    public void calculate_additionWithTwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, ADD);
        assertEquals(FIRST_POS_OPERAND + SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_additionWithTwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, ADD);
        assertEquals(FIRST_NEG_OPERAND + SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_additionWithPositiveAndNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, ADD);
        assertEquals(FIRST_POS_OPERAND + SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_additionWithZero_isOk() {
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
    public void calculate_additionWithMaxValue_isOk() {
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
    public void calculate_additionWithMinValue_isOk() {
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
    public void calculate_additionWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(Double.MIN_VALUE + Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(Double.MAX_VALUE + Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_subtractionWithTwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, SUBTRACT);
        assertEquals(FIRST_POS_OPERAND - SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_subtractionWithTwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(FIRST_NEG_OPERAND - SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_subtractionWithPositiveAndNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, SUBTRACT);
        assertEquals(FIRST_POS_OPERAND - SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_subtractionWithZero_isOk() {
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
    public void calculate_subtractionWithMaxValue_isOk() {
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
    public void calculate_subtractionWithMinValue_isOk() {
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
    public void calculate_subtractionWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACT);
        assertEquals(Double.MIN_VALUE - Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACT);
        assertEquals(Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_multiplicationWithTwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, MULTIPLY);
        assertEquals(FIRST_POS_OPERAND * SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_multiplicationWithTwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, MULTIPLY);
        assertEquals(FIRST_NEG_OPERAND * SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_multiplicationWithPositiveAndNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, MULTIPLY);
        assertEquals(FIRST_POS_OPERAND * SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_multiplicationWithZero_isOk() {
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
    public void calculate_multiplicationWithMaxValue_isOk() {
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
    public void calculate_multiplicationWithMinValue_isOk() {
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
    public void calculate_multiplicationWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLY);
        assertEquals(Double.MIN_VALUE * Double.MAX_VALUE, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLY);
        assertEquals(Double.MAX_VALUE * Double.MIN_VALUE, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_divisionWithTwoPositiveOperands_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, DIVIDE);
        assertEquals(FIRST_POS_OPERAND / SECOND_POS_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_divisionWithTwoNegativeOperands_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, DIVIDE);
        assertEquals(FIRST_NEG_OPERAND / SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_divisionWithPositiveAndNegativeOperands_sOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, DIVIDE);
        assertEquals(FIRST_POS_OPERAND / SECOND_NEG_OPERAND, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_divisionWithZero_isOk() {
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
    public void calculate_divisionWithMaxValue_isOk() {
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
    public void calculate_divisionWithMinValue_isOk() {
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
    public void calculate_divisionWithMinAndMaxValue_isOk() {
        actualResult = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(0, actualResult, ERROR_MESSAGE);
        actualResult = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVIDE);
        assertEquals(Double.POSITIVE_INFINITY, actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithPositiveOperandToPositivePow_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_POS_OPERAND, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, SECOND_POS_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithNegativeOperandsToPositivePow_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_POS_OPERAND, POW);
        assertEquals(Math.pow(FIRST_NEG_OPERAND, SECOND_POS_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithPositiveOperandsToNegativePow_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, SECOND_NEG_OPERAND, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, SECOND_NEG_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithNegativeOperandsToNegativePow_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND, POW);
        assertEquals(Math.pow(FIRST_NEG_OPERAND, SECOND_NEG_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithPositiveOperandsToZeroPow_isOk() {
        actualResult = calculator.calculate(FIRST_POS_OPERAND, 0, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, 0), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithNegativeOperandsToZeroPow_isOk() {
        actualResult = calculator.calculate(FIRST_NEG_OPERAND, 0, POW);
        assertEquals(Math.pow(FIRST_POS_OPERAND, 0), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithZeroToPositivePow_isk() {
        actualResult = calculator.calculate(0, SECOND_POS_OPERAND, POW);
        assertEquals(Math.pow(0, SECOND_POS_OPERAND), actualResult, ERROR_MESSAGE);
    }

    @Test
    public void calculate_raisingWithZeroToNegativePow_isOk() {
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
