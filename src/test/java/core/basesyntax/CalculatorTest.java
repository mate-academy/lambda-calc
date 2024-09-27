package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char DIVIDE = '/';
    private static final char MULTIPLY = '*';
    private static final char POWER = '^';
    private static Calculator calculatorTest;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculatorTest = new Calculator();
    }

    @Test
    void add_twoPositiveNumbers_Ok() {
        actual = calculatorTest.calculate(3.45, 3.55,PLUS);
        expected = 7.00;
        assertEquals(expected, actual);
    }

    @Test
    void add_twoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-3.45, -3.55,PLUS);
        expected = -7.00;
        assertEquals(expected, actual);
    }

    @Test
    void add_positiveNumberToNegative_Ok() {
        actual = calculatorTest.calculate(3, -6,PLUS);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void add_zeroInDifferentPlaces_Ok() {
        actual = calculatorTest.calculate(0, 5, PLUS);
        expected = 5;
        assertEquals(expected, actual);

        actual = calculatorTest.calculate(3.5, 0, PLUS);
        expected = 3.5;
        assertEquals(expected, actual);

        actual = calculatorTest.calculate(-34, -6.05,PLUS);
        expected = -40.05;
        assertEquals(expected, actual);

        actual = calculatorTest.calculate(0.03, 0.02,PLUS);
        expected = 0.05;
        assertEquals(expected, actual);
    }

    @Test
    void add_twoMaxValue_Ok() {
        actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE,PLUS);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void add_twoMinValue_Ok() {
        actual = calculatorTest.calculate(Double.MIN_VALUE, Double.MIN_VALUE,PLUS);
        expected = 1.0E-323;
        assertEquals(expected, actual);
    }

    @Test
    void subtract_twoPositiveNumbers_Ok() {
        actual = calculatorTest.calculate(3.5, 2.5, MINUS);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void subtract_twoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-3, -9, MINUS);
        expected = 6.0;
        assertEquals(expected, actual);
    }

    @Test
    void subtract_positiveNumberToNegative_Ok() {
        actual = calculatorTest.calculate(3, -6, MINUS);
        expected = 9.0;
        assertEquals(expected, actual);
    }

    @Test
    void subtract_zeroInDifferentPlaces_Ok() {
        actual = calculatorTest.calculate(0, 5, MINUS);
        expected = -5;
        assertEquals(expected, actual);

        actual = calculatorTest.calculate(3.5, 0.0, MINUS);
        expected = 3.5;
        assertEquals(expected, actual);

        actual = calculatorTest.calculate(-34.0, -6.05, MINUS);
        expected = -27.95;
        assertEquals(expected, actual);

        actual = calculatorTest.calculate(0.05, 0.50, MINUS);
        expected = -0.45;
        assertEquals(expected, actual);
    }

    @Test
    void subtract_twoMaxValue_Ok() {
        actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void subtract_twoMinValue_Ok() {
        actual = calculatorTest.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MINUS);
        expected = 0.0;
        assertEquals(expected, actual);

    }

    @Test
    void divide_twoPositiveNumbers_Ok() {
        actual = calculatorTest.calculate(170, 2, DIVIDE);
        expected = 85;
        assertEquals(expected, actual);
    }

    @Test
    void divide_twoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-50, -25, DIVIDE);
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void divide_positiveNumberToNegative_Ok() {
        actual = calculatorTest.calculate(3, -6, DIVIDE);
        expected = -0.5;
        assertEquals(expected, actual);
    }

    @Test
    void divide_zeroByNumber_Ok() {
        actual = calculatorTest.calculate(0, 5, DIVIDE);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divide_numberByZero_notOk() {
        assertThrows(ArithmeticException.class,() -> calculatorTest
                .calculate(3.5,0, DIVIDE));
    }

    @Test
    void divide_twoMaxValue_Ok() {
        actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVIDE);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void divide_twoMinValue_Ok() {
        actual = calculatorTest.calculate(Double.MIN_VALUE, Double.MIN_VALUE, DIVIDE);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_twoPositiveNumbers_Ok() {
        actual = calculatorTest.calculate(3.45, 3.55, MULTIPLY);
        expected = 12.2475;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_twoNegativeNumbers_Ok() {
        actual = calculatorTest.calculate(-3.45, -5.55, MULTIPLY);
        expected = 19.1475;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_positiveNumberToNegative_Ok() {
        actual = calculatorTest.calculate(3, -6, MULTIPLY);
        expected = -18;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_zeroByNumberAndNumberByZero_Ok() {
        actual = calculatorTest.calculate(0, 5, MULTIPLY);
        expected = 0;
        assertEquals(expected, actual);

        actual = calculatorTest.calculate(3.5, 0, MULTIPLY);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_twoMaxValue_Ok() {
        actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLY);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_twoMinValue_Ok() {
        actual = calculatorTest.calculate(Double.MIN_VALUE, Double.MIN_VALUE, MULTIPLY);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void raising_positiveNumberToNegative_Ok() {
        actual = calculatorTest.calculate(2, -2, POWER);
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void raising_negativeNumberToNegative_Ok() {
        actual = calculatorTest.calculate(-2, -2, POWER);
        expected = 0.25;
        assertEquals(expected, actual);
    }

    @Test
    void raising_positiveNumberToPositive_Ok() {
        actual = calculatorTest.calculate(2, 5, POWER);
        expected = 32;
        assertEquals(expected, actual);
    }

    @Test
    void raising_negativeNumberToPositive_Ok() {
        actual = calculatorTest.calculate(-2, 5, POWER);
        expected = -32;
        assertEquals(expected, actual);
    }

    @Test
    void raising_positiveNumberToZero_Ok() {
        actual = calculatorTest.calculate(26, 0, POWER);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void raising_negativeNumberToZero_Ok() {
        actual = calculatorTest.calculate(-22, 0, POWER);
        expected = 1.0;
        assertEquals(expected, actual);
    }

    @Test
    void raising_zeroToNumberValue_Ok() {
        actual = calculatorTest.calculate(0, 3, POWER);
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void illigalOperations_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculatorTest.calculate(3, 7, '&');
        });
    }
}
