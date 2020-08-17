package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;
import static core.basesyntax.Calculator.calculate;

public class CalculatorTest {
    private static final double DELTA = 0;
    private static final double POSITIVENUMBER = 5;
    private static final double NEGATIVENUMBER = -10;

    @Test(expected = ArithmeticException.class)
    public void wrongOperator() {
        calculate( POSITIVENUMBER, POSITIVENUMBER, '(');
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculate( POSITIVENUMBER, 0, '/');
    }

    @Test
    public void sumOfNumbers() {
        double calculatePositiveNumbers = calculate(POSITIVENUMBER, POSITIVENUMBER, '+');
        Assert.assertEquals(10, calculatePositiveNumbers, DELTA);
        double calculateNegativeNumbers = calculate(NEGATIVENUMBER, NEGATIVENUMBER, '+');
        Assert.assertEquals(-20, calculateNegativeNumbers, DELTA);
        double calculateNegativeWithPositiveNumbers = calculate(NEGATIVENUMBER, POSITIVENUMBER, '+');
        Assert.assertEquals(-5, calculateNegativeWithPositiveNumbers, DELTA);
    }

    @Test
    public void minusOfNumbers() {
        double calculatePositiveNumbers = calculate(POSITIVENUMBER, POSITIVENUMBER, '-');
        Assert.assertEquals(0, calculatePositiveNumbers, DELTA);
        double calculateNegativeNumbers = calculate(NEGATIVENUMBER, NEGATIVENUMBER, '-');
        Assert.assertEquals(0, calculateNegativeNumbers, DELTA);
        double calculateNegativeWithPositiveNumbers = calculate(NEGATIVENUMBER, POSITIVENUMBER, '-');
        Assert.assertEquals(-15, calculateNegativeWithPositiveNumbers, DELTA);
    }

    @Test
    public void divisionOfNumbers() {
        double calculatePositiveNumbers = calculate(POSITIVENUMBER, POSITIVENUMBER, '/');
        Assert.assertEquals(1, calculatePositiveNumbers, DELTA);
        double calculateNegativeNumbers = calculate(NEGATIVENUMBER, NEGATIVENUMBER, '/');
        Assert.assertEquals(1, calculateNegativeNumbers, DELTA);
        double calculateNegativeWithPositiveNumbers = calculate(NEGATIVENUMBER, POSITIVENUMBER, '/');
        Assert.assertEquals(-2, calculateNegativeWithPositiveNumbers, DELTA);
    }

    @Test
    public void multiplicationOfNumbers() {
        double calculatePositiveNumbers = calculate(POSITIVENUMBER, POSITIVENUMBER, '*');
        Assert.assertEquals(25, calculatePositiveNumbers, DELTA);
        double calculateNegativeNumbers = calculate(NEGATIVENUMBER, NEGATIVENUMBER, '*');
        Assert.assertEquals(100, calculateNegativeNumbers, DELTA);
        double calculateNegativeWithPositiveNumbers = calculate(NEGATIVENUMBER, POSITIVENUMBER, '*');
        Assert.assertEquals(-50, calculateNegativeWithPositiveNumbers, DELTA);
    }

    @Test
    public void exponentiationOfNumbers() {
        double calculatePositiveNumbers = calculate(POSITIVENUMBER, POSITIVENUMBER, '^');
        Assert.assertEquals(3125, calculatePositiveNumbers, DELTA);
        double calculateNegativeNumbers = calculate(NEGATIVENUMBER, NEGATIVENUMBER, '^');
        Assert.assertEquals(0.0000000001, calculateNegativeNumbers, DELTA);
        double calculateNegativeWithPositiveNumbers = calculate(NEGATIVENUMBER, POSITIVENUMBER, '^');
        Assert.assertEquals(-100000, calculateNegativeWithPositiveNumbers, DELTA);
    }
}
