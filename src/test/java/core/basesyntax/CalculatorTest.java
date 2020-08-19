package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static final double ZERO = 0.0;
    private static final double TWO = 2.0;
    private static final double IRRACIONAL_FIVE = 5.2367;
    private static final double NEGATIVE_TWO = -2.0;
    private static final double NEGATIVE_SIX = -6.0;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void divisionIsValid() {
        Assert.assertEquals(-1.1457, calculator.calculate(NEGATIVE_SIX, IRRACIONAL_FIVE, '/'), DELTA);
        Assert.assertEquals(0.0, calculator.calculate(ZERO, TWO, '/'), DELTA);
        Assert.assertEquals(-3.0, calculator.calculate(NEGATIVE_SIX, TWO, '/'), DELTA);
        Assert.assertEquals(-1.0, calculator.calculate(NEGATIVE_TWO, TWO, '/'), DELTA);
        Assert.assertEquals(3.0, calculator.calculate(NEGATIVE_SIX, NEGATIVE_TWO, '/'), DELTA);
    }

    @Test
    public void multiplicationIsValid() {
        Assert.assertEquals(-4.0, calculator.calculate(TWO, NEGATIVE_TWO, '*'), DELTA);
        Assert.assertEquals(10.4734, calculator.calculate(TWO, IRRACIONAL_FIVE, '*'), DELTA);
        Assert.assertEquals(-12.0, calculator.calculate(TWO, NEGATIVE_SIX, '*'), DELTA);
        Assert.assertEquals(0.0, calculator.calculate(TWO, ZERO, '*'), DELTA);
        Assert.assertEquals(12.0, calculator.calculate(NEGATIVE_SIX, NEGATIVE_TWO, '*'), DELTA);
    }

    @Test
    public void additionIsValid() {
        Assert.assertEquals(-6.0, calculator.calculate(NEGATIVE_SIX, ZERO, '+'), DELTA);
        Assert.assertEquals(2.0, calculator.calculate(TWO, ZERO, '+'), DELTA);
        Assert.assertEquals(5.2367, calculator.calculate(IRRACIONAL_FIVE, ZERO, '+'), DELTA);
        Assert.assertEquals(-8.0, calculator.calculate(NEGATIVE_SIX, NEGATIVE_TWO, '+'), DELTA);
        Assert.assertEquals(2.0, calculator.calculate(TWO, ZERO, '+'), DELTA);
    }

    @Test
    public void subtractionIsValid() {
        Assert.assertEquals(-4.0, calculator.calculate(NEGATIVE_SIX, NEGATIVE_TWO, '-'), DELTA);
        Assert.assertEquals(4.0, calculator.calculate(TWO, NEGATIVE_TWO, '-'), DELTA);
        Assert.assertEquals(7.2367, calculator.calculate(IRRACIONAL_FIVE, NEGATIVE_TWO, '-'), DELTA);
        Assert.assertEquals(-2.0, calculator.calculate(ZERO, TWO, '-'), DELTA);
        Assert.assertEquals(-8.0, calculator.calculate(NEGATIVE_SIX, TWO, '-'), DELTA);
    }

    @Test
    public void exaltationInDegreeIsValid() {
        Assert.assertEquals(37.7054, calculator.calculate(TWO, IRRACIONAL_FIVE, '^'), DELTA);
        Assert.assertEquals(0.25, calculator.calculate(TWO, NEGATIVE_TWO, '^'), DELTA);
        Assert.assertEquals(36.0, calculator.calculate(NEGATIVE_SIX, TWO, '^'), DELTA);
        Assert.assertEquals(0.0, calculator.calculate(ZERO, TWO, '^'), DELTA);
        Assert.assertEquals(1.0, calculator.calculate(NEGATIVE_SIX, ZERO, '^'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void notValidDivisionOnZero() {
        calculator.calculate(TWO, ZERO, '/');
    }

    @Test(expected = ArithmeticException.class)
    public void notValidZeroInMinusDegree() {
        calculator.calculate(ZERO, NEGATIVE_SIX, '^');
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidValue() {
        calculator.calculate(TWO, null, '*');
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidSign() {
        calculator.calculate(NEGATIVE_TWO, ZERO, '%');
    }
}
