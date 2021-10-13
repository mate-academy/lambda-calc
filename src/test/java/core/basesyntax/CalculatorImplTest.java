package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static Calculator calculator;
    private double operand1;
    private double operand2;
    private double actual;
    private char ch;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    void calculate_AdditionTwoPositiveOperands_Ok() {
        operand1 = 6;
        operand2 = 7;
        ch = '+';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionTwoNegativeOperands_Ok() {
        operand1 = -6;
        operand2 = -7;
        ch = '+';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionNegativeAndPositiveOperands_Ok() {
        operand1 = 6;
        operand2 = -7;
        ch = '+';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionZeroDifferentPlaces_Ok() {
        operand1 = 6;
        operand2 = 0;
        ch = '+';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 + operand2,actual);
        operand1 = 0;
        operand2 = -6;
        ch = '+';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_AdditionMaxAndMinDoubleValues_Ok() {
        operand1 = Double.MIN_VALUE;
        operand2 = Double.MAX_VALUE;
        ch = '+';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 + operand2,actual);
    }

    @Test
    void calculate_SubtractionTwoPositiveOperands_Ok() {
        operand1 = 6;
        operand2 = 7;
        ch = '-';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionTwoNegativeOperands_Ok() {
        operand1 = -6;
        operand2 = -7;
        ch = '-';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionNegativeAndPositiveOperands_Ok() {
        operand1 = 6;
        operand2 = -7;
        ch = '-';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionZeroDifferentPlaces_Ok() {
        operand1 = 6;
        operand2 = 0;
        ch = '-';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 - operand2,actual);
        operand1 = 0;
        operand2 = -6;
        ch = '-';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_SubtractionMaxAndMinDoubleValues_Ok() {
        operand1 = Double.MIN_VALUE;
        operand2 = Double.MAX_VALUE;
        ch = '-';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 - operand2,actual);
    }

    @Test
    void calculate_MultiplicationTwoPositiveOperands() {
        operand1 = 5;
        operand2 = 6;
        ch = '*';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 * operand2,actual);
    }

    @Test
    void calculate_MultiplicationTwoNegativeOperands() {
        operand1 = -5;
        operand2 = -6;
        ch = '*';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 * operand2,actual);
    }

    @Test
    void calculate_MultiplicationZeroDifferentPlaces_Ok() {
        operand1 = 6;
        operand2 = 0;
        ch = '*';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(0,actual);
    }

    @Test
    void calculate_MultiplicationMaxAndMinDoubleValues_Ok() {
        operand1 = Double.MIN_VALUE;
        operand2 = Double.MAX_VALUE;
        ch = '*';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 * operand2,actual);
    }

    @Test
    void calculate_DivisionTwoPositiveOperands() {
        operand1 = 5;
        operand2 = 6;
        ch = '/';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 / operand2,actual);
    }

    @Test
    void calculate_DivisionTwoNegativeOperands() {
        operand1 = -5;
        operand2 = -6;
        ch = '/';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 / operand2,actual);
    }

    @Test
    void calculate_DivisionZeroDifferentPlaces_Ok() {
        operand1 = 6;
        operand2 = 3;
        ch = '/';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 / operand2,actual);
        operand2 = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(operand1, operand2, ch);
        });
    }

    @Test
    void calculate_DivisionMaxAndMinDoubleValues_Ok() {
        operand1 = Double.MAX_VALUE;
        operand2 = Double.MIN_VALUE;
        ch = '/';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(operand1 / operand2,actual);
    }

    @Test
    void calculate_Raising_Ok() {
        operand1 = 4;
        operand2 = 5;
        ch = '^';
        actual = calculator.calculate(operand1,operand2,ch);
        assertEquals(Math.pow(operand1,operand2),actual);
    }

    @Test
    void calculate_IllegalOperation_NotOk() {
        if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '^') {
            assertThrows(Exception.class, () -> {
                calculator.calculate(operand1, operand2, ch);
            });
        }
    }
}
