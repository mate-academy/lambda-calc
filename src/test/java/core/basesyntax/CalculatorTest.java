package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final int DELTA = 0;
    private final double POSITIVE_A = 4;
    private final double NEGATIVE_A = -4;
    private final double POSITIVE_B = 2.5;
    private final double NEGATIVE_B = -2.5;
    private final double ZERO = 0;

    @Test
    public void additionTestOk() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '+');
        Assert.assertEquals(1.5, actualResult, DELTA);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '+');
        Assert.assertEquals(-2.5, actualResult, DELTA);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '+');
        Assert.assertEquals(6.5, actualResult, DELTA);
    }

    @Test
    public void subtractioinTestOk() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '-');
        Assert.assertEquals(-1.5, actualResult, DELTA);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '-');
        Assert.assertEquals(2.5, actualResult, DELTA);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '-');
        Assert.assertEquals(1.5, actualResult, DELTA);
    }

    @Test
    public void multiplyTestOk() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '*');
        Assert.assertEquals(-10, actualResult, DELTA);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '*');
        Assert.assertEquals(0, actualResult, DELTA);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '*');
        Assert.assertEquals(10, actualResult, DELTA);
    }

    @Test
    public void divisionTestOk() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '/');
        Assert.assertEquals(-1.6, actualResult, DELTA);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '/');
        Assert.assertEquals(0, actualResult, DELTA);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '/');
        Assert.assertEquals(1.6, actualResult, DELTA);
    }

    @Test
    public void powerTestOk() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '^');
        Assert.assertEquals(0.03125, actualResult, DELTA);
        actualResult = calculator.calculate(NEGATIVE_B, ZERO, '^');
        Assert.assertEquals(1, actualResult, DELTA);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '^');
        Assert.assertEquals(32, actualResult, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionByZero() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculate(POSITIVE_A, ZERO, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSignIsOk() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculate(POSITIVE_A, ZERO, ':');
    }
}
