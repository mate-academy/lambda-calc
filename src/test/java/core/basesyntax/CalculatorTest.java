package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double POSITIVE_FIRST = 15.0;
    private static final double POSITIVE_SECOND = 3.0;
    private static final double NEGATIVE_FIRST = -15.0;
    private static final double NEGATIVE_SECOND = -3.0;
    private static final double ZERO = 0;
    private static final double DELTA = 1e-10;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final char INCORRECT_OPERATOR = '%';
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, PLUS);
        Assert.assertEquals(18.0, actual, DELTA);
    }

    @Test
    public void additionNegativeTest() {
        double actual = calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, PLUS);
        Assert.assertEquals(-18.0, actual, DELTA);
    }

    @Test
    public void additionPositiveNegativeTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, PLUS);
        Assert.assertEquals(ZERO, actual, DELTA);
    }

    @Test
    public void subtractPositiveTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, MINUS);
        Assert.assertEquals(12.0, actual, DELTA);
    }

    @Test
    public void subtractNegativeTest() {
        double actual = calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, MINUS);
        Assert.assertEquals(-12.0, actual, DELTA);
    }

    @Test
    public void subtractPositiveNegativeTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, MINUS);
        Assert.assertEquals(30.0, actual, DELTA);
    }

    @Test
    public void multiplyTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, MULTIPLY);
        Assert.assertEquals(45.0, actual, DELTA);
    }

    @Test
    public void multiplyNegativeTest() {
        double actual = calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, MULTIPLY);
        Assert.assertEquals(45.0, actual, DELTA);
    }

    @Test
    public void multiplyPositiveNegativeTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, MULTIPLY);
        Assert.assertEquals(-225.0, actual, DELTA);
    }

    @Test
    public void multiplyByZeroTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, ZERO, MULTIPLY);
        Assert.assertEquals(ZERO, actual, DELTA);
    }

    @Test
    public void divisionPositiveTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, DIVISION);
        Assert.assertEquals(5.0, actual, DELTA);
    }

    @Test
    public void divisionNegativeTest() {
        double actual = calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, DIVISION);
        Assert.assertEquals(5.0, actual, DELTA);
    }

    @Test
    public void divisionPositiveNegativeTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, DIVISION);
        Assert.assertEquals(-1.0, actual, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroThrowsException() {
        calculator.calculate(POSITIVE_FIRST, ZERO, DIVISION);
    }

    @Test
    public void positiveToPowerTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, POWER);
        Assert.assertEquals(3375.0, actual, DELTA);
        actual = calculator.calculate(POSITIVE_FIRST, 1, POWER);
        Assert.assertEquals(POSITIVE_FIRST, actual, DELTA);
    }

    @Test
    public void negativeToPowerTest() {
        double actual = calculator.calculate(NEGATIVE_FIRST, POSITIVE_SECOND, POWER);
        Assert.assertEquals(-3375.0, actual, DELTA);
    }

    @Test
    public void toNegativePowerTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, POWER);
        Assert.assertEquals(Math.pow(15.0, -3.0), actual, DELTA);
    }

    @Test
    public void toZeroPowerTest() {
        double actual = calculator.calculate(POSITIVE_FIRST, ZERO, POWER);
        Assert.assertEquals(1.0, actual, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidOperationThrowsException() {
        calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, INCORRECT_OPERATOR);
    }
}
