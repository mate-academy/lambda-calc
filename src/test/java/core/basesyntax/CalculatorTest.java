package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static double actual;
    private static double expected;
    private static double actualSecond;
    private static double expectedSecond;
    private static final Character ADDITION = '+';
    private static final Character SUBTRACTION = '-';
    private static final Character DIVISION = '/';
    private static final Character MULTIPLICATION = '*';
    private static final Character RAISING = '^';
    private static final Character ILLEGAL_SING = '&';
    private static final double DELTA = 0.0000001;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addition_PositiveOperands_OK() {
        actual = calculator.calculate(0.1, 0.2, ADDITION);
        expected = 0.3;
        assertEquals(expected, actual, DELTA);

        actualSecond = calculator.calculate(2.0005, 2.00041, ADDITION);
        expectedSecond = 4.00091;
        assertEquals(expectedSecond, actualSecond, DELTA);
    }

    @Test
    void calculate_addition_NegativeOperands_OK() {
        actual = calculator.calculate(-0.5, -0.2, ADDITION);
        expected = -0.7;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addition_PositiveNegativeOperands_OK() {
        actual = calculator.calculate(0.3, -0.5, ADDITION);
        expected = -0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addition_ZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(0, -0.5, ADDITION);
        expected = -0.5;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(0.1, 0, ADDITION);
        expectedSecond = 0.1;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void calculate_addition_ForMinAndMaxDoubleValues_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(0.1, Double.MIN_VALUE, ADDITION);
        expectedSecond = 0.1;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void calculate_subtraction_PositiveOperands_OK() {
        actual = calculator.calculate(0.00054, 0.0003, SUBTRACTION);
        expected = 0.00024;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtraction_NegativeOperands_OK() {
        actual = calculator.calculate(-0.00054, -0.0003, SUBTRACTION);
        expected = -0.00024;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtraction_PositiveNegativeOperands_OK() {
        actual = calculator.calculate(0.0003, -0.0005, SUBTRACTION);
        expected = 0.0008;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtraction_ZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(0.0003, 0, SUBTRACTION);
        expected = 0.0003;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(0, 0.0007, SUBTRACTION);
        expectedSecond = -0.0007;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void calculate_subtraction_ForMinAndMaxDoubleValues_OK() {
        actual = calculator.calculate(2000, Double.MAX_VALUE, SUBTRACTION);
        expected = -1.7976931348623157E308;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(2000, Double.MIN_VALUE, SUBTRACTION);
        expectedSecond = 2000;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void calculate_multiplication_PositiveOperands_OK() {
        actual = calculator.calculate(0.005, 0.003, MULTIPLICATION);
        expected = 0.000015;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplication_NegativeOperands_OK() {
        actual = calculator.calculate(-0.005, -0.003, MULTIPLICATION);
        expected = 0.000015;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplication_PositiveNegativeOperands_OK() {
        actual = calculator.calculate(0.0006, -0.0005, MULTIPLICATION);
        expected = -0.0000003;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplication_ZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(0, 0.0005, MULTIPLICATION);
        expected = 0;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(0.0765, 0, MULTIPLICATION);
        expectedSecond = 0;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void calculate_multiplication_ForMinAndMaxDoubleValues_OK() {
        actual = calculator.calculate(0.1, Double.MIN_VALUE, MULTIPLICATION);
        expected = 0;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(10000, Double.MAX_VALUE, MULTIPLICATION);
        expectedSecond = Double.POSITIVE_INFINITY;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void calculate_division_PositiveOperands_OK() {
        actual = calculator.calculate(10, 0.0005, DIVISION);
        expected = 20000;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_division_NegativeOperands_OK() {
        actual = calculator.calculate(-0.0002, -0.0003, DIVISION);
        expected = 0.666666667;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_division_PositiveNegativeOperands_OK() {
        actual = calculator.calculate(0.0002, -0.0001, DIVISION);
        expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_division_ZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(0, 0.0005, DIVISION);
        expected = 0;
        assertEquals(expected, actual);

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0.005, 0, DIVISION);
        });
    }

    @Test
    void calculate_division_ForMinAndMaxDoubleValues_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual,DELTA);

        actualSecond = calculator.calculate(Double.MIN_VALUE, 6.325, DIVISION);
        expectedSecond = 0;
        assertEquals(expectedSecond, actualSecond, DELTA);
    }

    @Test
    void calculate_raising_PositiveValue_ToThePositivePower_OK() {
        actual = calculator.calculate(0.007, 2, RAISING);
        expected = 0.000049;
        assertEquals(expected, actual,0.00001);

        actualSecond = calculator.calculate(0.007, 0.002, RAISING);
        expectedSecond = 0.99012539;
        assertEquals(expectedSecond, actualSecond, DELTA);
    }

    @Test
    void calculate_raising_NegativeValue_ToThePositivePower_OK() {
        actual = calculator.calculate(-0.07, 3, RAISING);
        expected = -0.000343;
        assertEquals(expected, actual,DELTA);

        actualSecond = calculator.calculate(-20, 3, RAISING);
        expectedSecond = -8000;
        assertEquals(expectedSecond, actualSecond, DELTA);
    }

    @Test
    void calculate_raising_PositiveValue_ToTheNegativePower_OK() {
        actual = calculator.calculate(0.07, -3, RAISING);
        expected = 2915.45189504;
        assertEquals(expected, actual,0.00001);

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-0.3, -0.2, RAISING);;
        });
    }

    @Test
    void calculate_raising_NegativeValue_ToTheNegativePower_OK() {
        actual = calculator.calculate(-0.07, -3, RAISING);
        expected = -2915.45189504;
        assertEquals(expected, actual, DELTA);

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-20, -0.2, RAISING);
        });
    }

    @Test
    void calculate_raising_PositiveNegativeValue_toZeroPower_OK() {
        actual = calculator.calculate(-0.07, 0, RAISING);
        expected = 1;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(0.0002, 0, RAISING);
        expectedSecond = 1;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void calculate_raising_ZeroToPower_OK() {
        actual = calculator.calculate(0, 0.2, RAISING);
        expected = 0;
        assertEquals(expected, actual);

        actualSecond = calculator.calculate(0, 0, RAISING);
        expectedSecond = 1;
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void check_illegalOperation_Ok() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(0.005, 2, ILLEGAL_SING);
        });
    }
}
