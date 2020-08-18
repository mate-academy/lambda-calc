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
    public void additionTest() {
        result = calculator.calculate(POSITIVE_FIRST, '+', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST + POSITIVE_SECOND, result, DELTA);
        result = calculator.calculate(POSITIVE_FIRST, '+', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST + NEGATIVE_FIRST, result, DELTA);
        result = calculator.calculate(NEGATIVE_FIRST, '+', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST + NEGATIVE_SECOND, result, DELTA);
        result = calculator.calculate(NEGATIVE_SECOND, '+', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND + ZERO, result, DELTA);

    }

    @Test
    public void subtractionTest() {
        result = calculator.calculate(POSITIVE_FIRST, '-', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST - POSITIVE_SECOND, result, DELTA);
        result = calculator.calculate(POSITIVE_FIRST, '-', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST - NEGATIVE_FIRST, result, DELTA);
        result = calculator.calculate(NEGATIVE_FIRST, '-', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST - NEGATIVE_SECOND, result, DELTA);
        result = calculator.calculate(NEGATIVE_SECOND, '-', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND - ZERO, result, DELTA);
    }

    @Test
    public void multiplyingTest() {
        result = calculator.calculate(POSITIVE_FIRST, '*', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST * POSITIVE_SECOND, result, DELTA);
        result = calculator.calculate(POSITIVE_FIRST, '*', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST * NEGATIVE_FIRST, result, DELTA);
        result = calculator.calculate(NEGATIVE_FIRST, '*', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST * NEGATIVE_SECOND, result, DELTA);
        result = calculator.calculate(NEGATIVE_SECOND, '*', ZERO);
        Assert.assertEquals(NEGATIVE_SECOND * ZERO, result, DELTA);
    }

    @Test
    public void toDegreeTest() {
        result = calculator.calculate(POSITIVE_FIRST, '^', POSITIVE_SECOND);
        Assert.assertEquals(Math.pow(POSITIVE_FIRST, POSITIVE_SECOND), result, DELTA);
        result = calculator.calculate(POSITIVE_FIRST, '^', NEGATIVE_FIRST);
        Assert.assertEquals(Math.pow(POSITIVE_FIRST, NEGATIVE_FIRST), result, DELTA);
        result = calculator.calculate(NEGATIVE_FIRST, '^', NEGATIVE_SECOND);
        Assert.assertEquals(Math.pow(NEGATIVE_FIRST, NEGATIVE_SECOND), result, DELTA);
        result = calculator.calculate(NEGATIVE_SECOND, '^', ZERO);
        Assert.assertEquals(Math.pow(NEGATIVE_SECOND, ZERO), result, DELTA);
    }

    @Test
    public void divisionTest() {
        result = calculator.calculate(POSITIVE_FIRST, '/', POSITIVE_SECOND);
        Assert.assertEquals(POSITIVE_FIRST / POSITIVE_SECOND, result, DELTA);
        result = calculator.calculate(POSITIVE_FIRST, '/', NEGATIVE_FIRST);
        Assert.assertEquals(POSITIVE_FIRST / NEGATIVE_FIRST, result, DELTA);
        result = calculator.calculate(NEGATIVE_FIRST, '/', NEGATIVE_SECOND);
        Assert.assertEquals(NEGATIVE_FIRST / NEGATIVE_SECOND, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        result = calculator.calculate(NEGATIVE_FIRST, '/', ZERO);
    }
}
