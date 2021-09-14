package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalculatorTest {
    private static Calculator calculator;
    private double first;
    private double second;
    private double expected;
    private char operator;
    private double actual;
    private double delta;

    @BeforeAll
    static void setUp() {
        calculator = new LambdaCalculator();
    }

    @Test
    void calculatePositivePlusPositive_Ok() {
        first = 15.25d;
        second = 89.45d;
        operator = '+';
        expected = 104.7d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculatePlusTwoNegative_Ok() {
        first = -16815.002345d;
        second = -4505689.3540545d;
        operator = '+';
        expected = -4522504.356399501d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculateNegativePlusPositive_Ok() {
        first = 543543.875435d;
        second = -4505689.3540545d;
        operator = '+';
        expected = -3962145.4786195d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculatePlusZeroPositive_Ok() {
        first = 0.0d;
        second = -4505689.3540545d;
        operator = '+';
        expected = -4505689.354d;
        delta = 0.0545d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected, delta);
    }

    @Test
    void calculateMaxValuePlusNegative_Ok() {
        first = Double.MAX_VALUE;
        second = -35120.05430;
        operator = '+';
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMaxValuePlusPositive_NotOk() {
        first = Double.MAX_VALUE;
        second = 20.0;
        operator = '+';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinValuePlusNegative_NotOk() {
        first = -Double.MAX_VALUE;
        second = -10020.0;
        operator = '+';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinValuePlusPositive_Ok() {
        first = Double.MIN_VALUE;
        second = 20.0;
        operator = '+';
        expected = 20.0;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateReachInfinity_NotOk() {
        first = 1.7976931348623157E307;
        second = 1.7976931348623157E308;
        operator = '+';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateIllegalOperator_NotOk() {
        first = 5434.5464;
        second = 20.0;
        operator = '#';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinusTwoPositive_Ok() {
        first = 15.25d;
        second = 89.45d;
        operator = '-';
        expected = -74.2d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMinusTwoNegative_Ok() {
        first = -16815.002345d;
        second = -4505689.3540545d;
        operator = '-';
        expected = 4488874.35d;
        delta = 0.017095d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual, delta);
    }

    @Test
    void calculateNegativeMinusPositive_Ok() {
        first = -543543.875435d;
        second = 4505689.3540545d;
        operator = '-';
        expected = -5049233.22d;
        delta = .009489501d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected, delta);
    }

    @Test
    void calculateZeroMinisPositive_Ok() {
        first = 0.0d;
        second = 4505689.3540545d;
        operator = '-';
        expected = -4505689.3540545d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculateMaxValueMinusNegative_Ok() {
        first = Double.MAX_VALUE;
        second = -35120.05430;
        operator = '-';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMaxValueMinusPositive_NotOk() {
        first = Double.MAX_VALUE;
        second = 20.0;
        operator = '-';
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);

    }

    @Test
    void calculateMinValueMinusNegative_NotOk() {
        first = -Double.MAX_VALUE;
        second = -10020.0;
        operator = '-';
        expected = -Double.MAX_VALUE;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateMinValueMinusPositive_Ok() {
        first = -Double.MAX_VALUE;
        second = 4154654620.0;
        operator = '-';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateReachInfinityMinus_NotOk() {
        first = -1.7976931348623157E307;
        second = 1.7976931348623157E308;
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateZeroReminder_NotOk() {
        first = 446545.00574055;
        second = 0.0;
        operator = '/';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateNegativeZeroReminder_NotOk() {
        first = 446545.00574055;
        second = -0.0;
        operator = '/';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinValue_NotOk() {
        first = 4.9E-322;
        second = 100;
        operator = '/';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMinValue_Ok() {
        first = 4.9E-322;
        second = 10.0;
        operator = '/';
        expected = 4.9E-323;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculatePositiveDivideNegative_Ok() {
        first = 4932.5674d;
        second = -4354.34641d;
        operator = '/';
        expected = -1.13d;
        delta = 0.027916834251135d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual, delta);
    }

    @Test
    void calculateDivideInfinity_NotOk() {
        first = Double.NEGATIVE_INFINITY;
        second = 100.545;
        operator = '/';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateDivisibleInfinity_NotOk() {
        first = 456643.4645;
        second = Double.NEGATIVE_INFINITY;
        operator = '/';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateMultiplicationPositiveTwo_Ok() {
        first = 493245.00457;
        second = 4354.346410;
        operator = '*';
        expected = 2147759614.899813d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);

    }

    @Test
    void calculateMultiplicationNegativeTwo_Ok() {
        first = -493245.00457;
        second = -4354.346410;
        operator = '*';
        expected = 2147759614.899813d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);

    }

    @Test
    void calculatePositiveInfinity_NotOk() {
        first = 1.7976931348623157E307;
        second = 4354.346410;
        operator = '*';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));

    }

    @Test
    void calculateNegativeInfinity_NotOk() {
        first = -1.7976931348623157E307;
        second = 4354.346410;
        operator = '*';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));

    }

    @Test
    void calculateNegativeMaxValue_NotOk() {
        first = -1.7976931348623157E307;
        second = 100.346410;
        operator = '*';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));

    }

    @Test
    void calculatePositiveMaxValue_NotOk() {
        first = 1.7976931348623157E307;
        second = 100.346410;
        operator = '*';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculatePositiveToPositivePower_Ok() {
        first = 4.932;
        second = 43.3464;
        operator = '^';
        expected = 1.0966173467368478E30d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculatePositiveToNegativePower_Ok() {
        first = 4.932;
        second = -3.3464;
        operator = '^';
        expected = 0.0047958722437526306d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculateNegativeToNegativePower_Ok() {
        first = -4.932;
        second = -30.00;
        operator = '^';
        expected = 1.6192278402800162E-21;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculateNegativeToPositivePower_Ok() {
        first = -4.932;
        second = 33.0;
        operator = '^';
        expected = -7.409028092504483E22d;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculateNegativeToZeroPower_Ok() {
        first = -4.932;
        second = 0.00;
        operator = '^';
        expected = 1;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateZeroToZeroPower_Ok() {
        first = 0.00;
        second = 0.00;
        operator = '^';
        expected = 1;
        actual = calculator.calculate(first, second, operator);
        assertEquals(actual, expected);
    }

    @Test
    void calculateZeroPowerPositive_Ok() {
        first = 0.00;
        second = 2.45;
        operator = '^';
        expected = 0.0;
        actual = calculator.calculate(first, second, operator);
        assertEquals(expected, actual);
    }

    @Test
    void calculateZeroPowerNegative_Ok() {
        first = 0.00;
        second = -2.45;
        operator = '^';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateNegativeToEvenPower_NotOk() {
        first = -12.00;
        second = 0.50;
        operator = '^';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateNegativeImmenseToHugePower_NotOk() {
        first = -456546544354312.7987416875324300;
        second = 465465413413541540.5456550;
        operator = '^';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

    @Test
    void calculateInfinityToPositivePower_NotOk() {
        first = -4.932;
        second = 3464;
        operator = '^';
        assertThrows(ArgumentsValidationException.class,
                () -> calculator.calculate(first, second, operator));
    }

}
