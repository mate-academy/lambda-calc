package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    void addition_with_two_positive_operands_Ok() {
        String add = "+";
        double a = 7;
        double b = 8;
        double expected = 15;
        double actual = calculator.calculate(a, b, add);
        assertEquals(expected, actual);

    }

    @Test
    void addition_with_two_negative_operands_Ok() {
        String add = "+";
        double a = -7;
        double b = -9;
        double expected = -16;
        double actual = calculator.calculate(a, b, add);
    }

    @Test
    void addition_with_positive_and_negative_operands_Ok() {
        String add = "+";
        double a = -7;
        double b = 8;
        double expected = 1;
        double actual = calculator.calculate(a, b, add);
        assertEquals(expected, actual);
    }

    @Test
    void addition_with_first_zero_Ok() {
        String add = "+";
        double a = 0;
        double b = 8;
        double expected = 8;
        double actual = calculator.calculate(a, b, add);
        assertEquals(expected, actual);
    }

    @Test
    void addition_with_second_zero_Ok() {
        String add = "+";
        double a = 8;
        double b = 0;
        double expected = 8;
        double actual = calculator.calculate(a, b, add);
        assertEquals(expected, actual);
    }

    @Test
    void addition_for_Min_Max_value_ok() {
        String add = "+";
        double a = Double.MIN_VALUE;
        double b = Double.MAX_VALUE;
        double expected = a + b;
        double actual = calculator.calculate(a, b, add);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_Ok() {
        String subtraction = "-";
        double a = 0;
        double b = 8;
        double expected = -8;
        double actual = calculator.calculate(a, b, subtraction);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_Ok() {
        String multiplication = "*";
        double a = 3;
        double b = 8;
        double expected = 24;
        double actual = calculator.calculate(a, b, multiplication);
        assertEquals(expected, actual);
    }

    @Test
    void division_by_zero_notOk() {
        String division = "/";
        double a = 7;
        double b = 0;
        assertThrows(ArithmeticException.class, () -> calculator.calculate(a, b, division));
    }

    @Test
    void division_Ok() {
        String division = "/";
        double a = 7;
        double b = 2;
        double expected = 3.5;
        double actual = calculator.calculate(a, b, division);
        assertEquals(expected, actual);
    }

    @Test
    void rising_positive_to_positive_Ok() {
        String pow = "^";
        double a = 3;
        double b = 4;
        double expected = 81;
        double actual = calculator.calculate(a, b, pow);
        assertEquals(expected, actual);
    }

    @Test
    void rising_negtive_to_positive_Ok() {
        String pow = "^";
        double a = -3;
        double b = 4;
        double expected = 81;
        double actual = calculator.calculate(a, b, pow);
        assertEquals(expected, actual);
    }

    @Test
    void rising_negative_to_negative_Ok() {
        String pow = "^";
        double a = -3;
        double b = -4;
        double expected = 0.012345679012345678;
        double actual = calculator.calculate(a, b, pow);
        assertEquals(expected, actual);
    }

    @Test
    void rising_negative_to_zero_Ok() {
        String pow = "^";
        double a = -3;
        double b = 0;
        double expected = 1;
        double actual = calculator.calculate(a, b, pow);
        assertEquals(expected, actual);
    }

    @Test
    void rising_positive_to_zero_Ok() {
        String pow = "^";
        double a = 3;
        double b = 0;
        double expected = 1;
        double actual = calculator.calculate(a, b, pow);
        assertEquals(expected, actual);
    }

    @Test
    void rising_zero_to_pow_Ok() {
        String pow = "^";
        double a = 0;
        double b = 4;
        double expected = 0;
        double actual = calculator.calculate(a, b, pow);
        assertEquals(expected, actual);
    }

    @Test
    void illegal_operation_notOk() {
        String error = "error";
        double a = 7;
        double b = 0;
        assertThrows(NoSuchElementException.class, () -> calculator.calculate(a, b, error));
    }
}
