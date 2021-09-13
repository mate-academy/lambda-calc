package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char DIVISION = '/';
    public static final char MULTIPLICATION = '*';
    public static final char POWER = '^';
    public static final double A_POSITIVE = 12.154;
    public static final double B_POSITIVE = 7.885;
    public static final double A_NEGATIVE = -13.215;
    public static final double B_NEGATIVE = -9;
    public static final double ZERO = 0;
    public static final double DELTA = 0.001;
    public static final double MAX = Math.pow(2,1023);
    public static final double MIN = Math.pow(2, 1023) * -1;
    public static final double FRACTIONS_NUMBER = 0.00002;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void chekAdditionWithPositiveOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_POSITIVE, ADDITION);
        expected = A_POSITIVE + B_POSITIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void chekAdditionWithNegativeOperands_OK() {
        actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, ADDITION);
        expected = A_NEGATIVE + B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void chekAdditionWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_NEGATIVE, ADDITION);
        expected = A_POSITIVE + B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void chekAdditionWithZeroInDifferentPlaces_OK() {
        assertEquals(A_POSITIVE, calculator.calculate(ZERO, A_POSITIVE, ADDITION), DELTA);
        assertEquals(A_POSITIVE, calculator.calculate(A_POSITIVE, ZERO, ADDITION), DELTA);
        assertEquals(A_NEGATIVE, calculator.calculate(ZERO, A_NEGATIVE, ADDITION), DELTA);
        assertEquals(A_NEGATIVE, calculator.calculate(A_NEGATIVE, ZERO, ADDITION), DELTA);
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, ADDITION), DELTA);
    }

    @Test
    void checkAdditionForMinAndMaxDoubleValues_NotOk() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, A_POSITIVE, ADDITION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(A_NEGATIVE, MAX, ADDITION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, A_NEGATIVE, ADDITION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(A_NEGATIVE, MIN, ADDITION);
        });
    }

    @Test
    void subtractionWithPositiveOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_POSITIVE, SUBTRACTION);
        expected = A_POSITIVE - B_POSITIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithNegativeOperands_OK() {
        actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, SUBTRACTION);
        expected = A_NEGATIVE - B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_NEGATIVE, SUBTRACTION);
        expected = A_POSITIVE - B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_OK() {
        assertEquals(ZERO - A_POSITIVE, calculator.calculate(ZERO, A_POSITIVE, SUBTRACTION), DELTA);
        assertEquals(A_POSITIVE - ZERO, calculator.calculate(A_POSITIVE, ZERO, SUBTRACTION), DELTA);
        assertEquals(ZERO - A_NEGATIVE, calculator.calculate(ZERO, A_NEGATIVE, SUBTRACTION), DELTA);
        assertEquals(A_NEGATIVE - ZERO, calculator.calculate(A_NEGATIVE, ZERO, SUBTRACTION), DELTA);
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, SUBTRACTION), DELTA);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_NotOk() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, A_POSITIVE, SUBTRACTION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(A_NEGATIVE, MAX, SUBTRACTION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, A_NEGATIVE, SUBTRACTION);
        });
    }

    @Test
    void multiplicationWithPositiveOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_POSITIVE, MULTIPLICATION);
        expected = A_POSITIVE * B_POSITIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithNegativeOperands_OK() {
        actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, MULTIPLICATION);
        expected = A_NEGATIVE * B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_NEGATIVE, MULTIPLICATION);
        expected = A_POSITIVE * B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, A_POSITIVE, MULTIPLICATION), DELTA);
        assertEquals(ZERO, calculator.calculate(A_POSITIVE, ZERO, MULTIPLICATION), DELTA);
        assertEquals(ZERO, calculator.calculate(ZERO, A_NEGATIVE, MULTIPLICATION), DELTA);
        assertEquals(ZERO, calculator.calculate(A_NEGATIVE, ZERO, MULTIPLICATION), DELTA);
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, SUBTRACTION), DELTA);
    }

    @Test
    void multiplicationForMinAndMaxDoubleValues_NotOk() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, A_POSITIVE, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(A_POSITIVE, MIN, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(A_NEGATIVE, MIN, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, A_NEGATIVE, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, A_POSITIVE, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(A_POSITIVE, MAX, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(A_NEGATIVE, MAX, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, A_NEGATIVE, MULTIPLICATION);
        });
    }

    @Test
    void divisionWithPositiveOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_POSITIVE, DIVISION);
        expected = A_POSITIVE / B_POSITIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithNegativeOperands_OK() {
        actual = calculator.calculate(A_NEGATIVE, B_NEGATIVE, DIVISION);
        expected = A_NEGATIVE / B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(A_POSITIVE, B_NEGATIVE, DIVISION);
        expected = A_POSITIVE / B_NEGATIVE;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithZeroInDifferentPlaces() {
        assertThrows(DivisionByZeroException.class,() -> {
            calculator.calculate(A_POSITIVE, ZERO, DIVISION);
        });
        assertThrows(DivisionByZeroException.class,() -> {
            calculator.calculate(ZERO, ZERO, DIVISION);
        });
        assertEquals(ZERO, calculator.calculate(ZERO, A_POSITIVE, DIVISION));
        assertEquals(ZERO, calculator.calculate(ZERO, A_NEGATIVE, DIVISION), DELTA);
    }

    @Test
    void divisionForMinAndMaxDoubleValues() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, FRACTIONS_NUMBER, DIVISION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, FRACTIONS_NUMBER, DIVISION);
        });
        assertEquals(MIN / MAX, calculator.calculate(MIN, MAX, DIVISION), DELTA);
        assertEquals(MAX / MIN, calculator.calculate(MAX, MIN, DIVISION), DELTA);
        assertEquals(1, calculator.calculate(MIN, MIN, DIVISION), DELTA);
        assertEquals(1, calculator.calculate(MAX, MAX, DIVISION), DELTA);
        assertEquals(MIN / A_NEGATIVE, calculator.calculate(MIN, A_NEGATIVE, DIVISION), DELTA);
        assertEquals(MIN / A_POSITIVE, calculator.calculate(MIN, A_POSITIVE, DIVISION), DELTA);
        assertEquals(A_NEGATIVE / MAX, calculator.calculate(A_NEGATIVE, MAX, DIVISION), DELTA);
        assertEquals(A_POSITIVE / MAX, calculator.calculate(A_POSITIVE, MAX, DIVISION), DELTA);
        assertEquals(MAX / A_NEGATIVE, calculator.calculate(MAX, A_NEGATIVE, DIVISION), DELTA);
        assertEquals(MAX / A_POSITIVE, calculator.calculate(MAX, A_POSITIVE, DIVISION), DELTA);
        assertEquals(A_NEGATIVE / MIN, calculator.calculate(A_NEGATIVE, MIN, DIVISION), DELTA);
        assertEquals(A_POSITIVE / MIN, calculator.calculate(A_POSITIVE, MIN, DIVISION), DELTA);
    }

    @Test
    void raisingToPowerWithPositiveOperands_OK() {
        assertEquals(Math.pow(A_POSITIVE, B_POSITIVE),
                calculator.calculate(A_POSITIVE, B_POSITIVE, POWER), DELTA);
        assertEquals(Math.pow(A_POSITIVE, FRACTIONS_NUMBER),
                calculator.calculate(A_POSITIVE, FRACTIONS_NUMBER, POWER), DELTA);
        assertEquals(Math.pow(FRACTIONS_NUMBER, B_POSITIVE),
                calculator.calculate(FRACTIONS_NUMBER, B_POSITIVE, POWER), DELTA);
    }

    @Test
    void raisingToPowerWithPositiveAndNegativeOperands_OK() {
        assertEquals(Math.pow(A_POSITIVE, B_NEGATIVE),
                calculator.calculate(A_POSITIVE, B_NEGATIVE, POWER), DELTA);
        assertEquals(Math.pow(A_NEGATIVE, B_POSITIVE),
                calculator.calculate(A_NEGATIVE, B_POSITIVE, POWER), DELTA);
        assertEquals(Math.pow(A_NEGATIVE, B_NEGATIVE),
                calculator.calculate(A_NEGATIVE, B_NEGATIVE, POWER), DELTA);
        assertEquals(Math.pow(A_POSITIVE, FRACTIONS_NUMBER),
                calculator.calculate(A_POSITIVE, FRACTIONS_NUMBER, POWER), DELTA);
        assertEquals(Math.pow(A_NEGATIVE, FRACTIONS_NUMBER),
                calculator.calculate(A_NEGATIVE, FRACTIONS_NUMBER, POWER), DELTA);
        assertEquals(Math.pow(FRACTIONS_NUMBER, B_NEGATIVE),
                calculator.calculate(FRACTIONS_NUMBER, B_NEGATIVE, POWER), DELTA);
    }

    @Test
    void raisingToPowerWithPositiveNegativeAndZeroOperands_OK() {
        assertEquals(1, calculator.calculate(A_POSITIVE, ZERO, POWER));
        assertEquals(1, calculator.calculate(A_NEGATIVE, ZERO, POWER));
        assertEquals(1, calculator.calculate(ZERO, ZERO, POWER));
        assertEquals(0, calculator.calculate(ZERO, B_POSITIVE, POWER));
        assertEquals(0, calculator.calculate(ZERO, FRACTIONS_NUMBER, POWER));
        assertThrows(MinMaxValueException.class, () -> {
            calculator.calculate(ZERO, B_NEGATIVE, POWER);
        });
    }

    @Test
    void raisingToPowerForMinAndMaxDoubleValues() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, MIN, POWER);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, MAX, POWER);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, MIN, POWER);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, MAX, POWER);
        });
    }

    @Test
    void checkForNull_NotOk() {
        Double checkNull = null;
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(checkNull, A_POSITIVE, ADDITION);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(A_NEGATIVE, checkNull, SUBTRACTION);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(checkNull, checkNull, DIVISION);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FRACTIONS_NUMBER, checkNull, POWER);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(A_POSITIVE, checkNull, POWER);
        });
        Character charNull = null;
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(checkNull, checkNull, charNull);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(B_POSITIVE, A_POSITIVE, charNull);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(checkNull, A_POSITIVE, charNull);
        });
    }

    @Test
    void checkForValidOperator_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(A_NEGATIVE, B_POSITIVE, '%');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(A_NEGATIVE, B_POSITIVE, '5');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(A_NEGATIVE, B_POSITIVE, '>');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(A_NEGATIVE, B_POSITIVE, '.');
        });
    }
}
