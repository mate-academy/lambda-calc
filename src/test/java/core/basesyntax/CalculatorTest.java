package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static CalculatorService calculatorService;
    private double actual;
    private double expected;

    @BeforeAll
    private static void beforeAll() {
        calculatorService = new Calculator();
    }

    @Test
    void addTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(10, 5, '+');
        expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    void addTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-5, -10, '+');
        expected = -15;
        assertEquals(expected, actual);
    }

    @Test
    void addPositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-30, 50, '+');
        expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZero_Ok() {
        double actualFirstZero = calculatorService.calculate(0, 5, '+');
        double actualSecondZero = calculatorService.calculate(50, 0, '+');
        double actualBothZero = calculatorService.calculate(0, 0, '+');
        double expectedFirstZero = 5;
        double expectedSecondZero = 50;
        double expectedBothZero = 0;
        assertEquals(expectedFirstZero, actualFirstZero);
        assertEquals(expectedSecondZero, actualSecondZero);
        assertEquals(expectedBothZero, actualBothZero);
    }

    @Test
    void addTwoZeroNumbers_NotOk() {
        actual = calculatorService.calculate(0, 0, '+');
        expected = 55;
        assertNotEquals(expected, actual);
    }

    @Test
    void addTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void addTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = 1.0E-323;
        assertEquals(expected, actual);
    }

    @Test
    void subtractTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(200, 5, '-');
        expected = 195;
        assertEquals(expected, actual);
    }

    @Test
    void subtractTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-50, -10, '-');
        expected = -40;
        assertEquals(expected, actual);
    }

    @Test
    void subtractPositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-30, 50, '-');
        expected = -80;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZero_Ok() {
        double actualFirstZero = calculatorService.calculate(0, 5, '-');
        double actualSecondZero = calculatorService.calculate(50, 0, '-');
        double actualBothZero = calculatorService.calculate(0, 0, '-');
        double expectedFirstZero = -5;
        double expectedSecondZero = 50;
        double expectedBothZero = 0;
        assertEquals(expectedFirstZero, actualFirstZero);
        assertEquals(expectedSecondZero, actualSecondZero);
        assertEquals(expectedBothZero, actualBothZero);
    }

    @Test
    void subtractTwoZeroNumbers_NotOk() {
        actual = calculatorService.calculate(0, 0, '-');
        expected = 5555;
        assertNotEquals(expected, actual);
    }

    @Test
    void subtractTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(100, 100, '*');
        expected = 10000;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-8, -20, '*');
        expected = 160;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyPositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-40, 40, '*');
        expected = -1600;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZero_Ok() {
        double actualFirstZero = calculatorService.calculate(0, 5, '*');
        double actualSecondZero = calculatorService.calculate(50, 0, '*');
        double actualBothZero = calculatorService.calculate(0, 0, '*');
        double expectedFirstZero = 0;
        double expectedSecondZero = 0;
        double expectedBothZero = 0;
        assertEquals(expectedFirstZero, actualFirstZero);
        assertEquals(expectedSecondZero, actualSecondZero);
        assertEquals(expectedBothZero, actualBothZero);
    }

    @Test
    void multiplyTwoZeroNumbers_NotOk() {
        actual = calculatorService.calculate(0, 0, '*');
        expected = 10;
        assertNotEquals(expected, actual);
    }

    @Test
    void multiplyTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void multiplyTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoPositiveNumbers_Ok() {
        actual = calculatorService.calculate(100, 10, '/');
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-8, -2, '/');
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void dividePositiveAndNegativeNumbers_Ok() {
        actual = calculatorService.calculate(-160, 4, '/');
        expected = -40;
        assertEquals(expected, actual);
    }

    @Test
    void divideWithZero_Ok() {
        actual = calculatorService.calculate(0, 5, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divideWithZero_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, '/'));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(0, 0, '/'));
    }

    @Test
    void divideTwoMaxNumbers_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void divideTwoMinNumbers_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisePositiveNumberToPositivePower_Ok() {
        actual = calculatorService.calculate(2, 5, '^');
        expected = 32;
        assertEquals(expected, actual);
    }

    @Test
    void raiseNegativeNumberToPositivePower_Ok() {
        actual = calculatorService.calculate(-5, 2, '^');
        expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    void raiseNegativeNumberToNegativePower_Ok() {
        actual = calculatorService.calculate(-4, -2, '^');
        expected = 0.0625;
        assertEquals(expected, actual);
    }

    @Test
    void raisingToPowerWithZero_Ok() {
        double actualFirstZero = calculatorService.calculate(0, 5, '^');
        double actualSecondZero = calculatorService.calculate(50, 0, '^');
        double actualBothZero = calculatorService.calculate(0, 0, '^');
        double expectedFirstZero = 0;
        double expectedSecondZero = 1;
        double expectedBothZero = 1;
        assertEquals(expectedFirstZero, actualFirstZero);
        assertEquals(expectedSecondZero, actualSecondZero);
        assertEquals(expectedBothZero, actualBothZero);
    }

    @Test
    void raisingNegativeToZeroPower_Ok() {
        actual = calculatorService.calculate(-80, 0, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raiseMaxNumberToMaxPower_Ok() {
        actual = calculatorService.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '^');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void raiseMinNumberToMinPower_Ok() {
        actual = calculatorService.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperationType_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, '$'));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, '4'));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(50, 0, 'h'));
    }
}
