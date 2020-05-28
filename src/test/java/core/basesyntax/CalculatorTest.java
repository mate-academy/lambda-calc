package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.math.BigDecimal;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test
    public void checkAddition() {
        BigDecimal additionResult
                = calculator.calculate(BigDecimal.valueOf(5.2), BigDecimal.valueOf(3.5), '+');
        Assert.assertEquals("8.7 was expected",
                BigDecimal.valueOf(8.7), additionResult);
    }

    @Test
    public void checkSubtraction() {
        BigDecimal subtractionResult
                = calculator.calculate(BigDecimal.valueOf(100.5), BigDecimal.valueOf(26.5), '-');
        Assert.assertEquals("74.0 was expected",
                BigDecimal.valueOf(74.0), subtractionResult);
    }

    @Test
    public void checkMultiplication() {
        BigDecimal multiplicationResult
                = calculator.calculate(BigDecimal.valueOf(5.7), BigDecimal.valueOf(3.1), '*');
        Assert.assertEquals("17.67 was expected",
                BigDecimal.valueOf(17.67), multiplicationResult);
    }

    @Test
    public void checkDivision() {
        BigDecimal divisionResult
                = calculator.calculate(BigDecimal.valueOf(37.74), BigDecimal.valueOf(3.4), '/');
        Assert.assertEquals("11.1 was expected",
                BigDecimal.valueOf(11.1), divisionResult);
    }

    @Test
    public void checkExponentiation() {
        BigDecimal exponentiationResult
                = calculator.calculate(BigDecimal.valueOf(5.1), BigDecimal.valueOf(3.0), '^');
        Assert.assertEquals("132.651 was expected",
                BigDecimal.valueOf(132.651), exponentiationResult);
    }

    @Test
    public void checkNullFirstArgument() {
        try {
            calculator.calculate(null, BigDecimal.valueOf(1.0), '+');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException was expected");
    }

    @Test
    public void checkNullSecondArgument() {
        try {
            calculator.calculate(BigDecimal.valueOf(1.0), null, '+');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException was expected");
    }

    @Test
    public void checkWrongOperation() {
        try {
            calculator.calculate(BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.0), 'w');
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail("IllegalArgumentException was expected");
    }

    @Test
    public void checkDivisionByZero() {
        try {
            calculator.calculate(BigDecimal.valueOf(1.0), BigDecimal.valueOf(0.0), '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException was expected");
    }

    @Test
    public void checkPowerOutOfRange() {
        try {
            calculator.calculate(BigDecimal.valueOf(1.0), BigDecimal.valueOf(-1.0), '^');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException was expected");
    }
}
