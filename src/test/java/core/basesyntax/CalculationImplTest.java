package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculationImplTest {

    private static CalculationImpl calculation;

    @BeforeAll
    public static void setDefaultValue() {
        calculation = new CalculationImpl();
    }

    @Test
    public void calculate_PositiveAndZeroValue_notOk() {
        int firstValue = 0;
        int secondValue = 5;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_divideByZero_notOk() {
        int firstValue = 5;
        int secondValue = 0;
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculation.calculate(firstValue, secondValue, '/'));
    }

    @Test
    public void calculate_maxIntegerValue_ok() {
        int firstValue = Integer.MAX_VALUE;
        int secondValue = Integer.MAX_VALUE;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_incorrectSymbol_notOk() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculation.calculate(4, 5, ' '));
    }

    @Test
    public void calculate_correctValue_ok() {
        int firstValue = 10;
        int secondValue = 2;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_negativeAndPositiveValue_ok() {
        int firstValue = 10;
        int secondValue = -2;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_twoNegativeValue_ok() {
        int firstValue = -3;
        int secondValue = -2;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_minIntegerValue_ok() {
        int firstValue = Integer.MIN_VALUE;
        int secondValue = Integer.MIN_VALUE;
        checkCalculate(firstValue, secondValue);
    }

    public void checkCalculate(int firstValue, int secondValue) {
        Assertions.assertEquals((double) firstValue + secondValue,
                calculation.calculate(firstValue, secondValue, '+'));
        Assertions.assertEquals(firstValue - secondValue,
                calculation.calculate(firstValue, secondValue, '-'));
        Assertions.assertEquals((double) firstValue / secondValue,
                calculation.calculate(firstValue, secondValue, '/'));
        Assertions.assertEquals((double) firstValue * secondValue,
                calculation.calculate(firstValue, secondValue, '*'));
        Assertions.assertEquals(Math.pow(firstValue, secondValue),
                calculation.calculate(firstValue, secondValue, '^'));
    }

}
