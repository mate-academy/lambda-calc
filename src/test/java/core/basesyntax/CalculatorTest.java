package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.1;
    private static Calculation count;

    @BeforeAll
    public static void beforeAll() {
        count = new Calculator();
    }

    @Test
    public void calculate_addition_positiveOperands() {
        double actual = count.calculate(6, 7, '+');
        assertEquals(13, actual);
    }

    @Test
    public void calculate_addition_negativeOperands() {
        double actual = count.calculate(-9, -11, '+');
        assertEquals(-20, actual);
    }

    @Test
    public void calculate_addition_positiveNegativeOperands() {
        double actual = count.calculate(10, -20, '+');
        assertEquals(-10, actual);
    }

    @Test
    public void calculate_addition_zeroOperands() {
        double actual = count.calculate(0, 0, '+');
        assertEquals(0, actual);
    }

    @Test
    public void calculate_addition_operandsMinValues() {
        double actual = count.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(1.0E-323, actual);
    }

    @Test
    public void calculate_addition_operandsMaxValues() {
        double actual = count.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertTrue(Double.isInfinite(actual));
    }

    @Test
    public void calculate_subtraction_positiveOperands() {
        double actual = count.calculate(6, 7, '-');
        assertEquals(-1, actual);
    }

    @Test
    public void calculate_subtraction_negativeOperands() {
        double actual = count.calculate(-9, -11, '-');
        assertEquals(2, actual);
    }

    @Test
    public void calculate_subtraction_positiveNegativeOperands() {
        double actual = count.calculate(10, -20, '-');
        assertEquals(30, actual);
    }

    @Test
    public void calculate_subtraction_zeroOperands() {
        double actual = count.calculate(0, 0, '-');
        assertEquals(0, actual);
    }

    @Test
    public void calculate_subtraction_operandsMinValues() {
        double actual = count.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    public void calculate_subtraction_operandsMaxValues() {
        double actual = count.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    public void calculate_multiplication_positiveOperands() {
        double actual = count.calculate(6, 7, '*');
        assertEquals(42, actual);
    }

    @Test
    public void calculate_multiplication_negativeOperands() {
        double actual = count.calculate(-9, -11, '*');
        assertEquals(99, actual);
    }

    @Test
    public void calculate_multiplication_positiveNegativeOperands() {
        double actual = count.calculate(10, -20, '*');
        assertEquals(-200, actual);
    }

    @Test
    public void calculate_multiplication_zeroOperands() {
        double actual = count.calculate(0, 2, '*');
        assertEquals(0, actual);
        actual = count.calculate(2, 0, '*');
        assertEquals(0, actual);
        actual = count.calculate(0, 0, '*');
        assertEquals(0, actual);
    }

    @Test
    public void calculate_multiplication_operandsMinValues() {
        double actual = count.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(0, actual);
    }

    @Test
    public void calculate_multiplication_operandsMaxValues() {
        double actual = count.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertTrue(Double.isInfinite(actual));
    }

    @Test
    public void calculate_division_positiveOperands() {
        double actual = count.calculate(1.4, 1.2, '/');
        assertEquals(1.2, actual, DELTA);
    }

    @Test
    public void calculate_division_negativeOperands() {
        double actual = count.calculate(-10, -2, '/');
        assertEquals(5, actual);
    }

    @Test
    public void calculate_division_positiveNegativeOperands() {
        double actual = count.calculate(10, -2, '/');
        assertEquals(-5, actual);
    }

    @Test
    public void calculate_division_zeroDividendOperand() {
        double actual = count.calculate(0, 5, '/');
        assertEquals(0, actual);
    }

    @Test
    public void calculate_division_zeroDividerOperand() {
        double actual = count.calculate(5, 0, '/');
        assertTrue(Double.isInfinite(actual));
    }

    @Test
    public void calculate_division_operandsMinValues() {
        double actual = count.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    public void calculate_division_operandsMaxValues() {
        double actual = count.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    void calculate_raising_positiveNegativeValue_positivePower() {
        double actual = count.calculate(2, 3, '^');
        assertEquals(8, actual);
        actual = count.calculate(-2, 3, '^');
        assertEquals(-8, actual);
    }

    @Test
    void calculate_raising_positiveNegativeValue_negativePower() {
        double actual = count.calculate(2, -2, '^');
        assertEquals(0.25, actual);
        actual = count.calculate(-2, -2, '^');
        assertEquals(0.25, actual);
    }

    @Test
    void calculate_raising_positiveNegativeValue_zeroPower() {
        double actual = count.calculate(2, 0, '^');
        assertEquals(1, actual);
        actual = count.calculate(-2, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void calculate_raising_zeroValue_positiveNegativePower() {
        double actual = count.calculate(0, -2, '^');
        assertTrue(Double.isInfinite(actual));
        actual = count.calculate(0, 2, '^');
        assertEquals(0, actual);
    }

    @Test
    void calculate_illegalOperation_isNotOk() {
        char invalidOperation = '%';
        assertThrows(IllegalOperationException.class, () -> {
            count.calculate(0, 2, invalidOperation);
        });
    }
}
