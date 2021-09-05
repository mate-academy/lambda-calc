package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositivePositive_Ok() {
        double actual = calculator.calculate(10.1, 20.2, '+');
        double expected = 30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionNegativeNegative_Ok() {
        double actual = calculator.calculate(-10.1, -20.2, '+');
        double expected = -30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveNegative_Ok() {
        double actual = calculator.calculate(10.1, -20.2, '+');
        double expected = -10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveZero_Ok() {
        double actual = calculator.calculate(10.1, 0.0, '+');
        double expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionZeroNegative_Ok() {
        double actual = calculator.calculate(0.0, -20.0, '+');
        double expected = -20.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxDoubleMaxDouble_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMinDoubleMinDouble_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositivePositive_Ok() {
        double actual = calculator.calculate(10.1, 20.2, '-');
        double expected = -10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeNegative_Ok() {
        double actual = calculator.calculate(-10.1, -20.2, '-');
        double expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveNegative_Ok() {
        double actual = calculator.calculate(10.1, -20.2, '-');
        double expected = 30.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveZero_Ok() {
        double actual = calculator.calculate(10.1, 0.0, '-');
        double expected = 10.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionZeroNegative_Ok() {
        double actual = calculator.calculate(0.0, -20.0, '-');
        double expected = 20.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxDoubleMaxDouble_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinDoubleMinDouble_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositivePositive_Ok() {
        double actual = calculator.calculate(10.1, 20.2, '*');
        double expected = 204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationNegativeNegative_Ok() {
        double actual = calculator.calculate(-10.1, -20.2, '*');
        double expected = 204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveNegative_Ok() {
        double actual = calculator.calculate(10.1, -20.2, '*');
        double expected = -204.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveZero_Ok() {
        double actual = calculator.calculate(10.1, 0.0, '*');
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationZeroNegative_Ok() {
        double actual = calculator.calculate(0.0, -20.0, '*');
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMaxDoubleMaxDouble_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMinDoubleMinDouble_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositivePositive_Ok() {
        double actual = calculator.calculate(10.1, 20.2, '/');
        double expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeNegative_Ok() {
        double actual = calculator.calculate(-10.1, -20.2, '/');
        double expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveNegative_Ok() {
        double actual = calculator.calculate(10.1, -20.2, '/');
        double expected = -0.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveZero_NotOk() {
        assertThrows(DivisionByZero.class,
                () -> calculator.calculate(10.1, 0.0, '/'));
    }

    @Test
    void calculate_divisionZeroNegative_Ok() {
        double actual = calculator.calculate(0.0, -20.0, '/');
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionMaxDoubleMaxDouble_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        double expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinDoubleMinDouble_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToPositivePower_Ok() {
        double actual = calculator.calculate(2.0, 10.0, '^');
        double expected = 1024.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToPositivePower_Ok() {
        double actual = calculator.calculate(-2.0, 3.0, '^');
        double expected = -8.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToNegativePower_Ok() {
        double actual = calculator.calculate(2.0, -2.0, '^');
        double expected = 0.25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToNegativePower_Ok() {
        double actual = calculator.calculate(-2.0, -3.0, '^');
        double expected = -0.125;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveToZeroPower_Ok() {
        double actual = calculator.calculate(15.0, 0.0, '^');
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeToZeroPower_Ok() {
        double actual = calculator.calculate(-5.0, 0.0, '^');
        double expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPositivePower_Ok() {
        double actual = calculator.calculate(0.0, 4.0, '^');
        double expected = 0.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        assertThrows(IllegalOperation.class,
                () -> calculator.calculate(10, 20, '$'));
    }
}
