package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    public final ExpectedException exception = ExpectedException.none();
    @Test
    public void testAdditionCorrectWork() {
        Assert.assertEquals(4, Calculator.calc(2,2,'+'));
        Assert.assertEquals(0, Calculator.calc(2,-2,'+'));
        Assert.assertEquals(-2, Calculator.calc(Integer.MAX_VALUE, Integer.MAX_VALUE,'+'));
    }

    @Test
    public void testSubtractionCorrectWork() {
        Assert.assertEquals(3, Calculator.calc(5,2,'-'));
        Assert.assertEquals(-3, Calculator.calc(-5,-2,'-'));
    }

    @Test
    public void testDivisionCorrectWork() {
        Assert.assertEquals(2, Calculator.calc(4,2,'/'));
        Assert.assertEquals(-3, Calculator.calc(-6,2,'/'));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionBy0() {
        Calculator.calc(4,0,'/');
    }

    @Test
    public void testMultiplicationCorrectWork() {
        Assert.assertEquals(9, Calculator.calc(3,3,'*'));
        Assert.assertEquals(-9, Calculator.calc(-3,3,'*'));
        Assert.assertEquals(9, Calculator.calc(-3,-3,'*'));
    }

    @Test
    public void testRaisingToThePowerCorrectWork() {
        Assert.assertEquals(4, Calculator.calc(2,2,'^'));
        Assert.assertEquals(1, Calculator.calc(100,0,'^'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRaisingToTheNegativePower() {
        Calculator.calc(100,-5,'^');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongOperation() {
        Calculator.calc(100,3,'&');
    }
}