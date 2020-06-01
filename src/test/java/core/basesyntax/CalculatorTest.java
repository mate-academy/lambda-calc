package core.basesyntax;

import java.util.Random;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private static Random rn;
    private static Calculator calculator;

    @BeforeClass
    public static void before() {
        calculator = new Calculator();
        rn = new Random();
    }

    @Test
    public void addingTest() {
        int a = rn.nextInt(), b = rn.nextInt();
        Assert.assertEquals( (a + b) + " was expected" ,
                a + b, calculator.calculate(a , b, '+'));
    }

    @Test
    public void subtractionTest() {
        int a = rn.nextInt(), b = rn.nextInt();
        Assert.assertEquals( (a - b) + " was expected" ,
                a - b, calculator.calculate(a , b, '-'));
    }

    @Test
    public void multiplicationTest() {
        int a = rn.nextInt(), b = rn.nextInt();
        Assert.assertEquals( (a * b) + " was expected" ,
                a * b, calculator.calculate(a , b, '*'));
    }

    @Test
    public void divisionTest() {
        int a = rn.nextInt(), b = rn.nextInt();
        Assert.assertEquals( (a / b) + " was expected" ,
                a / b, calculator.calculate(a , b, '/'));
    }

    @Test
    public void exponentiationTest() {
        int a = rn.nextInt(), b = rn.nextInt();
        Assert.assertEquals( (a + b) + " was expected" ,
                a + b, calculator.calculate(a , b, '+'));
    }
}