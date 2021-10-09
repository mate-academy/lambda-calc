package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exceptions.OperatorException;
import core.basesyntax.exceptions.ValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Double MIN_DOUBLE_VALUE = Double.MIN_VALUE;
    private static final Double MAX_DOUBLE_VALUE = Double.MAX_VALUE;
    private static final Double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    private static final Double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    private static final char ILLEGAL_EXPRESSION = '?';
    private static Calculator calculator;
    private double firstValue;
    private double secondValue;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = 1E-323;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_OK() {
        firstValue = -100;
        secondValue = 200;
        expected = 100;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_OK() {
        firstValue = -100.00;
        secondValue = -200.00;
        expected = -300;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_OK() {
        firstValue = 125;
        secondValue = 225;
        expected = 350;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);

    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_OK() {
        firstValue = 0;
        secondValue = 5;
        expected = 5;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
        firstValue = -5;
        secondValue = 0;
        expected = -5;
        actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionForMinAndMaxDoubleValues_OK() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = 1;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = 1;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = 0;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_OK() {
        firstValue = -25;
        secondValue = 5;
        expected = -5;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_OK() {
        firstValue = -15;
        secondValue = -5;
        expected = 3;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_OK() {
        firstValue = 75;
        secondValue = 15;
        expected = 5;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroInDifferentPlaces_OK() {
        firstValue = 0;
        secondValue = 125;
        expected = 0;
        actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual);
        firstValue = 125;
        secondValue = 0;
        assertThrows(ValueException.class, () ->
                calculator.calculate(firstValue, secondValue, '/'));
    }

    @Test
    void calculate_illegalOperation_NotOK() {
        assertThrows(OperatorException.class, () ->
                calculator.calculate(firstValue, secondValue, ILLEGAL_EXPRESSION));
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues() {
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MIN_DOUBLE_VALUE;
        expected = 0;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
        firstValue = MAX_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
        firstValue = MIN_DOUBLE_VALUE;
        secondValue = MAX_DOUBLE_VALUE;
        expected = 0;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_OK() {
        firstValue = -5;
        secondValue = 5;
        expected = -25;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_OK() {
        firstValue = -25;
        secondValue = -15;
        expected = 375;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_OK() {
        firstValue = 5;
        secondValue = 5;
        expected = 25;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_OK() {
        firstValue = 0;
        secondValue = 5;
        expected = 0;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
        firstValue = 5;
        secondValue = 0;
        expected = 0;
        actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativePositiveValueToTheNegativePower_OK() {
        firstValue = -5;
        secondValue = -4;
        expected = 0;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativePositiveValueToThePositivePower_OK() {
        firstValue = -5;
        secondValue = 5;
        expected = firstValue + secondValue;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativePositiveValueToTheZeroPower_OK() {
        firstValue = -5;
        secondValue = 5;
        expected = firstValue + secondValue;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_OK() {
        firstValue = 0;
        secondValue = 5;
        expected = -1;
        actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues() {
        firstValue = -5;
        secondValue = 5;
        expected = firstValue + secondValue;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_OK() {
        firstValue = -5;
        secondValue = 5;
        expected = firstValue + secondValue;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual);
    }
    @Test
    void calculate_subtractionWithTwoNegativeOperands_OK() {
        firstValue = -5;
        secondValue = 5;
        expected = firstValue + secondValue;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual);
    }
    @Test
    void calculate_subtractionWithTwoPositiveOperands_OK() {
        firstValue = -5;
        secondValue = 5;
        expected = firstValue + secondValue;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_OK() {
        firstValue = -5;
        secondValue = 5;
        expected = firstValue + secondValue;
        actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual);
    }

    /*    ;
    addition for min and max double values;
    addition with positive and negative operands;
    addition with 2 negative operands;
    addition with 2 positive operands;
    addition with zero in different places;

    (check division by 0);
    division for min and max double values;
    division with positive and negative operands;
    division with 2 negative operands;
    division with 2 positive operands;
    division with zero in different places;

    illegal operation;

    multiplication for min and max double values;
    multiplication with positive and negative operands;
    multiplication with 2 negative operands;
    multiplication with 2 positive operands;
    multiplication with zero in different places;

    raising positive/negative value to the negative power;
    raising positive/negative value to the positive power;
    raising positive/negative value to zero power;
    raising zero to power

    subtraction for min and max double values;
    subtraction with positive and negative operands;
    subtraction with 2 negative operands;
    subtraction with 2 positive operands;
    subtraction with zero in different places;
    */
}
