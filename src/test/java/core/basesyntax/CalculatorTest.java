package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.00001;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveOk() {
        double actual = calculator.calculate(12, '+', 8);
        Assert.assertEquals(20, actual, DELTA);
    }

    @Test
    public void additionNegativeOk() {
        double actual = calculator.calculate(-12, '+', -8);
        Assert.assertEquals(-20, actual, DELTA);
    }

    @Test
    public void subtractionPositiveOk() {
        double actual = calculator.calculate(12, '-', 20);
        Assert.assertEquals(-8, actual, DELTA);
    }

    @Test
    public void subtractionNegativeOk() {
        double actual = calculator.calculate(-12, '-', -20);
        Assert.assertEquals(8, actual, DELTA);
    }

    @Test
    public void divisionPositiveOk() {
        double actual = calculator.calculate(12, '/', 2);
        Assert.assertEquals(6, actual, DELTA);
    }

    @Test
    public void divisionNegativeOk() {
        double actual = calculator.calculate(12, '/', -2);
        Assert.assertEquals(-6, actual, DELTA);
    }

    @Test
    public void multiplicationNegativeOk() {
        double actual = calculator.calculate(-12, '*', 3);
        Assert.assertEquals(-36, actual, DELTA);
    }

    @Test
    public void multiplicationPositiveOk() {
        double actual = calculator.calculate(12, '*', 3);
        Assert.assertEquals(36, actual, DELTA);
    }

    @Test
    public void powerZeroOk() {
        double actual = calculator.calculate(-3, '^', 0);
        Assert.assertEquals(1, actual, DELTA);
    }

    @Test
    public void powerPositiveOk() {
        double actual = calculator.calculate(3, '^', 2);
        Assert.assertEquals(9, actual, DELTA);
    }

    @Test
    public void powerNegativeOk() {
        double actual = calculator.calculate(-3, '^', -2);
        Assert.assertEquals(0.11111, actual, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(12, '/', 0);
    }

    @Test(expected = NoSuchOperationException.class)
    public void checkMathAction() {
        calculator.calculate(12, ';', 4);
    }
}
