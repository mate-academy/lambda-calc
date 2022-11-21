package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_AdditionWithTwoPositiveOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(123.5 + 321.5);
        BigDecimal actual = calculator.calculate(123.5, 321.5, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithTwoNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(-123.5 + -321.5);
        BigDecimal actual = calculator.calculate(-123.5, -321.5, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithPositiveAndNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(123.5 + -321.5);
        BigDecimal actual = calculator.calculate(123.5, -321.5, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionWithZeroInDifferentPlaces_Ok() {
        BigDecimal expected = BigDecimal.valueOf(0 + -321.5);
        BigDecimal actual = calculator.calculate(0, -321.5, PLUS);
        assertEquals(expected, actual);

        expected = BigDecimal.valueOf(123.5 + 0);
        actual = calculator.calculate(123.5, 0, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_AdditionForMinAndMaxDoubleValues_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Double.MIN_VALUE + Double.MAX_VALUE);
        BigDecimal actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoPositiveOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(123.5 - 124.5);
        BigDecimal actual = calculator.calculate(123.5, 124.5, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithTwoNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(-123.5 - -122.3);
        BigDecimal actual = calculator.calculate(-123.5, -122.3, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithPositiveAndNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(123.5 - -123.5);
        BigDecimal actual = calculator.calculate(123.5, -123.5, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionWithZeroInDifferentPlaces_Ok() {
        BigDecimal expected = BigDecimal.valueOf(0 - 123.5);
        BigDecimal actual = calculator.calculate(0, 123.5, MINUS);
        assertEquals(expected, actual);

        expected = BigDecimal.valueOf(123.5 - 0);
        actual = calculator.calculate(123.5, 0, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_SubtractionForMinAndMaxDoubleValues_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Double.MIN_VALUE - Double.MAX_VALUE);
        BigDecimal actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoPositiveOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(123.5 * 123.5);
        BigDecimal actual = calculator.calculate(123.5, 123.5, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithTwoNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(-123.5 * -123.5);
        BigDecimal actual = calculator.calculate(-123.5, -123.5, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithPositiveAndNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(123.5 * -123.5);
        BigDecimal actual = calculator.calculate(123.5, -123.5, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_MultiplicationWithZeroInDifferentPlaces_Ok() {
        BigDecimal expected = BigDecimal.valueOf(0 * 123.5);
        BigDecimal actual = calculator.calculate(0, 123.5, MULTIPLICATION);
        assertEquals(expected, actual);

        actual = calculator.calculate(123.5, 0, MULTIPLICATION);
        assertEquals(expected, actual);

    }

    @Test
    void calculate_MultiplicationForMinAndMaxDoubleValues_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Double.MIN_VALUE * Double.MAX_VALUE);
        BigDecimal actual = calculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithTwoPositiveOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(1.0);
        BigDecimal actual = calculator.calculate(123.5, 123.5, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithTwoNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(1.0);
        BigDecimal actual = calculator.calculate(-123.5, -123.5, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithPositiveAndNegativeOperands_Ok() {
        BigDecimal expected = BigDecimal.valueOf(123.5 / -123.5);
        BigDecimal actual = calculator.calculate(123.5, -123.5, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithZeroAndPositiveOperand_Ok() {
        BigDecimal expected = BigDecimal.valueOf(0 / 123.5);
        BigDecimal actual = calculator.calculate(0, 123.5, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_DivisionWithZeroAndNegativeOperand_Ok() {
        BigDecimal expected = BigDecimal.valueOf(0.0);
        BigDecimal actual = calculator.calculate(0, -123.5, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void checkDivisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(123.5, 0, DIVISION);
        }, "Can't divide by zero!");
    }

    @Test
    void calculate_DivisionForMinAndMaxDoubleValues_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Double.MIN_VALUE / Double.MAX_VALUE);
        BigDecimal actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingNegativeAndPositiveValueToThePositivePower_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Math.pow(123.5, 123.5));
        BigDecimal actual = calculator.calculate(123.5, 123.5, POWER);
        assertEquals(expected, actual);

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-123.5, 123.5, POWER);
        });
    }

    @Test
    void calculate_RaisingNegativeAndPositiveValueToTheNegativePower_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Math.pow(123.5, -123.5));
        BigDecimal actual = calculator.calculate(123.5, -123.5, POWER);
        assertEquals(expected, actual);

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-123.5, -123.5, POWER);
        });
    }

    @Test
    void calculate_RaisingNegativeAndPositiveValueToZeroPower_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Math.pow(-123.5, 0));
        BigDecimal actual = calculator.calculate(-123.5, 0, POWER);
        assertEquals(expected, actual);

        expected = BigDecimal.valueOf(Math.pow(123.5, 0));
        actual = calculator.calculate(123.5, 0, POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_RaisingZeroToPower_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Math.pow(0, 123.5));
        BigDecimal actual = calculator.calculate(0, 123.5, POWER);
        assertEquals(expected, actual);

        assertThrows(ArithmeticException.class, () -> {
            System.out.println(calculator.calculate(0, -123.5, POWER));
        }, "Zero cannot have a negative power!");
    }

    @Test
    void calculate_checkIllegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(123.5, 123.5, '~');
        });
    }

    @Test
    void calculate_checkOverFlow_Ok() {
        BigDecimal expected = BigDecimal.valueOf(Double.MAX_VALUE + 123.5);
        BigDecimal actual = calculator.calculate(Double.MAX_VALUE, 123.5, PLUS);
        assertEquals(expected, actual);

        expected = BigDecimal.valueOf(Double.MIN_VALUE - 123.5);
        actual = calculator.calculate(Double.MIN_VALUE, 123.5, MINUS);
        assertEquals(expected, actual);
    }
}
