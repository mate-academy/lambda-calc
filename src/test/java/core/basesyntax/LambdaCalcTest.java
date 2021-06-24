package core.basesyntax;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LambdaCalcTest {
    private static final double DELTA = 0.0001;
    LambdaCalc calculator = new LambdaCalc();

    @Test
    void additionWithTwoOPositiveOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 245.8648;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithTwoONegativeOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = -245.8648;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = -245.8648;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithNegativeAndPositiveOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 245.8648;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroAndPositiveOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = 245.8648;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroAndNegativeOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = -245.8648;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroAndZeroOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = 0;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndZeroOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 0;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithNegativeAndZeroOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 0;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionForMinAndMaxDoubleValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        char operation = '+';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber + secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoOPositiveOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 245.8648;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoONegativeOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = -245.8648;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = -245.8648;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithNegativeAndPositiveOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 245.8648;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroAndPositiveOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = 245.8648;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroAndNegativeOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = -245.8648;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroAndZeroOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = 0;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndZeroOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 0;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithNegativeAndZeroOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 0;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        char operation = '-';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber - secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoOPositiveOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 245.8648;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoONegativeOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = -245.8648;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = -245.8648;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithNegativeAndPositiveOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 245.8648;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroAndPositiveOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = 245.8648;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroAndNegativeOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = -245.8648;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroAndZeroOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = 0;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndZeroOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 0;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithNegativeAndZeroOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 0;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        char operation = '*';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber * secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoOPositiveOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 245.8648;
        char operation = '/';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber / secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoONegativeOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = -245.8648;
        char operation = '/';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber / secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = -245.8648;
        char operation = '/';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber / secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithNegativeAndPositiveOperands_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 245.8648;
        char operation = '/';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber / secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAndPositiveOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = 245.8648;
        char operation = '/';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber / secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAndNegativeOperands_Ok() {
        double firstNumber = 0;
        double secondNumber = -245.8648;
        char operation = '/';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber / secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroAndZeroOperands_NotOk() {
        double firstNumber = 0;
        double secondNumber = 0;
        char operation = '/';
        assertThrows(ArithmeticException.class, () -> calculator.calculate(firstNumber, secondNumber, operation));
    }

    @Test
    void divisionWithPositiveAndZeroOperands_NotOk() {
        double firstNumber = 153.1486;
        double secondNumber = 0;
        char operation = '/';
        assertThrows(ArithmeticException.class, () -> calculator.calculate(firstNumber, secondNumber, operation));
    }

    @Test
    void divisionWithNegativeAndZeroOperands_NotOk() {
        double firstNumber = -153.1486;
        double secondNumber = 0;
        char operation = '/';
        assertThrows(ArithmeticException.class, () -> calculator.calculate(firstNumber, secondNumber, operation));
    }

    @Test
    void divisionForMinAndMaxDoubleValues_Ok() {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MAX_VALUE;
        char operation = '/';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = firstNumber / secondNumber;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 245.8648;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = -245.8648;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingPositiveValueToTheZeroPower_Ok() {
        double firstNumber = 153.1486;
        double secondNumber = 0;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 245.8648;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = -245.8648;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingNegativeValueToTheZeroPower_Ok() {
        double firstNumber = -153.1486;
        double secondNumber = 0;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroValueToThePositivePower_Ok() {
        double firstNumber = 0;
        double secondNumber = 245.8648;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void raisingZeroValueToTheNegativePower_Ok() {
        double firstNumber = 0;
        double secondNumber = -245.8648;
        char operation = '^';
        double actual = calculator.calculate(firstNumber, secondNumber, operation);
        double expected = Math.pow(firstNumber, secondNumber);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void illegalOperation_NotOk() {
        double firstNumber = 153.1486;
        double secondNumber = 245.8648;
        char operation = '$';
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(firstNumber, secondNumber, operation));
    }
}
