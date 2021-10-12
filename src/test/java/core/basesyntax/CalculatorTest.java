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
    private static final double DELTA = 0.001;
    private static final double POSITIVE_FIRST = 2.3;
    private static final double POSITIVE_SECOND = 3.2;
    private static final double NEGATIVE_FIRST = -2.3;
    private static final double NEGATIVE_SECOND = -3.2;
    private static final double ZERO = 0;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static final double NAN = Double.NaN;

    private CalculatorInter calculatorInter = new Calculator();

    @Test
    void twoPositiveOperandsAddedOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, POSITIVE_SECOND, ADD);
        double expected = 5.5;
        assertEquals(expected, actual, DELTA, "two positive numbers not work!");
    }

    @Test
    void twoNegativeOperandsAddedOk() {
        double actual = calculatorInter.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, ADD);
        double expected = -5.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positiveAndNegativeOperandsAddedOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, ADD);
        double expected = -0.9;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void zeroOperandAddedOk() {
        double actual = calculatorInter.calculate(ZERO, POSITIVE_FIRST, ADD);
        double expected = POSITIVE_FIRST;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void maxMinDoubleValueAddedOk() {
        double actual = calculatorInter.calculate(MAX_VALUE, POSITIVE_SECOND, ADD);
        double expected = MAX_VALUE;
        assertEquals(expected, actual, DELTA);
        actual = calculatorInter.calculate(MIN_VALUE, POSITIVE_SECOND, ADD);
        expected = POSITIVE_SECOND;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void twoPositiveOperandsSubtractionOk() {
        double actual = calculatorInter.calculate(POSITIVE_SECOND, POSITIVE_FIRST, SUBTRACTION);
        double expected = 0.9;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void twoNegativeOperandsSubtractionOk() {
        double actual = calculatorInter.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, SUBTRACTION);
        double expected = 0.9;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positiveAndNegativeOperandsSubtractionOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, SUBTRACTION);
        double expected = 5.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void zeroOperandSubtractionOk() {
        double actual = calculatorInter.calculate(ZERO, POSITIVE_FIRST, SUBTRACTION);
        double expected = -POSITIVE_FIRST;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void maxMinDoubleValueSubtractionOk() {
        double actual = calculatorInter.calculate(MAX_VALUE, POSITIVE_SECOND, SUBTRACTION);
        double expected = MAX_VALUE;
        assertEquals(expected, actual, DELTA);
        actual = calculatorInter.calculate(MIN_VALUE, POSITIVE_SECOND, SUBTRACTION);
        expected = -POSITIVE_SECOND;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void twoPositiveOperandsMultiplicationOk() {
        double actual = calculatorInter.calculate(POSITIVE_SECOND, POSITIVE_FIRST, MULTIPLICATION);
        double expected = 7.36;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void twoNegativeOperandsMultiplicationOk() {
        double actual = calculatorInter.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, MULTIPLICATION);
        double expected = 7.36;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positiveAndNegativeOperandsMultiplicationOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, MULTIPLICATION);
        double expected = -7.36;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void zeroOperandMultiplicationOk() {
        double actual = calculatorInter.calculate(ZERO, POSITIVE_FIRST, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void maxMinDoubleValueMultiplicationOk() {
        double actual;
        double expected;
        Assertions.assertThrows(RuntimeException.class,
                () -> calculatorInter.calculate(MAX_VALUE, POSITIVE_SECOND, MULTIPLICATION));
        actual = calculatorInter.calculate(MIN_VALUE, POSITIVE_SECOND, MULTIPLICATION);
        expected = MIN_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void twoPositiveOperandsDivisionOk() {
        double actual = calculatorInter.calculate(POSITIVE_SECOND, POSITIVE_FIRST, DIVISION);
        double expected = 1.391;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void twoNegativeOperandsDivisionOk() {
        double actual = calculatorInter.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, DIVISION);
        double expected = 0.718;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positiveAndNegativeOperandsDivisionOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, DIVISION);
        double expected = -0.718;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void zeroOperandDivisionOk() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculatorInter.calculate(POSITIVE_FIRST, ZERO, DIVISION));
    }

    @Test
    void maxMinDoubleValueDivisionOk() {
        double actual = calculatorInter.calculate(MAX_VALUE, POSITIVE_SECOND, DIVISION);
        double expected = MAX_VALUE / POSITIVE_SECOND;
        assertEquals(expected, actual, DELTA);
        actual = calculatorInter.calculate(MIN_VALUE, POSITIVE_SECOND, DIVISION);
        expected = MIN_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positiveValueToPositivePowerOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, POSITIVE_SECOND, POWER);
        double expected = 14.372;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void negativeValueToPositivePowerOk() {
        double actual = calculatorInter.calculate(NEGATIVE_FIRST, POSITIVE_SECOND, POWER);
        double expected = NAN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positeveValueToNegativPowerOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, POWER);
        double expected = 0.147;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void negativeValueToNegativePowerOk() {
        double actual = calculatorInter.calculate(NEGATIVE_FIRST, NEGATIVE_FIRST, POWER);
        double expected = NAN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void positiveValueToZeroPowerOk() {
        double actual = calculatorInter.calculate(POSITIVE_FIRST, ZERO, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void negativeValueToZeroPowerOk() {
        double actual = calculatorInter.calculate(NEGATIVE_FIRST, ZERO, POWER);
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void zeroToPowerOk() {
        double actual = calculatorInter.calculate(ZERO, POSITIVE_FIRST, POWER);
        double expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalOperation() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculatorInter.calculate(POSITIVE_FIRST, ZERO, ILLEGAL_OPERATION));
    }
}
