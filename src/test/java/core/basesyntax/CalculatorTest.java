package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static final int zero = 0;
    private static final int one = 1;
    private static final int two = 2;
    private static final int three = 3;
    private static final int minusOne = -1;
    private static final int minusTwo = -2;
    private static final int minusFive = -5;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void additionTest_OK() {
        double positiveNumbers = calculator.calculation(one, two, '+');
        double negativeNumbers = calculator.calculation(minusFive, minusTwo, '+');
        assertEquals(3, positiveNumbers);
        assertEquals(-7, negativeNumbers);
        double differentNumbers = calculator.calculation(one, minusFive, '+');
        double zeroNumberFirst = calculator.calculation(zero, three, '+');
        double zeroNumberSecond = calculator.calculation(minusFive, zero, '+');
        assertEquals(-4, differentNumbers);
        assertEquals(3, zeroNumberFirst);
        assertEquals(-5, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, one, '+');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '+');
        assertEquals(Integer.MIN_VALUE, maxValueFirst);
        assertEquals(-2, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, one, '+');
        double minValueSecond = calculator.calculation(minusFive,
                Integer.MIN_VALUE, '+');
        assertEquals(-2147483647, minValueFirst);
        assertEquals(2147483643, minValueSecond);
    }

    @Test
    public void subtractionTest_OK() {
        double positiveNumbers = calculator.calculation(one, two, '-');
        double negativeNumbers = calculator.calculation(minusFive, minusTwo, '-');
        assertEquals(-1, positiveNumbers);
        assertEquals(-3, negativeNumbers);
        double differentNumbers = calculator.calculation(one, minusFive, '-');
        double zeroNumberFirst = calculator.calculation(zero, three, '-');
        double zeroNumberSecond = calculator.calculation(minusFive, zero, '-');
        assertEquals(6, differentNumbers);
        assertEquals(-3, zeroNumberFirst);
        assertEquals(-5, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, one, '-');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '-');
        assertEquals(2147483646, maxValueFirst);
        assertEquals(0, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, one, '-');
        double minValueSecond = calculator.calculation(minusFive,
                Integer.MIN_VALUE, '-');
        assertEquals(Integer.MAX_VALUE, minValueFirst);
        assertEquals(2147483643, minValueSecond);
    }

    @Test
    public void multiplicationTest_OK() {
        double positiveNumbers = calculator.calculation(one, two, '*');
        double negativeNumbers = calculator.calculation(minusFive, minusTwo, '*');
        assertEquals(2, positiveNumbers);
        assertEquals(10, negativeNumbers);
        double differentNumbers = calculator.calculation(one, minusFive, '*');
        double zeroNumberFirst = calculator.calculation(zero, three, '*');
        double zeroNumberSecond = calculator.calculation(minusFive, zero, '*');
        assertEquals(-5, differentNumbers);
        assertEquals(0, zeroNumberFirst);
        assertEquals(0, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, two, '*');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '*');
        assertEquals(-2, maxValueFirst);
        assertEquals(1, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, three, '*');
        double minValueSecond = calculator.calculation(minusFive,
                Integer.MIN_VALUE, '*');
        assertEquals(-2147483648, minValueFirst);
        assertEquals(-2147483648, minValueSecond);
    }

    @Test
    public void divisionTest_OK() {
        double positiveNumbers = calculator.calculation(one, two, '/');
        double negativeNumbers = calculator.calculation(minusFive, minusTwo, '/');
        assertEquals(0.5, positiveNumbers);
        assertEquals(2.5, negativeNumbers);
        double differentNumbers = calculator.calculation(one, minusFive, '/');
        double zeroNumberFirst = calculator.calculation(zero, three, '/');
        assertEquals(-0.2, differentNumbers);
        assertEquals(0, zeroNumberFirst);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, one, '/');
        double maxValueSecond = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '/');
        assertEquals(Integer.MAX_VALUE, maxValueFirst);
        assertEquals(1, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, one, '/');
        double minValueSecond = calculator.calculation(Integer.MIN_VALUE,
                Integer.MIN_VALUE, '/');
        assertEquals(Integer.MIN_VALUE, minValueFirst);
        assertEquals(1, minValueSecond);
    }

    @Test
    public void powerTest_OK() {
        double positiveNumbers = calculator.calculation(one, two, '^');
        double negativeNumbers = calculator.calculation(minusFive, minusTwo, '^');
        assertEquals(1, positiveNumbers);
        assertEquals(0.04, negativeNumbers);
        double differentNumbers = calculator.calculation(one, minusFive, '^');
        double zeroNumberFirst = calculator.calculation(zero, three, '^');
        double zeroNumberSecond = calculator.calculation(minusFive, zero, '^');
        assertEquals(1, differentNumbers);
        assertEquals(0, zeroNumberFirst);
        assertEquals(1, zeroNumberSecond);
        double maxValueFirst = calculator.calculation(Integer.MAX_VALUE, one, '^');
        double maxValueSecond = calculator.calculation(one,
                Integer.MAX_VALUE, '^');
        assertEquals(Integer.MAX_VALUE, maxValueFirst);
        assertEquals(1, maxValueSecond);
        double minValueFirst = calculator.calculation(Integer.MIN_VALUE, two, '^');
        double minValueSecond = calculator.calculation(minusFive,
                Integer.MIN_VALUE, '^');
        assertEquals(4.6116860184273879E18, minValueFirst);
        assertEquals(0, minValueSecond);
    }

    @Test
    public void divisionByZeroInDivision() {
        assertThrows(DivisionByZeroException.class, ()
                -> calculator.calculation(one, zero, '/'));
    }

    @Test
    public void wrongOperatorTest() {
        assertThrows(UnexpectedOperatorException.class, ()
                -> calculator.calculation(one, two, 'a'));
    }
}
