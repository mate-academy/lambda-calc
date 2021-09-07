package core.basesyntax.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double DELTA = 0.00001;
    private static final double OPERATOR_TEN_AND_HALF = 10.5;
    private static final double NEGATIVE_OPERATOR_FIVE = -5;
    private static final double OPERATOR_FIVE = 5;
    private static final double NEGATIVE_OPERATOR_TEN = -10;
    private static final double HALF_OPERATOR = 0.5;
    private static final double TEN_OPERATOR = 10;
    private static final double FIFTEEN_OPERATOR = 15;
    private static final double ZERO_OPERATOR = 0;
    private static final double ONE_OPERATOR = 1;
    private static final double HUNDRED_OPERATOR = 100;
    private static final double NEGATIVE_OPERATOR_FIFTEEN = -15;
    private final Calculator calculator = new CalculatorImpl();

    @Test
    void twoPositiveOperandsAddition_OK() {
        double actual = calculator.calculate(OPERATOR_TEN_AND_HALF, OPERATOR_TEN_AND_HALF, '+');
        double secondOperator = 21;
        double expected = secondOperator;
        assertEquals(expected, actual, "Addition result for two positive operands is incorrect!");
    }

    @Test
    void twoNegativeOperandsAddition_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_FIVE, NEGATIVE_OPERATOR_FIVE, '+');
        double expected = NEGATIVE_OPERATOR_TEN;
        assertEquals(expected, actual, "Addition result for two negative operands is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandPositiveResult_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_FIVE, TEN_OPERATOR, '+');
        double expected = -NEGATIVE_OPERATOR_FIVE;
        assertEquals(expected, actual,
                "Addition result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandNegativeResult_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, NEGATIVE_OPERATOR_FIVE, '+');
        double expected = -NEGATIVE_OPERATOR_FIVE;
        assertEquals(actual, expected,
                "Addition result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(TEN_OPERATOR, ZERO_OPERATOR, '+');
        double expected = TEN_OPERATOR;
        assertEquals(expected, actual,
                "Addition result for one positive one zero operand is incorrect!");
    }

    @Test
    void positiveAndZeroOperandsTwo_Ok() {
        double actual = calculator.calculate(ZERO_OPERATOR, TEN_OPERATOR, '+');
        double expected = TEN_OPERATOR;
        assertEquals(expected, actual,
                "Addition result for one positive one zero operand is incorrect!");
    }

    @Test
    void minDoubleValuesAddition_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, ZERO_OPERATOR, '+');
        double expected = Double.MIN_VALUE;
        assertEquals(expected, actual,
                "Addition result for double min value is incorrect!");
    }

    @Test
    void maxDoubleValuesAddition_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, OPERATOR_TEN_AND_HALF, '+');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual,
                "Addition result for double max value is incorrect!");
    }

    @Test
    void twoPositiveOperandsSubtraction_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, OPERATOR_TEN_AND_HALF, '-');
        double expected = -HALF_OPERATOR;
        assertEquals(expected, actual,
                "Subtraction result for two positive operands is incorrect!");
    }

    @Test
    void twoNegativeOperandsSubtraction_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_FIVE, NEGATIVE_OPERATOR_FIVE, '-');
        double expected = ZERO_OPERATOR;
        assertEquals(expected, actual,
                "Subtraction result for two negative operands is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandSubtractionResult_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_FIVE, TEN_OPERATOR, '-');
        double expected = NEGATIVE_OPERATOR_FIFTEEN;
        assertEquals(expected, actual,
                "Subtraction result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandNegativeSubtraction_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, NEGATIVE_OPERATOR_FIVE, '-');
        double expected = FIFTEEN_OPERATOR;
        assertEquals(actual, expected,
                "Subtraction result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndZeroOperandsSubtraction_Ok() {
        double actual = calculator.calculate(OPERATOR_TEN_AND_HALF, ZERO_OPERATOR, '-');
        double expected = OPERATOR_TEN_AND_HALF;
        assertEquals(expected, actual,
                "Subtraction result for one positive one zero operand is incorrect!");
    }

    @Test
    void positiveAndZeroOperandsSubtractionTwo_Ok() {
        double actual = calculator.calculate(ZERO_OPERATOR, OPERATOR_TEN_AND_HALF, '-');
        double expected = -OPERATOR_TEN_AND_HALF;
        assertEquals(expected, actual,
                "Subtraction result for one positive one zero operand is incorrect!");
    }

    @Test
    void minDoubleValuesSubtraction_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, ONE_OPERATOR, '-');
        double expected = Double.MIN_VALUE - ONE_OPERATOR;
        assertEquals(expected, actual,
                "Subtraction result for double min value is incorrect!");
    }

    @Test
    void maxDoubleValuesSubtraction_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        double expected = ZERO_OPERATOR;
        assertEquals(expected, actual,
                "Subtraction result for double max value is incorrect!");
    }

    @Test
    void twoPositiveOperandsMultiplication_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, TEN_OPERATOR, '*');
        double expected = HUNDRED_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for two positive operands is incorrect!");
    }

    @Test
    void twoNegativeOperandsMultiplication_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_TEN, NEGATIVE_OPERATOR_TEN, '*');
        double expected = HUNDRED_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for two negative operands is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandMultiplicationResult_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_TEN, TEN_OPERATOR, '*');
        double expected = -HUNDRED_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandNegativeMultiplication_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, NEGATIVE_OPERATOR_TEN, '*');
        double expected = -HUNDRED_OPERATOR;
        assertEquals(actual, expected, DELTA,
                "Multiplication result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndZeroOperandsMultiplication_Ok() {
        double actual = calculator.calculate(TEN_OPERATOR, ZERO_OPERATOR, '*');
        double expected = ZERO_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for one positive one zero operand is incorrect!");
    }

    @Test
    void positiveAndZeroOperandsMultiplicationTwo_Ok() {
        double actual = calculator.calculate(ZERO_OPERATOR, TEN_OPERATOR, '*');
        double expected = ZERO_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for one positive one zero operand is incorrect!");
    }

    @Test
    void minDoubleValuesMultiplication_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, ONE_OPERATOR, '*');
        double expected = Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for double min value is incorrect!");
    }

    @Test
    void maxDoubleValuesMultiplication_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, TEN_OPERATOR, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual,
                "Multiplication result for double max value is incorrect!");
    }

    @Test
    void twoPositiveOperandsDivision_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, TEN_OPERATOR, '/');
        double expected = ONE_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Division result for two positive operands is incorrect!");
    }

    @Test
    void twoNegativeOperandsDivision_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_TEN, NEGATIVE_OPERATOR_TEN, '/');
        double expected = ONE_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Division result for two negative operands is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandDivisionResult_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_TEN, TEN_OPERATOR, '/');
        double expected = -ONE_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Division result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandNegativeDivision_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, NEGATIVE_OPERATOR_TEN, '/');
        double expected = -ONE_OPERATOR;
        assertEquals(actual, expected, DELTA,
                "Division result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndZeroOperandsDivision_Ok() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(TEN_OPERATOR, ZERO_OPERATOR, '/'));
    }

    @Test
    void positiveAndZeroOperandsDivisionTwo_Ok() {
        double actual = calculator.calculate(ZERO_OPERATOR, TEN_OPERATOR, '/');
        double expected = ZERO_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Division result for one positive one zero operand is incorrect!");
    }

    @Test
    void minDoubleValuesDivision_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, ONE_OPERATOR, '/');
        double expected = Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for double min value is incorrect!");
    }

    @Test
    void maxDoubleValuesDivisionInfinity_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, HALF_OPERATOR, '/');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for double max value is incorrect!");
    }

    @Test
    void maxDoubleValuesDivision_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, ONE_OPERATOR, '/');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA,
                "Multiplication result for double max value is incorrect!");
    }

    @Test
    void twoPositiveOperandsPower_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, FIFTEEN_OPERATOR, '^');
        double expected = Math.pow(TEN_OPERATOR, FIFTEEN_OPERATOR);
        assertEquals(expected, actual, DELTA,
                "Power result for two positive operands is incorrect!");
    }

    @Test
    void twoNegativeOperandsPower_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_TEN, NEGATIVE_OPERATOR_TEN, '^');
        double expected = Math.pow(NEGATIVE_OPERATOR_TEN, NEGATIVE_OPERATOR_TEN);
        assertEquals(expected, actual, DELTA,
                "Power result for two negative operands is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandPowerResult_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_FIVE, OPERATOR_FIVE, '^');
        double expected = Math.pow(NEGATIVE_OPERATOR_FIVE, OPERATOR_FIVE);
        assertEquals(expected, actual, DELTA,
                "Power result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveAndNegativeOperandNegativePower_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, NEGATIVE_OPERATOR_FIVE, '^');
        double expected = Math.pow(TEN_OPERATOR, NEGATIVE_OPERATOR_FIVE);
        assertEquals(actual, expected, DELTA,
                "Power result for one positive one negative operand is incorrect!");
    }

    @Test
    void positiveOperandToZeroPower_OK() {
        double actual = calculator.calculate(TEN_OPERATOR, ZERO_OPERATOR, '^');
        double expected = ONE_OPERATOR;
        assertEquals(actual, expected, DELTA,
                "Power result for one positive and zero operand is incorrect!");
    }

    @Test
    void negativeOperandToZeroPower_OK() {
        double actual = calculator.calculate(NEGATIVE_OPERATOR_FIVE, ZERO_OPERATOR, '^');
        double expected = ONE_OPERATOR;
        assertEquals(expected, actual,
                "Power result for one negative one zero operand is incorrect!");
    }

    @Test
    void zeroOperandToPositivePower_OK() {
        double actual = calculator.calculate(ZERO_OPERATOR, TEN_OPERATOR, '^');
        double expected = ZERO_OPERATOR;
        assertEquals(expected, actual, DELTA,
                "Power result for zero and positive operand is incorrect!");
    }

    @Test
    void zeroOperandToNegativePower_OK() {
        double actual = calculator.calculate(ZERO_OPERATOR, NEGATIVE_OPERATOR_FIVE, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA,
                "Power result for negative power and zero operand is incorrect!");
    }

    @Test
    void illegalOperation_OK() {
        assertThrows(IllegalOperationException.class,
                () -> calculator.calculate(ONE_OPERATOR, ZERO_OPERATOR, '.'));
    }
}
