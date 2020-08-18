package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private static final double DELTA = 0.001;
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
        assertEquals(15, calculator.calculate(10, 5, '+'), DELTA);
    }

    @Test
    public void addFirstNegative() {
        assertEquals(-25, calculator.calculate(-30, 5, '+'), DELTA);
    }

    @Test
    public void addSecondNegative() {
        assertEquals(12, calculator.calculate(17, -5, '+'), DELTA);
    }

    @Test
    public void addBothNegative() {
        assertEquals(-9, calculator.calculate(-6, -3, '+'), DELTA);
    }

    @Test
    public void addFirstZero() {
        assertEquals(15, calculator.calculate(0, 15, '+'), DELTA);
    }

    @Test
    public void addSecondZero() {
        assertEquals(7, calculator.calculate(7, 0, '+'), DELTA);
    }

    @Test
    public void addBothZero() {
        assertEquals(0, calculator.calculate(0, 0, '+'), DELTA);
    }

    @Test
    public void subtractOK() {
        assertEquals(20, calculator.calculate(21, 1, '-'), DELTA);
    }

    @Test
    public void subtractFirstNegative() {
        assertEquals(-11, calculator.calculate(-10, 1, '-'), DELTA);
    }

    @Test
    public void subtractSecondNegative() {
        assertEquals(22, calculator.calculate(18, -4, '-'), DELTA);
    }

    @Test
    public void subtractBothNegative() {
        assertEquals(-2, calculator.calculate(-8, -6, '-'), DELTA);
    }

    @Test
    public void subtractFirstZero() {
        assertEquals(-1, calculator.calculate(0, 1, '-'), DELTA);
    }

    @Test
    public void subtractSecondZero() {
        assertEquals(4, calculator.calculate(4, 0, '-'), DELTA);
    }

    @Test
    public void subtractBothZero() {
        assertEquals(0, calculator.calculate(0, 0, '-'), DELTA);
    }

    @Test
    public void multiplyOK() {
        assertEquals(35, calculator.calculate(5, 7, '*'), DELTA);
    }

    @Test
    public void multiplyFirstNegative() {
        assertEquals(-7, calculator.calculate(-7, 1, '*'), DELTA);
    }

    @Test
    public void multiplySecondNegative() {
        assertEquals(-8, calculator.calculate(2, -4, '*'), DELTA);
    }

    @Test
    public void multiplyBothNegative() {
        assertEquals(12, calculator.calculate(-3, -4, '*'), DELTA);
    }

    @Test
    public void multiplyFirstZero() {
        assertEquals(0, calculator.calculate(0, 1, '*'), DELTA);
    }

    @Test
    public void multiplySecondZero() {
        assertEquals(0, calculator.calculate(14, 0, '*'), DELTA);
    }

    @Test
    public void multiplyBothZero() {
        assertEquals(0, calculator.calculate(0, 0, '*'), DELTA);
    }

    @Test
    public void divisionOK() {
        assertEquals(5, calculator.calculate(10, 2, '/'), DELTA);
    }

    @Test
    public void divisionFirstNegative() {
        assertEquals(-4, calculator.calculate(-16, 4, '/'), DELTA);
    }

    @Test
    public void divisionSecondNegative() {
        assertEquals(-7, calculator.calculate(14, -2, '/'), DELTA);
    }

    @Test
    public void divisionBothNegative() {
        assertEquals(5, calculator.calculate(-10, -2, '/'), DELTA);
    }

    @Test
    public void divisionFirstZero() {
        assertEquals(0, calculator.calculate(0, 2, '/'), DELTA);
    }

    @Test
    public void divisionSecondZero() {
        try {
            calculator.calculate(5, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Cannot divide by 0 was expected");
    }

    @Test
    public void divisionBothZero() {
        try {
            calculator.calculate(0, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Cannot divide by 0 was expected");
    }

    @Test
    public void powerOK() {
        assertEquals(4, calculator.calculate(2, 2, '^'), DELTA);
    }

    @Test
    public void powerFirstNegativeEvenPower() {
        assertEquals(100, calculator.calculate(-10, 2, '^'), DELTA);
    }

    @Test
    public void powerFirstNegativeOddPower() {
        assertEquals(-27, calculator.calculate(-3, 3, '^'), DELTA);
    }

    @Test
    public void powerSecondNegative() {
        assertEquals(0.01, calculator.calculate(10, -2, '^'), DELTA);
    }

    @Test
    public void powerBothNegativeEvenPower() {
        assertEquals(0.02, calculator.calculate(-7, -2, '^'), DELTA);
    }

    @Test
    public void powerBothNegativeOddPower() {
        assertEquals(-0.015, calculator.calculate(-4, -3, '^'), DELTA);
    }

    @Test
    public void powerFirstZero() {
        assertEquals(0.0,  calculator.calculate(0, 2, '^'), DELTA);
    }

    @Test
    public void powerSecondZero() {
        assertEquals(1.0, calculator.calculate(10, 0, '^'), DELTA);
    }

    @Test
    public void powerBothZero() {
        assertEquals(1.0, calculator.calculate(0, 0, '^'), DELTA);
    }

    @Test
    public void powerFraction() {
        assertEquals(2.0, calculator.calculate(4, 0.5, '^'), DELTA);
    }
}
