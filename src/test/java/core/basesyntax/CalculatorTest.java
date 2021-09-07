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
        first = 1211.0;
        second = 565.0;
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(first, second, '$'));
    }

    @Test
    void addingTwoPositive_Ok() {
        assertEquals(first + second,
                calculator.calculate(first, second, '+'),
                DELTA);
    }

    @Test
    void addingTwoNegative_Ok() {
        assertEquals(-first + -second,
                calculator.calculate(-first, -second, '+'),
                DELTA);
    }

    @Test
    void addingNegativeAndPositive_Ok() {
        assertEquals(-first + second,
                calculator.calculate(-first, second, '+'),
                DELTA);
    }

    @Test
    void addingWithZeroAtFirstPlace_Ok() {
        assertEquals(0 + second,
                calculator.calculate(0, second, '+'),
                DELTA);
    }

    @Test
    void addingWithZeroAtSecondPlace_Ok() {
        assertEquals(first + 0,
                calculator.calculate(first, 0, '+'),
                DELTA);
    }

    @Test
    void addingToDoubleMaxValue_Ok() {
        assertEquals(Double.MAX_VALUE + second,
                calculator.calculate(Double.MAX_VALUE, second, '+'),
                DELTA);
    }

    @Test
    void dividingTwoPositive_Ok() {
        assertEquals(first / second,
                calculator.calculate(first, second, '/'),
                DELTA);
    }

    @Test
    void dividingTwoNegative_Ok() {
        assertEquals(-first / -second,
                calculator.calculate(-first, -second, '/'),
                DELTA);
    }

    @Test
    void dividingPositiveAndNegative_Ok() {
        assertEquals(first / -second,
                calculator.calculate(first, -second, '/'),
                DELTA);
    }

    @Test
    void dividingWithZeroAtFirstPlace_Ok() {
        assertEquals(0 / -second,
                calculator.calculate(0, -second, '/'),
                DELTA);
    }

    @Test
    void dividingWithZeroAtSecondPlace_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(first, 0, '/'));
    }

    @Test
    void dividingDoubleMaxValue_Ok() {
        assertEquals(Double.MAX_VALUE / second,
                calculator.calculate(Double.MAX_VALUE, second, '/'),
                DELTA);
    }

    @Test
    void dividingByDoubleMaxValue_Ok() {
        assertEquals(first / Double.MAX_VALUE,
                calculator.calculate(first, Double.MAX_VALUE, '/'),
                DELTA);
    }

    @Test
    void multiplicationTwoPositive_Ok() {
        assertEquals(first * second,
                calculator.calculate(first, second, '*'),
                DELTA);
    }

    @Test
    void multiplicationTwoNegative_Ok() {
        assertEquals(-first * -second,
                calculator.calculate(-first, -second, '*'),
                DELTA);
    }

    @Test
    void multiplicationPositiveAndNegative_Ok() {
        assertEquals(first * -second,
                calculator.calculate(first, -second, '*'),
                DELTA);
    }

    @Test
    void multiplicationWithZeroAtFirstPlace_Ok() {
        assertEquals(0 * second,
                calculator.calculate(0, second, '*'),
                DELTA);
    }

    @Test
    void multiplicationWithZeroAtSecondPlace_Ok() {
        assertEquals(first * 0,
                calculator.calculate(first, 0, '*'),
                DELTA);
    }

    @Test
    void multiplicationDoubleMaxValue_Ok() {
        assertEquals(Double.MAX_VALUE * second,
                calculator.calculate(Double.MAX_VALUE, second, '*'),
                DELTA);
    }

    @Test
    void multiplicationByDoubleMaxValue_Ok() {
        assertEquals(first * Double.MAX_VALUE,
                calculator.calculate(first, Double.MAX_VALUE, '*'),
                DELTA);
    }

    @Test
    void subtractingTwoPositive_Ok() {
        assertEquals(first - second,
                calculator.calculate(first, second, '-'),
                DELTA);
    }

    @Test
    void subtractingTwoNegative_Ok() {
        assertEquals(-first - -second,
                calculator.calculate(-first, -second, '-'),
                DELTA);
    }

    @Test
    void subtractingPositiveAndNegative_Ok() {
        assertEquals(first - -second,
                calculator.calculate(first, -second, '-'),
                DELTA);
    }

    @Test
    void subtractingWithZeroAtFirstPlace_Ok() {
        assertEquals(0 - second,
                calculator.calculate(0, second, '-'),
                DELTA);
    }

    @Test
    void subtractingWithZeroAtSecondPlace_Ok() {
        assertEquals(first - 0,
                calculator.calculate(first, 0, '-'),
                DELTA);
    }

    @Test
    void subtractingFromDoubleMaxValue_Ok() {
        assertEquals(Double.MAX_VALUE - second,
                calculator.calculate(Double.MAX_VALUE, second, '-'),
                DELTA);
    }

    @Test
    void subtractingDoubleMaxValue_Ok() {
        assertEquals(first - Double.MAX_VALUE,
                calculator.calculate(first, Double.MAX_VALUE, '-'),
                DELTA);
    }

    @Test
    void raisingPositiveValueToPositivePower_Ok() {
        assertEquals(Math.pow(first, second),
                calculator.calculate(first, second, '^'),
                DELTA);
    }

    @Test
    void raisingNegativeValueToPositivePower_Ok() {
        assertEquals(Math.pow(-first, second),
                calculator.calculate(-first, second, '^'),
                DELTA);
    }

    @Test
    void raisingPositiveValueToNegativePower_Ok() {
        assertEquals(Math.pow(first, -second),
                calculator.calculate(first, -second, '^'),
                DELTA);
    }

    @Test
    void raisingNegativeValueToNegativePower_Ok() {
        assertEquals(Math.pow(-first, -second),
                calculator.calculate(-first, -second, '^'),
                DELTA);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        assertEquals(Math.pow(first, 0),
                calculator.calculate(first, 0, '^'),
                DELTA);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        assertEquals(Math.pow(-first, 0),
                calculator.calculate(-first, 0, '^'),
                DELTA);
    }
}
