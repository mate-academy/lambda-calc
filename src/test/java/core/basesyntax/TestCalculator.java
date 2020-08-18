package core.basesyntax;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class TestCalculator {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final double ZERO = 0;
    private static final double POSITIVE_OPERAND = 11;
    private static final double NEGATIVE_OPERAND = -2;
    private static final double DELTA = 1e-10;
    private static final char INVALID_OPERATION_SIGN = '{';
    private static Calculator calculator;
    private double result;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnacceptableOperation() {
        calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, INVALID_OPERATION_SIGN);
    }

    @Test
    public void additionTestOK() {
        result = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, PLUS);
        Assert.assertEquals(22, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, PLUS);
        Assert.assertEquals(-4, result, DELTA);
        result = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, PLUS);
        Assert.assertEquals(9, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_OPERAND, PLUS);
        Assert.assertEquals(POSITIVE_OPERAND, result, DELTA);
        result = calculator.calculate(ZERO, NEGATIVE_OPERAND, PLUS);
        Assert.assertEquals(NEGATIVE_OPERAND, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, PLUS);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void subtractionTest() {
        result = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, MINUS);
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, MINUS);
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, MINUS);
        Assert.assertEquals(13, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, POSITIVE_OPERAND, MINUS);
        Assert.assertEquals(-13, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_OPERAND, MINUS);
        Assert.assertEquals(-POSITIVE_OPERAND, result, DELTA);
        result = calculator.calculate(ZERO, NEGATIVE_OPERAND, MINUS);
        Assert.assertEquals(-NEGATIVE_OPERAND, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, MINUS);
        Assert.assertEquals(ZERO, result, DELTA);
    }


    @Test
    public void multiplicationTest() {
        result = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, MULTIPLICATION);
        Assert.assertEquals(121, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, MULTIPLICATION);
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, MULTIPLICATION);
        Assert.assertEquals(-22, result, DELTA);
        result = calculator.calculate(POSITIVE_OPERAND, ZERO, MULTIPLICATION);
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, ZERO, MULTIPLICATION);
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, MULTIPLICATION);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test
    public void divisionWithValidOperandsTest() {
        result = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, DIVISION);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, DIVISION);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, DIVISION);
        Assert.assertEquals(-5.5, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, POSITIVE_OPERAND, DIVISION);
        Assert.assertEquals(-0.18181818181818182, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_OPERAND, DIVISION);
        Assert.assertEquals(ZERO, result, DELTA);
        result = calculator.calculate(ZERO, NEGATIVE_OPERAND, DIVISION);
        Assert.assertEquals(ZERO, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(POSITIVE_OPERAND, ZERO, DIVISION);
    }

    @Test
    public void raisingToPowerTest() {
        result = calculator.calculate(POSITIVE_OPERAND, POSITIVE_OPERAND, POWER);
        Assert.assertEquals(2.85311670611E11, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, NEGATIVE_OPERAND, POWER);
        Assert.assertEquals(0.25, result, DELTA);
        result = calculator.calculate(POSITIVE_OPERAND, NEGATIVE_OPERAND, POWER);
        Assert.assertEquals(0.008264462809917356, result, DELTA);
        result = calculator.calculate(POSITIVE_OPERAND, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(NEGATIVE_OPERAND, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(ZERO, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(ZERO, POSITIVE_OPERAND, POWER);
        Assert.assertEquals(ZERO, result, DELTA);
    }
}
