package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';
    private static final char ILLEGAL_OPERATION = '!';
    private static final double POSITIVE_VALUE = 9876.543;
    private static final double NEGATIVE_VALUE = -1234.567;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;
    private static Calculate calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void checkAdditionTwoPositiveOperands() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        expected = POSITIVE_VALUE + POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionTwoNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        expected = NEGATIVE_VALUE + NEGATIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionPositiveAndNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ADDITION);
        expected = NEGATIVE_VALUE + POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionZeroDifferentOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, ADDITION);
        expected = NEGATIVE_VALUE + ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        expected = ZERO + POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionMinAndMaxValuesOperands() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        expected = Double.MAX_VALUE + POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, ADDITION);
        expected = POSITIVE_VALUE + Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionTwoPositiveOperands() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        expected = POSITIVE_VALUE - POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionTwoNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        expected = NEGATIVE_VALUE - NEGATIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionPositiveAndNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        expected = NEGATIVE_VALUE - POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionZeroDifferentOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, SUBTRACTION);
        expected = NEGATIVE_VALUE - ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_VALUE, SUBTRACTION);
        expected = ZERO - POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, ZERO, SUBTRACTION);
        expected = ZERO - ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionMinAndMaxValuesOperands() {
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = POSITIVE_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, SUBTRACTION);
        expected = Double.MIN_VALUE - POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationTwoPositiveOperands() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        expected = POSITIVE_VALUE * POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationTwoNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        expected = NEGATIVE_VALUE * NEGATIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationPositiveAndNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        expected = NEGATIVE_VALUE * POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationZeroDifferentOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, MULTIPLICATION);
        expected = NEGATIVE_VALUE * ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        expected = ZERO * POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationMinAndMaxValuesOperands() {
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = POSITIVE_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        expected = Double.MIN_VALUE * POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionTwoPositiveOperands() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        expected = POSITIVE_VALUE / POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionTwoNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        expected = NEGATIVE_VALUE / NEGATIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionPositiveAndNegativeOperands() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, DIVISION);
        expected = NEGATIVE_VALUE / POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionZeroDifferentOperands() {
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        expected = ZERO / POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionMinAndMaxValuesOperands() {
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, DIVISION);
        expected = POSITIVE_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, DIVISION);
        expected = Double.MIN_VALUE / POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void checkDivisionWithByZero() {
        try {
            calculator.calculate(POSITIVE_VALUE, ZERO, DIVISION);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException should be thrown if divided by 0");
    }

    @Test
    void checkRaisingPositiveAndNegativeValuesOperandsToPositivePower() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = Math.pow(POSITIVE_VALUE, POSITIVE_VALUE);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = Math.pow(NEGATIVE_VALUE, POSITIVE_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingPositiveAndNegativeValuesOperandsToNegativePower() {
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = Math.pow(POSITIVE_VALUE, NEGATIVE_VALUE);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = Math.pow(NEGATIVE_VALUE, NEGATIVE_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingPositiveAndNegativeValuesOperandsToZeroPower() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        expected = Math.pow(POSITIVE_VALUE, ZERO);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        expected = Math.pow(NEGATIVE_VALUE, ZERO);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingZeroOperandToPower() {
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = Math.pow(ZERO, POSITIVE_VALUE);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = Math.pow(ZERO, NEGATIVE_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkIllegalOperation() {
        try {
            calculator.calculate(ZERO, POSITIVE_VALUE, ILLEGAL_OPERATION);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException should be thrown if illegal operation type used");
    }
}
