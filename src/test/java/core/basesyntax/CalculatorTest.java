package core.basesyntax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculatorTest = new Calculator();
    private static final double DELTA = 1e-10;

    @Test
    public void calculateAdditionOk() {
        assertEquals(4, calculatorTest.calculate(2, '+', 2), DELTA);
    }

    @Test
    public void calculateSubtractionOk() {
        assertEquals(0, calculatorTest.calculate(2, '-', 2), DELTA);
    }

    @Test
    public void calculateMultiplicationOk() {
        assertEquals(4, calculatorTest.calculate(2, '*', 2), DELTA);
    }

    @Test
    public void calculateDivisionOk() {
        assertEquals(1, calculatorTest.calculate(2, '/', 2), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateIllegalArgumentException() {
        calculatorTest.calculate(2, ']', 2);
    }

    @Test
    public void additionOk() {
        assertEquals(4, calculatorTest.addition(2, 2), DELTA);
    }

    @Test
    public void additionWithMinus() {
        assertEquals(0, calculatorTest.addition(2, -2), DELTA);
    }

    @Test
    public void additionNegativeByNegative() {
        assertEquals(-4, calculatorTest.addition(-2, -2), DELTA);
    }

    @Test
    public void subtractionOk() {
        assertEquals(0, calculatorTest.subtraction(2, 2), DELTA);
    }

    @Test
    public void subtractionWithMinus() {
        assertEquals(4, calculatorTest.subtraction(2, -2), DELTA);
    }

    @Test
    public void subtractionNegativeByNegative() {
        assertEquals(0, calculatorTest.subtraction(-2, -2), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionByZeroExceptionExpected() {
        calculatorTest.division(2, 0);
    }

    @Test
    public void divisionZero() {
        assertEquals(0, calculatorTest.division(0, 2), DELTA);
    }

    @Test
    public void divisionOK() {
        assertEquals(2, calculatorTest.division(4, 2), DELTA);
    }

    @Test
    public void divisionNegativeByNegative() {
        assertEquals(1, calculatorTest.division(-2, -2), DELTA);
    }

    @Test
    public void divisionByNegative() {
        assertEquals(-1, calculatorTest.division(2, -2), DELTA);
    }

    @Test
    public void multiplicationOk() {
        assertEquals(4, calculatorTest.multiplication(2, 2), DELTA);
    }

    @Test
    public void multiplicationZero() {
        assertEquals(0, calculatorTest.multiplication(0, 2), DELTA);
    }

    @Test
    public void multiplicationFloatOk() {
        assertEquals(4.4, calculatorTest.multiplication(2.2, 2), DELTA);
    }

    @Test
    public void raisingToThePowerOk() {
        assertEquals(4, calculatorTest.raisingToThePower(2, 2), DELTA);
    }

    @Test
    public void raisingToThePower0() {
        assertEquals(1, calculatorTest.raisingToThePower(2, 0), DELTA);
    }

    @Test
    public void raisingToTheMinusPower() {
        assertEquals(0.5, calculatorTest.raisingToThePower(2, -1), DELTA);
    }

    @Test
    public void raisingToTheFloatPower() {
        assertEquals(2, calculatorTest.raisingToThePower(4, 0.5), DELTA);
    }
}
