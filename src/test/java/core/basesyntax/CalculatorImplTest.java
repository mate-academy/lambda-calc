package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorImplTest {
    private static final Double DELTA = 0.001;
    private CalculatorImpl calculator;

    @Before
    public void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void positiveCheckAddition() {
        double result = calculator.executor(5d, '+', 5d);
        Assert.assertEquals(10, result, DELTA);
        result = calculator.executor(25d, '+', 10d);
        Assert.assertEquals(35d, result, DELTA);
        result = calculator.executor(15d, '+', 0d);
        Assert.assertEquals(15d, result, DELTA);
    }

    @Test
    public void positiveCheckSubtraction() {
        double result = calculator.executor(10d, '-', 5d);
        Assert.assertEquals(5, result, DELTA);
        result = calculator.executor(100d, '-', 50d);
        Assert.assertEquals(50, result, DELTA);
        result = calculator.executor(100d, '-', 0d);
        Assert.assertEquals(100, result, DELTA);
    }

    @Test
    public void positiveCheckMult() {
        double result = calculator.executor(5d, '*', 5d);
        Assert.assertEquals(25, result, DELTA);
        result = calculator.executor(3d, '*', 3d);
        Assert.assertEquals(9, result, DELTA);
        result = calculator.executor(10d, '*', 10d);
        Assert.assertEquals(100, result, DELTA);
        result = calculator.executor(10d, '*', 0d);
        Assert.assertEquals(0, result, DELTA);
        result = calculator.executor(-54.65d, '*', 34.7d);
        Assert.assertEquals(-1896.355, result, DELTA);
        result = calculator.executor(-65.47d, '*', -12.4d);
        Assert.assertEquals(811.828, result, DELTA);
    }

    @Test
    public void positiveCheckDivision() {
        double result = calculator.executor(25d, '/', 5d);
        Assert.assertEquals(5, result, DELTA);
        result = calculator.executor(100d, '/', 10d);
        Assert.assertEquals(10, result, DELTA);
        result = calculator.executor(25d, '/', 4d);
        Assert.assertEquals(6.25, result, DELTA);
        result = calculator.executor(-13d, '/', 4d);
        Assert.assertEquals(-3.25, result, DELTA);
        result = calculator.executor(-23d, '/', -5d);
        Assert.assertEquals(4.6, result, DELTA);
    }

    @Test
    public void positiveCheckPow() {
        double result = calculator.executor(3d, '^', 2d);
        Assert.assertEquals(9, result, DELTA);
        result = calculator.executor(5d, '^', 2d);
        Assert.assertEquals(25, result, DELTA);
        result = calculator.executor(34d, '^', 2d);
        Assert.assertEquals(1156, result, DELTA);
        result = calculator.executor(13d, '^', 0d);
        Assert.assertEquals(1, result, DELTA);
        result = calculator.executor(-34d, '^', 2d);
        Assert.assertEquals(1156, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void executeWithNull() {
        Double b = null;
        double resultMult = calculator.executor(12d, '*', b);
        double resultDiv = calculator.executor(13d, '/', b);
        double resultAdd = calculator.executor(14d, '+', b);
        double resultSub = calculator.executor(15d, '-', b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDivisionWithZero() {
        calculator.executor(23d, '/', 0d);
    }
}
