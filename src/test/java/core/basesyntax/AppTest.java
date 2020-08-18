package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    private CalculatorImpl calculator = new CalculatorImpl();

    @Test
    public void additionTest() {
        Double resAdd = calculator.addition(3.0, 3.0);
        Assert.assertTrue(resAdd == 6.0);
        Assert.assertFalse("Wrong additional result", resAdd == 7.0);
    }

    @Test
    public void additionNegativeTest() {
        Double resAdd = calculator.addition(-3.0, -3.0);
        Assert.assertTrue(resAdd == -6.0);
        Assert.assertFalse("Wrong additional result", resAdd == 6.0);
    }

    @Test
    public void removalTest() {
        Double resRem = calculator.removal(6.0, 3.0);
        Assert.assertEquals(3.0, resRem, 0.0);
        Assert.assertNotEquals("Wrong additional result", 7.0, resRem, 0.0);
    }

    @Test
    public void removalNegativeTest() {
        Assert.assertEquals(9.0, calculator.removal(6.0, -3.0), 0.0);
        //Assert.assertEquals(3.0, calculator.removal(-6.0, 3.0), 0.0);   //WTF
    }

    @Test
    public void divisionTest() {
        Double resDiv = calculator.division(6.0, 3.0);
        Assert.assertEquals(2.0, resDiv, 0.0);
        Assert.assertNotEquals("Wrong additional result", 7.0, resDiv, 0.0);
    }

    @Test
    public void divisionZeroTest() {
        Double resDiv = calculator.division(6.0, 0.0);
        Assert.assertEquals("Divide by zero gives infinity as result", true, Double.isInfinite(resDiv));
    }

    @Test
    public void multiplicationTest() {
        Double resMult = calculator.multiplication(6.0, 3.0);
        Assert.assertEquals(18.0, resMult, 0.0);
        Assert.assertNotEquals("Wrong additional result", 7.0, resMult, 0.0);
    }

    @Test
    public void multiplicationZeroTest() {
        Assert.assertEquals(0.0, calculator.multiplication(6.0, 0.0), 0.0);
        Assert.assertEquals(0.0, calculator.multiplication(0.0, 6.0), 0.0);
        Assert.assertEquals(0.0, calculator.multiplication(0.0, 0.0), 0.0);
    }

    @Test
    public void powTest() {
        Double resPow = calculator.pow(6.0, 3.0);
        Assert.assertTrue(resPow == 216.0);
        Assert.assertFalse("Wrong additional result", resPow == 218.0);
    }

    @Test(expected = NullPointerException.class)
    public void checkNullSecondArgument() {
        calculator.removal(Double.valueOf(1), null);
        Assert.fail("NullPointerException was expected");
    }
}