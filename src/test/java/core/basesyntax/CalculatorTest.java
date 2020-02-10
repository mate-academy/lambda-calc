package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;
    
    @Before
    public void setCalculator(){
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        double result = calculator.calculete(20,10,'+');
        Assert.assertEquals(30,result,0.01);
    }

    @Test
    public void subtractionTest() {
        double result = calculator.calculete(225.37,234.38,'-');
        Assert.assertEquals(-9.01,result,0.01);
    }

    @Test
    public void divisionTest() {
        double result = calculator.calculete(20.5,10,'/');
        Assert.assertEquals(2.05,result,0.01);
    }

    @Test
    public void multiplyingTest() {
        double result = calculator.calculete(225.37,234.38,'*');
        Assert.assertEquals(52822.22,result,0.01);
    }

    @Test
    public void powerTest() {
        double resutlt = calculator.calculete(2,4,'p');
        Assert.assertEquals(16,resutlt,0.01);
    }

    @Test
    public void wrongParametersTest() {
        try {
            double result = calculator
                    .calculete(Double.parseDouble("one"),
                            Double.parseDouble("two"), '+');
        }catch (NumberFormatException e){
            return;
        }
        Assert.fail("NumberFormatException was expected");
    }

    @Test
    public void wrongOperationTest() {
        try {
            double result = calculator
                    .calculete(20, 10, 'a');
        }catch (NullPointerException e){
            return;
        }
        Assert.fail("NullPointerException was expected");
    }

    @Test
    public void nullNumbersTest() {
        try {
            Calculator calculator = new Calculator();
            Double a = null;
            Double b = null;
            calculator.calculete(a, b, '+');
        } catch (NullPointerException e){
            return;
        }
        Assert.fail("NullPointerException was expected");
    }
}
