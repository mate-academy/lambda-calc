package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;
    private int firstCaseA;
    private int firstCaseB;
    private int secondCaseA;
    private int secondCaseB;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        firstCaseA = 21;
        firstCaseB = -3;
        secondCaseA = -25;
        secondCaseB = 0;
    }

    @Test
    void addition_Ok() {
        double expectedFirst = 18;
        double expectedSecond = -25;
        double actualFirst = calculator.calculator(firstCaseA, firstCaseB, '+');
        double actualSecond = calculator.calculator(secondCaseA, secondCaseB, '+');
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void subtraction_Ok() {
        double expected = 24;
        double expectedSecond = -25;
        double actual = calculator.calculator(firstCaseA, firstCaseB, '-');
        double actualSecond = calculator.calculator(secondCaseA, secondCaseB, '-');
        assertEquals(expected, actual);
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void division_Ok() {
        double expected = -7;
        double actual = calculator.calculator(firstCaseA, firstCaseB, '/');
        assertEquals(expected, actual);
        assertThrows(ArithmeticException.class, () -> calculator
                .calculator(secondCaseA, secondCaseB, '/'), "Can't division on zero!");
    }

    @Test
    void multiplication_Ok() {
        double expectedSecond = 0;
        double expectedFirst = -63;
        double actualFirst = calculator.calculator(firstCaseA, firstCaseB, '*');
        double actualSecond = calculator.calculator(secondCaseA, secondCaseB, '*');
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void raisingToAPower_Ok() {
        double actual = calculator.calculator(firstCaseA, firstCaseB, '^');
        double actualSecond = calculator.calculator(secondCaseA, secondCaseB, '^');
        double expectedSecond = 1;
        double expected = 1.0797969981643452E-4;
        assertEquals(expected, actual);
        assertEquals(expectedSecond, actualSecond);
    }
}
