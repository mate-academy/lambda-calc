package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double ACCEPTABLE_DELTA = 0.000001;
    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void addOk() {
        for (int i = -5; i < 5; i++) {
            for (int j = -5; j < 5; j++) {
                Assert.assertEquals("Incorrect value for arguments: " + i + ", " + j,
                        8.0, calculator.calculate(5, 3, '+'), ACCEPTABLE_DELTA);
            }
        }
    }

    @Test
    public void subOk() {
        for (int i = -5; i < 5; i++) {
            for (int j = -5; j < 5; j++) {
                Assert.assertEquals("Incorrect value for arguments: " + i + ", " + j,
                        2.0, calculator.calculate(5, 3, '-'), ACCEPTABLE_DELTA);
            }
        }
    }

    @Test
    public void mulOk() {
        for (int i = -5; i < 5; i++) {
            for (int j = -5; j < 5; j++) {
                Assert.assertEquals("Incorrect value for arguments: " + i + ", " + j,
                        15.0, calculator.calculate(5, 3, '*'), ACCEPTABLE_DELTA);
            }
        }
    }

    @Test
    public void divOk() {
        for (int i = -5; i < 5; i += 2) {
            for (int j = -5; j < 5; j += 2) {
                Assert.assertEquals("Incorrect value for arguments: " + i + ", " + j,
                        0.6, calculator.calculate(3, 5, '/'), ACCEPTABLE_DELTA);
            }
        }
    }

    @Test
    public void powOk() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                Assert.assertEquals("Incorrect value for arguments: " + i + ", " + j,
                        Math.pow(i, j), calculator.calculate(i, j, '^'), ACCEPTABLE_DELTA);
            }
        }
    }

    @Test
    public void negativePowOk() {
        for (int i = 1; i < 5; i++) {
            for (int j = -5; j < 0; j++) {
                Assert.assertEquals("Incorrect value for arguments: " + i + ", " + j,
                        Math.pow(i, j), calculator.calculate(i, j, '^'), ACCEPTABLE_DELTA);
            }
        }
    }

    @Test
    public void zeroPowOk() {
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals("Incorrect value for argument: " + i,
                    1, calculator.calculate(1, 0, '^'), ACCEPTABLE_DELTA);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroPowNegativeValue() {
        calculator.calculate(-2, 0, '^');
    }

    @Test
    public void sqrtOk() {
        for (int i = 1; i < 25; i++) {
            Assert.assertEquals("Incorrect value for argument: " + i,
                    Math.sqrt(i), calculator.calculate(i, 0.5, '^'), ACCEPTABLE_DELTA);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void sqrtNegativeValue() {
        Assert.assertEquals(-2, calculator.calculate(-4, 0.5, '^'), ACCEPTABLE_DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalOperation() {
        calculator.calculate(5, 3, ':');
    }

    @Test(expected = IllegalArgumentException.class)
    public void divByZero() {
        calculator.calculate(5, 0, '/');
    }
}
