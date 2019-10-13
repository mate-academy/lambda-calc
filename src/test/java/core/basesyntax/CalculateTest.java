package core.basesyntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculateTest {

    @Test
    public void sumIsValid() {
        Calculate calculate = new Calculate(2, '+', 3);
        assertEquals(5, calculate.result(), 0);
    }

    @Test
    public void subtractionIsValid() {
        Calculate calculate = new Calculate(8, '-', 3);
        assertEquals(5, calculate.result(), 0);
    }

    @Test
    public void multiplicationIsValid() {
        Calculate calculate = new Calculate(2, '*', 3);
        assertEquals(6, calculate.result(), 0);
    }

    @Test
    public void multiplicationByZeroIsValid() {
        Calculate calculate = new Calculate(2, '*', 0);
        assertEquals(0, calculate.result(), 0);
    }

    @Test
    public void divisionIsValid() {
        Calculate calculate = new Calculate(9, '/', 3);
        assertEquals(3, calculate.result(), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        Calculate calculate = new Calculate(6, '/', 0);
        calculate.result();
    }

    @Test
    public void powIsValid() {
        Calculate calculate = new Calculate(2, '^', 3);
        assertEquals(8, calculate.result(), 0);
    }

    @Test
    public void powByZeroIsValid() {
        Calculate calculate = new Calculate(2, '^', 0);
        assertEquals(1, calculate.result(), 0);
    }

    @Test
    public void powByNegativeNumberIsValid() {
        Calculate calculate = new Calculate(8, '^', -3);
        assertEquals(0.001953125, calculate.result(), 0);
    }
}