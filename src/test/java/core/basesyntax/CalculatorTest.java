package core.basesyntax;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    public void testAddOk() {
        int a = 15;
        int b = 20;
        int expectedResult = 35;
        long result = calculator.add(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testAddZeroOk() {
        int a = 15;
        int b = 0;
        int expectedResult = 15;
        long result = calculator.add(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testAddingOppositeNumbersOk() {
        int a = -15;
        int b = 15;
        int expectedResult = 0;
        long result = calculator.add(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testSubtractionOk() {
        int a = 25;
        int b = 20;
        int expectedResult = 5;
        int result = calculator.subtract(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testSubtractZeroOk() {
        int a = 25;
        int b = 0;
        int expectedResult = 25;
        int result = calculator.subtract(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testMultiplyOk() {
        int a = 10;
        int b = 25;
        int expectedResult = 250;
        int result = calculator.multiply(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testMultiplyByZero() {
        int a = 10;
        int b = 0;
        int expectedResult = 0;
        int result = calculator.multiply(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testDivideOk() {
        int a = 50;
        int b = 10;
        int expectedResult = 5;
        int result = calculator.divide(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testDivideByZeroValid() {
        int a = 15;
        int b = 0;
        calculator.divide(a, b);
    }

    @Test
    public void testDivideZeroValid() {
        int a = 0;
        int b = 10;
        int expectedResult = 0;
        int result = calculator.divide(a, b);
        Assert.assertEquals(expectedResult, result);
    }
}

