package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculating calculator;
    private static final double DELTA = 0.0001;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_IllegalOperator_notOk() {
        assertThrows(IllegalOperatorException.class, () -> calculator.calculate(5, 5, '&'));
    }

    @Test
    void calculate_additionPositiveOperands() {
        actual = calculator.calculate(4, 6, '+');
        assertEquals(10, actual);
    }

    @Test
    void calculate_additionNegativeOperands() {
        actual = calculator.calculate(-4, -6, '+');
        assertEquals(-10, actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperands() {
        actual = calculator.calculate(-4, 6, '+');
        assertEquals(2, actual);
    }

    @Test
    void calculate_additionZeroOperand() {
        actual = calculator.calculate(0, 5, '+');
        assertEquals(5, actual);
        actual = calculator.calculate(10, 0, '+');
        assertEquals(10, actual);
    }

    @Test
    void calculate_additionMinMaxOperands() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(1.0E-323, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands() {
        actual = calculator.calculate(10, 5, '-');
        assertEquals(5, actual);
        actual = calculator.calculate(5, 10, '-');
        assertEquals(-5, actual);
    }

    @Test
    void calculate_subtractionNegativeOperands() {
        actual = calculator.calculate(-4, -6, '-');
        assertEquals(2, actual);
        actual = calculator.calculate(-6, -4, '-');
        assertEquals(-2, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperands() {
        actual = calculator.calculate(-5, 5, '-');
        assertEquals(-10, actual);
        actual = calculator.calculate(5, -5, '-');
        assertEquals(10, actual);
    }

    @Test
    void calculate_subtractionZeroOperand() {
        actual = calculator.calculate(0, 5, '-');
        assertEquals(-5, actual);
        actual = calculator.calculate(5, 0, '-');
        assertEquals(5, actual);
    }

    @Test
    void calculate_subtractionMinMaxOperands() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(0.00, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(0.00, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveOperands() {
        actual = calculator.calculate(5, 5, '*');
        assertEquals(25, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands() {
        actual = calculator.calculate(-5, -5, '*');
        assertEquals(25, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperands() {
        actual = calculator.calculate(-5, 5, '*');
        assertEquals(-25, actual);
    }

    @Test
    void calculate_multiplicationZeroOperand() {
        actual = calculator.calculate(0, 5, '*');
        assertEquals(0, actual);
    }

    @Test
    void calculate_multiplicationMinMaxOperands() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(0.00, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveOperands() {
        actual = calculator.calculate(10, 5, '/');
        assertEquals(2, actual, DELTA);
        actual = calculator.calculate(5, 10, '/');
        assertEquals(0.5, actual, DELTA);
    }

    @Test
    void calculate_divisionNegativeOperands() {
        actual = calculator.calculate(-10, -5, '/');
        assertEquals(2, actual, DELTA);
        actual = calculator.calculate(-5, -10, '/');
        assertEquals(0.5, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperands() {
        actual = calculator.calculate(-10, 5, '/');
        assertEquals(-2, actual, DELTA);
        actual = calculator.calculate(10, -5, '/');
        assertEquals(-2, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroOperand() {
        actual = calculator.calculate(0, 5, '/');
        assertEquals(0.0, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(5, 0, '/'));
    }

    @Test
    void calculate_divisionMinMaxOperands() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(1.00, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(1.00, actual, DELTA);
    }

    @Test
    void calculate_raisingToPositivePower() {
        actual = calculator.calculate(2, 3, '^');
        assertEquals(8, actual);
        actual = calculator.calculate(-2, 3, '^');
        assertEquals(-8, actual);
    }

    @Test
    void calculate_raisingToNegativePower() {
        actual = calculator.calculate(2, -3, '^');
        assertEquals(0.125, actual, DELTA);
        actual = calculator.calculate(-2, -3, '^');
        assertEquals(-0.125, actual, DELTA);
    }

    @Test
    void calculate_raisingToZeroPower() {
        actual = calculator.calculate(2, 0, '^');
        assertEquals(1, actual);
        actual = calculator.calculate(-2, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void calculate_raisingZeroToPower() {
        actual = calculator.calculate(0, 5, '^');
        assertEquals(0, actual);
    }
}
