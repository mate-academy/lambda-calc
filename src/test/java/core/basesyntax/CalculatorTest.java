package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static BigCalculator calculator;
    private double first;
    private double second;
    private char operation;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addPositive_Ok() {
        first = 2.0;
        second = 1.0;
        operation = '+';
        double expected = 3.0;
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void addNegative_Ok() {
        first = -2.0;
        second = -1.0;
        operation = '+';
        double expected = -3.0;
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void addPositiveAndNegative_Ok() {
        first = 2.0;
        second = -1.0;
        double expected = 1.0;
        operation = '+';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void addWithZero_Ok() {
        first = 0.0;
        second = 1.0;
        operation = '+';
        double actual = calculator.calculate(first, second, operation);
        double expected = 1.0;
        assertEquals(expected, actual);

        first = 1.0;
        second = 0.0;
        actual = calculator.calculate(1.0, 0.0, operation);
        expected = 1.0;
        assertEquals(expected, actual);

        first = 0.0;
        second = 0.0;
        actual = calculator.calculate(0.0, 0.0, operation);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void addMaxAndMinDoubleValue() {
        first = Double.MAX_VALUE;
        second = Double.MIN_VALUE;
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        operation = '+';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositive_Ok() {
        first = 2.0;
        second = 1.0;
        double expected = 1.0;
        operation = '-';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionNegative_Ok() {
        first = -2.0;
        second = -1.0;
        double expected = -1.0;
        operation = '-';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositiveAndNegative_Ok() {
        first = 2.0;
        second = -1.0;
        double expected = 3.0;
        operation = '-';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZero_Ok() {
        first = 0.0;
        second = 1.0;
        operation = '-';
        double actual = calculator.calculate(first, second, operation);
        double expected = -1.0;
        assertEquals(expected, actual);

        first = 1.0;
        second = 0.0;
        actual = calculator.calculate(1.0, 0.0, operation);
        expected = 1.0;
        assertEquals(expected, actual);

        first = 0.0;
        second = 0.0;
        actual = calculator.calculate(0.0, 0.0, operation);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMaxAndMinDoubleValue_Ok() {
        first = Double.MAX_VALUE;
        second = Double.MIN_VALUE;
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        operation = '-';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationPositive_Ok() {
        first = 2.0;
        second = 1.0;
        double expected = 2.0;
        operation = '*';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationNegative_Ok() {
        first = -2.0;
        second = -1.0;
        double expected = 2.0;
        operation = '*';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationPositiveAndNegative_Ok() {
        first = 2.0;
        second = -1.0;
        double expected = -2.0;
        operation = '*';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZero_Ok() {
        first = 0.0;
        second = 1.0;
        operation = '*';
        double actual = calculator.calculate(first, second, operation);
        double expected = 0.0;
        assertEquals(expected, actual);

        first = 1.0;
        second = 0.0;
        actual = calculator.calculate(1.0, 0.0, operation);
        expected = 0.0;
        assertEquals(expected, actual);

        first = 0.0;
        second = 0.0;
        actual = calculator.calculate(0.0, 0.0, operation);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMaxAndMinDoubleValue_Ok() {
        first = Double.MAX_VALUE;
        second = Double.MIN_VALUE;
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        operation = '*';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveOk() {
        first = 2.0;
        second = 1.0;
        double expected = 2.0;
        operation = '/';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void divisionNegativeOk() {
        first = -2.0;
        second = -1.0;
        double expected = 2.0;
        operation = '/';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveAndNegative_Ok() {
        first = 2.0;
        second = -1.0;
        double expected = -2.0;
        operation = '/';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZero_Ok() {
        first = 0.0;
        second = 1.0;
        operation = '/';
        double actual = calculator.calculate(first, second, operation);
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZero_NotOk() {
        first = 0.0;
        second = 0.0;
        operation = '/';
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0.0, 0.0, operation));
        first = 1.0;
        second = 0.0;
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1.0, 0, operation));
    }

    @Test
    void divisionMaxAndMinDoubleValue_NotOk() {
        first = Double.MAX_VALUE;
        second = 0.0;
        operation = '/';
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(first, second, operation));
    }

    @Test
    void raisingPositiveAndNegativeToPositive_Ok() {
        first = 2.0;
        second = -3.0;
        double expected = 0.125;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeAndPositiveToNegative_Ok() {
        first = -2.0;
        second = 3.0;
        double expected = -8.0;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToNegative_Ok() {
        first = -2.0;
        second = -3.0;
        double expected = -0.125;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToPositive_Ok() {
        first = 2.0;
        second = 3.0;
        double expected = 8.0;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToZero_Ok() {
        first = 2.0;
        second = 0.0;
        double expected = 1.0;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToZero_Ok() {
        first = -2.0;
        second = 0.0;
        double expected = 1.0;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToZero_Ok() {
        first = 0.0;
        second = 0.0;
        double expected = 1.0;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        first = 0.0;
        second = 8.0;
        double expected = 0.0;
        operation = '^';
        double actual = calculator.calculate(first, second, operation);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        first = 0.0;
        second = 8.0;
        char illegalOperand = '?';
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(first, second, illegalOperand));
    }
}
