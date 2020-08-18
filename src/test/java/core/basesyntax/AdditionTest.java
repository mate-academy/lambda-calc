package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionTest {
    private static final double DELTA = 0D;
    private Calculator calculator;
    private double result;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void normalAdditionTest() {
        result = calculator.calculate(5.2, 5.8, '+');
        Assert.assertEquals(11, result, DELTA);
    }

    @Test
    public void negativeAdditionTest() {
        result = calculator.calculate(-5.2, -5.8, '+');
        Assert.assertEquals(-11, result, DELTA);
    }

    @Test
    public void negativeAndPositiveAdditionTest() {
        result = calculator.calculate(-5.2, 5.8, '+');
        Assert.assertEquals(0.6, result, DELTA);
    }

    @Test
    public void additionWithOneZero() {
        result = calculator.calculate(0, 5.8, '+');
        Assert.assertEquals(5.8, result, DELTA);
    }

    @Test
    public void additionWithBothZero() {
        result = calculator.calculate(0, 0, '+');
        Assert.assertEquals(0, result, DELTA);
    }
}