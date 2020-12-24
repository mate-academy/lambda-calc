package core.basesyntax;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void additionTwoPositive() {
        int a = 10;
        int b = 15;
        int expected = a + b;
        int actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionTwoNegative() {
        int a = -10;
        int b = -15;
        int expected = a + b;
        int actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionPositiveAndNegative() {
        int a = -10;
        int b = 15;
        int expected = a + b;
        int actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionZeroAtA() {
        int a = 0;
        int b = 15;
        int expected = a + b;
        int actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionZeroAtB() {
        int a = 10;
        int b = 0;
        int expected = a + b;
        int actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionMinAndMaxValues() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int expected = a + b;
        int actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoPositive() {
        int a = 10;
        int b = 15;
        int expected = a - b;
        int actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoNegative() {
        int a = -10;
        int b = -15;
        int expected = a - b;
        int actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositiveAndNegative() {
        int a = -10;
        int b = 15;
        int expected = a - b;
        int actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionZeroAtA() {
        int a = 0;
        int b = 15;
        int expected = a - b;
        int actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionZeroAtB() {
        int a = 10;
        int b = 0;
        int expected = a - b;
        int actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMinAndMaxValues() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int expected = a - b;
        int actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoPositive() {
        int a = 10;
        int b = 15;
        int expected = a * b;
        int actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoNegative() {
        int a = -10;
        int b = -15;
        int expected = a * b;
        int actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationPositiveAndNegative() {
        int a = -10;
        int b = 15;
        int expected = a * b;
        int actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationZeroAtA() {
        int a = 0;
        int b = 15;
        int expected = a * b;
        int actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationZeroAtB() {
        int a = 10;
        int b = 0;
        int expected = a * b;
        int actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMinAndMaxValues() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int expected = a * b;
        int actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoPositive() {
        int a = 10;
        int b = 15;
        int expected = a / b;
        int actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoNegative() {
        int a = -10;
        int b = -15;
        int expected = a / b;
        int actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveAndNegative() {
        int a = -10;
        int b = 15;
        int expected = a / b;
        int actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionZeroAtA() {
        int a = 0;
        int b = 15;
        int expected = a / b;
        int actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionZeroAtB() {
        int a = 10;
        int b = 0;
        assertThrows(RuntimeException.class, () -> calculator.calculate(a, b, '/'));
    }

    @Test
    void divisionMinAndMaxValues() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int expected = a / b;
        int actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToPositive() {
        int a = 10;
        int b = 15;
        int expected = (int) Math.pow(a, b);
        int actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToPositive() {
        int a = -10;
        int b = 15;
        int expected = (int) Math.pow(a, b);
        int actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToNegative() {
        int a = 10;
        int b = -15;
        int expected = (int) Math.pow(a, b);
        int actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToNegative() {
        int a = -10;
        int b = -15;
        int expected = (int) Math.pow(a, b);
        int actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToZero() {
        int a = 10;
        int b = 0;
        int expected = (int) Math.pow(a, b);
        int actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToZero() {
        int a = -10;
        int b = 0;
        int expected = (int) Math.pow(a, b);
        int actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower() {
        int a = 0;
        int b = 15;
        int expected = (int) Math.pow(a, b);
        int actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation() {
        int a = 10;
        int b = 15;
        assertThrows(RuntimeException.class, () -> calculator.calculate(a, b, '$'));
    }
}
