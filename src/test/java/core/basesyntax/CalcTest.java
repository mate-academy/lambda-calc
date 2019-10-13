package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalcTest {

    @Test
    public void addPositive() {
        Calc calc = new Calc(1, '+', 1.5);
        Assert.assertEquals(2.5, calc.calculate(), 0);
    }

    @Test
    public void addNegative() {
        Calc calc = new Calc(1, '+', -1.5);
        Assert.assertEquals(-0.5, calc.calculate(), 0);
        Assert.assertNotEquals(2.5, calc.calculate(), 0);
    }

    @Test
    public void multiplyPositive() {
        Calc calc = new Calc(1, '*', 1.5);
        Assert.assertEquals(1.5, calc.calculate(), 0);
    }

    @Test
    public void multiplyNegative() {
        Calc calc = new Calc(-1, '*', -1.5);
        Assert.assertEquals(1.5, calc.calculate(), 0);
        Assert.assertNotEquals(-1.5, calc.calculate(), 0);
    }

    @Test
    public void dividePositive() {
        Calc calc = new Calc(1, '/', 2);
        Assert.assertEquals(0.5, calc.calculate(), 0);
    }

    @Test
    public void divideNegative() {
        Calc calc = new Calc(1, '/', -0.5);
        Assert.assertEquals(-2, calc.calculate(), 0);
        Assert.assertNotEquals(-0.5, calc.calculate(), 0);
    }

    @Test
    public void divideByZero() {
        try {
            Calc calc = new Calc(1, '/', 0);
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException was expected");
    }

    @Test
    public void differencePositive() {
        Calc calc = new Calc(1, '-', 1.5);
        Assert.assertEquals(-0.5, calc.calculate(), 0);
    }

    @Test
    public void differenceNegative() {
        Calc calc = new Calc(1, '-', -1.5);
        Assert.assertEquals(2.5, calc.calculate(), 0);
        Assert.assertNotEquals(-0.5, calc.calculate(), 0);
    }

    @Test
    public void powerPositive() {
        Calc calc = new Calc(5, '^', 2);
        Assert.assertEquals(25, calc.calculate(), 0);
    }

    @Test
    public void powerNegative() {
        Calc calc = new Calc(2, '^', -2);
        Assert.assertEquals(0.25, calc.calculate(), 0);
        Assert.assertNotEquals(4, calc.calculate(), 0);
    }

    @Test
    public void powerOfZero() {
        Calc calc = new Calc(0, '^', 2);
        Assert.assertEquals(0, calc.calculate(), 0);
        Assert.assertNotEquals(1, calc.calculate(), 0);
    }
}
