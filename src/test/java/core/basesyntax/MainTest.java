package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    private static final String MESSAGE_NPE = "NPE was expected!";
    private static final String MESSAGE_POW =
            "This calculator can't work with negative pow or with very big range!";

    @Test
    public void correctSum() {
        Assert.assertEquals("3", Main.calculating(Main::lambdaImpl, -2, '+', 5));
    }

    @Test
    public void correctSubtraction() {
        Assert.assertEquals("-1", Main.calculating(Main::lambdaImpl, 5, '-', 6));
    }

    @Test
    public void correctMultiply() {
        Assert.assertEquals("-6", Main.calculating(Main::lambdaImpl, -3, '*', 2));
    }

    @Test
    public void correctDivide() {
        Assert.assertEquals("-3", Main.calculating(Main::lambdaImpl, 9, '/', -3));
    }

    @Test
    public void correctPow() {
        Assert.assertEquals("8", Main.calculating(Main::lambdaImpl, 2, '^', 3));
    }

    @Test
    public void FirstArgumentNull() {
        try {
            Assert.assertNotEquals("3", Main.calculating(Main::lambdaImpl, null, '+', 3));
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail(MESSAGE_NPE);
    }

    @Test
    public void SecondArgumentNull() {
        try {
            Assert.assertNotEquals("72", Main.calculating(Main::lambdaImpl, 7, null, 2));
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail(MESSAGE_NPE);
    }

    @Test
    public void ThirdArgumentNull() {
        try {
            Assert.assertNotEquals("0", Main.calculating(Main::lambdaImpl, 7, '*', null));
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail(MESSAGE_NPE);
    }

    @Test
    public void AllArgumentNull() {
        try {
            Assert.assertNotEquals("0", Main.calculating(Main::lambdaImpl, null, null, null));
        } catch (NullPointerException e) {
            return;
        }
        Assert.fail(MESSAGE_NPE);
    }

    @Test
    public void DivideByZero() {
        Assert.assertEquals("You can't divide by zero!",
                Main.calculating(Main::lambdaImpl, 5, '/', 0));
    }

    @Test
    public void DivideByZeroIsNotZero() {
        Assert.assertNotEquals("0", Main.calculating(Main::lambdaImpl, 5, '/', 0));
    }

    @Test
    public void numberInDegree0() {
        Assert.assertEquals("1", Main.calculating(Main::lambdaImpl, 2, '^', 0));
    }

    @Test
    public void numberInDegree1() {
        Assert.assertEquals("7", Main.calculating(Main::lambdaImpl, 7, '^', 1));
    }

    @Test
    public void numberInDegreeMinus() {
        Assert.assertEquals(MESSAGE_POW, Main.calculating(Main::lambdaImpl, 8, '^', -2));
    }

    @Test
    public void multiplyByZero() {
        Assert.assertEquals("0", Main.calculating(Main::lambdaImpl, 3, '*', 0));
    }

    @Test
    public void multiplyZeroByNumber() {
        Assert.assertEquals("0", Main.calculating(Main::lambdaImpl, 0, '*', -6));
    }

    @Test
    public void MaxSum() {
        Assert.assertEquals("4294967294",
                Main.calculating(Main::lambdaImpl, Integer.MAX_VALUE, '+', Integer.MAX_VALUE));
    }

    @Test
    public void MinSubrtaction() {
        Assert.assertEquals("-4294967296",
                Main.calculating(Main::lambdaImpl, Integer.MIN_VALUE, '+', Integer.MIN_VALUE));
    }

    @Test
    public void MaxMultiply() {
        Assert.assertEquals("4611686014132420609",
                Main.calculating(Main::lambdaImpl, Integer.MAX_VALUE, '*', Integer.MAX_VALUE));
    }

    @Test
    public void MaxPow() {
        Assert.assertEquals(MESSAGE_POW, Main.calculating(Main::lambdaImpl, Integer.MAX_VALUE, '^', Integer.MAX_VALUE));
    }
}
