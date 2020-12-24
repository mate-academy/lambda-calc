package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void tryWithWrongOperator_NotOk() {
        assertThrows(WrongOperatorException.class, () -> {
            calculator.calculate(1000, 'm', 1000);
        });
        assertThrows(WrongOperatorException.class, () -> {
            calculator.calculate(-1000, '!', -1000);
        });
        assertThrows(WrongOperatorException.class, () -> {
            calculator.calculate(1000, '<', -1000);
        });
        assertThrows(WrongOperatorException.class, () -> {
            calculator.calculate(-1000, '0', 1000);
        });
        assertThrows(WrongOperatorException.class, () -> {
            calculator.calculate(-1000, 'A', 1000);
        });
        assertThrows(WrongOperatorException.class, () -> {
            calculator.calculate(-1000, 'ж', 1000);
        });
    }

    @Test
    void addiction_Ok() {
        assertEquals(2000, calculator.calculate(1000, '+', 1000));
        assertEquals(-2000, calculator.calculate(-1000, '+', -1000));
        assertEquals(0, calculator.calculate(1000, '+', -1000));
        assertEquals(0, calculator.calculate(-1000, '+', 1000));
        assertEquals(2.147484647E9, calculator.calculate(Integer.MAX_VALUE, '+', 1000));
        assertEquals(-2.147482648E9, calculator.calculate(Integer.MIN_VALUE, '+', 1000));
    }

    @Test
    void subtraction_Ok() {
        assertEquals(0, calculator.calculate(1000, '-', 1000));
        assertEquals(0, calculator.calculate(-1000, '-', -1000));
        assertEquals(2000, calculator.calculate(1000, '-', -1000));
        assertEquals(-2000, calculator.calculate(-1000, '-', 1000));
        assertEquals(2.147482647E9, calculator.calculate(Integer.MAX_VALUE, '-', 1000));
        assertEquals(-2.147484648E9, calculator.calculate(Integer.MIN_VALUE, '-', 1000));
    }

    @Test
    void multiplication_Ok() {
        assertEquals(4, calculator.calculate(2, '*', 2));
        assertEquals(4, calculator.calculate(-2, '*', -2));
        assertEquals(-4, calculator.calculate(2, '*', -2));
        assertEquals(-4, calculator.calculate(-2, '*', 2));
        assertEquals(0, calculator.calculate(0, '*', 2));
        assertEquals(0, calculator.calculate(-2, '*', 0));
    }

    @Test
    void division() {
        assertEquals(1, calculator.calculate(4, '/', 4));
        assertEquals(1, calculator.calculate(-4, '/', -4));
        assertEquals(-1, calculator.calculate(4, '/', -4));
        assertEquals(-1, calculator.calculate(-4, '/', 4));

        assertEquals(2.5, calculator.calculate(5, '/', 2));
        assertEquals(5.666666666666667, calculator.calculate(-17, '/', -3));
        assertEquals(-49.75, calculator.calculate(199, '/', -4));
        assertEquals(-5.2631578947368425, calculator.calculate(-1, '/', 0.19));

        assertEquals(0, calculator.calculate(0, '/', 4));
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(4, '/', 0);
        });
    }

    @Test
    void raisingToPower_Ok() {
        assertEquals(4, calculator.calculate(2, '^', 2));
        assertEquals(0.25, calculator.calculate(-2, '^', -2));
        assertEquals(0.25, calculator.calculate(2, '^', -2));
        assertEquals(4, calculator.calculate(-2, '^', 2));

        assertEquals(4.572473708276177E-4, calculator.calculate(3, '^', -7));
        assertEquals(1.0861771343660416E31, calculator.calculate(43, '^', 19));
        assertEquals(-4913.0, calculator.calculate(-17, '^', 3));
        assertEquals(-3.535942135457617E-18, calculator.calculate(-22, '^', -13));
    }

    @Test
    void raisingToPower_NotOK() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(2000000000, '^', 2000000000);
            assertThrows(ArithmeticException.class, () ->
                    calculator.calculate(0, '^', -4));
        });
    }
}
