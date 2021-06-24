package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static CalculatorImpl calculator;
    private static final double DELTA = 0.0001;

    @BeforeAll
    static void setCalculator() {
        calculator = new CalculatorImpl();
    }

    @Test
    void calculate_additionPositiveOperands_ok() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(i + j, calculator.calculate(i, j, '+'));
            }
        }
        double a = 0.5;
        double b = 0.345;
        double expected = a + b;
        double actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionNegativeOperands_ok() {
        for (int i = -10; i < 0; i++) {
            for (int j = -10; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, '+'));
            }
        }
        double a = -0.5;
        double b = -0.345;
        double expected = a + b;
        double actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveNegativeNumbers_ok() {
        for (int i = 100; i > 0; i--) {
            for (int j = -100; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, '+'));
            }
        }
        double a = -0.5;
        double b = 0.345;
        double expected = a + b;
        double actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a + b;
        actual = calculator.calculate(a, b, '+');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionZero_ok() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i + 0, calculator.calculate(i, 0, '+'));
            assertEquals(0 + i, calculator.calculate(0, i, '+'));
        }
    }

    @Test
    void calculate_differentOperationWithMinAndMaxDoubleValue_ok() {
        assertEquals(0,
                calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'), DELTA);
        assertEquals(0,
                calculator.calculate(-Double.MAX_VALUE, Double.MAX_VALUE, '+'), DELTA);
        assertEquals(8.881784197001251E-16,
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*'), DELTA);
        assertEquals(0.0,
                calculator.calculate(Double.MIN_VALUE, 3.234, '/'), DELTA);
        assertEquals(5.558729545028805E307,
                calculator.calculate(Double.MAX_VALUE, 3.234, '/'), DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands_ok() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(i - j, calculator.calculate(i, j, '-'));
            }
        }
        double a = 0.5;
        double b = 0.345;
        double expected = a - b;
        double actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeOperands_ok() {
        for (int i = -10; i < 0; i++) {
            for (int j = -10; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, '+'));
            }
        }
        double a = -0.5;
        double b = -0.345;
        double expected = a - b;
        double actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveNegativeNumbers_ok() {
        for (int i = 100; i > 0; i--) {
            for (int j = 100; j > 0; j--) {
                assertEquals(i - j, calculator.calculate(i, j, '-'));
            }
        }
        double a = -0.5;
        double b = 0.345;
        double expected = a - b;
        double actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a - b;
        actual = calculator.calculate(a, b, '-');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionZero_ok() {
        for (int i = 0; i < 100; i++) {
            assertEquals(i - 0, calculator.calculate(i, 0, '-'));
            assertEquals(0 - i, calculator.calculate(0, i, '-'));
        }
    }

    @Test
    void calculate_multiplicationPositiveOperands_ok() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                assertEquals(i * j, calculator.calculate(i, j, '*'));
            }
        }
        double a = 0.5;
        double b = 0.345;
        double expected = a * b;
        double actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_ok() {
        for (int i = -100; i < 0; i++) {
            for (int j = -100; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, '+'));
            }
        }
        double a = -0.5;
        double b = -0.345;
        double expected = a * b;
        double actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveNegativeNumbers_ok() {
        for (int i = 100; i > 0; i--) {
            for (int j = -100; j < 0; j++) {
                assertEquals(i + j, calculator.calculate(i, j, '+'));
            }
        }
        double a = -0.5;
        double b = 0.345;
        double expected = a * b;
        double actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a * b;
        actual = calculator.calculate(a, b, '*');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationZero_ok() {
        for (int i = 0; i < 100; i++) {
            assertEquals(i + 0, calculator.calculate(i, 0, '+'));
            assertEquals(0 + i, calculator.calculate(0, i, '+'));
        }
    }

    @Test
    void calculate_divisionPositiveOperands_ok() {
        double a = 0.5;
        double b = 0.345;
        double expected = a / b;
        double actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeOperands_ok() {
        double a = -0.5;
        double b = -0.345;
        double expected = a / b;
        double actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveNegativeNumbers_ok() {
        double a = -0.5;
        double b = 0.345;
        double expected = a / b;
        double actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
        a = 0.5;
        b = -0.345;
        expected = a / b;
        actual = calculator.calculate(a, b, '/');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionZero_notOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(4.6, 0, '/'));
    }

    @Test
    void calculate_raisingPositiveNumberToPositivePower_ok() {
        double expected = Math.pow(0.5, 34);
        double actual = calculator.calculate(0.5, 34, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeNumberToPositivePower_ok() {
        double expected = Math.pow(-0.5, 34);
        double actual = calculator.calculate(-0.5, 34, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveNumberToNegativePower_ok() {
        double expected = Math.pow(0.5, -34);
        double actual = calculator.calculate(0.5, -34, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeNumberToNegativePower_ok() {
        double expected = Math.pow(-0.5, -34);
        double actual = calculator.calculate(-0.5, -34, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveNumberToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(0.34, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeNumberToZeroPower_ok() {
        double expected = 1;
        double actual = calculator.calculate(-0.34, 0, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroToPower_ok() {
        double expected = 0;
        double actual = calculator.calculate(0, 35, '^');
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            for (int i = 0; i < 1000; i++) {
                if (i == (int) '+' || i == (int) '-' || i == (int) '/' || i == (int) '*'
                        || i == (int) '^') {
                    continue;
                }
                calculator.calculate(34, 53, (char) i);
            }
        });
    }

}
