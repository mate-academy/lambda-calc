package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    //Addition
    @Test
    public void calculate_additionWithPositivesOperands_ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = 30;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_additionWithNegativesOperands_ok() {
        double firstNumber = -5;
        double secondNumber = -22;
        double expect = -27;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_additionWithDifferentOperands_ok() {
        double firstNumber = 25;
        double secondNumber = -15;
        double expect = 10;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_additionWithFirstZeroOperand_ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = -15;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_additionWithSecondZeroOperand_ok() {
        double firstNumber = -10;
        double secondNumber = 0;
        double expect = -10;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_additionMinAndMaxValue_ok() {
        double secondNumber = 5;
        double actual = calculator.calculate(Double.MAX_VALUE, secondNumber, '+');
        double expected = 1.7976931348623157E308;
        assertEquals(actual, expected, DELTA);
    }

    //Subtraction
    @Test
    public void calculate_subtractionWithPositivesOperands_ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = -10;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithNegativesOperands_ok() {
        double firstNumber = -5;
        double secondNumber = -25;
        double expect = 20;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithDifferentOperands_ok() {
        double firstNumber = -25;
        double secondNumber = 30;
        double expect = -55;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithFirstZeroOperand_ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = 15;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_subtractionWithSecondZeroOperand_ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        double expect = 10;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_subtractionMinAndMaxValue_ok() {
        double secondNumber = 1;
        double actual = calculator.calculate(Double.MIN_VALUE, secondNumber, '-');
        double expected = -1;
        assertEquals(actual, expected, DELTA);
    }

    //Multiple
    @Test
    public void calculate_multipleWithPositivesOperands_ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = 200;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_multipleWithNegativesOperands_ok() {
        double firstNumber = -5;
        double secondNumber = -5;
        double expect = 25;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_multipleWithDifferentOperands_ok() {
        double firstNumber = -2;
        double secondNumber = 5;
        double expect = -10;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_multipleWithFirstZeroOperand_ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_multipleWithSecondZeroOperand_ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_multipleMinAndMaxValue_ok() {
        double secondNumber = 2;
        double actual = calculator.calculate(Double.MIN_VALUE, secondNumber, '*');
        double expected = 1.0E-323;
        assertEquals(actual, expected, DELTA);
    }

    //Divide
    @Test
    public void calculate_divideWithPositivesOperands_ok() {
        double firstNumber = 10;
        double secondNumber = 20;
        double expect = 0.5;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_divideWithNegativesOperands_ok() {
        double firstNumber = -5;
        double secondNumber = -5;
        double expect = 1;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_divideWithDifferentOperands_ok() {
        double firstNumber = -20;
        double secondNumber = 5;
        double expect = -4;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_divideWithFirstZeroOperand_ok() {
        double firstNumber = 0;
        double secondNumber = -15;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void calculate_divideWithSecondZeroOperand_ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(firstNumber, secondNumber, '/');
        });
    }

    @Test
    public void calculate_divideMinAndMaxValue_ok() {
        double secondNumber = 2;
        double actual = calculator.calculate(Double.MAX_VALUE, secondNumber, '/');
        double expected = 8.988465674311579E307;
        assertEquals(actual, expected, DELTA);
    }

    //Raising
    @Test
    public void calculate_raisingWithPositivesOperands_ok() {
        double firstNumber = 10;
        double secondNumber = 2;
        double expect = 100;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    public void calculate_raisingWithNegativesOperands_ok() {
        double firstNumber = -5;
        double secondNumber = 3;
        double expect = -125;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    public void calculate_raisingWithDifferentOperands_ok() {
        double firstNumber = 5;
        double secondNumber = -3;
        double expect = 0.008;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    public void calculate_raisingWithFirstZeroOperand_ok() {
        double firstNumber = 0;
        double secondNumber = 2;
        double expect = 0;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    public void calculate_raisingWithSecondZeroOperand_ok() {
        double firstNumber = 10;
        double secondNumber = 0;
        double expect = 1;
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        assertEquals(expect, actual);
    }

    @Test
    public void calculate_raisingMinAndMaxValue_ok() {
        double secondNumber = 2;
        double actual = calculator.calculate(Double.MAX_VALUE, secondNumber, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(actual, expected, DELTA);
    }

    //Illegal operation
    @Test
    public void set_illegalOperation_notOk() {
        double secondNumber = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Double.MAX_VALUE, secondNumber, '?');
        });
    }
}
