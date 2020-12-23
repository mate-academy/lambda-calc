package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator = new Calculator();
    private static double firstVariable = 10;
    private static double secondVariable = 5;

    @Test
    void correctAddition_Ok() {
        double expectedResult = 15;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'+');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctSubtraction_Ok() {
        double expectedResult = 5;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'-');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctDivision_Ok() {
        double expectedResult = 2;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'/');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctMultiplication_Ok() {
        double expectedResult = 50;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'*');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctRaisingToAPower_Ok() {
        double expectedResult = 100000;
        double actualResult = calculator.calculate(firstVariable, secondVariable,'^');
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void correctOperation_NotOk() {
        assertThrows(NotValidOperationException.class, ()
                -> calculator.calculate(firstVariable, secondVariable,'d'));
    }

    @Test
    void zeroDivision_NotOk() {
        assertThrows(ArithmeticException.class, () ->
            calculator.calculate(firstVariable, 0,'/'));
    }
}
