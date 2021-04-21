package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';
    private static final char ILLEGAL_OPERATION = '!';
    private static final double POSITIVE_VALUE = 9876.143;
    private static final double NEGATIVE_VALUE = -1234.167;
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
    void checkAdditionTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        expected = 19_752.286;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        expected = -2468.334;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ADDITION);
        expected = 8641.976;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionZeroDifferentOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, ADDITION);
        expected = NEGATIVE_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        expected = POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionMinAndMaxValuesOperands_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, ADDITION);
        expected = 9876.143;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        expected = -11_110.31;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionZeroDifferentOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, SUBTRACTION);
        expected = NEGATIVE_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_VALUE, SUBTRACTION);
        expected = -POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, ZERO, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionMinAndMaxValuesOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, SUBTRACTION);
        expected = Double.MIN_VALUE - POSITIVE_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        expected = 97_538_200.556_4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        expected = 1_523_168.183_89;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        expected = -121_888_09.777_9;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationZeroDifferentOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationMinAndMaxValuesOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        expected = 6.1E-322;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionTwoPositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, DIVISION);
        expected = -0.124_964_47;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionZeroDifferentOperands_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionMinAndMaxValuesOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, DIVISION);
        expected = 5.493786903044723E-305;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, DIVISION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void checkDivisionWithByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, ZERO, DIVISION);
        });
    }

    @Test
    void checkRaisingPositiveAndNegativeValuesOperandsToPositivePower_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingPositiveAndNegativeValuesOperandsToNegativePower_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingPositiveAndNegativeValuesOperandsToZeroPower_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingZeroOperandToPower_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkIllegalOperation_isNotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(ZERO, POSITIVE_VALUE, ILLEGAL_OPERATION);
        });
    }
}
