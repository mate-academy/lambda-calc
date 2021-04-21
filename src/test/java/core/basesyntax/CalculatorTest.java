package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char DIVIDER = '/';
    private static final char MULTIPLIER = '*';
    private static final char POWER = '^';
    private static final char BAD_OPERATION_TYPE = '!';
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void additionWithPositiveValues_OK() {
        expected = 5.2;
        actual = calculator.calculate(2.4, 2.8, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void additionWithNegativeValues_OK() {
        expected = -5.2;
        actual = calculator.calculate(-2.4, -2.8, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void additionWithPositiveAndNegativeValues_OK() {
        expected = -0.4;
        actual = calculator.calculate(2.4, -2.8, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void additionWithZeroInDifferentPlaces_Ok() {
        expected = 2.4;
        actual = calculator.calculate(2.4, 0, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = 2.8;
        actual = calculator.calculate(0, 2.8, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void additionForMinAndMaxDoubleValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, 2.8, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE + 2.4;
        actual = calculator.calculate(Double.MIN_VALUE, 2.4, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithPositiveValues_Ok() {
        expected = -0.4;
        actual = calculator.calculate(2.4, 2.8, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithNegativeValues_Ok() {
        expected = 0.4;
        actual = calculator.calculate(-2.4, -2.8, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithPositiveAndNegativeValues_Ok() {
        expected = -5.2;
        actual = calculator.calculate(-2.4, 2.8, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionWithZeroInDifferentPlaces_Ok() {
        expected = 2.4;
        actual = calculator.calculate(2.4, 0, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = -2.8;
        actual = calculator.calculate(0, 2.8, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void subtractionForMinAndMaxDoubleValues_Ok() {
        expected = Double.MAX_VALUE - 2.8;
        actual = calculator.calculate(Double.MAX_VALUE, 2.8, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE - 2.4;
        actual = calculator.calculate(Double.MIN_VALUE, 2.4, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithPositiveValues_Ok() {
        expected = 6.72;
        actual = calculator.calculate(2.4, 2.8, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithNegativeValues_Ok() {
        expected = 6.72;
        actual = calculator.calculate(-2.4, -2.8, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithPositiveAndNegativeValues_Ok() {
        expected = -6.72;
        actual = calculator.calculate(-2.4, 2.8, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationWithZeroInDifferentPlaces_Ok() {
        expected = 0;
        actual = calculator.calculate(2.4, 0, MULTIPLIER);
        assertEquals(expected, actual, DELTA);

        expected = 0;
        actual = calculator.calculate(0, 2.8, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiplicationForMinAndMaxDoubleValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, 2.8, MULTIPLIER);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE * 2.4;
        actual = calculator.calculate(Double.MIN_VALUE, 2.8, MULTIPLIER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithPositiveValues_Ok() {
        expected = 0.85714;
        actual = calculator.calculate(2.4, 2.8, DIVIDER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithNegativeValues_Ok() {
        expected = 0.85714;
        actual = calculator.calculate(-2.4, -2.8, DIVIDER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithPositiveAndNegativeValues_Ok() {
        expected = -0.85714;
        actual = calculator.calculate(-2.4, 2.8, DIVIDER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionWithZero_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 2.8, DIVIDER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void divisionByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(2.4, 0, DIVIDER);
        });
    }

    @Test
    public void divisionForMinAndMaxDoubleValues_Ok() {
        expected = Double.MAX_VALUE / 2.8;
        actual = calculator.calculate(Double.MAX_VALUE, 2.8, DIVIDER);
        assertEquals(expected, actual, DELTA);

        expected = Double.MIN_VALUE;
        actual = calculator.calculate(Double.MIN_VALUE, 2.4, DIVIDER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingPositiveAndNegativeValuesToPositivePower_Ok() {
        expected = 11.60356;
        actual = calculator.calculate(2.4, 2.8, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-2.4, -2.8);
        actual = calculator.calculate(-2.4, -2.8, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingPositiveAndNegativeValuesToNegativePower_Ok() {
        expected = 0.08618;
        actual = calculator.calculate(2.4, -2.8, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(-2.4, -2.8);
        actual = calculator.calculate(-2.4, -2.8, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingPositiveAndNegativeValuesToZeroPower_Ok() {
        expected = 1;
        actual = calculator.calculate(2.4, 0, POWER);
        assertEquals(expected, actual, DELTA);

        expected = 1;
        actual = calculator.calculate(-2.4, 0, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingZeroToPower_Ok() {
        expected = 0;
        actual = calculator.calculate(0, 2.4, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Math.pow(0, -2.4);
        actual = calculator.calculate(0, -2.4, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void badOperationType_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(2.4, 2.8, BAD_OPERATION_TYPE);
        });
    }
}
