package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.000_001;
    private static final double POSITIVE_FIRST = 5;
    private static final double POSITIVE_SECOND = 7.5;
    private static final double NEGATIVE_FIRST = -5;
    private static final double NEGATIVE_SECOND = -7.5;
    private static final double ZERO = 0;

    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void unexpectedSign() {
        calculator.calculate(POSITIVE_FIRST, '#', NEGATIVE_SECOND);
    }

    @Test
    public void additionTestPositivePositive() {
        double result = calculator.calculate(POSITIVE_FIRST, '+', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST + POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void additionTestPositiveNegative() {
        double result = calculator.calculate(POSITIVE_FIRST, '+', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST + NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void additionTestNegativeNegative() {
        double result = calculator.calculate(NEGATIVE_FIRST, '+', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST + NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void additionTestNegativeZero() {
        double result = calculator.calculate(NEGATIVE_SECOND, '+', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND + ZERO, result, DELTA);
    }

    @Test
    public void additionTestPositiveZero() {
        double result = calculator.calculate(POSITIVE_FIRST, '+', ZERO);
        Assert.assertEquals(POSITIVE_FIRST + ZERO, result, DELTA);
    }

    @Test
    public void subtractionTestPositivePositive() {
        double result = calculator.calculate(POSITIVE_FIRST, '-', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST - POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void subtractionTestPositiveNegative() {
        double result = calculator.calculate(POSITIVE_FIRST, '-', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST - NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void subtractionTestNegativeNegative() {
        double result = calculator.calculate(NEGATIVE_FIRST, '-', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST - NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void subtractionTestNegativeZero() {
        double result = calculator.calculate(NEGATIVE_SECOND, '-', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND - ZERO, result, DELTA);
    }

    @Test
    public void subtractionTestPositiveZero() {
        double result = calculator.calculate(POSITIVE_FIRST, '-', ZERO);
        Assert.assertEquals(POSITIVE_FIRST - ZERO, result, DELTA);
    }

    @Test
    public void multiplyingTestPositivePositive() {
        double result = calculator.calculate(POSITIVE_FIRST, '*', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST * POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void multiplyingTestPositiveNegative() {
        double result = calculator.calculate(POSITIVE_FIRST, '*', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST * NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void multiplyingTestNegativeNegative() {
        double result = calculator.calculate(NEGATIVE_FIRST, '*', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST * NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void multiplyingTestNegativeZero() {
        double result = calculator.calculate(NEGATIVE_SECOND, '*', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND * ZERO, result, DELTA);
    }

    @Test
    public void multiplyingTestPositiveZero() {
        double result = calculator.calculate(POSITIVE_FIRST, '*', ZERO);
        Assert.assertEquals(POSITIVE_FIRST * ZERO, result, DELTA);
    }

    @Test
    public void toDegreeTestPositivePositive() {
        double result = calculator.calculate(POSITIVE_FIRST, '^', POSITIVE_SECOND);
        Assert.assertEquals(Math.pow(POSITIVE_FIRST, POSITIVE_SECOND), result, DELTA);
    }

    @Test
    public void toDegreeTestPositiveNegative() {
        double result = calculator.calculate(POSITIVE_FIRST, '^', NEGATIVE_FIRST);
        Assert.assertEquals(Math.pow(POSITIVE_FIRST, NEGATIVE_FIRST), result, DELTA);
    }

    @Test
    public void toDegreeTestNegativeNegative() {
        double result = calculator.calculate(NEGATIVE_FIRST, '^', NEGATIVE_SECOND);
        Assert.assertEquals(Math.pow(NEGATIVE_FIRST, NEGATIVE_SECOND), result, DELTA);
    }

    @Test
    public void toDegreeTestNegativeZero() {
        double result = calculator.calculate(NEGATIVE_SECOND, '^', ZERO);
        Assert.assertEquals(Math.pow(NEGATIVE_SECOND, ZERO), result, DELTA);
    }

    @Test
    public void toDegreeTestPositiveZero() {
        double result = calculator.calculate(POSITIVE_SECOND, '^', ZERO);
        Assert.assertEquals(Math.pow(POSITIVE_SECOND, ZERO), result, DELTA);
    }

    @Test
    public void divisionTestPositivePositive() {
        double result = calculator.calculate(POSITIVE_FIRST, '/', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST / POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void divisionTestPositiveNegative() {
        double result = calculator.calculate(POSITIVE_FIRST, '/', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST / NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void divisionTestNegativeNegative() {
        double result = calculator.calculate(NEGATIVE_FIRST, '/', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST / NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void divisionTestZeroNegative() {
        double result = calculator.calculate(ZERO, '/', NEGATIVE_SECOND);
        Assert.assertEquals(ZERO / NEGATIVE_SECOND, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        double result = calculator.calculate(NEGATIVE_FIRST, '/', ZERO);
    }
}
