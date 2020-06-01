package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void arithmeticException() {
        try {
            calculator.calculate(5, 0, '/');
        } catch (ArithmeticException e) {
            return;
        }
        Assert.fail("Arithmetic Exception vas expected");
    }

    @Test
    public void unexpectedOperation() {
        try {
            for (int i = 0; i < 128; i++) {
                char operation = (char) i;
                if (operation == '+'
                        || operation == '-'
                        || operation == '*'
                        || operation == '/'
                        || operation == '^') {
                    return;
                } else {
                    calculator.calculate(5, 1, operation);
                }
            }
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail("Index Out Of Bounds Exception vas expected");
    }

    @Test
    public void sumTest() {
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE - 2000; i += 1000) {
            int j = i - 1000;
            double expect = Double.sum(i, j);
            double act = calculator.calculate(i, j, '+');
            Assert.assertEquals("Incorrect result; ", expect, act, 1e-15);
        }
    }

    @Test
    public void differenceTest() {
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE - 2000; i += 1000) {
            int j = i - 1000;
            double expect = (double) i - (double) j;
            double act = calculator.calculate(i, j, '-');
            Assert.assertEquals("Incorrect result; ", expect, act, 1e-15);
        }
    }

    @Test
    public void multiplyTest() {
        for (int i = -5000; i < 5000; i += 10) {
            int j = i - 1000;
            double expect = (double) i * (double) j;
            double act = calculator.calculate(i, j, '*');
            Assert.assertEquals("Incorrect result; ", expect, act, 1e-15);
        }
    }

    @Test
    public void divideTest() {
        for (int i = -5000; i < 5000; i += 10) {
            int j = i - 1000;
            if (j != 0) {
                double expect = (double) i / (double) j;
                double act = calculator.calculate(i, j, '/');
                Assert.assertEquals("Incorrect result; ", expect, act, 1e-15);
            }
        }
    }

    @Test
    public void powTest() {
        for (int i = -100; i < 100; i += 10) {
            int j = i - 1000;
            if (i != 0) {
                double expect = Math.pow(i, j);
                double act = calculator.calculate(i, j, '^');
                Assert.assertEquals("Incorrect result; ", expect, act, 1e-15);
            }
        }
    }

    @Test
    public void powNegativeNumberTest() {
        for (int i = -100; i < 0; i += 10) {
            int j = i - 1000;
            if (i != 0) {
                double expect = Math.pow(i, j);
                double act = calculator.calculate(i, j, '^');
                Assert.assertEquals("Incorrect result; ", expect, act, 1e-15);
            }
        }
    }

    @Test
    public void powZeroTest() {
        for (int i = -100; i < 100; i += 10) {
            int j = 0;
            if (i != 0) {
                double expect = Math.pow(i, j);
                double act = calculator.calculate(i, j, '^');
                Assert.assertEquals("Incorrect result; ", expect, act, 1e-15);
            }
        }
    }
}
