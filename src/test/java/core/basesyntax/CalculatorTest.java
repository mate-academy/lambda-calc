package core.basesyntax;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final char ADDITION_SIGN = '+';
    private static final char SUBTRACTION_SIGN = '-';
    private static final char DIVISION_SIGN = '/';
    private static final char MULTIPLICATION_SIGN = '*';
    private static final char RAISING_TO_THE_POWER_SIGN = '^';
    private static final char AMPERSAND_SIGN = '&';
    private static final double DELTA = 0.001;
    private double resultReturn;
    private Calculator calculator;

    @Before
    public void setUp() {
       calculator = new Calculator();
    }

    @Test
    public void sumTestIsOk() {
        resultReturn = calculator.calculate(8, 11.7, ADDITION_SIGN);
        Assert.assertEquals(19.7, resultReturn, DELTA);
        resultReturn = calculator.calculate(0, 18.7, ADDITION_SIGN);
        Assert.assertEquals(18.7, resultReturn, DELTA);
        resultReturn = calculator.calculate(18.7, 0, ADDITION_SIGN);
        Assert.assertEquals(18.7, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, 18.7, ADDITION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, -18.7, ADDITION_SIGN);
        Assert.assertEquals(-37.4, resultReturn, DELTA);
    }

    @Test
    public void subtractionTestIsOk() {
        resultReturn = calculator.calculate(8, 11.7,SUBTRACTION_SIGN);
        Assert.assertEquals(-3.7, resultReturn, DELTA);
        resultReturn = calculator.calculate(0, 18.7, SUBTRACTION_SIGN);
        Assert.assertEquals(-18.7, resultReturn, DELTA);
        resultReturn = calculator.calculate(18.7, 0, SUBTRACTION_SIGN);
        Assert.assertEquals(18.7, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, 18.7, SUBTRACTION_SIGN);
        Assert.assertEquals(-37.4, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, -18.7, SUBTRACTION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void divisionTestIsOk() {
        resultReturn = calculator.calculate(8, 11.7,SUBTRACTION_SIGN);
        Assert.assertEquals(0.068, resultReturn, DIVISION_SIGN);
        resultReturn = calculator.calculate(0, 18.7, DIVISION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, 18.7, DIVISION_SIGN);
        Assert.assertEquals(-1, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, -18.7, DIVISION_SIGN);
        Assert.assertEquals(1, resultReturn, DELTA);
    }

    @Test (expected = IllegalArgumentException.class)
    public void divisionTestIsNotOkFirst() {
        resultReturn = calculator.calculate(0, 0, DIVISION_SIGN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void divisionTestIsNotOkSecond() {
        resultReturn = calculator.calculate(5, 0, DIVISION_SIGN);
    }

    @Test
    public void multiplicationTestIsOk() {
        resultReturn = calculator.calculate(8, 11.7,MULTIPLICATION_SIGN);
        Assert.assertEquals(93.6, resultReturn, DELTA);
        resultReturn = calculator.calculate(0, 18.7, MULTIPLICATION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
        resultReturn = calculator.calculate(18.7, 0, MULTIPLICATION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, 18.7, MULTIPLICATION_SIGN);
        Assert.assertEquals(-349.69, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, -18.7, MULTIPLICATION_SIGN);
        Assert.assertEquals(349.69, resultReturn, DELTA);
    }

    @Test
    public void raisingToThePowerTestIsOk() {
        resultReturn = calculator.calculate(8, 4, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(4096, resultReturn, DELTA);
        resultReturn = calculator.calculate(0, 18.7, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
        resultReturn = calculator.calculate(18.7, 0, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(1, resultReturn, DELTA);
        resultReturn = calculator.calculate(-18.7, 1, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(-18.7, resultReturn, DELTA);
        resultReturn = calculator.calculate(18.7, -1, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(0.053, resultReturn, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongInputOperationTest() {
        resultReturn = calculator.calculate(8, 4, AMPERSAND_SIGN);
    }
}
