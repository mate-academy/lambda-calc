package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.01;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER_RAISING = '^';
    private static Calculator calculator;
    private static double result;

    @BeforeClass
    public static void SetUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionIsOkTest() {
        result = calculator.calculate(2,2, ADDITION);
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(-2,2, ADDITION);
        Assert.assertEquals(0, result, DELTA);
        result = calculator.calculate(0,0, ADDITION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void subtractionIsOkTest() {
        result = calculator.calculate(10, 5, SUBTRACTION);
        Assert.assertEquals(5, result, DELTA);
        result = calculator.calculate(-5, 5, SUBTRACTION);
        Assert.assertEquals(-10, result, DELTA);
        result = calculator.calculate(100,0, SUBTRACTION);
        Assert.assertEquals(100, result, DELTA);
    }

    @Test
    public void divisionIsOkTest() {
        result = calculator.calculate(10, 5, DIVISION);
        Assert.assertEquals(2, result, DELTA);
        result = calculator.calculate(-100, 5, DIVISION);
        Assert.assertEquals(-20, result, DELTA);
        result = calculator.calculate(-10, -5, DIVISION);
        Assert.assertEquals(2, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        result = calculator.calculate(300, 0, DIVISION);
    }

    @Test
    public void multiplicationIsOkTest() {
        result = calculator.calculate(150, 2, MULTIPLICATION);
        Assert.assertEquals(300, result, DELTA);
        result = calculator.calculate(-150, 2, MULTIPLICATION);
        Assert.assertEquals(-300, result, DELTA);
        result = calculator.calculate(-150, -2, MULTIPLICATION);
        Assert.assertEquals(300, result, DELTA);
        result = calculator.calculate(150, 0, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void powIsOkTest() {
        result = calculator.calculate(2, 2, POWER_RAISING);
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(-2, 2, POWER_RAISING);
        Assert.assertEquals(4, result, DELTA);
        result = calculator.calculate(-2, 3, POWER_RAISING);
        Assert.assertEquals(-8, result, DELTA);
        result = calculator.calculate(2, -2, POWER_RAISING);
        Assert.assertEquals(0.25, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalActionTest() {
        result = calculator.calculate(300, 0, 'a');
    }


}