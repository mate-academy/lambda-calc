package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculator {
    private static final double DELTA = 0;
    private static Calculator calculator;

    @BeforeClass
    public static void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void plusPositiveNumbersValid() {
        double result = calculator.calculate(1,'+', 2);
        Assert.assertEquals(3, result, DELTA);
    }

    @Test
    public void plusPositiveNumbersNotValid() {
        double result = calculator.calculate(1,'+', 2);
        Assert.assertNotEquals(4, result, DELTA);
    }

    @Test
    public void plusNegativeNumbersValid() {
        double result = calculator.calculate(-1,'+', -2);
        Assert.assertEquals(-3, result, DELTA);
    }

    @Test
    public void plusNegativeNumbersNotValid() {
        double result = calculator.calculate(-1,'+', -2);
        Assert.assertNotEquals(-2, result, DELTA);
    }

    @Test
    public void subtractPositiveValid() {
        double result = calculator.calculate(5,'-', 2);
        Assert.assertEquals(3, result, DELTA);
    }

    @Test
    public void subtractPositiveNotValid() {
        double result = calculator.calculate(5,'-', 6);
        Assert.assertNotEquals(-2, result, DELTA);
    }

    @Test
    public void subtractNegativeValid() {
        double result = calculator.calculate(-5,'-', -6);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void subtractNegativeNotValid() {
        double result = calculator.calculate(-5,'-', -16);
        Assert.assertNotEquals(1, result, DELTA);
    }

    @Test
    public void multiplyPositiveValid() {
        double result = calculator.calculate(5,'*', 6);
        Assert.assertEquals(30, result, DELTA);
    }

    @Test
    public void multiplyPositiveNotValid() {
        double result = calculator.calculate(5,'*', 6);
        Assert.assertNotEquals(11, result, DELTA);
    }

    @Test
    public void multiplyNegativeValid() {
        double result = calculator.calculate(-5,'*', -6);
        Assert.assertEquals(30, result, DELTA);
    }

    @Test
    public void multiplyNegativeNotValid() {
        double result = calculator.calculate(-5,'*', -6);
        Assert.assertNotEquals(-30, result, DELTA);
    }

    @Test
    public void dividePositiveValid() {
        double result = calculator.calculate(6,'/', 4);
        Assert.assertEquals(1.5, result, DELTA);
    }

    @Test
    public void dividePositiveNotValid() {
        double result = calculator.calculate(10,'/', 20);
        Assert.assertNotEquals(2, result, DELTA);
    }

    @Test
    public void divideNegativeValid() {
        double result = calculator.calculate(-6,'/', -4);
        Assert.assertEquals(1.5, result, DELTA);
    }

    @Test
    public void divideNegativeNotValid() {
        double result = calculator.calculate(-6,'/', -3);
        Assert.assertNotEquals(-2, result, DELTA);
    }

    @Test
    public void divideByZero() {
        try {
            double result = calculator.calculate(6, '/', 0);
        } catch (ArithmeticException e) {
            return;
        }
        System.out.println("ArithmeticException expected");
    }

    @Test
    public void exponentPositiveValid() {
        double result = calculator.calculate(2,'^', 4);
        Assert.assertEquals(16, result, DELTA);
    }

    @Test
    public void exponentPositiveNotValid() {
        double result = calculator.calculate(2,'^', 4);
        Assert.assertNotEquals(8, result, DELTA);
    }

    @Test
    public void exponentNegativeValid() {
        double result = calculator.calculate(-2,'^', 4);
        Assert.assertEquals(16, result, DELTA);
    }

    @Test
    public void exponentNegativeNotValid() {
        double result = calculator.calculate(-2,'^', 4);
        Assert.assertNotEquals(-16, result, DELTA);
    }

    @Test
    public void exponentZeroValid() {
        double result = calculator.calculate(2,'^', 0);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void exponentZeroNotValid() {
        double result = calculator.calculate(2,'^', 0);
        Assert.assertNotEquals(2, result, DELTA);
    }
}
