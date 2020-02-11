package core.basesyntax;

import org.junit.Assert;

import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private static final Double DELTA = 0.0001;
    
    @Test
    public void addOK() {
        Assert.assertEquals(20.8, calculator.calculate('+', 10, 10.8), DELTA);
        Assert.assertEquals(-20.8, calculator.calculate('+', -10, -10.8), DELTA);
        Assert.assertEquals(0.8, calculator.calculate('+', -10, 10.8), DELTA);
        Assert.assertEquals(-0.8, calculator.calculate('+', 10, -10.8), DELTA);
    }

    @Test
    public void subtractionOK() {
        Assert.assertEquals(-0.8, calculator.calculate('-', 10, 10.8), DELTA);
        Assert.assertEquals(0.8, calculator.calculate('-', -10, -10.8), DELTA);
        Assert.assertEquals(-20.8, calculator.calculate('-', -10, 10.8), DELTA);
        Assert.assertEquals(20.8, calculator.calculate('-', 10, -10.8), DELTA);
    }

    @Test
    public void multiplicationOK() {
        Assert.assertEquals(100, calculator.calculate('*', 10, 10), DELTA);
        Assert.assertEquals(100, calculator.calculate('*', -10, -10), DELTA);
        Assert.assertEquals(-100, calculator.calculate('*', -10, 10), DELTA);
        Assert.assertEquals(-100, calculator.calculate('*', 10, -10), DELTA);
    }

    @Test
    public void divisionOK() {
        Assert.assertEquals(2, calculator.calculate('/', 4, 2),  DELTA);
        Assert.assertEquals(2, calculator.calculate('/', -4, -2),  DELTA);
        Assert.assertEquals(-2, calculator.calculate('/', -4, 2),  DELTA);
        Assert.assertEquals(-2, calculator.calculate('/', 4, -2),  DELTA);
    }

    @Test
    public void powEvenDegreeOK() {
        Assert.assertEquals(4, calculator.calculate('^', 2, 2),  DELTA);
        Assert.assertEquals(0.25, calculator.calculate('^', -2, -2),  DELTA);
        Assert.assertEquals(4, calculator.calculate('^', -2, 2),  DELTA);
        Assert.assertEquals(0.25, calculator.calculate('^', 2, -2),  DELTA);
    }

    @Test
    public void powOddDegreeOK() {
        Assert.assertEquals(8, calculator.calculate('^', 2, 3),  DELTA);
        Assert.assertEquals(-0.125, calculator.calculate('^', -2, -3),  DELTA);
        Assert.assertEquals(-8, calculator.calculate('^', -2, 3),  DELTA);
        Assert.assertEquals(0.125, calculator.calculate('^', 2, -3),  DELTA);
    }

    @Test
    public void divisionPositiveByZero() {
        double infinity = Double.POSITIVE_INFINITY;
        double result = calculator.calculate('/', 4, 0);
        Assert.assertEquals("Test failed! Division by zero!", infinity, result, DELTA);
    }

    @Test
    public void divisionNegativeByZero() {
        double infinity = Double.NEGATIVE_INFINITY;
        double result = calculator.calculate('/', -4, 0);
        Assert.assertEquals("Test failed! Division by zero!", infinity, result, DELTA);
    }

    @Test
    public void powZeroDegree() {
        double result = calculator.calculate('^', 4, 0);
        Assert.assertEquals(1, result, DELTA);
    }
}
