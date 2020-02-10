package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
    private Double a = 2d;
    private Double b = 1d;
    private Double nullDouble = null;

    @BeforeClass
    public static void beforeClass() {
        Calc.main();
    }

    @Test
    public void addingTestCorrect() {
        Double result = Calc.calculate(a, b, '+');
        Assert.assertEquals(java.util.Optional.of(a + b).get(), result);
    }

    @Test
    public void addingTestWrong() {
        Double result = Calc.calculate(a, b, '+');
        Assert.assertNotEquals(a * b, result);

    }

    @Test
    public void subtractionTestCorrect() {
        Double result = Calc.calculate(a, b, '-');
        Assert.assertEquals(java.util.Optional.of(a - b).get(), result);
    }

    @Test
    public void subtractionTestWrong() {
        Double result = Calc.calculate(a, b, '-');
        Assert.assertNotEquals(a / b, result);
    }

    @Test
    public void multiplyTestCorrect() {
        Double result = Calc.calculate(a, b, '*');
        Assert.assertEquals(java.util.Optional.of(a * b).get(), result);
    }

    @Test
    public void multiplyTestWrong() {
        Double result = Calc.calculate(a, b, '*');
        Assert.assertNotEquals(a - b, result);
    }

    @Test
    public void divisionTestCorrect() {
        Double result = Calc.calculate(a, b, '/');
        Assert.assertEquals(java.util.Optional.of(a / b).get(), result);
    }

    @Test
    public void divisionTestWrong() {
        Double result = Calc.calculate(a, b, '*');
        Assert.assertNotEquals(a + b, result);
    }

    @Test
    public void powerTestCorrect() {
        Double result = Calc.calculate(a, b, 'p');
        Assert.assertEquals(java.util.Optional.of(Math.pow(a, b)).get(), result);
    }

    @Test
    public void powerTestWrong() {
        Double result = Calc.calculate(a, b, '+');
        Assert.assertNotEquals(Math.pow(a, b), result);
    }

    @Test
    public void powerTestNull() {
        try {
            Double result = Calc.calculate(nullDouble, b, 'p');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void subtractionTestNull() {
        try {
            Double result = Calc.calculate(nullDouble, b, '-');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void substitutionTestNull() {
        try {
            Double result = Calc.calculate(nullDouble, b, '+');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void divisionTestNull() {
        try {
            Double result = Calc.calculate(nullDouble, b, '/');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void multiplyingTestNull() {
        try {
            Double result = Calc.calculate(nullDouble, b, '*');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }
}
