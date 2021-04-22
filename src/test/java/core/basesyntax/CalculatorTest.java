package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double VALUE1 = 34.324;
    private static final double VALUE2 = -23.21;
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0;
    private static final char PLUS = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final char INVALID_OPERATOR = '#';
    private static double expected;
    private static double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculateAdditionWithTwoPositiveOperands_Ok() {
        expected = 68.648;
        actual = calculator.calculate(VALUE1,VALUE1,PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionWithTwoNegativeOperands_Ok() {
        expected = -46.42;
        actual = calculator.calculate(VALUE2,VALUE2,PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionWithPositiveAndNegativeOperands_Ok() {
        expected = 11.114;
        actual = calculator.calculate(VALUE1, VALUE2, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionWithZeroInDifferentPlaces_Ok() {
        expected = VALUE1;
        actual = calculator.calculate(VALUE1, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);
        expected = VALUE2;
        actual = calculator.calculate(ZERO, VALUE2, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateAdditionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, VALUE1, PLUS);
        assertEquals(expected, actual, DELTA);
        expected = 34.324;
        actual = calculator.calculate(Double.MIN_VALUE, VALUE1, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithTwoPositiveOperands_Ok() {
        expected = ZERO;
        actual = calculator.calculate(VALUE1,VALUE1,SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithTwoNegativeOperands_Ok() {
        expected = ZERO;
        actual = calculator.calculate(VALUE2,VALUE2,SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 57.534;
        actual = calculator.calculate(VALUE1, VALUE2, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionWithZeroInDifferentPlaces_Ok() {
        expected = VALUE1;
        actual = calculator.calculate(VALUE1, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
        expected = Math.abs(VALUE2);
        actual = calculator.calculate(ZERO, VALUE2, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateSubtractionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, VALUE1, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
        expected = -34.324;
        actual = calculator.calculate(Double.MIN_VALUE, VALUE1, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithTwoPositiveOperands_Ok() {
        expected = 1178.1369759999998;
        actual = calculator.calculate(VALUE1,VALUE1,MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithTwoNegativeOperands_Ok() {
        expected = 538.7041;
        actual = calculator.calculate(VALUE2,VALUE2,MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithPositiveAndNegativeOperands_Ok() {
        expected = -796.66004;
        actual = calculator.calculate(VALUE1, VALUE2, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyWithZeroInDifferentPlaces_Ok() {
        expected = ZERO;
        actual = calculator.calculate(VALUE1, ZERO, MULTIPLY);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(ZERO, VALUE2, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateMultiplyForMinAndMaxDoubleValues() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, VALUE1, MULTIPLY);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(Double.MIN_VALUE, VALUE1, MULTIPLY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithTwoPositiveOperands_Ok() {
        expected = 1;
        actual = calculator.calculate(VALUE1,VALUE1,DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithTwoNegativeOperands_Ok() {
        expected = 1;
        actual = calculator.calculate(VALUE2,VALUE2,DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithPositiveAndNegativeOperands_Ok() {
        expected = -1.4788453252908227;
        actual = calculator.calculate(VALUE1, VALUE2, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideWithZeroInSecondPlaces_Ok() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(VALUE1, ZERO, DIVIDE);
        });
    }

    @Test
    void calculateDivideWithZeroInFirstPlaces_Ok() {
        expected = 0;
        actual = calculator.calculate(ZERO, VALUE1, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateDivideForMinAndMaxDoubleValues() {
        expected = 5.237423187455762E306;
        actual = calculator.calculate(Double.MAX_VALUE, VALUE1, DIVIDE);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(Double.MIN_VALUE, VALUE1, DIVIDE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithTwoPositiveOperands_Ok() {
        expected = 5.103429146499071E52;
        actual = calculator.calculate(VALUE1,VALUE1,POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithTwoNegativeOperands_Ok() {
        expected = Double.NaN;
        actual = calculator.calculate(VALUE2,VALUE2,POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithNegativeAndPositiveOperands_Ok() {
        expected = Double.NaN;
        actual = calculator.calculate(VALUE2,VALUE1,POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithPositiveAndNegativeOperands_Ok() {
        expected = 2.2844039188379576E-36;
        actual = calculator.calculate(VALUE1, VALUE2, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowWithZeroInDifferentPlaces_Ok() {
        expected = 1;
        actual = calculator.calculate(VALUE1, ZERO, POW);
        assertEquals(expected, actual, DELTA);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(ZERO, VALUE2, POW);
        assertEquals(expected, actual, DELTA);
        expected = 1;
        actual = calculator.calculate(VALUE2, ZERO, POW);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(ZERO, VALUE1, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculatePowForMinAndMaxDoubleValues() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, VALUE1, POW);
        assertEquals(expected, actual, DELTA);
        expected = ZERO;
        actual = calculator.calculate(Double.MIN_VALUE, VALUE1, POW);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_WithIllegalOperation_isNotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(VALUE1, VALUE1, INVALID_OPERATOR);
            calculator.calculate(VALUE2, VALUE2, INVALID_OPERATOR);
            calculator.calculate(VALUE1, VALUE2, INVALID_OPERATOR);
            calculator.calculate(ZERO, VALUE1, INVALID_OPERATOR);
        });
    }
}
