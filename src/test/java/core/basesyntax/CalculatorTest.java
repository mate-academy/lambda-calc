package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MULTIPLY = '*';
    private static final char SUBTRACT = '-';
    private static final char DIVIDE = '/';
    private static final char WRONG_SIGNAL = '?';
    private static final char RAISING_TO_THE_POWER = '^';
    private static final double DELTA = 1
            ;
    private static final double POSITIVE_A = 5;
    private static final double POSITIVE_B = 5;
    private static final double NEGATIVE_A = -10;
    private static final double NEGATIVE_B = -2;
    private static final double ZERO_VALUE = 0.0;

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void additionalNegativeAndPositive() {
        double res = Calculator.calculate(POSITIVE_A, NEGATIVE_B, PLUS);
        Assert.assertEquals(3, res, DELTA);
    }

    @Test
    public void additionalPositive() {
        double res = Calculator.calculate(POSITIVE_A, POSITIVE_B, PLUS);
        Assert.assertEquals(10, res, DELTA);
    }

    @Test
    public void SubtractionPositive() {
        double res = Calculator.calculate(POSITIVE_A, POSITIVE_B, SUBTRACT);
        Assert.assertEquals(0, res, DELTA);
    }

    @Test
    public void SubtractionNegative() {
        double res = Calculator.calculate(NEGATIVE_A, NEGATIVE_B, SUBTRACT);
        Assert.assertEquals(-8, res, DELTA);
    }

    @Test
    public void divisionPositive() {
        double res = Calculator.calculate(POSITIVE_A, POSITIVE_A, DIVIDE);
        Assert.assertEquals(1, res, DELTA);
    }

    @Test
    public void divisionNegative() {
        double res = Calculator.calculate(NEGATIVE_A, NEGATIVE_B, DIVIDE);
        Assert.assertEquals(5, res, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        double res = Calculator.calculate(POSITIVE_A, ZERO_VALUE, DIVIDE);
    }

    @Test
    public void multiplicationPositive() {
        double res = Calculator.calculate(POSITIVE_A, POSITIVE_B, MULTIPLY);
        Assert.assertEquals(25, res, DELTA);
    }

    @Test
    public void multiplicationNegative() {
        double res = Calculator.calculate(NEGATIVE_A, NEGATIVE_B, MULTIPLY);
        Assert.assertEquals(20, res, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplicationZero() {
        double res = Calculator.calculate(ZERO_VALUE, NEGATIVE_B, MULTIPLY);
    }

    @Test
    public void raisingToBePowerPositive() {
        double res = Calculator.calculate(POSITIVE_A, POSITIVE_B, RAISING_TO_THE_POWER);
        Assert.assertEquals(3125, res, DELTA);
    }

    @Test
    public void raisingToBePowerNegative() {
        double res = Calculator.calculate(NEGATIVE_A, POSITIVE_B, RAISING_TO_THE_POWER);
        Assert.assertEquals(-100000.0, res, DELTA);
    }

    @Test
    public void raisingToBePowerZero() {
        double res = Calculator.calculate(ZERO_VALUE, POSITIVE_B, RAISING_TO_THE_POWER);
        Assert.assertEquals(ZERO_VALUE, res, DELTA);
    }

    @Test
    public void raisingToBePowerZeroSecond() {
        double res = Calculator.calculate(POSITIVE_A, ZERO_VALUE, RAISING_TO_THE_POWER);
        Assert.assertEquals(1, res, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongSignal() {
        double res = Calculator.calculate(POSITIVE_A, POSITIVE_B, WRONG_SIGNAL);
    }
}
