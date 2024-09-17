package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final int POSITIVE_NUMBER_1 = 9;
    private static final int POSITIVE_NUMBER_2 = 3;
    private static final int NEGATIVE_NUMBER_1 = -3;
    private static final int NEGATIVE_NUMBER_2 = -9;
    private static final int MAX_INT_VALUE = Integer.MAX_VALUE;
    private static final int MIN_INT_VALUE = Integer.MIN_VALUE;
    private static final int ZERO = 0;
    private static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void checkOperationAdditionWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '+');
        assertEquals(12, actual);
    }

    @Test
    public void checkOperationAdditionWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '+');
        assertEquals(-12, actual);
    }

    @Test
    public void checkOperationAdditionWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '+');
        assertEquals(6, actual);
    }

    @Test
    public void checkOperationAdditionWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_2, '+');
        assertEquals(-6, actual);
    }

    @Test
    public void checkOperationAdditionWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '+');
        assertEquals(-2, actual);
    }

    @Test
    public void checkOperationAdditionWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '+');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationAdditionWhenNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(MIN_INT_VALUE, MAX_INT_VALUE, '+');
        double actual2 = calculator.calculate(MAX_INT_VALUE, MIN_INT_VALUE, '+');
        assertEquals(actual2, actual1);
    }

    @Test
    public void checkOperationAdditionWithPositiveNumberAndZero_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '+');
        assertEquals(9, actual);
    }

    @Test
    public void checkOperationAdditionWithNegativeNumberAndZero_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, ZERO, '+');
        assertEquals(-9, actual);
    }

    @Test
    public void checkOperationSubtractionWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '-');
        assertEquals(6, actual);
    }

    @Test
    public void checkOperationSubtractionWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '-');
        assertEquals(6, actual);
    }

    @Test
    public void checkOperationSubtractionWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '-');
        assertEquals(-12, actual);
    }

    @Test
    public void checkOperationSubtractionWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_2, '-');
        assertEquals(12, actual);
    }

    @Test
    public void checkOperationSubtractionWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationSubtractionWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationSubtractionWhenNumbersChangePlaces_NotEquals() {
        double actual1 = calculator.calculate(MIN_INT_VALUE, MAX_INT_VALUE, '-');
        double actual2 = calculator.calculate(MAX_INT_VALUE, MIN_INT_VALUE, '-');
        assertNotEquals(actual2, actual1);
    }

    @Test
    public void checkOperationSubtractionWithPositiveNumberAndZero_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '-');
        assertEquals(9, actual);
    }

    @Test
    public void checkOperationSubtractionWithNegativeNumberAndZero_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, ZERO, '-');
        assertEquals(-9, actual);
    }

    @Test
    public void checkOperationDivisionWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '/');
        assertEquals(3, actual);
    }

    @Test
    public void checkOperationDivisionWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '/');
        assertEquals(0.33, actual);
    }

    @Test
    public void checkOperationDivisionWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_1, '/');
        assertEquals(-1, actual);
    }

    @Test
    public void checkOperationDivisionWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_1, '/');
        assertEquals(-1, actual);
    }

    @Test
    public void checkOperationDivisionWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    public void checkOperationDivisionWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    public void checkOperationDivisionWhenDifferentNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_1, '/');
        double actual2 = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '/');
        assertNotEquals(actual2, actual1);
    }

    @Test
    public void checkOperationDivisionWhenSameOrAbsoluteValueNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_2, '/');
        double actual2 = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_1, '/');
        assertEquals(actual2, actual1);
    }

    @Test
    public void checkOperationDivisionNumberOnZero_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER_1, ZERO, '/');
        });
    }

    @Test
    public void checkOperationDivisionZeroOnNumber_Ok() {
        double actual = calculator.calculate(ZERO, NEGATIVE_NUMBER_2, '/');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationMultiplicationWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '*');
        assertEquals(27, actual);
    }

    @Test
    public void checkOperationMultiplicationWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '*');
        assertEquals(27, actual);
    }

    @Test
    public void checkOperationMultiplicationWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_1, '*');
        assertEquals(-81, actual);
    }

    @Test
    public void checkOperationMultiplicationWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_1, '*');
        assertEquals(-9, actual);
    }

    @Test
    public void checkOperationMultiplicationWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '*');
        assertEquals(1, actual);
    }

    @Test
    public void checkOperationMultiplicationWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '*');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationMultiplicationWhenNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_1, '*');
        double actual2 = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '*');
        assertEquals(actual2, actual1);
    }

    @Test
    public void checkOperationMultiplicationNumberOnZero_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '*');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationMultiplicationZeroOnNumber_Ok() {
        double actual = calculator.calculate(ZERO, NEGATIVE_NUMBER_2, '*');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationRaisingPositiveValueToPositivePower_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '^');
        assertEquals(729, actual);
    }

    @Test
    public void checkOperationRaisingNegativeValueToPositivePower_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_2, '^');
        });
    }

    @Test
    public void checkOperationRaisingPositiveValueToNegativePower_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_1, '^');
        assertEquals(0.001, actual);
    }

    @Test
    public void checkOperationRaisingNegativeValueToNegativePower_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(NEGATIVE_NUMBER_2, NEGATIVE_NUMBER_1, '^');
        });
    }

    @Test
    public void checkOperationRaisingPositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '^');
        assertEquals(1, actual);
    }

    @Test
    public void checkOperationRaisingNegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, ZERO, '^');
        assertEquals(-1, actual);
    }

    @Test
    public void checkOperationRaisingZeroToPositivePower_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER_2, '^');
        assertEquals(0, actual);
    }

    @Test
    public void checkOperationRaisingZeroToZeroPower_Ok() {
        double actual = calculator.calculate(ZERO, ZERO, '^');
        assertEquals(1, actual);
    }

    @Test
    public void checkOperation_NotOk() {
        assertThrows(NoSuchElementException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '!');
        });
        assertThrows(NoSuchElementException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '$');
        });
        assertThrows(NoSuchElementException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '=');
        });
    }

    @Test
    public void checkOnTrueSameOperationWithSameNumbers_Ok() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '+');
        double actual2 = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '+');
        assertTrue(actual1 == actual2);
        double actual3 = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '*');
        double actual4 = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '*');
        assertTrue(actual3 == actual4);
    }

    @Test
    public void checkOnFalse_NotOk() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '*');
        double actual2 = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '+');
        assertFalse(actual1 == actual2);
        double actual3 = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '-');
        double actual4 = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '/');
        assertFalse(actual3 == actual4);
    }
}
