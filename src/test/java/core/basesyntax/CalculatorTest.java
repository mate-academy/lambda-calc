package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {
    private static final double DELTA = 1e-10;
    private Calculator calculator;

    @Before
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void additionTest() {
        double result = calculator.calculate(2.0, 3.5, '+');
        Assert.assertEquals(5.5, result, DELTA);
    }

    @Test
    public void additionNegativeTest() {
        double result = calculator.calculate(-32.3, -5.0, '+');
        Assert.assertEquals(-37.3, result, DELTA);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.calculate(15.3, 3.4, '-');
        Assert.assertEquals(11.9, result, DELTA);
    }

    @Test
    public void subtractionNegativeTest() {
        double result = calculator.calculate(-5.0, -2.0, '-');
        Assert.assertEquals(-3, result, DELTA);
    }

    @Test
    public void multiplicationTest() {
        double result = calculator.calculate(10.1, 18.4, '*');
        Assert.assertEquals(185.84, result, DELTA);
    }

    @Test
    public void multiplyNegativeTest() {
        double result = calculator.calculate(-3.0, 5.0, '*');
        Assert.assertEquals(-15, result, DELTA);
    }

    @Test
    public void multiplicationByZeroTest() {
        double result = calculator.calculate(14.3, 0.0, '*');
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void divisionTest() {
        double result = calculator.calculate(20.0, 5.0, '/');
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void divisionNegativeTest() {
        double result = calculator.calculate(-9.0, -3.0, '/');
        Assert.assertEquals(3, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(32.3, 0.0, '/');
    }

    @Test
    public void powerTest() {
        double result = calculator.calculate(3.0, 3.0, '^');
        Assert.assertEquals(27, result, DELTA);
    }

    @Test
    public void powerByZeroTest() {
        double result = calculator.calculate(5.0, 0.0, '^');
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void powerByNegativeValueTest() {
        double result = calculator.calculate(-3.5, 2.0, '^');
        Assert.assertEquals(12.25, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperationTest() {
        calculator.calculate(5.0, 6.0, '>');
    }

    @Test(expected = NumberFormatException.class)
    public void wrongParametersTest() {
        calculator.calculate(Double.parseDouble("first"), Double.parseDouble("second"), '*');
    }

    @Test(expected = NullPointerException.class)
    public void checkElementsForNullTest() {
        calculator.calculate(null, null, '+');
    }
}