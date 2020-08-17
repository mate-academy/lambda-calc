package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private final double EPS = 1e-9;

    @Test
    public void simplePositiveAddedTest() {
        Calculator calculator = new Calculator(2, 3, '+');
        Assert.assertEquals(5, calculator.calculate(), EPS);
    }

    @Test
    public void simpleNegativeAddedTest() {
        Calculator calculator = new Calculator(-2, -3, '+');
        Assert.assertEquals(-5, calculator.calculate(), EPS);
    }

    @Test
    public void simpleAllZeroAddedTest() {
        Calculator calculator = new Calculator(0, 0, '+');
        Assert.assertEquals(0, calculator.calculate(), EPS);
    }

    @Test
    public void simpleXZeroAddedTest() {
        Calculator calculator = new Calculator(0, 3, '+');
        Assert.assertEquals(3, calculator.calculate(), EPS);
    }

    @Test
    public void simpleYZeroAddedTest() {
        Calculator calculator = new Calculator(2, 0, '+');
        Assert.assertEquals(2, calculator.calculate(), EPS);
    }

    @Test
    public void simplePositiveSubtractionTest() {
        Calculator calculator = new Calculator(2, 3, '-');
        Assert.assertEquals(-1, calculator.calculate(), EPS);
    }

    @Test
    public void simpleNegativeSubtractionTest() {
        Calculator calculator = new Calculator(-2, -3, '-');
        Assert.assertEquals(1, calculator.calculate(), EPS);
    }

    @Test
    public void simpleZeroSubtractionTest() {
        Calculator calculator = new Calculator(0, 0, '-');
        Assert.assertEquals(0, calculator.calculate(), EPS);
    }

    @Test
    public void simpleXZeroSubtractionTest() {
        Calculator calculator = new Calculator(0, 3, '-');
        Assert.assertEquals(-3, calculator.calculate(), EPS);
    }

    @Test
    public void simpleYZeroSubtractionTest() {
        Calculator calculator = new Calculator(2, 0, '-');
        Assert.assertEquals(2, calculator.calculate(), EPS);
    }

    @Test
    public void simplePositiveDivisionTest() {
        Calculator calculator = new Calculator(2, 3, '/');
        Assert.assertEquals(0.6666666666666666, calculator.calculate(), EPS);
    }

    @Test
    public void simpleNegativeDivisionTest() {
        Calculator calculator = new Calculator(-2, -3, '/');
        Assert.assertEquals(0.6666666666666666, calculator.calculate(), EPS);
    }

    @Test(expected = ArithmeticException.class)
    public void simpleZeroDivisionTest() {
        Calculator calculator = new Calculator(0, 0, '/');
        calculator.calculate();
    }

    @Test
    public void simpleXZeroDivisionTest() {
        Calculator calculator = new Calculator(0, 3, '/');
        Assert.assertEquals(0, calculator.calculate(), EPS);
    }

    @Test(expected = ArithmeticException.class)
    public void simpleYZeroDivisionTest() {
        Calculator calculator = new Calculator(2, 0, '/');
        calculator.calculate();
    }

    @Test
    public void simplePositiveMultiplicationTest() {
        Calculator calculator = new Calculator(2, 3, '*');
        Assert.assertEquals(6, calculator.calculate(), EPS);
    }

    @Test
    public void simpleNegativeMultiplicationTest() {
        Calculator calculator = new Calculator(-2, -3, '*');
        Assert.assertEquals(6, calculator.calculate(), EPS);
    }

    @Test
    public void simpleZeroMultiplicationTest() {
        Calculator calculator = new Calculator(0, 0, '*');
        Assert.assertEquals(0, calculator.calculate(), EPS);
    }

    @Test
    public void simpleXZeroMultiplicationTest() {
        Calculator calculator = new Calculator(0, 3, '*');
        Assert.assertEquals(0, calculator.calculate(), EPS);
    }

    @Test
    public void simpleYZeroMultiplicationTest() {
        Calculator calculator = new Calculator(2, 0, '*');
        Assert.assertEquals(0, calculator.calculate(), EPS);
    }

    @Test
    public void simplePositiveRaisingToThePowerTest() {
        Calculator calculator = new Calculator(2, 3, '^');
        Assert.assertEquals(8, calculator.calculate(), EPS);
    }

    @Test
    public void simpleNegativeRaisingToThePowerTest() {
        Calculator calculator = new Calculator(-2, -3, '^');
        Assert.assertEquals(-0.125, calculator.calculate(), EPS);
    }

    @Test
    public void simpleZeroRaisingToThePowerTest() {
        Calculator calculator = new Calculator(0, 0, '^');
        Assert.assertEquals(1, calculator.calculate(), EPS);
    }

    @Test
    public void simpleXZeroRaisingToThePowerTest() {
        Calculator calculator = new Calculator(0, 3, '^');
        Assert.assertEquals(0, calculator.calculate(), EPS);
    }

    @Test
    public void simpleYZeroRaisingToThePowerTest() {
        Calculator calculator = new Calculator(2, 0, '^');
        Assert.assertEquals(1, calculator.calculate(), EPS);
    }
}
