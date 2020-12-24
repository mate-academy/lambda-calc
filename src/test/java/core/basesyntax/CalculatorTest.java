package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final char OPERATION_ADD = '+';
    private static final char OPERATION_SUB = '-';
    private static final char OPERATION_DIV = '/';
    private static final char OPERATION_MUL = '*';
    private static final char OPERATION_POW = '^';
    private static Calculator calculator;
    
    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }
    
    @Test
    public void calculate_addition_OK() {
        assertEquals(1_001_000, calculator.calculate(1_000_000, OPERATION_ADD, 1000));
        assertEquals(444, calculator.calculate(123, OPERATION_ADD, 321));
        assertEquals(-20, calculator.calculate(-10, OPERATION_ADD, -10));
        assertEquals(-90, calculator.calculate(10, OPERATION_ADD, -100));
        assertEquals(90, calculator.calculate(-10, OPERATION_ADD, 100));
        assertEquals(123, calculator.calculate(123, OPERATION_ADD, 0));
        assertEquals(234, calculator.calculate(0, OPERATION_ADD, 234));
        assertEquals(0, calculator.calculate(0, OPERATION_ADD, 0));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                OPERATION_ADD, Double.MAX_VALUE));
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE,
                OPERATION_ADD, Double.MIN_VALUE));
    }
    
    @Test
    public void calculate_subtraction() {
        assertEquals(999_000, calculator.calculate(1_000_000, OPERATION_SUB, 1000));
        assertEquals(-198, calculator.calculate(123, OPERATION_SUB, 321));
        assertEquals(0, calculator.calculate(-10, OPERATION_SUB, -10));
        assertEquals(110, calculator.calculate(10, OPERATION_SUB, -100));
        assertEquals(-110, calculator.calculate(-10, OPERATION_SUB, 100));
        assertEquals(123, calculator.calculate(123, OPERATION_SUB, 0));
        assertEquals(-234, calculator.calculate(0, OPERATION_SUB, 234));
        assertEquals(0, calculator.calculate(0, OPERATION_SUB, 0));
        assertEquals(0, calculator.calculate(Double.MAX_VALUE,
                OPERATION_SUB, Double.MAX_VALUE));
        assertEquals(-100, calculator.calculate(Double.MIN_VALUE,
                OPERATION_SUB, 100));
    }
    
    @Test
    public void calculate_divisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '/', 0));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(234, '/', 0));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(-234, '/', 0));
    }
    
    @Test
    public void calculate_division() {
        assertEquals(1000, calculator.calculate(1_000_000, OPERATION_DIV, 1000));
        assertEquals(3, calculator.calculate(333, OPERATION_DIV, 111));
        assertEquals(1, calculator.calculate(-10, OPERATION_DIV, -10));
        assertEquals(-0.1, calculator.calculate(10, OPERATION_DIV, -100));
        assertEquals(-0.1, calculator.calculate(-10, OPERATION_DIV, 100));
        assertEquals(0, calculator.calculate(0, OPERATION_DIV, 234));
        assertEquals(1, calculator.calculate(Double.MAX_VALUE,
                OPERATION_DIV, Double.MAX_VALUE));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                OPERATION_DIV, Double.MIN_VALUE));
    }
    
    @Test
    public void calculate_multiplication() {
        assertEquals(1_000_000, calculator.calculate(1000, OPERATION_MUL, 1000));
        assertEquals(39483, calculator.calculate(123, OPERATION_MUL, 321));
        assertEquals(100, calculator.calculate(-10, OPERATION_MUL, -10));
        assertEquals(-1000, calculator.calculate(10, OPERATION_MUL, -100));
        assertEquals(-1000, calculator.calculate(-10, OPERATION_MUL, 100));
        assertEquals(0, calculator.calculate(123, OPERATION_MUL, 0));
        assertEquals(0, calculator.calculate(0, OPERATION_MUL, 234));
        assertEquals(0, calculator.calculate(0, OPERATION_MUL, 0));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                OPERATION_MUL, Double.MAX_VALUE));
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE,
                OPERATION_MUL, Double.MIN_VALUE));
    }
    
    @Test
    public void calculate_power() {
        assertEquals(2209, calculator.calculate(47, OPERATION_POW, 2));
        assertEquals(25, calculator.calculate(5, OPERATION_POW, 2));
        assertEquals(0.04, calculator.calculate(-5, OPERATION_POW, -2));
        assertEquals(1_000_000, calculator.calculate(0.001, OPERATION_POW, -2));
        assertEquals(-15625, calculator.calculate(-25, OPERATION_POW, 3));
        assertEquals(1, calculator.calculate(123, OPERATION_POW, 0));
        assertEquals(0, calculator.calculate(0, OPERATION_POW, 6));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                OPERATION_POW, Double.MAX_VALUE));
        assertEquals(1, calculator.calculate(Double.MAX_VALUE,
                OPERATION_POW, Double.MIN_VALUE));
        assertEquals(1, calculator.calculate(Double.MIN_VALUE,
                OPERATION_POW, Double.MIN_VALUE));
    }
    
    @Test
    public void calculate_invalidOperator() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '=', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '$', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '&', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '1', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '_', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 'a', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 'x', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '~', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '_', 10));
    }
}
