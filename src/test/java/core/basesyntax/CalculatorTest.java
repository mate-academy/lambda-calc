package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void correctInput() {
        double first = 56;
        double second = 5;

        assertEquals(first + second, calculator.calculate(first, second, '+'));
        assertEquals(first - second, calculator.calculate(first, second, '-'));
        assertEquals(first / second, calculator.calculate(first, second, '/'));
        assertEquals(first * second, calculator.calculate(first, second, '*'));
        assertEquals(Math.pow(second, first), calculator.calculate(first, second, '^'));
    }

    @Test
    void incorrectNumericInput() {
        double first = 5;
        double second = 0;

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(first, second, '/');
        });
    }

    @Test
    void incorrectOperation() {
        int first = 0;
        int second = 0;
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(first, second, ' ');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(first, second, 'i');
        });
    }

    @Test
    void largeCorrectInput() {
        double first = 3456576870796857345768780235398753205732985732985779832579382753d;
        double second = 576898324239872349089832823526236235232352357295792759823785972d;

        assertEquals(first + second, calculator.calculate(first, second, '+'));
        assertEquals(first - second, calculator.calculate(first, second, '-'));
        assertEquals(first / second, calculator.calculate(first, second, '/'));
        assertEquals(first * second, calculator.calculate(first, second, '*'));
    }

    @Test
    void largeIncorrectInput() {
        double first = 345657687079685734576878d;
        double second = 57689832423987234908985d;

        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(first, second, '^');
        });
    }
}
