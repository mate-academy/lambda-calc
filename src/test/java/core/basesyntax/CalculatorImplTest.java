package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorImplTest {
  private  double first;
  private  double second;
  private  char action;
  private  double actual;
  private double expected;
  private  Calculator calculator;
  private static final double MAX_VALUE = Double.MAX_VALUE;
  private static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;

    @BeforeAll
    void createCalculatorInstance() {
        calculator = new CalculatorImpl();
    }

    @Test
    void addition_positive_numbersOk() {
        first = 5;
        second = 7;
        expected = 12;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void addition_oneNegative_numberOk() {
        first = 8;
        second = -5;
        expected = 3;
        action = '+';
        actual = calculator.calculate(first,second,action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void addition_twoNegativeNumsOk() {
        first = -7;
        second = -16;
        expected = -23;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void addition_zeroNumOk() {
        first = 41;
        second = 0;
        expected = 41;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void addition_floatingPointNumsOk() {
        first = 28.4;
        second = 35.8;
        expected = 64.2;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void addition_positive_maxValuesOk() {
        first = MAX_VALUE;
        second = 741.5;
        expected = MAX_VALUE;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void addiction_oneNegative_maxValuesOk() {
        first = MAX_VALUE;
        second = -232157;
        expected = MAX_VALUE + second;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void infinityTestOk() {
        first = MAX_VALUE;
        second = MAX_VALUE;
        action = '+';
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }
}