package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivisionTest {
    private static final double DELTA = 0.01D;
    private Calculator calculator;
    private double result;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void normalDivision() {
        result = calculator.calculate(7.5, 2, '/');
        Assert.assertEquals(3.75, result, DELTA);
    }

    @Test
    public void firstNegativeDivision() {
        result = calculator.calculate(-7.5, 2, '/');
        Assert.assertEquals(-3.75, result, DELTA);
    }

    @Test
    public void secondNegativeDivision() {
        result = calculator.calculate(7.5, -2, '/');
        Assert.assertEquals(-3.75, result, DELTA);
    }

    @Test
    public void bothNegativeDivision() {
        result = calculator.calculate(-7.5, -2, '/');
        Assert.assertEquals(3.75, result, DELTA);
    }

    @Test
    public void firstZeroDivision() {
        result = calculator.calculate(0, 2, '/');
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void secondZeroDivision() {
        try {
            result = calculator.calculate(7.5, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Division by Zero Exception expected");
    }

    @Test
    public void bothZeroDivision() {
        try {
            result = calculator.calculate(0, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Division by Zero Exception expected");
    }
}
