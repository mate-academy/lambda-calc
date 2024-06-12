package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void additionWithTwoPositiveOperands() {
        double actual = calculator.calculate(2,2, "+");
        assertEquals(4,actual);
        actual = calculator.calculate(5,2, "+");
        assertEquals(7,actual);
        actual = calculator.calculate(1,2, "+");
        assertEquals(3,actual);
    }

    @Test
    void additionWithTwoNegativeOperands() {
        double actual = calculator.calculate(-2,-2, "+");
        assertEquals(-4,actual);
        actual = calculator.calculate(-7,-2, "+");
        assertEquals(-9,actual);
        actual = calculator.calculate(-2,-1, "+");
        assertEquals(-3,actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(2,-2, "+");
        assertEquals(0,actual);
        actual = calculator.calculate(-3,1, "+");
        assertEquals(-2,actual);
        actual = calculator.calculate(10,-1, "+");
        assertEquals(9,actual);
    }

    @Test
    void additionWithZeroInDifferentPlaces() {
        double actual = calculator.calculate(0,2, "+");
        assertEquals(2,actual);
        actual = calculator.calculate(-3,0, "+");
        assertEquals(-3,actual);
        actual = calculator.calculate(0,0, "+");
        assertEquals(0,actual);
    }

    @Test
    void subtractionWithTwoPositiveOperands() {
        double actual = calculator.calculate(2,2, "-");
        assertEquals(0,actual);
        actual = calculator.calculate(5,2, "-");
        assertEquals(3,actual);
        actual = calculator.calculate(1,2, "-");
        assertEquals(-1,actual);
    }

    @Test
    void subtractionWithTwoNegativeOperands() {
        double actual = calculator.calculate(-2,-2, "-");
        assertEquals(0,actual);
        actual = calculator.calculate(-7,-2, "-");
        assertEquals(-5,actual);
        actual = calculator.calculate(-2,-1, "-");
        assertEquals(-1,actual);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(2,-2, "-");
        assertEquals(4,actual);
        actual = calculator.calculate(-3,1, "-");
        assertEquals(-4,actual);
        actual = calculator.calculate(10,-1, "-");
        assertEquals(11,actual);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces() {
        double actual = calculator.calculate(0,2, "-");
        assertEquals(-2,actual);
        actual = calculator.calculate(-3,0, "-");
        assertEquals(-3,actual);
        actual = calculator.calculate(0,0, "-");
        assertEquals(0,actual);
    }

    @Test
    void multiplicationWithTwoPositiveOperands() {
        double actual = calculator.calculate(2,2, "*");
        assertEquals(4,actual);
        actual = calculator.calculate(5,2, "*");
        assertEquals(10,actual);
        actual = calculator.calculate(1,2, "*");
        assertEquals(2,actual);
    }

    @Test
    void multiplicationWithTwoNegativeOperands() {
        double actual = calculator.calculate(-2,-2, "*");
        assertEquals(4,actual);
        actual = calculator.calculate(-7,-2, "*");
        assertEquals(14,actual);
        actual = calculator.calculate(-2,-1, "*");
        assertEquals(2,actual);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(2,-2, "*");
        assertEquals(-4,actual);
        actual = calculator.calculate(-3,1, "*");
        assertEquals(-3,actual);
        actual = calculator.calculate(10,-1, "*");
        assertEquals(-10,actual);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces() {
        double actual = calculator.calculate(0,2, "*");
        assertEquals(0,actual);
        actual = calculator.calculate(-3,0, "*");
        assertTrue(0 == actual);
        actual = calculator.calculate(0,0, "*");
        assertEquals(0,actual);
    }

    @Test
    void divisionWithTwoPositiveOperands() {
        double actual = calculator.calculate(2,2, "/");
        assertEquals(1,actual);
        actual = calculator.calculate(6,2, "/");
        assertEquals(3,actual);
    }

    @Test
    void divisionWithTwoNegativeOperands() {
        double actual = calculator.calculate(-2,-2, "/");
        assertEquals(1,actual);
        actual = calculator.calculate(-6,-2, "/");
        assertEquals(3,actual);
        actual = calculator.calculate(-2,-1, "/");
        assertEquals(2,actual);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(2,-2, "/");
        assertEquals(-1,actual);
        actual = calculator.calculate(-3,1, "/");
        assertEquals(-3,actual);
        actual = calculator.calculate(10,-1, "/");
        assertEquals(-10,actual);
    }

    @Test
    void divisionWithZeroInDifferentPlaces() {
        double actual = calculator.calculate(0,2, "/");
        assertEquals(0,actual);
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(2, 0, "/");
        });
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0, 0, "/");
        });
    }

    @Test
    void raisingWithTwoPositiveOperands() {
        double actual = calculator.calculate(2,2, "^");
        assertEquals(4,actual);
        actual = calculator.calculate(5,2, "^");
        assertEquals(25,actual);
        actual = calculator.calculate(1,2, "^");
        assertEquals(1,actual);
    }

    @Test
    void raisingWithTwoNegativeOperands() {
        double actual = calculator.calculate(-2,-2, "^");
        assertEquals(0.25,actual);
        actual = calculator.calculate(-2,-1, "^");
        assertEquals(-0.5,actual);
    }

    @Test
    void raisingWithPositiveAndNegativeOperands() {
        double actual = calculator.calculate(2,-2, "^");
        assertEquals(0.25,actual);
        actual = calculator.calculate(-3,1, "^");
        assertEquals(-3,actual);
        actual = calculator.calculate(10,-1, "^");
        assertEquals(0.1,actual);
    }

    @Test
    void raisingWithZeroInDifferentPlaces() {
        double actual = calculator.calculate(0,2, "^");
        assertEquals(0,actual);
        actual = calculator.calculate(-3,0, "^");
        assertEquals(1,actual);
        actual = calculator.calculate(0,0, "^");
        assertEquals(1,actual);
    }

    @Test
    void nullOperationTest() {
        assertThrows(NullPointerException.class, () -> {
            calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
        });
    }

    @Test
    void invalidOperationTest() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(0, 1, "**");
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(1, 2, "&");
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(1,0, "$");
        });
    }
}
