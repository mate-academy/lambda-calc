package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {
    private Calculate calculate;

    @Before
    public void setUp() throws Exception {
        calculate = new Calculate();
    }

    @Test
    public void testPlusNumbers() {
        Assert.assertEquals(10, calculate.calculate(5,5,'+'), 1);
        Assert.assertEquals(669.0, calculate.calculate(345,324,'+'), 1);
        Assert.assertEquals(490.744, calculate.calculate(456.11,34.634,'+'), 1);
        Assert.assertEquals(5746.0, calculate.calculate(5234,512,'+'), 1);
    }

    @Test
    public void testMinusNumbers() {
        Assert.assertEquals(2, calculate.calculate(6,4,'-'), 1);
        Assert.assertEquals(219, calculate.calculate(342,123,'-'), 1);
        Assert.assertEquals(222.22, calculate.calculate(456.78,234.56,'-'), 1);
        Assert.assertEquals(-3087.0, calculate.calculate(1234,4321,'-'), 1);
    }

    @Test
    public void testMultiplyNumbers() {
        Assert.assertEquals(25, calculate.calculate(5,5,'*'), 1);
        Assert.assertEquals(2751.0784, calculate.calculate(517.12,5.32,'*'), 1);
        Assert.assertEquals(2, calculate.calculate(0.5,4,'*'), 1);
        Assert.assertEquals(87, calculate.calculate(17.4,5,'*'), 1);
        Assert.assertEquals(318.2, calculate.calculate(43,7.4,'*'), 1);

    }

    @Test
    public void testDivisionNumbers() {
        Assert.assertEquals(5, calculate.calculate(10,2,'/'), 1);
        Assert.assertEquals(34, calculate.calculate(374, 11,'/'), 1);
        Assert.assertEquals(175.395348837, calculate.calculate(7542,43,'/'), 1);
        Assert.assertEquals(147.981132075, calculate.calculate(784.3,5.3,'/'), 1);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculate.calculate(10,0,'/');
        calculate.calculate(342,0,'/');
        calculate.calculate(132,0,'/');
        calculate.calculate(754,0,'/');
    }

    @Test(expected = NullPointerException.class)
    public void TestNullNumbersTest() {
        Double a = null;
        Double b = null;
        calculate.calculate(a, b, '+');
    }
}