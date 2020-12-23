package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.InvalidOperatorException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISE_TO_POWER = '^';
    private static final char INVALID_OPERATOR = '1';
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addition_DifferentParameters_Ok() {
        assertEquals(46, calculator.calculate(13, 33, ADDITION));
        assertEquals(-22, calculator.calculate(22, -44, ADDITION));
        assertEquals(-66, calculator.calculate(-22, -44, ADDITION));
        assertEquals(-44, calculator.calculate(0, -44, ADDITION));
        assertEquals(55, calculator.calculate(55, 0, ADDITION));
        assertEquals(1.7976931348623157E308,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADDITION));
    }

    @Test
    void addition_DifferentParameters_NotOk() {
        assertNotEquals(436, calculator.calculate(135, 337, ADDITION));
        assertNotEquals(-222, calculator.calculate(223, -4434, ADDITION));
        assertNotEquals(-66, calculator.calculate(-22, -844, ADDITION));
        assertNotEquals(-44, calculator.calculate(0, -444, ADDITION));
        assertNotEquals(545, calculator.calculate(55, 20, ADDITION));
        assertNotEquals(1.79227693134863157E308,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, ADDITION));
    }

    @Test
    void subtract_DifferentParameters_Ok() {
        assertEquals(33, calculator.calculate(55, 22, SUBTRACTION));
        assertEquals(34, calculator.calculate(-64, -98, SUBTRACTION));
        assertEquals(153, calculator.calculate(87, -66, SUBTRACTION));
        assertEquals(-654, calculator.calculate(0, 654, SUBTRACTION));
        assertEquals(546, calculator.calculate(546, 0, SUBTRACTION));
        assertEquals(-1.7976931348623157E308,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void subtract_DifferentParameters_NotOk() {
        assertNotEquals(54, calculator.calculate(56, 22, SUBTRACTION));
        assertNotEquals(87, calculator.calculate(-64, -654, SUBTRACTION));
        assertNotEquals(343, calculator.calculate(65, -23, SUBTRACTION));
        assertNotEquals(-675, calculator.calculate(0, 76, SUBTRACTION));
        assertNotEquals(57634, calculator.calculate(546, 0, SUBTRACTION));
        assertNotEquals(-1.127976933157E308,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void division_DifferentParameters_Ok() {
        assertEquals(2, calculator.calculate(8, 4, DIVISION));
        assertEquals(7.588235294117647, calculator.calculate(-258, -34, DIVISION));
        assertEquals(-58, calculator.calculate(-232, 4, DIVISION));
        assertEquals(0.0, calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION));
        assertThrows(ArithmeticException.class, ()
                -> calculator.calculate(232, 0, DIVISION));
    }

    @Test
    void division_DifferentParameters_NotOk() {
        assertNotEquals(23, calculator.calculate(843, 41, DIVISION));
        assertNotEquals(7.58894117647, calculator.calculate(-413, -67, DIVISION));
        assertNotEquals(-58, calculator.calculate(-342, 235, DIVISION));
        assertNotEquals(1354, calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, DIVISION));
    }

    @Test
    void multiplication_DifferentParameters_Ok() {
        assertEquals(8, calculator.calculate(2, 4, MULTIPLICATION));
        assertEquals(5412, calculator.calculate(-123, -44, MULTIPLICATION));
        assertEquals(15042, calculator.calculate(23, 654, MULTIPLICATION));
        assertEquals(0, calculator.calculate(24214, 0, MULTIPLICATION));
        assertEquals(0, calculator.calculate(0, 5432, MULTIPLICATION));
        assertEquals(8.881784197001251E-16,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void multiplication_DifferentParameters_NotOk() {
        assertNotEquals(438, calculator.calculate(2, 4, MULTIPLICATION));
        assertNotEquals(32, calculator.calculate(-123, -44, MULTIPLICATION));
        assertNotEquals(343, calculator.calculate(23, 654, MULTIPLICATION));
        assertNotEquals(23, calculator.calculate(24214, 0, MULTIPLICATION));
        assertNotEquals(34, calculator.calculate(0, 5432, MULTIPLICATION));
        assertNotEquals(82.88178001251E-16,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void raisingPower_DifferentParameters_Ok() {
        assertEquals(1.1688200277601E13, calculator.calculate(43, 8, RAISE_TO_POWER));
        assertEquals(-128, calculator.calculate(-2, 7, RAISE_TO_POWER));
        assertEquals(9.391435011269723E-5, calculator.calculate(22, -3, RAISE_TO_POWER));
        assertEquals(0.25, calculator.calculate(-2, -2, RAISE_TO_POWER));
        assertEquals(1, calculator.calculate(2, 0, RAISE_TO_POWER));
        assertEquals(1, calculator.calculate(-2, 0, RAISE_TO_POWER));
    }

    @Test
    void raisingPower_DifferentParameters_NotOk() {
        assertNotEquals(1.1277601E13, calculator.calculate(43, 8, RAISE_TO_POWER));
        assertNotEquals(-1228, calculator.calculate(-2, 7, RAISE_TO_POWER));
        assertNotEquals(9.35011269723E-5, calculator.calculate(22, -3, RAISE_TO_POWER));
        assertNotEquals(0.2522, calculator.calculate(-2, -2, RAISE_TO_POWER));
        assertNotEquals(112, calculator.calculate(2, 0, RAISE_TO_POWER));
        assertNotEquals(143, calculator.calculate(-2, 0, RAISE_TO_POWER));
    }

    @Test
    void illegalOperation_ThrowsException() {
        assertThrows(InvalidOperatorException.class, ()
                -> calculator.calculate(0, 3, INVALID_OPERATOR));
    }
}
