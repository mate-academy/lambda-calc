package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    public static final double DELTA = 0.01;
    private Calculator calculator;

    @Before
    public void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        double result = calculator.calculate(20, 10, '+');
        Assert.assertEquals(30, result, DELTA);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.calculate(225.37, 234.38, '-');
        Assert.assertEquals(-9.01, result, DELTA);
    }

    @Test
    public void divisionTest() {
        double result = calculator.calculate(20.5, 10, '/');
        Assert.assertEquals(2.05, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        calculator.calculate(5, 0, '/');
    }

    @Test
    public void multiplyingTest() {
        double result = calculator.calculate(225.37, 234.38, '*');
        Assert.assertEquals(52822.22, result, DELTA);
    }

    @Test
    public void powerTest() {
        double resutlt = calculator.calculate(2, 4, 'p');
        Assert.assertEquals(16, resutlt, DELTA);
    }

    @Test
    public void powerTestWithZeroExponent() {
        double resutlt = calculator.calculate(2, 0, 'p');
        Assert.assertEquals(1, resutlt, DELTA);
    }

    @Test
    public void powerTestWithNegativeExponent() {
        double resutlt = calculator.calculate(2, -2, 'p');
        Assert.assertEquals(0.25, resutlt, DELTA);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongParametersTest() {
            double result = calculator
                    .calculate(Double.parseDouble("one"),
                            Double.parseDouble("two"), '+');
    }

    @Test(expected = NullPointerException.class)
    public void wrongOperationTest() {
            double result = calculator
                    .calculate(20, 10, 'a');
    }

    @Test(expected = NullPointerException.class)
    public void nullNumbersTest() {
            Calculator calculator = new Calculator();
            Double a = null;
            Double b = null;
            calculator.calculate(a, b, '+');
    }
}
