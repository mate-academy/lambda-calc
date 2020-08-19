package core.basesyntax;

import core.basesyntax.exception.DividingByZeroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;
    public static final double ZERO = 0;
    public static final double POSITIVE_NUMBER_1 = 20;
    public static final double POSITIVE_NUMBER_2 = 40;
    public static final double NEGATIVE_NUMBER_1 = -20;
    public static final double NEGATIVE_NUMBER_2 = -40;
    public static final double POSITIVE_NUMBER_EXTREME_BIG_1 = 324334;
    public static final double POSITIVE_NUMBER_EXTREME_BIG_2 = 234234;
    public static final double NEGATIVE_NUMBER_EXTREME_BIG_1 = -324334;
    public static final double NEGATIVE_NUMBER_EXTREME_BIG_2 = -234234;
    public static final double POSITIVE_NUMBER_EXTREME_SMALL_1 = 0.00000000000374;
    public static final double POSITIVE_NUMBER_EXTREME_SMALL_2 = 0.0000000002323;
    public static final double NEGATIVE_NUMBER_EXTREME_SMALL_1 = -0.00000000000374;
    public static final double NEGATIVE_NUMBER_EXTREME_SMALL_2 = -0.0000000002323;
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char DIVIDE = '/';
    public static final char MULTIPLY = '*';
    public static final char POWER = '^';
    public static final double DELTA = 0;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test (expected = IllegalArgumentException.class)
    public void IllegalActionTest() {
        calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '&');
    }

    @Test
    public void AdditionTestPositive() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", 60, firstResult, DELTA);
    }

    @Test
    public void AdditionTestNegative() {
        double firstResult = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", -60, firstResult, DELTA);
    }

    @Test
    public void AdditionTestWithZero() {
        double firstResult = calculator.calculate(ZERO, POSITIVE_NUMBER_2, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", 40, firstResult, DELTA);
    }

    @Test
    public void AdditionTestWithZeroResult() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_1, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", 0, firstResult, DELTA);
    }

    @Test
    public void AdditionWithExtremeBigValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_BIG_1, POSITIVE_NUMBER_EXTREME_BIG_2, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", 558568, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_BIG_1, NEGATIVE_NUMBER_EXTREME_BIG_2, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", -558568, secondResult, DELTA);
    }

    @Test
    public void AdditionWithExtremeSmallValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_SMALL_1, POSITIVE_NUMBER_EXTREME_SMALL_2, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", POSITIVE_NUMBER_EXTREME_SMALL_1 + POSITIVE_NUMBER_EXTREME_SMALL_2, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_SMALL_1, NEGATIVE_NUMBER_EXTREME_SMALL_2, PLUS);
        Assert.assertEquals("Wrong addition algorithm!", NEGATIVE_NUMBER_EXTREME_SMALL_1 + NEGATIVE_NUMBER_EXTREME_SMALL_2, secondResult, DELTA);
    }

    @Test
    public void SubtractionTestPositive() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_2, POSITIVE_NUMBER_1, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", 20, firstResult, DELTA);
        double secondResult = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", -20, secondResult, DELTA);
    }

    @Test
    public void SubtractionTestNegative() {
        double firstResult = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", 20, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_2, NEGATIVE_NUMBER_1, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", -20, secondResult, DELTA);
    }

    @Test
    public void SubtractionTestWithZero() {
        double firstResult = calculator.calculate(ZERO, POSITIVE_NUMBER_1, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", -20, firstResult, DELTA);
    }

    @Test
    public void SubtractionTestWithZeroResult() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_2, POSITIVE_NUMBER_2, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", 0, firstResult, DELTA);
    }

    @Test
    public void SubtractionWithExtremeBigValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_BIG_1, POSITIVE_NUMBER_EXTREME_BIG_2, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", 90100, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_BIG_1, NEGATIVE_NUMBER_EXTREME_BIG_2, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", -90100, secondResult, DELTA);
    }

    @Test
    public void SubtractionWithExtremeSmallValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_SMALL_1, POSITIVE_NUMBER_EXTREME_SMALL_2, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", POSITIVE_NUMBER_EXTREME_SMALL_1 - POSITIVE_NUMBER_EXTREME_SMALL_2, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_SMALL_1, NEGATIVE_NUMBER_EXTREME_SMALL_2, MINUS);
        Assert.assertEquals("Wrong subtraction algorithm!", NEGATIVE_NUMBER_EXTREME_SMALL_1 - NEGATIVE_NUMBER_EXTREME_SMALL_2, secondResult, DELTA);
    }

    @Test
    public void DivisionTestPositive() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_2, POSITIVE_NUMBER_1, DIVIDE);
        Assert.assertEquals("Wrong division algorithm!", 2, firstResult, DELTA);
    }

    @Test
    public void DivisionTestNegative() {
        double firstResult = calculator.calculate(NEGATIVE_NUMBER_2, NEGATIVE_NUMBER_1, DIVIDE);
        Assert.assertEquals("Wrong division algorithm!", 2, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_1, DIVIDE);
        Assert.assertEquals("Wrong division algorithm!", -2, secondResult, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void DivisionTestWithZero() {
        double firstResult = calculator.calculate(ZERO, POSITIVE_NUMBER_1, DIVIDE);
        Assert.assertEquals("", 0, firstResult, DELTA);
        calculator.calculate(POSITIVE_NUMBER_1, ZERO, DIVIDE);
    }

    @Test
    public void DivisionWithExtremeBigValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_BIG_1, POSITIVE_NUMBER_EXTREME_BIG_2, DIVIDE);
        Assert.assertEquals("Wrong subtraction algorithm!", POSITIVE_NUMBER_EXTREME_BIG_1 / POSITIVE_NUMBER_EXTREME_BIG_2, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_BIG_1, NEGATIVE_NUMBER_EXTREME_BIG_2, DIVIDE);
        Assert.assertEquals("Wrong subtraction algorithm!", NEGATIVE_NUMBER_EXTREME_BIG_1 / NEGATIVE_NUMBER_EXTREME_BIG_2, secondResult, DELTA);
    }

    @Test
    public void DivisionWithExtremeSmallValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_SMALL_1, POSITIVE_NUMBER_EXTREME_SMALL_2, DIVIDE);
        Assert.assertEquals("Wrong subtraction algorithm!", POSITIVE_NUMBER_EXTREME_SMALL_1 / POSITIVE_NUMBER_EXTREME_SMALL_2, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_SMALL_1, NEGATIVE_NUMBER_EXTREME_SMALL_2, DIVIDE);
        Assert.assertEquals("Wrong subtraction algorithm!", NEGATIVE_NUMBER_EXTREME_SMALL_1 / NEGATIVE_NUMBER_EXTREME_SMALL_2, secondResult, DELTA);
    }

    @Test
    public void MultiplicationTestPositive() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, MULTIPLY);
        Assert.assertEquals("Wrong multiplication algorithm!", 800, firstResult, DELTA);
    }

    @Test
    public void MultiplicationTestNegative() {
        double firstResult = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, MULTIPLY);
        Assert.assertEquals("Wrong addition algorithm!", 800, firstResult,  DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_2, MULTIPLY);
        Assert.assertEquals("Wrong addition algorithm!", -800, secondResult, DELTA);
    }

    @Test
    public void MultiplicationTestWithZero() {
        double firstResult = calculator.calculate(ZERO, POSITIVE_NUMBER_2, MULTIPLY);
        Assert.assertEquals("Wrong addition algorithm!", 0, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_1, ZERO, MULTIPLY);
        Assert.assertEquals("Wrong addition algorithm!", 0, secondResult, DELTA);
    }

    @Test
    public void MultiplicationWithExtremeBigValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_BIG_1, POSITIVE_NUMBER_EXTREME_BIG_2, MULTIPLY);
        Assert.assertEquals("Wrong subtraction algorithm!", POSITIVE_NUMBER_EXTREME_BIG_1 * POSITIVE_NUMBER_EXTREME_BIG_2, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_BIG_1, NEGATIVE_NUMBER_EXTREME_BIG_2, MULTIPLY);
        Assert.assertEquals("Wrong subtraction algorithm!", NEGATIVE_NUMBER_EXTREME_BIG_1 * NEGATIVE_NUMBER_EXTREME_BIG_2, secondResult, DELTA);
    }

    @Test
    public void MultiplicationWithExtremeSmallValues() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_EXTREME_SMALL_1, POSITIVE_NUMBER_EXTREME_SMALL_2, MULTIPLY);
        Assert.assertEquals("Wrong subtraction algorithm!", POSITIVE_NUMBER_EXTREME_SMALL_1 * POSITIVE_NUMBER_EXTREME_SMALL_2, firstResult, DELTA);
        double secondResult = calculator.calculate(NEGATIVE_NUMBER_EXTREME_SMALL_1, NEGATIVE_NUMBER_EXTREME_SMALL_2, MULTIPLY);
        Assert.assertEquals("Wrong subtraction algorithm!", NEGATIVE_NUMBER_EXTREME_SMALL_1 * NEGATIVE_NUMBER_EXTREME_SMALL_2, secondResult, DELTA);
    }

    @Test
    public void PowerTestPositive() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_1, 2, POWER);
        Assert.assertEquals("Wrong multiplication algorithm!", 400, firstResult, DELTA);
    }

    @Test
    public void PowerTestNegative() {
        double firstResult = calculator.calculate(NEGATIVE_NUMBER_1, 2, POWER);
        Assert.assertEquals("Wrong powering algorithm!", 400, firstResult, DELTA);
        double secondResult = calculator.calculate(POSITIVE_NUMBER_1, -2, POWER);
        Assert.assertEquals("Wrong powering algorithm!", 0.0025, secondResult, DELTA);
        double thirdResult = calculator.calculate(NEGATIVE_NUMBER_1, -2, POWER);
        Assert.assertEquals("Wrong powering algorithm!", 0.0025, thirdResult, DELTA);
    }

    @Test
    public void PowerTestWithZero() {
        double firstResult = calculator.calculate(POSITIVE_NUMBER_1, ZERO, POWER);
        Assert.assertEquals("Wrong powering algorithm!", 1, firstResult, DELTA);
        double secondResult = calculator.calculate(ZERO, 5, POWER);
        Assert.assertEquals("Wrong powering algorithm!", 0, secondResult, DELTA);
    }

    @Test
    public void PowerWithExtremeBigValues() {
        double firstResult = calculator.calculate(4000, 20, POWER);
        Assert.assertEquals("Wrong powering algorithm!", Math.pow(4000, 20), firstResult, DELTA);
    }

    @Test
    public void PowerWithExtremeSmallValues() {
        double firstResult = calculator.calculate(0.0004, 20, POWER);
        Assert.assertEquals("Wrong powering algorithm!", Math.pow(0.0004, 20), firstResult, DELTA);
    }
}
