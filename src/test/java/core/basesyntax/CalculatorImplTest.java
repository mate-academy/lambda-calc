package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
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

    @Test
    void addition_positiveNumbers_Ok() {
        firstDouble = 10;
        secondDouble = 15;
        assertEquals(25, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_negativeNumbers_Ok() {
        firstDouble = -10;
        secondDouble = -15;
        assertEquals(-25, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_posAndNegNumbers_Ok() {
        firstDouble = 10;
        secondDouble = -15;
        assertEquals(-5, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_firstZero_Ok() {
        firstDouble = 0;
        secondDouble = 15;
        assertEquals(15, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_secondZero_Ok() {
        firstDouble = 10;
        secondDouble = 0;
        assertEquals(10, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = 15;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = 15;
        assertEquals(15, doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_positiveMaxValues_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = Double.MAX_VALUE;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '+', secondDouble));
    }

    @Test
    void addition_negativeMaxValues_Ok() {
        firstDouble = -Double.MAX_VALUE;
        secondDouble = -Double.MAX_VALUE;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '+', secondDouble));
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
    void subtraction_positiveNumbers_Ok() {
        firstDouble = 10;
        secondDouble = 15;
        assertEquals(-5, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_negativeNumbers_Ok() {
        firstDouble = -10;
        secondDouble = -15;
        assertEquals(5, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_posAndNegNumbers_Ok() {
        firstDouble = 10;
        secondDouble = -15;
        assertEquals(25, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_firstZero_Ok() {
        firstDouble = 0;
        secondDouble = 15;
        assertEquals(-15, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_secondZero_Ok() {
        firstDouble = 10;
        secondDouble = 0;
        assertEquals(10, doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = 15;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '-', secondDouble));
    }

    @Test
    void subtraction_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = 15;
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
    void multiplication_positiveNumbers_Ok() {
        firstDouble = 10;
        secondDouble = 15;
        assertEquals(150, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_negativeNumbers_Ok() {
        firstDouble = -10;
        secondDouble = -15;
        assertEquals(150, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_posAndNegNumbers_Ok() {
        firstDouble = 10;
        secondDouble = -15;
        assertEquals(-150, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_firstZero_Ok() {
        firstDouble = 0;
        secondDouble = 15;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_secondZero_Ok() {
        firstDouble = 10;
        secondDouble = 0;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = 15;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = 15;
        assertEquals(7.4E-323, doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_positiveMaxValues_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = Double.MAX_VALUE;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '*', secondDouble));
    }

    @Test
    void multiplication_negativeMaxValues_Ok() {
        firstDouble = -Double.MAX_VALUE;
        secondDouble = -Double.MAX_VALUE;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '*', secondDouble));
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
    void division_positiveNumbers_Ok() {
        firstDouble = 10;
        secondDouble = 15;
        assertEquals(0.6666666666666666, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_negativeNumbers_Ok() {
        firstDouble = -10;
        secondDouble = -15;
        assertEquals(0.6666666666666666, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_posAndNegNumbers_Ok() {
        firstDouble = 10;
        secondDouble = -15;
        assertEquals(-0.6666666666666666, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_firstZero_Ok() {
        firstDouble = 0;
        secondDouble = 15;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_secondZero_notOk() {
        firstDouble = 10;
        secondDouble = 0;
        assertThrows(ArithmeticException.class,
                () -> doubleCalculator.calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_oneMaxValue_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = 15;
        assertEquals(1.1984620899082106E307, doubleCalculator
                .calculate(firstDouble, '/', secondDouble));
    }

    @Test
    void division_oneMinValue_Ok() {
        firstDouble = Double.MIN_VALUE;
        secondDouble = 15;
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
    void power_positiveValuePositivePower_Ok() {
        firstDouble = 10;
        secondDouble = 15;
        assertEquals(1.0E15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_negativeValuePositivePower_Ok() {
        firstDouble = -10;
        secondDouble = 15;
        assertEquals(-1.0E15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_positiveValueNegativePower_Ok() {
        firstDouble = 10;
        secondDouble = -15;
        assertEquals(1.0E-15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_negativeValueNegativePower_Ok() {
        firstDouble = -10;
        secondDouble = -15;
        assertEquals(-1.0E-15, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_positiveValueZeroPower_Ok() {
        firstDouble = 10;
        secondDouble = 0;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_negativeValueZeroPower_Ok() {
        firstDouble = -10;
        secondDouble = 0;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_zeroValue_Ok() {
        firstDouble = 0;
        secondDouble = 15;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_zeroValueZeroPower_Ok() {
        firstDouble = 0;
        secondDouble = 0;
        assertEquals(1, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_positiveMaxValues_Ok() {
        firstDouble = Double.MAX_VALUE;
        secondDouble = Double.MAX_VALUE;
        assertThrows(TooBigValuesException.class,
                () -> doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void power_negativeMaxValues_Ok() {
        firstDouble = -Double.MAX_VALUE;
        secondDouble = -Double.MAX_VALUE;
        assertEquals(0, doubleCalculator.calculate(firstDouble, '^', secondDouble));
    }

    @Test
    void calculate_illegalOperation_notOk() {
        firstDouble = 10;
        secondDouble = 15;
        assertThrows(InvalidOperationException.class,
                () -> doubleCalculator.calculate(firstDouble, '&', secondDouble));
    }
}
