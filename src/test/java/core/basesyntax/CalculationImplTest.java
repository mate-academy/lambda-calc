package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculationImplTest {

    private static CalculationImpl calculation;
    private double expectedDivision;
    private double expectedSum;
    private double expectedSubtraction;
    private double expectedMultiplication;
    private double expectedPow;

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
    public void calculate_maxIntegerValue_NotOk() {
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
        expectedSum = (double) firstValue + secondValue;
        expectedSubtraction = firstValue - secondValue;
        expectedDivision = (double) firstValue / secondValue;
        expectedMultiplication = (double) firstValue * secondValue;
        expectedPow = Math.pow(firstValue, secondValue);
        System.out.println(expectedPow);
        Assertions.assertEquals(expectedSum,
                calculation.calculate(firstValue, secondValue, '+'));
        Assertions.assertEquals(expectedSubtraction,
                calculation.calculate(firstValue, secondValue, '-'));
        Assertions.assertEquals(expectedDivision,
                calculation.calculate(firstValue, secondValue, '/'));
        Assertions.assertEquals(expectedMultiplication,
                calculation.calculate(firstValue, secondValue, '*'));
        if (secondValue < 0 || secondValue == Integer.MAX_VALUE) {
            Assertions.assertThrows(ArithmeticException.class,
                    () -> calculation.calculate(firstValue, secondValue, '^'));
        } else {
            Assertions.assertEquals(expectedPow,
                    calculation.calculate(firstValue, secondValue, '^'));
        }
    }

}
