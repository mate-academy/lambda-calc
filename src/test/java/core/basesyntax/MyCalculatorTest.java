package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char DIVISION = '/';
    public static final char MULTIPLICATION = '*';
    public static final char RISING_TO_POWER = '^';
    Calculator calculator = new MyCalculator();

    @Test
    void additionTwoPositiveOperands_OK() {
        double actual = calculator.calculate(10, 5, ADDITION);
        double expected = 15;
        assertEquals(actual,expected);
    }

    @Test
    void additionTwoNegativeOperands_OK() {
        double actual = calculator.calculate(-10, -5, ADDITION);
        double expected = -15;
        assertEquals(expected, actual);
    }

}