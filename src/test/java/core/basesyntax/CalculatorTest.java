package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_POWER = '^';
    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private static final int INT_NUB = 5;
    private static final double DOUBLE_NUB = 0.001;
    private static final float FLOAT_NUB = 0.0001f;
    private static final long LONG_NUB = 500;
    private static final short SHORT_NUB = 300;
    private static final byte BYTE_NUB = 16;
    private static final double ZERO = 0;
    private static final char CHAR1_NUB = 'C';
    private static final char CHAR2_NUB = 'H';
    private static final char ILLEGAL_OPERATION1 = '!';
    private static final char ILLEGAL_OPERATION2 = '0';
    private static final char ILLEGAL_OPERATION3 = '@';
    private static final char ILLEGAL_OPERATION4 = '#';

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void twoPositive_addition_ok() {
        double expected = INT_NUB + DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, DOUBLE_NUB, ADDITION));

        expected = FLOAT_NUB + LONG_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, LONG_NUB, ADDITION), DELTA);
        
        expected = SHORT_NUB + BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, BYTE_NUB, ADDITION));

        expected = CHAR1_NUB + CHAR2_NUB;
        assertEquals(expected, calculator.calculate(CHAR1_NUB, CHAR2_NUB, ADDITION));

        expected = INT_NUB + FLOAT_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, FLOAT_NUB, ADDITION), DELTA);

        expected = LONG_NUB + DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(LONG_NUB, DOUBLE_NUB, ADDITION));
    }

    @Test
    void twoNegative_addition_ok() {
        double expected = -INT_NUB + -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, -DOUBLE_NUB, ADDITION));

        expected = -FLOAT_NUB + -LONG_NUB;
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, -LONG_NUB, ADDITION), DELTA);

        expected = -SHORT_NUB + -BYTE_NUB;
        assertEquals(expected, calculator.calculate(-SHORT_NUB, -BYTE_NUB, ADDITION));

        expected = -INT_NUB + -FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, -FLOAT_NUB, ADDITION), DELTA);

        expected = -LONG_NUB + -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, -DOUBLE_NUB, ADDITION));
    }

    @Test
    void onePositive_and_oneNegative_addition_ok() {
        double expected = INT_NUB + -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, -DOUBLE_NUB, ADDITION));

        expected = FLOAT_NUB + -LONG_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, -LONG_NUB, ADDITION), DELTA);

        expected = SHORT_NUB + -BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, -BYTE_NUB, ADDITION));

        expected = -INT_NUB + FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, FLOAT_NUB, ADDITION), DELTA);

        expected = -LONG_NUB + CHAR1_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, CHAR1_NUB, ADDITION));
    }

    @Test
    void withZero_addition_ok() {
        double expected = -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(ZERO, -DOUBLE_NUB, ADDITION));

        expected = FLOAT_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, ZERO, ADDITION));

        expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, ZERO, ADDITION));

        expected = INT_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, ZERO, ADDITION));

    }

    @Test
    void withMaxAndMinValues_addition_ok() {
        double expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(SHORT_NUB, Double.MAX_VALUE, ADDITION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, ZERO, ADDITION));

        expected = ZERO;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calculator
                .calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION));
    }

    @Test
    void twoPositive_subtraction_ok() {
        double expected = INT_NUB - DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, DOUBLE_NUB, SUBTRACTION));

        expected = FLOAT_NUB - LONG_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, LONG_NUB, SUBTRACTION), DELTA);

        expected = SHORT_NUB - BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, BYTE_NUB, SUBTRACTION));

        expected = CHAR1_NUB - CHAR2_NUB;
        assertEquals(expected, calculator.calculate(CHAR1_NUB, CHAR2_NUB, SUBTRACTION));

        expected = INT_NUB - FLOAT_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, FLOAT_NUB, SUBTRACTION), DELTA);

        expected = LONG_NUB - DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(LONG_NUB, DOUBLE_NUB, SUBTRACTION));
    }

    @Test
    void twoNegative_subtraction_ok() {
        double expected = -INT_NUB - -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, -DOUBLE_NUB, SUBTRACTION));

        expected = -FLOAT_NUB - -LONG_NUB;
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, -LONG_NUB, SUBTRACTION), DELTA);

        expected = -SHORT_NUB - -BYTE_NUB;
        assertEquals(expected, calculator.calculate(-SHORT_NUB, -BYTE_NUB, SUBTRACTION));

        expected = -INT_NUB - -FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, -FLOAT_NUB, SUBTRACTION), DELTA);

        expected = -LONG_NUB - -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, -DOUBLE_NUB, SUBTRACTION));
    }

    @Test
    void onePositive_and_oneNegative_subtraction_ok() {
        double expected = INT_NUB - -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, -DOUBLE_NUB, SUBTRACTION));

        expected = -FLOAT_NUB - LONG_NUB;
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, LONG_NUB, SUBTRACTION),DELTA);

        expected = SHORT_NUB - -BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, -BYTE_NUB, SUBTRACTION));

        expected = -INT_NUB - FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, FLOAT_NUB, SUBTRACTION), DELTA);

        expected = -LONG_NUB - CHAR1_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, CHAR1_NUB, SUBTRACTION));
    }

    @Test
    void withZero_subtraction_ok() {
        double expected = -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-DOUBLE_NUB, ZERO, SUBTRACTION));

        expected = CHAR2_NUB;
        assertEquals(expected, calculator.calculate(CHAR2_NUB, ZERO, SUBTRACTION));

        expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, ZERO, SUBTRACTION));

        expected = INT_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, ZERO, SUBTRACTION));

    }

    @Test
    void withMaxAndMinValues_subtraction_ok() {
        double expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, INT_NUB, SUBTRACTION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calculator
                .calculate(Double.MAX_VALUE, ZERO, SUBTRACTION));

        expected = ZERO;
        assertEquals(expected, calculator
                .calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator
                .calculate(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calculator
                .calculate(-Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    void twoPositive_multiplication_ok() {
        double expected = INT_NUB * DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, DOUBLE_NUB, MULTIPLICATION));

        expected = FLOAT_NUB * LONG_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, LONG_NUB, MULTIPLICATION), DELTA);

        expected = SHORT_NUB * BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, BYTE_NUB, MULTIPLICATION));

        expected = CHAR1_NUB * CHAR2_NUB;
        assertEquals(expected, calculator.calculate(CHAR1_NUB, CHAR2_NUB, MULTIPLICATION));

        expected = INT_NUB * FLOAT_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, FLOAT_NUB, MULTIPLICATION), DELTA);

        expected = LONG_NUB * DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(LONG_NUB, DOUBLE_NUB, MULTIPLICATION));
    }

    @Test
    void twoNegative_multiplication_ok() {
        double expected = -INT_NUB * -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, -DOUBLE_NUB, MULTIPLICATION));

        expected = -FLOAT_NUB * -LONG_NUB;
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, -LONG_NUB, MULTIPLICATION), DELTA);

        expected = -SHORT_NUB * -BYTE_NUB;
        assertEquals(expected, calculator.calculate(-SHORT_NUB, -BYTE_NUB, MULTIPLICATION));

        expected = -INT_NUB * -FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, -FLOAT_NUB, MULTIPLICATION), DELTA);

        expected = -LONG_NUB * -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, -DOUBLE_NUB, MULTIPLICATION));
    }

    @Test
    void onePositive_and_oneNegative_multiplication_ok() {
        double expected = INT_NUB * -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, -DOUBLE_NUB, MULTIPLICATION));

        expected = FLOAT_NUB * -LONG_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, -LONG_NUB, MULTIPLICATION), DELTA);

        expected = SHORT_NUB * -BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, -BYTE_NUB, MULTIPLICATION));

        expected = -INT_NUB * FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, FLOAT_NUB, MULTIPLICATION), DELTA);

        expected = -LONG_NUB * DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, DOUBLE_NUB, MULTIPLICATION));
    }

    @Test
    void withZero_multiplication_ok() {
        double expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, DOUBLE_NUB, MULTIPLICATION));

        expected = ZERO;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, ZERO, MULTIPLICATION));

        expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, ZERO, MULTIPLICATION));

        expected = ZERO;
        assertEquals(expected, calculator.calculate(INT_NUB, ZERO, MULTIPLICATION));

    }

    @Test
    void withMaxAndMinValues_multiplication_ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(SHORT_NUB, Double.MAX_VALUE, MULTIPLICATION));

        expected = ZERO;
        assertEquals(expected, calculator
                .calculate(Double.MAX_VALUE, ZERO, MULTIPLICATION), DELTA);

        expected = Double.MAX_VALUE * (-FLOAT_NUB);
        assertEquals(expected, calculator
                .calculate(Double.MAX_VALUE, -FLOAT_NUB, MULTIPLICATION));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator
                .calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calculator
                .calculate(Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    void twoPositive_division_ok() {
        double expected = INT_NUB / DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, DOUBLE_NUB, DIVISION));

        expected = FLOAT_NUB / LONG_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, LONG_NUB, DIVISION), DELTA);

        expected = (double) SHORT_NUB / BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, BYTE_NUB, DIVISION));

        expected = (double) CHAR1_NUB / CHAR2_NUB;
        assertEquals(expected, calculator.calculate(CHAR1_NUB, CHAR2_NUB, DIVISION));

        expected = DOUBLE_NUB / FLOAT_NUB;
        assertEquals(expected, calculator.calculate(DOUBLE_NUB, FLOAT_NUB, DIVISION));

        expected = LONG_NUB / DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(LONG_NUB, DOUBLE_NUB, DIVISION));
    }

    @Test
    void twoNegative_division_ok() {
        double expected = -INT_NUB / -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-INT_NUB, -DOUBLE_NUB, DIVISION));

        expected = -FLOAT_NUB / -LONG_NUB;
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, -LONG_NUB, DIVISION), DELTA);

        expected = (double) -SHORT_NUB / -BYTE_NUB;
        assertEquals(expected, calculator.calculate(-SHORT_NUB, -BYTE_NUB, DIVISION), DELTA);

        expected = -DOUBLE_NUB / -FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-DOUBLE_NUB, -FLOAT_NUB, DIVISION));

        expected = -LONG_NUB / -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, -DOUBLE_NUB, DIVISION));
    }

    @Test
    void onePositive_and_oneNegative_division_ok() {
        double expected = INT_NUB / -DOUBLE_NUB;
        assertEquals(expected, calculator.calculate(INT_NUB, -DOUBLE_NUB, DIVISION));

        expected = FLOAT_NUB / -LONG_NUB;
        assertEquals(expected, calculator.calculate(FLOAT_NUB, -LONG_NUB, DIVISION), DELTA);

        expected = (double) SHORT_NUB / -BYTE_NUB;
        assertEquals(expected, calculator.calculate(SHORT_NUB, -BYTE_NUB, DIVISION), DELTA);

        expected = -DOUBLE_NUB / FLOAT_NUB;
        assertEquals(expected, calculator.calculate(-DOUBLE_NUB, FLOAT_NUB, DIVISION), DELTA);

        expected = (double) -LONG_NUB / CHAR1_NUB;
        assertEquals(expected, calculator.calculate(-LONG_NUB, CHAR1_NUB, DIVISION), DELTA);
    }

    @Test
    void withZero_division_ok() {
        double expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, INT_NUB, DIVISION));

        expected = ZERO;
        assertEquals(expected, calculator.calculate(ZERO, FLOAT_NUB, DIVISION));
    }

    @Test
    void withZero_division_notOk() {
        double expected = ZERO;
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(LONG_NUB, ZERO, DIVISION));

        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(ZERO, ZERO, DIVISION));

        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(-FLOAT_NUB, ZERO, DIVISION));
    }

    @Test
    void withMaxAndMinValues_division_ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION));

        expected = -1;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION));

        expected = 1;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION));

        expected = 1;
        assertEquals(expected, calculator
                .calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION));

        expected = 0;
        assertEquals(expected, calculator.calculate(INT_NUB, Double.MAX_VALUE, DIVISION), DELTA);
    }

    @Test
    void positivePow_ok() {
        double expected = Math.pow(INT_NUB, DOUBLE_NUB);
        assertEquals(expected, calculator.calculate(INT_NUB, DOUBLE_NUB, RAISING_TO_POWER));

        expected = Math.pow(-FLOAT_NUB, LONG_NUB);
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, LONG_NUB, RAISING_TO_POWER));

        expected = Math.pow(CHAR1_NUB, CHAR2_NUB);
        assertEquals(expected, calculator.calculate(CHAR1_NUB, CHAR2_NUB, RAISING_TO_POWER));

        expected = Math.pow(-SHORT_NUB, BYTE_NUB);
        assertEquals(expected, calculator.calculate(-SHORT_NUB, BYTE_NUB, RAISING_TO_POWER));
    }

    @Test
    void negativePow_ok() {
        double expected = Math.pow(INT_NUB, -DOUBLE_NUB);
        assertEquals(expected, calculator.calculate(INT_NUB, -DOUBLE_NUB, RAISING_TO_POWER));

        expected = Math.pow(-FLOAT_NUB, -LONG_NUB);
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, -LONG_NUB, RAISING_TO_POWER));

        expected = Math.pow(CHAR1_NUB, -CHAR2_NUB);
        assertEquals(expected, calculator.calculate(CHAR1_NUB, -CHAR2_NUB, RAISING_TO_POWER));

        expected = Math.pow(-SHORT_NUB, -BYTE_NUB);
        assertEquals(expected, calculator.calculate(-SHORT_NUB, -BYTE_NUB, RAISING_TO_POWER));
    }

    @Test
    void valueToZero_pow_ok() {
        double expected = 1;
        assertEquals(expected, calculator.calculate(INT_NUB, ZERO, RAISING_TO_POWER));

        expected = 1;
        assertEquals(expected, calculator.calculate(-FLOAT_NUB, ZERO, RAISING_TO_POWER));

        expected = 1;
        assertEquals(expected, calculator.calculate(CHAR1_NUB, ZERO, RAISING_TO_POWER));

        expected = 1;
        assertEquals(expected, calculator.calculate(-SHORT_NUB, ZERO, RAISING_TO_POWER));
    }

    @Test
    void zeroToValue_pow_ok() {
        double expected = 0;
        assertEquals(expected, calculator.calculate(ZERO, INT_NUB, RAISING_TO_POWER));

        expected = 0;
        assertEquals(expected, calculator.calculate(ZERO, FLOAT_NUB, RAISING_TO_POWER));
    }

    @Test
    void zeroToValue_pow_notOk() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(INT_NUB, ZERO, DIVISION));

        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(FLOAT_NUB, ZERO, DIVISION));
    }

    @Test
    public void illegalOperation() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(DOUBLE_NUB, INT_NUB, ILLEGAL_OPERATION1));

        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(DOUBLE_NUB, FLOAT_NUB, ILLEGAL_OPERATION2));

        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(DOUBLE_NUB, FLOAT_NUB, ILLEGAL_OPERATION3));

        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(DOUBLE_NUB, FLOAT_NUB, ILLEGAL_OPERATION4));
    }
}
