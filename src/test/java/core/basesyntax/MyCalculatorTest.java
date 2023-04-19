package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class MyCalculatorTest {
    private static final MyCalculator calculator = new MyCalculator();
    private static final double DELTA = 0.0001;
    private double actual;
    private double expected;

    // 1. ADDITION
    @Test
    void additionPositiveOperands_Ok() {
        actual = calculator.calculate(17, 102.99999, '+');
        expected = 119.99999;
        assertEquals(expected, actual);

        actual = calculator.calculate(0.5, 0.5, '+');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(12_345, 87_655, '+');
        expected = 100_000;
        assertEquals(expected, actual);
    }

    @Test
    void additionNegativeOperands_Ok() {
        actual = calculator.calculate(-17, -102.99999, '+');
        expected = -119.99999;
        assertEquals(expected, actual);

        actual = calculator.calculate(-0.1, -0.1, '+');
        expected = -0.2;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100_000, -200_000, '+');
        expected = -300_000;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(100, -200, '+');
        expected = -100;
        assertEquals(expected, actual);

        actual = calculator.calculate(100, -30, '+');
        expected = 70;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100, 200, '+');
        expected = 100;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100, 30, '+');
        expected = -70;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(0, 0, '+');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(100_000, 0, '+');
        expected = 100_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 100_000, '+');
        expected = 100_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100_000, 0, '+');
        expected = -100_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, -100_000, '+');
        expected = -100_000;
        assertEquals(expected, actual);
    }

    @Test
    void additionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        expected = 2 * Double.MIN_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, -1.1, '+');
        expected = -1.1;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, 1.1, '+');
        expected = 1.1;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -100_000, '+');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, 1, '+');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '+');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '+');
        expected = 0;
        assertEquals(expected, actual);
    }

    // 2. SUBTRACTION
    @Test
    void subtractionPositiveOperands_Ok() {
        actual = calculator.calculate(5.5, 2.2, '-');
        expected = 3.3;
        assertEquals(expected, actual);

        actual = calculator.calculate(0.5, 0.5, '-');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(12_345, 87_655, '-');
        expected = -75_310;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionNegativeOperands_Ok() {
        actual = calculator.calculate(-10, -100.99999, '-');
        expected = 90.99999;
        assertEquals(expected, actual);

        actual = calculator.calculate(-0.1, -0.1, '-');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(100, -200, '-');
        expected = 300;
        assertEquals(expected, actual);

        actual = calculator.calculate(100, -30, '-');
        expected = 130;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100, 200, '-');
        expected = -300;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100, 30, '-');
        expected = -130;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(0, 0, '-');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(100_000, 0, '-');
        expected = 100_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 100_000, '-');
        expected = -100_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100_000, 0, '-');
        expected = -100_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, -100_000, '-');
        expected = 100_000;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, -1.1, '-');
        expected = 1.1;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, 1.1, '-');
        expected = -1.1;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, 100, '-');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -1.1, '-');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '-');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    // 3. MULTIPLICATION
    @Test
    void multiplicationPositiveOperands_Ok() {
        actual = calculator.calculate(5.5, 2.2, '*');
        expected = 12.1;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0.5, 0.5, '*');
        expected = 0.25;
        assertEquals(expected, actual);

        actual = calculator.calculate(12_345, 87_655, '*');
        expected = 1_082_100_975;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationNegativeOperands_Ok() {
        actual = calculator.calculate(-17, -102.99999, '*');
        expected = 1_750.99983;
        assertEquals(expected, actual);

        actual = calculator.calculate(-0.1, -0.1, '*');
        expected = 0.01;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(100, -200, '*');
        expected = -20_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(100, -30, '*');
        expected = -3_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100, 200, '*');
        expected = -20_000;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100, 30, '*');
        expected = -3_000;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(0, 0, '*');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(100_000, 0, '*');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 100_000, '*');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100_000, 0, '*');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, -100_000, '*');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        expected = 8.881784197001251E-16;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, -1, '*');
        expected = -Double.MIN_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, 1, '*');
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, 2, '*');
        expected = 1.0E-323;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, -4, '*');
        expected = -2.0E-323;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, 10, '*');
        expected = 5.0E-323;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, 1, '*');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, 1.1, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, 100, '*');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -1.1, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -100, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '*');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    // 4. DIVISION
    @Test
    void divisionPositiveOperands_Ok() {
        actual = calculator.calculate(8.4, 2.1, '/');
        expected = 4;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(0.5, 0.5, '/');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(3, 9, '/');
        expected = 0.3333333;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionNegativeOperands_Ok() {
        actual = calculator.calculate(-50.5, -10.1, '/');
        expected = 5;
        assertEquals(expected, actual);

        actual = calculator.calculate(-0.5, -0.25, '/');
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        actual = calculator.calculate(100, -200, '/');
        expected = -0.5;
        assertEquals(expected, actual);

        actual = calculator.calculate(100, -30, '/');
        expected = -3.33333;
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(-100, 200, '/');
        expected = -0.5;
        assertEquals(expected, actual);

        actual = calculator.calculate(-100, 30, '/');
        expected = -3.33333;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroInDifferentPlaces_Ok() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, '/'));

        assertThrows(ArithmeticException.class, () -> calculator.calculate(100, 0, '/'));

        assertThrows(ArithmeticException.class, () -> calculator.calculate(-100, 0, '/'));

        actual = calculator.calculate(0, 100_000, '/');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, -100_000, '/');
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZeroInDifferentPlaces_NotOk() {
        try {
            actual = calculator.calculate(100, 0, '/');
            fail("ArithmeticException should be thrown!");
        } catch (ArithmeticException e) {
            // ok
        } catch (Exception e) {
            fail("Wrong exception! ArithmeticException should be thrown!");
        }

        try {
            actual = calculator.calculate(0, 100_000, '/');
            expected = 100_000;
            assertNotEquals(expected, actual);
        } catch (ArithmeticException e) {
            fail("ArithmeticException shouldn't be thrown! Must be 0");
        }

        actual = calculator.calculate(0, -100_000, '/');
        expected = -100_000;
        assertNotEquals(expected, actual);
    }

    @Test
    void divisionForMinAndMaxDoubleValues_Ok() {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -1, '/');
        expected = -Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, 1, '/');
        expected = Double.MAX_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, -1, '/');
        expected = -Double.MIN_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, 1, '/');
        expected = Double.MIN_VALUE;
        assertEquals(expected, actual);

        actual = calculator.calculate(10, Double.MIN_VALUE, '/');
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(-10, Double.MIN_VALUE, '/');
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '/');
        expected = -1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '/');
        expected = -1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '/');
        expected = -1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-Double.MIN_VALUE, Double.MIN_VALUE, '/');
        expected = -1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-Double.MIN_VALUE, -Double.MIN_VALUE, '/');
        expected = 1;
        assertEquals(expected, actual);
    }

    // 5. RAISING TO POWER
    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        actual = calculator.calculate(1, 1, '^');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(2, 1, '^');
        expected = 2;
        assertEquals(expected, actual);

        actual = calculator.calculate(2, 2, '^');
        expected = 4;
        assertEquals(expected, actual);

        actual = calculator.calculate(10, 5, '^');
        expected = 100_000;
        assertEquals(expected, actual);
    }

    @Test
    void raisingPositiveValueToThePositivePower_NotOk() {
        actual = calculator.calculate(1, 1, '^');
        expected = 0;
        assertNotEquals(expected, actual);

        actual = calculator.calculate(2, 1, '^');
        expected = 1;
        assertNotEquals(expected, actual);

        actual = calculator.calculate(2, 2, '^');
        expected = 2;
        assertNotEquals(expected, actual);

        actual = calculator.calculate(10, 5, '^');
        expected = 10;
        assertNotEquals(expected, actual);

        actual = calculator.calculate(10, 5, '^');
        expected = 50;
        assertNotEquals(expected, actual);

        actual = calculator.calculate(10, 5, '^');
        expected = 10_000;
        assertNotEquals(expected, actual);

        actual = calculator.calculate(10, 5, '^');
        expected = 1_000_000;
        assertNotEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        actual = calculator.calculate(-1, 1, '^');
        expected = -1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-2, 1, '^');
        expected = -2;
        assertEquals(expected, actual);

        actual = calculator.calculate(-2, 2, '^');
        expected = 4;
        assertEquals(expected, actual);

        actual = calculator.calculate(-10, 5, '^');
        expected = -100_000;
        assertEquals(expected, actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        actual = calculator.calculate(-1, 0, '^');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-2, 0, '^');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-10, 0, '^');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(-10_000_000, 0, '^');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        actual = calculator.calculate(0, 0, '^');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 1, '^');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 2, '^');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(0, 5, '^');
        expected = 0;
        assertEquals(expected, actual);
    }

    // 6. ILLEGAL OPERATION
    @Test
    void illegalOperation_Ok() {
        actual = calculator.calculate(1, 1, '+');
        expected = 2;
        assertEquals(expected, actual);

        actual = calculator.calculate(1, 1, '-');
        expected = 0;
        assertEquals(expected, actual);

        actual = calculator.calculate(1, 1, '*');
        expected = 1;
        assertEquals(expected, actual);

        actual = calculator.calculate(1, 1, '/');
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 1, '$'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 1, '%'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 1, ' '));
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 1, '1'));
    }
}
