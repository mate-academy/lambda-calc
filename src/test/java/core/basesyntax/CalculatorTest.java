package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void additionNegativeOk() {
        double calculated = Calculator.calculate(10.0, -5.0, '+');
        Assert.assertEquals(5.0, calculated, 0.0001);
    }

    @Test

    public void multiplicationNegativeOk() {
        double calculated = Calculator.calculate(10.0, -5.0, '*');
        Assert.assertEquals(-50.0, calculated, 0.0001);
    }

    @Test
    public void subtractionNegativeOk() {
        double calculated = Calculator.calculate(10.0, -5.0, '-');
        Assert.assertEquals(15, calculated, 0.0001);
    }

    @Test
    public void divisionNegativeOk() {
        double calculated = Calculator.calculate(15.0, -5.0, '/');
        Assert.assertEquals(-3.0, calculated, 0.0001);
    }

    @Test
    public void powerNegativeOk() {
        double calculated = Calculator.calculate(10.0, -3.0, '^');
        Assert.assertEquals(0.001, calculated, 0.0001);
    }

    @Test
    public void additionOk() {
        double calculated = Calculator.calculate(10.0, 5.0, '+');
        Assert.assertEquals(15.0, calculated, 0.0001);
    }

    @Test

    public void multiplicationOk() {
        double calculated = Calculator.calculate(10.0, 5.0, '*');
        Assert.assertEquals(50.0, calculated, 0.0001);
    }

    @Test
    public void subtractionOk() {
        double calculated = Calculator.calculate(10.0, 5.0, '-');
        Assert.assertEquals(5.0, calculated, 0.0001);
    }

    @Test
    public void divisionOk() {
        double calculated = Calculator.calculate(15.0, 5.0, '/');
        Assert.assertEquals(3.0, calculated, 0.0001);
    }

    @Test
    public void powerOk() {
        double calculated = Calculator.calculate(5.0, 2.0, '^');
        Assert.assertEquals(25.0, calculated, 0.0001);
    }

    @Test
    public void divisionByZero() {
        try {
            Calculator.calculate(15.0, 0.0, '/');
        } catch (ArithmeticException e) {
            Assert.fail();
        }
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

    @Test
    public void calculateWithNullParameters() {
        try {
            Calculator.calculate(null, null, '+');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void calculateWithNullOperator() {
        try {
            Calculator.calculate(5.0, 5.0, null);
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void calculateAboveNumberLimitResult() {
        double maxDoubleValue = 1.7976931348623157E308;
        Assert.assertTrue(maxDoubleValue > Calculator
                .calculate(99999999999.9, 666666666666666.6, '*'));
    }

    @Test
    public void calculateWithValidParameter() {
        double calculate = Calculator
                .calculate(9.8, 66.5, '*');
        double minDoubleValue = -1.7976931348623157E30;
        double maxDoubleValue = 1.7976931348623157E308;
        Assert.assertTrue(maxDoubleValue > calculate && minDoubleValue < calculate);
    }
}
