package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static final double DELTA = 0.0001;
    private static final double firstParameter = 0.1;
    private static final double secondParameter = 0.2;
    private static final double zeroParameter = 0;
    private static final double degreeOfPower = 3;
    private static final double minDouble = Double.MIN_VALUE;
    private static final double maxDouble = Double.MAX_VALUE;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(firstParameter, secondParameter, '+');
        expected = 0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-firstParameter, -secondParameter, '+');
        expected = -0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(firstParameter, -secondParameter, '+');
        expected = -0.1;
        assertEquals(expected, actual);
        actual = calculator.calculate(-firstParameter, secondParameter, '+');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirthZeroOperands_ok() {
        actual = calculator.calculate(zeroParameter, secondParameter, '+');
        expected = 0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithSecondZeroOperands_ok() {
        actual = calculator.calculate(firstParameter, zeroParameter, '+');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMinDoubleValues_ok() {
        actual = calculator.calculate(minDouble, minDouble, '+');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithMaxDoubleValues_ok() {
        actual = calculator.calculate(maxDouble, maxDouble, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(firstParameter, secondParameter, '-');
        expected = -0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-firstParameter, -secondParameter, '-');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(firstParameter, -secondParameter, '-');
        expected = 0.3;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-firstParameter, secondParameter, '-');
        expected = -0.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithFirthZeroOperands_ok() {
        actual = calculator.calculate(zeroParameter, secondParameter, '-');
        expected = -0.2;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondZeroOperands_ok() {
        actual = calculator.calculate(firstParameter, zeroParameter, '-');
        expected = 0.1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMinDoubleValues_ok() {
        actual = calculator.calculate(minDouble, minDouble, '-');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithMaxDoubleValues_ok() {
        actual = calculator.calculate(maxDouble, maxDouble, '-');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(firstParameter, secondParameter, '*');
        expected = 0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-firstParameter, -secondParameter, '*');
        expected = 0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(firstParameter, -secondParameter, '*');
        expected = -0.02;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-firstParameter, secondParameter, '*');
        expected = -0.02;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithFirthZeroOperands_ok() {
        actual = calculator.calculate(zeroParameter, secondParameter, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondZeroOperands_ok() {
        actual = calculator.calculate(firstParameter, zeroParameter, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMinDoubleValues_ok() {
        actual = calculator.calculate(minDouble, minDouble, '*');
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithMaxDoubleValues_ok() {
        actual = calculator.calculate(maxDouble, maxDouble, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_ok() {
        actual = calculator.calculate(firstParameter, secondParameter, '/');
        expected = 0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_ok() {
        actual = calculator.calculate(-firstParameter, -secondParameter, '/');
        expected = 0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_ok() {
        actual = calculator.calculate(firstParameter, -secondParameter, '/');
        expected = -0.5;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-firstParameter, secondParameter, '/');
        expected = -0.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithFirthZeroOperands_ok() {
        actual = calculator.calculate(zeroParameter, secondParameter, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondZeroOperands_not0k() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(firstParameter, zeroParameter, '/'));
    }

    @Test
    void calculate_divisionWithMinDoubleValues_ok() {
        actual = calculator.calculate(minDouble, minDouble, '/');
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithMaxDoubleValues_ok() {
        actual = calculator.calculate(maxDouble, maxDouble, '/');
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_ok() {
        actual = calculator.calculate(firstParameter, degreeOfPower, '^');
        expected = 0.001;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_ok() {
        actual = calculator.calculate(-firstParameter, degreeOfPower, '^');
        expected = -0.001;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_ok() {
        actual = calculator.calculate(firstParameter, -degreeOfPower, '^');
        expected = 1.0 / 0.1 / 0.1 / 0.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_ok() {
        actual = calculator.calculate(-firstParameter, -degreeOfPower, '^');
        expected = 1.0 / -0.1 / -0.1 / -0.1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToZeroPower_ok() {
        actual = calculator.calculate(firstParameter, zeroParameter, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToZeroPower_ok() {
        actual = calculator.calculate(-firstParameter, zeroParameter, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        actual = calculator.calculate(zeroParameter, degreeOfPower, '^');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalOperationException.class, () ->
                calculator.calculate(firstParameter, secondParameter, '#'));
    }
}
