package core.basesyntax;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';
    private static final double POSITIVE_THREE = 3.0;
    private static final double POSITIVE_HALF = 0.5;
    private static final double NEGATIVE_THREE = -3.0;
    private static final double NEGATIVE_HALF = -0.5;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0000001;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveNumTest() {
        double result = calculator.calculate(POSITIVE_THREE, POSITIVE_HALF, ADDITION);
        Assert.assertEquals(3.5, result, DELTA);
    }

    @Test
    public void additionNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, NEGATIVE_HALF, ADDITION);
        Assert.assertEquals(-3.5, result, DELTA);
    }

    @Test
    public void additionPositiveAndNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, POSITIVE_THREE, ADDITION);
        Assert.assertEquals(0, result, DELTA);
        result = calculator.calculate(POSITIVE_THREE, NEGATIVE_HALF, ADDITION);
        Assert.assertEquals(2.5, result, DELTA);
    }

    @Test
    public void subtractionPositiveNumTest() {
        double result = calculator.calculate(POSITIVE_THREE, POSITIVE_HALF, SUBTRACTION);
        Assert.assertEquals(2.5, result, DELTA);
        result = calculator.calculate(POSITIVE_THREE, ZERO, SUBTRACTION);
        Assert.assertEquals(3, result, DELTA);
    }

    @Test
    public void subtractionNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, NEGATIVE_HALF, SUBTRACTION);
        Assert.assertEquals(-2.5, result, DELTA);
        result = calculator.calculate(NEGATIVE_HALF, ZERO, SUBTRACTION);
        Assert.assertEquals(-0.5, result, DELTA);
    }

    @Test
    public void subtractionPositiveAndNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, POSITIVE_HALF, SUBTRACTION);
        Assert.assertEquals(-3.5, result, DELTA);
    }

    @Test
    public void multiplicationPositiveNumTest() {
        double result = calculator.calculate(POSITIVE_THREE, POSITIVE_HALF, MULTIPLICATION);
        Assert.assertEquals(1.5, result, DELTA);
        result = calculator.calculate(POSITIVE_THREE, ZERO, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void multiplicationNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, NEGATIVE_HALF, MULTIPLICATION);
        Assert.assertEquals(1.5, result, DELTA);
        result = calculator.calculate(NEGATIVE_THREE, ZERO, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void multiplicationPositiveAndNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, POSITIVE_THREE, MULTIPLICATION);
        Assert.assertEquals(-9, result, DELTA);
    }

    @Test
    public void divisionPositiveNumTest() {
        double result = calculator.calculate(POSITIVE_THREE, POSITIVE_HALF, DIVISION);
        Assert.assertEquals(6, result, DELTA);
    }

    @Test
    public void divisionNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, NEGATIVE_HALF, DIVISION);
        Assert.assertEquals(6, result, DELTA);
    }

    @Test
    public void divisionPositiveAndNegativeNumTest() {
        double result = calculator.calculate(POSITIVE_THREE, NEGATIVE_HALF, DIVISION);
        Assert.assertEquals(-6, result, DELTA);
    }

    @Test
    public void powerPositiveNumTest() {
        double result = calculator.calculate(POSITIVE_THREE, POSITIVE_THREE, RAISING_TO_POWER);
        Assert.assertEquals(27, result, DELTA);
    }

    @Test
    public void powerNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, NEGATIVE_THREE, RAISING_TO_POWER);
        Assert.assertEquals(-0.037037037037037, result, DELTA);
    }

    @Test
    public void powerPositiveAndNegativeNumTest() {
        double result = calculator.calculate(NEGATIVE_THREE, POSITIVE_THREE, RAISING_TO_POWER);
        Assert.assertEquals(-27, result, DELTA);
        result = calculator.calculate(POSITIVE_THREE, NEGATIVE_THREE, RAISING_TO_POWER);
        Assert.assertEquals(0.037037037037037, result, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        calculator.calculate(POSITIVE_THREE, ZERO, DIVISION);
        calculator.calculate(NEGATIVE_THREE, ZERO, DIVISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidOperationSign() {
        calculator.calculate(POSITIVE_THREE, ZERO, '=');
        calculator.calculate(NEGATIVE_THREE, ZERO, '%');
    }
}