package core.basesyntax;

import static java.lang.Double.NaN;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    public static final double DELTA = 0.001;
    public static final double FIRST_OPERAND = 5.5;
    public static final double SECOND_OPERAND = 7.6;
    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidOperator() {
        calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, '&');
    }

    @Test
    public void additionPositiveNumbersOk() {
        Assert.assertEquals(
                13.1, calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, '+'), DELTA);
    }

    @Test
    public void additionNegativeNumbersOk() {
        Assert.assertEquals(
                -13.1, calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, '+'), DELTA);
    }

    @Test
    public void additionPositiveAndNegativeNumbersOk() {
        Assert.assertEquals(
                2.1, calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, '+'), DELTA);
        Assert.assertEquals(
                -2.1, calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, '+'), DELTA);
    }

    @Test
    public void additionZeroValuesOk() {
        Assert.assertEquals(
                5.5, calculator.calculate(FIRST_OPERAND, 0, '+'), DELTA);
        Assert.assertEquals(
                -7.6, calculator.calculate(0, -SECOND_OPERAND, '+'), DELTA);
        Assert.assertEquals(
                0, calculator.calculate(0, 0, '+'), DELTA);
    }

    @Test
    public void subtractionPositiveNumbersOk() {
        Assert.assertEquals(
                -2.1, calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, '-'), DELTA);
        Assert.assertEquals(
                2.1, calculator.calculate(SECOND_OPERAND, FIRST_OPERAND, '-'), DELTA);
    }

    @Test
    public void subtractionNegativeNumbersOk() {
        Assert.assertEquals(
                2.1, calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, '-'), DELTA);
        Assert.assertEquals(
                -2.1, calculator.calculate(-SECOND_OPERAND, -FIRST_OPERAND, '-'), DELTA);
    }

    @Test
    public void subtractionPositiveAndNegativeNumbersOk() {
        Assert.assertEquals(
                -13.1, calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, '-'), DELTA);
        Assert.assertEquals(
                13.1, calculator.calculate(SECOND_OPERAND, -FIRST_OPERAND, '-'), DELTA);
    }

    @Test
    public void subtractionZeroValuesOk() {
        Assert.assertEquals(
                7.6, calculator.calculate(0, -SECOND_OPERAND, '-'), DELTA);
        Assert.assertEquals(
                5.5, calculator.calculate(FIRST_OPERAND, 0, '-'), DELTA);
        Assert.assertEquals(
                0, calculator.calculate(0, 0, '-'), DELTA);
    }

    @Test
    public void divisionPositiveNumbersOk() {
        Assert.assertEquals(
                0.723, calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, '/'), DELTA);
    }

    @Test
    public void divisionNegativeNumbersOk() {
        Assert.assertEquals(
                0.723, calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, '/'), DELTA);
        Assert.assertEquals(
                -0.723, calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, '/'), DELTA);
        Assert.assertEquals(
                -0.723, calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, '/'), DELTA);
    }

    @Test
    public void divisionPositiveAndNegativeNumbersOk() {
        Assert.assertEquals(
                -0.723, calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, '/'), DELTA);
        Assert.assertEquals(
                -0.723, calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, '/'), DELTA);
    }


    @Test(expected = ArithmeticException.class)
    public void divisionZeroNumbers() {
        Assert.assertEquals(
                0, calculator.calculate(0, SECOND_OPERAND, '/'), DELTA);
        calculator.calculate(FIRST_OPERAND, 0, '/');
    }

    @Test
    public void multiplicationPositiveNumbersOk() {
        Assert.assertEquals(
                41.8, calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, '*'), DELTA);
    }

    @Test
    public void multiplicationNegativeNumbersOk() {
        Assert.assertEquals(
                41.8, calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, '*'), DELTA);
    }

    @Test
    public void multiplicationPositiveAndNegativeNumbersOk() {
        Assert.assertEquals(
                -41.8, calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, '*'), DELTA);
        Assert.assertEquals(
                -41.8, calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, '*'), DELTA);
    }

    @Test
    public void multiplicationZeroNumbersOk() {
        Assert.assertEquals(
                0, calculator.calculate(0, SECOND_OPERAND, '*'), DELTA);
        Assert.assertEquals(
                0, calculator.calculate(-FIRST_OPERAND, 0, '*'), DELTA);
    }

    @Test
    public void raisingToThePowerPositiveNumbersOk() {
        Assert.assertEquals(
                423405.446, calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, '^'), DELTA);
    }

    @Test
    public void raisingToThePowerNegativeNumbersOk() {
        Assert.assertEquals(
                NaN, calculator.calculate(-FIRST_OPERAND, SECOND_OPERAND, '^'), DELTA);
        Assert.assertEquals(
                NaN, calculator.calculate(-FIRST_OPERAND, -SECOND_OPERAND, '^'), DELTA);
    }

    @Test
    public void raisingToTheNegativePowerOk() {
        Assert.assertEquals(
                0.00000236, calculator.calculate(FIRST_OPERAND, -SECOND_OPERAND, '^'),
                0.00000001);
    }

    @Test
    public void raisingNullToThePositivePowerOk() {
        Assert.assertEquals(
                0, calculator.calculate(0, SECOND_OPERAND, '^'), 0.00000001);
    }

    @Test
    public void raisingToTheZeroPowerOk() {
        Assert.assertEquals(
                1, calculator.calculate(FIRST_OPERAND, 0, '^'), 0.00000001);
    }

    @Test(expected = ArithmeticException.class)
    public void raisingNullToTheNegativePowerOk() {
        calculator.calculate(0, -SECOND_OPERAND, '^');
    }
}
