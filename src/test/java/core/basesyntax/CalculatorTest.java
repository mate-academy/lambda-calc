package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final String ADDITION_MESSAGE = "Addition test failed";
    private static final String SUBTRACTION_MESSAGE = "Subtraction test failed";
    private static final String DIVISION_MESSAGE = "Division test failed";
    private static final String MULTIPLICATION_MESSAGE = "Multiplication test failed";
    private static final String RAISING_TO_POWER = "Raising to power test failed";
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() throws ValidationException {
        actual = calculator.calculate(125.50, 100.25,'-');
        expected = 25.25;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-5.5, -3.25,'-');
        expected = -2.25;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-5.25, 10.5,'-');
        expected = -15.75;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 12.25,'-');
        expected = -12.25;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);

        actual = calculator.calculate(5.33, 0,'-');
        expected = 5.33;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);

        actual = calculator.calculate(0, 0,'-');
        expected = 0;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);
    }

    @Test
    void subtractionForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);
    }

    @Test
    void subtractionForMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = Double.MIN_VALUE - Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);
    }

    @Test
    void subtractionForMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = Double.MAX_VALUE - Double.MAX_VALUE;
        assertEquals(expected,actual,DELTA,SUBTRACTION_MESSAGE);
    }

    @Test
    void additionWithTwoPositiveOperands_Ok() throws ValidationException {
        actual = calculator.calculate(125.25, 100.25,'+');
        expected = 225.5;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void additionWithTwoNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-5.5, -3.25,'+');
        expected = -8.75;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-5.5, 10.5,'+');
        expected = 5;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 12.5,'+');
        expected = 12.5;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);

        actual = calculator.calculate(33.33, 0,'+');
        expected = 33.33;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);

        actual = calculator.calculate(0, 0,'+');
        expected = 0;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void additionForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void additionForMinAndMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void additionForMaxAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.MAX_VALUE + Double.MAX_VALUE;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() throws ValidationException {
        actual = calculator.calculate(50, 2,'/');
        expected = 25;
        assertEquals(expected,actual,DELTA,ADDITION_MESSAGE);
    }

    @Test
    void divisionWithTwoNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-15, -3,'/');
        expected = 5;
        assertEquals(expected,actual,DELTA,DIVISION_MESSAGE);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-5, 10,'/');
        expected = -0.5;
        assertEquals(expected,actual,DELTA,DIVISION_MESSAGE);
    }

    @Test
    void divisionWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 22.25, '/');
        expected = 0;
        assertEquals(expected, actual, DELTA, DIVISION_MESSAGE);
    }

    @Test
    void divisionWithZeroInDifferentPlaces_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(201.11, 0, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, '/'));
    }

    @Test
    void divisionForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,DIVISION_MESSAGE);
    }

    @Test
    void divisionForMinAndMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = Double.MIN_VALUE / Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,DIVISION_MESSAGE);
    }

    @Test
    void divisionForMaxAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = Double.MAX_VALUE / Double.MAX_VALUE;
        assertEquals(expected,actual,DELTA,DIVISION_MESSAGE);
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() throws ValidationException {
        actual = calculator.calculate(50, 2,'*');
        expected = 100;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-5, -3,'*');
        expected = 15;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() throws ValidationException {
        actual = calculator.calculate(-5, 10,'*');
        expected = -50;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() throws ValidationException {
        actual = calculator.calculate(0, 12.25,'*');
        expected = 0;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);

        actual = calculator.calculate(10.33, 0,'*');
        expected = 0;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);

        actual = calculator.calculate(0, 0,'*');
        expected = 0;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplicationForMinAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplicationForMinAndMinValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplicationForMaxAndMaxValues_Ok() throws ValidationException {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        assertEquals(expected,actual,DELTA,MULTIPLICATION_MESSAGE);
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() throws ValidationException {
        actual = calculator.calculate(2,3,'^');
        expected = 8;
        assertEquals(expected,actual,DELTA,RAISING_TO_POWER);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() throws ValidationException {
        actual = calculator.calculate(-2,3,'^');
        expected = -8;
        assertEquals(expected,actual,DELTA,RAISING_TO_POWER);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() throws ValidationException {
        actual = calculator.calculate(-2,-3,'^');
        expected = -0.125;
        assertEquals(expected,actual,DELTA,RAISING_TO_POWER);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() throws ValidationException {
        actual = calculator.calculate(2,-3,'^');
        expected = 0.125;
        assertEquals(expected,actual,DELTA, RAISING_TO_POWER);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() throws ValidationException {
        actual = calculator.calculate(-2,0,'^');
        expected = 1;
        assertEquals(expected,actual,DELTA,RAISING_TO_POWER);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() throws ValidationException {
        actual = calculator.calculate(2,0,'^');
        expected = 1;
        assertEquals(expected,actual,DELTA, RAISING_TO_POWER);
    }

    @Test
    void raisingZeroValueToPower_Ok() throws ValidationException {
        actual = calculator.calculate(0,5.3,'^');
        expected = 0;
        assertEquals(expected,actual,DELTA,RAISING_TO_POWER);
    }

    @Test
    void calculateIllegalOperation_notOk() {
        assertThrows(ValidationException.class, () -> calculator.calculate(201.11, 0, '#'));
    }
}
