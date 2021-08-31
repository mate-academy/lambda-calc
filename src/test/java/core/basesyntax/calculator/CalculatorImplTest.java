package core.basesyntax.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private Calculator calculator = new CalculatorImpl();
    private double delta = 0.00001;

    @Test
    void twoPositiveOperandsAddition_OK() {
        double actual = calculator.calculate(10.5, 10.5, '+');
        double expected = 21.0;
        assertEquals(expected, actual, "Addition result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsAddition_OK() {
        double actual = calculator.calculate(-1.0, -2.5, '+');
        double expected = -3.5;
        assertEquals(expected, actual, "Addition result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandPositiveResult_OK() {
        double actual = calculator.calculate(-1.0, 2.5, '+');
        double expected = 1.5;
        assertEquals(expected, actual,
                "Addition result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeResult_OK() {
        double actual = calculator.calculate(1.0, -2.5, '+');
        double expected = -1.5;
        assertEquals(actual, expected,
                "Addition result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(5.5, 0, '+');
        double expected = 5.5;
        assertEquals(expected, actual,
                "Addition result for one positive one zero operand is false!");
    }

    @Test
    void positiveAndZeroOperandsTwo_Ok() {
        double actual = calculator.calculate(0, 6.5, '+');
        double expected = 6.5;
        assertEquals(expected, actual,
                "Addition result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesAddition_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 1, '+');
        double expected = Double.MIN_VALUE + 1;
        assertEquals(expected, actual, delta,
                "Addition result for double min value is false!");
    }

    @Test
    void maxDoubleValuesAddition_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 10, '+');
        double expected = Double.MAX_VALUE + 10;
        assertEquals(expected, actual, delta,
                "Addition result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsSubtraction_OK() {
        double actual = calculator.calculate(12.5, 10.5, '-');
        double expected = 2.0;
        assertEquals(expected, actual,
                "Subtraction result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsSubtraction_OK() {
        double actual = calculator.calculate(-1.0, -2.5, '-');
        double expected = 1.5;
        assertEquals(expected, actual,
                "Subtraction result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandSubtractionResult_OK() {
        double actual = calculator.calculate(-1.0, 2.5, '-');
        double expected = -3.5;
        assertEquals(expected, actual,
                "Subtraction result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeSubtraction_OK() {
        double actual = calculator.calculate(1.0, -2.5, '-');
        double expected = 3.5;
        assertEquals(actual, expected,
                "Subtraction result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperandsSubtraction_Ok() {
        double actual = calculator.calculate(5.5, 0, '-');
        double expected = 5.5;
        assertEquals(expected, actual,
                "Subtraction result for one positive one zero operand is false!");
    }

    @Test
    void positiveAndZeroOperandsSubtractionTwo_Ok() {
        double actual = calculator.calculate(0, 6.5, '-');
        double expected = - 6.5;
        assertEquals(expected, actual,
                "Subtraction result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesSubtraction_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 1, '-');
        double expected = Double.MIN_VALUE - 1;
        assertEquals(expected, actual, delta,
                "Subtraction result for double min value is false!");
    }

    @Test
    void maxDoubleValuesSubtraction_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 10, '-');
        double expected = Double.MAX_VALUE - 10;
        assertEquals(expected, actual, delta,
                "Subtraction result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsMultiplication_OK() {
        double actual = calculator.calculate(12.5, 10, '*');
        double expected = 125;
        assertEquals(expected, actual,
                "Multiplication result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsMultiplication_OK() {
        double actual = calculator.calculate(-12.5, -10, '*');
        double expected = 125;
        assertEquals(expected, actual,
                "Multiplication result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandMultiplicationResult_OK() {
        double actual = calculator.calculate(-10.0, 12.5, '*');
        double expected = -125;
        assertEquals(expected, actual,
                "Multiplication result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeMultiplication_OK() {
        double actual = calculator.calculate(10.0, -12.5, '*');
        double expected = -125;
        assertEquals(actual, expected,
                "Multiplication result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperandsMultiplication_Ok() {
        double actual = calculator.calculate(5.5, 0, '*');
        double expected = 0;
        assertEquals(expected, actual,
                "Multiplication result for one positive one zero operand is false!");
    }

    @Test
    void positiveAndZeroOperandsMultiplicationTwo_Ok() {
        double actual = calculator.calculate(0, 6.5, '*');
        double expected = 0;
        assertEquals(expected, actual,
                "Multiplication result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesMultiplication_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 3, '*');
        double expected = Double.MIN_VALUE * 3;
        assertEquals(expected, actual, delta,
                "Multiplication result for double min value is false!");
    }

    @Test
    void maxDoubleValuesMultiplication_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 2, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta,
                "Multiplication result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsDivision_OK() {
        double actual = calculator.calculate(12.5, 10, '/');
        double expected = 1.25;
        assertEquals(expected, actual,
                "Division result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsDivision_OK() {
        double actual = calculator.calculate(-12.5, -10, '/');
        double expected = 1.25;
        assertEquals(expected, actual,
                "Division result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandDivisionResult_OK() {
        double actual = calculator.calculate(-12.5, 10.0, '/');
        double expected = -1.25;
        assertEquals(expected, actual,
                "Division result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeDivision_OK() {
        double actual = calculator.calculate(125.0, -10.0, '/');
        double expected = -12.5;
        assertEquals(actual, expected,
                "Division result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperandsDivision_Ok() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(5.5, 0, '/'));
    }

    @Test
    void positiveAndZeroOperandsDivisionTwo_Ok() {
        double actual = calculator.calculate(0, 6.5, '/');
        double expected = 0;
        assertEquals(expected, actual,
                "Division result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesDivision_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 3, '/');
        double expected = Double.MIN_VALUE / 3;
        assertEquals(expected, actual, delta,
                "Multiplication result for double min value is false!");
    }

    @Test
    void maxDoubleValuesDivisionInfinity_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 0.5, '/');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta,
                "Multiplication result for double max value is false!");
    }

    @Test
    void maxDoubleValuesDivision_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 5, '/');
        double expected = Double.MAX_VALUE / 5;
        assertEquals(expected, actual, delta,
                "Multiplication result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsPower_OK() {
        double actual = calculator.calculate(12.5, 10, '^');
        double expected = Math.pow(12.5, 10);
        assertEquals(expected, actual,
                "Power result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsPower_OK() {
        double actual = calculator.calculate(-12.5, -10, '^');
        double expected = Math.pow(-12.5, -10);
        assertEquals(expected, actual,
                "Power result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandPowerResult_OK() {
        double actual = calculator.calculate(-12.5, 10.0, '^');
        double expected = Math.pow(-12.5, 10);
        assertEquals(expected, actual,
                "Power result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativePower_OK() {
        double actual = calculator.calculate(12.0, -10.0, '^');
        double expected = Math.pow(12, -10);
        assertEquals(actual, expected,
                "Power result for one positive one negative operand is false!");
    }

    @Test
    void positiveOperandToZeroPower_OK() {
        double actual = calculator.calculate(12.0, 0, '^');
        double expected = 1;
        assertEquals(actual, expected,
                "Power result for one positive and zero operand is false!");
    }

    @Test
    void negativeOperandToZeroPower_OK() {
        double actual = calculator.calculate(-12.0, 0, '^');
        double expected = 1;
        assertEquals(expected, actual,
                "Power result for one negative one zero operand is false!");
    }

    @Test
    void zeroOperandToPositivePower_OK() {
        double actual = calculator.calculate(0, 80, '^');
        double expected = 0;
        assertEquals(expected, actual,
                "Power result for zero and positive operand is false!");
    }

    @Test
    void zeroOperandToNegativePower_OK() {
        double actual = calculator.calculate(0, -80, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual,
                "Power result for negative power and zero operand is false!");
    }

    @Test
    void illegalOperation_OK() {
        assertThrows(IllegalOperationException.class, () -> calculator.calculate(5.5, 0, '.'));
    }
}
