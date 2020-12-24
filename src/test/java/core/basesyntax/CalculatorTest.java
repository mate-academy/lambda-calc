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
    private int firstParam;
    private int secondParam;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void additionTwoPositive() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionTwoNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_NEGATIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionPositiveAndNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionZeroAtA() {
        firstParam = ZERO_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionZeroAtB() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = ZERO_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void additionMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam + secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '+');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionTwoPositive() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionTwoNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_NEGATIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionPositiveAndNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionZeroAtA() {
        firstParam = ZERO_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionZeroAtB() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = ZERO_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam - secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '-');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationTwoPositive() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationTwoNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_NEGATIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationPositiveAndNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationZeroAtA() {
        firstParam = ZERO_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationZeroAtB() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = ZERO_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam * secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '*');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionTwoPositive() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionTwoNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_NEGATIVE_VALUE;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionPositiveAndNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionZeroAtA() {
        firstParam = ZERO_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void divisionZeroAtB() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = ZERO_VALUE;
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(firstParam, secondParam, '/'));
    }

    @Test
    public void divisionMinAndMaxValues() {
        firstParam = Integer.MAX_VALUE;
        secondParam = Integer.MIN_VALUE;
        double expected = firstParam / secondParam;
        double actual = calculator.calculate(firstParam, secondParam, '/');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToPositive() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingNegativeToPositive() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToNegative() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = SECOND_NEGATIVE_VALUE;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingNegativeToNegative() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = SECOND_NEGATIVE_VALUE;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToZero() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = ZERO_VALUE;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingNegativeToZero() {
        firstParam = FIRST_NEGATIVE_VALUE;
        secondParam = ZERO_VALUE;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingZeroToPower() {
        firstParam = ZERO_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        double expected = (int) Math.pow(firstParam, secondParam);
        double actual = calculator.calculate(firstParam, secondParam, '^');
        assertEquals(expected, actual);
    }

    @Test
    public void illegalOperation() {
        firstParam = FIRST_POSITIVE_VALUE;
        secondParam = SECOND_POSITIVE_VALUE;
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(firstParam, secondParam, '$'));
    }
}
