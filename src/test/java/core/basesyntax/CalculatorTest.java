package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.01;
    private Calculator calculator = null;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveOk() {
        double result = calculator.calculation("+", 3.0, 2.0);
        Assert.assertEquals(5, result, DELTA);
    }

    @Test
    public void additionNegativeOk() {
        double result = calculator.calculation("+", -3.0, -22.0);
        Assert.assertEquals(-25, result, DELTA);
    }

    @Test
    public void subtractionPositiveOk() {
        double result = calculator.calculation("-", 1.0, 22.0);
        Assert.assertEquals(-21, result, DELTA);
    }

    @Test
    public void subtractionNegativePositiveOk() {
        double result = calculator.calculation("-", -11.0, 22.0);
        Assert.assertEquals(-33, result, DELTA);
    }

    @Test
    public void multiplicationPositiveOk() {
        double result = calculator.calculation("*", 8.0, 2.0);
        Assert.assertEquals(16, result, DELTA);
    }

    @Test
    public void multiplicationNegativeOk() {
        double result = calculator.calculation("*", -8.0, -3.0);
        Assert.assertEquals(24, result, DELTA);
    }

    @Test
    public void divisionNegativeOk() {
        double result = calculator.calculation("/", -8.0, -3.0);
        Assert.assertNotEquals(2, result, DELTA);
    }

    @Test
    public void divisionPositiveOk() {
        double result = calculator.calculation("/", 2.0, 3.0);
        Assert.assertEquals(0.66, result, DELTA);
    }

    @Test
    public void divisionNegativePositiveFail() {
        double result = calculator.calculation("/", -9.0, 3.0);
        Assert.assertNotEquals(2, result, DELTA);
    }

    @Test
    public void toDegreePositiveOk() {
        double result = calculator.calculation("^", 2.0, 3.0);
        Assert.assertEquals(8, result, DELTA);
    }

    @Test
    public void toDegreeNegativeOk() {
        double result = calculator.calculation("^", 5.0, -3.0);
        Assert.assertEquals(0.008, result, DELTA);
    }

    @Test
    public void toDegreeZeroOK() {
        double result = calculator.calculation("^", 5.0, 0.0);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void wrongOperator() {
        try {
            calculator.calculation("&", 5.0, 1.0);
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException was expected");
    }

    @Test
    public void divisionByNull() {
        try {
            calculator.calculation("/", 5.0, Double.valueOf(null));
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException was expected");
    }

    @Test
    public void divisionByZero() {
        double result = calculator.calculation("/", 5.0, 0.0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
    }
}
