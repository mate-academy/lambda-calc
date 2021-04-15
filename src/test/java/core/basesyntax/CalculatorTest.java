package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static final double POSITIVE_VALUE = 636.123;
    private static final double NEGATIVE_VALUE = -570.38;
    private static final double POSITIVE_POWER = 1.3;
    private static final double NEGATIVE_POWER = - 1.3;
    private static final double ZERO = 0.0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final char NOT_CORRECT_OPERATOR = '\\';
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionWithTwoPositive() {
        double sum = calculator.calculator(
                POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        double correctResult = POSITIVE_VALUE + POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void additionWithTwoNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        double correctResult = NEGATIVE_VALUE + NEGATIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void additionWithPositiveAndNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, POSITIVE_VALUE, ADDITION);
        double correctResult = NEGATIVE_VALUE + POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void additionWithZeroInDifferentPlace() {
        double sumOne = calculator.calculator(
                ZERO, NEGATIVE_VALUE, ADDITION);
        double sumTwo = calculator.calculator(
                POSITIVE_VALUE, ZERO, ADDITION);
        double correctResultOne = ZERO + NEGATIVE_VALUE;
        double correctResultTwo = ZERO + POSITIVE_VALUE;

        Assertions.assertEquals(sumOne, correctResultOne);
        Assertions.assertEquals(sumTwo, correctResultTwo);

    }

    @Test
    public void additionMinAndMaxValues() {
        double sum = calculator.calculator(
                MIN_VALUE, MAX_VALUE, ADDITION);
        double correctResult = MIN_VALUE + MAX_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void subtractionWithTwoPositive() {
        double sum = calculator.calculator(
                POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        double correctResult = POSITIVE_VALUE - POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void subtractionWithTwoNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        double correctResult = NEGATIVE_VALUE - NEGATIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void subtractionWithPositiveAndNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        double correctResult = NEGATIVE_VALUE - POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void subtractionWithZeroInDifferentPlace() {
        double sumOne = calculator.calculator(
                ZERO, NEGATIVE_VALUE, SUBTRACTION);
        double sumTwo = calculator.calculator(
                POSITIVE_VALUE, ZERO, SUBTRACTION);
        double correctResultOne = ZERO - NEGATIVE_VALUE;
        double correctResultTwo = POSITIVE_VALUE - ZERO;

        Assertions.assertEquals(sumOne, correctResultOne);
        Assertions.assertEquals(sumTwo, correctResultTwo);
    }

    @Test
    public void subtractionMinAndMaxValues() {
        double sum = calculator.calculator(
                MIN_VALUE, MAX_VALUE, SUBTRACTION);
        double correctResult = MIN_VALUE - MAX_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void divisionWithTwoPositive() {
        double sum = calculator.calculator(
                POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        double correctResult = POSITIVE_VALUE / POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void divisionWithTwoNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        double correctResult = NEGATIVE_VALUE / NEGATIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void divisionWithPositiveAndNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, POSITIVE_VALUE, DIVISION);
        double correctResult = NEGATIVE_VALUE / POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void divisionWithZeroInDifferentPlace() {
        double sumOne = calculator.calculator(
                ZERO, NEGATIVE_VALUE, DIVISION);
        double sumTwo = calculator.calculator(
                POSITIVE_VALUE, ZERO, DIVISION);
        double correctResultOne = ZERO / NEGATIVE_VALUE;
        double correctResultTwo = POSITIVE_VALUE / ZERO;

        Assertions.assertEquals(correctResultOne, sumOne);
        Assertions.assertEquals(correctResultTwo, sumTwo);

    }

    @Test
    public void divisionMinAndMaxValues() {
        double sum = calculator.calculator(
                MIN_VALUE, MAX_VALUE, DIVISION);
        double correctResult = MIN_VALUE / MAX_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void multiplicationWithTwoPositive() {
        double sum = calculator.calculator(
                POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        double correctResult = POSITIVE_VALUE * POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void multiplicationWithTwoNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        double correctResult = NEGATIVE_VALUE * NEGATIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void multiplicationWithPositiveAndNegative() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        double correctResult = NEGATIVE_VALUE * POSITIVE_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void multiplicationWithZeroInDifferentPlace() {
        double sumOne = calculator.calculator(
                ZERO, NEGATIVE_VALUE, MULTIPLICATION);
        double sumTwo = calculator.calculator(
                POSITIVE_VALUE, ZERO, MULTIPLICATION);
        double correctResultOne = ZERO * NEGATIVE_VALUE;
        double correctResultTwo = ZERO * POSITIVE_VALUE;

        Assertions.assertEquals(sumOne, correctResultOne);
        Assertions.assertEquals(sumTwo, correctResultTwo);

    }

    @Test
    public void multiplicationMinAndMaxValues() {
        double sum = calculator.calculator(
                MIN_VALUE, MAX_VALUE, MULTIPLICATION);
        double correctResult = MIN_VALUE * MAX_VALUE;
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void positiveValueToPositivePower() {
        double sum = calculator.calculator(
                POSITIVE_VALUE, POSITIVE_POWER, POWER);
        double correctResult = Math.pow(POSITIVE_VALUE, POSITIVE_POWER);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void negativeValueToPositivePower() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, POSITIVE_POWER, POWER);
        double correctResult = Math.pow(NEGATIVE_POWER, POSITIVE_POWER);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void positiveValueToNegativePower() {
        double sum = calculator.calculator(
                POSITIVE_VALUE, NEGATIVE_POWER, POWER);
        double correctResult = Math.pow(POSITIVE_VALUE, NEGATIVE_POWER);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void negativeValueToNegativePower() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, NEGATIVE_POWER, POWER);
        double correctResult = Math.pow(NEGATIVE_POWER, NEGATIVE_POWER);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void positiveValueToZeroPower() {
        double sum = calculator.calculator(
                POSITIVE_VALUE, ZERO, POWER);
        double correctResult = Math.pow(POSITIVE_VALUE, ZERO);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void negativeValueToZeroPower() {
        double sum = calculator.calculator(
                NEGATIVE_VALUE, ZERO, POWER);
        double correctResult = Math.pow(NEGATIVE_POWER, ZERO);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void zeroValueToPower() {
        double sum = calculator.calculator(
                ZERO, POSITIVE_POWER, POWER);
        double correctResult = Math.pow(ZERO, POSITIVE_POWER);
        Assertions.assertEquals(correctResult, sum);
    }

    @Test
    public void illegalOperation() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            calculator.calculator(
                        POSITIVE_VALUE, POSITIVE_POWER, NOT_CORRECT_OPERATOR);
        });
    }
}
