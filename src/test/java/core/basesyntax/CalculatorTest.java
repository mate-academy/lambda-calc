package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static CalculatorService calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculateAdditionTwoPositiveOperands_Ok() {
        double expected = 55.55;
        assertEquals(expected, calculator.calculate(22.22, 33.33,
                '+'), DELTA);
    }

    @Test
    void calculateAdditionTwoNegativeOperands_Ok() {
        double expected = -55.55;
        assertEquals(expected, calculator.calculate(-22.22, -33.33,
                '+'), DELTA);
    }

    @Test
    void calculateAdditionFirstPositiveSecondNegativeOperands_Ok() {
        double expected = -11.11;
        assertEquals(expected, calculator.calculate(22.22, -33.33,
                '+'), DELTA);
    }

    @Test
    void calculateAdditionFirstNegativeSecondPositiveOperands_Ok() {
        double expected = 11.11;
        assertEquals(expected, calculator.calculate(-22.22, 33.33,
                '+'), DELTA);
    }

    @Test
    void calculateAdditionFirstZeroOperand_Ok() {
        double expected = 33.33;
        assertEquals(expected, calculator.calculate(0, 33.33,
                '+'), DELTA);
    }

    @Test
    void calculateAdditionSecondZeroOperand_Ok() {
        double expected = 22.22;
        assertEquals(expected, calculator.calculate(22.22, 0,
                '+'), DELTA);
    }

    @Test
    void calculateAdditionTwoZeroOperands_Ok() {
        assertEquals(0, calculator.calculate(0, 0,
                '+'));
    }

    @Test
    void calculateAdditionTwoMaxValueOperand_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '+'), DELTA);
    }

    @Test
    void calculateAdditionTwoMinValueOperand_Ok() {
        double expected = 1.0E-323;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '+'));
    }

    @Test
    void calculateAdditionToOneMaxValueOperand_Ok() {
        double expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 4.444,
                '+'));
    }

    @Test
    void calculateAdditionToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE + 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '+'));
    }

    @Test
    void calculateSubtractionTwoPositiveOperands_Ok() {
        double expected = -11.11;
        assertEquals(expected, calculator.calculate(22.22, 33.33,
                '-'), DELTA);
    }

    @Test
    void calculateSubtractionTwoNegativeOperands_Ok() {
        double expected = 11.11;
        assertEquals(expected, calculator.calculate(-22.22, -33.33,
                '-'), DELTA);
    }

    @Test
    void calculateSubtractionFirstPositiveSecondNegativeOperands_Ok() {
        double expected = 55.55;
        assertEquals(expected, calculator.calculate(22.22, -33.33,
                '-'), DELTA);
    }

    @Test
    void calculateSubtractionFirstNegativeSecondPositiveOperands_Ok() {
        double expected = -55.55;
        assertEquals(expected, calculator.calculate(-22.22, 33.33,
                '-'), DELTA);
    }

    @Test
    void calculateSubtractionFirstZeroOperand_Ok() {
        double expected = -33.33;
        assertEquals(expected, calculator.calculate(0, 33.33,
                '-'), DELTA);
    }

    @Test
    void calculateSubtractionSecondZeroOperand_Ok() {
        double expected = 22.22;
        assertEquals(expected, calculator.calculate(22.22, 0,
                '-'), DELTA);
    }

    @Test
    void calculateSubtractionTwoZeroOperands_Ok() {
        assertEquals(0, calculator.calculate(0, 0,
                '-'));
    }

    @Test
    void calculateSubtractionTwoMaxValueOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '-'), DELTA);
    }

    @Test
    void calculateSubtractionTwoMinValueOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '-'));
    }

    @Test
    void calculateSubtractionToOneMaxValueOperand_Ok() {
        double expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 4.444,
                '-'));
    }

    @Test
    void calculateSubtractionToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE - 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '-'));
    }

    @Test
    void calculateMultiplicationTwoPositiveOperands_Ok() {
        double expected = 740.5926;
        assertEquals(expected, calculator.calculate(22.22, 33.33,
                '*'), DELTA);
    }

    @Test
    void calculateMultiplicationTwoNegativeOperands_Ok() {
        double expected = 740.5926;
        assertEquals(expected, calculator.calculate(-22.22, -33.33,
                '*'), DELTA);
    }

    @Test
    void calculateMultiplicationFirstPositiveSecondNegativeOperands_Ok() {
        double expected = -740.5926;
        assertEquals(expected, calculator.calculate(22.22, -33.33,
                '*'), DELTA);
    }

    @Test
    void calculateMultiplicationFirstNegativeSecondPositiveOperands_Ok() {
        double expected = -740.5926;
        assertEquals(expected, calculator.calculate(-22.22, 33.33,
                '*'), DELTA);
    }

    @Test
    void calculateMultiplicationFirstZeroOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(0, 33.33,
                '*'), DELTA);
    }

    @Test
    void calculateMultiplicationSecondZeroOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(22.22, 0,
                '*'), DELTA);
    }

    @Test
    void calculateMultiplicationTwoZeroOperands_Ok() {
        assertEquals(0, calculator.calculate(0, 0,
                '*'));
    }

    @Test
    void calculateMultiplicationTwoMaxValueOperand_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '*'), DELTA);
    }

    @Test
    void calculateMultiplicationTwoMinValueOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '*'));
    }

    @Test
    void calculateMultiplicationToOneMaxValueOperand_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 4.444,
                '*'));
    }

    @Test
    void calculateMultiplicationToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE * 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '*'));
    }

    @Test
    void calculateDivisionTwoPositiveOperands_Ok() {
        double expected = 2.0;
        assertEquals(expected, calculator.calculate(44.44, 22.22,
                '/'), DELTA);
    }

    @Test
    void calculateDivisionTwoNegativeOperands_Ok() {
        double expected = 2.0;
        assertEquals(expected, calculator.calculate(-44.44, -22.22,
                '/'), DELTA);
    }

    @Test
    void calculateDivisionFirstPositiveSecondNegativeOperands_Ok() {
        double expected = -2.0;
        assertEquals(expected, calculator.calculate(44.44, -22.22,
                '/'), DELTA);
    }

    @Test
    void calculateDivisionFirstNegativeSecondPositiveOperands_Ok() {
        double expected = -2.0;
        assertEquals(expected, calculator.calculate(-44.44, 22.22,
                '/'), DELTA);
    }

    @Test
    void calculateDivisionFirstZeroOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(0, 22.22,
                '/'), DELTA);
    }

    @Test
    void calculateDivisionSecondZeroOperand_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(44.44, 0,
                '/'));
    }

    @Test
    void calculateDivisionTwoZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0,
                '/'));
    }

    @Test
    void calculateDivisionTwoMaxValueOperand_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '/'), DELTA);
    }

    @Test
    void calculateDivisionTwoMinValueOperand_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '/'));
    }

    @Test
    void calculateDivisionToOneMaxValueOperand_Ok() {
        double expected = Double.MAX_VALUE / 20.222;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 20.222,
                '/'));
    }

    @Test
    void calculateDivisionToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE / 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '/'));
    }

    @Test
    void calculateRaisingPositiveValueToPositivePower_Ok() {
        double expected = Math.pow(2.22, 3.33);
        assertEquals(expected, calculator.calculate(2.22, 3.33,
                '^'), DELTA);
    }

    @Test
    void calculateRaisingNegativeValueToPositivePower_Ok() {
        double expected = Math.pow(-2.22, 3.33);
        assertEquals(expected, calculator.calculate(-2.22, 3.33,
                '^'), DELTA);
    }

    @Test
    void calculateRaisingPositiveValueToNegativePower_Ok() {
        double expected = Math.pow(2.22, -3.33);
        assertEquals(expected, calculator.calculate(2.22, -3.33,
                '^'), DELTA);
    }

    @Test
    void calculateRaisingNegativeValueToNegativePower_Ok() {
        double expected = Math.pow(-2.22, -3.33);
        assertEquals(expected, calculator.calculate(-2.22, -3.33,
                '^'), DELTA);
    }

    @Test
    void calculateRaisingPositiveValueToZeroPower_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(2.22, 0,
                '^'));
    }

    @Test
    void calculateRaisingNegativeValueToZeroPower_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(-2.22, 0,
                '^'));
    }

    @Test
    void calculateRaisingZeroValueToPower_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(0, 2.22,
                '^'));
    }

    @Test
    void calculateIllegalOperation_NotOk() {
        assertThrows(IncorrectDataEntryException.class, () -> calculator.calculate(2.22, 3.33,
                '%'));
    }
}
