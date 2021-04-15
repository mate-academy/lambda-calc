package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final double delta = 0.0001;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addTwoPositiveNumbers_isPositive() {
        double result = calculator.calculate(1.2, 4.4, '+');
        double expected = 5.6;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addTwoNegativeNumbers_isNegative() {
        double result = calculator.calculate(-2.0, -5.0, '+');
        double expected = -7.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addOneNegativeAndOnePositiveNumber_isNegative() {
        double result = calculator.calculate(2.0, -5, '+');
        double expected = -3.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addFirstZeroAndSecondPositiveNumber_isPositive() {
        double result = calculator.calculate(0, 5.3, '+');
        double expected = 5.3;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addFirstPositiveAndSecondZeroNumber_isPositive() {
        double result = calculator.calculate(5.6, 0, '+');
        double expected = 5.6;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addFirstNegativeAndSecondZeroNumber_isNegative() {
        double result = calculator.calculate(-5.2, 0, '+');
        double expected = -5.2;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addFirstZeroAndSecondNegativeNumber_isNegative() {
        double result = calculator.calculate(0, -5.8, '+');
        double expected = -5.8;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addDoubleMinAndDoubleMaxNumbers_isPositive() {
        double result = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '+');
        double expected = 0.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addTwoDoubleMin_isNegativeInfinity() {
        double result = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, '+');
        double expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_addTwoDoubleMax_isPositiveInfinity() {
        double result = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractTwoPositiveFirstBiggerThenSecond_isPositive() {
        double result = calculator.calculate(5.2, 2.7, '-');
        double expected = 2.5;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractTwoPositiveSecondBiggerThenFirst_isNegative() {
        double result = calculator.calculate(2.7, 5.0, '-');
        double expected = -2.3;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractTwoNegativeNumbersSecondBiggerThenFirst_isPositive() {
        double result = calculator.calculate(-2.7, -5.0, '-');
        double expected = 2.3;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractTwoNegativeNumbersFirstBiggerThenSecond_isNegative() {
        double result = calculator.calculate(-6.0, -5.0, '-');
        double expected = -1.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractFirstNegativeSecondPositive_isNegative() {
        double result = calculator.calculate(-6.0, 5.0, '-');
        double expected = -11.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractFirstPositiveSecondNegative_isPositive() {
        double result = calculator.calculate(6.0, -5.0, '-');
        double expected = 11.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractTwoEqualMinusNumbers_Zero() {
        double result = calculator.calculate(-6.0, -6.0, '-');
        double expected = 0.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractFirstZeroSecondPositive_isNegative() {
        double result = calculator.calculate(0.0, 6.0, '-');
        double expected = -6.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractFirstZeroSecondNegative_isPositive() {
        double result = calculator.calculate(0.0, -6.0, '-');
        double expected = 6.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractFirstNegativeSecondZero_isNegative() {
        double result = calculator.calculate(-6.0, 0.0, '-');
        double expected = -6.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractFirstPositiveSecondZero_isPositive() {
        double result = calculator.calculate(6.0, 0.0, '-');
        double expected = 6.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractTwoDoubleMin_isZero() {
        double result = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, '-');
        double expected = 0.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractDoubleMinFromDoubleMax_isPositive() {
        double result = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '-');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_subtractDoubleMaxValueFromDoubleMin_isNegative() {
        double result = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '-');
        double expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyTwoPositive_isPositive() {
        double result = calculator.calculate(2.5, 3.1, '*');
        double expected = 7.75;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyTwoNegative_isPositive() {
        double result = calculator.calculate(-2.5, -3.1, '*');
        double expected = 7.75;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyOneNegativeOnePositive_isNegative() {
        double result = calculator.calculate(-2.5, 3.1, '*');
        double expected = -7.75;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyOneZeroOnePositive_isZero() {
        double result = calculator.calculate(0, 3.1, '*');
        double expected = 0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyOneZeroOneNegative_isZero() {
        double result = calculator.calculate(-3.6, 0, '*');
        double expected = 0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyTwoDoubleMax_isPositiveInfinity() {
        double result = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyTwoDoubleMin_isPositiveInfinity() {
        double result = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_multiplyDoubleMinByDoubleMax_isNegativeInfinity() {
        double result = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '*');
        double expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_divisionTwoPositive_isPositive() {
        double result = calculator.calculate(2.5, 5.3, '/');
        double expected = 0.47169;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_divisionTwoNegative_isPositive() {
        double result = calculator.calculate(-2.5, -5.3, '/');
        double expected = 0.47169;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_divisionOneNegativeSecondPositive_isNegative() {
        double result = calculator.calculate(2.5, -5.3, '/');
        double expected = -0.47169;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_divisionByZero_isArithmeticException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(2.5, 0, '/'));
    }

    @Test
    void calculate_divisionFirstZeroSecondPositive_isZero() {
        double result = calculator.calculate(0, 5.3, '/');
        double expected = 0.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_divisionTwoDoubleMax_isPositiveOne() {
        double result = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        double expected = 1.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_divisionTwoDoubleMin_isPositiveOne() {
        double result = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, '/');
        double expected = 1.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_divisionDoubleMinByDoubleMax_isNegativeOne() {
        double result = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '/');
        double expected = -1.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerTwoPositiveNumbers_isPositive() {
        double result = calculator.calculate(2, 4, '^');
        double expected = 16;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerTwoNegativeNumbers_isPositive() {
        double result = calculator.calculate(-2, -4, '^');
        double expected = 0.0625;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerPositiveNumberNegativeExponent_isPositive() {
        double result = calculator.calculate(2, -4, '^');
        double expected = 0.0625;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerPositiveNumberZeroExponent_isOne() {
        double result = calculator.calculate(2, 0, '^');
        double expected = 1.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerNegativeNumberZeroExponent_isOne() {
        double result = calculator.calculate(-2, 0, '^');
        double expected = 1.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerZeroNumberPositiveExponent_isZero() {
        double result = calculator.calculate(0, 2, '^');
        double expected = 0.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerZeroNumberNegativeExponent_isPositiveInfinity() {
        double result = calculator.calculate(0, -2.5, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerPositiveNumberToDoubleMaxExponent_isPositiveInfinity() {
        double result = calculator.calculate(3, Double.MAX_VALUE, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerNegativeNumberToDoubleMaxExponent_isPositiveInfinity() {
        double result = calculator.calculate(-3, Double.MAX_VALUE, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }

    @Test
    void calculate_powerPositiveNumberToDoubleMinValue_isZero() {
        double result = calculator.calculate(5, -Double.MAX_VALUE, '^');
        double expected = 0.0;
        assertEquals(expected, result, delta,
                String.format("Expected is %.1f but get %.1f", expected, result));
    }
}
