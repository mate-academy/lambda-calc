package core.basesyntax;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private static final double A_VALUE = 10;
    private static final double B_VALUE = 5;
    private static final double NEGATIVE_A_VALUE = -10;
    private static final double NEGATIVE_B_VALUE = -5;
    private static final double ZERO_VALUE = 0;
    private static final double DELTA = 0.1;
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        double sum = calculator.calculate(A_VALUE, B_VALUE, '+');
        assertEquals(15, sum, DELTA);
        sum = calculator.calculate(NEGATIVE_A_VALUE, NEGATIVE_B_VALUE, '+');
        assertEquals(-15, sum, DELTA);
    }

    @Test
    public void substrTest() {
        double sub = calculator.calculate(A_VALUE, B_VALUE, '-');
        assertEquals(5, sub, DELTA);
        sub = calculator.calculate(NEGATIVE_A_VALUE, NEGATIVE_B_VALUE, '-');
        assertEquals(-5, sub, DELTA);
    }

    @Test
    public void multiTest() {
        double multi = calculator.calculate(A_VALUE, B_VALUE, '*');
        assertEquals(50, multi, DELTA);
        multi = calculator.calculate(NEGATIVE_A_VALUE, NEGATIVE_B_VALUE, '*');
        assertEquals(50, multi, DELTA);
        multi = calculator.calculate(NEGATIVE_A_VALUE, A_VALUE, '*');
        assertEquals(-100, multi, DELTA);
    }

    @Test
    public void divTest() {
        double div = calculator.calculate(A_VALUE, B_VALUE, '/');
        assertEquals(2, div, DELTA);
        div = calculator.calculate(NEGATIVE_A_VALUE, NEGATIVE_B_VALUE, '/');
        assertEquals(2, div, DELTA);
        div = calculator.calculate(NEGATIVE_A_VALUE, A_VALUE, '/');
        assertEquals(-1, div, DELTA);
    }

    @Test
    public void powerTest() {
        double pow = calculator.calculate(A_VALUE, B_VALUE, '^');
        assertEquals(100000, pow, DELTA);
        pow = calculator.calculate(NEGATIVE_A_VALUE, B_VALUE, '^');
        assertEquals(-100000, pow, DELTA);
    }

    @Test
    public void zeroPowerTest() {
        double pow = calculator.calculate(A_VALUE, ZERO_VALUE, '^');
        assertEquals(1, pow, DELTA);
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalArgumentTest() {
        calculator.calculate(A_VALUE, B_VALUE, '!');
    }
}
