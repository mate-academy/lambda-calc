package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private static final double DELTA = 0.00001;
    private Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void nonexistentOperation() {
        try {
            calculator.calculate(4, 20, '?');
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail("Operation not supported was expected");
    }

    @Test
    public void addsOk() {
        assertEquals(15,
                calculator.calculate(10, 5, '+'),
                DELTA);
    }

    @Test
    public void subtractsOk() {
        assertEquals(20,
                calculator.calculate(21, 1, '-'),
                DELTA);
    }

    @Test
    public void multiplyOK() {
        assertEquals(35,
                calculator.calculate(5, 7, '*'),
                DELTA);
    }

    @Test
    public void multiplyFirstZero() {
        assertEquals(0,
                calculator.calculate(0, 1, '*'),
                DELTA);
    }

    @Test
    public void divisionOK() {
        assertEquals(5,
                calculator.calculate(10, 2, '/'),
                DELTA);
    }

    @Test
    public void divisionByZero() {
        try {
            calculator.calculate(5, 0, '/');
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail("Cannot divide by 0 was expected");
    }

    @Test
    public void powerOK() {
        assertEquals("Result should be 0.0", 4,
                calculator.calculate(2, 2, '^'), DELTA);
    }

    @Test
    public void powerOfZero() {
       assertTrue("Result should be 0.0",
               calculator.calculate(0, 2, '^') == 0.0);
    }

    @Test
    public void toPowerZero() {
        assertEquals("Result should be 0.0", 1.0,
                calculator.calculate(10, 0, '^'), DELTA);
    }

    @Test
    public void toPowerNegative() {
        assertEquals("Result should be 0.0", 0.01,
                calculator.calculate(10, -2, '^'), DELTA);
    }
}