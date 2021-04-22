package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final String ERROR_MESSAGE = "Error! Expected value is not equal actual";
    private static final double MIN_DOUBLE_VALUE = -Double.MAX_VALUE;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';
    private static final char ILLEGAL_OPERATION = '?';
    private static final double DELTA = 0.0001;
    private static ICalculate calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositives_Ok() {
        actual = calculator.calculate(10.35, 14.24, ADDITION);
        expected = 24.59;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithTwoNegatives_Ok() {
        actual = calculator.calculate(-10.35, -14.24, ADDITION);
        expected = -24.59;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithPositiveAndNegative_Ok() {
        actual = calculator.calculate(10.35, -14.24, ADDITION);
        expected = -3.89;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(-9.34, 13.21, ADDITION);
        expected = 3.87;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithPositiveAndZero_Ok() {
        actual = calculator.calculate(10.35, 0.0, ADDITION);
        expected = 10.35;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(0.0, 2.45, ADDITION);
        expected = 2.45;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithNegativeAndZero_Ok() {
        actual = calculator.calculate(-10.35, 0.0, ADDITION);
        expected = -10.35;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(0.0, -23.09, ADDITION);
        expected = -23.09;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithTwoZeroes_Ok() {
        actual = calculator.calculate(0.0, 0.0, ADDITION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithPositiveAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(15.45, Double.MAX_VALUE, ADDITION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, 13.67, ADDITION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithNegativeAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(-15.44, Double.MAX_VALUE, ADDITION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, -13.67, ADDITION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithPositiveAndMinDoubleValue_Ok() {
        actual = calculator.calculate(15.45, MIN_DOUBLE_VALUE, ADDITION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, 16.87, ADDITION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void additionWithNegativeAndMinDoubleValue_Ok() {
        actual = calculator.calculate(-15.45, MIN_DOUBLE_VALUE, ADDITION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, -16.87, ADDITION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithTwoPositives_Ok() {
        actual = calculator.calculate(24.25, 14.24, SUBTRACTION);
        expected = 10.01;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithTwoNegatives_Ok() {
        actual = calculator.calculate(-24.25, -14.24, SUBTRACTION);
        expected = -10.01;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithPositiveAndNegative_Ok() {
        actual = calculator.calculate(10.35, -14.24, SUBTRACTION);
        expected = 24.59;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(-30.35, 4.24, SUBTRACTION);
        expected = -34.59;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithPositiveAndZero_Ok() {
        actual = calculator.calculate(10.55, 0.0, SUBTRACTION);
        expected = 10.55;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(0.0, 12.04, SUBTRACTION);
        expected = -12.04;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithNegativeAndZero_Ok() {
        actual = calculator.calculate(-10.35, 0.0, SUBTRACTION);
        expected = -10.35;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(0.0, -12.04, SUBTRACTION);
        expected = 12.04;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithTwoZeroes_Ok() {
        actual = calculator.calculate(0.0, 0.0, SUBTRACTION);
        expected = 0.00;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithPositiveAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(10.34, Double.MAX_VALUE, SUBTRACTION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, 23.15, SUBTRACTION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithNegativeAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(-10.34, Double.MAX_VALUE, SUBTRACTION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, -34.65, SUBTRACTION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void subtractionWithPositiveAndMinDoubleValue_Ok() {
        actual = calculator.calculate(10.34, MIN_DOUBLE_VALUE, SUBTRACTION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, 23.15, SUBTRACTION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA,ERROR_MESSAGE);
    }

    @Test
    void subtractionWithNegativeAndMinDoubleValue_Ok() {
        actual = calculator.calculate(-10.36, MIN_DOUBLE_VALUE, SUBTRACTION);
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, -23.05, SUBTRACTION);
        expected = MIN_DOUBLE_VALUE;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithTwoPositives_Ok() {
        actual = calculator.calculate(24.25, 14.24, MULTIPLICATION);
        expected = 345.32;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithTwoNegatives_Ok() {
        actual = calculator.calculate(-24.25, -14.24, MULTIPLICATION);
        expected = 345.32;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithPositiveAndNegative_Ok() {
        actual = calculator.calculate(10.35, -14.24, MULTIPLICATION);
        expected = -147.384;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(-30.35, 4.24, MULTIPLICATION);
        expected = -128.684;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithPositiveAndZero_Ok() {
        actual = calculator.calculate(10.55, 0.0, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(0.0, 12.04, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithNegativeAndZero_Ok() {
        actual = calculator.calculate(-10.35, 0.0, MULTIPLICATION);
        expected = -0.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(0.0, -12.04, MULTIPLICATION);
        expected = -0.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithTwoZeroes_Ok() {
        actual = calculator.calculate(0.0, 0.0, MULTIPLICATION);
        expected = 0.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithPositiveAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(10.34, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, 23.15, MULTIPLICATION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithNegativeAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(-10.34, Double.MAX_VALUE, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, -34.65, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithPositiveAndMinDoubleValue_Ok() {
        actual = calculator.calculate(10.34, MIN_DOUBLE_VALUE, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, 23.15, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void multiplicationWithNegativeAndMinDoubleValue_Ok() {
        actual = calculator.calculate(10.36, MIN_DOUBLE_VALUE, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, 23.05, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionPositiveValueByPositive_Ok() {
        actual = calculator.calculate(247.25, 14.24, DIVISION);
        expected = 17.36306;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionPositiveValueByNegative_Ok() {
        actual = calculator.calculate(100.35, -14.24, DIVISION);
        expected = -7.04705;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionNegativeValueByPositive_Ok() {
        actual = calculator.calculate(-350.35, 40.24, DIVISION);
        expected = -8.70651;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionNegativeValueByNegative_Ok() {
        actual = calculator.calculate(-524.25, -12.24, DIVISION);
        expected = 42.830882;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionPositiveValueByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(5.76, 0.0, DIVISION);
        });
    }

    @Test
    void divisionNegativeValueByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-1.44, 0.0, DIVISION);
        });
    }

    @Test
    void divisionZeroValueByZero_Ok() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0.0, 0.0, DIVISION);
        });
    }

    @Test
    void divisionWithPositiveAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(10.34, Double.MAX_VALUE, DIVISION);
        expected = 5.751815924241116E-308;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, 23.15, DIVISION);
        expected = 7.76541310955644E306;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionWithNegativeAndMaxDoubleValue_Ok() {
        actual = calculator.calculate(-10.34, Double.MAX_VALUE, DIVISION);
        expected = -5.751815924241116E-308;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(Double.MAX_VALUE, -34.65, DIVISION);
        expected = -5.1881475753602184E306;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionWithPositiveAndMinDoubleValue_Ok() {
        actual = calculator.calculate(10.34, MIN_DOUBLE_VALUE, DIVISION);
        expected = -5.751815924241116E-308;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, 23.15, DIVISION);
        expected = -7.76541310955644E306;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void divisionWithNegativeAndMinDoubleValue_Ok() {
        actual = calculator.calculate(10.36, MIN_DOUBLE_VALUE, DIVISION);
        expected = -5.762941293533652E-308;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);

        actual = calculator.calculate(MIN_DOUBLE_VALUE, 23.05, DIVISION);
        expected = -7.799102537363625E306;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingPositiveValueToPositivePower_Ok() {
        actual = calculator.calculate(24.25, 4.24, RAISING);
        expected = 743323.3749;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingNegativeValueToPositivePower_Ok() {
        actual = calculator.calculate(-124.25, 6.24, RAISING);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingPositiveValueToNegativePower_Ok() {
        actual = calculator.calculate(24.95, -14.28, RAISING);
        expected = 1.1215859145892847E-20;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingNegativeValueToNegativePower_Ok() {
        actual = calculator.calculate(-24.95, -14.28, RAISING);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        actual = calculator.calculate(10.35, 0.0, RAISING);
        expected = 1.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(-10.35, 0.0, RAISING);
        expected = 1.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingZeroToPositivePower_Ok() {
        actual = calculator.calculate(0.0, 5.1, RAISING);
        expected = 0.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingZeroToNegativePower_Ok() {
        actual = calculator.calculate(0.0, -4.05, RAISING);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void raisingZeroToZeroPower_Ok() {
        actual = calculator.calculate(0.0, 0.0, RAISING);
        expected = 1.0;
        assertEquals(expected, actual, DELTA, ERROR_MESSAGE);
    }

    @Test
    void wrongOperationType_NotOk() {
        assertThrows(IllegalOperationException.class, () -> {
            calculator.calculate(21.44, 2.78, ILLEGAL_OPERATION);
        });
    }
}
