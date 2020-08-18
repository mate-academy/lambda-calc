package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1E-10;
    private static final double FIRST_POSITIVE = 12;
    private static final double FIRST_NEGATIVE = -3;
    private static final double SECOND_POSITIVE = 6;
    private static final double SECOND_NEGATIVE = -4;
    private static final double EVEN_POSITIVE = 2;
    private static final double ODD_POSITIVE = 3;
    private static final double EVEN_NEGATIVE = -2;
    private static final double ODD_NEGATIVE = -3;
    private static final double FRACTION = 0.5;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = RuntimeException.class)
    public void nonexistentOperation() {
        calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '?');
    }

    @Test
    public void addIsOk() {
        Assert.assertEquals(18, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '+'), DELTA);
        Assert.assertEquals(3, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '+'), DELTA);
        Assert.assertEquals(8, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '+'), DELTA);
        Assert.assertEquals(-7, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '+'), DELTA);
        Assert.assertEquals(6, calculator.calculate(0, SECOND_POSITIVE, '+'), DELTA);
        Assert.assertEquals(12, calculator.calculate(FIRST_POSITIVE, 0, '+'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, 0, '+'), DELTA);
    }

    @Test
    public void subtractIsOK() {
        Assert.assertEquals(6, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '-'), DELTA);
        Assert.assertEquals(-9, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '-'), DELTA);
        Assert.assertEquals(16, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '-'), DELTA);
        Assert.assertEquals(1, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '-'), DELTA);
        Assert.assertEquals(-6, calculator.calculate(0, SECOND_POSITIVE, '-'), DELTA);
        Assert.assertEquals(12, calculator.calculate(FIRST_POSITIVE, 0, '-'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, 0, '-'), DELTA);
    }

    @Test
    public void multiplyIsOK() {
        Assert.assertEquals(72, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '*'), DELTA);
        Assert.assertEquals(-18, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '*'), DELTA);
        Assert.assertEquals(-48, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '*'), DELTA);
        Assert.assertEquals(12, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '*'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, SECOND_POSITIVE, '*'), DELTA);
        Assert.assertEquals(0, calculator.calculate(FIRST_POSITIVE, 0, '*'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, 0, '*'), DELTA);
    }

    @Test
    public void divisionIsOK() {
        Assert.assertEquals(2, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '/'), DELTA);
        Assert.assertEquals(-0.5, calculator.calculate(FIRST_NEGATIVE, SECOND_POSITIVE, '/'), DELTA);
        Assert.assertEquals(-3, calculator.calculate(FIRST_POSITIVE, SECOND_NEGATIVE, '/'), DELTA);
        Assert.assertEquals(0.75, calculator.calculate(FIRST_NEGATIVE, SECOND_NEGATIVE, '/'), DELTA);
        Assert.assertEquals(0, calculator.calculate(0, SECOND_POSITIVE, '/'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroCheck() {
        calculator.calculate(FIRST_POSITIVE, 0, '/');
        calculator.calculate(0, 0, '/');
    }

    @Test
    public void powerIsOK() {
        Assert.assertEquals(2985984, calculator.calculate(FIRST_POSITIVE, SECOND_POSITIVE, '^'), DELTA);
    }

    @Test
    public void powerEvenAndOddPositivePower() {
        Assert.assertEquals(144, calculator.calculate(FIRST_POSITIVE, EVEN_POSITIVE, '^'), DELTA);
        Assert.assertEquals(-27, calculator.calculate(FIRST_NEGATIVE, ODD_POSITIVE, '^'), DELTA);
    }

    @Test
    public void powerEvenAndOddNegativePower() {
        Assert.assertEquals(0.006944444444444444,
                calculator.calculate(FIRST_POSITIVE, EVEN_NEGATIVE, '^'), DELTA);
        Assert.assertEquals(-0.037037037037037035,
                calculator.calculate(FIRST_NEGATIVE, ODD_NEGATIVE, '^'), DELTA);
    }

    @Test
    public void powerWithZero() {
        Assert.assertEquals(0.0, calculator.calculate(0, SECOND_POSITIVE, '^'), DELTA);
        Assert.assertEquals(1.0, calculator.calculate(FIRST_POSITIVE, 0, '^'), DELTA);
        Assert.assertEquals(1.0, calculator.calculate(0, 0, '^'), DELTA);
    }

    @Test
    public void powerWithFraction() {
        Assert.assertEquals(3.4641016151377544, calculator.calculate(FIRST_POSITIVE, FRACTION, '^'), DELTA);
    }
}
