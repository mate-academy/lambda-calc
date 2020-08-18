package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.01;
    private static Calculator calculator;

    @BeforeClass
    public static void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        Assert.assertEquals(7,calculator.result('+',2,5),DELTA);
        Assert.assertEquals(3,calculator.result('+',-2,5),DELTA);
        Assert.assertEquals(2,calculator.result('+',2,0),DELTA);
        Assert.assertEquals(0,calculator.result('+',0,0),DELTA);
    }

    @Test
    public void subtractTest() {
        Assert.assertEquals(-3,calculator.result('-',2,5),DELTA);
        Assert.assertEquals(-7,calculator.result('-',-2,5),DELTA);
        Assert.assertEquals(3,calculator.result('-',-2,-5),DELTA);
        Assert.assertEquals(-3,calculator.result('-',0,3),DELTA);
    }

    @Test
    public void multiplyTest() {
        Assert.assertEquals(10,calculator.result('*',2,5),DELTA);
        Assert.assertEquals(10,calculator.result('*',-2,-5),DELTA);
        Assert.assertEquals(0,calculator.result('*',2,0),DELTA);
        Assert.assertEquals(-10,calculator.result('*',-2,5),DELTA);
    }

    @Test
    public void toPowerTest() {
        Assert.assertEquals(32,calculator.result('^',2,5),DELTA);
        Assert.assertEquals(1,calculator.result('^',2,0),DELTA);
        Assert.assertEquals(0,calculator.result('^',5,-10),DELTA);
    }

    @Test
    public void differeceTest() {
        Assert.assertEquals(0,calculator.result('/',2,5),DELTA);
        Assert.assertEquals(-2,calculator.result('/',4,-2),DELTA);
        Assert.assertEquals(2,calculator.result('/',-2,-1),DELTA);
        Assert.assertEquals(0,calculator.result('/',0,5),DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.result('/',5,0);
    }

    @Test(expected = NoSuchArgument.class)
    public void invalidArgument() {
        calculator.result(')',8,9);
    }

}
