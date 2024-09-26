package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final char ILLEGAL_OPERATIONS = '?';
    private static final double POSITIVE_NUMBER = 20.4;
    private static final double NEGATIVE_NUMBER = -10.2;
    private static final double ZERO = 0;
    private static final int POSITIVE_EXPONENT = 4;
    private static final int NEGATIVE_EXPONENT = -4;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    private static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void calculate_additionTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ADDITION);
        expected = 40.8;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = -20.4;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ADDITION);
        expected = 10.2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
   public void calculate_additionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, ADDITION);
        expected = 20.4;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, ADDITION);
        expected = -10.2;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionTwoDoubleMinValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionTwoDoubleMaxValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionWithMaxAndMinDoubleValues_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, SUBTRACTION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, SUBTRACTION);
        expected = 30.6;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, SUBTRACTION);
        expected = -20.4;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, SUBTRACTION);
        expected = 20.4;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionTwoDoubleMinValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionTwoDoubleMaxValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionWithMaxAndMinDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        expected = -2;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithZeroInSecondOperand_ArithmeticException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    public void calculate_divisionTwoDoubleMinValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionTwoDoubleMaxValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionWithMaxAndMinDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithTwoPositiveOperands_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = 416.16;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationTwoNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        expected = 104.04;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithPositiveAndNegativeOperands_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        expected = -208.08;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationWithZeroInFirstOperand_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithZeroInSecondOperand_isOk() {
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationTwoDoubleMinValue_isOk() {
        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationTwoDoubleMaxValue_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationWithMaxAndMinDoubleValues_isOk() {
        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingToPositivePower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_EXPONENT, POWER);
        expected = 10824.321599999997;
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_EXPONENT, POWER);
        expected = 173189.14559999996;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingToNegativePower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_EXPONENT, POWER);
        expected = 0.00009238454260265145;
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_EXPONENT, POWER);
        expected = 0.000005774033912665716;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingToZeroPower_isOk() {
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, POWER);
        expected = 1;
        assertEquals(expected, actual);
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisingZeroToPower_isOk() {
        actual = calculator.calculate(ZERO, POSITIVE_EXPONENT, POWER);
        expected = 0;
        assertEquals(expected, actual);
        actual = calculator.calculate(ZERO, NEGATIVE_EXPONENT, POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_illegalOperation_RuntimeException() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATIONS));
    }
}
