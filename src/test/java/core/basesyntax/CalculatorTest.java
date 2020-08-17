package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    private static final Double DELTA = 0.0001;

    @Test
    public void addNegativeNumberOk() {
        double calculated = calculator.calculate(10.0, -5.0, '+');
        Assert.assertEquals(5.0, calculated, DELTA);
    }

    @Test

    public void multiNegativeNumberOk() {
        double calculated = calculator.calculate(10.0, -5.0, '*');
        Assert.assertEquals(-50.0, calculated, DELTA);
    }

    @Test
    public void subNegativeNumberOk() {
        double calculated = calculator.calculate(10.0, -5.0, '-');
        Assert.assertEquals(15, calculated, DELTA);
    }

    @Test
    public void divNegativeNumberOk() {
        double calculated = calculator.calculate(15.0, -5.0, '/');
        Assert.assertEquals(-3.0, calculated, DELTA);
    }

    @Test
    public void powNegativeNumberOk() {
        double calculated = calculator.calculate(10.0, -3.0, '^');
        Assert.assertEquals(0.001, calculated, DELTA);
    }

    @Test
    public void addPositiveNumberOk() {
        double calculated = calculator.calculate(10.0, 5.0, '+');
        Assert.assertEquals(15.0, calculated, DELTA);
    }

    @Test

    public void multPositiveNumberOk() {
        double calculated = calculator.calculate(10.0, 5.0, '*');
        Assert.assertEquals(50.0, calculated, DELTA);
    }

    @Test
    public void subPositiveNumberOk() {
        double calculated = calculator.calculate(10.0, 5.0, '-');
        Assert.assertEquals(5.0, calculated, DELTA);
    }

    @Test
    public void divPositiveNumberOk() {
        double calculated = calculator.calculate(15.0, 5.0, '/');
        Assert.assertEquals(3.0, calculated, DELTA);
    }

    @Test
    public void powPositiveNumberOk() {
        double calculated = calculator.calculate(5.0, 2.0, '^');
        Assert.assertEquals(25.0, calculated, DELTA);
    }

    @Test
    public void powByZeroOk() {
        double calculated = calculator.calculate(5.0, 0.0, '^');
        Assert.assertEquals(1.0, calculated, DELTA);
    }

    @Test
    public void divisionByZero() {
        double actualResult = calculator.calculate(5.0, 0.0, '/');
        Assert.assertEquals(Double.POSITIVE_INFINITY, actualResult, DELTA);
    }

    @Test
    public void calculateByWrongOperator() {
        try {
            calculator.calculate(10.0, 20.0, '@');
        } catch (Exception e) {
            return;
        }
        Assert.fail();
    }

    @Test(expected = NullPointerException.class)
    public void calculateWithNullParameters() {
        calculator.calculate(null, null, '+');
    }

    @Test(expected = NullPointerException.class)
    public void calculateWithNullOperator() {
        calculator.calculate(5.0, 5.0, null);
    }

    @Test
    public void calculateWithValidParameter() {
        double calculate = calculator
                .calculate(9.8, 66.5, '*');
        Assert.assertTrue(Double.MIN_VALUE < calculate && Double.MAX_VALUE > calculate);
    }
}
