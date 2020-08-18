package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    public static final double DELTA = 0.000_000_001;
    public static final char ADD = '+';
    public static final char SUBSTRACT = '-';
    public static final char MULTIPLY = '*';
    public static final char RAISE = '^';
    public static final char DIVIDE = '/';
    public static final char SOME_CHAR = '#';
    public static final int ZERO = 0;
    public static final int POSITIVE_INT = 3;
    public static final int NEGATIVE_INT = -5;
    public static final double POSITIVE_DOUBLE = 7.5973;
    public static final double NEGATIVE_DOUBLE = -11.5973;

    public static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void addWithMixedParameters() {
        Assert.assertEquals((NEGATIVE_DOUBLE + POSITIVE_INT),
                calculator.calculate(NEGATIVE_DOUBLE,
                        POSITIVE_INT, ADD), DELTA);
    }

    @Test
    public void addIntWithZero() {
        Assert.assertEquals((POSITIVE_INT),
                calculator.calculate(POSITIVE_INT,
                        ZERO, ADD), DELTA);
    }

    @Test
    public void substractDoubleAndInt() {
        double expected = NEGATIVE_DOUBLE - POSITIVE_INT;
        double actual = calculator.calculate(NEGATIVE_DOUBLE,
                POSITIVE_INT, SUBSTRACT);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void substractNegativeDoubleAndZero() {
        double actual = calculator.calculate(NEGATIVE_DOUBLE,
                ZERO, SUBSTRACT);
        Assert.assertEquals((NEGATIVE_DOUBLE), actual, DELTA);
    }

    @Test
    public void divide() {
        double actual = calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_INT, DIVIDE);
        double expected = NEGATIVE_DOUBLE / POSITIVE_INT;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.calculate(POSITIVE_INT, ZERO, DIVIDE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithSomeSymbol() {
        calculator.calculate(POSITIVE_INT, POSITIVE_DOUBLE, SOME_CHAR);
    }

    @Test
    public void raisePositiveInNegative() {
        double expected = Math.pow(POSITIVE_DOUBLE, NEGATIVE_INT);
        double actual = calculator.calculate(POSITIVE_DOUBLE, NEGATIVE_INT, RAISE);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raiseNegativeInPositive() {
        double expected = Math.pow(NEGATIVE_DOUBLE, POSITIVE_INT);
        double actual = calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_INT, RAISE);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void multiply() {
        double expected = NEGATIVE_DOUBLE * POSITIVE_INT;
        double actual = calculator.calculate(NEGATIVE_DOUBLE, POSITIVE_INT, MULTIPLY);
        Assert.assertEquals(expected, actual, DELTA);
    }
}
