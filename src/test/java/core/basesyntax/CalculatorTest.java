package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char EXPONENT = '^';
    private static final char ILLEGAL_OPERATOR = '$';
    private static final double POSITIVE_VALUE = 8535.7937;
    private static final double NEGATIVE_VALUE = -9876.5433;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWith2PositiveOperands_Ok() {
        expected = 17071.5874;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWith2NegativeOperands_Ok() {
        expected = -19753.0866;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        expected = -1340.7495999999992;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, ADDITION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, ADDITION);
        assertEquals(NEGATIVE_VALUE, actual, DELTA);
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, ADDITION);
        assertEquals(NEGATIVE_VALUE, actual, DELTA);
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
    }

    @Test
    void calculate_subtractionWith2PositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(ZERO, actual, DELTA);
    }

    @Test
    void calculate_subtractionWith2NegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(ZERO, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 18412.337;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
        expected = -POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(NEGATIVE_VALUE, actual, DELTA);
        expected = -NEGATIVE_VALUE;
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWith2PositiveOperands_Ok() {
        expected = 7.28597740889597E7;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWith2NegativeOperands_Ok() {
        expected = 9.754610755677488E7;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        expected = -8.43041360779172E7;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(ZERO, actual, DELTA);
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(ZERO, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(-ZERO, actual, DELTA);
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(-ZERO, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = 4.2173E-320;
        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = Double.NEGATIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = -4.88E-320;
        actual = calculator.calculate(NEGATIVE_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWith2PositiveOperands_Ok() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWith2NegativeOperands_Ok() {
        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        expected = -0.864249104238727;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        assertEquals(ZERO, actual, DELTA);

        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, DIVISION);
        assertEquals(-ZERO, actual, DELTA);
    }

    @Test
    void calculate_divisionForMinAndMaxDoubleValues_Ok() {
        expected = 2.1060644130402493E304;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);

        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);

        expected = -1.8201642824390957E304;
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);

        expected = Double.NEGATIVE_INFINITY;
        actual = calculator.calculate(NEGATIVE_VALUE, Double.MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToThePositivePower_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, EXPONENT);
        assertEquals(expected, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, EXPONENT);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, EXPONENT);
        assertEquals(ZERO, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, EXPONENT);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToZero_Ok() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, EXPONENT);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, EXPONENT);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, EXPONENT);
        assertEquals(ZERO, actual, DELTA);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, EXPONENT);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_withTheUseOfIllegalOperator_NotOk() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_OPERATOR);
        });
    }
}
