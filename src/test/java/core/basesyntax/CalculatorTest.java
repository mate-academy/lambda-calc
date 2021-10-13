package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADD = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = 'p';
    private static final char ILLEGAL_OPERATION = 'f';

    private CalculatorInter calculatorInter = new Calculator();

    @Test
    void twoPositiveOperandsAddedOk() {
        double actual = calculatorInter.calculate(2.3, 3.2, ADD);
        double expected = 5.5;
        assertEquals(expected, actual, 0.001, "two positive numbers not work!");
    }

    @Test
    void twoNegativeOperandsAddedOk() {
        double actual = calculatorInter.calculate(-2.3, -3.2, ADD);
        double expected = -5.5;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void positiveAndNegativeOperandsAddedOk() {
        double actual = calculatorInter.calculate(2.3, -3.2, ADD);
        double expected = -0.9;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void zeroOperandAddedOk() {
        double actual = calculatorInter.calculate(0, 2.3, ADD);
        double expected = 2.3;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void maxMinDoubleValueAddedOk() {
        double actual = calculatorInter.calculate(Double.MAX_VALUE, 3.2, ADD);
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, 0.001);
        actual = calculatorInter.calculate(Double.MIN_VALUE, 3.2, ADD);
        expected = 3.2;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void twoPositiveOperandsSubtractionOk() {
        double actual = calculatorInter.calculate(3.2, 2.3, SUBTRACTION);
        double expected = 0.9;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void twoNegativeOperandsSubtractionOk() {
        double actual = calculatorInter.calculate(-2.3, -3.2, SUBTRACTION);
        double expected = 0.9;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void positiveAndNegativeOperandsSubtractionOk() {
        double actual = calculatorInter.calculate(2.3, -3.2, SUBTRACTION);
        double expected = 5.5;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void zeroOperandSubtractionOk() {
        double actual = calculatorInter.calculate(0, 2.3, SUBTRACTION);
        double expected = -2.3;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void maxMinDoubleValueSubtractionOk() {
        double actual = calculatorInter.calculate(Double.MAX_VALUE, 3.2, SUBTRACTION);
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, 0.001);
        actual = calculatorInter.calculate(Double.MIN_VALUE, 3.2, SUBTRACTION);
        expected = -3.2;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void twoPositiveOperandsMultiplicationOk() {
        double actual = calculatorInter.calculate(3.2, 2.3, MULTIPLICATION);
        double expected = 7.36;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void twoNegativeOperandsMultiplicationOk() {
        double actual = calculatorInter.calculate(-2.3, -3.2, MULTIPLICATION);
        double expected = 7.36;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void positiveAndNegativeOperandsMultiplicationOk() {
        double actual = calculatorInter.calculate(2.3, -3.2, MULTIPLICATION);
        double expected = -7.36;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void zeroOperandMultiplicationOk() {
        double actual = calculatorInter.calculate(0, 2.3, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void maxMinDoubleValueMultiplicationOk() {
        double actual;
        double expected;
        Assertions.assertThrows(RuntimeException.class,
                () -> calculatorInter.calculate(Double.MAX_VALUE, 3.2, MULTIPLICATION));
        actual = calculatorInter.calculate(Double.MIN_VALUE, 3.2, MULTIPLICATION);
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void twoPositiveOperandsDivisionOk() {
        double actual = calculatorInter.calculate(3.2, 2.3, DIVISION);
        double expected = 1.391;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void twoNegativeOperandsDivisionOk() {
        double actual = calculatorInter.calculate(-2.3, -3.2, DIVISION);
        double expected = 0.718;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void positiveAndNegativeOperandsDivisionOk() {
        double actual = calculatorInter.calculate(2.3, -3.2, DIVISION);
        double expected = -0.718;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void zeroOperandDivisionOk() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculatorInter.calculate(2.3, 0, DIVISION));
    }

    @Test
    void maxMinDoubleValueDivisionOk() {
        double actual = calculatorInter.calculate(Double.MAX_VALUE, 3.2, DIVISION);
        double expected = Double.MAX_VALUE / 3.2;
        assertEquals(expected, actual, 0.001);
        actual = calculatorInter.calculate(Double.MIN_VALUE, 3.2, DIVISION);
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void positiveValueToPositivePowerOk() {
        double actual = calculatorInter.calculate(2.3, 3.2, POWER);
        double expected = 14.372;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void negativeValueToPositivePowerOk() {
        double actual = calculatorInter.calculate(-2.3, 3.2, POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void positeveValueToNegativPowerOk() {
        double actual = calculatorInter.calculate(2.3, -2.3, POWER);
        double expected = 0.147;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void negativeValueToNegativePowerOk() {
        double actual = calculatorInter.calculate(-2.3, -2.3, POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void positiveValueToZeroPowerOk() {
        double actual = calculatorInter.calculate(2.3, 0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void negativeValueToZeroPowerOk() {
        double actual = calculatorInter.calculate(-2.3, 0, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void zeroToPowerOk() {
        double actual = calculatorInter.calculate(0, 2.3, POWER);
        double expected = 0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void illegalOperation() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculatorInter.calculate(2.3, 0, ILLEGAL_OPERATION));
    }
}
