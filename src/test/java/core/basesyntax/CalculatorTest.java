package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final static int MAX_VALUE = Integer.MAX_VALUE;
    private final static int MIN_VALUE = Integer.MIN_VALUE;
    private Calculator calculate;

    @BeforeEach
    void create_object() {
        calculate = new Calculator();
        calculate.setFirstNumber(20);
        calculate.setSecondNumber(10);
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
        Integer actual = calculate.getFirstNumber();
        Assertions.assertEquals(20, actual, "You number not equals");
    }

    @Test
    void checkForConsistent_secondValue() {
        Integer actual = calculate.getSecondNumber();
        Assertions.assertEquals(10, actual, "You number not equals");
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
        Assertions.assertEquals(10, actual);
    }

    @Test
    void division_Ok() {
        Integer actual = calculate
                .division(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(2, actual);
    }

    @Test
    void division_NotOk_FirstNumber() {
        calculate.setFirstNumber(-20);
        Integer actual = calculate
                .division(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(-2, actual);
    }

    @Test
    void division_NotOk_SecondNumber() {
        calculate.setSecondNumber(0);
        Assertions.assertThrows(ArithmeticException.class, () -> calculate
                .division(calculate.getFirstNumber(), calculate.getSecondNumber()));
    }

    @Test
    void multiplication() {
        Integer actual = calculate
                .multiplication(calculate.getFirstNumber(), calculate.getSecondNumber());
        Assertions.assertEquals(200, actual);
    }

    @Test
    void final_negative() {
        Assertions.assertEquals(MIN_VALUE - MIN_VALUE,
                calculate.subtraction(MIN_VALUE, MIN_VALUE));
        Assertions.assertEquals(MAX_VALUE - MIN_VALUE,
                calculate.addition(MAX_VALUE, MIN_VALUE));
    }

    @Test
    void final_positive() {
        Assertions.assertEquals(MAX_VALUE + MAX_VALUE,
                calculate.addition(MAX_VALUE, MAX_VALUE));
        Assertions.assertEquals(MAX_VALUE + MIN_VALUE,
                calculate.subtraction(MAX_VALUE, MIN_VALUE));
    }

    @Test
    void final_zero() {
        Assertions.assertEquals(MAX_VALUE - MIN_VALUE,
                calculate.addition(MAX_VALUE, MIN_VALUE));
        Assertions.assertEquals(MAX_VALUE - MIN_VALUE,
                calculate.subtraction(MAX_VALUE, MIN_VALUE));
    }
}
