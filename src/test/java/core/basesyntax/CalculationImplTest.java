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
    private int firstValue;
    private int secondValue;

    @BeforeAll
    public static void setDefaultValue() {
        calculation = new CalculationImpl();
    }

    @Test
    public void calculate_PositiveAndZeroValue_notOk() {
        firstValue = 0;
        secondValue = 5;
        expectedSum = 5;
        expectedSubtraction = -5;
        expectedDivision = 0;
        expectedMultiplication = 0;
        expectedPow = 0;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_divideByZero_notOk() {
        firstValue = 5;
        secondValue = 0;
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculation.calculate(firstValue, secondValue, '/'));
    }

    @Test
    public void calculate_maxIntegerValue_NotOk() {
        firstValue = Integer.MAX_VALUE;
        secondValue = Integer.MAX_VALUE;
        expectedSum = (double) Integer.MAX_VALUE + Integer.MAX_VALUE;
        expectedSubtraction = 0;
        expectedDivision = 1;
        expectedMultiplication = (double) Integer.MAX_VALUE * Integer.MAX_VALUE;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_incorrectSymbol_notOk() {
        Assertions.assertThrows(RuntimeException.class,
                () -> calculation.calculate(4, 5, ' '));
    }

    @Test
    public void calculate_correctValue_ok() {
        firstValue = 10;
        secondValue = 2;
        expectedSum = 12;
        expectedSubtraction = 8;
        expectedDivision = 5;
        expectedMultiplication = 20;
        expectedPow = 100;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_negativeAndPositiveValue_ok() {
        firstValue = 10;
        secondValue = -2;
        expectedSum = 8;
        expectedSubtraction = 12;
        expectedDivision = -5;
        expectedMultiplication = -20;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_twoNegativeValue_ok() {
        firstValue = -3;
        secondValue = -2;
        expectedSum = -5;
        expectedSubtraction = -1;
        expectedDivision = 1.5;
        expectedMultiplication = 6;
        checkCalculate(firstValue, secondValue);
    }

    @Test
    public void calculate_minIntegerValue_ok() {
        firstValue = Integer.MIN_VALUE;
        secondValue = Integer.MIN_VALUE;
        expectedSum = (double) Integer.MIN_VALUE + Integer.MIN_VALUE;
        expectedSubtraction = 0;
        expectedDivision = 1;
        expectedMultiplication = (double) Integer.MIN_VALUE * Integer.MIN_VALUE;
        expectedPow = Math.pow(Integer.MIN_VALUE, Integer.MIN_VALUE);
        checkCalculate(firstValue, secondValue);
    }

    public void checkCalculate(int firstValue, int secondValue) {
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
