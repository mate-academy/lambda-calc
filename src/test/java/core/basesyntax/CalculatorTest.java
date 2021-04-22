package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLE = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositive_Ok() {
        double expected = 5;
        double actual = calculator.calculate(2, 3, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegative_Ok() {
        double expected = -5;
        double actual = calculator.calculate(-2, -3, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegative_Ok() {
        double expected = -1;
        double actual = calculator.calculate(2, -3, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroInTheFirstPosition_Ok() {
        double expected = 2;
        double actual = calculator.calculate(0, 2, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroInTheSecondPosition_Ok() {
        double expected = 3;
        double actual = calculator.calculate(3, 0, ADD);
        assertEquals(expected, actual);
    }

    //addition for min and max double values;
    @Test
    void calculate_additionToMaxValue_Ok() {
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, 1, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionToMinValue_Ok() {
        double expected = -Double.MAX_VALUE;
        double actual = calculator.calculate(-Double.MAX_VALUE, 1, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoPositive_Ok() {
        double expected = 7;
        double actual = calculator.calculate(10, 3, SUBTRACT);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegative_Ok() {
        double expected = -2;
        double actual = calculator.calculate(-5, -3, SUBTRACT);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegative_Ok() {
        double expected = 8;
        double actual = calculator.calculate(5, -3, SUBTRACT);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroInTheFirstPosition_Ok() {
        double expected = -2;
        double actual = calculator.calculate(0, 2, SUBTRACT);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroInTheSecondPosition_Ok() {
        double expected = 3;
        double actual = calculator.calculate(3, 0, SUBTRACT);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxValue_Ok() {
        double expected = -Double.MAX_VALUE;
        double actual = calculator.calculate(1, Double.MAX_VALUE, SUBTRACT);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinValue_Ok() {
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(1, -Double.MAX_VALUE, SUBTRACT);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositive_Ok() {
        double expected = 25;
        double actual = calculator.calculate(5, 5, MULTIPLE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoNegative_Ok() {
        double expected = 15;
        double actual = calculator.calculate(-5, -3, MULTIPLE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegative() {
        double expected = -15;
        double actual = calculator.calculate(5, -3, MULTIPLE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroInTheFirstPosition_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, MULTIPLE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroInTheSecondPosition_Ok() {
        double expected = 0;
        double actual = calculator.calculate(3, 0, MULTIPLE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxValue_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(2, Double.MAX_VALUE, MULTIPLE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMinValue_Ok() {
        double expected = Double.NEGATIVE_INFINITY;
        double actual = calculator.calculate(10, -Double.MAX_VALUE, MULTIPLE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoPositive_Ok() {
        double expected = 5;
        double actual = calculator.calculate(25, 5, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoNegative_Ok() {
        double expected = 4;
        double actual = calculator.calculate(-12, -3, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithPositiveAndNegative_Ok() {
        double expected = -5;
        double actual = calculator.calculate(15, -3, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroInTheFirstPosition_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionByZero_Ok() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(2, 0, DIVIDE);
        });
    }

    @Test
    void calculate_divisionMaxValueByMaxValue_Ok() {
        double expected = 1;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinValueByMinValue_Ok() {
        double expected = 1;
        double actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMaxValueByMinValue_Ok() {
        double expected = -1;
        double actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinValueByMaxValue_Ok() {
        double expected = -1;
        double actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithPositivePowerPositive_Ok() {
        double expected = 4;
        double actual = calculator.calculate(2, 2, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithPositivePowerNegative_Ok() {
        double expected = 0.25;
        double actual = calculator.calculate(2, -2, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithNegativePowerPositive_Ok() {
        double expected = 4;
        double actual = calculator.calculate(-2, 2, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithNegativePowerNegative_Ok() {
        double expected = 0.25;
        double actual = calculator.calculate(-2, -2, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithPositivePowerZero_Ok() {
        double expected = 1;
        double actual = calculator.calculate(2, 0, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithNegativePowerZero_Ok() {
        double expected = 1;
        double actual = calculator.calculate(-2, 0, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithZeroPowerPositive_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingWithZeroPowerNegative_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(0, -2, POW);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_unknownOperand_Ok() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(0, -2, '|');
        });
    }
}
