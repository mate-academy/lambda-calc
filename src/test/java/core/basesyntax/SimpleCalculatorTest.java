package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.basesyntax.Operation.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {
    private static Calculator calculator;
    private static final double ZERO = 0;
    private static final double POSITIVE_FIRST = 450.3;
    private static final double POSITIVE_SECOND = 45.9;
    private static final double NEGATIVE_FIRST = -23.5;
    private static final double NEGATIVE_SECOND = -124.75;
    private static final char INVALID_OPERATION = '$';

    @BeforeAll
    static void beforeAll() {
        calculator = new SimpleCalculator();
    }

    @Test
    void divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(POSITIVE_FIRST, ZERO, DIVISION.getOperation()));
    }

    @Test
    void sumOfTwoValues_Ok() {
        double sumOfPositive = POSITIVE_FIRST + POSITIVE_SECOND;
        double sumOfNegative = NEGATIVE_FIRST + NEGATIVE_SECOND;
        double sumOfPositiveAndNegative = POSITIVE_FIRST + NEGATIVE_SECOND;
        assertEquals(sumOfPositive,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, ADDITION.getOperation()));
        assertEquals(sumOfNegative,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, ADDITION.getOperation()));
        assertEquals(sumOfPositiveAndNegative,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, ADDITION.getOperation()));
    }

    @Test
    void subtractingTwoValues_Ok() {
        double subtractionOfPositive = POSITIVE_FIRST - POSITIVE_SECOND;
        assertEquals(subtractionOfPositive,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, SUBTRACTION.getOperation()));
        double subtractionOfNegative = NEGATIVE_FIRST - NEGATIVE_SECOND;
        assertEquals(subtractionOfNegative,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, SUBTRACTION.getOperation()));
        double subtractPositiveFromNegative = POSITIVE_FIRST - NEGATIVE_SECOND;
        assertEquals(subtractPositiveFromNegative,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, SUBTRACTION.getOperation()));
        double subtractNegativeFromPositive = NEGATIVE_FIRST - POSITIVE_SECOND;
        assertEquals(subtractNegativeFromPositive,
                calculator.calculate(NEGATIVE_FIRST, POSITIVE_SECOND, SUBTRACTION.getOperation()));
    }

    @Test
    void divisionOfTwoNumbers_Ok() {
        double divisionOfNegative = NEGATIVE_FIRST / NEGATIVE_SECOND;
        assertEquals(divisionOfNegative,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, DIVISION.getOperation()));
        double divisionPositiveByNegative = POSITIVE_FIRST / NEGATIVE_SECOND;
        assertEquals(divisionPositiveByNegative,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, DIVISION.getOperation()));
        double divisionNegativeByPositive = NEGATIVE_FIRST / POSITIVE_SECOND;
        assertEquals(divisionNegativeByPositive,
                calculator.calculate(NEGATIVE_FIRST, POSITIVE_SECOND, DIVISION.getOperation()));
        double divisionZeroByNumber = ZERO / POSITIVE_SECOND;
        assertEquals(divisionZeroByNumber,
                calculator.calculate(ZERO, POSITIVE_SECOND, DIVISION.getOperation()));
    }

    @Test
    void multiplicationOfTwoNumbers_Ok() {
        double multiplicationOfPositive = POSITIVE_FIRST * POSITIVE_SECOND;
        assertEquals(multiplicationOfPositive,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, MULTIPLICATION.getOperation()));
        double multiplicationOfNegative = NEGATIVE_FIRST * NEGATIVE_SECOND;
        assertEquals(multiplicationOfNegative,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, MULTIPLICATION.getOperation()));
        double multiplicationByZero = POSITIVE_FIRST * ZERO;
        assertEquals(multiplicationByZero,
                calculator.calculate(POSITIVE_FIRST, ZERO, MULTIPLICATION.getOperation()));
    }

    @Test
    void raisingToPower_Ok() {
        double raisingToPositivePower = Math.pow(POSITIVE_FIRST, POSITIVE_SECOND);
        assertEquals(raisingToPositivePower,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, POWER.getOperation()));
        double raisingToNegativePower = Math.pow(POSITIVE_FIRST, NEGATIVE_FIRST);
        assertEquals(raisingToNegativePower,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, POWER.getOperation()));
        double raisingToZeroPower = Math.pow(POSITIVE_FIRST, ZERO);
        assertEquals(raisingToZeroPower,
                calculator.calculate(POSITIVE_FIRST, ZERO, POWER.getOperation()));
        double raisingZeroToPower = Math.pow(ZERO, NEGATIVE_SECOND);
        assertEquals(raisingZeroToPower,
                calculator.calculate(ZERO, NEGATIVE_SECOND, POWER.getOperation()));
    }

    @Test
    void validOperation_NotOk() {
        assertThrows(NoSuchOperationException.class,
                () -> calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, INVALID_OPERATION));
    }
}
