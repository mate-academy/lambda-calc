package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void addCheck() {
        double firstRes = calculator.calculate(25, 10, '+');
        Assert.assertEquals(35, firstRes, DELTA);
        double secondRes = calculator.calculate(-13, 23, '+');
        Assert.assertEquals(10, secondRes, DELTA);
        double thirdRes = calculator.calculate(10, 10, '+');
        Assert.assertEquals(20, thirdRes, DELTA);
    }

    @Test
    public void subtractCheck() {
        double firstRes = calculator.calculate(25, 10, '-');
        Assert.assertEquals(15, firstRes, DELTA);
        double secondRes = calculator.calculate(-13, 23, '-');
        Assert.assertEquals(-36, secondRes, DELTA);
        double thirdRes = calculator.calculate(10, 10, '-');
        Assert.assertEquals(0, thirdRes, DELTA);
    }

    @Test
    public void multiplyCheck() {
        double firstRes = calculator.calculate(25, 10, '*');
        Assert.assertEquals(250, firstRes, DELTA);
        double secondRes = calculator.calculate(-13, 23, '*');
        Assert.assertEquals(-299, secondRes, DELTA);
        double thirdRes = calculator.calculate(10, 10, '*');
        Assert.assertEquals(100, thirdRes, DELTA);
    }

    @Test
    public void divideByZeroCheck() {
        Assert.assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(25, 0, '/'), DELTA);
        Assert.assertEquals(Double.NEGATIVE_INFINITY,
                calculator.calculate(-25, 0, '/'), DELTA);
    }

    @Test
    public void divideCheck() {
        double firstRes = calculator.calculate(25, 10, '/');
        Assert.assertEquals(2.5, firstRes, DELTA);
        double secondRes = calculator.calculate(-26, 13, '/');
        Assert.assertEquals(-2, secondRes, DELTA);
        double thirdRes = calculator.calculate(10, 10, '/');
        Assert.assertEquals(1, thirdRes, DELTA);
    }

    @Test
    public void powerCheck() {
        double firstRes = calculator.calculate(2, 3, '^');
        Assert.assertEquals(8, firstRes, DELTA);
        double secondRes = calculator.calculate(3, 3, '^');
        Assert.assertEquals(27, secondRes, DELTA);
        double thirdRes = calculator.calculate(5,2, '^');
        Assert.assertEquals(25, thirdRes, DELTA);
    }

    @Test
    public void negativePowerCheck() {
        double firstRes = calculator.calculate(10, -1 , '^');
        Assert.assertEquals(0.1, firstRes, DELTA);
        double secondRes = calculator.calculate(25, -1, '^');
        Assert.assertEquals(0.04, secondRes, DELTA);
        double thirdRes = calculator.calculate(4,-1, '^');
        Assert.assertEquals(0.25, thirdRes, DELTA);
    }
}