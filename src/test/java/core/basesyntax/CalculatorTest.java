package core.basesyntax;

import core.basesyntax.calculator.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
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
        Assert.assertEquals(calculator.calculate(0, 9, '/'), 0, 1);
        Assert.assertEquals(calculator.calculate(-2, 1, '/'), -2, 1);
    }

    @Test
    public void checkMultiplication() {
        Assert.assertEquals(calculator.calculate(-2, -2, '*'), 4, 1);
        Assert.assertEquals(calculator.calculate(Double.MAX_VALUE, 1, '*'), Double.MAX_VALUE, 1);

    }

    @Test
    public void checkAddition() {
        Assert.assertEquals(calculator.calculate(-2, 2, '+'), 0, 1);
        Assert.assertEquals(calculator.calculate(0, -7, '+'), -7, 1);
        Assert.assertEquals(calculator.calculate(0, Double.MAX_VALUE, '+'), Double.MAX_VALUE, 1);

    }

    @Test
    public void checkSubtraction() {
        Assert.assertEquals(calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'), 0, 1);
        Assert.assertEquals(calculator.calculate(Double.MAX_VALUE, 0, '-'), Double.MAX_VALUE, 1);
    }
}
