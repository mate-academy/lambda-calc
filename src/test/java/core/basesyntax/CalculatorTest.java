package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.InvalidOperatorException;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    void addition_TwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(13, 33, '+');
        assertEquals(46, actual);
    }

    @Test
    void addition_PositiveAndNegative_Ok() {
        double actual = calculator.calculate(22, -44, '+');
        assertEquals(-22, actual);
    }

    @Test
    void addition_TwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-22, -44, '+');
        assertEquals(-66, actual);
    }

    @Test
    void addition_ZeroLeftOperand_Ok() {
        double actual = calculator.calculate(0, -44, '+');
        assertEquals(-44, actual);
    }

    @Test
    void addition_ZeroRightOperand_Ok() {
        double actual = calculator.calculate(55, 0, '+');
        assertEquals(55, actual);
    }

    @Test
    void addition_DoubleMinAndMaxValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
        assertEquals(1.7976931348623157E308, actual);
    }

    @Test
    void subtract_TwoPositiveOperands_Ok() {
        double actual = calculator.calculate(55, 22, '-');
        assertEquals(33, actual);
    }

    @Test
    void subtract_TwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-64, -98, '-');
        assertEquals(34, actual);
    }

    @Test
    void subtract_PositiveAndNegative_Ok() {
        double actual = calculator.calculate(87, -66, '-');
        assertEquals(153, actual);
    }

    @Test
    void subtract_ZeroLeftOperand_Ok() {
        double actual = calculator.calculate(0, 654, '-');
        assertEquals(-654, actual);
    }

    @Test
    void subtract_ZeroRightOperand_Ok() {
        double actual = calculator.calculate(546, 0, '-');
        assertEquals(546, actual);
    }

    @Test
    void subtract_DoubleMinAndMaxValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        assertEquals(-1.7976931348623157E308, actual);
    }

    @Test
    void division_TwoPositive_Ok() {
        double actual = calculator.calculate(8, 4, '/');
        assertEquals(2, actual);
    }

    @Test
    void division_TwoNegative_Ok() {
        double actual = calculator.calculate(-258, -34, '/');
        assertEquals(7.588235294117647, actual);
    }

    @Test
    void division_PositiveAndNegative_Ok() {
        double actual = calculator.calculate(-232, 4, '/');
        assertEquals(-58, actual);
    }

    @Test
    void division_ZeroLeftOperand_ThrowException() {
        assertThrows(ArithmeticException.class, ()
                -> calculator.calculate(0, 4412, '/'));
    }

    @Test
    void division_ZeroRightOperand_ThrowException() {
        assertThrows(ArithmeticException.class, ()
                -> calculator.calculate(232, 0, '/'));
    }

    @Test
    void division_DoubleMinAndMaxValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        assertEquals(0.0, actual);
    }

    @Test
    void multiplication_TwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(2, 4, '*');
        assertEquals(8, actual);
    }

    @Test
    void multiplication_TwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-123, -44, '*');
        assertEquals(5412, actual);
    }

    @Test
    void multiplication_PositiveAndNegativeNumber_Ok() {
        double actual = calculator.calculate(23, 654, '*');
        assertEquals(15042, actual);
    }

    @Test
    void multiplication_ZeroRightOperand_Ok() {
        double actual = calculator.calculate(24214, 0, '*');
        assertEquals(0, actual);
    }

    @Test
    void multiplication_ZeroLeftOperand_Ok() {
        double actual = calculator.calculate(0, 5432, '*');
        assertEquals(0, actual);
    }

    @Test
    void multiplication_DoubleMinAndMaxValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        assertEquals(8.881784197001251E-16, actual);
    }

    @Test
    void raisingPower_PositiveValueToPositivePower_Ok() {
        double actual = calculator.calculate(43, 8, '^');
        assertEquals(1.1688200277601E13, actual);
    }

    @Test
    void raisingPower_NegativeValueToPositivePower_Ok() {
        double actual = calculator.calculate(-2, 7, '^');
        assertEquals(-128, actual);
    }

    @Test
    void raisingPower_PositiveValueToNegativePower_Ok() {
        double actual = calculator.calculate(22, -3, '^');
        assertEquals(9.391435011269723E-5, actual);
    }

    @Test
    void raisingPower_NegativeValueToNegativePower_Ok() {
        double actual = calculator.calculate(-2, -2, '^');
        assertEquals(0.25, actual);
    }

    @Test
    void raisingPower_PositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(2, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void raisingPower_NegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(-2, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void illegalOperation() {
        assertThrows(InvalidOperatorException.class, ()
                -> calculator.calculate(0, 3, '1'));
    }
}
