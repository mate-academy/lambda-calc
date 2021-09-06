package core.basesyntax.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private final Calculator calculator = new CalculatorImpl();
    private final double delta = 0.00001;
    private final double firstOperator = 10.5;
    private final double secondOperator = 21;
    private final double negativeOperatorFive = -5;
    private final double negativeOperatorTen = -10;
    private final double halfOperator = 0.5;
    private final double tenOperator = 10;
    private final double negativeOperatorFifteen = -15;
    private final double fiveOperator = 5;
    private final double fifteenOperator = 15;
    private final double zeroOperator = 0;
    private final double oneOperator = 1;
    private final double hundredOperator = 100;

    @Test
    void twoPositiveOperandsAddition_OK() {
        double actual = calculator.calculate(firstOperator, firstOperator, '+');
        double expected = secondOperator;
        assertEquals(expected, actual, "Addition result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsAddition_OK() {
        double actual = calculator.calculate(negativeOperatorFive, negativeOperatorFive, '+');
        double expected = negativeOperatorTen;
        assertEquals(expected, actual, "Addition result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandPositiveResult_OK() {
        double actual = calculator.calculate(negativeOperatorFive, tenOperator, '+');
        double expected = -negativeOperatorFive;
        assertEquals(expected, actual,
                "Addition result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeResult_OK() {
        double actual = calculator.calculate(tenOperator, negativeOperatorFive, '+');
        double expected = -negativeOperatorFive;
        assertEquals(actual, expected,
                "Addition result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(tenOperator, zeroOperator, '+');
        double expected = tenOperator;
        assertEquals(expected, actual,
                "Addition result for one positive one zero operand is false!");
    }

    @Test
    void positiveAndZeroOperandsTwo_Ok() {
        double actual = calculator.calculate(zeroOperator, tenOperator, '+');
        double expected = tenOperator;
        assertEquals(expected, actual,
                "Addition result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesAddition_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, zeroOperator, '+');
        double expected = Double.MIN_VALUE;
        assertEquals(expected, actual, delta,
                "Addition result for double min value is false!");
    }

    @Test
    void maxDoubleValuesAddition_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, firstOperator, '+');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, delta,
                "Addition result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsSubtraction_OK() {
        double actual = calculator.calculate(tenOperator, firstOperator, '-');
        double expected = -halfOperator;
        assertEquals(expected, actual,
                "Subtraction result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsSubtraction_OK() {
        double actual = calculator.calculate(negativeOperatorFive, negativeOperatorFive, '-');
        double expected = zeroOperator;
        assertEquals(expected, actual,
                "Subtraction result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandSubtractionResult_OK() {
        double actual = calculator.calculate(negativeOperatorFive, tenOperator, '-');
        double expected = negativeOperatorFifteen;
        assertEquals(expected, actual,
                "Subtraction result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeSubtraction_OK() {
        double actual = calculator.calculate(tenOperator, negativeOperatorFive, '-');
        double expected = fifteenOperator;
        assertEquals(actual, expected,
                "Subtraction result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperandsSubtraction_Ok() {
        double actual = calculator.calculate(firstOperator, zeroOperator, '-');
        double expected = firstOperator;
        assertEquals(expected, actual,
                "Subtraction result for one positive one zero operand is false!");
    }

    @Test
    void positiveAndZeroOperandsSubtractionTwo_Ok() {
        double actual = calculator.calculate(zeroOperator, firstOperator, '-');
        double expected = - firstOperator;
        assertEquals(expected, actual,
                "Subtraction result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesSubtraction_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, oneOperator, '-');
        double expected = Double.MIN_VALUE - oneOperator;
        assertEquals(expected, actual, delta,
                "Subtraction result for double min value is false!");
    }

    @Test
    void maxDoubleValuesSubtraction_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        double expected = zeroOperator;
        assertEquals(expected, actual, delta,
                "Subtraction result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsMultiplication_OK() {
        double actual = calculator.calculate(tenOperator, tenOperator, '*');
        double expected = hundredOperator;
        assertEquals(expected, actual,
                "Multiplication result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsMultiplication_OK() {
        double actual = calculator.calculate(negativeOperatorTen, negativeOperatorTen, '*');
        double expected = hundredOperator;
        assertEquals(expected, actual,
                "Multiplication result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandMultiplicationResult_OK() {
        double actual = calculator.calculate(negativeOperatorTen, tenOperator, '*');
        double expected = -hundredOperator;
        assertEquals(expected, actual,
                "Multiplication result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeMultiplication_OK() {
        double actual = calculator.calculate(tenOperator, negativeOperatorTen, '*');
        double expected = -hundredOperator;
        assertEquals(actual, expected,
                "Multiplication result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperandsMultiplication_Ok() {
        double actual = calculator.calculate(tenOperator, zeroOperator, '*');
        double expected = zeroOperator;
        assertEquals(expected, actual,
                "Multiplication result for one positive one zero operand is false!");
    }

    @Test
    void positiveAndZeroOperandsMultiplicationTwo_Ok() {
        double actual = calculator.calculate(zeroOperator, tenOperator, '*');
        double expected = zeroOperator;
        assertEquals(expected, actual,
                "Multiplication result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesMultiplication_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, oneOperator, '*');
        double expected = Double.MIN_VALUE;
        assertEquals(expected, actual, delta,
                "Multiplication result for double min value is false!");
    }

    @Test
    void maxDoubleValuesMultiplication_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, tenOperator, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta,
                "Multiplication result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsDivision_OK() {
        double actual = calculator.calculate(tenOperator, tenOperator, '/');
        double expected = oneOperator;
        assertEquals(expected, actual,
                "Division result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsDivision_OK() {
        double actual = calculator.calculate(negativeOperatorTen, negativeOperatorTen, '/');
        double expected = oneOperator;
        assertEquals(expected, actual,
                "Division result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandDivisionResult_OK() {
        double actual = calculator.calculate(negativeOperatorTen, tenOperator, '/');
        double expected = -oneOperator;
        assertEquals(expected, actual,
                "Division result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativeDivision_OK() {
        double actual = calculator.calculate(tenOperator, negativeOperatorTen, '/');
        double expected = -oneOperator;
        assertEquals(actual, expected,
                "Division result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndZeroOperandsDivision_Ok() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(tenOperator, zeroOperator, '/'));
    }

    @Test
    void positiveAndZeroOperandsDivisionTwo_Ok() {
        double actual = calculator.calculate(zeroOperator, tenOperator, '/');
        double expected = zeroOperator;
        assertEquals(expected, actual,
                "Division result for one positive one zero operand is false!");
    }

    @Test
    void minDoubleValuesDivision_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, oneOperator, '/');
        double expected = Double.MIN_VALUE;
        assertEquals(expected, actual, delta,
                "Multiplication result for double min value is false!");
    }

    @Test
    void maxDoubleValuesDivisionInfinity_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, halfOperator, '/');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta,
                "Multiplication result for double max value is false!");
    }

    @Test
    void maxDoubleValuesDivision_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, oneOperator, '/');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, delta,
                "Multiplication result for double max value is false!");
    }

    @Test
    void twoPositiveOperandsPower_OK() {
        double actual = calculator.calculate(tenOperator, fifteenOperator, '^');
        double expected = Math.pow(tenOperator, fifteenOperator);
        assertEquals(expected, actual,
                "Power result for two positive operands is false!");
    }

    @Test
    void twoNegativeOperandsPower_OK() {
        double actual = calculator.calculate(negativeOperatorTen, negativeOperatorTen, '^');
        double expected = Math.pow(negativeOperatorTen, negativeOperatorTen);
        assertEquals(expected, actual,
                "Power result for two negative operands is false!");
    }

    @Test
    void positiveAndNegativeOperandPowerResult_OK() {
        double actual = calculator.calculate(negativeOperatorFive, fiveOperator, '^');
        double expected = Math.pow(negativeOperatorFive, fiveOperator);
        assertEquals(expected, actual,
                "Power result for one positive one negative operand is false!");
    }

    @Test
    void positiveAndNegativeOperandNegativePower_OK() {
        double actual = calculator.calculate(tenOperator, negativeOperatorTen, '^');
        double expected = Math.pow(tenOperator, negativeOperatorTen);
        assertEquals(actual, expected,
                "Power result for one positive one negative operand is false!");
    }

    @Test
    void positiveOperandToZeroPower_OK() {
        double actual = calculator.calculate(tenOperator, zeroOperator, '^');
        double expected = oneOperator;
        assertEquals(actual, expected,
                "Power result for one positive and zero operand is false!");
    }

    @Test
    void negativeOperandToZeroPower_OK() {
        double actual = calculator.calculate(negativeOperatorTen, zeroOperator, '^');
        double expected = oneOperator;
        assertEquals(expected, actual,
                "Power result for one negative one zero operand is false!");
    }

    @Test
    void zeroOperandToPositivePower_OK() {
        double actual = calculator.calculate(zeroOperator, tenOperator, '^');
        double expected = zeroOperator;
        assertEquals(expected, actual,
                "Power result for zero and positive operand is false!");
    }

    @Test
    void zeroOperandToNegativePower_OK() {
        double actual = calculator.calculate(zeroOperator, negativeOperatorTen, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual,
                "Power result for negative power and zero operand is false!");
    }

    @Test
    void illegalOperation_OK() {
        assertThrows(IllegalOperationException.class,
                () -> calculator.calculate(firstOperator, zeroOperator, '.'));
    }
}
