package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;
    private static final double DELTA = 0;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void isIllegalArgs() {
        for (int i = 0; i < 128; i++) {
            if (i != 43 && i != 45 && i != 47 && i != 94 && i != 42) {
                calculator.calculate(1, 1, (char) i);
            }
        }
    }

    @Test
    public void isPlusOk() {
        calculator.calculate(4, 5, '+');
        for (double i = -10; i <= 10; i += 0.5) {
            for (double j = -10; j <= 10; j += 0.5) {
                Assert.assertEquals(i + j, calculator.calculate(i, j, '+'), DELTA);
            }
        }
    }

    @Test
    public void isMinusOk() {
        for (double i = -10; i <= 10; i += 0.5) {
            for (double j = -10; j <= 10; j += 0.5) {
                Assert.assertEquals(i - j, calculator.calculate(i, j, '-'), DELTA);
            }
        }
    }

    @Test
    public void isPositiveDivideOk() {
        for (double i = 1; i <= 10; i += 0.5) {
            for (double j = 1; j <= 10; j += 0.5) {
                Assert.assertEquals(i / j, calculator.calculate(i, j, '/'), DELTA);
            }
        }
    }

    @Test
    public void isNegativeDivideOk() {
        for (double i = -10; i <= -1; i += 0.5) {
            for (double j = -10; j <= -1; j += 0.5) {
                Assert.assertEquals(i / j, calculator.calculate(i, j, '/'), DELTA);
            }
        }
    }


    @Test
    public void positiveNumDivideByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(5, 0, '/'), DELTA);
    }

    @Test
    public void negativeNumDivideByZero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, calculator.calculate(-5, 0, '/'), DELTA);
    }

    @Test
    public void isMultiplicationOk() {
        for (double i = -10; i <= 10; i += 0.5) {
            for (double j = -10; j <= 10; j += 0.5) {
                Assert.assertEquals(i * j, calculator.calculate(i, j, '*'), DELTA);
            }
        }
    }

    @Test
    public void isPositivePowerOk() {
        for (double i = 1; i <= 10; i += 0.5) {
            for (double j = 1; j <= 10; j += 0.5) {
                Assert.assertEquals(Math.pow(i, j), calculator.calculate(i, j, '^'), DELTA);
            }
        }
    }

    @Test
    public void isZeroPowerOk() {
        Assert.assertEquals(Math.pow(5, 0), calculator.calculate(5, 0, '^'), DELTA);
    }

    @Test
    public void isNegativePowerOk() {
        for (double i = -10; i <= -1; i += 0.5) {
            for (double j = -10; j <= -1; j += 0.5) {
                Assert.assertEquals(Math.pow(i, j), calculator.calculate(i, j, '^'), DELTA);
            }
        }
    }
}
