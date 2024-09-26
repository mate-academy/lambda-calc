package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.ValidationException;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    static final double DELTA = 1e-15;
    static final double DOUBLE_MAX_VALUE = Double.MAX_VALUE;
    static final double DOUBLE_MIN_VALUE = Double.MIN_VALUE;
    private Calculator calculator = new Calculator();

    @Test
    void additionPositiveNumbers_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = 2.6;
        double expected = 4.1;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionPositiveNegativeNumbers_Ok() throws ValidationException {
        double firstValue = -1.5;
        double secondValue = 2.6;
        double expected = 1.1;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionNegativeNumbers_Ok() throws ValidationException {
        double firstValue = -1.5;
        double secondValue = -2.6;
        double expected = -4.1;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionFirstNumbersIsZero_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = 0;
        double expected = 1.5;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionSecondNumbersIsZero_Ok() throws ValidationException {
        double firstValue = 0;
        double secondValue = 1.5;
        double expected = 1.5;
        double actual = calculator.calculate(firstValue, secondValue, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionTwoMinValues_Ok() throws ValidationException {
        double actual =
                calculator.calculate(DOUBLE_MIN_VALUE, DOUBLE_MIN_VALUE, '+');
        assertEquals(DOUBLE_MIN_VALUE, actual, DELTA);
    }

    @Test
    void additionTwoMaxValues_Ok() {
        double actual = 0;
        try {
            actual = calculator.calculate(DOUBLE_MAX_VALUE, DOUBLE_MAX_VALUE, '+');
        } catch (ValidationException e) {
            throw new RuntimeException("Result out of memory!", e);
        }
    }

    @Test
    void subtractionPositiveNumbers_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = 2.6;
        double expected = -1.1;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionPositiveNegativeNumbers_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = -2.6;
        double expected = 4.1;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionNegativeNumbers_Ok() throws ValidationException {
        double firstValue = -1.5;
        double secondValue = -2.6;
        double expected = 1.1;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionFirstNumbersIsZero_Ok() throws ValidationException {
        double firstValue = 0;
        double secondValue = -2.6;
        double expected = 2.6;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionSecondNumbersIsZero_Ok() throws ValidationException {
        double firstValue = -2.6;
        double secondValue = 0;
        double expected = -2.6;
        double actual = calculator.calculate(firstValue, secondValue, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionTwoMinValues_Ok() throws ValidationException {
        double expected = 0;
        double actual = calculator.calculate(DOUBLE_MIN_VALUE, DOUBLE_MIN_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoMaxValues_Ok() throws ValidationException {
        double expected = 0;
        double actual = calculator.calculate(DOUBLE_MAX_VALUE, DOUBLE_MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveNumbers_Ok() throws ValidationException {
        double firstValue = 3.375;
        double secondValue = 1.5;
        double expected = 2.25;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionPositiveNegativeNumbers_Ok() throws ValidationException {
        double firstValue = 3.375;
        double secondValue = -1.5;
        double expected = -2.25;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionNegativeNumbers_Ok() throws ValidationException {
        double firstValue = -3.375;
        double secondValue = -1.5;
        double expected = 2.25;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionFirstNumbersIsZero_Ok() throws ValidationException {
        double firstValue = 0;
        double secondValue = -1.5;
        double expected = 0;
        double actual = calculator.calculate(firstValue, secondValue, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionSecondNumbersIsZero_NotOk() {
        double firstValue = -3.375;
        double secondValue = 0;
        assertThrows(ValidationException.class, () -> {
            calculator.calculate(firstValue, secondValue, '/');
        });
    }

    @Test
    void divisionTwoMinValues_Ok() throws ValidationException {
        double expected = 1;
        double actual = calculator.calculate(DOUBLE_MIN_VALUE, DOUBLE_MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionTwoMaxValues_Ok() throws ValidationException {
        double expected = 1;
        double actual = calculator.calculate(DOUBLE_MIN_VALUE, DOUBLE_MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationPositiveNumbers_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = 2.6;
        double expected = 3.9;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationPositiveNegativeNumbers_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = -2.6;
        double expected = -3.9;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationNegativeNumbers_Ok() throws ValidationException {
        double firstValue = -1.5;
        double secondValue = -2.6;
        double expected = 3.9;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationFirstNumbersIsZero_Ok() throws ValidationException {
        double firstValue = 0;
        double secondValue = 2.6;
        double expected = 0;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationSecondNumbersIsZero_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = 0;
        double expected = 0;
        double actual = calculator.calculate(firstValue, secondValue, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationTwoMinValues_Ok() throws ValidationException {
        double actual = calculator.calculate(DOUBLE_MIN_VALUE, DOUBLE_MIN_VALUE, '*');
        assertEquals(DOUBLE_MIN_VALUE, actual, DELTA);
    }

    @Test
    void multiplicationTwoMaxValues_Ok() {
        try {
            calculator.calculate(DOUBLE_MAX_VALUE, DOUBLE_MAX_VALUE, '*');
        } catch (ValidationException e) {
            throw new RuntimeException("Result out of memory!", e);
        }
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() throws ValidationException {
        double firstValue = 1.5;
        double secondValue = 2;
        double expected = 2.25;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() throws ValidationException {
        double firstValue = -1.5;
        double secondValue = 2;
        double expected = 2.25;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() throws ValidationException {
        double firstValue = 2;
        double secondValue = -2;
        double expected = 0.25;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() throws ValidationException {
        double firstValue = -2;
        double secondValue = -2;
        double expected = 0.25;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheZeroPower_Ok() throws ValidationException {
        double firstValue = -2;
        double secondValue = 0;
        double expected = 1;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheZeroPower_Ok() throws ValidationException {
        double firstValue = 2;
        double secondValue = 0;
        double expected = 1;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroToPower() throws ValidationException {
        double firstValue = 0;
        double secondValue = 2;
        double expected = 0;
        double actual = calculator.calculate(firstValue, secondValue, '^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        double firstValue = 1.5;
        double secondValue = 2.6;
        try {
            double actual = calculator.calculate(firstValue, secondValue, '!');
        } catch (ValidationException e) {
            throw new RuntimeException("Illegal use this operation", e);
        }
    }
}
