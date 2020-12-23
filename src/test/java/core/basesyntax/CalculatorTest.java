package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator = new Calculator();
    private final int int0 = 0;
    private final int int1 = 3;
    private final int int2 = 4;
    private final int int3 = -5;
    private final int int4 = -7;
    private final int int5 = -2;
    private final int int6 = 1;

    @Test
    public void additionTest_OK() {
        double positiveNumbers = calculator.calculation(int1, int2, '+');
        double negativeNumbers = calculator.calculation(int3, int4, '+');
        assertEquals(7, positiveNumbers);
        assertEquals(-12, negativeNumbers);
        double differentNumbers = calculator.calculation(int1, int4, '+');
        double zeroNumber = calculator.calculation(int0, int3, '+');
        assertEquals(-4, differentNumbers);
        assertEquals(-5, zeroNumber);
        double maxValue1 = calculator.calculation(Integer.MAX_VALUE, int6, '+');
        double maxValue2 = calculator.calculation(Integer.MAX_VALUE,
                Integer.MAX_VALUE, '+');
        assertEquals(Integer.MIN_VALUE, maxValue1);
        assertEquals(-2, maxValue2);
    }

    @Test
    public void subtractionTest_OK() {
        double positiveNumbers = calculator.calculation(int1, int2, '-');
        double negativeNumbers = calculator.calculation(int3, int4, '-');
        assertEquals(-1, positiveNumbers);
        assertEquals(2, negativeNumbers);
        double differentNumbers = calculator.calculation(int1, int4, '-');
        double zeroNumber = calculator.calculation(int0, int3, '-');
        assertEquals(10, differentNumbers);
        assertEquals(5, zeroNumber);
    }

    @Test
    public void multiplicationTest_OK() {
        double positiveNumbers = calculator.calculation(int1, int2, '*');
        double negativeNumbers = calculator.calculation(int3, int4, '*');
        assertEquals(12, positiveNumbers);
        assertEquals(35, negativeNumbers);
        double differentNumbers = calculator.calculation(int1, int4, '*');
        double zeroNumber = calculator.calculation(int0, int3, '*');
        assertEquals(-21, differentNumbers);
        assertEquals(0, zeroNumber);
    }

    @Test
    public void divisionTest_OK() {
        double positiveNumbers = calculator.calculation(int1, int2, '/');
        double negativeNumbers = calculator.calculation(int4, int3, '/');
        assertEquals(0.75, positiveNumbers);
        assertEquals(1.4, negativeNumbers);
        double differentNumbers = calculator.calculation(int3, int2, '/');
        double zeroNumber = calculator.calculation(int0, int3, '/');
        assertEquals(-1.25, differentNumbers);
        assertEquals(0, zeroNumber);
    }

    @Test
    public void powerTest_OK() {
        double positiveNumbers = calculator.calculation(int1, int2, '^');
        double negativeNumbers = calculator.calculation(int3, int5, '^');
        assertEquals(81, positiveNumbers);
        assertEquals(0.04, negativeNumbers);
        double differentNumbers = calculator.calculation(int3, int2, '^');
        double zeroNumber = calculator.calculation(int0, int1, '^');
        assertEquals(625, differentNumbers);
        assertEquals(0, zeroNumber);
    }

    @Test
    public void divisionByZeroInDivision() {
        assertThrows(DivisionByZeroException.class, ()
                -> calculator.calculation(int1, int0, '/'));
    }

    @Test
    public void wrongOperatorTest() {
        assertThrows(UnexpectedOperatorException.class, ()
                -> calculator.calculation(int0, int3, 'a'));
    }
}
