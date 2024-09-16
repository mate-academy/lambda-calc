package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION_SIGN = '+';
    private static final char SUBTRACTION_SIGN = '-';
    private static final char MULTIPLICATION_SIGN = '*';
    private static final char DIVISION_SIGN = '/';
    private static final char RAISING_SIGN = '^';
    private static final double DELTA = 0.0001;
    private Calculator calculator;
    private double expected;
    private double actual;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithPositiveOperands_IsOk() {
        expected = 13.37;
        actual = calculator.calculate(12.37,1, ADDITION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithNegativeOperands_IsOk() {
        expected = -14.01;
        actual = calculator.calculate(-12,-2.01, ADDITION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithOneNegativeOperandAndOnePositive_IsOk() {
        expected = -36;
        actual = calculator.calculate(-100,64, ADDITION_SIGN);
        assertEquals(expected, actual);
        actual = calculator.calculate(64,-100, ADDITION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZero_IsOk() {
        expected = 0.02;
        actual = calculator.calculate(0,0.02, ADDITION_SIGN);
        assertEquals(expected, actual);
        actual = calculator.calculate(0.02,0, ADDITION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionMaxOperands_IsOk() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION_SIGN);
        assertEquals(expected, actual);
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinOperands_IsOk() {
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION_SIGN);
        assertEquals(expected, actual, DELTA);
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADDITION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveOperands_IsOk() {
        expected = 401;
        actual = calculator.calculate(800,399,SUBTRACTION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithNegativeOperands_IsOk() {
        expected = 5;
        actual = calculator.calculate(-10,-15, SUBTRACTION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithOneNegativeOperandAndOnePositive_IsOk() {
        expected = 110;
        actual = calculator.calculate(90,-20,SUBTRACTION_SIGN);
        assertEquals(expected, actual);
        expected = -60;
        actual = calculator.calculate(-40,20, SUBTRACTION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZero_IsOk() {
        expected = -1;
        actual = calculator.calculate(-1,0, SUBTRACTION_SIGN);
        assertEquals(expected, actual);
        actual = calculator.calculate(-1,0, SUBTRACTION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionMinAndMaxValues_IsOk() {
        expected = -Double.MAX_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionMaxMinValues_IsOk() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionMaxValues_IsOk() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION_SIGN);
        assertEquals(expected, actual);

    }

    @Test
    public void calculate_subtractionIfBothOperandsAreMinValues_IsOk() {
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, SUBTRACTION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationOfTwoPositiveOperands_IsOk() {
        expected = 200;
        actual = calculator.calculate(20, 10, MULTIPLICATION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationOfTwoNegativeOperands_IsOk() {
        expected = 8;
        actual = calculator.calculate(-2, -4, MULTIPLICATION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationOfPositiveAndNegative_IsOk() {
        expected = -60;
        actual = calculator.calculate(-15, 4, MULTIPLICATION_SIGN);
        assertEquals(expected, actual);
        actual = calculator.calculate(4, -15, MULTIPLICATION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationZero_IsOk() {
        expected = 0;
        actual = calculator.calculate(0, 2, MULTIPLICATION_SIGN);
        assertEquals(expected, actual);
        actual = calculator.calculate(2, 0, MULTIPLICATION_SIGN);
        assertEquals(expected, actual);
        actual = calculator.calculate(0, 0, MULTIPLICATION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationMinMax_IsOk() {
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION_SIGN);
        assertEquals(expected, actual, DELTA);
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION_SIGN);
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLICATION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionTwoPositiveOperands_IsOk() {
        expected = 2;
        actual = calculator.calculate(6, 3, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionTwoNegativeOperands_IsOk() {
        expected = 1;
        actual = calculator.calculate(-1, -1, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionPositiveNegative_IsOk() {
        expected = -16;
        actual = calculator.calculate(32, -2, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
        expected = -0.0625;
        actual = calculator.calculate(-2, 32, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionFirstOperandEqualsZero_IsOk() {
        expected = 0;
        actual = calculator.calculate(0, 10, DIVISION_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionSecondOperandEqualsZero_isNotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(5, 0, DIVISION_SIGN));
    }

    @Test
    public void calculate_divisionMinAndMaxValues_IsOk() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionMaxAndMinValues_IsOk() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionOperandsAreMaxValues_IsOk() {
        expected = 1;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionOperandsAreMinValues_IsOk() {
        expected = 1;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVISION_SIGN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisePositiveValueToPositiveValue_IsOk() {
        expected = 4;
        actual = calculator.calculate(2, 2, RAISING_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisePositiveValueToNegativeValue_IsOk() {
        expected = 0.25;
        actual = calculator.calculate(2, -2, RAISING_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseNegativeValueToPositiveValue_IsOk() {
        expected = -64;
        actual = calculator.calculate(-4,3, RAISING_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseNegativeValueToNegativeValue_IsOk() {
        expected = -0.008;
        actual = calculator.calculate(-5, -3, RAISING_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisePositiveValueToZero_IsOk() {
        expected = 1;
        actual = calculator.calculate(10, 0, RAISING_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseNegativeValueToZero_IsOk() {
        expected = 1;
        actual = calculator.calculate(-2, 0, RAISING_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseZeroValueToPositiveValue_IsOk() {
        expected = 0;
        actual = calculator.calculate(0, 2, RAISING_SIGN);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_illegalOperation_isNotOk() {
        assertThrows(IllegalArgumentException.class, ()
                -> calculator.calculate(10, 25, '='));
    }
}
