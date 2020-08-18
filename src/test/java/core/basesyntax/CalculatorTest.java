package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static java.lang.Double.NaN;

public class CalculatorTest {
    public static final double DELTA = 0.001;
    private static double firstOperand;
    private static double secondOperand;
    private char operator;

    @BeforeClass
    public static void beforeClass() {
        firstOperand = 5.5;
        secondOperand = 7.6;
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidOperator() {
        operator = '&';
        Calculator.calculate(firstOperand, secondOperand, operator);
    }

    @Test
    public void additionPositiveNumbersOk() {
        operator = '+';
        Assert.assertEquals(
                13.1, Calculator.calculate(firstOperand, secondOperand, operator), DELTA);
    }

    @Test
    public void additionNegativeNumbersOk() {
        operator = '+';
        Assert.assertEquals(
                -13.1, Calculator.calculate(-firstOperand, -secondOperand, operator), DELTA);
    }

    @Test
    public void additionPositiveAndNegativeNumbersOk() {
        operator = '+';
        Assert.assertEquals(
                2.1, Calculator.calculate(-firstOperand, secondOperand, operator), DELTA);
        Assert.assertEquals(
                -2.1, Calculator.calculate(firstOperand, -secondOperand, operator), DELTA);
    }

    @Test
    public void additionZeroValuesOk() {
        operator = '+';
        Assert.assertEquals(
                5.5, Calculator.calculate(firstOperand, 0, operator), DELTA);
        Assert.assertEquals(
                -7.6, Calculator.calculate(0, -secondOperand, operator), DELTA);
        Assert.assertEquals(
                0, Calculator.calculate(0, 0, operator), DELTA);
    }

    @Test
    public void subtractionPositiveNumbersOk() {
        operator = '-';
        Assert.assertEquals(
                -2.1, Calculator.calculate(firstOperand, secondOperand, operator), DELTA);
        Assert.assertEquals(
                2.1, Calculator.calculate(secondOperand, firstOperand, operator), DELTA);
    }

    @Test
    public void subtractionNegativeNumbersOk() {
        operator = '-';
        Assert.assertEquals(
                2.1, Calculator.calculate(-firstOperand, -secondOperand, operator), DELTA);
        Assert.assertEquals(
                -2.1, Calculator.calculate(-secondOperand, -firstOperand, operator), DELTA);
    }

    @Test
    public void subtractionPositiveAndNegativeNumbersOk() {
        operator = '-';
        Assert.assertEquals(
                -13.1, Calculator.calculate(-firstOperand, secondOperand, operator), DELTA);
        Assert.assertEquals(
                13.1, Calculator.calculate(secondOperand, -firstOperand, operator), DELTA);
    }

    @Test
    public void subtractionZeroValuesOk() {
        operator = '-';
        Assert.assertEquals(
                7.6, Calculator.calculate(0, -secondOperand, operator), DELTA);
        Assert.assertEquals(
                5.5, Calculator.calculate(firstOperand, 0, operator), DELTA);
        Assert.assertEquals(
                0, Calculator.calculate(0, 0, operator), DELTA);
    }

    @Test
    public void divisionPositiveNumbersOk() {
        operator = '/';
        Assert.assertEquals(
                0.723, Calculator.calculate(firstOperand, secondOperand, operator), DELTA);
    }

    @Test
    public void divisionNegativeNumbersOk() {
        operator = '/';
        Assert.assertEquals(
                0.723, Calculator.calculate(-firstOperand, -secondOperand, operator), DELTA);
        Assert.assertEquals(
                -0.723, Calculator.calculate(firstOperand, -secondOperand, operator), DELTA);
        Assert.assertEquals(
                -0.723, Calculator.calculate(-firstOperand, secondOperand, operator), DELTA);
    }

    @Test
    public void divisionPositiveAndNegativeNumbersOk() {
        operator = '/';
        Assert.assertEquals(
                -0.723, Calculator.calculate(firstOperand, -secondOperand, operator), DELTA);
        Assert.assertEquals(
                -0.723, Calculator.calculate(-firstOperand, secondOperand, operator), DELTA);
    }


    @Test(expected = ArithmeticException.class)
    public void divisionZeroNumbers() {
        operator = '/';
        Assert.assertEquals(
                0, Calculator.calculate(0, secondOperand, operator), DELTA);
        Calculator.calculate(firstOperand, 0, operator);
    }

    @Test
    public void multiplicationPositiveNumbersOk() {
        operator = '*';
        Assert.assertEquals(
                41.8, Calculator.calculate(firstOperand, secondOperand, operator), DELTA);
    }

    @Test
    public void multiplicationNegativeNumbersOk() {
        operator = '*';
        Assert.assertEquals(
                41.8, Calculator.calculate(-firstOperand, -secondOperand, operator), DELTA);
    }

    @Test
    public void multiplicationPositiveAndNegativeNumbersOk() {
        operator = '*';
        Assert.assertEquals(
                -41.8, Calculator.calculate(-firstOperand, secondOperand, operator), DELTA);
        Assert.assertEquals(
                -41.8, Calculator.calculate(firstOperand, -secondOperand, operator), DELTA);
    }

    @Test
    public void multiplicationZeroNumbersOk() {
        operator = '*';
        Assert.assertEquals(
                0, Calculator.calculate(0, secondOperand, operator), DELTA);
        Assert.assertEquals(
                0, Calculator.calculate(-firstOperand, 0, operator), DELTA);
    }

    @Test
    public void raisingToThePowerPositiveNumbersOk() {
        operator = '^';
        Assert.assertEquals(
                423405.446, Calculator.calculate(firstOperand, secondOperand, operator), DELTA);
    }

    @Test
    public void raisingToThePowerNegativeNumbersOk() {
        operator = '^';
        Assert.assertEquals(
                NaN, Calculator.calculate(-firstOperand, secondOperand, operator), DELTA);
        Assert.assertEquals(
                NaN, Calculator.calculate(-firstOperand, -secondOperand, operator), DELTA);
    }

    @Test
    public void raisingToTheNegativePowerOk() {
        operator = '^';
        Assert.assertEquals(
                0.00000236, Calculator.calculate(firstOperand, -secondOperand, operator),
                0.00000001);
    }

    @Test
    public void raisingNullToThePositivePowerOk() {
        operator = '^';
        Assert.assertEquals(
                0, Calculator.calculate(0, secondOperand, operator), 0.00000001);
    }

    @Test
    public void raisingToTheZeroPowerOk() {
        operator = '^';
        Assert.assertEquals(
                1, Calculator.calculate(firstOperand, 0, operator), 0.00000001);
    }

    @Test(expected = ArithmeticException.class)
    public void raisingNullToTheNegativePowerOk() {
        operator = '^';
       Calculator.calculate(0, -secondOperand, operator);
    }
}
