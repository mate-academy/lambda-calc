package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LambdaCalculatorTest {
    private static final double DELTA = 0.0001;
    private static final double FIRST_NUMBER = 153.1486;
    private static final double SECOND_NUMBER = 284.4892;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static LambdaCalculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalculator();
    }

    @Test
    void calculate_additionWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, ADDITION);
        double expected = FIRST_NUMBER + SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, -SECOND_NUMBER, ADDITION);
        double expected = -FIRST_NUMBER + -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, -SECOND_NUMBER, ADDITION);
        double expected = FIRST_NUMBER + -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, SECOND_NUMBER, ADDITION);
        double expected = -FIRST_NUMBER + SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, ADDITION);
        double expected = 0 + SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, -SECOND_NUMBER, ADDITION);
        double expected = 0 + -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeroAndZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, ADDITION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithPositiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, ADDITION);
        double expected = FIRST_NUMBER + 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithNegativeAndZeroOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, 0, ADDITION);
        double expected = -FIRST_NUMBER + 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADDITION);
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, SUBTRACTION);
        double expected = FIRST_NUMBER - SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, -SECOND_NUMBER, SUBTRACTION);
        double expected = -FIRST_NUMBER - -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, -SECOND_NUMBER, SUBTRACTION);
        double expected = FIRST_NUMBER - -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, SECOND_NUMBER, SUBTRACTION);
        double expected = -FIRST_NUMBER - SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, SUBTRACTION);
        double expected = 0 - SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, -SECOND_NUMBER, SUBTRACTION);
        double expected = 0 - -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithZeroAndZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithPositiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, SUBTRACTION);
        double expected = FIRST_NUMBER - 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionWithNegativeAndZeroOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, 0, SUBTRACTION);
        double expected = -FIRST_NUMBER - 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, MULTIPLICATION);
        double expected = FIRST_NUMBER * SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, -SECOND_NUMBER, MULTIPLICATION);
        double expected = -FIRST_NUMBER * -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, -SECOND_NUMBER, MULTIPLICATION);
        double expected = FIRST_NUMBER * -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, SECOND_NUMBER, MULTIPLICATION);
        double expected = -FIRST_NUMBER * SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, MULTIPLICATION);
        double expected = 0 * SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, -SECOND_NUMBER, MULTIPLICATION);
        double expected = 0 * -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroAndZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, MULTIPLICATION);
        double expected = FIRST_NUMBER * 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithNegativeAndZeroOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, 0, MULTIPLICATION);
        double expected = -FIRST_NUMBER * 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        double expected = Double.MIN_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, DIVISION);
        double expected = FIRST_NUMBER / SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, -SECOND_NUMBER, DIVISION);
        double expected = -FIRST_NUMBER / -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, -SECOND_NUMBER, DIVISION);
        double expected = FIRST_NUMBER / -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, SECOND_NUMBER, DIVISION);
        double expected = -FIRST_NUMBER / SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, DIVISION);
        double expected = 0 / SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, -SECOND_NUMBER, DIVISION);
        double expected = 0 / -SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithZeroAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(0, 0, DIVISION));
    }

    @Test
    void calculate_divisionWithPositiveAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(FIRST_NUMBER, 0, DIVISION));
    }

    @Test
    void calculate_divisionWithNegativeAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(-FIRST_NUMBER, 0, DIVISION));
    }

    @Test
    void calculate_divisionForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = Double.MIN_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToThePositivePower_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, POWER);
        double expected = Math.pow(FIRST_NUMBER, SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, -SECOND_NUMBER, POWER);
        double expected = Math.pow(FIRST_NUMBER, (- SECOND_NUMBER));
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToTheZeroPower_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, POWER);
        double expected = Math.pow(FIRST_NUMBER, 0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToThePositivePower_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, SECOND_NUMBER, POWER);
        double expected = Math.pow(-FIRST_NUMBER, SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, -SECOND_NUMBER, POWER);
        double expected = Math.pow(-FIRST_NUMBER, -SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNegativeValueToTheZeroPower_Ok() {
        double actual = calculator.calculate(-FIRST_NUMBER, 0, POWER);
        double expected = Math.pow(-FIRST_NUMBER, 0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroValueToThePositivePower_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, POWER);
        double expected = Math.pow(0, SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroValueToTheNegativePower_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(0, -SECOND_NUMBER, POWER));
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        char operation = '$';
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, operation));
    }
}
