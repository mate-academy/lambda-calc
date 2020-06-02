package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    private static Double DELTA = 0.0;
    private CalculatorImpl calculator = new CalculatorImpl();

    @Test
    public void additionTest() {
        Assert.assertEquals(6.0, calculator.addition(3.0, 3.0), DELTA);
    }

    @Test
    public void additionNegativeTest() {
        Assert.assertEquals(-6.0, calculator.addition(-3.0, -3.0), DELTA);
    }

    @Test
    public void removalTest() {
        Double resRem = calculator.removal(6.0, 3.0);
        Assert.assertEquals(3.0, resRem, DELTA);
        Assert.assertNotEquals("Wrong additional result", 7.0, resRem, DELTA);
    }

    @Test
    public void removalNegativeTest() {
        Assert.assertEquals(9.0, calculator.removal(6.0, -3.0), DELTA);
    }

    @Test
    public void divisionTest() {
        Double resDiv = calculator.division(6.0, 3.0);
        Assert.assertEquals(2.0, resDiv, DELTA);
        Assert.assertNotEquals("Wrong additional result", 7.0, resDiv, DELTA);
    }

    @Test
    public void divisionZeroTest() {
        Double resDiv = calculator.division(6.0, 0.0);
        Assert.assertTrue("Divide by zero gives infinity as result", Double.isInfinite(resDiv));
    }

    @Test
    public void multiplicationTest() {
        Double resMult = calculator.multiplication(6.0, 3.0);
        Assert.assertEquals(18.0, resMult, DELTA);
        Assert.assertNotEquals("Wrong additional result", 7.0, resMult, DELTA);
    }

    @Test
    public void multiplicationZeroTest() {
        Assert.assertEquals(0.0, calculator.multiplication(6.0, 0.0), DELTA);
        Assert.assertEquals(0.0, calculator.multiplication(0.0, 6.0), DELTA);
        Assert.assertEquals(0.0, calculator.multiplication(0.0, 0.0), DELTA);
    }

    @Test
    public void powTest() {
        Assert.assertEquals(216.0, calculator.pow(6.0, 3.0), DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void checkNullSecondArgument() {
        calculator.removal(Double.valueOf(1), null);
        Assert.fail("NullPointerException was expected");
    }
}
