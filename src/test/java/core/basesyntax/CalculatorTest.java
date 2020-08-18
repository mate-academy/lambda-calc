package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.000_001;
    private static final double POSITIVE_FIRST = 5;
    private static final double POSITIVE_SECOND = 7.5;
    private static final double NEGATIVE_FIRST = -5;
    private static final double NEGATIVE_SECOND = -7.5;
    private static final double ZERO = 0;

    private Calculator calculator;
    private double result;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void unexpectedSign() {
        calculator.calculate(POSITIVE_FIRST, '#', NEGATIVE_SECOND);
    }

    @Test
    public void additionTestPositivePositive() {
        result = calculator.calculate(POSITIVE_FIRST, '+', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST + POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void additionTestPositiveNegative() {
        result = calculator.calculate(POSITIVE_FIRST, '+', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST + NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void additionTestNegativeNegative() {
        result = calculator.calculate(NEGATIVE_FIRST, '+', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST + NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void additionTestNegativeZero() {
        result = calculator.calculate(NEGATIVE_SECOND, '+', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND + ZERO, result, DELTA);
    }

    @Test
    public void additionTestPositiveZero() {
        result = calculator.calculate(POSITIVE_FIRST, '+', ZERO);
        Assert.assertEquals(POSITIVE_FIRST + ZERO, result, DELTA);
    }

    @Test
    public void subtractionTestPositivePositive() {
        result = calculator.calculate(POSITIVE_FIRST, '-', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST - POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void subtractionTestPositiveNegative() {
        result = calculator.calculate(POSITIVE_FIRST, '-', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST - NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void subtractionTestNegativeNegative() {
        result = calculator.calculate(NEGATIVE_FIRST, '-', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST - NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void subtractionTestNegativeZero() {
        result = calculator.calculate(NEGATIVE_SECOND, '-', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND - ZERO, result, DELTA);
    }

    @Test
    public void subtractionTestPositiveZero() {
        result = calculator.calculate(POSITIVE_FIRST, '-', ZERO);
        Assert.assertEquals(POSITIVE_FIRST - ZERO, result, DELTA);
    }

    @Test
    public void multiplyingTestPositivePositive() {
        result = calculator.calculate(POSITIVE_FIRST, '*', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST * POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void multiplyingTestPositiveNegative() {
        result = calculator.calculate(POSITIVE_FIRST, '*', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST * NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void multiplyingTestNegativeNegative() {
        result = calculator.calculate(NEGATIVE_FIRST, '*', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST * NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void multiplyingTestNegativeZero() {
        result = calculator.calculate(NEGATIVE_SECOND, '*', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND * ZERO, result, DELTA);
    }

    @Test
    public void multiplyingTestPositiveZero() {
        result = calculator.calculate(POSITIVE_FIRST, '*', ZERO);
        Assert.assertEquals(POSITIVE_FIRST * ZERO, result, DELTA);
    }

    @Test
    public void toDegreeTestPositivePositive() {
        result = calculator.calculate(POSITIVE_FIRST, '^', POSITIVE_SECOND);
        Assert.assertEquals(Math.pow(POSITIVE_FIRST, POSITIVE_SECOND), result, DELTA);
    }

    @Test
    public void toDegreeTestPositiveNegative() {
        result = calculator.calculate(POSITIVE_FIRST, '^', NEGATIVE_FIRST);
        Assert.assertEquals(Math.pow(POSITIVE_FIRST, NEGATIVE_FIRST), result, DELTA);
    }

    @Test
    public void toDegreeTestNegativeNegative() {
        result = calculator.calculate(NEGATIVE_FIRST, '^', NEGATIVE_SECOND);
        Assert.assertEquals(Math.pow(NEGATIVE_FIRST, NEGATIVE_SECOND), result, DELTA);
    }

    @Test
    public void toDegreeTestNegativeZero() {
        result = calculator.calculate(NEGATIVE_SECOND, '^', ZERO);
        Assert.assertEquals(Math.pow(NEGATIVE_SECOND, ZERO), result, DELTA);
    }

    @Test
    public void toDegreeTestPositiveZero() {
        result = calculator.calculate(POSITIVE_SECOND, '^', ZERO);
        Assert.assertEquals(Math.pow(POSITIVE_SECOND, ZERO), result, DELTA);
    }

    @Test
    public void divisionTestPositivePositive() {
        result = calculator.calculate(POSITIVE_FIRST, '/', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST / POSITIVE_SECOND, result, DELTA);
    }

    @Test
    public void divisionTestPositiveNegative() {
        result = calculator.calculate(POSITIVE_FIRST, '/', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST / NEGATIVE_FIRST, result, DELTA);
    }

    @Test
    public void divisionTestNegativeNegative() {
        result = calculator.calculate(NEGATIVE_FIRST, '/', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST / NEGATIVE_SECOND, result, DELTA);
    }

    @Test
    public void divisionTestZeroNegative() {
        result = calculator.calculate(ZERO, '/', NEGATIVE_SECOND);
        Assert.assertEquals(ZERO / NEGATIVE_SECOND, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        result = calculator.calculate(NEGATIVE_FIRST, '/', ZERO);
    }
}
