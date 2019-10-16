package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Test(expected = IllegalArgumentException.class)
    public void checkIllegalArguments() {
        calculator.calculate(10.5, 0.2, 'Q');
    }

    @Test
    public void validSum() {
        double actual = calculator.calculate(1, 3, '+');
        Assert.assertEquals(4, actual, 0);
        actual = calculator.calculate(5.1, 0, '+');
        Assert.assertEquals(5.1, actual, 0);
    }

    @Test
    public void validSubstraction() {
        double actual = calculator.calculate(6, 2, '-');
        Assert.assertEquals(4, actual, 0);
        actual = calculator.calculate(3.1, 1, '-');
        Assert.assertEquals(2.1, actual, 0);
    }

    @Test
    public void validMultiplication() {
        double actual = calculator.calculate(6, 0, '*');
        Assert.assertEquals(0, actual, 0);
        actual = calculator.calculate(3.1, 2, '*');
        Assert.assertEquals(6.2, actual, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void validDivByZero() {
        calculator.calculate(6, 0, '/');
    }

    @Test
    public void validDivision() {
        double actual = calculator.calculate(0, 2, '/');
        Assert.assertEquals(0, actual, 0);
        actual = calculator.calculate(3, 1.5, '/');
        Assert.assertEquals(2, actual, 0);
    }

    @Test
    public void validPow() {
        double actual = calculator.calculate(2, 2, '^');
        Assert.assertEquals(4, actual, 0);
        actual = calculator.calculate(4, -1, '^');
        Assert.assertEquals(0.25, actual, 0);
        actual = calculator.calculate(4, 0, '^');
        Assert.assertEquals(1, actual, 0);
    }
}
