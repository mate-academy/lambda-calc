package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculatorTest;

    @BeforeAll
    static void beforeAll() {
        calculatorTest = new Calculator();
    }

    @Test
    void add_positiveOperands_ok() {
        double actual = calculatorTest.calculate(12, 8, '+');
        assertEquals(20, actual);
    }

    @Test
    void add_negativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, '+');
        assertEquals(-111, actual);
    }

    @Test
    void add_operandsWithDifferentSign_ok() {
        double actual = calculatorTest.calculate(15, -24, '+');
        assertEquals(-9, actual);
    }

    @Test
    void add_zero_ok() {
        double actual = calculatorTest.calculate(0, -2, '+');
        double actual2 = calculatorTest.calculate(4, 0, '+');
        assertEquals(-2, actual);
        assertEquals(4, actual2);
    }

    @Test
    void add_minAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(Double.MAX_VALUE + Double.MIN_VALUE, actual);
    }

    @Test
    void subtract_positiveValues_ok() {
        double actual = calculatorTest.calculate(24, 4, '-');
        assertEquals(20, actual);
    }

    @Test
    void subtract_negativeValues_ok() {
        double actual = calculatorTest.calculate(-9, -4, '-');
        assertEquals(-5, actual);
    }

    @Test
    void subtract_differentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, '-');
        assertEquals(-70, actual);
    }

    @Test
    void subtract_withOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, '-');
        assertEquals(-4, actual);
        double actual2 = calculatorTest.calculate(21, 0, '-');
        assertEquals(21, actual2);
    }

    @Test
    void subtract_withMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(Double.MAX_VALUE - Double.MIN_VALUE, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        assertEquals(Double.MIN_VALUE - Double.MAX_VALUE, actual2);
    }

    @Test
    void multiply_PositiveOperands_ok() {
        double actual = calculatorTest.calculate(24, 4, '*');
        assertEquals(96, actual);
    }

    @Test
    void multiply_NegativeOperands_ok() {
        double actual = calculatorTest.calculate(-9.97, -4.565, '*');
        assertEquals(-9.97 * -4.565, actual);
    }

    @Test
    void multiply_differentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, '*');
        assertEquals(-325, actual);
    }

    @Test
    void multiply_withOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, '*');
        assertEquals(0, actual);
        double actual2 = calculatorTest.calculate(21, 0, '*');
        assertEquals(0, actual2);
    }

    @Test
    void multiply_minAndMaxValues_Ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(Double.MAX_VALUE * Double.MIN_VALUE, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        assertEquals(Double.MIN_VALUE * Double.MAX_VALUE, actual2);
    }

    @Test
    void divide_withTwoPositiveOperands_ok() {
        double actual = calculatorTest.calculate(12, 8, '/');
        assertEquals((double) 12 / 8, actual);
    }

    @Test
    void divide_withTwoNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, ':');
        assertEquals((double) -21 / -90, actual);
    }

    @Test
    void divide_withDifferentOperands_ok() {
        double actual = calculatorTest.calculate(15, -24, '/');
        assertEquals((double) 15 / -24, actual);
    }

    @Test
    void divide_zeroByValue_ok() {
        double actual = calculatorTest.calculate(0, -2, '/');
        assertEquals(0, actual);
    }

    @Test
    void divide_valueByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> calculatorTest.calculate(4, 0, ':'));
    }

    @Test
    void divide_withMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(Double.MAX_VALUE / Double.MIN_VALUE, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ':');
        assertEquals(Double.MIN_VALUE / Double.MAX_VALUE, actual2);
    }

    @Test
    void raise_positiveNumberToPower_ok() {
        double actual = calculatorTest.calculate(3, 3, '^');
        assertEquals(3 * 3 * 3, actual);
    }

    @Test
    void raise_NegativeNumberToPower_ok() {
        double actual = calculatorTest.calculate(-2, 3, '^');
        assertEquals(-8, actual);
    }

    @Test
    void raise_positiveNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(6, -8, '^');
        assertEquals(Math.pow(6, -8), actual);
    }

    @Test
    void raise_negativeNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(-12, -3, '^');
        assertEquals(Math.pow(-12, -3), actual);
    }

    @Test
    void raisingPositiveNumberToZero_Ok() {
        double actual = calculatorTest.calculate(6948, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void raisingNegativeNumberToZero_Ok() {
        double actual = calculatorTest.calculate(-74, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        double actual = calculatorTest.calculate(0, 23, '^');
        assertEquals(0, actual);
    }

    @Test
    void calculate_illegalCharacter_Ok() {
        assertThrows(RuntimeException.class, () -> calculatorTest.calculate(15, 3, 't'));
    }
}
