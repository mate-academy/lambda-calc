package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_additionWithZero() {
        double value1 = 123.111;
        double value2 = 321.222;
        char operation = '+';
        double actual = calculator.calculate(value1, 0, operation);
        assertEquals(value1, actual, DELTA);
    }

    @Test
    public void calculate_Ok_additionWithNegativeValues() {
        double value1 = -123.111;
        double value2 = -321.222;
        char operation = '+';
        double expected = -444.333;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_additionWithNegativeValue() {
        double value1 = -123.111;
        double value2 = 321.222;
        char operation = '+';
        double expected = 198.111;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_NotOk_additionMaxValues() {
        double value1 = Double.MAX_VALUE;
        double value2 = 1;
        char operation = '+';
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value1, value2, operation));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    public void calculate_Ok_additionMinValues() {
        double value1 = 0.123;
        double value2 = 0.345;
        char operation = '+';
        double actual = calculator.calculate(value1, Double.MIN_VALUE, operation);
        assertEquals(value1, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, value2, operation);
        assertEquals(value2, actual, DELTA);
    }

    @Test
    void calculate_Ok_multiplication() {
        double value1 = 111.111;
        double value2 = 2.00;
        char operation = '*';
        double expected = 222.222;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_multiplicationWithZero() {
        double value1 = 123.111;
        double value2 = 321.222;
        char operation = '*';
        double actual = calculator.calculate(value1, 0, operation);
        assertEquals(0, actual, DELTA);
        actual = calculator.calculate(0, value2, operation);
        assertEquals(0, actual, DELTA);
    }

    @Test
    public void calculate_Ok_multiplicationWithNegativeValues() {
        double value1 = -111.111;
        double value2 = -2.000;
        char operation = '*';
        double expected = 222.222;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_multiplicationWithNegativeValue() {
        double value1 = 111.111;
        double value2 = -2.000;
        char operation = '*';
        double expected = -222.222;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_NotOk_multiplicationMaxValues() {
        double value1 = Double.MAX_VALUE;
        double value2 = 1;
        char operation = '*';
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value1, value2, operation));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    public void calculate_Ok_multiplicationMinValues() {
        double value1 = Double.MIN_VALUE;
        double value2 = 2;
        char operation = '*';
        double expected = value1 * value2;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_Ok_subtraction() {
        double value1 = 456.789;
        double value2 = 123.456;
        char operation = '-';
        double expected = 333.333;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(-expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_subtractionWithZero() {
        double value1 = 123.111;
        double value2 = 321.222;
        char operation = '-';
        double actual = calculator.calculate(value1, 0, operation);
        assertEquals(value1, actual, DELTA);
        actual = calculator.calculate(0, value2, operation);
        assertEquals(-value2, actual, DELTA);
    }

    @Test
    public void calculate_Ok_subtractionWithNegativeValues() {
        double value1 = -222.111;
        double value2 = -333.222;
        char operation = '-';
        double expected = 111.111;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(-expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_subtractionWithNegativeValue() {
        double value1 = -111.111;
        double value2 = 222.222;
        char operation = '-';
        double expected = -333.333;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(-expected, actual, DELTA);
    }

    @Test
    public void calculate_NotOk_subtractionMaxValues() {
        double value1 = Double.MAX_VALUE;
        double value2 = 1;
        char operation = '-';
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value1, value2, operation));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    public void calculate_Ok_subtractionMinValues() {
        double value1 = 0.123;
        double value2 = 0.345;
        char operation = '-';
        double actual = calculator.calculate(value1, Double.MIN_VALUE, operation);
        assertEquals(value1, actual, DELTA);
        actual = calculator.calculate(Double.MIN_VALUE, value2, operation);
        assertEquals(-value2, actual, DELTA);
    }

    @Test
    void calculate_Ok_power() {
        double value1 = 2;
        double value2 = 2;
        char operation = '^';
        double expected = 4;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_powerWithZero() {
        double value1 = 0;
        double value2 = 321.222;
        char operation = '^';
        double actual = calculator.calculate(value2, value1, operation);
        double expected = 1;
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value1, value2, operation);
        expected = 0;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_powerWithNegativeValues() {
        double value1 = -2;
        double value2 = -2;
        char operation = '^';
        double expected = 0.25;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_powerWithNegativeValue() {
        double value1 = 2;
        double value2 = -2;
        char operation = '^';
        double expected = 0.25;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        expected = 4;
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_NotOk_powerMaxValues() {
        double value1 = Double.MAX_VALUE;
        double value2 = 1;
        char operation = '^';
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value1, value2, operation));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    void calculate_Ok_division() {
        double value1 = 222.222;
        double value2 = 222.222;
        char operation = '/';
        double expected = 1;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_divisionWithZero() {
        double value1 = 0;
        double value2 = 321.222;
        char operation = '/';
        double actual;
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value2, value1, operation));
        actual = calculator.calculate(value1, value2, operation);
        assertEquals(0, actual, DELTA);
    }

    @Test
    public void calculate_Ok_divisionWithNegativeValues() {
        double value1 = -222.222;
        double value2 = -222.222;
        char operation = '/';
        double expected = 1;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_Ok_divisionWithNegativeValue() {
        double value1 = 222.222;
        double value2 = -222.222;
        char operation = '/';
        double expected = -1;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(value2, value1, operation);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculate_NotOk_divisionMaxValues() {
        double value1 = Double.MAX_VALUE;
        double value2 = 1;
        char operation = '/';
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value1, value2, operation));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    public void calculate_Ok_divisionMinValues() {
        double value1 = Double.MIN_VALUE;
        double value2 = 2;
        char operation = '/';
        double expected = value1 * value2;
        double actual = calculator.calculate(value1, value2, operation);
        assertEquals(expected, actual, DELTA);
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(value2, value1, operation));
    }

    @Test
    void calculate_NotOk_illegalOperation() {
        double value1 = 0;
        double value2 = 0;
        char wrongOperation = '$';
        assertThrows(RuntimeException.class,
                () -> calculator.calculate(value1, value2, wrongOperation));
    }
}
