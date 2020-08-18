package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double ZERO = 0;
    private static final double POSITIVE_X = 2;
    private static final double POSITIVE_Y = 3;
    private static final double NEGATIVE_X = -2;
    private static final double NEGATIVE_Y = -3;
    private static final double DELTA = 0.0000001;

    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperationCharacterTest() {
        calculator.calculate(POSITIVE_X, POSITIVE_Y, 'h');
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        calculator.calculate(POSITIVE_X, ZERO, '/');
    }

    @Test
    public void additionTest() {
        double result = calculator.calculate(POSITIVE_X, POSITIVE_Y, '+');
        Assert.assertEquals(5, result, DELTA);
        result = calculator.calculate(POSITIVE_X, NEGATIVE_X, '+');
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '+');
        Assert.assertEquals(-5, result, DELTA);
        result = calculator.calculate(POSITIVE_X, ZERO, '+');
        Assert.assertEquals(POSITIVE_X, result, DELTA);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.calculate(POSITIVE_X, POSITIVE_Y, '-');
        Assert.assertEquals(-1, result, DELTA);
        result = calculator.calculate(POSITIVE_X, NEGATIVE_X, '-');
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '-');
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(POSITIVE_X, ZERO, '-');
        Assert.assertEquals(POSITIVE_X, result, DELTA);
    }

    @Test
    public void multiplicationTest() {
        double result = calculator.calculate(POSITIVE_X, POSITIVE_Y, '*');
        Assert.assertEquals(6, result, DELTA);
        result = calculator.calculate(POSITIVE_X, NEGATIVE_X, '*');
        Assert.assertEquals(-4, result, DELTA);
        result = calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '*');
        Assert.assertEquals(6, result, DELTA);
        result = calculator.calculate(POSITIVE_X, ZERO, '*');
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void divisionTest() {
        double result = calculator.calculate(POSITIVE_Y, POSITIVE_Y, '^');
        Assert.assertEquals(27, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_X, '^');
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(POSITIVE_X, ZERO, '^');
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void powerTest() {
        double result = calculator.calculate(POSITIVE_Y, POSITIVE_X, '/');
        Assert.assertEquals(1.5, result, DELTA);
        result = calculator.calculate(POSITIVE_X, NEGATIVE_X, '/');
        Assert.assertEquals(-1, result, DELTA);
        result = calculator.calculate(NEGATIVE_Y, NEGATIVE_X, '/');
        Assert.assertEquals(1.5, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_X, '/');
        Assert.assertEquals(ZERO, result, DELTA);
    }
}