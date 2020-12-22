package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LambdaCalcTest {
    private static final int FIRST_POSITIVE_NUMBER = 2;
    private static final int SECOND_POSITIVE_NUMBER = 4;
    private static final int FIRST_NEGATIVE_NUMBER = -2;
    private static final int SECOND_NEGATIVE_NUMBER = -4;
    private static final int ODD_NUMBER = 3;
    private static final int ZERO = 0;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    @Test
    void checkAddition() {
        double actual = LambdaCalc
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, ADDITION);
        assertEquals(6, actual);
        actual = LambdaCalc
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ADDITION);
        assertEquals(-6, actual);
    }

    @Test
    void checkSubtraction() {
        double actual = LambdaCalc
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(-2, actual);
        actual = LambdaCalc
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(2, actual);
    }

    @Test
    void checkEdgeValues() {
        double expected = Integer.MIN_VALUE + SECOND_POSITIVE_NUMBER - 1;
        double actual = LambdaCalc.calculate(Integer.MAX_VALUE, SECOND_POSITIVE_NUMBER, ADDITION);
        assertEquals(expected, actual);
        expected = Integer.MAX_VALUE + SECOND_NEGATIVE_NUMBER + 1;
        actual = LambdaCalc.calculate(Integer.MIN_VALUE, SECOND_NEGATIVE_NUMBER, ADDITION);
        assertEquals(expected, actual);
        expected = Integer.MAX_VALUE - SECOND_POSITIVE_NUMBER + 1;
        actual = LambdaCalc.calculate(Integer.MIN_VALUE, SECOND_POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
        expected = Integer.MIN_VALUE - SECOND_NEGATIVE_NUMBER - 1;
        actual = LambdaCalc.calculate(Integer.MAX_VALUE, SECOND_NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    void edgeValuesExceptions() {
        assertThrows(RuntimeException.class, () ->
                LambdaCalc.calculate(Integer.MAX_VALUE, SECOND_POSITIVE_NUMBER, MULTIPLICATION));
        assertThrows(RuntimeException.class, () ->
                LambdaCalc.calculate(Integer.MIN_VALUE, SECOND_POSITIVE_NUMBER, MULTIPLICATION));
        assertThrows(RuntimeException.class, () ->
                LambdaCalc.calculate(Integer.MAX_VALUE, SECOND_NEGATIVE_NUMBER, MULTIPLICATION));
        assertThrows(RuntimeException.class, () ->
                LambdaCalc.calculate(Integer.MIN_VALUE, SECOND_NEGATIVE_NUMBER, MULTIPLICATION));
    }

    @Test
    void checkMultiplication() {
        double actual = LambdaCalc
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(8, actual);
        actual = LambdaCalc
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(8, actual);
    }

    @Test
    void checkDivision() {
        double actual = LambdaCalc
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, DIVISION);
        assertEquals(0.5, actual);
        actual = LambdaCalc
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, DIVISION);
        assertEquals(0.5, actual);
    }

    @Test
    void checkDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                LambdaCalc.calculate(FIRST_POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    void checkPower() {
        double actual = LambdaCalc
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, POWER);
        assertEquals(16, actual);
        actual = LambdaCalc
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, POWER);
        assertEquals(0.0625, actual);
    }

    @Test
    void checkNotValidOperation() {
        assertThrows(RuntimeException.class, () ->
                LambdaCalc.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, '$'));
    }
}
