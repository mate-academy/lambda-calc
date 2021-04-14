package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION_OPERATOR = '+';
    private static final char SUBTRACTION_OPERATOR = '-';
    private static final char MULTIPLICATION_OPERATOR = '*';
    private static final char DIVISION_OPERATOR = '/';
    private static final char POWER_OPERATOR = '^';
    private static final double DELTA = 0.0001;
    private static final String MESSAGE = "Test passed.";
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionTwoOperands() {
        assertEquals(30,
                calculator.calculate(10, 20, ADDITION_OPERATOR), DELTA, MESSAGE);
        assertEquals(-12.3,
                calculator.calculate(-5, -7.3, ADDITION_OPERATOR), DELTA, MESSAGE);
        assertEquals(5,
                calculator.calculate(-5, 10, ADDITION_OPERATOR), DELTA, MESSAGE);
        assertEquals(234.5,
                calculator.calculate(0, 234.5, ADDITION_OPERATOR), DELTA, MESSAGE);
        assertEquals(126.345,
                calculator.calculate(126.345, 0, ADDITION_OPERATOR), DELTA, MESSAGE);
    }

    @Test
    void subtractionTwoOperands() {
        assertEquals(10,
                calculator.calculate(1110, 1100, SUBTRACTION_OPERATOR), DELTA, MESSAGE);
        assertEquals(0,
                calculator.calculate(-7, -7, SUBTRACTION_OPERATOR), DELTA, MESSAGE);
        assertEquals(-18.5,
                calculator.calculate(-6, 12.5, SUBTRACTION_OPERATOR), DELTA, MESSAGE);
        assertEquals(7,
                calculator.calculate(0, -7, SUBTRACTION_OPERATOR), DELTA, MESSAGE);
        assertEquals(23.78,
                calculator.calculate(23.78, 0, SUBTRACTION_OPERATOR), DELTA, MESSAGE);
    }

    @Test
    void multiplicationTwoOperands() {
        assertEquals(14.64,
                calculator.calculate(2, 7.32, MULTIPLICATION_OPERATOR), DELTA, MESSAGE);
        assertEquals(3,
                calculator.calculate(-1, -3, MULTIPLICATION_OPERATOR), DELTA, MESSAGE);
        assertEquals(-3,
                calculator.calculate(1, -3, MULTIPLICATION_OPERATOR), DELTA, MESSAGE);
        assertEquals(0,
                calculator.calculate(0, 234345.56, MULTIPLICATION_OPERATOR), DELTA, MESSAGE);
        assertEquals(0,
                calculator.calculate(11234.56789, 0, MULTIPLICATION_OPERATOR), DELTA, MESSAGE);
    }

    @Test
    void divisionTwoOperands() {
        assertEquals(4,
                calculator.calculate(16, 4, DIVISION_OPERATOR), DELTA, MESSAGE);
        assertEquals(39.4,
                calculator.calculate(-236.4, -6, DIVISION_OPERATOR), DELTA, MESSAGE);
        assertEquals(685.2173913043478,
                calculator.calculate(236.4, 0.345, DIVISION_OPERATOR), DELTA, MESSAGE);
        assertEquals(0,
                calculator.calculate(0, 2323.6677871, DIVISION_OPERATOR), DELTA, MESSAGE);
    }

    @Test
    void divisionByZero_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(1050.3, 0, DIVISION_OPERATOR), MESSAGE);
    }

    @Test
    void raisingValueToAPower() {
        assertEquals(9,
                calculator.calculate(3, 2, POWER_OPERATOR), DELTA, MESSAGE);
        assertEquals(9,
                calculator.calculate(-3, 2, POWER_OPERATOR), DELTA, MESSAGE);
        assertEquals(0.1111111111111111,
                calculator.calculate(3, -2, POWER_OPERATOR), DELTA, MESSAGE);
        assertEquals(0.1111111111111111,
                calculator.calculate(-3, -2, POWER_OPERATOR), DELTA, MESSAGE);
        assertEquals(1.0,
                calculator.calculate(5, 0, POWER_OPERATOR), DELTA, MESSAGE);
        assertEquals(1.0,
                calculator.calculate(-5, 0, POWER_OPERATOR), DELTA, MESSAGE);
        assertEquals(0,
                calculator.calculate(0, 200, POWER_OPERATOR), DELTA, MESSAGE);
    }

    @Test
    void illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(5, 10, '!'), MESSAGE);
    }

    @Test
    void valuesTooBigOrTooSmall_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Double.MAX_VALUE, 31, ADDITION_OPERATOR));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Double.MIN_VALUE, 0.5, SUBTRACTION_OPERATOR));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Double.MAX_VALUE, 3, MULTIPLICATION_OPERATOR));
    }
}
