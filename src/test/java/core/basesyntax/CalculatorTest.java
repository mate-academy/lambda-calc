package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.000001;
    Calculator calculator = new Calculator();

    @Test
    void additionTests_Ok() {
        assertEquals(70, calculator.calculate(50, 20, "+"), DELTA);
        assertEquals(-140.5, calculator.calculate(-25.5, -115, "+"), DELTA);
        assertEquals(4.37, calculator.calculate(5.35, -0.98, "+"), DELTA);
        assertEquals(-129, calculator.calculate(0, -129, "+"), DELTA);
        assertEquals(10025, calculator.calculate(10025, 0, "+"), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(
                Double.MAX_VALUE, Double.MAX_VALUE, "+"), DELTA);
    }

    @Test
    void subtractionTests_Ok() {
        assertEquals(30, calculator.calculate(50, 20, "-"), DELTA);
        assertEquals(89.5, calculator.calculate(-25.5, -115, "-"), DELTA);
        assertEquals(6.33, calculator.calculate(5.35, -0.98, "-"), DELTA);
        assertEquals(129, calculator.calculate(0, -129, "-"), DELTA);
        assertEquals(10025, calculator.calculate(10025, 0, "-"), DELTA);
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, "-"), DELTA);

    }

    @Test
    void multiplicationTests_Ok() {
        assertEquals(1000, calculator.calculate(50, 20, "*"), DELTA);
        assertEquals(75, calculator.calculate(-5, -15, "*"), DELTA);
        assertEquals(-10.7, calculator.calculate(5.35, -2, "*"), DELTA);
        assertEquals(0, calculator.calculate(0, -129, "*"), DELTA);
        assertEquals(0, calculator.calculate(10025, 0, "*"), DELTA);
    }

    @Test
    void divisionTests_Ok() {
        assertEquals(2.5, calculator.calculate(50, 20, "/"), DELTA);
        assertEquals(25, calculator.calculate(-50, -2, "/"), DELTA);
        assertEquals(-5.333333, calculator.calculate(16, -3, "/"), DELTA);
        assertEquals(0, calculator.calculate(0, -129, "/"), DELTA);
    }

    @Test
    void divisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, "/"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(120, 0, "/"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(-190, 0, "/"));
    }

    @Test
    void powerTest_Ok() {
        assertEquals(4, calculator.calculate(2, 2, "^"), DELTA);
        assertEquals(0.04, calculator.calculate(5, -2, "^"), DELTA);
        assertEquals(-100000, calculator.calculate(-10, 5, "^"), DELTA);
        assertEquals(0.87055, calculator.calculate(2, -0.2, "^"), DELTA);
        assertEquals(0.00390625, calculator.calculate(0.5, 8, "^"), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(
                Double.MAX_VALUE, Double.MAX_VALUE, "^"), DELTA);
    }

    void invalidOperators() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "&"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "|"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "="));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "?"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "."));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, ","));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "!"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "#"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "@"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, "("));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(1, 1, ")"));
    }
}
