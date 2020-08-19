package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculator {
    private static final double DELTA = 1e-10;
    private static final char ADDITION = '+';
    private static final char MINUS = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(DIVISION, 15, 0);
    }

    @Test
    public void additionTest() {
        Assert.assertEquals(8.0, calculator.calculate(ADDITION, 3.0, 5.0), DELTA);
        Assert.assertEquals(22.978, calculator.calculate(ADDITION, 19.458, 3.52), DELTA);
        Assert.assertEquals(0, calculator.calculate(ADDITION, 0, 0), DELTA);
        Assert.assertEquals(4.4, calculator.calculate(ADDITION, -5.6, 10.0), DELTA);
        Assert.assertEquals(-23.8, calculator.calculate(ADDITION, -15.2, -8.6), DELTA);
        Assert.assertEquals(8.2, calculator.calculate(ADDITION, 128.25, -120.05), DELTA);
    }

    @Test
    public void subtractionTest() {
        Assert.assertEquals(3, calculator.calculate(MINUS, 13, 10.0), DELTA);
        Assert.assertEquals(4.4, calculator.calculate(MINUS, 4.4, 0), DELTA);
        Assert.assertEquals(0, calculator.calculate(MINUS, 0, 0), DELTA);
        Assert.assertEquals(1, calculator.calculate(MINUS, -5, -6.0), DELTA);
        Assert.assertEquals(-2.2, calculator.calculate(MINUS, 4.4, 6.6), DELTA);
        Assert.assertEquals(-236.85, calculator.calculate(MINUS, -180.31, 56.54), DELTA);
    }

    @Test
    public void multiplicationTest() {
        Assert.assertEquals(11.5, calculator.calculate(MULTIPLICATION, 5, 2.3), DELTA);
        Assert.assertEquals(0, calculator.calculate(MULTIPLICATION, 3, 0), DELTA);
        Assert.assertEquals(654.9212, calculator.calculate(MULTIPLICATION, 52.31, 12.52), DELTA);
        Assert.assertEquals(30, calculator.calculate(MULTIPLICATION, -5, -6.0), DELTA);
        Assert.assertEquals(-15.18, calculator.calculate(MULTIPLICATION, -2.3, 6.6), DELTA);
        Assert.assertEquals(0, calculator.calculate(MULTIPLICATION, -180.31, 0), DELTA);
    }

    @Test
    public void divisionTest() {
        Assert.assertEquals(-5, calculator.calculate(DIVISION, 30, -6.0), DELTA);
        Assert.assertEquals(5.25, calculator.calculate(DIVISION, 10.5, 2), DELTA);
        Assert.assertEquals(-0.7858823529411765, calculator.calculate(DIVISION, -6.68, 8.5), DELTA);
        Assert.assertEquals(-0.34848484848484845, calculator.calculate(DIVISION, -2.3, 6.6), DELTA);
        Assert.assertEquals(0, calculator.calculate(DIVISION, 0, 5.5), DELTA);
    }

    @Test
    public void exponentiationTest() {
        Assert.assertEquals(4.0, calculator.calculate(POWER, 2, 2), DELTA);
        Assert.assertEquals(1.3160740129524924, calculator.calculate(POWER, 3, 0.25), DELTA);
        Assert.assertEquals(-5507.317759999998, calculator.calculate(POWER, -5.6, 5), DELTA);
        Assert.assertEquals(1.0, calculator.calculate(POWER, 2, 0), DELTA);
        Assert.assertEquals(0.0, calculator.calculate(POWER, 0, 2), DELTA);
        Assert.assertEquals(0.04, calculator.calculate(POWER, -5, -2), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperationTest() {
        calculator.calculate('%', 2, 50);
    }
}
