package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final String MAX_VALUE_ADDITION_MESSAGE =
            "Addition with near max values must be infinity";
    private static final String MAX_VALUE_MULTIPLICATION_MESSAGE =
            "Multiplication with near values must be infinity";
    private static double firstDouble;
    private static double secondDouble;
    private static CalculatorImpl doubleCalculator;

    @BeforeAll
    static void beforeAll() {
        doubleCalculator = new CalculatorImpl();
    }

    @BeforeEach
    void beforeEach() {
        firstDouble = 10;
        secondDouble = 15;
    }

    @Test
    void addition_positiveNumbs_Ok() {
        assertEquals(25, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_negativeNumbs_Ok() {
        firstDouble = -1 * firstDouble;
        secondDouble = -1 * secondDouble;
        assertEquals(-25, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_posAndNegNumbs_Ok() {
        secondDouble = -1 * secondDouble;
        assertEquals(-5, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_firstZero_Ok() {
        firstDouble = 0;
        assertEquals(15, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_secondZero_Ok() {
        secondDouble = 0;
        assertEquals(10, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        assertEquals(Double.MAX_VALUE, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        assertEquals(15, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_positiveMaxValues_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = Double.MAX_VALUE;
        assertTrue(Double.isInfinite(doubleCalculator.calculate(firstDouble, '+', secondDouble)),
                MAX_VALUE_ADDITION_MESSAGE);
    }

    @Test
    void addition_negativeMaxValues_Ok() {
        firstDouble = -Double.MAX_VALUE;
        secondDouble = -Double.MAX_VALUE;
        assertTrue(Double.isInfinite(doubleCalculator.calculate(firstDouble, '+', secondDouble)),
                MAX_VALUE_ADDITION_MESSAGE);
    }

    @Test
    void addition_positiveMinValues_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = Double.MIN_VALUE;
        assertEquals(1.0E-323, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_negativeMinValues_Ok() {
        firstDouble = -Double.MIN_VALUE;
        secondDouble = -Double.MIN_VALUE;
        assertEquals(-1.0E-323, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void subtraction_positiveNumbs_Ok() {
        assertEquals(-5, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_negativeNumbs_Ok() {
        firstDouble = -1 * firstDouble;
        secondDouble = -1 * secondDouble;
        assertEquals(5, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_posAndNegNumbs_Ok() {
        secondDouble = -1 * secondDouble;
        assertEquals(25, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_firstZero_Ok() {
        firstDouble = 0;
        assertEquals(-15, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_secondZero_Ok() {
        secondDouble = 0;
        assertEquals(10, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        assertEquals(Double.MAX_VALUE, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        assertEquals(-15, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_positiveMaxValues_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = Double.MAX_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_negativeMaxValues_Ok() {
        firstDouble = -Double.MAX_VALUE;
        secondDouble = -Double.MAX_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_positiveMinValues_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = Double.MIN_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_negativeMinValues_Ok() {
        firstDouble = -Double.MIN_VALUE;
        secondDouble = -Double.MIN_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void multiplication_positiveNumbs_Ok() {
        assertEquals(150, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_negativeNumbs_Ok() {
        firstDouble = -1 * firstDouble;
        secondDouble = -1 * secondDouble;
        assertEquals(150, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_posAndNegNumbs_Ok() {
        secondDouble = -1 * secondDouble;
        assertEquals(-150, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_firstZero_Ok() {
        firstDouble = 0;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_secondZero_Ok() {
        secondDouble = 0;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        assertTrue(Double.isInfinite(doubleCalculator.calculate(firstDouble, '*', secondDouble)),
                MAX_VALUE_MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplication_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        assertEquals(7.4E-323, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_positiveMaxValues_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = Double.MAX_VALUE;
        assertTrue(Double.isInfinite(doubleCalculator.calculate(firstDouble, '*', secondDouble)),
                MAX_VALUE_MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplication_negativeMaxValues_Ok() {
        firstDouble = -Double.MAX_VALUE;
        secondDouble = -Double.MAX_VALUE;
        assertTrue(Double.isInfinite(doubleCalculator.calculate(firstDouble, '*', secondDouble)),
                MAX_VALUE_MULTIPLICATION_MESSAGE);
    }

    @Test
    void multiplication_positiveMinValues_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = Double.MIN_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_negativeMinValues_Ok() {
        firstDouble = -Double.MIN_VALUE;
        secondDouble = -Double.MIN_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void division_positiveNumbs_Ok() {
        assertEquals(0.6666666666666666, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_negativeNumbs_Ok() {
        firstDouble = -1 * firstDouble;
        secondDouble = -1 * secondDouble;
        assertEquals(0.6666666666666666, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_posAndNegNumbs_Ok() {
        secondDouble = -1 * secondDouble;
        assertEquals(-0.6666666666666666, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_firstZero_Ok() {
        firstDouble = 0;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_secondZero_notOk() {
        secondDouble = 0;
        assertThrows(ArithmeticException.class,
                () -> doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        assertEquals(1.1984620899082106E307, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_positiveMaxValues_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = Double.MAX_VALUE;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_negativeMaxValues_Ok() {
        firstDouble = -Double.MAX_VALUE;
        secondDouble = -Double.MAX_VALUE;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_positiveMinValues_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = Double.MIN_VALUE;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_negativeMinValues_Ok() {
        firstDouble = -Double.MIN_VALUE;
        secondDouble = -Double.MIN_VALUE;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void power_positiveValPositivePower_Ok() {
        assertEquals(1.0E15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_negativeValPositivePower_Ok() {
        firstDouble = -1 * firstDouble;
        assertEquals(-1.0E15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_positiveValNegativePower_Ok() {
        secondDouble = -1 * secondDouble;
        assertEquals(1.0E-15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_negativeValNegativePower_Ok() {
        firstDouble = -1 * firstDouble;
        secondDouble = -1 * secondDouble;
        assertEquals(-1.0E-15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_positiveValZeroPower_Ok() {
        secondDouble = 0;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_negativeValZeroPower_Ok() {
        firstDouble = -1 * firstDouble;
        secondDouble = 0;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_zeroVal_Ok() {
        firstDouble = 0;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_zeroValZeroPower_Ok() {
        firstDouble = 0;
        secondDouble = 0;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(InvalidOperationException.class,
                () -> doubleCalculator.calculate(firstDouble, '&', secondDouble));
    }
}
