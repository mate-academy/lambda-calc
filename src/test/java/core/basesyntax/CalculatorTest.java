package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';
    private static final double DELTA = 0.01;
    private static Calculator calculator;
    private static double result;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveValuesTest() {
        result = calculator.calculate(2.2, 1.1, ADDITION);
        Assert.assertEquals(3.3, result, DELTA);
    }

    @Test
    public void additionNegativeValuesTest() {
        result = calculator.calculate(-2.2, -1.1, ADDITION);
        Assert.assertEquals(-3.3, result, DELTA);
    }

    @Test
    public void additionZeroValuesTest() {
        result = calculator.calculate(0, 0, ADDITION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void additionMixedValuesTest() {
        result = calculator.calculate(2.2, -1.1, ADDITION);
        Assert.assertEquals(1.1, result, DELTA);
        result = calculator.calculate(0, -1.1, ADDITION);
        Assert.assertEquals(-1.1, result, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void additionMaxValueTest() {
        calculator.calculate(Double.MAX_VALUE, 10, ADDITION);
    }

    @Test
    public void substractionPositiveValuesTest() {
        result = calculator.calculate(2.2, 1.1, SUBSTRACTION);
        Assert.assertEquals(1.1, result, DELTA);
    }

    @Test
    public void substractionNegativeValuesTest() {
        result = calculator.calculate(-2.2, -1.1, SUBSTRACTION);
        Assert.assertEquals(-1.1, result, DELTA);
    }

    @Test
    public void substractionZeroValuesTest() {
        result = calculator.calculate(0, 0, SUBSTRACTION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void substractionMixedValuesTest() {
        result = calculator.calculate(1.1, -2.2, SUBSTRACTION);
        Assert.assertEquals(3.3, result, DELTA);
        result = calculator.calculate(0, -1.1, SUBSTRACTION);
        Assert.assertEquals(1.1, result, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void substractionMaxValueTest() {
        calculator.calculate(1, Double.MAX_VALUE, SUBSTRACTION);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        calculator.calculate(2.2, 0, DIVISION);
    }

    @Test
    public void divisionPositiveValuesTest() {
        result = calculator.calculate(2.2, 2, DIVISION);
        Assert.assertEquals(1.1, result, DELTA);
    }

    @Test
    public void divisionNegativeValuesTest() {
        result = calculator.calculate(-2.2, -2, DIVISION);
        Assert.assertEquals(1.1, result, DELTA);
    }

    @Test
    public void divisionZeroTest() {
        result = calculator.calculate(0, 2, DIVISION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void divisionMixedValuesTest() {
        result = calculator.calculate(0, -2, DIVISION);
        Assert.assertEquals(0, result, DELTA);
        result = calculator.calculate(2.2, -2, DIVISION);
        Assert.assertEquals(-1.1, result, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void divisionMaxValueTest() {
        calculator.calculate(Double.MAX_VALUE, 0.1, DIVISION);
    }

    @Test
    public void multiplicationPositiveValuesTest() {
        result = calculator.calculate(2.2, 2, MULTIPLICATION);
        Assert.assertEquals(4.4, result, DELTA);
    }

    @Test
    public void multiplicationNegativeValuesTest() {
        result = calculator.calculate(-2.2, -2, MULTIPLICATION);
        Assert.assertEquals(4.4, result, DELTA);
    }

    @Test
    public void multiplicationZeroValuesTest() {
        result = calculator.calculate(0, 0, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void multiplicationMixedValuesTest() {
        result = calculator.calculate(2.2, -2, MULTIPLICATION);
        Assert.assertEquals(-4.4, result, DELTA);
        result = calculator.calculate(-2.2, 0, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void multiplicationMaxValueTest() {
        calculator.calculate(Double.MAX_VALUE, 2, MULTIPLICATION);
    }

    @Test
    public void raizingToPowerPositiveValuesTest() {
        result = calculator.calculate(2, 2, RAISING_TO_POWER);
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void raizingToPowerNegativeValuesTest() {
        result = calculator.calculate(-2, -1, RAISING_TO_POWER);
        Assert.assertEquals(-0.5, result, DELTA);
    }

    @Test
    public void raizingToPowerZeroValuesTest() {
        result = calculator.calculate(0, 0, RAISING_TO_POWER);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void raizingToPowerMixedValuesTest() {
        result = calculator.calculate(2, -2, RAISING_TO_POWER);
        Assert.assertEquals(0.25, result, DELTA);
        result = calculator.calculate(-2, 0, RAISING_TO_POWER);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void raizingToPowerMaxValueTest() {
        calculator.calculate(Double.MAX_VALUE, 2, RAISING_TO_POWER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unknownOperationTest() {
        calculator.calculate(1, 1, '=');
    }
}
