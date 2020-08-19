package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-10;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER_RAISING = '^';
    private static Calculator calculator;
    private static double result;

    @BeforeClass
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalActionTest() {
        result = calculator.calculate(2, 2, '?');
    }

    @Test
    public void additionIsOkTest() {
        result = calculator.calculate(3, 1, ADDITION);
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(-3, 2, ADDITION);
        Assert.assertEquals(-1, result, DELTA);
        result = calculator.calculate(0, 0, ADDITION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void subtractionIsOkTest() {
        result = calculator.calculate(25, 20, SUBTRACTION);
        Assert.assertEquals(5, result, DELTA);
        result = calculator.calculate(-15, 5, SUBTRACTION);
        Assert.assertEquals(-20, result, DELTA);
        result = calculator.calculate(0, 0, SUBTRACTION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void divisionIsOkTest() {
        result = calculator.calculate(25, 2, DIVISION);
        Assert.assertEquals(12.5, result, DELTA);
        result = calculator.calculate(-100, 5, DIVISION);
        Assert.assertEquals(-20, result, DELTA);
        result = calculator.calculate(-1, -1, DIVISION);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        result = calculator.calculate(1, 0, DIVISION);
    }

    @Test
    public void multiplicationIsOkTest() {
        result = calculator.calculate(2, 2, MULTIPLICATION);
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(-2, 6, MULTIPLICATION);
        Assert.assertEquals(-12, result, DELTA);
        result = calculator.calculate(-20, -2, MULTIPLICATION);
        Assert.assertEquals(40, result, DELTA);
        result = calculator.calculate(0, 0, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void powIsOkTest() {
        result = calculator.calculate(2, 2, POWER_RAISING);
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(-1, 2, POWER_RAISING);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.calculate(-1, 3, POWER_RAISING);
        Assert.assertEquals(-1, result, DELTA);
        result = calculator.calculate(2, -2, POWER_RAISING);
        Assert.assertEquals(0.25, result, DELTA);
    }
}
