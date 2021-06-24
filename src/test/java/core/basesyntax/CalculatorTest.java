package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POWER = '^';
    private static Calculator calculator;
    private static BigDecimal expected;
    private static double positiveOperand;
    private static double negativeOperand;
    private static double zeroOperand;
    private static double minDoubleValue;
    private static double maxDoubleValue;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
        positiveOperand = 12.65;
        negativeOperand = -132.228;
        zeroOperand = 0;
        minDoubleValue = Double.MIN_VALUE;
        maxDoubleValue = Double.MAX_VALUE;
    }

    @Test
    void calculate_AdditionWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand + positiveOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(negativeOperand + negativeOperand);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand + negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroInDifferentPlaces_Ok() {
        BigDecimal expected1 = BigDecimal.valueOf(zeroOperand + negativeOperand);
        BigDecimal actual1 = calculator.calculate(zeroOperand, negativeOperand, PLUS);
        assertEquals(expected1, actual1);

        BigDecimal expected2 = BigDecimal.valueOf(positiveOperand + zeroOperand);
        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, PLUS);
        assertEquals(expected2, actual2);
    }

    @Test
    void calculate_AdditionForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue + maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand - negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithZeroInDifferentPlaces_Ok() {
        BigDecimal expected1 = BigDecimal.valueOf(zeroOperand - positiveOperand);
        BigDecimal actual1 = calculator.calculate(zeroOperand, positiveOperand, MINUS);
        assertEquals(expected1, actual1);

        BigDecimal expected2 = BigDecimal.valueOf(positiveOperand - zeroOperand);
        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, MINUS);
        assertEquals(expected2, actual2);
    }

    @Test
    void calculate_SubtractionForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue - maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand * positiveOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(negativeOperand * negativeOperand);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand * negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithZeroInDifferentPlaces_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual1 = calculator.calculate(zeroOperand, positiveOperand, MULTIPLY);
        assertEquals(expected, actual1);

        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, MULTIPLY);
        assertEquals(expected, actual2);

    }

    @Test
    void calculate_MultiplicationForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue * maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(1.0);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(1.0);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand / negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithZeroAndPositiveOperand_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(zeroOperand, positiveOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithZeroAndNegativeOperand_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(zeroOperand, negativeOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void checkDivisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(positiveOperand, zeroOperand, DIVIDE);
        }, "Can't divide by zero!");
    }

    @Test
    void calculate_DivisionForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue / maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingNegativeAndPositiveValueToThePositivePower_Ok() {
        expected = BigDecimal.valueOf(Math.pow(positiveOperand, positiveOperand));
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, POWER);
        assertEquals(expected, actual);

        assertThrows(NumberFormatException.class, () -> {
            calculator.calculate(negativeOperand, positiveOperand, '^');
        });
    }

    @Test
    void calculate_RaisingNegativeAndPositiveValueToTheNegativePower_Ok() {
        expected = BigDecimal.valueOf(Math.pow(positiveOperand, negativeOperand));
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, POWER);
        assertEquals(expected, actual);

        assertThrows(NumberFormatException.class, () -> {
            calculator.calculate(negativeOperand, negativeOperand, '^');
        });
    }

    @Test
    void calculate_RaisingNegativeAndPositiveValueToZeroPower_Ok() {
        BigDecimal expected1 = BigDecimal.valueOf(Math.pow(negativeOperand, zeroOperand));
        BigDecimal actual1 = calculator.calculate(negativeOperand, zeroOperand, POWER);
        assertEquals(expected1, actual1);

        BigDecimal expected2 = BigDecimal.valueOf(Math.pow(positiveOperand, zeroOperand));
        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, POWER);
        assertEquals(expected2, actual2);
    }

    @Test
    void calculate_RaisingZeroToPower_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(zeroOperand, positiveOperand, POWER);
        assertEquals(expected, actual);

        assertThrows(ArithmeticException.class, () -> {
            System.out.println(calculator.calculate(zeroOperand, negativeOperand, POWER));
        }, "Zero cannot have a negative power!");
    }

    @Test
    void checkIllegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(positiveOperand, positiveOperand, '~');
        });
    }

    @Test
    void checkOverFlow_Ok() {
        BigDecimal expected1 = BigDecimal.valueOf(maxDoubleValue + positiveOperand);
        BigDecimal actual1 = calculator.calculate(maxDoubleValue, positiveOperand, PLUS);
        assertEquals(expected1, actual1);

        BigDecimal expected2 = BigDecimal.valueOf(minDoubleValue - positiveOperand);
        BigDecimal actual2 = calculator.calculate(minDoubleValue, positiveOperand, MINUS);
        assertEquals(expected2, actual2);
    }
}
