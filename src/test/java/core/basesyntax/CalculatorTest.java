package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class CalculatorTest {

    private Calculator calculatorTest = new Calculator();
    private static final double DELTA = 0.1;

    @Test
    void calculateAdditionOk() {
        assertEquals(4, calculatorTest.calculate(2, '+', 2), DELTA);
    }

    @Test
    void calculateSubtractionOk() {
        assertEquals(0, calculatorTest.calculate(2, '-', 2), DELTA);
    }

    @Test
    void calculateMultiplicationOk() {
        assertEquals(4, calculatorTest.calculate(2, '*', 2), DELTA);
    }

    @Test
    void calculateDivisionOk() {
        assertEquals(1, calculatorTest.calculate(2, '/', 2), DELTA);
    }

    @Test
    void calculateIllegalArgumentException() {
        try {
            calculatorTest.calculate(2, ']', 2);
            fail("Test failed, expected exception");
        } catch (IllegalArgumentException exception) {
            assertEquals("Sorry, illegal operand", exception.getMessage());
        }
    }

    @Test
    void additionOk() {
        assertEquals(4, calculatorTest.addition(2, 2), DELTA);
    }

    @Test
    void additionWithMinus() {
        assertEquals(0, calculatorTest.addition(2, -2), DELTA);
    }

    @Test
    void additionNegativeByNegative() {
        assertEquals(-4, calculatorTest.addition(-2, -2), DELTA);
    }

    @Test
    void subtractionOk() {
        assertEquals(0, calculatorTest.subtraction(2, 2), DELTA);
    }

    @Test
    void subtractionWithMinus() {
        assertEquals(4, calculatorTest.subtraction(2, -2), DELTA);
    }

    @Test
    void subtractionNegativeByNegative() {
        assertEquals(0, calculatorTest.subtraction(-2, -2), DELTA);
    }

    @Test
    void divisionByZeroExceptionExpected() {
        try {
            calculatorTest.division(2, 0);
            fail("Test failed, expected exception");
        } catch (IllegalArgumentException exception) {
            assertEquals("You can't divide by zero", exception.getMessage());
        }
    }

    @Test
    void divisionZero() {
        assertEquals(0, calculatorTest.division(0, 2), DELTA);
    }

    @Test
    void divisionOK() {
        assertEquals(2, calculatorTest.division(4, 2), DELTA);
    }

    @Test
    void divisionNegativeByNegative() {
        assertEquals(1, calculatorTest.division(-2, -2), DELTA);
    }

    @Test
    void divisionByNegative() {
        assertEquals(-1, calculatorTest.division(2, -2), DELTA);
    }

    @Test
    void multiplicationOk() {
        assertEquals(4, calculatorTest.multiplication(2, 2), DELTA);
    }

    @Test
    void multiplicationZero() {
        assertEquals(0, calculatorTest.multiplication(0, 2), DELTA);
    }

    @Test
    void multiplicationFloatOk() {
        assertEquals(4.4, calculatorTest.multiplication(2.2, 2), DELTA);
    }

    @Test
    void raisingToThePowerOk() {
        assertEquals(4, calculatorTest.raisingToThePower(2, 2), DELTA);
    }

    @Test
    void raisingToThePower0() {
        assertEquals(1, calculatorTest.raisingToThePower(2, 0), DELTA);
    }

    @Test
    void raisingToTheMinusPower() {
        assertEquals(0.5, calculatorTest.raisingToThePower(2, -1), DELTA);
    }

    @Test
    void raisingToTheFloatPower() {
        assertEquals(2, calculatorTest.raisingToThePower(4, 0.5), DELTA);
    }
}