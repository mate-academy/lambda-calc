package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addition() {
        int expectedResult1 = 7;
        int expectedResult2 = -16;
        int expectedResult3 = 0;
        Assert.assertEquals(expectedResult1, Calculator.calculate('+', 3, 4));
        Assert.assertEquals(expectedResult2, Calculator.calculate('+', -16, 0));
        Assert.assertEquals(expectedResult3, Calculator.calculate('+', 10, -10));
    }

    @Test
    public void subtraction() {
        int expectedResult1 = 25;
        int expectedResult2 = -11;
        int expectedResult3 = 55;
        Assert.assertEquals(expectedResult1, Calculator.calculate('-', 32, 7));
        Assert.assertEquals(expectedResult2, Calculator.calculate('-', 10, 21));
        Assert.assertEquals(expectedResult3, Calculator.calculate('-', -75, -130));
    }

    @Test
    public void multiplication() {
        int expectedResult1 = 56;
        int expectedResult3 = 0;
        Assert.assertEquals(expectedResult1, Calculator.calculate('*', 7, 8));
        Assert.assertEquals(expectedResult1, Calculator.calculate('*', 8, 7));
        Assert.assertEquals(expectedResult3, Calculator.calculate('*', 0, 565675675));
    }

    @Test
    public void division() {
        int expectedResult1 = 3;
        int expectedResult2 = 0;
        int expectedResult3 = 1;
        Assert.assertEquals(expectedResult1, Calculator.calculate('/', 10, 3));
        Assert.assertEquals(expectedResult2, Calculator.calculate('/', 0, 5));
        Assert.assertEquals(expectedResult3, Calculator.calculate('/', 25, 25));
    }

    @Test
    public void power() {
        int expectedResult1 = 1000;
        int expectedResult2 = 0;
        int expectedResult3 = -27;
        Assert.assertEquals(expectedResult1, Calculator.calculate('^', 10, 3));
        Assert.assertEquals(expectedResult2, Calculator.calculate('^', 0, 5));
        Assert.assertEquals(expectedResult3, Calculator.calculate('^', -3, 3));
    }

    @Test
    public void powerWithZero() {
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, Calculator.calculate('^', 3, 0));
        Assert.assertEquals(expectedResult, Calculator.calculate('^', 0, 0));
        Assert.assertEquals(expectedResult, Calculator.calculate('^', -15, 0));
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        Calculator.calculate('/', 0, 0);
    }

    @Test(expected = NullPointerException.class)
    public void incorrectInputOperation() {
        Calculator.calculate('k', 65, 32);
    }
}