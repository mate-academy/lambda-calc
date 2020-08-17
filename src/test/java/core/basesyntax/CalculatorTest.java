package core.basesyntax;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLE = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final char WRONG_SIGN = '%';
    private static final double ZERO = 0;
    private static final double POSITIVE_A = 2.5;
    private static final double POSITIVE_B = 5;
    private static final double NEGATIVE_A = -2.5;
    private static final double NEGATIVE_B = -5;
    private static final double DELTA = 0.000_001;

    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionTest() {
        double result = calculator.calculate(POSITIVE_A, POSITIVE_B, PLUS);
        assertEquals(7.5, result, DELTA);
        result = calculator.calculate(POSITIVE_A, NEGATIVE_A, PLUS);
        assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(NEGATIVE_A, NEGATIVE_B, PLUS);
        assertEquals(-7.5, result, DELTA);
        result = calculator.calculate(POSITIVE_A, ZERO, PLUS);
        assertEquals(POSITIVE_A, result, DELTA);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.calculate(POSITIVE_A, POSITIVE_B, MINUS);
        assertEquals(-2.5, result, DELTA);
        result = calculator.calculate(POSITIVE_A, NEGATIVE_A, MINUS);
        assertEquals(5, result, DELTA);
        result = calculator.calculate(NEGATIVE_A, NEGATIVE_B, MINUS);
        assertEquals(2.5, result, DELTA);
        result = calculator.calculate(POSITIVE_A, ZERO, MINUS);
        assertEquals(POSITIVE_A, result, DELTA);
    }

    @Test
    public void multiplicationTest() {
        double result = calculator.calculate(POSITIVE_A, POSITIVE_B, MULTIPLE);
        assertEquals(12.5, result, DELTA);
        result = calculator.calculate(POSITIVE_A, NEGATIVE_A, MULTIPLE);
        assertEquals(-6.25, result, DELTA);
        result = calculator.calculate(NEGATIVE_A, NEGATIVE_B, MULTIPLE);
        assertEquals(12.5, result, DELTA);
        result = calculator.calculate(POSITIVE_A, ZERO, MULTIPLE);
        assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void divisionTest() {
        double result = calculator.calculate(POSITIVE_B, POSITIVE_B, POWER);
        assertEquals(3125, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_A, POWER);
        assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(POSITIVE_A, ZERO, POWER);
        assertEquals(1, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void onZeroDivisionTest() {
        calculator.calculate(POSITIVE_B, ZERO, DIVISION);
    }

    @Test
    public void powerTest() {
        double result = calculator.calculate(POSITIVE_B, POSITIVE_A, DIVISION);
        assertEquals(2, result, DELTA);
        result = calculator.calculate(POSITIVE_A, NEGATIVE_A, DIVISION);
        assertEquals(-1, result, DELTA);
        result = calculator.calculate(NEGATIVE_B, NEGATIVE_A, DIVISION);
        assertEquals(2, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_A, DIVISION);
        assertEquals(ZERO, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongSignTest() {
        calculator.calculate(POSITIVE_A, POSITIVE_B, WRONG_SIGN);
    }
}