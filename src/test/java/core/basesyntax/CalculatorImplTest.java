package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static Calculator calculator;
    private static final double FIRST_PARAM_POSITIVE = 25.5;
    private static final double SECOND_PARAM_POSITIVE = 10.7;
    private static final double FIRST_PARAM_NEGATIVE = -176.84;
    private static final double SECOND_PARAM_NEGATIVE = -65.12;
    private static final double ZERO_PARAM = 0.00;
    private static final double PARAM_MAX_VALUE = Double.MAX_VALUE;
    private static final double PARAM_MIN_VALUE = Double.MIN_VALUE;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    void whenWrongOperator_expectExceptionTest() {
        assertThrows(RuntimeException.class,
                () -> {
                    calculator.calculate(1, '?', 1);
                });
    }

    @Test
    void whenBothParamsIsDoubleMaxValue_expectExceptionTest() {
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(PARAM_MAX_VALUE, '+', PARAM_MAX_VALUE);
                });
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(PARAM_MAX_VALUE, '-', -PARAM_MAX_VALUE);
                });
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(PARAM_MAX_VALUE, '*', PARAM_MAX_VALUE);
                });
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(PARAM_MAX_VALUE, '^', PARAM_MAX_VALUE);
                });
    }

    @Test
    void whenDivisionByZero_expectExceptionTest() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(1, '/', 0);
        });
    }

    @Test
    void whenAdditionTwoPositiveParams_expectOkTest() {
        double expected = 36.2;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '+',
                SECOND_PARAM_POSITIVE);
        assertEquals(expected, actual, "expected is "
                + expected + " but actual is " + actual);
    }

    @Test
    void whenAdditionTwoNegativeParams_expectOkTest() {
        double expected = -241.96;
        double actual = calculator.calculate(FIRST_PARAM_NEGATIVE, '+',
                SECOND_PARAM_NEGATIVE);
        assertEquals(expected, actual, "expected is "
                + expected + " but actual is " + actual);
    }

    @Test
    void whenAdditionPositiveAndNegativeParams_expectOkTest() {
        double expected = -39.6;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '+',
                SECOND_PARAM_NEGATIVE);
        assertEquals(expected, actual, 0.1);
    }

    @Test
    void whenAdditionWithOneZeroParam_expectOkTest() {
        double expected = 25.5;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '+', ZERO_PARAM);
        assertEquals(expected, actual, "expected is "
                + expected + " but actual is " + actual);
    }

    @Test
    void whenSubtractionTwoPositiveParams_expectOkTest() {
        double expected = 14.8;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '-',
                SECOND_PARAM_POSITIVE);
        assertEquals(expected, actual, "expected is "
                + expected + " but actual is " + actual);
    }

    @Test
    void whenSubtractionTwoNegativeParams_expectOkTest() {
        double expected = -111.7;
        double delta = 0.1;
        double actual = calculator.calculate(FIRST_PARAM_NEGATIVE, '-',
                SECOND_PARAM_NEGATIVE);
        assertEquals(expected, actual, delta, "expected is "
                + expected + " but actual is " + actual + " allowed delta " + delta);
    }

    @Test
    void whenSubtractionNegativeAndPositiveParams_expectOkTest() {
        double expected = -187.54;
        double actual = calculator.calculate(FIRST_PARAM_NEGATIVE, '-',
                SECOND_PARAM_POSITIVE);
        assertEquals(expected, actual);
    }

    @Test
    void whenSubtractionWithFirstZeroSecondNegativeParam_expectTrueTest() {
        double actual = calculator.calculate(ZERO_PARAM, '-',
                SECOND_PARAM_NEGATIVE);
        assertTrue(actual > 0);
    }

    @Test
    void whenMultiplicationTwoPositiveParams_expectFalseTest() {
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '*',
                SECOND_PARAM_POSITIVE);
        assertFalse(actual < 0);
    }

    @Test
    void whenMultiplicationTwoNegativeParams_expectOkTest() {
        double expected = 11515.81;
        double delta = 0.1;
        double actual = calculator.calculate(FIRST_PARAM_NEGATIVE, '*',
                SECOND_PARAM_NEGATIVE);
        assertEquals(expected, actual, delta, "expected is "
                + expected + " but actual is " + actual + " allowed delta " + delta);
    }

    @Test
    void whenMultiplicationPositiveAndNegativeParams_expectOkTest() {
        double expected = -1660.56;
        double delta = 0.05;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '*', SECOND_PARAM_NEGATIVE);
        assertEquals(expected, actual, delta, "expected is "
                + expected + " but actual is " + actual + " allowed delta " + delta);
    }

    @Test
    void whenMultiplicationWithZeroParam_expectTrueTest() {
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '*', ZERO_PARAM);
        assertTrue(actual == 0);
    }

    @Test
    void whenDivisionTwoPositiveParams_expectOkTest() {
        double expected = 2.38;
        double delta = 0.01;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '/',
                SECOND_PARAM_POSITIVE);
        assertEquals(expected, actual, delta, "expected is "
                + expected + " but actual is " + actual + " allowed delta " + delta);
    }

    @Test
    void whenDivisionTwoNegativeParams_expectTrueTest() {
        double actual = calculator.calculate(FIRST_PARAM_NEGATIVE, '/',
                SECOND_PARAM_NEGATIVE);
        assertTrue(actual > 0);
    }

    @Test
    void whenDivisionFirstNegativeSecondPositiveParams_expectOkTest() {
        double expected = -16.5;
        double delta = 0.1;
        double actual = calculator.calculate(FIRST_PARAM_NEGATIVE, '/',
                SECOND_PARAM_POSITIVE);
        assertEquals(expected, actual, delta, "expected is "
                + expected + " but actual is " + actual + " allowed delta " + delta);
    }

    @Test
    void whenDivisionFirstZeroParam_expectTrueTest() {
        double actual = calculator.calculate(ZERO_PARAM, '/', SECOND_PARAM_POSITIVE);
        assertTrue(actual == 0);
    }

    @Test
    void whenRaisingPositiveValueToPositivePower_expectOkTest() {
        double expected = 1.1219666054546732E15;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '^',
                SECOND_PARAM_POSITIVE);
        assertEquals(expected, actual);
    }

    @Test
    void whenRaisingPositiveValueToNegativePower_expectOkTest() {
        double expected = 2.547436986820479E-92;
        double actual = calculator.calculate(FIRST_PARAM_POSITIVE, '^',
                SECOND_PARAM_NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void whenNegativeValueToZeroPower_expectTrueTest() {
        double actual = calculator.calculate(FIRST_PARAM_NEGATIVE, '^', ZERO_PARAM);
        assertTrue(actual == 1);
    }

    @Test
    void whenZeroValueToNegativePower_expectExceptionTest() {
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(ZERO_PARAM, '^', SECOND_PARAM_NEGATIVE);
                }
        );
    }
}
