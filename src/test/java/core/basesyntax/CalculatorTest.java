package core.basesyntax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static final double DELTA = 0.00001;

    @Test
    public void additionTest() {
        assertEquals("The sum of positives",
                27, Calculator.calculate(13, '+', 14), DELTA);
        assertEquals("The sum with one negative",
                1, Calculator.calculate(-13, '+', 14), DELTA);
        assertEquals("The sum of two negatives",
                -27, Calculator.calculate(-13, '+', -14), DELTA);
        assertEquals("The sum with one zero",
                13, Calculator.calculate(13, '+', 0), DELTA);
        assertEquals("The sum of two zeroes",
                0, Calculator.calculate(0, '+', 0), DELTA);

    }

    @Test
    public void subtractionTest() {
        assertEquals("The difference of positives",
                -1, Calculator.calculate(13, '-', 14), DELTA);
        assertEquals("The difference with one negative",
                -27, Calculator.calculate(-13, '-', 14), DELTA);
        assertEquals("The difference of two negatives",
                1, Calculator.calculate(-13, '-', -14), DELTA);
        assertEquals("The difference with one zero",
                -14, Calculator.calculate(0, '-', 14), DELTA);
        assertEquals("The difference of two zeroes",
                0, Calculator.calculate(0, '-', 0), DELTA);
    }

    @Test
    public void multiplicationTest() {
        assertEquals("The product of positives",
                182, Calculator.calculate(13, '*', 14), DELTA);
        assertEquals("The product with one negative",
                -182, Calculator.calculate(13, '*', -14), DELTA);
        assertEquals("The product of two negatives",
                182, Calculator.calculate(-13, '*', -14), DELTA);
        assertEquals("The product with one zero",
                0, Calculator.calculate(13, '*', 0), DELTA);
        assertEquals("The product of two zeroes",
                0, Calculator.calculate(0, '*', 0), DELTA);
    }

    @Test
    public void divisionTest() {
        assertEquals("The quotient of positives",
                0.928571, Calculator.calculate(13, '/', 14), DELTA);
        assertEquals("The quotient with one negative",
                -0.928571, Calculator.calculate(13, '/', -14), DELTA);
        assertEquals("The quotient of two negatives",
                0.928571, Calculator.calculate(-13, '/', -14), DELTA);
        assertEquals("The quotient of zero",
                0, Calculator.calculate(0, '/', -14), DELTA);
    }

    @Test
    public void involutionTest() {
        assertEquals("The involution with positive values", 28561,
                Calculator.calculate(13, '^', 4), DELTA);
        assertEquals("The involution to negative power", 0.000035013,
                Calculator.calculate(13, '^', -4), DELTA);
        assertEquals("The involution of negative", -2197,
                Calculator.calculate(-13, '^', 3), DELTA);
        assertEquals("The involution of zero", 0,
                Calculator.calculate(0, '^', 14), DELTA);
        assertEquals("The involution to zero power", 1,
                Calculator.calculate(13, '^', 0), DELTA);
        assertEquals("The involution of zero to zero power", 1,
                Calculator.calculate(0, '^', 0), DELTA);
    }

    @Test
    public void additionAdvancedTest() {
        assertEquals("The sum of positives", 28192.1362,
                Calculator.calculate(13315.4375, '+', 14876.6987), DELTA);
        assertEquals("The sum with one negative",1561.2612,
                Calculator.calculate(-13315.4375, '+', 14876.6987), DELTA);
        assertEquals("The sum of two negatives", -28192.1362,
                Calculator.calculate(-13315.4375, '+', -14876.6987), DELTA);
        assertEquals("The sum with one zero", 13315.4375,
                Calculator.calculate(13315.4375, '+', 0.00), DELTA);
        assertEquals("The sum of two zeroes", 0,
                Calculator.calculate(0.0, '+', 0.000), DELTA);
    }

    @Test
    public void subtractionAdvancedTest() {
        assertEquals("The difference of positives", -8948019.331167,
                Calculator.calculate(139796855.7668, '-', 148744875.097967), DELTA);
        assertEquals("The difference with one negative", -288541730.864767,
                Calculator.calculate(-139796855.7668, '-', 148744875.097967), DELTA);
        assertEquals("The difference of two negatives", 8948019.331167,
                Calculator.calculate(-139796855.7668, '-', -148744875.097967), DELTA);
        assertEquals("The difference with one zero", -148744875.097967,
                Calculator.calculate(0.0000, '-', 148744875.097967), DELTA);
        assertEquals("The difference of two zeroes", 0,
                Calculator.calculate(0.000, '-', 0.00), DELTA);
    }

    @Test
    public void multiplicationAdvancedTest() {
        assertEquals("The product of positives", 196739074.590852764,
                Calculator.calculate(13974.98687, '*', 14077.94343), DELTA);
        assertEquals("The product with one negative", -196739074.590852764,
                Calculator.calculate(13974.98687, '*', -14077.94343), DELTA);
        assertEquals("The product of two negatives", 196739074.590852764,
                Calculator.calculate(-13974.98687, '*', -14077.94343), DELTA);
        assertEquals("The product with one zero", 0,
                Calculator.calculate(13974.98687, '*', 0.00), DELTA);
        assertEquals("The product of two zeroes", 0,
                Calculator.calculate(0.00, '*', 0.0), DELTA);
    }

    @Test
    public void divisionAdvancedTest() {
        assertEquals("The quotient of positives", 0.884581555,
                Calculator.calculate(1307998.986447, '/', 1478664.09796), DELTA);
        assertEquals("The quotient with one negative", -0.884581555,
                Calculator.calculate(1307998.986447, '/', -1478664.09796), DELTA);
        assertEquals("The quotient of two negatives", 0.884581555,
                Calculator.calculate(-1307998.986447, '/', -1478664.09796), DELTA);
        assertEquals("The quotient of zero", 0,
                Calculator.calculate(0.0, '/', 8776653.966574), DELTA);
    }

    @Test
    public void involutionAdvancedTest() {
        assertEquals("The involution with positive values", 256017.848341923,
                Calculator.calculate(13.6458, '^', 4.765), DELTA);
        assertEquals("The involution to negative power", 0.000003906,
                Calculator.calculate(13.6458, '^', -4.765), DELTA);
        assertEquals("The involution of zero", 0,
                Calculator.calculate(0.0, '^', 14.087), DELTA);
        assertEquals("The involution to zero power", 1,
                Calculator.calculate(13.876, '^', 0.0), DELTA);
        assertEquals("The involution zero to zero power", 1,
                Calculator.calculate(0.0, '^', 0.00), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongOperator() {
        Calculator.calculate(13, '%', 14);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        Calculator.calculate(13, '/', 0);
    }

}