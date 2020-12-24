package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;
    private int firstParam;
    private int secondParam;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionTwoPositive() {
        firstParam = 10;
        secondParam = 15;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionTwoNegative() {
        firstParam = -10;
        secondParam = -15;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionPositiveAndNegative() {
        firstParam = -10;
        secondParam = 15;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionZeroAtA() {
        firstParam = 0;
        secondParam = 15;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionZeroAtB() {
        firstParam = 10;
        secondParam = 0;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoPositive() {
        firstParam = 10;
        secondParam = 15;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoNegative() {
        firstParam = -10;
        secondParam = -15;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositiveAndNegative() {
        firstParam = -10;
        secondParam = 15;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionZeroAtA() {
        firstParam = 0;
        secondParam = 15;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionZeroAtB() {
        firstParam = 10;
        secondParam = 0;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoPositive() {
        firstParam = 10;
        secondParam = 15;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoNegative() {
        firstParam = -10;
        secondParam = -15;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationPositiveAndNegative() {
        firstParam = -10;
        secondParam = 15;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationZeroAtA() {
        firstParam = 0;
        secondParam = 15;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationZeroAtB() {
        firstParam = 10;
        secondParam = 0;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoPositive() {
        firstParam = 10;
        secondParam = 15;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoNegative() {
        firstParam = -10;
        secondParam = -15;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveAndNegative() {
        firstParam = -10;
        secondParam = 15;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionZeroAtA() {
        firstParam = 0;
        secondParam = 15;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionZeroAtB() {
        firstParam = 10;
        secondParam = 0;
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(firstParam, secondParam, '/'));
    }

    @Test
    void divisionMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToPositive() {
        firstParam = 10;
        secondParam = 15;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPositive() {
        firstParam = -10;
        secondParam = 15;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToNegative() {
        firstParam = 10;
        secondParam = -15;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToNegative() {
        firstParam = -10;
        secondParam = -15;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToZero() {
        firstParam = 10;
        secondParam = 0;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToZero() {
        firstParam = -10;
        secondParam = 0;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower() {
        firstParam = 0;
        secondParam = 15;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation() {
        firstParam = 10;
        secondParam = 15;
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(firstParam, secondParam, '$'));
    }
}
