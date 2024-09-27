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
    private static final char ILLEGAL_OPERATION = '@';
    private static final double ZERO = 0.0;
    private static final double DELTA = 0.0001;
    private static final double POSITIVE_VALUE = 1985.021;
    private static final double NEGATIVE_VALUE = -2105.123;
    private static final double DOUBLE_MIN_VALUE = -Double.MAX_VALUE;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addTwoPositiveValues_Ok() {
        expected = 3_970.042;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addTwoNegativeValues_Ok() {
        expected = -4_210.246;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addPositiveAndNegativeValues_Ok() {
        expected = -120.102;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addPositiveAndZeroValues_Ok() {
        expected = POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addNegativeAndZeroValues_Ok() {
        expected = NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addZeroAndZeroValues_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, ZERO, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addPositiveAndDoubleMaxValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addNegativeAndDoubleMaxValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, Double.MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addZeroAndDoubleMaxValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(ZERO, Double.MAX_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addPositiveAndDoubleMinValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, DOUBLE_MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addNegativeAndDoubleMinValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, DOUBLE_MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addZeroAndDoubleMinValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(ZERO, DOUBLE_MIN_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractTwoPositiveValues_Ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractTwoNegativeValues_Ok() {
        expected = ZERO;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractPositiveAndNegativeValues_Ok() {
        expected = 4_090.144;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractNegativeAndPositiveValues_Ok() {
        expected = -4_090.144;
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractPositiveAndZeroValues_Ok() {
        expected = POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractNegativeAndZeroValues_Ok() {
        expected = NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractZeroAndNegativeValues_Ok() {
        expected = 2105.123;
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractZeroAndZeroValues_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, ZERO, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractPositiveAndDoubleMaxValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractDoubleMaxAndPositiveValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractNegativeAndDoubleMaxValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractDoubleMaxAndNegativeValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(Double.MAX_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractZeroAndDoubleMaxValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(ZERO, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractPositiveAndDoubleMinValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, DOUBLE_MIN_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractDoubleMinAndPositiveValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(DOUBLE_MIN_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractNegativeAndDoubleMinValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, DOUBLE_MIN_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractDoubleMinAndNegativeValues_Ok() {
        expected = DOUBLE_MIN_VALUE;
        actual = calculator.calculate(DOUBLE_MIN_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractZeroAndDoubleMinValues_Ok() {
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(ZERO, DOUBLE_MIN_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyTwoPositiveValues_Ok() {
        expected = 3_940_308.3704;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyTwoNegativeValues_Ok() {
        expected = 4_431_542.8451;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyPositiveAndNegativeValues_Ok() {
        expected = -4_178_713.3625;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyPositiveAndZeroValues_Ok() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyNegativeAndZeroValues_Ok() {
        expected = ZERO;
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyZeroAndZeroValues_Ok() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyPositiveAndDoubleMaxValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyNegativeAndDoubleMaxValues_Ok() {
        expected = Double.NEGATIVE_INFINITY;
        actual = calculator.calculate(NEGATIVE_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyPositiveAndDoubleMinValues_Ok() {
        expected = Double.NEGATIVE_INFINITY;
        actual = calculator.calculate(POSITIVE_VALUE, DOUBLE_MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyNegativeAndDoubleMinValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(NEGATIVE_VALUE, DOUBLE_MIN_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideTwoPositiveValues_Ok() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideTwoNegativeValues_Ok() {
        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividePositiveByNegativeValues_Ok() {
        expected = -0.9429;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividePositiveByZeroValues_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(NEGATIVE_VALUE, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_divideNegativeByZeroValues_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(NEGATIVE_VALUE, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_divideZeroByZeroValues_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(NEGATIVE_VALUE, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_dividePositiveByDoubleMaxValues_Ok() {
        expected = 1.104204583921956E-305;
        actual = calculator.calculate(POSITIVE_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideNegativeByDoubleMaxValues_Ok() {
        expected = -1.171013539060564E-305;
        actual = calculator.calculate(NEGATIVE_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividePositiveByDoubleMinValues_Ok() {
        expected = -1.104204583921956E-305;
        actual = calculator.calculate(POSITIVE_VALUE, DOUBLE_MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideNegativeByDoubleMinValues_Ok() {
        expected = 1.171013539060564E-305;
        actual = calculator.calculate(NEGATIVE_VALUE, DOUBLE_MIN_VALUE, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValuesToPositivePower_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValuesToNegativePower_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValuesToPositivePower_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValuesToNegativePower_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.NaN;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValuesToZeroPower_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValuesToZeroPower_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, RAISING_TO_A_POWER);
        expected = 1.0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroValuesToPositivePower_Ok() {
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, RAISING_TO_A_POWER);
        expected = ZERO;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroValuesToNegativePower_Ok() {
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, RAISING_TO_A_POWER);
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(POSITIVE_VALUE, ZERO, ILLEGAL_OPERATION);
            calculator.calculate(NEGATIVE_VALUE, ZERO, ILLEGAL_OPERATION);
            calculator.calculate(ZERO, NEGATIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(ZERO, POSITIVE_VALUE, ILLEGAL_OPERATION);
            calculator.calculate(ZERO, ZERO, ILLEGAL_OPERATION);
        });
    }
}
