package core.basesyntax;

import java.util.Random;
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
        int a = 5, b = 3;
        Assert.assertEquals( (a + b) + " was expected" ,
                a + b, calculator.calculate(a , b, '+'));
    }

    @Test
    public void subtractionTest() {
        int a = 2, b = 5;
        Assert.assertEquals( (a - b) + " was expected" ,
                a - b, calculator.calculate(a , b, '-'));
    }

    @Test
    public void multiplicationTest() {
        int a = 10, b = 30;
        Assert.assertEquals( (a * b) + " was expected" ,
                a * b, calculator.calculate(a , b, '*'));
    }

    @Test
    public void divisionTest() {
        int a = -4, b = 2;
        Assert.assertEquals( (a / b) + " was expected" ,
                a / b, calculator.calculate(a , b, '/'));
    }

    @Test
    public void nullDivisionTest() {
        try {
            calculator.calculate(1 , 0 , '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException expexted");
    }

    @Test
    public void exponentiationTest() {
        int a = 3, b = 2;
        Assert.assertEquals( Math.pow(a, b) + " was expected" ,
                (int) Math.pow(a, b), calculator.calculate(a , b, '^'));
    }

    @Test
    public void negativeExponentiationTest() {
        int a = 3, b = -2;
        Assert.assertEquals( Math.pow(a, b) + " was expected" ,
                (int) Math.pow(a, b), calculator.calculate(a , b, '^'));
    }

    public void notMathCharTest() {
        try {
            calculator.calculate(1 , 2 , 'x');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException expexted");
    }
}