package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LambdaCalcTest {
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
    private static LambdaCalc testCalculator;

    @BeforeAll
    public static void beforeAll() {
        testCalculator = new LambdaCalc();
    }

    @Test
    public void checkAddition() {
        double actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, ADDITION);
        assertEquals(6, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ADDITION);
        assertEquals(-6, actual);
        actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, ADDITION);
        assertEquals(-2, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_POSITIVE_NUMBER, ADDITION);
        assertEquals(2, actual);
        actual = testCalculator.calculate(ZERO, FIRST_POSITIVE_NUMBER, ADDITION);
        assertEquals(FIRST_POSITIVE_NUMBER, actual);
        actual = testCalculator.calculate(ZERO, FIRST_NEGATIVE_NUMBER, ADDITION);
        assertEquals(FIRST_NEGATIVE_NUMBER, actual);
    }

    @Test
    public void checkSubtraction() {
        double actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(-2, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(2, actual);
        actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(6, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(-6, actual);
        actual = testCalculator.calculate(ZERO, FIRST_POSITIVE_NUMBER, SUBTRACTION);
        assertEquals((-1) * FIRST_POSITIVE_NUMBER, actual);
        actual = testCalculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, SUBTRACTION);
        assertEquals(FIRST_POSITIVE_NUMBER, actual);
    }

    @Test
    public void checkEdgeValues() {
        double expected = Integer.MIN_VALUE + SECOND_POSITIVE_NUMBER - 1;
        double actual = testCalculator
                .calculate(Integer.MAX_VALUE, SECOND_POSITIVE_NUMBER, ADDITION);
        assertEquals(expected, actual);
        expected = Integer.MAX_VALUE + SECOND_NEGATIVE_NUMBER + 1;
        actual = testCalculator
                .calculate(Integer.MIN_VALUE, SECOND_NEGATIVE_NUMBER, ADDITION);
        assertEquals(expected, actual);
        expected = Integer.MAX_VALUE - SECOND_POSITIVE_NUMBER + 1;
        actual = testCalculator
                .calculate(Integer.MIN_VALUE, SECOND_POSITIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
        expected = Integer.MIN_VALUE - SECOND_NEGATIVE_NUMBER - 1;
        actual = testCalculator
                .calculate(Integer.MAX_VALUE, SECOND_NEGATIVE_NUMBER, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void edgeValuesExceptions() {
        assertThrows(RuntimeException.class, () -> testCalculator
                .calculate(Integer.MAX_VALUE, SECOND_POSITIVE_NUMBER, MULTIPLICATION));
        assertThrows(RuntimeException.class, () -> testCalculator
                .calculate(Integer.MIN_VALUE, SECOND_POSITIVE_NUMBER, MULTIPLICATION));
        assertThrows(RuntimeException.class, () -> testCalculator
                .calculate(Integer.MAX_VALUE, SECOND_NEGATIVE_NUMBER, MULTIPLICATION));
        assertThrows(RuntimeException.class, () -> testCalculator
                .calculate(Integer.MIN_VALUE, SECOND_NEGATIVE_NUMBER, MULTIPLICATION));
    }

    @Test
    public void checkMultiplication() {
        double actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(8, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(8, actual);
        actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(-8, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(-8, actual);
        actual = testCalculator.calculate(ZERO, FIRST_POSITIVE_NUMBER, MULTIPLICATION);
        assertEquals(0, actual);
        actual = testCalculator.calculate(ZERO, FIRST_NEGATIVE_NUMBER, MULTIPLICATION);
        assertEquals(0, actual);
    }

    @Test
    public void checkDivision() {
        double actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, DIVISION);
        assertEquals(0.5, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, DIVISION);
        assertEquals(0.5, actual);
        actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, DIVISION);
        assertEquals(-0.5, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_POSITIVE_NUMBER, DIVISION);
        assertEquals(-0.5, actual);
        actual = testCalculator.calculate(ZERO, FIRST_POSITIVE_NUMBER, DIVISION);
        assertEquals(0, actual);
        actual = testCalculator.calculate(ZERO, FIRST_NEGATIVE_NUMBER, DIVISION);
        assertEquals(0, actual);
    }

    @Test
    public void checkDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                testCalculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, DIVISION));
    }

    @Test
    public void checkPower() {
        double actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, POWER);
        assertEquals(16, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_NEGATIVE_NUMBER, POWER);
        assertEquals(0.0625, actual);
        actual = testCalculator
                .calculate(FIRST_POSITIVE_NUMBER, SECOND_NEGATIVE_NUMBER, POWER);
        assertEquals(0.0625, actual);
        actual = testCalculator
                .calculate(FIRST_NEGATIVE_NUMBER, SECOND_POSITIVE_NUMBER, POWER);
        assertEquals(16, actual);
        actual = testCalculator.calculate(FIRST_NEGATIVE_NUMBER, ODD_NUMBER, POWER);
        assertEquals(-8, actual);
    }

    @Test
    public void checkZeroBasePower() {
        assertEquals(0, testCalculator.calculate(ZERO, FIRST_POSITIVE_NUMBER, POWER));
    }

    @Test
    public void checkRaisingToZeroPower() {
        assertEquals(1, testCalculator.calculate(FIRST_POSITIVE_NUMBER, ZERO, POWER));
    }

    @Test
    public void checkNotValidOperation() {
        assertThrows(RuntimeException.class, () ->
                testCalculator.calculate(FIRST_POSITIVE_NUMBER, SECOND_POSITIVE_NUMBER, '$'));
    }
}
