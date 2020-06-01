import core.basesyntax.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static java.lang.Double.valueOf;

public class CalculatorTest {
    private Calculator calculator;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        Double result = calculator.calculate(2, 2, '+');
        Assert.assertEquals(valueOf(4), result);
    }

    @Test
    public void testSumNegative() {
        Double result = calculator.calculate(2, -2, '+');
        Assert.assertEquals(valueOf(0), result);
    }

    @Test
    public void testMinus() {
        Double result = calculator.calculate(2, 2, '-');
        Assert.assertEquals(valueOf(0), result);
    }

    @Test
    public void testMinusNegative() {
        Double result = calculator.calculate(2, -2, '-');
        Assert.assertEquals(valueOf(4), result);
    }

    @Test
    public void multiple() {
        Double result = calculator.calculate(2, 2, '*');
        Assert.assertEquals(valueOf(4), result);
    }

    @Test
    public void multipleByZero() {
        Double result = calculator.calculate(0, 2, '*');
        Assert.assertEquals(valueOf(0), result);
    }

    @Test
    public void testToExponent() {
        Double result = calculator.calculate(2, 3, '^');
        Assert.assertEquals(valueOf(8), result);
    }

    @Test
    public void testToNegativeExponent() {
        Double result = calculator.calculate(2, -3, '^');
        Assert.assertEquals(valueOf(0.125), result);
    }

    @Test
    public void testNegativeToExponent() {
        Double result = calculator.calculate(-2, 3, '^');
        Assert.assertEquals(valueOf(-8), result);
    }

    @Test
    public void testToZeroExponent() {
        Double result = calculator.calculate(-2, 0, '^');
        Assert.assertEquals(valueOf(1), result);
    }

    @Test
    public void testDivide() {
        Double result = calculator.calculate(2, 2, '/');
        Assert.assertEquals(valueOf(1), result);
    }

    @Test
    public void checkDivideByZero() {
        double result = calculator.calculate(1.0, 0.0, '/');
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
    }

    @Test
    public void checkMinusNumberDivideByZero() {
        double result = calculator.calculate(-1.0, 0.0, '/');
        Assert.assertEquals(Double.NEGATIVE_INFINITY, result, DELTA);
    }
}
