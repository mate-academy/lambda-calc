package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorImplTest {
    private static final String[] ARGUMENTS_FOR_ADDITIONAL = {"5", "+", "5"};
    private static final String[] ARGUMENTS_FOR_SUBTRACTION = {"10", "-", "5"};
    private static final String[] ARGUMENTS_FOR_MULT = {"5", "*", "5"};
    private static final String[] ARGUMENTS_FOR_DIVISION = {"25", "/", "5"};
    private static final String[] ARGUMENTS_WITH_ZERO_MULT = {"10", "*", "0"};
    private static final String[] ARGUMENTS_WITH_ZERO_DIV = {"10", "/", "0"};
    private static final String[] ARGUMENTS_WITH_LETTERS = {"w", "+", "q"};
    private static final String[] NOT_ENOUGH_ARGUMENTS = {"2", "+"};
    private static final String[] ARGUMENTS_WITH_INVALID_MATH_SYMBOL = {"2", "&", "2"};
    private static final String[] ARGUMENTS_WITH_NULL = {null, "-", null};
    private CalculatorImpl calculator;

    @Before
    public void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void checkAddition() {
        double result = calculator.executor(ARGUMENTS_FOR_ADDITIONAL);
        Assert.assertEquals(10, result, 0);
    }

    @Test
    public void checkSubtraction() {
        double result = calculator.executor(ARGUMENTS_FOR_SUBTRACTION);
        Assert.assertEquals(5, result, 0);
    }

    @Test
    public void checkMult() {
        double result = calculator.executor(ARGUMENTS_FOR_MULT);
        Assert.assertEquals(25, result, 0);
    }

    @Test
    public void checkDivision() {
        double result = calculator.executor(ARGUMENTS_FOR_DIVISION);
        Assert.assertEquals(5, result, 0);
    }

    @Test
    public void multiplicationWithZero() {
        double result = calculator.executor(ARGUMENTS_WITH_ZERO_MULT);
        Assert.assertEquals(0, result, 0);
    }

    @Test
    public void divisionWithZero() {
        double result = calculator.executor(ARGUMENTS_WITH_ZERO_DIV);
        Assert.assertEquals(0, result, 0);
    }

    @Test(expected = NumberFormatException.class)
    public void argumentsWithLetters() {
        calculator.executor(ARGUMENTS_WITH_LETTERS);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void notEnoughArguments(){
        Assert.assertEquals(2, NOT_ENOUGH_ARGUMENTS.length);
        calculator.executor(NOT_ENOUGH_ARGUMENTS);
    }

    @Test(expected = NullPointerException.class)
    public void argumentsWithInvalidArithmeticSymbol() {
        calculator.executor(ARGUMENTS_WITH_INVALID_MATH_SYMBOL);
    }

    @Test(expected = NullPointerException.class)
    public void argumentsWithNull() {
        calculator.executor(ARGUMENTS_WITH_NULL);
    }


}
