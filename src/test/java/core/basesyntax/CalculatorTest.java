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
    void additionTwoPositiveOperands_Ok() {
        double expected = 55.55;
        assertEquals(expected, calculator.calculate(22.22, 33.33,
                '+'), DELTA);
    }

    @Test
    void additionTwoNegativeOperands_Ok() {
        double expected = -55.55;
        assertEquals(expected, calculator.calculate(-22.22, -33.33,
                '+'), DELTA);
    }

    @Test
    void additionFirstPositiveSecondNegativeOperands_Ok() {
        double expected = -11.11;
        assertEquals(expected, calculator.calculate(22.22, -33.33,
                '+'), DELTA);
    }

    @Test
    void additionFirstNegativeSecondPositiveOperands_Ok() {
        double expected = 11.11;
        assertEquals(expected, calculator.calculate(-22.22, 33.33,
                '+'), DELTA);
    }

    @Test
    void additionFirstZeroOperand_Ok() {
        double expected = 33.33;
        assertEquals(expected, calculator.calculate(0, 33.33,
                '+'), DELTA);
    }

    @Test
    void additionSecondZeroOperand_Ok() {
        double expected = 22.22;
        assertEquals(expected, calculator.calculate(22.22, 0,
                '+'), DELTA);
    }

    @Test
    void additionTwoZeroOperands_Ok() {
        assertEquals(0, calculator.calculate(0, 0,
                '+'));
    }

    @Test
    void additionTwoMaxValueOperand_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '+'), DELTA);
    }

    @Test
    void additionTwoMinValueOperand_Ok() {
        double expected = 1.0E-323;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '+'));
    }

    @Test
    void additionToOneMaxValueOperand_Ok() {
        double expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 4.444,
                '+'));
    }

    @Test
    void additionToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE + 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '+'));
    }

    @Test
    void subtractionTwoPositiveOperands_Ok() {
        double expected = -11.11;
        assertEquals(expected, calculator.calculate(22.22, 33.33,
                '-'), DELTA);
    }

    @Test
    void subtractionTwoNegativeOperands_Ok() {
        double expected = 11.11;
        assertEquals(expected, calculator.calculate(-22.22, -33.33,
                '-'), DELTA);
    }

    @Test
    void subtractionFirstPositiveSecondNegativeOperands_Ok() {
        double expected = 55.55;
        assertEquals(expected, calculator.calculate(22.22, -33.33,
                '-'), DELTA);
    }

    @Test
    void subtractionFirstNegativeSecondPositiveOperands_Ok() {
        double expected = -55.55;
        assertEquals(expected, calculator.calculate(-22.22, 33.33,
                '-'), DELTA);
    }

    @Test
    void subtractionFirstZeroOperand_Ok() {
        double expected = -33.33;
        assertEquals(expected, calculator.calculate(0, 33.33,
                '-'), DELTA);
    }

    @Test
    void subtractionSecondZeroOperand_Ok() {
        double expected = 22.22;
        assertEquals(expected, calculator.calculate(22.22, 0,
                '-'), DELTA);
    }

    @Test
    void subtractionTwoZeroOperands_Ok() {
        assertEquals(0, calculator.calculate(0, 0,
                '-'));
    }

    @Test
    void subtractionTwoMaxValueOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '-'), DELTA);
    }

    @Test
    void subtractionTwoMinValueOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '-'));
    }

    @Test
    void subtractionToOneMaxValueOperand_Ok() {
        double expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 4.444,
                '-'));
    }

    @Test
    void subtractionToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE - 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '-'));
    }

    @Test
    void multiplicationTwoPositiveOperands_Ok() {
        double expected = 740.5926;
        assertEquals(expected, calculator.calculate(22.22, 33.33,
                '*'), DELTA);
    }

    @Test
    void multiplicationTwoNegativeOperands_Ok() {
        double expected = 740.5926;
        assertEquals(expected, calculator.calculate(-22.22, -33.33,
                '*'), DELTA);
    }

    @Test
    void multiplicationFirstPositiveSecondNegativeOperands_Ok() {
        double expected = -740.5926;
        assertEquals(expected, calculator.calculate(22.22, -33.33,
                '*'), DELTA);
    }

    @Test
    void multiplicationFirstNegativeSecondPositiveOperands_Ok() {
        double expected = -740.5926;
        assertEquals(expected, calculator.calculate(-22.22, 33.33,
                '*'), DELTA);
    }

    @Test
    void multiplicationFirstZeroOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(0, 33.33,
                '*'), DELTA);
    }

    @Test
    void multiplicationSecondZeroOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(22.22, 0,
                '*'), DELTA);
    }

    @Test
    void multiplicationTwoZeroOperands_Ok() {
        assertEquals(0, calculator.calculate(0, 0,
                '*'));
    }

    @Test
    void multiplicationTwoMaxValueOperand_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '*'), DELTA);
    }

    @Test
    void multiplicationTwoMinValueOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '*'));
    }

    @Test
    void multiplicationToOneMaxValueOperand_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 4.444,
                '*'));
    }

    @Test
    void multiplicationToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE * 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '*'));
    }

    @Test
    void divisionTwoPositiveOperands_Ok() {
        double expected = 2.0;
        assertEquals(expected, calculator.calculate(44.44, 22.22,
                '/'), DELTA);
    }

    @Test
    void divisionTwoNegativeOperands_Ok() {
        double expected = 2.0;
        assertEquals(expected, calculator.calculate(-44.44, -22.22,
                '/'), DELTA);
    }

    @Test
    void divisionFirstPositiveSecondNegativeOperands_Ok() {
        double expected = -2.0;
        assertEquals(expected, calculator.calculate(44.44, -22.22,
                '/'), DELTA);
    }

    @Test
    void divisionFirstNegativeSecondPositiveOperands_Ok() {
        double expected = -2.0;
        assertEquals(expected, calculator.calculate(-44.44, 22.22,
                '/'), DELTA);
    }

    @Test
    void divisionFirstZeroOperand_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(0, 22.22,
                '/'), DELTA);
    }

    @Test
    void divisionSecondZeroOperand_NotOk() {
        assertThrows(IncorrectDataEntryException.class, () -> calculator.calculate(44.44, 0,
                '/'));
    }

    @Test
    void divisionTwoZeroOperands_NotOk() {
        assertThrows(IncorrectDataEntryException.class, () -> calculator.calculate(0, 0,
                '/'));
    }

    @Test
    void divisionTwoMaxValueOperand_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                '/'), DELTA);
    }

    @Test
    void divisionTwoMinValueOperand_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,
                '/'));
    }

    @Test
    void divisionToOneMaxValueOperand_Ok() {
        double expected = Double.MAX_VALUE / 20.222;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 20.222,
                '/'));
    }

    @Test
    void divisionToOneMinValueOperand_Ok() {
        double expected = Double.MIN_VALUE / 5.555;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 5.555,
                '/'));
    }

    @Test
    void raisingPositiveValueToPositivePower_Ok() {
        double expected = Math.pow(2.22, 3.33);
        assertEquals(expected, calculator.calculate(2.22, 3.33,
                '^'), DELTA);
    }

    @Test
    void raisingNegativeValueToPositivePower_Ok() {
        double expected = Math.pow(-2.22, 3.33);
        assertEquals(expected, calculator.calculate(-2.22, 3.33,
                '^'), DELTA);
    }

    @Test
    void raisingPositiveValueToNegativePower_Ok() {
        double expected = Math.pow(2.22, -3.33);
        assertEquals(expected, calculator.calculate(2.22, -3.33,
                '^'), DELTA);
    }

    @Test
    void raisingNegativeValueToNegativePower_Ok() {
        double expected = Math.pow(-2.22, -3.33);
        assertEquals(expected, calculator.calculate(-2.22, -3.33,
                '^'), DELTA);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(2.22, 0,
                '^'));
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(-2.22, 0,
                '^'));
    }

    @Test
    void raisingZeroValueToPower_Ok() {
        double expected = 0.0;
        assertEquals(expected, calculator.calculate(0, 2.22,
                '^'));
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(IncorrectDataEntryException.class, () -> calculator.calculate(2.22, 3.33,
                '%'));
    }
}
