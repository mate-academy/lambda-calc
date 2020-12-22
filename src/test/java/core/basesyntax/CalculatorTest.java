package core.basesyntax;

import core.basesyntax.exception.BigValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add_Ok() {
        int a = 5;
        int b = 10;
        int expected = a + b;
        int actual = Calculator.add(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void add_maxIntPlusOne_NotOk() {
        int a = Integer.MAX_VALUE;
        int b = 1;
        assertThrows(BigValueException.class, () -> {
            Calculator.add(a, b);
        });
    }

    @Test
    void add_MaxIntPlusMinInt_Ok() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int expected = -1;
        int actual = Calculator.add(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void subtract() {
    }

    @Test
    void divide() {
    }

    @Test
    void multiply() {
    }

    @Test
    void raiseToPower() {
    }
}