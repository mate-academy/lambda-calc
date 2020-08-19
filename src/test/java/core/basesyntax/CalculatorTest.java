package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class CalculatorTest {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final char ILLEGAL_ACTION = '&';
    private static final int ZERO = 0;
    private static final double NUMBER_1 = 2.0;
    private static final double NUMBER_2 = 3.0;
    private static final double DOUBLE_MAX_VALUE = Math.pow(2, 63) - 1;
    private static final double NEGATIVE_NUMBER_1 = -2.0;
    private static final double NEGATIVE_NUMBER_2 = -3.0;
    private static final double DOUBLE_MAX_NEGATIVE_VALUE = Math.pow(-2, 63);
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
        Calculator calculator = new Calculator();
    }

    @Test
    public void additionIsOk() {
        Assert.assertEquals(5.0, Calculator.calculate(NUMBER_1, NUMBER_2, ADDITION), DELTA);
        Assert.assertEquals(-5.0, Calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, ADDITION), DELTA);
        Assert.assertEquals(-1.0, Calculator.calculate(NUMBER_1, NEGATIVE_NUMBER_2, ADDITION), DELTA);
    }

    @Test
    public void additionWithMaxValueIsOk() {
        Assert.assertEquals(2.0 + Math.pow(-2, 63), Calculator.calculate(NUMBER_1, DOUBLE_MAX_NEGATIVE_VALUE, ADDITION), DELTA);
    }

    @Test
    public void subtractionIsOk() {
        Assert.assertEquals(-1.0, Calculator.calculate(NUMBER_1, NUMBER_2, SUBTRACTION), DELTA);
        Assert.assertEquals(1.0, Calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, SUBTRACTION), DELTA);
        Assert.assertEquals(5.0, Calculator.calculate(NUMBER_1, NEGATIVE_NUMBER_2, SUBTRACTION), DELTA);
    }

    @Test
    public void subtractionWithMaxValueIsOk() {
        Assert.assertEquals(2.0 - Math.pow(2, 63) - 1, Calculator.calculate(NUMBER_1, DOUBLE_MAX_VALUE, SUBTRACTION), DELTA);
    }

    @Test
    public void multiplicationIsOk() {
        Assert.assertEquals(6.0, Calculator.calculate(NUMBER_1, NUMBER_2, MULTIPLICATION), DELTA);
        Assert.assertEquals(6.0, Calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, MULTIPLICATION), DELTA);
        Assert.assertEquals(-6.0, Calculator.calculate(NUMBER_1, NEGATIVE_NUMBER_2, MULTIPLICATION), DELTA);
    }

    @Test
    public void divisionIsOk() {
        Assert.assertEquals(1.5, Calculator.calculate(NUMBER_2, NUMBER_1, DIVISION), DELTA);
    }

    @Test
    public void divisionByNegativeNumberIsOk() {
        Assert.assertEquals(1.5, Calculator.calculate(NEGATIVE_NUMBER_2, NEGATIVE_NUMBER_1, DIVISION), DELTA);
        Assert.assertEquals(-1.5, Calculator.calculate(NUMBER_2, NEGATIVE_NUMBER_1, DIVISION), DELTA);
    }

    @Test
    public void raisingToPowerIsOk() {
        Assert.assertEquals(8.0, Calculator.calculate(NUMBER_1, NUMBER_2, POWER), DELTA);
        Assert.assertEquals(-0.125, Calculator.calculate(NEGATIVE_NUMBER_1, NEGATIVE_NUMBER_2, POWER), DELTA);
        Assert.assertEquals(1, Calculator.calculate(NUMBER_1, ZERO, POWER), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        Calculator.calculate(NUMBER_1, ZERO, DIVISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalAction() {
        Calculator.calculate(NUMBER_1, ZERO, ILLEGAL_ACTION);
    }
}
