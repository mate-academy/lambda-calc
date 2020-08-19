package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorldTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test
    public void checkAddOperation() {
        for (double i = -10; i < 10; i++) {
            for (double j = 0; j < 10; j++) {
                double actualResult = calculator.calculate(i, j, '+');
                double expectedResult = i + j;
                assertEquals(expectedResult, actualResult, DELTA);
            }
        }
    }

    @Test
    public void checkSubstractOperation() {
        for (double i = -10; i < 10; i++) {
            for (double j = 0; j < 10; j++) {
                double actualResult = calculator.calculate(i, j, '-');
                double expectedResult = i - j;
                assertEquals(expectedResult, actualResult, DELTA);
            }
        }
    }

    @Test
    public void checkMultiplyOperation() {
        for (double i = 1; i < 10; i++) {
            for (double j = 1; j < 10; j++) {
                double actualResult = calculator.calculate(i, j, '*');
                double expectedResult = i * j;
                assertEquals(expectedResult, actualResult, DELTA);
            }
        }
    }

    @Test
    public void checkMultiplyByZero() {
        double actualResult = calculator.calculate(13.0, 0.0, '*');
        assertEquals(0.0, actualResult, DELTA);
        double actualResult2 = calculator.calculate(0.0, 13.0, '*');
        assertEquals(0.0, actualResult2, DELTA);
    }

    @Test
    public void checkDivideOperation() {
        for (double i = 1; i < 10; i++) {
            for (double j = 1; j < 10; j++) {
                double actualResult = calculator.calculate(i, j, '/');
                double expectedResult = i / j;
                assertEquals(expectedResult, actualResult, DELTA);
            }
        }
    }

    @Test
    public void divideByZero() {
        try {
            calculator.calculate(13.0, 0.0, '/');
        } catch (ArithmeticException e) {
            assertEquals(e.getMessage(), "We cannot divide by zero");
            return;
        }
        Assert.fail("Zero should not be accepted as divider.");
    }

    @Test
    public void checkPowOperation() {
        for (double i = 1; i < 10; i++) {
            for (double j = 1; j < 10; j++) {
                double actualResult = calculator.calculate(i, j, '^');
                double expectedResult = Math.pow(i, j);
                assertEquals(expectedResult, actualResult, DELTA);
            }
        }
    }

    @Test
    public void getNumberInZeroPow() {
        double actualResult = calculator.calculate(13.0, 0.0, '^');
        assertEquals(1.0, actualResult, DELTA);
    }

    @Test
    public void getZeroInPow() {
        try {
            calculator.calculate(0.0, 13.0, '^');
        } catch (ArithmeticException e) {
            assertEquals(e.getMessage(), "Just don't. https://en.wikipedia.org/wiki/Zero_to_the_power_of_zero");
            return;
        }
        Assert.fail("Please, make sure that 0 is not used for POW method");
    }

    @Test
    public void getNumberInNotIntPow() {
        double actualResult = calculator.calculate(-13.0, -13.4, '^');
        assertEquals(Math.pow(-13.0, -13.4), actualResult, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWrongOperation() {
        calculator.calculate(16.0, 61.0, '%');
    }
}