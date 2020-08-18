package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorldTest {
    private HelloWorld helloWorld;
    private static final double DELTA = 0.01D;

    @Test
    public void additionWithNegativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(5, helloWorld.calculate(2.00, 3.00, '+'), DELTA);
        Assert.assertEquals(-5, helloWorld.calculate(-15, 10, '+'), DELTA);
        Assert.assertEquals(-1000, helloWorld.calculate(-999, -1, '+'), DELTA);
    }

    @Test
    public void subtractionWithNegativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(1, helloWorld.calculate(3, 2, '-'), DELTA);
        Assert.assertEquals(-25, helloWorld.calculate(-15, 10, '-'), DELTA);
        Assert.assertEquals(-998, helloWorld.calculate(-999, -1, '-'), DELTA);
    }

    @Test
    public void divisionWithNegativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(1.5, helloWorld.calculate(3, 2, '/'), DELTA);
        Assert.assertEquals(-1.5, helloWorld.calculate(-15, 10, '/'), DELTA);
        Assert.assertEquals(999, helloWorld.calculate(-999, -1, '/'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        helloWorld = new HelloWorld();
        helloWorld.calculate(3, 0, '/');
    }

    @Test
    public void multiplicationWithNegativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(6, helloWorld.calculate(3, 2, '*'), DELTA);
        Assert.assertEquals(-150, helloWorld.calculate(-15, 10, '*'), DELTA);
        Assert.assertEquals(999, helloWorld.calculate(-999, -1, '*'), DELTA);
    }

    @Test
    public void raisingToPowerWithNegativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(81, helloWorld.calculate(9, 2, '^'), DELTA);
        Assert.assertEquals(-3125, helloWorld.calculate(-5, 5, '^'), DELTA);
        Assert.assertEquals(-0.5, helloWorld.calculate(-2, -1, '^'), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentUse(){
        helloWorld = new HelloWorld();
        helloWorld.calculate(3, 0, '$');
    }
}
