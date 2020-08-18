package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double ZERO = 0;
    private static final double POSITIVE_X = 2;
    private static final double POSITIVE_Y = 3;
    private static final double NEGATIVE_X = -2;
    private static final double NEGATIVE_Y = -3;
    private static final double DELTA = 0.0000001;

    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperationCharacterTest() {
        calculator.calculate(POSITIVE_X, POSITIVE_Y, 'h');
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        calculator.calculate(POSITIVE_X, ZERO, '/');
    }

    @Test
    public void additionTest() {
        double resultOne = calculator.calculate(POSITIVE_X, POSITIVE_Y, '+');
        double resultTwo = calculator.calculate(POSITIVE_X, NEGATIVE_X, '+');
        double resultThree = calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '+');
        double resultFour = calculator.calculate(POSITIVE_X, ZERO, '+');
        Assert.assertEquals(5, resultOne, DELTA);
        Assert.assertEquals(ZERO, resultTwo, DELTA);
        Assert.assertEquals(-5, resultThree, DELTA);
        Assert.assertEquals(POSITIVE_X, resultFour, DELTA);
    }

    @Test
    public void subtractionTest() {
        double resultOne = calculator.calculate(POSITIVE_X, POSITIVE_Y, '-');
        double resultTwo = calculator.calculate(POSITIVE_X, NEGATIVE_X, '-');
        double resultThree = calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '-');
        double resultFour = calculator.calculate(POSITIVE_X, ZERO, '-');
        Assert.assertEquals(-1, resultOne, DELTA);
        Assert.assertEquals(4, resultTwo, DELTA);
        Assert.assertEquals(1, resultThree, DELTA);
        Assert.assertEquals(POSITIVE_X, resultFour, DELTA);
    }

    @Test
    public void multiplicationTest() {
        double resultOne = calculator.calculate(POSITIVE_X, POSITIVE_Y, '*');
        double resultTwo = calculator.calculate(POSITIVE_X, NEGATIVE_X, '*');
        double resultThree = calculator.calculate(NEGATIVE_X, NEGATIVE_Y, '*');
        double resultFour = calculator.calculate(POSITIVE_X, ZERO, '*');
        Assert.assertEquals(6, resultOne, DELTA);
        Assert.assertEquals(-4, resultTwo, DELTA);
        Assert.assertEquals(6, resultThree, DELTA);
        Assert.assertEquals(ZERO, resultFour, DELTA);
    }

    @Test
    public void divisionTest() {
        double resultOne = calculator.calculate(POSITIVE_Y, POSITIVE_Y, '^');
        double resultTwo = calculator.calculate(ZERO, POSITIVE_X, '^');
        double resultThree = calculator.calculate(POSITIVE_X, ZERO, '^');
        Assert.assertEquals(27, resultOne, DELTA);
        Assert.assertEquals(ZERO, resultTwo, DELTA);
        Assert.assertEquals(1, resultThree, DELTA);
    }

    @Test
    public void powerTest() {
        double resultOne = calculator.calculate(POSITIVE_Y, POSITIVE_X, '/');
        double resultTwo = calculator.calculate(POSITIVE_X, NEGATIVE_X, '/');
        double resultThree = calculator.calculate(NEGATIVE_Y, NEGATIVE_X, '/');
        double resultFour = calculator.calculate(ZERO, POSITIVE_X, '/');
        Assert.assertEquals(1.5, resultOne, DELTA);
        Assert.assertEquals(-1, resultTwo, DELTA);
        Assert.assertEquals(1.5, resultThree, DELTA);
        Assert.assertEquals(ZERO, resultFour, DELTA);
    }
}