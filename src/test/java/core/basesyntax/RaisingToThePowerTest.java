package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaisingToThePowerTest {
    private static final double DELTA = 0.01D;
    private Calculator calculator;
    private double result;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void integerPower() {
        result = calculator.calculate(3.6, 2, '^');
        Assert.assertEquals(12.96, result, DELTA);
    }

    @Test
    public void doublePower() {
        result = calculator.calculate(3.6, 2.3, '^');
        Assert.assertEquals(19.0324962, result, DELTA);
    }

    @Test
    public void baseIsNegativeAndPowerIsOdd() {
        result = calculator.calculate(-3, 3, '^');
        Assert.assertEquals(-27, result, DELTA);
    }

    @Test
    public void baseIsNegativeAndPowerIsEven() {
        result = calculator.calculate(-3, 2, '^');
        Assert.assertEquals(9, result, DELTA);
    }

    @Test
    public void baseIsZero() {
        result = calculator.calculate(0, 8, '^');
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void powerIsZero() {
        result = calculator.calculate(8, 0, '^');
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void baseAndPowerAreZero() {
        result = calculator.calculate(0, 0, '^');
        Assert.assertEquals(1, result, DELTA);
    }
}