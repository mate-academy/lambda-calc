package core.basesyntax;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTests {

    private static final double DELTA = 0.01D;
    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test
    public void additionWithPositiveNumbers() {
        assertEquals(3, calculator.calculate(1, 2, '+'), DELTA);
    }

    @Test
    public void additionWithNegativeNumbers() {
        assertEquals(-3, calculator.calculate(-1, -2, '+'), DELTA);
    }

    @Test
    public void subtractionWithPositiveNumbers() {
        assertEquals(4, calculator.calculate(6, 2, '-'), DELTA);
    }

    @Test
    public void subtractionWithNegativeNumbers() {
        assertEquals(-2, calculator.calculate(-4, -2, '-'), DELTA);
    }

    @Test
    public void divisionWithPositiveNumbers() {
        assertEquals(2, calculator.calculate(8, 4, '/'), DELTA);
    }

    @Test
    public void divisionWithNegativeNumbers() {
        assertEquals(3, calculator.calculate(-6, -2, '/'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(8, 0, '/');
    }

    @Test
    public void checkRaisingToThePower() {
        assertEquals(4, calculator.calculate(2, 2, '^'), DELTA);
    }

    @Test
    public void raisingToThePowerWithNegative() {
        assertEquals(0.25, calculator.calculate(2, -2, '^'), DELTA);
    }

    @Test
    public void raisingToThePowerWithZero() {
        assertEquals(1, calculator.calculate(2, 0, '^'), DELTA);
    }

    @Test
    public void raisingToThePowerZero() {
        assertEquals(0, calculator.calculate(0, 2, '^'), DELTA);
    }

    @Test
    public void raisingToThePowerNegativeNumber() {
        assertEquals(4, calculator.calculate(-2, 2, '^'), DELTA);
    }

    @Test
    public void multiplicationWithPositiveNumbers() {
        assertEquals(20, calculator.calculate(10, 2, '*'), DELTA);
    }

    @Test
    public void multiplicationWithNegativeNumbers() {
        assertEquals(-20, calculator.calculate(-10, 2, '*'), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCalculateWithUnexpectedOperator() {
        calculator.calculate(4, 5, 'b');
    }
}
