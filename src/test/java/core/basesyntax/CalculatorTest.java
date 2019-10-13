package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private static final double INFINITY = 1. / 0;
    private static final double NAN = 0. / 0;

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgument() {
        calculator.calculate(3, 4, '2');
    }

    @Test
    public void addingOk() {
        double result = calculator.calculate(5, 10, '+');
        Assert.assertEquals("Incorrect result while positive numbers adding", 15, result, 0);
        result = calculator.calculate(-5, -10, '+');
        Assert.assertEquals("Incorrect result while negative numbers adding", -15, result, 0);
        result = calculator.calculate(-5, 10, '+');
        Assert.assertEquals("Incorrect result while first negative number adding", 5, result, 0);
        result = calculator.calculate(5, -10, '+');
        Assert.assertEquals("Incorrect result while second negative number adding", -5, result, 0);
        result = calculator.calculate(0, 10, '+');
        Assert.assertEquals("Incorrect result with zero first adding", 10, result, 0);
        result = calculator.calculate(5, 0, '+');
        Assert.assertEquals("Incorrect result with zero second adding", 5, result, 0);
    }

    @Test
    public void subtractionOk() {
        double result = calculator.calculate(10, 5, '-');
        Assert.assertEquals("Incorrect result while positive numbers subtraction", 5, result, 0);
        result = calculator.calculate(-5, -10, '-');
        Assert.assertEquals("Incorrect result while negative numbers subtraction", 5, result, 0);
        result = calculator.calculate(-5, 10, '-');
        Assert.assertEquals("Incorrect result while first negative number subtraction", -15, result, 0);
        result = calculator.calculate(5, -10, '-');
        Assert.assertEquals("Incorrect result while second negative number subtraction", 15, result, 0);
        result = calculator.calculate(0, 10, '-');
        Assert.assertEquals("Incorrect result with zero first subtraction", -10, result, 0);
        result = calculator.calculate(5, 0, '-');
        Assert.assertEquals("Incorrect result with zero second subtraction", 5, result, 0);
    }

    @Test
    public void multiplicationOk() {
        double result = calculator.calculate(10, 5, '*');
        Assert.assertEquals("Incorrect result while positive numbers multiplication", 50, result, 0);
        result = calculator.calculate(-5, -10, '*');
        Assert.assertEquals("Incorrect result while negative numbers multiplication", 50, result, 0);
        result = calculator.calculate(-5, 10, '*');
        Assert.assertEquals("Incorrect result while first negative number multiplication", -50, result, 0);
        result = calculator.calculate(5, -10, '*');
        Assert.assertEquals("Incorrect result while second negative number multiplication", -50, result, 0);
        result = calculator.calculate(0, 10, '*');
        Assert.assertEquals("Incorrect result with zero first multiplication", 0, result, 0);
        result = calculator.calculate(5, 0, '*');
        Assert.assertEquals("Incorrect result with zero second multiplication", 0, result, 0);
        result = calculator.calculate(10000, 1000, '*');
        Assert.assertEquals("Incorrect result while big values multiplication", 1.0E7, result, 0);
    }

    @Test
    public void divisionOk() {
        double result = calculator.calculate(10, 5, '/');
        Assert.assertEquals("Incorrect result while positive numbers division", 2, result, 0);
        result = calculator.calculate(-5, -10, '/');
        Assert.assertEquals("Incorrect result while negative numbers division", 0.5, result, 0);
        result = calculator.calculate(-5, 10, '/');
        Assert.assertEquals("Incorrect result while first negative number division", -0.5, result, 0);
        result = calculator.calculate(5, -10, '/');
        Assert.assertEquals("Incorrect result while second negative number division", -0.5, result, 0);
        result = calculator.calculate(0, 10, '/');
        Assert.assertEquals("Incorrect result with zero first division", 0, result, 0);
        result = calculator.calculate(5, 0, '/');
        Assert.assertEquals("Incorrect result with zero second division", INFINITY, result, 0);
        result = calculator.calculate(0, 0, '/');
        Assert.assertEquals("Incorrect result with both zeros division", NAN, result, 0);
        result = calculator.calculate(1, 100000, '/');
        Assert.assertEquals("Incorrect result while small value result", 1.0E-5, result, 0);
    }

    @Test
    public void exponentiationOk() {
        double result = calculator.calculate(3, 5, '^');
        Assert.assertEquals("Incorrect result while positive numbers exponentiation", 243, result, 0);
        result = calculator.calculate(-3, -1, '^');
        Assert.assertEquals("Incorrect result while negative numbers exponentiation", -0.3333333333333333, result, 0);
        result = calculator.calculate(-3, 5, '^');
        Assert.assertEquals("Incorrect result while first negative number exponentiation", -243, result, 0);
        result = calculator.calculate(3, -1, '^');
        Assert.assertEquals("Incorrect result while second negative number exponentiation", 0.3333333333333333, result, 0);
        result = calculator.calculate(0, 10, '^');
        Assert.assertEquals("Incorrect result with zero first positive second exponentiation", 0, result, 0);
        result = calculator.calculate(0, -3, '^');
        Assert.assertEquals("Incorrect result with zero first negative second exponentiation", INFINITY, result, 0);
        result = calculator.calculate(5, 0, '^');
        Assert.assertEquals("Incorrect result with zero second exponentiation", 1, result, 0);
    }
}
