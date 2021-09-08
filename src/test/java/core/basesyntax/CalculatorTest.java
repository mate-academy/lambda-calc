package core.basesyntax;

import static core.basesyntax.Calculator.DIVIDE;
import static core.basesyntax.Calculator.MINUS;
import static core.basesyntax.Calculator.MULTIPLY;
import static core.basesyntax.Calculator.PLUS;
import static core.basesyntax.Calculator.POW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final Calculator calculator = new Calculator();

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(10, 20, PLUS);
        double expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-10, -20, PLUS);
        double expected = -30;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(10, -20, PLUS);
        double expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok_Ok() {
        double actual = calculator.calculate(0, 30, PLUS);
        double expected = 30;
        assertEquals(expected, actual);

        actual = calculator.calculate(30, 0, PLUS);
        expected = 30;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 0, PLUS);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(10, 20, MINUS);
        double expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-30, -20, MINUS);
        double expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(50, -30, MINUS);
        double expected = 80;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 30, MINUS);
        double expected = -30;
        assertEquals(expected, actual);

        actual = calculator.calculate(30, 0, MINUS);
        expected = 30;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 0, MINUS);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(10, 20, MULTIPLY);
        double expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-10, -20, MULTIPLY);
        double expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(10, -20, MULTIPLY);
        double expected = -200;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() {
        double actual = calculator.calculate(0, 30, MULTIPLY);
        double expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(30, 0, MULTIPLY);
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 0, MULTIPLY);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() {
        double actual = calculator.calculate(10, 2, DIVIDE);
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoNegativeOperands_Ok() {
        double actual = calculator.calculate(-10, -2, DIVIDE);
        double expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(10, -2, DIVIDE);
        double expected = -5;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZeroInStart_Ok() {
        double actual = calculator.calculate(0, 30, DIVIDE);
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZeroInEnd_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(30, 0, DIVIDE));
    }

    @Test
    void divisionWithZeroInStartAndEnd_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(0, 0, DIVIDE));
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        double actual = calculator.calculate(10, 3, POW);
        double expected = 1000;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        double actual = calculator.calculate(-10, 3, POW);
        double expected = -1000;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(10, -3, POW);
        double expected = 0.001;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(-10, -3, POW);
        double expected = -0.001;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(10, 0, POW);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(-10, 0, POW);
        double expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroValueToPower_Ok() {
        double actual = calculator.calculate(0, 0, POW);
        double expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 10, POW);
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, -10, POW);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculateIllegalOperation_notOk() {
        assertThrows(NoSuchElementException.class,
                () -> calculator.calculate(100, 10, "$"));
    }
}
