import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculateTest {
    private static final double DELTA = 0.0001;
    private static Calculate calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculate();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(6, 8, Calculate.PLUS);
        expected = 14;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-6, -8, Calculate.PLUS);
        expected = -14;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-6, 8, Calculate.PLUS);
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(0, 8, Calculate.PLUS);
        expected = 8;
        assertEquals(expected,actual);
        actual = calculator.calculate(6, 0, Calculate.PLUS);
        expected = 6;
        assertEquals(expected,actual);
        actual = calculator.calculate(0, 0, Calculate.PLUS);
        expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_additionWithMaxValues_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, Calculate.PLUS);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithMinValue_OK() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, Calculate.PLUS);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(6, 8, Calculate.MINUS);
        expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-6, -8, Calculate.MINUS);
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstPositiveAndSecondNegativeOperands_Ok() {
        actual = calculator.calculate(-6, 8, Calculate.MINUS);
        expected = -14;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstNegativeAndSecondPositiveOperands_Ok() {
        actual = calculator.calculate(6, -8, Calculate.MINUS);
        expected = 14;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(0, 8, Calculate.MINUS);
        expected = -8;
        assertEquals(expected,actual);
        actual = calculator.calculate(6, 0, Calculate.MINUS);
        expected = 6;
        assertEquals(expected,actual);
        actual = calculator.calculate(0, 0, Calculate.MINUS);
        expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(6, 2, Calculate.DIVISION);
        expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-6, -2, Calculate.DIVISION);
        expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-6, 2, Calculate.DIVISION);
        expected = -3;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroInStart_Ok() {
        actual = calculator.calculate(0, 8, Calculate.DIVISION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithZeroInEnd_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(6, 0, Calculate.DIVISION);
        });
    }

    @Test
    void calculate_divisionWithZeroInStartAndEnd_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, 0, Calculate.DIVISION);
        });
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        actual = calculator.calculate(6, 8, Calculate.MULTIPLICATION);
        expected = 48;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        actual = calculator.calculate(-6, -8, Calculate.MULTIPLICATION);
        expected = 48;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(-6, 8, Calculate.MULTIPLICATION);
        expected = -48;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(0, 8, Calculate.MULTIPLICATION);
        expected = 0;
        assertEquals(expected,actual);
        actual = calculator.calculate(6, 0, Calculate.MULTIPLICATION);
        expected = 0;
        assertEquals(expected,actual);
        actual = calculator.calculate(0, 0, Calculate.MULTIPLICATION);
        expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_Ok() {
        actual = calculator.calculate(5, 2, Calculate.EXPONENTIATION);
        expected = 25;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(-5, 2, Calculate.EXPONENTIATION);
        expected = 25;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_Ok() {
        actual = calculator.calculate(10, -3, Calculate.EXPONENTIATION);
        expected = 0.001;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_Ok() {
        actual = calculator.calculate(-10, -3, Calculate.EXPONENTIATION);
        expected = -0.001;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_Ok() {
        actual = calculator.calculate(5, 0, Calculate.EXPONENTIATION);
        expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(-5, 0, Calculate.EXPONENTIATION);
        expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        actual = calculator.calculate(0, 0, Calculate.EXPONENTIATION);
        expected = 1;
        assertEquals(expected,actual);
        actual = calculator.calculate(0, 5, Calculate.EXPONENTIATION);
        expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void calculate_raisingZeroToNegativePower_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, -5, Calculate.EXPONENTIATION);
        });
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(0, 0, '&');
        });
    }
}
