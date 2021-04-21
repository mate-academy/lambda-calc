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

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculateAdditionWithTwoPositiveOperands_Ok() {
        expected = 68.648;
        assertEquals(expected, calculator.calculate(VALUE1,VALUE1,PLUS), DELTA);
    }

    @Test
    void calculateAdditionWithTwoNegativeOperands_Ok() {
        expected = -46.42;
        assertEquals(expected, calculator.calculate(VALUE2,VALUE2,PLUS), DELTA);
    }

    @Test
    void calculateAdditionWithPositiveAndNegativeOperands_Ok() {
        expected = 11.114;
        assertEquals(expected, calculator.calculate(VALUE1, VALUE2, PLUS), DELTA);
    }

    @Test
    void calculateAdditionWithZeroInDifferentPlaces_Ok() {
        expected = VALUE1;
        assertEquals(expected, calculator.calculate(VALUE1, ZERO, PLUS), DELTA);
        expected = VALUE2;
        assertEquals(expected, calculator.calculate(ZERO, VALUE2, PLUS), DELTA);
    }

    @Test
    void calculateAdditionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, VALUE1, PLUS), DELTA);
        expected = 34.324;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, VALUE1, PLUS), DELTA);
    }

    @Test
    void calculateSubtractionWithTwoPositiveOperands_Ok() {
        expected = ZERO;
        assertEquals(expected, calculator.calculate(VALUE1,VALUE1,SUBTRACTION), DELTA);
    }

    @Test
    void calculateSubtractionWithTwoNegativeOperands_Ok() {
        expected = ZERO;
        assertEquals(expected, calculator.calculate(VALUE2,VALUE2,SUBTRACTION), DELTA);
    }

    @Test
    void calculateSubtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 57.534;
        assertEquals(expected, calculator.calculate(VALUE1, VALUE2, SUBTRACTION), DELTA);
    }

    @Test
    void calculateSubtractionWithZeroInDifferentPlaces_Ok() {
        expected = VALUE1;
        assertEquals(expected, calculator.calculate(VALUE1, ZERO, SUBTRACTION), DELTA);
        expected = Math.abs(VALUE2);
        assertEquals(expected, calculator.calculate(ZERO, VALUE2, SUBTRACTION), DELTA);
    }

    @Test
    void calculateSubtractionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, VALUE1, SUBTRACTION), DELTA);
        expected = -34.324;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, VALUE1, SUBTRACTION), DELTA);
    }

    @Test
    void calculateMultiplyWithTwoPositiveOperands_Ok() {
        expected = 1178.1369759999998;
        assertEquals(expected, calculator.calculate(VALUE1,VALUE1,MULTIPLY), DELTA);
    }

    @Test
    void calculateMultiplyWithTwoNegativeOperands_Ok() {
        expected = 538.7041;
        assertEquals(expected, calculator.calculate(VALUE2,VALUE2,MULTIPLY), DELTA);
    }

    @Test
    void calculateMultiplyWithPositiveAndNegativeOperands_Ok() {
        expected = -796.66004;
        assertEquals(expected, calculator.calculate(VALUE1, VALUE2, MULTIPLY), DELTA);
    }

    @Test
    void calculateMultiplyWithZeroInDifferentPlaces_Ok() {
        expected = ZERO;
        assertEquals(expected, calculator.calculate(VALUE1, ZERO, MULTIPLY), DELTA);
        expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, VALUE2, MULTIPLY), DELTA);
    }

    @Test
    void calculateMultiplyForMinAndMaxDoubleValues() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, VALUE1, MULTIPLY), DELTA);
        expected = ZERO;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, VALUE1, MULTIPLY), DELTA);
    }

    @Test
    void calculateDivideWithTwoPositiveOperands_Ok() {
        expected = 1;
        assertEquals(expected, calculator.calculate(VALUE1,VALUE1,DIVIDE), DELTA);
    }

    @Test
    void calculateDivideWithTwoNegativeOperands_Ok() {
        expected = 1;
        assertEquals(expected, calculator.calculate(VALUE2,VALUE2,DIVIDE), DELTA);
    }

    @Test
    void calculateDivideWithPositiveAndNegativeOperands_Ok() {
        expected = -1.4788453252908227;
        assertEquals(expected, calculator.calculate(VALUE1, VALUE2, DIVIDE), DELTA);
    }

    @Test
    void calculateDivideWithZeroInFirstPlaces_Ok() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(VALUE1, ZERO, DIVIDE);
        });
    }

    @Test
    void calculateDivideWithZeroInSecondPlaces_Ok() {
        expected = 0;
        assertEquals(expected, calculator.calculate(ZERO, VALUE1, DIVIDE), DELTA);
    }

    @Test
    void calculateDivideForMinAndMaxDoubleValues() {
        expected = 5.237423187455762E306;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, VALUE1, DIVIDE), DELTA);
        expected = ZERO;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, VALUE1, DIVIDE), DELTA);
    }

    @Test
    void calculatePowWithTwoPositiveOperands_Ok() {
        expected = 5.103429146499071E52;
        assertEquals(expected, calculator.calculate(VALUE1,VALUE1,POW), DELTA);
    }

    @Test
    void calculatePowWithTwoNegativeOperands_Ok() {
        expected = Double.NaN;
        assertEquals(expected, calculator.calculate(VALUE2,VALUE2,POW), DELTA);
    }

    @Test
    void calculatePowWithNegativeAndPositiveOperands_Ok() {
        expected = Double.NaN;
        assertEquals(expected, calculator.calculate(VALUE2,VALUE1,POW), DELTA);
    }

    @Test
    void calculatePowWithPositiveAndNegativeOperands_Ok() {
        expected = 2.2844039188379576E-36;
        assertEquals(expected, calculator.calculate(VALUE1, VALUE2, POW), DELTA);
    }

    @Test
    void calculatePowWithZeroInDifferentPlaces_Ok() {
        expected = 1;
        assertEquals(expected, calculator.calculate(VALUE1, ZERO, POW), DELTA);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(ZERO, VALUE2, POW), DELTA);
        expected = 1;
        assertEquals(expected, calculator.calculate(VALUE2, ZERO, POW), DELTA);
        expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, VALUE1, POW), DELTA);
    }

    @Test
    void calculatePowForMinAndMaxDoubleValues() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, VALUE1, POW), DELTA);
        expected = ZERO;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, VALUE1, POW), DELTA);
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
