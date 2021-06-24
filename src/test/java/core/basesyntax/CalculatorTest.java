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
    void calculateAdditionWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand + positiveOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateAdditionWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(negativeOperand + negativeOperand);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateAdditionWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand + negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateAdditionWithZeroInDifferentPlaces_Ok() {
        BigDecimal expected1 = BigDecimal.valueOf(zeroOperand + negativeOperand);
        BigDecimal actual1 = calculator.calculate(zeroOperand, negativeOperand, PLUS);
        assertEquals(expected1, actual1);

        BigDecimal expected2 = BigDecimal.valueOf(positiveOperand + zeroOperand);
        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, PLUS);
        assertEquals(expected2, actual2);
    }

    @Test
    void calculateAdditionForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue + maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand - negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithZeroInDifferentPlaces_Ok() {
        BigDecimal expected1 = BigDecimal.valueOf(zeroOperand - positiveOperand);
        BigDecimal actual1 = calculator.calculate(zeroOperand, positiveOperand, MINUS);
        assertEquals(expected1, actual1);

        BigDecimal expected2 = BigDecimal.valueOf(positiveOperand - zeroOperand);
        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, MINUS);
        assertEquals(expected2, actual2);
    }

    @Test
    void calculateSubtractionForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue - maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand * positiveOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(negativeOperand * negativeOperand);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand * negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMultiplicationWithZeroInDifferentPlaces_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual1 = calculator.calculate(zeroOperand, positiveOperand, MULTIPLY);
        assertEquals(expected, actual1);

        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, MULTIPLY);
        assertEquals(expected, actual2);

    }

    @Test
    void calculateMultiplicationForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue * maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithTwoPositiveOperands_Ok() {
        expected = BigDecimal.valueOf(1.0);
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithTwoNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(1.0);
        BigDecimal actual = calculator.calculate(negativeOperand, negativeOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithPositiveAndNegativeOperands_Ok() {
        expected = BigDecimal.valueOf(positiveOperand / negativeOperand);
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithZeroAndPositiveOperand_Ok() {
        expected = BigDecimal.valueOf(zeroOperand);
        BigDecimal actual = calculator.calculate(zeroOperand, positiveOperand, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithZeroAndNegativeOperand_Ok() {
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
    void calculateDivisionForMinAndMaxDoubleValues_Ok() {
        expected = BigDecimal.valueOf(minDoubleValue / maxDoubleValue);
        BigDecimal actual = calculator.calculate(minDoubleValue, maxDoubleValue, DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingNegativeAndPositiveValueToThePositivePower() {
        expected = BigDecimal.valueOf(Math.pow(positiveOperand, positiveOperand));
        BigDecimal actual = calculator.calculate(positiveOperand, positiveOperand, POWER);
        assertEquals(expected, actual);

        assertThrows(NumberFormatException.class, () -> {
            calculator.calculate(negativeOperand, positiveOperand, '^');
        });
    }

    @Test
    void calculateRaisingNegativeAndPositiveValueToTheNegativePower() {
        expected = BigDecimal.valueOf(Math.pow(positiveOperand, negativeOperand));
        BigDecimal actual = calculator.calculate(positiveOperand, negativeOperand, POWER);
        assertEquals(expected, actual);

        assertThrows(NumberFormatException.class, () -> {
            calculator.calculate(negativeOperand, negativeOperand, '^');
        });
    }

    @Test
    void calculateRaisingNegativeAndPositiveValueToZeroPower() {
        BigDecimal expected1 = BigDecimal.valueOf(Math.pow(negativeOperand, zeroOperand));
        BigDecimal actual1 = calculator.calculate(negativeOperand, zeroOperand, POWER);
        assertEquals(expected1, actual1);

        BigDecimal expected2 = BigDecimal.valueOf(Math.pow(positiveOperand, zeroOperand));
        BigDecimal actual2 = calculator.calculate(positiveOperand, zeroOperand, POWER);
        assertEquals(expected2, actual2);
    }

    @Test
    void calculateRaisingZeroToPower_Ok() {
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
            calculator.checkOperationValid('~');
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
