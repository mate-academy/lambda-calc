package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DOUBLE_DELTA_REGULAR = 1e-9;
    private static final double DOUBLE_DELTA_SMALL = 0.5e-87;
    private static final double DOUBLE_DELTA_LARGE = 0.5e87;
    private static final double DOUBLE_DELTA_PRECISION = 0;
    private static Calculator calculator;

    @BeforeClass
    public static void instantiate() {
        calculator = new Calculator();
    }

    @Test
    public void addWithPositiveValues() {
        double result = calculator.calculate(5.123, '+', 5.123);
        Assert.assertEquals(10.246, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void addWithNegativeValues() {
        double result = calculator.calculate(-5.123, '+', -5.123);
        Assert.assertEquals(-10.246, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void addWithZero() {
        double result = calculator.calculate(5.123, '+', 0);
        Assert.assertEquals(5.123, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void addWithSmallValues() {
        double result = calculator.calculate(-5.123e-87, '+', -5.123e-87);
        Assert.assertEquals(-10.246e-87, result, DOUBLE_DELTA_SMALL);
    }

    @Test
    public void addWithLargeValues() {
        double result = calculator.calculate(-5.123e87, '+', -5.123e87);
        Assert.assertEquals(-10.246e87, result, DOUBLE_DELTA_LARGE);
    }

    @Test
    public void addWithPrecisionValues() {
        double result = calculator.calculate(-5.123123123123123123123, '+', -5.123123123123123123123);
        Assert.assertEquals(-10.246246246246246246246, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void addWithInfinity() {
        double result = calculator.calculate(5.123, '+', Double.POSITIVE_INFINITY);
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void addWithNan() {
        double result = calculator.calculate(5.123, '+', 0.0/0.0);
        Assert.assertEquals(0.0/0.0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void subWithPositiveValues() {
        double result = calculator.calculate(5.123, '-', 7.1231);
        Assert.assertEquals(-2.0001, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void subWithNegativeValues() {
        double result = calculator.calculate(-5.123, '-', -7.1231);
        Assert.assertEquals(2.0001, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void subWithZero() {
        double result = calculator.calculate(5.123, '-', 0.0);
        Assert.assertEquals(5.123, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void subWithSmallValues() {
        double result = calculator.calculate(-5.123e-87, '-', 7.123e-87);
        Assert.assertEquals(-12.246e-87, result, DOUBLE_DELTA_SMALL);
    }

    @Test
    public void subWithLargeValues() {
        double result = calculator.calculate(-5.123e87, '-', -7.123e87);
        Assert.assertEquals(2.246e87, result, DOUBLE_DELTA_LARGE);
    }

    @Test
    public void subWithPrecisionValues() {
        double result = calculator.calculate(-5.123123123123123123123, '-', -7.1231231231231231231231);
        Assert.assertEquals(2.0000000000000000000001, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void subWithInfinity() {
        double result = calculator.calculate(5.123, '-', Double.POSITIVE_INFINITY);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void subWithNan() {
        double result = calculator.calculate(5.123, '-', 0.0/0.0);
        Assert.assertEquals(0.0/0.0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void mulWithPositiveValues() {
        double result = calculator.calculate(5.123, '*', 3.14);
        Assert.assertEquals(16.08622, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void mulWithNegativeValues() {
        double result = calculator.calculate(5.123, '*', -3.14);
        Assert.assertEquals(-16.08622, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void mulWithZero() {
        double result = calculator.calculate(-5.123, '*', 0.0);
        Assert.assertEquals(0.0, result, DOUBLE_DELTA_SMALL);
    }

    @Test
    public void mulWithNegativeZero() {
        double result = calculator.calculate(5.123, '*', -0.0);
        Assert.assertEquals(0.0, result, DOUBLE_DELTA_SMALL);
    }

    @Test
    public void mulWithSmallValues() {
        double result = calculator.calculate(-5.123e-87, '*', 7.123e-87);
        Assert.assertEquals(-36.491129e-174, result, DOUBLE_DELTA_SMALL);
    }

    @Test
    public void mulWithLargeValues() {
        double result = calculator.calculate(-5.123e87, '*', 7.123e87);
        Assert.assertEquals(-36.491129e174, result, DOUBLE_DELTA_LARGE);
    }

    @Test
    public void mulWithPrecisionValues() {
        double result = calculator.calculate(-5.123123123123123, '*', -7.123123123123123);
        Assert.assertEquals(36.492636780925068, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void mulWithInfinity() {
        double result = calculator.calculate(5.123, '*', Double.POSITIVE_INFINITY);
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void mulWithNan() {
        double result = calculator.calculate(5.123, '*', 0.0/0.0);
        Assert.assertEquals(0.0/0.0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void divWithPositiveValues() {
        double result = calculator.calculate(5.123, '/', 3.14);
        Assert.assertEquals(1.631528662420382, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void divWithNegativeValues() {
        double result = calculator.calculate(5.123, '/', -3.14);
        Assert.assertEquals(-1.631528662420382, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void divWithZero() {
        double result = calculator.calculate(-5.123, '/', 0.0);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void divWithZeroInDividor() {
        double result = calculator.calculate(0.0, '/', 0.123);
        Assert.assertEquals(0.0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void divWithSmallValues() {
        double result = calculator.calculate(-5.123e-87, '/', 7.123e-87);
        Assert.assertEquals(-0.719219430015443, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void divWithLargeValues() {
        double result = calculator.calculate(-5.123e87, '/', 7.123e87);
        Assert.assertEquals(-0.719219430015443, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void divWithPrecisionValues() {
        double result = calculator.calculate(-5.123123123123123, '/', -7.123123123123123);
        Assert.assertEquals(0.719224283305228, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void divWithInfinity() {
        double result = calculator.calculate(5.123, '/', Double.POSITIVE_INFINITY);
        Assert.assertEquals(0.0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void divWithInfinityInDivider() {
        double result = calculator.calculate(Double.POSITIVE_INFINITY, '/', 5.123);
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void divWithNan() {
        double result = calculator.calculate(5.123, '/', 0.0/0.0);
        Assert.assertEquals(0.0/0.0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void powWithZero() {
        double result = calculator.calculate(Math.PI, '^', 0.0);
        Assert.assertEquals(1.0, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void powWithOne() {
        double result = calculator.calculate(Math.PI, '^', 1.0);
        Assert.assertEquals(Math.PI, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void powWithMinusOne() {
        double result = calculator.calculate(5.0, '^', -1.0);
        Assert.assertEquals(0.2, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void powWithTwo() {
        double result = calculator.calculate(5.0, '^', 2.0);
        Assert.assertEquals(25.0, result, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void powWithRegular() {
        double result = calculator.calculate(2.0, '^', 63.0);
        Assert.assertEquals(Long.MAX_VALUE, result - 1, DOUBLE_DELTA_REGULAR);
    }

    @Test
    public void powWithLargePositive() {
        double result = calculator.calculate(1.0000001, '^', 10000000.0);
        Assert.assertEquals(Math.E, result, 0.000001);
    }

    @Test
    public void powWithVeryLargePositive() {
        double result = calculator.calculate(10, '^', 1e100);
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void powWithInfinty() {
        double result = calculator.calculate(10, '^', Double.POSITIVE_INFINITY);
        Assert.assertEquals(Double.POSITIVE_INFINITY, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void powWithNegativeInfinty() {
        double result = calculator.calculate(10, '^', Double.NEGATIVE_INFINITY);
        Assert.assertEquals(0.0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void powWithLargeNegative() {
        double result = calculator.calculate(2, '^', -10000000.0);
        Assert.assertEquals(0, result, DOUBLE_DELTA_PRECISION);
    }

    @Test
    public void powWithNegativeArgument() {
        double result = calculator.calculate(-1, '^', 0.5);
        Assert.assertEquals(0.0/0.0, result, DOUBLE_DELTA_PRECISION);
    }
}
