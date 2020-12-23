package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final Calculator calculator = new Calculator();

    @Test
    void addingOperationTest() {
        assertEquals(3, calculator.calculate(1,2, '+'));
        assertEquals(1.9, calculator.calculate(2.4, -0.5, '+'));
        assertEquals(-11, calculator.calculate(-5, -6, '+'));
        assertEquals(0, calculator.calculate(0, 0, '+'));
    }

    @Test
    void subtractionOperationTest() {
        assertEquals(0, calculator.calculate(1,1, '-'));
        assertEquals(2.9, calculator.calculate(2.4, -0.5, '-'));
        assertEquals(1, calculator.calculate(-5, -6, '-'));
        assertEquals(-7.7, calculator.calculate(-2.7, 5, '-'));
    }

    @Test
    void multiplicationOperationTest() {
        assertEquals(1, calculator.calculate(1,1, '*'));
        assertEquals(-1.2, calculator.calculate(2.4, -0.5, '*'));
        assertEquals(30, calculator.calculate(-5, -6, '*'));
        assertEquals(-13.5, calculator.calculate(-2.7, 5, '*'));
    }

    @Test
    void divisionOperationTest() {
        assertEquals(1, calculator.calculate(1,1, '/'));
        assertEquals(0.5, calculator.calculate(-2, -4, '/'));
        assertEquals(-12, calculator.calculate(2.4, -0.2, '/'));
        assertEquals(-0.4, calculator.calculate(-2, 5, '/'));
        assertEquals(-0.4, calculator.calculate(-2, 5, '/'));
    }

    @Test
    void powerOperationTest() {
        assertEquals(4, calculator.calculate(2,2, 'p'));
        assertEquals(0.00032, calculator.calculate(5,-5, 'p'));
        assertEquals(625, calculator.calculate(-5,4, 'P'));
        assertEquals(1024, calculator.calculate(2,10, 'P'));

    }

    @Test
    void mistakesTest() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-2, 0, '/');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(-2, 0, 's');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(-2, 0, '2');
        });
    }
}
