package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculateTest {
    private Calculate calculate;
    private static final double DELTA = 0.01;

    public CalculateTest() {
        calculate = new Calculate();
    }

    @Test
    public void testSum() {
        double sum = calculate.getResult(7, 3, '+');
        Assert.assertEquals("Test sum , two number are positive: ", 10, sum, DELTA);

        sum = calculate.getResult(15, -7, '+');
        Assert.assertEquals(String.format("Test sum %d %d: ", 15, -7), 8, sum, DELTA);

        sum = calculate.getResult(15, 7, '+');
        Assert.assertEquals(String.format("Test sum %d %d: ", 15, 7), 22, sum, DELTA);

        sum = calculate.getResult(-15, -7, '+');
        Assert.assertEquals(String.format("Test sum %d %d :", -15, -7), -22, sum, DELTA);

        sum = calculate.getResult(-15, 7, '+');
        Assert.assertEquals(String.format("Test sum %d %d :", -15, 7), -8, sum, DELTA);
    }

    @Test
    public void testSubtraction() {
        double sub = calculate.getResult(15, 7, '-');
        Assert.assertEquals(String.format("Test div %d %d: ", 15, 7), 8, sub, DELTA);

        sub = calculate.getResult(-15, -7, '-');
        Assert.assertEquals(String.format("Test div %d %d :", -15, -7), -8, sub, DELTA);

        sub = calculate.getResult(-15, 7, '-');
        Assert.assertEquals(String.format("Test div %d %d :", -15, 7), -22, sub, DELTA);

        sub = calculate.getResult(15, -7, '-');
        Assert.assertEquals(String.format("Test div %d %d :", 15, -7), 22, sub, DELTA);
    }

    @Test
    public void testMultiplications() {
        double mult = calculate.getResult(2, 2, '*');
        Assert.assertEquals(String.format("Test mult %d %d: ", 2, 2), 4, mult, DELTA);

        mult = calculate.getResult(-2, -2, '*');
        Assert.assertEquals(String.format("Test mult %d %d :", -2, -2), 4, mult, DELTA);

        mult = calculate.getResult(-2, 2, '*');
        Assert.assertEquals(String.format("Test mult %d %d :", -2, 2), -4, mult, DELTA);

        mult = calculate.getResult(2, -2, '*');
        Assert.assertEquals(String.format("Test mult %d %d :", -2, 2), -4, mult, DELTA);
    }

    @Test
    public void testDivision() {
        double div = calculate.getResult(2, 2, '/');
        Assert.assertEquals(String.format("Test div %d %d: ", 2, 2), 1, div, DELTA);

        div = calculate.getResult(10, 2, '/');
        Assert.assertEquals(String.format("Test div %d %d :", 10, 2), 5, div, DELTA);

        div = calculate.getResult(10, -2, '/');
        Assert.assertEquals(String.format("Test div %d %d :", 10, -2), -5, div, DELTA);

        div = calculate.getResult(-10, -2, '/');
        Assert.assertEquals(String.format("Test div %d %d :", -10, -2), 5, div, DELTA);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testDivideByZero() {
        double div = calculate.getResult(10, 0, '/');
        Assert.assertEquals(String.format("Test div %d %d: ", 2, 2), java.lang.ArithmeticException.class);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testNotFindOperator() {
        double div = calculate.getResult(2, 2, 'a');
        Assert.assertEquals(String.format("Test div %d %d: ", 2, 2), java.lang.NullPointerException.class);
    }
}
