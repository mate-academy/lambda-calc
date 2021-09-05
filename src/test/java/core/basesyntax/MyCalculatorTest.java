package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {
    private static final double DELTA = 0.0001;
    private static MyCalculator myCalculator;

    @BeforeAll
    static void beforeAll() {
        myCalculator = new MyCalculator();
    }

    @Test
    void calculate_divisionByZero_notOk() {
        assertThrows(MyCalculateException.class, () -> myCalculator.calculate(2.0, 0, '/'));
    }

    @Test
    void calculate_singIsNotCorrect_notOk() {
        assertThrows(MyCalculateException.class, () -> myCalculator.calculate(1, 1, '$'));
    }

    @Test
    void calculate_additionTwoPositiveValues_Ok() throws Exception {
        double actual = myCalculator.calculate(7.7, 3.3, '+');
        double expected = 11;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionPositiveAndNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate(2, -1.1, '+');
        double expected = 0.9;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_additionTowNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate(-2, -1.1, '+');
        double expected = -3.1;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_additionWithFirstZero_Ok() throws Exception {
        double actual = myCalculator.calculate(0, 7, '+');
        double expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionWithSecondZero_Ok() throws Exception {
        double actual = myCalculator.calculate(10, 0, '+');
        double expected = 10;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_additionMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, 0.1, '+'));
    }

    @Test
    void calculate_additionMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, -0.1, '+'));
    }

    @Test
    void calculate_subtractionTwoPositiveValues_Ok() throws Exception {
        double actual = myCalculator.calculate(7.7, 3.3, '-');
        double expected = 4.4;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate(2, -1.1, '-');
        double expected = 3.1;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_subtractionTowNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate((-2), -1.1, '-');
        double expected = -0.9;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_subtractionWithFirstZero_Ok() throws Exception {
        double actual = myCalculator.calculate(0, 7, '-');
        double expected = -7;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionWithSecondZero_Ok() throws Exception {
        double actual = myCalculator.calculate(10, 0, '-');
        double expected = 10;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_subtractionMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, -0.1, '-'));
    }

    @Test
    void calculate_subtractionMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, 0.1, '-'));
    }

    @Test
    void calculate_multiplicationTwoPositiveValues_Ok() throws Exception {
        double actual = myCalculator.calculate(3, 5, '*');
        double expected = 15;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate(2, -5, '*');
        double expected = -10;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_multiplicationTowNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate((-2), -1.1, '*');
        double expected = 2.2;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_multiplicationWithFirstZero_Ok() throws Exception {
        double actual = myCalculator.calculate(0, 7, '*');
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationWithSecondZero_Ok() throws Exception {
        double actual = myCalculator.calculate(10, 0, '*');
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_multiplicationMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, 1.1, '*'));
    }

    @Test
    void calculate_multiplicationMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, 1.1, '*'));
    }

    @Test
    void calculate_divisionTwoPositiveValues_Ok() throws Exception {
        double actual = myCalculator.calculate(9.9, 3.3, '/');
        double expected = 3;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate(10, -5, '/');
        double expected = -2;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_divisionTowNegativeValues_Ok() throws Exception {
        double actual = myCalculator.calculate((-2.2), -1.1, '/');
        double expected = 2;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_divisionWithFirstZero_Ok() throws Exception {
        double actual = myCalculator.calculate(0, 7, '/');
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_divisionMaxValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(Double.MAX_VALUE, 0.9, '/'));
    }

    @Test
    void calculate_divisionMinValue_notOk() {
        assertThrows(MyCalculateException.class,
                () -> myCalculator.calculate(-Double.MAX_VALUE, 0.9, '/'));
    }

    @Test
    void calculate_raisingPositiveValueToPositivePower_Ok() throws MyCalculateException {
        double actual = myCalculator.calculate(7, 2, '^');
        double expected = 49;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingNegativeValueToPositivePower_Ok() throws MyCalculateException {
        double actual = myCalculator.calculate(-7, 2, '^');
        double expected = 49;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingPositiveValueToNegativePower_Ok() throws MyCalculateException {
        double actual = myCalculator.calculate(6.0, -2, '^');
        double expected = 1 / 36.0;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToNegativePower_Ok() throws MyCalculateException {
        double actual = myCalculator.calculate(-7.0, -2, '^');
        double expected = 1 / 49.0;
        assertEquals(actual, expected, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() throws MyCalculateException {
        double actual = myCalculator.calculate(7.0, 0, '^');
        double expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() throws MyCalculateException {
        double actual = myCalculator.calculate(-7.0, 0, '^');
        double expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_raisingZeroValueToPower_Ok() throws MyCalculateException {
        double actual = myCalculator.calculate(0, 3, '^');
        double expected = 0;
        assertEquals(actual, expected);
    }
}
