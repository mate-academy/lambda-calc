package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.00001;
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void additionOk() throws Calculator.NoSuchOperationException {
        double actual = calculator.calculate(12, '+', 8);
        Assert.assertEquals(20, actual, DELTA);
    }

    @Test
    public void subtractionOk() throws Calculator.NoSuchOperationException {
        double actual = calculator.calculate(12, '-', 20);
        Assert.assertEquals(-8, actual, DELTA);
    }

    @Test
    public void divisionOk() throws Calculator.NoSuchOperationException {
        double actual = calculator.calculate(12, '/', 2);
        Assert.assertEquals(6, actual, DELTA);
    }

    @Test
    public void multiplicationNegativeOk() throws Calculator.NoSuchOperationException {
        double actual = calculator.calculate(-12, '*', 3);
        Assert.assertEquals(-36, actual, DELTA);
    }

    @Test
    public void powerNegativeOk() throws Calculator.NoSuchOperationException {
        double actual = calculator.calculate(-3, '^', 0);
        Assert.assertEquals(1, actual, DELTA);
    }

    @Test
    public void divisionByZero() {
        try {
            calculator.calculate(12, '/', 0);
        } catch (ArithmeticException | Calculator.NoSuchOperationException e) {
            return;
        }
        Assert.fail("ArithmeticException was expected");
    }

    @Test
    public void checkMathAction() {
        try {
            calculator.calculate(12, ';', 4);
        } catch (Calculator.NoSuchOperationException e) {
            return;
        }
        Assert.fail("ActionException was expected");
    }
}
