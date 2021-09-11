package core.basesyntax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LambdaCalculatorTest {
    public final static double DELTA = 0.0001d;
    private Calculator calculator;
    private double first;
    private double second;
    private double expected;
    private char operator;
    private double actual;

    @BeforeEach
    void setUp() {
        calculator = new LambdaCalculator();
    }

    @Test
    void calculatePlusTwoPositive_Ok() {
        first = 15.25d;
        second = 89.45d;
        operator = '+';
        double expected = first + second;
        double actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculatePlusTwoNegative_Ok() {
        first = -16815.002345d;
        second = -4505689.3540545d;
        operator = '+';
        double expected = first + second;
        double actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateNegativePlusPositive_Ok() {
        first = 543543.875435d;
        second = -4505689.3540545d;
        operator = '+';
        double expected = first + second;
        double actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculatePlusZeroPositive_Ok() {
        first = 0.0d;
        second = -4505689.3540545d;
        operator = '+';
        expected = first + second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMaxValuePlusNegative_Ok() {
        first = Double.MAX_VALUE;
        second = -35120.05430;
        operator = '+';
        expected = first + second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMaxValuePlusPositive_NotOk() {
        first = Double.MAX_VALUE;
        second = 20.0;
        operator = '+';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinValuePlusNegative_NotOk() {
        first = -Double.MAX_VALUE;
        second = -10020.0;
        operator = '+';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinValuePlusPositive_Ok() {
        first = Double.MIN_VALUE;
        second = 20.0;
        operator = '+';
        expected = first + second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateReachInfinity_NotOk() {
        first = 1.7976931348623157E307;
        second = 1.7976931348623157E308;
        operator = '+';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateIllegalOperator_NotOk() {
        first = 5434.5464;
        second = 20.0;
        operator = '#';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinusTwoPositive_Ok() {
        first = 15.25d;
        second = 89.45d;
        operator = '-';
        double expected = first - second;
        double actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMinusTwoNegative_Ok() {
        first = -16815.002345d;
        second = -4505689.3540545d;
        operator = '-';
        double expected = first - second;
        double actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateNegativeMinusPositive_Ok() {
        first = -543543.875435d;
        second = 4505689.3540545d;
        operator = '-';
        double expected = first - second;
        double actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateZeroMinisPositive_Ok() {
        first = 0.0d;
        second = 4505689.3540545d;
        operator = '-';
        expected = first - second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMaxValueMinusNegative_Ok() {
        first = Double.MAX_VALUE;
        second = -35120.05430;
        operator = '-';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMaxValueMinusPositive_NotOk() {
        first = Double.MAX_VALUE;
        second = 20.0;
        operator = '-';
        expected = first - second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);

    }

    @Test
    void calculateMinValueMinusNegative_NotOk() {
        first = -Double.MAX_VALUE;
        second = -10020.0;
        operator = '-';
        expected = first - second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMinValueMinusPositive_Ok() {
        first = -Double.MAX_VALUE;
        second = 4154654620.0;
        operator = '-';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateReachInfinityMinus_NotOk() {
        first = -1.7976931348623157E307;
        second = 1.7976931348623157E308;
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateZeroReminder_NotOk() {
        first = 446545.00574055;
        second = 0.0;
        operator = '/';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateNegativeZeroReminder_NotOk() {
        first = 446545.00574055;
        second = -0.0;
        operator = '/';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void  calculateMinValue_NotOk() {
        first = 4.9E-322;
        second = 100;
        operator = '/';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void  calculateMinValue_Ok() {
        first = 4.9E-322;
        second = 10.0;
        operator = '/';
        expected = first / second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculatePositiveDivideNegative_Ok() {
        first = 4.9E32;
        second = -4354.346410;
        operator = '/';
        expected = first / second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void  calculateDivideInfinity_NotOk() {
        first = Double.NEGATIVE_INFINITY;
        second = 100.545;
        operator = '/';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateDivisibleInfinity_NotOk() {
        first = 456643.4645;
        second = Double.NEGATIVE_INFINITY;
        operator = '/';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculatePositiveTwo_Ok() {
        first = 4.9E32;
        second = 4354.346410;
        operator = '*';
        expected = first * second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);

    }

    @Test
    void calculateNegativeTwo_Ok() {
        first = -4.9E32;
        second = -4354.346410;
        operator = '*';
        expected = first * second;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);

    }

    @Test
    void calculatePositiveInfinity_NotOk() {
        first = 1.7976931348623157E307;
        second = 4354.346410;
        operator = '*';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));

    }

    @Test
    void calculateNegativeInfinity_NotOk() {
        first = -1.7976931348623157E307;
        second = 4354.346410;
        operator = '*';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));

    }

    @Test
    void calculateNegativeMaxValue_NotOk() {
        first = -1.7976931348623157E307;
        second = 100.346410;
        operator = '*';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));

    }

    @Test
    void calculatePositiveMaxValue_NotOk() {
        first = 1.7976931348623157E307;
        second = 100.346410;
        operator = '*';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculatePositiveToPositivePower_Ok() {
        first = 4.932;
        second = 43.3464;
        operator = '^';
        expected = Math.pow(first, second);
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculatePositiveToNegativePower_Ok() {
        first = 4.932;
        second = -3.3464;
        operator = '^';
        expected = Math.pow(first, second);
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateNegativeToNegativePower_Ok() {
        first = -4.932;
        second = -30.00;
        operator = '^';
        expected = Math.pow(first, second);
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateNegativeToPositivePower_Ok() {
        first = -4.932;
        second = 33.0;
        operator = '^';
        expected = Math.pow(first, second);
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateNegativeToZeroPower_Ok() {
        first = -4.932;
        second = 0.00;
        operator = '^';
        expected = Math.pow(first, second);
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateZeroToZeroPower_Ok() {
        first = 0.00;
        second = 0.00;
        operator = '^';
        expected = Math.pow(first, second);
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateNegativeToEvenPower_NotOk() {
        first = -12.00;
        second = 0.50;
        operator = '^';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateNegativeImmenseToHugePower_NotOk() {
        first = -456546544354312.7987416875324300;
        second = 465465413413541540.5456550;
        operator = '^';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateInfinityToPositivePower_NotOk() {
        first = -4.932;
        second = 3464;
        operator = '^';
        assertThrows(ExpectedException.class, () -> calculator.calculate(first, second, operator));
    }

}