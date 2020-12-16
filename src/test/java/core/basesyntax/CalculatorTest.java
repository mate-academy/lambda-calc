package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void operation_notOk() {
        assertThrows(IncorrectOperationException.class, () -> calculator.calculate(5,7,"n"));
        assertThrows(IncorrectOperationException.class, () -> calculator.calculate(6,8,"!"));
        assertThrows(IncorrectOperationException.class, () -> calculator.calculate(9,82,"+++"));
        assertThrows(IncorrectOperationException.class, () -> calculator.calculate(3,7,"/7"));
        assertThrows(IncorrectOperationException.class, () -> calculator.calculate(0,0," "));
        assertThrows(NullPointerException.class, () -> calculator.calculate(7,7,null));
    }

    @Test
    void addition_numbers_Ok() {
        assertEquals(8.0, calculator.calculate(2, 6, "+"));
        assertEquals(80.0, calculator.calculate(79, 1, "+"));
        assertEquals(2.14748422E9, calculator.calculate(Integer.MAX_VALUE, 573, "+"));
    }

    @Test
    void adding_numbers_notOk() {
        assertNotEquals(-2.0, calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, "+"));
        assertNotEquals(5.0, calculator.calculate(2, 2, "+"));
    }

    @Test
    void subtraction_numbers_Ok() {
        assertEquals(0.0, calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, "-"));
        assertEquals(-4.294967295E9, calculator.calculate(Integer.MIN_VALUE, Integer.MAX_VALUE, "-"));
        assertEquals(5.0, calculator.calculate(20, 15, "-"));
    }

    @Test
    void subtraction_numbers_notOk() {
        assertNotEquals(1.0, calculator.calculate(Integer.MIN_VALUE, Integer.MAX_VALUE, "-"));
        assertNotEquals(1.0, calculator.calculate(50, 50, "-"));
    }

    @Test
    void division_numbers_Ok() {
        double divisionResult1 = 0.5;
        double divisionResult2 = 0.1;
        double divisionResult3 = 8.0;
        assertEquals(divisionResult1, calculator.calculate(8, 16, "/"));
        assertEquals(divisionResult2, calculator.calculate(5, 50, "/"));
        assertEquals(divisionResult3, calculator.calculate(24, 3, "/"));
    }

    @Test
    void division_numbers_notOk() {
        double divisionResult1 = 0.0;
        double divisionResult2 = 1.20;
        double divisionResult3 = 6.0;
        double divisionResult4 = 2.0;
        assertNotEquals(divisionResult1, calculator.calculate(5, 5, "/"));
        assertNotEquals(divisionResult2, calculator.calculate(5, 4, "/"));
        assertNotEquals(divisionResult3, calculator.calculate(25, 4, "/"));
        assertNotEquals(divisionResult4, calculator.calculate(10, 4, "/"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(7,0,"/"));
    }

    @Test
    void multiplication_numbers_Ok() {
        assertEquals(4.6116860141324206E18, calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, "*"));
        assertEquals(0.0, calculator.calculate(Integer.MAX_VALUE, 0, "*"));
        assertEquals(6.0, calculator.calculate(2, 3, "*"));
        assertEquals(-5.0, calculator.calculate(1, -5, "*"));
        assertEquals(1.0, calculator.calculate(1, 1, "*"));
    }

    @Test
    void multiplication_numbers_notOk() {
        assertNotEquals(Integer.MAX_VALUE, calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, "*"));
        assertNotEquals(1.0, calculator.calculate(Integer.MAX_VALUE, 0, "*"));
        assertNotEquals(10.0, calculator.calculate(5, 5, "*"));
        assertNotEquals(0.0, calculator.calculate(1, 1, "*"));
    }

    @Test
    void raisingToAPower_Ok() {
        assertEquals(16.0, calculator.calculate(2,4, "^"));
        assertEquals(4.0, calculator.calculate(4,1, "^"));
        assertEquals(0.25, calculator.calculate(2,-2, "^"));
        assertEquals(1.0, calculator.calculate(Integer.MAX_VALUE,0, "^"));
        assertEquals(1.0, calculator.calculate(Integer.MIN_VALUE,0, "^"));
    }

    @Test
    void raisingToAPower_notOk() {
        assertNotEquals(8.0, calculator.calculate(2,2, "^"));
        assertNotEquals(1.0, calculator.calculate(4,1, "^"));
        assertNotEquals(0.0, calculator.calculate(Integer.MAX_VALUE,0, "^"));
    }
}