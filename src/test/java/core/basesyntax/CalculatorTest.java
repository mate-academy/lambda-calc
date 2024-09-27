package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.DivisionByZeroException;
import core.basesyntax.exception.NotSupportOperationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char TO_POWER = '^';
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private static final double FIRST_POSITIVE = 16.234;
    private static final double SECOND_POSITIVE = 15.234;
    private static final double FIRST_NEGATIVE = -16.234;
    private static final double SECOND_NEGATIVE = -15.234;
    private static final double ZERO = 0;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void twoPositiveAddition_OK() {
        double expected = 31.468;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE,
                ADDITION), DELTA);
    }

    @Test
    void twoNegativeAddition_OK() {
        double expected = -31.468;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE,
                ADDITION), DELTA);
    }

    @Test
        void firstNegativeAndPositiveAddition_OK() {
        double expected = -1.0;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE,
                ADDITION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveAddition_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE,
                ADDITION), DELTA);
    }

    @Test
    void firstZeroAddition_OK() {
        double expected = 15.234;
        assertEquals(expected, calculator.calculate(ZERO, SECOND_POSITIVE,
                ADDITION), DELTA);
    }

    @Test
    void secondZeroAddition_OK() {
        double expected = 16.234;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, ZERO, ADDITION), DELTA);
    }

    @Test
    void twoZeroAddition_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, ADDITION));
    }

    @Test
    void twoPositiveSubtraction_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE,
                SUBTRACTION), DELTA);
    }

    @Test
    void twoNegativeSubtraction_OK() {
        double expected = -1.0;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE,
                SUBTRACTION), DELTA);
    }

    @Test
    void firstNegativeAndPositiveSubtraction_OK() {
        double expected = -31.468;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE,
                SUBTRACTION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveSubtraction_OK() {
        double expected = 31.468;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE,
                SUBTRACTION), DELTA);
    }

    @Test
    void firstZeroSubtraction_OK() {
        double expected = -15.234;
        assertEquals(expected, calculator.calculate(ZERO, SECOND_POSITIVE,
                SUBTRACTION), DELTA);
    }

    @Test
    void secondZeroSubtraction_OK() {
        double expected = 16.234;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, ZERO,
                SUBTRACTION), DELTA);
    }

    @Test
    void twoZeroSubtraction_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO,
                SUBTRACTION));
    }

    @Test
    void twoPositiveDivision_OK() {
        double expected = 1.0656;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE,
                DIVISION), DELTA);
    }

    @Test
    void twoNegativeDivision_OK() {
        double expected = 1.0656;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE,
                DIVISION), DELTA);
    }

    @Test
    void firstNegativeAndPositiveDivision_OK() {
        double expected = -1.0656;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE,
                DIVISION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveDivision_OK() {
        double expected = -1.0656;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE,
                DIVISION), DELTA);
    }

    @Test
    void firstZeroDivision_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, SECOND_POSITIVE, DIVISION), DELTA);
    }

    @Test
    void secondZeroDivision_NotOK() {
        assertThrows(DivisionByZeroException.class, () ->
                calculator.calculate(SECOND_POSITIVE, ZERO, DIVISION));
    }

    @Test
    void twoZeroDivision_NotOK() {
        assertThrows(DivisionByZeroException.class, () ->
                calculator.calculate(ZERO, ZERO, DIVISION));
    }

    @Test
    void twoPositiveMultiplication_OK() {
        double expected = 247.3087;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE,
                MULTIPLICATION), DELTA);
    }

    @Test
    void twoNegativeMultiplication_OK() {
        double expected = 247.3087;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE,
                MULTIPLICATION), DELTA);
    }

    @Test
    void firstNegativeAndPositiveMultiplication_OK() {
        double expected = -247.3087;
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE,
                MULTIPLICATION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveMultiplication_OK() {
        double expected = -247.3087;
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE,
                MULTIPLICATION), DELTA);
    }

    @Test
    void firstZeroMultiplication_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, SECOND_POSITIVE, MULTIPLICATION), DELTA);
    }

    @Test
    void secondZeroMultiplication_OK() {
        assertEquals(ZERO, calculator.calculate(SECOND_POSITIVE, ZERO, MULTIPLICATION), DELTA);
    }

    @Test
    void twoZeroMultiplication_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, MULTIPLICATION), DELTA);
    }

    @Test
    void twoPositiveToPower_OK() {
        double expected = Math.pow(FIRST_POSITIVE, SECOND_POSITIVE);
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, TO_POWER));
    }

    @Test
    void twoNegativeToPower_OK() {
        double expected = Math.pow(FIRST_NEGATIVE, SECOND_NEGATIVE);
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE,
                TO_POWER), DELTA);
    }

    @Test
    void firstNegativeAndPositiveToPower_OK() {
        double expected = Math.pow(FIRST_NEGATIVE, SECOND_NEGATIVE);
        assertEquals(expected, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE,
                TO_POWER), DELTA);
    }

    @Test
    void secondNegativeAndPositiveToPower_OK() {
        double expected = Math.pow(FIRST_POSITIVE, SECOND_NEGATIVE);
        assertEquals(expected, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE,
                TO_POWER), DELTA);
    }

    @Test
    void firstZeroToPower_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, SECOND_POSITIVE, TO_POWER), DELTA);
    }

    @Test
    void secondZeroToPower_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(SECOND_POSITIVE, ZERO, TO_POWER));
    }

    @Test
    void twoZeroToPower_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(ZERO, ZERO, TO_POWER));
    }

    @Test
    void notSupportedOperation_NotOK() {
        char illegalOperation = '$';
        assertThrows(NotSupportOperationException.class, () ->
                calculator.calculate(ZERO, ZERO, illegalOperation));
    }
}
