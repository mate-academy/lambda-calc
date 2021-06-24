package core.basesyntax;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LambdaCalcTest {
    private static final double DELTA = 0.0001;
    private static final double FIRST_NUMBER = 153.1486;
    private static final double SECOND_NUMBER = 153.1486;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static LambdaCalc calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new LambdaCalc();
    }

    @Test
    void additionWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, ADDITION);
        double expected = FIRST_NUMBER + SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), (- SECOND_NUMBER), ADDITION);
        double expected = (- FIRST_NUMBER) + (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, (- SECOND_NUMBER), ADDITION);
        double expected = FIRST_NUMBER + ( - SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), SECOND_NUMBER, ADDITION);
        double expected = (- FIRST_NUMBER) + SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, ADDITION);
        double expected = 0 + SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, (- SECOND_NUMBER), ADDITION);
        double expected = 0 + (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroAndZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, ADDITION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, ADDITION);
        double expected = FIRST_NUMBER + 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithNegativeAndZeroOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), 0, ADDITION);
        double expected = (- FIRST_NUMBER) + 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADDITION);
        double expected = Double.MIN_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, SUBTRACTION);
        double expected = FIRST_NUMBER - SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), (- SECOND_NUMBER), SUBTRACTION);
        double expected = (- FIRST_NUMBER) - (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, (- SECOND_NUMBER), SUBTRACTION);
        double expected = FIRST_NUMBER - (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), SECOND_NUMBER, SUBTRACTION);
        double expected = (- FIRST_NUMBER) - SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, SUBTRACTION);
        double expected = 0 - SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, (- SECOND_NUMBER), SUBTRACTION);
        double expected = 0 - (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroAndZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, SUBTRACTION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, SUBTRACTION);
        double expected = FIRST_NUMBER - 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithNegativeAndZeroOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), 0, SUBTRACTION);
        double expected = (- FIRST_NUMBER) - 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        double expected = Double.MIN_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, MULTIPLICATION);
        double expected = FIRST_NUMBER * SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), (- SECOND_NUMBER), MULTIPLICATION);
        double expected = (- FIRST_NUMBER) * (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, (- SECOND_NUMBER), MULTIPLICATION);
        double expected = FIRST_NUMBER * (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), SECOND_NUMBER, MULTIPLICATION);
        double expected = (- FIRST_NUMBER) * SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, MULTIPLICATION);
        double expected = 0 * SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, (- SECOND_NUMBER), MULTIPLICATION);
        double expected = 0 * (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroAndZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, MULTIPLICATION);
        double expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndZeroOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, MULTIPLICATION);
        double expected = FIRST_NUMBER * 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithNegativeAndZeroOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), 0, MULTIPLICATION);
        double expected = (- FIRST_NUMBER) * 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION);
        double expected = Double.MIN_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoOPositiveOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, DIVISION);
        double expected = FIRST_NUMBER / SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoONegativeOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), (- SECOND_NUMBER), DIVISION);
        double expected = (- FIRST_NUMBER) / (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, (- SECOND_NUMBER), DIVISION);
        double expected = FIRST_NUMBER / (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithNegativeAndPositiveOperands_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), SECOND_NUMBER, DIVISION);
        double expected = (- FIRST_NUMBER) / SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAndPositiveOperands_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, DIVISION);
        double expected = 0 / SECOND_NUMBER;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAndNegativeOperands_Ok() {
        double actual = calculator.calculate(0, (- SECOND_NUMBER), DIVISION);
        double expected = 0 / (- SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, DIVISION));
    }

    @Test
    void divisionWithPositiveAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(FIRST_NUMBER, 0, DIVISION));
    }

    @Test
    void divisionWithNegativeAndZeroOperands_NotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate((- FIRST_NUMBER), 0, DIVISION));
    }

    @Test
    void divisionForMinAndMaxDoubleValues_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION);
        double expected = Double.MIN_VALUE / Double.MAX_VALUE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, POWER);
        double expected = Math.pow(FIRST_NUMBER, SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, (- SECOND_NUMBER), POWER);
        double expected = Math.pow(FIRST_NUMBER, (- SECOND_NUMBER));
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheZeroPower_Ok() {
        double actual = calculator.calculate(FIRST_NUMBER, 0, POWER);
        double expected = Math.pow(FIRST_NUMBER, 0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), SECOND_NUMBER, POWER);
        double expected = Math.pow((- FIRST_NUMBER), SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), (- SECOND_NUMBER), POWER);
        double expected = Math.pow((- FIRST_NUMBER), (- SECOND_NUMBER));
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheZeroPower_Ok() {
        double actual = calculator.calculate((- FIRST_NUMBER), 0, POWER);
        double expected = Math.pow((- FIRST_NUMBER), 0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroValueToThePositivePower_Ok() {
        double actual = calculator.calculate(0, SECOND_NUMBER, POWER);
        double expected = Math.pow(0, SECOND_NUMBER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroValueToTheNegativePower_Ok() {
        double actual = calculator.calculate(0, (- SECOND_NUMBER), POWER);
        double expected = Math.pow(0, (- SECOND_NUMBER));
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalOperation_NotOk() {
        char operation = '$';
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(FIRST_NUMBER, SECOND_NUMBER, operation));
    }
}
