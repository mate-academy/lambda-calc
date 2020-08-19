package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char DIV = '/';
    private static final char MULT = '*';
    private static final char POW = '^';
    private static final double ZERO = 0.0;
    private static final double FIRST_OPERAND = 5;
    private static final double SECOND_OPERAND = 8;
    private static final double FIRST_NEGATIVE_OPERAND = -6;
    private static final double SECOND_NEGATIVE_OPERAND = -10;
    private static final char ILLEGAL_OPERATOR = '!';
    private static final double DELTA = 0.001;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void addition_ok() {
        double expected = FIRST_OPERAND + SECOND_OPERAND;
        double actual = calculator.calculate(FIRST_OPERAND, ADD, SECOND_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeAddition_ok() {
        double expected = FIRST_NEGATIVE_OPERAND + SECOND_NEGATIVE_OPERAND;
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, ADD, SECOND_NEGATIVE_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtraction_ok() {
        double expected = FIRST_OPERAND - SECOND_OPERAND;
        double actual = calculator.calculate(FIRST_OPERAND, SUB, SECOND_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeSubtraction_ok() {
        double expected = FIRST_NEGATIVE_OPERAND - SECOND_NEGATIVE_OPERAND;
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SUB, SECOND_NEGATIVE_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void division_ok() {
        double expected = FIRST_OPERAND / SECOND_OPERAND;
        double actual = calculator.calculate(FIRST_OPERAND, DIV, SECOND_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeDivision_ok() {
        double expected = FIRST_NEGATIVE_OPERAND / SECOND_NEGATIVE_OPERAND;
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, DIV, SECOND_NEGATIVE_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplication_ok() {
        double expected = FIRST_OPERAND * SECOND_OPERAND;
        double actual = calculator.calculate(FIRST_OPERAND, MULT, SECOND_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeMultiplication_ok() {
        double expected = FIRST_NEGATIVE_OPERAND * SECOND_NEGATIVE_OPERAND;
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, MULT, SECOND_NEGATIVE_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void risingToPower_ok() {
        double expected = Math.pow(FIRST_OPERAND, SECOND_OPERAND);
        double actual = calculator.calculate(FIRST_OPERAND, POW, SECOND_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeRisingToPower_ok() {
        double expected = Math.pow(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND);
        double actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, POW, SECOND_NEGATIVE_OPERAND);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
            calculator.calculate(FIRST_OPERAND, DIV, ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalOperatorTest() {
            calculator.calculate(FIRST_OPERAND, ILLEGAL_OPERATOR, SECOND_OPERAND);
    }
}
