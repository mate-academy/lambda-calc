package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveOperands_Ok() {
        expected = 30.0;
        actual = calculator.calculate(20.0, 10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionTwoNegativeOperands_Ok() {
        expected = -30.0;
        actual = calculator.calculate(-20.0, -10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperands_Ok() {
        expected = 20.0;
        actual = calculator.calculate(30.0, -10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionFirstZeroOperand_Ok() {
        expected = 10.0;
        actual = calculator.calculate(0, 10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionSecondZeroOperand_Ok() {
        expected = 40.0;
        actual = calculator.calculate(40.0, 0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxDoubleOperands_Ok() {
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveOperands_Ok() {
        expected = 30.0;
        actual = calculator.calculate(40.0, 10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoNegativeOperands_Ok() {
        expected = -30.0;
        actual = calculator.calculate(-40.0, -10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperands_Ok() {
        expected = 50.0;
        actual = calculator.calculate(40.0, -10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionFirstZeroOperand_Ok() {
        expected = -10.0;
        actual = calculator.calculate(0, 10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionSecondZeroOperand_Ok() {
        expected = 40.0;
        actual = calculator.calculate(40.0, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxDoubleOperands_Ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveOperands_Ok() {
        expected = 400.0;
        actual = calculator.calculate(40.0, 10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationTwoNegativeOperands_Ok() {
        expected = 400.0;
        actual = calculator.calculate(-40.0, -10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperands_Ok() {
        expected = -400.0;
        actual = calculator.calculate(40.0, -10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationFirstZeroOperand_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationSecondZeroOperand_Ok() {
        expected = 0;
        actual = calculator.calculate(40.0, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxDoubleOperands_Ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveOperands_Ok() {
        expected = 4.0;
        actual = calculator.calculate(40.0, 10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionTwoNegativeOperands_Ok() {
        expected = 4.0;
        actual = calculator.calculate(-40.0, -10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperands_Ok() {
        expected = -4.0;
        actual = calculator.calculate(40.0, -10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionFirstZeroOperand_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionSecondZeroOperand_Ok() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, '/');
        });
    }

    @Test
    void calculate_divisionMaxDoubleOperands_Ok() {
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToPositivePower_Ok() {
        expected = 27.0;
        actual = calculator.calculate(3.0, 3.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToPositivePower_Ok() {
        expected = 9.0;
        actual = calculator.calculate(-3.0, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToNegativePower_Ok() {
        expected = 0.1;
        actual = calculator.calculate(10.0, -1.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToNegativePower_Ok() {
        expected = -1;
        actual = calculator.calculate(-1, -1, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroValueToPower_Ok() {
        expected = 0;
        actual = calculator.calculate(0.0, 1, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() {
        expected = 1;
        actual = calculator.calculate(10.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() {
        expected = 1;
        actual = calculator.calculate(-10.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingFirstIsZeroToNegativePower() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(0, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_Ok() {
        char illegalOperation = 'a';
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(100.0, 100.0, illegalOperation);
        });
    }
}
