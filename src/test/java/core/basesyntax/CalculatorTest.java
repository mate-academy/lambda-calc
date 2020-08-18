package core.basesyntax;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char DIVISION = '/';
    private final char MULTIPLICATION = '*';
    private final char RAISING_TO_POWER = '^';
    private final double DELTA = 0.0000001;
    private static Calculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionPositiveNumTest() {
        double result = calculator.calculate(8, 20, ADDITION);
        Assert.assertEquals(28, result, DELTA);
        result = calculator.calculate(1000000, 0.0001, ADDITION);
        Assert.assertEquals(1000000.0001, result, DELTA);
    }

    @Test
    public void additionNegativeNumTest() {
        double result = calculator.calculate(-8, -20, ADDITION);
        Assert.assertEquals(-28, result, DELTA);
        result = calculator.calculate(-1000000, -0.0001, ADDITION);
        Assert.assertEquals(-1000000.0001, result, DELTA);
    }

    @Test
    public void additionPositiveAndNegativeNumTest() {
        double result = calculator.calculate(-8, 20, ADDITION);
        Assert.assertEquals(12, result, DELTA);
        result = calculator.calculate(8, -20, ADDITION);
        Assert.assertEquals(-12, result, DELTA);
    }

    @Test
    public void subtractionPositiveNumTest() {
        double result = calculator.calculate(8, 20, SUBTRACTION);
        Assert.assertEquals(-12, result, DELTA);
        result = calculator.calculate(1000000, 0.0001, SUBTRACTION);
        Assert.assertEquals(999999.9999, result, DELTA);
        result = calculator.calculate(8, 0, SUBTRACTION);
        Assert.assertEquals(8, result, DELTA);
    }

    @Test
    public void subtractionNegativeNumTest() {
        double result = calculator.calculate(-8, -20, SUBTRACTION);
        Assert.assertEquals(12, result, DELTA);
        result = calculator.calculate(-1000000, -0.0001, SUBTRACTION);
        Assert.assertEquals(-999999.9999, result, DELTA);
        result = calculator.calculate(-8, 0, SUBTRACTION);
        Assert.assertEquals(-8, result, DELTA);
    }

    @Test
    public void subtractionPositiveAndNegativeNumTest() {
        double result = calculator.calculate(-8, 20, SUBTRACTION);
        Assert.assertEquals(-28, result, DELTA);
        result = calculator.calculate(8, -20, SUBTRACTION);
        Assert.assertEquals(28, result, DELTA);
    }

    @Test
    public void multiplicationPositiveNumTest() {
        double result = calculator.calculate(8, 20, MULTIPLICATION);
        Assert.assertEquals(160, result, DELTA);
        result = calculator.calculate(1000000, 0.0001, MULTIPLICATION);
        Assert.assertEquals(100, result, DELTA);
        result = calculator.calculate(8, 0, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void multiplicationNegativeNumTest() {
        double result = calculator.calculate(-8, -20, MULTIPLICATION);
        Assert.assertEquals(160, result, DELTA);
        result = calculator.calculate(-1000000, -0.0001, MULTIPLICATION);
        Assert.assertEquals(100, result, DELTA);
        result = calculator.calculate(-8, 0, MULTIPLICATION);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void multiplicationPositiveAndNegativeNumTest() {
        double result = calculator.calculate(-8, 20, MULTIPLICATION);
        Assert.assertEquals(-160, result, DELTA);
        result = calculator.calculate(8, -20, MULTIPLICATION);
        Assert.assertEquals(-160, result, DELTA);
        result = calculator.calculate(-1000000, 0.0001, MULTIPLICATION);
        Assert.assertEquals(-100, result, DELTA);
    }

    @Test
    public void divisionPositiveNumTest() {
        double result = calculator.calculate(8, 20, DIVISION);
        Assert.assertEquals(0.4, result, DELTA);
        result = calculator.calculate(20, 8, DIVISION);
        Assert.assertEquals(2.5, result, DELTA);
        result = calculator.calculate(1000000, 0.0001, DIVISION);
        Assert.assertEquals(1e10, result, DELTA);
    }

    @Test
    public void divisionNegativeNumTest() {
        double result = calculator.calculate(-8, -20, DIVISION);
        Assert.assertEquals(0.4, result, DELTA);
        result = calculator.calculate(-1000000, -0.0001, DIVISION);
        Assert.assertEquals(1e10, result, DELTA);
    }

    @Test
    public void divisionPositiveAndNegativeNumTest() {
        double result = calculator.calculate(-8, 20, DIVISION);
        Assert.assertEquals(-0.4, result, DELTA);
        result = calculator.calculate(8, -20, DIVISION);
        Assert.assertEquals(-0.4, result, DELTA);
        result = calculator.calculate(-1000000, 0.0001, DIVISION);
        Assert.assertEquals(-1e10, result, DELTA);
    }

    @Test
    public void powerPositiveNumTest() {
        double result = calculator.calculate(2, 8, RAISING_TO_POWER);
        Assert.assertEquals(256, result, DELTA);
        result = calculator.calculate(2, 0.2, RAISING_TO_POWER);
        Assert.assertEquals(1.148698354997035, result, DELTA);
        result = calculator.calculate(0.5, 3, RAISING_TO_POWER);
        Assert.assertEquals(0.125, result, DELTA);
        result = calculator.calculate(0.5, 0, RAISING_TO_POWER);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void powerNegativeNumTest() {
        double result = calculator.calculate(-2, -3, RAISING_TO_POWER);
        Assert.assertEquals(-0.125, result, DELTA);
    }

    @Test
    public void powerPositiveAndNegativeNumTest() {
        double result = calculator.calculate(-2, 3, RAISING_TO_POWER);
        Assert.assertEquals(-8, result, DELTA);
        result = calculator.calculate(8, -2, RAISING_TO_POWER);
        Assert.assertEquals(0.015625, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionByZero() {
        calculator.calculate(8, 0, DIVISION);
        calculator.calculate(-8, 0, DIVISION);
        calculator.calculate(0.0001, 0, DIVISION);
    }
}