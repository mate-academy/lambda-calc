package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PowerTest {
    private static final double DELTA = 0.001;
    private static final double MAX = Double.MAX_VALUE;
    private static final double MIN = Double.MIN_VALUE;
    private static final double ONE = 1.0;
    private static final double ZERO = 0.0;
    private static final char POWER = '^';
    private static Calculator calculator;
    private static double firstElement;
    private static double secondElement;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
        firstElement = 2.02432;
        secondElement = 1.04321;
    }

    @Test
    void raisePositiveValueToPositivePower_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, POWER);
        double expected = Math.pow(firstElement, secondElement);
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisePositiveValueToNegativePower_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, POWER);
        double expected = Math.pow(firstElement, -secondElement);
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void raiseNegativeValueToPositivePower_Ok() {
        double actual = calculator.calculate(-firstElement, secondElement, POWER);
        double expected = Math.pow(-firstElement, secondElement);
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void raiseNegativeValueToNegativePower_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, POWER);
        double expected = Math.pow(-firstElement, -secondElement);
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void raiseNegativeValueToZeroPower_Ok() {
        double actual = calculator.calculate(-firstElement, 0, POWER);
        double expected = ONE;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raisePositiveValueToZeroPower_Ok() {
        double actual = calculator.calculate(firstElement, 0, POWER);
        double expected = ONE;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseZeroToPower_Ok() {
        double actual = calculator.calculate(0, firstElement, POWER);
        double expected = ZERO;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMaxDoubleToNegativeOne_Ok() {
        double actual = calculator.calculate(MAX, -firstElement, POWER);
        double expected = Math.pow(MAX, -firstElement);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMaxDoubleToPositiveOne_NotOk() {
        double actual = calculator.calculate(MAX, firstElement, POWER);
        double expected = Math.pow(MAX, firstElement);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMinDoubleToPositiveOne_Ok() {
        double actual = calculator.calculate(MIN, firstElement, POWER);
        double expected = ZERO;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void raiseMinDoubleToNegativeOne_Ok() {
        double actual = calculator.calculate(MIN, -firstElement, POWER);
        double expected = Math.pow(MIN, -firstElement);
        Assertions.assertEquals(expected, actual);
    }
}
