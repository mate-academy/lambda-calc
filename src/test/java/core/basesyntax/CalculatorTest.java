package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.01;
    private static final char RANDOM_OPERATION = 'g';
    private static final double VALUE1_NEGATIVE = -3;
    private static final double VALUE1_POSITIVE = 3;
    private static final double VALUE2_NEGATIVE = -5;
    private static final double VALUE2_POSITIVE = 5;
    private static final double ZERO = 0;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POWER = '^';
    private static Calculator calculator;
    private double result;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = RuntimeException.class)
    public void testUnacceptableOperation() {
        calculator.calculate(6, 1, RANDOM_OPERATION);
    }

    @Test
    public void additionTest() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, PLUS);
        Assert.assertEquals(8, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_NEGATIVE, PLUS);
        Assert.assertEquals(-8, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, PLUS);
        Assert.assertEquals(2, result, DELTA);
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, PLUS);
        Assert.assertEquals(VALUE2_POSITIVE, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, PLUS);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void subtractionTest() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, MINUS);
        Assert.assertEquals(-2, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, MINUS);
        Assert.assertEquals(-8, result, DELTA);
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_NEGATIVE, MINUS);
        Assert.assertEquals(8, result, DELTA);
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, MINUS);
        Assert.assertEquals(VALUE2_NEGATIVE, result, DELTA);
        result = calculator.calculate(VALUE1_POSITIVE, ZERO, MINUS);
        Assert.assertEquals(VALUE1_POSITIVE, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, MINUS);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void multiplicationTest() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, MULTIPLY);
        Assert.assertEquals(15, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_NEGATIVE, MULTIPLY);
        Assert.assertEquals(15, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, MULTIPLY);
        Assert.assertEquals(-15, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, MULTIPLY);
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, MULTIPLY);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void divisionTest() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, DIVIDE);
        Assert.assertEquals(0.6, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, DIVIDE);
        Assert.assertEquals(-0.6, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_NEGATIVE, DIVIDE);
        Assert.assertEquals(0.6, result, DELTA);
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, DIVIDE);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(VALUE1_POSITIVE, ZERO, DIVIDE);
    }

    @Test(expected = ArithmeticException.class)
    public void bothAreZeroDivision() {
        calculator.calculate(ZERO, ZERO, DIVIDE);
    }

    @Test
    public void raisingToPowerTest() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, POWER);
        Assert.assertEquals(243, result, DELTA);
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_NEGATIVE, POWER);
        Assert.assertEquals(0.004115, result, DELTA);
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, POWER);
        Assert.assertEquals(-243, result, DELTA);
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, POWER);
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(VALUE1_POSITIVE, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
    }
}
