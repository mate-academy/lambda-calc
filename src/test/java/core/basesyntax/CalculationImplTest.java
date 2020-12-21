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
    public void calculate_divisionByZero_notOk() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculation.calculate(4, 0, '/'));
    }

    @Test
    public void calculate_maxIntegerValue_ok() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        Assertions.assertEquals((double) a + b, calculation.calculate(a, b, '+'));
        Assertions.assertEquals(a - b, calculation.calculate(a, b, '-'));
        Assertions.assertEquals(a / b, calculation.calculate(a, b, '/'));
        Assertions.assertEquals((double) a * b, calculation.calculate(a, b, '*'));
        Assertions.assertEquals(Math.pow(a, b), calculation.calculate(a, b, '^'));
    }

    @Test
    public void calculate_incorrectSymbol_notOk() {
        Assertions.assertThrows(RuntimeException.class, () -> calculation.calculate(4, 5, ' '));
    }

    @Test
    public void calculate_correctValue_ok() {
        int a = 10;
        int b = 2;
        double actualAddition = a + b;
        double actualSubtraction = a - b;
        double actualDivision = a / b;
        double actualMultiplication = a * b;
        double raisingToPower = Math.pow(a, b);
        Assertions.assertEquals(actualAddition, calculation.calculate(a, b, '+'));
        Assertions.assertEquals(actualSubtraction, calculation.calculate(a, b, '-'));
        Assertions.assertEquals(actualDivision, calculation.calculate(a, b, '/'));
        Assertions.assertEquals(actualMultiplication, calculation.calculate(a, b, '*'));
        Assertions.assertEquals(raisingToPower, calculation.calculate(a, b, '^'));
    }

}
