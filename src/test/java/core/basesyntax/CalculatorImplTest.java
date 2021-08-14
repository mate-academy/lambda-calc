package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double DELTA = 0.001;
    private CalculatorImpl calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Let's start the tests.");
    }

    @BeforeEach
    void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test
    void addition_bothPositive_Ok() {
        assertEquals(30, calculator.calculate(10, 20, '+'));
        assertEquals(40, calculator.calculate(20, 20, '+'));
    }

    @Test
    void addition_bothNegative_Ok() {
        assertEquals(-30, calculator.calculate(-10, -20, '+'));
        assertEquals(-50, calculator.calculate(-30, -20, '+'));
    }

    @Test
    void addition_positiveAndNegative_Ok() {
        assertEquals(-10, calculator.calculate(10, -20, '+'));
        assertEquals(-10, calculator.calculate(-20, 10, '+'));
    }

    @Test
    void addition_withZero_Ok() {
        assertEquals(10, calculator.calculate(10, 0, '+'));
        assertEquals(10, calculator.calculate(0, 10, '+'));
    }

    @Test
    void addition_minAndMaxDouble_Ok() {
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1, '+'));
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1000, '+'));
        assertEquals(Double.MAX_VALUE, calculator
                .calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+'));
        assertEquals(Double.POSITIVE_INFINITY, calculator
                .calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));

        assertEquals(1, calculator.calculate(Double.MIN_VALUE, 1, '+'));
        assertEquals(1000, calculator.calculate(Double.MIN_VALUE, 1000, '+'));
        assertEquals((Double.MIN_VALUE + Double.MIN_VALUE), calculator
                .calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+'));
    }

    @Test
    void subtraction_bothPositive_Ok() {
        assertEquals(-10, calculator.calculate(10, 20, '-'));
        assertEquals(10.3, calculator.calculate(20.8, 10.5, '-'));
    }

    @Test
    void subtraction_bothNegative_Ok() {
        assertEquals(10, calculator.calculate(-10, -20, '-'));
        assertEquals(-10, calculator.calculate(-30.5, -20.5, '-'));
    }

    @Test
    void subtraction_positiveAndNegative_Ok() {
        assertEquals(30, calculator.calculate(10, -20, '-'));
        assertEquals(-31, calculator.calculate(-20.5, 10.5, '-'));
    }

    @Test
    void subtraction_withZero_Ok() {
        assertEquals(10.5, calculator.calculate(10.5, 0, '-'));
        assertEquals(-10, calculator.calculate(0, 10, '-'));
    }

    @Test
    void subtraction_minAndMaxDouble_Ok() {
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1, '-'));
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1000, '-'));
        assertEquals(Double.MAX_VALUE, calculator
                .calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-'));

        assertEquals(0, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'));

        assertEquals(-1, calculator.calculate(Double.MIN_VALUE, 1, '-'));
        assertEquals(-1000.5, calculator.calculate(Double.MIN_VALUE, 1000.5, '-'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));
    }

    @Test
    void multiplication_bothPositive_Ok() {
        assertEquals(200, calculator.calculate(10, 20, '*'));
        assertEquals(218.4, calculator.calculate(20.8, 10.5, '*'));
    }

    @Test
    void multiplication_bothNegative_Ok() {
        assertEquals(200, calculator.calculate(-10, -20, '*'));
        assertEquals(625.25, calculator.calculate(-30.5, -20.5, '*'));
    }

    @Test
    void multiplication_positiveAndNegative_Ok() {
        assertEquals(-200, calculator.calculate(10, -20, '*'));
        assertEquals(-215.25, calculator.calculate(-20.5, 10.5, '*'));
    }

    @Test
    void multiplication_withZero_Ok() {
        assertEquals(0, calculator.calculate(10.5, 0, '*'));
        assertEquals(0, calculator.calculate(0, 10, '*'));
    }

    @Test
    void multiplication_minAndMaxDouble_Ok() {
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1, '*'));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE, 1000, '*'));
        assertEquals(Double.NEGATIVE_INFINITY, calculator.calculate(Double.MAX_VALUE, -1000, '*'));
        assertEquals((Double.MAX_VALUE * Double.MIN_VALUE), calculator
                .calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*'));

        assertEquals(Double.POSITIVE_INFINITY, calculator
                .calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'));

        assertEquals(Double.MIN_VALUE, calculator.calculate(Double.MIN_VALUE, 1, '*'));
        assertEquals((Double.MIN_VALUE * 1000.5), calculator
                .calculate(Double.MIN_VALUE, 1000.5, '*'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*'));
    }

    @Test
    void division_bothPositive_Ok() {
        assertEquals(0.5, calculator.calculate(10, 20, '/'));
        assertEquals(1.98095, calculator.calculate(20.8, 10.5, '/'), DELTA);
    }

    @Test
    void division_bothNegative_Ok() {
        assertEquals(0.5, calculator.calculate(-10, -20, '/'));
        assertEquals(1.487804, calculator.calculate(-30.5, -20.5, '/'), DELTA);
    }

    @Test
    void division_positiveAndNegative_Ok() {
        assertEquals(-0.5, calculator.calculate(10, -20, '/'));
        assertEquals(-1.9523809, calculator.calculate(-20.5, 10.5, '/'), DELTA);
    }

    @Test
    void division_withZero_Ok() {
        assertEquals(0, calculator.calculate(0, 10, '/'));
        assertEquals(0, calculator.calculate(0, 1000, '/'));
    }

    @Test
    void division_withZero_notOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(10, 0, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(10000, 0, '/'));
    }

    @Test
    void division_minAndMaxDouble_Ok() {
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1, '/'));
        assertEquals((Double.MAX_VALUE / 1000), calculator.calculate(Double.MAX_VALUE, 1000, '/'));
        assertEquals((Double.MAX_VALUE / -1000), calculator
                .calculate(Double.MAX_VALUE, -1000, '/'));
        assertEquals(Double.POSITIVE_INFINITY, calculator
                .calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/'));

        assertEquals(1, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));

        assertEquals(Double.MIN_VALUE, calculator.calculate(Double.MIN_VALUE, 1, '/'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, 1000.5, '/'));
        assertEquals(1, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/'));
    }

    @Test
    void raising_positivePower_Ok() {
        assertEquals(100, calculator.calculate(10, 2, '^'));
        assertEquals(100, calculator.calculate(-10, 2, '^'));
        assertEquals(15807.164198, calculator.calculate(5.8, 5.5, '^'), DELTA);
    }

    @Test
    void raising_negativePower_Ok() {
        assertEquals(0.01, calculator.calculate(10, -2, '^'));
        assertEquals(0.01, calculator.calculate(-10, -2, '^'));
        assertEquals(0.0297265, calculator.calculate(5.8, -2, '^'), DELTA);
    }

    @Test
    void raising_zeroPower_Ok() {
        assertEquals(1, calculator.calculate(10, 0, '^'));
        assertEquals(1, calculator.calculate(-20.5, 0, '^'));
    }

    @Test
    void raising_zeroToPower_Ok() {
        assertEquals(0, calculator.calculate(0, 10, '^'));
        assertEquals(0, calculator.calculate(0, 1000, '^'));
    }

    @Test
    void raising_minAndMaxDouble_Ok() {
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1, '^'));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE, 1000, '^'));
        assertEquals(0, calculator.calculate(Double.MAX_VALUE, -1000, '^'));
        assertEquals(1, calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '^'));

        assertEquals(Double.POSITIVE_INFINITY, calculator
                .calculate(Double.MAX_VALUE, Double.MAX_VALUE, '^'));

        assertEquals(Double.MIN_VALUE, calculator.calculate(Double.MIN_VALUE, 1, '^'));
        assertEquals(0, calculator.calculate(Double.MIN_VALUE, 1000.5, '^'));
        assertEquals(1, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '^'));
    }

    @Test
    void illegalOperation_Ok() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 2, 'r'));
        assertThrows(RuntimeException.class, () -> calculator
                .calculate(1, Double.parseDouble(new String()), '+'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 2, '3'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 2, '%'));
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tests are completed.");
    }
}
