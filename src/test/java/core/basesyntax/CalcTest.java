package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {

    private Calc calc = null;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }

    @Before
    public void executedBeforeEach() {
        calc = new Calc();
        System.out.println("@Before: executedBeforeEach");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIllegalArguments() {
        double a = 10.6;
        double b = 0.5;
        double expected = a + b;
        double actual = calc.total(a, b, 'Q');
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void validSum() {
        double actual = calc.total(1, 3, '+');
        Assert.assertEquals(4, actual, 0);
        actual = calc.total(5.1, 0, '+');
        Assert.assertEquals(5.1, actual, 0);
    }

    @Test
    public void validSubstraction() {
        double actual = calc.total(6, 2, '-');
        Assert.assertEquals(4, actual, 0);
        actual = calc.total(3.1, 1, '-');
        Assert.assertEquals(2.1, actual, 0);
    }

    @Test
    public void validMultiplication() {
        double actual = calc.total(6, 0, '*');
        Assert.assertEquals(0, actual, 0);
        actual = calc.total(3.1, 2, '*');
        Assert.assertEquals(6.2, actual, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void validDivByZero() {
        calc.total(6, 0, '/');
    }

    @Test
    public void validDivision() {
        double actual = calc.total(0, 2, '/');
        Assert.assertEquals(0, actual, 0);
        actual = calc.total(3, 1.5, '/');
        Assert.assertEquals(2, actual, 0);
    }

    @Test
    public void validPow() {
        double actual = calc.total(2, 2, '^');
        Assert.assertEquals(4, actual, 0);
        actual = calc.total(4, -1, '^');
        Assert.assertEquals(0.25, actual, 0);
    }
}
