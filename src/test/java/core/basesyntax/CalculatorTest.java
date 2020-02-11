package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private static final double DELTA = 0.001;

    @Test
    public void addition() {
        double expectedResult1 = 7;
        double expectedResult2 = -16;
        double expectedResult3 = 0;
        Assert.assertEquals(expectedResult1, calculator.calculate('+', 3, 4), DELTA);
        Assert.assertEquals(expectedResult2, calculator.calculate('+', -16, 0), DELTA);
        Assert.assertEquals(expectedResult3, calculator.calculate('+', 10, -10), DELTA);
    }

    @Test
    public void subtraction() {
        double expectedResult1 = 25;
        double expectedResult2 = -11;
        double expectedResult3 = 55;
        Assert.assertEquals(expectedResult1, calculator.calculate('-', 32, 7), DELTA);
        Assert.assertEquals(expectedResult2, calculator.calculate('-', 10, 21), DELTA);
        Assert.assertEquals(expectedResult3, calculator.calculate('-', -75, -130), DELTA);
    }

    @Test
    public void multiplication() {
        double expectedResult1 = 56;
        double expectedResult3 = 0;
        Assert.assertEquals(expectedResult1, calculator.calculate('*', 7, 8), DELTA);
        Assert.assertEquals(expectedResult1, calculator.calculate('*', 8, 7), DELTA);
        Assert.assertEquals(expectedResult3, calculator.calculate('*', 0, 565675675), DELTA);
    }

    @Test
    public void division() {
        double expectedResult1 = 3.333;
        double expectedResult2 = 0;
        double expectedResult3 = 1;
        Assert.assertEquals(expectedResult1, calculator.calculate('/', 10, 3), DELTA);
        Assert.assertEquals(expectedResult2, calculator.calculate('/', 0, 5), DELTA);
        Assert.assertEquals(expectedResult3, calculator.calculate('/', 25, 25), DELTA);
    }

    @Test
    public void power() {
        double expectedResult1 = 1000;
        double expectedResult2 = 0;
        double expectedResult3 = -27;
        double expectedResult4 = 0.037;
        Assert.assertEquals(expectedResult1, calculator.calculate('^', 10, 3),  DELTA);
        Assert.assertEquals(expectedResult2, calculator.calculate('^', 0, 5), DELTA);
        Assert.assertEquals(expectedResult3, calculator.calculate('^', -3, 3), DELTA);
        Assert.assertEquals(expectedResult4, calculator.calculate('^', 3, -3), DELTA);
    }

    @Test
    public void powerWithZero() {
        double expectedResult = 1;
        Assert.assertEquals(expectedResult, calculator.calculate('^', 3, 0), DELTA);
        Assert.assertEquals(expectedResult, calculator.calculate('^', 0, 0), DELTA);
        Assert.assertEquals(expectedResult, calculator.calculate('^', -15, 0), DELTA);
    }

    @Test
    public void divideByZero() {
        Assert.assertEquals(Double.NaN, calculator.calculate('/', 0, 0),DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectInputOperation() {
        calculator.calculate('k', 65, 32);
    }
}
