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
    private static final double DELTA = 1e-10;
    private double resultReturn;
    private Calculator calculator;

    @Before
    public void setUp() {
       calculator = new Calculator();
    }

    @Test
    public void sumTestPositiveWithMaxValue() {
        resultReturn = calculator.calculate(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2, ADDITION_SIGN);
        Assert.assertEquals(Double.MAX_VALUE, resultReturn, DELTA);
    }

    @Test
    public void sumTestPositiveWithFirstElementIsZero() {
        resultReturn = calculator.calculate(0, 18.7, ADDITION_SIGN);
        Assert.assertEquals(18.7, resultReturn, DELTA);
    }

    @Test
    public void sumTestPositiveWithSecondElementIsZero() {
        resultReturn = calculator.calculate(18.7, 0, ADDITION_SIGN);
        Assert.assertEquals(18.7, resultReturn, DELTA);
    }

    @Test
    public void sumTestResultIsZero() {
        resultReturn = calculator.calculate(-18.7, 18.7, ADDITION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void sumTestNegative() {
        resultReturn = calculator.calculate(-18.7, -18.7, ADDITION_SIGN);
        Assert.assertEquals(-37.4, resultReturn, DELTA);
    }

    @Test
    public void subtractionTestZeroWithMaxValue() {
        resultReturn = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void subtractionTestPositiveWithFirstElementIsZero() {
        resultReturn = calculator.calculate(0, 18.7, SUBTRACTION_SIGN);
        Assert.assertEquals(-18.7, resultReturn, DELTA);
    }

    @Test
    public void subtractionTestNegativeWithSecondElementIsZero() {
        resultReturn = calculator.calculate(18.7, 0, SUBTRACTION_SIGN);
        Assert.assertEquals(18.7, resultReturn, DELTA);
    }

    @Test
    public void subtractionTestNegative() {
        resultReturn = calculator.calculate(-18.7, 18.7, SUBTRACTION_SIGN);
        Assert.assertEquals(-37.4, resultReturn, DELTA);
    }

    @Test
    public void subtractionTestResultIsZero() {
        resultReturn = calculator.calculate(-18.7, -18.7, SUBTRACTION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void divisionTestIsOk() {
        resultReturn = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION_SIGN);
        Assert.assertEquals(1, resultReturn, DELTA);
    }
    @Test
    public void sumTestPositiveResultOne() {
        resultReturn = calculator.calculate(8, 11.7,SUBTRACTION_SIGN);
        Assert.assertEquals(0.068, resultReturn, DIVISION_SIGN);
    }

    @Test
    public void divisionTestPositiveWithFirstElementIsZero() {
        resultReturn = calculator.calculate(0, 18.7, DIVISION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void sumTestNegativeResultOne() {
        resultReturn = calculator.calculate(-18.7, 18.7, DIVISION_SIGN);
        Assert.assertEquals(-1, resultReturn, DELTA);
    }

    @Test (expected = IllegalArgumentException.class)
    public void divisionZeroByZeroTest() {
        resultReturn = calculator.calculate(0, 0, DIVISION_SIGN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void divisionNotZeroByZeroTest() {
        resultReturn = calculator.calculate(5, 0, DIVISION_SIGN);
    }

    @Test
    public void multiplicationPositiveTestWithTwoNegativeNumbers() {
        resultReturn = calculator.calculate(-18.7, -18.7, MULTIPLICATION_SIGN);
        Assert.assertEquals(349.69, resultReturn, DELTA);
    }

    @Test
    public void multiplicationPositiveTestIsOk() {
        resultReturn = calculator.calculate(8, 11.7,MULTIPLICATION_SIGN);
        Assert.assertEquals(93.6, resultReturn, DELTA);
    }

    @Test
    public void multiplicationTestWithFirstElementIsZero() {
        resultReturn = calculator.calculate(0, 18.7, MULTIPLICATION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void multiplicationTestWithSecondElementIsZero() {
        resultReturn = calculator.calculate(18.7, 0, MULTIPLICATION_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void multiplicationNegativeTestIsOk() {
        resultReturn = calculator.calculate(-18.7, 18.7, MULTIPLICATION_SIGN);
        Assert.assertEquals(-349.69, resultReturn, DELTA);
    }

    @Test
    public void raisingToThePowerTestWithDegreeNegativeOne() {
        resultReturn = calculator.calculate(18.7, -1, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(0.0534759358288, resultReturn, DELTA);
    }

    @Test
    public void raisingToThePowerPositiveTestWithTwoPositiveNumbers() {
        resultReturn = calculator.calculate(8, 4, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(4096, resultReturn, DELTA);
    }


    @Test
    public void raisingToThePowerTestWithFirstElementIsZero() {
        resultReturn = calculator.calculate(0, 18.7, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(0, resultReturn, DELTA);
    }

    @Test
    public void raisingToThePowerTestWithSecondElementIsZero() {
        resultReturn = calculator.calculate(Double.MAX_VALUE, 0, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(1, resultReturn, DELTA);
    }

    @Test
    public void raisingToThePowerTestWithDegreePositiveOne() {
        resultReturn = calculator.calculate(-18.7, 1, RAISING_TO_THE_POWER_SIGN);
        Assert.assertEquals(-18.7, resultReturn, DELTA);
    }


    @Test(expected = IllegalArgumentException.class)
    public void wrongInputOperationTest() {
        resultReturn = calculator.calculate(8, 4, AMPERSAND_SIGN);
    }
}
