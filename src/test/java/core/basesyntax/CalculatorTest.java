package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private final double DELTA = 0.1;
    private Calculator calculator;

    @Before
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void sumWholePositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('+', 5, 4);
        Assert.assertEquals(9, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('+', 10, 15);
        Assert.assertEquals(25, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('+', 10, 10);
        Assert.assertEquals(20, calculateEquals, DELTA);
    }

    @Test
    public void minusWholePositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('-', 5, 4);
        Assert.assertEquals(1, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('-', 10, 15);
        Assert.assertEquals(-5, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('-', 10, 10);
        Assert.assertEquals(0, calculateEquals, DELTA);
    }

    @Test
    public void divideWholePositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('/', 5, 4);
        Assert.assertEquals(1.25, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('/', 10, 15);
        Assert.assertEquals(0.6666666666666666, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('/', 10, 10);
        Assert.assertEquals(1, calculateEquals, DELTA);
    }

    @Test
    public void multiplyWholePositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('*', 5, 4);
        Assert.assertEquals(20, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('*', 10, 15);
        Assert.assertEquals(150, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('*', 10, 10);
        Assert.assertEquals(100, calculateEquals, DELTA);
    }

    @Test
    public void powWholePositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('^', 5, 4);
        Assert.assertEquals(625, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('^', 10, 15);
        Assert.assertEquals(1_000_000_000_000_000D, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('^', 10, 10);
        Assert.assertEquals(10_000_000_000D, calculateEquals, DELTA);
    }

    @Test
    public void sumDecimalPositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('+', 5.5, 4.2);
        Assert.assertEquals(9.7, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('+', 10.5, 15.2);
        Assert.assertEquals(25.7, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('+', 10.2, 10.2);
        Assert.assertEquals(20.4, calculateEquals, DELTA);
    }

    @Test
    public void minusDecimalPositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('-', 5.5, 4.2);
        Assert.assertEquals(1.2, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('-', 10.5, 15.2);
        Assert.assertEquals(-4.7, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('-', 10.2, 10.2);
        Assert.assertEquals(0, calculateEquals, DELTA);
    }

    @Test
    public void divideDecimalPositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('/', 5.5, 4.2);
        Assert.assertEquals(1.3, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('/', 10.5, 15.2);
        Assert.assertEquals(0.6, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('/', 10.2, 10.2);
        Assert.assertEquals(1, calculateEquals, DELTA);
    }

    @Test
    public void multiplyDecimalPositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('*', 5.5, 4.2);
        Assert.assertEquals(23.1, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('*', 10.5, 15.2);
        Assert.assertEquals(159.6, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('*', 10.2, 10.2);
        Assert.assertEquals(104.04, calculateEquals, DELTA);
    }

    @Test
    public void powDecimalPositiveNumbers() {
        double calculateFirstBigger = calculator.calculate('^', 5.5, 4.2);
        Assert.assertEquals(1286.83, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('^', 1.5, 5.2);
        Assert.assertEquals(8.23, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('^', 10.2, 10.2);
        Assert.assertEquals(19_396_427_701.4, calculateEquals, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void wrongOperator() {
        calculator.calculate('%', 5, 3);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.calculate('/', 5, 0);
    }

    @Test
    public void sumWholeNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('+', -5, -4);
        Assert.assertEquals(-9, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('+', -10, -15);
        Assert.assertEquals(-25, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('+', -10, -10);
        Assert.assertEquals(-20, calculateEquals, DELTA);
    }

    @Test
    public void minusWholeNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('-', -5, -4);
        Assert.assertEquals(-1, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('-', -10, -15);
        Assert.assertEquals(5, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('-', -10, -10);
        Assert.assertEquals(0, calculateEquals, DELTA);
    }

    @Test
    public void divideWholeNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('/', -5, -4);
        Assert.assertEquals(1.25, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('/', -10, 15);
        Assert.assertEquals(-0.6666666666666666, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('/', -10, 10);
        Assert.assertEquals(-1, calculateEquals, DELTA);
    }

    @Test
    public void multiplyWholeNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('*', -5, -4);
        Assert.assertEquals(20, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('*', -10, -15);
        Assert.assertEquals(150, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('*', -10, -10);
        Assert.assertEquals(100, calculateEquals, DELTA);
    }

    @Test
    public void powWholeNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('^', -5, -4);
        Assert.assertEquals(-0.0016, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('^', -10, -15);
        Assert.assertEquals(-1e-15, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('^', -10, -10);
        Assert.assertEquals(-1e-10, calculateEquals, DELTA);
    }

    @Test
    public void sumDecimalNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('+', -5.5, -4.2);
        Assert.assertEquals(-9.7, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('+', -10.5, -15.2);
        Assert.assertEquals(-25.7, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('+', -10.2, -10.2);
        Assert.assertEquals(-20.4, calculateEquals, DELTA);
    }

    @Test
    public void minusDecimalNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('-', -5.5, -4.2);
        Assert.assertEquals(-1.2, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('-', -10.5, -15.2);
        Assert.assertEquals(4.7, calculateSecondBigger, 0.1);
        double calculateEquals = calculator.calculate('-', -10.2, -10.2);
        Assert.assertEquals(0, calculateEquals, DELTA);
    }

    @Test
    public void divideDecimalNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('/', -5.5, 4.2);
        Assert.assertEquals(-1.3, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('/', -10.5, 15.2);
        Assert.assertEquals(-0.6, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('/', -10.2, 10.2);
        Assert.assertEquals(-1, calculateEquals, DELTA);
    }

    @Test
    public void multiplyDecimalNegativeNumbers() {
        double calculateFirstBigger = calculator.calculate('*', -5.5, 4.2);
        Assert.assertEquals(-23.1, calculateFirstBigger, DELTA);
        double calculateSecondBigger = calculator.calculate('*', -10.5, 15.2);
        Assert.assertEquals(-159.6, calculateSecondBigger, DELTA);
        double calculateEquals = calculator.calculate('*', -10.2, 10.2);
        Assert.assertEquals(-104.04, calculateEquals, DELTA);
    }

    @Test
    public void powZeroDegree() {
        double calculateZeroDegree = calculator.calculate('^', 5, 0);
        Assert.assertEquals(1, calculateZeroDegree, DELTA);
    }

    @Test
    public void powNegativeDegree() {
        double calculateNegativeDegree = calculator.calculate('^', 10, -2);
        Assert.assertEquals(0.001, calculateNegativeDegree, DELTA);
    }
}
