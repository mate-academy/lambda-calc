package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-10;
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

    @Test(expected = IllegalArgumentException.class)
    public void testUnacceptableOperation() {
        calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, RANDOM_OPERATION);
    }

    @Test
    public void additionBothZero() {
        result = calculator.calculate(ZERO, ZERO, PLUS);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void additionBothPositive() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, PLUS);
        Assert.assertEquals(8, result, DELTA);
    }

    @Test
    public void additionBothNegative() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_NEGATIVE, PLUS);
        Assert.assertEquals(-8, result, DELTA);
    }

    @Test
    public void additionNegativeAndPositive() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, PLUS);
        Assert.assertEquals(2, result, DELTA);
    }

    @Test
    public void additionOneZero() {
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, PLUS);
        Assert.assertEquals(VALUE2_POSITIVE, result, DELTA);
    }

    @Test
    public void subtractionBothZero() {
        result = calculator.calculate(ZERO, ZERO, MINUS);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void subtractZero() {
        result = calculator.calculate(VALUE1_POSITIVE, ZERO, MINUS);
        Assert.assertEquals(VALUE1_POSITIVE, result, DELTA);
    }

    @Test
    public void subtractFromZero() {
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, MINUS);
        Assert.assertEquals(VALUE2_NEGATIVE, result, DELTA);
    }

    @Test
    public void subtractNegativeFromPositive() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_NEGATIVE, MINUS);
        Assert.assertEquals(8, result, DELTA);
    }

    @Test
    public void subtractionFromNegative() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, MINUS);
        Assert.assertEquals(-8, result, DELTA);
    }

    @Test
    public void subtractionBothPositive() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, MINUS);
        Assert.assertEquals(-2, result, DELTA);
    }

    @Test
    public void multiplyBothPositive() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, MULTIPLY);
        Assert.assertEquals(15, result, DELTA);
    }

    @Test
    public void multiplyBothNegative() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_NEGATIVE, MULTIPLY);
        Assert.assertEquals(15, result, DELTA);
    }

    @Test
    public void multiplyNegativeAndPositive() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, MULTIPLY);
        Assert.assertEquals(-15, result, DELTA);
    }

    @Test
    public void multiplyByZero() {
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, MULTIPLY);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void multiplyBothZero() {
        result = calculator.calculate(ZERO, ZERO, MULTIPLY);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void divideBothPositive() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, DIVIDE);
        Assert.assertEquals(0.6, result, DELTA);
    }

    @Test
    public void divideBothNegative() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_NEGATIVE, DIVIDE);
        Assert.assertEquals(0.6, result, DELTA);
    }

    @Test
    public void divideNegativeAndPositive() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, DIVIDE);
        Assert.assertEquals(-0.6, result, DELTA);
    }

    @Test
    public void divideZero() {
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
    public void powerBothPositive() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_POSITIVE, POWER);
        Assert.assertEquals(243, result, DELTA);
    }

    @Test
    public void powerPositiveBaseNegativePower() {
        result = calculator.calculate(VALUE1_POSITIVE, VALUE2_NEGATIVE, POWER);
        Assert.assertEquals(0.00411522633744856, result, DELTA);
    }

    @Test
    public void powerNegativeBasePositivePower() {
        result = calculator.calculate(VALUE1_NEGATIVE, VALUE2_POSITIVE, POWER);
        Assert.assertEquals(-243, result, DELTA);
    }

    @Test
    public void powerZeroBase() {
        result = calculator.calculate(ZERO, VALUE2_POSITIVE, POWER);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void raisingToPowerZero() {
        result = calculator.calculate(VALUE1_POSITIVE, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void raisingToPowerBothZero() {
        result = calculator.calculate(ZERO, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
    }
}
