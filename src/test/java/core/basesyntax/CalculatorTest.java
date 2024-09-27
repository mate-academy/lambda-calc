package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private final double POSITIVE_A = 4;
    private final double NEGATIVE_A = -4;
    private final double POSITIVE_B = 2.5;
    private final double NEGATIVE_B = -2.5;
    private final double ZERO = 0;
    private static Calculator calculator;

    @BeforeClass
    public static void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void additionTestOk() {
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '+');
        Assert.assertEquals(1.5, actualResult, 0);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '+');
        Assert.assertEquals(-2.5, actualResult, 0);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '+');
        Assert.assertEquals(6.5, actualResult, 0);
    }

    @Test
    public void subtractionTestOk() {
        double actualResult = calculator.calculate(NEGATIVE_A, NEGATIVE_B, '-');
        Assert.assertEquals(-1.5, actualResult, 0);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '-');
        Assert.assertEquals(2.5, actualResult, 0);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '-');
        Assert.assertEquals(1.5, actualResult, 0);
    }

    @Test
    public void multiplyTestOk() {
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '*');
        Assert.assertEquals(-10, actualResult, 0);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '*');
        Assert.assertEquals(0, actualResult, 0);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '*');
        Assert.assertEquals(10, actualResult, 0);
    }

    @Test
    public void divisionTestOk() {
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '/');
        Assert.assertEquals(-1.6, actualResult, 0);
        actualResult = calculator.calculate(ZERO, NEGATIVE_B, '/');
        Assert.assertEquals(0, actualResult, 0);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '/');
        Assert.assertEquals(1.6, actualResult, 0);
    }

    @Test
    public void powerTestOk() {
        double actualResult = calculator.calculate(POSITIVE_A, NEGATIVE_B, '^');
        Assert.assertEquals(0.03125, actualResult, 0);
        actualResult = calculator.calculate(NEGATIVE_B, ZERO, '^');
        Assert.assertEquals(1, actualResult, 0);
        actualResult = calculator.calculate(POSITIVE_A, POSITIVE_B, '^');
        Assert.assertEquals(32, actualResult, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(POSITIVE_A, ZERO, '/');
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSignIsOk() {
        calculator.calculate(POSITIVE_A, ZERO, ':');
    }
}
