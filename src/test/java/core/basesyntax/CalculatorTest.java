package core.basesyntax;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static final Double DELTA = 0.01;
    private static final Double ZERO_VALUE = 0.;
    private static final Double FIRST_VALUE = 4.;
    private static final Double SECOND_VALUE = 12.;
    private static final Double NEGATIVE_VALUE = -8.;
    private static final Double NULL_VALUE = null;
    private static final char ADDITION_SIGN = '+';
    private static final char SUBTRACTION_SIGN = '-';
    private static final char DIVISION_SIGN = '/';
    private static final char MULTIPLICATION_SIGN = '*';
    private static final char RAISING_TO_THE_POWER_SIGN = '^';
    private static final char UNSUPPORTED_SIGN = '$';
    private Calculator calculator;

    @Before
    public void createCalculatorInstance() {
        calculator = new Calculator();
    }

    @After
    public void deleteCalculatorInstance() {
        calculator = null;
    }

    @Test
    public void getAddingResultInDifferentCases() {
        try {
            double actualFirstPlusSecond = calculator.calculate(FIRST_VALUE, ADDITION_SIGN, SECOND_VALUE);
            double actualFirstPlusNegative = calculator.calculate(FIRST_VALUE, ADDITION_SIGN, NEGATIVE_VALUE);

            double expectedFirstPlusSecond = 16.;
            double expectedFirstPlusNegative = -4.;

            Assert.assertEquals(expectedFirstPlusSecond, actualFirstPlusSecond, DELTA);
            Assert.assertEquals(expectedFirstPlusNegative, actualFirstPlusNegative, DELTA);
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test(expected = NullPointerException.class)
    public void getAddingResultInNullCase() {
        try {
            Assert.assertNull(calculator.calculate(FIRST_VALUE, ADDITION_SIGN, NULL_VALUE));
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test
    public void getSubtractingResultInDifferentCases() {
        try {
            double actualFirstMinusSecond = calculator.calculate(FIRST_VALUE, SUBTRACTION_SIGN, SECOND_VALUE);
            double actualFirstMinusNegative = calculator.calculate(FIRST_VALUE, SUBTRACTION_SIGN, NEGATIVE_VALUE);

            double expectedFirstMinusSecond = -8.;
            double expectedFirstMinusNegative = 12.;

            Assert.assertEquals(expectedFirstMinusSecond, actualFirstMinusSecond, DELTA);
            Assert.assertEquals(expectedFirstMinusNegative, actualFirstMinusNegative, DELTA);
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test(expected = NullPointerException.class)
    public void getSubtractingResultInNullCase() {
        try {
            Assert.assertNull(calculator.calculate(FIRST_VALUE, SUBTRACTION_SIGN, NULL_VALUE));
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test
    public void getDivisionResultInDifferentCases() {
        try {
            double actualSecondDivideFirst = calculator.calculate(SECOND_VALUE, DIVISION_SIGN, FIRST_VALUE);
            double actualNegativeDivideFirst = calculator.calculate(NEGATIVE_VALUE, DIVISION_SIGN, FIRST_VALUE);
            double actualZeroDivideFirst = calculator.calculate(ZERO_VALUE, DIVISION_SIGN, FIRST_VALUE);

            double expectedSecondDivideFirst = 3.;
            double expectedNegativeDivideFirst = -2.;
            double expectedZeroDivideFirst = 0.;

            Assert.assertEquals(expectedSecondDivideFirst, actualSecondDivideFirst, DELTA);
            Assert.assertEquals(expectedNegativeDivideFirst, actualNegativeDivideFirst, DELTA);
            Assert.assertEquals(expectedZeroDivideFirst, actualZeroDivideFirst, DELTA);
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test(expected = NullPointerException.class)
    public void getDivisionResultInNullCase() {
        try {
            Assert.assertNull(calculator.calculate(FIRST_VALUE, DIVISION_SIGN, NULL_VALUE));
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test
    public void getDivisionResultInDivideByZeroCase() {
        try {
            Assert.assertTrue(Double.isInfinite(calculator.calculate(FIRST_VALUE, DIVISION_SIGN, ZERO_VALUE)));
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test
    public void getMultiplicationResultInDifferentCases() {
        try {
            double actualFirstMultiplySecond = calculator.calculate(FIRST_VALUE, MULTIPLICATION_SIGN, SECOND_VALUE);
            double actualFirstMultiplyNegative = calculator.calculate(FIRST_VALUE, MULTIPLICATION_SIGN, NEGATIVE_VALUE);
            double actualZeroMultiplyFirst = calculator.calculate(ZERO_VALUE, MULTIPLICATION_SIGN, FIRST_VALUE);

            double expectedFirstMultiplySecond = 48.;
            double expectedFirstMultiplyNegative = -32.;
            double expectedZeroMultiplyFirst = 0.;

            Assert.assertEquals(expectedFirstMultiplySecond, actualFirstMultiplySecond, DELTA);
            Assert.assertEquals(expectedFirstMultiplyNegative, actualFirstMultiplyNegative, DELTA);
            Assert.assertEquals(expectedZeroMultiplyFirst, actualZeroMultiplyFirst, DELTA);
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test(expected = NullPointerException.class)
    public void getMultiplicationResultInNullCase() {
        try {
            Assert.assertNull(calculator.calculate(FIRST_VALUE, MULTIPLICATION_SIGN, NULL_VALUE));
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test
    public void getRaisingToThePowerResultInDifferentCases() {
        try {
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
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test(expected = NullPointerException.class)
    public void getRaisingToThePowerResultInNullValueCase() {
        try {
            Assert.assertNull(calculator.calculate(NULL_VALUE, RAISING_TO_THE_POWER_SIGN, FIRST_VALUE));
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test(expected = NullPointerException.class)
    public void getRaisingToThePowerResultInNullRaiseCase() {
        try {
            Assert.assertNull(calculator.calculate(FIRST_VALUE, RAISING_TO_THE_POWER_SIGN, NULL_VALUE));
        } catch (UnsupportedOperationException e) {
            Assert.fail();
        }
    }

    @Test
    public void getResultWithUnsupportedOperationValue() {
        try {
            calculator.calculate(FIRST_VALUE, UNSUPPORTED_SIGN, SECOND_VALUE);
        } catch (UnsupportedOperationException e) {
            assertEquals(e.getMessage(), "Unsupported operation");
            return;
        }
    }
}