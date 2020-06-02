package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private static Calculator calculator;

    @BeforeClass
    public static void before() {
        calculator = new Calculator();
    }

    @Test
    public void addingTest() {
        int a = 5;
        int b = 3;
        Assert.assertEquals((a + b) + " was expected",
                a + b, calculator.calculate(a, b, '+'));
    }

    @Test
    public void subtractionTest() {
        int a = 2;
        int b = 5;
        Assert.assertEquals((a - b) + " was expected",
                a - b, calculator.calculate(a, b, '-'));
    }

    @Test
    public void multiplicationTest() {
        int a = 10;
        int b = 30;
        Assert.assertEquals((a * b) + " was expected",
                a * b, calculator.calculate(a, b, '*'));
    }

    @Test
    public void divisionTest() {
        int a = -4;
        int b = 2;
        Assert.assertEquals((a / b) + " was expected",
                a / b, calculator.calculate(a, b, '/'));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionForNullTest() {
        calculator.calculate(1, 0, '/');
    }

    @Test
    public void exponentiationTest() {
        int a = 3;
        int b = 2;
        Assert.assertEquals(Math.pow(a, b) + " was expected",
                (int) Math.pow(a, b), calculator.calculate(a, b, '^'));
    }

    @Test
    public void negativeExponentiationTest() {
        int a = 3;
        int b = -2;
        Assert.assertEquals(Math.pow(a, b) + " was expected",
                (int) Math.pow(a, b), calculator.calculate(a, b, '^'));
    }

    @Test
    public void nullExponentiationTest() {
        int a = 3;
        int b = 0;
        Assert.assertEquals(Math.pow(a, b) + " was expected",
                (int) Math.pow(a, b), calculator.calculate(a, b, '^'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void notMathCharTest() {
        calculator.calculate(1, 2, 'x');
    }
}
