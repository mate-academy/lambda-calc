package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double POSITIVE_OPERAND = 34.324;
    private static final double NEGATIVE_OPERAND = -23.21;
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static double expected;
    private static double actual;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculateAdditionWithTwoPositiveOperands_ok() {
        expected = 68.648;
        actual = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionWithTwoNegativeOperands_ok() {
        expected = -46.42;
        actual = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionWithPositiveAndNegativeOperands_ok() {
        expected = 11.114;
        actual = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionWithZeroInDifferentPlaces_ok() {
        expected = POSITIVE_OPERAND;
        actual = calculator.calculate(POSITIVE_OPERAND, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA);
        expected = NEGATIVE_OPERAND;
        actual = calculator.calculate(ZERO, NEGATIVE_OPERAND, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_OPERAND, ADDITION);
        assertEquals(expected, actual, DELTA);
        expected = 34.324;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_OPERAND, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithTwoPositiveOperands_ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithTwoNegativeOperands_ok() {
        expected = ZERO;
        actual = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithPositiveAndNegativeOperands_ok() {
        expected = 57.534;
        actual = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithZeroInDifferentPlaces_ok() {
        expected = POSITIVE_OPERAND;
        actual = calculator.calculate(POSITIVE_OPERAND, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
        expected = Math.abs(NEGATIVE_OPERAND);
        actual = calculator.calculate(ZERO, NEGATIVE_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
        expected = -34.324;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_OPERAND, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithTwoPositiveOperands_ok() {
        expected = 1178.1369759999998;
        actual = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithTwoNegativeOperands_ok() {
        expected = 538.7041;
        actual = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithPositiveAndNegativeOperands_ok() {
        expected = -796.66004;
        actual = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithZeroInDifferentPlaces_ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_OPERAND, ZERO, MULTIPLY);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(ZERO, NEGATIVE_OPERAND, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyForMinAndMaxDoubleValues() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_OPERAND, MULTIPLY);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_OPERAND, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithTwoPositiveOperands_ok() {
        expected = 1;
        actual = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithTwoNegativeOperands_ok() {
        expected = 1;
        actual = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithPositiveAndNegativeOperands_ok() {
        expected = -1.4788453252908227;
        actual = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithZeroInSecondPlaces_ok() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_OPERAND, ZERO, DIVIDE);
        });
    }

    @Test
    void calculateDivideWithZeroInFirstPlaces_ok() {
        expected = 0;
        actual = calculator.calculate(ZERO, POSITIVE_OPERAND, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideForMinAndMaxDoubleValues() {
        expected = 5.237423187455762E306;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_OPERAND, DIVIDE);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_OPERAND, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithTwoPositiveOperands_ok() {
        expected = 5.103429146499071E52;
        actual = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithTwoNegativeOperands_ok() {
        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithNegativeAndPositiveOperands_ok() {
        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_OPERAND, POSITIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithPositiveAndNegativeOperands_ok() {
        expected = 2.2844039188379576E-36;
        actual = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithZeroInDifferentPlaces_ok() {
        expected = 1;
        actual = calculator.calculate(POSITIVE_OPERAND, ZERO, POW);
        assertEquals(expected, actual, DELTA);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(ZERO, NEGATIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
        expected = 1;
        actual = calculator.calculate(NEGATIVE_OPERAND, ZERO, POW);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowForMinAndMaxDoubleValues() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_OPERAND, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_withIllegalOperation_isNotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, '&');
            calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, '#');
            calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, '@');
            calculator.calculate(ZERO, POSITIVE_OPERAND, '!');
        });
    }
}
