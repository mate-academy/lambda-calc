package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        calculator = new Calculator();
    }

    @Test
    public void checkAddition() {
        BigDecimal additionResult1 = calculator.calculate(
                BigDecimal.valueOf(5.2), BigDecimal.valueOf(3.5), '+');
        BigDecimal additionResult2 = calculator.calculate(
                BigDecimal.valueOf(6.99), BigDecimal.valueOf(-0.01), '+');
        BigDecimal additionResult3 = calculator.calculate(
                BigDecimal.valueOf(Integer.MAX_VALUE), BigDecimal.valueOf(Integer.MAX_VALUE), '+');
        Assert.assertEquals("8.7 was expected",
                BigDecimal.valueOf(8.7), additionResult1);
        Assert.assertEquals("6.98 was expected",
                BigDecimal.valueOf(6.98), additionResult2);
        Assert.assertEquals("4294967294 was expected",
                BigDecimal.valueOf(4294967294L), additionResult3);
    }

    @Test
    public void checkSubtraction() {
        BigDecimal subtractionResult1 = calculator.calculate(
                BigDecimal.valueOf(100.5), BigDecimal.valueOf(26.5), '-');
        BigDecimal subtractionResult2 = calculator.calculate(
                BigDecimal.valueOf(-1.67), BigDecimal.valueOf(-5), '-');
        BigDecimal subtractionResult3 = calculator.calculate(
                BigDecimal.valueOf(Integer.MIN_VALUE), BigDecimal.valueOf(1), '-');
        Assert.assertEquals("74.0 was expected",
                BigDecimal.valueOf(74.0), subtractionResult1);
        Assert.assertEquals("3.33 was expected",
                BigDecimal.valueOf(3.33), subtractionResult2);
        Assert.assertEquals("-2147483649 was expected",
                BigDecimal.valueOf(-2147483649L), subtractionResult3);
    }

    @Test
    public void checkMultiplication() {
        BigDecimal multiplicationResult1 = calculator.calculate(
                BigDecimal.valueOf(5.7), BigDecimal.valueOf(3.1), '*');
        BigDecimal multiplicationResult2 = calculator.calculate(
                BigDecimal.valueOf(17.6), BigDecimal.valueOf(0), '*');
        BigDecimal multiplicationResult3 = calculator.calculate(
                BigDecimal.valueOf(-2), BigDecimal.valueOf(-31.2), '*');
        Assert.assertEquals("17.67 was expected",
                BigDecimal.valueOf(17.67), multiplicationResult1);
        Assert.assertEquals("0.0 was expected",
                BigDecimal.valueOf(0.0), multiplicationResult2);
        Assert.assertEquals("62.4 was expected",
                BigDecimal.valueOf(62.4), multiplicationResult3);
    }

    @Test
    public void checkDivision() {
        BigDecimal divisionResult1 = calculator.calculate(
                BigDecimal.valueOf(37.74), BigDecimal.valueOf(3.4), '/');
        BigDecimal divisionResult2 = calculator.calculate(
                BigDecimal.valueOf(1), BigDecimal.valueOf(3), '/');
        BigDecimal divisionResult3 = calculator.calculate(
                BigDecimal.valueOf(28.80), BigDecimal.valueOf(-2.2), '/');
        Assert.assertEquals("11.10 was expected",
                BigDecimal.valueOf(11.10).setScale(2, RoundingMode.HALF_UP), divisionResult1);
        Assert.assertEquals("0.33 was expected",
                BigDecimal.valueOf(0.33), divisionResult2);
        Assert.assertEquals("-13.09 was expected",
                BigDecimal.valueOf(-13.09), divisionResult3);

    }

    @Test
    public void checkExponentiation() {
        BigDecimal exponentiationResult1 = calculator.calculate(
                BigDecimal.valueOf(5.1), BigDecimal.valueOf(3), '^');
        BigDecimal exponentiationResult2 = calculator.calculate(
                BigDecimal.valueOf(2.5), BigDecimal.valueOf(2.1), '^');
        BigDecimal exponentiationResult3 = calculator.calculate(
                BigDecimal.valueOf(100), BigDecimal.valueOf(0), '^');
        Assert.assertEquals("132.651 was expected",
                BigDecimal.valueOf(132.651), exponentiationResult1);
        Assert.assertEquals("6.25 was expected",
                BigDecimal.valueOf(6.25), exponentiationResult2);
        Assert.assertEquals("1 was expected",
                BigDecimal.valueOf(1), exponentiationResult3);
    }

    @Test(expected = NullPointerException.class)
    public void checkNullFirstArgument() {
        calculator.calculate(null, BigDecimal.valueOf(1), '+');
        Assert.fail("NullPointerException was expected");
    }

    @Test(expected = NullPointerException.class)
    public void checkNullSecondArgument() {
        calculator.calculate(BigDecimal.valueOf(1), null, '+');
        Assert.fail("NullPointerException was expected");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWrongOperation() {
        calculator.calculate(BigDecimal.valueOf(1), BigDecimal.valueOf(1), '%');
        calculator.calculate(BigDecimal.valueOf(1), BigDecimal.valueOf(1), '$');
        calculator.calculate(BigDecimal.valueOf(1), BigDecimal.valueOf(1), ':');
        Assert.fail("IllegalArgumentException was expected");
    }

    @Test(expected = ArithmeticException.class)
    public void checkDivisionByZero() {
        calculator.calculate(BigDecimal.valueOf(1), BigDecimal.valueOf(0), '/');
        Assert.fail("ArithmeticException was expected");
    }

    @Test(expected = ArithmeticException.class)
    public void checkPowerOutOfRange() {
        calculator.calculate(BigDecimal.valueOf(1), BigDecimal.valueOf(-1), '^');
        Assert.fail("ArithmeticException was expected");
    }
}
