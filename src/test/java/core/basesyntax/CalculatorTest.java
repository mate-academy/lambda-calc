package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    public static final int FIRST_POSITIVE_VALUE = 10;
    public static final int SECOND_POSITIVE_VALUE = 15;
    public static final int ZERO_VALUE = 0;
    public static final int FIRST_NEGATIVE_VALUE = -10;
    public static final int SECOND_NEGATIVE_VALUE = -15;

    static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void additionTwoPositive() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionTwoNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_NEGATIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionPositiveAndNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionZeroAtA() {
        int firstParam = ZERO_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionZeroAtB() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = ZERO_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionMinAndMaxValues() {
        int firstParam = Integer.MAX_VALUE;
        int secondParam = Integer.MIN_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionTwoPositive() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionTwoNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_NEGATIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionPositiveAndNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionZeroAtA() {
        int firstParam = ZERO_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionZeroAtB() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = ZERO_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionMinAndMaxValues() {
        int firstParam = Integer.MAX_VALUE;
        int secondParam = Integer.MIN_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationTwoPositive() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationTwoNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_NEGATIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationPositiveAndNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationZeroAtA() {
        int firstParam = ZERO_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationZeroAtB() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = ZERO_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationMinAndMaxValues() {
        int firstParam = Integer.MAX_VALUE;
        int secondParam = Integer.MIN_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionTwoPositive() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = (double) firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionTwoNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_NEGATIVE_VALUE;
        double expected = (double) firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionPositiveAndNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = (double) firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionZeroAtA() {
        int firstParam = ZERO_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = (double) firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionZeroAtB() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = ZERO_VALUE;
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(firstParam, secondParam, '/'));
    }

    @Test
    public void divisionMinAndMaxValues() {
        int firstParam = Integer.MAX_VALUE;
        int secondParam = Integer.MIN_VALUE;
        double expected = (double) firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToPositive() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingNegativeToPositive() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToNegative() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = SECOND_NEGATIVE_VALUE;
        double expected = Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingNegativeToNegative() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = SECOND_NEGATIVE_VALUE;
        double expected = Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToZero() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = ZERO_VALUE;
        double expected = Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingNegativeToZero() {
        int firstParam = FIRST_NEGATIVE_VALUE;
        int secondParam = ZERO_VALUE;
        double expected = Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingZeroToPower() {
        int firstParam = ZERO_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        double expected = Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void illegalOperation() {
        int firstParam = FIRST_POSITIVE_VALUE;
        int secondParam = SECOND_POSITIVE_VALUE;
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(firstParam, secondParam, '$'));
    }
}
