package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveOperands_Ok() {
        double expected = 30.0;
        double actual = calculator.calculate(20.0, 10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionTwoNegativeOperands_Ok() {
        double expected = -30.0;
        double actual = calculator.calculate(-20.0, -10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperands_Ok() {
        double expected = 20.0;
        double actual = calculator.calculate(30.0, -10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionFirstZeroOperand_Ok() {
        double expected = 10.0;
        double actual = calculator.calculate(0, 10.0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionSecondZeroOperand_Ok() {
        double expected = 40.0;
        double actual = calculator.calculate(40.0, 0, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxDoubleOperands_Ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveOperands_Ok() {
        double expected = 30.0;
        double actual = calculator.calculate(40.0, 10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoNegativeOperands_Ok() {
        double expected = -30.0;
        double actual = calculator.calculate(-40.0, -10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperands_Ok() {
        double expected = 50.0;
        double actual = calculator.calculate(40.0, -10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionFirstZeroOperand_Ok() {
        double expected = -10.0;
        double actual = calculator.calculate(0, 10.0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionSecondZeroOperand_Ok() {
        double expected = 40.0;
        double actual = calculator.calculate(40.0, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxDoubleOperands_Ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveOperands_Ok() {
        double expected = 400.0;
        double actual = calculator.calculate(40.0, 10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationTwoNegativeOperands_Ok() {
        double expected = 400.0;
        double actual = calculator.calculate(-40.0, -10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperands_Ok() {
        double expected = -400.0;
        double actual = calculator.calculate(40.0, -10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationFirstZeroOperand_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 10.0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationSecondZeroOperand_Ok() {
        double expected = 0;
        double actual = calculator.calculate(40.0, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxDoubleOperands_Ok() {
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveOperands_Ok() {
        double expected = 4.0;
        double actual = calculator.calculate(40.0, 10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionTwoNegativeOperands_Ok() {
        double expected = 4.0;
        double actual = calculator.calculate(-40.0, -10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperands_Ok() {
        double expected = -4.0;
        double actual = calculator.calculate(40.0, -10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionFirstZeroOperand_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 10.0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionSecondZeroOperand_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(10, 0, '/');
        });
    }

    @Test
    void calculate_divisionMaxDoubleOperands_Ok() {
        double expected = Double.MAX_VALUE / Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToPositivePower_Ok() {
        double expected = 27.0;
        double actual = calculator.calculate(3.0, 3.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToPositivePower_Ok() {
        double expected = 9.0;
        double actual = calculator.calculate(-3.0, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToNegativePower_Ok() {
        double expected = 0.1;
        double actual = calculator.calculate(10.0, -1.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToNegativePower_Ok() {
        double expected = -1;
        double actual = calculator.calculate(-1, -1, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroValueToPower_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0.0, 1, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() {
        double expected = 1;
        double actual = calculator.calculate(10.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() {
        double expected = 1;
        double actual = calculator.calculate(-10.0, 0.0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_Ok() {
        char illegalOperaion = 'a';
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(100.0, 100.0, illegalOperaion);
        });
    }
}