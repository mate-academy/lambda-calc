package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_OK() {
        double positiveNumberOne = 10.5;
        double positiveNumberTwo = 20.1;
        double expected = 30.6;
        double actual = calculator.calculate(positiveNumberOne, positiveNumberTwo, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_OK() {
        double negativeNumberOne = -3.5;
        double negativeNumberTwo = -7.9;
        double expected = -11.4;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_OK() {
        double negativeNumber = -5.7;
        double positiveNumber = 10.2;
        double expected = 4.5;
        double actual = calculator.calculate(negativeNumber, positiveNumber, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_additionWithZeros_OK() {
        double zero = -0;
        double numberTwo = 3.14159265359;
        double expected = 3.14159265359;
        double actual = calculator.calculate(zero, numberTwo, ADDITION);
        assertEquals(expected, actual);
        actual = calculator.calculate(numberTwo, zero, ADDITION);
        assertEquals(expected, actual);
        actual = calculator.calculate(zero, zero, ADDITION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMinAndMaxOperands_OK() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 1;
        double negativeNumber = -1;
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(maxDouble, positiveNumber, ADDITION);
        assertEquals(expected, actual);
        expected = Double.MIN_VALUE;
        actual = calculator.calculate(minDouble, negativeNumber, ADDITION);
    }

    @Test
    void calculate_substractionWithTwoPositiveOperands_OK() {
        double positiveNumber = 10.5;
        double postivieNumber = 20.1;
        double expected = -9.6;
        double actual = calculator.calculate(positiveNumber, postivieNumber, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractionWithTwoNegativeOperands_OK() {
        double negativeNumberOne = -3.5;
        double negativeNumberTwo = -7.9;
        double expected = 4.4;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractionWithtPositiveAndNegativeOperands_OK() {
        double negativeNumber = -5.7;
        double positiveNumber = 10.2;
        double expected = -15.9;
        double actual = calculator.calculate(negativeNumber, positiveNumber, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_substractionWithZeros_OK() {
        double zero = 0;
        double numberTwo = 3.14159265359;
        double expected = -3.14159265359;
        double actual = calculator.calculate(zero, numberTwo, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(numberTwo, zero, SUBSTRACTION);
        expected = 3.14159265359;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(zero, zero, SUBSTRACTION);
        expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    void calculate_substractionWithMinAndMaxOperands_OK() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 1;
        double negativeNumber = -1;
        double expected = Double.MAX_VALUE;
        double actual = calculator.calculate(maxDouble, positiveNumber, SUBSTRACTION);
        assertEquals(expected, actual);
        actual = calculator.calculate(minDouble, negativeNumber, SUBSTRACTION);
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_OK() {
        double positiveNumber = 14.5;
        double positiveNumberTwo = 219.56;
        double expected = 3183.62;
        double actual = calculator.calculate(positiveNumber, positiveNumberTwo, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_OK() {
        double negativeNumberOne = -100.51;
        double negativeNumberTwo = -21.45;
        double expected = 2155.9395;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithtPositiveAndNegativeOperands_OK() {
        double negativeNumber = -18.91;
        double positiveNumber = 4.1;
        double expected = -77.531;
        double actual = calculator.calculate(negativeNumber, positiveNumber, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationWithZeros_OK() {
        double zero = 0;
        double numberTwo = 3.14159265359;
        double expected = 0;
        double actual = calculator.calculate(zero, numberTwo, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(numberTwo, zero, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(zero, zero, MULTIPLICATION);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMinAndMaxOperands_OK() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 2;
        double negativeNumber = -2;
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.calculate(maxDouble, positiveNumber, MULTIPLICATION);
        assertEquals(expected, actual);
        actual = calculator.calculate(minDouble, positiveNumber, MULTIPLICATION);
        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_OK() {
        double positive1 = 6.4;
        double positive2 = 4.6;
        double expected = 1.39130434783;
        double actual = calculator.calculate(positive1, positive2, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_OK() {
        double negativeNumberOne = -8.2;
        double negativeNumberTwo = -16.12;
        double expected = 0.50868486352;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_OK() {
        double negativeNumber = -9.45;
        double positiveNumber = 26.1950;
        double expected = -0.36075586944;
        double actual = calculator.calculate(negativeNumber, positiveNumber, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionZeroFirst_OK() {
        double zero = 0;
        double numberTwo = 3.14159265359;
        double expected = 0;
        double actual = calculator.calculate(zero, numberTwo, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionByZero_Not_OK() {
        double zero = 0;
        double numberTwo = 3.14159265359;
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(numberTwo, zero, DIVISION));
    }

    @Test
    void calculate_divisionWithMinAndMaxOperands_OK() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 0.5;
        double negativeNumber = -0.5;
        double actual = calculator.calculate(maxDouble, positiveNumber, DIVISION);
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);
        actual = calculator.calculate(minDouble, negativeNumber, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNumbersToTheNegative_OK() {
        double positiveNumber = 8.5;
        double negativeNumber = -3.95;
        double expected = 0.00021320394;
        double actual = calculator.calculate(positiveNumber, negativeNumber, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
        expected = -0.00439988648;
        actual = calculator.calculate(negativeNumber, negativeNumber, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumbersToThePositive_OK() {
        double positiveNumber = 5.61;
        double negativeNumber = -2.48;
        double expected = 15910.4202723;
        double actual = calculator.calculate(positiveNumber, positiveNumber, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
        expected = -163.257796098;
        actual = calculator.calculate(negativeNumber, positiveNumber, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingNumbersToZero_OK() {
        double positiveNumber = 1023012.123919329;
        double negativeNumber = -12391294219149.120014201241042102;
        double zero = 0;
        double expected = 1;
        double actual = calculator.calculate(positiveNumber, zero, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
        expected = -1;
        actual = calculator.calculate(negativeNumber, zero, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingZeroToPower_OK() {
        double positiveNumber = 89.89;
        double negativeNumber = 98.98;
        double zero = 0;
        double expected = 0;
        double actual = calculator.calculate(zero, positiveNumber, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(zero, negativeNumber, RAISING_TO_A_POWER);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_illegalOperation_Not_OK() {
        double firstNumber = 19.65;
        double secondNumber = 12.56;
        assertThrows(UnsupportedOperationException.class,
                () -> calculator.calculate(firstNumber, secondNumber, 'I'));
    }
}
