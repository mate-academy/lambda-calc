package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static final double DELTA = 0.0001;
    private static final double FIRST_PARAMETER = 0.1;
    private static final double SECOND_PARAMETER = 0.2;
    private static final double ZERO_PARAMETER = 0;
    private static final double DEGREE_OF_POWER = 3;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, SECOND_PARAMETER, '+');
        expected = 0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-FIRST_PARAMETER, -SECOND_PARAMETER, '+');
        expected = -0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, -SECOND_PARAMETER, '+');
        expected = -0.1;
        assertEquals(expected, actual);
        actual = calculator.calculate(-FIRST_PARAMETER, SECOND_PARAMETER, '+');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirthZeroOperands_ok() {
        actual = calculator.calculate(ZERO_PARAMETER, SECOND_PARAMETER, '+');
        expected = 0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithSecondZeroOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, ZERO_PARAMETER, '+');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMinDoubleValues_ok() {
        actual = calculator.calculate(Double.MIN_VALUE,Double.MIN_VALUE, '+');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithMaxDoubleValues_ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, SECOND_PARAMETER, '-');
        expected = -0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-FIRST_PARAMETER, -SECOND_PARAMETER, '-');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, -SECOND_PARAMETER, '-');
        expected = 0.3;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-FIRST_PARAMETER, SECOND_PARAMETER, '-');
        expected = -0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithFirthZeroOperands_ok() {
        actual = calculator.calculate(ZERO_PARAMETER, SECOND_PARAMETER, '-');
        expected = -0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondZeroOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, ZERO_PARAMETER, '-');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMinDoubleValues_ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithMaxDoubleValues_ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, SECOND_PARAMETER, '*');
        expected = 0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-FIRST_PARAMETER, -SECOND_PARAMETER, '*');
        expected = 0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, -SECOND_PARAMETER, '*');
        expected = -0.02;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-FIRST_PARAMETER, SECOND_PARAMETER, '*');
        expected = -0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithFirthZeroOperands_ok() {
        actual = calculator.calculate(ZERO_PARAMETER, SECOND_PARAMETER, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondZeroOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, ZERO_PARAMETER, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMinDoubleValues_ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithMaxDoubleValues_ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, SECOND_PARAMETER, '/');
        expected = 0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-FIRST_PARAMETER, -SECOND_PARAMETER, '/');
        expected = 0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, -SECOND_PARAMETER, '/');
        expected = -0.5;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-FIRST_PARAMETER, SECOND_PARAMETER, '/');
        expected = -0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithFirthZeroOperands_ok() {
        actual = calculator.calculate(ZERO_PARAMETER, SECOND_PARAMETER, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondZeroOperands_not0k() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(FIRST_PARAMETER, ZERO_PARAMETER, '/'));
    }

    @Test
    void calculate_divisionWithMinDoubleValues_ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMaxDoubleValues_ok() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, DEGREE_OF_POWER, '^');
        expected = 0.001;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_ok() {
        actual = calculator.calculate(-FIRST_PARAMETER, DEGREE_OF_POWER, '^');
        expected = -0.001;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, -DEGREE_OF_POWER, '^');
        expected = 1.0 / 0.1 / 0.1 / 0.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_ok() {
        actual = calculator.calculate(-FIRST_PARAMETER, -DEGREE_OF_POWER, '^');
        expected = 1.0 / -0.1 / -0.1 / -0.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_ok() {
        actual = calculator.calculate(FIRST_PARAMETER, ZERO_PARAMETER, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_ok() {
        actual = calculator.calculate(-FIRST_PARAMETER, ZERO_PARAMETER, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        actual = calculator.calculate(ZERO_PARAMETER, DEGREE_OF_POWER, '^');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalOperationException.class, () ->
                calculator.calculate(FIRST_PARAMETER, SECOND_PARAMETER, '#'));
    }
}
