package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static CalculatorValidator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculateAddition_Ok() {
        assertEquals(4, calculator.calculate(2, 2, "+"));
        assertEquals(-6, calculator.calculate(-8, 2, "+"));
        assertEquals(-64, calculator.calculate(-34, -30, "+"));
        assertEquals(10, calculator.calculate(10, 0, "+"));
        assertEquals(90, calculator.calculate(0, 90, "+"));
        assertEquals(1.7976931348623157E308,
                calculator.calculate(Double.MAX_VALUE, 120, "+"));
        assertEquals(45.0, calculator.calculate(Double.MIN_VALUE, 45, "+"));
    }

    @Test
    void calculateAddition_NotOk() {
        assertNotEquals(7, calculator.calculate(2, 2, "+"));
        assertNotEquals(-4, calculator.calculate(-8, 2, "+"));
        assertNotEquals(-88, calculator.calculate(-34, -30, "+"));
        assertNotEquals(23, calculator.calculate(10, 0, "+"));
        assertNotEquals(19, calculator.calculate(0, 90, "+"));
        assertNotEquals(1.76931348623157E308,
                calculator.calculate(Double.MAX_VALUE, 120, "+"));
        assertNotEquals(Double.MIN_VALUE + 0.01,
                calculator.calculate(Double.MIN_VALUE, 45, "+"));
    }

    @Test
    void calculateSubtraction_Ok() {
        assertEquals(0, calculator.calculate(8, 8, "-"));
        assertEquals(-10, calculator.calculate(-8, 2, "-"));
        assertEquals(-22, calculator.calculate(-45, -23, "-"));
        assertEquals(40, calculator.calculate(40, 0, "-"));
        assertEquals(-85, calculator.calculate(0, 85, "-"));
        assertEquals(1.7976931348623157E308,
                calculator.calculate(Double.MAX_VALUE, 445, "-"));
        assertEquals(-60.0, calculator.calculate(Double.MIN_VALUE, 60, "-"));
    }

    @Test
    void calculateSubtraction_NotOk() {
        assertNotEquals(5, calculator.calculate(8, 8, "-"));
        assertNotEquals(10, calculator.calculate(-8, 2, "-"));
        assertNotEquals(-28, calculator.calculate(-45, -23, "-"));
        assertNotEquals(56, calculator.calculate(40, 0, "-"));
        assertNotEquals(-855, calculator.calculate(0, 85, "-"));
        assertNotEquals(-1.7976931348623157E308,
                calculator.calculate(Double.MAX_VALUE, 445, "-"));
        assertNotEquals(23, calculator.calculate(Double.MIN_VALUE, 60, "-"));
    }

    @Test
    void calculateDivision_Ok() {
        assertEquals(1, calculator.calculate(20, 20, "/"));
        assertEquals(-3, calculator.calculate(15, -5, "/"));
        assertEquals(5, calculator.calculate(-10, -2, "/"));
        assertEquals(0, calculator.calculate(0, 8, "/"));
        assertEquals(5.3662481637681065E305,
                calculator.calculate(Double.MAX_VALUE, 335, "/"));
        assertEquals(0.0, calculator.calculate(Double.MIN_VALUE, 30, "/"));
    }

    @Test
    void calculateDivision_NotOk() {
        assertNotEquals(45, calculator.calculate(20, 20, "/"));
        assertNotEquals(23, calculator.calculate(15, -5, "/"));
        assertNotEquals(-6, calculator.calculate(-10, -2, "/"));
        assertNotEquals(50, calculator.calculate(0, 8, "/"));
        assertNotEquals(3.3662481637681065E305,
                calculator.calculate(Double.MAX_VALUE, 335, "/"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(5, 0, "/"));
    }

    @Test
    void calculateMultiplication_Ok() {
        assertEquals(64, calculator.calculate(8, 8, "*"));
        assertEquals(-16, calculator.calculate(-8, 2, "*"));
        assertEquals(1035, calculator.calculate(-45, -23, "*"));
        assertEquals(0, calculator.calculate(40, 0, "*"));
        assertEquals(0, calculator.calculate(0, 85, "*"));
        assertEquals(1.0E-323, calculator.calculate(Double.MIN_VALUE, 2, "*"));
    }

    @Test
    void calculateMultiplication_NotOk() {
        assertNotEquals(-20, calculator.calculate(8, 8, "*"));
        assertNotEquals(5, calculator.calculate(-8, 2, "*"));
        assertNotEquals(10, calculator.calculate(-45, -23, "*"));
        assertNotEquals(65, calculator.calculate(40, 0, "*"));
        assertNotEquals(4, calculator.calculate(0, 85, "*"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Double.MAX_VALUE, 4, "*"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(45, Double.MAX_VALUE, "*"));
        assertNotEquals(5, calculator.calculate(Double.MIN_VALUE, 2, "*"));
    }

    @Test
    void calculateRaisingToPower_Ok() {
        assertEquals(1.6777216E7, calculator.calculate(8, 8, "^"));
        assertEquals(64.0, calculator.calculate(-8, 2, "^"));
        assertEquals(0.04, calculator.calculate(-5, -2, "^"));
        assertEquals(6.4E-5, calculator.calculate(5, -6, "^"));
        assertEquals(1.0, calculator.calculate(4, 0, "^"));
        assertEquals(0.0, calculator.calculate(0, 8, "^"));
        assertEquals(1.0, calculator.calculate(-6, 0, "^"));
        assertEquals(0.0, calculator.calculate(Double.MIN_VALUE, 2, "^"));
    }

    @Test
    void calculateRaisingToPower_NotOk() {
        assertNotEquals(5, calculator.calculate(8, 8, "^"));
        assertNotEquals(23, calculator.calculate(-8, 2, "^"));
        assertNotEquals(-5, calculator.calculate(-5, -2, "^"));
        assertNotEquals(5, calculator.calculate(5, -6, "^"));
        assertNotEquals(-3, calculator.calculate(4, 0, "^"));
        assertNotEquals(1, calculator.calculate(0, 8, "^"));
        assertNotEquals(-2, calculator.calculate(-6, 0, "^"));
        assertNotEquals(3, calculator.calculate(Double.MIN_VALUE, 2, "^"));
    }

    @Test
    void calculateOperation_NotOk() {
        assertThrows(NullPointerException.class, () ->
                calculator.calculate(2, 2, null));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(3, 5, ""));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(4, 2, "@"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(4, 7, "&"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(10, 22, "#"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(15, 2, "?"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(3, 3, "!"));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(8, 22, "."));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(1, 9, ","));
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(6, 12, "$"));
    }
}
