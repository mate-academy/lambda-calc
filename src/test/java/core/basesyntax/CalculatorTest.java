package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exceptions.IllegalOperationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;
    private double firstOperand;
    private double secondOperand;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void calculate_illegalOperation_notOk() {
        firstOperand = 2;
        secondOperand = 0.0625;
        assertThrows(IllegalOperationException.class,
                () -> calculator.calculate(firstOperand, secondOperand, '%'));
    }

    @Test
    public void calculate_additionOfTwoPositiveOperands_Ok() {
        firstOperand = 11;
        secondOperand = 48;
        expected = 59;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionOfTwoNegativeOperands_Ok() {
        firstOperand = -11;
        secondOperand = -48;
        double expected = -59;
        double actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionOfPositiveAndNegativeOperands_Ok() {
        firstOperand = 11;
        secondOperand = -48;
        expected = -37;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual);
        firstOperand = -11;
        secondOperand = 48;
        expected = 37;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionIfFirstOperandEqualsZero_Ok() {
        firstOperand = 0;
        secondOperand = 48;
        expected = 48;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionIfSecondOperandEqualsZero_Ok() {
        firstOperand = 11;
        secondOperand = 0;
        expected = 11;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionIfBothOperandsEqualsZero_Ok() {
        firstOperand = 0;
        secondOperand = 0;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_additionOfMinAndMaxValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_additionOfMaxAndMinValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_additionIfBothOperandsAreMaxValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_additionIfBothOperandsAreMinValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionOfTwoPositiveOperands_Ok() {
        firstOperand = 11;
        secondOperand = 48;
        expected = -37;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionOfTwoNegativeOperands_Ok() {
        firstOperand = -11;
        secondOperand = -48;
        expected = 37;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionOfPositiveAndNegativeOperands_Ok() {
        firstOperand = -11;
        secondOperand = 48;
        expected = -59;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual);
        firstOperand = 11;
        secondOperand = -48;
        expected = 59;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionIfFirstOperandEqualsZero_Ok() {
        firstOperand = 0;
        secondOperand = 48;
        expected = -48;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionIfSecondOperandEqualsZero_Ok() {
        firstOperand = 11;
        secondOperand = 0;
        expected = 11;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionIfBothOperandsEqualsZero_Ok() {
        firstOperand = 0;
        secondOperand = 0;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_subtractionOfMinAndMaxValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = -Double.MAX_VALUE;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionOfMaxAndMinValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = Double.MAX_VALUE;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionIfBothOperandsAreMaxValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_subtractionIfBothOperandsAreMinValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationOfTwoPositiveOperands_Ok() {
        firstOperand = 11;
        secondOperand = 48;
        expected = 528;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationOfTwoNegativeOperands_Ok() {
        firstOperand = -11;
        secondOperand = -48;
        expected = 528;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationOfPositiveAndNegativeOperands_Ok() {
        firstOperand = -11;
        secondOperand = 48;
        expected = -528;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual);
        firstOperand = 11;
        secondOperand = -48;
        expected = -528;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationIfFirstOperandEqualsZero_Ok() {
        firstOperand = 0;
        secondOperand = 48;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationIfSecondOperandEqualsZero_Ok() {
        firstOperand = 11;
        secondOperand = 0;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationIfBothOperandsEqualsZero_Ok() {
        firstOperand = 0;
        secondOperand = 0;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_multiplicationOfMinAndMaxValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationOfMaxAndMinValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationIfBothOperandsAreMaxValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_multiplicationIfBothOperandsAreMinValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionOfTwoPositiveOperands_Ok() {
        firstOperand = 11;
        secondOperand = 48;
        expected = 0.2292;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionOfTwoNegativeOperands_Ok() {
        firstOperand = -11;
        secondOperand = -48;
        expected = 0.2292;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionOfPositiveAndNegativeOperands_Ok() {
        firstOperand = -11;
        secondOperand = 48;
        expected = -0.2292;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
        firstOperand = 11;
        secondOperand = -48;
        expected = -0.2292;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionIfFirstOperandEqualsZero_Ok() {
        firstOperand = 0;
        secondOperand = 48;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_divisionIfSecondOperandEqualsZero_notOk() {
        firstOperand = 11;
        secondOperand = 0;
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(firstOperand, secondOperand, DIVISION));
    }

    @Test
    public void calculate_divisionIfBothOperandsEqualsZero_notOk() {
        firstOperand = 0;
        secondOperand = 0;
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(firstOperand, secondOperand, DIVISION));
    }

    @Test
    public void calculate_divisionOfMinAndMaxValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionOfMaxAndMinValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionIfBothOperandsAreMaxValues_Ok() {
        firstOperand = Double.MAX_VALUE;
        secondOperand = Double.MAX_VALUE;
        expected = 1;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_divisionIfBothOperandsAreMinValues_Ok() {
        firstOperand = Double.MIN_VALUE;
        secondOperand = Double.MIN_VALUE;
        expected = 1;
        actual = calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_raisePositiveValueToPositiveValue_Ok() {
        firstOperand = 2;
        secondOperand = 4;
        expected = 16;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisePositiveValueToNegativeValue_Ok() {
        firstOperand = 2;
        secondOperand = -4;
        expected = 0.0625;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseNegativeValueToPositiveValue_Ok() {
        firstOperand = -2;
        secondOperand = 4;
        expected = 16;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseNegativeValueToNegativeValue_Ok() {
        firstOperand = -2;
        secondOperand = -4;
        expected = 0.0625;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisePositiveValueToZero_Ok() {
        firstOperand = 2;
        secondOperand = 0;
        expected = 1;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseNegativeValueToZero_Ok() {
        firstOperand = -2;
        secondOperand = 0;
        expected = 1;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raiseZeroValueToPositiveValue_Ok() {
        firstOperand = 0;
        secondOperand = 5;
        expected = 0;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void calculate_raisePositiveValueToFractionalValue_Ok() {
        firstOperand = 2;
        secondOperand = 0.0625;
        expected = 1.0443;
        actual = calculator.calculate(firstOperand, secondOperand, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
    }
}
