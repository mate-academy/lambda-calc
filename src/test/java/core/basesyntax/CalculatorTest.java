package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    public static final double DELTA = 0.01;
    Calculator calculator = null;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveOk() {
        double product = calculator.calculation("+", 3.0, 2.0);
        Assert.assertEquals(5, product, DELTA);
    }

    @Test
    public void additionNegativeOk() {
        double product = calculator.calculation("+", -3.0, -22.0);
        Assert.assertEquals(-25, product, DELTA);
    }

    @Test
    public void additionPositiveFail() {
        double product = calculator.calculation("+", 1.0, 22.0);
        Assert.assertNotEquals(25, product, DELTA);
    }

    @Test
    public void subtractionPositiveOk() {
        double product = calculator.calculation("-", 1.0, 22.0);
        Assert.assertEquals(-21, product, DELTA);
    }

    @Test
    public void subtractionNegativePositiveOk() {
        double product = calculator.calculation("-", -11.0, 22.0);
        Assert.assertEquals(-33, product, DELTA);
    }

    @Test
    public void subtractionNegativeFail() {
        double product = calculator.calculation("-", -1.0, -22.0);
        Assert.assertEquals(21, product, DELTA);
    }

    @Test
    public void multiplicationPositiveOk() {
        double product = calculator.calculation("*", 8.0, 2.0);
        Assert.assertEquals(16, product, DELTA);
    }

    @Test
    public void multiplicationNegativeOk() {
        double product = calculator.calculation("*", -8.0, -3.0);
        Assert.assertEquals(24, product, DELTA);
    }

    @Test
    public void divisionNegativeOk() {
        double product = calculator.calculation("/", -8.0, -3.0);
        Assert.assertNotEquals(2, product, DELTA);
    }

    @Test
    public void divisionPositiveOk() {
        double product = calculator.calculation("/", 2.0, 3.0);
        Assert.assertEquals(0.66, product, DELTA);
    }

    @Test
    public void divisionNegativePositiveFail() {
        double product = calculator.calculation("/", -9.0, 3.0);
        Assert.assertNotEquals(2, product, DELTA);
    }

    @Test
    public void toDegreePositiveOk() {
        double product = calculator.calculation("^", 2.0, 3.0);
        Assert.assertEquals(8, product, DELTA);
    }

    @Test
    public void toDegreeNegativeOk() {
        double product = calculator.calculation("^", -5.0, 3.0);
        Assert.assertEquals(-125, product, DELTA);
    }

    @Test
    public void toDegreePositiveFail() {
        double product = calculator.calculation("^", 5.0, 1.0);
        Assert.assertNotEquals(-125, product, DELTA);
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
}
