package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private static final double DELTA = 1E-10;
    private static final double FIRST_POSITIVE = 12;
    private static final double FIRST_NEGATIVE = -3;
    private static final double SECOND_POSITIVE = 6;
    private static final double SECOND_NEGATIVE = -4;
    private static final double EVEN_POSITIVE = 2;
    private static final double ODD_POSITIVE = 3;
    private static final double EVEN_NEGATIVE = -2;
    private static final double ODD_NEGATIVE = -3;
    private static final double FRACTION = 0.5;
    private Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void nonexistentOperation() {
        try {
            calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '?');
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail("Operation not supported was expected");
    }

    @Test
    public void addsOk() {
        assertEquals(18, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '+'), DELTA);
        assertEquals(3, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '+'), DELTA);
        assertEquals(8, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '+'), DELTA);
        assertEquals(-7, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '+'), DELTA);
        assertEquals(6, calculator.calculate(0, SECOND_POSITIVE, '+'), DELTA);
        assertEquals(12, calculator.calculate(FIRST_POSITIVE, 0, '+'), DELTA);
        assertEquals(0, calculator.calculate(0, 0, '+'), DELTA);
    }

    @Test
    public void subtractOK() {
        assertEquals(6, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '-'), DELTA);
        assertEquals(-9, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '-'), DELTA);
        assertEquals(16, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '-'), DELTA);
        assertEquals(1, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '-'), DELTA);
        assertEquals(-6, calculator.calculate(0, SECOND_POSITIVE, '-'), DELTA);
        assertEquals(12, calculator.calculate(FIRST_POSITIVE, 0, '-'), DELTA);
        assertEquals(0, calculator.calculate(0, 0, '-'), DELTA);
    }

    @Test
    public void multiplyOK() {
        assertEquals(72, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '*'), DELTA);
        assertEquals(-18, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '*'), DELTA);
        assertEquals(-48, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '*'), DELTA);
        assertEquals(12, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '*'), DELTA);
        assertEquals(0, calculator.calculate(0, SECOND_POSITIVE, '*'), DELTA);
        assertEquals(0, calculator.calculate(FIRST_POSITIVE, 0, '*'), DELTA);
        assertEquals(0, calculator.calculate(0, 0, '*'), DELTA);
    }

    @Test
    public void divisionOK() {
        assertEquals(2, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '/'), DELTA);
        assertEquals(-0.5, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '/'), DELTA);
        assertEquals(-3, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '/'), DELTA);
        assertEquals(0.75, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '/'), DELTA);
        assertEquals(0, calculator.calculate(0, SECOND_POSITIVE, '/'), DELTA);
    }

    @Test
    public void divisionByZeroCheck() {
        try {
            calculator.calculate(FIRST_POSITIVE, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Cannot divide by 0 was expected");

        try {
            calculator.calculate(0, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Cannot divide by 0 was expected");
    }

    @Test
    public void powerOK() {
        assertEquals(2985984, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '^'), DELTA);
    }

    @Test
    public void powerEvenAndOddPositivePower() {
        assertEquals(144, calculator.calculate(FIRST_POSITIVE, EVEN_POSITIVE, '^'), DELTA);
        assertEquals(-27, calculator.calculate(FIRST_NEGATIVE, ODD_POSITIVE, '^'), DELTA);
    }

    @Test
    public void powerEvenAndOddNegativePower() {
        assertEquals(0.006944444444444444,
                calculator.calculate(FIRST_POSITIVE, EVEN_NEGATIVE, '^'), DELTA);
        assertEquals(-0.037037037037037035,
                calculator.calculate(FIRST_NEGATIVE, ODD_NEGATIVE, '^'), DELTA);
    }

    @Test
    public void powerWithZero() {
        assertEquals(0.0, calculator.calculate(0, SECOND_POSITIVE, '^'), DELTA);
        assertEquals(1.0, calculator.calculate(FIRST_POSITIVE, 0, '^'), DELTA);
        assertEquals(1.0, calculator.calculate(0, 0, '^'), DELTA);
    }

    @Test
    public void powerWithFraction() {
        assertEquals(3.4641016151377544, calculator.calculate(FIRST_POSITIVE, FRACTION, '^'), DELTA);
    }
}
