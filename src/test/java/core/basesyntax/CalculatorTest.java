package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-10;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final double POSITIVE_VALUE1 = 4;
    private static final double POSITIVE_VALUE2 = 2;
    private static final double NEGATIVE_VALUE1 = -2;
    private static final double NEGATIVE_VALUE2 = -4;
    private static final double POSITIVE_FRACTION1 = 2.5;
    private static final double POSITIVE_FRACTION2 = 1.5;
    private static final double FRACTION_LESS_THAN_1 = 0.9;
    private static final double NEGATIVE_FRACTION1 = -2.5;
    private static final double NEGATIVE_FRACTION2 = -1.5;
    private static final double ZERO = 0;
    private static double result;
    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalOperation() {
        calculator.calculator(POSITIVE_VALUE1, POSITIVE_VALUE2, '!');
    }

    @Test
    public void positiveAddition() {
        result = calculator.calculator(POSITIVE_VALUE1, POSITIVE_VALUE2, ADDITION);
        Assert.assertEquals(6, result, DELTA);
    }

    @Test
    public void negativeAddition() {
        result = calculator.calculator(NEGATIVE_VALUE1, NEGATIVE_VALUE2, ADDITION);
        Assert.assertEquals(-6, result, DELTA);
    }

    @Test
    public void oneNegativeAddition() {
        result = calculator.calculator(NEGATIVE_VALUE1, POSITIVE_VALUE2, ADDITION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void positiveFractionAddition() {
        result = calculator.calculator(POSITIVE_FRACTION1, POSITIVE_FRACTION2, ADDITION);
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void negativeFractionAddition() {
        result = calculator.calculator(NEGATIVE_FRACTION1, NEGATIVE_FRACTION2, ADDITION);
        Assert.assertEquals(-4, result, DELTA);
    }

    @Test
    public void oneNegativeFractionAddition() {
        result = calculator.calculator(NEGATIVE_FRACTION1, POSITIVE_FRACTION2, ADDITION);
        Assert.assertEquals(-1, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityPositiveValuesAddition() {
        calculator.calculator(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityNegativeValuesAddition() {
        calculator.calculator(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
    }

    @Test
    public void positiveSubtraction() {
        result = calculator.calculator(POSITIVE_VALUE1, POSITIVE_VALUE2, SUBTRACTION);
        Assert.assertEquals(2, result, DELTA);
    }

    @Test
    public void negativeSubtraction() {
        result = calculator.calculator(NEGATIVE_VALUE1, NEGATIVE_VALUE2, SUBTRACTION);
        Assert.assertEquals(2, result, DELTA);
    }

    @Test
    public void oneNegativeSubtraction() {
        result = calculator.calculator(NEGATIVE_VALUE1, POSITIVE_VALUE2, SUBTRACTION);
        Assert.assertEquals(-4, result, DELTA);
    }

    @Test
    public void positiveFractionSubtraction() {
        result = calculator.calculator(POSITIVE_FRACTION1, POSITIVE_FRACTION2, SUBTRACTION);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void negativeFractionSubtraction() {
        result = calculator.calculator(NEGATIVE_FRACTION1, NEGATIVE_FRACTION2, SUBTRACTION);
        Assert.assertEquals(-1, result, DELTA);
    }

    @Test
    public void oneNegativeFractionSubtraction() {
        result = calculator.calculator(NEGATIVE_FRACTION1, POSITIVE_FRACTION2, SUBTRACTION);
        Assert.assertEquals(-4, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityFirstPositiveValueSubtraction() {
        calculator.calculator(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinitySecondPositiveValueSubtraction() {
        calculator.calculator(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
    }

    @Test
    public void positiveDivision() {
        result = calculator.calculator(POSITIVE_VALUE1, POSITIVE_VALUE2, DIVISION);
        Assert.assertEquals(2, result, DELTA);
    }

    @Test
    public void negativeDivision() {
        result = calculator.calculator(NEGATIVE_VALUE1, NEGATIVE_VALUE2, DIVISION);
        Assert.assertEquals(0.5, result, DELTA);
    }

    @Test
    public void oneNegativeDivision() {
        result = calculator.calculator(NEGATIVE_VALUE1, POSITIVE_VALUE2, DIVISION);
        Assert.assertEquals(-1, result, DELTA);
    }

    @Test
    public void positiveFractionDivision() {
        result = calculator.calculator(POSITIVE_FRACTION1, POSITIVE_VALUE2, DIVISION);
        Assert.assertEquals(1.25, result, DELTA);
    }

    @Test
    public void negativeFractionDivision() {
        result = calculator.calculator(NEGATIVE_FRACTION1, NEGATIVE_VALUE2, DIVISION);
        Assert.assertEquals(0.625, result, DELTA);
    }

    @Test
    public void oneNegativeFractionDivision() {
        result = calculator.calculator(NEGATIVE_FRACTION1, POSITIVE_VALUE2, DIVISION);
        Assert.assertEquals(-1.25, result, DELTA);
    }


    @Test
    public void zeroDevided() {
        result = calculator.calculator(ZERO, POSITIVE_VALUE2, DIVISION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void arithmeticException() {
        calculator.calculator(POSITIVE_VALUE1, ZERO, DIVISION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityBothPositiveDivision() {
        calculator.calculator(Double.MAX_VALUE, FRACTION_LESS_THAN_1, DIVISION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityBothNegativeDivision() {
        calculator.calculator(-Double.MAX_VALUE, -FRACTION_LESS_THAN_1, DIVISION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityFirstPositiveDivision() {
        calculator.calculator(Double.MAX_VALUE, -FRACTION_LESS_THAN_1, DIVISION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinitySecondPositiveDivision() {
        calculator.calculator(-Double.MAX_VALUE, FRACTION_LESS_THAN_1, DIVISION);
    }

    @Test
    public void positiveMultiplication() {
        result = calculator.calculator(POSITIVE_VALUE1, POSITIVE_VALUE2, MULTIPLICATION);
        Assert.assertEquals(8, result, DELTA);
    }

    @Test
    public void negativeMultiplication() {
        result = calculator.calculator(NEGATIVE_VALUE1, NEGATIVE_VALUE2, MULTIPLICATION);
        Assert.assertEquals(8, result, DELTA);
    }

    @Test
    public void oneNegativeMultiplication() {
        result = calculator.calculator(NEGATIVE_VALUE1, POSITIVE_VALUE2, MULTIPLICATION);
        Assert.assertEquals(-4, result, DELTA);
    }

    @Test
    public void positiveFractionMultiplication() {
        result = calculator.calculator(POSITIVE_FRACTION1, POSITIVE_VALUE2, MULTIPLICATION);
        Assert.assertEquals(5, result, DELTA);
    }

    @Test
    public void negativeFractionMultiplication() {
        result = calculator.calculator(NEGATIVE_FRACTION1, NEGATIVE_VALUE2, MULTIPLICATION);
        Assert.assertEquals(10, result, DELTA);
    }

    @Test
    public void oneNegativeFractionMultiplication() {
        result = calculator.calculator(NEGATIVE_FRACTION1, POSITIVE_VALUE2, MULTIPLICATION);
        Assert.assertEquals(-5, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityBothPositiveValuesMultiplication() {
        calculator.calculator(Double.MAX_VALUE, POSITIVE_VALUE2, MULTIPLICATION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityOneNegativeValuesMultiplication() {
        calculator.calculator(Double.MAX_VALUE, NEGATIVE_VALUE2, MULTIPLICATION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityOneNegativeSwapValuesMultiplication() {
        calculator.calculator(POSITIVE_VALUE1, -Double.MAX_VALUE, MULTIPLICATION);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityBothNegativeValuesMultiplication() {
        calculator.calculator(-Double.MAX_VALUE, NEGATIVE_VALUE2, MULTIPLICATION);
    }

    @Test
    public void zeroMultiplication() {
        result = calculator.calculator(ZERO, POSITIVE_VALUE2, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void positivePower() {
        result = calculator.calculator(POSITIVE_VALUE1, POSITIVE_VALUE2, POWER);
        Assert.assertEquals(16, result, DELTA);
    }

    @Test
    public void negativePower() {
        result = calculator.calculator(NEGATIVE_VALUE1, NEGATIVE_VALUE2, POWER);
        Assert.assertEquals(0.0625, result, DELTA);
    }

    @Test
    public void oneNegativePower() {
        result = calculator.calculator(NEGATIVE_VALUE1, POSITIVE_VALUE2, POWER);
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void positiveFractionPower() {
        result = calculator.calculator(POSITIVE_FRACTION1, POSITIVE_VALUE2, POWER);
        Assert.assertEquals(6.25, result, DELTA);
    }

    @Test
    public void negativeFractionPower() {
        result = calculator.calculator(NEGATIVE_FRACTION1, NEGATIVE_VALUE2, POWER);
        Assert.assertEquals(0.0256, result, DELTA);
    }

    @Test
    public void oneNegativeFractionPower() {
        result = calculator.calculator(NEGATIVE_FRACTION1, POSITIVE_VALUE2, POWER);
        Assert.assertEquals(6.25, result, DELTA);
    }

    @Test
    public void zeroPower() {
        result = calculator.calculator(ZERO, POSITIVE_VALUE2, POWER);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void powByZero() {
        result = calculator.calculator(POSITIVE_VALUE1, ZERO, POWER);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityBothPositivePower() {
        calculator.calculator(Double.MAX_VALUE, POSITIVE_VALUE2, POWER);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityBothPositiveSwapPower() {
        calculator.calculator(POSITIVE_VALUE1, Double.MAX_VALUE, POWER);
    }

    @Test(expected = ArithmeticException.class)
    public void isInfinityFirstNegativeSwapPower() {
        calculator.calculator(NEGATIVE_VALUE1, Double.MAX_VALUE, POWER);
    }
}
