package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculationImplTest {
    private static Calculation calculation;

    @BeforeAll
    public static void setDefaultValue() {
        calculation = new CalculationImpl();
    }

    @Test
    public void calculate_PositiveAndZeroValue_notOk() {
        Assertions.assertEquals(5,
                calculation.calculate(0, 5, '+'));
        Assertions.assertEquals(-5,
                calculation.calculate(0, 5, '-'));
        Assertions.assertEquals(0,
                calculation.calculate(0, 5, '/'));
        Assertions.assertEquals(0,
                calculation.calculate(0, 5, '*'));
        Assertions.assertEquals(0,
                calculation.calculate(0, 5, '^'));
    }

    @Test
    public void calculate_divideByZero_notOk() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculation.calculate(5, 0, '/'));
    }

    @Test
    public void calculate_maxIntegerValue_NotOk() {
        Assertions.assertEquals((double) Integer.MAX_VALUE + Integer.MAX_VALUE,
                calculation.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '+'));
        Assertions.assertEquals(0,
                calculation.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '-'));
        Assertions.assertEquals(1,
                calculation.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '/'));
        Assertions.assertEquals((double) Integer.MAX_VALUE * Integer.MAX_VALUE,
                calculation.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '*'));
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculation.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '^'));
    }

    @Test
    public void calculate_incorrectSymbol_notOk() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculation.calculate(4, 5, ' '));
    }

    @Test
    public void calculate_correctValue_ok() {
        Assertions.assertEquals(12,
                calculation.calculate(10, 2, '+'));
        Assertions.assertEquals(8,
                calculation.calculate(10, 2, '-'));
        Assertions.assertEquals(5,
                calculation.calculate(10, 2, '/'));
        Assertions.assertEquals(20,
                calculation.calculate(10, 2, '*'));
        Assertions.assertEquals(100,
                calculation.calculate(10, 2, '^'));
    }

    @Test
    public void calculate_negativeAndPositiveValue_ok() {
        Assertions.assertEquals(8,
                calculation.calculate(10, -2, '+'));
        Assertions.assertEquals(12,
                calculation.calculate(10, -2, '-'));
        Assertions.assertEquals(-5,
                calculation.calculate(10, -2, '/'));
        Assertions.assertEquals(-20,
                calculation.calculate(10, -2, '*'));
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculation.calculate(10, -2, '^'));
    }

    @Test
    public void calculate_twoNegativeValue_ok() {
        Assertions.assertEquals(-5,
                calculation.calculate(-3, -2, '+'));
        Assertions.assertEquals(-1,
                calculation.calculate(-3, -2, '-'));
        Assertions.assertEquals(1.5,
                calculation.calculate(-3, -2, '/'));
        Assertions.assertEquals(6,
                calculation.calculate(-3, -2, '*'));
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculation.calculate(-3, -2, '^'));
    }

    @Test
    public void calculate_minIntegerValue_ok() {
        Assertions.assertEquals((double) Integer.MIN_VALUE + Integer.MIN_VALUE,
                calculation.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '+'));
        Assertions.assertEquals(0,
                calculation.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '-'));
        Assertions.assertEquals(1,
                calculation.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '/'));
        Assertions.assertEquals((double) Integer.MIN_VALUE * Integer.MIN_VALUE,
                calculation.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '*'));
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculation.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '^'));
    }
}

