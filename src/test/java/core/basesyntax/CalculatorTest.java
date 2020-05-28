package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void checkPlusOperation() {
        for (double i = 0; i <= 10 ; i++) {
            for (double j = 1; j <= 10 ; j++) {
                Double actualResult = calculator.calculate(i, j, '+');
                Double expectedResult = i + j;
                Assert.assertEquals(actualResult, expectedResult);
            }
        }
    }

    @Test
    public void checkSumOfNegativeNumbers() {
        Double actualResult = calculator.calculate(-4.0, -2.0, '+');
        Assert.assertEquals(actualResult, -6.0, DELTA);
    }

    @Test
    public void checkMinusOperation() {
        for (double i = 10; i >= 1  ; i--) {
            for (double j = 1; j <= i ; j++) {
                Double actualResult = calculator.calculate(i, j, '-');
                Double expectedResult = i - j;
                Assert.assertEquals(actualResult, expectedResult);
            }
        }
    }

    @Test
    public void checkSubtractionOfNegativeNumbers() {
        Double actualResult = calculator.calculate(-4.0, -2.0, '-');
        Assert.assertEquals(actualResult, -2.0, DELTA);
    }

    @Test
    public void checkMultiOperation() {
        for (double i = 1; i <= 10 ; i++) {
            for (double j = 1; j <= 10 ; j++) {
                Double actualResult = calculator.calculate(i, j, '*');
                Double expectedResult = i * j;
                Assert.assertEquals(actualResult, expectedResult);
            }
        }
    }

    @Test
    public void checkMultiByZero() {
        Double actualResult = calculator.calculate(4.0, 0.0, '*');
        Assert.assertEquals(0.0, actualResult, DELTA);
    }

    @Test
    public void checkPowOperation() {
        for (double i = 2; i <= 10 ; i++) {
            for (double j = 2; j <= 10 ; j++) {
                Double actualResult = calculator.calculate(i, j, '^');
                Double expectedResult = Math.pow(i, j);
                Assert.assertEquals(actualResult, expectedResult);
            }
        }
    }

    @Test
    public void checkZeroPow() {
        Double actualResult = calculator.calculate(5.0, 0.0, '^');
        Assert.assertEquals(1.0, actualResult, DELTA);
    }

    @Test
    public void checkNotIntPow() {
        Double actualResult = calculator.calculate(-4.0, -4.4, '^');
        Assert.assertEquals(actualResult, Double.NaN, DELTA);
    }

    @Test
    public void checkDivideOperation() {
        for (double i = 10; i >= 2 ; i--) {
            for (double j = 2; j <= i ; j++) {
                Double actualResult = calculator.calculate(i, j, '/');
                Double expectedResult = i / j;
                Assert.assertEquals(actualResult, expectedResult);
            }
        }
    }

    @Test
    public void checkDivideByZero() {
        Double actualResult = calculator.calculate(1.0, 0.0, '/');
        Assert.assertEquals(Double.POSITIVE_INFINITY, actualResult, DELTA);
    }

    @Test
    public void checkMinusNumberDivideByZero() {
        Double actualResult = calculator.calculate(-1.0, 0.0, '/');
        Assert.assertEquals(Double.NEGATIVE_INFINITY, actualResult, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWrongOperation() {
        calculator.calculate(1.0, 2.0, '%');
    }

    @Test(expected = NullPointerException.class)
    public void checkNumbersForNull() {
        calculator.calculate(null, 1.0, '+');
    }
}