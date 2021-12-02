package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    void calculate_AdditionTwoPositiveOperands_Ok() {
        double operand1 = 6;
        double operand2 = 7;
        char operation = '+';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionTwoNegativeOperands_Ok() {
        double operand1 = -6;
        double operand2 = -7;
        char operation = '+';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionNegativeAndPositiveOperands_Ok() {
        double operand1 = 6;
        double operand2 = -7;
        char operation = '+';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionZeroDifferentPlaces_Ok() {
        double operand1 = 6;
        double operand2 = 0;
        char operation = '+';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 + operand2,actual);
        operand1 = 0;
        operand2 = -6;
        actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionMaxAndMinDoubleValues_Ok() {
        double operand1 = Double.MIN_VALUE;
        double operand2 = Double.MAX_VALUE;
        char operation = '+';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_SubtractionTwoPositiveOperands_Ok() {
        double operand1 = 6;
        double operand2 = 7;
        char operation = '-';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionTwoNegativeOperands_Ok() {
        double operand1 = -6;
        double operand2 = -7;
        char operation = '-';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionNegativeAndPositiveOperands_Ok() {
        double operand1 = 6;
        double operand2 = -7;
        char operation = '-';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionZeroDifferentPlaces_Ok() {
        double operand1 = 6;
        double operand2 = 0;
        char operation = '-';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 - operand2,actual);
        operand1 = 0;
        operand2 = -6;
        actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionMaxAndMinDoubleValues_Ok() {
        double operand1 = Double.MIN_VALUE;
        double operand2 = Double.MAX_VALUE;
        char operation = '-';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_MultiplicationTwoPositiveOperands() {
        double operand1 = 5;
        double operand2 = 6;
        char operation = '*';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 * operand2,actual);
    }

    @Test
    void calculate_MultiplicationTwoNegativeOperands() {
        double operand1 = -5;
        double operand2 = -6;
        char operation = '*';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 * operand2,actual);
    }

    @Test
    void calculate_MultiplicationZeroDifferentPlaces_Ok() {
        double operand1 = 6;
        double operand2 = 0;
        char operation = '*';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(0,actual);
    }

    @Test
    void calculate_MultiplicationMaxAndMinDoubleValues_Ok() {
        double operand1 = Double.MIN_VALUE;
        double operand2 = Double.MAX_VALUE;
        char operation = '*';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 * operand2,actual);
    }

    @Test
    void calculate_DivisionTwoPositiveOperands() {
        double operand1 = 5;
        double operand2 = 6;
        char operation = '/';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 / operand2,actual);
    }

    @Test
    void calculate_DivisionTwoNegativeOperands() {
        double operand1 = -5;
        double operand2 = -6;
        char operation = '/';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 / operand2,actual);
    }

    @Test
    void calculate_DivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(5, 0, '/');
        });
    }

    @Test
    void calculate_DivisionZeroDifferentPlaces_Ok() {
        double operand1 = 0;
        double operand2 = 8;
        char operation = '/';
        double actual = calculator.calculate(operand1,operand2,operation);
    }

    @Test
    void calculate_DivisionMaxAndMinDoubleValues_Ok() {
        double operand1 = Double.MAX_VALUE;
        double operand2 = Double.MIN_VALUE;
        char operation = '/';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(operand1 / operand2,actual);
    }

    @Test
    void calculate_Raising_Ok() {
        double operand1 = 4;
        double operand2 = 5;
        char operation = '^';
        double actual = calculator.calculate(operand1,operand2,operation);
        assertEquals(Math.pow(operand1,operand2),actual);
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        char operation = ')';
        assertThrows(Exception.class, () -> {
            calculator.calculate(0, 5, operation);
        });
    }
}
