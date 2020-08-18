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
    public void additionWithNehativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(5, helloWorld.calculate(2.00, 3.00, '+'), DELTA);
        Assert.assertEquals(-5, helloWorld.calculate(-15, 10, '+'), DELTA);
        Assert.assertEquals(-1000, helloWorld.calculate(-999, -1, '+'), DELTA);
    }

    @Test
    public void subtractionWithNehativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(1, helloWorld.calculate(3, 2, '-'), DELTA);
        Assert.assertEquals(-25, helloWorld.calculate(-15, 10, '-'), DELTA);
        Assert.assertEquals(-998, helloWorld.calculate(-999, -1, '-'), DELTA);
    }

    @Test
    public void divisionWithNehativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(1.5, helloWorld.calculate(3, 2, '/'), DELTA);
        Assert.assertEquals(-1.5, helloWorld.calculate(-15, 10, '/'), DELTA);
        Assert.assertEquals(999, helloWorld.calculate(-999, -1, '/'), DELTA);
    }

    @Test
    public void divisionByZero() {
        helloWorld = new HelloWorld();
        try {
            helloWorld.calculate(3, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("ArithmeticException expected");
    }

    @Test
    public void multiplicationWithNehativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(6, helloWorld.calculate(3, 2, '*'), DELTA);
        Assert.assertEquals(-150, helloWorld.calculate(-15, 10, '*'), DELTA);
        Assert.assertEquals(999, helloWorld.calculate(-999, -1, '*'), DELTA);
    }

    @Test
    public void raisingToPowerWithNehativeAndPositive() {
        helloWorld = new HelloWorld();
        Assert.assertEquals(81, helloWorld.calculate(9, 2, '^'), DELTA);
        Assert.assertEquals(-3125, helloWorld.calculate(-5, 5, '^'), DELTA);
        Assert.assertEquals(1, helloWorld.calculate(-2, -1, '^'), DELTA);
    }

    @Test
    public void illegalArgumenUse(){
        helloWorld = new HelloWorld();
        try {
            helloWorld.calculate(3, 0, '$');
        } catch (IllegalArgumentException e) {
            return;
        }
        Assert.fail("IllegalArgumentException expected");
    }
}
