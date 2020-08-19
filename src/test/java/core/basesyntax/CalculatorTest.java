package core.basesyntax;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
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

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.calculate(13.0, 0.0, '/');
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

    @Test(expected = ArithmeticException.class)
    public void getZeroToThePowerOfZero() {
        calculator.calculate(0.0, 0.0, '^');
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
