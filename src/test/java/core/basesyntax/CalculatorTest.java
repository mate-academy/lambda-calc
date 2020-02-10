package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private static final Double DELTA = 0.0001;

    @Test
    public void addNegativeNumberOk() {
        double calculated = Calculator.calculate(10.0, -5.0, '+');
        Assert.assertEquals(5.0, calculated, DELTA);
    }

    @Test

    public void multiNegativeNumberOk() {
        double calculated = Calculator.calculate(10.0, -5.0, '*');
        Assert.assertEquals(-50.0, calculated, DELTA);
    }

    @Test
    public void subNegativeNumberOk() {
        double calculated = Calculator.calculate(10.0, -5.0, '-');
        Assert.assertEquals(15, calculated, DELTA);
    }

    @Test
    public void divNegativeNumberOk() {
        double calculated = Calculator.calculate(15.0, -5.0, '/');
        Assert.assertEquals(-3.0, calculated, DELTA);
    }

    @Test
    public void powNegativeNumberOk() {
        double calculated = Calculator.calculate(10.0, -3.0, '^');
        Assert.assertEquals(0.001, calculated, DELTA);
    }

    @Test
    public void addPositiveNumberOk() {
        double calculated = Calculator.calculate(10.0, 5.0, '+');
        Assert.assertEquals(15.0, calculated, DELTA);
    }

    @Test
    public void multPositiveNumberOk() {
        double calculated = Calculator.calculate(10.0, 5.0, '*');
        Assert.assertEquals(50.0, calculated, DELTA);
    }

    @Test
    public void subPositiveNumberOk() {
        double calculated = Calculator.calculate(10.0, 5.0, '-');
        Assert.assertEquals(5.0, calculated, DELTA);
    }

    @Test
    public void divPositiveNumberOk() {
        double calculated = Calculator.calculate(15.0, 5.0, '/');
        Assert.assertEquals(3.0, calculated, DELTA);
    }

    @Test
    public void powPositiveNumberOk() {
        double calculated = Calculator.calculate(5.0, 2.0, '^');
        Assert.assertEquals(25.0, calculated, DELTA);
    }

    @Test
    public void powByZeroOk() {
        double calculated = Calculator.calculate(5.0, 0.0, '^');
        Assert.assertEquals(1.0, calculated, DELTA);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void divisionByZero() {
        Calculator.calculate(15.0, 0.0, '/');
    }

    @Test
    public void calculateByWrongOperator() {
        try {
            Calculator.calculate(10.0, 20.0, '@');
        } catch (Exception e) {
            return;
        }
        Assert.fail();
    }

    @Test(expected = NullPointerException.class)
    public void calculateWithNullParameters() {
        Calculator.calculate(null, null, '+');
    }

    @Test(expected = NullPointerException.class)
    public void calculateWithNullOperator() {
        Calculator.calculate(5.0, 5.0, null);
    }

    @Test
    public void calculateWithValidParameter() {
        double calculate = Calculator
                .calculate(9.8, 66.5, '*');
        Assert.assertTrue(Double.MIN_VALUE < calculate && Double.MAX_VALUE > calculate);
    }
}
