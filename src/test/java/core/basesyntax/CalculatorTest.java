package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final String ADD_STRING = "25 + 30";
    private static final String ADD_NEGATIVE_STRING = "-41 + 30";
    private static final String DIV_STRING = "60 / 30";
    private static final String DIV_NEGATIVE_STRING = "-125 / 25";
    private static final String MULT_STRING = "25 * 30";
    private static final String MULT_NEGATIVE_STRING = "25 * -30";
    private static final String MULT_NULL_STRING = "0 * -30";
    private static final String POW_STRING = "2 ^ 7";
    private static final String SUBTR_STRING = "33 - 8";
    private static final String SUBTR_NEGATIVE_STRING = "-5 - 8";
    private static final String POW_STRING_NEGATIVE = "-2 ^ 7";
    private static final String NULL_POW = "-2 ^ 0";
    private static final double DELTA = 1e-9;
    private static Calculator calculator;

    @BeforeClass
    public static void init() {
        calculator = new Calculator();
    }

    @Test
    public void isWeCallTheRightClass() {
        calculator.calculate(ADD_STRING);
        Assert.assertSame(calculator.getLastOperation().getClass(), AddOperation.class);
        calculator.calculate(DIV_STRING);
        Assert.assertSame(calculator.getLastOperation().getClass(), DivOperation.class);
        calculator.calculate(MULT_STRING);
        Assert.assertSame(calculator.getLastOperation().getClass(), MultOperation.class);
        calculator.calculate(SUBTR_STRING);
        Assert.assertSame(calculator.getLastOperation().getClass(), SubtrOperation.class);
        calculator.calculate(POW_STRING);
        Assert.assertSame(calculator.getLastOperation().getClass(), PowOperation.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPassedArgumentWithWrongParameters() {
        String stringWithoutArithmeticChars = "25_.0";
        calculator.calculate(stringWithoutArithmeticChars);
    }

    @Test(expected = IllegalArgumentException.class)
    public void passEmptyStringToCalculateMethod() {
        String emptyString = "";
        calculator.calculate(emptyString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void passNullValueToCalculateMethod() {
        calculator.calculate(null);
    }

    @Test(expected = ArithmeticException.class)
    public void checkDivisionByZero() {
        String divisionByZero = "25 / 0";
        calculator.calculate(divisionByZero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPassedArgumentWithMoreThanTwoNumbers() {
        String stringWithMoreThanTwoNumbers = "25 + 30 + 45";
        calculator.calculate(stringWithMoreThanTwoNumbers);
    }

    @Test
    public void okSubtractOperations() {
        double subtrNegativeNumResult = -13.0;
        Assert.assertEquals(subtrNegativeNumResult, calculator.calculate(SUBTR_NEGATIVE_STRING), DELTA);
        double subtrResult = 25.0;
        Assert.assertEquals(subtrResult, calculator.calculate(SUBTR_STRING), DELTA);
    }

    @Test
    public void okAddOperations() {
        double addResult = 55.0;
        Assert.assertEquals(addResult, calculator.calculate(ADD_STRING), DELTA);
        double addNegativeNumResult = -11.0;
        Assert.assertEquals(addNegativeNumResult, calculator.calculate(ADD_NEGATIVE_STRING), DELTA);
    }

    @Test
    public void okDivideOperations() {
        double divResult = 2.0;
        Assert.assertEquals(divResult, calculator.calculate(DIV_STRING), DELTA);
        double divNegativeNumResult = -5.0;
        Assert.assertEquals(divNegativeNumResult, calculator.calculate(DIV_NEGATIVE_STRING), DELTA);
    }

    @Test
    public void okElevationToTheDegreeOperations() {
        double powResult = 128.0;
        Assert.assertEquals(powResult, calculator.calculate(POW_STRING), DELTA);
        double powNegativeNumResult = -128.0;
        Assert.assertEquals(powNegativeNumResult, calculator.calculate(POW_STRING_NEGATIVE), DELTA);
        double powNullResult = 1.0;
        Assert.assertEquals(powNullResult, calculator.calculate(NULL_POW), DELTA);
    }

    @Test
    public void okMultiplicationOperations() {
        double multResult = 750.0;
        Assert.assertEquals(multResult, calculator.calculate(MULT_STRING), DELTA);
        double multNegativeNumResult = -750.0;
        Assert.assertEquals(multNegativeNumResult, calculator.calculate(MULT_NEGATIVE_STRING), DELTA);
        double multNullResult = 0.0;
        Assert.assertEquals(multNullResult, calculator.calculate(MULT_NULL_STRING), DELTA);
    }
}
