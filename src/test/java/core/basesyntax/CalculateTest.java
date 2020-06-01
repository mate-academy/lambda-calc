package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {
    private static final int DELTA = 1;

    private Calculate calculate;

    @Before
    public void setUp() throws Exception {
        calculate = new Calculate();
    }

    @Test
    public void testPlusNumbers() {
        Assert.assertEquals(10, calculate.calculate(5, 5, '+'), DELTA);
        Assert.assertEquals(669.0, calculate.calculate(345, 324, '+'), DELTA);
        Assert.assertEquals(490.744, calculate.calculate(456.11, 34.634, '+'), DELTA);
        Assert.assertEquals(5746.0, calculate.calculate(5234, 512, '+'), DELTA);
    }

    @Test
    public void testMinusNumbers() {
        Assert.assertEquals(2, calculate.calculate(6, 4, '-'), DELTA);
        Assert.assertEquals(219, calculate.calculate(342, 123, '-'), DELTA);
        Assert.assertEquals(222.22, calculate.calculate(456.78, 234.56, '-'), DELTA);
        Assert.assertEquals(-3087.0, calculate.calculate(1234, 4321, '-'), DELTA);
    }

    @Test
    public void testMinusWithOppositeNumbers() {
        Assert.assertEquals(-2, calculate.calculate(-6, -4, '-'), DELTA);
        Assert.assertEquals(-465.0, calculate.calculate(-342, 123, '-'), DELTA);
        Assert.assertEquals(-691.3399999999999, calculate.calculate(-456.78, 234.56, '-'), DELTA);
        Assert.assertEquals(5555.0, calculate.calculate(1234, -4321, '-'), DELTA);
    }

    @Test
    public void testMultiplyNumbers() {
        Assert.assertEquals(25, calculate.calculate(5, 5, '*'), DELTA);
        Assert.assertEquals(2751.0784, calculate.calculate(517.12, 5.32, '*'), DELTA);
        Assert.assertEquals(2, calculate.calculate(0.5, 4, '*'), DELTA);
        Assert.assertEquals(87, calculate.calculate(17.4, 5, '*'), DELTA);
        Assert.assertEquals(318.2, calculate.calculate(43, 7.4, '*'), DELTA);
    }

    @Test
    public void testPowNumbers() {
        Assert.assertEquals(3125.0, calculate.calculate(5, 5, 'p'), DELTA);
        Assert.assertEquals(2.7309006505965362E14, calculate.calculate(517.12, 5.32, 'p'), DELTA);
        Assert.assertEquals(0.0625, calculate.calculate(0.5, 4, 'p'), DELTA);
        Assert.assertEquals(1594946.9462399993, calculate.calculate(17.4, 5, 'p'), DELTA);
        Assert.assertEquals(1.223676363476881E12, calculate.calculate(43, 7.4, 'p'), DELTA);
    }

    @Test
    public void testPowNumbersWithOppositeNumber() {
        Assert.assertEquals(3.2E-4, calculate.calculate(5, -5, 'p'), DELTA);
        Assert.assertEquals(16.0, calculate.calculate(0.5, -4, 'p'), DELTA);
        Assert.assertEquals(6.26980102603065E-7, calculate.calculate(17.4, -5, 'p'), DELTA);
        Assert.assertEquals(8.172095415479462E-13, calculate.calculate(43, -7.4, 'p'), DELTA);
    }

    @Test
    public void testDivisionNumbers() {
        Assert.assertEquals(5, calculate.calculate(10, 2, '/'), DELTA);
        Assert.assertEquals(34, calculate.calculate(374, 11, '/'), DELTA);
        Assert.assertEquals(175.395348837, calculate.calculate(7542, 43, '/'), DELTA);
        Assert.assertEquals(147.981132075, calculate.calculate(784.3, 5.3, '/'), DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void testIncorrectSymbol() {
        calculate.calculate(10, 2, 'z');
        calculate.calculate(374,  11, 'b');
        calculate.calculate(7542, 43, 'r');
        calculate.calculate(784.3, 5.3, 'l');
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculate.calculate(10, 0, '/');
        calculate.calculate(342, 0, '/');
        calculate.calculate(132, 0, '/');
        calculate.calculate(754, 0, '/');
    }

    @Test(expected = NullPointerException.class)
    public void TestNullNumbersTest() {
        Double a = null;
        Double b = null;
        calculate.calculate(a,  b, '+');
    }
}
