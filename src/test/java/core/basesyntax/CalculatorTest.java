package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static Calculator calculator;

    @BeforeEach
    void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    void check_byNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> calculator.checkForNull(10.0, null));
        Assertions.assertThrows(NullPointerException.class,
                () -> calculator.checkForNull(null, 20.0));
    }

    @Test
    void power_negativeNumber() {
        double firstNumber = -2.0;
        double secondNumber = 3.0;
        double expected = Math.pow(firstNumber, secondNumber);
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power_negativeDegree() {
        double firstNumber = 2.0;
        double secondNumber = -3.0;
        double expected = Math.pow(firstNumber, secondNumber);
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power() {
        double firstNumber = 2.0;
        double secondNumber = 3.0;
        double expected = Math.pow(firstNumber, secondNumber);
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power_byFinal() {
        double expected = Math.pow(MAX_VALUE, MIN_VALUE);
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addition_negative() {
        double firstNumber = -20.0;
        double secondNumber = -10.0;
        double expected = firstNumber + secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addition() {
        double firstNumber = 20.0;
        double secondNumber = 10.0;
        double expected = firstNumber + secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addition_byFinal() {
        double expected = MAX_VALUE + MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction() {
        double firstNumber = 5.0;
        double secondNumber = 8.0;
        double expected = firstNumber - secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_negative() {
        double firstNumber = -8.0;
        double secondNumber = -5.0;
        double expected = firstNumber - secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_byFinal() {
        double expected = MAX_VALUE - MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division() {
        double firstNumber = 0.0;
        double secondNumber = 1.0;
        double expected = firstNumber / secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_negative() {
        double firstNumber = 0.0;
        double secondNumber = -1.0;
        double expected = firstNumber / secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_byFinal() {
        double expected = MAX_VALUE / MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_byZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(MAX_VALUE, 0.0, '/'));
    }

    @Test
    void multiplication() {
        double firstNumber = 5.0;
        double secondNumber = 8.0;
        double expected = firstNumber * secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_negative() {
        double firstNumber = 5.0;
        double secondNumber = -8.0;
        double expected = firstNumber * secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_byFinal() {
        double expected = MAX_VALUE * MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '*');
        Assertions.assertEquals(expected, actual);
    }
}
