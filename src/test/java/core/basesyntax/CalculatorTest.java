package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    public static final char OPERATION_ADD = '+';
    public static final char OPERATION_SUB = '-';
    public static final char OPERATION_DIV = '/';
    public static final char OPERATION_MUL = '*';
    public static final char OPERATION_POW = '^';
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    void calculate_addition() {
        assertEquals(0.1005, calculator.calculate(0.1, OPERATION_ADD, 0.0005));
        assertEquals(0, calculator.calculate(10, OPERATION_ADD, -10));
        assertEquals(444, calculator.calculate(123, OPERATION_ADD, 321));
        assertEquals(1_001_000, calculator.calculate(1_000_000, OPERATION_ADD, 1000));
        assertEquals(49, calculator.calculate(47, OPERATION_ADD, 2));
    }
    
    @Test
    void calculate_subtraction() {
        assertEquals(0.0995, calculator.calculate(0.1, OPERATION_SUB, 0.0005));
        assertEquals(20, calculator.calculate(10, OPERATION_SUB, -10));
        assertEquals(-198, calculator.calculate(123, OPERATION_SUB, 321));
        assertEquals(999_000, calculator.calculate(1_000_000, OPERATION_SUB, 1000));
        assertEquals(45, calculator.calculate(47, OPERATION_SUB, 2));
    }
    
    @Test
    void calculate_division() {
        assertEquals(200, calculator.calculate(0.1, OPERATION_DIV, 0.0005));
        assertEquals(-1, calculator.calculate(10, OPERATION_DIV, -10));
        assertEquals(41, calculator.calculate(123, OPERATION_DIV, 3));
        assertEquals(1000, calculator.calculate(1_000_000, OPERATION_DIV, 1000));
        assertEquals(23.5, calculator.calculate(47, OPERATION_DIV, 2));
    }
    
    @Test
    void calculate_multiplication() {
        assertEquals(0.5, calculator.calculate(0.1, OPERATION_MUL, 5));
        assertEquals(-100, calculator.calculate(10, OPERATION_MUL, -10));
        assertEquals(42435, calculator.calculate(123, OPERATION_MUL, 345));
        assertEquals(1_000_000, calculator.calculate(1000, OPERATION_MUL, 1000));
        assertEquals(94, calculator.calculate(47, OPERATION_MUL, 2));
    }
    
    @Test
    void calculate_power() {
        assertEquals(0.25, calculator.calculate(0.5, OPERATION_POW, 2));
        assertEquals(1_000_000, calculator.calculate(0.001, OPERATION_POW, -2));
        assertEquals(1860867, calculator.calculate(123, OPERATION_POW, 3));
        assertEquals(1_000_000, calculator.calculate(10, OPERATION_POW, 6));
        assertEquals(2209, calculator.calculate(47, OPERATION_POW, 2));
    }
    
    @Test
    void calculate_invalidOperator() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '=', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '$', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '&', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '1', 10));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '_', 10));
    }
    
    @Test
    void calculate_divisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, '/', 0));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(234, '/', 0));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(-234, '/', 0));
    }
}
