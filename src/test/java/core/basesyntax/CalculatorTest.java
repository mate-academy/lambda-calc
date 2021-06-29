package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private static double first;
    private static double second;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
        first = 12.0;
        second = 5.0;
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(first, second, '$');
        });
    }

    @Test
    void addingTwoPositive_Ok() {
        double expected = first + second;
        assertEquals(expected, calculator.calculate(first, second, '+'), DELTA);
    }

    @Test
    void addingTwoNegative_Ok() {
        double expected = -first + -second;
        assertEquals(expected, calculator.calculate(-first, -second, '+'), DELTA);
    }

    @Test
    void addingNegativeAndPositive_Ok() {
        double expected = -first + second;
        assertEquals(expected, calculator.calculate(-first, second, '+'), DELTA);
    }

    @Test
    void addingWithZeroAtFirstPlace_Ok() {
        double expected = 0 + second;
        assertEquals(expected, calculator.calculate(0, second, '+'), DELTA);
    }

    @Test
    void addingWithZeroAtSecondPlace_Ok() {
        double expected = first + 0;
        assertEquals(expected, calculator.calculate(first, 0, '+'), DELTA);
    }

    @Test
    void addingToDoubleMaxValue_Ok() {
        double expected = Double.MAX_VALUE + second;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, second, '+'), DELTA);
    }

    @Test
    void dividingTwoPositive_Ok() {
        double expected = first / second;
        assertEquals(expected, calculator.calculate(first, second, '/'), DELTA);
    }

    @Test
    void dividingTwoNegative_Ok() {
        double expected = -first / -second;
        assertEquals(expected, calculator.calculate(-first, -second, '/'), DELTA);
    }

    @Test
    void dividingPositiveAndNegative_Ok() {
        double expected = first / -second;
        assertEquals(expected, calculator.calculate(first, -second, '/'), DELTA);
    }

    @Test
    void dividingWithZeroAtFirstPlace_Ok() {
        double expected = 0 / -second;
        assertEquals(expected, calculator.calculate(0, -second, '/'), DELTA);
    }

    @Test
    void dividingWithZeroAtSecondPlace_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(first, 0, '/');
        });
    }

    @Test
    void dividingDoubleMaxValue_Ok() {
        double expected = Double.MAX_VALUE / second;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, second, '/'), DELTA);
    }

    @Test
    void dividingByDoubleMaxValue_Ok() {
        double expected = first / Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(first, Double.MAX_VALUE, '/'), DELTA);
    }

    @Test
    void multiplicationTwoPositive_Ok() {
        double expected = first * second;
        assertEquals(expected, calculator.calculate(first, second, '*'), DELTA);
    }

    @Test
    void multiplicationTwoNegative_Ok() {
        double expected = -first * -second;
        assertEquals(expected, calculator.calculate(-first, -second, '*'), DELTA);
    }

    @Test
    void multiplicationPositiveAndNegative_Ok() {
        double expected = first * -second;
        assertEquals(expected, calculator.calculate(first, -second, '*'), DELTA);
    }

    @Test
    void multiplicationWithZeroAtFirstPlace_Ok() {
        double expected = 0 * second;
        assertEquals(expected, calculator.calculate(0, second, '*'), DELTA);
    }

    @Test
    void multiplicationWithZeroAtSecondPlace_Ok() {
        double expected = first * 0;
        assertEquals(expected, calculator.calculate(first, 0, '*'), DELTA);
    }

    @Test
    void multiplicationDoubleMaxValue_Ok() {
        char operation = '*';
        double expected = Double.MAX_VALUE * second;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, second, operation), DELTA);
    }

    @Test
    void multiplicationByDoubleMaxValue_Ok() {
        double expected = first * Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(first, Double.MAX_VALUE, '*'), DELTA);
    }

    @Test
    void subtractingTwoPositive_Ok() {
        double expected = first - second;
        assertEquals(expected, calculator.calculate(first, second, '-'), DELTA);
    }

    @Test
    void subtractingTwoNegative_Ok() {
        double expected = -first - -second;
        assertEquals(expected, calculator.calculate(-first, -second, '-'), DELTA);
    }

    @Test
    void subtractingPositiveAndNegative_Ok() {
        double expected = first - -second;
        assertEquals(expected, calculator.calculate(first, -second, '-'), DELTA);
    }

    @Test
    void subtractingWithZeroAtFirstPlace_Ok() {
        double expected = 0 - second;
        assertEquals(expected, calculator.calculate(0, second, '-'), DELTA);
    }

    @Test
    void subtractingWithZeroAtSecondPlace_Ok() {
        double expected = first - 0;
        assertEquals(expected, calculator.calculate(first, 0, '-'), DELTA);
    }

    @Test
    void subtractingFromDoubleMaxValue_Ok() {
        double expected = Double.MAX_VALUE - second;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, second, '-'), DELTA);
    }

    @Test
    void subtractingDoubleMaxValue_Ok() {
        double expected = first - Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(first, Double.MAX_VALUE, '-'), DELTA);
    }

    @Test
    void raisingPositiveValueToPositivePower_Ok() {
        double expected = Math.pow(first, second);
        assertEquals(expected, calculator.calculate(first, second, '^'), DELTA);
    }

    @Test
    void raisingNegativeValueToPositivePower_Ok() {
        double expected = Math.pow(-first, second);
        assertEquals(expected, calculator.calculate(-first, second, '^'), DELTA);
    }

    @Test
    void raisingPositiveValueToNegativePower_Ok() {
        double expected = Math.pow(first, -second);
        assertEquals(expected, calculator.calculate(first, -second, '^'), DELTA);
    }

    @Test
    void raisingNegativeValueToNegativePower_Ok() {
        double expected = Math.pow(-first, -second);
        assertEquals(expected, calculator.calculate(-first, -second, '^'), DELTA);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        double expected = Math.pow(first, 0);
        assertEquals(expected, calculator.calculate(first, 0, '^'), DELTA);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        double expected = Math.pow(-first, 0);
        assertEquals(expected, calculator.calculate(-first, 0, '^'), DELTA);
    }
}
