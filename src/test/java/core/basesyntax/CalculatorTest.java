package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Double a = 2d;
    private Double b = 1d;
    private Double nullNumber = null;
    private Calculator calculator;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Test
    public void substitutionTestCorrect() {
        Double result = calculator.calculate(a, b, '+');
        Assert.assertEquals(java.util.Optional.of(a + b).get(), result);
    }

    @Test
    public void substitutionNegativeNumberTestCorrect() {
        Double result = calculator.calculate(-a, b, '+');
        Assert.assertEquals(java.util.Optional.of(-a + b).get(), result);
    }

    @Test
    public void subtractionTestCorrect() {
        Double result = calculator.calculate(a, b, '-');
        Assert.assertEquals(java.util.Optional.of(a - b).get(), result);
    }

    @Test
    public void subtractionNegativeNumberTestCorrect() {
        Double result = calculator.calculate(-a, b, '-');
        Assert.assertEquals(java.util.Optional.of(-a - b).get(), result);
    }

    @Test
    public void multiplyTestCorrect() {
        Double result = calculator.calculate(a, b, '*');
        Assert.assertEquals(java.util.Optional.of(a * b).get(), result);
    }

    @Test
    public void multiplyTestNegativeNumberCorrect() {
        Double result = calculator.calculate(-a, b, '*');
        Assert.assertEquals(java.util.Optional.of(-a * b).get(), result);
    }

    @Test
    public void divisionTestCorrect() {
        Double result = calculator.calculate(a, b, '/');
        Assert.assertEquals(java.util.Optional.of(a / b).get(), result);
    }

    @Test
    public void divisionTestNegativeNumberCorrect() {
        Double result = calculator.calculate(-a, b, '*');
        Assert.assertEquals(java.util.Optional.of(-a / b).get(), result);
    }

    @Test
    public void powerTestCorrect() {
        Double result = calculator.calculate(a, b, 'p');
        Assert.assertEquals(java.util.Optional.of(Math.pow(a, b)).get(), result);
    }

    @Test
    public void powerTestZero() {
        Double result = calculator.calculate(a, 0d, 'p');
        Assert.assertEquals(java.util.Optional.of(Math.pow(a, 0)).get(), result);
    }

    @Test
    public void powerTestNegativeValueCorrect() {
        Double result = calculator.calculate(-a, b, 'p');
        Assert.assertEquals(java.util.Optional.of(Math.pow(-a, b)).get(), result);
    }

    @Test
    public void powerTestNull() {
        try {
            Double result = calculator.calculate(nullNumber, b, 'p');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void subtractionTestNull() {
        try {
            Double result = calculator.calculate(nullNumber, b, '-');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void substitutionTestNull() {
        try {
            Double result = calculator.calculate(nullNumber, b, '+');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void divisionTestNull() {
        try {
            Double result = calculator.calculate(nullNumber, b, '/');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void multiplyingTestNull() {
        try {
            Double result = calculator.calculate(nullNumber, b, '*');
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }
}
