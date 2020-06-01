package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final Calculator CALCULATOR = new Calculator();

    @Test
    public void additionPositiveNumbers() {
        Assert.assertEquals(5.0, CALCULATOR.calculate(2.0, 3.0, '+'), 0.1);
    }

    @Test
    public void additionNegativeNumbers() {
        Assert.assertEquals(-5.0, CALCULATOR.calculate(-2.0, -3.0, '+'), 0.1);
    }

    @Test
    public void additionZeroToNumber() {
        double number = 2.0;
        Assert.assertEquals(number, CALCULATOR.calculate(number, 0, '+'), 0.1);
    }

    @Test
    public void additionNumbersPermutationOfTerms() {
        double number1 = 2.0;
        double number2 = 3.0;
        Assert.assertEquals(CALCULATOR.calculate(number1, number2, '+'),
                CALCULATOR.calculate(number2, number1, '+'), 0.1);
    }

    @Test
    public void subtractTheSmallerFromTheLarger() {
        Assert.assertTrue(CALCULATOR.calculate(3.0, 2.0, '-') > 0);
    }

    @Test
    public void subtractMoreFromASmallerNumber() {
        Assert.assertTrue(CALCULATOR.calculate(2.0, 3.0, '-') < 0);
    }

    @Test
    public void subtractTheNumberFromItself() {
        double number = 3.0;
        Assert.assertEquals(0, CALCULATOR.calculate(number, number, '-'), 0.1);
    }

    @Test
    public void multiplicationOfTwoNumbers() {
        Assert.assertEquals(6.0, CALCULATOR.calculate(3.0, 2.0, '*'), 0.1);
    }

    @Test
    public void multiplicationNegativeNumbers() {
        Assert.assertTrue(CALCULATOR.calculate(-2.0, -3.0, '*') > 0);
    }

    @Test
    public void multiplicationNegativeByPositiveNumbers() {
        Assert.assertTrue(CALCULATOR.calculate(-2.0, 3.0, '*') < 0);
    }

    @Test
    public void multiplicationNumberByZero() {
        Assert.assertEquals(0.0, CALCULATOR.calculate(3.0, 0.0, '*'), 0.1);
    }

    @Test
    public void multiplicationNumberByOne() {
        double number = 3.0;
        Assert.assertEquals(number, CALCULATOR.calculate(number, 1.0, '*'), 0.1);
    }

    @Test
    public void multiplicationNumbersPermutationOfTerms() {
        double number1 = 2.0;
        double number2 = 3.0;
        Assert.assertEquals(CALCULATOR.calculate(number1, number2, '*'),
                CALCULATOR.calculate(number2, number1, '*'), 0.1);
    }

    @Test
    public void divisionOfTwoNumbers() {
        Assert.assertEquals(2.0, CALCULATOR.calculate(6.0, 3.0, '/'), 0.1);
    }

    @Test
    public void divisionOfALargerNumberIntoASmallerNumber() {
        Assert.assertTrue(CALCULATOR.calculate(3.0, 2.0, '/') > 1);
    }

    @Test
    public void divisionOfASmallerNumberIntoALargerNumber() {
        Assert.assertTrue(CALCULATOR.calculate(2.0, 3.0, '/') < 1);
    }

    @Test
    public void divisionOfANumberByItself() {
        double number = 3.0;
        Assert.assertEquals(1.0, CALCULATOR.calculate(number, number, '/'), 0.1);
    }

    @Test
    public void divisionNumberByOne() {
        double number = 3.0;
        Assert.assertEquals(number, CALCULATOR.calculate(number, 1.0, '/'), 0.1);
    }

    @Test
    public void divisionPositiveNumberByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, CALCULATOR.calculate(3.0, 0.0, '/'), 0.1);
    }

    @Test
    public void divisionNegativeNumberByZero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, CALCULATOR.calculate(-3.0, 0.0, '/'), 0.1);
    }

    @Test
    public void raisingANumberToAPower() {
        Assert.assertEquals(9.0, CALCULATOR.calculate(3.0, 2.0, '^'), 0.1);
    }

    @Test
    public void raisingANumberToANegativePower() {
        Assert.assertEquals(0.1, CALCULATOR.calculate(3.0, -2.0, '^'), 0.1);
    }

    @Test
    public void raisingANumberToAOnePower() {
        double number = 3.0;
        Assert.assertEquals(number, CALCULATOR.calculate(number, 1.0, '^'), 0.1);
    }

    @Test
    public void raisingANumberToAZeroPower() {
        Assert.assertEquals(1.0, CALCULATOR.calculate(3.0, 0.0, '^'), 0.1);
    }

    @Test
    public void symbolThatDoesNotCorrespondToAMathematicalOperation() {
        try {
            CALCULATOR.calculate(3.0, 2.0, 'j');
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail("IllegalArgumentException was expected");
    }
}