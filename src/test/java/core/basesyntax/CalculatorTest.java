package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.1;
    private Calculator calculator = new Calculator();

    @Test
    public void additionPositiveNumbers() {
        Assert.assertEquals(5.0, calculator.calculate(2.0, 3.0, '+'), DELTA);
    }

    @Test
    public void additionNegativeNumbers() {
        Assert.assertEquals(-5.0, calculator.calculate(-2.0, -3.0, '+'), DELTA);
    }

    @Test
    public void additionZeroToNumber() {
        double number = 2.0;
        Assert.assertEquals(number, calculator.calculate(number, 0, '+'), DELTA);
    }

    @Test
    public void additionNumbersPermutationOfTerms() {
        double number1 = 2.0;
        double number2 = 3.0;
        Assert.assertEquals(calculator.calculate(number1, number2, '+'),
                calculator.calculate(number2, number1, '+'), DELTA);
    }

    @Test
    public void subtractTheSmallerFromTheLarger() {
        Assert.assertEquals(1.0, calculator.calculate(3.0, 2.0, '-'), DELTA);
    }

    @Test
    public void subtractMoreFromASmallerNumber() {
        Assert.assertEquals(-1.0, calculator.calculate(2.0, 3.0, '-'), DELTA);
    }

    @Test
    public void subtractTheNumberFromItself() {
        double number = 3.0;
        Assert.assertEquals(0, calculator.calculate(number, number, '-'), DELTA);
    }

    @Test
    public void multiplicationOfTwoNumbers() {
        Assert.assertEquals(6.0, calculator.calculate(3.0, 2.0, '*'), DELTA);
    }

    @Test
    public void multiplicationNegativeNumbers() {
        Assert.assertTrue(calculator.calculate(-2.0, -3.0, '*') > 0);
    }

    @Test
    public void multiplicationNegativeByPositiveNumbers() {
        Assert.assertTrue(calculator.calculate(-2.0, 3.0, '*') < 0);
    }

    @Test
    public void multiplicationNumberByZero() {
        Assert.assertEquals(0.0, calculator.calculate(3.0, 0.0, '*'), DELTA);
    }

    @Test
    public void multiplicationNumberByOne() {
        double number = 3.0;
        Assert.assertEquals(number, calculator.calculate(number, 1.0, '*'), DELTA);
    }

    @Test
    public void multiplicationNumbersPermutationOfTerms() {
        double number1 = 2.0;
        double number2 = 3.0;
        Assert.assertEquals(calculator.calculate(number1, number2, '*'),
                calculator.calculate(number2, number1, '*'), DELTA);
    }

    @Test
    public void divisionOfTwoNumbers() {
        Assert.assertEquals(2.0, calculator.calculate(6.0, 3.0, '/'), DELTA);
    }

    @Test
    public void divisionOfALargerNumberIntoASmallerNumber() {
        Assert.assertTrue(calculator.calculate(3.0, 2.0, '/') > 1);
    }

    @Test
    public void divisionOfASmallerNumberIntoALargerNumber() {
        Assert.assertTrue(calculator.calculate(2.0, 3.0, '/') < 1);
    }

    @Test
    public void divisionOfANumberByItself() {
        double number = 3.0;
        Assert.assertEquals(1.0, calculator.calculate(number, number, '/'), DELTA);
    }

    @Test
    public void divisionNumberByOne() {
        double number = 3.0;
        Assert.assertEquals(number, calculator.calculate(number, 1.0, '/'), DELTA);
    }

    @Test
    public void divisionPositiveNumberByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(3.0, 0.0, '/'), DELTA);
    }

    @Test
    public void divisionNegativeNumberByZero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, calculator.calculate(-3.0, 0.0, '/'), DELTA);
    }

    @Test
    public void raisingANumberToAPower() {
        Assert.assertEquals(9.0, calculator.calculate(3.0, 2.0, '^'), DELTA);
    }

    @Test
    public void raisingANumberToANegativePower() {
        Assert.assertEquals(0.1, calculator.calculate(3.0, -2.0, '^'), DELTA);
    }

    @Test
    public void raisingANumberToAOnePower() {
        double number = 3.0;
        Assert.assertEquals(number, calculator.calculate(number, 1.0, '^'), DELTA);
    }

    @Test
    public void raisingANumberToAZeroPower() {
        Assert.assertEquals(1.0, calculator.calculate(3.0, 0.0, '^'), DELTA);
    }

    @Test
    public void symbolThatDoesNotCorrespondToAMathematicalOperation() {
        try {
            calculator.calculate(3.0, 2.0, 'j');
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail("IllegalArgumentException was expected");
    }
}
