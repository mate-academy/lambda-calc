package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveOperands_Ok() {
        double expected = 23 + 17;
        double actual = calculator.calculate(23, 17, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeOperands_Ok() {
        double expected = -23 + -17;
        double actual = calculator.calculate(-23, -17, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        double expected = -23 + 17;
        double actual = calculator.calculate(-23, 17, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithFirstZero_Ok() {
        double expected = 0 + 23;
        double actual = calculator.calculate(0, 23, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithSecondZero_Ok() {
        double expected = 1 + 0;
        double actual = calculator.calculate(1, 0, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionForMinMaxValues_Ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE + Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinMaxValues_Ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE - Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE - Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinMaxValues_Ok() {
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionForMinMaxValues_Ok() {
        double expected = Double.MAX_VALUE / Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE / Double.MAX_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA);

        expected = Double.MAX_VALUE / Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE / Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_Ok() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(23, 0, '/'));
    }

    @Test
    void calculate_powerOfPositiveNumber_Ok() {
        double expected = Math.pow(17, 23);
        double actual = calculator.calculate(17, 23, '^');
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-17, 23);
        actual = calculator.calculate(-17, 23, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfTwoNegativeNumber_Ok() {
        double expected = Math.pow(17, -23);
        double actual = calculator.calculate(17, -23, '^');
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-17, -23);
        actual = calculator.calculate(-17, -23, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powerOfNumberWithZero_Ok() {
        double expected = Math.pow(17, 0);
        double actual = calculator.calculate(17, 0, '^');
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-17, 0);
        actual = calculator.calculate(-17, 0, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        double expected = Math.pow(0, 23);
        double actual = calculator.calculate(0, 23, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(17, 23, '&'));
    }
}
