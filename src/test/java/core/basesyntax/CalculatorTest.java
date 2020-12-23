package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final double FIRST_VARIABLE = 10;
    private static final double SECOND_VARIABLE = 5;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void additionWithNegativeValues_Ok() {
        double expectedResult = -15;
        double actualResult = calculator.calculate(-FIRST_VARIABLE, -SECOND_VARIABLE, '+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void additionWithPositiveAndNegativeValues_Ok() {
        double expectedResult = -5;
        double actualResult = calculator.calculate(-FIRST_VARIABLE, SECOND_VARIABLE, '+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void additionWithZero_Ok() {
        double expectedResult = 5;
        double actualResult = calculator.calculate(0, SECOND_VARIABLE, '+');
        assertEquals(expectedResult, actualResult);
        expectedResult = 10;
        actualResult = calculator.calculate(FIRST_VARIABLE, 0, '+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void additionWithMaxValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(FIRST_VARIABLE, Double.MAX_VALUE, '+'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MAX_VALUE, SECOND_VARIABLE, '+'));
    }

    @Test
    public void subtractionWithMinValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(FIRST_VARIABLE, Double.MIN_VALUE, '-'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MIN_VALUE, SECOND_VARIABLE, '-'));
    }

    @Test
    public void divisionWithMinValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(FIRST_VARIABLE, Double.MIN_VALUE, '/'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MIN_VALUE, SECOND_VARIABLE, '/'));
    }

    @Test
    public void multiplyWithMaxValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(FIRST_VARIABLE, Double.MAX_VALUE, '*'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MAX_VALUE, SECOND_VARIABLE, '*'));
    }

    @Test
    public void raisingToAPowerWithMaxValue_NotOk() {
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(FIRST_VARIABLE, Double.MAX_VALUE, '^'));
        assertThrows(ValueOutOfBoundException.class, ()
                -> calculator.calculate(Double.MAX_VALUE, SECOND_VARIABLE, '^'));
    }

    @Test
    public void raisingZeroToAPower_Ok() {
        double expectedResult = 1;
        double actualResult = calculator.calculate(FIRST_VARIABLE, 0, '^');
        assertEquals(expectedResult, actualResult);
        expectedResult = 0;
        actualResult = calculator.calculate(0, SECOND_VARIABLE, '^');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void raisingToAPowerWithNegativeValues_NotOk() {
        double expectedResult = -100000.0;
        double actualResult = calculator.calculate(-FIRST_VARIABLE, SECOND_VARIABLE, '^');
        assertEquals(expectedResult, actualResult);
        expectedResult = 1.0E-5;
        actualResult = calculator.calculate(FIRST_VARIABLE, -SECOND_VARIABLE, '^');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void correctAddition_Ok() {
        double expectedResult = 15;
        double actualResult = calculator.calculate(FIRST_VARIABLE, SECOND_VARIABLE, '+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void correctSubtraction_Ok() {
        double expectedResult = 5;
        double actualResult = calculator.calculate(FIRST_VARIABLE, SECOND_VARIABLE, '-');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void correctDivision_Ok() {
        double expectedResult = 2;
        double actualResult = calculator.calculate(FIRST_VARIABLE, SECOND_VARIABLE, '/');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void correctMultiplication_Ok() {
        double expectedResult = 50;
        double actualResult = calculator.calculate(FIRST_VARIABLE, SECOND_VARIABLE, '*');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void correctRaisingToAPower_Ok() {
        double expectedResult = 100000;
        double actualResult = calculator.calculate(FIRST_VARIABLE, SECOND_VARIABLE, '^');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void correctOperation_NotOk() {
        assertThrows(NotValidOperationException.class, ()
                -> calculator.calculate(FIRST_VARIABLE, SECOND_VARIABLE, 'd'));
    }

    @Test
    public void zeroDivision_NotOk() {
        assertThrows(ArithmeticException.class, () ->
            calculator.calculate(FIRST_VARIABLE, 0, '/'));
    }
}
