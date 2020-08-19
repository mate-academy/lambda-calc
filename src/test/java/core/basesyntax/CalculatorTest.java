
package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
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

    private static Calculator calculatorInstance;

    @BeforeClass
    public static void setCalculator() {
        calculatorInstance = new Calculator();
    }

    @Test
    public void testAdditionCorrectWork() {
        Assert.assertEquals(7.0, calculatorInstance.calc(POSITIVE_VALUE1, POSITIVE_VALUE2, PLUS), DELTA);
        Assert.assertEquals(0, calculatorInstance.calc(POSITIVE_VALUE1, NEGATIVE_VALUE1, PLUS), DELTA);
        Assert.assertEquals(POSITIVE_VALUE1, calculatorInstance.calc(POSITIVE_VALUE1, ZERO, PLUS), DELTA);
        Assert.assertEquals(NEGATIVE_VALUE1, calculatorInstance.calc(NEGATIVE_VALUE1, ZERO, PLUS), DELTA);
    }

   @Test
    public void testSubtractionCorrectWork() {
        Assert.assertEquals(3, calculatorInstance.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, MINUS), DELTA);
        Assert.assertEquals(-3, calculatorInstance.calc(NEGATIVE_VALUE2, NEGATIVE_VALUE1, MINUS), DELTA);
    }

    @Test
    public void testDivisionCorrectWork() {
        Assert.assertEquals(2.5, calculatorInstance.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, DIVIDE), DELTA);
        Assert.assertEquals(-2.5, calculatorInstance.calc(NEGATIVE_VALUE2, POSITIVE_VALUE1, DIVIDE), DELTA);
        Assert.assertEquals(2.5, calculatorInstance.calc(NEGATIVE_VALUE2, NEGATIVE_VALUE1, DIVIDE), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculatorInstance.calc(POSITIVE_VALUE1, ZERO, DIVIDE);
    }

    @Test
    public void testMultiplicationCorrectWork() {
        Assert.assertEquals(10.0, calculatorInstance.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, MULTIPLY), DELTA);
        Assert.assertEquals(-4.0, calculatorInstance.calc(NEGATIVE_VALUE1, POSITIVE_VALUE1, MULTIPLY), DELTA);
        Assert.assertEquals(10.0, calculatorInstance.calc(NEGATIVE_VALUE1, NEGATIVE_VALUE2, MULTIPLY), DELTA);
        Assert.assertEquals(0.0, calculatorInstance.calc(POSITIVE_VALUE1, ZERO, MULTIPLY), DELTA);
    }

    @Test
    public void testRaisingToThePowerCorrectWork() {
        Assert.assertEquals(25.0, calculatorInstance.calc(POSITIVE_VALUE2, POSITIVE_VALUE1, RAISE), DELTA);
        Assert.assertEquals(1, calculatorInstance.calc(POSITIVE_VALUE1, ZERO, RAISE), DELTA);
        Assert.assertEquals(0.04, calculatorInstance.calc(POSITIVE_VALUE2, NEGATIVE_VALUE1, RAISE), DELTA);
        Assert.assertEquals(4, calculatorInstance.calc(NEGATIVE_VALUE1, POSITIVE_VALUE1, RAISE), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongOperation() {
        calculatorInstance.calc(POSITIVE_VALUE1, POSITIVE_VALUE1, WRONG_OPERATOR);
    }
}