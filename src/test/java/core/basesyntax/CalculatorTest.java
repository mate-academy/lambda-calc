package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';
    private static final char ILLEGAL_OPERATOR = '!';
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWith2PositiveNumbers_Ok() {
        actual = calculator.calculate(2, 2, ADDITION);
        expected = 4;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(10.1, 20.2, ADDITION);
        expected = 30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeNumbers_Ok() {
        actual = calculator.calculate(288, -15, ADDITION);
        expected = 273;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-64.56, 88.33, ADDITION);
        expected = 23.77;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWith2NegativeNumbers_Ok() {
        actual = calculator.calculate(-3, -15, ADDITION);
        expected = -18;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-0.02001, -0.01002, ADDITION);
        expected = -0.03003;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZero_Ok() {
        actual = calculator.calculate(-1.7, 0, ADDITION);
        expected = -1.7;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0, 3.33, ADDITION);
        expected = 3.33;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 4578.214, ADDITION);
        expected = 4578.214;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWith2PositiveNumbers_Ok() {
        actual = calculator.calculate(12, 56, SUBTRACTION);
        expected = -44;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(10.2, 20.1, SUBTRACTION);
        expected = -9.9;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeNumbers_Ok() {
        actual = calculator.calculate(-64.56, 88.33, SUBTRACTION);
        expected = -152.89;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWith2NegativeNumbers_Ok() {
        actual = calculator.calculate(-3, -15, SUBTRACTION);
        expected = 12;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-0.02001, -0.01002, SUBTRACTION);
        expected = -0.00999;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZero_Ok() {
        actual = calculator.calculate(0, -1.7, SUBTRACTION);
        expected = 1.7;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = 0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 4578.214, SUBTRACTION);
        expected = -4578.214;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION);
        expected = 1.7976931348623157E308;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWith2PositiveNumbers_Ok() {
        actual = calculator.calculate(1.2, 2.1, MULTIPLICATION);
        expected = 2.52;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeNumbers_Ok() {
        actual = calculator.calculate(-4.56, 8.33, MULTIPLICATION);
        expected = -37.9848;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWith2NegativeNumbers_Ok() {
        actual = calculator.calculate(-3, -15, MULTIPLICATION);
        expected = 45;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZero_Ok() {
        actual = calculator.calculate(0, -1.7, MULTIPLICATION);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 1, MULTIPLICATION);
        expected = 4.9E-324;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION);
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWith2PositiveNumbers_Ok() {
        actual = calculator.calculate(20, 5, DIVISION);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeNumbers_Ok() {
        actual = calculator.calculate(-10.2, 2, DIVISION);
        expected = -5.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWith2NegativeNumbers_Ok() {
        actual = calculator.calculate(-3, -15, DIVISION);
        expected = 0.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZero_Ok() {
        actual = calculator.calculate(0, 2, DIVISION);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(2, 0, DIVISION));
    }

    @Test
    void calculate_divisionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 1, DIVISION);
        expected = 4.9E-324;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(5, 2, RAISING);
        expected = 25;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-5, 2, RAISING);
        expected = 25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(-5, -1, RAISING);
        expected = -0.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(5, -1, RAISING);
        expected = 0.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveAndNegativeValueToZero_Ok() {
        actual = calculator.calculate(5, 0, RAISING);
        expected = 1;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-5, 0, RAISING);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        actual = calculator.calculate(0, 2, RAISING);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_withIllegalOperation() {
        assertThrows(UnsupportedOperationException.class, () ->
                calculator.calculate(2, 1, ILLEGAL_OPERATOR));
    }
}
