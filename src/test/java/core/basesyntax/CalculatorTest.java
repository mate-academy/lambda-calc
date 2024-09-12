package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;
    private static final double ZERO_VALUE = 0.0;
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char POWER_OPERATOR = '^';
    private static double firstPositiveValue;
    private static double secondPositiveValue;
    private static double firstNegativeValue;
    private static double secondNegativeValue;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
        firstPositiveValue = 10.0;
        secondPositiveValue = 10.0;
        firstNegativeValue = -3.0;
        secondNegativeValue = -5.0;
    }

    @Test
    void calculate_AddictionWithTwoPositiveValue_Ok() {
        assertEquals(20.0,calculator
                .calculate(firstPositiveValue, secondPositiveValue,ADDITION_OPERATOR),DELTA);
    }

    @Test
    void calculate_AddictionWithTwoNegativeValue_Ok() {
        assertEquals(-8.0,calculator
                .calculate(firstNegativeValue, secondNegativeValue,ADDITION_OPERATOR),DELTA);
    }

    @Test
    void calculate_AddictionWithPositiveAndNegativeValue_Ok() {
        assertEquals(5.0,calculator
                .calculate(firstPositiveValue, secondNegativeValue,ADDITION_OPERATOR),DELTA);
    }

    @Test
    void calculate_AddictionWithZeroValue_Ok() {
        assertEquals(10.0,calculator
                .calculate(firstPositiveValue, ZERO_VALUE,ADDITION_OPERATOR),DELTA);
        assertEquals(-5.0,calculator
                .calculate(ZERO_VALUE, secondNegativeValue,ADDITION_OPERATOR),DELTA);
    }

    @Test
    void calculate_AddictionWithMaxAndMinValue_Ok() {
        assertEquals(ZERO_VALUE,calculator
                .calculate(Double.MAX_VALUE, -Double.MAX_VALUE,ADDITION_OPERATOR),DELTA);
        assertEquals(ZERO_VALUE,calculator
                .calculate(Double.MIN_VALUE, -Double.MIN_VALUE,ADDITION_OPERATOR),DELTA);
    }

    @Test
    void calculate_SubtractionWithTwoPositiveValue_Ok() {
        assertEquals(ZERO_VALUE,calculator
                .calculate(firstPositiveValue, secondPositiveValue,SUBTRACTION_OPERATOR),DELTA);
    }

    @Test
    void calculate_SubtractionWithTwoNegativeValue_Ok() {
        assertEquals(2.0,calculator
                .calculate(firstNegativeValue, secondNegativeValue,SUBTRACTION_OPERATOR),DELTA);
    }

    @Test
    void calculate_SubtractionWithPositiveAndNegativeValue_Ok() {
        assertEquals(15.0,calculator
                .calculate(firstPositiveValue, secondNegativeValue,SUBTRACTION_OPERATOR),DELTA);
    }

    @Test
    void calculate_SubtractionWithZeroValue_Ok() {
        assertEquals(10.0,calculator
                .calculate(firstPositiveValue, ZERO_VALUE,SUBTRACTION_OPERATOR),DELTA);
        assertEquals(5.0,calculator
                .calculate(ZERO_VALUE, secondNegativeValue,SUBTRACTION_OPERATOR),DELTA);
    }

    @Test
    void calculate_SubtractionWithMaxAndMinValue_Ok() {
        assertEquals(ZERO_VALUE,calculator
                .calculate(-Double.MAX_VALUE, -Double.MAX_VALUE,SUBTRACTION_OPERATOR),DELTA);
        assertEquals(ZERO_VALUE,calculator
                .calculate(Double.MIN_VALUE, -Double.MIN_VALUE,SUBTRACTION_OPERATOR),DELTA);
    }

    @Test
    void calculate_MultiplicationWithTwoPositiveValue_Ok() {
        assertEquals(100.0,calculator
                .calculate(firstPositiveValue, secondPositiveValue,MULTIPLICATION_OPERATOR),DELTA);
    }

    @Test
    void calculate_MultiplicationWithTwoNegativeValue_Ok() {
        assertEquals(15.0,calculator
                .calculate(firstNegativeValue, secondNegativeValue,MULTIPLICATION_OPERATOR),DELTA);
    }

    @Test
    void calculate_MultiplicationWithPositiveAndNegativeValue_Ok() {
        assertEquals(-50.0,calculator
                .calculate(firstPositiveValue, secondNegativeValue,MULTIPLICATION_OPERATOR),DELTA);
    }

    @Test
    void calculate_MultiplicationWithZeroValue_Ok() {
        assertEquals(ZERO_VALUE,calculator
                .calculate(firstPositiveValue, ZERO_VALUE,MULTIPLICATION_OPERATOR),DELTA);
        assertEquals(ZERO_VALUE,calculator
                .calculate(ZERO_VALUE, secondNegativeValue,MULTIPLICATION_OPERATOR),DELTA);
    }

    @Test
    void calculate_MultiplicationWithMaxAndMinValue_Ok() {
        assertEquals(Double.POSITIVE_INFINITY,calculator
                .calculate(Double.MAX_VALUE, Double.MAX_VALUE,MULTIPLICATION_OPERATOR),DELTA);
        assertEquals(ZERO_VALUE,calculator
                .calculate(Double.MIN_VALUE, Double.MIN_VALUE,MULTIPLICATION_OPERATOR),DELTA);
        assertEquals(ZERO_VALUE,calculator
                .calculate(Double.MIN_VALUE, Double.MAX_VALUE,MULTIPLICATION_OPERATOR),DELTA);
    }

    @Test
    void calculate_DivisionWithTwoPositiveValue_Ok() {
        assertEquals(1.0,calculator
                .calculate(firstPositiveValue, secondPositiveValue,DIVISION_OPERATOR),DELTA);
    }

    @Test
    void calculate_DivisionWithTwoNegativeValue_Ok() {
        assertEquals(0.6,calculator
                .calculate(firstNegativeValue, secondNegativeValue,DIVISION_OPERATOR),DELTA);
    }

    @Test
    void calculate_DivisionWithPositiveAndNegativeValue_Ok() {
        assertEquals(-2.0,calculator
                .calculate(firstPositiveValue, secondNegativeValue,DIVISION_OPERATOR),DELTA);
    }

    @Test
    void calculate_DivisionWithFirstZeroValue_Ok() {
        assertEquals(ZERO_VALUE,calculator
                .calculate(ZERO_VALUE, secondNegativeValue,DIVISION_OPERATOR),DELTA);
    }

    @Test
    void calculate_DivisionWithSecondZeroValue_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(secondPositiveValue, ZERO_VALUE, DIVISION_OPERATOR));
    }

    @Test
    void calculate_DivisionWithMaxAndMinValue_Ok() {
        assertEquals(1.0,calculator
                .calculate(Double.MAX_VALUE, Double.MAX_VALUE,DIVISION_OPERATOR),DELTA);
        assertEquals(1.0,calculator
                .calculate(Double.MIN_VALUE, Double.MIN_VALUE,DIVISION_OPERATOR),DELTA);
        assertEquals(0.0,calculator
                .calculate(Double.MIN_VALUE, Double.MAX_VALUE,DIVISION_OPERATOR),DELTA);
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(firstPositiveValue, secondNegativeValue, '#'));
    }

    @Test
    void calculate_RisingToPositivePower_Ok() {
        assertEquals(1.0E10,calculator
                .calculate(firstPositiveValue, secondPositiveValue,POWER_OPERATOR),DELTA);
        assertEquals(59049.0,calculator
                .calculate(firstNegativeValue, secondPositiveValue,POWER_OPERATOR),DELTA);
    }

    @Test
    void calculate_RisingToNegativePower_Ok() {
        assertEquals(1.0E-5,calculator
                .calculate(firstPositiveValue, secondNegativeValue,POWER_OPERATOR),DELTA);
        assertEquals(0.001,calculator
                .calculate(secondPositiveValue, firstNegativeValue,POWER_OPERATOR),DELTA);
        assertEquals(-0.008,calculator
                .calculate(secondNegativeValue, firstNegativeValue,POWER_OPERATOR),DELTA);
    }

    @Test
    void calculate_RisingToZeroPower_Ok() {
        assertEquals(1.0,calculator
                .calculate(firstPositiveValue, ZERO_VALUE,POWER_OPERATOR),DELTA);
        assertEquals(1.0,calculator
                .calculate(secondNegativeValue, ZERO_VALUE,POWER_OPERATOR),DELTA);
    }

    @Test
    void calculate_RisingZeroToPower_Ok() {
        assertEquals(0.0,calculator
                .calculate(ZERO_VALUE, firstPositiveValue,POWER_OPERATOR),DELTA);
        assertEquals(Double.POSITIVE_INFINITY,calculator
                .calculate(ZERO_VALUE, secondNegativeValue,POWER_OPERATOR),DELTA);
    }
}
