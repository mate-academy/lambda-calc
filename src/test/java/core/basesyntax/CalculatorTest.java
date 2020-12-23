package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int MINUS_ONE = -1;
    private static final int MINUS_TWO = -2;
    private static final int MINUS_FIVE = -5;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void additionTest_OK() {
        double positiveNumbers = calculator.calculation(ONE, TWO, '+');
        double negativeNumbers = calculator.calculation(MINUS_FIVE, MINUS_TWO, '+');
        assertEquals(3, positiveNumbers);
        assertEquals(-7, negativeNumbers);
        double differentNumbers = calculator.calculation(ONE, MINUS_FIVE, '+');
        double zeroNumberFirst = calculator.calculation(ZERO, THREE, '+');
        double zeroNumberSecond = calculator.calculation(MINUS_FIVE, ZERO, '+');
        assertEquals(-4, differentNumbers);
        assertEquals(3, zeroNumberFirst);
        assertEquals(-5, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, ONE, '+');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '+');
        assertEquals(Integer.MIN_VALUE, maxValueFirst);
        assertEquals(-2, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, ONE, '+');
        double minValueSecond = calculator.calculation(MINUS_FIVE,
                Integer.MIN_VALUE, '+');
        assertEquals(-2147483647, minValueFirst);
        assertEquals(2147483643, minValueSecond);
    }

    @Test
    public void subtractionTest_OK() {
        double positiveNumbers = calculator.calculation(ONE, TWO, '-');
        double negativeNumbers = calculator.calculation(MINUS_FIVE, MINUS_TWO, '-');
        assertEquals(-1, positiveNumbers);
        assertEquals(-3, negativeNumbers);
        double differentNumbers = calculator.calculation(ONE, MINUS_FIVE, '-');
        double zeroNumberFirst = calculator.calculation(ZERO, THREE, '-');
        double zeroNumberSecond = calculator.calculation(MINUS_FIVE, ZERO, '-');
        assertEquals(6, differentNumbers);
        assertEquals(-3, zeroNumberFirst);
        assertEquals(-5, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, ONE, '-');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '-');
        assertEquals(2147483646, maxValueFirst);
        assertEquals(0, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, ONE, '-');
        double minValueSecond = calculator.calculation(MINUS_FIVE,
                Integer.MIN_VALUE, '-');
        assertEquals(Integer.MAX_VALUE, minValueFirst);
        assertEquals(2147483643, minValueSecond);
    }

    @Test
    public void multiplicationTest_OK() {
        double positiveNumbers = calculator.calculation(ONE, TWO, '*');
        double negativeNumbers = calculator.calculation(MINUS_FIVE, MINUS_TWO, '*');
        assertEquals(2, positiveNumbers);
        assertEquals(10, negativeNumbers);
        double differentNumbers = calculator.calculation(ONE, MINUS_FIVE, '*');
        double zeroNumberFirst = calculator.calculation(ZERO, THREE, '*');
        double zeroNumberSecond = calculator.calculation(MINUS_FIVE, ZERO, '*');
        assertEquals(-5, differentNumbers);
        assertEquals(0, zeroNumberFirst);
        assertEquals(0, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, TWO, '*');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '*');
        assertEquals(-2, maxValueFirst);
        assertEquals(1, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, THREE, '*');
        double minValueSecond = calculator.calculation(MINUS_FIVE,
                Integer.MIN_VALUE, '*');
        assertEquals(-2147483648, minValueFirst);
        assertEquals(-2147483648, minValueSecond);
    }

    @Test
    public void divisionTest_OK() {
        double positiveNumbers = calculator.calculation(ONE, TWO, '/');
        double negativeNumbers = calculator.calculation(MINUS_FIVE, MINUS_TWO, '/');
        assertEquals(0.5, positiveNumbers);
        assertEquals(2.5, negativeNumbers);
        double differentNumbers = calculator.calculation(ONE, MINUS_FIVE, '/');
        double zeroNumberFirst = calculator.calculation(ZERO, THREE, '/');
        assertEquals(-0.2, differentNumbers);
        assertEquals(0, zeroNumberFirst);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, ONE, '/');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '/');
        assertEquals(Integer.MAX_VALUE, maxValueFirst);
        assertEquals(1, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, ONE, '/');
        double minValueSecond = calculator.calculation(Integer.MIN_VALUE,
                Integer.MIN_VALUE, '/');
        assertEquals(Integer.MIN_VALUE, minValueFirst);
        assertEquals(1, minValueSecond);
    }

    @Test
    public void powerTest_OK() {
        double positiveNumbers = calculator.calculation(ONE, TWO, '^');
        double negativeNumbers = calculator.calculation(MINUS_FIVE, MINUS_TWO, '^');
        assertEquals(1, positiveNumbers);
        assertEquals(0.04, negativeNumbers);
        double differentNumbers = calculator.calculation(ONE, MINUS_FIVE, '^');
        double zeroNumberFirst = calculator.calculation(ZERO, THREE, '^');
        double zeroNumberSecond = calculator.calculation(MINUS_FIVE, ZERO, '^');
        assertEquals(1, differentNumbers);
        assertEquals(0, zeroNumberFirst);
        assertEquals(1, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, ONE, '^');
        double maxValueSecond = calculator.calculation(ONE,
                Integer.MAX_VALUE, '^');
        assertEquals(Integer.MAX_VALUE, maxValueFirst);
        assertEquals(1, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, TWO, '^');
        double minValueSecond = calculator.calculation(MINUS_FIVE,
                Integer.MIN_VALUE, '^');
        assertEquals(4.6116860184273879E18, minValueFirst);
        assertEquals(0, minValueSecond);
    }

    @Test
    public void divisionByZeroInDivision() {
        assertThrows(DivisionByZeroException.class, ()
                -> calculator.calculation(ONE, ZERO, '/'));
    }

    @Test
    public void wrongOperatorTest() {
        assertThrows(UnexpectedOperatorException.class, ()
                -> calculator.calculation(ONE, TWO, 'a'));
    }
}
