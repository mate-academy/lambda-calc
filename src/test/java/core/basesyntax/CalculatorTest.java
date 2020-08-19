package core.basesyntax;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert;


public class CalculatorTest {

    private final static double DELTA = 0.001;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void getSumOfTwoPositiveNumbers() {
        double actualResult = calculator.calculate(12.5, 33.5, '+');
        Assert.assertEquals(46, actualResult, DELTA);
    }

    @Test
    public void getSumOfTwoNegativeAndPositiveNumbers() {
        double actualResult = calculator.calculate(58, -58, '+');
        Assert.assertEquals(0, actualResult, DELTA);
    }

    @Test
    public void getSumOfTwoNegativeNumbers() {
        double actualResult = calculator.calculate(-12, -5, '+');
        Assert.assertEquals(-17, actualResult, DELTA);
    }

    @Test
    public void getSumWithNull() {
        double actualResult = calculator.calculate(0, 33.5, '+');
        Assert.assertEquals(33.5, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultOfDividingByNull() {
        calculator.calculate(34, 0, '/');
    }

    @Test
    public void getResultOfDividingNullByNotNull() {
        double actualResult = calculator.calculate(0, 7, '/');
        Assert.assertEquals(0, actualResult, DELTA);
    }

    @Test
    public void getResultOfDividingNotNullByNotNull() {
        double actualResult = calculator.calculate(45, 5, '/');
        Assert.assertEquals(9, actualResult, DELTA);
    }

    @Test
    public void getResultBySubtractionOfTwoNegativeNumbers() {
        double actualResult = calculator.calculate(-2, -7, '-');
        Assert.assertEquals(5, actualResult, DELTA);
    }

    @Test
    public void getResultBySubtractionOfTwoNegativeAndPositiveNumbers() {
        double actualResult = calculator.calculate(2, -7, '-');
        Assert.assertEquals(9, actualResult, DELTA);
    }

    @Test
    public void getResultBySubtractionWithNull() {
        double actualResult = calculator.calculate(0, -7, '-');
        Assert.assertEquals(7, actualResult, DELTA);
    }

    @Test(expected = BadOperandException.class)
    public void getResultWithBadOperand() {
        calculator.calculate(5, 3, '9');
    }

    @Test
    public void getResultWithMultiplicationWithNull() {
        double actualResult = calculator.calculate(45, 0, '*');
        Assert.assertEquals(0, actualResult, DELTA);
    }

    @Test
    public void getResultWithMultiplicationWithPositiveNumbers() {
        double actualResult = calculator.calculate(5, 8, '*');
        Assert.assertEquals(40, actualResult, DELTA);
    }

    @Test
    public void getResultWithMultiplicationWithPositiveAndNegativeNumbers() {
        double actualResult = calculator.calculate(-1.5, 5.2, '*');
        Assert.assertEquals(-7.800000000000001, actualResult, DELTA);
    }

    @Test
    public void getResultWithMultiplicationWithNegativeNumbers() {
        double actualResult = calculator.calculate(-17, -80, '*');
        Assert.assertEquals(1360, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultWithNullBasisAndNegativeDegree() {
        calculator.calculate(0, -10, '^');
    }

    @Test
    public void getResultWithNullBasisAndNullDegree() {
        double actualResult = calculator.calculate(0, 0, '^');
        Assert.assertEquals(1, actualResult, DELTA);
    }

    @Test
    public void getResultWithPositiveBasisAndNegativeIntegerDegree() {
        double actualResult = calculator.calculate(2, -1, '^');
        Assert.assertEquals(0.5, actualResult, DELTA);
    }

    @Test
    public void getResultWithPositiveBasisAndNegativeDoubleDegree() {
        double actualResult = calculator.calculate(4, -0.5, '^');
        Assert.assertEquals(0.5, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultWithNegativeBasisAndPairedDegree() {
        double actualResult = calculator.calculate(-16, -2, '^');
    }
}
