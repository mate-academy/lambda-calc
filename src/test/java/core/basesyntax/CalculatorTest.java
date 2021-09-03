package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private static final double DELTA = 0.000001;

    @Test
    void additionWithTwoPositiveOperands() {
        double actual = calculator.calculate(10, 20, Operations.PLUS);
        double expected = 30;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -20, Operations.PLUS);
        double expected = -30;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(10, -20, Operations.PLUS);
        double expected = -10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 30, Operations.PLUS);
        double expected = 30;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(30, 0, Operations.PLUS);
        expected = 30;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0, 0, Operations.PLUS);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands() {
        double actual = calculator.calculate(10, 20, Operations.MINUS);
        double expected = -10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoNegativeOperands() {
        double actual = calculator.calculate(-30, -20, Operations.MINUS);
        double expected = -10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(50, -30, Operations.MINUS);
        double expected = 80;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 30, Operations.MINUS);
        double expected = -30;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(30, 0, Operations.MINUS);
        expected = 30;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0, 0, Operations.MINUS);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoPositiveOperands() {
        double actual = calculator.calculate(10, 20, Operations.MULTIPLY);
        double expected = 200;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -20, Operations.MULTIPLY);
        double expected = 200;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(10, -20, Operations.MULTIPLY);
        double expected = -200;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 30, Operations.MULTIPLY);
        double expected = 0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(30, 0, Operations.MULTIPLY);
        expected = 0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0, 0, Operations.MULTIPLY);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoPositiveOperands() {
        double actual = calculator.calculate(10, 2, Operations.DIVIDE);
        double expected = 5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -2, Operations.DIVIDE);
        double expected = 5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(10, -2, Operations.DIVIDE);
        double expected = -5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 30, Operations.DIVIDE);
        double expected = 0;
        assertEquals(expected, actual, DELTA);

        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(30, 0, Operations.DIVIDE));

        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(0, 0, Operations.DIVIDE));
    }

    @Test
    void raisingPositiveValueToThePositivePower() {
        double actual = calculator.calculate(10,3, Operations.POW);
        double expected = 1000;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToThePositivePower() {
        double actual = calculator.calculate(-10,3, Operations.POW);
        double expected = -1000;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheNegativePower() {
        double actual = calculator.calculate(10,-3,Operations.POW);
        double expected = 0.001;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheNegativePower() {
        double actual = calculator.calculate(-10,-3, Operations.POW);
        double expected = -0.001;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToZeroPower() {
        double actual = calculator.calculate(10,0, Operations.POW);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToZeroPower() {
        double actual = calculator.calculate(-10,0, Operations.POW);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroValueToPower() {
        double actual = calculator.calculate(0,0, Operations.POW);
        double expected = 1;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0,10, Operations.POW);
        expected = 0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0,-10, Operations.POW);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculateIllegalOperation() {
        assertThrows(NoSuchElementException.class,
                () -> calculator.calculate(100, 10, Operations.NO_EXISTED));
    }
}
