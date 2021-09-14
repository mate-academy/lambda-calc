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
    public static final double FIRST_OPERAND = 10;
    public static final double SECOND_OPERAND = 4;
    public static final double FIRST_NEGATIVE_OPERAND = -12;
    public static final double SECOND_NEGATIVE_OPERAND = -9;
    public static final double ZERO = 0;
    public static final double DELTA = 0.001;
    public static final double MAX = Math.pow(2,1023);
    public static final double MIN = Math.pow(2, 1023) * -1;
    public static final double FRACTIONS_NUMBER = 0.000002;
    private static Calculator calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_ForAdditionWithPositiveOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, ADDITION);
        expected = 14;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_AdditionWithNegativeOperands_OK() {
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, ADDITION);
        expected = -21;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_AdditionWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_NEGATIVE_OPERAND, ADDITION);
        expected = 1;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_AdditionWithZeroInDifferentPlaces_OK() {
        assertEquals(FIRST_OPERAND, calculator.calculate(ZERO, FIRST_OPERAND, ADDITION), DELTA);
        assertEquals(FIRST_OPERAND, calculator.calculate(FIRST_OPERAND, ZERO, ADDITION), DELTA);
        assertEquals(FIRST_NEGATIVE_OPERAND,
                calculator.calculate(ZERO, FIRST_NEGATIVE_OPERAND, ADDITION), DELTA);
        assertEquals(FIRST_NEGATIVE_OPERAND,
                calculator.calculate(FIRST_NEGATIVE_OPERAND, ZERO, ADDITION), DELTA);
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, ADDITION), DELTA);
    }

    @Test
    void calculate_AdditionForMinAndMaxDoubleValues_NotOk() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, FIRST_OPERAND, ADDITION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, MAX, ADDITION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, FIRST_NEGATIVE_OPERAND, ADDITION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, MIN, ADDITION);
        });
    }

    @Test
    void calculate_SubtractionWithPositiveOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, SUBTRACTION);
        expected = 6;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_SubtractionWithNegativeOperands_OK() {
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, SUBTRACTION);
        expected = -3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_SubtractionWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_NEGATIVE_OPERAND, SUBTRACTION);
        expected = 19;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_SubtractionWithZeroInDifferentPlaces_OK() {
        assertEquals(-10, calculator.calculate(ZERO, FIRST_OPERAND, SUBTRACTION), DELTA);
        assertEquals(10, calculator.calculate(FIRST_OPERAND, ZERO, SUBTRACTION), DELTA);
        assertEquals(12, calculator.calculate(ZERO, FIRST_NEGATIVE_OPERAND, SUBTRACTION), DELTA);
        assertEquals(-12, calculator.calculate(FIRST_NEGATIVE_OPERAND, ZERO, SUBTRACTION), DELTA);
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, SUBTRACTION), DELTA);
    }

    @Test
    void calculate_SubtractionForMinAndMaxDoubleValues_NotOk() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, FIRST_OPERAND, SUBTRACTION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, MAX, SUBTRACTION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, FIRST_NEGATIVE_OPERAND, SUBTRACTION);
        });
    }

    @Test
    void calculate_MultiplicationWithPositiveOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, MULTIPLICATION);
        expected = 40;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_MultiplicationWithNegativeOperands_OK() {
        actual = calculator
                .calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, MULTIPLICATION);
        expected = 108;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_ForMultiplicationWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_NEGATIVE_OPERAND, MULTIPLICATION);
        expected = -90;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_ForMultiplicationWithZeroInDifferentPlaces_OK() {
        assertEquals(ZERO, calculator.calculate(ZERO, FIRST_OPERAND, MULTIPLICATION), DELTA);
        assertEquals(ZERO, calculator.calculate(FIRST_OPERAND, ZERO, MULTIPLICATION), DELTA);
        assertEquals(ZERO,
                calculator.calculate(ZERO, FIRST_NEGATIVE_OPERAND, MULTIPLICATION), DELTA);
        assertEquals(ZERO,
                calculator.calculate(FIRST_NEGATIVE_OPERAND, ZERO, MULTIPLICATION), DELTA);
        assertEquals(ZERO, calculator.calculate(ZERO, ZERO, SUBTRACTION), DELTA);
    }

    @Test
    void calculate_MultiplicationForMinAndMaxDoubleValues_NotOk() {
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, FIRST_OPERAND, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(FIRST_OPERAND, MIN, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, MIN, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MIN, FIRST_NEGATIVE_OPERAND, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, FIRST_OPERAND, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(FIRST_OPERAND, MAX, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, MAX, MULTIPLICATION);
        });
        assertThrows(MinMaxValueException.class,() -> {
            calculator.calculate(MAX, FIRST_NEGATIVE_OPERAND, MULTIPLICATION);
        });
    }

    @Test
    void calculate_rDivisionWithPositiveOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, DIVISION);
        expected = 2.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_DivisionWithNegativeOperands_OK() {
        actual = calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, DIVISION);
        expected = 1.3333333333;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_DivisionWithPositiveAndNegativeOperands_OK() {
        actual = calculator.calculate(FIRST_OPERAND, SECOND_NEGATIVE_OPERAND, DIVISION);
        expected = -1.111111111;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_DivisionWithZeroInDifferentPlaces_NotOk() {
        assertThrows(DivisionByZeroException.class, () -> {
            calculator.calculate(FIRST_OPERAND, ZERO, DIVISION);
        });
        assertThrows(DivisionByZeroException.class, () -> {
            calculator.calculate(ZERO, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_DivisionWithZeroInDifferentPlaces_Ok() {
        assertEquals(ZERO, calculator.calculate(ZERO, FIRST_OPERAND, DIVISION));
        assertEquals(ZERO, calculator.calculate(ZERO, FIRST_NEGATIVE_OPERAND, DIVISION), DELTA);
    }

    @Test
    void calculate_DivisionForMinAndMaxDoubleValues_NotOk() {
        assertThrows(MinMaxValueException.class, () -> {
            calculator.calculate(MIN, FRACTIONS_NUMBER, DIVISION);
        });
        assertThrows(MinMaxValueException.class, () -> {
            calculator.calculate(MAX, FRACTIONS_NUMBER, DIVISION);
        });
    }

    @Test
    void calculate_DivisionForMinAndMaxDoubleValues_Ok() {
        assertEquals(-1,
                calculator.calculate(MIN, MAX, DIVISION), DELTA);
        assertEquals(-1,
                calculator.calculate(MAX, MIN, DIVISION), DELTA);
        assertEquals(1,
                calculator.calculate(MIN, MIN, DIVISION), DELTA);
        assertEquals(1,
                calculator.calculate(MAX, MAX, DIVISION), DELTA);
        assertEquals(7.490388061926316E306,
                calculator.calculate(MIN, FIRST_NEGATIVE_OPERAND, DIVISION), DELTA);
        assertEquals(-8.98846567431158E306,
                calculator.calculate(MIN, FIRST_OPERAND, DIVISION), DELTA);
        assertEquals(-1.3350443151043208E-307,
                calculator.calculate(FIRST_NEGATIVE_OPERAND, MAX, DIVISION), DELTA);
        assertEquals(1.1125369292536007E-307,
                calculator.calculate(FIRST_OPERAND, MAX, DIVISION), DELTA);
        assertEquals(-7.490388061926316E306,
                calculator.calculate(MAX, FIRST_NEGATIVE_OPERAND, DIVISION), DELTA);
        assertEquals(8.98846567431158E306,
                calculator.calculate(MAX, FIRST_OPERAND, DIVISION), DELTA);
        assertEquals(1.3350443151043208E-307,
                calculator.calculate(FIRST_NEGATIVE_OPERAND, MIN, DIVISION), DELTA);
        assertEquals(-1.1125369292536007E-307,
                calculator.calculate(FIRST_OPERAND, MIN, DIVISION), DELTA);
    }

    @Test
    void calculate_RaisingToPowerWithPositiveOperands_OK() {
        assertEquals(10000.0,
                calculator.calculate(FIRST_OPERAND, SECOND_OPERAND, POWER), DELTA);
        assertEquals(1.0000046051807898,
                calculator.calculate(FIRST_OPERAND, FRACTIONS_NUMBER, POWER), DELTA);
        assertEquals(1.5999999999999996E-23,
                calculator.calculate(FRACTIONS_NUMBER, SECOND_OPERAND, POWER), DELTA);
    }

    @Test
    void calculate_RaisingToPowerWithPositiveAndNegativeOperands_OK() {
        assertEquals(1.0E-9,
                calculator.calculate(FIRST_OPERAND, SECOND_NEGATIVE_OPERAND, POWER), DELTA);
        assertEquals(20736.0,
                calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_OPERAND, POWER), DELTA);
        assertEquals(-1.9380669946781485E-10,
                calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_NEGATIVE_OPERAND, POWER));
        assertEquals(1.0000460527622559,
                calculator.calculate(FIRST_OPERAND, FRACTIONS_NUMBER, POWER), DELTA);
        assertEquals(0,
                calculator.calculate(FIRST_NEGATIVE_OPERAND, FRACTIONS_NUMBER, POWER));
        assertEquals(1.9531250000000008E51,
                calculator.calculate(FRACTIONS_NUMBER, SECOND_NEGATIVE_OPERAND, POWER), DELTA);
    }

    @Test
    void calculate_RaisingToPowerWithPositiveNegativeAndZeroOperands_OK() {
        assertEquals(1, calculator.calculate(FIRST_OPERAND, ZERO, POWER));
        assertEquals(1, calculator.calculate(FIRST_NEGATIVE_OPERAND, ZERO, POWER));
        assertEquals(1, calculator.calculate(ZERO, ZERO, POWER));
        assertEquals(0, calculator.calculate(ZERO, SECOND_OPERAND, POWER));
        assertEquals(0, calculator.calculate(ZERO, FRACTIONS_NUMBER, POWER));
    }

    @Test
    void calculate_RatingToPowerWithZeroAndNegativeOperands_NotOk() {
        assertThrows(MinMaxValueException.class, () -> {
            calculator.calculate(ZERO, SECOND_NEGATIVE_OPERAND, POWER);
        });
    }

    @Test
    void calculate_RaisingToPowerForMinAndMaxDoubleValues_NotOk() {
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
    void calculate_ValidOperator_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_OPERAND, '%');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_OPERAND, '5');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_OPERAND, '>');
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(FIRST_NEGATIVE_OPERAND, SECOND_OPERAND, '.');
        });
    }
}
