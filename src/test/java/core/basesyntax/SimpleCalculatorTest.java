package core.basesyntax;

import static core.basesyntax.Operation.ADDITION;
import static core.basesyntax.Operation.DIVISION;
import static core.basesyntax.Operation.MULTIPLICATION;
import static core.basesyntax.Operation.POWER;
import static core.basesyntax.Operation.SUBTRACTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        assertEquals(sumOfPositive,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, ADDITION.getOperation()));
        double sumOfNegative = NEGATIVE_FIRST + NEGATIVE_SECOND;
        assertEquals(sumOfNegative,
                calculator.calculate(NEGATIVE_FIRST, NEGATIVE_SECOND, ADDITION.getOperation()));
        double sumOfPositiveAndNegative = POSITIVE_FIRST + NEGATIVE_SECOND;
        assertEquals(sumOfPositiveAndNegative,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_SECOND, ADDITION.getOperation()));
        double sumWithZero = ZERO + POSITIVE_FIRST;
        assertEquals(sumWithZero,
                calculator.calculate(ZERO, POSITIVE_FIRST, ADDITION.getOperation()));
        double sumWithSecondZero = POSITIVE_SECOND + ZERO;
        assertEquals(sumWithSecondZero,
                calculator.calculate(POSITIVE_SECOND, ZERO, ADDITION.getOperation()));
        double sumMaxAndMin = Double.MAX_VALUE + Double.MIN_VALUE;
        assertEquals(sumMaxAndMin,
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION.getOperation()));
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
        double subtractionWithZero = ZERO - POSITIVE_FIRST;
        assertEquals(subtractionWithZero,
                calculator.calculate(ZERO, POSITIVE_FIRST, SUBTRACTION.getOperation()));
        double subtractionWithSecondZero = POSITIVE_SECOND - ZERO;
        assertEquals(subtractionWithSecondZero,
                calculator.calculate(POSITIVE_SECOND, ZERO, SUBTRACTION.getOperation()));
        double subtractionMaxAndMin = Double.MAX_VALUE - Double.MIN_VALUE;
        assertEquals(subtractionMaxAndMin, calculator.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, SUBTRACTION.getOperation()));
    }

    @Test
    void divisionOfTwoNumbers_Ok() {
        double divisionOfPositive = POSITIVE_FIRST / POSITIVE_SECOND;
        assertEquals(divisionOfPositive,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, DIVISION.getOperation()));
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
        double subtractionMaxAndMin = Double.MIN_VALUE / Double.MAX_VALUE;
        assertEquals(subtractionMaxAndMin,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION.getOperation()));
    }

    @Test
    void multiplicationOfTwoNumbers_Ok() {
        double multiplicationOfPositive = POSITIVE_FIRST * POSITIVE_SECOND;
        assertEquals(multiplicationOfPositive, calculator.calculate(POSITIVE_FIRST,
                POSITIVE_SECOND, MULTIPLICATION.getOperation()));
        double multiplicationOfNegative = NEGATIVE_FIRST * NEGATIVE_SECOND;
        assertEquals(multiplicationOfNegative, calculator.calculate(NEGATIVE_FIRST,
                NEGATIVE_SECOND, MULTIPLICATION.getOperation()));
        double multiplicationByZero = POSITIVE_FIRST * ZERO;
        assertEquals(multiplicationByZero,
                calculator.calculate(POSITIVE_FIRST, ZERO, MULTIPLICATION.getOperation()));
        double multiplicationZeroByNumber = ZERO * NEGATIVE_SECOND;
        assertEquals(multiplicationZeroByNumber,
                calculator.calculate(ZERO, NEGATIVE_SECOND, MULTIPLICATION.getOperation()));
        double multiplicationMaxAndMin = Double.MAX_VALUE * Double.MIN_VALUE;
        assertEquals(multiplicationMaxAndMin, calculator.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, MULTIPLICATION.getOperation()));
    }

    @Test
    void raisingToPower_Ok() {
        double raisingPositiveToPositivePower = Math.pow(POSITIVE_FIRST, POSITIVE_SECOND);
        assertEquals(raisingPositiveToPositivePower,
                calculator.calculate(POSITIVE_FIRST, POSITIVE_SECOND, POWER.getOperation()));
        double raisingPositiveToNegativePower = Math.pow(POSITIVE_FIRST, NEGATIVE_FIRST);
        assertEquals(raisingPositiveToNegativePower,
                calculator.calculate(POSITIVE_FIRST, NEGATIVE_FIRST, POWER.getOperation()));
        double raisingNegativeToPositivePower = Math.pow(NEGATIVE_FIRST, POSITIVE_SECOND);
        assertEquals(raisingNegativeToPositivePower,
                calculator.calculate(NEGATIVE_FIRST, POSITIVE_SECOND, POWER.getOperation()));
        double raisingNegativeToNegativePower = Math.pow(NEGATIVE_SECOND, NEGATIVE_FIRST);
        assertEquals(raisingNegativeToNegativePower,
                calculator.calculate(NEGATIVE_SECOND, NEGATIVE_FIRST, POWER.getOperation()));
        double raisingPositiveToZeroPower = Math.pow(POSITIVE_FIRST, ZERO);
        assertEquals(raisingPositiveToZeroPower,
                calculator.calculate(POSITIVE_FIRST, ZERO, POWER.getOperation()));
        double raisingNegativeToZeroPower = Math.pow(POSITIVE_FIRST, ZERO);
        assertEquals(raisingNegativeToZeroPower,
                calculator.calculate(NEGATIVE_SECOND, ZERO, POWER.getOperation()));
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
