package core.basesyntax;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    private static Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void sumOk() {
        assertEquals(50.0, calculator.calculate(25.5, 24.5, '+'), DELTA);
        assertEquals(0.0, calculator.calculate(20.5, -20.5, '+'), DELTA);
    }

    @Test
    public void multiplyOk() {
        assertEquals(15.0, calculator.calculate(5.0, 3.0, '*'), DELTA);
        assertEquals(0.0, calculator.calculate(5.0, 0.0, '*'), DELTA);
        assertEquals(-20.0, calculator.calculate(5.0, -4.0, '*'), DELTA);
    }

    @Test
    public void divideOk() {
        assertEquals(2.0, calculator.calculate(32.0, 16.0, '/'), DELTA);
        assertEquals(-2.5, calculator.calculate(5.0, -2.0, '/'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByNull() {
        calculator.calculate(13.4, 0, '/');
    }


    @Test
    public void extractOk() {
        assertEquals(23.4, calculator.calculate(26.0, 2.6, '-'), DELTA);
        assertEquals(-8.2, calculator.calculate(-4.0, 4.2, '-'), DELTA);
        assertEquals(15.0, calculator.calculate(13.0, -2.0, '-'), DELTA);
    }

    @Test
    public void powerOk() {
        assertEquals(1.0, calculator.calculate(2.0, 0.0, '^'), DELTA);
        assertEquals(2.0, calculator.calculate(2.0, 1, '^'), DELTA);
        assertEquals(8.0, calculator.calculate(2.0, 3.0, '^'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void powerNegative() {
        assertEquals(1.0, calculator.calculate(2.0, -2.0, '^'), DELTA);
    }
}