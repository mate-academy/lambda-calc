package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char RAISING_TO_POWER_OPERATOR = '^';
    private static Calculator calculator;
    private double firstValue;
    private double secondValue;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_checkOperator_NotOk() {
        firstValue = 1;
        secondValue = 4;
        assertThrows(IllegalOperatorException.class, () -> {
            calculator.calculate(firstValue, secondValue, '&');
        });
    }

    @Test
    void calculate_addTwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addTwoNegative_Ok() {
        firstValue = -5.1;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -6.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addFirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addFirstPositiveSecondBegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addTwoZero_Ok() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addFirstZero_Ok() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addSecondZero_Ok() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addFirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addFirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addFirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addFirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addFirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addTwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addTwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subTwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subTwoNegative_Ok() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subFirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subFirstPositiveSecondNegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subTwoZero_Ok() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subFirstZero_Ok() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subSecondZero_Ok() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subFirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subFirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subFirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subFirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subFirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subTwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subTwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyTwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoNegative_Ok() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyFirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyFirstPositiveSecondNegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoZero_Ok() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyFirstZero_Ok() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplySecondZero_Ok() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -0.0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyFirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyFirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyFirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyFirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyFirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyTwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplyTwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideTwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideTwoNegative_Ok() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideFirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideFirstPositiveSecondNegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = -0.25;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideFirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideFirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideFirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideFirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideFirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideTwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divideTwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideFirstPositiveSecondZero_OK() {
        firstValue = 1;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void calculate_divideFirstNegativeSecondZero_OK() {
        firstValue = -1;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void calculate_divideFirstMaxSecondZero_OK() {
        firstValue = Double.MAX_VALUE;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void calculate_divideFirstMinSecondZero_OK() {
        firstValue = Double.MIN_VALUE;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void calculate_raisingFirstPositiveSecondPositive_OK() {
        firstValue = 5.5;
        secondValue = 4;
        actual = calculator.calculate(firstValue,secondValue,RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue,secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingFirstNegativeSecondPositive_Ok() {
        firstValue = -1.1;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveToNegative_Ok() {
        firstValue = 1;
        secondValue = -1.5;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeToNegative_Ok() {
        firstValue = -1;
        secondValue = -5;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveToZero_OK() {
        firstValue = 1;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeToZero_OK() {
        firstValue = -2;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPositive_Ok() {
        firstValue = 0;
        secondValue = 8;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToNegative_Ok() {
        firstValue = 0;
        secondValue = -3;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToMax_OK() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToMin_Ok() {
        firstValue = -2;
        secondValue = Double.MIN_VALUE;
        assertThrows(IllegalValueException.class, () -> {
            calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        });
    }
}
