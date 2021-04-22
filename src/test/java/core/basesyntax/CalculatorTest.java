package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';
    private static final double DELTA = 0.01;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addTwoPositives_isOk() {
        assertEquals(50.0, calculator.calculate(20.0, 30.0, PLUS));
        assertEquals(60.0, calculator.calculate(60.0, 0.0, PLUS));
        assertEquals(90.0, calculator.calculate(0.0, 90.0, PLUS));
    }

    @Test
    void calculate_addTwoNegatives_isOk() {
        assertEquals(-30.0, calculator.calculate(-20.0, -10.0, PLUS));
        assertEquals(-60.0, calculator.calculate(0.0, -60.0, PLUS));
        assertEquals(-30.0, calculator.calculate(-30.0, 0.0, PLUS));
    }

    @Test
    void calculate_addPositiveAndNegative_isOk() {
        assertEquals(100.0, calculator.calculate(170.0, -70.0, PLUS));
        assertEquals(40.0, calculator.calculate(-30.0, 70.0, PLUS));
        assertEquals(0.0, calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, PLUS));
    }

    @Test
    void calculate_addMaxValue_isOk() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                                                            Double.MAX_VALUE, PLUS));
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, 300000000.0, PLUS));
    }

    @Test
    void calculate_addMinValue_isOk() {
        assertEquals(-Double.POSITIVE_INFINITY, calculator.calculate(-Double.MAX_VALUE,
                                                        -Double.MAX_VALUE, PLUS), DELTA);
        assertEquals(-Double.MAX_VALUE, calculator.calculate(-Double.MAX_VALUE,
                                                -300000000.0, PLUS), DELTA);
    }

    @Test
    void calculate_subtractTwoPositives_isOk() {
        assertEquals(90.0, calculator.calculate(120.0, 30.0, MINUS));
        assertEquals(-10.0, calculator.calculate(60.0, 70.0, MINUS));
        assertEquals(-90.0, calculator.calculate(0.0, 90.0, MINUS));
        assertEquals(20.0, calculator.calculate(20.0, 0.0, MINUS));
    }

    @Test
    void calculate_subtractTwoNegatives_isOk() {
        assertEquals(10.0, calculator.calculate(-20.0, -30.0, MINUS));
        assertEquals(-40.0, calculator.calculate(-60.0, -20, MINUS));
        assertEquals(90.0, calculator.calculate(0.0, -90.0, MINUS));
        assertEquals(-20.0, calculator.calculate(-20.0, 0.0, MINUS));
    }

    @Test
    void calculate_subtractNegativeAndPositive_isOk() {
        assertEquals(-150.0, calculator.calculate(-120.0, 30.0, MINUS));
        assertEquals(140.0, calculator.calculate(60.0, -80, MINUS));
    }

    @Test
    void calculate_subtractMaxValue_isOk() {
        assertEquals(0.0, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                                                    -Double.MAX_VALUE, MINUS), DELTA);
        assertEquals(Double.MAX_VALUE, calculator.calculate(Double.MAX_VALUE, -300000000.0, MINUS));
        assertEquals(-Double.MAX_VALUE, calculator.calculate(-300000000.0,
                                                    Double.MAX_VALUE, MINUS));
    }

    @Test
    void calculate_subtractMinValue_isOk() {
        assertEquals(0.0, calculator.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MINUS));
        assertEquals(-Double.POSITIVE_INFINITY, calculator.calculate(-Double.MAX_VALUE,
                                                            Double.MAX_VALUE, MINUS));
        assertEquals(-Double.MAX_VALUE, calculator.calculate(-Double.MAX_VALUE,
                                                -300000000.0, MINUS), DELTA);
        assertEquals(Double.MAX_VALUE, calculator.calculate(-300000000.0,
                                            -Double.MAX_VALUE, MINUS), DELTA);
    }

    @Test
    void calculate_multiplyTwoPositives_isOk() {
        assertEquals(15.0, calculator.calculate(3.0, 5.0, MULTIPLICATION));
        assertEquals(20.0, calculator.calculate(2.0, 10.0, MULTIPLICATION));
        assertEquals(0.0, calculator.calculate(6.0, 0.0, MULTIPLICATION));
        assertEquals(0.0, calculator.calculate(0.0, 9.0, MULTIPLICATION));
    }

    @Test
    void calculate_multiplyTwoNegatives_isOk() {
        assertEquals(40.0, calculator.calculate(-8.0, -5.0, MULTIPLICATION));
        assertEquals(12.0, calculator.calculate(-6.0, -2.0, MULTIPLICATION));
        assertEquals(-0.0, calculator.calculate(0.0, -9.0, MULTIPLICATION));
        assertEquals(-0.0, calculator.calculate(-5.0, 0.0, MULTIPLICATION));
    }

    @Test
    void calculate_multiplyPositiveAndNegative_isOk() {
        assertEquals(-40.0, calculator.calculate(-5.0, 8.0, MULTIPLICATION));
        assertEquals(-14.0, calculator.calculate(7.0, -2.0, MULTIPLICATION));
    }

    @Test
    void calculate_multiplyMaxValue_isOk() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                                                Double.MAX_VALUE, MULTIPLICATION));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                                                        30.0, MULTIPLICATION));
        assertEquals(-Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE,
                                                    -Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void calculate_multiplyMinValue_isOk() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(-Double.MAX_VALUE,
                                                -Double.MAX_VALUE, MULTIPLICATION));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(-Double.MAX_VALUE,
                                                    -30.0, MULTIPLICATION), DELTA);
        assertEquals(-Double.POSITIVE_INFINITY, calculator.calculate(-Double.MAX_VALUE,
                                                    30.0, MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_divisionTwoPositives_isOk() {
        assertEquals(4.0, calculator.calculate(120.0, 30.0, DIVISION));
        assertEquals(0.5, calculator.calculate(10.0, 20.0, DIVISION));
        assertEquals(0.0, calculator.calculate(0.0, 7.0, DIVISION));
    }

    @Test
    void calculate_divisionTwoNegatives_isOk() {
        assertEquals(4.0, calculator.calculate(-20.0, -5.0, DIVISION));
        assertEquals(0.6, calculator.calculate(-6.0, -10.0, DIVISION));
        assertEquals(-0.0, calculator.calculate(0.0, -2.0, DIVISION));
    }

    @Test
    void calculate_divisionPositiveAndNegative_isOk() {
        assertEquals(-8.0, calculator.calculate(40.0, -5.0, DIVISION));
        assertEquals(-6.0, calculator.calculate(-60.0, 10.0, DIVISION));
    }

    @Test
    void calculate_divisionByZero_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-9.0, 0.0, DIVISION);
            calculator.calculate(8.0, 0.0, DIVISION);
        });
    }

    @Test
    void calculate_powTwoPositives_isOk() {
        assertEquals(27.0, calculator.calculate(3.0, 3.0, POWER), DELTA);
        assertEquals(33.64, calculator.calculate(5.8, 2.0, POWER), DELTA);
        assertEquals(9.49, calculator.calculate(90, 0.5, POWER), DELTA);
    }

    @Test
    void calculate_powTwoNegatives_isOk() {
        assertEquals(81.0, calculator.calculate(-9.0, 2.0, POWER));
        assertEquals(6.25, calculator.calculate(-2.5, 2.0, POWER), DELTA);
        assertEquals(0.58, calculator.calculate(3, -0.5, POWER), DELTA);
        assertEquals(0.02, calculator.calculate(-7.0, -2.0, POWER), DELTA);
    }

    @Test
    void calculate_powTwoNegatives_NotOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-9.0, -0.5, POWER);
        });
    }

    @Test
    void calculate_powMaxValue_isOk() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Double.MAX_VALUE, 2.0, POWER));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(3, Double.MAX_VALUE, POWER));
        assertEquals(1.0, calculator.calculate(Double.MAX_VALUE, 0.0, POWER));
    }

    @Test
    void calculate_powMinValue_isOk() {
        assertEquals(-Double.POSITIVE_INFINITY, calculator.calculate(-Double.MAX_VALUE,
                                                                    3.0, POWER));
        assertEquals(0.0, calculator.calculate(5, -Double.MAX_VALUE, POWER));
        assertEquals(1.0, calculator.calculate(-Double.MAX_VALUE, 0.0, POWER));
    }

    @Test
    void calculate_powWithZero_isOk() {
        assertEquals(1.0, calculator.calculate(6.0, 0.0, POWER));
        assertEquals(0.0, calculator.calculate(0.0, 2.0, POWER));
        assertEquals(1.0, calculator.calculate(-3.0, 0.0, POWER));
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(0.0, -5.0, POWER));
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(5.0, 5.0, '&');
            calculator.calculate(5.0, 5.0, '!');
            calculator.calculate(5.0, 5.0, '$');
            calculator.calculate(5.0, 5.0, '@');
            calculator.calculate(5.0, 5.0, '=');
            calculator.calculate(5.0, 5.0, '%');
            calculator.calculate(5.0, 5.0, '?');
            calculator.calculate(5.0, 5.0, '>');
            calculator.calculate(5.0, 5.0, '<');
            calculator.calculate(5.0, 5.0, 'f');
            calculator.calculate(5.0, 5.0, ':');
            calculator.calculate(5.0, 5.0, ',');
            calculator.calculate(5.0, 5.0, '|');
        });
    }
}
