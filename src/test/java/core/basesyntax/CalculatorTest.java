package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private final double EPS = 1e-9;
    private double x = 2;
    private double y = 3;

    @BeforeClass
    public static void createNewCalc() {
        calculator = new Calculator();
    }

    @Test
    public void positiveAddedTest() {
        Assert.assertEquals(5, calculator.calculate(2, 3, '+'), EPS);
    }

    @Test
    public void negativeAddedTest() {
        Assert.assertEquals(-5, calculator.calculate(-2, -3, '+'), EPS);
    }

    @Test
    public void allZeroAddedTest() {
        Assert.assertEquals(0, calculator.calculate(0, 0, '+'), EPS);
    }

    @Test
    public void xZeroAddedTest() {
        Assert.assertEquals(3, calculator.calculate(0, 3, '+'), EPS);
    }

    @Test
    public void yZeroAddedTest() {
        Assert.assertEquals(2, calculator.calculate(2, 0, '+'), EPS);
    }

    @Test
    public void positiveSubtractionTest() {
        Assert.assertEquals(-1, calculator.calculate(2, 3, '-'), EPS);
    }

    @Test
    public void negativeSubtractionTest() {
        Assert.assertEquals(1, calculator.calculate(-2, -3, '-'), EPS);
    }

    @Test
    public void zeroSubtractionTest() {
        Assert.assertEquals(0, calculator.calculate(0, 0, '-'), EPS);
    }

    @Test
    public void xZeroSubtractionTest() {
        Assert.assertEquals(-3, calculator.calculate(0, 3, '-'), EPS);
    }

    @Test
    public void yZeroSubtractionTest() {
        Assert.assertEquals(2, calculator.calculate(2, 0, '-'), EPS);
    }

    @Test
    public void positiveDivisionTest() {
        Assert.assertEquals(0.6666666666666666, calculator.calculate(2, 3, '/'), EPS);
    }

    @Test
    public void negativeDivisionTest() {
        Assert.assertEquals(0.6666666666666666, calculator.calculate(-2, -3, '/'), EPS);
    }

    @Test(expected = ArithmeticException.class)
    public void zeroDivisionTest() {
        calculator.calculate(0, 0, '/');
    }

    @Test
    public void xZeroDivisionTest() {
        Assert.assertEquals(0, calculator.calculate(0, 3, '/'), EPS);
    }

    @Test(expected = ArithmeticException.class)
    public void yZeroDivisionTest() {
        calculator.calculate(2, 0, '/');
    }

    @Test
    public void positiveMultiplicationTest() {
        Assert.assertEquals(6, calculator.calculate(2, 3, '*'), EPS);
    }

    @Test
    public void negativeMultiplicationTest() {
        Assert.assertEquals(6, calculator.calculate(-2, -3, '*'), EPS);
    }

    @Test
    public void zeroMultiplicationTest() {
        Assert.assertEquals(0, calculator.calculate(0, 0, '*'), EPS);
    }

    @Test
    public void xZeroMultiplicationTest() {
        Assert.assertEquals(0, calculator.calculate(0, 3, '*'), EPS);
    }

    @Test
    public void yZeroMultiplicationTest() {
        Assert.assertEquals(0, calculator.calculate(2, 0, '*'), EPS);
    }

    @Test
    public void positiveRaisingToThePowerTest() {
        Assert.assertEquals(8, calculator.calculate(2, 3, '^'), EPS);
    }

    @Test
    public void negativeRaisingToThePowerTest() {
        Assert.assertEquals(-0.125, calculator.calculate(-2, -3, '^'), EPS);
    }

    @Test
    public void zeroRaisingToThePowerTest() {
        Assert.assertEquals(1, calculator.calculate(0, 0, '^'), EPS);
    }

    @Test
    public void xZeroRaisingToThePowerTest() {
        Assert.assertEquals(0, calculator.calculate(0, 3, '^'), EPS);
    }

    @Test
    public void yZeroRaisingToThePowerTest() {
        Assert.assertEquals(1, calculator.calculate(2, 0, '^'), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperatorTest() {
        calculator.calculate(2, 3, ')');
    }

}
