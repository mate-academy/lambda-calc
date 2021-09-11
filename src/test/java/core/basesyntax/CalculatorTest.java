package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;
    private static final double DELTA = 0.0001;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void calculate_Ok_addition() {
        double value1 = 123.111;
        double value2 = 321.222;
        char operation = '+';
        double expected = 444.333;
        assertEquals(expected, calculator.calculate(value1, value2, operation), DELTA);
        assertEquals(expected, calculator.calculate(value2, value1, operation), DELTA);
    }

    @Test
    public void calculate_Ok_additionWithZero() {
        double value1 = 123.111;
        double value2 = 321.222;
        char operation = '+';
        assertEquals(value1, calculator.calculate(value1, 0, operation), DELTA);
        assertEquals(value2, calculator.calculate(0, value2, operation), DELTA);
    }

    @Test
    public void calculate_Ok_additionWithNegativeValues() {
        double value1 = -123.111;
        double value2 = -321.222;
        char operation = '+';
        double expected = -444.333;
        assertEquals(expected, calculator.calculate(value1, value2, operation), DELTA);
        assertEquals(expected, calculator.calculate(value2, value1, operation), DELTA);
    }

    @Test
    public void calculate_Ok_additionWithNegativeValue() {
        double value1 = -123.111;
        double value2 = 321.222;
        char operation = '+';
        double expected = 198.111;
        assertEquals(expected, calculator.calculate(value1, value2, operation), DELTA);
        assertEquals(expected, calculator.calculate(value2, value1, operation), DELTA);
    }

    @Test
    public void calculate_NotOk_additionMaxValues() {
        double value1 = Double.MAX_VALUE;
        double value2 = 1;
        char operation = '+';
        assertThrows(ArithmeticException.class, () -> calculator.calculate(value1, value2, operation));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    public void calculate_Ok_additionMinValues() {
        double value1 = 0.123;
        double value2 = 0.345;
        char operation = '+';
        assertEquals(value1, calculator.calculate(value1, Double.MIN_VALUE, operation), DELTA);
        assertEquals(value2, calculator.calculate(Double.MIN_VALUE, value2, operation), DELTA);
    }

    @Test
    void calculate_Ok_subtraction() {
        double value1 = 456.789;
        double value2 = 123.456;
        char operation = '-';
        double expected = 333.333;
        assertEquals(expected, calculator.calculate(value1, value2, operation), DELTA);
        assertEquals(-expected, calculator.calculate(value2, value1, operation), DELTA);
    }

    @Test
    public void calculate_Ok_subtractionWithZero() {
        double value1 = 123.111;
        double value2 = 321.222;
        char operation = '-';
        assertEquals(value1, calculator.calculate(value1, 0, operation), DELTA);
        assertEquals(-value2, calculator.calculate(0, value2, operation), DELTA);
    }

    @Test
    public void calculate_Ok_subtractionWithNegativeValues() {
        double value1 = -222.111;
        double value2 = -333.222;
        char operation = '-';
        double expected = 111.111;
        assertEquals(expected, calculator.calculate(value1, value2, operation), DELTA);
        assertEquals(-expected, calculator.calculate(value2, value1, operation), DELTA);
    }

    @Test
    public void calculate_Ok_subtractionWithNegativeValue() {
        double value1 = -111.111;
        double value2 = 222.222;
        char operation = '-';
        double expected = -333.333;
        assertEquals(expected, calculator.calculate(value1, value2, operation), DELTA);
        assertEquals(-expected, calculator.calculate(value2, value1, operation), DELTA);
    }

    @Test
    public void calculate_NotOk_subtractionMaxValues() {
        double value1 = Double.MAX_VALUE;
        double value2 = 1;
        char operation = '-';
        assertThrows(ArithmeticException.class, () -> calculator.calculate(value1, value2, operation));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    public void calculate_Ok_subtractionMinValues() {
        double value1 = 0.123;
        double value2 = 0.345;
        char operation = '-';
        assertEquals(value1, calculator.calculate(value1, Double.MIN_VALUE, operation), DELTA);
        assertEquals(-value2, calculator.calculate(Double.MIN_VALUE, value2, operation), DELTA);
    }


}