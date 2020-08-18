
package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    public final ExpectedException exception = ExpectedException.none();
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char RAISE = '^';
    private static final char WRONG_OPERATOR = '&';
    private static final double DELTA = 0.0000001;

    private static final double POSITIVE_VALUE1 = 2.0;
    private static final double POSITIVE_VALUE2 = 5.0;
    private static final double NEGATIVE_VALUE1 = -2.0;
    private static final double NEGATIVE_VALUE2 = -5.0;
    private static final double ZERO = 0.0;

    @Test
    public void testAdditionCorrectWork() {
        Assert.assertEquals(7.0, Calculator.calc(POSITIVE_VALUE1, POSITIVE_VALUE2, PLUS), DELTA);
        Assert.assertEquals(0, Calculator.calc(POSITIVE_VALUE1, NEGATIVE_VALUE1, PLUS), DELTA);
    }

    @Test
    public void testSubtractionCorrectWork() {
        Assert.assertEquals(3, Calculator.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, MINUS), DELTA);
        Assert.assertEquals(-3, Calculator.calc(NEGATIVE_VALUE2, NEGATIVE_VALUE1, MINUS), DELTA);
    }

    @Test
    public void testDivisionCorrectWork() {
        Assert.assertEquals(2.5, Calculator.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, DIVIDE), DELTA);
        Assert.assertEquals(-2.5, Calculator.calc(NEGATIVE_VALUE2, POSITIVE_VALUE1, DIVIDE), DELTA);
        Assert.assertEquals(2.5, Calculator.calc(NEGATIVE_VALUE2, NEGATIVE_VALUE1, DIVIDE), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionBy0() {
        Calculator.calc(POSITIVE_VALUE1, ZERO,'/');
    }

    @Test
    public void testMultiplicationCorrectWork() {
        Assert.assertEquals(10.0, Calculator.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, MULTIPLY), DELTA);
        Assert.assertEquals(-4.0, Calculator.calc(NEGATIVE_VALUE1, POSITIVE_VALUE1, MULTIPLY), DELTA);
        Assert.assertEquals(10.0, Calculator.calc(NEGATIVE_VALUE1, NEGATIVE_VALUE2, MULTIPLY), DELTA);
    }

    @Test
    public void testRaisingToThePowerCorrectWork() {
        Assert.assertEquals(25.0, Calculator.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, RAISE), DELTA);
        Assert.assertEquals(1, Calculator.calc(POSITIVE_VALUE1, ZERO, RAISE), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRaisingToTheNegativePower() {
        Calculator.calc(POSITIVE_VALUE1, NEGATIVE_VALUE1, RAISE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongOperation() {
        Calculator.calc(POSITIVE_VALUE1, POSITIVE_VALUE1, WRONG_OPERATOR);
    }
}