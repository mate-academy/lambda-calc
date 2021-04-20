package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION_1 = '/';
    private static final char DIVISION_2 = ':';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';
    private static Calculator calculatorTest;

    @BeforeAll
    static void beforeAll() {
        calculatorTest = new Calculator();
    }

    @Test
    void add_positiveOperands_ok() {
        double actual = calculatorTest.calculate(12.4, 8.6, ADDITION);
        assertEquals(21, actual);
    }

    @Test
    void add_negativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, ADDITION);
        assertEquals(-111, actual);
    }

    @Test
    void add_operandsWithDifferentSign_ok() {
        double actual = calculatorTest.calculate(15, -24, ADDITION);
        assertEquals(-9, actual);
    }

    @Test
    void add_zero_ok() {
        double actual = calculatorTest.calculate(0, -2, ADDITION);
        double actual2 = calculatorTest.calculate(4, 0, ADDITION);
        assertEquals(-2, actual);
        assertEquals(4, actual2);
    }

    @Test
    void add_minAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(Double.MAX_VALUE + Double.MIN_VALUE, actual);
    }

    @Test
    void subtract_positiveValues_ok() {
        double actual = calculatorTest.calculate(24, 4, SUBTRACTION);
        assertEquals(20, actual);
    }

    @Test
    void subtract_negativeValues_ok() {
        double actual = calculatorTest.calculate(-9, -4, SUBTRACTION);
        assertEquals(-5, actual);
    }

    @Test
    void subtract_differentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, SUBTRACTION);
        assertEquals(-70, actual);
    }

    @Test
    void subtract_withOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, SUBTRACTION);
        assertEquals(-4, actual);
        double actual2 = calculatorTest.calculate(21, 0, SUBTRACTION);
        assertEquals(21, actual2);
    }

    @Test
    void subtract_withMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(Double.MAX_VALUE - Double.MIN_VALUE, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(Double.MIN_VALUE - Double.MAX_VALUE, actual2);
    }

    @Test
    void multiply_PositiveOperands_ok() {
        double actual = calculatorTest.calculate(24, 4, MULTIPLICATION);
        assertEquals(96, actual);
    }

    @Test
    void multiply_NegativeOperands_ok() {
        double actual = calculatorTest.calculate(-9.97, -4.565, MULTIPLICATION);
        assertEquals(-9.97 * -4.565, actual);
    }

    @Test
    void multiply_differentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, MULTIPLICATION);
        assertEquals(-325, actual);
    }

    @Test
    void multiply_withOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, MULTIPLICATION);
        assertEquals(0, actual);
        double actual2 = calculatorTest.calculate(21, 0, MULTIPLICATION);
        assertEquals(0, actual2);
    }

    @Test
    void multiply_minAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(Double.MAX_VALUE * Double.MIN_VALUE, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(Double.MIN_VALUE * Double.MAX_VALUE, actual2);
    }

    @Test
    void divide_withTwoPositiveOperands_ok() {
        double actual = calculatorTest.calculate(12, 8, DIVISION_1);
        assertEquals((double) 12 / 8, actual);
    }

    @Test
    void divide_withTwoNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, DIVISION_2);
        assertEquals((double) -21 / -90, actual);
    }

    @Test
    void divide_withDifferentOperands_ok() {
        double actual = calculatorTest.calculate(15, -24, DIVISION_1);
        assertEquals((double) 15 / -24, actual);
    }

    @Test
    void divide_zeroByValue_ok() {
        double actual = calculatorTest.calculate(0, -2, DIVISION_2);
        assertEquals(0, actual);
    }

    @Test
    void divide_valueByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> calculatorTest.calculate(4, 0, DIVISION_2));
    }

    @Test
    void divide_withMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION_1);
        assertEquals(Double.MAX_VALUE / Double.MIN_VALUE, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION_2);
        assertEquals(Double.MIN_VALUE / Double.MAX_VALUE, actual2);
    }

    @Test
    void raise_positiveNumberToPower_ok() {
        double actual = calculatorTest.calculate(3.65, 3, RAISING_TO_POWER);
        assertEquals(3.65 * 3.65 * 3.65, actual);
    }

    @Test
    void raise_NegativeNumberToPower_ok() {
        double actual = calculatorTest.calculate(-2, 3, RAISING_TO_POWER);
        assertEquals(-8, actual);
    }

    @Test
    void raise_positiveNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(6, -8, RAISING_TO_POWER);
        assertEquals(Math.pow(6, -8), actual);
    }

    @Test
    void raise_negativeNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(-12, -3, RAISING_TO_POWER);
        assertEquals(Math.pow(-12, -3), actual);
    }

    @Test
    void raisingPositiveNumberToZero_Ok() {
        double actual = calculatorTest.calculate(6948, 0, RAISING_TO_POWER);
        assertEquals(1, actual);
    }

    @Test
    void raisingNegativeNumberToZero_Ok() {
        double actual = calculatorTest.calculate(-74, 0, RAISING_TO_POWER);
        assertEquals(1, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        double actual = calculatorTest.calculate(0, 23, RAISING_TO_POWER);
        assertEquals(0, actual);
    }

    @Test
    void calculate_illegalCharacter_Ok() {
        assertThrows(RuntimeException.class, ()
                -> calculatorTest.calculate(15, 3, '3'));
    }
}
