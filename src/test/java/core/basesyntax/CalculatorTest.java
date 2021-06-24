package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    public static final double delta = 0.0001;
    private static Calculator calculator;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void addTwoPositiveValues_OK() {
        actual = calculator.calculate(25.3554, 87.2445, '+');
        expected = 112.5999;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void addTwoNegativeValues_OK() {
        actual = calculator.calculate(-745.9523, -943.9534, '+');
        expected = -1689.9057;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void addPositiveAndNegativeValues_OK() {
        actual = calculator.calculate(-25.3554, 87.2445, '+');
        expected = 61.8891;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(-87.2445, 25.3554, '+');
        expected = -61.8891;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void addZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(25.3554, 0, '+');
        expected = 25.3554;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(0, 25.3554, '+');
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void addDoubleMaxValue_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, 87.2445, '+');
        expected = 1.7976931348623157E308;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(25.3554, Double.MAX_VALUE, '+');
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void addDoubleMinValue_OK() {
        actual = calculator.calculate(Double.MIN_VALUE, 25.3554, '+');
        expected = 25.3554;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(25.3554, Double.MIN_VALUE, '+');
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void subtractTwoPositiveValues_OK() {
        actual = calculator.calculate(25.3554, 87.2445,'-');
        expected = -61.8891;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void subtractTwoNegativeValues_OK() {
        actual = calculator.calculate(-745.9523, -943.9534,'-');
        expected = 198.00109999999995;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void subtractPositiveAndNegativeValues_OK() {
        actual = calculator.calculate(-25.3554, 87.2445,'-');
        expected = -112.5999;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(25.3554, -87.2445,'-');
        expected = 112.5999;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void subtractZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(25.3554, 0,'-');
        expected = 25.3554;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(0, 25.3554,'-');
        expected = -25.3554;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void subtractDoubleMaxValue_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, 87.2445,'-');
        expected = 1.7976931348623157E308;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(25.3554, Double.MAX_VALUE,'-');
        expected = -1.7976931348623157E308;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void subtractDoubleMinValue_OK() {
        actual = calculator.calculate(Double.MIN_VALUE, 25.3554,'-');
        expected = -25.3554;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(25.3554, Double.MIN_VALUE,'-');
        expected = 25.3554;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void divideTwoPositiveValues_OK() {
        actual = calculator.calculate(87.2445,25.3554,'/');
        expected = 3.440864667881398;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void divideTwoNegativeValues_OK() {
        actual = calculator.calculate(-87.2445,-25.3554,'/');
        expected = 3.440864667881398;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void dividePositiveAndNegativeValues_OK() {
        actual = calculator.calculate(-25.3554, 87.2445,'/');
        expected = -0.2906246239017932;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(87.2445, -25.3554,'/');
        expected = -3.440864667881398;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void divideZeroInDifferentPlaces_OK() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(25.3554, 0,'/'));
        actual = calculator.calculate(0, 25.3554,'/');
        expected = 0.0;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void divideDoubleMaxValue_OK() {
        actual = calculator.calculate(Double.MAX_VALUE, 87.2445,'/');
        expected = 2.0605231674917222E306;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(87.2445, Double.MAX_VALUE,'/');
        expected = 4.853136406213289E-307;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void divideDoubleMinValue_OK() {
        actual = calculator.calculate(Double.MIN_VALUE, 87.2445,'/');
        expected = 0.0;
        Assertions.assertEquals(expected, actual, delta);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(25.3554, Double.MIN_VALUE,'/'));
    }

    @Test
    void multiplyTwoPositiveValues_OK() {
        actual = calculator.calculate(25.3554, 87.2445,'*');
        expected = 2212.1191953000002;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void multiplyTwoNegativeValues_OK() {
        actual = calculator.calculate(-745.9523, -943.9534,'*');
        expected = 704144.20982282;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void multiplyPositiveAndNegativeValues_OK() {
        actual = calculator.calculate(-25.3554, 87.2445,'*');
        expected = -2212.1191953000002;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(-87.2445, 25.3554,'*');
        expected = -2212.1191953000002;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void multiplyZeroInDifferentPlaces_OK() {
        actual = calculator.calculate(25.3554, 0,'*');
        expected = 0;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(0, 25.3554,'*');
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void multiplyDoubleMaxValue_OK() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(Double.MAX_VALUE, 1.1,'*'));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(1.1, Double.MAX_VALUE,'*'));
        actual = calculator.calculate(0.7, Double.MAX_VALUE,'*');
        expected = 1.2583851944036209E308;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void multiplyDoubleMinValue_OK() {
        actual = calculator.calculate(Double.MIN_VALUE, 25.3554,'*');
        expected = 1.24E-322;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(25.3554, Double.MIN_VALUE,'*');
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void raiseToPositivePower_OK() {
        actual = calculator.calculate(87.2445, 2.532,'^');
        expected = 82025.47668849025;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(-25.3554, 3.0,'^');
        expected = -16300.893077275463;
        Assertions.assertEquals(expected, this.actual, delta);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(-25.3554, 3.3,'^'));

    }

    @Test
    void raiseToNegativePower_OK() {
        actual = calculator.calculate(87.2445, -2.532,'^');
        expected = 1.2191334209464207E-5;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(-87.2445, -3.0,'^');
        expected = -1.5058642598673879E-6;
        Assertions.assertEquals(expected, actual, delta);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(-87.2445, -3.3,'^'));
    }

    @Test
    void raiseToZeroPower_OK() {
        actual = calculator.calculate(87.2445, 0,'^');
        expected = 1;
        Assertions.assertEquals(expected, actual, delta);
        actual = calculator.calculate(-87.2445, 0,'^');
        expected = 1;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void raiseZeroToPower_OK() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(0, -3.3,'^'));
        actual = calculator.calculate(0, 2.325,'^');
        expected = 0.0;
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void wrongOperation_NotOK() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator
                .calculate(5,5,'j'));
    }
}
