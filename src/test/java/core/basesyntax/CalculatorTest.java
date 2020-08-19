package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.000_001;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POW = '^';
    private static final char WRONG_SIGN1 = '?';
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveDigits() {
        double actualResult = calculator.calculate(5.1, 2.0, PLUS);
        Assert.assertEquals(7.1, actualResult, DELTA);
    }

    @Test
    public void additionPositiveAndNegativeDigits() {
        double actualResult = calculator.calculate(1.2, -5.9, PLUS);
        Assert.assertEquals(-4.7, actualResult, DELTA);
    }

    @Test
    public void additionNegativesDigits() {
        double actualResult = calculator.calculate(-1.2, -5.9, PLUS);
        Assert.assertEquals(-7.1, actualResult, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void additionDoubleMaxValue() {
       calculator.calculate(Double.MAX_VALUE, 55.8, PLUS);
    }

    @Test (expected = ArithmeticException.class)
    public void substractionDoubleMinValue() {
        calculator.calculate(Double.MIN_VALUE, 10000.0, MINUS);
    }

    @Test
    public void substractionPositiveDigits() {
        double actualResult = calculator.calculate(5.1, 2.0, MINUS);
        Assert.assertEquals(3.1, actualResult, DELTA);
    }

    @Test
    public void substractionPositiveAndNegativeDigits() {
        double actualResult = calculator.calculate(3.0, -8.4, MINUS);
        Assert.assertEquals(11.4, actualResult, DELTA);
    }


    @Test
    public void substractionNegativeDigits() {
        double actualResult = calculator.calculate(-3.2, -8.9, MINUS);
        Assert.assertEquals(5.7, actualResult, DELTA);
    }

    @Test
    public void multiplicationPositiveDigits() {
        double actualResult = calculator.calculate(5.0, 5.9, MULTIPLY);
        Assert.assertEquals(29.5, actualResult, DELTA);
    }

    @Test
    public void multiplicationPositiveAndNegativeDigits() {
        double actualResult = calculator.calculate(-5.0, 5.9, MULTIPLY);
        Assert.assertEquals(-29.5, actualResult, DELTA);
    }

    @Test
    public void multiplicationNegativeDigits() {
        double actualResult = calculator.calculate(-5.0, -5.9, MULTIPLY);
        Assert.assertEquals(29.5, actualResult, DELTA);
    }

    @Test
    public void divisionPositiveDigits() {
        double actualResult = calculator.calculate(20.5, 5.0, DIVIDE);
        Assert.assertEquals(4.1, actualResult, DELTA);
    }

    @Test
    public void divisionPositiveAndNegativeDigits() {
        double actualResult = calculator.calculate(15.0, -5.9, DIVIDE);
        Assert.assertEquals(-2.542372881355932, actualResult, DELTA);
    }

    @Test
    public void divisionNegativeDigits() {
        double actualResult = calculator.calculate(-15.0, -5.9, DIVIDE);
        Assert.assertEquals(2.542372881355932, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(5.0, 0, DIVIDE);
    }

    @Test
    public void powToPositiveDigit() {
        double actualResult = calculator.calculate(5.0, 2.0, POW);
        Assert.assertEquals(25.0, actualResult, DELTA);
    }

    @Test
    public void powToNegativeDigit() {
        double actualResult = calculator.calculate(5.0, -2.0, POW);
        Assert.assertEquals(0.04, actualResult, DELTA);
    }

    @Test
    public void powToFloatDigit() {
        double actualResult = calculator.calculate(25.0, 0.5, POW);
        Assert.assertEquals(5.0, actualResult, DELTA);
    }

    @Test
    public void powToZero() {
        double actualResult = calculator.calculate(10.0, 0, POW);
        Assert.assertEquals(1, actualResult, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongSign() {
        calculator.calculate(5.0, 1.0, WRONG_SIGN1);
    }
}
