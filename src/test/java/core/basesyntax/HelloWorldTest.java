package core.basesyntax;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert;


public class HelloWorldTest {

    private final static double DELTA = 0.001;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void getSumOfTwoPositiveNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(12.5, 33.5, '+');
        Assert.assertEquals(46, actualResult, DELTA);
    }

    @Test
    public void getSumOfTwoNegativeAndPositiveNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(58, -58, '+');
        Assert.assertEquals(0, actualResult, DELTA);
    }

    @Test
    public void getSumOfTwoNegativeNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(-12, -5, '+');
        Assert.assertEquals(-17, actualResult, DELTA);
    }

    @Test
    public void getSumWithNull() throws BadOperandException {
        double actualResult = calculator.calculate(0, 33.5, '+');
        Assert.assertEquals(33.5, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultOfDividingByNull() throws BadOperandException {
        calculator.calculate(34, 0, '/');
    }

    @Test
    public void getResultOfDividingNullByNotNull() throws BadOperandException {
        double actualResult = calculator.calculate(0, 7, '/');
        Assert.assertEquals(0, actualResult, DELTA);
    }

    @Test
    public void getResultOfDividingNotNullByNotNull() throws BadOperandException {
        double actualResult = calculator.calculate(45, 5, '/');
        Assert.assertEquals(9, actualResult, DELTA);
    }

    @Test
    public void getResultBySubtractionOfTwoNegativeNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(-2, -7, '-');
        Assert.assertEquals(5, actualResult, DELTA);
    }

    @Test
    public void getResultBySubtractionOfTwoNegativeAndPositiveNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(2, -7, '-');
        Assert.assertEquals(9, actualResult, DELTA);
    }

    @Test
    public void getResultBySubtractionWithNull() throws BadOperandException {
        double actualResult = calculator.calculate(0, -7, '-');
        Assert.assertEquals(7, actualResult, DELTA);
    }

    @Test(expected = BadOperandException.class)
    public void getResultWithBadOperand() throws BadOperandException {
        calculator.calculate(5, 3, '9');
    }

    @Test
    public void getResultWithMultiplicationWithNull() throws BadOperandException {
        double actualResult = calculator.calculate(45, 0, '*');
        Assert.assertEquals(0, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultWithNullBasisAndNegativeDegree() throws BadOperandException {
        calculator.calculate(0, -10, '^');
    }

    @Test
    public void getResultWithNullBasisAndNullDegree() throws BadOperandException {
        double actualResult = calculator.calculate(0, 0, '^');
        Assert.assertEquals(1, actualResult, DELTA);
    }

    @Test
    public void getResultWithPositiveBasisAndNegativeIntegerDegree() throws BadOperandException {
        double actualResult = calculator.calculate(2, -1, '^');
        Assert.assertEquals(0.5, actualResult, DELTA);
    }

    @Test
    public void getResultWithPositiveBasisAndNegativeDoubleDegree() throws BadOperandException {
        double actualResult = calculator.calculate(4, -0.5, '^');
        Assert.assertEquals(0.5, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultWithNegativeBasisAndPairedDegree() throws BadOperandException {
        double actualResult = calculator.calculate(-16, -2, '^');
    }
}
