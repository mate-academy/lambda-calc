package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_positiveNumberAddition_Ok() {
        expected = 15.0;
        actual = calculator.calculate(7.6, 7.4, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_negativeNumbersAddition_Ok() {
        expected = -15;
        actual = calculator.calculate(-10, -5, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_positiveAndNegativeAddition_Ok() {
        expected = 15;
        assertEquals(expected, calculator.calculate(25.5, -10.5, '+'));
    }

    @Test
    void calculate_negativeAndPositiveAddition_Ok() {
        expected = -15;
        actual = calculator.calculate(-20, 5, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_zeroAddition_Ok() {
        expected = 15;
        assertEquals(expected, calculator.calculate(15, 0, '+'));
        assertEquals(expected, calculator.calculate(0, 15, '+'));
    }

    @Test
    void calculate_minAndMaxDoubleValuesAddition_Ok() {
        assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
        assertEquals(Double.MIN_VALUE * 2,
                calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+'));
        assertEquals(Double.MAX_VALUE,
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+'));
        assertEquals(Double.MAX_VALUE,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+'));
    }

    @Test
    void calculate_positiveNumberSubtraction_Ok() {
        expected = 20;
        actual = calculator.calculate(25.5, 5.5, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_negativeNumbersSubtraction_Ok() {
        expected = -20;
        actual = calculator.calculate(-25, -5, '-');
        assertEquals(expected, actual);

    }

    @Test
    void calculate_positiveAndNegativeSubtraction_Ok() {
        expected = 20;
        assertEquals(expected, calculator.calculate(15, -5, '-'));
    }

    @Test
    void calculate_negativeAndPositiveSubtraction_Ok() {
        expected = -20;
        actual = calculator.calculate(-5, 15, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_zeroSubtraction_Ok() {
        expected = 20;
        assertEquals(expected, calculator.calculate(20, 0, '-'));
        assertEquals(-expected, calculator.calculate(0, 20, '-'));
    }

    @Test
    void calculate_minAndMaxDoubleValuesSubtraction_Ok() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'));
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));
    }

    @Test
    void calculate_maxDoubleMinsMinValue_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_minDoubleMinusMaxDouble_Ok() {
        expected = - Double.MAX_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_positiveNumberMultiplication_Ok() {
        double expected = 5;
        actual = calculator.calculate(2.5, 2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_negativeNumbersMultiplication_Ok() {
        expected = 5;
        actual = calculator.calculate(-2.5, -2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_positiveAndNegativeMultiplication_Ok() {
        expected = -5;
        assertEquals(expected, calculator.calculate(-2.5, 2, '*'));
        assertEquals(expected, calculator.calculate(2.5, -2, '*'));
    }

    @Test
    void calculate_zeroMultiplication_Ok() {
        expected = 0;
        assertEquals(expected,calculator.calculate(2.5, 0, '*'));
        assertEquals(expected, calculator.calculate(0, 2.5, '*'));
    }

    @Test
    void calculate_minAndMaxDoubleValueMultiplication_Ok() {
        assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*'));
    }

    @Test
    void calculate_positiveNumbersDivision_Ok() {
        double expected = 15.5;
        actual = calculator.calculate(35.65, 2.3, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_negativeNumbersDivision_Ok() {
        expected = 15.5;
        actual = calculator.calculate(-35.65, -2.3, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_positiveAndNegativeNumbers_Ok() {
        expected = -15.5;
        assertEquals(expected, calculator.calculate(35.65, -2.3, '/'));
        assertEquals(expected, calculator.calculate(-35.65, 2.3, '/'));
    }

    @Test
    void calculate_zeroByNumberDivision_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 2.3, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_numberByZeroDivision_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(25, 0, '/');
        });
    }

    @Test
    void calculate_minAndMaxDoubleValuesDivision_Ok() {
        expected = 1;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/'));
    }

    @Test
    void calculate_positiveNumberToPositivePower_Ok() {
        expected = 27;
        actual = calculator.calculate(3, 3, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_negativeNumbersToPositiveToPower_Ok() {
        expected = 4;
        actual = calculator.calculate(-2, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_positiveAndNegativeNumberToNegativePower_Ok() {
        expected = 0.25;
        assertEquals(expected,calculator.calculate(2, -2, '^'));
        assertEquals(expected, calculator.calculate(-2, -2, '^'));
    }

    @Test
    void calculate_raisingToZeroPower_Ok() {
        expected = 1;
        assertEquals(expected,calculator.calculate(5, 0, '^'));
        assertEquals(expected, calculator.calculate(-5, 0, '^'));
    }

    @Test
    void calculate_zeroToPower_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 5, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_zerotoNegativePower_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(0, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegal_operation_notOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '$'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '!'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '@'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '#'));
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(12, 21, '%'));
    }
}
