package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void checkOperatorNotOk() {
        double firstValue = 1;
        double secondValue = 4;
        assertThrows(IllegalOperatorException.class, () -> {
            calculator.calculate(firstValue, secondValue, '&');
        });
    }

    @Test
    void addTwoPositiveOk() {
        double firstValue = 5;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void addTwoNegativeOk() {
        double firstValue = -5;
        double secondValue = -1;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = -6;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstNegativeSecondPositiveOk() {
        double firstValue = -1;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstPositiveSecondBegativeOk() {
        double firstValue = 1;
        double secondValue = -4;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void addTwoZeroOk() {
        double firstValue = 0;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstZeroOk() {
        double firstValue = 0;
        double secondValue = 3;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void addSecondZeroOk() {
        double firstValue = -4;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstPositiveSecondMinOk() {
        double firstValue = 1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addFirstNegativeSecondMinOk() {
        double firstValue = -1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addFirstPositiveSecondMaxOk() {
        double firstValue = 1;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstZeroSecondMaxOk() {
        double firstValue = 0;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void addFirstMaxSecondMinOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = Double.MAX_VALUE;            
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void addTwoMaxOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        double expected = Double.POSITIVE_INFINITY;                               
        assertEquals(expected, actual);
    }

    @Test
    void addTwoMinOk() {
        double firstValue = Double.MIN_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue,secondValue, '+');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subTwoPositiveOk() {
        double firstValue = 5;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void subTwoNegativeOk() {
        double firstValue = -5;
        double secondValue = -1;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstNegativeSecondPositiveOk() {
        double firstValue = -1;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstPositiveSecondNegativeOk() {
        double firstValue = 1;
        double secondValue = -4;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void subTwoZeroOk() {
        double firstValue = 0;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstZeroOk() {
        double firstValue = 0;
        double secondValue = 3;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void subSecondZeroOk() {
        double firstValue = -4;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void subFirstPositiveSecondMinOk() {
        double firstValue = 1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstNegativeSecondMinOk() {
        double firstValue = -1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = -1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstPositiveSecondMaxOk() {
        double firstValue = 1;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstZeroSecondMaxOk() {
        double firstValue = 0;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subFirstMaxSecondMinOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subTwoMaxOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subTwoMinOk() {
        double firstValue = Double.MIN_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue,secondValue, '-');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyTwoPositiveOk() {
        double firstValue = 5;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoNegativeOk() {
        double firstValue = -5;
        double secondValue = -1;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstNegativeSecondPositiveOk() {
        double firstValue = -1;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstPositiveSecondNegativeOk() {
        double firstValue = 1;
        double secondValue = -4;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = -4;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoZeroOk() {
        double firstValue = 0;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstZeroOk() {
        double firstValue = 0;
        double secondValue = 3;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplySecondZeroOk() {
        double firstValue = -4;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = -0.0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstPositiveSecondMinOk() {
        double firstValue = 1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyFirstNegativeSecondMinOk() {
        double firstValue = -1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyFirstPositiveSecondMaxOk() {
        double firstValue = 1;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = Double.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstZeroSecondMaxOk() {
        double firstValue = 0;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyFirstMaxSecondMinOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplyTwoMaxOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoMinOk() {
        double firstValue = Double.MIN_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue,secondValue, '*');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideTwoPositiveOk() {
        double firstValue = 5;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoNegativeOk() {
        double firstValue = -5;
        double secondValue = -1;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstNegativeSecondPositiveOk() {
        double firstValue = -1;
        double secondValue = 1;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstPositiveSecondNegativeOk() {
        double firstValue = 1;
        double secondValue = -4;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = -0.25;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstPositiveSecondMinOk() {
        double firstValue = 1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstNegativeSecondMinOk() {
        double firstValue = -1;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstPositiveSecondMaxOk() {
        double firstValue = 1;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideFirstZeroSecondMaxOk() {
        double firstValue = 0;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divideFirstMaxSecondMinOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideTwoMaxOk() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoMinOk() {
        double firstValue = Double.MIN_VALUE;
        double secondValue = Double.MIN_VALUE;
        double actual = calculator.calculate(firstValue,secondValue, '/');
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divideFirstPositiveSecondZeroOK() {
        double firstValue = 1;
        double secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, '/');
        });
    }

    @Test
    void divideFirstNegativeSecondZeroOK() {
        double firstValue = -1;
        double secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, '/');
        });
    }

    @Test
    void divideFirstMaxSecondZeroOK() {
        double firstValue = Double.MAX_VALUE;
        double secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, '/');
        });
    }

    @Test
    void divideFirstMinSecondZeroOK() {
        double firstValue = Double.MIN_VALUE;
        double secondValue = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstValue, secondValue, '/');
        });
    }

    @Test
    void raisingFirstPositiveSecondPositiveOK() {
        double firstValue = 5.5;
        double secondValue = 4;
        double actual = calculator.calculate(firstValue,secondValue,'^');
        double expected = Math.pow(firstValue,secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingFirstNegativeSecondPositiveOk() {
        double firstValue = -1.1;
        double secondValue = 3;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToNegative() {
        double firstValue = 1;
        double secondValue = -1.5;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToNegative() {
        double firstValue = -1;
        double secondValue = -5;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = Math.pow(firstValue, secondValue);
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveToZeroOK() {
        double firstValue = 1;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeToZeroOK() {
        double firstValue = -2;
        double secondValue = 0;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPositiveOk() {
        double firstValue = 0;
        double secondValue = 8;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToNegativeOk() {
        double firstValue = 0;
        double secondValue = -3;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToMaxOK() {
        double firstValue = 0;
        double secondValue = Double.MAX_VALUE;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToMinOk() {
        double firstValue = -2;
        double secondValue = Double.MIN_VALUE;
        assertThrows(IllegalValueException.class, () -> {
            calculator.calculate(firstValue, secondValue, '^');
        });
    }
}
