package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final int POSITIVE_NUMBER_1 = 9;
    private static final int POSITIVE_NUMBER_2 = 3;
    private static final int NEGATIVE_NUMBER_1 = -3;
    private static final int NEGATIVE_NUMBER_2 = -9;
    private static final int MAX_INT_VALUE = Integer.MAX_VALUE;
    private static final int MIN_INT_VALUE = Integer.MIN_VALUE;
    private static final int ZERO = 0;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void checkOperationAdditionWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '+');
        assertEquals(12, actual);
    }

    @Test
    void checkOperationAdditionWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '+');
        assertEquals(-12, actual);
    }

    @Test
    void checkOperationAdditionWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '+');
        assertEquals(6, actual);
    }

    @Test
    void checkOperationAdditionWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_2, '+');
        assertEquals(-6, actual);
    }

    @Test
    void checkOperationAdditionWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '+');
        assertEquals(-2, actual);
    }

    @Test
    void checkOperationAdditionWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '+');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationAdditionWhenNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(MIN_INT_VALUE, MAX_INT_VALUE, '+');
        double actual2 = calculator.calculate(MAX_INT_VALUE, MIN_INT_VALUE, '+');
        assertEquals(actual2, actual1);
    }

    @Test
    void checkOperationAdditionWithPositiveNumberAndZero_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '+');
        assertEquals(9, actual);
    }

    @Test
    void checkOperationAdditionWithNegativeNumberAndZero_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, ZERO, '+');
        assertEquals(-9, actual);
    }

    @Test
    void checkOperationSubtractionWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '-');
        assertEquals(6, actual);
    }

    @Test
    void checkOperationSubtractionWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '-');
        assertEquals(6, actual);
    }

    @Test
    void checkOperationSubtractionWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '-');
        assertEquals(-12, actual);
    }

    @Test
    void checkOperationSubtractionWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_2, '-');
        assertEquals(12, actual);
    }

    @Test
    void checkOperationSubtractionWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationSubtractionWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '-');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationSubtractionWhenNumbersChangePlaces_NotEquals() {
        double actual1 = calculator.calculate(MIN_INT_VALUE, MAX_INT_VALUE, '-');
        double actual2 = calculator.calculate(MAX_INT_VALUE, MIN_INT_VALUE, '-');
        assertNotEquals(actual2, actual1);
    }

    @Test
    void checkOperationSubtractionWithPositiveNumberAndZero_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '-');
        assertEquals(9, actual);
    }

    @Test
    void checkOperationSubtractionWithNegativeNumberAndZero_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, ZERO, '-');
        assertEquals(-9, actual);
    }

    @Test
    void checkOperationDivisionWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '/');
        assertEquals(3, actual);
    }

    @Test
    void checkOperationDivisionWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '/');
        assertEquals(0.33, actual);
    }

    @Test
    void checkOperationDivisionWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_1, '/');
        assertEquals(-1, actual);
    }

    @Test
    void checkOperationDivisionWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_1, '/');
        assertEquals(-1, actual);
    }

    @Test
    void checkOperationDivisionWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    void checkOperationDivisionWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '/');
        assertEquals(1, actual);
    }

    @Test
    void checkOperationDivisionWhenDifferentNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_1, '/');
        double actual2 = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '/');
        assertNotEquals(actual2, actual1);
    }

    @Test
    void checkOperationDivisionWhenSameOrAbsoluteValueNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_2, '/');
        double actual2 = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_1, '/');
        assertEquals(actual2, actual1);
    }

    @Test
    void checkOperationDivisionNumberOnZero_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(POSITIVE_NUMBER_1, ZERO, '/');
        });
    }

    @Test
    void checkOperationDivisionZeroOnNumber_Ok() {
        double actual = calculator.calculate(ZERO, NEGATIVE_NUMBER_2, '/');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationMultiplicationWithTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '*');
        assertEquals(27, actual);
    }

    @Test
    void checkOperationMultiplicationWithTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, '*');
        assertEquals(27, actual);
    }

    @Test
    void checkOperationMultiplicationWithFirstNegativeAndSecondPositiveNumber_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_1, '*');
        assertEquals(-81, actual);
    }

    @Test
    void checkOperationMultiplicationWithFirstPositiveAndSecondNegativeNumber_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_2, NEGATIVE_NUMBER_1, '*');
        assertEquals(-9, actual);
    }

    @Test
    void checkOperationMultiplicationWithTwoMaxInt_Ok() {
        double actual = calculator.calculate(MAX_INT_VALUE, MAX_INT_VALUE, '*');
        assertEquals(1, actual);
    }

    @Test
    void checkOperationMultiplicationWithTwoMinInt_Ok() {
        double actual = calculator.calculate(MIN_INT_VALUE, MIN_INT_VALUE, '*');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationMultiplicationWhenNumbersChangePlaces_Ok() {
        double actual1 = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_1, '*');
        double actual2 = calculator.calculate(NEGATIVE_NUMBER_1, POSITIVE_NUMBER_1, '*');
        assertEquals(actual2, actual1);
    }

    @Test
    void checkOperationMultiplicationNumberOnZero_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '*');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationMultiplicationZeroOnNumber_Ok() {
        double actual = calculator.calculate(ZERO, NEGATIVE_NUMBER_2, '*');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationRaisingPositiveValueToPositivePower_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, POSITIVE_NUMBER_2, '^');
        assertEquals(729, actual);
    }

    @Test
    void checkOperationRaisingNegativeValueToPositivePower_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, POSITIVE_NUMBER_2, '^');
        assertEquals(-729, actual);
    }

    @Test
    void checkOperationRaisingPositiveValueToNegativePower_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, NEGATIVE_NUMBER_1, '^');
        assertEquals(0.001, actual);
    }

    @Test
    void checkOperationRaisingNegativeValueToNegativePower_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, NEGATIVE_NUMBER_1, '^');
        assertEquals(-0.001, actual);
    }

    @Test
    void checkOperationRaisingPositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(POSITIVE_NUMBER_1, ZERO, '^');
        assertEquals(1, actual);
    }

    @Test
    void checkOperationRaisingNegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(NEGATIVE_NUMBER_2, ZERO, '^');
        assertEquals(-1, actual);
    }

    @Test
    void checkOperationRaisingZeroToPositivePower_Ok() {
        double actual = calculator.calculate(ZERO, POSITIVE_NUMBER_2, '^');
        assertEquals(0, actual);
    }

    @Test
    void checkOperationRaisingZeroToZeroPower_Ok() {
        double actual = calculator.calculate(ZERO, ZERO, '^');
        assertEquals(1, actual);
    }

    @Test
    void checkOperation_NotOk() {
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
}
