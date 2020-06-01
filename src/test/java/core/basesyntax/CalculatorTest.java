package core.basesyntax;

import core.basesyntax.exceptions.DataProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addSimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(7), Calculator.calculate(3, 4, '+'));
    }

    @Test
    public void addNegativeNumbers() throws DataProcessingException {
        Assert.assertEquals(Integer.valueOf(-15), Calculator.calculate(-5, -10, '+'));
    }

    @Test
    public void subtractSimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(4), Calculator.calculate(6, 2, '-'));
    }
    @Test
    public void subtractNegativeNumbers() {
        Assert.assertEquals(Integer.valueOf(-2), Calculator.calculate(-6, -4, '-'));
    }

    @Test
    public void multiplySimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(25), Calculator.calculate(5, 5, '*'));
    }

    @Test
    public void multiplyByZero() {
        Assert.assertEquals(Integer.valueOf(0), Calculator.calculate(6, 0, '*'));
    }

    @Test
    public void divideSimpleNumbers() {
        Assert.assertEquals(Integer.valueOf(1), Calculator.calculate(7, 7, '/'));
    }

    @Test(expected = DataProcessingException.class)
    public void divideByZero() {
        Calculator.calculate(5, 0, '/');
    }

    @Test(expected = DataProcessingException.class)
    public void setNotValidSign() {
        Calculator.calculate(5, 3, 's');
    }
}
