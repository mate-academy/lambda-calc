package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exeptions.InvalidOperationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final double ZERO = 0;
    private static final char firstInvalidOperation = '3';
    private static final char secondInvalidOperation = '=';
    private static CalculatorImpl calculator;
    private static double firstVariable;
    private static double secondVariable;
    private static double thirdVariable;
    private static double maxValue;
    private static double minValue;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
        firstVariable = -13243.34;
        secondVariable = 13.567;
        thirdVariable = 10;
        maxValue = Double.MAX_VALUE;
        minValue = Double.MIN_VALUE;
    }

    @Test
    void addition_Ok() {
        assertEquals(firstVariable + secondVariable,
                calculator.calculate(firstVariable, secondVariable, PLUS));
        assertEquals(firstVariable + thirdVariable,
                calculator.calculate(firstVariable, thirdVariable, PLUS));
        assertEquals(thirdVariable + secondVariable,
                calculator.calculate(thirdVariable, secondVariable, PLUS));
        assertEquals(ZERO + ZERO, calculator.calculate(ZERO, ZERO, PLUS));
        assertEquals(thirdVariable + ZERO,
                calculator.calculate(thirdVariable, ZERO, PLUS));
        assertEquals(maxValue + minValue,
                calculator.calculate(maxValue, minValue, PLUS));
        assertEquals(maxValue + maxValue,
                calculator.calculate(maxValue, maxValue, PLUS));
    }

    @Test
    void subtraction_Ok() {
        assertEquals(firstVariable - secondVariable,
                calculator.calculate(firstVariable, secondVariable, MINUS));
        assertEquals(firstVariable - thirdVariable,
                calculator.calculate(firstVariable, thirdVariable, MINUS));
        assertEquals(thirdVariable - secondVariable,
                calculator.calculate(thirdVariable, secondVariable, MINUS));
        assertEquals(ZERO - ZERO,
                calculator.calculate(ZERO, ZERO, MINUS));
        assertEquals(ZERO - secondVariable,
                calculator.calculate(ZERO, secondVariable, MINUS));
        assertEquals(maxValue - minValue,
                calculator.calculate(maxValue, minValue, MINUS));
    }

    @Test
    void multiplication_Ok() {
        assertEquals(firstVariable * secondVariable,
                calculator.calculate(firstVariable, secondVariable, MULTIPLICATION));
        assertEquals(firstVariable * thirdVariable,
                calculator.calculate(firstVariable, thirdVariable, MULTIPLICATION));
        assertEquals(thirdVariable * secondVariable,
                calculator.calculate(thirdVariable, secondVariable, MULTIPLICATION));
        assertEquals(ZERO * ZERO, calculator.calculate(ZERO, ZERO, MULTIPLICATION));
        assertEquals(maxValue * minValue,
                calculator.calculate(maxValue, minValue, MULTIPLICATION));
    }

    @Test
    void raisingToAPower_Ok() {
        assertEquals(Math.pow(firstVariable, secondVariable),
                calculator.calculate(firstVariable, secondVariable, POWER));
        assertEquals(Math.pow(firstVariable, thirdVariable),
                calculator.calculate(firstVariable, thirdVariable, POWER));
        assertEquals(Math.pow(thirdVariable, secondVariable),
                calculator.calculate(thirdVariable, secondVariable, POWER));
        assertEquals(Math.pow(thirdVariable, ZERO),
                calculator.calculate(thirdVariable, ZERO, POWER));
        assertEquals(Math.pow(ZERO, secondVariable),
                calculator.calculate(ZERO, secondVariable, POWER));
        assertEquals(Math.pow(maxValue, maxValue),
                calculator.calculate(maxValue, maxValue, POWER));
        assertEquals(Math.pow(maxValue, minValue),
                calculator.calculate(maxValue, minValue, POWER));
    }

    @Test
    void division_Ok() {
        assertEquals(firstVariable / secondVariable,
                calculator.calculate(firstVariable, secondVariable, DIVISION));
        assertEquals(firstVariable / thirdVariable,
                calculator.calculate(firstVariable, thirdVariable, DIVISION));
        assertEquals(thirdVariable / secondVariable,
                calculator.calculate(thirdVariable, secondVariable, DIVISION));
        assertEquals(ZERO / secondVariable,
                calculator.calculate(ZERO, secondVariable, DIVISION));
        assertEquals(maxValue / maxValue,
                calculator.calculate(maxValue, maxValue, DIVISION));
        assertEquals(ZERO / minValue,
                calculator.calculate(ZERO, minValue, DIVISION));
    }

    @Test
    void divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(firstVariable, ZERO, DIVISION));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(minValue, ZERO, DIVISION));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(maxValue, ZERO, DIVISION));
    }

    @Test
    void invalidOperation_NotOk() {
        assertThrows(InvalidOperationException.class, () ->
                calculator.calculate(firstVariable, secondVariable, firstInvalidOperation));
        assertThrows(InvalidOperationException.class, () ->
                calculator.calculate(minValue, ZERO, secondInvalidOperation));
    }
}
