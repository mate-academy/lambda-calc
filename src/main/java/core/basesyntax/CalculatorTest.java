package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final int DELTA = 1;

    @Test(expected = ArithmeticException.class)
    public void checkWrongOperationCharacter() {
        Calculator.calculate(3, 5, 'a');
    }

    @Test(expected = ArithmeticException.class)
    public void checkDoubleMaxValueOverflow() {
        Calculator.calculate(Double.MAX_VALUE, 1, '+');
    }

    @Test(expected = ArithmeticException.class)
    public void checkDivisionByZero() {
        Calculator.calculate(11, 0, '/');
    }

    @Test
    public void checkDivision() {
        Assert.assertEquals(0, Calculator.calculate(0, 9, '/'), DELTA);
        Assert.assertEquals(-2, Calculator.calculate(-2, 1, '/'), DELTA);
    }

    @Test
    public void checkMultiplication() {
        Assert.assertEquals(4, Calculator.calculate(-2, -2, '*'), DELTA);
        Assert.assertEquals(Double.MAX_VALUE, Calculator.calculate(Double.MAX_VALUE, 1, '*'), DELTA);

    }

    @Test
    public void checkAddition() {
        Assert.assertEquals(0, Calculator.calculate(-2, 2, '+'), DELTA);
        Assert.assertEquals(-7, Calculator.calculate(0, -7, '+'), DELTA);
        Assert.assertEquals(Double.MAX_VALUE,
                Calculator.calculate(0, Double.MAX_VALUE, '+'), DELTA);

    }

    @Test
    public void checkSubtraction() {
        Assert.assertEquals(0,
                Calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'), DELTA);
        Assert.assertEquals(Double.MAX_VALUE,
                Calculator.calculate(Double.MAX_VALUE, 0, '-'), DELTA);
    }

    @Test
    public void checkExponentiation() {
        Assert.assertEquals(1, Calculator.calculate(3, 0, '^'), DELTA);
        Assert.assertEquals(Double.MAX_VALUE,
                Calculator.calculate(Double.MAX_VALUE, 1, '^'), DELTA);
        Assert.assertEquals(74.088, Calculator.calculate(4.2, 3, '^'), DELTA);
    }
}

