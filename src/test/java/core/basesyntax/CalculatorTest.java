package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';
    private static final char INCORRECT_OPERATION = '!';
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0;
    private static Calculate calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositiveOperands_OK() {
        actual = calculator.calculate(1.10, 5.75, ADDITION);
        expected = 6.85;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoNegativeOperands_OK() {
        actual = calculator.calculate(-2.75, -3.35, ADDITION);
        expected = -6.10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(2.55, -1.25, ADDITION);
        expected = 1.30;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-2.55, 1.25, ADDITION);
        expected = -1.30;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(-12, ZERO, ADDITION);
        expected = -12;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, 34.6, ADDITION);
        expected = 34.6;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinAndMaxDoubleValues_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, 12.7, ADDITION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(12.7, Double.MIN_VALUE, ADDITION);
        expected = 12.7;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoPositiveOperands_OK() {
        actual = calculator.calculate(35.5, 34.5, SUBTRACTION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-12.5, -2.5, SUBTRACTION);
        expected = -15;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-13.8, 3.7, SUBTRACTION);
        expected = -10.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionZeroDifferentOperands_Ok() {
        actual = calculator.calculate(-12.2, ZERO, SUBTRACTION);
        expected = -12.2;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, 5.5, SUBTRACTION);
        expected = -5.5;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, ZERO, SUBTRACTION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionMinAndMaxValuesOperands_Ok() {
        actual = calculator.calculate(23.6, Double.MAX_VALUE, SUBTRACTION);
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 15.75, SUBTRACTION);
        expected = Double.MIN_VALUE - 15.75;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationTwoPositiveOperands_Ok() {
        actual = calculator.calculate(2.2, 2.2, MULTIPLICATION);
        expected = 4.84;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-3.3, -3.3, MULTIPLICATION);
        expected = -10.89;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-12.5, 8.6, MULTIPLICATION);
        expected = -107.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationZeroDifferentOperands_Ok() {
        actual = calculator.calculate(-124.7, ZERO, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, 356.9, MULTIPLICATION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationMinAndMaxValuesOperands_Ok() {
        actual = calculator.calculate(126.7, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 128.9, MULTIPLICATION);
        expected = 6.1E-322;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionTwoPositiveOperands_Ok() {
        actual = calculator.calculate(345.5, 345.5, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-125.1, -125.1, DIVISION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-124, 34, DIVISION);
        expected = -3.64705882353;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionZeroDifferentOperands_Ok() {
        actual = calculator.calculate(ZERO, 569, DIVISION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionMinAndMaxValuesOperands_Ok() {
        actual = calculator.calculate(898, Double.MAX_VALUE, DIVISION);
        expected = 4.995290812348668E-306;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(Double.MIN_VALUE, 898, DIVISION);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(1675.8, ZERO, DIVISION);
        });
    }

    @Test
    void raisingPositiveAndNegativeValuesOperandsToPositivePower_Ok() {
        actual = calculator.calculate(134.77, ZERO, RAISING_TO_A_POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-134.89, ZERO, RAISING_TO_A_POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveAndNegativeValuesOperandsToNegativePower_Ok() {
        actual = calculator.calculate(-3.98, -2, RAISING_TO_A_POWER);
        expected = 0.063129718946491;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveAndNegativeValuesOperandsToZeroPower_Ok() {
        actual = calculator.calculate(2, 2, RAISING_TO_A_POWER);
        expected = 4;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroToPower_OK() {
        actual = calculator.calculate(ZERO, 98.23, RAISING_TO_A_POWER);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(ZERO, -12.16, RAISING_TO_A_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalOperation_OK() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(1234.67, -123.64, INCORRECT_OPERATION)
        );
    }
}
