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
    private static final double SQUARE = 25;
    private static final double NEGATIVE_POW = -2;
    private static final double FLOAT_POW = 0.5;
    private static final double DELTA = 0.000_001;

    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveTest() {
        double result = calculator.calculate(POSITIVE_A, POSITIVE_B, PLUS);
        assertEquals(7.5, result, DELTA);
    }

    @Test
    public void additionPositiveNegativeTest() {
        double result = calculator.calculate(POSITIVE_A, NEGATIVE_A, PLUS);
        assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void additionNegativeTest() {
        double result = calculator.calculate(NEGATIVE_A, NEGATIVE_B, PLUS);
        assertEquals(-7.5, result, DELTA);
    }

    @Test
    public void additionZeroTest() {
        double result = calculator.calculate(POSITIVE_A, ZERO, PLUS);
        assertEquals(POSITIVE_A, result, DELTA);
    }

    @Test
    public void subtractionPositiveTest() {
        double result = calculator.calculate(POSITIVE_A, POSITIVE_B, MINUS);
        assertEquals(-2.5, result, DELTA);
    }

    @Test
    public void subtractionPositiveNegativeTest() {
        double result = calculator.calculate(POSITIVE_A, NEGATIVE_A, MINUS);
        assertEquals(5, result, DELTA);
    }

    @Test
    public void subtractionNegativeTest() {
        double result = calculator.calculate(NEGATIVE_A, NEGATIVE_B, MINUS);
        assertEquals(2.5, result, DELTA);
    }

    @Test
    public void subtractionZeroTest() {
        double result = calculator.calculate(POSITIVE_A, ZERO, MINUS);
        assertEquals(POSITIVE_A, result, DELTA);
    }

    @Test
    public void multiplicationPositiveTest() {
        double result = calculator.calculate(POSITIVE_A, POSITIVE_B, MULTIPLE);
        assertEquals(12.5, result, DELTA);
    }

    @Test
    public void multiplicationPositiveNegativeTest() {
        double result = calculator.calculate(POSITIVE_A, NEGATIVE_A, MULTIPLE);
        assertEquals(-6.25, result, DELTA);
    }

    @Test
    public void multiplicationNegativeTest() {
        double result = calculator.calculate(NEGATIVE_A, NEGATIVE_B, MULTIPLE);
        assertEquals(12.5, result, DELTA);
    }

    @Test
    public void multiplicationZeroTest() {
        double result = calculator.calculate(POSITIVE_A, ZERO, MULTIPLE);
        assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void divisionPositiveTest() {
        double result = calculator.calculate(POSITIVE_B, POSITIVE_A, DIVISION);
        assertEquals(2, result, DELTA);
    }

    @Test
    public void divisionPositiveNegativeTest() {
        double result = calculator.calculate(POSITIVE_A, NEGATIVE_A, DIVISION);
        assertEquals(-1, result, DELTA);
    }

    @Test
    public void divisionNegativeTest() {
        double result = calculator.calculate(NEGATIVE_B, NEGATIVE_A, DIVISION);
        assertEquals(2, result, DELTA);
    }

    @Test
    public void divisionZeroTest() {
        double result = calculator.calculate(ZERO, POSITIVE_A, DIVISION);
        assertEquals(ZERO, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void onZeroDivisionTest() {
        calculator.calculate(POSITIVE_B, ZERO, DIVISION);
    }

    @Test
    public void powerPositiveTest() {
        double result = calculator.calculate(POSITIVE_B, POSITIVE_B, POWER);
        assertEquals(3125, result, DELTA);
    }

    @Test
    public void powerNegativeTest() {
        double result = calculator.calculate(POSITIVE_B, NEGATIVE_POW, POWER);
        assertEquals(0.04, result, DELTA);
    }

    @Test
    public void powerFloatTest() {
        double result = calculator.calculate(SQUARE, FLOAT_POW, POWER);
        assertEquals(5, result, DELTA);
    }

    @Test
    public void powerZeroPositiveTest() {
        double result = calculator.calculate(ZERO, POSITIVE_A, POWER);
        assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void powerOneTest() {
        double result = calculator.calculate(POSITIVE_A, ZERO, POWER);
        assertEquals(1, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongSignTest() {
        calculator.calculate(POSITIVE_A, POSITIVE_B, WRONG_SIGN);
    }
}
