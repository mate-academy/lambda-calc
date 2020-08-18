package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    public static final double DELTA = 0.001;
    Calculator calculator = new Calculator();

    @Test
    public void getSumOk() {
        double expectedSum = calculator.calcuate(2,2,'+');
        double expectedNegativeSum = calculator.calcuate(-2,-3, '+');
        Assert.assertEquals(4, expectedSum, DELTA);
        Assert.assertEquals(-5, expectedNegativeSum, DELTA);
    }

    @Test
    public void getDivisionOk() {
        double expectedDivision = calculator.calcuate(10,2,'/');
        double expectedReversedDivision = calculator.calcuate(2,10,'/');
        Assert.assertEquals(5, expectedDivision, DELTA);
        Assert.assertEquals(0.2, expectedReversedDivision, DELTA);
    }

    @Test
    public void getSubtractionOk() {
        double expectedSubtraction = calculator.calcuate(10,8,'-');
        double expectedNegativeSubtraction = calculator.calcuate(-3,-2,'-');
        Assert.assertEquals(2, expectedSubtraction, DELTA);
        Assert.assertEquals(-1, expectedNegativeSubtraction, DELTA);
    }

    @Test
    public void getMultiplicationOk() {
        double expectedMultiplication = calculator.calcuate(2,2, '*');
        double expectedNegativeMultiplication = calculator.calcuate(-2,-2,'*');
        double expectedZeroMultiplication = calculator.calcuate(0,2,'*');
        Assert.assertEquals(4, expectedMultiplication, DELTA);
        Assert.assertEquals(4, expectedNegativeMultiplication, DELTA);
        Assert.assertEquals(0, expectedZeroMultiplication, DELTA);
    }

    @Test
    public void getPowerOk() {
        double expectedPower = calculator.calcuate(2,2,'^');
        Assert.assertEquals(4, expectedPower, DELTA);
    }

    @Test
    public void getPowerNegative() {
        double expectedNegativePower = calculator.calcuate(-2, 3, '^');
        double expectedPowerToNegative = calculator.calcuate(3,-3, '^');
        double expectedBothNegative = calculator.calcuate(-2,-3,'^');
        Assert.assertEquals(-8, expectedNegativePower , DELTA);
        Assert.assertEquals(0.037, expectedPowerToNegative, DELTA);
        Assert.assertEquals(-0.125, expectedBothNegative, DELTA);
    }

    @Test
    public void getPowerZero() {
        double expectedZeroPower = calculator.calcuate(0,2,'^');
        double expectedPowerToZero = calculator.calcuate(2, 0, '^');
        Assert.assertEquals(0,expectedZeroPower, DELTA);
        Assert.assertEquals(1, expectedPowerToZero, DELTA);
    }

    @Test
    public void unsupportedOperation() {
        try {
            calculator.calcuate(2,2,'&');
        } catch (RuntimeException e ) {
            return;
        }
        Assert.fail("No valid operation!");
    }

    @Test
    public void testDivisionByZero() {
        try {
            calculator.calcuate(2, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("division by zero");
    }


}