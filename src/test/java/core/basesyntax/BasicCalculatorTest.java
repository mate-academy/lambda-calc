package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicCalculatorTest {
    private static final double ZERO = 0;
    private static final double ONE = 1;
    private static final double NEGATIVE_BIG = -1000;
    private static final double POSITIVE_BIG = 1000;
    private static final double NEGATIVE = -2;
    private static final double POSITIVE = 10;
    private static final char MULTI = '*';
    private static final char DIV = '/';
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char POW = '^';
    private static final char NOT_MATH = '&';
    private static final double DIFF = 1e-15;
    private static BasicCalculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new BasicCalculator();
    }


    @Test
    public void multiplicationWithZero() throws CalcException {
        double zeroResult = calculator.calculus(POSITIVE, ZERO, MULTI);
        Assert.assertEquals(0, zeroResult, DIFF);
    }

    @Test
    public void multiplicationPositiveWithNegative() throws CalcException {
        double negativeResult = calculator.calculus(NEGATIVE, POSITIVE, MULTI);
        Assert.assertTrue(negativeResult < 0);
    }

    @Test
    public void multiplicationNegativeWithNegative() throws CalcException {
        double negNegResult = calculator.calculus(NEGATIVE, NEGATIVE_BIG, MULTI);
        Assert.assertFalse(negNegResult < 0);
    }

    @Test
    public void multiplicationMaxValue() throws CalcException {
        double infiniteResult = calculator.calculus(Double.MAX_VALUE, POSITIVE_BIG, MULTI);
        Assert.assertTrue(infiniteResult > Double.MAX_VALUE);
    }

    @Test
    public void negativeSubtraction() throws CalcException {
        double negativeSubtract = calculator.calculus(NEGATIVE_BIG, POSITIVE, SUBTRACT);
        Assert.assertEquals(NEGATIVE_BIG - POSITIVE, negativeSubtract, DIFF);
        negativeSubtract = calculator.calculus(POSITIVE, POSITIVE_BIG, SUBTRACT);
        Assert.assertTrue(negativeSubtract < 0);
        negativeSubtract = calculator.calculus(NEGATIVE_BIG, NEGATIVE, SUBTRACT);
        Assert.assertTrue(negativeSubtract < 0);
        negativeSubtract = calculator.calculus(NEGATIVE, POSITIVE_BIG, SUBTRACT);
        Assert.assertTrue(negativeSubtract < 0);
    }

    @Test
    public void subtractItself() throws CalcException {
        double zeroResult = calculator.calculus(NEGATIVE_BIG, NEGATIVE_BIG, SUBTRACT);
        Assert.assertEquals(ZERO, zeroResult, DIFF);
        zeroResult = calculator.calculus(POSITIVE, POSITIVE, SUBTRACT);
        Assert.assertEquals(ZERO, zeroResult, DIFF);
    }

    @Test
    public void positiveSubtraction() throws CalcException {
        double positiveSubtract = calculator.calculus(NEGATIVE, NEGATIVE_BIG, SUBTRACT);
        Assert.assertTrue(positiveSubtract > 0);
        positiveSubtract = calculator.calculus(POSITIVE_BIG, POSITIVE, SUBTRACT);
        Assert.assertEquals(POSITIVE_BIG - POSITIVE, positiveSubtract, DIFF);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() throws CalcException {
        int zeroDivision = (int) (calculator.calculus(POSITIVE, ZERO, DIV));
//            Assert.assertEquals("Can't divide by zero", ArithmeticException.getMessage());
    }

    @Test
    public void divisionWithSignChange() throws CalcException {
        double result = calculator.calculus(NEGATIVE, POSITIVE, DIV);
        Assert.assertEquals(NEGATIVE / POSITIVE, result, DIFF);
        result = calculator.calculus(NEGATIVE_BIG, NEGATIVE, DIV);
        Assert.assertEquals(NEGATIVE_BIG / NEGATIVE, result, DIFF);
        result = calculator.calculus(POSITIVE_BIG, NEGATIVE, DIV);
        Assert.assertEquals(POSITIVE_BIG / NEGATIVE, result, DIFF);
    }

    @Test
    public void divisionByBigValue() throws CalcException {
        double result = calculator.calculus(NEGATIVE, NEGATIVE_BIG, DIV);
        Assert.assertEquals(NEGATIVE / NEGATIVE_BIG, result, DIFF);
        result = calculator.calculus(POSITIVE, POSITIVE_BIG, DIV);
        Assert.assertEquals(POSITIVE / POSITIVE_BIG, result, DIFF);
    }

    @Test
    public void divisionOfZeroByNumber() throws CalcException {
        double result = calculator.calculus(ZERO, NEGATIVE_BIG, DIV);
        Assert.assertEquals(ZERO, result, DIFF);
        result = calculator.calculus(ZERO, POSITIVE, DIV);
        Assert.assertEquals(ZERO, result, DIFF);
    }

    @Test
    public void addingZero() throws CalcException {
        double unChangedResult = calculator.calculus(NEGATIVE, ZERO, ADD);
        Assert.assertEquals(NEGATIVE, unChangedResult, DIFF);
        unChangedResult = calculator.calculus(POSITIVE_BIG, ZERO, ADD);
        Assert.assertEquals(POSITIVE_BIG, unChangedResult, DIFF);
    }

    @Test
    public void powerOfZero() throws CalcException {
        double powerOfZero = calculator.calculus(POSITIVE, ZERO, POW);
        Assert.assertEquals(ONE, powerOfZero, DIFF);
        powerOfZero = calculator.calculus(NEGATIVE_BIG, ZERO, POW);
        Assert.assertEquals(ONE, powerOfZero, DIFF);
    }

    @Test
    public void powerOfOne() throws CalcException {
        double powerOfOne = calculator.calculus(POSITIVE, ONE, POW);
        Assert.assertEquals(POSITIVE, powerOfOne, DIFF);
        powerOfOne = calculator.calculus(NEGATIVE_BIG, ONE, POW);
        Assert.assertEquals(NEGATIVE_BIG, powerOfOne, DIFF);
    }

    @Test
    public void powerOfNegative() throws CalcException {
        double powerOfNegative = calculator.calculus(POSITIVE, NEGATIVE, POW);
        Assert.assertEquals(1 / (POSITIVE * POSITIVE), powerOfNegative, DIFF);
        powerOfNegative = calculator.calculus(NEGATIVE, (-ONE), POW);
        Assert.assertEquals(1 / NEGATIVE, powerOfNegative, DIFF);
    }

    @Test(expected = CalcException.class)
    public void wrongOperand() throws CalcException {
        double noCalc = calculator.calculus(POSITIVE, NEGATIVE, NOT_MATH);
    }
}
