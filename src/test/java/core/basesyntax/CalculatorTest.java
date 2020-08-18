package core.basesyntax;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static final String ADD = "25 + 30";
    private static final double ADD_RESULT = 55.0;
    private static final String DIV = "60 / 30";
    private static final double DIV_RESULT = 2.0;
    private static final String MULT = "25 * 30";
    private static final double MULT_RESULT = 750.0;
    private static final String POW = "2 ^ 7";
    private static final double POW_RESULT = 128.0;
    private static final String SUBTR = "33 - 8";
    private static final double SUBTR_RESULT = 25.0;
    private static final String DIVISION_BY_ZERO = "25 / 0";
    private static final String STRING_WITHOUT_ARITHMETIC_CHARS = "25_.0";
    private static final String STRING_WITH_MORE_THAN_TWO_NUMBERS = "25 + 30 + 45";
    private static final double DELTA = 0.000_001d;
    private Calculator calculator;

    @Before
    public void init(){
        calculator = new Calculator();
    }
    @Test
    public void isWeCallTheRightClass() {
        assertNull(calculator.getArithmeticOperation());
        calculator.calculate(ADD);
        assertSame(calculator.getArithmeticOperation().getClass(), AddOperation.class);
        calculator.calculate(DIV);
        assertSame(calculator.getArithmeticOperation().getClass(), DivOperation.class);
        calculator.calculate(MULT);
        assertSame(calculator.getArithmeticOperation().getClass(), MultOperation.class);
        calculator.calculate(SUBTR);
        assertSame(calculator.getArithmeticOperation().getClass(), SubtrOperation.class);
        calculator.calculate(POW);
        assertSame(calculator.getArithmeticOperation().getClass(), PowOperation.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPassedArgumentWithWrongParameters() {
            calculator.calculate(STRING_WITHOUT_ARITHMETIC_CHARS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void passEmptyStringToCalculateMethod() {
            calculator.calculate("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void passNullValueToCalculateMethod() {
            calculator.calculate(null);
    }

    @Test(expected = ArithmeticException.class)
    public void checkDivisionByZero() {
            calculator.calculate(DIVISION_BY_ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPassedArgumentWithMoreThanTwoNumbers() {
            calculator.calculate(STRING_WITH_MORE_THAN_TWO_NUMBERS);
    }

    @Test
    public void isCorrectArithmeticOperations() {
        assertEquals(ADD_RESULT, calculator.calculate(ADD), DELTA);
        assertEquals(DIV_RESULT, calculator.calculate(DIV), DELTA);
        assertEquals(MULT_RESULT, calculator.calculate(MULT), DELTA);
        assertEquals(SUBTR_RESULT, calculator.calculate(SUBTR), DELTA);
        assertEquals(POW_RESULT, calculator.calculate(POW), DELTA);
    }
}