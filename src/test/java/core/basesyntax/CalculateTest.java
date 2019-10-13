package core.basesyntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculateTest {

    @Test
    public void sum() {
        Calculate calculate = new Calculate(2, '+', 3);
        assertEquals(5, calculate.result(), 0);
    }

    @Test
    public void sub() {
        Calculate calculate = new Calculate(8, '-', 3);
        assertEquals(5, calculate.result(), 0);
    }

    @Test
    public void mul() {
        Calculate calculate = new Calculate(2, '*', 3);
        assertEquals(6, calculate.result(), 0);
    }

    @Test
    public void div() {
        Calculate calculate = new Calculate(9, '/', 3);
        assertEquals(3, calculate.result(), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        Calculate calculate = new Calculate(6, '/', 0);
        calculate.result();
    }

    @Test
    public void pow() {
        Calculate calculate = new Calculate(2, '^', 3);
        assertEquals(8, calculate.result(), 0);
    }

    @Test
    public void powByZero() {
        Calculate calculate = new Calculate(2, '^', 0);
        assertEquals(1, calculate.result(), 0);
    }
}