package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private static final double DELTA = 0.0001;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addWithTwoPos_Ok() {
        double expected = 50;
        double actual = calculator.calculate(15.5, 34.5, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addWithTwoNeg_Ok() {
        double expected = -50;
        double actual = calculator.calculate(-15.5, -34.5, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addWithOnePosOneNeg_Ok() {
        double expected = 50;
        double actual = calculator.calculate(100, -50, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addWithZero_Ok() {
        double expected = 50;
        double actual = calculator.calculate(50, 0, '+');
        assertEquals(expected, actual);
        actual = calculator.calculate(0, 50, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addWithMaxAndMin_Ok() {
        double expected = MAX_VALUE + MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subWithTwoPos_Ok() {
        double expected = 50;
        double actual = calculator.calculate(100, 50, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subWithTwoNeg_Ok() {
        double expected = -50;
        double actual = calculator.calculate(-100, -50, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subWithOnePosOneNeg_Ok() {
        double expected = 150;
        double actual = calculator.calculate(100, -50, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subWithZero_Ok() {
        double expected = 50;
        double actual = calculator.calculate(50, 0, '-');
        assertEquals(expected, actual);
        actual = calculator.calculate(0, -50, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subWithMaxAndMin_Ok() {
        double expected = MAX_VALUE - MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multWithTwoPos_Ok() {
        double expected = 50;
        double actual = calculator.calculate(10, 5, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multWithTwoNeg_Ok() {
        double expected = 50;
        double actual = calculator.calculate(-10, -5, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multWithOnePosOneNeg_Ok() {
        double expected = -50;
        double actual = calculator.calculate(10, -5, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multWithZero_Ok() {
        double expected = 0;
        double actual = calculator.calculate(50, 0, '*');
        assertEquals(expected, actual);
        actual = calculator.calculate(0, 50, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multWithMaxAndMin_Ok() {
        double expected = MAX_VALUE * MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divWithTwoPos_Ok() {
        double expected = 10;
        double actual = calculator.calculate(50, 5, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divWithTwoNeg_Ok() {
        double expected = 10;
        double actual = calculator.calculate(-50, -5, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divWithOnePosOneNeg_Ok() {
        double expected = -2;
        double actual = calculator.calculate(10, -5, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divWithZero_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 5, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divWithZero_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(5, 0, '/'));
    }

    @Test
    void calculate_divMinAndMax_Ok() {
        double expected = MAX_VALUE / MIN_VALUE;
        double actual = calculator.calculate(MAX_VALUE, MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_powWithPos_Ok() {
        double expected = 100;
        double actual = calculator.calculate(10, 2, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_powWithNeg_Ok() {
        double expected = 0.01;
        double actual = calculator.calculate(10, -2, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, -2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_powWithZero_Ok() {
        double expected = 1;
        double actual = calculator.calculate(10, 0, '^');
        assertEquals(expected, actual);
        actual = calculator.calculate(-10, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_powZeroPow_Ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 2, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_powZeroPow_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(0, -2, '^'));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(0, 0, '^'));
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(0, 0, 'a'));
    }
}
