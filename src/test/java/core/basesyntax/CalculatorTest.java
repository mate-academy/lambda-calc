package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING_TO_A_POWER = '^';
    private static final double POSITIVE_VALUE = 123.123;
    private static final double NEGATIVE_VALUE = -456.456;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;

    private static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void checkAdditionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        double expected = 246.246;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        double expected = -912.912;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionWithPositiveAndNegativeOperands_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ADDITION);
        double expected = -333.333;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionWithZeroInFirstPlace_OK() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        double expected = 123.123;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionWithZeroInSecondPlace_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, ZERO, ADDITION);
        double expected = -456.456;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkAdditionForMinDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, ADDITION));
    }

    @Test
    void checkAdditionForMinDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, ADDITION));
    }

    @Test
    void checkAdditionForMaxDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION));
    }

    @Test
    void checkAdditionForMaxDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, ADDITION));
    }

    @Test
    void checkSubtractionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionWithPositiveAndNegativeOperands_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        double expected = 579.579;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionWithZeroInFirstPlace_OK() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, SUBTRACTION);
        double expected = -123.123;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionWithZeroInSecondPlace_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, SUBTRACTION);
        double expected = 123.123;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkSubtractionForMinDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, SUBTRACTION));
    }

    @Test
    void checkSubtractionForMinDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, SUBTRACTION));
    }

    @Test
    void checkSubtractionForMaxDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, SUBTRACTION));
    }

    @Test
    void checkSubtractionForMaxDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void checkMultiplicationWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        double expected = 15_159.2731;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        double expected = 208_352.0799;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationWithPositiveAndNegativeOperands_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        double expected = -56_200.2321;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkMultiplicationWithZeroInFirstPlace_OK() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void checkMultiplicationWithZeroInSecondPlace_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void checkMultiplicationForMinDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, MULTIPLICATION));
    }

    @Test
    void checkMultiplicationForMinDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, MULTIPLICATION));
    }

    @Test
    void checkMultiplicationForMaxDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, MULTIPLICATION));
    }

    @Test
    void checkMultiplicationForMaxDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void checkDivisionWithTwoPositiveOperands_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionWithTwoNegativeOperands_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionWithPositiveAndNegativeOperands_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        double expected = -0.2697;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionWithZeroInFirstPlace_OK() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkDivisionWithZeroInSecondPlace_OK() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_VALUE, ZERO, DIVISION));
    }

    @Test
    void checkDivisionForMinDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MIN_VALUE, POSITIVE_VALUE, DIVISION));
    }

    @Test
    void checkDivisionForMinDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, DIVISION));
    }

    @Test
    void checkDivisionForMaxDoubleValuesInFirstPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, DIVISION));
    }

    @Test
    void checkDivisionForMaxDoubleValuesInSecondPlace_NotOK() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, DIVISION));
    }

    @Test
    void checkRaisingPositiveValueToPositivePower_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        double expected = 2.3379324409797183E257;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingNegativeValueToPositivePower_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingPositiveValueToNegativePower_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingNegativeValueToNegativePower_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        double expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void checkRaisingPositiveValueToZeroPower_OK() {
        double actual = calculator.calculate(POSITIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void checkRaisingNegativeValueToZeroPower_OK() {
        double actual = calculator.calculate(NEGATIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void checkRaisingZeroToPower_OK() {
        double actual = calculator.calculate(ZERO, POSITIVE_VALUE, RAISING_TO_A_POWER);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void checkIllegalOperationNot_OK() {
        assertThrows(UnsupportedOperationException.class, () ->
                calculator.calculate(10, 10, '?'));
    }
}
