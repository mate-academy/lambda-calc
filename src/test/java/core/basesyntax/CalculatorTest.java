package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;
/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    @Test
    public void addNumbers() {
        Assert.assertEquals(Integer.valueOf(9), Calculator.startCalc(2, 7, '+'));
    }

    @Test
    public void addNegativeNumbers(){
        Assert.assertEquals(Integer.valueOf(-10), Calculator.startCalc(-3, -7, '+'));
    }

    @Test
    public void subtractNumbers() {
        Assert.assertEquals(Integer.valueOf(3), Calculator.startCalc(5, 2, '-'));
    }
    @Test
    public void subtractNegativeNumbers() {
        Assert.assertEquals(Integer.valueOf(-3), Calculator.startCalc(-5, -2, '-'));
    }

    @Test
    public void multiplySimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(4), Calculator.startCalc(2, 2, '*'));
    }

    @Test
    public void divideSimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(2), Calculator.startCalc(4, 2, '/'));
    }

    @Test
    public void levelOfNumber() {
        Assert.assertEquals(Integer.valueOf(4), Calculator.startCalc(2, 2, '^'));
    }

    @Test
    public void levelOfNegativeNumber() {
        Assert.assertEquals(Integer.valueOf(0), Calculator.startCalc(2, -2, '^'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZero() {
        Calculator.startCalc(5, 0, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNotValidSign() {
        Calculator.startCalc(5, 3, 's');
    }
}
