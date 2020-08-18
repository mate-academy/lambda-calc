package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final int ZERO = 0;
    private static final int NUM_TWO = 2;
    private static final int RANGE_MIN = -50000000;
    private static final int RANGE_MAX = 50000000;
    private static final String OPERATOR_ADD = "+";
    private static final String OPERATOR_SUB = "-";
    private static final String OPERATOR_MUL = "*";
    private static final String OPERATOR_DIV = "/";
    private static final String OPERATOR_POW = "^";
    private static final String FAKE_OPERATOR = "?";
    private static final String FAKE_OPERATORS = "1234567890.,!?(){}[]@#$%&_№:;`\\|/" +
            "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void twoPlusTwo() {
        Assert.assertEquals(4, calculator.calculate(NUM_TWO, NUM_TWO, OPERATOR_ADD));
    }

    @Test
    public void twoMinusTwo() {
        Assert.assertEquals(ZERO, calculator.calculate(NUM_TWO, NUM_TWO, OPERATOR_SUB));
    }

    @Test
    public void twoMultipliedByTwo() {
        Assert.assertEquals(4, calculator.calculate(NUM_TWO, NUM_TWO, OPERATOR_MUL));
    }

    @Test
    public void twoDivideByTwo() {
        Assert.assertEquals(1, calculator.calculate(NUM_TWO, NUM_TWO, OPERATOR_DIV));
    }

    @Test
    public void twoSquared() {
        Assert.assertEquals(4, calculator.calculate(NUM_TWO, NUM_TWO, OPERATOR_POW));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionByZero() {
        calculator.calculate(NUM_TWO, ZERO, "/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidOperator() {
        calculator.calculate(NUM_TWO, NUM_TWO, FAKE_OPERATOR);
    }

    @Test
    public void addInRangeFromNegativeToPositiveNumbers() {
        for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
            int expected = i + NUM_TWO;
            int actual = calculator.calculate(i, NUM_TWO, OPERATOR_ADD);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void subInRangeFromNegativeToPositiveNumbers() {
        for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
            int expected = i - NUM_TWO;
            int actual = calculator.calculate(i, NUM_TWO, OPERATOR_SUB);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void mulInRangeFromNegativeToPositiveNumbers() {
        for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
            int expected = i * NUM_TWO;
            int actual = calculator.calculate(i, NUM_TWO, OPERATOR_MUL);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void divInRangeFromNegativeToPositiveNumbers() {
        for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
            int expected = i / NUM_TWO;
            int actual = calculator.calculate(i, NUM_TWO, OPERATOR_DIV);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void powInRangeFromNegativeToPositiveNumbers() {
        for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
            int expected = (int) Math.pow(NUM_TWO, i);
            int actual = calculator.calculate(NUM_TWO, i, OPERATOR_POW);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidOperators() {
        int countException = 0;
        for (int i = 0; i < FAKE_OPERATORS.length(); i++) {
            try {
                calculator.calculate(NUM_TWO, NUM_TWO, FAKE_OPERATORS.substring(i, i + 1));
            } catch (IllegalArgumentException e) {
                countException++;
            }
        }
        Assert.assertEquals("IllegalArgumentException was expected", FAKE_OPERATORS.length() - 1, countException);
    }
}
