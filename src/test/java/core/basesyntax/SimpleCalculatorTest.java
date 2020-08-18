package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Float.NaN;

/**
 * Feel free to remove this class and create your own.
 */
public class SimpleCalculatorTest {
    @Test
    public void addOk() throws IOException {
        Assert.assertEquals(2, SimpleCalculator.calculate(1,'+',1),0.0000001);
        Assert.assertEquals(54, SimpleCalculator.calculate(-5,'+',59),0.0000001);
        Assert.assertEquals(0, SimpleCalculator.calculate(15,'+',-15),0.0000001);
        Assert.assertEquals(-40, SimpleCalculator.calculate(-25,'+',-15),0.0000001);
        Assert.assertEquals(-1, SimpleCalculator.calculate(-2147483648 ,'+',2147483647),0.0000001);
        Assert.assertEquals(444, SimpleCalculator.calculate(444,'+',0),0.0000001);
        Assert.assertEquals(45, SimpleCalculator.calculate(0,'+',45),0.0000001);
    }

    @Test
    public void substractOK() throws IOException {
        Assert.assertEquals(0,SimpleCalculator.calculate(1,'-',1),0.0000001);
        Assert.assertEquals(7,SimpleCalculator.calculate(2147483647,'-',2147483640),0.000001);
        Assert.assertEquals(-1,SimpleCalculator.calculate(0,'-',1),0.0000001);
        Assert.assertEquals(1,SimpleCalculator.calculate(1,'-',0),0.0000001);
        Assert.assertEquals(6,SimpleCalculator.calculate(1,'-',-5),0.0000001);
        Assert.assertEquals(-47,SimpleCalculator.calculate(-51,'-',-4),0.0000001);
        Assert.assertEquals(-6,SimpleCalculator.calculate(-5,'-',1),0.0000001);
    }

    @Test
    public void multiplyOk() throws IOException {
        Assert.assertEquals(25,SimpleCalculator.calculate(5,'*',5),0.0000001);
        Assert.assertEquals(-25,SimpleCalculator.calculate(5,'*',-5),0.0000001);
        Assert.assertEquals(-25,SimpleCalculator.calculate(-5,'*',5),0.0000001);
        Assert.assertEquals(25,SimpleCalculator.calculate(-5,'*',-5),0.0000001);
        Assert.assertEquals(0,SimpleCalculator.calculate(5,'*',0),0.0000001);
        Assert.assertEquals(0,SimpleCalculator.calculate(0,'*',0),0.0000001);
        Assert.assertEquals(0,SimpleCalculator.calculate(0,'*',0),0.0000001);
    }

    @Test
    public void divisionOK() throws IOException {
        Assert.assertEquals(1,SimpleCalculator.calculate(5,'/',5),0.0000001);
        Assert.assertEquals(-1,SimpleCalculator.calculate(5,'/',-5),0.0000001);
        Assert.assertEquals(5,SimpleCalculator.calculate(25,'/',5),0.0000001);
        Assert.assertEquals(-1,SimpleCalculator.calculate(-5,'/',5),0.0000001);
    }

    @Test
    public void divisionByZeroTest() {
        try {
            SimpleCalculator.calculate(5,'/',0);
        }
        catch (ArithmeticException e) {
            return;
        }
        catch (IOException e) {
            Assert.fail("ArithmeticException should be thrown");
        }
        Assert.fail("ArithmeticException should be thrown");
    }

    @Test
    public void powOK() throws IOException {
        Assert.assertEquals(25,SimpleCalculator.calculate(5,'^',2),0.0000001);
        Assert.assertEquals(5,SimpleCalculator.calculate(25,'^',0.5),0.0000001);
        Assert.assertEquals(8,SimpleCalculator.calculate(4,'^',1.5),0.0000001);
        Assert.assertEquals(25,SimpleCalculator.calculate(-5,'^',2),0.0000001);
        Assert.assertEquals(-125,SimpleCalculator.calculate(-5,'^',3),0.0000001);
        Assert.assertEquals(NaN,SimpleCalculator.calculate(-5,'^',0.5),0.0000001);
        Assert.assertEquals(2.23606798,SimpleCalculator.calculate(5,'^',0.5),0.0000001);
        Assert.assertEquals(0.25,SimpleCalculator.calculate(0.5,'^',2),0.0000001);

    }
}