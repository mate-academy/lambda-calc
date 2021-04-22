package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double NEGATIVE_NUMBER = -347.981;
    private static final double POSITIVE_NUMBER = 543.234;
    private static final double DELTA = 0.0001;
    private static final char ILLEGAL_OPERATOR = '#';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char MINUS = '-';
    private static final char POWER = '^';
    private static final char PLUS = '+';
    private static final double ZERO = 0;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionTwoPositiveNumbers_isOk() {
        expected = 1086.468;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionTwoNegativeNumbers_isOk() {
        expected = -695.962;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionPositiveAndNegativeNumbers_isOk() {
        expected = 195.253;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionNumberWithZero_isOk() {
        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionMinMaxValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);

        expected = 543.234;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoPositiveNumbers_isOk() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionTwoNegativeNumbers_isOk() {
        expected = ZERO;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeNumbers_isOk() {
        expected = 891.215;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionNumberWithZero_isOk() {
        expected = POSITIVE_NUMBER;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = -POSITIVE_NUMBER;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionMinMaxValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);

        expected = -543.234;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, MINUS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoPositiveNumbers_isOk() {
        expected = 295103.17875600007;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationTwoNegativeNumbers_isOk() {
        expected = 121090.776361;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeNumbers_isOk() {
        expected = -189035.110554;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationNumberWithZero_isOk() {
        expected = ZERO;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationMinMaxValues_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);

        expected = 2.683E-321;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoPositiveNumbers_isOk() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionTwoNegativeNumbers_isOk() {
        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveAndNegativeNumbers_isOk() {
        expected = -1.5611024739856487;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionNumberByZero_isOk() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionNumberByZero_isNotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_divisionMinMaxValues_isOk() {
        expected = 3.3092426741741416E305;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);

        expected = 0.0;
        actual = calculator.calculate(Double.MIN_VALUE, POSITIVE_NUMBER, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumberToPositivePower_isOk() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumberToNegativePower_isOk() {
        expected = 0.0;
        actual = calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Double.NaN;
        actual = calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumberToZeroPower_isOk() {
        expected = 1.0;
        actual = calculator.calculate(POSITIVE_NUMBER, ZERO, POWER);
        assertEquals(expected, actual, DELTA);

        expected = 1.0;
        actual = calculator.calculate(NEGATIVE_NUMBER, ZERO, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_isOk() {
        expected = ZERO;
        actual = calculator.calculate(ZERO, POSITIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);

        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(ZERO, NEGATIVE_NUMBER, POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void illegalOperation_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATOR);
            calculator.calculate(NEGATIVE_NUMBER, POSITIVE_NUMBER, ILLEGAL_OPERATOR);
            calculator.calculate(POSITIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATOR);
            calculator.calculate(NEGATIVE_NUMBER, NEGATIVE_NUMBER, ILLEGAL_OPERATOR);
        });
    }
}
