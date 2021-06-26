package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char CHARACTER_MULTIPLICATION = '*';
    public static final char CHARACTER_DIVISION = '/';
    public static final char CHARACTER_POWER = '^';
    private static final double DELTA = 0.0001;
    private static CalculatorImpl calculator;

    @BeforeAll
    static void setCalculator() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void calculate_ExpressionTrue_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(34 + "&" + 45));
    }

    @Test
    public void calculate_additionExpression_ok() {
        for (int i = -100; i < 100; i++) {
            for (int j = -100; j < 100; j++) {
                assertEquals(i + j, calculator.calculate(i + " + " + j));
            }
        }
        assertEquals(-35.56 + 30.56, calculator.calculate(-35.56 + " + " + 30.56), DELTA);
        assertEquals(-35.56 + -30.56, calculator.calculate(-35.56 + " + " + -30.56), DELTA);
        assertEquals(35.56 + -30.56, calculator.calculate(35.56 + " + " + -30.56), DELTA);
        assertEquals(35.56 + 30.56, calculator.calculate(35.56 + " + " + 30.56), DELTA);
    }

    @Test
    public void calculate_subtractionExpression_ok() {
        for (int i = -100; i < 100; i++) {
            for (int j = -9; j < 100; j++) {
                assertEquals(i - j, calculator.calculate(i + " - " + j), DELTA,
                        "i = " + i + " j = " + j);
            }
        }
        assertEquals(-35.56 - 30.56, calculator.calculate(-35.56 + " - " + 30.56), DELTA);
        assertEquals(-35.56 - -30.56, calculator.calculate(-35.56 + " - " + -30.56), DELTA);
        assertEquals(35.56 - -30.56, calculator.calculate(35.56 + " - " + -30.56), DELTA);
        assertEquals(35.56 - 30.56, calculator.calculate(35.56 + " - " + 30.56), DELTA);
    }

    @Test
    public void calculate_divisionExpression_ok() {
        for (int i = -100; i < 100; i++) {
            for (int j = -100; j < 100; j++) {
                if (j == 0) {
                    continue;
                }
                assertEquals((double) i / j, calculator.calculate(i + " / " + j), DELTA,
                        "i = " + i + " j = " + j);
            }
        }
        assertEquals(-35.56 / 30.56, calculator.calculate(-35.56 + " / " + 30.56), DELTA);
        assertEquals(-35.56 / -30.56, calculator.calculate(-35.56 + " / " + -30.56), DELTA);
        assertEquals(35.56 / -30.56, calculator.calculate(35.56 + " / " + -30.56), DELTA);
        assertEquals(35.56 / 30.56, calculator.calculate(35.56 + " / " + 30.56), DELTA);
    }

    @Test
    public void calculate_multiplyExpression_ok() {
        for (int i = -100; i < 100; i++) {
            for (int j = -100; j < 100; j++) {
                assertEquals(i * j, calculator.calculate(i + " * " + j), DELTA,
                        "i = " + i + " j = " + j);
            }
        }
        assertEquals(-35.56 * 30.56, calculator.calculate(-35.56 + " * " + 30.56), DELTA);
        assertEquals(-35.56 * -30.56, calculator.calculate(-35.56 + " * " + -30.56), DELTA);
        assertEquals(35.56 * -30.56, calculator.calculate(35.56 + " * " + -30.56), DELTA);
        assertEquals(35.56 * 30.56, calculator.calculate(35.56 + " * " + 30.56), DELTA);
    }

    @Test
    public void calculate_powerExpression_ok() {
        for (int i = -100; i < 100; i++) {
            for (int j = -100; j < 100; j++) {
                assertEquals(Math.pow(i, j), calculator.calculate(i + " ^ " + j), DELTA,
                        "i = " + i + " j = " + j);
            }
        }
        assertEquals(Math.pow(-35.56, 30.56), calculator.calculate(-35.56 + " ^ " + 30.56), DELTA);
        assertEquals(Math.pow(35.56, -30.56), calculator.calculate(35.56 + " ^ " + -30.56), DELTA);
        assertEquals(Math.pow(35.56, 30.56), calculator.calculate(35.56 + " ^ " + 30.56), DELTA);
        assertEquals(Math.pow(-35.56, -30.56), calculator.calculate(-35.56 + " ^ " + -30.56),
                DELTA);
    }

    @Test
    void calculate_additionPositiveOperands_ok() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(i + j, calculator.calculate(i, j, PLUS));
            }
        }
        double a = 0.5;
        double b = 0.345;
        double expected = a + b;
        double actual = calculator.calculate(a, b, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionNegativeOperands_ok() {
        for (int i = -10; i < 0; i++) {
            for (int j = -10; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, PLUS));
            }
        }
        double a = -0.5;
        double b = -0.345;
        double expected = a + b;
        double actual = calculator.calculate(a, b, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveNegativeNumbers_ok() {
        for (int i = 100; i > 0; i--) {
            for (int j = -100; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, PLUS));
            }
        }
        double a = -0.5;
        double b = 0.345;
        double expected = a + b;
        double actual = calculator.calculate(a, b, PLUS);
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a + b;
        actual = calculator.calculate(a, b, PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionZero_ok() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, calculator.calculate(i, 0, PLUS));
            assertEquals(i, calculator.calculate(0, i, PLUS));
        }
    }

    @Test
    void calculate_differentOperationWithMinAndMaxDoubleValue_ok() {
        assertEquals(0, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MINUS), DELTA);
        assertEquals(0, calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, PLUS), DELTA);
        assertEquals(8.881784197001251E-16,
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, CHARACTER_MULTIPLICATION),
                DELTA);
        assertEquals(0.0,
                calculator.calculate(Double.MIN_VALUE, 3.234, CHARACTER_DIVISION), DELTA);
        assertEquals(5.558729545028805E307,
                calculator.calculate(Double.MAX_VALUE, 3.234, CHARACTER_DIVISION), DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands_ok() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(i - j, calculator.calculate(i, j, MINUS));
            }
        }
        double a = 0.5;
        double b = 0.345;
        double expected = a - b;
        double actual = calculator.calculate(a, b, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeOperands_ok() {
        for (int i = -10; i < 0; i++) {
            for (int j = -10; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, PLUS));
            }
        }
        double a = -0.5;
        double b = -0.345;
        double expected = a - b;
        double actual = calculator.calculate(a, b, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveNegativeNumbers_ok() {
        for (int i = 100; i > 0; i--) {
            for (int j = 100; j > 0; j--) {
                assertEquals(i - j, calculator.calculate(i, j, MINUS));
            }
        }
        double a = -0.5;
        double b = 0.345;
        double expected = a - b;
        double actual = calculator.calculate(a, b, MINUS);
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a - b;
        actual = calculator.calculate(a, b, MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionZero_ok() {
        for (int i = 0; i < 100; i++) {
            assertEquals(i, calculator.calculate(i, 0, MINUS));
            assertEquals(-i, calculator.calculate(0, i, MINUS));
        }
    }

    @Test
    void calculate_multiplicationPositiveOperands_ok() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                assertEquals(i * j, calculator.calculate(i, j, CHARACTER_MULTIPLICATION));
            }
        }
        double a = 0.5;
        double b = 0.345;
        double expected = a * b;
        double actual = calculator.calculate(a, b, CHARACTER_MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_ok() {
        for (int i = -100; i < 0; i++) {
            for (int j = -100; j < 0; j++) {
                assertEquals(i * j, calculator.calculate(i, j, CHARACTER_MULTIPLICATION));
            }
        }
        double a = -0.5;
        double b = -0.345;
        double expected = a * b;
        double actual = calculator.calculate(a, b, CHARACTER_MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveNegativeNumbers_ok() {
        for (int i = 100; i > 0; i--) {
            for (int j = -100; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, PLUS));
            }
        }
        double a = -0.5;
        double b = 0.345;
        double expected = a * b;
        double actual = calculator.calculate(a, b, CHARACTER_MULTIPLICATION);
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a * b;
        actual = calculator.calculate(a, b, CHARACTER_MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationZero_ok() {
        for (int i = 0; i < 100; i++) {
            assertEquals(0, calculator.calculate(i, 0, CHARACTER_MULTIPLICATION));
            assertEquals(0, calculator.calculate(0, i, CHARACTER_MULTIPLICATION));
        }
    }

    @Test
    void calculate_divisionPositiveOperands_ok() {
        double a = 0.5;
        double b = 0.345;
        double expected = a / b;
        double actual = calculator.calculate(a, b, CHARACTER_DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeOperands_ok() {
        double a = -0.5;
        double b = -0.345;
        double expected = a / b;
        double actual = calculator.calculate(a, b, CHARACTER_DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveNegativeNumbers_ok() {
        double a = -0.5;
        double b = 0.345;
        double expected = a / b;
        double actual = calculator.calculate(a, b, CHARACTER_DIVISION);
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a / b;
        actual = calculator.calculate(a, b, CHARACTER_DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionZero_notOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(4.6, 0, CHARACTER_DIVISION));
    }

    @Test
    void calculate_raisingPositiveNumberToPositivePower_ok() {
        double expected = Math.pow(0.5, 34);
        double actual = calculator.calculate(0.5, 34, CHARACTER_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeNumberToPositivePower_ok() {
        double expected = Math.pow(-0.5, 34);
        double actual = calculator.calculate(-0.5, 34, CHARACTER_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveNumberToNegativePower_ok() {
        double expected = Math.pow(0.5, -34);
        double actual = calculator.calculate(0.5, -34, CHARACTER_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeNumberToNegativePower_ok() {
        double expected = Math.pow(-0.5, -34);
        double actual = calculator.calculate(-0.5, -34, CHARACTER_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveNumberToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(0.34, 0, CHARACTER_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeNumberToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(-0.34, 0, CHARACTER_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 35, CHARACTER_POWER);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(34, 53, '&'));
    }
}
