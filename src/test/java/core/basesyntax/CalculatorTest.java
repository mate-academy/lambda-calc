package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void sum() {
        Assert.assertEquals(3, Calculator.calculate(1, 2, '+'));
    }

    @Test
    public void substract() {
        Assert.assertEquals(1, Calculator.calculate(3, 2, '-'));
    }

    @Test
    public void multiply() {
        Assert.assertEquals(6, Calculator.calculate(3, 2, '*'));
    }

    @Test
    public void divide() {
        Assert.assertEquals(2, Calculator.calculate(6, 3, '/'));
    }

    @Test
    public void divisionByZero() {
        try {
            Calculator.calculate(3, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException expected!");
    }

    @Test
    public void unavailableOperation() {
        try {
            Calculator.calculate(3, 2, '%');
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail("IllegalArgumentException expected!");
    }
}
