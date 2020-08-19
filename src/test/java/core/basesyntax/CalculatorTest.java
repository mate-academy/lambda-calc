package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void init() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalOperationPassedAsParam() {
        calculator.calculate(1, 1, '?');

    }

    @Test
    public void additionOk() {
        int expected = 10;
        int actual = calculator.calculate(5, 5, '+');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void subtractionOk() {
        int expected = 2;
        int actual = calculator.calculate(7, 5, '-');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void divisionOk() {
        int expected = 2;
        int actual = calculator.calculate(12, 6, '/');
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class )
    public void dividendIsZero() {
        calculator.calculate(12, 0, '/');
    }

    @Test
    public void multiplicationOk() {
        int expected = 8;
        int actual = calculator.calculate(4, 2, '*');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void powOk() {
        int expected = 16;
        int actual = calculator.calculate(4, 2, '^');
        Assert.assertEquals(expected, actual);
    }

}
