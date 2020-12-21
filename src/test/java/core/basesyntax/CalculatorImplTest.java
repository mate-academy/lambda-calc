package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exeptions.InvalidOperationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double ZERO = 0;
    private static CalculatorImpl calculator;
    private double firstVariable;
    private double secondVariable;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @BeforeEach
    void setUp() {
        firstVariable = Integer.MAX_VALUE;
        secondVariable = Integer.MIN_VALUE;
    }

    @Test
    void addition_Ok() {
        assertEquals(firstVariable + secondVariable,
                calculator.calculate(firstVariable, secondVariable, '+'));
        firstVariable = -4;
        secondVariable = 13;
        assertEquals(firstVariable + secondVariable,
                calculator.calculate(firstVariable, secondVariable, '+'));
        firstVariable = 100;
        secondVariable = 0;
        assertEquals(firstVariable + secondVariable,
                calculator.calculate(firstVariable, secondVariable, '+'));
    }

    @Test
    void subtraction_Ok() {
        assertEquals(firstVariable - secondVariable,
                calculator.calculate(firstVariable, secondVariable, '-'));
        firstVariable = 100;
        secondVariable = -50;
        assertEquals(firstVariable - secondVariable,
                calculator.calculate(firstVariable, secondVariable, '-'));
        firstVariable = 3;
        secondVariable = 0;
        assertEquals(firstVariable - secondVariable,
                calculator.calculate(firstVariable, secondVariable, '-'));
    }

    @Test
    void multiplication_Ok() {
        assertEquals(firstVariable * secondVariable,
                calculator.calculate(firstVariable, secondVariable, '*'));
        firstVariable = 0;
        secondVariable = 0;
        assertEquals(firstVariable * secondVariable,
                calculator.calculate(firstVariable, secondVariable, '*'));
        firstVariable = 100;
        secondVariable = -333;
        assertEquals(firstVariable * secondVariable,
                calculator.calculate(firstVariable, secondVariable, '*'));
    }

    @Test
    void raisingToAPower_Ok() {
        assertEquals(Math.pow(firstVariable, secondVariable),
                calculator.calculate(firstVariable, secondVariable, '^'));
        firstVariable = 4;
        secondVariable = 65;
        assertEquals(Math.pow(firstVariable, secondVariable),
                calculator.calculate(firstVariable, secondVariable, '^'));
        firstVariable = 0;
        secondVariable = 0;
        assertEquals(Math.pow(firstVariable, secondVariable),
                calculator.calculate(firstVariable, secondVariable, '^'));
    }

    @Test
    void division_Ok() {
        assertEquals((double) firstVariable / secondVariable,
                calculator.calculate(firstVariable, secondVariable, '/'));
        firstVariable = 44;
        secondVariable = 44;
        assertEquals((double) firstVariable / secondVariable,
                calculator.calculate(firstVariable, secondVariable, '/'));
        firstVariable = 71;
        secondVariable = -45;
        assertEquals((double) firstVariable / secondVariable,
                calculator.calculate(firstVariable, secondVariable, '/'));
    }

    @Test
    void unexpectedOperation() {
        assertThrows(InvalidOperationException.class, () ->
                calculator.calculate(firstVariable, secondVariable, 'a'));
        assertThrows(InvalidOperationException.class, () ->
                calculator.calculate(firstVariable, secondVariable, '6'));
        assertThrows(InvalidOperationException.class, () ->
                calculator.calculate(firstVariable, secondVariable, '='));
    }

    @Test
    void divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(firstVariable, ZERO, '/'));
    }
}
