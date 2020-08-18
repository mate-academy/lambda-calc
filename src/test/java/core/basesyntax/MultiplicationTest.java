package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiplicationTest {
    private static final double DELTA = 0.01D;
    private Calculator calculator;
    private double result;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void normalMultiplication() {
        result = calculator.calculate(2.2, 5.5, '*');
        Assert.assertEquals(12.1, result, DELTA);
    }

    @Test
    public void bothNegativeMultiplication() {
        result = calculator.calculate(-2.2, -5.5, '*');
        Assert.assertEquals(12.1, result, DELTA);
    }

    @Test
    public void firstNegativeMultiplication() {
        result = calculator.calculate(-2.2, 5.5, '*');
        Assert.assertEquals(-12.1, result, DELTA);
    }

    @Test
    public void secondNegativeMultiplication() {
        result = calculator.calculate(2.2, -5.5, '*');
        Assert.assertEquals(-12.1, result, DELTA);
    }

    @Test
    public void bothZeroMultiplication() {
        result = calculator.calculate(0, 0, '*');
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void firstZeroMultiplication() {
        result = calculator.calculate(0, 5.5, '*');
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void secondZeroMultiplication() {
        result = calculator.calculate(2.2, 0, '*');
        Assert.assertEquals(0, result, DELTA);
    }
}