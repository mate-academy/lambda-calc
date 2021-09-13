package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_ok() {
        double a = 0.1;
        double b = 0.2;
        actual = calculator.calculate(a, b, '+');
        expected = 0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_ok() {
        double a = -0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '+');
        expected = -0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_ok() {
        double a = 0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '+');
        expected = -0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirthZeroOperands_ok() {
        double a = 0;
        double b = 0.2;
        actual = calculator.calculate(a, b, '+');
        expected = 0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithSecondZeroOperands_ok() {
        double a = 0.1;
        double b = 0;
        actual = calculator.calculate(a, b, '+');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMinDoubleValues_ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        actual = calculator.calculate(a, b, '+');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithMaxDoubleValues_ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        actual = calculator.calculate(a, b, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_ok() {
        double a = 0.1;
        double b = 0.2;
        actual = calculator.calculate(a, b, '-');
        expected = -0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_ok() {
        double a = -0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '-');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_ok() {
        double a = 0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '-');
        expected = 0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithFirthZeroOperands_ok() {
        double a = 0;
        double b = 0.2;
        actual = calculator.calculate(a, b, '-');
        expected = -0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondZeroOperands_ok() {
        double a = 0.1;
        double b = 0;
        actual = calculator.calculate(a, b, '-');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMinDoubleValues_ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        actual = calculator.calculate(a, b, '-');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithMaxDoubleValues_ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        actual = calculator.calculate(a, b, '-');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_ok() {
        double a = 0.1;
        double b = 0.2;
        actual = calculator.calculate(a, b, '*');
        expected = 0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_ok() {
        double a = -0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '*');
        expected = 0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_ok() {
        double a = 0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '*');
        expected = -0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithFirthZeroOperands_ok() {
        double a = 0;
        double b = 0.2;
        actual = calculator.calculate(a, b, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondZeroOperands_ok() {
        double a = 0.1;
        double b = 0;
        actual = calculator.calculate(a, b, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMinDoubleValues_ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        actual = calculator.calculate(a, b, '*');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithMaxDoubleValues_ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        actual = calculator.calculate(a, b, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_ok() {
        double a = 0.1;
        double b = 0.2;
        actual = calculator.calculate(a, b, '/');
        expected = 0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_ok() {
        double a = -0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '/');
        expected = 0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_ok() {
        double a = 0.1;
        double b = -0.2;
        actual = calculator.calculate(a, b, '/');
        expected = -0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithFirthZeroOperands_ok() {
        double a = 0;
        double b = 0.2;
        actual = calculator.calculate(a, b, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondZeroOperands_not0k() {
        double a = 0.1;
        double b = 0;
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(a, b, '/'));
    }

    @Test
    void calculate_divisionWithMinDoubleValues_ok() {
        double a = Double.MIN_VALUE;
        double b = Double.MIN_VALUE;
        actual = calculator.calculate(a, b, '/');
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMaxDoubleValues_ok() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        actual = calculator.calculate(a, b, '/');
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_ok() {
        double a = 0.1;
        double b = 2;
        actual = calculator.calculate(a, b, '^');
        expected = 0.01;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_ok() {
        double a = -0.1;
        double b = 3;
        actual = calculator.calculate(a, b, '^');
        expected = -0.001;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_ok() {
        double a = 0.1;
        double b = -2;
        actual = calculator.calculate(a, b, '^');
        expected = 1.0 / 0.1 / 0.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_ok() {
        double a = -0.1;
        double b = -3;
        actual = calculator.calculate(a, b, '^');
        expected = 1.0 / -0.1 / -0.1 / -0.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_ok() {
        double a = 0.1;
        double b = 0;
        actual = calculator.calculate(a, b, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_ok() {
        double a = -0.1;
        double b = 0;
        actual = calculator.calculate(a, b, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        double a = 0;
        double b = 2;
        actual = calculator.calculate(a, b, '^');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        double a = 1;
        double b = 2;
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(a, b, '#'));
    }
}
