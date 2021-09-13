package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static Calculate calculator;
    private static final double DELTA = 0.0001;

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(55.34, 35, '+');
        double expected = 90.34;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-1.34, -0.001, '+');
        double expected = -1.341;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0.32, -11, '+');
        double expected = -10.68;
        assertEquals(expected, actual);
        actual = calculator.calculate(-0.34, 20.0001, '+');
        expected = 19.6601;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroAsFirstOperand_Ok() {
        double actual = calculator.calculate(0, 4, '+');
        double expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroAsSecondOperand_Ok() {
        double actual = calculator.calculate(12, 0, '+');
        double expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionTwoMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        double expected = Double.MAX_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionTwoMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        double expected = Double.MIN_VALUE + Double.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(7, 0.005, '-');
        double expected = 6.995;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-5, -34.5551, '-');
        double expected = 29.5551;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(32, -1, '-');
        double expected = 33;
        assertEquals(expected, actual);
        actual = calculator.calculate(-12, 3.5, '-');
        expected = -15.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 3, '-');
        double expected = -3;
        assertEquals(expected, actual);
        actual = calculator.calculate(0, -0.2, '-');
        expected = 0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstPositiveAndSecondZeroOperand_Ok() {
        double actual = calculator.calculate(4.5, 0, '-');
        double expected = 4.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstNegativeAndSecondZeroOperand_Ok() {
        double actual = calculator.calculate(-4.5, 0, '-');
        double expected = -4.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionTwoMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(2, 4.12, '*');
        double expected = 8.24;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-1, -0.45, '*');
        double expected = 0.45;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(5, -67, '*');
        double expected = -335;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-90.45, 2.3, '*');
        expected = -208.035;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 78.34532, '*');
        double expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(0, -45.2311, '*');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithFirstPositiveAndSecondZeroOperand_Ok() {
        double actual = calculator.calculate(4.5678, 0, '*');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstNegativeAndSecondZeroOperand_Ok() {
        double actual = calculator.calculate(-32.432156, 0, '*');
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        double expected = Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        double expected = Double.MIN_VALUE * Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(4, 0.2, '/');
        double expected = 20;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-2.3, -0.45, '/');
        double expected = 5.1111111;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(32, -6, '/');
        double expected = -5.33333;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-12, 2, '/');
        expected = -6;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroAsFirstOperand_Ok() {
        double actual = calculator.calculate(0, 78, '/');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(0, -6.5, '/');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroAsSecondOperand_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(4, 0, '/');
        });

    }

    @Test
    void calculate_divisionWithTwoZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, 0, '/');
        });
    }

    @Test
    void calculate_divisionTwoMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoMinDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_Ok() {
        double actual = calculator.calculate(3, 2, '^');
        double expected = 9;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_Ok() {
        double actual = calculator.calculate(-6.5, 3, '^');
        double expected = -274.625;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(6, -2, '^');
        double expected = 0.02777777;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(2, -8, '^');
        double expected = 0.0039062;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(45, 0, '^');
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(-4.532, 0, '^');
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        double actual = calculator.calculate(0, 4, '^');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(Exception.class, () -> {
            calculator.calculate(67, 2, '&');
        });
    }
}
