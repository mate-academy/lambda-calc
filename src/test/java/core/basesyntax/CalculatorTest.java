package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculate;

    @BeforeEach
    void create_object() {
        calculate = new Calculator(10, 20);
    }

    @Test
    void setters_checkForNull_FirstNumber() {
        try {
            Assertions.assertFalse(calculate.setFirstNumber(null));
            Assertions.assertThrows(NullPointerException.class, () -> calculate.checkForNull());
        } catch (NullPointerException e) {
            return;
        }
        Assertions.fail("You need to check values for null!");
    }

    @Test
    void setters_checkForNull_SecondNumber() {
        try {
            Assertions.assertFalse(calculate.setSecondNumber(null));
            Assertions.assertThrows(NullPointerException.class, () -> calculate.checkForNull());
        } catch (NullPointerException e) {
            return;
        }
        Assertions.fail("You need to check values for null!");
    }

    @Test
    void isSet_FirstValue() {
        Assertions.assertTrue(calculate.setFirstNumber(10));
    }

    @Test
    void isSet_SecondValue() {
        Assertions.assertTrue(calculate.setSecondNumber(10));
    }

    @Test
    void checkForConsistent_firstValue() {
        Integer expected = calculate.getFirstNumber();
        Assertions.assertEquals(expected, calculate.getFirstNumber(), "You number not equals");
    }

    @Test
    void checkForConsistent_secondValue() {
        Integer expected = calculate.getSecondNumber();
        Assertions.assertEquals(expected, calculate.getSecondNumber(), "You number not equals");
    }

    @Test
    void additional() {
        Integer actual = calculate
                .addition(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(30, actual);
    }

    @Test
    void subtraction() {
        Integer actual = calculate
                .subtraction(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(-10, actual);
    }

    @Test
    void division_Ok() {
        Integer actual = calculate
                .division(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(2, actual);
    }

    @Test
    void division_NotOk_FirstNumber() {
        calculate.setFirstNumber(-1);
        Integer actual = calculate
                .division(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(-20, actual);
    }

    @Test
    void division_NotOk_SecondNumber() {
        calculate.setSecondNumber(0);
        Integer actual = calculate
                .division(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(1, actual);
    }

    @Test
    void multiplication() {
        Integer actual = calculate
                .multiplication(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(200, actual);
    }
}
