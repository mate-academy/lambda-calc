package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double FIRST_POSITIVE_OPERAND = 1.5;
    private static final double SECOND_POSITIVE_OPERAND = 8.50;
    private static final double FIRST_NEGATIVE_OPERAND = -100.450;
    private static final double SECOND_NEGATIVE_OPERAND = -5.0;
    private static final double DELTA = 0.0001;
    private static final byte ZERO = 0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char EXPONENTIATION = '^';
    private static SimpleCalculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositiveOperands_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, ADDITION);
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, ADDITION);
        expected = -105.450;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirstNegativeOperand_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, FIRST_POSITIVE_OPERAND, ADDITION);
        expected = -98.95;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMinOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxValuesOperands_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMaxAndMinOperands_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, SUBTRACTION);
        expected = -7.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeOperands_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, SUBTRACTION);
        expected = -95.45;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstNegativeOperand_Ok() {
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, FIRST_POSITIVE_OPERAND, SUBTRACTION);
        expected = -101.95;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondNegativeOperand_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_OPERAND, FIRST_NEGATIVE_OPERAND, SUBTRACTION);
        expected = 101.95;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION);
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMaxOperands_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinAndMaxOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveOperands_Ok() {
        actual = calculator
                .calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, MULTIPLICATION);
        expected = 12.75;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_Ok() {
        actual = calculator
                .calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, MULTIPLICATION);
        expected = 502.25;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstNegativeOperand_Ok() {
        actual = calculator
                .calculate(FIRST_NEGATIVE_OPERAND, FIRST_POSITIVE_OPERAND, MULTIPLICATION);
        expected = -150.675;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMinOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxValuesOperands_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxAndMinOperands_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveOperands_Ok() {
        actual = calculator
                .calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, DIVISION);
        expected = 0.17647058823529413;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeOperands_Ok() {
        actual = calculator
                .calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, DIVISION);
        expected = 20.09;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithFirstNegativeOperand_Ok() {
        actual = calculator
                .calculate(FIRST_NEGATIVE_OPERAND, FIRST_POSITIVE_OPERAND, DIVISION);
        expected = -66.96666666666667;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondNegativeOperand_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_OPERAND, FIRST_NEGATIVE_OPERAND, DIVISION);
        expected = -0.014932802389248382;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMaxOperands_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinAndMaxOperands_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        expected = ZERO;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionByZero_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_POSITIVE_OPERAND, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_exponentiationToPositiveValue_Ok() {
        actual = calculator
                .calculate(FIRST_POSITIVE_OPERAND, SECOND_POSITIVE_OPERAND, EXPONENTIATION);
        expected = 31.388871489063344;
        assertEquals(expected, actual);
        actual = calculator
                .calculate(FIRST_NEGATIVE_OPERAND, SECOND_POSITIVE_OPERAND, EXPONENTIATION);
        expected = Double.NaN;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationToNegativeValue_Ok() {
        actual = calculator
                .calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, EXPONENTIATION);
        expected = 0.13168724279835392;
        assertEquals(expected, actual);
        actual = calculator
                .calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, EXPONENTIATION);
        expected = -9.77800589098601E-11;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationValueToZero_Ok() {
        actual = calculator.calculate(FIRST_POSITIVE_OPERAND, ZERO, EXPONENTIATION);
        expected = 1;
        assertEquals(expected, actual);
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, ZERO, EXPONENTIATION);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_exponentiationZero_Ok() {
        actual = calculator.calculate(ZERO, FIRST_POSITIVE_OPERAND, EXPONENTIATION);
        expected = ZERO;
        assertEquals(expected, actual);
        actual = calculator.calculate(ZERO, FIRST_NEGATIVE_OPERAND, EXPONENTIATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalOperationException.class, () -> {
            calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, '%');
        });
        assertThrows(IllegalOperationException.class, () -> {
            calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, '#');
        });
        assertThrows(IllegalOperationException.class, () -> {
            calculator.calculate(FIRST_POSITIVE_OPERAND, SECOND_NEGATIVE_OPERAND, '<');
        });
    }
}
