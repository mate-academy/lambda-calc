package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    double expected;
    double actual;

    @BeforeAll
    static void beforeAll() {
        lambdaCalculator = new LambdaCalculator();
    }

    @Test
    void checkOperation() {
        try {
            lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, ' ');
        } catch (ExceptionIllegalOperation e) {
            return;
        }
        fail("There is no such operation");
    }

    @Test
    void additionTwoPositiveValue_Ok() {
        expected = 5;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionTwoNegativeValue_Ok() {
        expected = -5;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionFirstNegativeValueSecondPositiveValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionFirstPositiveValueSecondNegativeValue_Ok() {
        expected = -1;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionFirstZeroValueSecondNegativeValue_Ok() {
        expected = -3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, ADD);
        assertEquals(expected, actual);

    }

    @Test
    void additionFirstZeroValueSecondPositiveValue_Ok() {
        expected = 3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionTwoMinValue_Ok() {
        expected = 1.0E-323;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionTwoMaxValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionMaxValueAndMinValue_Ok() {
        expected = 1.7976931348623157E308;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void additionTwoZeros_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, ZERO, ADD);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoPositiveValue_Ok() {
        expected = -1;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoNegativeValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -5;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionFirstPositiveValueSecondNegativeValue_Ok() {
        expected = 5;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionFirstZeroValueSecondNegativeValue_Ok() {
        expected = 3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, SUB);
        assertEquals(expected, actual);

    }

    @Test
    void subtractionFirstZeroValueSecondPositiveValue_Ok() {
        expected = -3;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoMinValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoMaxValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMaxValueAndMinValue_Ok() {
        expected = 1.7976931348623157E308;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionTwoZeros_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, ZERO, SUB);
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoPositiveValue_Ok() {
        expected = 0.666666;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionTwoNegativeValue_Ok() {
        expected = 0.666666;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -0.666666;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionFirstPositiveValueSecondNegativeValue_Ok() {
        expected = -0.666666;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, DIV);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionFirstZeroValueSecondNegativeValue_Ok() {
        expected = -0.0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, DIV);
        assertEquals(expected, actual);

    }

    @Test
    void divisionFirstZeroValueSecondPositiveValue_Ok() {
        expected = 0.0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoMinValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoMaxValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void divisionMaxValueAndMinValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void divisionMinValueAndMaxValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MAX_VALUE, DIV);
        assertEquals(expected, actual);
    }

    @Test
    void divisionTwoZeros_Ok() {
        try {
            lambdaCalculator.calculation(ZERO, ZERO, DIV);
        } catch (ArithmeticException e) {
            return;
        }
        fail("You cannot divide by zero");
    }

    @Test
    void multiplicationTwoPositiveValue_Ok() {
        expected = 6;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoNegativeValue_Ok() {
        expected = 6;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -6;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationFirstPositiveValueSecondNegativeValue_Ok() {
        expected = -6;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationFirstZeroValueSecondNegativeValue_Ok() {
        expected = -0.0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, MULTI);
        assertEquals(expected, actual);

    }

    @Test
    void multiplicationFirstZeroValueSecondPositiveValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoMinValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoMaxValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationMaxValueAndMinValue_Ok() {
        expected = 8.881784197001251E-16;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationTwoZeros_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, ZERO, MULTI);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerTwoPositiveValue_Ok() {
        expected = 8;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_POSITIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerTwoNegativeValue_Ok() {
        expected = -0.125;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_NEGATIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerFirstNegativeValueSecondPositiveValue_Ok() {
        expected = -8;
        actual = lambdaCalculator.calculation(FIRS_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerFirstPositiveValueSecondNegativeValue_Ok() {
        expected = 0.125;
        actual = lambdaCalculator.calculation(FIRS_POSITIVE_VALUE, SECOND_NEGATIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerFirstZeroValueSecondNegativeValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(ZERO, SECOND_NEGATIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);

    }

    @Test
    void toPowerFirstZeroValueSecondPositiveValue_Ok() {
        expected = 0;
        actual = lambdaCalculator.calculation(ZERO, SECOND_POSITIVE_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerTwoMinValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MIN_VALUE, Double.MIN_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerTwoMaxValue_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MAX_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerMaxValueAndMinValue_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(Double.MAX_VALUE, Double.MIN_VALUE, TO_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void toPowerTwoZeros_Ok() {
        expected = 1;
        actual = lambdaCalculator.calculation(ZERO, ZERO, TO_POWER);
        assertEquals(expected, actual);
    }
}