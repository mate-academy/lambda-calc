package core.basesyntax;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class CalculationsTest {
    private static final int DELTA = 1;
    private static final double FLOATING_DELTA = 1e-10;
    private static Calculation calc;

    @BeforeClass
    public static void setUp() {
        calc = new Calculation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void operationCharacterNegativeTest() {
        calc.calculate(13, 5, 'o');
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        calc.calculate(173, 0, '/');
    }

    @Test(expected = ArithmeticException.class)
    public void checkDoubleMaxValueOverflow() {
        calc.calculate(Double.MAX_VALUE, 10000, '-');
    }

    @Test
    public void AdditionPositiveNumberOk() {
        Assert.assertEquals(7, calc.calculate(5, 2, '+'), DELTA);
    }

    @Test
    public void AdditionNegativeNumberOk() {
        Assert.assertEquals(-10650.0, calc.calculate(-5784.0, -4866.0, '+'), DELTA);
    }

    @Test
    public void ZeroAdditionOk() {
        Assert.assertEquals(57.0, calc.calculate(57.0, 0.0, '+'), DELTA);
        Assert.assertEquals(0.0, calc.calculate(0.0, 0.0, '+'), DELTA);
    }

    @Test
    public void AdditionFloatingPointNumberOk() {
        Assert.assertEquals(-313.7, calc.calculate(-576.88, 263.18, '+'), FLOATING_DELTA);
    }

    @Test
    public void MultiplicationPositiveNumberOk() {
        Assert.assertEquals(56.0, calc.calculate(7.0, 8.0, '*'), DELTA);
    }

    @Test
    public void MultiplicationNegativeNumberOk() {
        Assert.assertEquals(-56.0, calc.calculate(7.0, -8.0, '*'), DELTA);
    }

    @Test
    public void ZeroMultiplicationOk() {
        Assert.assertEquals(0.0, calc.calculate(57.0, 0.0, '*'), DELTA);
        Assert.assertEquals(0.0, calc.calculate(0.0, 0.0, '*'), DELTA);
    }

    @Test
    public void MultiplicationFloatingPointNumberOk() {
        Assert.assertEquals(-187.44, calc.calculate(-56.8, 3.3, '*'), FLOATING_DELTA);
    }

    @Test
    public void SubtractionPositiveNumberOk() {
        Assert.assertEquals(77.0, calc.calculate(87.0, 10.0, '-'), DELTA);
    }

    @Test
    public void SubtractionNegativeNumberOk() {
        Assert.assertEquals(-11.0, calc.calculate(-24.0, -13.0, '-'), DELTA);
    }

    @Test
    public void ZeroSubtractionOk() {
        Assert.assertEquals(88.0, calc.calculate(88.0, 0.0, '-'), DELTA);
        Assert.assertEquals(0.0, calc.calculate(0.0, 0.0, '-'), DELTA);
    }

    @Test
    public void SubtractionFloatingPointNumberOk() {
        Assert.assertEquals(-209.77, calc.calculate(-176.66, 33.11, '-'), FLOATING_DELTA);
    }

    @Test
    public void DivisionPositiveNumberOk() {
        Assert.assertEquals(11.0, calc.calculate(121, 11, '/'), DELTA);
    }

    @Test
    public void DivisionNegativeNumberOk() {
        Assert.assertEquals(-88.0, calc.calculate(-3168.0, 36.0, '/'), DELTA);
        Assert.assertEquals(31.0, calc.calculate(-403.0, -13.0, '/'), DELTA);
    }

    @Test
    public void ZeroDivisionOk() {
        Assert.assertEquals(0.0, calc.calculate(0.0, 18.0, '/'), DELTA);
    }

    @Test
    public void DivisionFloatingPointNumberOk() {
        Assert.assertEquals(-3.55, calc.calculate(-1365.6495, 384.69, '/'), FLOATING_DELTA);
    }

    @Test
    public void PowerPositiveNumberOk() {
        Assert.assertEquals(1977326743.0, calc.calculate(7.0, 11.0, '^'), DELTA);
    }

    @Test
    public void PowerNegativeNumberOk() {
        Assert.assertEquals(-29791.0, calc.calculate(-31.0, 3.0, '^'), DELTA);
        Assert.assertEquals(46656.0, calc.calculate(-6.0, 6.0, '^'), DELTA);
    }

    @Test
    public void ZeroPowerOk() {
        Assert.assertEquals(1.0, calc.calculate(88.0, 0.0, '^'), DELTA);
        Assert.assertEquals(0.0, calc.calculate(0.0, 5.0, '^'), DELTA);
    }

    @Test
    public void PowerFloatingPointNumberOk() {
        Assert.assertEquals(0.03921184197627684, calc.calculate(-5.05, -2.0, '^'), FLOATING_DELTA);
    }

    @Test
    public void NegativePowerOk() {
        Assert.assertEquals(-0.037037037037037035, calc.calculate(-3.0, -3.0, '^'), FLOATING_DELTA);
        Assert.assertEquals(0.012345679012345678, calc.calculate(-3.0, -4.0, '^'), FLOATING_DELTA);
    }

    @Test
    public void FloatingPointPowerOk() {
        Assert.assertEquals(0.2534898699475073, calc.calculate(8, -0.66, '^'), FLOATING_DELTA);
        Assert.assertEquals(13501.25107, calc.calculate(44.89, 2.5, '^'), FLOATING_DELTA);
    }
}
