package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LambdaCalcTest {
    private static LambdaCalc calc;
    private static final int INT_NUM = 10;
    private static final double DOUBLE_NUM = 15.5;
    private static final byte BYTE_NUM = 100;
    private static final float FLOAT_NUM = 15.5f;
    private static final short SHORT_NUM = 1;
    private static final long LONG_NUM = 999;
    private static final char CHAR1 = 'A';
    private static final char CHAR2 = 'B';
    private static final double ZERO = 0.0;

    @BeforeAll
    public static void setUp() {
        calc = new LambdaCalc();
    }

    @Test
    public void getSum_twoPositives_Ok() {
        char operation = '+';

        double expected = INT_NUM + DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, operation));

        expected = BYTE_NUM + FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, operation));

        expected = SHORT_NUM + LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, operation));

        expected = CHAR1 + CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, operation));
    }

    @Test
    public void getSum_twoNegatives_Ok() {
        char operation = '-';

        double expected = -INT_NUM - (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, operation));

        expected = -BYTE_NUM - (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, operation));

        expected = -LONG_NUM - (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, operation));
    }

    @Test
    public void getSum_PositiveNegative_Ok() {
        char operation = '+';

        double expected = INT_NUM + (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, operation));

        expected = BYTE_NUM + (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, operation));

        expected = SHORT_NUM + (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, operation));

        expected = CHAR1 + (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, operation));
    }

    @Test
    public void getSum_ZeroAddition_Ok() {
        char operation = '+';

        double expected = INT_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, operation));

        expected = -FLOAT_NUM;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM,operation));

        expected = ZERO;
        assertEquals(expected, calc.calculate(ZERO, -ZERO,operation));

        expected = CHAR1;
        assertEquals(expected, calc.calculate(CHAR1, ZERO, operation));
    }

    @Test
    public void getSum_MaxDouble_Ok() {
        char operation = '+';

        double expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, operation));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -FLOAT_NUM,operation));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -ZERO,operation));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, operation));

        expected = 0;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, operation));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, operation));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, operation));
    }

    @Test
    public void getSub_twoPositives_Ok() {
        char operation = '-';

        double expected = INT_NUM - DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, operation));

        expected = BYTE_NUM - FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, operation));

        expected = SHORT_NUM - LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, operation));

        expected = CHAR1 - CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, operation));
    }

    @Test
    public void getSub_twoNegatives_Ok() {
        char operation = '-';

        double expected = -INT_NUM - (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, operation));

        expected = -BYTE_NUM - (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, operation));

        expected = -LONG_NUM - (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, operation));
    }

    @Test
    public void getSub_PositiveNegative_Ok() {
        char operation = '-';

        double expected = INT_NUM - (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, operation));

        expected = BYTE_NUM - (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, operation));

        expected = SHORT_NUM - (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, operation));

        expected = CHAR1 - (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, operation));
    }

    @Test
    public void getSub_ZeroSubtractions_Ok() {
        char operation = '-';

        double expected = INT_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, operation));

        expected = FLOAT_NUM;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM,operation));

        expected = ZERO;
        assertEquals(expected, calc.calculate(ZERO, -ZERO,operation));

        expected = CHAR1;
        assertEquals(expected, calc.calculate(CHAR1, ZERO, operation));
    }

    @Test
    public void getSub_MaxDouble_Ok() {
        char operation = '-';

        double expected = -Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, operation));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -FLOAT_NUM,operation));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -ZERO,operation));

        expected = 0;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, operation));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, operation));

        expected = Double.MAX_VALUE;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, operation));

        expected = 0;
        assertEquals(expected, calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, operation));
    }

    @Test
    public void getMult_twoPositives_Ok() {
        char operation = '*';

        double expected = INT_NUM * DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, operation));

        expected = BYTE_NUM * FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, operation));

        expected = SHORT_NUM * LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, operation));

        expected = CHAR1 * CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, operation));
    }

    @Test
    public void getMult_twoNegatives_Ok() {
        char operation = '*';

        double expected = -INT_NUM * (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, operation));

        expected = -BYTE_NUM * (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, operation));

        expected = -LONG_NUM * (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, operation));
    }

    @Test
    public void getMult_PositiveNegative_Ok() {
        char operation = '*';

        double expected = INT_NUM * (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, operation));

        expected = BYTE_NUM * (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, operation));

        expected = SHORT_NUM * (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, operation));

        expected = CHAR1 * (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, operation));
    }

    @Test
    public void getMult_ZeroMultiplications_Ok() {
        char operation = '*';

        double expected = 0;
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, operation));

        expected = 0;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM,operation), 0.0001);

        expected = 0;
        assertEquals(expected, calc.calculate(ZERO, -ZERO,operation), 0.0001);

        expected = 0;
        assertEquals(expected, calc.calculate(CHAR1, ZERO, operation));
    }

    @Test
    public void getMult_MaxDouble_Ok() {
        char operation = '*';

        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, operation));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -FLOAT_NUM, operation));

        expected = 0;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -ZERO,operation), 0.0001);

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, operation));

        expected = Double.NEGATIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, operation));

        expected = 0;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, operation), 1);

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, operation));
    }

    @Test
    public void getDiv_twoPositives_Ok() {
        char operation = '/';

        double expected = INT_NUM / DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, operation));

        expected = BYTE_NUM / FLOAT_NUM;
        assertEquals(expected, calc.calculate(BYTE_NUM, FLOAT_NUM, operation), 0.0001);

        expected = (double) SHORT_NUM / LONG_NUM;
        assertEquals(expected, calc.calculate(SHORT_NUM, LONG_NUM, operation));

        expected = (double) CHAR1 / CHAR2;
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, operation));
    }

    @Test
    public void getDiv_twoNegatives_Ok() {
        char operation = '/';

        double expected = -INT_NUM / (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(-INT_NUM, -DOUBLE_NUM, operation));

        expected = -BYTE_NUM / (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(-BYTE_NUM, -FLOAT_NUM, operation), 0.0001);

        expected = (double) -LONG_NUM / (-SHORT_NUM);
        assertEquals(expected, calc.calculate(-LONG_NUM, -SHORT_NUM, operation));
    }

    @Test
    public void getDiv_PositiveNegative_Ok() {
        char operation = '/';

        double expected = INT_NUM / (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, operation));

        expected = BYTE_NUM / (-FLOAT_NUM);
        assertEquals(expected, calc.calculate(BYTE_NUM, -FLOAT_NUM, operation), 0.0001);

        expected = (double) SHORT_NUM / (-LONG_NUM);
        assertEquals(expected, calc.calculate(SHORT_NUM, -LONG_NUM, operation));

        expected = CHAR1 / (-DOUBLE_NUM);
        assertEquals(expected, calc.calculate(CHAR1, -DOUBLE_NUM, operation));
    }

    @Test
    public void getDiv_ZeroDivision_Ok() {
        char operation = '/';

        double expected = 0;
        assertEquals(expected, calc.calculate(ZERO, INT_NUM, operation));

        expected = 0;
        assertEquals(expected, calc.calculate(ZERO, -FLOAT_NUM, operation), 0.0001);
    }

    @Test
    public void getDiv_ZeroDivision_NotOk() {
        char operation = '/';

        assertThrows(RuntimeException.class, () -> calc.calculate(INT_NUM, ZERO, operation));

        assertThrows(RuntimeException.class, () -> calc.calculate(-DOUBLE_NUM, -ZERO, operation));

        assertThrows(RuntimeException.class, () -> calc.calculate(ZERO, ZERO, operation));
    }

    @Test
    public void getDiv_MaxDouble_Ok() {
        char operation = '/';

        double expected = 0;
        assertEquals(expected, calc.calculate(INT_NUM, Double.MAX_VALUE, operation), 0.0001);

        expected = 1;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MAX_VALUE, operation));

        expected = -1;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, operation));

        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calc.calculate(Double.MAX_VALUE, Double.MIN_VALUE, operation));

        expected = 1;
        assertEquals(expected, calc.calculate(-Double.MAX_VALUE, -Double.MAX_VALUE, operation));
    }

    @Test
    public void getPow_PositivePow_Ok() {
        char operation = '^';

        double expected = Math.pow(INT_NUM, DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, operation));

        expected = Math.pow(FLOAT_NUM, BYTE_NUM);
        assertEquals(expected, calc.calculate(FLOAT_NUM, BYTE_NUM, operation));

        expected = Math.pow(-FLOAT_NUM, SHORT_NUM);
        assertEquals(expected, calc.calculate(-FLOAT_NUM, SHORT_NUM, operation));

        expected = Math.pow(CHAR1, CHAR2);
        assertEquals(expected, calc.calculate(CHAR1, CHAR2, operation));
    }

    @Test
    public void getPow_NegativePow_Ok() {
        char operation = '^';

        double expected = Math.pow(INT_NUM, -DOUBLE_NUM);
        assertEquals(expected, calc.calculate(INT_NUM, -DOUBLE_NUM, operation));

        expected = Math.pow(FLOAT_NUM, -BYTE_NUM);
        assertEquals(expected, calc.calculate(FLOAT_NUM, -BYTE_NUM, operation));

        expected = Math.pow(-FLOAT_NUM, -SHORT_NUM);
        assertEquals(expected, calc.calculate(-FLOAT_NUM, -SHORT_NUM, operation));
    }

    @Test
    public void getPow_ToZeroPow_Ok() {
        char operation = '^';

        double expected = Math.pow(INT_NUM, ZERO);
        assertEquals(expected, calc.calculate(INT_NUM, ZERO, operation));

        expected = Math.pow(FLOAT_NUM, -ZERO);
        assertEquals(expected, calc.calculate(FLOAT_NUM, -ZERO, operation));

        expected = Math.pow(-FLOAT_NUM, ZERO);
        assertEquals(expected, calc.calculate(-FLOAT_NUM, ZERO, operation));

        expected = Math.pow(CHAR1, -ZERO);
        assertEquals(expected, calc.calculate(CHAR1, -ZERO, operation));
    }

    @Test
    public void getPow_ZeroToPow_Ok() {
        char operation = '^';

        double expected = 0;
        assertEquals(expected, calc.calculate(ZERO, INT_NUM, operation));

        expected = 0;
        assertEquals(expected, calc.calculate(-ZERO, FLOAT_NUM, operation));
    }

    @Test
    public void getPow_ZeroToPow_NotOk() {
        char operation1 = '^';
        assertThrows(RuntimeException.class, () -> calc.calculate(ZERO, -FLOAT_NUM, operation1));

        char operation2 = '^';
        assertThrows(RuntimeException.class, () -> calc.calculate(-ZERO, -CHAR1, operation2));
    }

    @Test
    public void get_IllegalOperation_NotOk() {
        char operation1 = '!';
        assertThrows(RuntimeException.class, () -> calc.calculate(INT_NUM, BYTE_NUM, operation1));

        char operation2 = '@';
        assertThrows(RuntimeException.class, () -> calc.calculate(INT_NUM, BYTE_NUM, operation2));

        char operation3 = '#';
        assertThrows(RuntimeException.class, () -> calc.calculate(INT_NUM, BYTE_NUM, operation3));

        char operation4 = '4';
        assertThrows(RuntimeException.class, () -> calc.calculate(INT_NUM, BYTE_NUM, operation4));

        char operation5 = 43;
        double expected = INT_NUM + DOUBLE_NUM;
        assertEquals(expected, calc.calculate(INT_NUM, DOUBLE_NUM, operation5));
    }
}
