package core.basesyntax;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double A_VALUE = 10;
    private static final double B_VALUE = 5;
    private static final double NEGATIVE_A_VALUE = -10;
    private static final double NEGATIVE_B_VALUE = -5;
    private static final double ZERO_VALUE = 0;
    private static final double DELTA = 0.01;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        double sum = calculator.calculate(A_VALUE, B_VALUE, '+');
        assertEquals(15, sum, DELTA);
        sum = calculator.calculate(NEGATIVE_A_VALUE, NEGATIVE_B_VALUE, '+');
        assertEquals(-15, sum, DELTA);
        sum = calculator.calculate(NEGATIVE_A_VALUE, ZERO_VALUE, '+');
        assertEquals(-10, sum, DELTA);
        sum = calculator.calculate(ZERO_VALUE, ZERO_VALUE, '+');
        assertEquals(0, sum, DELTA);
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
        multi = calculator.calculate(NEGATIVE_A_VALUE, ZERO_VALUE, '*');
        assertEquals(0, multi, DELTA);
    }

    @Test
    public void divTest() {
        double div = calculator.calculate(A_VALUE, B_VALUE, '/');
        assertEquals(2, div, DELTA);
        div = calculator.calculate(NEGATIVE_A_VALUE, NEGATIVE_B_VALUE, '/');
        assertEquals(2, div, DELTA);
        div = calculator.calculate(NEGATIVE_A_VALUE, A_VALUE, '/');
        assertEquals(-1, div, DELTA);
        try {
            calculator.calculate(A_VALUE, ZERO_VALUE, '/');
        } catch (ArithmeticException e) {
            String errMsg = "Can't divide on zero!";
            assertEquals(errMsg ,e.getMessage());
            return;
        }
        Assert.fail("Test shouldn't pass zero as a divider");
    }

    @Test
    public void powerTest() {
        double pow = calculator.calculate(A_VALUE, B_VALUE, '^');
        assertEquals(100000, pow, DELTA);
        pow = calculator.calculate(NEGATIVE_A_VALUE, B_VALUE, '^');
        assertEquals(-100000, pow, DELTA);
        pow = calculator.calculate(NEGATIVE_A_VALUE, ZERO_VALUE, '^');
        assertEquals(1, pow, DELTA);
        pow = calculator.calculate(A_VALUE, ZERO_VALUE, '^');
        assertEquals(1, pow, DELTA);
        try {
            pow = calculator.calculate(ZERO_VALUE, B_VALUE, '^');
            assertEquals(1, pow, DELTA);
        } catch (ArithmeticException e) {
            String errMsg = "Can't power zero!";
            assertEquals(errMsg, e.getMessage());
            return;
        }
        Assert.fail("A value can't be 0 for 'pow' method");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentTest() {
        calculator.calculate(A_VALUE, B_VALUE, '!');
    }

    @Test
    public void modTest() {
        double mod = calculator.calculate(A_VALUE, B_VALUE, '%');
        assertEquals(A_VALUE % B_VALUE, mod, DELTA);
        try {
            mod = calculator.calculate(A_VALUE, ZERO_VALUE, '%');
            assertEquals(A_VALUE % ZERO_VALUE, mod, DELTA);
        } catch (ArithmeticException e) {
            String errMsg = "Can't divide on zero!";
            assertEquals(errMsg ,e.getMessage());
            return;
        }
        Assert.fail("You shouldn't pass zero as B argument");
    }

}
