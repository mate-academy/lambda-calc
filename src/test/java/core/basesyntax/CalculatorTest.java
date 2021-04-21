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
    void addPositiveOperands_ok() {
        double actual = calculatorTest.calculate(12.4, 8.6, ADDITION);
        assertEquals(21, actual);
    }

    @Test
    void addNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, ADDITION);
        assertEquals(-111, actual);
    }

    @Test
    void addOperandsWithDifferentSign_ok() {
        double actual = calculatorTest.calculate(15, -24, ADDITION);
        assertEquals(-9, actual);
    }

    @Test
    void addZero_ok() {
        double actual = calculatorTest.calculate(0, -2, ADDITION);
        assertEquals(-2, actual);
        double actual2 = calculatorTest.calculate(4, 0, ADDITION);
        assertEquals(4, actual2);
    }

    @Test
    void addMaxValues_notOk() {
        assertThrows(ArithmeticException.class, () ->
                calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION));
    }

    @Test
    void addMinValues_ok() {
        double actual = calculatorTest.calculate(Double.MIN_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(1.0E-323, actual);
    }

    @Test
    void addMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(1.7976931348623157E308, actual);
    }

    @Test
    void subtractPositiveValues_ok() {
        double actual = calculatorTest.calculate(24, 4, SUBTRACTION);
        assertEquals(20, actual);
    }

    @Test
    void subtractNegativeValues_ok() {
        double actual = calculatorTest.calculate(-9, -4, SUBTRACTION);
        assertEquals(-5, actual);
    }

    @Test
    void subtractDifferentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, SUBTRACTION);
        assertEquals(-70, actual);
    }

    @Test
    void subtractWithOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, SUBTRACTION);
        assertEquals(-4, actual);
        double actual2 = calculatorTest.calculate(21, 0, SUBTRACTION);
        assertEquals(21, actual2);
    }

    @Test
    void subtractWithMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(1.7976931348623157E308, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION);
        assertEquals(-1.7976931348623157E308, actual2);
    }

    @Test
    void multiplyPositiveOperands_ok() {
        double actual = calculatorTest.calculate(24, 4, MULTIPLICATION);
        assertEquals(96, actual);
    }

    @Test
    void multiplyNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-9.97, -4.565, MULTIPLICATION);
        assertEquals(45.51305000000001, actual);
    }

    @Test
    void multiplyDifferentOperands_ok() {
        double actual = calculatorTest.calculate(-65, 5, MULTIPLICATION);
        assertEquals(-325, actual);
    }

    @Test
    void multiplyWithOneZero_ok() {
        double actual = calculatorTest.calculate(0, 4, MULTIPLICATION);
        assertEquals(0, actual);
        double actual2 = calculatorTest.calculate(21, 0, MULTIPLICATION);
        assertEquals(0, actual2);
    }

    @Test
    void multiplyMinAndMaxValues_ok() {
        double actual = calculatorTest.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(8.881784197001251E-16, actual);
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, MULTIPLICATION);
        assertEquals(8.881784197001251E-16, actual2);
    }

    @Test
    void multiplyMaxValues_notOk() {
        assertThrows(ArithmeticException.class, () ->
                calculatorTest.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void multiplyMinValues_notOk() {
        double actual = calculatorTest.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, MULTIPLICATION);
        assertEquals(0, actual);
    }

    @Test
    void divideWithTwoPositiveOperands_ok() {
        double actual = calculatorTest.calculate(12, 8, DIVISION_1);
        assertEquals(1.5, actual);
    }

    @Test
    void divideWithTwoNegativeOperands_ok() {
        double actual = calculatorTest.calculate(-21, -90, DIVISION_2);
        assertEquals(0.23333333333333334, actual);
    }

    @Test
    void divideWithDifferentOperands_ok() {
        double actual = calculatorTest.calculate(15, -24, DIVISION_1);
        assertEquals(-0.625, actual);
    }

    @Test
    void divideZeroByValue_ok() {
        double actual = calculatorTest.calculate(0, -2, DIVISION_2);
        assertEquals(0, actual);
    }

    @Test
    void divideValueByZero_notOk() {
        assertThrows(ArithmeticException.class, () ->
                calculatorTest.calculate(4, 0, DIVISION_2));
    }

    @Test
    void divideWithMinDivisor_notOk() {
        assertThrows(ArithmeticException.class, () ->
                calculatorTest.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION_1));
    }

    @Test
    void divideWithMaxDivisor_ok() {
        double actual2 = calculatorTest.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION_2);
        assertEquals(0, actual2);
    }

    @Test
    void raisePositiveNumberToPower_ok() {
        double actual = calculatorTest.calculate(3.65, 3, RAISING_TO_POWER);
        assertEquals(48.627125, actual);
    }

    @Test
    void raiseNegativeNumberToPower_ok() {
        double actual = calculatorTest.calculate(-2, 3, RAISING_TO_POWER);
        assertEquals(-8, actual);
    }

    @Test
    void raisePositiveNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(6, -8, RAISING_TO_POWER);
        assertEquals(5.953741807651273E-7, actual);
    }

    @Test
    void raiseNegativeNumberToNegativePower_ok() {
        double actual = calculatorTest.calculate(-12, -3, RAISING_TO_POWER);
        assertEquals(-5.787037037037037E-4, actual);
    }

    @Test
    void raisingPositiveNumberToZero_Ok() {
        double actual = calculatorTest.calculate(6948, 0, RAISING_TO_POWER);
        assertEquals(1, actual);
    }

    @Test
    void raisingNegativeNumberToZero_Ok() {
        double actual = calculatorTest.calculate(-74, 0, RAISING_TO_POWER);
        assertEquals(1, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        double actual = calculatorTest.calculate(0, 23, RAISING_TO_POWER);
        assertEquals(0, actual);
    }

    @Test
    void calculateIllegalCharacter_notOk() {
        assertThrows(RuntimeException.class, ()
                -> calculatorTest.calculate(15, 3, '3'));
    }
}
