package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    public static final double DELTA = 0.01;
    Calculator calculator = new Calculator();

    @Test
    public void getSumOk() {
        double expectedSum = calculator.calculate(2,2,'+');
        double expectedNegativeSum = calculator.calculate(-2,-3, '+');
        Assert.assertEquals(4, expectedSum, DELTA);
        Assert.assertEquals(-5, expectedNegativeSum, DELTA);
    }

    @Test
    public void getDivisionOk() {
        double expectedDivision = calculator.calculate(10,2,'/');
        double expectedReversedDivision = calculator.calculate(2,10,'/');
        Assert.assertEquals(5, expectedDivision, DELTA);
        Assert.assertEquals(0.2, expectedReversedDivision, DELTA);
    }

    @Test
    public void getSubtractionOk() {
        double expectedSubtraction = calculator.calculate(10,8,'-');
        double expectedNegativeSubtraction = calculator.calculate(-3,-2,'-');
        Assert.assertEquals(2, expectedSubtraction, DELTA);
        Assert.assertEquals(-1, expectedNegativeSubtraction, DELTA);
    }

    @Test
    public void getMultiplicationOk() {
        double expectedMultiplication = calculator.calculate(2,2, '*');
        double expectedNegativeMultiplication = calculator.calculate(-2,-2,'*');
        double expectedZeroMultiplication = calculator.calculate(0,2,'*');
        Assert.assertEquals(4, expectedMultiplication, DELTA);
        Assert.assertEquals(4, expectedNegativeMultiplication, DELTA);
        Assert.assertEquals(0, expectedZeroMultiplication, DELTA);
    }

    @Test
    public void getPowerOk() {
        double expectedPower = calculator.calculate(2,2,'^');
        Assert.assertEquals(4, expectedPower, DELTA);
    }

    @Test
    public void getPowerNegative() {
        double expectedNegativePower = calculator.calculate(-2, 3, '^');
        double expectedPowerToNegative = calculator.calculate(3,-3, '^');
        double expectedBothNegative = calculator.calculate(-2,-3,'^');
        Assert.assertEquals(-8, expectedNegativePower , DELTA);
        Assert.assertEquals(0.037, expectedPowerToNegative, DELTA);
        Assert.assertEquals(-0.125, expectedBothNegative, DELTA);
    }

    @Test
    public void getPowerZero() {
        double expectedZeroPower = calculator.calculate(0,2,'^');
        double expectedPowerToZero = calculator.calculate(2, 0, '^');
        Assert.assertEquals(0,expectedZeroPower, DELTA);
        Assert.assertEquals(1, expectedPowerToZero, DELTA);
    }

    @Test
    public void unsupportedOperation() {
        try {
            calculator.calculate(2,2,'&');
        } catch (RuntimeException e ) {
            return;
        }
        Assert.fail("No valid operation!");
    }

    @Test
    public void testDivisionByZero() {
        try {
            calculator.calculate(2, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("division by zero");
    }


}