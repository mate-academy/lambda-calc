package core.basesyntax;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class calculatorTest {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLAY = '*';
    public static final char DIVIDE = '/';
    public static final char POWERING = '^';
    public static final double DELTA = 1e-10;
    public static Calculator calculator;
    public static final Double NULL = null;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void checkSummingForSmallNumbers() {
        Assert.assertEquals("Test failed!", 0, calculator.calculate(0, 0, PLUS), DELTA);
        Assert.assertEquals("Test failed!", 9, calculator.calculate(4, 5, PLUS), DELTA);
        Assert.assertEquals("Test failed!", 300, calculator.calculate(200, 100, PLUS), DELTA);
        Assert.assertEquals("Test failed!", 1000, calculator.calculate(500, 500, PLUS), DELTA);
    }

    @Test
    public void checkSummingForBigNumbers() {
        Assert.assertEquals("Test failed!", 1000, calculator.calculate(500, 500, PLUS), DELTA);

    }

    @Test
    public void checkSummingForNegativeNumbers() {
        Assert.assertEquals("Test failed!", -3, calculator.calculate(-3, 0, PLUS), DELTA);
        Assert.assertEquals("Test failed!", -6, calculator.calculate(-3, -3, PLUS), DELTA);
        Assert.assertEquals("Test failed!", -10, calculator.calculate(0, -10, PLUS), DELTA);
        Assert.assertEquals("Test failed!", -10, calculator.calculate(-10, 0, PLUS), DELTA);
    }

    @Test
    public void checkSubstructionForPositiveNumbers() {
        Assert.assertEquals("Test failed!", 0, calculator.calculate(0, 0, MINUS), DELTA);
        Assert.assertEquals("Test failed!", 0, calculator.calculate(10, 10, MINUS), DELTA);
        Assert.assertEquals("Test failed!", 100, calculator.calculate(100, 0, MINUS), DELTA);
    }

    @Test
    public void checkSubstructionForNegativeeNumbers() {
        Assert.assertEquals("Test failed!", 3, calculator.calculate(0, -3, MINUS), DELTA);
        Assert.assertEquals("Test failed!", 5, calculator.calculate(-10, -15, MINUS), DELTA);
        Assert.assertEquals("Test failed!", -2, calculator.calculate(-3, -1, MINUS), DELTA);
    }

    @Test
    public void checkMultiplyingForPositiveNumbers() {
        Assert.assertEquals("Test failed!", 2, calculator.calculate(1, 2, MULTIPLAY), DELTA);
        Assert.assertEquals("Test failed!", 20, calculator.calculate(2, 10, MULTIPLAY), DELTA);
        Assert.assertEquals("Test failed!", 132, calculator.calculate(11, 12, MULTIPLAY), DELTA);
    }

    @Test
    public void checkMultiplyingForNegativeNumbers() {
        Assert.assertEquals("Test failed!", -2, calculator.calculate(1, -2, MULTIPLAY), DELTA);
        Assert.assertEquals("Test failed!", -20, calculator.calculate(-2, 10, MULTIPLAY), DELTA);
        Assert.assertEquals("Test failed!", 99, calculator.calculate(-9, -11, MULTIPLAY), DELTA);
    }

    @Test
    public void checkMultiplyingForZero() {
        Assert.assertEquals("Test failed!", 0, calculator.calculate(0, -2, MULTIPLAY), DELTA);
        Assert.assertEquals("Test failed!", 0, calculator.calculate(-2, 0, MULTIPLAY), DELTA);
        Assert.assertEquals("Test failed!", 0, calculator.calculate(10, 0, MULTIPLAY), DELTA);
        Assert.assertEquals("Test failed!", 0, calculator.calculate(0, 7, MULTIPLAY), DELTA);
    }

    @Test
    public void checkDividing() {
        Assert.assertEquals("Test failed!", 0, calculator.calculate(0, -2, DIVIDE), DELTA);
        Assert.assertEquals("Test failed!", 0, calculator.calculate(0, -2, DIVIDE), DELTA);
        Assert.assertEquals("Test failed!", -1, calculator.calculate(2, -2, DIVIDE), DELTA);
        Assert.assertEquals("Test failed!", 1, calculator.calculate(-2, -2, DIVIDE), DELTA);
        Assert.assertEquals("Test failed!", 2, calculator.calculate(10, 5, DIVIDE), DELTA);
        Assert.assertEquals("Test failed!", -2, calculator.calculate(10, -5, DIVIDE), DELTA);
    }

    @Test
    public void checkPowering() {
        Assert.assertEquals("Test failed!", 4, calculator.calculate(2, 2, POWERING), DELTA);
        Assert.assertEquals("Test failed!", 0.25, calculator.calculate(2, -2, POWERING), DELTA);
        Assert.assertEquals("Test failed!", 1, calculator.calculate(2, 0, POWERING), DELTA);
        Assert.assertEquals("Test failed!", 1, calculator.calculate(-2, 0, POWERING), DELTA);
        Assert.assertEquals("Test failed!", 4, calculator.calculate(-2, 2, POWERING), DELTA);
        Assert.assertEquals("Test failed!", 0.25, calculator.calculate(-2, -2, POWERING), DELTA);
        Assert.assertEquals("Test failed!", 9.5367431640625E-7, calculator.calculate(-2, -20, POWERING), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void dividingByZero() {
        calculator.calculate(10, 0, DIVIDE);
        calculator.calculate(-10, 0, DIVIDE);
        calculator.calculate(0, 0, DIVIDE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkingSignAccuracy() {
        calculator.calculate(2, 3, '@');
        calculator.calculate(2, 3, '#');
        calculator.calculate(2, 3, '$');
        calculator.calculate(2, 3, '%');
        calculator.calculate(2, 3, '&');
        calculator.calculate(2, 3, '!');
        calculator.calculate(2, 3, '.');
        calculator.calculate(2, 3, '_');
    }
}
