package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;

    @Test
    void testSum_Ok() {
        Double actual = Calculator.calculate(10d, 20d, '+');
        assertEquals(30d, actual, DELTA);
        actual = Calculator.calculate(-10d, 20d, '+');
        assertEquals(10d, actual, DELTA);
    }

    @Test
    void testSum_Null() {
        Double a = null;
        assertThrows(NullPointerException.class, () -> {
            Calculator.calculate(a, 3d, '+');
        });
    }

    @Test
    void testDiff_Ok() {
        Double actual = Calculator.calculate(3d, 5d, '-');
        assertEquals(-2d, actual, DELTA);
        actual = Calculator.calculate(-5d, -10d, '-');
        assertEquals(5d, actual, DELTA);
    }

    @Test
    void testDiff_null() {
        Double b = null;
        assertThrows(NullPointerException.class, () -> {
            Calculator.calculate(-10d, b, '-');
        });
    }

    @Test
    void testMultiply_Ok() {
        Double actual = Calculator.calculate(5d, -3d, '*');
        assertEquals(-15d, actual, DELTA);
        actual = Calculator.calculate(-3d, -12d, '*');
        assertEquals(36d, actual, DELTA);
    }

    @Test
    void testMultiply_Null() {
        Double a = null;
        assertThrows(NullPointerException.class, () -> {
            Calculator.calculate(a, 10d, '*');
        });
    }

    @Test
    void testDividing_Ok() {
        Double actual = Calculator.calculate(10d, -3d, '/');
        assertEquals(-3.3333, actual, DELTA);
    }

    @Test
    void testDividing_Null() {
        Double a = null;
        assertThrows(NullPointerException.class, () -> {
            Calculator.calculate(a, 5d, '/');
        });
    }

    @Test
    void testDividingByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(10d, 0d, '/');
        });
    }

    @Test
    void testPow_Ok() {
        Double actual = Calculator.calculate(10d, 2d, '^');
        assertEquals(100d, actual, DELTA);
        actual = Calculator.calculate(100d, 0.5, '^');
        assertEquals(10d, actual, DELTA);
        actual = Calculator.calculate(100d, 0.0, '^');
        assertEquals(1.0, actual, DELTA);
    }

    @Test
    void testPow_getNan() {
        Double actual = Calculator.calculate(-4d, 0.5, '^');
        assertEquals(Double.NaN, actual, DELTA);
    }

    @Test
    void testPow_Null() {
        Double a = null;
        assertThrows(NullPointerException.class, () -> {
            Calculator.calculate(a, 10d, '^');
        });
    }

    @Test
    void testPow_NotOk() {
        Double actual = Calculator.calculate(5d, 3d, '^');
        assertNotEquals(225d, actual, DELTA);
    }

    @Test
    void testWrongOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(3d, 5d, '\\');
        });
    }
}
