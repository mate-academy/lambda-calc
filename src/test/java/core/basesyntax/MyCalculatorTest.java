package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';
    private static final double DELTA = 0.0001;
    private static MyCalculator myCalculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        myCalculator = new MyCalculator();
    }

    @Test
    void calculate_divisionByZero_notOk() {
        assertThrows(MyCalculateException.class, () -> myCalculator.calculate(2.0, 0, DIVISION));
    }

    @Test
    void calculate_singIsNotCorrect_notOk() {
        assertThrows(UnsupportedOperationException.class, () -> myCalculator.calculate(1, 1, '$'));
    }

    @Test
    void calculate_additionTwoPositiveValues_Ok() {
        actual = myCalculator.calculate(7.7, 3.3, ADDITION);
        expected = 11;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionPositiveAndNegativeValues_Ok() {
        actual = myCalculator.calculate(2, -1.1, ADDITION);
        expected = 0.9;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeValues_Ok() {
        actual = myCalculator.calculate(-2, -1.1, ADDITION);
        expected = -3.1;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionWithFirstZero_Ok() {
        actual = myCalculator.calculate(0, 7, ADDITION);
        expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionWithSecondZero_Ok() {
        actual = myCalculator.calculate(10, 0, ADDITION);
        expected = 10;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION));
    }

    @Test
    void calculate_additionMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION));
    }

    @Test
    void calculate_subtractionTwoPositiveValues_Ok() {
        actual = myCalculator.calculate(7.7, 3.3, SUBTRACTION);
        expected = 4.4;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeValues_Ok() {
        actual = myCalculator.calculate(2, -1.1, SUBTRACTION);
        expected = 3.1;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionTwoNegativeValues_Ok() {
        actual = myCalculator.calculate(-2, -1.1, SUBTRACTION);
        expected = -0.9;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_subtractionWithFirstZero_Ok() {
        actual = myCalculator.calculate(0, 7, SUBTRACTION);
        expected = -7;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionWithSecondZero_Ok() {
        actual = myCalculator.calculate(10, 0, SUBTRACTION);
        expected = 10;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void calculate_subtractionMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void calculate_multiplicationTwoPositiveValues_Ok() {
        actual = myCalculator.calculate(3, 5, MULTIPLICATION);
        expected = 15;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeValues_Ok() {
        actual = myCalculator.calculate(2, -5, MULTIPLICATION);
        expected = -10;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationTwoNegativeValues_Ok() {
        actual = myCalculator.calculate(-2, -1.1, MULTIPLICATION);
        expected = 2.2;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationWithFirstZero_Ok() {
        actual = myCalculator.calculate(0, 7, MULTIPLICATION);
        expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationWithSecondZero_Ok() {
        actual = myCalculator.calculate(10, 0, MULTIPLICATION);
        expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, 1.1, MULTIPLICATION));
    }

    @Test
    void calculate_multiplicationMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, 1.1, MULTIPLICATION));
    }

    @Test
    void calculate_divisionTwoPositiveValues_Ok() {
        actual = myCalculator.calculate(9.9, 3.3, DIVISION);
        expected = 3;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeValues_Ok() {
        actual = myCalculator.calculate(10, -5, DIVISION);
        expected = -2;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_divisionTwoNegativeValues_Ok() {
        actual = myCalculator.calculate(-2.2, -1.1, DIVISION);
        expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_divisionWithFirstZero_Ok() {
        actual = myCalculator.calculate(0, 7, DIVISION);
        expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_divisionMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, 0.9, DIVISION));
    }

    @Test
    void calculate_divisionMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, 0.9, DIVISION));
    }

    @Test
    void calculate_raisingPositiveValueToPositivePower_Ok() {
        actual = myCalculator.calculate(7, 2, RAISING_TO_A_POWER);
        expected = 49;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingNegativeValueToPositivePower_Ok() {
        actual = myCalculator.calculate(-7, 2, RAISING_TO_A_POWER);
        expected = 49;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingPositiveValueToNegativePower_Ok() {
        actual = myCalculator.calculate(6.0, -2, RAISING_TO_A_POWER);
        expected = 1 / 36.0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingNegativeValueToNegativePower_Ok() {
        actual = myCalculator.calculate(-7.0, -2, RAISING_TO_A_POWER);
        expected = 1 / 49.0;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() {
        actual = myCalculator.calculate(7.0, 0, RAISING_TO_A_POWER);
        expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() {
        actual = myCalculator.calculate(-7.0, 0, RAISING_TO_A_POWER);
        expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingZeroValueToPower_Ok() {
        actual = myCalculator.calculate(0, 3, RAISING_TO_A_POWER);
        expected = 0;
        assertEquals(actual, expected);
    }
}
