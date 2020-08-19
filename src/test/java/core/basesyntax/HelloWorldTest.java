package core.basesyntax;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert;


public class HelloWorldTest {
    private final static double DELTA = 0.00000001;
    private final static double SUM_OF_TWO_POSITIVE_NUMBERS = 46.0;
    private final static double SUM_OF_TWO_POSITIVE_AND_NEGATIVE_NUMBERS = 0;
    private final static double RESULT_OF_DIVIDING_BY_NOT_NULL = 45 / 7.0;
    private final static double RESULT_BY_SUBTRACTION_OF_TWO_NEGATIVE_NUMBERS = 5;
    private final static double RESULT_WITH_MULTIPLICATION_WITH_NULL = 0;
    private final static double RESULT_WITH_NULL_BASIS_AND_NULL_DEGREE = 1;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void getSumOfTwoPositiveNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(12.5, 33.5, '+');
        Assert.assertEquals(SUM_OF_TWO_POSITIVE_NUMBERS, actualResult, DELTA);
    }

    @Test
    public void getSumOfTwoNegativeAndPositiveNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(58, -58, '+');
        Assert.assertEquals(SUM_OF_TWO_POSITIVE_AND_NEGATIVE_NUMBERS, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultOfDividingByNull() throws BadOperandException {
        calculator.calculate(34, 0, '/');
    }

    @Test
    public void getResultOfDividingByNotNull() throws BadOperandException {
        double actualResult = calculator.calculate(45, 7, '/');
        Assert.assertEquals(RESULT_OF_DIVIDING_BY_NOT_NULL, actualResult, DELTA);
    }

    @Test
    public void getResultBySubtractionOfTwoNegativeNumbers() throws BadOperandException {
        double actualResult = calculator.calculate(-2, -7, '-');
        Assert.assertEquals(RESULT_BY_SUBTRACTION_OF_TWO_NEGATIVE_NUMBERS, actualResult, DELTA);
    }

    @Test(expected = BadOperandException.class)
    public void getResultWithBadOperand() throws BadOperandException {
        calculator.calculate(5, 3, '9');
    }

    @Test
    public void getResultWithMultiplicationWithNull() throws BadOperandException {
        double actualResult = calculator.calculate(45, 0, '*');
        Assert.assertEquals(RESULT_WITH_MULTIPLICATION_WITH_NULL, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultWithNullBasisAndNegativeDegree() throws BadOperandException {
        calculator.calculate(0, -10, '^');
    }

    @Test
    public void getResultWithNullBasisAndNullDegree() throws BadOperandException {
        double actualResult = calculator.calculate(0, 0, '^');
        Assert.assertEquals(RESULT_WITH_NULL_BASIS_AND_NULL_DEGREE, actualResult, DELTA);
    }
}
