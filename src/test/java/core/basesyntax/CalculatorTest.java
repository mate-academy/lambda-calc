package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void sumWholeNumbers() {
        double calculateFirstBigger = calculator.calculate('+', 5, 4);
        Assert.assertEquals(9, calculateFirstBigger, 0);
        double calculateSecondBigger = calculator.calculate('+', 10, 15);
        Assert.assertEquals(25, calculateSecondBigger, 0);
        double calculateEquals = calculator.calculate('+', 10, 10);
        Assert.assertEquals(20, calculateEquals, 0);
    }

    @Test
    public void minusWholeNumbers() {
        double calculateFirstBigger = calculator.calculate('-', 5, 4);
        Assert.assertEquals(1, calculateFirstBigger, 0);
        double calculateSecondBigger = calculator.calculate('-', 10, 15);
        Assert.assertEquals(-5, calculateSecondBigger, 0);
        double calculateEquals = calculator.calculate('-', 10, 10);
        Assert.assertEquals(0, calculateEquals, 0);
    }

    @Test
    public void divideWholeNumbers() {
        double calculateFirstBigger = calculator.calculate('/', 5, 4);
        Assert.assertEquals(1.25, calculateFirstBigger, 0);
        double calculateSecondBigger = calculator.calculate('/', 10, 15);
        Assert.assertEquals(0.6666666666666666, calculateSecondBigger, 0);
        double calculateEquals = calculator.calculate('/', 10, 10);
        Assert.assertEquals(1, calculateEquals, 0);
    }

    @Test
    public void multiplyWholeNumbers() {
        double calculateFirstBigger = calculator.calculate('*', 5, 4);
        Assert.assertEquals(20, calculateFirstBigger, 0);
        double calculateSecondBigger = calculator.calculate('*', 10, 15);
        Assert.assertEquals(150, calculateSecondBigger, 0);
        double calculateEquals = calculator.calculate('*', 10, 10);
        Assert.assertEquals(100, calculateEquals, 0);
    }

    @Test
    public void powWholeNumbers() {
        double calculateFirstBigger = calculator.calculate('^', 5, 4);
        Assert.assertEquals(625, calculateFirstBigger, 0);
        double calculateSecondBigger = calculator.calculate('^', 10, 15);
        Assert.assertEquals(1_000_000_000_000_000D, calculateSecondBigger, 0);
        double calculateEquals = calculator.calculate('^', 10, 10);
        Assert.assertEquals(10_000_000_000D, calculateEquals, 0);
    }

    @Test
    public void sumDecimalNumbers() {
        double calculateFirstBigger = calculator.calculate('+', 5.5, 4.2);
        Assert.assertEquals(9.7, calculateFirstBigger, 0);
        double calculateSecondBigger = calculator.calculate('+', 10.5, 15.2);
        Assert.assertEquals(25.7, calculateSecondBigger, 0);
        double calculateEquals = calculator.calculate('+', 10.2, 10.2);
        Assert.assertEquals(20.4, calculateEquals, 0);
    }

    @Test
    public void minusDecimalNumbers() {
        double calculateFirstBigger = calculator.calculate('-', 5.5, 4.2);
        Assert.assertEquals(1.2, calculateFirstBigger, 0.1);
        double calculateSecondBigger = calculator.calculate('-', 10.5, 15.2);
        Assert.assertEquals(-4.7, calculateSecondBigger, 0.1);
        double calculateEquals = calculator.calculate('-', 10.2, 10.2);
        Assert.assertEquals(0, calculateEquals, 0.1);
    }

    @Test
    public void divideDecimalNumbers() {
        double calculateFirstBigger = calculator.calculate('/', 5.5, 4.2);
        Assert.assertEquals(1.3, calculateFirstBigger, 0.1);
        double calculateSecondBigger = calculator.calculate('/', 10.5, 15.2);
        Assert.assertEquals(0.6, calculateSecondBigger, 0.1);
        double calculateEquals = calculator.calculate('/', 10.2, 10.2);
        Assert.assertEquals(1, calculateEquals, 0.1);
    }

    @Test
    public void multiplyDecimalNumbers() {
        double calculateFirstBigger = calculator.calculate('*', 5.5, 4.2);
        Assert.assertEquals(23.1, calculateFirstBigger, 0.1);
        double calculateSecondBigger = calculator.calculate('*', 10.5, 15.2);
        Assert.assertEquals(159.6, calculateSecondBigger, 0.1);
        double calculateEquals = calculator.calculate('*', 10.2, 10.2);
        Assert.assertEquals(104.04, calculateEquals, 0.1);
    }

    @Test
    public void powDecimalNumbers() {
        double calculateFirstBigger = calculator.calculate('^', 5.5, 4.2);
        Assert.assertEquals(1286.83, calculateFirstBigger, 0.1);
        double calculateSecondBigger = calculator.calculate('^', 1.5, 5.2);
        Assert.assertEquals(8.23, calculateSecondBigger, 0.1);
        double calculateEquals = calculator.calculate('^', 10.2, 10.2);
        Assert.assertEquals(19_396_427_701.4, calculateEquals, 0.1);
    }

    @Test
    public void wrongOperator() {
        try {
            calculator.calculate('%', 5, 3);
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException was expected");
    }

    @Test
    public void divideByZero() {
        try {
            calculator.calculate('/', 5, 0);
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException was expected");
    }
}
