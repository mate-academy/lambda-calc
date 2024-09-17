package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char POWER_OPERATOR = '^';
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addTwoOperands_isOk() {
        assertEquals(30,
                calculator.calculate(10, 20, ADDITION_OPERATOR), DELTA);
        assertEquals(-12.3,
                calculator.calculate(-5, -7.3, ADDITION_OPERATOR), DELTA);
        assertEquals(5,
                calculator.calculate(-5, 10, ADDITION_OPERATOR), DELTA);
        assertEquals(234.5,
                calculator.calculate(0, 234.5, ADDITION_OPERATOR), DELTA);
        assertEquals(126.345,
                calculator.calculate(126.345, 0, ADDITION_OPERATOR), DELTA);
    }

    @Test
    void calculate_subTwoOperands_isOk() {
        assertEquals(10,
                calculator.calculate(1110, 1100, SUBTRACTION_OPERATOR), DELTA);
        assertEquals(0,
                calculator.calculate(-7, -7, SUBTRACTION_OPERATOR), DELTA);
        assertEquals(-18.5,
                calculator.calculate(-6, 12.5, SUBTRACTION_OPERATOR), DELTA);
        assertEquals(7,
                calculator.calculate(0, -7, SUBTRACTION_OPERATOR), DELTA);
        assertEquals(23.78,
                calculator.calculate(23.78, 0, SUBTRACTION_OPERATOR), DELTA);
    }

    @Test
    void calculate_multTwoOperands_isOK() {
        assertEquals(14.64,
                calculator.calculate(2, 7.32, MULTIPLICATION_OPERATOR), DELTA);
        assertEquals(3,
                calculator.calculate(-1, -3, MULTIPLICATION_OPERATOR), DELTA);
        assertEquals(-3,
                calculator.calculate(1, -3, MULTIPLICATION_OPERATOR), DELTA);
        assertEquals(0,
                calculator.calculate(0, 234345.56, MULTIPLICATION_OPERATOR), DELTA);
        assertEquals(0,
                calculator.calculate(11234.56789, 0, MULTIPLICATION_OPERATOR), DELTA);
    }

    @Test
    void calculate_divTwoOperands_isOk() {
        assertEquals(4,
                calculator.calculate(16, 4, DIVISION_OPERATOR), DELTA);
        assertEquals(39.4,
                calculator.calculate(-236.4, -6, DIVISION_OPERATOR), DELTA);
        assertEquals(685.2173913043478,
                calculator.calculate(236.4, 0.345, DIVISION_OPERATOR), DELTA);
        assertEquals(0,
                calculator.calculate(0, 2323.6677871, DIVISION_OPERATOR), DELTA);
    }

    @Test
    void calculate_divByZero_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(1050.3, 0, DIVISION_OPERATOR));
    }

    @Test
    void calculate_raisValueToAPower_isOk() {
        assertEquals(9,
                calculator.calculate(3, 2, POWER_OPERATOR), DELTA);
        assertEquals(9,
                calculator.calculate(-3, 2, POWER_OPERATOR), DELTA);
        assertEquals(0.1111111111111111,
                calculator.calculate(3, -2, POWER_OPERATOR), DELTA);
        assertEquals(0.1111111111111111,
                calculator.calculate(-3, -2, POWER_OPERATOR), DELTA);
        assertEquals(1.0,
                calculator.calculate(5, 0, POWER_OPERATOR), DELTA);
        assertEquals(1.0,
                calculator.calculate(-5, 0, POWER_OPERATOR), DELTA);
        assertEquals(0,
                calculator.calculate(0, 200, POWER_OPERATOR), DELTA);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(5, 10, '!'));
    }

    @Test
    void calculate_twoOperandsAreMaxAndMinValue_isOk() {
        assertEquals(0,
                calculator.calculate(Double.MAX_VALUE,
                        -Double.MAX_VALUE, ADDITION_OPERATOR), DELTA);
        assertEquals(0,
                calculator.calculate(-Double.MAX_VALUE,
                        -Double.MAX_VALUE, SUBTRACTION_OPERATOR), DELTA);
        assertEquals(-1.7976931348623157E308,
                calculator.calculate(-Double.MAX_VALUE,
                        Double.MIN_VALUE, SUBTRACTION_OPERATOR), DELTA);
    }
}
