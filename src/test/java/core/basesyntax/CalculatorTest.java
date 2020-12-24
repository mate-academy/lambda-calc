package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculable calculator = new Calculator();

    @Test
    void addTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(15, 15, '+');
        assertEquals(30, actual);
    }

    @Test
    void addTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-15, -15, '+');
        assertEquals(-30, actual);
    }

    @Test
    void addPositiveAndNegativeNumber_Ok() {
        double actual = calculator.calculate(15, -15, '+');
        assertEquals(0, actual);
    }

    @Test
    void addZeroFirstArg_Ok() {
        double actual = calculator.calculate(0, 15, '+');
        assertEquals(15, actual);
    }

    @Test
    void addZeroSecondArg_Ok() {
        double actual = calculator.calculate(15, 0, '+');
        assertEquals(15, actual);
    }

    @Test
    void addMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, 15, '+');
        assertEquals(15 + Double.MIN_VALUE, actual);
    }

    @Test
    void addTwoMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(Double.MIN_VALUE + Double.MIN_VALUE, actual);
    }

    @Test
    void addMaxValue_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE * 0.1, '+');
        });
    }

    @Test
    void addMaxValue_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, 15, '+');
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    void addTwoMaxValues_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        });
    }

    @Test
    void subTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(15, 15, '-');
        assertEquals(0, actual);
    }

    @Test
    void subTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-15, -15, '-');
        assertEquals(0, actual);
    }

    @Test
    void subPositiveAndNegativeNumber_Ok() {
        double actual = calculator.calculate(15, -15, '-');
        assertEquals(30, actual);
    }

    @Test
    void subZeroFirstArg_Ok() {
        double actual = calculator.calculate(0, 15, '-');
        assertEquals(-15, actual);
    }

    @Test
    void subZeroSecondArg_Ok() {
        double actual = calculator.calculate(15, 0, '-');
        assertEquals(15, actual);
    }

    @Test
    void subMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, 15, '-');
        assertEquals(Double.MIN_VALUE - 15, actual);
    }

    @Test
    void subTwoMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    void subMaxValue_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, 15, '-');
        assertEquals(Double.MAX_VALUE - 15, actual);
    }

    @Test
    void subTwoMaxValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    void mulTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(2, 2, '*');
        assertEquals(4, actual);
    }

    @Test
    void mulTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-2, -2, '*');
        assertEquals(4, actual);
    }

    @Test
    void mulPositiveAndNegativeNumber_Ok() {
        double actual = calculator.calculate(2, -2, '*');
        assertEquals(-4, actual);
    }

    @Test
    void mulZeroFirstArg_Ok() {
        double actual = calculator.calculate(0, 15, '*');
        assertEquals(0, actual);
    }

    @Test
    void mulZeroSecondArg_Ok() {
        double actual = calculator.calculate(15, 0, '*');
        assertEquals(0, actual);
    }

    @Test
    void mulMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, 100, '*');
        assertEquals(100 * Double.MIN_VALUE, actual);
    }

    @Test
    void mulTwoMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(Double.MIN_VALUE * Double.MIN_VALUE, actual);
    }

    @Test
    void mulMaxValue_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, 15, '*');
        });
    }

    @Test
    void mulTwoMaxValues_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        });
    }

    @Test
    void divTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(15, 15, '/');
        assertEquals(1, actual);
    }

    @Test
    void divTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-15, -15, '/');
        assertEquals(1, actual);
    }

    @Test
    void divPositiveAndNegativeNumber_Ok() {
        double actual = calculator.calculate(15, -15, '/');
        assertEquals(-1, actual);
    }

    @Test
    void divZeroFirstArg_Ok() {
        double actual = calculator.calculate(0, 2, '/');
        assertEquals(0, actual);
    }

    @Test
    void divZeroSecondArg_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(15, 0, '/');
        });
    }

    @Test
    void divMinDoubleValue_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, 2, '/');
        assertEquals(Double.MIN_VALUE / 2, actual);
    }

    @Test
    void divTwoMinValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    void divMaxValue_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, 15, '/');
        assertEquals(Double.MAX_VALUE / 15, actual);
    }

    @Test
    void divTwoMaxValues_Ok() {
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    void powTwoPositiveNumbers_Ok() {
        double actual = calculator.calculate(2, 2, '^');
        assertEquals(4, actual);
    }

    @Test
    void powTwoNegativeNumbers_Ok() {
        double actual = calculator.calculate(-2, -2, '^');
        assertEquals(1.0 / 4, actual);
    }

    @Test
    void powPositiveAndNegativeNumber_Ok() {
        double actual = calculator.calculate(2, -2, '^');
        assertEquals(1.0 / 4, actual);
    }

    @Test
    void powNegativeAndPositiveNumber_Ok() {
        double actual = calculator.calculate(-2, 2, '^');
        assertEquals(4, actual);
    }

    @Test
    void powZeroFirstArg_Ok() {
        double actual = calculator.calculate(0, 2, '^');
        assertEquals(0, actual);
    }

    @Test
    void powZeroSecondArg_Ok() {
        double actual = calculator.calculate(15, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void powZeroPowerNegative_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, -2, '^');
        });
    }

    @Test
    void powNegativeAndFractionalNumber_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-2, 0.5, '^');
        });
    }

    @Test
    void wrongOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(3, 5, 'g');
        });
    }
}
