package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    /*
    Tests for additions.
     */

    @Test
    void additionWithTwoPositiveOperands_isOk() {
        double a = 23.4;
        double b = 700.5;
        double actual = calculator.calculate(a, b, '+');
        double expected = 723.9;
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoNegativeOperands_isOk() {
        double a = -23.4;
        double b = -700.5;
        double expected = -723.9;
        double actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_isOk() {
        double a = -23.4;
        double b = 700.5;
        double expected = 677.1;
        double actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroInDifferentPlaces_isOk() {
        double a = 0;
        double b = 700.5;
        double expected = 700.5;
        double actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
        a = 321.45;
        b = 0;
        expected = 321.45;
        actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void additionForMinAndMaxDoubleValues_isOk() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        double delta = 0.0001;
        double actual = calculator.calculate(a, b, '+');
        assertEquals(a, actual, delta);
    }

    /*
    Tests for subtractions.
     */

    @Test
    void subtractionWithTwoPositiveOperands_isOk() {
        double a = 23.4;
        double b = 700.5;
        double actual = calculator.calculate(a, b, '-');
        double expected = -677.1;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithTwoNegativeOperands_isOk() {
        double a = -23.4;
        double b = -700.5;
        double expected = 677.1;
        double actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_isOk() {
        double a = -23.4;
        double b = 700.5;
        double expected = -723.9;
        double actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_isOk() {
        double a = 0;
        double b = 700.5;
        double expected = -700.5;
        double actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
        a = 321.45;
        b = 0;
        expected = 321.45;
        actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_isOk() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        double actual = calculator.calculate(a, b, '-');
        double expected = Double.MAX_VALUE;
        double delta = 0.0001;
        assertEquals(expected, actual, delta);
    }

    /*
    Tests for multiplication.
     */

    @Test
    void multiplicationWithTwoPositiveOperands_isOk() {
        double a = 23.4;
        double b = 700.5;
        double actual = calculator.calculate(a, b, '*');
        double expected = 16391.7;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_isOk() {
        double a = -23.4;
        double b = -700.5;
        double expected = 16391.7;
        double actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_isOk() {
        double a = -23.4;
        double b = 700.5;
        double expected = -16391.7;
        double actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_isOk() {
        double a = 0;
        double b = 700.5;
        double expected = 0;
        double actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
        a = 321.45;
        b = 0;
        actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_isOk() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        double actual = calculator.calculate(a, b, '*');
        double delta = 0.0001;
        assertEquals(0, actual, delta);
    }

    /*
    Tests for division.
     */

    @Test
    void divisionWithTwoPositiveOperands_isOk() {
        double a = 8;
        double b = 25;
        double expected = 0.32;
        double actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithTwoNegativeOperands_isOk() {
        double a = -8;
        double b = -25;
        double expected = 0.32;
        double actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_isOk() {
        double a = 8;
        double b = -25;
        double expected = -0.32;
        double actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZeroInDifferentPlaces() {
        double a = 0;
        double b = 25;
        double expected = 0;
        double actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
        double anotherA = 8;
        double anotherB = 0;
        assertThrows(RuntimeException.class, () -> calculator.calculate(anotherA, anotherB, '/'));
    }

    /*
    Tests for ^ operation.
     */

    @Test
    void raisingForMinAndMaxDoubleValues() {
        double a = Double.MAX_VALUE;
        double b = Double.MIN_VALUE;
        double expected = 1;
        double delta = 0.0001;
        double actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual, delta);
        a = Double.MIN_VALUE;
        b = Double.MAX_VALUE;
        actual = calculator.calculate(a, b, '^');
        expected = 0;
        assertEquals(expected, actual, delta);
    }

    @Test
    void raisingPositiveOrNegativeValueToThePositivePower() {
        final double b = 2.5;
        double a = 4.5;
        double expected = 42.956737;
        double delta = 0.0001;
        double actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual, delta);
        double negativeA = -4.5;
        assertThrows(RuntimeException.class, () -> calculator.calculate(negativeA, b, '^'));

    }

    @Test
    void raisingPositiveOrNegativeValueToTheNegativePower() {
        double a = 4.5;
        double b = -2.2;
        double expected = 0.03655;
        double delta = 0.0001;
        double actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual, delta);
        double negativeA = -4.5;
        assertThrows(RuntimeException.class, () -> calculator.calculate(negativeA, b, '^'));
    }

    @Test
    void raisingPositiveOrNegativeValueToTheZeroPower() {
        double a = 4.5;
        double b = 0;
        double expected = 1;
        double actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
        a = -4.5;
        expected = 1;
        actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    @Test
    void raisingZeroToPower() {
        double a = 0;
        double b = 4.5;
        double expected = 0;
        double actual = calculator.calculate(a, b, '^');
        assertEquals(expected, actual);
    }

    /*
    Tests for illegal operation.
     */

    @Test
    void illegalOperations_ExceptionOk() {
        double finalA = 24;
        double finalB = -8;
        assertThrows(RuntimeException.class, () -> calculator.calculate(finalA, finalB, '='));
        assertThrows(RuntimeException.class, () -> calculator.calculate(finalA, finalB, '!'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(finalA, finalB, '$'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(finalA, finalB, '%'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(finalA, finalB, '('));
    }
}
