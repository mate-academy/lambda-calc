package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double POSITIVE_A = 15.0;
    private static final double POSITIVE_B = 3.0;
    private static final double NEGATIVE_A = -15.0;
    private static final double NEGATIVE_B = -3.0;
    private static final double ZERO = 0;
    private static final double DELTA = 1e-10;
    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test
    public void additionOk() {
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '+');
        Assert.assertEquals(18.0, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '+');
        Assert.assertEquals(-18.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, NEGATIVE_A, '+');
        Assert.assertEquals(0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, ZERO, '+');
        Assert.assertEquals(POSITIVE_A, actual, DELTA);
    }

    @Test
    public void additionIsNotOk() {
        double actual = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '+');
        Assert.assertNotEquals(-12.0, actual, DELTA);
    }

    @Test
    public void subtractionOk() {
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '-');
        Assert.assertEquals(12.0, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '-');
        Assert.assertEquals(-12.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, NEGATIVE_A, '-');
        Assert.assertEquals(30.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, ZERO, '-');
        Assert.assertEquals(POSITIVE_A, actual, DELTA);
    }

    @Test
    public void subtractionIsNotOk() {
        double actual = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '-');
        Assert.assertNotEquals(-18.0, actual, DELTA);
    }

    @Test
    public void multiplicationOk() {
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '*');
        Assert.assertEquals(45.0, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '*');
        Assert.assertEquals(45.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, NEGATIVE_A, '*');
        Assert.assertEquals(-225.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, ZERO, '*');
        Assert.assertEquals(ZERO, actual, DELTA);
    }

    @Test
    public void multiplicationInNotOk() {
        double actual = calculator.calculate(POSITIVE_A, NEGATIVE_A, '*');
        Assert.assertNotEquals(225.0, actual, DELTA);
    }

    @Test
    public void divisionOk() {
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '/');
        Assert.assertEquals(5.0, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '/');
        Assert.assertEquals(5.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, NEGATIVE_A, '/');
        Assert.assertEquals(-1.0, actual, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(POSITIVE_A, ZERO, '/');
    }

    @Test
    public void powerOk() {
        double actual = calculator.calculate(POSITIVE_A, POSITIVE_B, '^');
        Assert.assertEquals(3375.0, actual, DELTA);
        actual = calculator.calculate(NEGATIVE_A, POSITIVE_B, '^');
        Assert.assertEquals(-3375.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, ZERO, '^');
        Assert.assertEquals(1.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, 1, '^');
        Assert.assertEquals(POSITIVE_A, actual, DELTA);
    }

    @Test
    public void powerIsNotOk() {
        double actual = calculator.calculate(POSITIVE_A, ZERO, '^');
        Assert.assertNotEquals(POSITIVE_A, actual, DELTA);
        actual = calculator.calculate(POSITIVE_A, 1, '^');
        Assert.assertNotEquals(0, actual, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgument() {
        calculator.calculate(POSITIVE_A, POSITIVE_B, '%');
    }
}
