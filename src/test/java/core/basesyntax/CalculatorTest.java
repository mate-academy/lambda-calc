package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static final double ZERO = 0.0;
    private static Calculator calculator;

    @BeforeEach
    void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    void set_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> calculator.setSecondNumber(null));
        Assertions.assertThrows(NullPointerException.class,
                () -> calculator.setFirstNumber(null));
    }

    @Test
    void set_number_ok() {
        boolean actualFirst = calculator.setFirstNumber(Math.random() * MAX_VALUE);
        Assertions.assertTrue(true, String.valueOf(actualFirst));

        boolean actualSecond = calculator.setSecondNumber(Math.random() * MAX_VALUE);
        Assertions.assertTrue(true, String.valueOf(actualSecond));
    }

    @Test
    void create_constructorWithParameters() {
        Calculator temp = new Calculator(null, 12.0);
        calculator = temp;
        Assertions.assertThrows(NullPointerException.class, () -> calculator.checkForNull());

        temp = new Calculator(12.0, null);
        calculator = temp;
        Assertions.assertThrows(NullPointerException.class, () -> calculator.checkForNull());
    }

    @Test
    void addition_withoutFinal() {
        double firstNumber = Math.random() * MAX_VALUE;
        double secondNumber = Math.random() * MIN_VALUE;
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        double expected = firstNumber + secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addition_Final() {
        calculator.setFirstNumber(MAX_VALUE);
        calculator.setSecondNumber(MIN_VALUE);
        double expected = MAX_VALUE + MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_withoutFinal() {
        double firstNumber = Math.random() * MAX_VALUE;
        double secondNumber = Math.random() * MIN_VALUE;
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        double expected = firstNumber - secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_Final() {
        calculator.setFirstNumber(MAX_VALUE);
        calculator.setSecondNumber(MIN_VALUE);
        double expected = MAX_VALUE - MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_withoutFinal() {
        double firstNumber = Math.random() * MAX_VALUE;
        double secondNumber = Math.random() * MIN_VALUE + 1;
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        double expected = firstNumber / secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_Final() {
        calculator.setFirstNumber(MAX_VALUE);
        calculator.setSecondNumber(MIN_VALUE);
        double expected = MAX_VALUE / MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_byZero() {
        calculator.setFirstNumber(Math.random() * MAX_VALUE);
        calculator.setSecondNumber(0.0);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(calculator.getFirstNumber(), calculator.getSecondNumber(), '/'));
    }

    @Test
    void multiplication_withoutFinal() {
        double firstNumber = Math.random() * MAX_VALUE;
        double secondNumber = Math.random() * MIN_VALUE;
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        double expected = firstNumber * secondNumber;
        double actual = calculator.calculate(firstNumber, secondNumber, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_Final() {
        calculator.setFirstNumber(MAX_VALUE);
        calculator.setSecondNumber(MIN_VALUE);
        double expected = MAX_VALUE * MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power_withoutFinal() {
        double firstNumber = Math.random() * MAX_VALUE;
        double secondNumber = Math.random() * MIN_VALUE;
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        double expected = Math.pow(firstNumber, secondNumber);
        double actual = calculator.calculate(firstNumber, secondNumber, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power_Final() {
        calculator.setFirstNumber(MAX_VALUE);
        calculator.setSecondNumber(MIN_VALUE);
        double expected = Math.pow(MAX_VALUE, MIN_VALUE);
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '^');
        Assertions.assertEquals(expected, actual);
    }
}
