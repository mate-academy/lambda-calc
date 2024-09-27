package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION_1 = '/';
    private static final char DIVISION_2 = ':';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';
    private static Calculator calculatorTest;

    @BeforeAll
    static void beforeAll() {
        calculatorTest = new Calculator();
    }

    @Test
    void calculate_addPositiveOperands_ok() {
        double actual = calculatorTest.calculate(12.4, 8.6, ADDITION);
        assertEquals(21, actual);
    }

    @Test
    void calculate_addNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, ADDITION);
        assertEquals(-111, actual);
    }

    @Test
    void calculate_addOperandsWithDifferentSign_ok() {
        double actual = calculatorTest.calculate(15, -24, ADDITION);
        assertEquals(-9, actual);
    }

    @Test
    void calculate_addZero_ok() {
        double actual = calculatorTest.calculate(0, -2, ADDITION);
        assertEquals(-2, actual);
        double actual2 = calculatorTest.calculate(4, 0, ADDITION);
        assertEquals(4, actual2);
    }

    @Test
    void calculate_addMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_addMinValues_ok() {
        double actual = calculatorTest.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(1.0E-323, actual);
    }

    @Test
    void calculate_addMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(1.7976931348623157E308, actual);
    }

    @Test
    void calculate_subtractPositiveValues_ok() {
        double actual = calculatorTest.calculate(24, 4, SUBTRACTION);
        assertEquals(20, actual);
    }

    @Test
    void calculate_subtractNegativeValues_ok() {
        double actual = calculatorTest.calculate(-9, -4, SUBTRACTION);
        assertEquals(-5, actual);
    }

    @Test
    void calculate_subtractDifferentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, SUBTRACTION);
        assertEquals(-70, actual);
    }

    @Test
    void calculate_subtractWithOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, SUBTRACTION);
        assertEquals(-4, actual);
        double actual2 = calculatorTest.calculate(21, 0, SUBTRACTION);
        assertEquals(21, actual2);
    }

    @Test
    void calculate_subtractWithMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(1.7976931348623157E308, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(-1.7976931348623157E308, actual2);
    }

    @Test
    void calculate_multiplyPositiveOperands_ok() {
        double actual = calculatorTest.calculate(24, 4, MULTIPLICATION);
        assertEquals(96, actual);
    }

    @Test
    void calculate_multiplyNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-9.97, -4.565, MULTIPLICATION);
        assertEquals(45.51305000000001, actual);
    }

    @Test
    void calculate_multiplyDifferentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, MULTIPLICATION);
        assertEquals(-325, actual);
    }

    @Test
    void calculate_multiplyWithOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, MULTIPLICATION);
        assertEquals(0, actual);
        double actual2 = calculatorTest.calculate(21, 0, MULTIPLICATION);
        assertEquals(0, actual2);
    }

    @Test
    void calculate_multiplyMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(8.881784197001251E-16, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(8.881784197001251E-16, actual2);
    }

    @Test
    void calculate_multiplyMaxValues_notOk() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE,
                 MULTIPLICATION);
        assertEquals(Double.POSITIVE_INFINITY, actual);
    }

    @Test
    void calculate_multiplyMinValues_notOk() {
        double actual = calculatorTest.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(0, actual);
    }

    @Test
    void calculate_divideWithTwoPositiveOperands_ok() {
        double actual = calculatorTest.calculate(12, 8, DIVISION_1);
        assertEquals(1.5, actual);
    }

    @Test
    void calculate_divideWithTwoNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, DIVISION_2);
        assertEquals(0.23333333333333334, actual);
    }

    @Test
    void calculate_divideWithDifferentOperands_ok() {
        double actual = calculatorTest.calculate(15, -24, DIVISION_1);
        assertEquals(-0.625, actual);
    }

    @Test
    void calculate_divideZeroByValue_ok() {
        double actual = calculatorTest.calculate(0, -2, DIVISION_2);
        assertEquals(0, actual);
    }

    @Test
    void calculate_divideValueByZero_notOk() {
        assertThrows(ArithmeticException.class, () ->
                calculatorTest.calculate(4, 0, DIVISION_2));
    }

    @Test
    void calculate_divideWithMinDivisor_notOk() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION_2);
        assertEquals(Double.POSITIVE_INFINITY, actual);;
    }

    @Test
    void calculate_divideWithMaxDivisor_ok() {
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION_2);
        assertEquals(0, actual2);
    }

    @Test
    void calculate_raisePositiveNumberToPower_ok() {
        double actual = calculatorTest.calculate(3.65, 3, RAISING_TO_POWER);
        assertEquals(48.627125, actual);
    }

    @Test
    void calculate_raiseNegativeNumberToPower_ok() {
        double actual = calculatorTest.calculate(-2, 3, RAISING_TO_POWER);
        assertEquals(-8, actual);
    }

    @Test
    void calculate_raisePositiveNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(6, -8, RAISING_TO_POWER);
        assertEquals(5.953741807651273E-7, actual);
    }

    @Test
    void calculate_raiseNegativeNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(-12, -3, RAISING_TO_POWER);
        assertEquals(-5.787037037037037E-4, actual);
    }

    @Test
    void calculate_raisingPositiveNumberToZero_Ok() {
        double actual = calculatorTest.calculate(6948, 0, RAISING_TO_POWER);
        assertEquals(1, actual);
    }

    @Test
    void calculate_raisingNegativeNumberToZero_Ok() {
        double actual = calculatorTest.calculate(-74, 0, RAISING_TO_POWER);
        assertEquals(1, actual);
    }

    @Test
    void calculate_raisingZeroToPower_Ok() {
        double actual = calculatorTest.calculate(0, 23, RAISING_TO_POWER);
        assertEquals(0, actual);
    }

    @Test
    void calculate_illegalCharacter_notOk() {
        assertThrows(RuntimeException.class, ()
                -> calculatorTest.calculate(15, 3, '3'));
    }
}
