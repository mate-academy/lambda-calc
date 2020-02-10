package core.basesyntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
    private final double DELTA = 0.00001;

    @Test
    public void operationsWitPositiveNumbers() {
        assertEquals("The sum of calculate",
                12, Calculator.calculate(7, 5, '+'), DELTA);
        assertEquals("The subtrction of calculate",
                9, Calculator.calculate(21, 12, '-'), DELTA);
        assertEquals("The multipiler of calculate",
                18, Calculator.calculate(2, 9, '*'), DELTA);
        assertEquals("The division of calculate",
                5, Calculator.calculate(35, 7, '/'), DELTA);
        assertEquals("The pow of calculate",
                144, Calculator.calculate(12, 2, '^'), DELTA);
        assertEquals("The pow of calculate",
                12, Calculator.calculate(12, 1, '^'), DELTA);

    }

    @Test
    public void operationsWitNegativeNumbers() {
        assertEquals("The sum of calculate",
                -2, Calculator.calculate(-7, 5, '+'), DELTA);
        assertEquals("The sum of calculate",
                2, Calculator.calculate(7, -5, '+'), DELTA);
        assertEquals("The sum of calculate",
                -12, Calculator.calculate(-7, -5, '+'), DELTA);

        assertEquals("The subtrction of calculate",
                33, Calculator.calculate(21, -12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                -33, Calculator.calculate(-21, 12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                -9, Calculator.calculate(-21, -12, '-'), DELTA);

        assertEquals("The multipiler of calculate",
                -18, Calculator.calculate(-2, 9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                -18, Calculator.calculate(2, -9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                18, Calculator.calculate(-2, -9, '*'), DELTA);

        assertEquals("The division of calculate",
                -5, Calculator.calculate(-35, 7, '/'), DELTA);
        assertEquals("The division of calculate",
                -5, Calculator.calculate(35, -7, '/'), DELTA);
        assertEquals("The division of calculate",
                5, Calculator.calculate(-35, -7, '/'), DELTA);

        assertEquals("The pow of calculate1",
                0.00694444, Calculator.calculate(12, -2, '^'), DELTA);
        assertEquals("The pow of calculate2",
                144, Calculator.calculate(-12, 2, '^'), DELTA);
        assertEquals("The pow of calculate3",
                0.00694444, Calculator.calculate(-12, -2, '^'), DELTA);
    }

    @Test
    public void operationsWitZero() {
        assertEquals("The sum of calculate",
                7, Calculator.calculate(7, 0, '+'), DELTA);
        assertEquals("The sum of calculate",
                5, Calculator.calculate(0, 5, '+'), DELTA);
        assertEquals("The sum of calculate",
                0, Calculator.calculate(0, 0, '+'), DELTA);

        assertEquals("The subtrction of calculate",
                21, Calculator.calculate(21, 0, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                -12, Calculator.calculate(0, 12, '-'), DELTA);
        assertEquals("The subtrction of calculate",
                0, Calculator.calculate(0, 0, '-'), DELTA);

        assertEquals("The multipiler of calculate",
                0, Calculator.calculate(0, 9, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                0, Calculator.calculate(2, 0, '*'), DELTA);
        assertEquals("The multipiler of calculate",
                0, Calculator.calculate(0, 0, '*'), DELTA);

        assertEquals("The division of calculate",
                0, Calculator.calculate(0, 7, '/'), DELTA);

        assertEquals("The pow of calculate",
                1, Calculator.calculate(12, 0, '^'), DELTA);
        assertEquals("The pow of calculate",
                0, Calculator.calculate(0, 2, '^'), DELTA);
        assertEquals("The pow of calculate",
                1, Calculator.calculate(0, 0, '^'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        Calculator.calculate(5, 0, '/');
    }

    @Test(expected = NullPointerException.class)
    public void wrongInputParameter() {
        Calculator.calculate(1, 5, 'p');
    }
}