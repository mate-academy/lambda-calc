package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void additionWithTwoPositive() {
        double expected = 5;
        double actual = calculator.calculate(2, 3, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoNegative() {
        double expected = -5;
        double actual = calculator.calculate(-2, -3, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegative() {
        double expected = -1;
        double actual = calculator.calculate(2, -3, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroInTheFirstPosition() {
        double expected = 2;
        double actual = calculator.calculate(0, 2, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroInTheSecondPosition() {
        double expected = 3;
        double actual = calculator.calculate(3, 0, '+');
        assertEquals(expected, actual);
    }

    //addition for min and max double values;
    @Test
    void additionToMAX_VALUE() {
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, 1, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionToMIN_VALUE() {
        double expected = -Double.MAX_VALUE;
        double actual = calculator.calculate(-Double.MAX_VALUE, 1, '+');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoPositive() {
        double expected = 7;
        double actual = calculator.calculate(10, 3, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoNegative() {
        double expected = -2;
        double actual = calculator.calculate(-5, -3, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithPositiveAndNegative() {
        double expected = 8;
        double actual = calculator.calculate(5, -3, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroInTheFirstPosition() {
        double expected = -2;
        double actual = calculator.calculate(0, 2, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroInTheSecondPosition() {
        double expected = 3;
        double actual = calculator.calculate(3, 0, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMAX_VALUE() {
        double expected = -Double.MAX_VALUE;
        double actual = calculator.calculate(1, Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMIN_VALUE() {
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(1, -Double.MAX_VALUE, '-');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoPositive() {
        double expected = 25;
        double actual = calculator.calculate(5, 5, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoNegative() {
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
    void multiplicationWithZeroInTheFirstPosition() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZeroInTheSecondPosition() {
        double expected = 0;
        double actual = calculator.calculate(3, 0, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMAX_VALUE() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(2, Double.MAX_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMIN_VALUE() {
        double expected = Double.NEGATIVE_INFINITY;
        double actual = calculator.calculate(10, -Double.MAX_VALUE, '*');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoPositive() {
        double expected = 5;
        double actual = calculator.calculate(25, 5, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoNegative() {
        double expected = 4;
        double actual = calculator.calculate(-12, -3, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithPositiveAndNegative() {
        double expected = -5;
        double actual = calculator.calculate(15, -3, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZeroInTheFirstPosition() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveByZero() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(3, 0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionNegativeByZero() {
        double expected = Double.NEGATIVE_INFINITY;
        double actual = calculator.calculate(-3, 0, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionByMIN_VALUE() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(10, Double.MIN_VALUE, '/');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithPositivePowerPositive() {
        double expected = 4;
        double actual = calculator.calculate(2, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithPositivePowerNegative() {
        double expected = 0.25;
        double actual = calculator.calculate(2, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithNegativePowerPositive() {
        double expected = 4;
        double actual = calculator.calculate(-2, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithNegativePowerNegative() {
        double expected = 0.25;
        double actual = calculator.calculate(-2, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithPositivePowerZero() {
        double expected = 1;
        double actual = calculator.calculate(2, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithNegativePowerZero() {
        double expected = 1;
        double actual = calculator.calculate(-2, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithZeroPowerPositive() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingWithZeroPowerNegative() {
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