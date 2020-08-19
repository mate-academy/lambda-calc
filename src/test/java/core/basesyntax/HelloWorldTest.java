package core.basesyntax;

import org.junit.*;

public class HelloWorldTest {
    private HelloWorld helloWorld;
    private final static double SUM_OF_TWO_POSITIVE_NUMBERS = 46.0;
    private final static double SUM_OF_TWO_POSITIVE_AND_NEGATIVE_NUMBERS = 0;
    private final static double ResultOfDividingByNotNull = 45 / 7.0;
    private final static double ResultBySubtractionOfTwoNegativeNumbers = 5;
    private final static double ResultWithMultiplicationWithNull = 0;
    private final static double ResultWithNullBasisAndNullDegree = 1;

    @Before
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @After
    public void tearDown() {
        helloWorld = null;
    }

    @Test
    public void getSumOfTwoPositiveNumbers() throws BadOperandException {
        double actualResult = helloWorld.calculate(12.5, 33.5, '+');
        double expectedResult = SUM_OF_TWO_POSITIVE_NUMBERS;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getSumOfTwoNegativeAndPositiveNumbers() throws BadOperandException {
        double actualResult = helloWorld.calculate(58, -58, '+');
        double expectedResult = SUM_OF_TWO_POSITIVE_AND_NEGATIVE_NUMBERS;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultOfDividingByNull() throws BadOperandException {
        helloWorld.calculate(34, 0, '/');
    }

    @Test
    public void getResultOfDividingByNotNull() throws BadOperandException {
        double actualResult = helloWorld.calculate(45, 7, '/');
        double expectedResult = ResultOfDividingByNotNull;
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void getResultBySubtractionOfTwoNegativeNumbers() throws BadOperandException {
        double actualResult = helloWorld.calculate(-2, -7, '-');
        double expectedResult = ResultBySubtractionOfTwoNegativeNumbers;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test(expected = BadOperandException.class)
    public void getResultWithBadOperand() throws BadOperandException {
        helloWorld.calculate(5, 3, '9');
    }

    @Test
    public void getResultWithMultiplicationWithNull() throws BadOperandException {
        double actualResult = helloWorld.calculate(45, 0, '*');
        double expectedResult = ResultWithMultiplicationWithNull;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void getResultWithNullBasisAndNegativeDegree() throws BadOperandException {
        helloWorld.calculate(0, -10, '^');
    }

    @Test
    public void getResultWithNullBasisAndNullDegree() throws BadOperandException {
        double actualResult = helloWorld.calculate(0, 0, '^');
        double expectedResult = ResultWithNullBasisAndNullDegree;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }
}
