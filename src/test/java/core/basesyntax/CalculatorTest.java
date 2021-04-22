package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import core.basesyntax.exception.DivisionByZeroException;
import core.basesyntax.exception.NotSupportOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char TO_POWER = '^';
    private static final double DELTA = 0.0001;
    private Calculator calculator;
    private double firstPositive;
    private double secondPositive;
    private double firstNegative;
    private double secondNegative;
    private double zero;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        firstPositive = 16.234;
        firstNegative = -16.234;
        secondPositive = 15.234;
        secondNegative = -15.234;
        zero = 0.0;
    }

    @Test
    void twoPositiveAddition_OK() {
        double expected = 31.468;
        assertEquals(expected, calculator.calculate(firstPositive, secondPositive,
                ADDITION), DELTA);
    }

    @Test
    void twoNegativeAddition_OK() {
        double expected = -31.468;
        assertEquals(expected, calculator.calculate(firstNegative, secondNegative,
                ADDITION), DELTA);
    }

    @Test
        void firstNegativeAndPositiveAddition_OK() {
        double expected = -1.0;
        assertEquals(expected, calculator.calculate(firstNegative, secondPositive,
                ADDITION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveAddition_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(firstPositive, secondNegative,
                ADDITION), DELTA);
    }

    @Test
    void firstZeroAddition_OK() {
        double expected = 15.234;
        assertEquals(expected, calculator.calculate(zero, secondPositive,
                ADDITION), DELTA);
    }

    @Test
    void secondZeroAddition_OK() {
        double expected = 16.234;
        assertEquals(expected, calculator.calculate(firstPositive, zero, ADDITION), DELTA);
    }

    @Test
    void twoZeroAddition_OK() {
        assertEquals(zero, calculator.calculate(zero, zero, ADDITION));
    }

    @Test
    void twoPositiveSubtraction_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(firstPositive, secondPositive,
                SUBTRACTION), DELTA);
    }

    @Test
    void twoNegativeSubtraction_OK() {
        double expected = -1.0;
        assertEquals(expected, calculator.calculate(firstNegative, secondNegative,
                SUBTRACTION), DELTA);
    }

    @Test
    void firstNegativeAndPositiveSubtraction_OK() {
        double expected = -31.468;
        assertEquals(expected, calculator.calculate(firstNegative, secondPositive,
                SUBTRACTION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveSubtraction_OK() {
        double expected = 31.468;
        assertEquals(expected, calculator.calculate(firstPositive, secondNegative,
                SUBTRACTION), DELTA);
    }

    @Test
    void firstZeroSubtraction_OK() {
        double expected = -15.234;
        assertEquals(expected, calculator.calculate(zero, secondPositive,
                SUBTRACTION), DELTA);
    }

    @Test
    void secondZeroSubtraction_OK() {
        double expected = 16.234;
        assertEquals(expected, calculator.calculate(firstPositive, zero,
                SUBTRACTION), DELTA);
    }

    @Test
    void twoZeroSubtraction_OK() {
        assertEquals(zero, calculator.calculate(zero, zero,
                SUBTRACTION));
    }

    @Test
    void twoPositiveDivision_OK() {
        double expected = 1.0656;
        assertEquals(expected, calculator.calculate(firstPositive, secondPositive,
                DIVISION), DELTA);
    }

    @Test
    void twoNegativeDivision_OK() {
        double expected = 1.0656;
        assertEquals(expected, calculator.calculate(firstNegative, secondNegative,
                DIVISION), DELTA);
    }

    @Test
    void firstNegativeAndPositiveDivision_OK() {
        double expected = -1.0656;
        assertEquals(expected, calculator.calculate(firstNegative, secondPositive,
                DIVISION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveDivision_OK() {
        double expected = -1.0656;
        assertEquals(expected, calculator.calculate(firstPositive, secondNegative,
                DIVISION), DELTA);
    }

    @Test
    void firstZeroDivision_OK() {
        assertEquals(zero, calculator.calculate(zero, secondPositive, DIVISION), DELTA);
    }

    @Test
    void secondZeroDivision_NotOK() {
        assertThrows(DivisionByZeroException.class, () ->
                calculator.calculate(secondPositive, zero, DIVISION));
    }

    @Test
    void twoZeroDivision_NotOK() {
        assertThrows(DivisionByZeroException.class, () ->
                calculator.calculate(zero, zero, DIVISION));
    }

    @Test
    void twoPositiveMultiplication_OK() {
        double expected = 247.3087;
        assertEquals(expected, calculator.calculate(firstPositive, secondPositive,
                MULTIPLICATION), DELTA);
    }

    @Test
    void twoNegativeMultiplication_OK() {
        double expected = 247.3087;
        assertEquals(expected, calculator.calculate(firstNegative, secondNegative,
                MULTIPLICATION), DELTA);
    }

    @Test
    void firstNegativeAndPositiveMultiplication_OK() {
        double expected = -247.3087;
        assertEquals(expected, calculator.calculate(firstNegative, secondPositive,
                MULTIPLICATION), DELTA);
    }

    @Test
    void secondNegativeAndPositiveMultiplication_OK() {
        double expected = -247.3087;
        assertEquals(expected, calculator.calculate(firstPositive, secondNegative,
                MULTIPLICATION), DELTA);
    }

    @Test
    void firstZeroMultiplication_OK() {
        assertEquals(zero, calculator.calculate(zero, secondPositive, MULTIPLICATION), DELTA);
    }

    @Test
    void secondZeroMultiplication_OK() {
        assertEquals(zero, calculator.calculate(secondPositive, zero, MULTIPLICATION), DELTA);
    }

    @Test
    void twoZeroMultiplication_OK() {
        assertEquals(zero, calculator.calculate(zero, zero, MULTIPLICATION), DELTA);
    }

    @Test
    void twoPositiveToPower_OK() {
        double expected = Math.pow(firstPositive, secondPositive);
        assertEquals(expected, calculator.calculate(firstPositive, secondPositive, TO_POWER));
    }

    @Test
    void twoNegativeToPower_OK() {
        double expected = Math.pow(firstNegative, secondNegative);
        assertEquals(expected, calculator.calculate(firstNegative, secondNegative,
                TO_POWER), DELTA);
    }

    @Test
    void firstNegativeAndPositiveToPower_OK() {
        double expected = Math.pow(firstNegative, secondNegative);
        assertEquals(expected, calculator.calculate(firstNegative, secondPositive,
                TO_POWER), DELTA);
    }

    @Test
    void secondNegativeAndPositiveToPower_OK() {
        double expected = Math.pow(firstPositive, secondNegative);
        assertEquals(expected, calculator.calculate(firstPositive, secondNegative,
                TO_POWER), DELTA);
    }

    @Test
    void firstZeroToPower_OK() {
        assertEquals(zero, calculator.calculate(zero, secondPositive, TO_POWER), DELTA);
    }

    @Test
    void secondZeroToPower_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(secondPositive, zero, TO_POWER));
    }

    @Test
    void twoZeroToPower_OK() {
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(zero, zero, TO_POWER));
    }

    @Test
    void notSupportedOperation_NotOK() {
        char operation = '$';
        try {
            calculator.calculate(0.0, 0.0, operation);
        } catch (NotSupportOperationException e) {
            return;
        }
        fail("This operation '" + operation + "' not supports!");
    }
}
