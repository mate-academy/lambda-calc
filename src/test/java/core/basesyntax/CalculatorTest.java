package core.basesyntax;

import core.basesyntax.calculator.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final int DELTA = 1;
    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWrongOperationCharacter() {
        calculator.calculate(3, 5, 'a');
    }

    @Test
    public void checkDoubleMaxValueOverflow() {
        try {
            calculator.calculate(Double.MAX_VALUE, 1, '+');
        } catch (ArithmeticException exception) {
            return;
        }
    }

    @Test(expected = ArithmeticException.class)
    public void checkDivisionByZero() {
        calculator.calculate(8, 0, '/');
    }

    @Test
    public void checkDivision() {
        Assert.assertEquals(0, calculator.calculate(0, 9, '/'), DELTA);
        Assert.assertEquals(-2, calculator.calculate(-2, 1, '/'), DELTA);
    }

    @Test
    public void checkMultiplication() {
        Assert.assertEquals(4, calculator.calculate(-2, -2, '*'), DELTA);
        Assert.assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1,'*'),  DELTA);

    }

    @Test
    public void checkAddition() {
        Assert.assertEquals(0, calculator.calculate(-2, 2, '+'), DELTA);
        Assert.assertEquals(-7, calculator.calculate(0, -7, '+'), DELTA);
        Assert.assertEquals(Double.MAX_VALUE, calculator.calculate(0, Double.MAX_VALUE, '+'), DELTA);

    }

    @Test
    public void checkSubtraction() {
        Assert.assertEquals(0, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'), DELTA);
        Assert.assertEquals( Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 0, '-'), DELTA);
    }

    @Test
    public void checkExponentiation() {
        Assert.assertEquals(1, calculator.calculate(3, 0, '^'), DELTA);
        Assert.assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 1, '^'), DELTA);
        Assert.assertEquals(74.088, calculator.calculate(4.2, 3, '^'), DELTA);
    }
}
