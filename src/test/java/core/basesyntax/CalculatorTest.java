package core.basesyntax;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static final double DELTA = 0.00001;
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void additionTest() {
        assertEquals("The sum of positives",
                27, calculator.calculate(13, '+', 14), DELTA);
        assertEquals("The sum with one negative",
                1, calculator.calculate(-13, '+', 14), DELTA);
        assertEquals("The sum of two negatives",
                -27, calculator.calculate(-13, '+', -14), DELTA);
        assertEquals("The sum with one zero",
                13, calculator.calculate(13, '+', 0), DELTA);
        assertEquals("The sum of two zeroes",
                0, calculator.calculate(0, '+', 0), DELTA);

    }

    @Test
    public void subtractionTest() {
        assertEquals("The difference of positives",
                -1, calculator.calculate(13, '-', 14), DELTA);
        assertEquals("The difference with one negative",
                -27, calculator.calculate(-13, '-', 14), DELTA);
        assertEquals("The difference of two negatives",
                1, calculator.calculate(-13, '-', -14), DELTA);
        assertEquals("The difference with one zero",
                -14, calculator.calculate(0, '-', 14), DELTA);
        assertEquals("The difference of two zeroes",
                0, calculator.calculate(0, '-', 0), DELTA);
    }

    @Test
    public void multiplicationTest() {
        assertEquals("The product of positives",
                182, calculator.calculate(13, '*', 14), DELTA);
        assertEquals("The product with one negative",
                -182, calculator.calculate(13, '*', -14), DELTA);
        assertEquals("The product of two negatives",
                182, calculator.calculate(-13, '*', -14), DELTA);
        assertEquals("The product with one zero",
                0, calculator.calculate(13, '*', 0), DELTA);
        assertEquals("The product of two zeroes",
                0, calculator.calculate(0, '*', 0), DELTA);
    }

    @Test
    public void divisionTest() {
        assertEquals("The quotient of positives",
                0.928571, calculator.calculate(13, '/', 14), DELTA);
        assertEquals("The quotient with one negative",
                -0.928571, calculator.calculate(13, '/', -14), DELTA);
        assertEquals("The quotient of two negatives",
                0.928571, calculator.calculate(-13, '/', -14), DELTA);
        assertEquals("The quotient of zero",
                0, calculator.calculate(0, '/', -14), DELTA);
    }

    @Test
    public void involutionTest() {
        assertEquals("The involution with positive values", 28561,
                calculator.calculate(13, '^', 4), DELTA);
        assertEquals("The involution to negative power", 0.000035013,
                calculator.calculate(13, '^', -4), DELTA);
        assertEquals("The involution of negative", -2197,
                calculator.calculate(-13, '^', 3), DELTA);
        assertEquals("The involution of zero", 0,
                calculator.calculate(0, '^', 14), DELTA);
        assertEquals("The involution to zero power", 1,
                calculator.calculate(13, '^', 0), DELTA);
        assertEquals("The involution of zero to zero power", 1,
                calculator.calculate(0, '^', 0), DELTA);
    }

    @Test
    public void additionAdvancedTest() {
        assertEquals("The sum of positives", 28192.1362,
                calculator.calculate(13315.4375, '+', 14876.6987), DELTA);
        assertEquals("The sum with one negative",1561.2612,
                calculator.calculate(-13315.4375, '+', 14876.6987), DELTA);
        assertEquals("The sum of two negatives", -28192.1362,
                calculator.calculate(-13315.4375, '+', -14876.6987), DELTA);
        assertEquals("The sum with one zero", 13315.4375,
                calculator.calculate(13315.4375, '+', 0.00), DELTA);
        assertEquals("The sum of two zeroes", 0,
                calculator.calculate(0.0, '+', 0.000), DELTA);
    }

    @Test
    public void subtractionAdvancedTest() {
        assertEquals("The difference of positives", -8948019.331167,
                calculator.calculate(139796855.7668, '-', 148744875.097967), DELTA);
        assertEquals("The difference with one negative", -288541730.864767,
                calculator.calculate(-139796855.7668, '-', 148744875.097967), DELTA);
        assertEquals("The difference of two negatives", 8948019.331167,
                calculator.calculate(-139796855.7668, '-', -148744875.097967), DELTA);
        assertEquals("The difference with one zero", -148744875.097967,
                calculator.calculate(0.0000, '-', 148744875.097967), DELTA);
        assertEquals("The difference of two zeroes", 0,
                calculator.calculate(0.000, '-', 0.00), DELTA);
    }

    @Test
    public void multiplicationAdvancedTest() {
        assertEquals("The product of positives", 196739074.590852764,
                calculator.calculate(13974.98687, '*', 14077.94343), DELTA);
        assertEquals("The product with one negative", -196739074.590852764,
                calculator.calculate(13974.98687, '*', -14077.94343), DELTA);
        assertEquals("The product of two negatives", 196739074.590852764,
                calculator.calculate(-13974.98687, '*', -14077.94343), DELTA);
        assertEquals("The product with one zero", 0,
                calculator.calculate(13974.98687, '*', 0.00), DELTA);
        assertEquals("The product of two zeroes", 0,
                calculator.calculate(0.00, '*', 0.0), DELTA);
    }

    @Test
    public void divisionAdvancedTest() {
        assertEquals("The quotient of positives", 0.884581555,
                calculator.calculate(1307998.986447, '/', 1478664.09796), DELTA);
        assertEquals("The quotient with one negative", -0.884581555,
                calculator.calculate(1307998.986447, '/', -1478664.09796), DELTA);
        assertEquals("The quotient of two negatives", 0.884581555,
                calculator.calculate(-1307998.986447, '/', -1478664.09796), DELTA);
        assertEquals("The quotient of zero", 0,
                calculator.calculate(0.0, '/', 8776653.966574), DELTA);
    }

    @Test
    public void involutionAdvancedTest() {
        assertEquals("The involution with positive values", 256017.848341923,
                calculator.calculate(13.6458, '^', 4.765), DELTA);
        assertEquals("The involution to negative power", 0.000003906,
                calculator.calculate(13.6458, '^', -4.765), DELTA);
        assertEquals("The involution of zero", 0,
                calculator.calculate(0.0, '^', 14.087), DELTA);
        assertEquals("The involution to zero power", 1,
                calculator.calculate(13.876, '^', 0.0), DELTA);
        assertEquals("The involution zero to zero power", 1,
                calculator.calculate(0.0, '^', 0.00), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperator() {
        calculator.calculate(13, '%', 14);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.calculate(13, '/', 0);
    }
}
