package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
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

    @Test
    public void normalSubtraction() {
        result = calculator.calculate(10, 6.2, '-');
        Assert.assertEquals(3.8, result, DELTA);
    }

    @Test
    public void subtractionWithFirstNegative() {
        result = calculator.calculate(-10, 6.2, '-');
        Assert.assertEquals(-16.2, result, DELTA);
    }

    @Test
    public void subtractionWithSecondNegative() {
        result = calculator.calculate(10, -6.2, '-');
        Assert.assertEquals(16.2, result, DELTA);
    }

    @Test
    public void subtractionWithFirstZero() {
        result = calculator.calculate(0, 6.2, '-');
        Assert.assertEquals(-6.2, result, DELTA);
    }

    @Test
    public void subtractionWithSecondZero() {
        result = calculator.calculate(10, 0, '-');
        Assert.assertEquals(10, result, DELTA);
    }

    @Test
    public void subtractionWithBothZero() {
        result = calculator.calculate(0, 0, '-');
        Assert.assertEquals(0, result, DELTA);
    }
}