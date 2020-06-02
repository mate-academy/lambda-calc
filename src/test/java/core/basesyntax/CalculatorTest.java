package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final int FIRST_NUMBER = 10;
    private static final int SECOND_NUMBER = 10;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnSumOfTwoNumbersIfOperandIsPlus() {
        Assert.assertEquals(FIRST_NUMBER + SECOND_NUMBER, calculator
                .calculate(FIRST_NUMBER, '+', SECOND_NUMBER));
    }

    @Test
    public void shouldReturnDifferenceOfTwoNumbersIfOperandIsPlusAndFirstNumberIsNegative() {
        Assert.assertEquals(-FIRST_NUMBER + SECOND_NUMBER, calculator
                .calculate(-FIRST_NUMBER, '+', SECOND_NUMBER));
    }

    @Test
    public void shouldReturnDifferenceOfTwoNumbersIfOperandIsMinus() {
        Assert.assertEquals(FIRST_NUMBER - SECOND_NUMBER, calculator
                .calculate(FIRST_NUMBER, '-', SECOND_NUMBER));
    }

    @Test
    public void shouldReturnSumOfTwoNumbersIfBothOfThemAreNegativeAndOperandIsMinus() {
        Assert.assertEquals(-FIRST_NUMBER - (-SECOND_NUMBER), calculator
                .calculate(-FIRST_NUMBER, '-', -SECOND_NUMBER));
    }

    @Test
    public void shouldReturnProductOfTwoNumbersIfOperandIsMultiply() {
        Assert.assertEquals(FIRST_NUMBER * SECOND_NUMBER, calculator
                .calculate(FIRST_NUMBER, '*', SECOND_NUMBER));
    }

    @Test
    public void shouldReturnProductOfTwoNumbersWithNegativeNumberInResultIfOneOfTwoNumbersIsNegative() {
        Assert.assertEquals(-FIRST_NUMBER * SECOND_NUMBER, calculator
                .calculate(FIRST_NUMBER, '*', -SECOND_NUMBER));
    }

    @Test
    public void shouldReturnDivisionResultOfTwoNumbersIfOperandIsDivide() {
        Assert.assertEquals(FIRST_NUMBER / SECOND_NUMBER, calculator
                .calculate(FIRST_NUMBER, '/', SECOND_NUMBER));
    }

    @Test
    public void shouldReturnNegativeNumberInResultOfDivisionIfOneOfTwoNumbersIsNegative() {
        Assert.assertEquals(-FIRST_NUMBER / SECOND_NUMBER, calculator
                .calculate(FIRST_NUMBER, '/', -SECOND_NUMBER));
    }

    @Test
    public void shouldReturnFirstNumberInExponentiationOfSecondNumber() {
        Assert.assertEquals((int) Math.pow(FIRST_NUMBER, SECOND_NUMBER), calculator
                .calculate(FIRST_NUMBER, '^', SECOND_NUMBER));
    }

    @Test
    public void shouldReturnResultOfFirstNumberToExponentiationOfZero() {
        Assert.assertEquals((int) Math.pow(FIRST_NUMBER, 0), calculator
                .calculate(FIRST_NUMBER, '^', 0));
    }

    @Test
    public void shouldReturnResultOfFirstNumberToNegativeExponentiation() {
        Assert.assertEquals((int) Math.pow(FIRST_NUMBER, -SECOND_NUMBER), calculator
                .calculate(FIRST_NUMBER, '^', -SECOND_NUMBER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenOperandIsWrong() {
        calculator
                .calculate(2, '!', 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenOneOfTwoNumbersIsZero() {
        calculator
                .calculate(2, '/', 0);
    }
}
