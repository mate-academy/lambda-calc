package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    void init() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositive_Ok() {
        double expected = 5;
        double actual = calculator.calculate(2, 3, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoNegative_Ok() {
        double expected = -5;
        double actual = calculator.calculate(-2, -3, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegative_Ok() {
        double expected = -1;
        double actual = calculator.calculate(2, -3, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroInTheFirstPosition_Ok() {
        double expected = 2;
        double actual = calculator.calculate(0, 2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroInTheSecondPosition_Ok() {
        double expected = 3;
        double actual = calculator.calculate(3, 0, '+');
        assertEquals(expected, actual);
    }

    //addition for min and max double values;
    @Test
    void additionToMaxValue_Ok() {
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, 1, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionToMinValue_Ok() {
        double expected = -Double.MAX_VALUE;
        double actual = calculator.calculate(-Double.MAX_VALUE, 1, '+');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoPositive_Ok() {
        double expected = 7;
        double actual = calculator.calculate(10, 3, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoNegative_Ok() {
        double expected = -2;
        double actual = calculator.calculate(-5, -3, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithPositiveAndNegative_Ok() {
        double expected = 8;
        double actual = calculator.calculate(5, -3, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroInTheFirstPosition_Ok() {
        double expected = -2;
        double actual = calculator.calculate(0, 2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroInTheSecondPosition_Ok() {
        double expected = 3;
        double actual = calculator.calculate(3, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMaxValue_Ok() {
        double expected = -Double.MAX_VALUE;
        double actual = calculator.calculate(1, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMinValue_Ok() {
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(1, -Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoPositive_Ok() {
        double expected = 25;
        double actual = calculator.calculate(5, 5, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoNegative_Ok() {
        double expected = 15;
        double actual = calculator.calculate(-5, -3, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithPositiveAndNegative() {
        double expected = -15;
        double actual = calculator.calculate(5, -3, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZeroInTheFirstPosition_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZeroInTheSecondPosition_Ok() {
        double expected = 0;
        double actual = calculator.calculate(3, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMaxValue_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(2, Double.MAX_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMinValue_Ok() {
        double expected = Double.NEGATIVE_INFINITY;
        double actual = calculator.calculate(10, -Double.MAX_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoPositive_Ok() {
        double expected = 5;
        double actual = calculator.calculate(25, 5, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoNegative_Ok() {
        double expected = 4;
        double actual = calculator.calculate(-12, -3, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithPositiveAndNegative_Ok() {
        double expected = -5;
        double actual = calculator.calculate(15, -3, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZeroInTheFirstPosition_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveByZero_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(3, 0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionNegativeByZero_Ok() {
        double expected = Double.NEGATIVE_INFINITY;
        double actual = calculator.calculate(-3, 0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionByMinValue_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(10, Double.MIN_VALUE, '/');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithPositivePowerPositive_Ok() {
        double expected = 4;
        double actual = calculator.calculate(2, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithPositivePowerNegative_Ok() {
        double expected = 0.25;
        double actual = calculator.calculate(2, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithNegativePowerPositive_Ok() {
        double expected = 4;
        double actual = calculator.calculate(-2, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithNegativePowerNegative_Ok() {
        double expected = 0.25;
        double actual = calculator.calculate(-2, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithPositivePowerZero_Ok() {
        double expected = 1;
        double actual = calculator.calculate(2, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithNegativePowerZero_Ok() {
        double expected = 1;
        double actual = calculator.calculate(-2, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithZeroPowerPositive_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithZeroPowerNegative_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(0, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void unknownOperand_Ok() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(0, -2, '|');
        });
    }
}
