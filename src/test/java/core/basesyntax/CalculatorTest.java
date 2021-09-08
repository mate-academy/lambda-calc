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
    void addition_for_Min_value_ok() {
        String add = "+";
        double a = Double.MIN_VALUE;
        double b = 9;
        double expected = 9;
        double actual = calculator.calculate(a, b, add);
        assertEquals(expected, actual);
    }

    @Test
    void addition_for_Max_value_ok() {
        String add = "+";
        double a = Double.MAX_VALUE;
        double b = 9;
        double expected = 1.7976931348623157E308;
        double actual = calculator.calculate(a, b, add);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_with_two_positive_operands_Ok() {
        String subtraction = "-";
        double a = 7;
        double b = 8;
        double expected = -1;
        double actual = calculator.calculate(a, b, subtraction);
        assertEquals(expected, actual);

    }

    @Test
    void subtraction_with_two_negative_operands_Ok() {
        String subtraction = "-";
        double a = -7;
        double b = -9;
        double expected = 2;
        double actual = calculator.calculate(a, b, subtraction);
    }

    @Test
    void subtraction_with_positive_and_negative_operands_Ok() {
        String subtraction = "-";
        double a = -7;
        double b = 8;
        double expected = -15;
        double actual = calculator.calculate(a, b, subtraction);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_with_first_zero_Ok() {
        String subtraction = "-";
        double a = 0;
        double b = 8;
        double expected = -8;
        double actual = calculator.calculate(a, b, subtraction);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_with_second_zero_Ok() {
        String subtraction = "-";
        double a = 8;
        double b = 0;
        double expected = 8;
        double actual = calculator.calculate(a, b, subtraction);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_for_Min_value_ok() {
        String subtraction = "-";
        double a = Double.MIN_VALUE;
        double b = 9;
        double expected = -9;
        double actual = calculator.calculate(a, b, subtraction);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_for_Max_value_ok() {
        String subtraction = "-";
        double a = Double.MAX_VALUE;
        double b = 9;
        double expected = 1.7976931348623157E308;
        double actual = calculator.calculate(a, b, subtraction);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_with_two_positive_operands_Ok() {
        String multiplication = "*";
        double a = 7;
        double b = 8;
        double expected = 56;
        double actual = calculator.calculate(a, b, multiplication);
        assertEquals(expected, actual);

    }

    @Test
    void multiplication_with_two_negative_operands_Ok() {
        String multiplication = "*";
        double a = -7;
        double b = -9;
        double expected = 63;
        double actual = calculator.calculate(a, b, multiplication);
    }

    @Test
    void multiplication_with_positive_and_negative_operands_Ok() {
        String multiplication = "*";
        double a = -7;
        double b = 8;
        double expected = -56;
        double actual = calculator.calculate(a, b, multiplication);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_with_first_zero_Ok() {
        String multiplication = "*";
        double a = 0;
        double b = 8;
        double expected = 0;
        double actual = calculator.calculate(a, b, multiplication);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_with_second_zero_Ok() {
        String multiplication = "*";
        double a = 8;
        double b = 0;
        double expected = 0;
        double actual = calculator.calculate(a, b, multiplication);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_for_Min_value_ok() {
        String multiplication = "*";
        double a = Double.MIN_VALUE;
        double b = 9;
        double expected = 4.4E-323;
        double actual = calculator.calculate(a, b, multiplication);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_for_Max_value_ok() {
        String multiplication = "*";
        double a = Double.MAX_VALUE;
        double b = 1;
        double expected = Double.MAX_VALUE;
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
    void division_with_first_zero_Ok() {
        String division = "/";
        double a = 0;
        double b = 2;
        double expected = 0;
        double actual = calculator.calculate(a, b, division);
        assertEquals(expected, actual);
    }

    @Test
    void division_for_Min_value_ok() {
        String division = "/";
        double a = Double.MIN_VALUE;
        double b = 2;
        double expected = 0;
        double actual = calculator.calculate(a, b, division);
        assertEquals(expected, actual);
    }

    @Test
    void division_for_Max_value_ok() {
        String division = "/";
        double a = Double.MAX_VALUE;
        double b = 9;
        double expected = 1.9974368165136842E307;
        double actual = calculator.calculate(a, b, division);
        assertEquals(expected, actual);
    }

    @Test
    void division_with_two_positive_operands_Ok() {
        String division = "/";
        double a = 10;
        double b = 8;
        double expected = 1.25;
        double actual = calculator.calculate(a, b, division);
        assertEquals(expected, actual);

    }

    @Test
    void division_with_two_negative_operands_Ok() {
        String division = "/";
        double a = -9;
        double b = -3;
        double expected = 3;
        double actual = calculator.calculate(a, b, division);
    }

    @Test
    void division_with_positive_and_negative_operands_Ok() {
        String division = "/";
        double a = -7;
        double b = 2;
        double expected = -3.5;
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
        assertThrows(InvalidOperationException.class, () -> calculator.calculate(a, b, error));
    }
}
