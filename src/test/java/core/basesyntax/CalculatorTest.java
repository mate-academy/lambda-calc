package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;
    public static final double DELTA = 0.01;

    @Before
    public void setCalculator(){
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        double result = calculator.calculate(25, '+', 25);
        Assert.assertEquals(50, result, DELTA);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.calculate(273.6, '-', 197.38);
        Assert.assertEquals(76.22, result, DELTA);
    }

    @Test
    public void multiplyTest() {
        double result = calculator.calculate(55, '*', 5);
        Assert.assertEquals(275, result, DELTA);
        result = calculator.calculate(55, '*', 0);
        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void divideTest() {
        double result = calculator.calculate(72, '/', 8);
        Assert.assertEquals(9, result, DELTA);
    }

    @Test
    public void negativeDegreeTest() {
        double result = calculator.calculate(10, '^', -2);
        Assert.assertEquals(0.01, result, DELTA);
    }

    @Test
    public void degreeTest() {
        double result = calculator.calculate(10, '^', 2);
        Assert.assertEquals(100, result, DELTA);
    }

    @Test
    public void zeroDegreeTest() {
        double result = calculator.calculate(10, '^', 0);
        Assert.assertEquals(1, result, DELTA);
    }

    @Test(expected = NullPointerException.class)
    public void wrongOperatorTest() {
        calculator.calculate(6, 'a', 4);
    }

}
