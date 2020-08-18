package core.basesyntax;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static final double DELTA = 0.01;
    private static final double ZERO_VALUE = 0.;
    private static final double FIRST_VALUE = 4.;
    private static final double SECOND_VALUE = 12.;
    private static final double NEGATIVE_VALUE = -8.;
    private static final char ADDITION_SIGN = '+';
    private static final char SUBTRACTION_SIGN = '-';
    private static final char DIVISION_SIGN = '/';
    private static final char MULTIPLICATION_SIGN = '*';
    private static final char RAISING_TO_THE_POWER_SIGN = '^';
    private static final char UNSUPPORTED_SIGN = '$';
    private static Calculator calculator;

    @BeforeClass
    public static void createCalculatorInstance() {
        calculator = new Calculator();
    }

    @AfterClass
    public static void deleteCalculatorInstance() {
        calculator = null;
    }

    @Test
    public void getAddingResultInDifferentCases() {
        double actualFirstPlusSecond = calculator.calculate(FIRST_VALUE, ADDITION_SIGN, SECOND_VALUE);
        double actualFirstPlusNegative = calculator.calculate(FIRST_VALUE, ADDITION_SIGN, NEGATIVE_VALUE);

        double expectedFirstPlusSecond = 16.;
        double expectedFirstPlusNegative = -4.;

        Assert.assertEquals(expectedFirstPlusSecond, actualFirstPlusSecond, DELTA);
        Assert.assertEquals(expectedFirstPlusNegative, actualFirstPlusNegative, DELTA);
    }

    @Test
    public void getSubtractingResultInDifferentCases() {
        double actualFirstMinusSecond = calculator.calculate(FIRST_VALUE, SUBTRACTION_SIGN, SECOND_VALUE);
        double actualFirstMinusNegative = calculator.calculate(FIRST_VALUE, SUBTRACTION_SIGN, NEGATIVE_VALUE);

        double expectedFirstMinusSecond = -8.;
        double expectedFirstMinusNegative = 12.;

        Assert.assertEquals(expectedFirstMinusSecond, actualFirstMinusSecond, DELTA);
        Assert.assertEquals(expectedFirstMinusNegative, actualFirstMinusNegative, DELTA);
    }

    @Test
    public void getDivisionResultInDifferentCases() {
        double actualSecondDivideFirst = calculator.calculate(SECOND_VALUE, DIVISION_SIGN, FIRST_VALUE);
        double actualNegativeDivideFirst = calculator.calculate(NEGATIVE_VALUE, DIVISION_SIGN, FIRST_VALUE);
        double actualZeroDivideFirst = calculator.calculate(ZERO_VALUE, DIVISION_SIGN, FIRST_VALUE);

        double expectedSecondDivideFirst = 3.;
        double expectedNegativeDivideFirst = -2.;
        double expectedZeroDivideFirst = 0.;

        Assert.assertEquals(expectedSecondDivideFirst, actualSecondDivideFirst, DELTA);
        Assert.assertEquals(expectedNegativeDivideFirst, actualNegativeDivideFirst, DELTA);
        Assert.assertEquals(expectedZeroDivideFirst, actualZeroDivideFirst, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getDivisionResultInDivideByZeroCase() {
        calculator.calculate(FIRST_VALUE, DIVISION_SIGN, ZERO_VALUE);
    }

    @Test
    public void getMultiplicationResultInDifferentCases() {
        double actualFirstMultiplySecond = calculator.calculate(FIRST_VALUE, MULTIPLICATION_SIGN, SECOND_VALUE);
        double actualFirstMultiplyNegative = calculator.calculate(FIRST_VALUE, MULTIPLICATION_SIGN, NEGATIVE_VALUE);
        double actualZeroMultiplyFirst = calculator.calculate(ZERO_VALUE, MULTIPLICATION_SIGN, FIRST_VALUE);

        double expectedFirstMultiplySecond = 48.;
        double expectedFirstMultiplyNegative = -32.;
        double expectedZeroMultiplyFirst = 0.;

        Assert.assertEquals(expectedFirstMultiplySecond, actualFirstMultiplySecond, DELTA);
        Assert.assertEquals(expectedFirstMultiplyNegative, actualFirstMultiplyNegative, DELTA);
        Assert.assertEquals(expectedZeroMultiplyFirst, actualZeroMultiplyFirst, DELTA);
    }

    @Test
    public void getRaisingToThePowerResultInDifferentCases() {
        double actualFirstRaisingSecond = calculator.calculate(FIRST_VALUE, RAISING_TO_THE_POWER_SIGN, SECOND_VALUE);
        double actualFirstRaisingNegative = calculator.calculate(FIRST_VALUE, RAISING_TO_THE_POWER_SIGN, NEGATIVE_VALUE);
        double actualNegativeRaisingFirst = calculator.calculate(NEGATIVE_VALUE, RAISING_TO_THE_POWER_SIGN, FIRST_VALUE);
        double actualZeroRaisingFirst = calculator.calculate(ZERO_VALUE, RAISING_TO_THE_POWER_SIGN, FIRST_VALUE);
        double actualFirstRaisingZero = calculator.calculate(FIRST_VALUE, RAISING_TO_THE_POWER_SIGN, ZERO_VALUE);

        double expectedFirstRaisingSecond = 16777216.;
        double expectedFirstRaisingNegative = .0000152587890625;
        double expectedNegativeRaisingFirst = 4096.;
        double expectedZeroRaisingFirst = 0.;
        double expectedFirstRaisingZero = 1.;

        Assert.assertEquals(expectedFirstRaisingSecond, actualFirstRaisingSecond, DELTA);
        Assert.assertEquals(expectedFirstRaisingNegative, actualFirstRaisingNegative, DELTA);
        Assert.assertEquals(expectedNegativeRaisingFirst, actualNegativeRaisingFirst, DELTA);
        Assert.assertEquals(expectedZeroRaisingFirst, actualZeroRaisingFirst, DELTA);
        Assert.assertEquals(expectedFirstRaisingZero, actualFirstRaisingZero, DELTA);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getResultWithUnsupportedOperationValue() {
        calculator.calculate(FIRST_VALUE, UNSUPPORTED_SIGN, SECOND_VALUE);
    }
}