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
    void check_Operator_NotOk() {
        firstValue = 1;
        secondValue = 4;
        assertThrows(IllegalOperatorException.class, () -> {
            calculator.calculate(firstValue, secondValue, '&');
        });
    }

    @Test
    void add_TwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void add_TwoNegative_Ok() {
        firstValue = -5.1;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -6.1;
        assertEquals(expected, actual);
    }

    @Test
    void add_FirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void add_FirstPositiveSecondBegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void add_TwoZero_Ok() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void add_FirstZero_Ok() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void add_SecondZero_Ok() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void add_FirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void add_FirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void add_FirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void add_FirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void add_FirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void add_TwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void add_TwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void sub_TwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void sub_TwoNegative_Ok() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void sub_FirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    void sub_FirstPositiveSecondNegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void sub_TwoZero_Ok() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void sub_FirstZero_Ok() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void sub_SecondZero_Ok() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void sub_FirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void sub_FirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void sub_FirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void sub_FirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void sub_FirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void sub_TwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void sub_TwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiply_TwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_TwoNegative_Ok() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_FirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_FirstPositiveSecondNegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_TwoZero_Ok() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_FirstZero_Ok() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_SecondZero_Ok() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -0.0;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_FirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiply_FirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiply_FirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_FirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_FirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiply_TwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void multiply_TwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divide_TwoPositive_Ok() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divide_TwoNegative_Ok() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divide_FirstNegativeSecondPositive_Ok() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void divide_FirstPositiveSecondNegative_Ok() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = -0.25;
        assertEquals(expected, actual);
    }

    @Test
    void divide_FirstPositiveSecondMin_Ok() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void divide_FirstNegativeSecondMin_Ok() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void divide_FirstPositiveSecondMax_Ok() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divide_FirstZeroSecondMax_Ok() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divide_FirstMaxSecondMin_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divide_TwoMax_Ok() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void divide_TwoMin_Ok() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divide_FirstPositiveSecondZero_OK() {
        firstValue = 1;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void divide_FirstNegativeSecondZero_OK() {
        firstValue = -1;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void divide_FirstMaxSecondZero_OK() {
        firstValue = Double.MAX_VALUE;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void divide_FirstMinSecondZero_OK() {
        firstValue = Double.MIN_VALUE;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void raising_FirstPositiveSecondPositive_OK() {
        firstValue = 5.5;
        secondValue = 4;
        actual = calculator.calculate(firstValue,secondValue,RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue,secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raising_FirstNegativeSecondPositive_Ok() {
        firstValue = -1.1;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raising_PositiveToNegative_Ok() {
        firstValue = 1;
        secondValue = -1.5;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raising_NegativeToNegative_Ok() {
        firstValue = -1;
        secondValue = -5;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raising_PositiveToZero_OK() {
        firstValue = 1;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raising_NegativeToZero_OK() {
        firstValue = -2;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raising_ZeroToPositive_Ok() {
        firstValue = 0;
        secondValue = 8;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void raising_ZeroToNegative_Ok() {
        firstValue = 0;
        secondValue = -3;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void raising_ZeroToMax_OK() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void raising_ZeroToMin_Ok() {
        firstValue = -2;
        secondValue = Double.MIN_VALUE;
        assertThrows(IllegalValueException.class, () -> {
            calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        });
    }
}
