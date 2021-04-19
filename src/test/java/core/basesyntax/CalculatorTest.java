package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    //Addition
    @Test
    void additionWithPositivesOperands_Ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = 30;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void additionWithNegativesOperands_Ok() {
        double firstNumber = -5;
        double secondNumber = -22;
        double expect = -27;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void additionWithDifferentOperands_Ok() {
        double firstNumber = 25;
        double secondNumber = -15;
        double expect = 10;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void additionWithFirstZeroOperand_Ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = -15;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void additionWithSecondZeroOperand_Ok() {
        double firstNumber = -10;
        double secondNumber = 0;
        double expect = -10;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void additionMinAndMaxValue_Ok() {
        double secondNumber = 5;
        double actual = calculator.calculate(Double.MAX_VALUE, secondNumber, '+');
        double expected = 1.7976931348623157E308;
        assertEquals(actual, expected, DELTA);
    }

    //Subtraction
    @Test
    void subtractionWithPositivesOperands_Ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = -10;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void subtractionWithNegativesOperands_Ok() {
        double firstNumber = -5;
        double secondNumber = -25;
        double expect = 20;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void subtractionWithDifferentOperands_Ok() {
        double firstNumber = -25;
        double secondNumber = 30;
        double expect = -55;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void subtractionWithFirstZeroOperand_Ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = 15;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void subtractionWithSecondZeroOperand_Ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        double expect = 10;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void subtractionMinAndMaxValue_Ok() {
        double secondNumber = 1;
        double actual = calculator.calculate(Double.MIN_VALUE, secondNumber, '-');
        double expected = -1;
        assertEquals(actual, expected, DELTA);
    }

    //Multiple
    @Test
    void multipleWithPositivesOperands_Ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = 200;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void multipleWithNegativesOperands_Ok() {
        double firstNumber = -5;
        double secondNumber = -5;
        double expect = 25;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void multipleWithDifferentOperands_Ok() {
        double firstNumber = -2;
        double secondNumber = 5;
        double expect = -10;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void multipleWithFirstZeroOperand_Ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void multipleWithSecondZeroOperand_Ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void multipleMinAndMaxValue_Ok() {
        double secondNumber = 2;
        double actual = calculator.calculate(Double.MIN_VALUE, secondNumber, '*');
        double expected = 1.0E-323;
        assertEquals(actual, expected, DELTA);
    }

    //Divide
    @Test
    void divideWithPositivesOperands_Ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = 0.5;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void divideWithNegativesOperands_Ok() {
        double firstNumber = -5;
        double secondNumber = -5;
        double expect = 1;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void divideWithDifferentOperands_Ok() {
        double firstNumber = -20;
        double secondNumber = 5;
        double expect = -4;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void divideWithFirstZeroOperand_Ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    void divideWithSecondZeroOperand_Ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstNumber, secondNumber, '/');
        });
    }

    @Test
    void divideMinAndMaxValue_Ok() {
        double secondNumber = 2;
        double actual = calculator.calculate(Double.MAX_VALUE, secondNumber, '/');
        double expected = 8.988465674311579E307;
        assertEquals(actual, expected, DELTA);
    }

    //Raising
    @Test
    void raisingWithPositivesOperands_Ok() {
        double firstNumber = 10;
        double secondNumber = 2;
        double expect = 100;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    void raisingWithNegativesOperands_Ok() {
        double firstNumber = -5;
        double secondNumber = 3;
        double expect = -125;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    void raisingWithDifferentOperands_Ok() {
        double firstNumber = 5;
        double secondNumber = -3;
        double expect = 0.008;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    void raisingWithFirstZeroOperand_Ok() {
        double firstNumber = 0;
        double secondNumber = 2;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    void raisingWithSecondZeroOperand_Ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        double expect = 1;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    void raisingMinAndMaxValue_Ok() {
        double secondNumber = 2;
        double actual = calculator.calculate(Double.MAX_VALUE, secondNumber, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(actual, expected, DELTA);
    }

    //Illegal operation
    @Test
    void illegalOperation_NotOk() {
        double secondNumber = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, secondNumber, '?');
        });
    }
}
