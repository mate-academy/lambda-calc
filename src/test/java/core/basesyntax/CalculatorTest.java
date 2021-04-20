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
    void additionWithTwoPositiveOperands() {
        double positiveNumberOne = 10.5;
        double positiveNumberTwo = 20.1;
        double expected = 30.6;
        double actual = calculator.calculate(positiveNumberOne, positiveNumberTwo, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoNegativeOperands() {
        double negativeNumberOne = -3.5;
        double negativeNumberTwo = -7.9;
        double expected = -11.4;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands() {
        double negativeNumber = -5.7;
        double positiveNumber = 10.2;
        double expected = 4.5;
        double actual = calculator.calculate(negativeNumber, positiveNumber, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeros() {
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
    void additionWithMinAndMaxOperands() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 1;
        double negativeNumber = -1;
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(maxDouble, positiveNumber, ADDITION));
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(minDouble, negativeNumber, ADDITION));
    }

    @Test
    void substractionWithTwoPositiveOperands() {
        double positiveNumber = 10.5;
        double postivieNumber = 20.1;
        double expected = -9.6;
        double actual = calculator.calculate(positiveNumber, postivieNumber, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void substractionWithTwoNegativeOperands() {
        double negativeNumberOne = -3.5;
        double negativeNumberTwo = -7.9;
        double expected = 4.4;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void substractionWithtPositiveAndNegativeOperands() {
        double negativeNumber = -5.7;
        double positiveNumber = 10.2;
        double expected = -15.9;
        double actual = calculator.calculate(negativeNumber, positiveNumber, SUBSTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void substractionWithZeros() {
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
    void substractionWithMinAndMaxOperands() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 1;
        double negativeNumber = -1;
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(maxDouble, negativeNumber, SUBSTRACTION));
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(minDouble, positiveNumber, SUBSTRACTION));
    }

    @Test
    void multiplicationWithTwoPositiveOperands() {
        double positiveNumber = 14.5;
        double positiveNumberTwo = 219.56;
        double expected = 3183.62;
        double actual = calculator.calculate(positiveNumber, positiveNumberTwo, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoNegativeOperands() {
        double negativeNumberOne = -100.51;
        double negativeNumberTwo = -21.45;
        double expected = 2155.9395;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithtPositiveAndNegativeOperands() {
        double negativeNumber = -18.91;
        double positiveNumber = 4.1;
        double expected = -77.531;
        double actual = calculator.calculate(negativeNumber, positiveNumber, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeros() {
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
    void multiplicationWithMinAndMaxOperands() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 2;
        double negativeNumber = -2;
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(maxDouble, negativeNumber, MULTIPLICATION));
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(minDouble, positiveNumber, MULTIPLICATION));
    }

    @Test
    void divisionWithTwoPositiveOperands() {
        double positive1 = 6.4;
        double positive2 = 4.6;
        double expected = 1.39130434783;
        double actual = calculator.calculate(positive1, positive2, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoNegativeOperands() {
        double negativeNumberOne = -8.2;
        double negativeNumberTwo = -16.12;
        double expected = 0.50868486352;
        double actual = calculator.calculate(negativeNumberOne, negativeNumberTwo, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands() {
        double negativeNumber = -9.45;
        double positiveNumber = 26.1950;
        double expected = -0.36075586944;
        double actual = calculator.calculate(negativeNumber, positiveNumber, DIVISION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeros() {
        double zero = 0;
        double numberTwo = 3.14159265359;
        double expected = 0;
        double actual = calculator.calculate(zero, numberTwo, DIVISION);
        assertEquals(expected, actual, DELTA);
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(numberTwo, zero, DIVISION));
    }

    @Test
    void divisionWithMinAndMaxOperands() {
        double maxDouble = Double.MAX_VALUE;
        double minDouble = -Double.MAX_VALUE;
        double positiveNumber = 0.5;
        double negativeNumber = -0.5;
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(maxDouble, positiveNumber, DIVISION));
        assertThrows(LimitDoubleValueReachedException.class,
                () -> calculator.calculate(minDouble, negativeNumber, DIVISION));
    }

    @Test
    void raisingNumbersToTheNegative() {
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
    void raisingNumbersToThePositive() {
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
    void raisingNumbersToZero() {
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
    void raisingZeroToPower() {
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
    void illegalOperation() {
        double firstNumber = 19.65;
        double secondNumber = 12.56;
        assertThrows(UnsupportedOperationException.class,
                () -> calculator.calculate(firstNumber, secondNumber, 'I'));
    }
}
