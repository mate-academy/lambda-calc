package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculating calculator;
    private static final double DELTA = 0.0001;

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
        double actual = calculator.calculate(4, 6, '+');
        assertEquals(10, actual);
    }

    @Test
    void calculate_additionNegativeOperands() {
        double actual = calculator.calculate(-4, -6, '+');
        assertEquals(-10, actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperands() {
        double actual = calculator.calculate(-4, 6, '+');
        assertEquals(2, actual);
        actual = calculator.calculate(6, -4, '+');
        assertEquals(2, actual);
    }

    @Test
    void calculate_additionZeroOperand() {
        double actual = calculator.calculate(0, 5, '+');
        assertEquals(5, actual);
        actual = calculator.calculate(10, 0, '+');
        assertEquals(10, actual);
        actual = calculator.calculate(0, 0, '+');
        assertEquals(0, actual);
    }

    @Test
    void calculate_additionMinMaxOperands() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(1.0E-323, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands() {
        double actual = calculator.calculate(10, 5, '-');
        assertEquals(5, actual);
        actual = calculator.calculate(5, 10, '-');
        assertEquals(-5, actual);
    }

    @Test
    void calculate_subtractionNegativeOperands() {
        double actual = calculator.calculate(-4, -6, '-');
        assertEquals(2, actual);
        actual = calculator.calculate(-6, -4, '-');
        assertEquals(-2, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperands() {
        double actual = calculator.calculate(-5, 5, '-');
        assertEquals(-10, actual);
        actual = calculator.calculate(5, -5, '-');
        assertEquals(10, actual);
    }

    @Test
    void calculate_subtractionZeroOperand() {
        double actual = calculator.calculate(0, 5, '-');
        assertEquals(-5, actual);
        actual = calculator.calculate(5, 0, '-');
        assertEquals(5, actual);
    }

    @Test
    void calculate_subtractionMinMaxOperands() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(0.00, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(0.00, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveOperands() {
        double actual = calculator.calculate(5, 5, '*');
        assertEquals(25, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands() {
        double actual = calculator.calculate(-5, -5, '*');
        assertEquals(25, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperands() {
        double actual = calculator.calculate(-5, 5, '*');
        assertEquals(-25, actual);
    }

    @Test
    void calculate_multiplicationZeroOperand() {
        double actual = calculator.calculate(0, 5, '*');
        assertEquals(0, actual);
    }

    @Test
    void calculate_multiplicationMinMaxOperands() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(Double.POSITIVE_INFINITY, actual);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(0.00, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveOperands() {
        double actual = calculator.calculate(10, 5, '/');
        assertEquals(2, actual, DELTA);
        actual = calculator.calculate(5, 10, '/');
        assertEquals(0.5, actual, DELTA);
    }

    @Test
    void calculate_divisionNegativeOperands() {
        double actual = calculator.calculate(-10, -5, '/');
        assertEquals(2, actual, DELTA);
        actual = calculator.calculate(-5, -10, '/');
        assertEquals(0.5, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperands() {
        double actual = calculator.calculate(-10, 5, '/');
        assertEquals(-2, actual, DELTA);
        actual = calculator.calculate(10, -5, '/');
        assertEquals(-2, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroOperand() {
        double actual = calculator.calculate(0, 5, '/');
        assertEquals(0.0, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(5, 0, '/'));
    }

    @Test
    void calculate_divisionMinMaxOperands() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(1.00, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(1.00, actual, DELTA);
    }

    @Test
    void calculate_raisingToPositivePower() {
        double actual = calculator.calculate(2, 3, '^');
        assertEquals(8, actual);
        actual = calculator.calculate(-2, 3, '^');
        assertEquals(-8, actual);
    }

    @Test
    void calculate_raisingToNegativePower() {
        double actual = calculator.calculate(2, -3, '^');
        assertEquals(0.125, actual, DELTA);
        actual = calculator.calculate(-2, -3, '^');
        assertEquals(-0.125, actual, DELTA);
    }

    @Test
    void calculate_raisingToZeroPower() {
        double actual = calculator.calculate(2, 0, '^');
        assertEquals(1, actual);
        actual = calculator.calculate(-2, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void calculate_raisingZeroToPower() {
        double actual = calculator.calculate(0, 5, '^');
        assertEquals(0, actual);
    }
}
