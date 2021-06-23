package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.DoubleBinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionTwoElements_Ok() {
        assertEquals(15.8,
                calculator.calculate(5, 10.8, '+'), DELTA);
        assertEquals(3.4,
                calculator.calculate(0, 3.4, '+'), DELTA);
        assertEquals(-13.2,
                calculator.calculate(-7.6, -5.6, '+'), DELTA);
        assertEquals(256.3428,
                calculator.calculate(111.077, 145.2658, '+'), DELTA);
        assertEquals(29.56,
                calculator.calculate(29.56, 0, '+'), DELTA);
        assertEquals(7,
                calculator.calculate(-3, 10, '+'), DELTA);

    }

    @Test
    void subtractionTwoElements_Ok() {
        assertEquals(0,
                calculator.calculate(13.6, 13.6, '-'), DELTA);
        assertEquals(-434.55,
                calculator.calculate(-285.69, 148.86, '-'), DELTA);
        assertEquals(17,
                calculator.calculate(17, 0, '-'), DELTA);
        assertEquals(76.45123,
                calculator.calculate(152.61352, 76.16229, '-'), DELTA);
        assertEquals(-18.29,
                calculator.calculate(0, 18.29, '-'), DELTA);
        assertEquals(-76.0,
                calculator.calculate(-185, -109, '-'), DELTA);
    }

    @Test
    void divisionTwoElements_Ok() {
        assertEquals(8,
                calculator.calculate(32, 4, '/'), DELTA);
        assertEquals(0,
                calculator.calculate(0, 127.23, '/'), DELTA);
        assertEquals(18.3,
                calculator.calculate(36.6, 2, '/'), DELTA);
        assertEquals(13.65,
                calculator.calculate(13.65, 1, '/'), DELTA);
        assertEquals(-9,
                calculator.calculate(-81, 9, '/'), DELTA);
        assertEquals(79,
                calculator.calculate(1896, 24, '/'), DELTA);
    }

    @Test
    void divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(342.56, 0, '/'));
    }

    @Test
    void multiplicationTwoElements_Ok() {
        assertEquals(4454.9726,
                calculator.calculate(156.26, 28.51, '*'), DELTA);
        assertEquals(64.4,
                calculator.calculate(32.2, 2, '*'), DELTA);
        assertEquals(0,
                calculator.calculate(987.12, 0, '*'), DELTA);
        assertEquals(12,
                calculator.calculate(-4, -3, '*'), DELTA);
        assertEquals(-36,
                calculator.calculate(-9, 4, '*'), DELTA);
        assertEquals(0,
                calculator.calculate(0, 245.84, '*'), DELTA);
    }

    @Test
    void raisingToAPowerValue() {
        assertEquals(8,
                calculator.calculate(2, 3, '^'), DELTA);
        assertEquals(1.0,
                calculator.calculate(125, 0, '^'), DELTA);
        assertEquals(0,
                calculator.calculate(0, 5, '^'), DELTA);
        assertEquals(1.0,
                calculator.calculate(-7, 0, '^'), DELTA);
        assertEquals(729,
                calculator.calculate(9, 3, '^'), DELTA);
        assertEquals(28561,
                calculator.calculate(13, 4, '^'), DELTA);
    }

    @Test
    void illigalOperation_NotOk() {
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(15, 2.3, '?'));
    }

    @Test
    void twoElementsAreMaxAndMinValue() {
        assertEquals(0,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'), DELTA);
        assertEquals(0,
                calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '+'), DELTA);
    }
}