package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static Calculator lambdaCalculator;
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char DIV = '/';
    private static final char MULTI = '*';
    private static final char TO_POWER = '^';
    private static final double DELTA = 0.000001;
    private static final double ZERO = 0;
    private static final double FIRS_POSITIVE_VALUE = 2;
    private static final double SECOND_POSITIVE_VALUE = 3;
    private static final double FIRS_NEGATIVE_VALUE = -2;
    private static final double SECOND_NEGATIVE_VALUE = -3;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        lambdaCalculator = new LambdaCalculator();
    }

    @Test
    void calculation_checkOperation_Ok() {
        assertThrows(ExceptionIllegalOperation.class, () -> {
            lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, ' ');
        });
    }

    @Test
    void calculation_additionTwoPositiveValue_Ok() {
        expected = 5;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionTwoNegativeValue_Ok() {
        expected = -5;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionFirstNegativeValueSecondPositiveValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionFirstPositiveValueSecondNegativeValue_Ok() {
        expected = -1;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionFirstZeroValueSecondNegativeValue_Ok() {
        expected = -3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, ADD);
        assertEquals(expected, actual);

    }

    @Test
    void calculation_additionFirstZeroValueSecondPositiveValue_Ok() {
        expected = 3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionTwoMinValue_Ok() {
        expected = 1.0E-323;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionTwoMaxValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionMaxValueAndMinValue_Ok() {
        expected = 1.7976931348623157E308;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_additionTwoZeros_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, ZERO, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionTwoPositiveValue_Ok() {
        expected = -1;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionTwoNegativeValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -5;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionFirstPositiveValueSecondNegativeValue_Ok() {
        expected = 5;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionFirstZeroValueSecondNegativeValue_Ok() {
        expected = 3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionFirstZeroValueSecondPositiveValue_Ok() {
        expected = -3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionTwoMinValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionTwoMaxValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionMaxValueAndMinValue_Ok() {
        expected = 1.7976931348623157E308;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_subtractionTwoZeros_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, ZERO, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_divisionTwoPositiveValue_Ok() {
        expected = 0.666666;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculation_divisionTwoNegativeValue_Ok() {
        expected = 0.666666;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculation_divisionFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -0.666666;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculation_divisionFirstPositiveValueSecondNegativeValue_Ok() {
        expected = -0.666666;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculation_divisionFirstZeroValueSecondNegativeValue_Ok() {
        expected = -0.0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_divisionFirstZeroValueSecondPositiveValue_Ok() {
        expected = 0.0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_divisionTwoMinValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_divisionTwoMaxValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_divisionMaxValueAndMinValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_divisionMinValueAndMaxValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MAX_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_divisionTwoZeros_Ok() {
        assertThrows(ArithmeticException.class, () -> {
            lambdaCalculator.calculation(ZERO, ZERO, DIV);
        });
    }

    @Test
    void calculation_multiplicationTwoPositiveValue_Ok() {
        expected = 6;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationTwoNegativeValue_Ok() {
        expected = 6;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -6;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationFirstPositiveValueSecondNegativeValue_Ok() {
        expected = -6;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationFirstZeroValueSecondNegativeValue_Ok() {
        expected = -0.0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationFirstZeroValueSecondPositiveValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationTwoMinValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationTwoMaxValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationMaxValueAndMinValue_Ok() {
        expected = 8.881784197001251E-16;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_multiplicationTwoZeros_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, ZERO, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerTwoPositiveValue_Ok() {
        expected = 8;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerTwoNegativeValue_Ok() {
        expected = -0.125;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -8;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerFirstPositiveValueSecondNegativeValue_Ok() {
        expected = 0.125;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerFirstZeroValueSecondNegativeValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerFirstZeroValueSecondPositiveValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerTwoMinValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerTwoMaxValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerMaxValueAndMinValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculation_toPowerTwoZeros_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(ZERO, ZERO, TO_POWER);
        assertEquals(expected, actual);
    }
}
