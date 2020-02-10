package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculateTest {
    @Test
    public void testSumPositive() {
        double sum = Calculate.getResult(7, 3, '+');
        Assert.assertEquals("Test sum , two number is positive: ", 10, sum, 0.01);
    }

    @Test
    public void testSum() {
        double sum = Calculate.getResult(15, -7, '+');
        Assert.assertEquals(String.format("Test sum %d %d: ", 15, -7), 8, sum, 0.01);

        sum = Calculate.getResult(15, 7, '+');
        Assert.assertEquals(String.format("Test sum %d %d: ", 15, 7), 22, sum, 0.01);

        sum = Calculate.getResult(-15, -7, '+');
        Assert.assertEquals(String.format("Test sum %d %d :", -15, -7), -22, sum, 0.01);

        sum = Calculate.getResult(-15, 7, '+');
        Assert.assertEquals(String.format("Test sum %d %d :", -15, 7), -8, sum, 0.01);
    }

    @Test
    public void testSubtraction() {
        double sub = Calculate.getResult(15, 7, '-');
        Assert.assertEquals(String.format("Test div %d %d: ", 15, 7), 8, sub, 0.01);

        sub = Calculate.getResult(-15, -7, '-');
        Assert.assertEquals(String.format("Test div %d %d :", -15, -7), -8, sub, 0.01);

        sub = Calculate.getResult(-15, 7, '+');
        Assert.assertEquals(String.format("Test div %d %d :", -15, 7), -8, sub, 0.01);

        sub = Calculate.getResult(15, -7, '+');
        Assert.assertEquals(String.format("Test div %d %d :", 15, -7), 8, sub, 0.01);
    }

    @Test
    public void testMultiplications() {
        double mult = Calculate.getResult(2, 2, '*');
        Assert.assertEquals(String.format("Test mult %d %d: ", 2, 2), 4, mult, 0.01);

        mult = Calculate.getResult(-2, -2, '*');
        Assert.assertEquals(String.format("Test mult %d %d :", -2, -2), 4, mult, 0.01);

        mult = Calculate.getResult(-2, 2, '*');
        Assert.assertEquals(String.format("Test mult %d %d :", -2, 2), -4, mult, 0.01);

        mult = Calculate.getResult(2, -2, '*');
        Assert.assertEquals(String.format("Test mult %d %d :", -2, 2), -4, mult, 0.01);
    }

    @Test
    public void testDivision() {
        double div = Calculate.getResult(2, 2, '/');
        Assert.assertEquals(String.format("Test div %d %d: ", 2, 2), 1, div, 0.01);

        div = Calculate.getResult(10, 2, '/');
        Assert.assertEquals(String.format("Test div %d %d :", 10, 2), 5, div, 0.01);

        div = Calculate.getResult(10, -2, '/');
        Assert.assertEquals(String.format("Test div %d %d :", 10, -2), -5, div, 0.01);

        div = Calculate.getResult(-10, -2, '/');
        Assert.assertEquals(String.format("Test div %d %d :", -10, -2), 5, div, 0.01);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testDivideByZero() {
        double div = Calculate.getResult(10, 0, '/');
        Assert.assertEquals(String.format("Test div %d %d: ", 2, 2), java.lang.ArithmeticException.class);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testNotFindOperator() {
        double div = Calculate.getResult(2, 2, 'a');
        Assert.assertEquals(String.format("Test div %d %d: ", 2, 2), java.lang.NullPointerException.class);
    }
}
