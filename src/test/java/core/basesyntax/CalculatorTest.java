package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final String ADDITION_MESSAGE = "Addition test failed";
    private static final String SUBTRACTION_MESSAGE = "Subtraction test failed";
    private static final String DIVISION_MESSAGE = "Division test failed";
    private static final String MULTIPLICATION_MESSAGE = "Multiplication test failed";
    private static final String RAISING_TO_A_POWER_MESSAGE = "Raising to a power test failed";
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositiveValues_Ok() throws ValidationException {
        actual = calculator.calculate(10.1, 20.2,'+');
        expected = 30.3;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_additionWithTwoNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(-51.5, -3.55,'+');
        expected = -55.05;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(13.67, -3.51,'+');
        expected = 10.16;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_additionWithNegativeAndPositiveValues_Ok() throws ValidationException {
        actual = calculator.calculate(-13.67, 3.51,'+');
        expected = -10.16;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 25.3,'+');
        expected = 25.3;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);

        actual = calculator.calculate(21.15, 0,'+');
        expected = 21.15;
        assertEquals(expected,actual, DELTA, ADDITION_MESSAGE);

        actual = calculator.calculate(0, 0,'+');
        expected = 0;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_additionForMinAndMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_additionForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
        expected = Double.MIN_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_additionForMaxAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ADDITION_MESSAGE);
    }

    @Test
    void calculate_subtractionWithTwoPositiveValues_Ok() throws ValidationException {
        actual = calculator.calculate(10.1, 20.2,'-');
        expected = -10.1;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_subtractionWithTwoNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(-51.5, -3.55,'-');
        expected = -47.95;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(13.67, -3.51,'-');
        expected = 17.18;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_subtractionWithNegativeAndPositiveValues_Ok() throws ValidationException {
        actual = calculator.calculate(-13.67, 3.51,'-');
        expected = -17.18;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 25.3,'-');
        expected = -25.3;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);

        actual = calculator.calculate(21.15, 0,'-');
        expected = 21.15;
        assertEquals(expected,actual, DELTA, SUBTRACTION_MESSAGE);

        actual = calculator.calculate(0, 0,'-');
        expected = 0;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_subtractionForMinAndMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = Double.MIN_VALUE - Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_subtractionForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        expected = Double.MIN_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_subtractionForMaxAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = Double.MAX_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, SUBTRACTION_MESSAGE);
    }

    @Test
    void calculate_divisionWithTwoPositiveValues_Ok() throws ValidationException {
        actual = calculator.calculate(10.1, 20.2,'/');
        expected = 0.5;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void calculate_divisionWithTwoNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(-51.5, -3.55,'/');
        expected = 14.507;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(13.67, -3.51,'/');
        expected = -3.8945;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void calculate_divisionWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 25.3, '/');
        expected = 0;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void calculate_divisionWithZeroInDifferentPlaces_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(21.15, 0, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, '/'));
    }

    @Test
    void calculate_divisionForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        expected = Double.MIN_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void calculate_divisionForMinAndMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = Double.MIN_VALUE / Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void calculate_divisionForMaxAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = Double.MAX_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveValues_Ok() throws ValidationException {
        actual = calculator.calculate(10.1, 20.2,'*');
        expected = 204.0199;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(-51.5, -3.55,'*');
        expected = 182.825;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeValues_Ok() throws ValidationException {
        actual = calculator.calculate(13.67, -3.51,'*');
        expected = -47.9817;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 25.3,'*');
        expected = 0;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);

        actual = calculator.calculate(21.15, 0,'*');
        expected = 0;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);

        actual = calculator.calculate(0, 0,'*');
        expected = 0;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);
    }

    @Test
    void calculate_multiplicationForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        expected = Double.MIN_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);
    }

    @Test
    void calculate_multiplicationForMinAndMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);
    }

    @Test
    void calculate_multiplicationForMaxAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, MULTIPLICATION_MESSAGE);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_Ok() throws ValidationException {
        actual = calculator.calculate(3,-5,'^');
        expected = 0.0041;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_Ok() throws ValidationException {
        actual = calculator.calculate(3,5,'^');
        expected = 243.0;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_Ok() throws ValidationException {
        actual = calculator.calculate(-3,5,'^');
        expected = -243.0;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_Ok() throws ValidationException {
        actual = calculator.calculate(-3,-5,'^');
        expected = -0.0041;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() throws ValidationException {
        actual = calculator.calculate(-3,0,'^');
        expected = 1;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() throws ValidationException {
        actual = calculator.calculate(3,0,'^');
        expected = 1;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_raisingZeroValueToAPower_Ok() throws ValidationException {
        actual = calculator.calculate(0,5,'^');
        expected = 0;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_raisingZeroValueToNegativePower_Ok() throws ValidationException {
        actual = calculator.calculate(0,-5,'^');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA, RAISING_TO_A_POWER_MESSAGE);
    }

    @Test
    void calculate_calculateIllegalOperation_NotOk() {
        assertThrows(ValidationException.class, () -> calculator.calculate(10.1, 20.2, '&'));
    }
}
