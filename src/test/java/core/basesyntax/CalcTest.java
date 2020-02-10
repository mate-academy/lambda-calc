package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
    private Double a = 2d;
    private Double b = 1d;
    private Double nullDouble = null;
    private static Calc calc;

    @BeforeClass
    public static void beforeClass() {
        Calc.main(new String[0]);
        calc = new Calc();
    }

    @Test
    public void addingTestCorrect() {
        Double result = calc.calculate(a, b, '+');
        Assert.assertEquals(java.util.Optional.of(a + b).get(), result);
    }

    @Test
    public void addingTestWrong() {
        Double result = calc.calculate(a, b, '+');
        Assert.assertNotEquals(a * b, result);

    }

    @Test
    public void subtractionTestCorrect() {
        Double result = calc.calculate(a, b, '-');
        Assert.assertEquals(java.util.Optional.of(a - b).get(), result);
    }

    @Test
    public void subtractionTestWrong() {
        Double result = calc.calculate(a, b, '-');
        Assert.assertNotEquals(a / b, result);
    }

    @Test
    public void multiplyTestCorrect() {
        Double result = calc.calculate(a, b, '*');
        Assert.assertEquals(java.util.Optional.of(a * b).get(), result);
    }

    @Test
    public void multiplyTestWrong() {
        Double result = calc.calculate(a, b, '*');
        Assert.assertNotEquals(a - b, result);
    }

    @Test
    public void divisionTestCorrect() {
        Double result = calc.calculate(a, b, '/');
        Assert.assertEquals(java.util.Optional.of(a / b).get(), result);
    }

    @Test
    public void divisionTestWrong() {
        Double result = calc.calculate(a, b, '*');
        Assert.assertNotEquals(a + b, result);
    }

    @Test
    public void powerTestCorrect() {
        Double result = calc.calculate(a, b, 'p');
        Assert.assertEquals(java.util.Optional.of(Math.pow(a, b)).get(), result);
    }

    @Test
    public void powerTestWrong() {
        Double result = calc.calculate(a, b, '+');
        Assert.assertNotEquals(Math.pow(a, b), result);
    }

    @Test
    public void powerTestNull() {
        try {
            Double result = calc.calculate(nullDouble, b, 'p');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void subtractionTestNull() {
        try {
            Double result = calc.calculate(nullDouble, b, '-');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void substitutionTestNull() {
        try {
            Double result = calc.calculate(nullDouble, b, '+');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void divisionTestNull() {
        try {
            Double result = calc.calculate(nullDouble, b, '/');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }

    @Test
    public void multiplyingTestNull() {
        try {
            Double result = calc.calculate(nullDouble, b, '*');
        } catch(NullPointerException e) {
            return;
        }
        Assert.fail("NullPointerException expected");
    }
}
