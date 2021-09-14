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
    void checkOperatorNotOk() {
        firstValue = 1;
        secondValue = 4;
        assertThrows(IllegalOperatorException.class, () -> {
            calculator.calculate(firstValue, secondValue, '&');
        });
    }

    @Test
    void addTwoPositiveOk() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void addTwoNegativeOk() {
        firstValue = -5.1;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -6.1;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstNegativeSecondPositiveOk() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstPositiveSecondBegativeOk() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void addTwoZeroOk() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstZeroOk() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void addSecondZeroOk() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstPositiveSecondMinOk() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addFirstNegativeSecondMinOk() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addFirstPositiveSecondMaxOk() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstZeroSecondMaxOk() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstMaxSecondMinOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addTwoMaxOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, ADDITION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void addTwoMinOk() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, ADDITION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subTwoPositiveOk() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void subTwoNegativeOk() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstNegativeSecondPositiveOk() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstPositiveSecondNegativeOk() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void subTwoZeroOk() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstZeroOk() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void subSecondZeroOk() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstPositiveSecondMinOk() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstNegativeSecondMinOk() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstPositiveSecondMaxOk() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstZeroSecondMaxOk() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstMaxSecondMinOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subTwoMaxOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subTwoMinOk() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, SUBTRACTION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyTwoPositiveOk() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoNegativeOk() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstNegativeSecondPositiveOk() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstPositiveSecondNegativeOk() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoZeroOk() {
        firstValue = 0;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstZeroOk() {
        firstValue = 0;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplySecondZeroOk() {
        firstValue = -4;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = -0.0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstPositiveSecondMinOk() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyFirstNegativeSecondMinOk() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyFirstPositiveSecondMaxOk() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstZeroSecondMaxOk() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstMaxSecondMinOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyTwoMaxOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, MULTIPLICATION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoMinOk() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, MULTIPLICATION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideTwoPositiveOk() {
        firstValue = 5;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoNegativeOk() {
        firstValue = -5;
        secondValue = -1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstNegativeSecondPositiveOk() {
        firstValue = -1;
        secondValue = 1;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstPositiveSecondNegativeOk() {
        firstValue = 1;
        secondValue = -4;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = -0.25;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstPositiveSecondMinOk() {
        firstValue = 1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstNegativeSecondMinOk() {
        firstValue = -1;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstPositiveSecondMaxOk() {
        firstValue = 1;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideFirstZeroSecondMaxOk() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstMaxSecondMinOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideTwoMaxOk() {
        firstValue = Double.MAX_VALUE;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoMinOk() {
        firstValue = Double.MIN_VALUE;
        secondValue = Double.MIN_VALUE;
        actual = calculator.calculate(firstValue,secondValue, DIVISION_OPERATOR);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideFirstPositiveSecondZeroOK() {
        firstValue = 1;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void divideFirstNegativeSecondZeroOK() {
        firstValue = -1;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void divideFirstMaxSecondZeroOK() {
        firstValue = Double.MAX_VALUE;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void divideFirstMinSecondZeroOK() {
        firstValue = Double.MIN_VALUE;
        secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, DIVISION_OPERATOR);
        });
    }

    @Test
    void raisingFirstPositiveSecondPositiveOK() {
        firstValue = 5.5;
        secondValue = 4;
        actual = calculator.calculate(firstValue,secondValue,RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue,secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingFirstNegativeSecondPositiveOk() {
        firstValue = -1.1;
        secondValue = 3;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToNegative() {
        firstValue = 1;
        secondValue = -1.5;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToNegative() {
        firstValue = -1;
        secondValue = -5;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToZeroOK() {
        firstValue = 1;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToZeroOK() {
        firstValue = -2;
        secondValue = 0;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPositiveOk() {
        firstValue = 0;
        secondValue = 8;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToNegativeOk() {
        firstValue = 0;
        secondValue = -3;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToMaxOK() {
        firstValue = 0;
        secondValue = Double.MAX_VALUE;
        actual = calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToMinOk() {
        firstValue = -2;
        secondValue = Double.MIN_VALUE;
        assertThrows(IllegalValueException.class, () -> {
            calculator.calculate(firstValue, secondValue, RAISING_TO_POWER_OPERATOR);
        });
    }
}
