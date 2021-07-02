package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalcTest {
    private static final int INT_NUM = 10;
    private static final double DOUBLE_NUM = 0.05;
    private static final byte BYTE_NUM = 100;
    private static final float FLOAT_NUM = 0.5f;
    private static final short SHORT_NUM = 1;
    private static final long LONG_NUM = 999;
    private static final char CHAR1 = 'A';
    private static final char CHAR2 = 'B';
    private static final double ZERO = 0.0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING = '^';
    private static final char ILLEGAL_OPERATION1 = '!';
    private static final char ILLEGAL_OPERATION2 = '@';
    private static final char ILLEGAL_OPERATION3 = '#';
    private static final char ILLEGAL_OPERATION4 = '4';
    private static final char CHAR_OK_OPERATION = 43;
    private static final double ALLOWED_DELTA = 0.0001;
    private static LambdaCalc calc;

    @BeforeAll
    public static void setUp() {
        calc = new LambdaCalc();
    }

    @Test
    public void calculate_addTwoPositives_ok() {
        double expected = INT_NUM + DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, ADDITION));

        expected = BYTE_NUM + FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, ADDITION));

        expected = SHORT_NUM + LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, ADDITION));

        expected = CHAR1 + CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, ADDITION));

        expected = INT_NUM + DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, CHAR_OK_OPERATION));
    }

    @Test
    public void calculate_addTwoNegatives_ok() {
        double expected = -INT_NUM + (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, ADDITION));

        expected = -BYTE_NUM + (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, ADDITION));

        expected = -LONG_NUM + (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, ADDITION));
    }

    @Test
    public void calculate_addPositiveNegative_ok() {
        double expected = INT_NUM + (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, ADDITION));

        expected = BYTE_NUM + (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, ADDITION));

        expected = SHORT_NUM + (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, ADDITION));

        expected = CHAR1 + (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, ADDITION));
    }

    @Test
    public void calculate_addZero_ok() {
        double expected = INT_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, ADDITION));

        expected = -FLOAT_NUM;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM, ADDITION));

        expected = ZERO;
        assertEquals(expected, calc.calculate(ZERO, -ZERO, ADDITION));

        expected = CHAR1;
        assertEquals(expected, calc.calculate(CHAR1, ZERO, ADDITION));
    }

    @Test
    public void calculate_addMaxDouble_ok() {
        double expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, ADDITION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -FLOAT_NUM, ADDITION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -ZERO, ADDITION));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, ADDITION));

        expected = 0;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, ADDITION));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, ADDITION));
    }

    @Test
    public void calculate_subtractTwoPositives_ok() {
        double expected = INT_NUM - DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, SUBTRACTION));

        expected = BYTE_NUM - FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, SUBTRACTION));

        expected = SHORT_NUM - LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, SUBTRACTION));

        expected = CHAR1 - CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, SUBTRACTION));
    }

    @Test
    public void calculate_subtractTwoNegatives_ok() {
        double expected = -INT_NUM - (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, SUBTRACTION));

        expected = -BYTE_NUM - (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, SUBTRACTION));

        expected = -LONG_NUM - (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, SUBTRACTION));
    }

    @Test
    public void calculate_subtractPositiveNegative_ok() {
        double expected = INT_NUM - (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, SUBTRACTION));

        expected = BYTE_NUM - (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, SUBTRACTION));

        expected = SHORT_NUM - (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, SUBTRACTION));

        expected = CHAR1 - (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, SUBTRACTION));
    }

    @Test
    public void calculate_subtractZero_ok() {
        double expected = INT_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, SUBTRACTION));

        expected = FLOAT_NUM;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM, SUBTRACTION));

        expected = ZERO;
        assertEquals(expected, calc.calculate(ZERO, -ZERO, SUBTRACTION));

        expected = CHAR1;
        assertEquals(expected, calc.calculate(CHAR1, ZERO, SUBTRACTION));
    }

    @Test
    public void calculate_subtractMaxDouble_ok() {
        double expected = -Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, SUBTRACTION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -FLOAT_NUM, SUBTRACTION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -ZERO, SUBTRACTION));

        expected = 0;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, SUBTRACTION));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, SUBTRACTION));

        expected = 0;
        assertEquals(expected, calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, SUBTRACTION));
    }

    @Test
    public void calculate_multiplyTwoPositives_ok() {
        double expected = INT_NUM * DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, MULTIPLICATION));

        expected = BYTE_NUM * FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, MULTIPLICATION));

        expected = SHORT_NUM * LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, MULTIPLICATION));

        expected = CHAR1 * CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, MULTIPLICATION));
    }

    @Test
    public void calculate_multiplyTwoNegatives_ok() {
        double expected = -INT_NUM * (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, MULTIPLICATION));

        expected = -BYTE_NUM * (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, MULTIPLICATION));

        expected = -LONG_NUM * (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, MULTIPLICATION));
    }

    @Test
    public void calculate_multiplyPositiveNegative_ok() {
        double expected = INT_NUM * (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, MULTIPLICATION));

        expected = BYTE_NUM * (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, MULTIPLICATION));

        expected = SHORT_NUM * (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, MULTIPLICATION));

        expected = CHAR1 * (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, MULTIPLICATION));
    }

    @Test
    public void calculate_multiplyZero_ok() {
        double expected = 0;
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, MULTIPLICATION));

        expected = 0;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM,MULTIPLICATION), ALLOWED_DELTA);

        expected = 0;
        assertEquals(expected, calc.calculate(ZERO, -ZERO,MULTIPLICATION), ALLOWED_DELTA);

        expected = 0;
        assertEquals(expected, calc.calculate(CHAR1, ZERO, MULTIPLICATION));
    }

    @Test
    public void calculate_multiplyMaxDouble_ok() {
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, MULTIPLICATION));

        expected = Double.MAX_VALUE * (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -FLOAT_NUM, MULTIPLICATION));

        expected = 0;
        assertEquals(expected,
                calc.calculate(Double.MAX_VALUE, -ZERO, MULTIPLICATION), ALLOWED_DELTA);

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, MULTIPLICATION));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION));

        expected = 0;
        assertEquals(expected,
                calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, MULTIPLICATION), ALLOWED_DELTA);

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected,
                calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, MULTIPLICATION));
    }

    @Test
    public void calculate_divideTwoPositives_ok() {
        double expected = INT_NUM / DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, DIVISION));

        expected = BYTE_NUM / FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, DIVISION), ALLOWED_DELTA);

        expected = (double) SHORT_NUM / LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, DIVISION));

        expected = (double) CHAR1 / CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, DIVISION));
    }

    @Test
    public void calculate_divideTwoNegatives_ok() {
        double expected = -INT_NUM / (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, DIVISION));

        expected = -BYTE_NUM / (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, DIVISION), ALLOWED_DELTA);

        expected = (double) -LONG_NUM / (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, DIVISION));
    }

    @Test
    public void calculate_dividePositiveNegative_ok() {
        double expected = INT_NUM / (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, DIVISION));

        expected = BYTE_NUM / (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, DIVISION), ALLOWED_DELTA);

        expected = (double) SHORT_NUM / (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, DIVISION));

        expected = CHAR1 / (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, DIVISION));
    }

    @Test
    public void calculate_divideZero_ok() {
        double expected = 0;
        assertEquals(expected, calc.calculate(ZERO, INT_NUM, DIVISION));

        expected = 0;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM, DIVISION), ALLOWED_DELTA);
    }

    @Test
    public void calculate_divideByZero_notOk() {
        assertThrows(ArithmeticException.class, () -> calc.calculate(INT_NUM, ZERO, DIVISION));

        assertThrows(ArithmeticException.class, () -> calc.calculate(-DOUBLE_NUM, -ZERO, DIVISION));

        assertThrows(ArithmeticException.class, () -> calc.calculate(ZERO, ZERO, DIVISION));
    }

    @Test
    public void calculate_divisionMaxDouble_ok() {
        double expected = 0;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, DIVISION), ALLOWED_DELTA);

        expected = 1;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, DIVISION));

        expected = -1;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, DIVISION));

        expected = 1;
        assertEquals(expected, calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, DIVISION));
    }

    @Test
    public void calculate_positivePow_ok() {
        double expected = Math.pow(INT_NUM, DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, RAISING));

        expected = Math.pow(FLOAT_NUM, BYTE_NUM);
        assertEquals(expected, calc.calculate(FLOAT_NUM, BYTE_NUM, RAISING));

        expected = Math.pow(-FLOAT_NUM, SHORT_NUM);
        assertEquals(expected, calc.calculate(-FLOAT_NUM, SHORT_NUM, RAISING));

        expected = Math.pow(CHAR1, CHAR2);
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, RAISING));
    }

    @Test
    public void calculate_negativePow_ok() {
        double expected = Math.pow(INT_NUM, -DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, RAISING));

        expected = Math.pow(FLOAT_NUM, -BYTE_NUM);
        assertEquals(expected, calc.calculate(FLOAT_NUM, -BYTE_NUM, RAISING));

        expected = Math.pow(-FLOAT_NUM, -SHORT_NUM);
        assertEquals(expected, calc.calculate(-FLOAT_NUM, -SHORT_NUM, RAISING));
    }

    @Test
    public void calculate_toZeroPow_ok() {
        double expected = 1;
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, RAISING));

        expected = 1;
        assertEquals(expected, calc.calculate(FLOAT_NUM, -ZERO, RAISING));

        expected = 1;
        assertEquals(expected, calc.calculate(-FLOAT_NUM, ZERO, RAISING));

        expected = 1;
        assertEquals(expected, calc.calculate(CHAR1, -ZERO, RAISING));
    }

    @Test
    public void calculate_zeroToPow_ok() {
        double expected = 0;
        assertEquals(expected, calc.calculate(ZERO, INT_NUM, RAISING));

        expected = 0;
        assertEquals(expected, calc.calculate(-ZERO, FLOAT_NUM, RAISING));
    }

    @Test
    public void calculate_zeroToPow_notOk() {
        assertThrows(ArithmeticException.class, () -> calc.calculate(ZERO, -FLOAT_NUM, RAISING));

        assertThrows(ArithmeticException.class, () -> calc.calculate(-ZERO, -CHAR1, RAISING));
    }

    @Test
    public void calculate_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () ->
                calc.calculate(INT_NUM, BYTE_NUM, ILLEGAL_OPERATION1));

        assertThrows(IllegalArgumentException.class, () ->
                calc.calculate(INT_NUM, BYTE_NUM, ILLEGAL_OPERATION2));

        assertThrows(IllegalArgumentException.class, () ->
                calc.calculate(INT_NUM, BYTE_NUM, ILLEGAL_OPERATION3));

        assertThrows(IllegalArgumentException.class, () ->
                calc.calculate(INT_NUM, BYTE_NUM, ILLEGAL_OPERATION4));
    }
}
